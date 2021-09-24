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
