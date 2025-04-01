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
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ChangesResultItem;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformation;
import com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

/**
 * A helper for using the changes feed.
 * <p>
 * There are two modes of operation:
 * <ul>
 *   <li>{@link #startOneOff()} to fetch the changes from the supplied since sequence
 *       until there are no further pending changes.</li>
 *   <li>{@link #start()} to fetch the changes from the supplied since sequence
 *       and then continuing to listen indefinitely for further new changes.</li>
 * </ul>
 * <p>
 * The starting sequence ID can be changed for either mode by using
 * {@link PostChangesOptions.Builder#since(String)}. By default when using:
 * <ul>
 *   <li>{@link #startOneOff()} the feed will start from the beginning.</li>
 *   <li>{@link #start()} the feed will start from "now".</li>
 * </ul>
 * <p>
 * In either mode the {@link Stream} of changes can be terminated early by calling
 * {@link #stop()}.
 * <p>
 * By default {@link ChangesFollower} will suppress transient errors indefinitely and
 * endeavour to run to completion or listen forever. For applications where that
 * behaviour is not desirable an alternate constructor is available where a
 * {@link Duration} may be specified to limit the time since the last successful
 * response that transient errors will be suppressed.
 * <p>
 * It should be noted that errors considered terminal, for example, the database not
 * existing or invalid credentials are never suppressed and will throw an exception
 * immediately.
 * <p>
 * The {@link PostChangesOptions} model of changes feed options is used to configure
 * the behaviour of the {@link ChangesFollower}. However, a subset of the options are
 * invalid as they are configured internally by the implementation and will cause
 * an {@link IllegalArgumentException} to be thrown if supplied. These invalid
 * options are:
 * <ul>
 *   <li>{@link PostChangesOptions.Builder#descending(Boolean)}</li>
 *   <li>{@link PostChangesOptions.Builder#feed(String)}</li>
 *   <li>{@link PostChangesOptions.Builder#heartbeat(long)}</li>
 *   <li>{@link PostChangesOptions.Builder#lastEventId(String)} (use {@link PostChangesOptions.Builder#since(String)} instead)</li>
 *   <li>{@link PostChangesOptions.Builder#timeout(long)}</li>
 * </uL>
 * <p>
 * Only the value of <code>_selector</code> is permitted for the {@link PostChangesOptions.Builder#filter(String)} option.
 * Selector based filters perform better than JS based filters and using one of the alternative JS based
 * filter types will cause {@link ChangesFollower} to throw an {@link IllegalArgumentException}.
 * <p>
 * It should also be noted that the {@link PostChangesOptions.Builder#limit(long)}
 * parameter will truncate the stream at the given number of changes in either
 * operating mode.
 * <p>
 * The {@link ChangesFollower} requires the {@link Cloudant} client to have
 * HTTP call and read timeouts of at least 1 minute. The default client
 * configuration has sufficiently long timeouts.
 */
public class ChangesFollower {

    static final Long BATCH_SIZE = 10_000L;

    private static final Logger LOGGER = Logger.getLogger(ChangesFollower.class.getName());

    // Initialization fields
    private final Cloudant client;
    private final PostChangesOptions options;
    private final Duration errorTolerance;
    private final Long limit;
    private AtomicReference<ChangesResultSpliterator> changesResultSpliterator = new AtomicReference<ChangesResultSpliterator>();

    enum Mode {
        FINITE,
        LISTEN;
    }

    /**
     * Create a new {@link ChangesFollower} using the supplied client and options and
     * configured to continually suppress transient errors and retry indefinitely.
     *
     * @param client - Cloudant client instance to use to make requests
     * @param options - Changes feed options
     *
     * @throws IllegalArgumentException if there are invalid options
     */
    public ChangesFollower(Cloudant client, PostChangesOptions options) throws IllegalArgumentException {
        this(client, options, ChronoUnit.FOREVER.getDuration());
    }

    /**
     * Create a new {@link ChangesFollower} using the supplied client and options that will
     * suppress transient errors and retry for as long as the given duration.
     *
     * @param client - Cloudant client instance to use to make requests
     * @param options - Changes feed options
     * @param errorTolerance - the duration to suppress errors, measured from the previous successful request.
     * Use {@link Duration#ZERO} to disable error suppression and terminate this {@link ChangesFollower} on any
     * failed request.
     *
     * @throws IllegalArgumentException if there are invalid options
     */
    public ChangesFollower(Cloudant client, PostChangesOptions options, Duration errorTolerance) throws IllegalArgumentException {
        // Validate supplied options
        ChangesOptionsHelper.validateOptions(options);
        this.limit = options.limit();
        // Setup with the required defaults and merges of user options
        this.options = ChangesOptionsHelper.cloneOptions(options);
        this.client = client;
        if (errorTolerance.isNegative()) {
            throw new IllegalArgumentException("Error tolerance duration must not be negative.");
        }
        this.errorTolerance = errorTolerance;
        // Check the timeouts are suitable
        long callTimeout = this.client.getClient().callTimeoutMillis();
        long readTimeout = this.client.getClient().readTimeoutMillis();
        if ((callTimeout > 0 && callTimeout < ChangesOptionsHelper.MIN_CLIENT_TIMEOUT)
            || (readTimeout > 0 && readTimeout < ChangesOptionsHelper.MIN_CLIENT_TIMEOUT)) {
                throw new IllegalArgumentException(
                    String.format("To use %s the client read and call timeouts must be at least %d ms. The client read timeout is %d ms and the call timeout is %d ms.",
                    ChangesFollower.class.getSimpleName(),
                    ChangesOptionsHelper.MIN_CLIENT_TIMEOUT,
                    readTimeout,
                    callTimeout));
        }
    }

