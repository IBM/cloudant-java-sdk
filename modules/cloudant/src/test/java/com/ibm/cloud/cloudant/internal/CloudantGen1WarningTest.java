/**
 * © Copyright IBM Corporation 2026. All Rights Reserved.
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

package com.ibm.cloud.cloudant.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetCapacityThroughputInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetServerInformationOptions;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CloudantGen1WarningTest {

    private static final String EXPECTED_URL =
            "https://github.com/IBM/cloudant-java-sdk/blob/main/KNOWN_ISSUES.md#cloudant-gen-2-compatibility";

    private final Logger logger = Logger.getLogger(CloudantBaseService.class.getName());

    public void runTest(
            Function<Cloudant, ?> serviceCall,
            Consumer<List<LogRecord>> logAssertion
    ) throws Exception {
        TestLogHandler handler = new TestLogHandler();
        logger.addHandler(handler);
        try (MockWebServer server = new MockWebServer()) {
            server.start();
            server.enqueue(new MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setResponseCode(200)
                    .setBody("{}"));
            Cloudant cloudantService = new Cloudant("test", new NoAuthAuthenticator());
            cloudantService.setServiceUrl(server.url("/test/foo").toString());
            serviceCall.apply(cloudantService);
            logAssertion.accept(handler.records);
        } finally {
            logger.removeHandler(handler);
        }
    }

    class AssertWarning implements Consumer<List<LogRecord>> {

        private final String expectedOperation;

        AssertWarning(String expectedOperation) {
            this.expectedOperation = expectedOperation;
        }

        @Override
        public void accept(List<LogRecord> records) {
            assertEquals(records.size(), 1, "Expected one warning log record.");
            LogRecord record = records.get(0);
            assertEquals(record.getLevel(), Level.WARNING);
            assertEquals(record.getMessage(), String.format(
                    "The operation %s is unavailable for Gen 2 Cloudant plans. See %s for more information.",
                    expectedOperation,
                    EXPECTED_URL));
        }
    }

    class AssertNoWarning implements Consumer<List<LogRecord>> {

        @Override
        public void accept(List<LogRecord> records) {
            assertTrue(records.isEmpty(), "Expected no log records.");
        }
    }

    private static class TestLogHandler extends Handler {
        private final List<LogRecord> records = new ArrayList<>();

        @Override
        public void publish(LogRecord record) {
            records.add(record);
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() throws SecurityException {
        }
    }

    @Test
    public void testGetCapacityThroughputInformationWarning() throws Throwable {
        GetCapacityThroughputInformationOptions options = new GetCapacityThroughputInformationOptions();
        runTest(
                c -> c.getCapacityThroughputInformation(options).execute(),
                new AssertWarning("getCapacityThroughputInformation")
        );
    }

    @Test
    public void testPostApiKeysWarning() throws Throwable {
        runTest(
                c -> c.postApiKeys().execute(),
                new AssertWarning("postApiKeys")
        );
    }

    @Test
    public void testGetServerInformationNoWarning() throws Throwable {
        GetServerInformationOptions options = new GetServerInformationOptions();
        runTest(
                c -> c.getServerInformation(options).execute(),
                new AssertNoWarning()
        );
    }
}
