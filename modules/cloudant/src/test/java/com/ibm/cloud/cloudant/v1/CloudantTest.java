/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.cloudant.v1;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ActiveTask;
import com.ibm.cloud.cloudant.v1.model.ActivityTrackerEvents;
import com.ibm.cloud.cloudant.v1.model.AllDocsQueriesResult;
import com.ibm.cloud.cloudant.v1.model.AllDocsQuery;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.Analyzer;
import com.ibm.cloud.cloudant.v1.model.AnalyzerConfiguration;
import com.ibm.cloud.cloudant.v1.model.ApiKeysResult;
import com.ibm.cloud.cloudant.v1.model.Attachment;
import com.ibm.cloud.cloudant.v1.model.BulkDocs;
import com.ibm.cloud.cloudant.v1.model.BulkGetQueryDocument;
import com.ibm.cloud.cloudant.v1.model.BulkGetResult;
import com.ibm.cloud.cloudant.v1.model.BulkGetResultDocument;
import com.ibm.cloud.cloudant.v1.model.BulkGetResultItem;
import com.ibm.cloud.cloudant.v1.model.CapacityThroughputInformation;
import com.ibm.cloud.cloudant.v1.model.CapacityThroughputInformationCurrent;
import com.ibm.cloud.cloudant.v1.model.CapacityThroughputInformationTarget;
import com.ibm.cloud.cloudant.v1.model.Change;
import com.ibm.cloud.cloudant.v1.model.ChangesResult;
import com.ibm.cloud.cloudant.v1.model.ChangesResultItem;
import com.ibm.cloud.cloudant.v1.model.ContentInformationSizes;
import com.ibm.cloud.cloudant.v1.model.CorsInformation;
import com.ibm.cloud.cloudant.v1.model.CurrentThroughputInformation;
import com.ibm.cloud.cloudant.v1.model.CurrentThroughputInformationThroughput;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformation;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformationCluster;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformationProps;
import com.ibm.cloud.cloudant.v1.model.DbEvent;
import com.ibm.cloud.cloudant.v1.model.DbUpdates;
import com.ibm.cloud.cloudant.v1.model.DbsInfoResult;
import com.ibm.cloud.cloudant.v1.model.DeleteAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteDatabaseOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteIndexOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DesignDocument;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentInformation;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentViewIndex;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentViewsMapReduce;
import com.ibm.cloud.cloudant.v1.model.DocsResultRow;
import com.ibm.cloud.cloudant.v1.model.DocsResultRowValue;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.DocumentRevisionStatus;
import com.ibm.cloud.cloudant.v1.model.DocumentShardInfo;
import com.ibm.cloud.cloudant.v1.model.ExecutionStats;
import com.ibm.cloud.cloudant.v1.model.ExplainResult;
import com.ibm.cloud.cloudant.v1.model.ExplainResultRange;
import com.ibm.cloud.cloudant.v1.model.FindResult;
import com.ibm.cloud.cloudant.v1.model.GeoIndexDefinition;
import com.ibm.cloud.cloudant.v1.model.GeoIndexInformation;
import com.ibm.cloud.cloudant.v1.model.GeoIndexStats;
import com.ibm.cloud.cloudant.v1.model.GeoJsonFeature;
import com.ibm.cloud.cloudant.v1.model.GeoJsonGeometry;
import com.ibm.cloud.cloudant.v1.model.GeoJsonGeometryCollection;
import com.ibm.cloud.cloudant.v1.model.GeoJsonGeometryObject;
import com.ibm.cloud.cloudant.v1.model.GeoResult;
import com.ibm.cloud.cloudant.v1.model.GeoResultRow;
import com.ibm.cloud.cloudant.v1.model.GetActiveTasksOptions;
import com.ibm.cloud.cloudant.v1.model.GetActivityTrackerEventsOptions;
import com.ibm.cloud.cloudant.v1.model.GetAllDbsOptions;
import com.ibm.cloud.cloudant.v1.model.GetAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.GetCapacityThroughputInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetCorsInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetCurrentThroughputInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetDbUpdatesOptions;
import com.ibm.cloud.cloudant.v1.model.GetDesignDocumentInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetDocumentShardsInfoOptions;
import com.ibm.cloud.cloudant.v1.model.GetGeoIndexInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetGeoOptions;
import com.ibm.cloud.cloudant.v1.model.GetIndexesInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetMembershipInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetPartitionInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerDocsOptions;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerJobOptions;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerJobsOptions;
import com.ibm.cloud.cloudant.v1.model.GetSearchInfoOptions;
import com.ibm.cloud.cloudant.v1.model.GetSecurityOptions;
import com.ibm.cloud.cloudant.v1.model.GetServerInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetSessionInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetShardsInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetUpInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetUuidsOptions;
import com.ibm.cloud.cloudant.v1.model.HeadAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadDatabaseOptions;
import com.ibm.cloud.cloudant.v1.model.HeadDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadSchedulerDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadSchedulerJobOptions;
import com.ibm.cloud.cloudant.v1.model.HeadUpInformationOptions;
import com.ibm.cloud.cloudant.v1.model.IndexDefinition;
import com.ibm.cloud.cloudant.v1.model.IndexField;
import com.ibm.cloud.cloudant.v1.model.IndexInformation;
import com.ibm.cloud.cloudant.v1.model.IndexResult;
import com.ibm.cloud.cloudant.v1.model.IndexTextOperatorDefaultField;
import com.ibm.cloud.cloudant.v1.model.IndexesInformation;
import com.ibm.cloud.cloudant.v1.model.MembershipInformation;
import com.ibm.cloud.cloudant.v1.model.MissingRevsResult;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PartitionInformation;
import com.ibm.cloud.cloudant.v1.model.PartitionInformationIndexes;
import com.ibm.cloud.cloudant.v1.model.PartitionInformationIndexesIndexes;
import com.ibm.cloud.cloudant.v1.model.PartitionInformationSizes;
import com.ibm.cloud.cloudant.v1.model.PostActivityTrackerEventsOptions;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsQueriesOptions;
import com.ibm.cloud.cloudant.v1.model.PostApiKeysOptions;
import com.ibm.cloud.cloudant.v1.model.PostBulkDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostBulkGetOptions;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
import com.ibm.cloud.cloudant.v1.model.PostDbsInfoOptions;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsQueriesOptions;
import com.ibm.cloud.cloudant.v1.model.PostDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PostExplainOptions;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostGeoCleanupOptions;
import com.ibm.cloud.cloudant.v1.model.PostIndexOptions;
import com.ibm.cloud.cloudant.v1.model.PostMissingRevsOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostRevsDiffOptions;
import com.ibm.cloud.cloudant.v1.model.PostSearchAnalyzeOptions;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewQueriesOptions;
import com.ibm.cloud.cloudant.v1.model.PutAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.PutCapacityThroughputConfigurationOptions;
import com.ibm.cloud.cloudant.v1.model.PutCloudantSecurityConfigurationOptions;
import com.ibm.cloud.cloudant.v1.model.PutCorsConfigurationOptions;
import com.ibm.cloud.cloudant.v1.model.PutDatabaseOptions;
import com.ibm.cloud.cloudant.v1.model.PutDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutSecurityOptions;
import com.ibm.cloud.cloudant.v1.model.ReplicationCreateTargetParameters;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabase;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuth;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthIam;
import com.ibm.cloud.cloudant.v1.model.ReplicationDocument;
import com.ibm.cloud.cloudant.v1.model.Revisions;
import com.ibm.cloud.cloudant.v1.model.RevsDiff;
import com.ibm.cloud.cloudant.v1.model.SchedulerDocsResult;
import com.ibm.cloud.cloudant.v1.model.SchedulerDocument;
import com.ibm.cloud.cloudant.v1.model.SchedulerInfo;
import com.ibm.cloud.cloudant.v1.model.SchedulerJob;
import com.ibm.cloud.cloudant.v1.model.SchedulerJobEvent;
import com.ibm.cloud.cloudant.v1.model.SchedulerJobsResult;
import com.ibm.cloud.cloudant.v1.model.SearchAnalyzeResult;
import com.ibm.cloud.cloudant.v1.model.SearchIndexDefinition;
import com.ibm.cloud.cloudant.v1.model.SearchIndexInfo;
import com.ibm.cloud.cloudant.v1.model.SearchInfoResult;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
import com.ibm.cloud.cloudant.v1.model.SearchResultProperties;
import com.ibm.cloud.cloudant.v1.model.SearchResultRow;
import com.ibm.cloud.cloudant.v1.model.Security;
import com.ibm.cloud.cloudant.v1.model.SecurityObject;
import com.ibm.cloud.cloudant.v1.model.ServerInformation;
import com.ibm.cloud.cloudant.v1.model.ServerVendor;
import com.ibm.cloud.cloudant.v1.model.SessionAuthentication;
import com.ibm.cloud.cloudant.v1.model.SessionInformation;
import com.ibm.cloud.cloudant.v1.model.ShardsInformation;
import com.ibm.cloud.cloudant.v1.model.ThroughputInformation;
import com.ibm.cloud.cloudant.v1.model.UpInformation;
import com.ibm.cloud.cloudant.v1.model.UserContext;
import com.ibm.cloud.cloudant.v1.model.UuidsResult;
import com.ibm.cloud.cloudant.v1.model.ViewQueriesResult;
import com.ibm.cloud.cloudant.v1.model.ViewQuery;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
import com.ibm.cloud.cloudant.v1.model.ViewResultRow;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Cloudant service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class CloudantTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected Cloudant cloudantService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    cloudantService = Cloudant.newInstance(serviceName);
    String url = server.url("/").toString();
    cloudantService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new Cloudant(serviceName, null);
  }

  @Test
  public void testGetServerInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"couchdb\": \"couchdb\", \"features\": [\"features\"], \"vendor\": {\"name\": \"name\", \"variant\": \"variant\", \"version\": \"version\"}, \"version\": \"version\", \"features_flags\": [\"featuresFlags\"]}";
    String getServerInformationPath = "/";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetServerInformationOptions model
    GetServerInformationOptions getServerInformationOptionsModel = new GetServerInformationOptions();

    // Invoke operation with valid options model (positive test)
    Response<ServerInformation> response = cloudantService.getServerInformation(getServerInformationOptionsModel).execute();
    assertNotNull(response);
    ServerInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getServerInformationPath);
  }

  @Test
  public void testGetMembershipInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"all_nodes\": [\"allNodes\"], \"cluster_nodes\": [\"clusterNodes\"]}";
    String getMembershipInformationPath = "/_membership";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetMembershipInformationOptions model
    GetMembershipInformationOptions getMembershipInformationOptionsModel = new GetMembershipInformationOptions();

    // Invoke operation with valid options model (positive test)
    Response<MembershipInformation> response = cloudantService.getMembershipInformation(getMembershipInformationOptionsModel).execute();
    assertNotNull(response);
    MembershipInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMembershipInformationPath);
  }

  @Test
  public void testGetUuidsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"uuids\": [\"uuids\"]}";
    String getUuidsPath = "/_uuids";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetUuidsOptions model
    GetUuidsOptions getUuidsOptionsModel = new GetUuidsOptions.Builder()
    .count(Long.valueOf("1"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<UuidsResult> response = cloudantService.getUuids(getUuidsOptionsModel).execute();
    assertNotNull(response);
    UuidsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("1"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getUuidsPath);
  }

  @Test
  public void testGetCapacityThroughputInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"current\": {\"throughput\": {\"blocks\": 0, \"query\": 0, \"read\": 0, \"write\": 0}}, \"target\": {\"throughput\": {\"blocks\": 0, \"query\": 0, \"read\": 0, \"write\": 0}}}";
    String getCapacityThroughputInformationPath = "/_api/v2/user/capacity/throughput";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCapacityThroughputInformationOptions model
    GetCapacityThroughputInformationOptions getCapacityThroughputInformationOptionsModel = new GetCapacityThroughputInformationOptions();

    // Invoke operation with valid options model (positive test)
    Response<CapacityThroughputInformation> response = cloudantService.getCapacityThroughputInformation(getCapacityThroughputInformationOptionsModel).execute();
    assertNotNull(response);
    CapacityThroughputInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCapacityThroughputInformationPath);
  }

  @Test
  public void testPutCapacityThroughputConfigurationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"current\": {\"throughput\": {\"blocks\": 0, \"query\": 0, \"read\": 0, \"write\": 0}}, \"target\": {\"throughput\": {\"blocks\": 0, \"query\": 0, \"read\": 0, \"write\": 0}}}";
    String putCapacityThroughputConfigurationPath = "/_api/v2/user/capacity/throughput";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PutCapacityThroughputConfigurationOptions model
    PutCapacityThroughputConfigurationOptions putCapacityThroughputConfigurationOptionsModel = new PutCapacityThroughputConfigurationOptions.Builder()
    .blocks(Long.valueOf("0"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CapacityThroughputInformation> response = cloudantService.putCapacityThroughputConfiguration(putCapacityThroughputConfigurationOptionsModel).execute();
    assertNotNull(response);
    CapacityThroughputInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putCapacityThroughputConfigurationPath);
  }

  // Test the putCapacityThroughputConfiguration operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutCapacityThroughputConfigurationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putCapacityThroughputConfiguration(null).execute();
  }

  @Test
  public void testGetDbUpdatesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"last_seq\": \"lastSeq\", \"results\": [{\"account\": \"account\", \"db_name\": \"dbName\", \"seq\": \"seq\", \"type\": \"created\"}]}";
    String getDbUpdatesPath = "/_db_updates";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDbUpdatesOptions model
    GetDbUpdatesOptions getDbUpdatesOptionsModel = new GetDbUpdatesOptions.Builder()
    .feed("normal")
    .heartbeat(Long.valueOf("0"))
    .timeout(Long.valueOf("0"))
    .since("0")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DbUpdates> response = cloudantService.getDbUpdates(getDbUpdatesOptionsModel).execute();
    assertNotNull(response);
    DbUpdates responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("feed"), "normal");
    assertEquals(Long.valueOf(query.get("heartbeat")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("0"));
    assertEquals(query.get("since"), "0");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDbUpdatesPath);
  }

  @Test
  public void testPostChangesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"last_seq\": \"lastSeq\", \"pending\": 7, \"results\": [{\"changes\": [{\"rev\": \"rev\"}], \"deleted\": false, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"seq\": \"seq\"}]}";
    String postChangesPath = "/testString/_changes";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostChangesOptions model
    PostChangesOptions postChangesOptionsModel = new PostChangesOptions.Builder()
    .db("testString")
    .docIds(new java.util.ArrayList<String>(java.util.Arrays.asList("0007741142412418284")))
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .lastEventId("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .feed("normal")
    .filter("testString")
    .heartbeat(Long.valueOf("0"))
    .includeDocs(false)
    .limit(Long.valueOf("0"))
    .seqInterval(Long.valueOf("1"))
    .since("0")
    .style("main_only")
    .timeout(Long.valueOf("0"))
    .view("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ChangesResult> response = cloudantService.postChanges(postChangesOptionsModel).execute();
    assertNotNull(response);
    ChangesResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("descending")), Boolean.valueOf(false));
    assertEquals(query.get("feed"), "normal");
    assertEquals(query.get("filter"), "testString");
    assertEquals(Long.valueOf(query.get("heartbeat")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("include_docs")), Boolean.valueOf(false));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("seq_interval")), Long.valueOf("1"));
    assertEquals(query.get("since"), "0");
    assertEquals(query.get("style"), "main_only");
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("0"));
    assertEquals(query.get("view"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postChangesPath);
  }

  // Test the postChanges operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostChangesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postChanges(null).execute();
  }

  @Test
  public void testPostChangesAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postChangesAsStreamPath = "/testString/_changes";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostChangesOptions model
    PostChangesOptions postChangesOptionsModel = new PostChangesOptions.Builder()
    .db("testString")
    .docIds(new java.util.ArrayList<String>(java.util.Arrays.asList("0007741142412418284")))
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .lastEventId("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .feed("normal")
    .filter("testString")
    .heartbeat(Long.valueOf("0"))
    .includeDocs(false)
    .limit(Long.valueOf("0"))
    .seqInterval(Long.valueOf("1"))
    .since("0")
    .style("main_only")
    .timeout(Long.valueOf("0"))
    .view("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postChangesAsStream(postChangesOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("descending")), Boolean.valueOf(false));
    assertEquals(query.get("feed"), "normal");
    assertEquals(query.get("filter"), "testString");
    assertEquals(Long.valueOf(query.get("heartbeat")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("include_docs")), Boolean.valueOf(false));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("seq_interval")), Long.valueOf("1"));
    assertEquals(query.get("since"), "0");
    assertEquals(query.get("style"), "main_only");
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("0"));
    assertEquals(query.get("view"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postChangesAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postChangesAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostChangesAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postChangesAsStream(null).execute();
  }

  @Test
  public void testHeadDatabaseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String headDatabasePath = "/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the HeadDatabaseOptions model
    HeadDatabaseOptions headDatabaseOptionsModel = new HeadDatabaseOptions.Builder()
    .db("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = cloudantService.headDatabase(headDatabaseOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headDatabasePath);
  }

  // Test the headDatabase operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadDatabaseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.headDatabase(null).execute();
  }

  @Test
  public void testGetAllDbsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[\"operationResponse\"]";
    String getAllDbsPath = "/_all_dbs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAllDbsOptions model
    GetAllDbsOptions getAllDbsOptionsModel = new GetAllDbsOptions.Builder()
    .descending(false)
    .endkey("testString")
    .limit(Long.valueOf("0"))
    .skip(Long.valueOf("0"))
    .startkey("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<String>> response = cloudantService.getAllDbs(getAllDbsOptionsModel).execute();
    assertNotNull(response);
    List<String> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("descending")), Boolean.valueOf(false));
    assertEquals(query.get("endkey"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("0"));
    assertEquals(query.get("startkey"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAllDbsPath);
  }

  @Test
  public void testPostDbsInfoWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"info\": {\"cluster\": {\"n\": 1, \"q\": 1, \"r\": 1, \"w\": 1}, \"committed_update_seq\": \"committedUpdateSeq\", \"compact_running\": true, \"compacted_seq\": \"compactedSeq\", \"db_name\": \"dbName\", \"disk_format_version\": 17, \"doc_count\": 0, \"doc_del_count\": 0, \"engine\": \"engine\", \"props\": {\"partitioned\": false}, \"sizes\": {\"active\": 6, \"external\": 8, \"file\": 4}, \"update_seq\": \"updateSeq\", \"uuid\": \"uuid\"}, \"key\": \"key\"}]";
    String postDbsInfoPath = "/_dbs_info";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostDbsInfoOptions model
    PostDbsInfoOptions postDbsInfoOptionsModel = new PostDbsInfoOptions.Builder()
    .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<DbsInfoResult>> response = cloudantService.postDbsInfo(postDbsInfoOptionsModel).execute();
    assertNotNull(response);
    List<DbsInfoResult> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postDbsInfoPath);
  }

  // Test the postDbsInfo operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDbsInfoNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postDbsInfo(null).execute();
  }

  @Test
  public void testDeleteDatabaseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true}";
    String deleteDatabasePath = "/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteDatabaseOptions model
    DeleteDatabaseOptions deleteDatabaseOptionsModel = new DeleteDatabaseOptions.Builder()
    .db("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Ok> response = cloudantService.deleteDatabase(deleteDatabaseOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDatabasePath);
  }

  // Test the deleteDatabase operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDatabaseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.deleteDatabase(null).execute();
  }

  @Test
  public void testGetDatabaseInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"cluster\": {\"n\": 1, \"q\": 1, \"r\": 1, \"w\": 1}, \"committed_update_seq\": \"committedUpdateSeq\", \"compact_running\": true, \"compacted_seq\": \"compactedSeq\", \"db_name\": \"dbName\", \"disk_format_version\": 17, \"doc_count\": 0, \"doc_del_count\": 0, \"engine\": \"engine\", \"props\": {\"partitioned\": false}, \"sizes\": {\"active\": 6, \"external\": 8, \"file\": 4}, \"update_seq\": \"updateSeq\", \"uuid\": \"uuid\"}";
    String getDatabaseInformationPath = "/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDatabaseInformationOptions model
    GetDatabaseInformationOptions getDatabaseInformationOptionsModel = new GetDatabaseInformationOptions.Builder()
    .db("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DatabaseInformation> response = cloudantService.getDatabaseInformation(getDatabaseInformationOptionsModel).execute();
    assertNotNull(response);
    DatabaseInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDatabaseInformationPath);
  }

  // Test the getDatabaseInformation operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDatabaseInformationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getDatabaseInformation(null).execute();
  }

  @Test
  public void testPutDatabaseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true}";
    String putDatabasePath = "/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PutDatabaseOptions model
    PutDatabaseOptions putDatabaseOptionsModel = new PutDatabaseOptions.Builder()
    .db("testString")
    .partitioned(false)
    .q(Long.valueOf("1"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Ok> response = cloudantService.putDatabase(putDatabaseOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("partitioned")), Boolean.valueOf(false));
    assertEquals(Long.valueOf(query.get("q")), Long.valueOf("1"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putDatabasePath);
  }

  // Test the putDatabase operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutDatabaseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putDatabase(null).execute();
  }

  @Test
  public void testHeadDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String headDocumentPath = "/testString/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the HeadDocumentOptions model
    HeadDocumentOptions headDocumentOptionsModel = new HeadDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .ifNoneMatch("testString")
    .latest(false)
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = cloudantService.headDocument(headDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headDocumentPath);
  }

  // Test the headDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.headDocument(null).execute();
  }

  @Test
  public void testPostDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String postDocumentPath = "/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
    .contentType("testString")
    .data(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .digest("testString")
    .encodedLength(Long.valueOf("0"))
    .encoding("testString")
    .follows(true)
    .length(Long.valueOf("0"))
    .revpos(Long.valueOf("1"))
    .stub(true)
    .build();

    // Construct an instance of the Revisions model
    Revisions revisionsModel = new Revisions.Builder()
    .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .start(Long.valueOf("1"))
    .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
    .rev("testString")
    .status("available")
    .build();

    // Construct an instance of the Document model
    Document documentModel = new Document.Builder()
    .attachments(new java.util.HashMap<String, Attachment>() { { put("foo", attachmentModel); } })
    .conflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .deleted(true)
    .deletedConflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .id("testString")
    .localSeq("testString")
    .rev("testString")
    .revisions(revisionsModel)
    .revsInfo(new java.util.ArrayList<DocumentRevisionStatus>(java.util.Arrays.asList(documentRevisionStatusModel)))
    .add("foo", "testString")
    .build();

    // Construct an instance of the PostDocumentOptions model
    PostDocumentOptions postDocumentOptionsModel = new PostDocumentOptions.Builder()
    .db("testString")
    .document(documentModel)
    .contentType("application/json")
    .batch("ok")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.postDocument(postDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("batch"), "ok");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postDocumentPath);
  }

  // Test the postDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postDocument(null).execute();
  }

  @Test
  public void testPostAllDocsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}";
    String postAllDocsPath = "/testString/_all_docs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostAllDocsOptions model
    PostAllDocsOptions postAllDocsOptionsModel = new PostAllDocsOptions.Builder()
    .db("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(false)
    .inclusiveEnd(true)
    .limit(Long.valueOf("10"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .key("testString")
    .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .startkey("0007741142412418284")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AllDocsResult> response = cloudantService.postAllDocs(postAllDocsOptionsModel).execute();
    assertNotNull(response);
    AllDocsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postAllDocsPath);
  }

  // Test the postAllDocs operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostAllDocsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postAllDocs(null).execute();
  }

  @Test
  public void testPostAllDocsAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postAllDocsAsStreamPath = "/testString/_all_docs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostAllDocsOptions model
    PostAllDocsOptions postAllDocsOptionsModel = new PostAllDocsOptions.Builder()
    .db("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(false)
    .inclusiveEnd(true)
    .limit(Long.valueOf("10"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .key("testString")
    .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .startkey("0007741142412418284")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postAllDocsAsStream(postAllDocsOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postAllDocsAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postAllDocsAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostAllDocsAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postAllDocsAsStream(null).execute();
  }

  @Test
  public void testPostAllDocsQueriesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"results\": [{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}]}";
    String postAllDocsQueriesPath = "/testString/_all_docs/queries";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AllDocsQuery model
    AllDocsQuery allDocsQueryModel = new AllDocsQuery.Builder()
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(false)
    .inclusiveEnd(true)
    .limit(Long.valueOf("0"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .key("testString")
    .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("small-appliances:1000042", "small-appliances:1000043")))
    .startkey("testString")
    .build();

    // Construct an instance of the PostAllDocsQueriesOptions model
    PostAllDocsQueriesOptions postAllDocsQueriesOptionsModel = new PostAllDocsQueriesOptions.Builder()
    .db("testString")
    .queries(new java.util.ArrayList<AllDocsQuery>(java.util.Arrays.asList(allDocsQueryModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AllDocsQueriesResult> response = cloudantService.postAllDocsQueries(postAllDocsQueriesOptionsModel).execute();
    assertNotNull(response);
    AllDocsQueriesResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postAllDocsQueriesPath);
  }

  // Test the postAllDocsQueries operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostAllDocsQueriesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postAllDocsQueries(null).execute();
  }

  @Test
  public void testPostAllDocsQueriesAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postAllDocsQueriesAsStreamPath = "/testString/_all_docs/queries";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AllDocsQuery model
    AllDocsQuery allDocsQueryModel = new AllDocsQuery.Builder()
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(false)
    .inclusiveEnd(true)
    .limit(Long.valueOf("0"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .key("testString")
    .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("small-appliances:1000042", "small-appliances:1000043")))
    .startkey("testString")
    .build();

    // Construct an instance of the PostAllDocsQueriesOptions model
    PostAllDocsQueriesOptions postAllDocsQueriesOptionsModel = new PostAllDocsQueriesOptions.Builder()
    .db("testString")
    .queries(new java.util.ArrayList<AllDocsQuery>(java.util.Arrays.asList(allDocsQueryModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postAllDocsQueriesAsStream(postAllDocsQueriesOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postAllDocsQueriesAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postAllDocsQueriesAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostAllDocsQueriesAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postAllDocsQueriesAsStream(null).execute();
  }

  @Test
  public void testPostBulkDocsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}]";
    String postBulkDocsPath = "/testString/_bulk_docs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
    .contentType("testString")
    .data(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .digest("testString")
    .encodedLength(Long.valueOf("0"))
    .encoding("testString")
    .follows(true)
    .length(Long.valueOf("0"))
    .revpos(Long.valueOf("1"))
    .stub(true)
    .build();

    // Construct an instance of the Revisions model
    Revisions revisionsModel = new Revisions.Builder()
    .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .start(Long.valueOf("1"))
    .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
    .rev("testString")
    .status("available")
    .build();

    // Construct an instance of the Document model
    Document documentModel = new Document.Builder()
    .attachments(new java.util.HashMap<String, Attachment>() { { put("foo", attachmentModel); } })
    .conflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .deleted(true)
    .deletedConflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .id("testString")
    .localSeq("testString")
    .rev("testString")
    .revisions(revisionsModel)
    .revsInfo(new java.util.ArrayList<DocumentRevisionStatus>(java.util.Arrays.asList(documentRevisionStatusModel)))
    .add("foo", "testString")
    .build();

    // Construct an instance of the BulkDocs model
    BulkDocs bulkDocsModel = new BulkDocs.Builder()
    .docs(new java.util.ArrayList<Document>(java.util.Arrays.asList(documentModel)))
    .newEdits(true)
    .build();

    // Construct an instance of the PostBulkDocsOptions model
    PostBulkDocsOptions postBulkDocsOptionsModel = new PostBulkDocsOptions.Builder()
    .db("testString")
    .bulkDocs(bulkDocsModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<DocumentResult>> response = cloudantService.postBulkDocs(postBulkDocsOptionsModel).execute();
    assertNotNull(response);
    List<DocumentResult> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkDocsPath);
  }

  // Test the postBulkDocs operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkDocsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postBulkDocs(null).execute();
  }

  @Test
  public void testPostBulkGetWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"results\": [{\"docs\": [{\"error\": {\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}, \"ok\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}}], \"id\": \"id\"}]}";
    String postBulkGetPath = "/testString/_bulk_get";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the BulkGetQueryDocument model
    BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
    .attsSince(new java.util.ArrayList<String>(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8")))
    .id("order00067")
    .rev("3-917fa2381192822767f010b95b45325b")
    .build();

    // Construct an instance of the PostBulkGetOptions model
    PostBulkGetOptions postBulkGetOptionsModel = new PostBulkGetOptions.Builder()
    .db("testString")
    .docs(new java.util.ArrayList<BulkGetQueryDocument>(java.util.Arrays.asList(bulkGetQueryDocumentModel)))
    .attachments(false)
    .attEncodingInfo(false)
    .latest(false)
    .revs(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<BulkGetResult> response = cloudantService.postBulkGet(postBulkGetOptionsModel).execute();
    assertNotNull(response);
    BulkGetResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkGetPath);
  }

  // Test the postBulkGet operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkGetNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postBulkGet(null).execute();
  }

  @Test
  public void testPostBulkGetAsMixedWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String postBulkGetAsMixedPath = "/testString/_bulk_get";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "multipart/mixed")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the BulkGetQueryDocument model
    BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
    .attsSince(new java.util.ArrayList<String>(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8")))
    .id("order00067")
    .rev("3-917fa2381192822767f010b95b45325b")
    .build();

    // Construct an instance of the PostBulkGetOptions model
    PostBulkGetOptions postBulkGetOptionsModel = new PostBulkGetOptions.Builder()
    .db("testString")
    .docs(new java.util.ArrayList<BulkGetQueryDocument>(java.util.Arrays.asList(bulkGetQueryDocumentModel)))
    .attachments(false)
    .attEncodingInfo(false)
    .latest(false)
    .revs(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postBulkGetAsMixed(postBulkGetOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkGetAsMixedPath);
  }

  // Test the postBulkGetAsMixed operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkGetAsMixedNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postBulkGetAsMixed(null).execute();
  }

  @Test
  public void testPostBulkGetAsRelatedWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String postBulkGetAsRelatedPath = "/testString/_bulk_get";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "multipart/related")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the BulkGetQueryDocument model
    BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
    .attsSince(new java.util.ArrayList<String>(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8")))
    .id("order00067")
    .rev("3-917fa2381192822767f010b95b45325b")
    .build();

    // Construct an instance of the PostBulkGetOptions model
    PostBulkGetOptions postBulkGetOptionsModel = new PostBulkGetOptions.Builder()
    .db("testString")
    .docs(new java.util.ArrayList<BulkGetQueryDocument>(java.util.Arrays.asList(bulkGetQueryDocumentModel)))
    .attachments(false)
    .attEncodingInfo(false)
    .latest(false)
    .revs(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postBulkGetAsRelated(postBulkGetOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkGetAsRelatedPath);
  }

  // Test the postBulkGetAsRelated operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkGetAsRelatedNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postBulkGetAsRelated(null).execute();
  }

  @Test
  public void testPostBulkGetAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postBulkGetAsStreamPath = "/testString/_bulk_get";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the BulkGetQueryDocument model
    BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
    .attsSince(new java.util.ArrayList<String>(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8")))
    .id("order00067")
    .rev("3-917fa2381192822767f010b95b45325b")
    .build();

    // Construct an instance of the PostBulkGetOptions model
    PostBulkGetOptions postBulkGetOptionsModel = new PostBulkGetOptions.Builder()
    .db("testString")
    .docs(new java.util.ArrayList<BulkGetQueryDocument>(java.util.Arrays.asList(bulkGetQueryDocumentModel)))
    .attachments(false)
    .attEncodingInfo(false)
    .latest(false)
    .revs(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postBulkGetAsStream(postBulkGetOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkGetAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postBulkGetAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkGetAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postBulkGetAsStream(null).execute();
  }

  @Test
  public void testDeleteDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String deleteDocumentPath = "/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteDocumentOptions model
    DeleteDocumentOptions deleteDocumentOptionsModel = new DeleteDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .ifMatch("testString")
    .batch("ok")
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.deleteDocument(deleteDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("batch"), "ok");
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDocumentPath);
  }

  // Test the deleteDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.deleteDocument(null).execute();
  }

  @Test
  public void testGetDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}";
    String getDocumentPath = "/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDocumentOptions model
    GetDocumentOptions getDocumentOptionsModel = new GetDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .ifNoneMatch("testString")
    .attachments(false)
    .attEncodingInfo(false)
    .conflicts(false)
    .deletedConflicts(false)
    .latest(false)
    .localSeq(false)
    .meta(false)
    .rev("testString")
    .revs(false)
    .revsInfo(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Document> response = cloudantService.getDocument(getDocumentOptionsModel).execute();
    assertNotNull(response);
    Document responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("deleted_conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("local_seq")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("meta")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs_info")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentPath);
  }

  // Test the getDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getDocument(null).execute();
  }

  @Test
  public void testGetDocumentAsMixedWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String getDocumentAsMixedPath = "/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "multipart/mixed")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDocumentOptions model
    GetDocumentOptions getDocumentOptionsModel = new GetDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .ifNoneMatch("testString")
    .attachments(false)
    .attEncodingInfo(false)
    .conflicts(false)
    .deletedConflicts(false)
    .latest(false)
    .localSeq(false)
    .meta(false)
    .rev("testString")
    .revs(false)
    .revsInfo(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.getDocumentAsMixed(getDocumentOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("deleted_conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("local_seq")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("meta")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs_info")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentAsMixedPath);
  }

  // Test the getDocumentAsMixed operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentAsMixedNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getDocumentAsMixed(null).execute();
  }

  @Test
  public void testGetDocumentAsRelatedWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String getDocumentAsRelatedPath = "/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "multipart/related")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDocumentOptions model
    GetDocumentOptions getDocumentOptionsModel = new GetDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .ifNoneMatch("testString")
    .attachments(false)
    .attEncodingInfo(false)
    .conflicts(false)
    .deletedConflicts(false)
    .latest(false)
    .localSeq(false)
    .meta(false)
    .rev("testString")
    .revs(false)
    .revsInfo(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.getDocumentAsRelated(getDocumentOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("deleted_conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("local_seq")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("meta")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs_info")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentAsRelatedPath);
  }

  // Test the getDocumentAsRelated operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentAsRelatedNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getDocumentAsRelated(null).execute();
  }

  @Test
  public void testGetDocumentAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String getDocumentAsStreamPath = "/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDocumentOptions model
    GetDocumentOptions getDocumentOptionsModel = new GetDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .ifNoneMatch("testString")
    .attachments(false)
    .attEncodingInfo(false)
    .conflicts(false)
    .deletedConflicts(false)
    .latest(false)
    .localSeq(false)
    .meta(false)
    .rev("testString")
    .revs(false)
    .revsInfo(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.getDocumentAsStream(getDocumentOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("deleted_conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("local_seq")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("meta")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs_info")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the getDocumentAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getDocumentAsStream(null).execute();
  }

  @Test
  public void testPutDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String putDocumentPath = "/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
    .contentType("testString")
    .data(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .digest("testString")
    .encodedLength(Long.valueOf("0"))
    .encoding("testString")
    .follows(true)
    .length(Long.valueOf("0"))
    .revpos(Long.valueOf("1"))
    .stub(true)
    .build();

    // Construct an instance of the Revisions model
    Revisions revisionsModel = new Revisions.Builder()
    .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .start(Long.valueOf("1"))
    .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
    .rev("testString")
    .status("available")
    .build();

    // Construct an instance of the Document model
    Document documentModel = new Document.Builder()
    .attachments(new java.util.HashMap<String, Attachment>() { { put("foo", attachmentModel); } })
    .conflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .deleted(true)
    .deletedConflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .id("exampleid")
    .localSeq("testString")
    .rev("testString")
    .revisions(revisionsModel)
    .revsInfo(new java.util.ArrayList<DocumentRevisionStatus>(java.util.Arrays.asList(documentRevisionStatusModel)))
    .add("brand", "Foo")
    .add("colours", "[\"red\",\"green\",\"black\",\"blue\"]")
    .add("description", "Slim Colourful Design Electronic Cooking Appliance for ...")
    .add("image", "assets/img/0gmsnghhew.jpg")
    .add("keywords", "[\"Foo\",\"Scales\",\"Weight\",\"Digital\",\"Kitchen\"]")
    .add("name", "Digital Kitchen Scales")
    .add("price", "14.99")
    .add("productid", "1000042")
    .add("taxonomy", "[\"Home\",\"Kitchen\",\"Small Appliances\"]")
    .add("type", "product")
    .build();

    // Construct an instance of the PutDocumentOptions model
    PutDocumentOptions putDocumentOptionsModel = new PutDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .document(documentModel)
    .contentType("application/json")
    .ifMatch("testString")
    .batch("ok")
    .newEdits(false)
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.putDocument(putDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("batch"), "ok");
    assertEquals(Boolean.valueOf(query.get("new_edits")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putDocumentPath);
  }

  // Test the putDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putDocument(null).execute();
  }

  @Test
  public void testHeadDesignDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String headDesignDocumentPath = "/testString/_design/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the HeadDesignDocumentOptions model
    HeadDesignDocumentOptions headDesignDocumentOptionsModel = new HeadDesignDocumentOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .ifNoneMatch("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = cloudantService.headDesignDocument(headDesignDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headDesignDocumentPath);
  }

  // Test the headDesignDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadDesignDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.headDesignDocument(null).execute();
  }

  @Test
  public void testDeleteDesignDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String deleteDesignDocumentPath = "/testString/_design/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteDesignDocumentOptions model
    DeleteDesignDocumentOptions deleteDesignDocumentOptionsModel = new DeleteDesignDocumentOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .ifMatch("testString")
    .batch("ok")
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.deleteDesignDocument(deleteDesignDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("batch"), "ok");
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDesignDocumentPath);
  }

  // Test the deleteDesignDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDesignDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.deleteDesignDocument(null).execute();
  }

  @Test
  public void testGetDesignDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}], \"autoupdate\": true, \"filters\": {\"mapKey\": \"inner\"}, \"indexes\": {\"mapKey\": {\"analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"], \"fields\": {\"mapKey\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}}}, \"index\": \"index\"}}, \"language\": \"javascript\", \"options\": {\"partitioned\": false}, \"updates\": {\"mapKey\": \"inner\"}, \"validate_doc_update\": \"validateDocUpdate\", \"views\": {\"mapKey\": {\"map\": \"map\", \"reduce\": \"reduce\"}}, \"st_indexes\": {\"mapKey\": {\"index\": \"index\"}}}";
    String getDesignDocumentPath = "/testString/_design/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDesignDocumentOptions model
    GetDesignDocumentOptions getDesignDocumentOptionsModel = new GetDesignDocumentOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .ifNoneMatch("testString")
    .attachments(false)
    .attEncodingInfo(false)
    .conflicts(false)
    .deletedConflicts(false)
    .latest(false)
    .localSeq(false)
    .meta(false)
    .rev("testString")
    .revs(false)
    .revsInfo(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DesignDocument> response = cloudantService.getDesignDocument(getDesignDocumentOptionsModel).execute();
    assertNotNull(response);
    DesignDocument responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("deleted_conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("local_seq")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("meta")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs_info")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDesignDocumentPath);
  }

  // Test the getDesignDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDesignDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getDesignDocument(null).execute();
  }

  @Test
  public void testPutDesignDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String putDesignDocumentPath = "/testString/_design/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
    .contentType("testString")
    .data(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .digest("testString")
    .encodedLength(Long.valueOf("0"))
    .encoding("testString")
    .follows(true)
    .length(Long.valueOf("0"))
    .revpos(Long.valueOf("1"))
    .stub(true)
    .build();

    // Construct an instance of the Revisions model
    Revisions revisionsModel = new Revisions.Builder()
    .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .start(Long.valueOf("1"))
    .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
    .rev("testString")
    .status("available")
    .build();

    // Construct an instance of the Analyzer model
    Analyzer analyzerModel = new Analyzer.Builder()
    .name("classic")
    .stopwords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the AnalyzerConfiguration model
    AnalyzerConfiguration analyzerConfigurationModel = new AnalyzerConfiguration.Builder()
    .name("classic")
    .stopwords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .fields(new java.util.HashMap<String, Analyzer>() { { put("foo", analyzerModel); } })
    .build();

    // Construct an instance of the SearchIndexDefinition model
    SearchIndexDefinition searchIndexDefinitionModel = new SearchIndexDefinition.Builder()
    .analyzer(analyzerConfigurationModel)
    .index("testString")
    .build();

    // Construct an instance of the DesignDocumentOptions model
    DesignDocumentOptions designDocumentOptionsModel = new DesignDocumentOptions.Builder()
    .partitioned(true)
    .build();

    // Construct an instance of the DesignDocumentViewsMapReduce model
    DesignDocumentViewsMapReduce designDocumentViewsMapReduceModel = new DesignDocumentViewsMapReduce.Builder()
    .map("testString")
    .reduce("testString")
    .build();

    // Construct an instance of the GeoIndexDefinition model
    GeoIndexDefinition geoIndexDefinitionModel = new GeoIndexDefinition.Builder()
    .index("testString")
    .build();

    // Construct an instance of the DesignDocument model
    DesignDocument designDocumentModel = new DesignDocument.Builder()
    .attachments(new java.util.HashMap<String, Attachment>() { { put("foo", attachmentModel); } })
    .conflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .deleted(true)
    .deletedConflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .id("testString")
    .localSeq("testString")
    .rev("testString")
    .revisions(revisionsModel)
    .revsInfo(new java.util.ArrayList<DocumentRevisionStatus>(java.util.Arrays.asList(documentRevisionStatusModel)))
    .autoupdate(true)
    .filters(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
    .indexes(new java.util.HashMap<String, SearchIndexDefinition>() { { put("foo", searchIndexDefinitionModel); } })
    .language("javascript")
    .options(designDocumentOptionsModel)
    .updates(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
    .validateDocUpdate("testString")
    .views(new java.util.HashMap<String, DesignDocumentViewsMapReduce>() { { put("foo", designDocumentViewsMapReduceModel); } })
    .stIndexes(new java.util.HashMap<String, GeoIndexDefinition>() { { put("foo", geoIndexDefinitionModel); } })
    .add("foo", "testString")
    .build();

    // Construct an instance of the PutDesignDocumentOptions model
    PutDesignDocumentOptions putDesignDocumentOptionsModel = new PutDesignDocumentOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .designDocument(designDocumentModel)
    .ifMatch("testString")
    .batch("ok")
    .newEdits(false)
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.putDesignDocument(putDesignDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("batch"), "ok");
    assertEquals(Boolean.valueOf(query.get("new_edits")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putDesignDocumentPath);
  }

  // Test the putDesignDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutDesignDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putDesignDocument(null).execute();
  }

  @Test
  public void testGetDesignDocumentInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"name\": \"name\", \"view_index\": {\"compact_running\": true, \"language\": \"language\", \"signature\": \"signature\", \"sizes\": {\"active\": 6, \"external\": 8, \"file\": 4}, \"update_seq\": \"updateSeq\", \"updater_running\": true, \"waiting_clients\": 0, \"waiting_commit\": false}}";
    String getDesignDocumentInformationPath = "/testString/_design/testString/_info";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDesignDocumentInformationOptions model
    GetDesignDocumentInformationOptions getDesignDocumentInformationOptionsModel = new GetDesignDocumentInformationOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DesignDocumentInformation> response = cloudantService.getDesignDocumentInformation(getDesignDocumentInformationOptionsModel).execute();
    assertNotNull(response);
    DesignDocumentInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDesignDocumentInformationPath);
  }

  // Test the getDesignDocumentInformation operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDesignDocumentInformationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getDesignDocumentInformation(null).execute();
  }

  @Test
  public void testPostDesignDocsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}";
    String postDesignDocsPath = "/testString/_design_docs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostDesignDocsOptions model
    PostDesignDocsOptions postDesignDocsOptionsModel = new PostDesignDocsOptions.Builder()
    .db("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(false)
    .inclusiveEnd(true)
    .limit(Long.valueOf("10"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .key("testString")
    .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .startkey("0007741142412418284")
    .accept("application/json")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AllDocsResult> response = cloudantService.postDesignDocs(postDesignDocsOptionsModel).execute();
    assertNotNull(response);
    AllDocsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postDesignDocsPath);
  }

  // Test the postDesignDocs operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDesignDocsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postDesignDocs(null).execute();
  }

  @Test
  public void testPostDesignDocsQueriesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"results\": [{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}]}";
    String postDesignDocsQueriesPath = "/testString/_design_docs/queries";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AllDocsQuery model
    AllDocsQuery allDocsQueryModel = new AllDocsQuery.Builder()
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(false)
    .inclusiveEnd(true)
    .limit(Long.valueOf("0"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .key("testString")
    .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("small-appliances:1000042", "small-appliances:1000043")))
    .startkey("testString")
    .build();

    // Construct an instance of the PostDesignDocsQueriesOptions model
    PostDesignDocsQueriesOptions postDesignDocsQueriesOptionsModel = new PostDesignDocsQueriesOptions.Builder()
    .db("testString")
    .queries(new java.util.ArrayList<AllDocsQuery>(java.util.Arrays.asList(allDocsQueryModel)))
    .accept("application/json")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AllDocsQueriesResult> response = cloudantService.postDesignDocsQueries(postDesignDocsQueriesOptionsModel).execute();
    assertNotNull(response);
    AllDocsQueriesResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postDesignDocsQueriesPath);
  }

  // Test the postDesignDocsQueries operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDesignDocsQueriesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postDesignDocsQueries(null).execute();
  }

  @Test
  public void testPostViewWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"update_seq\": \"updateSeq\", \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"anyValue\", \"value\": \"anyValue\"}]}";
    String postViewPath = "/testString/_design/testString/_view/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostViewOptions model
    PostViewOptions postViewOptionsModel = new PostViewOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .view("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(true)
    .inclusiveEnd(true)
    .limit(Long.valueOf("10"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .endkeyDocid("testString")
    .group(false)
    .groupLevel(Long.valueOf("1"))
    .key("testString")
    .keys(new java.util.ArrayList<Object>(java.util.Arrays.asList("examplekey")))
    .reduce(true)
    .stable(false)
    .startkey("testString")
    .startkeyDocid("testString")
    .update("true")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ViewResult> response = cloudantService.postView(postViewOptionsModel).execute();
    assertNotNull(response);
    ViewResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postViewPath);
  }

  // Test the postView operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postView(null).execute();
  }

  @Test
  public void testPostViewAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postViewAsStreamPath = "/testString/_design/testString/_view/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostViewOptions model
    PostViewOptions postViewOptionsModel = new PostViewOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .view("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(true)
    .inclusiveEnd(true)
    .limit(Long.valueOf("10"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .endkeyDocid("testString")
    .group(false)
    .groupLevel(Long.valueOf("1"))
    .key("testString")
    .keys(new java.util.ArrayList<Object>(java.util.Arrays.asList("examplekey")))
    .reduce(true)
    .stable(false)
    .startkey("testString")
    .startkeyDocid("testString")
    .update("true")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postViewAsStream(postViewOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postViewAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postViewAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postViewAsStream(null).execute();
  }

  @Test
  public void testPostViewQueriesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"results\": [{\"total_rows\": 0, \"update_seq\": \"updateSeq\", \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"anyValue\", \"value\": \"anyValue\"}]}]}";
    String postViewQueriesPath = "/testString/_design/testString/_view/testString/queries";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ViewQuery model
    ViewQuery viewQueryModel = new ViewQuery.Builder()
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(true)
    .inclusiveEnd(true)
    .limit(Long.valueOf("5"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .endkeyDocid("testString")
    .group(false)
    .groupLevel(Long.valueOf("1"))
    .key("testString")
    .keys(new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")))
    .reduce(true)
    .stable(false)
    .startkey("testString")
    .startkeyDocid("testString")
    .update("true")
    .build();

    // Construct an instance of the PostViewQueriesOptions model
    PostViewQueriesOptions postViewQueriesOptionsModel = new PostViewQueriesOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .view("testString")
    .queries(new java.util.ArrayList<ViewQuery>(java.util.Arrays.asList(viewQueryModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ViewQueriesResult> response = cloudantService.postViewQueries(postViewQueriesOptionsModel).execute();
    assertNotNull(response);
    ViewQueriesResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postViewQueriesPath);
  }

  // Test the postViewQueries operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewQueriesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postViewQueries(null).execute();
  }

  @Test
  public void testPostViewQueriesAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postViewQueriesAsStreamPath = "/testString/_design/testString/_view/testString/queries";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ViewQuery model
    ViewQuery viewQueryModel = new ViewQuery.Builder()
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(true)
    .inclusiveEnd(true)
    .limit(Long.valueOf("5"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .endkeyDocid("testString")
    .group(false)
    .groupLevel(Long.valueOf("1"))
    .key("testString")
    .keys(new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")))
    .reduce(true)
    .stable(false)
    .startkey("testString")
    .startkeyDocid("testString")
    .update("true")
    .build();

    // Construct an instance of the PostViewQueriesOptions model
    PostViewQueriesOptions postViewQueriesOptionsModel = new PostViewQueriesOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .view("testString")
    .queries(new java.util.ArrayList<ViewQuery>(java.util.Arrays.asList(viewQueryModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postViewQueriesAsStream(postViewQueriesOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postViewQueriesAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postViewQueriesAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewQueriesAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postViewQueriesAsStream(null).execute();
  }

  @Test
  public void testGetPartitionInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"db_name\": \"dbName\", \"doc_count\": 0, \"doc_del_count\": 0, \"partition\": \"partition\", \"partitioned_indexes\": {\"count\": 0, \"indexes\": {\"search\": 0, \"view\": 0}, \"limit\": 0}, \"sizes\": {\"active\": 0, \"external\": 0}}";
    String getPartitionInformationPath = "/testString/_partition/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetPartitionInformationOptions model
    GetPartitionInformationOptions getPartitionInformationOptionsModel = new GetPartitionInformationOptions.Builder()
    .db("testString")
    .partitionKey("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PartitionInformation> response = cloudantService.getPartitionInformation(getPartitionInformationOptionsModel).execute();
    assertNotNull(response);
    PartitionInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPartitionInformationPath);
  }

  // Test the getPartitionInformation operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPartitionInformationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getPartitionInformation(null).execute();
  }

  @Test
  public void testPostPartitionAllDocsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}";
    String postPartitionAllDocsPath = "/testString/_partition/testString/_all_docs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPartitionAllDocsOptions model
    PostPartitionAllDocsOptions postPartitionAllDocsOptionsModel = new PostPartitionAllDocsOptions.Builder()
    .db("testString")
    .partitionKey("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(false)
    .inclusiveEnd(true)
    .limit(Long.valueOf("10"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .key("testString")
    .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .startkey("0007741142412418284")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AllDocsResult> response = cloudantService.postPartitionAllDocs(postPartitionAllDocsOptionsModel).execute();
    assertNotNull(response);
    AllDocsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionAllDocsPath);
  }

  // Test the postPartitionAllDocs operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionAllDocsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postPartitionAllDocs(null).execute();
  }

  @Test
  public void testPostPartitionAllDocsAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postPartitionAllDocsAsStreamPath = "/testString/_partition/testString/_all_docs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPartitionAllDocsOptions model
    PostPartitionAllDocsOptions postPartitionAllDocsOptionsModel = new PostPartitionAllDocsOptions.Builder()
    .db("testString")
    .partitionKey("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(false)
    .inclusiveEnd(true)
    .limit(Long.valueOf("10"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .key("testString")
    .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .startkey("0007741142412418284")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postPartitionAllDocsAsStream(postPartitionAllDocsOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionAllDocsAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postPartitionAllDocsAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionAllDocsAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postPartitionAllDocsAsStream(null).execute();
  }

  @Test
  public void testPostPartitionSearchWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"bookmark\": \"bookmark\", \"by\": \"by\", \"counts\": {\"mapKey\": {\"mapKey\": 0}}, \"ranges\": {\"mapKey\": {\"mapKey\": 0}}, \"rows\": [{\"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"fields\": {\"mapKey\": \"anyValue\"}, \"highlights\": {\"mapKey\": [\"inner\"]}, \"id\": \"id\"}], \"groups\": [{\"total_rows\": 0, \"bookmark\": \"bookmark\", \"by\": \"by\", \"counts\": {\"mapKey\": {\"mapKey\": 0}}, \"ranges\": {\"mapKey\": {\"mapKey\": 0}}, \"rows\": [{\"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"fields\": {\"mapKey\": \"anyValue\"}, \"highlights\": {\"mapKey\": [\"inner\"]}, \"id\": \"id\"}]}]}";
    String postPartitionSearchPath = "/testString/_partition/testString/_design/testString/_search/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPartitionSearchOptions model
    PostPartitionSearchOptions postPartitionSearchOptionsModel = new PostPartitionSearchOptions.Builder()
    .db("testString")
    .partitionKey("testString")
    .ddoc("testString")
    .index("testString")
    .query("testString")
    .bookmark("testString")
    .highlightFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .highlightNumber(Long.valueOf("1"))
    .highlightPostTag("</em>")
    .highlightPreTag("<em>")
    .highlightSize(Long.valueOf("1"))
    .includeDocs(false)
    .includeFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .limit(Long.valueOf("3"))
    .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .stale("ok")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SearchResult> response = cloudantService.postPartitionSearch(postPartitionSearchOptionsModel).execute();
    assertNotNull(response);
    SearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionSearchPath);
  }

  // Test the postPartitionSearch operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionSearchNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postPartitionSearch(null).execute();
  }

  @Test
  public void testPostPartitionSearchAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postPartitionSearchAsStreamPath = "/testString/_partition/testString/_design/testString/_search/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPartitionSearchOptions model
    PostPartitionSearchOptions postPartitionSearchOptionsModel = new PostPartitionSearchOptions.Builder()
    .db("testString")
    .partitionKey("testString")
    .ddoc("testString")
    .index("testString")
    .query("testString")
    .bookmark("testString")
    .highlightFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .highlightNumber(Long.valueOf("1"))
    .highlightPostTag("</em>")
    .highlightPreTag("<em>")
    .highlightSize(Long.valueOf("1"))
    .includeDocs(false)
    .includeFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .limit(Long.valueOf("3"))
    .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .stale("ok")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postPartitionSearchAsStream(postPartitionSearchOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionSearchAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postPartitionSearchAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionSearchAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postPartitionSearchAsStream(null).execute();
  }

  @Test
  public void testPostPartitionViewWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"update_seq\": \"updateSeq\", \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"anyValue\", \"value\": \"anyValue\"}]}";
    String postPartitionViewPath = "/testString/_partition/testString/_design/testString/_view/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPartitionViewOptions model
    PostPartitionViewOptions postPartitionViewOptionsModel = new PostPartitionViewOptions.Builder()
    .db("testString")
    .partitionKey("testString")
    .ddoc("testString")
    .view("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(true)
    .inclusiveEnd(true)
    .limit(Long.valueOf("10"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .endkeyDocid("testString")
    .group(false)
    .groupLevel(Long.valueOf("1"))
    .key("testString")
    .keys(new java.util.ArrayList<Object>(java.util.Arrays.asList("examplekey")))
    .reduce(true)
    .stable(false)
    .startkey("testString")
    .startkeyDocid("testString")
    .update("true")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ViewResult> response = cloudantService.postPartitionView(postPartitionViewOptionsModel).execute();
    assertNotNull(response);
    ViewResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionViewPath);
  }

  // Test the postPartitionView operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionViewNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postPartitionView(null).execute();
  }

  @Test
  public void testPostPartitionViewAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postPartitionViewAsStreamPath = "/testString/_partition/testString/_design/testString/_view/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPartitionViewOptions model
    PostPartitionViewOptions postPartitionViewOptionsModel = new PostPartitionViewOptions.Builder()
    .db("testString")
    .partitionKey("testString")
    .ddoc("testString")
    .view("testString")
    .attEncodingInfo(false)
    .attachments(false)
    .conflicts(false)
    .descending(false)
    .includeDocs(true)
    .inclusiveEnd(true)
    .limit(Long.valueOf("10"))
    .skip(Long.valueOf("0"))
    .updateSeq(false)
    .endkey("testString")
    .endkeyDocid("testString")
    .group(false)
    .groupLevel(Long.valueOf("1"))
    .key("testString")
    .keys(new java.util.ArrayList<Object>(java.util.Arrays.asList("examplekey")))
    .reduce(true)
    .stable(false)
    .startkey("testString")
    .startkeyDocid("testString")
    .update("true")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postPartitionViewAsStream(postPartitionViewOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionViewAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postPartitionViewAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionViewAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postPartitionViewAsStream(null).execute();
  }

  @Test
  public void testPostPartitionFindWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"bookmark\": \"bookmark\", \"docs\": [{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}], \"execution_stats\": {\"execution_time_ms\": 15, \"results_returned\": 0, \"total_docs_examined\": 0, \"total_keys_examined\": 0, \"total_quorum_docs_examined\": 0}, \"warning\": \"warning\"}";
    String postPartitionFindPath = "/testString/_partition/testString/_find";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPartitionFindOptions model
    PostPartitionFindOptions postPartitionFindOptionsModel = new PostPartitionFindOptions.Builder()
    .db("testString")
    .partitionKey("testString")
    .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .bookmark("testString")
    .conflicts(true)
    .executionStats(true)
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("productid", "name", "description")))
    .limit(Long.valueOf("0"))
    .skip(Long.valueOf("0"))
    .sort(new java.util.ArrayList<java.util.Map<String, String>>(java.util.Arrays.asList(new java.util.HashMap<String, String>() { { put("foo", "asc"); } })))
    .stable(true)
    .update("true")
    .useIndex(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<FindResult> response = cloudantService.postPartitionFind(postPartitionFindOptionsModel).execute();
    assertNotNull(response);
    FindResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionFindPath);
  }

  // Test the postPartitionFind operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionFindNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postPartitionFind(null).execute();
  }

  @Test
  public void testPostPartitionFindAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postPartitionFindAsStreamPath = "/testString/_partition/testString/_find";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostPartitionFindOptions model
    PostPartitionFindOptions postPartitionFindOptionsModel = new PostPartitionFindOptions.Builder()
    .db("testString")
    .partitionKey("testString")
    .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .bookmark("testString")
    .conflicts(true)
    .executionStats(true)
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("productid", "name", "description")))
    .limit(Long.valueOf("0"))
    .skip(Long.valueOf("0"))
    .sort(new java.util.ArrayList<java.util.Map<String, String>>(java.util.Arrays.asList(new java.util.HashMap<String, String>() { { put("foo", "asc"); } })))
    .stable(true)
    .update("true")
    .useIndex(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postPartitionFindAsStream(postPartitionFindOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionFindAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postPartitionFindAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionFindAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postPartitionFindAsStream(null).execute();
  }

  @Test
  public void testPostExplainWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"dbname\": \"dbname\", \"fields\": [\"fields\"], \"index\": {\"ddoc\": \"ddoc\", \"def\": {\"default_analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"default_field\": {\"analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"enabled\": true}, \"fields\": [{\"name\": \"name\", \"type\": \"boolean\"}], \"index_array_lengths\": true, \"partial_filter_selector\": {\"mapKey\": \"anyValue\"}}, \"name\": \"name\", \"type\": \"json\"}, \"limit\": 0, \"opts\": {\"mapKey\": \"anyValue\"}, \"range\": {\"end_key\": [\"anyValue\"], \"start_key\": [\"anyValue\"]}, \"selector\": {\"mapKey\": \"anyValue\"}, \"skip\": 0}";
    String postExplainPath = "/testString/_explain";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostExplainOptions model
    PostExplainOptions postExplainOptionsModel = new PostExplainOptions.Builder()
    .db("testString")
    .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .bookmark("testString")
    .conflicts(true)
    .executionStats(true)
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .limit(Long.valueOf("0"))
    .skip(Long.valueOf("0"))
    .sort(new java.util.ArrayList<java.util.Map<String, String>>(java.util.Arrays.asList(new java.util.HashMap<String, String>() { { put("foo", "asc"); } })))
    .stable(true)
    .update("true")
    .useIndex(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .r(Long.valueOf("1"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ExplainResult> response = cloudantService.postExplain(postExplainOptionsModel).execute();
    assertNotNull(response);
    ExplainResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postExplainPath);
  }

  // Test the postExplain operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostExplainNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postExplain(null).execute();
  }

  @Test
  public void testPostFindWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"bookmark\": \"bookmark\", \"docs\": [{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}], \"execution_stats\": {\"execution_time_ms\": 15, \"results_returned\": 0, \"total_docs_examined\": 0, \"total_keys_examined\": 0, \"total_quorum_docs_examined\": 0}, \"warning\": \"warning\"}";
    String postFindPath = "/testString/_find";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostFindOptions model
    PostFindOptions postFindOptionsModel = new PostFindOptions.Builder()
    .db("testString")
    .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .bookmark("testString")
    .conflicts(true)
    .executionStats(true)
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("_id", "type", "name", "email")))
    .limit(Long.valueOf("3"))
    .skip(Long.valueOf("0"))
    .sort(new java.util.ArrayList<java.util.Map<String, String>>(java.util.Arrays.asList(new java.util.HashMap<String, String>() { { put("foo", "asc"); } })))
    .stable(true)
    .update("true")
    .useIndex(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .r(Long.valueOf("1"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<FindResult> response = cloudantService.postFind(postFindOptionsModel).execute();
    assertNotNull(response);
    FindResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postFindPath);
  }

  // Test the postFind operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostFindNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postFind(null).execute();
  }

  @Test
  public void testPostFindAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postFindAsStreamPath = "/testString/_find";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostFindOptions model
    PostFindOptions postFindOptionsModel = new PostFindOptions.Builder()
    .db("testString")
    .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .bookmark("testString")
    .conflicts(true)
    .executionStats(true)
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("_id", "type", "name", "email")))
    .limit(Long.valueOf("3"))
    .skip(Long.valueOf("0"))
    .sort(new java.util.ArrayList<java.util.Map<String, String>>(java.util.Arrays.asList(new java.util.HashMap<String, String>() { { put("foo", "asc"); } })))
    .stable(true)
    .update("true")
    .useIndex(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .r(Long.valueOf("1"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postFindAsStream(postFindOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postFindAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postFindAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostFindAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postFindAsStream(null).execute();
  }

  @Test
  public void testGetIndexesInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"indexes\": [{\"ddoc\": \"ddoc\", \"def\": {\"default_analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"default_field\": {\"analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"enabled\": true}, \"fields\": [{\"name\": \"name\", \"type\": \"boolean\"}], \"index_array_lengths\": true, \"partial_filter_selector\": {\"mapKey\": \"anyValue\"}}, \"name\": \"name\", \"type\": \"json\"}]}";
    String getIndexesInformationPath = "/testString/_index";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetIndexesInformationOptions model
    GetIndexesInformationOptions getIndexesInformationOptionsModel = new GetIndexesInformationOptions.Builder()
    .db("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<IndexesInformation> response = cloudantService.getIndexesInformation(getIndexesInformationOptionsModel).execute();
    assertNotNull(response);
    IndexesInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getIndexesInformationPath);
  }

  // Test the getIndexesInformation operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetIndexesInformationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getIndexesInformation(null).execute();
  }

  @Test
  public void testPostIndexWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"result\": \"created\"}";
    String postIndexPath = "/testString/_index";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Analyzer model
    Analyzer analyzerModel = new Analyzer.Builder()
    .name("classic")
    .stopwords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the IndexTextOperatorDefaultField model
    IndexTextOperatorDefaultField indexTextOperatorDefaultFieldModel = new IndexTextOperatorDefaultField.Builder()
    .analyzer(analyzerModel)
    .enabled(true)
    .build();

    // Construct an instance of the IndexField model
    IndexField indexFieldModel = new IndexField.Builder()
    .name("testString")
    .type("boolean")
    .add("foo", "asc")
    .build();

    // Construct an instance of the IndexDefinition model
    IndexDefinition indexDefinitionModel = new IndexDefinition.Builder()
    .defaultAnalyzer(analyzerModel)
    .defaultField(indexTextOperatorDefaultFieldModel)
    .fields(new java.util.ArrayList<IndexField>(java.util.Arrays.asList(indexFieldModel)))
    .indexArrayLengths(true)
    .partialFilterSelector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .build();

    // Construct an instance of the PostIndexOptions model
    PostIndexOptions postIndexOptionsModel = new PostIndexOptions.Builder()
    .db("testString")
    .index(indexDefinitionModel)
    .ddoc("testString")
    .def(indexDefinitionModel)
    .name("testString")
    .partitioned(true)
    .type("json")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<IndexResult> response = cloudantService.postIndex(postIndexOptionsModel).execute();
    assertNotNull(response);
    IndexResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postIndexPath);
  }

  // Test the postIndex operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostIndexNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postIndex(null).execute();
  }

  @Test
  public void testDeleteIndexWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true}";
    String deleteIndexPath = "/testString/_index/_design/testString/json/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteIndexOptions model
    DeleteIndexOptions deleteIndexOptionsModel = new DeleteIndexOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .type("json")
    .index("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Ok> response = cloudantService.deleteIndex(deleteIndexOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteIndexPath);
  }

  // Test the deleteIndex operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteIndexNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.deleteIndex(null).execute();
  }

  @Test
  public void testPostSearchAnalyzeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"tokens\": [\"tokens\"]}";
    String postSearchAnalyzePath = "/_search_analyze";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostSearchAnalyzeOptions model
    PostSearchAnalyzeOptions postSearchAnalyzeOptionsModel = new PostSearchAnalyzeOptions.Builder()
    .analyzer("arabic")
    .text("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SearchAnalyzeResult> response = cloudantService.postSearchAnalyze(postSearchAnalyzeOptionsModel).execute();
    assertNotNull(response);
    SearchAnalyzeResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postSearchAnalyzePath);
  }

  // Test the postSearchAnalyze operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostSearchAnalyzeNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postSearchAnalyze(null).execute();
  }

  @Test
  public void testPostSearchWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"bookmark\": \"bookmark\", \"by\": \"by\", \"counts\": {\"mapKey\": {\"mapKey\": 0}}, \"ranges\": {\"mapKey\": {\"mapKey\": 0}}, \"rows\": [{\"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"fields\": {\"mapKey\": \"anyValue\"}, \"highlights\": {\"mapKey\": [\"inner\"]}, \"id\": \"id\"}], \"groups\": [{\"total_rows\": 0, \"bookmark\": \"bookmark\", \"by\": \"by\", \"counts\": {\"mapKey\": {\"mapKey\": 0}}, \"ranges\": {\"mapKey\": {\"mapKey\": 0}}, \"rows\": [{\"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"fields\": {\"mapKey\": \"anyValue\"}, \"highlights\": {\"mapKey\": [\"inner\"]}, \"id\": \"id\"}]}]}";
    String postSearchPath = "/testString/_design/testString/_search/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostSearchOptions model
    PostSearchOptions postSearchOptionsModel = new PostSearchOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .index("testString")
    .query("testString")
    .bookmark("testString")
    .highlightFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .highlightNumber(Long.valueOf("1"))
    .highlightPostTag("</em>")
    .highlightPreTag("<em>")
    .highlightSize(Long.valueOf("1"))
    .includeDocs(false)
    .includeFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .limit(Long.valueOf("3"))
    .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .stale("ok")
    .counts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .drilldown(new java.util.ArrayList<List<String>>(java.util.Arrays.asList(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))))
    .groupField("testString")
    .groupLimit(Long.valueOf("1"))
    .groupSort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .ranges(new java.util.HashMap<String, Map<String, Map<String, String>>>() { { put("foo", new java.util.HashMap<String, Map<String, String>>() { { put("foo", new java.util.HashMap<String, String>() { { put("foo", "testString"); } }); } }); } })
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SearchResult> response = cloudantService.postSearch(postSearchOptionsModel).execute();
    assertNotNull(response);
    SearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postSearchPath);
  }

  // Test the postSearch operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostSearchNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postSearch(null).execute();
  }

  @Test
  public void testPostSearchAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postSearchAsStreamPath = "/testString/_design/testString/_search/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostSearchOptions model
    PostSearchOptions postSearchOptionsModel = new PostSearchOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .index("testString")
    .query("testString")
    .bookmark("testString")
    .highlightFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .highlightNumber(Long.valueOf("1"))
    .highlightPostTag("</em>")
    .highlightPreTag("<em>")
    .highlightSize(Long.valueOf("1"))
    .includeDocs(false)
    .includeFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .limit(Long.valueOf("3"))
    .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .stale("ok")
    .counts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .drilldown(new java.util.ArrayList<List<String>>(java.util.Arrays.asList(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))))
    .groupField("testString")
    .groupLimit(Long.valueOf("1"))
    .groupSort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .ranges(new java.util.HashMap<String, Map<String, Map<String, String>>>() { { put("foo", new java.util.HashMap<String, Map<String, String>>() { { put("foo", new java.util.HashMap<String, String>() { { put("foo", "testString"); } }); } }); } })
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.postSearchAsStream(postSearchOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postSearchAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the postSearchAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostSearchAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postSearchAsStream(null).execute();
  }

  @Test
  public void testGetSearchInfoWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"name\": \"name\", \"search_index\": {\"committed_seq\": 12, \"disk_size\": 0, \"doc_count\": 0, \"doc_del_count\": 0, \"pending_seq\": 10}}";
    String getSearchInfoPath = "/testString/_design/testString/_search_info/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSearchInfoOptions model
    GetSearchInfoOptions getSearchInfoOptionsModel = new GetSearchInfoOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .index("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SearchInfoResult> response = cloudantService.getSearchInfo(getSearchInfoOptionsModel).execute();
    assertNotNull(response);
    SearchInfoResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSearchInfoPath);
  }

  // Test the getSearchInfo operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSearchInfoNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getSearchInfo(null).execute();
  }

  @Test
  public void testGetGeoWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"bookmark\": \"bookmark\", \"features\": [{\"_id\": \"id\", \"_rev\": \"rev\", \"bbox\": [4], \"geometry\": {\"type\": \"Point\", \"coordinates\": [\"anyValue\"]}, \"properties\": {\"mapKey\": \"anyValue\"}, \"type\": \"Feature\"}], \"rows\": [{\"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"geometry\": {\"type\": \"Point\", \"coordinates\": [\"anyValue\"]}, \"id\": \"id\", \"rev\": \"rev\"}], \"type\": \"FeatureCollection\"}";
    String getGeoPath = "/testString/_design/testString/_geo/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetGeoOptions model
    GetGeoOptions getGeoOptionsModel = new GetGeoOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .index("testString")
    .bbox("testString")
    .bookmark("testString")
    .format("view")
    .g("testString")
    .includeDocs(false)
    .lat(Double.valueOf("-90"))
    .limit(Long.valueOf("0"))
    .lon(Double.valueOf("-180"))
    .nearest(false)
    .radius(Double.valueOf("0"))
    .rangex(Double.valueOf("0"))
    .rangey(Double.valueOf("0"))
    .relation("intersects")
    .skip(Long.valueOf("0"))
    .stale("ok")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GeoResult> response = cloudantService.getGeo(getGeoOptionsModel).execute();
    assertNotNull(response);
    GeoResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("bbox"), "testString");
    assertEquals(query.get("bookmark"), "testString");
    assertEquals(query.get("format"), "view");
    assertEquals(query.get("g"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_docs")), Boolean.valueOf(false));
    assertEquals(Double.valueOf(query.get("lat")), Double.valueOf("-90"));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Double.valueOf(query.get("lon")), Double.valueOf("-180"));
    assertEquals(Boolean.valueOf(query.get("nearest")), Boolean.valueOf(false));
    assertEquals(Double.valueOf(query.get("radius")), Double.valueOf("0"));
    assertEquals(Double.valueOf(query.get("rangex")), Double.valueOf("0"));
    assertEquals(Double.valueOf(query.get("rangey")), Double.valueOf("0"));
    assertEquals(query.get("relation"), "intersects");
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("0"));
    assertEquals(query.get("stale"), "ok");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getGeoPath);
  }

  // Test the getGeo operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetGeoNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getGeo(null).execute();
  }

  @Test
  public void testGetGeoAsStreamWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String getGeoAsStreamPath = "/testString/_design/testString/_geo/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetGeoOptions model
    GetGeoOptions getGeoOptionsModel = new GetGeoOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .index("testString")
    .bbox("testString")
    .bookmark("testString")
    .format("view")
    .g("testString")
    .includeDocs(false)
    .lat(Double.valueOf("-90"))
    .limit(Long.valueOf("0"))
    .lon(Double.valueOf("-180"))
    .nearest(false)
    .radius(Double.valueOf("0"))
    .rangex(Double.valueOf("0"))
    .rangey(Double.valueOf("0"))
    .relation("intersects")
    .skip(Long.valueOf("0"))
    .stale("ok")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.getGeoAsStream(getGeoOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("bbox"), "testString");
    assertEquals(query.get("bookmark"), "testString");
    assertEquals(query.get("format"), "view");
    assertEquals(query.get("g"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_docs")), Boolean.valueOf(false));
    assertEquals(Double.valueOf(query.get("lat")), Double.valueOf("-90"));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Double.valueOf(query.get("lon")), Double.valueOf("-180"));
    assertEquals(Boolean.valueOf(query.get("nearest")), Boolean.valueOf(false));
    assertEquals(Double.valueOf(query.get("radius")), Double.valueOf("0"));
    assertEquals(Double.valueOf(query.get("rangex")), Double.valueOf("0"));
    assertEquals(Double.valueOf(query.get("rangey")), Double.valueOf("0"));
    assertEquals(query.get("relation"), "intersects");
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("0"));
    assertEquals(query.get("stale"), "ok");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getGeoAsStreamPath);

    // Verify streamed JSON response
    java.util.Scanner s = new java.util.Scanner(responseObj).useDelimiter("\\A");
    String streamedResponseBody = s.hasNext() ? s.next() : "";
    assertEquals(streamedResponseBody, mockResponseBody);
  }

  // Test the getGeoAsStream operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetGeoAsStreamNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getGeoAsStream(null).execute();
  }

  @Test
  public void testPostGeoCleanupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true}";
    String postGeoCleanupPath = "/testString/_geo_cleanup";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostGeoCleanupOptions model
    PostGeoCleanupOptions postGeoCleanupOptionsModel = new PostGeoCleanupOptions.Builder()
    .db("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Ok> response = cloudantService.postGeoCleanup(postGeoCleanupOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postGeoCleanupPath);
  }

  // Test the postGeoCleanup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostGeoCleanupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postGeoCleanup(null).execute();
  }

  @Test
  public void testGetGeoIndexInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"geo_index\": {\"data_size\": 0, \"disk_size\": 0, \"doc_count\": 0}, \"name\": \"name\"}";
    String getGeoIndexInformationPath = "/testString/_design/testString/_geo_info/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetGeoIndexInformationOptions model
    GetGeoIndexInformationOptions getGeoIndexInformationOptionsModel = new GetGeoIndexInformationOptions.Builder()
    .db("testString")
    .ddoc("testString")
    .index("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GeoIndexInformation> response = cloudantService.getGeoIndexInformation(getGeoIndexInformationOptionsModel).execute();
    assertNotNull(response);
    GeoIndexInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getGeoIndexInformationPath);
  }

  // Test the getGeoIndexInformation operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetGeoIndexInformationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getGeoIndexInformation(null).execute();
  }

  @Test
  public void testHeadReplicationDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String headReplicationDocumentPath = "/_replicator/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the HeadReplicationDocumentOptions model
    HeadReplicationDocumentOptions headReplicationDocumentOptionsModel = new HeadReplicationDocumentOptions.Builder()
    .docId("testString")
    .ifNoneMatch("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = cloudantService.headReplicationDocument(headReplicationDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headReplicationDocumentPath);
  }

  // Test the headReplicationDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadReplicationDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.headReplicationDocument(null).execute();
  }

  @Test
  public void testHeadSchedulerDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String headSchedulerDocumentPath = "/_scheduler/docs/_replicator/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the HeadSchedulerDocumentOptions model
    HeadSchedulerDocumentOptions headSchedulerDocumentOptionsModel = new HeadSchedulerDocumentOptions.Builder()
    .docId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = cloudantService.headSchedulerDocument(headSchedulerDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headSchedulerDocumentPath);
  }

  // Test the headSchedulerDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadSchedulerDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.headSchedulerDocument(null).execute();
  }

  @Test
  public void testHeadSchedulerJobWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String headSchedulerJobPath = "/_scheduler/jobs/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the HeadSchedulerJobOptions model
    HeadSchedulerJobOptions headSchedulerJobOptionsModel = new HeadSchedulerJobOptions.Builder()
    .jobId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = cloudantService.headSchedulerJob(headSchedulerJobOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headSchedulerJobPath);
  }

  // Test the headSchedulerJob operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadSchedulerJobNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.headSchedulerJob(null).execute();
  }

  @Test
  public void testDeleteReplicationDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String deleteReplicationDocumentPath = "/_replicator/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteReplicationDocumentOptions model
    DeleteReplicationDocumentOptions deleteReplicationDocumentOptionsModel = new DeleteReplicationDocumentOptions.Builder()
    .docId("testString")
    .ifMatch("testString")
    .batch("ok")
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.deleteReplicationDocument(deleteReplicationDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("batch"), "ok");
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteReplicationDocumentPath);
  }

  // Test the deleteReplicationDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteReplicationDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.deleteReplicationDocument(null).execute();
  }

  @Test
  public void testGetReplicationDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}], \"cancel\": true, \"checkpoint_interval\": 0, \"connection_timeout\": 0, \"continuous\": false, \"create_target\": false, \"create_target_params\": {\"n\": 1, \"partitioned\": false, \"q\": 1}, \"doc_ids\": [\"docIds\"], \"filter\": \"filter\", \"http_connections\": 1, \"query_params\": {\"mapKey\": \"inner\"}, \"retries_per_request\": 0, \"selector\": {\"mapKey\": \"anyValue\"}, \"since_seq\": \"sinceSeq\", \"socket_options\": \"socketOptions\", \"source\": {\"auth\": {\"iam\": {\"api_key\": \"apiKey\"}}, \"headers\": {\"mapKey\": \"inner\"}, \"url\": \"url\"}, \"source_proxy\": \"sourceProxy\", \"target\": {\"auth\": {\"iam\": {\"api_key\": \"apiKey\"}}, \"headers\": {\"mapKey\": \"inner\"}, \"url\": \"url\"}, \"target_proxy\": \"targetProxy\", \"use_checkpoints\": true, \"user_ctx\": {\"db\": \"db\", \"name\": \"name\", \"roles\": [\"_reader\"]}, \"worker_batch_size\": 1, \"worker_processes\": 1}";
    String getReplicationDocumentPath = "/_replicator/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetReplicationDocumentOptions model
    GetReplicationDocumentOptions getReplicationDocumentOptionsModel = new GetReplicationDocumentOptions.Builder()
    .docId("testString")
    .ifNoneMatch("testString")
    .attachments(false)
    .attEncodingInfo(false)
    .conflicts(false)
    .deletedConflicts(false)
    .latest(false)
    .localSeq(false)
    .meta(false)
    .rev("testString")
    .revs(false)
    .revsInfo(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ReplicationDocument> response = cloudantService.getReplicationDocument(getReplicationDocumentOptionsModel).execute();
    assertNotNull(response);
    ReplicationDocument responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("deleted_conflicts")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("local_seq")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("meta")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs_info")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReplicationDocumentPath);
  }

  // Test the getReplicationDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReplicationDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getReplicationDocument(null).execute();
  }

  @Test
  public void testPutReplicationDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String putReplicationDocumentPath = "/_replicator/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
    .contentType("testString")
    .data(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .digest("testString")
    .encodedLength(Long.valueOf("0"))
    .encoding("testString")
    .follows(true)
    .length(Long.valueOf("0"))
    .revpos(Long.valueOf("1"))
    .stub(true)
    .build();

    // Construct an instance of the Revisions model
    Revisions revisionsModel = new Revisions.Builder()
    .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .start(Long.valueOf("1"))
    .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
    .rev("testString")
    .status("available")
    .build();

    // Construct an instance of the ReplicationCreateTargetParameters model
    ReplicationCreateTargetParameters replicationCreateTargetParametersModel = new ReplicationCreateTargetParameters.Builder()
    .n(Long.valueOf("1"))
    .partitioned(false)
    .q(Long.valueOf("1"))
    .build();

    // Construct an instance of the ReplicationDatabaseAuthIam model
    ReplicationDatabaseAuthIam replicationDatabaseAuthIamModel = new ReplicationDatabaseAuthIam.Builder()
    .apiKey("testString")
    .build();

    // Construct an instance of the ReplicationDatabaseAuth model
    ReplicationDatabaseAuth replicationDatabaseAuthModel = new ReplicationDatabaseAuth.Builder()
    .iam(replicationDatabaseAuthIamModel)
    .build();

    // Construct an instance of the ReplicationDatabase model
    ReplicationDatabase replicationDatabaseModel = new ReplicationDatabase.Builder()
    .auth(replicationDatabaseAuthModel)
    .headers(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
    .url("testString")
    .build();

    // Construct an instance of the UserContext model
    UserContext userContextModel = new UserContext.Builder()
    .db("testString")
    .name("testString")
    .roles(new java.util.ArrayList<String>(java.util.Arrays.asList("_reader")))
    .build();

    // Construct an instance of the ReplicationDocument model
    ReplicationDocument replicationDocumentModel = new ReplicationDocument.Builder()
    .attachments(new java.util.HashMap<String, Attachment>() { { put("foo", attachmentModel); } })
    .conflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .deleted(true)
    .deletedConflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .id("testString")
    .localSeq("testString")
    .rev("testString")
    .revisions(revisionsModel)
    .revsInfo(new java.util.ArrayList<DocumentRevisionStatus>(java.util.Arrays.asList(documentRevisionStatusModel)))
    .cancel(true)
    .checkpointInterval(Long.valueOf("0"))
    .connectionTimeout(Long.valueOf("0"))
    .continuous(false)
    .createTarget(false)
    .createTargetParams(replicationCreateTargetParametersModel)
    .docIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .filter("testString")
    .httpConnections(Long.valueOf("1"))
    .queryParams(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
    .retriesPerRequest(Long.valueOf("0"))
    .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .sinceSeq("testString")
    .socketOptions("testString")
    .source(replicationDatabaseModel)
    .sourceProxy("testString")
    .target(replicationDatabaseModel)
    .targetProxy("testString")
    .useCheckpoints(true)
    .userCtx(userContextModel)
    .workerBatchSize(Long.valueOf("1"))
    .workerProcesses(Long.valueOf("1"))
    .add("foo", "testString")
    .build();

    // Construct an instance of the PutReplicationDocumentOptions model
    PutReplicationDocumentOptions putReplicationDocumentOptionsModel = new PutReplicationDocumentOptions.Builder()
    .docId("testString")
    .replicationDocument(replicationDocumentModel)
    .ifMatch("testString")
    .batch("ok")
    .newEdits(false)
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.putReplicationDocument(putReplicationDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("batch"), "ok");
    assertEquals(Boolean.valueOf(query.get("new_edits")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putReplicationDocumentPath);
  }

  // Test the putReplicationDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutReplicationDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putReplicationDocument(null).execute();
  }

  @Test
  public void testGetSchedulerDocsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"docs\": [{\"database\": \"database\", \"doc_id\": \"docId\", \"error_count\": 0, \"id\": \"id\", \"info\": {\"changes_pending\": 0, \"checkpointed_source_seq\": \"checkpointedSourceSeq\", \"doc_write_failures\": 0, \"docs_read\": 0, \"docs_written\": 0, \"error\": \"error\", \"missing_revisions_found\": 0, \"revisions_checked\": 0, \"source_seq\": \"sourceSeq\", \"through_seq\": \"throughSeq\"}, \"last_updated\": \"2019-01-01T12:00:00.000Z\", \"node\": \"node\", \"source\": \"source\", \"source_proxy\": \"sourceProxy\", \"start_time\": \"2019-01-01T12:00:00.000Z\", \"state\": \"initializing\", \"target\": \"target\", \"target_proxy\": \"targetProxy\"}]}";
    String getSchedulerDocsPath = "/_scheduler/docs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSchedulerDocsOptions model
    GetSchedulerDocsOptions getSchedulerDocsOptionsModel = new GetSchedulerDocsOptions.Builder()
    .limit(Long.valueOf("0"))
    .skip(Long.valueOf("0"))
    .states(new java.util.ArrayList<String>(java.util.Arrays.asList("initializing")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SchedulerDocsResult> response = cloudantService.getSchedulerDocs(getSchedulerDocsOptionsModel).execute();
    assertNotNull(response);
    SchedulerDocsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("0"));
    assertEquals(query.get("states"), RequestUtils.join(new java.util.ArrayList<String>(java.util.Arrays.asList("initializing")), ","));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSchedulerDocsPath);
  }

  @Test
  public void testGetSchedulerDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"database\": \"database\", \"doc_id\": \"docId\", \"error_count\": 0, \"id\": \"id\", \"info\": {\"changes_pending\": 0, \"checkpointed_source_seq\": \"checkpointedSourceSeq\", \"doc_write_failures\": 0, \"docs_read\": 0, \"docs_written\": 0, \"error\": \"error\", \"missing_revisions_found\": 0, \"revisions_checked\": 0, \"source_seq\": \"sourceSeq\", \"through_seq\": \"throughSeq\"}, \"last_updated\": \"2019-01-01T12:00:00.000Z\", \"node\": \"node\", \"source\": \"source\", \"source_proxy\": \"sourceProxy\", \"start_time\": \"2019-01-01T12:00:00.000Z\", \"state\": \"initializing\", \"target\": \"target\", \"target_proxy\": \"targetProxy\"}";
    String getSchedulerDocumentPath = "/_scheduler/docs/_replicator/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSchedulerDocumentOptions model
    GetSchedulerDocumentOptions getSchedulerDocumentOptionsModel = new GetSchedulerDocumentOptions.Builder()
    .docId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SchedulerDocument> response = cloudantService.getSchedulerDocument(getSchedulerDocumentOptionsModel).execute();
    assertNotNull(response);
    SchedulerDocument responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSchedulerDocumentPath);
  }

  // Test the getSchedulerDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSchedulerDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getSchedulerDocument(null).execute();
  }

  @Test
  public void testGetSchedulerJobsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_rows\": 0, \"jobs\": [{\"database\": \"database\", \"doc_id\": \"docId\", \"history\": [{\"timestamp\": \"2019-01-01T12:00:00.000Z\", \"type\": \"type\"}], \"id\": \"id\", \"info\": {\"changes_pending\": 0, \"checkpointed_source_seq\": \"checkpointedSourceSeq\", \"doc_write_failures\": 0, \"docs_read\": 0, \"docs_written\": 0, \"error\": \"error\", \"missing_revisions_found\": 0, \"revisions_checked\": 0, \"source_seq\": \"sourceSeq\", \"through_seq\": \"throughSeq\"}, \"node\": \"node\", \"pid\": \"pid\", \"source\": \"source\", \"start_time\": \"2019-01-01T12:00:00.000Z\", \"target\": \"target\", \"user\": \"user\"}]}";
    String getSchedulerJobsPath = "/_scheduler/jobs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSchedulerJobsOptions model
    GetSchedulerJobsOptions getSchedulerJobsOptionsModel = new GetSchedulerJobsOptions.Builder()
    .limit(Long.valueOf("0"))
    .skip(Long.valueOf("0"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SchedulerJobsResult> response = cloudantService.getSchedulerJobs(getSchedulerJobsOptionsModel).execute();
    assertNotNull(response);
    SchedulerJobsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("0"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSchedulerJobsPath);
  }

  @Test
  public void testGetSchedulerJobWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"database\": \"database\", \"doc_id\": \"docId\", \"history\": [{\"timestamp\": \"2019-01-01T12:00:00.000Z\", \"type\": \"type\"}], \"id\": \"id\", \"info\": {\"changes_pending\": 0, \"checkpointed_source_seq\": \"checkpointedSourceSeq\", \"doc_write_failures\": 0, \"docs_read\": 0, \"docs_written\": 0, \"error\": \"error\", \"missing_revisions_found\": 0, \"revisions_checked\": 0, \"source_seq\": \"sourceSeq\", \"through_seq\": \"throughSeq\"}, \"node\": \"node\", \"pid\": \"pid\", \"source\": \"source\", \"start_time\": \"2019-01-01T12:00:00.000Z\", \"target\": \"target\", \"user\": \"user\"}";
    String getSchedulerJobPath = "/_scheduler/jobs/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSchedulerJobOptions model
    GetSchedulerJobOptions getSchedulerJobOptionsModel = new GetSchedulerJobOptions.Builder()
    .jobId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SchedulerJob> response = cloudantService.getSchedulerJob(getSchedulerJobOptionsModel).execute();
    assertNotNull(response);
    SchedulerJob responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSchedulerJobPath);
  }

  // Test the getSchedulerJob operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSchedulerJobNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getSchedulerJob(null).execute();
  }

  @Test
  public void testGetSessionInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true, \"info\": {\"authenticated\": \"authenticated\", \"authentication_db\": \"authenticationDb\", \"authentication_handlers\": [\"authenticationHandlers\"]}, \"userCtx\": {\"db\": \"db\", \"name\": \"name\", \"roles\": [\"_reader\"]}}";
    String getSessionInformationPath = "/_session";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSessionInformationOptions model
    GetSessionInformationOptions getSessionInformationOptionsModel = new GetSessionInformationOptions();

    // Invoke operation with valid options model (positive test)
    Response<SessionInformation> response = cloudantService.getSessionInformation(getSessionInformationOptionsModel).execute();
    assertNotNull(response);
    SessionInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSessionInformationPath);
  }

  @Test
  public void testGetSecurityWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"admins\": {\"names\": [\"names\"], \"roles\": [\"roles\"]}, \"members\": {\"names\": [\"names\"], \"roles\": [\"roles\"]}, \"cloudant\": {\"mapKey\": [\"_reader\"]}, \"couchdb_auth_only\": false}";
    String getSecurityPath = "/testString/_security";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSecurityOptions model
    GetSecurityOptions getSecurityOptionsModel = new GetSecurityOptions.Builder()
    .db("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Security> response = cloudantService.getSecurity(getSecurityOptionsModel).execute();
    assertNotNull(response);
    Security responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSecurityPath);
  }

  // Test the getSecurity operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSecurityNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getSecurity(null).execute();
  }

  @Test
  public void testPutSecurityWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true}";
    String putSecurityPath = "/testString/_security";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SecurityObject model
    SecurityObject securityObjectModel = new SecurityObject.Builder()
    .names(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .roles(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the PutSecurityOptions model
    PutSecurityOptions putSecurityOptionsModel = new PutSecurityOptions.Builder()
    .db("testString")
    .admins(securityObjectModel)
    .members(securityObjectModel)
    .cloudant(new java.util.HashMap<String, List<String>>() { { put("foo", new java.util.ArrayList<String>(java.util.Arrays.asList("_reader"))); } })
    .couchdbAuthOnly(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Ok> response = cloudantService.putSecurity(putSecurityOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putSecurityPath);
  }

  // Test the putSecurity operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutSecurityNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putSecurity(null).execute();
  }

  @Test
  public void testPostApiKeysWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true, \"key\": \"key\", \"password\": \"password\"}";
    String postApiKeysPath = "/_api/v2/api_keys";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostApiKeysOptions model
    PostApiKeysOptions postApiKeysOptionsModel = new PostApiKeysOptions();

    // Invoke operation with valid options model (positive test)
    Response<ApiKeysResult> response = cloudantService.postApiKeys(postApiKeysOptionsModel).execute();
    assertNotNull(response);
    ApiKeysResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postApiKeysPath);
  }

  @Test
  public void testPutCloudantSecurityConfigurationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true}";
    String putCloudantSecurityConfigurationPath = "/_api/v2/db/testString/_security";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SecurityObject model
    SecurityObject securityObjectModel = new SecurityObject.Builder()
    .names(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .roles(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the PutCloudantSecurityConfigurationOptions model
    PutCloudantSecurityConfigurationOptions putCloudantSecurityConfigurationOptionsModel = new PutCloudantSecurityConfigurationOptions.Builder()
    .db("testString")
    .cloudant(new java.util.HashMap<String, List<String>>() { { put("foo", new java.util.ArrayList<String>(java.util.Arrays.asList("_reader"))); } })
    .admins(securityObjectModel)
    .members(securityObjectModel)
    .couchdbAuthOnly(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Ok> response = cloudantService.putCloudantSecurityConfiguration(putCloudantSecurityConfigurationOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putCloudantSecurityConfigurationPath);
  }

  // Test the putCloudantSecurityConfiguration operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutCloudantSecurityConfigurationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putCloudantSecurityConfiguration(null).execute();
  }

  @Test
  public void testGetCorsInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"allow_credentials\": true, \"enable_cors\": true, \"origins\": [\"origins\"]}";
    String getCorsInformationPath = "/_api/v2/user/config/cors";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCorsInformationOptions model
    GetCorsInformationOptions getCorsInformationOptionsModel = new GetCorsInformationOptions();

    // Invoke operation with valid options model (positive test)
    Response<CorsInformation> response = cloudantService.getCorsInformation(getCorsInformationOptionsModel).execute();
    assertNotNull(response);
    CorsInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCorsInformationPath);
  }

  @Test
  public void testPutCorsConfigurationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true}";
    String putCorsConfigurationPath = "/_api/v2/user/config/cors";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PutCorsConfigurationOptions model
    PutCorsConfigurationOptions putCorsConfigurationOptionsModel = new PutCorsConfigurationOptions.Builder()
    .origins(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .allowCredentials(true)
    .enableCors(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Ok> response = cloudantService.putCorsConfiguration(putCorsConfigurationOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putCorsConfigurationPath);
  }

  // Test the putCorsConfiguration operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutCorsConfigurationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putCorsConfiguration(null).execute();
  }

  @Test
  public void testHeadAttachmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String headAttachmentPath = "/testString/testString/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the HeadAttachmentOptions model
    HeadAttachmentOptions headAttachmentOptionsModel = new HeadAttachmentOptions.Builder()
    .db("testString")
    .docId("testString")
    .attachmentName("testString")
    .ifMatch("testString")
    .ifNoneMatch("testString")
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = cloudantService.headAttachment(headAttachmentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headAttachmentPath);
  }

  // Test the headAttachment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadAttachmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.headAttachment(null).execute();
  }

  @Test
  public void testDeleteAttachmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String deleteAttachmentPath = "/testString/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteAttachmentOptions model
    DeleteAttachmentOptions deleteAttachmentOptionsModel = new DeleteAttachmentOptions.Builder()
    .db("testString")
    .docId("testString")
    .attachmentName("testString")
    .ifMatch("testString")
    .rev("testString")
    .batch("ok")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.deleteAttachment(deleteAttachmentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("rev"), "testString");
    assertEquals(query.get("batch"), "ok");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAttachmentPath);
  }

  // Test the deleteAttachment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAttachmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.deleteAttachment(null).execute();
  }

  @Test
  public void testGetAttachmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String getAttachmentPath = "/testString/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "*/*")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAttachmentOptions model
    GetAttachmentOptions getAttachmentOptionsModel = new GetAttachmentOptions.Builder()
    .db("testString")
    .docId("testString")
    .attachmentName("testString")
    .accept("testString")
    .ifMatch("testString")
    .ifNoneMatch("testString")
    .range("testString")
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = cloudantService.getAttachment(getAttachmentOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAttachmentPath);
  }

  // Test the getAttachment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAttachmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getAttachment(null).execute();
  }

  @Test
  public void testPutAttachmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String putAttachmentPath = "/testString/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PutAttachmentOptions model
    PutAttachmentOptions putAttachmentOptionsModel = new PutAttachmentOptions.Builder()
    .db("testString")
    .docId("testString")
    .attachmentName("testString")
    .attachment(TestUtilities.createMockStream("This is a mock file."))
    .contentType("application/octet-stream")
    .ifMatch("testString")
    .rev("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.putAttachment(putAttachmentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    assertEquals(request.getHeader("Content-Type"), "application/octet-stream");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("rev"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putAttachmentPath);
  }

  // Test the putAttachment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutAttachmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putAttachment(null).execute();
  }

  @Test
  public void testHeadLocalDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String headLocalDocumentPath = "/testString/_local/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the HeadLocalDocumentOptions model
    HeadLocalDocumentOptions headLocalDocumentOptionsModel = new HeadLocalDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .ifNoneMatch("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = cloudantService.headLocalDocument(headLocalDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headLocalDocumentPath);
  }

  // Test the headLocalDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadLocalDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.headLocalDocument(null).execute();
  }

  @Test
  public void testDeleteLocalDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String deleteLocalDocumentPath = "/testString/_local/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteLocalDocumentOptions model
    DeleteLocalDocumentOptions deleteLocalDocumentOptionsModel = new DeleteLocalDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .batch("ok")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.deleteLocalDocument(deleteLocalDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("batch"), "ok");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteLocalDocumentPath);
  }

  // Test the deleteLocalDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteLocalDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.deleteLocalDocument(null).execute();
  }

  @Test
  public void testGetLocalDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}";
    String getLocalDocumentPath = "/testString/_local/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetLocalDocumentOptions model
    GetLocalDocumentOptions getLocalDocumentOptionsModel = new GetLocalDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .accept("application/json")
    .ifNoneMatch("testString")
    .attachments(false)
    .attEncodingInfo(false)
    .localSeq(false)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Document> response = cloudantService.getLocalDocument(getLocalDocumentOptionsModel).execute();
    assertNotNull(response);
    Document responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("local_seq")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLocalDocumentPath);
  }

  // Test the getLocalDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLocalDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getLocalDocument(null).execute();
  }

  @Test
  public void testPutLocalDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\"}";
    String putLocalDocumentPath = "/testString/_local/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
    .contentType("testString")
    .data(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .digest("testString")
    .encodedLength(Long.valueOf("0"))
    .encoding("testString")
    .follows(true)
    .length(Long.valueOf("0"))
    .revpos(Long.valueOf("1"))
    .stub(true)
    .build();

    // Construct an instance of the Revisions model
    Revisions revisionsModel = new Revisions.Builder()
    .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .start(Long.valueOf("1"))
    .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
    .rev("testString")
    .status("available")
    .build();

    // Construct an instance of the Document model
    Document documentModel = new Document.Builder()
    .attachments(new java.util.HashMap<String, Attachment>() { { put("foo", attachmentModel); } })
    .conflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .deleted(true)
    .deletedConflicts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .id("exampleid")
    .localSeq("testString")
    .rev("testString")
    .revisions(revisionsModel)
    .revsInfo(new java.util.ArrayList<DocumentRevisionStatus>(java.util.Arrays.asList(documentRevisionStatusModel)))
    .add("brand", "Foo")
    .add("colours", "[\"red\",\"green\",\"black\",\"blue\"]")
    .add("description", "Slim Colourful Design Electronic Cooking Appliance for ...")
    .add("image", "assets/img/0gmsnghhew.jpg")
    .add("keywords", "[\"Foo\",\"Scales\",\"Weight\",\"Digital\",\"Kitchen\"]")
    .add("name", "Digital Kitchen Scales")
    .add("price", "14.99")
    .add("productid", "1000042")
    .add("taxonomy", "[\"Home\",\"Kitchen\",\"Small Appliances\"]")
    .add("type", "product")
    .build();

    // Construct an instance of the PutLocalDocumentOptions model
    PutLocalDocumentOptions putLocalDocumentOptionsModel = new PutLocalDocumentOptions.Builder()
    .db("testString")
    .docId("testString")
    .document(documentModel)
    .contentType("application/json")
    .batch("ok")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentResult> response = cloudantService.putLocalDocument(putLocalDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("batch"), "ok");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putLocalDocumentPath);
  }

  // Test the putLocalDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutLocalDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.putLocalDocument(null).execute();
  }

  @Test
  public void testPostMissingRevsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"missing_revs\": {\"mapKey\": [\"inner\"]}}";
    String postMissingRevsPath = "/testString/_missing_revs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostMissingRevsOptions model
    PostMissingRevsOptions postMissingRevsOptionsModel = new PostMissingRevsOptions.Builder()
    .db("testString")
    .documentRevisions(new java.util.HashMap<String, List<String>>() { { put("foo", new java.util.ArrayList<String>(java.util.Arrays.asList("testString"))); } })
    .build();

    // Invoke operation with valid options model (positive test)
    Response<MissingRevsResult> response = cloudantService.postMissingRevs(postMissingRevsOptionsModel).execute();
    assertNotNull(response);
    MissingRevsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postMissingRevsPath);
  }

  // Test the postMissingRevs operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostMissingRevsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postMissingRevs(null).execute();
  }

  @Test
  public void testPostRevsDiffWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"mapKey\": {\"missing\": [\"missing\"], \"possible_ancestors\": [\"possibleAncestors\"]}}";
    String postRevsDiffPath = "/testString/_revs_diff";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostRevsDiffOptions model
    PostRevsDiffOptions postRevsDiffOptionsModel = new PostRevsDiffOptions.Builder()
    .db("testString")
    .documentRevisions(new java.util.HashMap<String, List<String>>() { { put("foo", new java.util.ArrayList<String>(java.util.Arrays.asList("testString"))); } })
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Map<String, RevsDiff>> response = cloudantService.postRevsDiff(postRevsDiffOptionsModel).execute();
    assertNotNull(response);
    Map<String, RevsDiff> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postRevsDiffPath);
  }

  // Test the postRevsDiff operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostRevsDiffNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postRevsDiff(null).execute();
  }

  @Test
  public void testGetShardsInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"shards\": {\"mapKey\": [\"inner\"]}}";
    String getShardsInformationPath = "/testString/_shards";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetShardsInformationOptions model
    GetShardsInformationOptions getShardsInformationOptionsModel = new GetShardsInformationOptions.Builder()
    .db("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ShardsInformation> response = cloudantService.getShardsInformation(getShardsInformationOptionsModel).execute();
    assertNotNull(response);
    ShardsInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getShardsInformationPath);
  }

  // Test the getShardsInformation operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetShardsInformationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getShardsInformation(null).execute();
  }

  @Test
  public void testGetDocumentShardsInfoWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"nodes\": [\"nodes\"], \"range\": \"range\"}";
    String getDocumentShardsInfoPath = "/testString/_shards/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDocumentShardsInfoOptions model
    GetDocumentShardsInfoOptions getDocumentShardsInfoOptionsModel = new GetDocumentShardsInfoOptions.Builder()
    .db("testString")
    .docId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentShardInfo> response = cloudantService.getDocumentShardsInfo(getDocumentShardsInfoOptionsModel).execute();
    assertNotNull(response);
    DocumentShardInfo responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentShardsInfoPath);
  }

  // Test the getDocumentShardsInfo operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentShardsInfoNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.getDocumentShardsInfo(null).execute();
  }

  @Test
  public void testHeadUpInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String headUpInformationPath = "/_up";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the HeadUpInformationOptions model
    HeadUpInformationOptions headUpInformationOptionsModel = new HeadUpInformationOptions();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = cloudantService.headUpInformation(headUpInformationOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headUpInformationPath);
  }

  @Test
  public void testGetActiveTasksWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"changes_done\": 0, \"database\": \"database\", \"node\": \"node\", \"pid\": \"pid\", \"progress\": 0, \"started_on\": 0, \"status\": \"status\", \"task\": \"task\", \"total_changes\": 0, \"type\": \"type\", \"updated_on\": 0}]";
    String getActiveTasksPath = "/_active_tasks";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetActiveTasksOptions model
    GetActiveTasksOptions getActiveTasksOptionsModel = new GetActiveTasksOptions();

    // Invoke operation with valid options model (positive test)
    Response<List<ActiveTask>> response = cloudantService.getActiveTasks(getActiveTasksOptionsModel).execute();
    assertNotNull(response);
    List<ActiveTask> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getActiveTasksPath);
  }

  @Test
  public void testGetUpInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"seeds\": {\"mapKey\": \"anyValue\"}, \"status\": \"maintenance_mode\"}";
    String getUpInformationPath = "/_up";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetUpInformationOptions model
    GetUpInformationOptions getUpInformationOptionsModel = new GetUpInformationOptions();

    // Invoke operation with valid options model (positive test)
    Response<UpInformation> response = cloudantService.getUpInformation(getUpInformationOptionsModel).execute();
    assertNotNull(response);
    UpInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getUpInformationPath);
  }

  @Test
  public void testGetActivityTrackerEventsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"types\": [\"management\"]}";
    String getActivityTrackerEventsPath = "/_api/v2/user/activity_tracker/events";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetActivityTrackerEventsOptions model
    GetActivityTrackerEventsOptions getActivityTrackerEventsOptionsModel = new GetActivityTrackerEventsOptions();

    // Invoke operation with valid options model (positive test)
    Response<ActivityTrackerEvents> response = cloudantService.getActivityTrackerEvents(getActivityTrackerEventsOptionsModel).execute();
    assertNotNull(response);
    ActivityTrackerEvents responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getActivityTrackerEventsPath);
  }

  @Test
  public void testPostActivityTrackerEventsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ok\": true}";
    String postActivityTrackerEventsPath = "/_api/v2/user/activity_tracker/events";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostActivityTrackerEventsOptions model
    PostActivityTrackerEventsOptions postActivityTrackerEventsOptionsModel = new PostActivityTrackerEventsOptions.Builder()
    .types(new java.util.ArrayList<String>(java.util.Arrays.asList("management")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Ok> response = cloudantService.postActivityTrackerEvents(postActivityTrackerEventsOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postActivityTrackerEventsPath);
  }

  // Test the postActivityTrackerEvents operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostActivityTrackerEventsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    cloudantService.postActivityTrackerEvents(null).execute();
  }

  @Test
  public void testGetCurrentThroughputInformationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"throughput\": {\"query\": 0, \"read\": 0, \"write\": 0}}";
    String getCurrentThroughputInformationPath = "/_api/v2/user/current/throughput";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCurrentThroughputInformationOptions model
    GetCurrentThroughputInformationOptions getCurrentThroughputInformationOptionsModel = new GetCurrentThroughputInformationOptions();

    // Invoke operation with valid options model (positive test)
    Response<CurrentThroughputInformation> response = cloudantService.getCurrentThroughputInformation(getCurrentThroughputInformationOptionsModel).execute();
    assertNotNull(response);
    CurrentThroughputInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCurrentThroughputInformationPath);
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    cloudantService = null;
  }
}