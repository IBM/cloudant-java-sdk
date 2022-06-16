/**
 * © Copyright IBM Corporation 2021, 2023. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.cloudant.features;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Random;
import java.util.Spliterator;
import java.util.Spliterators.AbstractSpliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ibm.cloud.cloudant.features.ChangesFollower.Mode;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ChangesResult;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

/**
 * An implementation of {@link Spliterator} that makes a sequence of requests
 * to the Cloudant changes endpoint to provide iteration of {@link ChangesResult}.
 *
 * It throws {@link RuntimeException} for irrecoverable errors making requests
 * and suppresses recoverable errors according to the configured tolerance.
 *
 * Unless stopped or an error is thrown it will continue to make requests
 * until there are zero pending changes in "finite" mode or indefinitely
 * in "listen" mode.
 */
class ChangesResultSpliterator extends AbstractSpliterator<ChangesResult> {

    private static final Logger LOGGER = Logger.getLogger(ChangesResultSpliterator.class.getName());
    private static final String LOGGER_CLASS_NAME = ChangesResultSpliterator.class.getCanonicalName();
    private static final ChangesResult EMPTY_CHANGES_RESULT = new ChangesResult() {
        public java.util.List<com.ibm.cloud.cloudant.v1.model.ChangesResultItem> getResults() {
            return Collections.emptyList();
        };
    };

    // Retry backoff constants
    // Starting value in ms for retry delays
    private static final double BASE_DELAY = 100d;
    // Once we reach this number of retries we'll be capping the backoff
    private static final long EXP_RETRY_GATE = Math.round(Math.floor(Math.log(ChangesOptionsHelper.LONGPOLL_TIMEOUT / BASE_DELAY) / Math.log(2)));
    // Jitter generator
    private static final Random JITTER = new Random();

    private final Cloudant client;
    private final PostChangesOptions options;
    private final Mode mode;
    private final Duration errorTolerance;
    private final TransientErrorSuppression transientSuppression;
    private final Object requestLock = new Object();
    private volatile String since;
    // Default to "infinite"
    private volatile Long pending = Long.MAX_VALUE;
    private volatile boolean hasNext = true;
    private volatile boolean stopping = false;
    private volatile Instant successTimestamp;
    private AtomicReference<ServiceCall<ChangesResult>> inflightRequest = new AtomicReference<ServiceCall<ChangesResult>>();
    private AtomicInteger retry = new AtomicInteger();

    private enum TransientErrorSuppression {
        ALWAYS,
        NEVER,
        TIMER
    }

    ChangesResultSpliterator(Cloudant client, PostChangesOptions options, Mode mode, Duration errorTolerance) {
        super(Long.MAX_VALUE, NONNULL | ORDERED | CONCURRENT);
        this.client = client;
        this.options = options;
        this.mode = mode;
        this.errorTolerance = errorTolerance;
        if (this.errorTolerance.isZero()) {
            this.transientSuppression = TransientErrorSuppression.NEVER;
        } else if (errorTolerance.equals(ChronoUnit.FOREVER.getDuration())) {
            this.transientSuppression = TransientErrorSuppression.ALWAYS;
        } else {
            this.transientSuppression = TransientErrorSuppression.TIMER;
        }
        if (this.options.since() == null) {
            this.since = (this.mode == Mode.LISTEN) ? "now" : "0";
        }
        this.successTimestamp = Instant.now();
    }

    @Override
    public long estimateSize() {
        if (this.mode == Mode.LISTEN || this.pending == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        } else {
            return (this.pending / this.options.limit()) + (this.pending % this.options.limit() > 0L ? 1L : 0L);
        }
    }

    @Override
    public synchronized boolean tryAdvance(Consumer<? super ChangesResult> action) {
        if (this.hasNext) {
            action.accept(next());
            return true;
        }
        return false;
    }

    /**
     * The changes feed can't be split because the Cloudant changes feed cannot be read in parallel
     * and each request is required to obtain the since value from the previous response.
     */
    @Override
    public Spliterator<ChangesResult> trySplit() {
        return null;
    }

