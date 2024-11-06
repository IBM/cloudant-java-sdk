package com.ibm.cloud.cloudant.internal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.function.Consumer;
import java.util.function.Function;
import org.testng.annotations.Test;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadDocumentOptions;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.GsonSingleton;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class CloudantErrorInterceptorTest {

  private static final String REQ_ID = "338da230c5";
  private static final String EXPECTED_ERROR = "test_error_name";
  private static final String EXPECTED_REASON = "test reason";
  private static final String MOCK_RESPONSE_BODY = "{\"error\":\"" + EXPECTED_ERROR+ "\",\"reason\":\"" + EXPECTED_REASON + "\"}";

  public void runTest(
        MockResponse mockResponse,
        Function<Cloudant, ?> serviceCall,
        Consumer<JsonObject> bodyAssertion
      ) throws Exception {
    try(MockWebServer server = new MockWebServer()) {
      server.start();
      server.enqueue(mockResponse);
      Cloudant cloudantService = new Cloudant("test", new NoAuthAuthenticator());
      cloudantService.setServiceUrl(server.url("/test/foo").toString());
      try {
        serviceCall.apply(cloudantService);
      } catch(ServiceResponseException sre) {
        JsonObject errorBody = null;
        String body = sre.getResponseBody();
        if (body != null) {
          errorBody = GsonSingleton.getGson().fromJson(body, JsonObject.class);
        }
        bodyAssertion.accept(errorBody);
      }
    }
  }

  class AssertAugment implements Consumer<JsonObject> {

    @Override
    public void accept(JsonObject actualErrorBody) {
      assertNotNull(actualErrorBody, "There should be a body.");
      assertTrue(actualErrorBody.has("errors"));
      JsonArray errors = actualErrorBody.getAsJsonArray("errors");
      assertEquals(1, errors.size());
      JsonObject error = errors.get(0).getAsJsonObject();
      assertTrue(error.has("code"));
      assertTrue(error.has("message"));
      assertEquals(error.get("code").getAsString(), EXPECTED_ERROR);
      assertEquals(error.get("message").getAsString(), EXPECTED_ERROR + ": " + EXPECTED_REASON);
      assertTrue(actualErrorBody.has("trace"));
      assertEquals(actualErrorBody.get("trace").getAsString(), REQ_ID);
    }

  }

  class AssertNoAugment implements Consumer<JsonObject> {

    @Override
    public void accept(JsonObject actualErrorBody) {
      assertNotNull(actualErrorBody, "There should be a body.");
      assertFalse(actualErrorBody.has("errors"));
      assertFalse(actualErrorBody.has("trace"));
    }
    
  }

  class AssertNoBody implements Consumer<JsonObject> {

    @Override
    public void accept(JsonObject actualErrorBody) {
      assertNull(actualErrorBody, "There should be no body.");
    }
    
  }

  @Test
  public void testDocumentNoError() throws Throwable {
    // Register a mock response
    MockResponse mockResponse = new MockResponse()
      .setHeader("Content-type", "application/json")
      .setHeader("x-couch-request-id", REQ_ID)
      .setResponseCode(200)
      .setBody("{\"_id\": \"foo\"}");

      GetDocumentOptions opts = new GetDocumentOptions.Builder()
      .db("test")
      .docId("foo")
      .build();

    runTest(mockResponse,
      c -> c.getDocument(opts).execute(),
      new AssertNoAugment());
  }

  @Test
  public void testDocumentError() throws Throwable {
    // Register a mock response
    MockResponse mockResponse = new MockResponse()
      .setHeader("Content-type", "application/json")
      .setHeader("x-couch-request-id", REQ_ID)
      .setResponseCode(444)
      .setBody(MOCK_RESPONSE_BODY);

      GetDocumentOptions opts = new GetDocumentOptions.Builder()
      .db("test")
      .docId("foo")
      .build();

    runTest(mockResponse,
      c -> c.getDocument(opts).execute(),
      new AssertAugment());
  }

  @Test
  public void testDocumentAsStreamError() throws Throwable {
    // Register a mock response
    
    MockResponse mockResponse = new MockResponse()
      .setHeader("Content-type", "application/json")
      .setHeader("x-couch-request-id", REQ_ID)
      .setResponseCode(444)
      .setChunkedBody(MOCK_RESPONSE_BODY, 1);

      GetDocumentOptions opts = new GetDocumentOptions.Builder()
      .db("test")
      .docId("foo")
      .build();

    runTest(mockResponse,
      c -> c.getDocumentAsStream(opts).execute(),
      new AssertAugment());
  }


  @Test
  public void testDocumentHeadError() throws Throwable {
    // Register a mock response
    MockResponse mockResponse = new MockResponse()
      .setHeader("Content-type", "application/json")
      .setHeader("x-couch-request-id", REQ_ID)
      .setResponseCode(444);

      HeadDocumentOptions opts = new HeadDocumentOptions.Builder()
      .db("test")
      .docId("foo")
      .build();

    runTest(mockResponse,
      c -> c.headDocument(opts).execute(),
      new AssertNoBody());
  }
}