    /**
     * Return all available changes and keep listening for new changes until reaching an end condition.
     * <p>
     * The end conditions are:
     * <ul>
     *   <li>a terminal error (e.g. unauthorized client).</li>
     *   <li>transient errors occur for longer than the error suppression duration.</li>
     *   <li>the number of changes received reaches the limit specified in the
     *       {@link PostChangesOptions} used to instantiate this {@link ChangesFollower}.</li>
     *   <li>{@link ChangesFollower#stop()} is called.</li>
     * </ul>
     * <p>
     * The same change may be received more than once.
     *
     * @return {@link Stream} of at least one {@link ChangesResultItem} per change
     * @throws IllegalStateException if {@link ChangesFollower#start()}
     *  or {@link ChangesFollower#startOneOff()} was already called.
     * @throws ServiceResponseException if a terminal error or unsupressed transient error
     *   is recevied from the service when fetching changes
     */
    public Stream<ChangesResultItem> start() throws IllegalStateException, ServiceResponseException {
        return run(Mode.LISTEN);
    }

    /**
     * Return all available changes until there are no further changes pending or
     * reaching an end condition.
     * <p>
     * The end conditions are:
     * <ul>
     *   <li>a terminal error (e.g. unauthorized client).</li>
     *   <li>transient errors occur for longer than the error suppression duration.</li>
     *   <li>the number of changes received reaches the limit specified in the
     *       {@link PostChangesOptions} used to instantiate this {@link ChangesFollower}.</li>
     *   <li>{@link ChangesFollower#stop()} is called.</li>
     * </ul>
     * <p>
     * The same change may be received more than once.
     *
     * @return {@link Stream} of at least one {@link ChangesResultItem} per change
     * @throws IllegalStateException if {@link ChangesFollower#start()}
     *  or {@link ChangesFollower#startOneOff()} was already called.
     * @throws ServiceResponseException if a terminal error or unsupressed transient error
     *   is recevied from the service when fetching changes
     */
    public Stream<ChangesResultItem> startOneOff() throws IllegalStateException, ServiceResponseException {
        return run(Mode.FINITE);
    }

    /**
     * Stop this {@link ChangesFollower}.
     * <p>
     * Note that {@link Stream} terminal operations block so this stop method needs to
     * be called from a different thread than the terminal operation to have any effect.
     *
     * @throws IllegalStateException if {@link ChangesFollower#start()}
     *  or {@link ChangesFollower#startOneOff()} was not called first.
     */
    public synchronized void stop() throws IllegalStateException {
        ChangesResultSpliterator spliterator = this.changesResultSpliterator.get();
        if (spliterator != null) {
            spliterator.stop();
        } else {
            throw new IllegalStateException("Cannot stop a feed that is not running.");
        }
    }

    /**
     *
     * @param mode the mode in which to run the ChangesFollower
     * @return
     */
    private synchronized Stream<ChangesResultItem> run(Mode mode) throws IllegalStateException, ServiceResponseException {
        ChangesResultSpliterator spliterator = this.changesResultSpliterator.get();
        if (spliterator == null) {
            final AtomicLong batchSize = new AtomicLong(BATCH_SIZE); // default
            if (Optional.ofNullable(this.options.includeDocs()).orElse(false)) {
                DatabaseInformation info = this.client.getDatabaseInformation(
                        new GetDatabaseInformationOptions.Builder(this.options.db()).build())
                    .execute()
                    .getResult();
                final Long docs = Optional.ofNullable(info.getDocCount()).orElse(0L);
                Optional.ofNullable(info.getSizes()).ifPresent(sizes -> {
                    Optional.ofNullable(sizes.getExternal()).ifPresent(externalSize -> {
                        if (externalSize > 0L && docs > 0L) {
                            // Calculate an average doc size + typical change content size and try to
                            // keep each batch to be about 5 MB
                            long calculatedBatchSize = (5 * 1024 * 1024) / ((externalSize.longValue() / docs) + 500);
                            if (calculatedBatchSize >= 1L) {
                                batchSize.set(calculatedBatchSize);
                            } else {
                                batchSize.set(1L);
                            }
                        }
                    });
                });
            }

            // Configure the per request limit as the smaller of batch size or total limit
            if (this.limit != null && this.limit < batchSize.get()) {
                batchSize.set(this.limit);
            }
            // Construct the spliterator using the batch size as the per request limit
            this.changesResultSpliterator.set(new ChangesResultSpliterator(
                this.client,
                ChangesOptionsHelper.cloneOptionsWithModeAndNewLimit(this.options, mode, batchSize.get()),
                mode,
                this.errorTolerance
            ));
        } else {
            throw new IllegalStateException("Cannot start a feed that has already started.");
        }
        Stream<ChangesResultItem> changesStream = StreamSupport.stream(this.changesResultSpliterator.get(), false).flatMap(result -> result.getResults().stream());
        // If the user requested a finite number of changes, cap the stream
        if (this.limit != null) {
            LOGGER.config(String.format("Applying changes limit %s", this.limit));
            changesStream = changesStream.limit(this.limit);
        }
        return changesStream;
    }

}
