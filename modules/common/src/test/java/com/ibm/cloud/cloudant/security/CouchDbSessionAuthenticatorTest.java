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

package com.ibm.cloud.cloudant.security;

import com.ibm.cloud.cloudant.common.SdkCommon;
import com.ibm.cloud.cloudant.internal.CloudantBaseService;
import com.ibm.cloud.cloudant.internal.TestCloudantService;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class CouchDbSessionAuthenticatorTest {

    public static String URL = "https://cloudant-test.example";
    public static String USERNAME = "testuser";
    public static String PASSWORD = "testpass";

    CouchDbSessionAuthenticator testAuthenticator =
            createAuthenticator(CouchDbSessionAuthenticatorTest.USERNAME,
            CouchDbSessionAuthenticatorTest.PASSWORD);

    Map<String, String> customHeaders = Collections.singletonMap("X-CDT-SDK-TEST", "TESTVALUE");

    private CouchDbSessionAuthenticator createAuthenticator(String user, String pass) {
        CouchDbSessionAuthenticator authenticator = (CouchDbSessionAuthenticator)
                CouchDbSessionAuthenticator.newAuthenticator(user, pass);
        authenticator.setSessionUrl(URL);
        return authenticator;
    }

    @Test
    void newAuthenticator() {
        Authenticator authenticator = createAuthenticator(USERNAME,
                PASSWORD);
        assertNotNull(authenticator, "Authenticator should not be null.");
    }

    /**
     * Test that no exceptions are thrown when validating good test data
     */
    @Test
    void validateValid() {
        testAuthenticator.validate();
    }

    @Test
    void validateNullUser() {
        Authenticator a = createAuthenticator(null, CouchDbSessionAuthenticatorTest.PASSWORD);
        assertThrows(IllegalArgumentException.class, a::validate);
    }

    @Test
    void validateEmptyUser() {
        Authenticator a = createAuthenticator("", CouchDbSessionAuthenticatorTest.PASSWORD);
        assertThrows(IllegalArgumentException.class, a::validate);
    }

    @Test
    void validateNullPass() {
        Authenticator a = createAuthenticator(CouchDbSessionAuthenticatorTest.USERNAME, null);
        assertThrows(IllegalArgumentException.class, a::validate);
    }

    @Test
    void validateEmptyPass() {
        Authenticator a = createAuthenticator(CouchDbSessionAuthenticatorTest.USERNAME, "");
        assertThrows(IllegalArgumentException.class, a::validate);
    }

    @Test
    void authenticationType() {
        assertEquals(testAuthenticator.authenticationType(), "COUCHDB_SESSION", "Authentication " +
                "type should be COUCHDB_SESSION");
    }

    /**
     * Test that first time calls to authenticate request a token
     */
    @Test
    void authenticateFirstTime() {
        CouchDbSessionAuthenticator a =
                Mockito.spy(testAuthenticator);
        // Stub token response
        Mockito.doReturn(
                new CouchDbSessionAuthenticator.CouchDbSessionToken(System.currentTimeMillis() + 5000))
                .when(a)
                .requestToken();

        // Call authenticate
        a.authenticate(null);

        // Verify that requestToken was called once
        Mockito.verify(a).requestToken();
    }

    /**
     * Test that when authenticate is called when a token needs refresh a new token is requested
     */
    @Test
    void authenticatePreemptiveRenewal() {
        CouchDbSessionAuthenticator a =
                Mockito.spy(testAuthenticator);
        // Stub token response
        CouchDbSessionAuthenticator.CouchDbSessionToken token =
                Mockito.mock(CouchDbSessionAuthenticator.CouchDbSessionToken.class);
        Mockito.when(token.isTokenValid()).thenReturn(true);
        Mockito.when(token.needsRefresh()).thenReturn(true);
        Mockito.doReturn(token)
                .when(a)
                .requestToken();

        // Call authenticate, this is the first call that provides the new (mock) token
        a.authenticate(null);

        // Call authenticate a second time, the token should renew
        a.authenticate(null);

        // Note that pre-emptive token renewal takes place on a background thread so we
        // can't necessarily verify immediately. Use a timeout to wait up to 1 second to
        // verify that requestToken was called twice before that time.
        Mockito.verify(a, Mockito.timeout(1000).times(2)).requestToken();
    }

    /**
     * Test that when authenticate is called when a token is expired a new token is requested
     */
    @Test
    void authenticateExpiredRenewal() {
        CouchDbSessionAuthenticator a =
                Mockito.spy(testAuthenticator);
        // Stub token response
        CouchDbSessionAuthenticator.CouchDbSessionToken token =
                Mockito.mock(CouchDbSessionAuthenticator.CouchDbSessionToken.class);
        Mockito.when(token.isTokenValid()).thenReturn(false);
        Mockito.when(token.needsRefresh()).thenReturn(true);
        Mockito.doReturn(token)
                .when(a)
                .requestToken();

        // Call authenticate, this is the first call that provides the new (mock) token
        a.authenticate(null);

        // Call authenticate a second time, the token should renew
        a.authenticate(null);

        // Verify that requestToken was called twice
        Mockito.verify(a, Mockito.times(2)).requestToken();
    }

    @Test
    void setServiceUrlInvalidatesToken() {
        CouchDbSessionAuthenticator couchDbSessionAuthenticator =
                Mockito.spy(testAuthenticator);
        CouchDbSessionAuthenticator.CouchDbSessionToken token =
                Mockito.mock(CouchDbSessionAuthenticator.CouchDbSessionToken.class);

        Mockito.when(token.isTokenValid()).thenReturn(true);
        Mockito.when(token.needsRefresh()).thenReturn(false);
        Mockito.doNothing().when(couchDbSessionAuthenticator).setSessionUrl(any());

        CloudantBaseService cloudantBaseService = new CloudantBaseService(null,
                couchDbSessionAuthenticator) {
        };

        Mockito.doReturn(token)
                .when(couchDbSessionAuthenticator)
                .requestToken();

        // Call authenticate, this is the first call that provides the new (mock) token
        couchDbSessionAuthenticator.authenticate(null);

        cloudantBaseService.setServiceUrl("newUrl");

        // Call authenticate a second time, the token should renew
        couchDbSessionAuthenticator.authenticate(null);

        // Verify that requestToken was called twice
        Mockito.verify(couchDbSessionAuthenticator, Mockito.times(2)).requestToken();
    }

    /**
     * Test that when authenticate is called when a token is valid no new token is requested
     */
    @Test
    void authenticateWhenValid() {
        CouchDbSessionAuthenticator a =
                Mockito.spy(testAuthenticator);
        // Stub token response
        CouchDbSessionAuthenticator.CouchDbSessionToken token =
                Mockito.mock(CouchDbSessionAuthenticator.CouchDbSessionToken.class);
        Mockito.when(token.isTokenValid()).thenReturn(true);
        Mockito.when(token.needsRefresh()).thenReturn(false);
        Mockito.doReturn(token)
                .when(a)
                .requestToken();

        // Call authenticate, this is the first call that provides the new (mock) token
        a.authenticate(null);

        // Call authenticate a second time, the token is valid and should not renew
        a.authenticate(null);

        // Verify that requestToken was called just once
        Mockito.verify(a).requestToken();
    }

    /**
     * Validate that the cookie jar used by the authenticator matches the one on the service client
     */
    @Test
    void getCookieJar() {
        TestCloudantService testCloudantService = new TestCloudantService("test", testAuthenticator);
        assertEquals(testAuthenticator.getCookieJar(), testCloudantService.getClient().cookieJar(), "The " +
                "authenticator and client should use the same cookie jar.");

    }

    /**
     * Test that setting default headers for the client apply to the token request
     */
    @Test
    void setHeaders() {
        CouchDbSessionAuthenticator a =
                Mockito.spy(testAuthenticator);
        TestCloudantService testCloudantService = new TestCloudantService("test", a);
        testCloudantService.setDefaultHeaders(customHeaders);

        // Assert that the headers are the custom header + the SDK defaults
        Map<String, String> expectedHeaders = new HashMap<>();
        expectedHeaders.putAll(customHeaders);
        expectedHeaders.putAll(SdkCommon.getSdkHeaders("authenticatorPostSession"));
        assertEquals(a.getHeaders(), expectedHeaders, "The expected headers should match.");
    }

    /**
     * Assert that the requestToken method calls out to the _session endpoint successfully.
     *
     * @throws Exception
     */
    @Test
    void requestToken() throws Exception {

        String mockSession = "AuthSession=ABC123456DE";
        String mockSetCookieValue = String.format("%s; Version=1; Expires=Thu, 09-Apr-2020 " +
                "10:30:47 GMT; Max-Age=600; Path=/; HttpOnly", mockSession);
        String mockSessionPostResponseBody = "{\"ok\":true,\"name\":\"testuser\"," +
                "\"roles\":[\"admin\"]}";
        String mockSessionGetResponseBody = "{\"ok\":true,\"userCtx\":{\"name\":\"testuser\"," +
                "\"roles\":[\"_admin\"]}}";

        MockResponse sessionPostResponse = new MockResponse()
                .addHeader("Set-Cookie", mockSetCookieValue)
                .setBody(mockSessionPostResponseBody);
        MockResponse sessionGetResponse = new MockResponse()
                .setBody(mockSessionGetResponseBody);
        try(MockWebServer server = new MockWebServer();) {
            server.start();
            server.getPort();
            server.enqueue(sessionPostResponse);
            server.enqueue(sessionGetResponse);

            TestCloudantService testCloudantService = new TestCloudantService("test", testAuthenticator);
            testCloudantService.setServiceUrl("http://" + server.getHostName() + ":" + server.getPort());
            testCloudantService.setDefaultHeaders(customHeaders);
            Response<Map<String,Object>> call = testCloudantService.getSessionInformation().execute();

            // Assert on the mock server
            // First request
            RecordedRequest sessionPostRequest = server.takeRequest();
            assertEquals(sessionPostRequest.getMethod(), "POST", "Should have been a POST request" +
                    ".");
            assertEquals(sessionPostRequest.getPath(), "/_session", "Should have been a _session " +
                    "request.");
            String expectedBody = String.format("{\"username\":\"%s\",\"password\":\"%s\"}",
                    CouchDbSessionAuthenticatorTest.USERNAME,
                    String.valueOf(CouchDbSessionAuthenticatorTest.PASSWORD));
            assertEquals(sessionPostRequest.getBody().readUtf8(), expectedBody, "The body should " +
                    "be as expected.");
            assertEquals(sessionPostRequest.getHeader("X-CDT-SDK-TEST"), "TESTVALUE", "The custom" +
                    " header should have been on the request.");
            // Second request
            RecordedRequest sessionGetRequest = server.takeRequest();
            assertEquals(sessionGetRequest.getMethod(), "GET", "Should have been a GET request.");
            assertEquals(sessionGetRequest.getPath(), "/_session", "Should have been a _session " +
                    "request.");
            assertEquals(sessionGetRequest.getHeader("Cookie"), mockSession, "The cookie on the " +
                    "request should be correct.");

            // Additional assertions on the response
            assertEquals(200, call.getStatusCode(), "The request should succeed.");
            // Perform some additional assertions on the response
            Map<String, Object> information = call.getResult();
            assertTrue((Boolean) information.get("ok"), "The response should be OK.");
            Map<String, Object> userCtx = (Map<String, Object>) information.get("userCtx");
            assertNotNull(information.get("userCtx"), "There should be a user context.");
            assertEquals(userCtx.get("name"), "testuser", "The user should be " +
                    "testuser.");
            List<String> roles = (List<String>) userCtx.get("roles");
            assertEquals(roles.get(0), "_admin", "The role should be " +
                    "_admin");
        }
    }

    /**
     * Test that an exception from requestToken propagates correctly.
     *
     * @throws Exception
     */
    @Test
    void requestTokenUnauthorized() throws Exception {
        MockResponse sessionPostErrorResponse = new MockResponse()
                .setStatus("HTTP/1.1 401 UNAUTHORIZED")
                .setBody("{\"error\":\"unauthorized\",\"reason\":\"Name or password is incorrect" +
                        ".\"}");
        try(MockWebServer server = new MockWebServer()) {
            server.start();
            server.getPort();
            server.enqueue(sessionPostErrorResponse);

            TestCloudantService testCloudantService = new TestCloudantService("test", testAuthenticator);
            testCloudantService.setServiceUrl("http://" + server.getHostName() + ":" + server.getPort());

            try {
                testCloudantService.getSessionInformation().execute().getResult();
                fail("A ServiceResponseException should be thrown.");
            } catch (ServiceResponseException e) {
                assertEquals(e.getStatusCode(), 401, "The status code should be 401.");
                assertEquals(e.getMessage(), "unauthorized", "The error should be " +
                        "unauthorized.");
                assertEquals(e.getDebuggingInfo().get(
                        "reason"), "Name or password is incorrect.", "The reason should be as expected.");
            }
        }
    }

    /**
     * Test that an exception is thrown in the case there is no cookie returned.
     *
     * @throws Exception
     */
    @Test
    void requestTokenNoCookie() throws Exception {
        MockResponse sessionPostErrorResponse = new MockResponse()
                .setBody("{\"ok\": true}");
        try(MockWebServer server = new MockWebServer();) {
            server.start();
            server.getPort();
            server.enqueue(sessionPostErrorResponse);

            TestCloudantService testCloudantService = new TestCloudantService("test", testAuthenticator);
            testCloudantService.setServiceUrl("http://" + server.getHostName() + ":" + server.getPort());
            try {
                testCloudantService.getSessionInformation().execute().getResult();
                fail("A ServiceResponseException should be thrown.");
            } catch (ServiceResponseException e) {
                assertEquals(e.getStatusCode(), 200, "The status code should be 200.");
            }
        }
    }
}
