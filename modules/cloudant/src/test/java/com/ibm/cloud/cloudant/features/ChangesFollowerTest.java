/**
 * © Copyright IBM Corporation 2022, 2025. All Rights Reserved.
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Stream;
import com.ibm.cloud.cloudant.features.ChangesRequestMockClient.LimitExposingException;
import com.ibm.cloud.cloudant.features.ChangesRequestMockClient.PerpetualSupplier;
import com.ibm.cloud.cloudant.features.MockCloudant.MockError;
import com.ibm.cloud.cloudant.features.MockCloudant.MockInstruction;
import com.ibm.cloud.cloudant.features.MockCloudant.QueuedSupplier;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ChangesResult;
import com.ibm.cloud.cloudant.v1.model.ChangesResultItem;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import okhttp3.OkHttpClient;

public class ChangesFollowerTest {

    Object[][] errorsAsTestObjectArray(Collection<MockError> errors) {
        Object[][] tests = new Object[errors.size()][];
        int index = 0;
        for (MockError e : errors) {
            tests[index] = new Object[]{e};
            index++;
        }
        return tests;
    }

    /**
     * Make a collection of mock instructions that alternate between
     * successful batches and errors.
     *
     * @param batches
     * @return
     */
    Collection<MockInstruction<ChangesResult>> getAlternatingBatchesAndErrors(int batches) {
        Collection<MockInstruction<ChangesResult>> instructions = new ArrayList<>(batches*2);
        Object[] errors = MockError.getTransientErrors().toArray();
        Supplier<MockInstruction<ChangesResult>> qs = ChangesRequestMockClient.makeBatchSupplier(batches);
        for (int i = 0; i < batches; i++) {
            // Add a successful batch
            instructions.add(qs.get());
            // Add a transient error
            instructions.add(new MockInstruction<ChangesResult>((MockError) errors[i % errors.length]));
        }
        return instructions;
    }

    Supplier<MockInstruction<ChangesResult>> getAlternatingBatchErrorSupplier(int batches) {
        return new QueuedSupplier<ChangesResult>(getAlternatingBatchesAndErrors(batches));
    }

    Cloudant getClientWithTimeouts(Duration callTimeout, Duration readTimeout) {
        Cloudant service = new ChangesRequestMockClient(new PerpetualSupplier(true));
        OkHttpClient.Builder builder = service.getClient().newBuilder();
        if (callTimeout != null) {
            builder.callTimeout(callTimeout);
        }
        if (readTimeout != null) {
            builder.readTimeout(readTimeout);
        }
        service.setClient(builder.build());
        return service;
    }

    /**
     * Initially an alternating batch supplier, but when that is exhausted continues
     * to answer with empty results.
     * 
     * @param batches
     * @return
     */
    Supplier<MockInstruction<ChangesResult>> getAlternatingBatchErrorThenPerpetualSupplier(int batches) {
        return new PerpetualSupplier(getAlternatingBatchesAndErrors(batches), true);
    }

    @DataProvider(name = "terminalErrors")
    Object[][] getTerminalErrors() {
        return errorsAsTestObjectArray(MockError.getTerminalErrors());
    }

    @DataProvider(name = "transientErrors")
    Object[][] getTransientErrors() {
        return errorsAsTestObjectArray(MockError.getTransientErrors());
    }

    @DataProvider(name = "invalidTimeoutClients")
    Object[][] getInvalidTimeoutClients() {
        return new Object[][]{
            { getClientWithTimeouts(null, Duration.ofSeconds(15L)) },
            { getClientWithTimeouts(Duration.ofSeconds(30L), null) },
            { getClientWithTimeouts(Duration.ofSeconds(30L), Duration.ofSeconds(15L)) },
            { getClientWithTimeouts(Duration.ofMillis(ChangesOptionsHelper.LONGPOLL_TIMEOUT), null) },
            { getClientWithTimeouts(null, Duration.ofMillis(ChangesOptionsHelper.LONGPOLL_TIMEOUT)) },
            { getClientWithTimeouts(Duration.ofMillis(ChangesOptionsHelper.LONGPOLL_TIMEOUT), Duration.ofMillis(ChangesOptionsHelper.LONGPOLL_TIMEOUT)) }
        };
    }

    @DataProvider(name = "validTimeoutClients")
    Object[][] getValidTimeoutClients() {
        return new Object[][]{
            { getClientWithTimeouts(Duration.ofMillis(ChangesOptionsHelper.MIN_CLIENT_TIMEOUT), null) },
            { getClientWithTimeouts(null, Duration.ofMillis(ChangesOptionsHelper.MIN_CLIENT_TIMEOUT)) },
            { getClientWithTimeouts(Duration.ofMillis(ChangesOptionsHelper.MIN_CLIENT_TIMEOUT), Duration.ofMillis(ChangesOptionsHelper.MIN_CLIENT_TIMEOUT)) },
            { getClientWithTimeouts(Duration.ofMinutes(2L), null) },
            { getClientWithTimeouts(null, Duration.ofMinutes(5L)) },
            { getClientWithTimeouts(Duration.ofMinutes(2L), Duration.ofMinutes(5L)) }
        };
    }

    @DataProvider(name = "states")
    Object[][] getStates() {
        return new Object[][]{
            {ChangesFollower.Mode.FINITE, ChangesFollower.Mode.FINITE},
            {ChangesFollower.Mode.FINITE, ChangesFollower.Mode.LISTEN},
            {ChangesFollower.Mode.LISTEN, ChangesFollower.Mode.FINITE},
            {ChangesFollower.Mode.LISTEN, ChangesFollower.Mode.LISTEN}
        };
    }

    @DataProvider(name = "modesAndLimits")
    Object[][] getModesAndLimits() {
        return new Object[][]{
            {ChangesFollower.Mode.FINITE, 100L},
            {ChangesFollower.Mode.FINITE, ChangesFollower.BATCH_SIZE},
            {ChangesFollower.Mode.FINITE, 10000L},
            {ChangesFollower.Mode.LISTEN, 100L},
            {ChangesFollower.Mode.LISTEN, ChangesFollower.BATCH_SIZE},
            {ChangesFollower.Mode.LISTEN, 10000L},
        };
    }

    @Test
    void testInitialization() {
        Cloudant mockClient = new ChangesRequestMockClient(new PerpetualSupplier(true));
        try {
            new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        } catch (Exception e) {
            Assert.fail("There should be no exception.", e);
        }
    }

    @Test
    void testInitializationInvalidOptions() {
        Cloudant mockClient = new ChangesRequestMockClient(new PerpetualSupplier(true));
        IllegalArgumentException iae = Assert.expectThrows(IllegalArgumentException.class, () -> {
            new ChangesFollower(mockClient, TestOptions.MULTI_INVALID.getOptions());
        });
        Assert.assertTrue(iae.getMessage().contains("'descending', 'feed', 'heartbeat', 'lastEventId', 'timeout' are invalid"),
            "The error message should contain the invalid options.");
    }

    @Test
    void testInitializationNegativeTolerance() {
        Cloudant mockClient = new ChangesRequestMockClient(new PerpetualSupplier(true));
        IllegalArgumentException iae = Assert.expectThrows(IllegalArgumentException.class, () -> {
            new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions(), Duration.ofSeconds(-1L));
        });
        Assert.assertEquals(iae.getMessage(),
            "Error tolerance duration must not be negative.",
            "The error message should be correct.");
    }

    @Test(dataProvider = "invalidTimeoutClients")
    void testInitializationInvalidClientTimeouts(final Cloudant mockClient) {
        IllegalArgumentException iae = Assert.expectThrows(IllegalArgumentException.class, () -> {
            new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        });
        Assert.assertTrue(iae.getMessage().contains("timeouts must be at least"), "The exception should be for timeouts.");
    }

    @Test(dataProvider = "validTimeoutClients")
    void testInitializationMinTimeout(final Cloudant mockClient) {
        try {
            new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        } catch (Exception e) {
            Assert.fail("There should be no exception.", e);
        }
    }

    /**
     * Utility to run a follower on a separate thread.
     * Asserts whether the follower self terminates or stops it after the
     * specified duration.
     *
     * Will return a count of changes or throw an exception for asserting by
     * the caller.
     *
     * @param testFollower test subject
     * @param mode mode to launch either finite or listening
     * @param expectToSelfTerminate whether the subject is expected to self terminate
     * @param testTimeout the duration to wait for self termination before stopping
     * @return
     * @throws Throwable
     */
    long testFollowerOnThread(ChangesFollower testFollower, ChangesFollower.Mode mode, boolean expectToSelfTerminate, Duration testTimeout) throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicReference<Throwable> e = new AtomicReference<>();
        final AtomicLong count = new AtomicLong();
        Thread streamThread = new Thread(() -> {
            Stream<ChangesResultItem> stream = (mode == ChangesFollower.Mode.FINITE) ? testFollower.startOneOff() : testFollower.start();
            count.set(stream.count());
            // release the latch if we finished the stream
            latch.countDown();
        });
        streamThread.setUncaughtExceptionHandler((thread, thrown) -> {
            e.set(thrown);
            // release the latch if we got an exception
            latch.countDown();
        });
        streamThread.start();
        // Await completion by stream termination, error or timeout.
        if (latch.await(testTimeout.toMillis(), TimeUnit.MILLISECONDS)) {
            // Here the stream completed; so assert that was what we expected
            if (!expectToSelfTerminate) {
                // We're unexpectedly here, assert a failure with the reason
                if (e.get() != null) {
                    Assert.fail("Terminated unexpectedly with exception.", e.get());
                } else {
                    Assert.fail(String.format("Terminated unexpectedly with %s changes.", count.get()));
                }
            }
        } else {
            // Here we've reached the wait time, so manually stop the stream
            testFollower.stop();
            latch.await();
            Assert.assertFalse(expectToSelfTerminate, "The thread should have stopped before the wait time.");
        }
        // Wait for the stream thread to stop
        streamThread.join();
        // Handle exceptions
        try {
            if (e.get() != null) throw e.get();
        } catch (RuntimeException re) {
            throw re;
        } catch(Throwable t) {
            Assert.fail("Unexpected exception.", t);
        }
        return count.get();
    }

    /**
     * Checks that a FINITE mode completes successfully for a fixed number of batches.
     */
    @Test
    void testStartOneOff() {
        int batches = 6;
        Cloudant mockClient = new ChangesRequestMockClient(ChangesRequestMockClient.makeBatchSupplier(batches));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        Assert.assertEquals(testFollower.startOneOff().count(), batches*ChangesFollower.BATCH_SIZE, "There should be the expected number of changes.");
    }

    /**
     * Checks that a FINITE mode errors for all terminal errors.
     */
    @Test(dataProvider = "terminalErrors")
    void testStartOneOffTerminalErrors(MockError error) {
        Cloudant mockClient = new ChangesRequestMockClient(() -> new MockInstruction<ChangesResult>(error));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> {
            testFollower.startOneOff().count();
        });
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected error message.");
    }

    /**
     * Checks that a FINITE mode errors for all transient errors when not suppressing.
     */
    @Test(dataProvider = "transientErrors")
    void testStartOneOffTransientErrorsNoSuppression(MockError error) {
        Cloudant mockClient = new ChangesRequestMockClient(() -> new MockInstruction<ChangesResult>(error));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions(), Duration.ZERO);
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> {
            testFollower.startOneOff().count();
        });
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected error message.");
    }

    /**
     * Checks that a FINITE mode repeatedly encountering transient errors will terminate with an exception after a duration.
     *
     * @param error
     */
    @Test(dataProvider = "transientErrors")
    void testStartOneOffTransientErrorsWithSuppressionDuration(MockError error) {
        Cloudant mockClient = new ChangesRequestMockClient(() -> new MockInstruction<ChangesResult>(error));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions(), Duration.ofMillis(100L));
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> {
            testFollower.startOneOff().count();
        });
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected error message.");
    }

    /**
     * Checks that a FINITE mode repeatedly encountering transient errors will complete successfully if not exceeding the duration.
     */
    @Test
    void testStartOneOffTransientErrorsWithSuppressionDurationCompletes() {
        int batches = 5;
        Cloudant mockClient = new ChangesRequestMockClient(getAlternatingBatchErrorSupplier(batches));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions(), Duration.ofMillis(100L));
        Assert.assertEquals(testFollower.startOneOff().count(), batches*ChangesFollower.BATCH_SIZE, "There should be the expected number of changes.");
    }

    /**
     * Checks that a FINITE mode repeatedly encountering transient errors will keep trying indefinitely with max suppression.
     *
     * @param error
     * @throws Exception
     */
    @Test(dataProvider = "transientErrors")
    void testStartOneOffTransientErrorsMaxSuppressionDoesNotComplete(MockError error) {
        Cloudant mockClient = new ChangesRequestMockClient(() -> new MockInstruction<ChangesResult>(error));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        try {
            long count = testFollowerOnThread(testFollower, ChangesFollower.Mode.FINITE, false, Duration.ofMillis(500L));
            Assert.assertEquals(count, 0L, "There should be no changes.");
        } catch(Exception e) {
            Assert.fail("There should be no exception.", e);
        }
    }

    /**
     * Checks that a FINITE mode encountering transient errors will complete successfully with max suppression.
     *
     * @throws Exception
     */
    @Test
    void testStartOneOffTransientErrorsMaxSuppressionDoesComplete() {
        int batches = 4;
        Cloudant mockClient = new ChangesRequestMockClient(getAlternatingBatchErrorSupplier(batches));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        Assert.assertEquals(testFollower.startOneOff().count(), batches*ChangesFollower.BATCH_SIZE, "There should be the expected number of changes.");
    }

    /**
     * Listening mode tests can terminate for errors, but not when changes complete so the helper stops the feed after the
     * duration when not an error case.
     *
     * Checks that a LISTEN mode completes successfully (after stopping) with some batches.
     */
    @Test
    void testStart() {
        Cloudant mockClient = new ChangesRequestMockClient(new PerpetualSupplier());
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        try {
            // Run for 5 seconds against an infinite stream
            long count = testFollowerOnThread(testFollower, ChangesFollower.Mode.LISTEN, false, Duration.ofSeconds(5L));
            // Even on a slow test machine we should at least get two batches, but hard to predict total changes
            long expectedMinChanges = 2 * ChangesFollower.BATCH_SIZE;
            Assert.assertTrue(count >= expectedMinChanges,
                String.format("Expected at least %d changes, but found only %d.", expectedMinChanges, count));
        } catch(Exception e) {
            Assert.fail("There should be no exception.", e);
        }
    }

    /**
     * Checks that a LISTEN mode errors for all terminal errors.
     */
    @Test(dataProvider = "terminalErrors")
    void testStartTerminalErrors(MockError error) {
        Cloudant mockClient = new ChangesRequestMockClient(() -> new MockInstruction<ChangesResult>(error));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> {
            testFollowerOnThread(testFollower, ChangesFollower.Mode.LISTEN, true, Duration.ofSeconds(1L));
        });
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected error message.");
    }
    
    /**
     * Checks that a LISTEN mode errors for all transient errors when not suppressing.
     */
    @Test(dataProvider = "transientErrors")
    void testStartTransientErrorsNoSuppression(MockError error) {
        Cloudant mockClient = new ChangesRequestMockClient(() -> new MockInstruction<ChangesResult>(error));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions(), Duration.ZERO);
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> {
            testFollowerOnThread(testFollower, ChangesFollower.Mode.LISTEN, true, Duration.ofSeconds(1L));
        });
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected error message.");
    }

    /**
     * Checks that a LISTEN mode errors for all transient errors when exceeding the suppression duration.
     */
    @Test(dataProvider = "transientErrors")
    void testStartTransientErrorsWithSuppressionDurationErrorTermination(MockError error) {
        Cloudant mockClient = new ChangesRequestMockClient(() -> new MockInstruction<ChangesResult>(error));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions(), Duration.ofMillis(100L));
        RuntimeException e = Assert.expectThrows(error.getExceptionClass(), () -> {
            testFollowerOnThread(testFollower, ChangesFollower.Mode.LISTEN, true, Duration.ofSeconds(1L));
        });
        Assert.assertEquals(e.getMessage(), error.getException().getMessage(), "Should receive the expected error message.");
    }

    /**
     * Checks that a LISTEN mode gets changes and can be stopped cleanly with transient errors when not exceeding the
     * suppression duration.
     */
    @Test
    void testStartTransientErrorsWithSuppressionDurationAllChanges() {
        int batches = 2;
        Cloudant mockClient = new ChangesRequestMockClient(getAlternatingBatchErrorThenPerpetualSupplier(batches));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions(), Duration.ofMillis(100L));
        try {
            long count = testFollowerOnThread(testFollower, ChangesFollower.Mode.LISTEN, false, Duration.ofSeconds(1L));
            Assert.assertEquals(count, batches*ChangesFollower.BATCH_SIZE, "There should be the correct number of changes.");
        } catch(Exception e) {
            Assert.fail("There should be no exception", e);
        }
    }

    /**
     * Checks that a LISTEN mode keeps running with transient errors (until stopped cleanly) with max suppression.
     */
    @Test(dataProvider = "transientErrors")
    void testStartTransientErrorsWithMaxSuppression(MockError error) {
        Cloudant mockClient = new ChangesRequestMockClient(() -> new MockInstruction<ChangesResult>(error));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        try {
            long count = testFollowerOnThread(testFollower, ChangesFollower.Mode.LISTEN, false, Duration.ofSeconds(1L));
            Assert.assertEquals(count, 0L, "There should be no changes.");
        } catch(Exception e) {
            Assert.fail("There should be no exception", e);
        }
    }

    /**
     * Checks that a LISTEN mode runs through multiple transient errors with max suppression to receive changes until stopped.
     */
    @Test
    void testStartTransientErrorsWithMaxSuppressionAllChanges() {
        int batches = 3;
        Cloudant mockClient = new ChangesRequestMockClient(getAlternatingBatchErrorThenPerpetualSupplier(batches));
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        try {
            long count = testFollowerOnThread(testFollower, ChangesFollower.Mode.LISTEN, false, Duration.ofSeconds(1L));
            Assert.assertEquals(count, batches*ChangesFollower.BATCH_SIZE, "There should be the correct number of changes.");
        } catch(Exception e) {
            Assert.fail("There should be no exception", e);
        }
    }

    /**
     * Checks calling stop for the FINITE case. The LISTEN case is covered in start tests because they won't stop by themselves.
     */
    @Test
    void testStop() {
        Cloudant mockClient = new ChangesRequestMockClient(new PerpetualSupplier());
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getOptions());
        try {
            // Run for 5 seconds against an infinite stream
            long count = testFollowerOnThread(testFollower, ChangesFollower.Mode.FINITE, false, Duration.ofSeconds(5L));
            // Even on a slow test machine we should at least get two batches, but hard to predict total changes
            long expectedMinChanges = 2 * ChangesFollower.BATCH_SIZE;
            Assert.assertTrue(count >= expectedMinChanges,
                String.format("Expected at least %d changes, but found only %d.", expectedMinChanges, count));
        } catch(Exception e) {
            Assert.fail("There should be no exception.", e);
        }
    }

    /**
     * Checks that a follower can only be started once.
     *
     * @param firstCallMode finite or listen for the first call
     * @param secondCallMode finite or listen for the second call
     * @throws InterruptedException
     */
    @Test(dataProvider = "states")
    void testStateErrors(final ChangesFollower.Mode firstCallMode, final ChangesFollower.Mode secondCallMode) {
        ChangesFollower testFollower = new ChangesFollower(new ChangesRequestMockClient(new PerpetualSupplier()), TestOptions.MINIMUM.getOptions());
        if (firstCallMode == ChangesFollower.Mode.FINITE) {
            testFollower.startOneOff();
        } else {
            testFollower.start();
        }
        try {
            Assert.assertThrows(IllegalStateException.class, () -> {
                if (secondCallMode == ChangesFollower.Mode.FINITE) {
                    testFollower.startOneOff();
                } else {
                    testFollower.start();
                }
            });
        } finally {
            testFollower.stop();
        }
    }

    /**
     * Checks that setting a limit terminates the stream early for both modes and limits smaller, the same and larger than the default
     * batch size.
     */
    @Test(dataProvider = "modesAndLimits")
    void testLimit(ChangesFollower.Mode mode, long limit) {
        Cloudant mockClient = new ChangesRequestMockClient(new PerpetualSupplier());
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getBuilder().limit(limit).build());
        try {
            // The stream should self terminate, so use a long timeout
            long count = testFollowerOnThread(testFollower, mode, true, Duration.ofMinutes(1L));
            // Assert the number of changes matches the limit
            Assert.assertEquals(count, limit, "There should be the correct number of changes.");
        } catch(Exception e) {
            Assert.fail("There should be no exception.", e);
        }
    }

    /**
     * Checks that setting includeDocs forces a calculation of batch size and asserts the size.
     *
     * Mocks a DB of 500_000 docs of 523 bytes each to give an expected batch size of 5125
     *
     * 523 bytes + 500 bytes of changes overhead = 1023 bytes
     * 5 MiB / 1023 bytes = 5125 docs per batch
     *
     * @see ChangesRequestMockClient#getDatabaseInformation(com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions)
     */
    @Test
    void testBatchSize() {
        Cloudant mockClient = new ChangesRequestMockClient(ChangesRequestMockClient.makeBatchSupplier(1));
        // Use no error tolerance to ensure we get our special test exception
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getBuilder().includeDocs(true).build(), Duration.ZERO);
        LimitExposingException lee = Assert.expectThrows(LimitExposingException.class, () -> {
            testFollower.startOneOff().count();
        });
        Assert.assertEquals(lee.getRequestLimit(), 5125L, "The changes request should have the expected limit.");
    }

    /**
     * Checks that setting includeDocs forces a calculation of batch size and asserts the size.
     *
     * Mocks a DB of just under 5 MiB with 1 doc to validate that a batch calculation of 0
     * results in a limit of 1.
     *
     * @see ChangesRequestMockClient#getDatabaseInformation(com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions)
     */
    @Test
    void testBatchSizeMinimum() {
        ChangesRequestMockClient mockClient = new ChangesRequestMockClient(ChangesRequestMockClient.makeBatchSupplier(1));
        mockClient.setDatabaseInfoDocCount(1L);
        mockClient.setDatabaseInfoDocSize(5L * 1024L * 1024L - 1L);
        // Use no error tolerance to ensure we get our special test exception
        ChangesFollower testFollower = new ChangesFollower(mockClient, TestOptions.MINIMUM.getBuilder().includeDocs(true).build(), Duration.ZERO);
        LimitExposingException lee = Assert.expectThrows(LimitExposingException.class, () -> {
            testFollower.startOneOff().count();
        });
        Assert.assertEquals(lee.getRequestLimit(), 1L, "The changes request should have the expected limit.");
    }

    /**
     * Checks that setting includeDocs forces a calculation of batch size and asserts the size.
     *
     * Mocks a DB of 500_000 docs of 523 bytes each to give an expected batch size of 5125
     *
     * With a total limit of 1000 set that should be used for the per request size instead of 5125.
     *
     * @see ChangesRequestMockClient#getDatabaseInformation(com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions)
     */
    @Test
    void testBatchSizeLimit() {
        Cloudant mockClient = new ChangesRequestMockClient(ChangesRequestMockClient.makeBatchSupplier(1));
        // Use no error tolerance to ensure we get our special test exception
        ChangesFollower testFollower = new ChangesFollower(mockClient,
            TestOptions.MINIMUM.getBuilder().limit(1000L).includeDocs(true).build(), Duration.ZERO);
        LimitExposingException lee = Assert.expectThrows(LimitExposingException.class, () -> {
            testFollower.startOneOff().count();
        });
        Assert.assertEquals(lee.getRequestLimit(), 1000L, "The changes request should have the expected limit.");
    }
}
