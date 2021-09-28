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

package com.ibm.cloud.cloudant.internal;

import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import okhttp3.*;
import okhttp3.internal.connection.RealCall;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


@PrepareForTest({RealCall.class})
public class SdkTimeoutTestNew {
    final long defaultTimeoutValue = 150L;
    final long customTimeoutValue = 10L;

    // Every test case tests an authenticator.
    final long testCases[] = {
            // 1. case: its default timeout value checked,
            defaultTimeoutValue,
            // 2. case: a custom overwrite possibility is checked.
            customTimeoutValue
    };

    @Test
    void testNoAuthTimeout() throws NoSuchFieldException, IllegalAccessException {
        CloudantBaseService myService = new CloudantBaseService(null, new NoAuthAuthenticator()) {};
        myService.setServiceUrl("https://cloudant.example");

        // Create a server request for testing
        HttpUrl requestUrl = HttpUrl.parse(myService.getServiceUrl()).newBuilder().addPathSegment("/").build();
        Request req = new Request.Builder().url(requestUrl).get().build();

        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                // Change timeout
                OkHttpClient client = myService.getClient();
                client = client.newBuilder().readTimeout(testCases[i], TimeUnit.SECONDS).build();
                myService.setClient(client);
            }
            // Create a service call for testing
            ServiceCall<RealCall> serviceCall = myService.createServiceCall(req, null);
            Field callField = serviceCall.getClass().getDeclaredField("call");
            callField.setAccessible(true);
            RealCall requestCall = (RealCall) callField.get(serviceCall);

            assertEquals(TimeUnit.MILLISECONDS.toSeconds(requestCall.getClient().readTimeoutMillis()), testCases[i]);
        }
    }

    @Test
    void testBasicAuthTimeout() throws NoSuchFieldException, IllegalAccessException {
        BasicAuthenticator basicAuth = new BasicAuthenticator.Builder()
                .username("user")
                .password("psw")
                .build();
        CloudantBaseService myService = new CloudantBaseService(null, basicAuth) {};
        myService.setServiceUrl("https://cloudant.example");

        // Create a server request for testing
        HttpUrl requestUrl = HttpUrl.parse(myService.getServiceUrl()).newBuilder().addPathSegment("/").build();
        Request req = new Request.Builder().url(requestUrl).get().build();

        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                // Change timeout
                OkHttpClient client = myService.getClient();
                client = client.newBuilder().readTimeout(testCases[i], TimeUnit.SECONDS).build();
                myService.setClient(client);
            }
            // Create a service call for testing
            ServiceCall<RealCall> serviceCall = myService.createServiceCall(req, null);
            Field callField = serviceCall.getClass().getDeclaredField("call");
            callField.setAccessible(true);
            RealCall requestCall = (RealCall) callField.get(serviceCall);

            assertEquals(TimeUnit.MILLISECONDS.toSeconds(requestCall.getClient().readTimeoutMillis()), testCases[i]);
        }
    }
}
