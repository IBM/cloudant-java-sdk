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

import com.ibm.cloud.cloudant.security.CouchDbSessionAuthenticator;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.connection.RealCall;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class SdkTimeoutTestNew {
    final long defaultTimeoutValue = 150L;
    final long authenticationTimeoutValue = 90L;
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

    @Test
    void testSessionAuthTimeout() throws Exception {
        CouchDbSessionAuthenticator sessionAuth = (CouchDbSessionAuthenticator)CouchDbSessionAuthenticator.newAuthenticator("user", "pass");
        CloudantBaseService myService = new CloudantBaseService(null, sessionAuth) {};
        myService.setServiceUrl("https://cloudant.example");

        // Create a server request for testing
        HttpUrl requestUrl = HttpUrl.parse(myService.getServiceUrl()).newBuilder().addPathSegment("/").build();
        Request req = new Request.Builder().url(requestUrl).get().build();

        MockWebServer server = new MockWebServer();
        server.start();
        String mockSession = "AuthSession=ABC123456DE";
        String mockSetCookieValue = String.format("%s; Version=1; Expires=Thu, 09-Apr-2020 " +
                "10:30:47 GMT; Max-Age=600; Path=/; HttpOnly", mockSession);
        String mockSessionPostResponseBody = "{\"ok\":true,\"name\":\"testuser\"," +
                "\"roles\":[\"admin\"]}";
        MockResponse sessionPostResponse = new MockResponse()
                .addHeader("Set-Cookie", mockSetCookieValue)
                .setBody(mockSessionPostResponseBody);

        server.enqueue(sessionPostResponse);

        myService.setServiceUrl("http://" + server.getHostName() + ":" + server.getPort());

        // Create a service call for testing
        ServiceCall<RealCall> serviceCall = myService.createServiceCall(req, null);
        Field callField = serviceCall.getClass().getDeclaredField("call");
        callField.setAccessible(true);
        RealCall requestCall = (RealCall) callField.get(serviceCall);
        assertEquals(TimeUnit.MILLISECONDS.toSeconds(requestCall.getClient().readTimeoutMillis()), testCases[0]);

        CouchDbSessionAuthenticator auth = (CouchDbSessionAuthenticator) myService.getAuthenticator();
        Field clientField = auth.getClass().getDeclaredField("client");
        clientField.setAccessible(true);
        OkHttpClient c = (OkHttpClient) clientField.get(auth);
        assertEquals(TimeUnit.MILLISECONDS.toSeconds(c.readTimeoutMillis()), authenticationTimeoutValue);

        server.shutdown();
    }

    @Test
    void testIAMAuthTimeout() throws Exception {
        // Create auth server
        MockWebServer server = new MockWebServer();
        server.start();

        String tokenResponse ="{\n" +
                "  \"access_token\": \"abcd-1234\",\n" +
                "  \"refresh_token\": \"00000000\",\n" +
                "  \"token_type\": \"Bearer\",\n" +
                "  \"expires_in\": 3600,\n" +
                "  \"expiration\": 1522788645\n" +
                "}";

        MockResponse iamPostResponse = new MockResponse()
                .setResponseCode(200)
                .setBody(tokenResponse);

        server.enqueue(iamPostResponse);

        IamAuthenticator iamAuth = new IamAuthenticator.Builder()
                .apikey("apikey")
                .url("http://" + server.getHostName() + ":" + server.getPort())
                .build();
        CloudantBaseService myService = new CloudantBaseService(null, iamAuth) {
        };
        myService.setServiceUrl("https://cloudant.example");

        // Create a server request for testing
        HttpUrl requestUrl = HttpUrl.parse(myService.getServiceUrl()).newBuilder().addPathSegment("/").build();
        Request req = new Request.Builder().url(requestUrl).get().build();

        // Create a service call for testing
        ServiceCall<RealCall> serviceCall = myService.createServiceCall(req, null);
        Field callField = serviceCall.getClass().getDeclaredField("call");
        callField.setAccessible(true);
        RealCall requestCall = (RealCall) callField.get(serviceCall);
        assertEquals(TimeUnit.MILLISECONDS.toSeconds(requestCall.getClient().readTimeoutMillis()), testCases[0]);
        server.shutdown();
    }
}
