/**
 * © Copyright IBM Corporation 2020. All Rights Reserved.
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

package com.ibm.cloud.cloudant;

import com.ibm.cloud.cloudant.internal.CloudantBaseService;
import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import okhttp3.OkHttpClient;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SdkTimeoutTest {
    @Test
    void testDefaultReadTimeoutSetting() {
        final long defaultTimeoutValue = 150L;
        final long customTimeoutValue = 10L;

        CloudantBaseService cloudantBaseService = new CloudantBaseService(null, new NoAuthAuthenticator()) {
        };
        // Default 2.5 minutes read timeout is set by default.
        assertEquals(TimeUnit.MILLISECONDS.toSeconds(cloudantBaseService.getClient().readTimeoutMillis()), defaultTimeoutValue);

        // Calling setServiceUrl function will not change the default timeout
        cloudantBaseService.setServiceUrl("https://cloudant.example");
        assertEquals(TimeUnit.MILLISECONDS.toSeconds(cloudantBaseService.getClient().readTimeoutMillis()), defaultTimeoutValue);

        // Calling configureClient function will not change the default timeout
        HttpConfigOptions options = new HttpConfigOptions.Builder().disableRetries().build();
        cloudantBaseService.configureClient(options);
        assertEquals(TimeUnit.MILLISECONDS.toSeconds(cloudantBaseService.getClient().readTimeoutMillis()), defaultTimeoutValue);

        // Calling setClient function will not change the default timeout
        OkHttpClient client = cloudantBaseService.getClient();
        client = client.newBuilder().callTimeout(customTimeoutValue, TimeUnit.SECONDS).build();
        cloudantBaseService.setClient(client);
        assertEquals(TimeUnit.MILLISECONDS.toSeconds(cloudantBaseService.getClient().readTimeoutMillis()), defaultTimeoutValue);
        assertEquals(TimeUnit.MILLISECONDS.toSeconds(cloudantBaseService.getClient().callTimeoutMillis()), customTimeoutValue);

        // Allow timeout overwrite by the common SDK suggested way
        client = client.newBuilder().readTimeout(customTimeoutValue, TimeUnit.SECONDS).build();
        cloudantBaseService.setClient(client);
        assertEquals(TimeUnit.MILLISECONDS.toSeconds(cloudantBaseService.getClient().readTimeoutMillis()), customTimeoutValue);
    }
}
