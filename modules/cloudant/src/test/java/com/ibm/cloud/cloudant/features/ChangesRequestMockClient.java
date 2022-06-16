/**
 * © Copyright IBM Corporation 2022, 2023. All Rights Reserved.
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

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import com.google.gson.stream.MalformedJsonException;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Change;
import com.ibm.cloud.cloudant.v1.model.ChangesResult;
import com.ibm.cloud.cloudant.v1.model.ChangesResultItem;
import com.ibm.cloud.cloudant.v1.model.ContentInformationSizes;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformation;
import com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.http.ServiceCallback;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.BadRequestException;
import com.ibm.cloud.sdk.core.service.exception.ForbiddenException;
import com.ibm.cloud.sdk.core.service.exception.InternalServerErrorException;
import com.ibm.cloud.sdk.core.service.exception.InvalidServiceResponseException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.exception.ServiceUnavailableException;
import com.ibm.cloud.sdk.core.service.exception.TooManyRequestsException;
import com.ibm.cloud.sdk.core.service.exception.UnauthorizedException;
import org.testng.Assert;
import io.reactivex.Single;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Mock client that simulates changes responses
 */
public class ChangesRequestMockClient extends Cloudant {

    static final Random r = new Random();
    private static final okhttp3.Request MOCK_REQUEST = new okhttp3.Request.Builder()
                                                            .url("https://test.example/foo/_changes")
                                                            .method("POST",
                                                                RequestBody.create("{}", 
                                                                MediaType.get("application/json")))
                                                            .build();
    private static final okhttp3.Response SUCCESS_RESPONSE = new okhttp3.Response.Builder()
                                                            .code(200)
                                                            .message("OK")
                                                            .protocol(Protocol.HTTP_2)
                                                            .request(MOCK_REQUEST)
                                                            .build();
    
    private final Supplier<MockInstruction> mocks;
    final List<ServiceCall<ChangesResult>> cancelledRequests = Collections.synchronizedList(new ArrayList<>());
    private boolean batchSizeCalculation = false;
    private Long databaseInfoDocCount = 500_000L;
    private Long databaseInfoDocSize = 523L;
    
    /**
     * Mock errors
     */
    enum MockError {
        TERMINAL_400,
        TERMINAL_401,
        TERMINAL_403,
        TERMINAL_404,
        TRANSIENT_429,
        TRANSIENT_500,
        TRANSIENT_502,
        TRANSIENT_503,
        TRANSIENT_504,
        TRANSIENT_BAD_JSON,
        TRANSIENT_IO;

        static EnumSet<MockError> getTerminalErrors() {
            return EnumSet.of(
                TERMINAL_400,
                TERMINAL_401,
                TERMINAL_403,
                TERMINAL_404);
        }

        static EnumSet<MockError> getTransientErrors() {
            return EnumSet.of(
                TRANSIENT_429,
                TRANSIENT_500,
                TRANSIENT_502,
                TRANSIENT_503,
                TRANSIENT_504,
                TRANSIENT_BAD_JSON,
                TRANSIENT_IO);
        }

        private okhttp3.Response makeResponse(okhttp3.Response.Builder rb, int code, String error) {
            rb.code(code)
                .protocol(Protocol.HTTP_2)
                .request(MOCK_REQUEST);
            switch (code) {
                case 200:
                    rb.message("OK");
                    // make some invalid JSON
                    rb.body(ResponseBody.create("{", MediaType.get("application/json")));
                    break;
                case 502:
                    rb.message("BAD_GATEWAY");
                    rb.body(ResponseBody.create("", MediaType.get("text/plain")));
                    break;
                case 504:
                    rb.message("GATEWAY_TIMEOUT");
                    rb.body(ResponseBody.create("", MediaType.get("text/plain")));
                    break;
                default:
                    rb.message(error);
                    rb.body(ResponseBody.create(
                            String.format("{\"error\":\"%s\", \"reason\":\"test error\"}", error),
                            MediaType.get("application/json")));
                    break;
            }
            return rb.build();
        }

        Class<? extends RuntimeException> getExceptionClass() {
            return getException().getClass();
        }

        RuntimeException getException() {
            okhttp3.Response.Builder rb = new okhttp3.Response.Builder();
            switch(this) {
                case TERMINAL_400:
                    return new BadRequestException(makeResponse(rb, 400, "bad_request"));
                case TERMINAL_401:
                    return new UnauthorizedException(makeResponse(rb, 401, "unauthorized"));
                case TERMINAL_403:
                    return new ForbiddenException(makeResponse(rb, 403, "forbidden"));
                case TERMINAL_404:
                    return new NotFoundException(makeResponse(rb, 404, "not_found"));
                case TRANSIENT_429:
                    return new TooManyRequestsException(makeResponse(rb, 429, "too_many_requests"));
                case TRANSIENT_500:
                    return new InternalServerErrorException(makeResponse(rb, 500, "internal_server_error"));
                case TRANSIENT_503:
                    return new ServiceUnavailableException(makeResponse(rb, 503, "service_unavailable"));
                case TRANSIENT_502:
                    return new ServiceResponseException(502, makeResponse(rb, 502, null));
                case TRANSIENT_504:
                    return new ServiceResponseException(504, makeResponse(rb, 504, null));
                case TRANSIENT_BAD_JSON:
                    return new InvalidServiceResponseException(makeResponse(rb, 200, null), "Bad request body", new MalformedJsonException("test bad json"));
                case TRANSIENT_IO:
                    return new RuntimeException("Bad IO", new IOException("test bad IO"));
                default:
                    return new RuntimeException("Unimplemented test exception");
            }
        }

