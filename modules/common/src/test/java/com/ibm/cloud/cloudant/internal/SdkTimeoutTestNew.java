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
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.connection.RealCall;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


// Every method tests an authenticator.
public class SdkTimeoutTestNew {
    final long defaultTimeoutValue = 150L;
    final long authenticationTimeoutValue = 90L;
    final long customTimeoutValue = 10L;

    final long testCases[] = {
            // 1. case: check default timeout value
            defaultTimeoutValue,
            // 2. case: check custom timeout overwrite
            customTimeoutValue
    };

    public static MockWebServer mockedServer;

    @BeforeMethod
    static void setUp() throws IOException {
        mockedServer = new MockWebServer();
        mockedServer.start();
    }

    @AfterMethod
    static void tearDown() throws IOException {
        mockedServer.shutdown();
    }
    
    // Helper functions
    private CloudantBaseService createCloudantBaseService(Authenticator authInstance, String urlAsString) {
        CloudantBaseService myService = new CloudantBaseService(null, authInstance) {};
        myService.setServiceUrl(urlAsString);
        return myService;
    }

    private Request createTestRequest(CloudantBaseService myService) {
        HttpUrl requestUrl = HttpUrl.parse(myService.getServiceUrl()).newBuilder().addPathSegment("/").build();
        return new Request.Builder().url(requestUrl).get().build();
    }

    private void setCustomTimeout(CloudantBaseService myService, long testCase) {
        OkHttpClient client = myService.getClient();
        client = client.newBuilder().readTimeout(testCase, TimeUnit.SECONDS).build();
        myService.setClient(client);
    }

    private RealCall createServiceCall(CloudantBaseService serviceClient, Request serviceRequest) throws NoSuchFieldException, IllegalAccessException {
        ServiceCall<RealCall> serviceCall = serviceClient.createServiceCall(serviceRequest, null);
        Field callField = serviceCall.getClass().getDeclaredField("call");
        callField.setAccessible(true);
        return (RealCall) callField.get(serviceCall);
    }

    private void setupIamAuthResponse() {
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

        mockedServer.enqueue(iamPostResponse);
    }

    private void setupSessionAuthRespones() {
        String mockSetCookieValue = String.format("%s; Version=1; Expires=Thu, 09-Apr-2020 " +
                "10:30:47 GMT; Max-Age=600; Path=/; HttpOnly", "AuthSession=ABC123456DE");
        String mockSessionPostResponseBody = "{\"ok\":true,\"name\":\"testuser\"," +
                "\"roles\":[\"admin\"]}";
        MockResponse sessionPostResponse = new MockResponse()
                .addHeader("Set-Cookie", mockSetCookieValue)
                .setBody(mockSessionPostResponseBody);

        mockedServer.enqueue(sessionPostResponse);
    }

    // Test implementations
    @Test
    void testNoAuthTimeout() throws NoSuchFieldException, IllegalAccessException {
        NoAuthAuthenticator noAuth = new NoAuthAuthenticator();
        CloudantBaseService myService = createCloudantBaseService(noAuth, "https://cloudant.example");
        Request testRequest = createTestRequest(myService);
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                setCustomTimeout(myService, testCases[i]);
            }
            RealCall testRequestCall = createServiceCall(myService, testRequest);
            assertEquals(TimeUnit.MILLISECONDS.toSeconds(testRequestCall.getClient().readTimeoutMillis()), testCases[i]);
        }
    }

    @Test
    void testBasicAuthTimeout() throws NoSuchFieldException, IllegalAccessException {
        BasicAuthenticator basicAuth = new BasicAuthenticator.Builder()
                .username("user")
                .password("psw")
                .build();
        CloudantBaseService myService = createCloudantBaseService(basicAuth, "https://cloudant.example");
        Request testRequest = createTestRequest(myService);
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                setCustomTimeout(myService, testCases[i]);
            }
            RealCall testRequestCall = createServiceCall(myService, testRequest);
            assertEquals(TimeUnit.MILLISECONDS.toSeconds(testRequestCall.getClient().readTimeoutMillis()), testCases[i]);
        }
    }

    @Test
    void testSessionAuthTimeout() throws NoSuchFieldException, IllegalAccessException {
        CouchDbSessionAuthenticator sessionAuth = (CouchDbSessionAuthenticator)CouchDbSessionAuthenticator.newAuthenticator("user", "pass");
        CloudantBaseService myService = createCloudantBaseService(sessionAuth, "http://" + mockedServer.getHostName() + ":" + mockedServer.getPort());
        Request testRequest = createTestRequest(myService);
        for (int i = 0; i < 2; i++) {
            setupSessionAuthRespones();
            if (i == 1) {
                setCustomTimeout(myService, testCases[i]);
            }
            RealCall testRequestCall = createServiceCall(myService, testRequest);
            assertEquals(TimeUnit.MILLISECONDS.toSeconds(testRequestCall.getClient().readTimeoutMillis()), testCases[i]);

            CouchDbSessionAuthenticator auth = (CouchDbSessionAuthenticator) myService.getAuthenticator();
            Field clientField = auth.getClass().getDeclaredField("client");
            clientField.setAccessible(true);
            OkHttpClient c = (OkHttpClient) clientField.get(auth);
            assertEquals(TimeUnit.MILLISECONDS.toSeconds(c.readTimeoutMillis()), authenticationTimeoutValue);
        }
    }

    @Test
    void testIAMAuthTimeout() throws NoSuchFieldException, IllegalAccessException {
        IamAuthenticator iamAuth = new IamAuthenticator.Builder()
                .apikey("apikey")
                .url("http://" + mockedServer.getHostName() + ":" + mockedServer.getPort())
                .build();
        CloudantBaseService myService = createCloudantBaseService(iamAuth, "https://cloudant.example");
        Request testRequest = createTestRequest(myService);
        for (int i = 0; i < 2; i++) {
            setupIamAuthResponse();
            if (i == 1) {
                setCustomTimeout(myService, testCases[i]);
            }
            RealCall testRequestCall = createServiceCall(myService, testRequest);
            assertEquals(TimeUnit.MILLISECONDS.toSeconds(testRequestCall.getClient().readTimeoutMillis()), testCases[i]);
        }
    }
}
