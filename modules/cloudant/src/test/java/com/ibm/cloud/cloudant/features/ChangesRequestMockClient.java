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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
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
import org.testng.Assert;
import io.reactivex.Single;

/**
 * Mock client that simulates changes responses
 */
public class ChangesRequestMockClient extends MockCloudant<ChangesResult> {

    static final Random r = new Random();

    private boolean batchSizeCalculation = false;
    private Long databaseInfoDocCount = 500_000L;
    private Long databaseInfoDocSize = 523L;

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
    ChangesRequestMockClient(Supplier<MockInstruction<ChangesResult>> instructionSupplier) {
        super(instructionSupplier);
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

    /**
     * A MockInstruction supplier that adds a new result instruction for
     * each one taken, thereby providing results perpetually.
     */
    static class PerpetualSupplier extends QueuedSupplier<ChangesResult> {

        final boolean emptyFeed;
        final AtomicInteger counter = new AtomicInteger(0);

        PerpetualSupplier() {
            this(false);
        }

        PerpetualSupplier(boolean emptyFeed) {
            this(Collections.emptyList(), emptyFeed);
        }

        PerpetualSupplier(Collection<MockInstruction<ChangesResult>> initialMocks, boolean emptyFeed) {
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
            return q.add(new MockInstruction<ChangesResult>(mockResult));
        }

        @Override
        public MockInstruction<ChangesResult> get() {
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

    static Supplier<MockInstruction<ChangesResult>> makeBatchSupplier(int numberOfBatches) {
        long pending = numberOfBatches * ChangesFollower.BATCH_SIZE;
        List<MockInstruction<ChangesResult>> mocks = new ArrayList<>();
        for (int i=1; i <= numberOfBatches; i++) {
            pending -= ChangesFollower.BATCH_SIZE;
            mocks.add(new MockInstruction<ChangesResult>(new MockChangesResult(((i-1) * ChangesFollower.BATCH_SIZE) + 1, pending)));
        }
        // Add a final empty result (the only result for 0 batch case)
        mocks.add(new MockInstruction<ChangesResult>(MockChangesResult.EMPTY_RESULT));
        return new QueuedSupplier<ChangesResult>(mocks);
    }
}