        void throwException() throws RuntimeException {
            throw getException();
        }
    }

    static String generateAlphanumString(final int size) {
        return r.ints(48 /* i.e. 0 */, 122 + 1 /* i.e. z +1 code point */)
                    .filter(i -> (i < 58 || i > 64) && (i < 91 || i > 96)) // remove all non alphanumeric
                                .limit(size)
                                .collect(StringBuffer::new, StringBuffer::appendCodePoint, StringBuffer::append)
                                .toString();
    }

    static String generateSeqLikeString(final long gen, final int size) {
        final StringBuilder seqBuilder = new StringBuilder(String.valueOf(gen)).append("-");
        seqBuilder.append(generateAlphanumString(size));
        return seqBuilder.toString();
    }

    /**
     * Make a mock client that supplies results or exceptions as indicated by the supplier.
     * @param instructionSupplier
     */
    ChangesRequestMockClient(Supplier<MockInstruction> instructionSupplier) {
        super(null, new NoAuthAuthenticator());
        this.mocks = instructionSupplier;
    }

    void setDatabaseInfoDocCount(Long count) {
        this.databaseInfoDocCount = count;
    }

    void setDatabaseInfoDocSize(Long size) {
        this.databaseInfoDocSize = size;
    }

    /**
     * Supply mock ServiceCalls and results for calls to postChanges
     */
    @Override
    public ServiceCall<ChangesResult> postChanges(PostChangesOptions postChangesOptions) {
        // In cases where getDatabaseInformation has been called first throw a special test exception
        if (this.batchSizeCalculation) {
            throw new LimitExposingException(postChangesOptions.limit());
        }
        try {
            MockServiceCall call = new MockServiceCall(mocks.get());
            if (cancelledRequests.size() > 0) {
                // If a request has been cancelled, add all the follow on requests to the
                // cancelled list so we can track stop behaving badly
                cancelledRequests.add(call);
            }                
            return call;
        } catch(NoSuchElementException e) {
            Assert.fail("Test error: no mock instruction available for request.");
            return null;
        }
    }

    /**
     * Mock out the DatabaseInformation for batch size calculations
     */
    @Override
    public ServiceCall<DatabaseInformation> getDatabaseInformation(
            GetDatabaseInformationOptions getDatabaseInformationOptions) {
                // Set the batch sizing flag so we can throw a special test exception
                this.batchSizeCalculation = true;
        return new ServiceCall<DatabaseInformation>() {

            @Override
            public ServiceCall<DatabaseInformation> addHeader(String name, String value) {
                throw new UnsupportedOperationException("NOT MOCKED");
            }

            @Override
            public Response<DatabaseInformation> execute() throws RuntimeException {
                return new Response<DatabaseInformation>(new DatabaseInformation(){
                    @Override
                    public Long getDocCount() {
                        return ChangesRequestMockClient.this.databaseInfoDocCount;
                    };
                    @Override
                    public ContentInformationSizes getSizes() {
                        return new ContentInformationSizes() {
                            @Override
                            public Long getExternal() {
                                return ChangesRequestMockClient.this.databaseInfoDocCount
                                    * ChangesRequestMockClient.this.databaseInfoDocSize;
                            }
                        };
                    }
                }, SUCCESS_RESPONSE);
            }

            @Override
            public void enqueue(ServiceCallback<DatabaseInformation> callback) {
                throw new UnsupportedOperationException("NOT MOCKED");
            }

            @Override
            public Single<Response<DatabaseInformation>> reactiveRequest() {
                throw new UnsupportedOperationException("NOT MOCKED");
            }

            @Override
            public void cancel() {
                throw new UnsupportedOperationException("NOT MOCKED");
            }
            
        };
    }

    /**
     * An instruction to return a result or an error
     */
    static class MockInstruction {

        private final MockError e;
        private final ChangesResult result;

        MockInstruction(MockError e) {
            this.e = e;
            this.result = null;
        }

        MockInstruction(ChangesResult result) {
            this.result = result;
            this.e = null;
        }

        ChangesResult getResultOrThrow() {
            if (result != null) {
                return result;
            } else {
                e.throwException();
                return null;
            }
        }
    }

    static final class MockChangesResult extends ChangesResult {

