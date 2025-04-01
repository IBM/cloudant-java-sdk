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

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;
import com.ibm.cloud.cloudant.features.ChangesRequestMockClient.MockChangesResult;
import com.ibm.cloud.cloudant.features.ChangesRequestMockClient.MockError;
import com.ibm.cloud.cloudant.features.ChangesRequestMockClient.MockInstruction;
import com.ibm.cloud.cloudant.features.ChangesRequestMockClient.PerpetualSupplier;
import com.ibm.cloud.cloudant.features.ChangesRequestMockClient.QueuedSupplier;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ChangesResult;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangesResultSpliteratorTest {

    // A default set of options to run with
    static final PostChangesOptions DEFAULT_OPTIONS = ChangesOptionsHelper.cloneOptionsWithModeAndNewLimit(
                                                        TestOptions.MINIMUM.getOptions(),
                                                        ChangesFollower.Mode.LISTEN,
                                                        ChangesFollower.BATCH_SIZE);

    // A duration to use for testing error suppression
    static final Duration DWELL_TIME = Duration.ofMillis(50L);

    /**
     * Actions for testing sequences
     */
    enum Action {
        SUCCESS,
        SUPPRESS,
        THROW
    }

    /**
     * Make a spliterator with a supplier for a fixed number of batches.
     *
     * @param batches
     * @param mode
     * @param tolerance
     * @return
     */
    WrappedTestSpliterator makeFixedSizeSpliterator(int batches, ChangesFollower.Mode mode, Duration tolerance) {
        return makeSpliterator(QueuedSupplier.makeBatchSupplier(batches), mode, tolerance);
    }

    /**
     * Make a spliterator that will answer perpetually either with or without actual changes.
     * Note that the empty feed has zero pending so although it will return empty batches perpetually in
     * Mode.FINITE cases the spliterator will stop making requests and terminate.
     *
     * @param empty whether the feed should have changes
     * @param mode
     * @param tolerance
     * @return
     */
    WrappedTestSpliterator makePerpetualSpliterator(boolean empty, ChangesFollower.Mode mode, Duration tolerance) {
        return makeSpliterator(new PerpetualSupplier(empty), mode, tolerance);
    }

    /**
     * Make a spliterator with the given mock supplier, operating mode and error tolerance.
     *
     * @param mockSupplier
     * @param mode
     * @param tolerance
     * @return
     */
    WrappedTestSpliterator makeSpliterator(Supplier<MockInstruction> mockSupplier, ChangesFollower.Mode mode, Duration tolerance) {
        return new WrappedTestSpliterator(
                    new ChangesRequestMockClient(mockSupplier),
                    DEFAULT_OPTIONS,
                    mode,
                    tolerance);
    }

    /**
     * A wrapper that exposes the mock client so additional assertions can be made.
     */
    static class WrappedTestSpliterator extends ChangesResultSpliterator {

        private final ChangesRequestMockClient mockClient;

        WrappedTestSpliterator(ChangesRequestMockClient client, PostChangesOptions options, ChangesFollower.Mode mode,
                Duration errorTolerance) {
            super(client, options, mode, errorTolerance);
            this.mockClient = client;
        }

        ChangesRequestMockClient getMockClient() {
            return mockClient;
        }
    }

    @DataProvider(name = "modes")
    Object[][] getModes() {
        return new Object[][]{
            {ChangesFollower.Mode.FINITE},
            {ChangesFollower.Mode.LISTEN}
        };
    }

    @DataProvider(name = "modesWithErrors")
    Object[][] getModesWithErrors() {
        // Each test is a Mode, Error, Client
        EnumSet<ChangesFollower.Mode> modes = EnumSet.allOf(ChangesFollower.Mode.class);
        EnumSet<ChangesRequestMockClient.MockError> errors = EnumSet.allOf(ChangesRequestMockClient.MockError.class);
        Object[][] tests = new Object[modes.size() * errors.size()][]; // each mode and each error
        int index = 0;
        for (ChangesFollower.Mode mode : modes) {
            for (ChangesRequestMockClient.MockError error : errors) {
                tests[index] = new Object[]{mode, error, new ChangesRequestMockClient(() -> new MockInstruction(error))};
                index++;
            }            
        }
        return tests;
    }

    /**
     * Data provider for sequences of mock instructions
     *
     * @return
     */
    @DataProvider(name = "suppressionSequences")
    Object[][] getSuppressionSequences() {
        // Each test is a Sequence, Mode, Error, Client

        List<Action[]> sequences = new ArrayList<>(10);
        sequences.add(new Action[]{Action.SUCCESS, Action.SUPPRESS, Action.THROW});
        sequences.add(new Action[]{Action.SUCCESS, Action.SUPPRESS, Action.SUCCESS});
        sequences.add(new Action[]{Action.SUCCESS, Action.SUPPRESS, Action.SUPPRESS});
        sequences.add(new Action[]{Action.SUCCESS, Action.SUCCESS, Action.THROW});
        sequences.add(new Action[]{Action.SUCCESS, Action.SUCCESS, Action.SUPPRESS});
        sequences.add(new Action[]{Action.SUPPRESS, Action.SUPPRESS, Action.THROW});
        sequences.add(new Action[]{Action.SUPPRESS, Action.SUPPRESS, Action.SUCCESS});
        sequences.add(new Action[]{Action.SUPPRESS, Action.SUCCESS, Action.THROW});
        sequences.add(new Action[]{Action.SUPPRESS, Action.SUCCESS, Action.SUCCESS});
        sequences.add(new Action[]{Action.SUPPRESS, Action.SUCCESS, Action.SUPPRESS});
        EnumSet<ChangesFollower.Mode> modes = EnumSet.allOf(ChangesFollower.Mode.class);
        // Use just a single transient error to test this
        EnumSet<ChangesRequestMockClient.MockError> errors = EnumSet.of(ChangesRequestMockClient.MockError.TRANSIENT_429);
        Object[][] tests = new Object[modes.size() * errors.size() * sequences.size()][]; // each mode and each error
        int index = 0;
        for (ChangesFollower.Mode mode : modes) {
            for (ChangesRequestMockClient.MockError error : errors) {
                for(Action[] sequence : sequences) {
                    List<MockInstruction> instructions = new ArrayList<>(3);
                    for (Action a: sequence) {
                        switch(a) {
                            case SUCCESS:
                                instructions.add(new MockInstruction(new MockChangesResult(1,1)));
                                break;
                            case SUPPRESS:
                            case THROW:
                                instructions.add(new MockInstruction(error));
                                break;
                        }
                    }
                    tests[index] = new Object[]{sequence, mode, error, new ChangesRequestMockClient(new QueuedSupplier(instructions))};
                    index++;
                }
            }
        }
        return tests;
    }

    /**
     * Data provider for testing combinations of changes with try-advance
     *
     * @return
     */
    @DataProvider(name = "tryAdvance")
    Object[][] getCombinations() {
        int expectedBatchSize = ChangesFollower.BATCH_SIZE.intValue();
        String firstBatchLastSeq = expectedBatchSize + "-";
        String secondBatchLastSeq = 2*expectedBatchSize + "-";
        String noMoreChangesLastSeq = "77777-";
        return new Object[][]{
            // name, mode, batches, first assert, second assert
            {"Finite mode, empty feed", ChangesFollower.Mode.FINITE, 0,
                new ChangesResultAssert(0, 0L, noMoreChangesLastSeq),
                null // finite, zero pending, no more results
            },
            {"Listen mode, empty feed", ChangesFollower.Mode.LISTEN, 0,
                new ChangesResultAssert(0, 0L, noMoreChangesLastSeq),
                new ChangesResultAssert(0, 0L, noMoreChangesLastSeq) // listening, but no more changes
            },
            {"Finite mode, 1 batch, zero pending", ChangesFollower.Mode.FINITE, 1,
                new ChangesResultAssert(expectedBatchSize, 0L, firstBatchLastSeq),
                null // finite, zero pending, no more results
            },
            {"Listen mode, 1 batch, zero pending", ChangesFollower.Mode.LISTEN, 1,
                new ChangesResultAssert(expectedBatchSize, 0L, firstBatchLastSeq),
                new ChangesResultAssert(0, 0L, noMoreChangesLastSeq) // listening, but no more changes
            },
            {"Finite mode, 2 batches, zero pending", ChangesFollower.Mode.FINITE, 2,
                new ChangesResultAssert(expectedBatchSize, ChangesFollower.BATCH_SIZE, firstBatchLastSeq),
                new ChangesResultAssert(expectedBatchSize, 0L, secondBatchLastSeq)
            },
            {"Listen mode, 2 batches, zero pending", ChangesFollower.Mode.LISTEN, 2,
                new ChangesResultAssert(expectedBatchSize, ChangesFollower.BATCH_SIZE, firstBatchLastSeq),
                new ChangesResultAssert(expectedBatchSize, 0L, secondBatchLastSeq)
            },
            {"Finite mode, 2 batches, some pending", ChangesFollower.Mode.FINITE, 2,
                new ChangesResultAssert(expectedBatchSize, 2*ChangesFollower.BATCH_SIZE, firstBatchLastSeq),
                new ChangesResultAssert(expectedBatchSize, ChangesFollower.BATCH_SIZE, secondBatchLastSeq)
            },
            {"Listen mode, 2 batches, some pending", ChangesFollower.Mode.LISTEN, 2,
                new ChangesResultAssert(expectedBatchSize, 2*ChangesFollower.BATCH_SIZE, firstBatchLastSeq),
                new ChangesResultAssert(expectedBatchSize, ChangesFollower.BATCH_SIZE, secondBatchLastSeq)
            },
            {"Finite mode, infinite batches, max pending", ChangesFollower.Mode.FINITE, -1,
                new ChangesResultAssert(expectedBatchSize, Long.MAX_VALUE, firstBatchLastSeq),
                new ChangesResultAssert(expectedBatchSize, Long.MAX_VALUE, secondBatchLastSeq)
            },
            {"Listen mode, infinite batches, max pending", ChangesFollower.Mode.LISTEN, -1,
                new ChangesResultAssert(expectedBatchSize, Long.MAX_VALUE, firstBatchLastSeq),
                new ChangesResultAssert(expectedBatchSize, Long.MAX_VALUE, secondBatchLastSeq)
            },
        };
    }

    /**
     * Test the estimated size with a whole number of batches.
     *
     * @param mode
     */
    @Test(dataProvider = "modes")
    void testEstimateSize(ChangesFollower.Mode mode) {
        ChangesResultSpliterator testSpliterator = makeFixedSizeSpliterator(3, mode, Duration.ZERO);
        // Initial estimate is always Long.MAX_VALUE
        Assert.assertEquals(testSpliterator.estimateSize(), Long.MAX_VALUE, "The initial estimated size should be Long.MAX_VALUE.");
        // Advance the spliterator
        testSpliterator.tryAdvance((c) -> {});
        long expectedSize = (mode == ChangesFollower.Mode.LISTEN) ? Long.MAX_VALUE : 2; // 2 batches left for FINITE case
        Assert.assertEquals(testSpliterator.estimateSize(), expectedSize, "The  estimated size should match the expected.");
        // Advance the spliterator
        testSpliterator.tryAdvance((c) -> {});
        expectedSize = (mode == ChangesFollower.Mode.LISTEN) ? Long.MAX_VALUE : 1; // 1 batches left for FINITE case
        Assert.assertEquals(testSpliterator.estimateSize(), expectedSize, "The  estimated size should match the expected.");
    }

    /**
     * Test the estimated size without a whole number of batches.
     */
    @Test
    void testEstimateSizePartialBatch() {
        List<MockInstruction> instructions = new ArrayList<>();
        long partialBatchSize = 1844;
        instructions.add(new MockInstruction(new MockChangesResult(1, ChangesFollower.BATCH_SIZE, ChangesFollower.BATCH_SIZE + partialBatchSize)));
        instructions.add(new MockInstruction(new MockChangesResult(ChangesFollower.BATCH_SIZE + 1, ChangesFollower.BATCH_SIZE, partialBatchSize)));
        instructions.add(new MockInstruction(new MockChangesResult(2*ChangesFollower.BATCH_SIZE + 1, partialBatchSize, 0L)));
        ChangesResultSpliterator testSpliterator = makeSpliterator(new QueuedSupplier(instructions), ChangesFollower.Mode.FINITE, Duration.ZERO);
        // Initial estimate is always Long.MAX_VALUE
        Assert.assertEquals(testSpliterator.estimateSize(), Long.MAX_VALUE, "The initial estimated size should be Long.MAX_VALUE.");
        // Advance the spliterator
        testSpliterator.tryAdvance((c) -> {});
        Assert.assertEquals(testSpliterator.estimateSize(), 2, "The estimated size should be 2.");
        // Advance the spliterator
        testSpliterator.tryAdvance((c) -> {});
        Assert.assertEquals(testSpliterator.estimateSize(), 1, "The estimated size should be 1.");
        testSpliterator.tryAdvance((c) -> {});
        Assert.assertEquals(testSpliterator.estimateSize(), 0, "The estimated size should be 0.");
    }

    @Test(dataProvider = "modes")
    void testNext(ChangesFollower.Mode mode) {
        ChangesResult expectedResult = new MockChangesResult(1, 0);
        ChangesResultSpliterator testSpliterator = makeSpliterator(
            new QueuedSupplier(Collections.singletonList(new MockInstruction(expectedResult))),
            mode,
            Duration.ZERO);
        ChangesResult actualResult = testSpliterator.next();
        Assert.assertEquals(actualResult, expectedResult, "next() should return the expected ChangesResult");
    }

    @Test(dataProvider = "modesWithErrors")
    void testNextWithZeroErrorTolerance(ChangesFollower.Mode mode, ChangesRequestMockClient.MockError error, Cloudant client) {
        ChangesResultSpliterator testSpliterator = new ChangesResultSpliterator(client, DEFAULT_OPTIONS, mode, Duration.ZERO);
        // With zero tolerance we always expect the error to throw when calling next()
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> testSpliterator.next());
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected exception message.");
    }

    @Test(dataProvider = "modesWithErrors")
    void testNextWithMaxErrorTolerance(ChangesFollower.Mode mode, ChangesRequestMockClient.MockError error, Cloudant client) {
        ChangesResultSpliterator testSpliterator = new ChangesResultSpliterator(client, DEFAULT_OPTIONS, mode, ChronoUnit.FOREVER.getDuration());
        // When suppressing errors the behaviour when calling next() changes depending on the type of error passed to the test
        if (MockError.getTerminalErrors().contains(error)) {
            // For terminal errors expect an exception
            RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> testSpliterator.next());
            Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected exception message.");
        } else {
            // For transient errors expect no exception because the error is suppressed
            try {
                testSpliterator.next();
            } catch (Exception e) {
                Assert.fail("The exception should be suppressed.", e);
            }
        }
    }

    @Test(dataProvider = "modesWithErrors")
    void testNextWithFiniteTolerance(ChangesFollower.Mode mode, ChangesRequestMockClient.MockError error, Cloudant client) throws Exception {
        ChangesResultSpliterator testSpliterator = new ChangesResultSpliterator(client, DEFAULT_OPTIONS, mode, DWELL_TIME);
        // First invocation
        // When suppressing errors the behaviour when calling next() changes depending on the type of error passed to the test
        if (MockError.getTerminalErrors().contains(error)) {
            // For terminal errors expect an exception
            RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> testSpliterator.next());
            Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected exception message.");
        } else {
            // For transient errors expect no exception because the error is suppressed
            try {
                testSpliterator.next();
            } catch (Exception e) {
                Assert.fail("The exception should be suppressed.", e);
            }
        }
        // Lapse duration
        Thread.sleep(DWELL_TIME.toMillis());
        // Second invocation should always error regardless of error type because duration has lapsed
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> testSpliterator.next());
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected exception message.");
    }


    @Test(dataProvider = "suppressionSequences")
    void testNextWithSequences(Action[] sequence, ChangesFollower.Mode mode, ChangesRequestMockClient.MockError error, Cloudant client) throws Exception {
        // When we are testing with sequences the retry backoff time comes into play - on a first retry this is a max of 100 ms.
        // Our tolerance time needs to be higher than that, add 10%
        Duration tolerance = Duration.ofMillis(110L);
        ChangesResultSpliterator testSpliterator = new ChangesResultSpliterator(client, DEFAULT_OPTIONS, mode, tolerance);
        // First call, should not error
        try {
            testSpliterator.next();
        } catch (Exception e) {
            Assert.fail("There should be no exception on the first call, expected " + sequence[0], e);
        }
        // Second call, should not error
        try {
            testSpliterator.next();
        } catch (Exception e) {
            Assert.fail("There should be no exception on the second call, expected " + sequence[1], e);
        }
        Action finalAction = sequence[2];
        // For the third call behaviour changes depending on the desired final action
        if (finalAction != Action.SUPPRESS) {
            // If we're not expecting to suppress we need to allow at least the dwell time
            Thread.sleep(tolerance.toMillis());
        }
        try {
            testSpliterator.next();
            // in case of Action.THROW the next line should not be reached:
            if (finalAction == Action.THROW) {
                Assert.fail("An exception should have been thrown on the final call.");
            }
        } catch (Exception e) {
            if (finalAction == Action.SUCCESS || finalAction == Action.SUPPRESS) {
                Assert.fail("There should be no exception on the final call, expected " + sequence[2], e);
            } else {
                Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected exception message.");
            }
        }
    }

    /**
     * Test stopping when working with changes
     *
     * @param mode
     * @throws Exception
     */
    @Test(dataProvider = "modes")
    void testStop(ChangesFollower.Mode mode) throws Exception {
        executeTestStop(makePerpetualSpliterator(false, mode, Duration.ZERO));
    }

    /**
     * Test stopping when suppressing errors
     *
     * @param mode
     * @throws Exception
     */
    @Test(dataProvider = "modes")
    void testStopDuringSuppression(ChangesFollower.Mode mode) throws Exception {
        executeTestStop(makeSpliterator(
            () -> new MockInstruction(MockError.TRANSIENT_429),
            mode,
            ChronoUnit.FOREVER.getDuration()));
    }

    /**
     * This checks the case where an inflight request will be cancelled.
     * Simulate by calling stop before next.
     *
     * @param mode
     * @throws Exception
     */
    @Test(dataProvider = "modes")
    void testStopWithCancelledCall(ChangesFollower.Mode mode) throws Exception {
        Collection<MockInstruction> instructions = Collections.singletonList(
                new MockInstruction(MockError.TRANSIENT_IO)
            );
        ChangesResultSpliterator testSpliterator = makeSpliterator(
            new QueuedSupplier(instructions),
            mode,
            Duration.ZERO);
        testSpliterator.stop();
        try {
            testSpliterator.next();
        } catch(RuntimeException e) {
            Assert.fail("There should be no exception.", e);
        }
    }

    /**
     * Helper to execute a stopping test
     *
     * @param testSpliterator
     * @throws Exception
     */
    void executeTestStop(WrappedTestSpliterator testSpliterator) throws Exception {
        final AtomicInteger tryAdvanceCounter = new AtomicInteger();
        final AtomicInteger acceptCounter = new AtomicInteger();
        // The number of iterations before calling stop
        final int iterations = 5;
        final CountDownLatch latch = new CountDownLatch(1);
        Thread t = new Thread(() -> {
            boolean advance = false;
            do {
                advance = testSpliterator.tryAdvance((c) -> { acceptCounter.incrementAndGet(); });
                if (tryAdvanceCounter.incrementAndGet() == iterations) {
                    latch.countDown();
                }
            } while(advance);
        });
        AtomicReference<Throwable> spliteratorRunnableException = new AtomicReference<>();
        t.setUncaughtExceptionHandler((thread, thrown) -> {
            spliteratorRunnableException.set(thrown);
        });
        t.start();
        // Wait for the iterations to complete before stopping
        latch.await();
        testSpliterator.stop();
        // Now wait for the spliterator runnable thread to stop
        t.join();
        if (spliteratorRunnableException.get() != null) {
            Assert.fail("There should be no exceptions on the runnable thread after calling stop.", spliteratorRunnableException.get());
        }
        int taCount = tryAdvanceCounter.get();
        Assert.assertTrue(taCount >= iterations, "There should have been at least as many try-advance calls as iterations.");
        Assert.assertEquals(taCount, acceptCounter.get() + 1, iterations, "There should be one more try-advance call than accept calls.");
        int cancelledRequests = testSpliterator.getMockClient().cancelledRequests.size();
        Assert.assertTrue(cancelledRequests <= 1, "Cancelled requests should be <= 1.");
    }

    @Test(dataProvider = "tryAdvance")
    void testTryAdvance(String name, ChangesFollower.Mode mode, int batches, ChangesResultAssert firstAssert, ChangesResultAssert secondAssert) {
        ChangesResultSpliterator testSpliterator = null;
        switch(batches) {
            case -1:
                testSpliterator = makePerpetualSpliterator(false, mode, Duration.ZERO);
                break;
            case 0:
                testSpliterator = makePerpetualSpliterator(true, mode, Duration.ZERO);
                break;
            case 1:
            case 2:
                // We need to queue an extra batch for cases where we expect to have changes
                // pending
                if (secondAssert != null && secondAssert.expectedPending > 0) {
                    batches++;
                }
                testSpliterator = makeFixedSizeSpliterator(batches, mode, Duration.ZERO);
                break;
            default:
                Assert.fail("Unimplemented case in test " + name);
        }
        if (secondAssert == null) {
            secondAssert = new NoAcceptAssert();
        }
        Assert.assertTrue(testSpliterator.tryAdvance(firstAssert), "The first try advance should always return true.");
        // Second try advance depends on pending changes after first and if we are in finte mode
        boolean expectResult = mode == ChangesFollower.Mode.LISTEN || firstAssert.expectedPending > 0L;
        Assert.assertEquals(testSpliterator.tryAdvance(secondAssert), expectResult, "The second try advance should return the correct value.");
    }


    @Test(dataProvider = "modesWithErrors")
    void testTryAdvanceWithErrors(ChangesFollower.Mode mode, ChangesRequestMockClient.MockError error, Cloudant client) {
        ChangesResultSpliterator testSpliterator = new ChangesResultSpliterator(client, DEFAULT_OPTIONS, mode, Duration.ZERO);
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> testSpliterator.next());
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected exception message.");
        Assert.assertFalse(testSpliterator.tryAdvance(new NoAcceptAssert()), "Try advance should return false after a terminal error.");
    }

    @Test(dataProvider = "modesWithErrors")
    void testTryAdvanceWithMaxErrorTolerance(ChangesFollower.Mode mode, ChangesRequestMockClient.MockError error, Cloudant client) {
        ChangesResultSpliterator testSpliterator = new ChangesResultSpliterator(client, DEFAULT_OPTIONS, mode, ChronoUnit.FOREVER.getDuration());
        if (MockError.getTerminalErrors().contains(error)) {
            RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> testSpliterator.next());
            Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected exception message.");
            Assert.assertFalse(testSpliterator.tryAdvance(new NoAcceptAssert()), "Try advance should return false after a terminal error.");
        } else {
            try {
                // Assert try advance returns true on a suppressed error and that it has an empty ChangesResult
                Assert.assertTrue(testSpliterator.tryAdvance(new ChangesResultAssert(0, null, null)));
            } catch (Exception e) {
                Assert.fail("The exception should be suppressed.", e);
            }
        }
    }

    @Test(dataProvider = "modesWithErrors")
    void testTryAdvanceWithFiniteTolerance(ChangesFollower.Mode mode, ChangesRequestMockClient.MockError error, Cloudant client) throws Exception {
        ChangesResultSpliterator testSpliterator = new ChangesResultSpliterator(client, DEFAULT_OPTIONS, mode, DWELL_TIME);
        // First invocation will suppress transient errors
        if (MockError.getTerminalErrors().contains(error)) {
            RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> testSpliterator.next());
            Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected exception message.");
            Assert.assertFalse(testSpliterator.tryAdvance(new NoAcceptAssert()), "Try advance should return false after a terminal error.");
        } else {
            try {
                // Assert try advance returns true on a suppressed error and that it has an empty ChangesResult
                Assert.assertTrue(testSpliterator.tryAdvance(new ChangesResultAssert(0, null, null)));
            } catch (Exception e) {
                Assert.fail("The exception should be suppressed.", e);
            }
        }
        // Allow the errorTolerance to lapse
        Thread.sleep(DWELL_TIME.toMillis());
        // Second invocation should error
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> testSpliterator.next());
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected exception message.");
        Assert.assertFalse(testSpliterator.tryAdvance(new NoAcceptAssert()), "Try advance should return false after a terminal error.");
    }

    @Test(dataProvider = "modes")
    void testTrySplit(ChangesFollower.Mode mode) {
        ChangesResultSpliterator testSpliterator = makePerpetualSpliterator(false, mode, Duration.ZERO);
        Assert.assertNull(testSpliterator.trySplit(), "Trying to split should return null, the changes feed cannot be split.");
    }

    /**
     * Assert that reties are delayed by a backoff and not in a tight loop.
     * @param mode
     */
    @Test(dataProvider = "modes")
    void testRetryDelay(ChangesFollower.Mode mode) {
        // Make a spliterator with 429 responses
        ChangesResultSpliterator testSpliterator = makeSpliterator(() -> new MockInstruction(MockError.TRANSIENT_429), mode, ChronoUnit.FOREVER.getDuration());
        // Iterate for at least 300 ms (i.e. minimum 2 delays i.e. 100, 200 but could be more because of jitter)
        int requestCounter = 0;
        long startTime = System.currentTimeMillis();
        do {
            testSpliterator.next();
            requestCounter++;
        } while (System.currentTimeMillis() < (startTime + 300));
        // If the delays aren't working 300 ms of iterating against mock errors will give at least 1000 requests.
        // Even if we are randomly unlucky and get all short delays i.e. 1 ms we should see fewer than 300 requests.
        Assert.assertTrue(requestCounter < 300, "There should be fewer than 300 iterations, but there were " + requestCounter);
    }

    /**
     * A class for helping assert on results from the spliterator.
     */
    private static class ChangesResultAssert implements Consumer<ChangesResult> {

        private final int expectedSize;
        private final Long expectedPending;
        private final String expectedLastSeqPrefix;

        ChangesResultAssert(int expectedSize, Long expectedPending, String expectedLastSeqPrefix) {
            this.expectedSize = expectedSize;
            this.expectedPending = expectedPending;
            this.expectedLastSeqPrefix = expectedLastSeqPrefix;
        }

        @Override
        public void accept(ChangesResult t) {
            Assert.assertNotNull(t.getResults(), "The results should not be null.");
            Assert.assertEquals(t.getResults().size(), expectedSize, "The changes result should be of the expected size.");
            Assert.assertEquals(t.getPending(), expectedPending, "There should be the expected number of pending changes.");
            if (expectedLastSeqPrefix == null) {
                Assert.assertNull(t.getLastSeq(), "The lastSeq should be null.");
            } else {
                String actualLastSeqPrefix = t.getLastSeq().substring(0, t.getLastSeq().indexOf('-')+1);
                Assert.assertEquals(actualLastSeqPrefix, expectedLastSeqPrefix, "The lastSeq should have the expected prefix.");
            }
        }
        
    }

    /**
     * A class used to assert that a consumer is not called.
     */
    private static final class NoAcceptAssert extends ChangesResultAssert {

        NoAcceptAssert() {
            super(0, 0L, null);
        }

        @Override
        public void accept(ChangesResult t) {
            Assert.fail("The consumer should not be called.");
        }

    }
}
