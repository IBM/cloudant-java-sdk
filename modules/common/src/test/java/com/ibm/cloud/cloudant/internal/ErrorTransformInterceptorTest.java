/**
 * © Copyright IBM Corporation 2024. All Rights Reserved.
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

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.EnumSet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ErrorTransformInterceptorTest {


    private static final String MOCK_ERROR = "test_error";
    private static final String MOCK_ERROR_K = "error";
    private static final String MOCK_REASON = "some test reason";
    private static final String MOCK_REASON_K = "reason";
    private static final String MOCK_COUCH_REQ_ID = "338da230c5";
    private static final String MOCK_REQ_ID = "455fe7724";
    private static final String MOCK_MALFORMED_RESPONSE;
    private static final String MOCK_EXPECTED_ERROR_REASON_RESPONSE;
    private static final String MOCK_EXPECTED_ERRORS_RESPONSE;
    private static final String MOCK_EXPECTED_NO_ERROR_RESPONSE;
    private static final String MOCK_EXPECTED_NO_REASON_RESPONSE;
    private static final String MOCK_EXPECTED_OK_RESPONSE;
    private static final String MOCK_EXISTING_TRACE_RESPONSE;
    private static final String MOCK_EXPECTED_ERROR_EMPTY_REASON_RESPONSE;

    static {
      JsonObject errorBody = new JsonObject();
      // Add an error
      errorBody.addProperty(MOCK_ERROR_K, MOCK_ERROR);
      MOCK_EXPECTED_NO_REASON_RESPONSE = errorBody.toString();

      errorBody.addProperty(MOCK_REASON_K, "");
      MOCK_EXPECTED_ERROR_EMPTY_REASON_RESPONSE = errorBody.toString();
      
      errorBody.remove(MOCK_REASON_K);
      errorBody.addProperty(MOCK_REASON_K, MOCK_REASON);
      MOCK_EXPECTED_ERROR_REASON_RESPONSE = errorBody.toString();

      errorBody.remove(MOCK_ERROR_K);
      MOCK_EXPECTED_NO_ERROR_RESPONSE = errorBody.toString();

      JsonObject okBody = new JsonObject();
      okBody.addProperty("ok", true);
      MOCK_EXPECTED_OK_RESPONSE = okBody.toString();

      JsonObject errorsBody = new JsonObject();
      errorsBody.addProperty(MOCK_ERROR_K, "wrong");
      errorsBody.addProperty(MOCK_REASON_K, "different");
      JsonArray errors = new JsonArray();
      JsonObject existingError = new JsonObject();
      existingError.addProperty("code", "not_found");
      existingError.addProperty("message", "not_found: Database does not exist.");
      errors.add(existingError);
      errorsBody.add("errors", errors);
      MOCK_EXPECTED_ERRORS_RESPONSE = errorsBody.toString();

      JsonObject traceBody = new JsonObject();
      traceBody.addProperty(MOCK_ERROR_K, "uhoh");
      traceBody.addProperty("trace", "45566afdec");
      MOCK_EXISTING_TRACE_RESPONSE = traceBody.toString();

      MOCK_MALFORMED_RESPONSE = MOCK_EXPECTED_ERROR_REASON_RESPONSE.substring(
        0, MOCK_EXPECTED_ERROR_REASON_RESPONSE.length() - 1);
    }

    private enum RequestIdHeader {
      XREQUEST,
      XCOUCH,
      BOTH,
      NONE
    }

    private enum Case {
      NO_AUGMENT_SUCCESS(200,
        "GET",
        MOCK_EXPECTED_OK_RESPONSE,
        RequestIdHeader.XCOUCH,
        null,
        null,
        null,
        "application/json"),
      NO_AUGMENT_REASON(444,
        "GET",
        MOCK_EXPECTED_NO_ERROR_RESPONSE,
        RequestIdHeader.NONE,
        null,
        null,
        null,
        "application/json"),
      AUGMENT_ERROR(444,
        "GET",
        MOCK_EXPECTED_NO_REASON_RESPONSE,
        RequestIdHeader.NONE,
        MOCK_ERROR,
        null,
        null,
        "application/json"),
      AUGMENT_ERROR_REASON(444,
        "GET",
        MOCK_EXPECTED_ERROR_REASON_RESPONSE,
        RequestIdHeader.NONE,
        MOCK_ERROR,
        MOCK_REASON,
        null,
        "application/json"),
      NO_AUGMENT_ID_ONLY(444,
        "GET",
        MOCK_EXPECTED_OK_RESPONSE,
        RequestIdHeader.XCOUCH,
        null,
        null,
        null,
        "application/json"),
      NO_AUGMENT_NO_ERROR(444,
        "GET",
        MOCK_EXPECTED_NO_ERROR_RESPONSE,
        RequestIdHeader.XCOUCH,
        null,
        null,
        null,
        "application/json"),
      AUGMENT_ERROR_WITH_TRACE(444,
        "GET",
        MOCK_EXPECTED_NO_REASON_RESPONSE,
        RequestIdHeader.XCOUCH,
        MOCK_ERROR,
        null,
        MOCK_COUCH_REQ_ID,
        "application/json"),
      AUGMENT_ERROR_REASON_WITH_TRACE(444,
        "GET",
        MOCK_EXPECTED_ERROR_REASON_RESPONSE,
        RequestIdHeader.XCOUCH,
        MOCK_ERROR,
        MOCK_REASON,
        MOCK_COUCH_REQ_ID,
        "application/json"),
      AUGMENT_ERROR_REASON_WITH_TRACE_REQUEST_ID(444,
        "GET",
        MOCK_EXPECTED_ERROR_REASON_RESPONSE,
        RequestIdHeader.XREQUEST,
        MOCK_ERROR,
        MOCK_REASON,
        MOCK_REQ_ID,
        "application/json"),
      AUGMENT_ERROR_REASON_WITH_TRACE_REQUEST_ID_PREFERRED(444,
        "GET",
        MOCK_EXPECTED_ERROR_REASON_RESPONSE,
        RequestIdHeader.BOTH,
        MOCK_ERROR,
        MOCK_REASON,
        MOCK_REQ_ID,
        "application/json"),
      NO_AUGMENT_EXISTING_TRACE(444,
        "GET",
        MOCK_EXISTING_TRACE_RESPONSE,
        RequestIdHeader.XCOUCH,
        null,
        null,
        "45566afdec",
        "application/json"),
      NO_AUGMENT_EXISTING_ERRORS_NO_ID(444,
        "GET",
        MOCK_EXPECTED_ERRORS_RESPONSE,
        RequestIdHeader.NONE,
        null,
        null,
        null,
        "application/json"),
      AUGMENT_TRACE_EXISTING_ERRORS(444,
        "GET",
        MOCK_EXPECTED_ERRORS_RESPONSE,
        RequestIdHeader.XCOUCH,
        null,
        null,
        MOCK_COUCH_REQ_ID,
        "application/json"),
      NO_AUGMENT_HEAD(444,
        "HEAD",
        null,
        RequestIdHeader.XCOUCH,
        null,
        null,
        null,
        "application/json"),
      NO_AUGMENT_NON_JSON(444,
        "GET",
        "text body",
        RequestIdHeader.XCOUCH,
        null,
        null,
        null,
        "text/plain"),
      NO_AUGMENT_NO_CONTENT_TYPE(444,
        "GET",
        MOCK_EXPECTED_ERROR_REASON_RESPONSE,
        RequestIdHeader.XCOUCH,
        null,
        null,
        null,
        null),
      NO_AUGMENT_MALFORMED_JSON(444,
        "GET",
        MOCK_MALFORMED_RESPONSE,
        RequestIdHeader.XCOUCH,
        null,
        null,
        null,
        "application/json"),
      AUGMENT_ERROR_EMPTY_REASON_WITH_TRACE(444,
        "GET",
        MOCK_EXPECTED_ERROR_EMPTY_REASON_RESPONSE,
        RequestIdHeader.XCOUCH,
        MOCK_ERROR,
        null,
        MOCK_COUCH_REQ_ID,
        "application/json");

      private final Response mockResponse;
      private final Request mockRequest;
      private final String responseBody;
      private final String errorToAssert;
      private final String reasonToAssert;
      private final String traceToAssert;

      Case(int statusCode,
            String httpMethod,
            String responseBody,
            RequestIdHeader idHeader,
            String errorToAssert,
            String reasonToAssert,
            String traceToAssert,
            String contentType) {
              this.responseBody = responseBody;
              this.errorToAssert = errorToAssert;
              this.reasonToAssert = reasonToAssert;
              this.traceToAssert = traceToAssert;
        mockRequest = new Request.Builder()
          .url("https://test.example")
          .method(httpMethod, null)
          .build();
        // Make a response
        Response.Builder responseBuilder = new Response.Builder()
          .protocol(Protocol.HTTP_2)
          .code(statusCode)
          .message("status_line")
          .request(mockRequest);
        // Make a response body
        if (responseBody != null) {
          MediaType bodyContentType = (contentType != null) ? MediaType.parse(contentType) : null;
          responseBuilder.body(ResponseBody.create(responseBody, bodyContentType));
        }
        // Add the header if needed
        switch(idHeader) {
          case XCOUCH:
            responseBuilder.header("x-couch-request-id", MOCK_COUCH_REQ_ID);
            break;
          case XREQUEST:
            responseBuilder.header("x-request-id", MOCK_REQ_ID);
            break;
          case BOTH:
            responseBuilder.header("x-couch-request-id", MOCK_COUCH_REQ_ID);
            responseBuilder.header("x-request-id", MOCK_REQ_ID);
          case NONE:
          default:
            break;
        }
        mockResponse = responseBuilder.build();
      }

      void runTest(Interceptor interceptor) throws IOException {
        Response r = interceptor.intercept(mockChain(mockRequest, mockResponse));
        if (errorToAssert != null || traceToAssert != null) {
          JsonObject actualErrorBody = GsonSingleton.getGson().fromJson(
            r.body().string(), JsonObject.class);
          if (errorToAssert != null) {
            StringBuilder expectedMessage = new StringBuilder(errorToAssert);
            assertEquals(actualErrorBody.get("error").getAsString(), errorToAssert);
            if (reasonToAssert != null) {
              expectedMessage.append(": ");
              expectedMessage.append(reasonToAssert);
              assertEquals(actualErrorBody.get("reason").getAsString(), reasonToAssert);
            }
            assertTrue(actualErrorBody.has("errors"), "There should be an errors array present.");
            JsonArray errorsArray = actualErrorBody.get("errors").getAsJsonArray();
            assertEquals(errorsArray.size(), 1);
            JsonObject errorItem = errorsArray.get(0).getAsJsonObject();
            assertEquals(errorItem.get("code").getAsString(), errorToAssert);
            assertEquals(errorItem.get("message").getAsString(), expectedMessage.toString());
          } else {
            // If the response body already had errors then it will still have it
            if (!responseBody.contains("errors")) {
              assertFalse(actualErrorBody.has("errors"), "There should not be an errors array present.");
            }
          }
          if (traceToAssert != null) {
            assertTrue(actualErrorBody.has("trace"), "There should be a trace element present.");
            assertEquals(actualErrorBody.get("trace").getAsString(), traceToAssert);
          } else {
            assertFalse(actualErrorBody.has("trace"), "There should not be a trace element present.");
          }
        } else {
          // If we aren't asserting a specific part of augment check the body is unchanged
          if ("HEAD" == r.request().method()) {
            assertNull(r.body());
          } else {
            assertEquals(r.body().string(), responseBody); 
          }
        }
      }

      @DataProvider(name = "cases")
      public static Iterator<Case> parameters() {
        return EnumSet.allOf(Case.class).iterator();
      }
    }

    private ErrorTransformInterceptor interceptor;

    @BeforeTest
    public void setUp() throws IOException {
        // Initialize the custom error interceptor
        interceptor = new ErrorTransformInterceptor();
    }

    @AfterTest
    void tearDown() throws IOException {
      interceptor = null;
    }

    public static Chain mockChain(Request req, Response resp) {
      return (Chain) Proxy.newProxyInstance(
        ErrorTransformInterceptorTest.class.getClassLoader(),
        new Class[]{Chain.class},
        new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          switch (method.getName()) {
            case "proceed":
              return resp;
            case "request":
              return req;
            default:
              throw new UnsupportedOperationException("Mock does not implement method " + method.getName());
          }
        }
      });
  }

  @Test(dataProvider = "cases", dataProviderClass = Case.class)
  public void testInterceptor(Case c) throws Exception {
    c.runTest(interceptor);
  }

  private void countExpectedInterceptors(CloudantBaseService service) {
    int count = 0;
    for (Interceptor interceptor : service.getClient().interceptors()) {
      if (interceptor instanceof ErrorTransformInterceptor) {
        count++;
      }
    }
    assertEquals(count, 1);
  }
  @Test
  public void testSetClientWithInterceptor() throws Throwable {
    CloudantBaseService cloudantService = new CloudantBaseService("test", new NoAuthAuthenticator()) {};
    cloudantService.setClient(cloudantService.getClient());
    countExpectedInterceptors(cloudantService);
  }

  @Test
  public void testSetClientWithNoInterceptor() throws Throwable {
    CloudantBaseService cloudantService = new CloudantBaseService("test", new NoAuthAuthenticator()) {};
    OkHttpClient newClient = new OkHttpClient();
    cloudantService.setClient(newClient);
    countExpectedInterceptors(cloudantService);
  }
}