        static ChangesResult EMPTY_RESULT = new MockChangesResult(Collections.emptyList(), 0L);

        MockChangesResult(long start, long size, long pending) {
            this(LongStream.range(start, start + size)
                    .mapToObj(MockChangesResultItem::new)
                    .collect(Collectors.toList()),
                 pending);
        }

        MockChangesResult(long start, long pending) {
            this(start, ChangesFollower.BATCH_SIZE, pending);
        }

        MockChangesResult(List<ChangesResultItem> items, long pending) {
            this.pending = pending;
            this.results = items;
            this.lastSeq = this.results.isEmpty() 
                ? generateSeqLikeString(77777, 512) // generate a fake seq for the empty result
                : this.results.get(this.results.size()-1).getSeq();
        }
    }

    static final class MockChangesResultItem extends ChangesResultItem {
        MockChangesResultItem(long counter) {
            this.changes = Collections.singletonList(new MockChange());
            this.deleted = false;
            this.doc = null;
            this.id = generateAlphanumString(10);
            this.seq = generateSeqLikeString(counter, 512);
        }
    }

    static final class MockChange extends Change {
        MockChange() {
            this.rev = generateSeqLikeString(1, 32);
        }
    }

    final class MockServiceCall implements ServiceCall<ChangesResult> {

        private final MockInstruction mockI;
        private volatile boolean isCancelled = false;

        MockServiceCall(MockInstruction mockI) {
            this.mockI = mockI;
        }

        @Override
        public ServiceCall<ChangesResult> addHeader(String name, String value) {
            throw new UnsupportedOperationException("NOT MOCKED");
        }

        @Override
        public Response<ChangesResult> execute() throws RuntimeException {
            if (isCancelled) {
                throw new RuntimeException("Execution of MockServiceCall after cancellation.");                
            }
            return new Response<>(mockI.getResultOrThrow(), SUCCESS_RESPONSE);
        }

        @Override
        public void enqueue(ServiceCallback<ChangesResult> callback) {
            throw new UnsupportedOperationException("NOT MOCKED");
        }

        @Override
        public Single<Response<ChangesResult>> reactiveRequest() {
            throw new UnsupportedOperationException("NOT MOCKED");
        }

        @Override
        public void cancel() {
            isCancelled = true;
            cancelledRequests.add(this);
        }
    }

    /**
     * A MockInstruction supplier that uses a queue.
     */
    static class QueuedSupplier implements Supplier<MockInstruction> {

        protected final Queue<MockInstruction> q;

        QueuedSupplier(Collection<MockInstruction> instructions) {
            q = new ArrayDeque<>(instructions);
        }

        @Override
        public MockInstruction get() {
            try {
                return q.remove();
            } catch(NoSuchElementException e) {
                Assert.fail("Test error: no mock instruction available for request.");
                // The assert throw should take care of the exit, but the compiler
                // doesn't seem to notice.
                return null;
            }
        }

        static Supplier<MockInstruction> makeBatchSupplier(int numberOfBatches) {
            long pending = numberOfBatches * ChangesFollower.BATCH_SIZE;
            List<MockInstruction> mocks = new ArrayList<>();
            for (int i=1; i <= numberOfBatches; i++) {
                pending -= ChangesFollower.BATCH_SIZE;
                mocks.add(new MockInstruction(new MockChangesResult(((i-1) * ChangesFollower.BATCH_SIZE) + 1, pending)));
            }
            // Add a final empty result (the only result for 0 batch case)
            mocks.add(new MockInstruction(MockChangesResult.EMPTY_RESULT));
            return new QueuedSupplier(mocks);
        }
    }

    /**
     * A MockInstruction supplier that adds a new result instruction for
     * each one taken, thereby providing results perpetually.
     */
    static class PerpetualSupplier extends QueuedSupplier {

        final boolean emptyFeed;
        final AtomicInteger counter = new AtomicInteger(0);

        PerpetualSupplier() {
            this(false);
        }

        PerpetualSupplier(boolean emptyFeed) {
            this(Collections.emptyList(), emptyFeed);
        }

        PerpetualSupplier(Collection<MockInstruction> initialMocks, boolean emptyFeed) {
            super(initialMocks);
            this.emptyFeed = emptyFeed;
            // Add an initial batch if there wasn't one
            if (initialMocks.size() < 1) {
                add();
            }
        }

        boolean add() {
            ChangesResult mockResult = emptyFeed
                ? MockChangesResult.EMPTY_RESULT
                : new MockChangesResult((counter.getAndIncrement() * ChangesFollower.BATCH_SIZE) + 1, Long.MAX_VALUE);
            return q.add(new MockInstruction(mockResult));
        }

        @Override
        public MockInstruction get() {
            add();
            return super.get();
        }
    }

    static class LimitExposingException extends RuntimeException {
        private final long limit;
        LimitExposingException(long limit) {
            this.limit = limit;
        }

        long getRequestLimit() {
            return this.limit;
        }
    }
}