    ChangesResult next() {
        LOGGER.entering(LOGGER_CLASS_NAME, "next");
        try {
            this.inflightRequest.set(this.client.postChanges(ChangesOptionsHelper.cloneOptionsWithNewSince(this.options, this.since)));
            Response<ChangesResult> response;
            try {
                response = this.inflightRequest.get().execute();
            } finally {
                // Once we have a response or exception the request is no longer inflight
                // Lock around this to avoid stop calls from receiving a null pointer if
                // the request completes during the stop
                synchronized (this.requestLock) {
                    this.inflightRequest.set(null);
                }
            }
            ChangesResult result = response.getResult();
            // Successful response, reset counter
            this.retry.set(0);
            // Update the success timestamp if we're using an errorTolerance duration
            if (this.transientSuppression == TransientErrorSuppression.TIMER) {
                this.successTimestamp = Instant.now();
            }
            this.since = result.getLastSeq();
            this.pending = result.getPending();
            if (this.mode == Mode.FINITE && this.pending == 0L) {
                this.hasNext = false;
            }
            LOGGER.exiting(LOGGER_CLASS_NAME, "next", result);
            return result;
        } catch (RuntimeException re) {
            LOGGER.log(Level.FINE, "Exception getting changes.", re);
            if (this.stopping) {
                // Stopping; suppress the exception because cancellation in okhttp
                // can cause an IOException which the core wraps.
                // It would be cleaner to check the request for isCancelled, but the
                // ServiceCall interface doesn't expose that from the underlying client.
                LOGGER.fine("Suppressing exception while stopping.");
                return EMPTY_CHANGES_RESULT;
            }
            switch (this.transientSuppression) {
                case ALWAYS:
                    break;
                case TIMER:
                    if (Instant.now().isBefore(this.successTimestamp.plus(this.errorTolerance))) {
                        break;
                    }
                    LOGGER.fine("Error tolerance deadline exceeded.");
                    // The permissable time without success has lapsed
                    // Fallthrough to throw the error
                case NEVER:
                    this.hasNext = false;
                    LOGGER.exiting(LOGGER_CLASS_NAME, "next", re);
                    throw re;
            }
            if (re instanceof ServiceResponseException) {
                ServiceResponseException sre = (ServiceResponseException) re;
                switch (sre.getStatusCode()) {
                    case 400:
                    case 401:
                    case 403:
                    case 404:
                        LOGGER.fine("Terminal error.");
                        // Terminal error, stop running
                        this.hasNext = false;
                        LOGGER.exiting(LOGGER_CLASS_NAME, "next", sre);
                        throw sre;
                    default:
                        // Note this includes InvalidServiceResponseException
                        // which handles cases like disconnections and incomplete
                        // bodies where we may have received a successful response
                        // code, but couldn't e.g. parse the body
                        LOGGER.fine("Suppressing transient error.");
                        // Calculate and delay for an apporpriate amount between retries
                        long expDelay;
                        int currentRetry = retry.getAndIncrement();
                        if (currentRetry > EXP_RETRY_GATE) {
                            // If we've exceeded the cap, use the timeout value
                            expDelay = ChangesOptionsHelper.LONGPOLL_TIMEOUT;
                        } else {
                            expDelay = Math.round(Math.pow(2, currentRetry) * BASE_DELAY);
                        }
                        // Randomize delay between the bounds adding 1 ms to ensure we
                        // have at least some delay and because the upper bound is exclusive.
                        long delay = JITTER.longs(1, 0, expDelay).findAny().getAsLong() + 1L;
                        try {
                            LOGGER.finest(() -> "Backing off for " + delay + " ms.");
                            Thread.sleep(delay);
                            LOGGER.finest("Resuming after error suppression back-off.");
                        } catch (InterruptedException interruptedException) {
                            // We're only trying to back-off; suppress the exception and reinterrupt
                            Thread.currentThread().interrupt();
                        }
                        break;
                }
            }
        }
        LOGGER.exiting(LOGGER_CLASS_NAME, "next", EMPTY_CHANGES_RESULT);
        return EMPTY_CHANGES_RESULT;
    }

    /**
     * Stop the request/response stream.
     */
    void stop() {
        this.hasNext = false;
        this.stopping = true;
        // Lock around the cancellation to avoid inflightRequest
        // getting changed to null if a request completes while
        // trying to stop.
        synchronized (this.requestLock) {
            ServiceCall<ChangesResult> request = this.inflightRequest.get();
            if (request != null) {
                request.cancel();
            }
        }
    }
}
