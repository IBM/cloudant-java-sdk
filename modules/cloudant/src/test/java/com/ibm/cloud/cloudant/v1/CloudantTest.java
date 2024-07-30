/*
 * (C) Copyright IBM Corp. 2024.
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
import com.ibm.cloud.cloudant.v1.model.ExplainResultMrArgs;
import com.ibm.cloud.cloudant.v1.model.ExplainResultOpts;
import com.ibm.cloud.cloudant.v1.model.FindResult;
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
import com.ibm.cloud.cloudant.v1.model.IndexAnalysis;
import com.ibm.cloud.cloudant.v1.model.IndexAnalysisExclusionReason;
import com.ibm.cloud.cloudant.v1.model.IndexCandidate;
import com.ibm.cloud.cloudant.v1.model.IndexDefinition;
import com.ibm.cloud.cloudant.v1.model.IndexField;
import com.ibm.cloud.cloudant.v1.model.IndexInformation;
import com.ibm.cloud.cloudant.v1.model.IndexResult;
import com.ibm.cloud.cloudant.v1.model.IndexTextOperatorDefaultField;
import com.ibm.cloud.cloudant.v1.model.IndexesInformation;
import com.ibm.cloud.cloudant.v1.model.MembershipInformation;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PartitionInformation;
import com.ibm.cloud.cloudant.v1.model.PartitionInformationIndexes;
import com.ibm.cloud.cloudant.v1.model.PartitionInformationIndexesIndexes;
import com.ibm.cloud.cloudant.v1.model.PartitionInformationSizes;
import com.ibm.cloud.cloudant.v1.model.PartitionedIndexesDetailedInformation;
import com.ibm.cloud.cloudant.v1.model.PartitionedIndexesInformation;
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
import com.ibm.cloud.cloudant.v1.model.PostIndexOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionExplainOptions;
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
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthBasic;
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
import com.ibm.cloud.cloudant.v1.model.SelectorHint;
import com.ibm.cloud.cloudant.v1.model.ServerInformation;
import com.ibm.cloud.cloudant.v1.model.ServerVendor;
import com.ibm.cloud.cloudant.v1.model.SessionAuthentication;
import com.ibm.cloud.cloudant.v1.model.SessionInformation;
import com.ibm.cloud.cloudant.v1.model.ShardsInformation;
import com.ibm.cloud.cloudant.v1.model.ThroughputInformation;
import com.ibm.cloud.cloudant.v1.model.UpInformation;
import com.ibm.cloud.cloudant.v1.model.UpdatesPending;
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
import com.ibm.cloud.sdk.core.util.RequestUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Cloudant service.
 */
public class CloudantTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected Cloudant cloudantService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new Cloudant(serviceName, null);
  }

  // Test the getServerInformation operation with a valid options model parameter
  @Test
  public void testGetServerInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"couchdb\": \"couchdb\", \"features\": [\"features\"], \"vendor\": {\"name\": \"name\", \"variant\": \"variant\", \"version\": \"version\"}, \"version\": \"version\", \"features_flags\": [\"featuresFlags\"]}";
    String getServerInformationPath = "/";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetServerInformationOptions model
    GetServerInformationOptions getServerInformationOptionsModel = new GetServerInformationOptions();

    // Invoke getServerInformation() with a valid options model and verify the result
    Response<ServerInformation> response = cloudantService.getServerInformation(getServerInformationOptionsModel).execute();
    assertNotNull(response);
    ServerInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getServerInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getServerInformation operation with and without retries enabled
  @Test
  public void testGetServerInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetServerInformationWOptions();

    cloudantService.disableRetries();
    testGetServerInformationWOptions();
  }

  // Test the getMembershipInformation operation with a valid options model parameter
  @Test
  public void testGetMembershipInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"all_nodes\": [\"allNodes\"], \"cluster_nodes\": [\"clusterNodes\"]}";
    String getMembershipInformationPath = "/_membership";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetMembershipInformationOptions model
    GetMembershipInformationOptions getMembershipInformationOptionsModel = new GetMembershipInformationOptions();

    // Invoke getMembershipInformation() with a valid options model and verify the result
    Response<MembershipInformation> response = cloudantService.getMembershipInformation(getMembershipInformationOptionsModel).execute();
    assertNotNull(response);
    MembershipInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMembershipInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getMembershipInformation operation with and without retries enabled
  @Test
  public void testGetMembershipInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetMembershipInformationWOptions();

    cloudantService.disableRetries();
    testGetMembershipInformationWOptions();
  }

  // Test the getUuids operation with a valid options model parameter
  @Test
  public void testGetUuidsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"uuids\": [\"uuids\"]}";
    String getUuidsPath = "/_uuids";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetUuidsOptions model
    GetUuidsOptions getUuidsOptionsModel = new GetUuidsOptions.Builder()
      .count(Long.valueOf("1"))
      .build();

    // Invoke getUuids() with a valid options model and verify the result
    Response<UuidsResult> response = cloudantService.getUuids(getUuidsOptionsModel).execute();
    assertNotNull(response);
    UuidsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getUuidsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("1"));
  }

  // Test the getUuids operation with and without retries enabled
  @Test
  public void testGetUuidsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetUuidsWOptions();

    cloudantService.disableRetries();
    testGetUuidsWOptions();
  }

  // Test the getCapacityThroughputInformation operation with a valid options model parameter
  @Test
  public void testGetCapacityThroughputInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"current\": {\"throughput\": {\"blocks\": 0, \"query\": 0, \"read\": 0, \"write\": 0}}, \"target\": {\"throughput\": {\"blocks\": 0, \"query\": 0, \"read\": 0, \"write\": 0}}}";
    String getCapacityThroughputInformationPath = "/_api/v2/user/capacity/throughput";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetCapacityThroughputInformationOptions model
    GetCapacityThroughputInformationOptions getCapacityThroughputInformationOptionsModel = new GetCapacityThroughputInformationOptions();

    // Invoke getCapacityThroughputInformation() with a valid options model and verify the result
    Response<CapacityThroughputInformation> response = cloudantService.getCapacityThroughputInformation(getCapacityThroughputInformationOptionsModel).execute();
    assertNotNull(response);
    CapacityThroughputInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCapacityThroughputInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getCapacityThroughputInformation operation with and without retries enabled
  @Test
  public void testGetCapacityThroughputInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetCapacityThroughputInformationWOptions();

    cloudantService.disableRetries();
    testGetCapacityThroughputInformationWOptions();
  }

  // Test the putCapacityThroughputConfiguration operation with a valid options model parameter
  @Test
  public void testPutCapacityThroughputConfigurationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"current\": {\"throughput\": {\"blocks\": 0, \"query\": 0, \"read\": 0, \"write\": 0}}, \"target\": {\"throughput\": {\"blocks\": 0, \"query\": 0, \"read\": 0, \"write\": 0}}}";
    String putCapacityThroughputConfigurationPath = "/_api/v2/user/capacity/throughput";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PutCapacityThroughputConfigurationOptions model
    PutCapacityThroughputConfigurationOptions putCapacityThroughputConfigurationOptionsModel = new PutCapacityThroughputConfigurationOptions.Builder()
      .blocks(Long.valueOf("10"))
      .build();

    // Invoke putCapacityThroughputConfiguration() with a valid options model and verify the result
    Response<CapacityThroughputInformation> response = cloudantService.putCapacityThroughputConfiguration(putCapacityThroughputConfigurationOptionsModel).execute();
    assertNotNull(response);
    CapacityThroughputInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putCapacityThroughputConfigurationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the putCapacityThroughputConfiguration operation with and without retries enabled
  @Test
  public void testPutCapacityThroughputConfigurationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutCapacityThroughputConfigurationWOptions();

    cloudantService.disableRetries();
    testPutCapacityThroughputConfigurationWOptions();
  }

  // Test the putCapacityThroughputConfiguration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutCapacityThroughputConfigurationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putCapacityThroughputConfiguration(null).execute();
  }

  // Test the getDbUpdates operation with a valid options model parameter
  @Test
  public void testGetDbUpdatesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"last_seq\": \"lastSeq\", \"results\": [{\"db_name\": \"dbName\", \"seq\": \"seq\", \"type\": \"created\"}]}";
    String getDbUpdatesPath = "/_db_updates";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetDbUpdatesOptions model
    GetDbUpdatesOptions getDbUpdatesOptionsModel = new GetDbUpdatesOptions.Builder()
      .descending(false)
      .feed("normal")
      .heartbeat(Long.valueOf("0"))
      .limit(Long.valueOf("0"))
      .timeout(Long.valueOf("60000"))
      .since("0")
      .build();

    // Invoke getDbUpdates() with a valid options model and verify the result
    Response<DbUpdates> response = cloudantService.getDbUpdates(getDbUpdatesOptionsModel).execute();
    assertNotNull(response);
    DbUpdates responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDbUpdatesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("descending")), Boolean.valueOf(false));
    assertEquals(query.get("feed"), "normal");
    assertEquals(Long.valueOf(query.get("heartbeat")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("60000"));
    assertEquals(query.get("since"), "0");
  }

  // Test the getDbUpdates operation with and without retries enabled
  @Test
  public void testGetDbUpdatesWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetDbUpdatesWOptions();

    cloudantService.disableRetries();
    testGetDbUpdatesWOptions();
  }

  // Test the postChanges operation with a valid options model parameter
  @Test
  public void testPostChangesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"last_seq\": \"lastSeq\", \"pending\": 7, \"results\": [{\"changes\": [{\"rev\": \"rev\"}], \"deleted\": false, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"seq\": \"seq\"}]}";
    String postChangesPath = "/testString/_changes";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostChangesOptions model
    PostChangesOptions postChangesOptionsModel = new PostChangesOptions.Builder()
      .db("testString")
      .docIds(java.util.Arrays.asList("0007741142412418284"))
      .fields(java.util.Arrays.asList("testString"))
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
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
      .timeout(Long.valueOf("60000"))
      .view("testString")
      .build();

    // Invoke postChanges() with a valid options model and verify the result
    Response<ChangesResult> response = cloudantService.postChanges(postChangesOptionsModel).execute();
    assertNotNull(response);
    ChangesResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postChangesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
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
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("60000"));
    assertEquals(query.get("view"), "testString");
  }

  // Test the postChanges operation with and without retries enabled
  @Test
  public void testPostChangesWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostChangesWOptions();

    cloudantService.disableRetries();
    testPostChangesWOptions();
  }

  // Test the postChanges operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostChangesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postChanges(null).execute();
  }

  // Test the postChangesAsStream operation with a valid options model parameter
  @Test
  public void testPostChangesAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postChangesAsStreamPath = "/testString/_changes";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostChangesOptions model
    PostChangesOptions postChangesOptionsModel = new PostChangesOptions.Builder()
      .db("testString")
      .docIds(java.util.Arrays.asList("0007741142412418284"))
      .fields(java.util.Arrays.asList("testString"))
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
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
      .timeout(Long.valueOf("60000"))
      .view("testString")
      .build();

    // Invoke postChangesAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postChangesAsStream(postChangesOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postChangesAsStreamPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
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
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("60000"));
    assertEquals(query.get("view"), "testString");
  }

  // Test the postChangesAsStream operation with and without retries enabled
  @Test
  public void testPostChangesAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostChangesAsStreamWOptions();

    cloudantService.disableRetries();
    testPostChangesAsStreamWOptions();
  }

  // Test the postChangesAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostChangesAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postChangesAsStream(null).execute();
  }

  // Test the headDatabase operation with a valid options model parameter
  @Test
  public void testHeadDatabaseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String headDatabasePath = "/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the HeadDatabaseOptions model
    HeadDatabaseOptions headDatabaseOptionsModel = new HeadDatabaseOptions.Builder()
      .db("testString")
      .build();

    // Invoke headDatabase() with a valid options model and verify the result
    Response<Void> response = cloudantService.headDatabase(headDatabaseOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headDatabasePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the headDatabase operation with and without retries enabled
  @Test
  public void testHeadDatabaseWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testHeadDatabaseWOptions();

    cloudantService.disableRetries();
    testHeadDatabaseWOptions();
  }

  // Test the headDatabase operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadDatabaseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.headDatabase(null).execute();
  }

  // Test the getAllDbs operation with a valid options model parameter
  @Test
  public void testGetAllDbsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "[\"operationResponse\"]";
    String getAllDbsPath = "/_all_dbs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAllDbsOptions model
    GetAllDbsOptions getAllDbsOptionsModel = new GetAllDbsOptions.Builder()
      .descending(false)
      .endKey("testString")
      .limit(Long.valueOf("0"))
      .skip(Long.valueOf("0"))
      .startKey("testString")
      .build();

    // Invoke getAllDbs() with a valid options model and verify the result
    Response<List<String>> response = cloudantService.getAllDbs(getAllDbsOptionsModel).execute();
    assertNotNull(response);
    List<String> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAllDbsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("descending")), Boolean.valueOf(false));
    assertEquals(query.get("end_key"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("0"));
    assertEquals(query.get("start_key"), "testString");
  }

  // Test the getAllDbs operation with and without retries enabled
  @Test
  public void testGetAllDbsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetAllDbsWOptions();

    cloudantService.disableRetries();
    testGetAllDbsWOptions();
  }

  // Test the postDbsInfo operation with a valid options model parameter
  @Test
  public void testPostDbsInfoWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "[{\"error\": \"error\", \"info\": {\"cluster\": {\"n\": 3, \"q\": 1, \"r\": 1, \"w\": 1}, \"committed_update_seq\": \"committedUpdateSeq\", \"compact_running\": true, \"compacted_seq\": \"compactedSeq\", \"db_name\": \"dbName\", \"disk_format_version\": 17, \"doc_count\": 0, \"doc_del_count\": 0, \"engine\": \"engine\", \"instance_start_time\": \"instanceStartTime\", \"props\": {\"partitioned\": false}, \"sizes\": {\"active\": 6, \"external\": 8, \"file\": 4}, \"update_seq\": \"updateSeq\", \"uuid\": \"uuid\", \"partitioned_indexes\": {\"count\": 0, \"indexes\": {\"search\": 0, \"view\": 0}, \"limit\": 10}}, \"key\": \"key\"}]";
    String postDbsInfoPath = "/_dbs_info";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostDbsInfoOptions model
    PostDbsInfoOptions postDbsInfoOptionsModel = new PostDbsInfoOptions.Builder()
      .keys(java.util.Arrays.asList("products", "users", "orders"))
      .build();

    // Invoke postDbsInfo() with a valid options model and verify the result
    Response<List<DbsInfoResult>> response = cloudantService.postDbsInfo(postDbsInfoOptionsModel).execute();
    assertNotNull(response);
    List<DbsInfoResult> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postDbsInfoPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postDbsInfo operation with and without retries enabled
  @Test
  public void testPostDbsInfoWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostDbsInfoWOptions();

    cloudantService.disableRetries();
    testPostDbsInfoWOptions();
  }

  // Test the postDbsInfo operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDbsInfoNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postDbsInfo(null).execute();
  }

  // Test the deleteDatabase operation with a valid options model parameter
  @Test
  public void testDeleteDatabaseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ok\": true}";
    String deleteDatabasePath = "/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteDatabaseOptions model
    DeleteDatabaseOptions deleteDatabaseOptionsModel = new DeleteDatabaseOptions.Builder()
      .db("testString")
      .build();

    // Invoke deleteDatabase() with a valid options model and verify the result
    Response<Ok> response = cloudantService.deleteDatabase(deleteDatabaseOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDatabasePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteDatabase operation with and without retries enabled
  @Test
  public void testDeleteDatabaseWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testDeleteDatabaseWOptions();

    cloudantService.disableRetries();
    testDeleteDatabaseWOptions();
  }

  // Test the deleteDatabase operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDatabaseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.deleteDatabase(null).execute();
  }

  // Test the getDatabaseInformation operation with a valid options model parameter
  @Test
  public void testGetDatabaseInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"cluster\": {\"n\": 3, \"q\": 1, \"r\": 1, \"w\": 1}, \"committed_update_seq\": \"committedUpdateSeq\", \"compact_running\": true, \"compacted_seq\": \"compactedSeq\", \"db_name\": \"dbName\", \"disk_format_version\": 17, \"doc_count\": 0, \"doc_del_count\": 0, \"engine\": \"engine\", \"instance_start_time\": \"instanceStartTime\", \"props\": {\"partitioned\": false}, \"sizes\": {\"active\": 6, \"external\": 8, \"file\": 4}, \"update_seq\": \"updateSeq\", \"uuid\": \"uuid\", \"partitioned_indexes\": {\"count\": 0, \"indexes\": {\"search\": 0, \"view\": 0}, \"limit\": 10}}";
    String getDatabaseInformationPath = "/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetDatabaseInformationOptions model
    GetDatabaseInformationOptions getDatabaseInformationOptionsModel = new GetDatabaseInformationOptions.Builder()
      .db("testString")
      .build();

    // Invoke getDatabaseInformation() with a valid options model and verify the result
    Response<DatabaseInformation> response = cloudantService.getDatabaseInformation(getDatabaseInformationOptionsModel).execute();
    assertNotNull(response);
    DatabaseInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDatabaseInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getDatabaseInformation operation with and without retries enabled
  @Test
  public void testGetDatabaseInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetDatabaseInformationWOptions();

    cloudantService.disableRetries();
    testGetDatabaseInformationWOptions();
  }

  // Test the getDatabaseInformation operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDatabaseInformationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getDatabaseInformation(null).execute();
  }

  // Test the putDatabase operation with a valid options model parameter
  @Test
  public void testPutDatabaseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ok\": true}";
    String putDatabasePath = "/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the PutDatabaseOptions model
    PutDatabaseOptions putDatabaseOptionsModel = new PutDatabaseOptions.Builder()
      .db("testString")
      .partitioned(false)
      .q(Long.valueOf("26"))
      .build();

    // Invoke putDatabase() with a valid options model and verify the result
    Response<Ok> response = cloudantService.putDatabase(putDatabaseOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putDatabasePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("partitioned")), Boolean.valueOf(false));
    assertEquals(Long.valueOf(query.get("q")), Long.valueOf("26"));
  }

  // Test the putDatabase operation with and without retries enabled
  @Test
  public void testPutDatabaseWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutDatabaseWOptions();

    cloudantService.disableRetries();
    testPutDatabaseWOptions();
  }

  // Test the putDatabase operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutDatabaseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putDatabase(null).execute();
  }

  // Test the headDocument operation with a valid options model parameter
  @Test
  public void testHeadDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String headDocumentPath = "/testString/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the HeadDocumentOptions model
    HeadDocumentOptions headDocumentOptionsModel = new HeadDocumentOptions.Builder()
      .db("testString")
      .docId("testString")
      .ifNoneMatch("testString")
      .latest(false)
      .rev("testString")
      .build();

    // Invoke headDocument() with a valid options model and verify the result
    Response<Void> response = cloudantService.headDocument(headDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
  }

  // Test the headDocument operation with and without retries enabled
  @Test
  public void testHeadDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testHeadDocumentWOptions();

    cloudantService.disableRetries();
    testHeadDocumentWOptions();
  }

  // Test the headDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.headDocument(null).execute();
  }

  // Test the postDocument operation with a valid options model parameter
  @Test
  public void testPostDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String postDocumentPath = "/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
      .contentType("testString")
      .data(TestUtilities.createMockByteArray("VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4="))
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
      .ids(java.util.Arrays.asList("testString"))
      .start(Long.valueOf("1"))
      .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
      .rev("testString")
      .status("available")
      .build();

    // Construct an instance of the Document model
    Document documentModel = new Document.Builder()
      .attachments(java.util.Collections.singletonMap("key1", attachmentModel))
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("exampleid")
      .localSeq("testString")
      .rev("testString")
      .revisions(revisionsModel)
      .revsInfo(java.util.Arrays.asList(documentRevisionStatusModel))
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

    // Construct an instance of the PostDocumentOptions model
    PostDocumentOptions postDocumentOptionsModel = new PostDocumentOptions.Builder()
      .db("testString")
      .document(documentModel)
      .contentType("application/json")
      .batch("ok")
      .build();

    // Invoke postDocument() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.postDocument(postDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("batch"), "ok");
  }

  // Test the postDocument operation with and without retries enabled
  @Test
  public void testPostDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostDocumentWOptions();

    cloudantService.disableRetries();
    testPostDocumentWOptions();
  }

  // Test the postDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postDocument(null).execute();
  }

  // Test the postAllDocs operation with a valid options model parameter
  @Test
  public void testPostAllDocsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"deleted\": false, \"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}";
    String postAllDocsPath = "/testString/_all_docs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .key("testString")
      .keys(java.util.Arrays.asList("testString"))
      .startKey("0007741142412418284")
      .build();

    // Invoke postAllDocs() with a valid options model and verify the result
    Response<AllDocsResult> response = cloudantService.postAllDocs(postAllDocsOptionsModel).execute();
    assertNotNull(response);
    AllDocsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postAllDocsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postAllDocs operation with and without retries enabled
  @Test
  public void testPostAllDocsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostAllDocsWOptions();

    cloudantService.disableRetries();
    testPostAllDocsWOptions();
  }

  // Test the postAllDocs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostAllDocsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postAllDocs(null).execute();
  }

  // Test the postAllDocsAsStream operation with a valid options model parameter
  @Test
  public void testPostAllDocsAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postAllDocsAsStreamPath = "/testString/_all_docs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .key("testString")
      .keys(java.util.Arrays.asList("testString"))
      .startKey("0007741142412418284")
      .build();

    // Invoke postAllDocsAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postAllDocsAsStream(postAllDocsOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postAllDocsAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postAllDocsAsStream operation with and without retries enabled
  @Test
  public void testPostAllDocsAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostAllDocsAsStreamWOptions();

    cloudantService.disableRetries();
    testPostAllDocsAsStreamWOptions();
  }

  // Test the postAllDocsAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostAllDocsAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postAllDocsAsStream(null).execute();
  }

  // Test the postAllDocsQueries operation with a valid options model parameter
  @Test
  public void testPostAllDocsQueriesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"results\": [{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"deleted\": false, \"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}]}";
    String postAllDocsQueriesPath = "/testString/_all_docs/queries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .key("testString")
      .keys(java.util.Arrays.asList("small-appliances:1000042", "small-appliances:1000043"))
      .startKey("testString")
      .build();

    // Construct an instance of the PostAllDocsQueriesOptions model
    PostAllDocsQueriesOptions postAllDocsQueriesOptionsModel = new PostAllDocsQueriesOptions.Builder()
      .db("testString")
      .queries(java.util.Arrays.asList(allDocsQueryModel))
      .build();

    // Invoke postAllDocsQueries() with a valid options model and verify the result
    Response<AllDocsQueriesResult> response = cloudantService.postAllDocsQueries(postAllDocsQueriesOptionsModel).execute();
    assertNotNull(response);
    AllDocsQueriesResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postAllDocsQueriesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postAllDocsQueries operation with and without retries enabled
  @Test
  public void testPostAllDocsQueriesWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostAllDocsQueriesWOptions();

    cloudantService.disableRetries();
    testPostAllDocsQueriesWOptions();
  }

  // Test the postAllDocsQueries operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostAllDocsQueriesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postAllDocsQueries(null).execute();
  }

  // Test the postAllDocsQueriesAsStream operation with a valid options model parameter
  @Test
  public void testPostAllDocsQueriesAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postAllDocsQueriesAsStreamPath = "/testString/_all_docs/queries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .key("testString")
      .keys(java.util.Arrays.asList("small-appliances:1000042", "small-appliances:1000043"))
      .startKey("testString")
      .build();

    // Construct an instance of the PostAllDocsQueriesOptions model
    PostAllDocsQueriesOptions postAllDocsQueriesOptionsModel = new PostAllDocsQueriesOptions.Builder()
      .db("testString")
      .queries(java.util.Arrays.asList(allDocsQueryModel))
      .build();

    // Invoke postAllDocsQueriesAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postAllDocsQueriesAsStream(postAllDocsQueriesOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postAllDocsQueriesAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postAllDocsQueriesAsStream operation with and without retries enabled
  @Test
  public void testPostAllDocsQueriesAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostAllDocsQueriesAsStreamWOptions();

    cloudantService.disableRetries();
    testPostAllDocsQueriesAsStreamWOptions();
  }

  // Test the postAllDocsQueriesAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostAllDocsQueriesAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postAllDocsQueriesAsStream(null).execute();
  }

  // Test the postBulkDocs operation with a valid options model parameter
  @Test
  public void testPostBulkDocsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "[{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}]";
    String postBulkDocsPath = "/testString/_bulk_docs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
      .contentType("testString")
      .data(TestUtilities.createMockByteArray("VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4="))
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
      .ids(java.util.Arrays.asList("testString"))
      .start(Long.valueOf("1"))
      .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
      .rev("testString")
      .status("available")
      .build();

    // Construct an instance of the Document model
    Document documentModel = new Document.Builder()
      .attachments(java.util.Collections.singletonMap("key1", attachmentModel))
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("0007241142412418284")
      .localSeq("testString")
      .rev("testString")
      .revisions(revisionsModel)
      .revsInfo(java.util.Arrays.asList(documentRevisionStatusModel))
      .add("date", "2019-01-28T10:44:22.000Z")
      .add("eventType", "addedToBasket")
      .add("productId", "1000042")
      .add("type", "event")
      .add("userid", "abc123")
      .build();

    // Construct an instance of the BulkDocs model
    BulkDocs bulkDocsModel = new BulkDocs.Builder()
      .docs(java.util.Arrays.asList(documentModel))
      .newEdits(true)
      .build();

    // Construct an instance of the PostBulkDocsOptions model
    PostBulkDocsOptions postBulkDocsOptionsModel = new PostBulkDocsOptions.Builder()
      .db("testString")
      .bulkDocs(bulkDocsModel)
      .build();

    // Invoke postBulkDocs() with a valid options model and verify the result
    Response<List<DocumentResult>> response = cloudantService.postBulkDocs(postBulkDocsOptionsModel).execute();
    assertNotNull(response);
    List<DocumentResult> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkDocsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postBulkDocs operation with and without retries enabled
  @Test
  public void testPostBulkDocsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostBulkDocsWOptions();

    cloudantService.disableRetries();
    testPostBulkDocsWOptions();
  }

  // Test the postBulkDocs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkDocsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postBulkDocs(null).execute();
  }

  // Test the postBulkGet operation with a valid options model parameter
  @Test
  public void testPostBulkGetWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"results\": [{\"docs\": [{\"error\": {\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}, \"ok\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}}], \"id\": \"id\"}]}";
    String postBulkGetPath = "/testString/_bulk_get";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the BulkGetQueryDocument model
    BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
      .attsSince(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"))
      .id("order00067")
      .rev("3-917fa2381192822767f010b95b45325b")
      .build();

    // Construct an instance of the PostBulkGetOptions model
    PostBulkGetOptions postBulkGetOptionsModel = new PostBulkGetOptions.Builder()
      .db("testString")
      .docs(java.util.Arrays.asList(bulkGetQueryDocumentModel))
      .attachments(false)
      .attEncodingInfo(false)
      .latest(false)
      .revs(false)
      .build();

    // Invoke postBulkGet() with a valid options model and verify the result
    Response<BulkGetResult> response = cloudantService.postBulkGet(postBulkGetOptionsModel).execute();
    assertNotNull(response);
    BulkGetResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkGetPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
  }

  // Test the postBulkGet operation with and without retries enabled
  @Test
  public void testPostBulkGetWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostBulkGetWOptions();

    cloudantService.disableRetries();
    testPostBulkGetWOptions();
  }

  // Test the postBulkGet operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkGetNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postBulkGet(null).execute();
  }

  // Test the postBulkGetAsMixed operation with a valid options model parameter
  @Test
  public void testPostBulkGetAsMixedWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String postBulkGetAsMixedPath = "/testString/_bulk_get";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "multipart/mixed")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the BulkGetQueryDocument model
    BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
      .attsSince(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"))
      .id("order00067")
      .rev("3-917fa2381192822767f010b95b45325b")
      .build();

    // Construct an instance of the PostBulkGetOptions model
    PostBulkGetOptions postBulkGetOptionsModel = new PostBulkGetOptions.Builder()
      .db("testString")
      .docs(java.util.Arrays.asList(bulkGetQueryDocumentModel))
      .attachments(false)
      .attEncodingInfo(false)
      .latest(false)
      .revs(false)
      .build();

    // Invoke postBulkGetAsMixed() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postBulkGetAsMixed(postBulkGetOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertNotNull(responseObj);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkGetAsMixedPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
  }

  // Test the postBulkGetAsMixed operation with and without retries enabled
  @Test
  public void testPostBulkGetAsMixedWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostBulkGetAsMixedWOptions();

    cloudantService.disableRetries();
    testPostBulkGetAsMixedWOptions();
  }

  // Test the postBulkGetAsMixed operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkGetAsMixedNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postBulkGetAsMixed(null).execute();
  }

  // Test the postBulkGetAsRelated operation with a valid options model parameter
  @Test
  public void testPostBulkGetAsRelatedWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String postBulkGetAsRelatedPath = "/testString/_bulk_get";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "multipart/related")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the BulkGetQueryDocument model
    BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
      .attsSince(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"))
      .id("order00067")
      .rev("3-917fa2381192822767f010b95b45325b")
      .build();

    // Construct an instance of the PostBulkGetOptions model
    PostBulkGetOptions postBulkGetOptionsModel = new PostBulkGetOptions.Builder()
      .db("testString")
      .docs(java.util.Arrays.asList(bulkGetQueryDocumentModel))
      .attachments(false)
      .attEncodingInfo(false)
      .latest(false)
      .revs(false)
      .build();

    // Invoke postBulkGetAsRelated() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postBulkGetAsRelated(postBulkGetOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertNotNull(responseObj);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkGetAsRelatedPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
  }

  // Test the postBulkGetAsRelated operation with and without retries enabled
  @Test
  public void testPostBulkGetAsRelatedWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostBulkGetAsRelatedWOptions();

    cloudantService.disableRetries();
    testPostBulkGetAsRelatedWOptions();
  }

  // Test the postBulkGetAsRelated operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkGetAsRelatedNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postBulkGetAsRelated(null).execute();
  }

  // Test the postBulkGetAsStream operation with a valid options model parameter
  @Test
  public void testPostBulkGetAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postBulkGetAsStreamPath = "/testString/_bulk_get";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the BulkGetQueryDocument model
    BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
      .attsSince(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"))
      .id("order00067")
      .rev("3-917fa2381192822767f010b95b45325b")
      .build();

    // Construct an instance of the PostBulkGetOptions model
    PostBulkGetOptions postBulkGetOptionsModel = new PostBulkGetOptions.Builder()
      .db("testString")
      .docs(java.util.Arrays.asList(bulkGetQueryDocumentModel))
      .attachments(false)
      .attEncodingInfo(false)
      .latest(false)
      .revs(false)
      .build();

    // Invoke postBulkGetAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postBulkGetAsStream(postBulkGetOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postBulkGetAsStreamPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("latest")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("revs")), Boolean.valueOf(false));
  }

  // Test the postBulkGetAsStream operation with and without retries enabled
  @Test
  public void testPostBulkGetAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostBulkGetAsStreamWOptions();

    cloudantService.disableRetries();
    testPostBulkGetAsStreamWOptions();
  }

  // Test the postBulkGetAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostBulkGetAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postBulkGetAsStream(null).execute();
  }

  // Test the deleteDocument operation with a valid options model parameter
  @Test
  public void testDeleteDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String deleteDocumentPath = "/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteDocumentOptions model
    DeleteDocumentOptions deleteDocumentOptionsModel = new DeleteDocumentOptions.Builder()
      .db("testString")
      .docId("testString")
      .ifMatch("testString")
      .batch("ok")
      .rev("testString")
      .build();

    // Invoke deleteDocument() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.deleteDocument(deleteDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("batch"), "ok");
    assertEquals(query.get("rev"), "testString");
  }

  // Test the deleteDocument operation with and without retries enabled
  @Test
  public void testDeleteDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testDeleteDocumentWOptions();

    cloudantService.disableRetries();
    testDeleteDocumentWOptions();
  }

  // Test the deleteDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.deleteDocument(null).execute();
  }

  // Test the getDocument operation with a valid options model parameter
  @Test
  public void testGetDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}";
    String getDocumentPath = "/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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

    // Invoke getDocument() with a valid options model and verify the result
    Response<Document> response = cloudantService.getDocument(getDocumentOptionsModel).execute();
    assertNotNull(response);
    Document responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
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
  }

  // Test the getDocument operation with and without retries enabled
  @Test
  public void testGetDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetDocumentWOptions();

    cloudantService.disableRetries();
    testGetDocumentWOptions();
  }

  // Test the getDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getDocument(null).execute();
  }

  // Test the getDocumentAsMixed operation with a valid options model parameter
  @Test
  public void testGetDocumentAsMixedWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String getDocumentAsMixedPath = "/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "multipart/mixed")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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

    // Invoke getDocumentAsMixed() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.getDocumentAsMixed(getDocumentOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertNotNull(responseObj);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentAsMixedPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
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
  }

  // Test the getDocumentAsMixed operation with and without retries enabled
  @Test
  public void testGetDocumentAsMixedWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetDocumentAsMixedWOptions();

    cloudantService.disableRetries();
    testGetDocumentAsMixedWOptions();
  }

  // Test the getDocumentAsMixed operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentAsMixedNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getDocumentAsMixed(null).execute();
  }

  // Test the getDocumentAsRelated operation with a valid options model parameter
  @Test
  public void testGetDocumentAsRelatedWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String getDocumentAsRelatedPath = "/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "multipart/related")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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

    // Invoke getDocumentAsRelated() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.getDocumentAsRelated(getDocumentOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertNotNull(responseObj);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentAsRelatedPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
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
  }

  // Test the getDocumentAsRelated operation with and without retries enabled
  @Test
  public void testGetDocumentAsRelatedWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetDocumentAsRelatedWOptions();

    cloudantService.disableRetries();
    testGetDocumentAsRelatedWOptions();
  }

  // Test the getDocumentAsRelated operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentAsRelatedNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getDocumentAsRelated(null).execute();
  }

  // Test the getDocumentAsStream operation with a valid options model parameter
  @Test
  public void testGetDocumentAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String getDocumentAsStreamPath = "/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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

    // Invoke getDocumentAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.getDocumentAsStream(getDocumentOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentAsStreamPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
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
  }

  // Test the getDocumentAsStream operation with and without retries enabled
  @Test
  public void testGetDocumentAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetDocumentAsStreamWOptions();

    cloudantService.disableRetries();
    testGetDocumentAsStreamWOptions();
  }

  // Test the getDocumentAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getDocumentAsStream(null).execute();
  }

  // Test the putDocument operation with a valid options model parameter
  @Test
  public void testPutDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String putDocumentPath = "/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
      .contentType("testString")
      .data(TestUtilities.createMockByteArray("VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4="))
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
      .ids(java.util.Arrays.asList("testString"))
      .start(Long.valueOf("1"))
      .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
      .rev("testString")
      .status("available")
      .build();

    // Construct an instance of the Document model
    Document documentModel = new Document.Builder()
      .attachments(java.util.Collections.singletonMap("key1", attachmentModel))
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("exampleid")
      .localSeq("testString")
      .rev("testString")
      .revisions(revisionsModel)
      .revsInfo(java.util.Arrays.asList(documentRevisionStatusModel))
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

    // Invoke putDocument() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.putDocument(putDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("batch"), "ok");
    assertEquals(Boolean.valueOf(query.get("new_edits")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
  }

  // Test the putDocument operation with and without retries enabled
  @Test
  public void testPutDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutDocumentWOptions();

    cloudantService.disableRetries();
    testPutDocumentWOptions();
  }

  // Test the putDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putDocument(null).execute();
  }

  // Test the headDesignDocument operation with a valid options model parameter
  @Test
  public void testHeadDesignDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String headDesignDocumentPath = "/testString/_design/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the HeadDesignDocumentOptions model
    HeadDesignDocumentOptions headDesignDocumentOptionsModel = new HeadDesignDocumentOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .ifNoneMatch("testString")
      .build();

    // Invoke headDesignDocument() with a valid options model and verify the result
    Response<Void> response = cloudantService.headDesignDocument(headDesignDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headDesignDocumentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the headDesignDocument operation with and without retries enabled
  @Test
  public void testHeadDesignDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testHeadDesignDocumentWOptions();

    cloudantService.disableRetries();
    testHeadDesignDocumentWOptions();
  }

  // Test the headDesignDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadDesignDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.headDesignDocument(null).execute();
  }

  // Test the deleteDesignDocument operation with a valid options model parameter
  @Test
  public void testDeleteDesignDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String deleteDesignDocumentPath = "/testString/_design/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteDesignDocumentOptions model
    DeleteDesignDocumentOptions deleteDesignDocumentOptionsModel = new DeleteDesignDocumentOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .ifMatch("testString")
      .batch("ok")
      .rev("testString")
      .build();

    // Invoke deleteDesignDocument() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.deleteDesignDocument(deleteDesignDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDesignDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("batch"), "ok");
    assertEquals(query.get("rev"), "testString");
  }

  // Test the deleteDesignDocument operation with and without retries enabled
  @Test
  public void testDeleteDesignDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testDeleteDesignDocumentWOptions();

    cloudantService.disableRetries();
    testDeleteDesignDocumentWOptions();
  }

  // Test the deleteDesignDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDesignDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.deleteDesignDocument(null).execute();
  }

  // Test the getDesignDocument operation with a valid options model parameter
  @Test
  public void testGetDesignDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}], \"autoupdate\": true, \"filters\": {\"mapKey\": \"inner\"}, \"indexes\": {\"mapKey\": {\"analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"], \"fields\": {\"mapKey\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}}}, \"index\": \"index\"}}, \"language\": \"javascript\", \"options\": {\"partitioned\": false}, \"validate_doc_update\": \"validateDocUpdate\", \"views\": {\"mapKey\": {\"map\": \"map\", \"reduce\": \"reduce\"}}}";
    String getDesignDocumentPath = "/testString/_design/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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

    // Invoke getDesignDocument() with a valid options model and verify the result
    Response<DesignDocument> response = cloudantService.getDesignDocument(getDesignDocumentOptionsModel).execute();
    assertNotNull(response);
    DesignDocument responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDesignDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
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
  }

  // Test the getDesignDocument operation with and without retries enabled
  @Test
  public void testGetDesignDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetDesignDocumentWOptions();

    cloudantService.disableRetries();
    testGetDesignDocumentWOptions();
  }

  // Test the getDesignDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDesignDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getDesignDocument(null).execute();
  }

  // Test the putDesignDocument operation with a valid options model parameter
  @Test
  public void testPutDesignDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String putDesignDocumentPath = "/testString/_design/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
      .contentType("testString")
      .data(TestUtilities.createMockByteArray("VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4="))
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
      .ids(java.util.Arrays.asList("testString"))
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
      .stopwords(java.util.Arrays.asList("testString"))
      .build();

    // Construct an instance of the AnalyzerConfiguration model
    AnalyzerConfiguration analyzerConfigurationModel = new AnalyzerConfiguration.Builder()
      .name("standard")
      .stopwords(java.util.Arrays.asList("testString"))
      .fields(java.util.Collections.singletonMap("key1", analyzerModel))
      .build();

    // Construct an instance of the SearchIndexDefinition model
    SearchIndexDefinition searchIndexDefinitionModel = new SearchIndexDefinition.Builder()
      .analyzer(analyzerConfigurationModel)
      .index("function (doc) {\n  index(\"price\", doc.price);\n}")
      .build();

    // Construct an instance of the DesignDocumentOptions model
    DesignDocumentOptions designDocumentOptionsModel = new DesignDocumentOptions.Builder()
      .partitioned(true)
      .build();

    // Construct an instance of the DesignDocumentViewsMapReduce model
    DesignDocumentViewsMapReduce designDocumentViewsMapReduceModel = new DesignDocumentViewsMapReduce.Builder()
      .map("function(doc) { \n  emit(doc.productid, [doc.brand, doc.name, doc.description]) \n}")
      .reduce("testString")
      .build();

    // Construct an instance of the DesignDocument model
    DesignDocument designDocumentModel = new DesignDocument.Builder()
      .attachments(java.util.Collections.singletonMap("key1", attachmentModel))
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("_design/appliances")
      .localSeq("testString")
      .rev("8-7e2537e5989294471061e0cfd7292725")
      .revisions(revisionsModel)
      .revsInfo(java.util.Arrays.asList(documentRevisionStatusModel))
      .autoupdate(true)
      .filters(java.util.Collections.singletonMap("key1", "testString"))
      .indexes(java.util.Collections.singletonMap("key1", searchIndexDefinitionModel))
      .language("javascript")
      .options(designDocumentOptionsModel)
      .validateDocUpdate("testString")
      .views(java.util.Collections.singletonMap("key1", designDocumentViewsMapReduceModel))
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

    // Invoke putDesignDocument() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.putDesignDocument(putDesignDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putDesignDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("batch"), "ok");
    assertEquals(Boolean.valueOf(query.get("new_edits")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
  }

  // Test the putDesignDocument operation with and without retries enabled
  @Test
  public void testPutDesignDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutDesignDocumentWOptions();

    cloudantService.disableRetries();
    testPutDesignDocumentWOptions();
  }

  // Test the putDesignDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutDesignDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putDesignDocument(null).execute();
  }

  // Test the getDesignDocumentInformation operation with a valid options model parameter
  @Test
  public void testGetDesignDocumentInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"view_index\": {\"collator_versions\": [\"collatorVersions\"], \"compact_running\": true, \"language\": \"language\", \"signature\": \"signature\", \"sizes\": {\"active\": 6, \"external\": 8, \"file\": 4}, \"updater_running\": true, \"updates_pending\": {\"minimum\": 7, \"preferred\": 9, \"total\": 5}, \"waiting_clients\": 0, \"waiting_commit\": false}}";
    String getDesignDocumentInformationPath = "/testString/_design/testString/_info";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetDesignDocumentInformationOptions model
    GetDesignDocumentInformationOptions getDesignDocumentInformationOptionsModel = new GetDesignDocumentInformationOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .build();

    // Invoke getDesignDocumentInformation() with a valid options model and verify the result
    Response<DesignDocumentInformation> response = cloudantService.getDesignDocumentInformation(getDesignDocumentInformationOptionsModel).execute();
    assertNotNull(response);
    DesignDocumentInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDesignDocumentInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getDesignDocumentInformation operation with and without retries enabled
  @Test
  public void testGetDesignDocumentInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetDesignDocumentInformationWOptions();

    cloudantService.disableRetries();
    testGetDesignDocumentInformationWOptions();
  }

  // Test the getDesignDocumentInformation operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDesignDocumentInformationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getDesignDocumentInformation(null).execute();
  }

  // Test the postDesignDocs operation with a valid options model parameter
  @Test
  public void testPostDesignDocsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"deleted\": false, \"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}";
    String postDesignDocsPath = "/testString/_design_docs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .key("testString")
      .keys(java.util.Arrays.asList("testString"))
      .startKey("0007741142412418284")
      .build();

    // Invoke postDesignDocs() with a valid options model and verify the result
    Response<AllDocsResult> response = cloudantService.postDesignDocs(postDesignDocsOptionsModel).execute();
    assertNotNull(response);
    AllDocsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postDesignDocsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postDesignDocs operation with and without retries enabled
  @Test
  public void testPostDesignDocsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostDesignDocsWOptions();

    cloudantService.disableRetries();
    testPostDesignDocsWOptions();
  }

  // Test the postDesignDocs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDesignDocsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postDesignDocs(null).execute();
  }

  // Test the postDesignDocsQueries operation with a valid options model parameter
  @Test
  public void testPostDesignDocsQueriesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"results\": [{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"deleted\": false, \"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}]}";
    String postDesignDocsQueriesPath = "/testString/_design_docs/queries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .key("testString")
      .keys(java.util.Arrays.asList("small-appliances:1000042", "small-appliances:1000043"))
      .startKey("testString")
      .build();

    // Construct an instance of the PostDesignDocsQueriesOptions model
    PostDesignDocsQueriesOptions postDesignDocsQueriesOptionsModel = new PostDesignDocsQueriesOptions.Builder()
      .db("testString")
      .queries(java.util.Arrays.asList(allDocsQueryModel))
      .accept("application/json")
      .build();

    // Invoke postDesignDocsQueries() with a valid options model and verify the result
    Response<AllDocsQueriesResult> response = cloudantService.postDesignDocsQueries(postDesignDocsQueriesOptionsModel).execute();
    assertNotNull(response);
    AllDocsQueriesResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postDesignDocsQueriesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postDesignDocsQueries operation with and without retries enabled
  @Test
  public void testPostDesignDocsQueriesWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostDesignDocsQueriesWOptions();

    cloudantService.disableRetries();
    testPostDesignDocsQueriesWOptions();
  }

  // Test the postDesignDocsQueries operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDesignDocsQueriesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postDesignDocsQueries(null).execute();
  }

  // Test the postView operation with a valid options model parameter
  @Test
  public void testPostViewWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"update_seq\": \"updateSeq\", \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"anyValue\", \"value\": \"anyValue\"}]}";
    String postViewPath = "/testString/_design/testString/_view/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .endKeyDocId("testString")
      .group(false)
      .groupLevel(Long.valueOf("1"))
      .key("testString")
      .keys(java.util.Arrays.asList("examplekey"))
      .reduce(true)
      .stable(false)
      .startKey("testString")
      .startKeyDocId("testString")
      .update("true")
      .build();

    // Invoke postView() with a valid options model and verify the result
    Response<ViewResult> response = cloudantService.postView(postViewOptionsModel).execute();
    assertNotNull(response);
    ViewResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postViewPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postView operation with and without retries enabled
  @Test
  public void testPostViewWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostViewWOptions();

    cloudantService.disableRetries();
    testPostViewWOptions();
  }

  // Test the postView operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postView(null).execute();
  }

  // Test the postViewAsStream operation with a valid options model parameter
  @Test
  public void testPostViewAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postViewAsStreamPath = "/testString/_design/testString/_view/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .endKeyDocId("testString")
      .group(false)
      .groupLevel(Long.valueOf("1"))
      .key("testString")
      .keys(java.util.Arrays.asList("examplekey"))
      .reduce(true)
      .stable(false)
      .startKey("testString")
      .startKeyDocId("testString")
      .update("true")
      .build();

    // Invoke postViewAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postViewAsStream(postViewOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postViewAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postViewAsStream operation with and without retries enabled
  @Test
  public void testPostViewAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostViewAsStreamWOptions();

    cloudantService.disableRetries();
    testPostViewAsStreamWOptions();
  }

  // Test the postViewAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postViewAsStream(null).execute();
  }

  // Test the postViewQueries operation with a valid options model parameter
  @Test
  public void testPostViewQueriesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"results\": [{\"total_rows\": 0, \"update_seq\": \"updateSeq\", \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"anyValue\", \"value\": \"anyValue\"}]}]}";
    String postViewQueriesPath = "/testString/_design/testString/_view/testString/queries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .endKeyDocId("testString")
      .group(false)
      .groupLevel(Long.valueOf("1"))
      .key("testString")
      .keys(java.util.Arrays.asList("testString"))
      .reduce(true)
      .stable(false)
      .startKey("testString")
      .startKeyDocId("testString")
      .update("true")
      .build();

    // Construct an instance of the PostViewQueriesOptions model
    PostViewQueriesOptions postViewQueriesOptionsModel = new PostViewQueriesOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .view("testString")
      .queries(java.util.Arrays.asList(viewQueryModel))
      .build();

    // Invoke postViewQueries() with a valid options model and verify the result
    Response<ViewQueriesResult> response = cloudantService.postViewQueries(postViewQueriesOptionsModel).execute();
    assertNotNull(response);
    ViewQueriesResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postViewQueriesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postViewQueries operation with and without retries enabled
  @Test
  public void testPostViewQueriesWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostViewQueriesWOptions();

    cloudantService.disableRetries();
    testPostViewQueriesWOptions();
  }

  // Test the postViewQueries operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewQueriesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postViewQueries(null).execute();
  }

  // Test the postViewQueriesAsStream operation with a valid options model parameter
  @Test
  public void testPostViewQueriesAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postViewQueriesAsStreamPath = "/testString/_design/testString/_view/testString/queries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .endKeyDocId("testString")
      .group(false)
      .groupLevel(Long.valueOf("1"))
      .key("testString")
      .keys(java.util.Arrays.asList("testString"))
      .reduce(true)
      .stable(false)
      .startKey("testString")
      .startKeyDocId("testString")
      .update("true")
      .build();

    // Construct an instance of the PostViewQueriesOptions model
    PostViewQueriesOptions postViewQueriesOptionsModel = new PostViewQueriesOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .view("testString")
      .queries(java.util.Arrays.asList(viewQueryModel))
      .build();

    // Invoke postViewQueriesAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postViewQueriesAsStream(postViewQueriesOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postViewQueriesAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postViewQueriesAsStream operation with and without retries enabled
  @Test
  public void testPostViewQueriesAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostViewQueriesAsStreamWOptions();

    cloudantService.disableRetries();
    testPostViewQueriesAsStreamWOptions();
  }

  // Test the postViewQueriesAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewQueriesAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postViewQueriesAsStream(null).execute();
  }

  // Test the getPartitionInformation operation with a valid options model parameter
  @Test
  public void testGetPartitionInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"db_name\": \"dbName\", \"doc_count\": 0, \"doc_del_count\": 0, \"partition\": \"partition\", \"partitioned_indexes\": {\"count\": 0, \"indexes\": {\"search\": 0, \"view\": 0}, \"limit\": 0}, \"sizes\": {\"active\": 0, \"external\": 0}}";
    String getPartitionInformationPath = "/testString/_partition/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetPartitionInformationOptions model
    GetPartitionInformationOptions getPartitionInformationOptionsModel = new GetPartitionInformationOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .build();

    // Invoke getPartitionInformation() with a valid options model and verify the result
    Response<PartitionInformation> response = cloudantService.getPartitionInformation(getPartitionInformationOptionsModel).execute();
    assertNotNull(response);
    PartitionInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPartitionInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getPartitionInformation operation with and without retries enabled
  @Test
  public void testGetPartitionInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetPartitionInformationWOptions();

    cloudantService.disableRetries();
    testGetPartitionInformationWOptions();
  }

  // Test the getPartitionInformation operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPartitionInformationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getPartitionInformation(null).execute();
  }

  // Test the postPartitionAllDocs operation with a valid options model parameter
  @Test
  public void testPostPartitionAllDocsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"key\", \"value\": {\"deleted\": false, \"rev\": \"rev\"}}], \"update_seq\": \"updateSeq\"}";
    String postPartitionAllDocsPath = "/testString/_partition/testString/_all_docs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .key("testString")
      .keys(java.util.Arrays.asList("testString"))
      .startKey("0007741142412418284")
      .build();

    // Invoke postPartitionAllDocs() with a valid options model and verify the result
    Response<AllDocsResult> response = cloudantService.postPartitionAllDocs(postPartitionAllDocsOptionsModel).execute();
    assertNotNull(response);
    AllDocsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionAllDocsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postPartitionAllDocs operation with and without retries enabled
  @Test
  public void testPostPartitionAllDocsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostPartitionAllDocsWOptions();

    cloudantService.disableRetries();
    testPostPartitionAllDocsWOptions();
  }

  // Test the postPartitionAllDocs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionAllDocsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postPartitionAllDocs(null).execute();
  }

  // Test the postPartitionAllDocsAsStream operation with a valid options model parameter
  @Test
  public void testPostPartitionAllDocsAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postPartitionAllDocsAsStreamPath = "/testString/_partition/testString/_all_docs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .key("testString")
      .keys(java.util.Arrays.asList("testString"))
      .startKey("0007741142412418284")
      .build();

    // Invoke postPartitionAllDocsAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postPartitionAllDocsAsStream(postPartitionAllDocsOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionAllDocsAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postPartitionAllDocsAsStream operation with and without retries enabled
  @Test
  public void testPostPartitionAllDocsAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostPartitionAllDocsAsStreamWOptions();

    cloudantService.disableRetries();
    testPostPartitionAllDocsAsStreamWOptions();
  }

  // Test the postPartitionAllDocsAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionAllDocsAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postPartitionAllDocsAsStream(null).execute();
  }

  // Test the postPartitionSearch operation with a valid options model parameter
  @Test
  public void testPostPartitionSearchWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"bookmark\": \"bookmark\", \"by\": \"by\", \"counts\": {\"mapKey\": {\"mapKey\": 0}}, \"ranges\": {\"mapKey\": {\"mapKey\": 0}}, \"rows\": [{\"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"fields\": {\"anyKey\": \"anyValue\"}, \"highlights\": {\"mapKey\": [\"inner\"]}, \"id\": \"id\"}], \"groups\": [{\"total_rows\": 0, \"bookmark\": \"bookmark\", \"by\": \"by\", \"counts\": {\"mapKey\": {\"mapKey\": 0}}, \"ranges\": {\"mapKey\": {\"mapKey\": 0}}, \"rows\": [{\"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"fields\": {\"anyKey\": \"anyValue\"}, \"highlights\": {\"mapKey\": [\"inner\"]}, \"id\": \"id\"}]}]}";
    String postPartitionSearchPath = "/testString/_partition/testString/_design/testString/_search/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostPartitionSearchOptions model
    PostPartitionSearchOptions postPartitionSearchOptionsModel = new PostPartitionSearchOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .ddoc("testString")
      .index("testString")
      .query("name:Jane* AND active:True")
      .bookmark("testString")
      .highlightFields(java.util.Arrays.asList("testString"))
      .highlightNumber(Long.valueOf("1"))
      .highlightPostTag("</em>")
      .highlightPreTag("<em>")
      .highlightSize(Long.valueOf("100"))
      .includeDocs(false)
      .includeFields(java.util.Arrays.asList("testString"))
      .limit(Long.valueOf("3"))
      .sort(java.util.Arrays.asList("testString"))
      .stale("ok")
      .build();

    // Invoke postPartitionSearch() with a valid options model and verify the result
    Response<SearchResult> response = cloudantService.postPartitionSearch(postPartitionSearchOptionsModel).execute();
    assertNotNull(response);
    SearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionSearchPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postPartitionSearch operation with and without retries enabled
  @Test
  public void testPostPartitionSearchWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostPartitionSearchWOptions();

    cloudantService.disableRetries();
    testPostPartitionSearchWOptions();
  }

  // Test the postPartitionSearch operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionSearchNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postPartitionSearch(null).execute();
  }

  // Test the postPartitionSearchAsStream operation with a valid options model parameter
  @Test
  public void testPostPartitionSearchAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postPartitionSearchAsStreamPath = "/testString/_partition/testString/_design/testString/_search/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostPartitionSearchOptions model
    PostPartitionSearchOptions postPartitionSearchOptionsModel = new PostPartitionSearchOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .ddoc("testString")
      .index("testString")
      .query("name:Jane* AND active:True")
      .bookmark("testString")
      .highlightFields(java.util.Arrays.asList("testString"))
      .highlightNumber(Long.valueOf("1"))
      .highlightPostTag("</em>")
      .highlightPreTag("<em>")
      .highlightSize(Long.valueOf("100"))
      .includeDocs(false)
      .includeFields(java.util.Arrays.asList("testString"))
      .limit(Long.valueOf("3"))
      .sort(java.util.Arrays.asList("testString"))
      .stale("ok")
      .build();

    // Invoke postPartitionSearchAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postPartitionSearchAsStream(postPartitionSearchOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionSearchAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postPartitionSearchAsStream operation with and without retries enabled
  @Test
  public void testPostPartitionSearchAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostPartitionSearchAsStreamWOptions();

    cloudantService.disableRetries();
    testPostPartitionSearchAsStreamWOptions();
  }

  // Test the postPartitionSearchAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionSearchAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postPartitionSearchAsStream(null).execute();
  }

  // Test the postPartitionView operation with a valid options model parameter
  @Test
  public void testPostPartitionViewWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"update_seq\": \"updateSeq\", \"rows\": [{\"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3, \"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"id\": \"id\", \"key\": \"anyValue\", \"value\": \"anyValue\"}]}";
    String postPartitionViewPath = "/testString/_partition/testString/_design/testString/_view/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .endKeyDocId("testString")
      .group(false)
      .groupLevel(Long.valueOf("1"))
      .key("testString")
      .keys(java.util.Arrays.asList("examplekey"))
      .reduce(true)
      .startKey("testString")
      .startKeyDocId("testString")
      .update("true")
      .build();

    // Invoke postPartitionView() with a valid options model and verify the result
    Response<ViewResult> response = cloudantService.postPartitionView(postPartitionViewOptionsModel).execute();
    assertNotNull(response);
    ViewResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionViewPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postPartitionView operation with and without retries enabled
  @Test
  public void testPostPartitionViewWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostPartitionViewWOptions();

    cloudantService.disableRetries();
    testPostPartitionViewWOptions();
  }

  // Test the postPartitionView operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionViewNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postPartitionView(null).execute();
  }

  // Test the postPartitionViewAsStream operation with a valid options model parameter
  @Test
  public void testPostPartitionViewAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postPartitionViewAsStreamPath = "/testString/_partition/testString/_design/testString/_view/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .endKey("testString")
      .endKeyDocId("testString")
      .group(false)
      .groupLevel(Long.valueOf("1"))
      .key("testString")
      .keys(java.util.Arrays.asList("examplekey"))
      .reduce(true)
      .startKey("testString")
      .startKeyDocId("testString")
      .update("true")
      .build();

    // Invoke postPartitionViewAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postPartitionViewAsStream(postPartitionViewOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionViewAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postPartitionViewAsStream operation with and without retries enabled
  @Test
  public void testPostPartitionViewAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostPartitionViewAsStreamWOptions();

    cloudantService.disableRetries();
    testPostPartitionViewAsStreamWOptions();
  }

  // Test the postPartitionViewAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionViewAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postPartitionViewAsStream(null).execute();
  }

  // Test the postPartitionExplain operation with a valid options model parameter
  @Test
  public void testPostPartitionExplainWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"covering\": true, \"dbname\": \"dbname\", \"fields\": [\"fields\"], \"index\": {\"ddoc\": \"ddoc\", \"def\": {\"default_analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"default_field\": {\"analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"enabled\": true}, \"fields\": [{\"name\": \"name\", \"type\": \"boolean\"}], \"index_array_lengths\": true, \"partial_filter_selector\": {\"anyKey\": \"anyValue\"}}, \"name\": \"name\", \"partitioned\": false, \"type\": \"json\"}, \"index_candidates\": [{\"analysis\": {\"covering\": true, \"ranking\": 1, \"reasons\": [{\"name\": \"alphabetically_comes_after\"}], \"usable\": true}, \"index\": {\"ddoc\": \"ddoc\", \"def\": {\"default_analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"default_field\": {\"analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"enabled\": true}, \"fields\": [{\"name\": \"name\", \"type\": \"boolean\"}], \"index_array_lengths\": true, \"partial_filter_selector\": {\"anyKey\": \"anyValue\"}}, \"name\": \"name\", \"partitioned\": false, \"type\": \"json\"}}], \"limit\": 25, \"mrargs\": {\"conflicts\": \"anyValue\", \"direction\": \"direction\", \"end_key\": \"anyValue\", \"include_docs\": false, \"partition\": \"partition\", \"reduce\": true, \"stable\": true, \"start_key\": \"anyValue\", \"update\": \"anyValue\", \"view_type\": \"map\"}, \"opts\": {\"bookmark\": \"bookmark\", \"conflicts\": false, \"execution_stats\": false, \"fields\": [\"fields\"], \"limit\": 25, \"partition\": \"partition\", \"r\": 1, \"skip\": 0, \"sort\": \"anyValue\", \"stable\": false, \"stale\": false, \"update\": true, \"use_index\": [\"useIndex\"]}, \"partitioned\": \"anyValue\", \"selector\": {\"anyKey\": \"anyValue\"}, \"selector_hints\": [{\"indexable_fields\": [\"indexableFields\"], \"type\": \"json\", \"unindexable_fields\": [\"unindexableFields\"]}], \"skip\": 0}";
    String postPartitionExplainPath = "/testString/_partition/testString/_explain";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostPartitionExplainOptions model
    PostPartitionExplainOptions postPartitionExplainOptionsModel = new PostPartitionExplainOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .bookmark("testString")
      .conflicts(true)
      .executionStats(true)
      .fields(java.util.Arrays.asList("productid", "name", "description"))
      .limit(Long.valueOf("25"))
      .skip(Long.valueOf("0"))
      .sort(java.util.Arrays.asList(java.util.Collections.singletonMap("key1", "asc")))
      .stable(true)
      .update("true")
      .useIndex(java.util.Arrays.asList("testString"))
      .build();

    // Invoke postPartitionExplain() with a valid options model and verify the result
    Response<ExplainResult> response = cloudantService.postPartitionExplain(postPartitionExplainOptionsModel).execute();
    assertNotNull(response);
    ExplainResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionExplainPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postPartitionExplain operation with and without retries enabled
  @Test
  public void testPostPartitionExplainWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostPartitionExplainWOptions();

    cloudantService.disableRetries();
    testPostPartitionExplainWOptions();
  }

  // Test the postPartitionExplain operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionExplainNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postPartitionExplain(null).execute();
  }

  // Test the postPartitionFind operation with a valid options model parameter
  @Test
  public void testPostPartitionFindWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"bookmark\": \"bookmark\", \"docs\": [{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}], \"execution_stats\": {\"execution_time_ms\": 15, \"results_returned\": 0, \"total_docs_examined\": 0, \"total_keys_examined\": 0, \"total_quorum_docs_examined\": 0}, \"warning\": \"warning\"}";
    String postPartitionFindPath = "/testString/_partition/testString/_find";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostPartitionFindOptions model
    PostPartitionFindOptions postPartitionFindOptionsModel = new PostPartitionFindOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .bookmark("testString")
      .conflicts(true)
      .executionStats(true)
      .fields(java.util.Arrays.asList("productid", "name", "description"))
      .limit(Long.valueOf("25"))
      .skip(Long.valueOf("0"))
      .sort(java.util.Arrays.asList(java.util.Collections.singletonMap("key1", "asc")))
      .stable(true)
      .update("true")
      .useIndex(java.util.Arrays.asList("testString"))
      .build();

    // Invoke postPartitionFind() with a valid options model and verify the result
    Response<FindResult> response = cloudantService.postPartitionFind(postPartitionFindOptionsModel).execute();
    assertNotNull(response);
    FindResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionFindPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postPartitionFind operation with and without retries enabled
  @Test
  public void testPostPartitionFindWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostPartitionFindWOptions();

    cloudantService.disableRetries();
    testPostPartitionFindWOptions();
  }

  // Test the postPartitionFind operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionFindNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postPartitionFind(null).execute();
  }

  // Test the postPartitionFindAsStream operation with a valid options model parameter
  @Test
  public void testPostPartitionFindAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postPartitionFindAsStreamPath = "/testString/_partition/testString/_find";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostPartitionFindOptions model
    PostPartitionFindOptions postPartitionFindOptionsModel = new PostPartitionFindOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .bookmark("testString")
      .conflicts(true)
      .executionStats(true)
      .fields(java.util.Arrays.asList("productid", "name", "description"))
      .limit(Long.valueOf("25"))
      .skip(Long.valueOf("0"))
      .sort(java.util.Arrays.asList(java.util.Collections.singletonMap("key1", "asc")))
      .stable(true)
      .update("true")
      .useIndex(java.util.Arrays.asList("testString"))
      .build();

    // Invoke postPartitionFindAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postPartitionFindAsStream(postPartitionFindOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postPartitionFindAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postPartitionFindAsStream operation with and without retries enabled
  @Test
  public void testPostPartitionFindAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostPartitionFindAsStreamWOptions();

    cloudantService.disableRetries();
    testPostPartitionFindAsStreamWOptions();
  }

  // Test the postPartitionFindAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionFindAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postPartitionFindAsStream(null).execute();
  }

  // Test the postExplain operation with a valid options model parameter
  @Test
  public void testPostExplainWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"covering\": true, \"dbname\": \"dbname\", \"fields\": [\"fields\"], \"index\": {\"ddoc\": \"ddoc\", \"def\": {\"default_analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"default_field\": {\"analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"enabled\": true}, \"fields\": [{\"name\": \"name\", \"type\": \"boolean\"}], \"index_array_lengths\": true, \"partial_filter_selector\": {\"anyKey\": \"anyValue\"}}, \"name\": \"name\", \"partitioned\": false, \"type\": \"json\"}, \"index_candidates\": [{\"analysis\": {\"covering\": true, \"ranking\": 1, \"reasons\": [{\"name\": \"alphabetically_comes_after\"}], \"usable\": true}, \"index\": {\"ddoc\": \"ddoc\", \"def\": {\"default_analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"default_field\": {\"analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"enabled\": true}, \"fields\": [{\"name\": \"name\", \"type\": \"boolean\"}], \"index_array_lengths\": true, \"partial_filter_selector\": {\"anyKey\": \"anyValue\"}}, \"name\": \"name\", \"partitioned\": false, \"type\": \"json\"}}], \"limit\": 25, \"mrargs\": {\"conflicts\": \"anyValue\", \"direction\": \"direction\", \"end_key\": \"anyValue\", \"include_docs\": false, \"partition\": \"partition\", \"reduce\": true, \"stable\": true, \"start_key\": \"anyValue\", \"update\": \"anyValue\", \"view_type\": \"map\"}, \"opts\": {\"bookmark\": \"bookmark\", \"conflicts\": false, \"execution_stats\": false, \"fields\": [\"fields\"], \"limit\": 25, \"partition\": \"partition\", \"r\": 1, \"skip\": 0, \"sort\": \"anyValue\", \"stable\": false, \"stale\": false, \"update\": true, \"use_index\": [\"useIndex\"]}, \"partitioned\": \"anyValue\", \"selector\": {\"anyKey\": \"anyValue\"}, \"selector_hints\": [{\"indexable_fields\": [\"indexableFields\"], \"type\": \"json\", \"unindexable_fields\": [\"unindexableFields\"]}], \"skip\": 0}";
    String postExplainPath = "/testString/_explain";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostExplainOptions model
    PostExplainOptions postExplainOptionsModel = new PostExplainOptions.Builder()
      .db("testString")
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .bookmark("testString")
      .conflicts(true)
      .executionStats(true)
      .fields(java.util.Arrays.asList("_id", "type", "name", "email"))
      .limit(Long.valueOf("3"))
      .skip(Long.valueOf("0"))
      .sort(java.util.Arrays.asList(java.util.Collections.singletonMap("key1", "asc")))
      .stable(true)
      .update("true")
      .useIndex(java.util.Arrays.asList("testString"))
      .r(Long.valueOf("1"))
      .build();

    // Invoke postExplain() with a valid options model and verify the result
    Response<ExplainResult> response = cloudantService.postExplain(postExplainOptionsModel).execute();
    assertNotNull(response);
    ExplainResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postExplainPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postExplain operation with and without retries enabled
  @Test
  public void testPostExplainWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostExplainWOptions();

    cloudantService.disableRetries();
    testPostExplainWOptions();
  }

  // Test the postExplain operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostExplainNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postExplain(null).execute();
  }

  // Test the postFind operation with a valid options model parameter
  @Test
  public void testPostFindWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"bookmark\": \"bookmark\", \"docs\": [{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}], \"execution_stats\": {\"execution_time_ms\": 15, \"results_returned\": 0, \"total_docs_examined\": 0, \"total_keys_examined\": 0, \"total_quorum_docs_examined\": 0}, \"warning\": \"warning\"}";
    String postFindPath = "/testString/_find";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostFindOptions model
    PostFindOptions postFindOptionsModel = new PostFindOptions.Builder()
      .db("testString")
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .bookmark("testString")
      .conflicts(true)
      .executionStats(true)
      .fields(java.util.Arrays.asList("_id", "type", "name", "email"))
      .limit(Long.valueOf("3"))
      .skip(Long.valueOf("0"))
      .sort(java.util.Arrays.asList(java.util.Collections.singletonMap("key1", "asc")))
      .stable(true)
      .update("true")
      .useIndex(java.util.Arrays.asList("testString"))
      .r(Long.valueOf("1"))
      .build();

    // Invoke postFind() with a valid options model and verify the result
    Response<FindResult> response = cloudantService.postFind(postFindOptionsModel).execute();
    assertNotNull(response);
    FindResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postFindPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postFind operation with and without retries enabled
  @Test
  public void testPostFindWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostFindWOptions();

    cloudantService.disableRetries();
    testPostFindWOptions();
  }

  // Test the postFind operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostFindNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postFind(null).execute();
  }

  // Test the postFindAsStream operation with a valid options model parameter
  @Test
  public void testPostFindAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postFindAsStreamPath = "/testString/_find";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostFindOptions model
    PostFindOptions postFindOptionsModel = new PostFindOptions.Builder()
      .db("testString")
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .bookmark("testString")
      .conflicts(true)
      .executionStats(true)
      .fields(java.util.Arrays.asList("_id", "type", "name", "email"))
      .limit(Long.valueOf("3"))
      .skip(Long.valueOf("0"))
      .sort(java.util.Arrays.asList(java.util.Collections.singletonMap("key1", "asc")))
      .stable(true)
      .update("true")
      .useIndex(java.util.Arrays.asList("testString"))
      .r(Long.valueOf("1"))
      .build();

    // Invoke postFindAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postFindAsStream(postFindOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postFindAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postFindAsStream operation with and without retries enabled
  @Test
  public void testPostFindAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostFindAsStreamWOptions();

    cloudantService.disableRetries();
    testPostFindAsStreamWOptions();
  }

  // Test the postFindAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostFindAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postFindAsStream(null).execute();
  }

  // Test the getIndexesInformation operation with a valid options model parameter
  @Test
  public void testGetIndexesInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"indexes\": [{\"ddoc\": \"ddoc\", \"def\": {\"default_analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"default_field\": {\"analyzer\": {\"name\": \"classic\", \"stopwords\": [\"stopwords\"]}, \"enabled\": true}, \"fields\": [{\"name\": \"name\", \"type\": \"boolean\"}], \"index_array_lengths\": true, \"partial_filter_selector\": {\"anyKey\": \"anyValue\"}}, \"name\": \"name\", \"partitioned\": false, \"type\": \"json\"}]}";
    String getIndexesInformationPath = "/testString/_index";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetIndexesInformationOptions model
    GetIndexesInformationOptions getIndexesInformationOptionsModel = new GetIndexesInformationOptions.Builder()
      .db("testString")
      .build();

    // Invoke getIndexesInformation() with a valid options model and verify the result
    Response<IndexesInformation> response = cloudantService.getIndexesInformation(getIndexesInformationOptionsModel).execute();
    assertNotNull(response);
    IndexesInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getIndexesInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getIndexesInformation operation with and without retries enabled
  @Test
  public void testGetIndexesInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetIndexesInformationWOptions();

    cloudantService.disableRetries();
    testGetIndexesInformationWOptions();
  }

  // Test the getIndexesInformation operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetIndexesInformationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getIndexesInformation(null).execute();
  }

  // Test the postIndex operation with a valid options model parameter
  @Test
  public void testPostIndexWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"result\": \"created\"}";
    String postIndexPath = "/testString/_index";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the Analyzer model
    Analyzer analyzerModel = new Analyzer.Builder()
      .name("classic")
      .stopwords(java.util.Arrays.asList("testString"))
      .build();

    // Construct an instance of the IndexTextOperatorDefaultField model
    IndexTextOperatorDefaultField indexTextOperatorDefaultFieldModel = new IndexTextOperatorDefaultField.Builder()
      .analyzer(analyzerModel)
      .enabled(true)
      .build();

    // Construct an instance of the IndexField model
    IndexField indexFieldModel = new IndexField.Builder()
      .name("asc")
      .type("boolean")
      .add("foo", "asc")
      .build();

    // Construct an instance of the IndexDefinition model
    IndexDefinition indexDefinitionModel = new IndexDefinition.Builder()
      .defaultAnalyzer(analyzerModel)
      .defaultField(indexTextOperatorDefaultFieldModel)
      .fields(java.util.Arrays.asList(indexFieldModel))
      .indexArrayLengths(true)
      .partialFilterSelector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Construct an instance of the PostIndexOptions model
    PostIndexOptions postIndexOptionsModel = new PostIndexOptions.Builder()
      .db("testString")
      .index(indexDefinitionModel)
      .ddoc("json-index")
      .name("getUserByName")
      .partitioned(true)
      .type("json")
      .build();

    // Invoke postIndex() with a valid options model and verify the result
    Response<IndexResult> response = cloudantService.postIndex(postIndexOptionsModel).execute();
    assertNotNull(response);
    IndexResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postIndexPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postIndex operation with and without retries enabled
  @Test
  public void testPostIndexWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostIndexWOptions();

    cloudantService.disableRetries();
    testPostIndexWOptions();
  }

  // Test the postIndex operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostIndexNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postIndex(null).execute();
  }

  // Test the deleteIndex operation with a valid options model parameter
  @Test
  public void testDeleteIndexWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ok\": true}";
    String deleteIndexPath = "/testString/_index/_design/testString/json/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteIndexOptions model
    DeleteIndexOptions deleteIndexOptionsModel = new DeleteIndexOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .type("json")
      .index("testString")
      .build();

    // Invoke deleteIndex() with a valid options model and verify the result
    Response<Ok> response = cloudantService.deleteIndex(deleteIndexOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteIndexPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteIndex operation with and without retries enabled
  @Test
  public void testDeleteIndexWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testDeleteIndexWOptions();

    cloudantService.disableRetries();
    testDeleteIndexWOptions();
  }

  // Test the deleteIndex operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteIndexNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.deleteIndex(null).execute();
  }

  // Test the postSearchAnalyze operation with a valid options model parameter
  @Test
  public void testPostSearchAnalyzeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"tokens\": [\"tokens\"]}";
    String postSearchAnalyzePath = "/_search_analyze";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostSearchAnalyzeOptions model
    PostSearchAnalyzeOptions postSearchAnalyzeOptionsModel = new PostSearchAnalyzeOptions.Builder()
      .analyzer("english")
      .text("running is fun")
      .build();

    // Invoke postSearchAnalyze() with a valid options model and verify the result
    Response<SearchAnalyzeResult> response = cloudantService.postSearchAnalyze(postSearchAnalyzeOptionsModel).execute();
    assertNotNull(response);
    SearchAnalyzeResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postSearchAnalyzePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postSearchAnalyze operation with and without retries enabled
  @Test
  public void testPostSearchAnalyzeWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostSearchAnalyzeWOptions();

    cloudantService.disableRetries();
    testPostSearchAnalyzeWOptions();
  }

  // Test the postSearchAnalyze operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostSearchAnalyzeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postSearchAnalyze(null).execute();
  }

  // Test the postSearch operation with a valid options model parameter
  @Test
  public void testPostSearchWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"bookmark\": \"bookmark\", \"by\": \"by\", \"counts\": {\"mapKey\": {\"mapKey\": 0}}, \"ranges\": {\"mapKey\": {\"mapKey\": 0}}, \"rows\": [{\"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"fields\": {\"anyKey\": \"anyValue\"}, \"highlights\": {\"mapKey\": [\"inner\"]}, \"id\": \"id\"}], \"groups\": [{\"total_rows\": 0, \"bookmark\": \"bookmark\", \"by\": \"by\", \"counts\": {\"mapKey\": {\"mapKey\": 0}}, \"ranges\": {\"mapKey\": {\"mapKey\": 0}}, \"rows\": [{\"doc\": {\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}, \"fields\": {\"anyKey\": \"anyValue\"}, \"highlights\": {\"mapKey\": [\"inner\"]}, \"id\": \"id\"}]}]}";
    String postSearchPath = "/testString/_design/testString/_search/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostSearchOptions model
    PostSearchOptions postSearchOptionsModel = new PostSearchOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .index("testString")
      .query("name:Jane* AND active:True")
      .bookmark("testString")
      .highlightFields(java.util.Arrays.asList("testString"))
      .highlightNumber(Long.valueOf("1"))
      .highlightPostTag("</em>")
      .highlightPreTag("<em>")
      .highlightSize(Long.valueOf("100"))
      .includeDocs(false)
      .includeFields(java.util.Arrays.asList("testString"))
      .limit(Long.valueOf("3"))
      .sort(java.util.Arrays.asList("testString"))
      .stale("ok")
      .counts(java.util.Arrays.asList("testString"))
      .drilldown(java.util.Arrays.asList(java.util.Arrays.asList("testString")))
      .groupField("testString")
      .groupLimit(Long.valueOf("1"))
      .groupSort(java.util.Arrays.asList("testString"))
      .ranges(java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", "testString"))))
      .build();

    // Invoke postSearch() with a valid options model and verify the result
    Response<SearchResult> response = cloudantService.postSearch(postSearchOptionsModel).execute();
    assertNotNull(response);
    SearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postSearchPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postSearch operation with and without retries enabled
  @Test
  public void testPostSearchWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostSearchWOptions();

    cloudantService.disableRetries();
    testPostSearchWOptions();
  }

  // Test the postSearch operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostSearchNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postSearch(null).execute();
  }

  // Test the postSearchAsStream operation with a valid options model parameter
  @Test
  public void testPostSearchAsStreamWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"foo\": \"this is a mock response for JSON streaming\"}";
    String postSearchAsStreamPath = "/testString/_design/testString/_search/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostSearchOptions model
    PostSearchOptions postSearchOptionsModel = new PostSearchOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .index("testString")
      .query("name:Jane* AND active:True")
      .bookmark("testString")
      .highlightFields(java.util.Arrays.asList("testString"))
      .highlightNumber(Long.valueOf("1"))
      .highlightPostTag("</em>")
      .highlightPreTag("<em>")
      .highlightSize(Long.valueOf("100"))
      .includeDocs(false)
      .includeFields(java.util.Arrays.asList("testString"))
      .limit(Long.valueOf("3"))
      .sort(java.util.Arrays.asList("testString"))
      .stale("ok")
      .counts(java.util.Arrays.asList("testString"))
      .drilldown(java.util.Arrays.asList(java.util.Arrays.asList("testString")))
      .groupField("testString")
      .groupLimit(Long.valueOf("1"))
      .groupSort(java.util.Arrays.asList("testString"))
      .ranges(java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", "testString"))))
      .build();

    // Invoke postSearchAsStream() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.postSearchAsStream(postSearchOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertEquals(new String(responseObj.readAllBytes()), mockResponseBody);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postSearchAsStreamPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postSearchAsStream operation with and without retries enabled
  @Test
  public void testPostSearchAsStreamWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostSearchAsStreamWOptions();

    cloudantService.disableRetries();
    testPostSearchAsStreamWOptions();
  }

  // Test the postSearchAsStream operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostSearchAsStreamNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postSearchAsStream(null).execute();
  }

  // Test the getSearchInfo operation with a valid options model parameter
  @Test
  public void testGetSearchInfoWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"search_index\": {\"committed_seq\": 12, \"disk_size\": 0, \"doc_count\": 0, \"doc_del_count\": 0, \"pending_seq\": 10, \"signature\": \"signature\"}}";
    String getSearchInfoPath = "/testString/_design/testString/_search_info/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSearchInfoOptions model
    GetSearchInfoOptions getSearchInfoOptionsModel = new GetSearchInfoOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .index("testString")
      .build();

    // Invoke getSearchInfo() with a valid options model and verify the result
    Response<SearchInfoResult> response = cloudantService.getSearchInfo(getSearchInfoOptionsModel).execute();
    assertNotNull(response);
    SearchInfoResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSearchInfoPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSearchInfo operation with and without retries enabled
  @Test
  public void testGetSearchInfoWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetSearchInfoWOptions();

    cloudantService.disableRetries();
    testGetSearchInfoWOptions();
  }

  // Test the getSearchInfo operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSearchInfoNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getSearchInfo(null).execute();
  }

  // Test the headReplicationDocument operation with a valid options model parameter
  @Test
  public void testHeadReplicationDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String headReplicationDocumentPath = "/_replicator/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the HeadReplicationDocumentOptions model
    HeadReplicationDocumentOptions headReplicationDocumentOptionsModel = new HeadReplicationDocumentOptions.Builder()
      .docId("testString")
      .ifNoneMatch("testString")
      .build();

    // Invoke headReplicationDocument() with a valid options model and verify the result
    Response<Void> response = cloudantService.headReplicationDocument(headReplicationDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headReplicationDocumentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the headReplicationDocument operation with and without retries enabled
  @Test
  public void testHeadReplicationDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testHeadReplicationDocumentWOptions();

    cloudantService.disableRetries();
    testHeadReplicationDocumentWOptions();
  }

  // Test the headReplicationDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadReplicationDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.headReplicationDocument(null).execute();
  }

  // Test the headSchedulerDocument operation with a valid options model parameter
  @Test
  public void testHeadSchedulerDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String headSchedulerDocumentPath = "/_scheduler/docs/_replicator/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the HeadSchedulerDocumentOptions model
    HeadSchedulerDocumentOptions headSchedulerDocumentOptionsModel = new HeadSchedulerDocumentOptions.Builder()
      .docId("testString")
      .build();

    // Invoke headSchedulerDocument() with a valid options model and verify the result
    Response<Void> response = cloudantService.headSchedulerDocument(headSchedulerDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headSchedulerDocumentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the headSchedulerDocument operation with and without retries enabled
  @Test
  public void testHeadSchedulerDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testHeadSchedulerDocumentWOptions();

    cloudantService.disableRetries();
    testHeadSchedulerDocumentWOptions();
  }

  // Test the headSchedulerDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadSchedulerDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.headSchedulerDocument(null).execute();
  }

  // Test the headSchedulerJob operation with a valid options model parameter
  @Test
  public void testHeadSchedulerJobWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String headSchedulerJobPath = "/_scheduler/jobs/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the HeadSchedulerJobOptions model
    HeadSchedulerJobOptions headSchedulerJobOptionsModel = new HeadSchedulerJobOptions.Builder()
      .jobId("testString")
      .build();

    // Invoke headSchedulerJob() with a valid options model and verify the result
    Response<Void> response = cloudantService.headSchedulerJob(headSchedulerJobOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headSchedulerJobPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the headSchedulerJob operation with and without retries enabled
  @Test
  public void testHeadSchedulerJobWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testHeadSchedulerJobWOptions();

    cloudantService.disableRetries();
    testHeadSchedulerJobWOptions();
  }

  // Test the headSchedulerJob operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadSchedulerJobNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.headSchedulerJob(null).execute();
  }

  // Test the deleteReplicationDocument operation with a valid options model parameter
  @Test
  public void testDeleteReplicationDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String deleteReplicationDocumentPath = "/_replicator/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteReplicationDocumentOptions model
    DeleteReplicationDocumentOptions deleteReplicationDocumentOptionsModel = new DeleteReplicationDocumentOptions.Builder()
      .docId("testString")
      .ifMatch("testString")
      .batch("ok")
      .rev("testString")
      .build();

    // Invoke deleteReplicationDocument() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.deleteReplicationDocument(deleteReplicationDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteReplicationDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("batch"), "ok");
    assertEquals(query.get("rev"), "testString");
  }

  // Test the deleteReplicationDocument operation with and without retries enabled
  @Test
  public void testDeleteReplicationDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testDeleteReplicationDocumentWOptions();

    cloudantService.disableRetries();
    testDeleteReplicationDocumentWOptions();
  }

  // Test the deleteReplicationDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteReplicationDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.deleteReplicationDocument(null).execute();
  }

  // Test the getReplicationDocument operation with a valid options model parameter
  @Test
  public void testGetReplicationDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}], \"cancel\": true, \"checkpoint_interval\": 30000, \"connection_timeout\": 30000, \"continuous\": false, \"create_target\": false, \"create_target_params\": {\"n\": 3, \"partitioned\": false, \"q\": 1}, \"doc_ids\": [\"docIds\"], \"filter\": \"filter\", \"http_connections\": 20, \"owner\": \"owner\", \"query_params\": {\"mapKey\": \"inner\"}, \"retries_per_request\": 5, \"selector\": {\"anyKey\": \"anyValue\"}, \"since_seq\": \"sinceSeq\", \"socket_options\": \"socketOptions\", \"source\": {\"auth\": {\"basic\": {\"password\": \"password\", \"username\": \"username\"}, \"iam\": {\"api_key\": \"apiKey\"}}, \"headers\": {\"mapKey\": \"inner\"}, \"url\": \"url\"}, \"source_proxy\": \"sourceProxy\", \"target\": {\"auth\": {\"basic\": {\"password\": \"password\", \"username\": \"username\"}, \"iam\": {\"api_key\": \"apiKey\"}}, \"headers\": {\"mapKey\": \"inner\"}, \"url\": \"url\"}, \"target_proxy\": \"targetProxy\", \"use_bulk_get\": true, \"use_checkpoints\": true, \"user_ctx\": {\"db\": \"db\", \"name\": \"name\", \"roles\": [\"_reader\"]}, \"winning_revs_only\": false, \"worker_batch_size\": 500, \"worker_processes\": 4}";
    String getReplicationDocumentPath = "/_replicator/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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

    // Invoke getReplicationDocument() with a valid options model and verify the result
    Response<ReplicationDocument> response = cloudantService.getReplicationDocument(getReplicationDocumentOptionsModel).execute();
    assertNotNull(response);
    ReplicationDocument responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReplicationDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
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
  }

  // Test the getReplicationDocument operation with and without retries enabled
  @Test
  public void testGetReplicationDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetReplicationDocumentWOptions();

    cloudantService.disableRetries();
    testGetReplicationDocumentWOptions();
  }

  // Test the getReplicationDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReplicationDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getReplicationDocument(null).execute();
  }

  // Test the putReplicationDocument operation with a valid options model parameter
  @Test
  public void testPutReplicationDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String putReplicationDocumentPath = "/_replicator/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
      .contentType("testString")
      .data(TestUtilities.createMockByteArray("VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4="))
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
      .ids(java.util.Arrays.asList("testString"))
      .start(Long.valueOf("1"))
      .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
      .rev("testString")
      .status("available")
      .build();

    // Construct an instance of the ReplicationCreateTargetParameters model
    ReplicationCreateTargetParameters replicationCreateTargetParametersModel = new ReplicationCreateTargetParameters.Builder()
      .n(Long.valueOf("3"))
      .partitioned(false)
      .q(Long.valueOf("1"))
      .build();

    // Construct an instance of the ReplicationDatabaseAuthBasic model
    ReplicationDatabaseAuthBasic replicationDatabaseAuthBasicModel = new ReplicationDatabaseAuthBasic.Builder()
      .password("testString")
      .username("testString")
      .build();

    // Construct an instance of the ReplicationDatabaseAuthIam model
    ReplicationDatabaseAuthIam replicationDatabaseAuthIamModel = new ReplicationDatabaseAuthIam.Builder()
      .apiKey("testString")
      .build();

    // Construct an instance of the ReplicationDatabaseAuth model
    ReplicationDatabaseAuth replicationDatabaseAuthModel = new ReplicationDatabaseAuth.Builder()
      .basic(replicationDatabaseAuthBasicModel)
      .iam(replicationDatabaseAuthIamModel)
      .build();

    // Construct an instance of the ReplicationDatabase model
    ReplicationDatabase replicationDatabaseModel = new ReplicationDatabase.Builder()
      .auth(replicationDatabaseAuthModel)
      .headers(java.util.Collections.singletonMap("key1", "testString"))
      .url("https://my-source-instance.cloudantnosqldb.appdomain.cloud.example/animaldb")
      .build();

    // Construct an instance of the UserContext model
    UserContext userContextModel = new UserContext.Builder()
      .db("testString")
      .name("john")
      .roles(java.util.Arrays.asList("_replicator"))
      .build();

    // Construct an instance of the ReplicationDocument model
    ReplicationDocument replicationDocumentModel = new ReplicationDocument.Builder()
      .attachments(java.util.Collections.singletonMap("key1", attachmentModel))
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("testString")
      .localSeq("testString")
      .rev("testString")
      .revisions(revisionsModel)
      .revsInfo(java.util.Arrays.asList(documentRevisionStatusModel))
      .cancel(false)
      .checkpointInterval(Long.valueOf("4500"))
      .connectionTimeout(Long.valueOf("15000"))
      .continuous(true)
      .createTarget(true)
      .createTargetParams(replicationCreateTargetParametersModel)
      .docIds(java.util.Arrays.asList("badger", "lemur", "llama"))
      .filter("ddoc/my_filter")
      .httpConnections(Long.valueOf("10"))
      .owner("testString")
      .queryParams(java.util.Collections.singletonMap("key1", "testString"))
      .retriesPerRequest(Long.valueOf("3"))
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .sinceSeq("34-g1AAAAGjeJzLYWBgYMlgTmGQT0lKzi9KdU")
      .socketOptions("[{keepalive, true}, {nodelay, false}]")
      .source(replicationDatabaseModel)
      .sourceProxy("testString")
      .target(replicationDatabaseModel)
      .targetProxy("testString")
      .useBulkGet(true)
      .useCheckpoints(false)
      .userCtx(userContextModel)
      .winningRevsOnly(false)
      .workerBatchSize(Long.valueOf("400"))
      .workerProcesses(Long.valueOf("3"))
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

    // Invoke putReplicationDocument() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.putReplicationDocument(putReplicationDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putReplicationDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("batch"), "ok");
    assertEquals(Boolean.valueOf(query.get("new_edits")), Boolean.valueOf(false));
    assertEquals(query.get("rev"), "testString");
  }

  // Test the putReplicationDocument operation with and without retries enabled
  @Test
  public void testPutReplicationDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutReplicationDocumentWOptions();

    cloudantService.disableRetries();
    testPutReplicationDocumentWOptions();
  }

  // Test the putReplicationDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutReplicationDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putReplicationDocument(null).execute();
  }

  // Test the getSchedulerDocs operation with a valid options model parameter
  @Test
  public void testGetSchedulerDocsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"docs\": [{\"database\": \"database\", \"doc_id\": \"docId\", \"error_count\": 0, \"id\": \"id\", \"info\": {\"changes_pending\": 0, \"checkpointed_source_seq\": \"checkpointedSourceSeq\", \"doc_write_failures\": 0, \"docs_read\": 0, \"docs_written\": 0, \"error\": \"error\", \"missing_revisions_found\": 0, \"revisions_checked\": 0, \"source_seq\": \"sourceSeq\", \"through_seq\": \"throughSeq\"}, \"last_updated\": \"2019-01-01T12:00:00.000Z\", \"node\": \"node\", \"source\": \"source\", \"source_proxy\": \"sourceProxy\", \"start_time\": \"2019-01-01T12:00:00.000Z\", \"state\": \"initializing\", \"target\": \"target\", \"target_proxy\": \"targetProxy\"}]}";
    String getSchedulerDocsPath = "/_scheduler/docs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSchedulerDocsOptions model
    GetSchedulerDocsOptions getSchedulerDocsOptionsModel = new GetSchedulerDocsOptions.Builder()
      .limit(Long.valueOf("0"))
      .skip(Long.valueOf("0"))
      .states(java.util.Arrays.asList("initializing"))
      .build();

    // Invoke getSchedulerDocs() with a valid options model and verify the result
    Response<SchedulerDocsResult> response = cloudantService.getSchedulerDocs(getSchedulerDocsOptionsModel).execute();
    assertNotNull(response);
    SchedulerDocsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSchedulerDocsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("0"));
    assertEquals(query.get("states"), RequestUtils.join(java.util.Arrays.asList("initializing"), ","));
  }

  // Test the getSchedulerDocs operation with and without retries enabled
  @Test
  public void testGetSchedulerDocsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetSchedulerDocsWOptions();

    cloudantService.disableRetries();
    testGetSchedulerDocsWOptions();
  }

  // Test the getSchedulerDocument operation with a valid options model parameter
  @Test
  public void testGetSchedulerDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"database\": \"database\", \"doc_id\": \"docId\", \"error_count\": 0, \"id\": \"id\", \"info\": {\"changes_pending\": 0, \"checkpointed_source_seq\": \"checkpointedSourceSeq\", \"doc_write_failures\": 0, \"docs_read\": 0, \"docs_written\": 0, \"error\": \"error\", \"missing_revisions_found\": 0, \"revisions_checked\": 0, \"source_seq\": \"sourceSeq\", \"through_seq\": \"throughSeq\"}, \"last_updated\": \"2019-01-01T12:00:00.000Z\", \"node\": \"node\", \"source\": \"source\", \"source_proxy\": \"sourceProxy\", \"start_time\": \"2019-01-01T12:00:00.000Z\", \"state\": \"initializing\", \"target\": \"target\", \"target_proxy\": \"targetProxy\"}";
    String getSchedulerDocumentPath = "/_scheduler/docs/_replicator/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSchedulerDocumentOptions model
    GetSchedulerDocumentOptions getSchedulerDocumentOptionsModel = new GetSchedulerDocumentOptions.Builder()
      .docId("testString")
      .build();

    // Invoke getSchedulerDocument() with a valid options model and verify the result
    Response<SchedulerDocument> response = cloudantService.getSchedulerDocument(getSchedulerDocumentOptionsModel).execute();
    assertNotNull(response);
    SchedulerDocument responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSchedulerDocumentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSchedulerDocument operation with and without retries enabled
  @Test
  public void testGetSchedulerDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetSchedulerDocumentWOptions();

    cloudantService.disableRetries();
    testGetSchedulerDocumentWOptions();
  }

  // Test the getSchedulerDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSchedulerDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getSchedulerDocument(null).execute();
  }

  // Test the getSchedulerJobs operation with a valid options model parameter
  @Test
  public void testGetSchedulerJobsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_rows\": 0, \"jobs\": [{\"database\": \"database\", \"doc_id\": \"docId\", \"history\": [{\"reason\": \"reason\", \"timestamp\": \"2019-01-01T12:00:00.000Z\", \"type\": \"type\"}], \"id\": \"id\", \"info\": {\"changes_pending\": 0, \"checkpointed_source_seq\": \"checkpointedSourceSeq\", \"doc_write_failures\": 0, \"docs_read\": 0, \"docs_written\": 0, \"error\": \"error\", \"missing_revisions_found\": 0, \"revisions_checked\": 0, \"source_seq\": \"sourceSeq\", \"through_seq\": \"throughSeq\"}, \"node\": \"node\", \"pid\": \"pid\", \"source\": \"source\", \"start_time\": \"2019-01-01T12:00:00.000Z\", \"target\": \"target\", \"user\": \"user\"}]}";
    String getSchedulerJobsPath = "/_scheduler/jobs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSchedulerJobsOptions model
    GetSchedulerJobsOptions getSchedulerJobsOptionsModel = new GetSchedulerJobsOptions.Builder()
      .limit(Long.valueOf("25"))
      .skip(Long.valueOf("0"))
      .build();

    // Invoke getSchedulerJobs() with a valid options model and verify the result
    Response<SchedulerJobsResult> response = cloudantService.getSchedulerJobs(getSchedulerJobsOptionsModel).execute();
    assertNotNull(response);
    SchedulerJobsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSchedulerJobsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("25"));
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("0"));
  }

  // Test the getSchedulerJobs operation with and without retries enabled
  @Test
  public void testGetSchedulerJobsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetSchedulerJobsWOptions();

    cloudantService.disableRetries();
    testGetSchedulerJobsWOptions();
  }

  // Test the getSchedulerJob operation with a valid options model parameter
  @Test
  public void testGetSchedulerJobWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"database\": \"database\", \"doc_id\": \"docId\", \"history\": [{\"reason\": \"reason\", \"timestamp\": \"2019-01-01T12:00:00.000Z\", \"type\": \"type\"}], \"id\": \"id\", \"info\": {\"changes_pending\": 0, \"checkpointed_source_seq\": \"checkpointedSourceSeq\", \"doc_write_failures\": 0, \"docs_read\": 0, \"docs_written\": 0, \"error\": \"error\", \"missing_revisions_found\": 0, \"revisions_checked\": 0, \"source_seq\": \"sourceSeq\", \"through_seq\": \"throughSeq\"}, \"node\": \"node\", \"pid\": \"pid\", \"source\": \"source\", \"start_time\": \"2019-01-01T12:00:00.000Z\", \"target\": \"target\", \"user\": \"user\"}";
    String getSchedulerJobPath = "/_scheduler/jobs/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSchedulerJobOptions model
    GetSchedulerJobOptions getSchedulerJobOptionsModel = new GetSchedulerJobOptions.Builder()
      .jobId("testString")
      .build();

    // Invoke getSchedulerJob() with a valid options model and verify the result
    Response<SchedulerJob> response = cloudantService.getSchedulerJob(getSchedulerJobOptionsModel).execute();
    assertNotNull(response);
    SchedulerJob responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSchedulerJobPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSchedulerJob operation with and without retries enabled
  @Test
  public void testGetSchedulerJobWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetSchedulerJobWOptions();

    cloudantService.disableRetries();
    testGetSchedulerJobWOptions();
  }

  // Test the getSchedulerJob operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSchedulerJobNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getSchedulerJob(null).execute();
  }

  // Test the getSessionInformation operation with a valid options model parameter
  @Test
  public void testGetSessionInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ok\": true, \"info\": {\"authenticated\": \"authenticated\", \"authentication_db\": \"authenticationDb\", \"authentication_handlers\": [\"authenticationHandlers\"]}, \"userCtx\": {\"db\": \"db\", \"name\": \"name\", \"roles\": [\"_reader\"]}}";
    String getSessionInformationPath = "/_session";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSessionInformationOptions model
    GetSessionInformationOptions getSessionInformationOptionsModel = new GetSessionInformationOptions();

    // Invoke getSessionInformation() with a valid options model and verify the result
    Response<SessionInformation> response = cloudantService.getSessionInformation(getSessionInformationOptionsModel).execute();
    assertNotNull(response);
    SessionInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSessionInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSessionInformation operation with and without retries enabled
  @Test
  public void testGetSessionInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetSessionInformationWOptions();

    cloudantService.disableRetries();
    testGetSessionInformationWOptions();
  }

  // Test the getSecurity operation with a valid options model parameter
  @Test
  public void testGetSecurityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"admins\": {\"names\": [\"names\"], \"roles\": [\"roles\"]}, \"members\": {\"names\": [\"names\"], \"roles\": [\"roles\"]}, \"cloudant\": {\"mapKey\": [\"_reader\"]}, \"couchdb_auth_only\": false}";
    String getSecurityPath = "/testString/_security";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSecurityOptions model
    GetSecurityOptions getSecurityOptionsModel = new GetSecurityOptions.Builder()
      .db("testString")
      .build();

    // Invoke getSecurity() with a valid options model and verify the result
    Response<Security> response = cloudantService.getSecurity(getSecurityOptionsModel).execute();
    assertNotNull(response);
    Security responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSecurityPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSecurity operation with and without retries enabled
  @Test
  public void testGetSecurityWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetSecurityWOptions();

    cloudantService.disableRetries();
    testGetSecurityWOptions();
  }

  // Test the getSecurity operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSecurityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getSecurity(null).execute();
  }

  // Test the putSecurity operation with a valid options model parameter
  @Test
  public void testPutSecurityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ok\": true}";
    String putSecurityPath = "/testString/_security";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the SecurityObject model
    SecurityObject securityObjectModel = new SecurityObject.Builder()
      .names(java.util.Arrays.asList("superuser"))
      .roles(java.util.Arrays.asList("admins"))
      .build();

    // Construct an instance of the PutSecurityOptions model
    PutSecurityOptions putSecurityOptionsModel = new PutSecurityOptions.Builder()
      .db("testString")
      .admins(securityObjectModel)
      .members(securityObjectModel)
      .cloudant(java.util.Collections.singletonMap("key1", java.util.Arrays.asList("_reader")))
      .couchdbAuthOnly(true)
      .build();

    // Invoke putSecurity() with a valid options model and verify the result
    Response<Ok> response = cloudantService.putSecurity(putSecurityOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putSecurityPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the putSecurity operation with and without retries enabled
  @Test
  public void testPutSecurityWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutSecurityWOptions();

    cloudantService.disableRetries();
    testPutSecurityWOptions();
  }

  // Test the putSecurity operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutSecurityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putSecurity(null).execute();
  }

  // Test the postApiKeys operation with a valid options model parameter
  @Test
  public void testPostApiKeysWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ok\": true, \"key\": \"key\", \"password\": \"password\"}";
    String postApiKeysPath = "/_api/v2/api_keys";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the PostApiKeysOptions model
    PostApiKeysOptions postApiKeysOptionsModel = new PostApiKeysOptions();

    // Invoke postApiKeys() with a valid options model and verify the result
    Response<ApiKeysResult> response = cloudantService.postApiKeys(postApiKeysOptionsModel).execute();
    assertNotNull(response);
    ApiKeysResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postApiKeysPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postApiKeys operation with and without retries enabled
  @Test
  public void testPostApiKeysWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostApiKeysWOptions();

    cloudantService.disableRetries();
    testPostApiKeysWOptions();
  }

  // Test the putCloudantSecurityConfiguration operation with a valid options model parameter
  @Test
  public void testPutCloudantSecurityConfigurationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ok\": true}";
    String putCloudantSecurityConfigurationPath = "/_api/v2/db/testString/_security";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the SecurityObject model
    SecurityObject securityObjectModel = new SecurityObject.Builder()
      .names(java.util.Arrays.asList("testString"))
      .roles(java.util.Arrays.asList("testString"))
      .build();

    // Construct an instance of the PutCloudantSecurityConfigurationOptions model
    PutCloudantSecurityConfigurationOptions putCloudantSecurityConfigurationOptionsModel = new PutCloudantSecurityConfigurationOptions.Builder()
      .db("testString")
      .cloudant(java.util.Collections.singletonMap("key1", java.util.Arrays.asList("_reader")))
      .admins(securityObjectModel)
      .members(securityObjectModel)
      .couchdbAuthOnly(true)
      .build();

    // Invoke putCloudantSecurityConfiguration() with a valid options model and verify the result
    Response<Ok> response = cloudantService.putCloudantSecurityConfiguration(putCloudantSecurityConfigurationOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putCloudantSecurityConfigurationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the putCloudantSecurityConfiguration operation with and without retries enabled
  @Test
  public void testPutCloudantSecurityConfigurationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutCloudantSecurityConfigurationWOptions();

    cloudantService.disableRetries();
    testPutCloudantSecurityConfigurationWOptions();
  }

  // Test the putCloudantSecurityConfiguration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutCloudantSecurityConfigurationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putCloudantSecurityConfiguration(null).execute();
  }

  // Test the getCorsInformation operation with a valid options model parameter
  @Test
  public void testGetCorsInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"allow_credentials\": true, \"enable_cors\": true, \"origins\": [\"origins\"]}";
    String getCorsInformationPath = "/_api/v2/user/config/cors";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetCorsInformationOptions model
    GetCorsInformationOptions getCorsInformationOptionsModel = new GetCorsInformationOptions();

    // Invoke getCorsInformation() with a valid options model and verify the result
    Response<CorsInformation> response = cloudantService.getCorsInformation(getCorsInformationOptionsModel).execute();
    assertNotNull(response);
    CorsInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCorsInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getCorsInformation operation with and without retries enabled
  @Test
  public void testGetCorsInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetCorsInformationWOptions();

    cloudantService.disableRetries();
    testGetCorsInformationWOptions();
  }

  // Test the putCorsConfiguration operation with a valid options model parameter
  @Test
  public void testPutCorsConfigurationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ok\": true}";
    String putCorsConfigurationPath = "/_api/v2/user/config/cors";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PutCorsConfigurationOptions model
    PutCorsConfigurationOptions putCorsConfigurationOptionsModel = new PutCorsConfigurationOptions.Builder()
      .origins(java.util.Arrays.asList("https://example.com", "https://www.example.com"))
      .allowCredentials(true)
      .enableCors(true)
      .build();

    // Invoke putCorsConfiguration() with a valid options model and verify the result
    Response<Ok> response = cloudantService.putCorsConfiguration(putCorsConfigurationOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putCorsConfigurationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the putCorsConfiguration operation with and without retries enabled
  @Test
  public void testPutCorsConfigurationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutCorsConfigurationWOptions();

    cloudantService.disableRetries();
    testPutCorsConfigurationWOptions();
  }

  // Test the putCorsConfiguration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutCorsConfigurationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putCorsConfiguration(null).execute();
  }

  // Test the headAttachment operation with a valid options model parameter
  @Test
  public void testHeadAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String headAttachmentPath = "/testString/testString/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the HeadAttachmentOptions model
    HeadAttachmentOptions headAttachmentOptionsModel = new HeadAttachmentOptions.Builder()
      .db("testString")
      .docId("testString")
      .attachmentName("testString")
      .ifMatch("testString")
      .ifNoneMatch("testString")
      .rev("testString")
      .build();

    // Invoke headAttachment() with a valid options model and verify the result
    Response<Void> response = cloudantService.headAttachment(headAttachmentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headAttachmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("rev"), "testString");
  }

  // Test the headAttachment operation with and without retries enabled
  @Test
  public void testHeadAttachmentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testHeadAttachmentWOptions();

    cloudantService.disableRetries();
    testHeadAttachmentWOptions();
  }

  // Test the headAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.headAttachment(null).execute();
  }

  // Test the deleteAttachment operation with a valid options model parameter
  @Test
  public void testDeleteAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String deleteAttachmentPath = "/testString/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteAttachmentOptions model
    DeleteAttachmentOptions deleteAttachmentOptionsModel = new DeleteAttachmentOptions.Builder()
      .db("testString")
      .docId("testString")
      .attachmentName("testString")
      .ifMatch("testString")
      .rev("testString")
      .batch("ok")
      .build();

    // Invoke deleteAttachment() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.deleteAttachment(deleteAttachmentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAttachmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("rev"), "testString");
    assertEquals(query.get("batch"), "ok");
  }

  // Test the deleteAttachment operation with and without retries enabled
  @Test
  public void testDeleteAttachmentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testDeleteAttachmentWOptions();

    cloudantService.disableRetries();
    testDeleteAttachmentWOptions();
  }

  // Test the deleteAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.deleteAttachment(null).execute();
  }

  // Test the getAttachment operation with a valid options model parameter
  @Test
  public void testGetAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String getAttachmentPath = "/testString/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "*/*")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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

    // Invoke getAttachment() with a valid options model and verify the result
    Response<InputStream> response = cloudantService.getAttachment(getAttachmentOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertNotNull(responseObj);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAttachmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("rev"), "testString");
  }

  // Test the getAttachment operation with and without retries enabled
  @Test
  public void testGetAttachmentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetAttachmentWOptions();

    cloudantService.disableRetries();
    testGetAttachmentWOptions();
  }

  // Test the getAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getAttachment(null).execute();
  }

  // Test the putAttachment operation with a valid options model parameter
  @Test
  public void testPutAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String putAttachmentPath = "/testString/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

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

    // Invoke putAttachment() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.putAttachment(putAttachmentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putAttachmentPath);
    // Verify header parameters
    assertEquals(request.getHeader("Content-Type"), "application/octet-stream");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("rev"), "testString");
  }

  // Test the putAttachment operation with and without retries enabled
  @Test
  public void testPutAttachmentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutAttachmentWOptions();

    cloudantService.disableRetries();
    testPutAttachmentWOptions();
  }

  // Test the putAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putAttachment(null).execute();
  }

  // Test the headLocalDocument operation with a valid options model parameter
  @Test
  public void testHeadLocalDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String headLocalDocumentPath = "/testString/_local/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the HeadLocalDocumentOptions model
    HeadLocalDocumentOptions headLocalDocumentOptionsModel = new HeadLocalDocumentOptions.Builder()
      .db("testString")
      .docId("testString")
      .ifNoneMatch("testString")
      .build();

    // Invoke headLocalDocument() with a valid options model and verify the result
    Response<Void> response = cloudantService.headLocalDocument(headLocalDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headLocalDocumentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the headLocalDocument operation with and without retries enabled
  @Test
  public void testHeadLocalDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testHeadLocalDocumentWOptions();

    cloudantService.disableRetries();
    testHeadLocalDocumentWOptions();
  }

  // Test the headLocalDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadLocalDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.headLocalDocument(null).execute();
  }

  // Test the deleteLocalDocument operation with a valid options model parameter
  @Test
  public void testDeleteLocalDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String deleteLocalDocumentPath = "/testString/_local/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteLocalDocumentOptions model
    DeleteLocalDocumentOptions deleteLocalDocumentOptionsModel = new DeleteLocalDocumentOptions.Builder()
      .db("testString")
      .docId("testString")
      .batch("ok")
      .build();

    // Invoke deleteLocalDocument() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.deleteLocalDocument(deleteLocalDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteLocalDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("batch"), "ok");
  }

  // Test the deleteLocalDocument operation with and without retries enabled
  @Test
  public void testDeleteLocalDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testDeleteLocalDocumentWOptions();

    cloudantService.disableRetries();
    testDeleteLocalDocumentWOptions();
  }

  // Test the deleteLocalDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteLocalDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.deleteLocalDocument(null).execute();
  }

  // Test the getLocalDocument operation with a valid options model parameter
  @Test
  public void testGetLocalDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"_attachments\": {\"mapKey\": {\"content_type\": \"contentType\", \"data\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"digest\": \"digest\", \"encoded_length\": 0, \"encoding\": \"encoding\", \"follows\": false, \"length\": 0, \"revpos\": 1, \"stub\": true}}, \"_conflicts\": [\"conflicts\"], \"_deleted\": false, \"_deleted_conflicts\": [\"deletedConflicts\"], \"_id\": \"id\", \"_local_seq\": \"localSeq\", \"_rev\": \"rev\", \"_revisions\": {\"ids\": [\"ids\"], \"start\": 1}, \"_revs_info\": [{\"rev\": \"rev\", \"status\": \"available\"}]}";
    String getLocalDocumentPath = "/testString/_local/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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

    // Invoke getLocalDocument() with a valid options model and verify the result
    Response<Document> response = cloudantService.getLocalDocument(getLocalDocumentOptionsModel).execute();
    assertNotNull(response);
    Document responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLocalDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("attachments")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("att_encoding_info")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("local_seq")), Boolean.valueOf(false));
  }

  // Test the getLocalDocument operation with and without retries enabled
  @Test
  public void testGetLocalDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetLocalDocumentWOptions();

    cloudantService.disableRetries();
    testGetLocalDocumentWOptions();
  }

  // Test the getLocalDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLocalDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getLocalDocument(null).execute();
  }

  // Test the putLocalDocument operation with a valid options model parameter
  @Test
  public void testPutLocalDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"rev\": \"rev\", \"ok\": true, \"caused_by\": \"causedBy\", \"error\": \"error\", \"reason\": \"reason\", \"ref\": 3}";
    String putLocalDocumentPath = "/testString/_local/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Attachment model
    Attachment attachmentModel = new Attachment.Builder()
      .contentType("testString")
      .data(TestUtilities.createMockByteArray("VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4="))
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
      .ids(java.util.Arrays.asList("testString"))
      .start(Long.valueOf("1"))
      .build();

    // Construct an instance of the DocumentRevisionStatus model
    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
      .rev("testString")
      .status("available")
      .build();

    // Construct an instance of the Document model
    Document documentModel = new Document.Builder()
      .attachments(java.util.Collections.singletonMap("key1", attachmentModel))
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("exampleid")
      .localSeq("testString")
      .rev("testString")
      .revisions(revisionsModel)
      .revsInfo(java.util.Arrays.asList(documentRevisionStatusModel))
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

    // Invoke putLocalDocument() with a valid options model and verify the result
    Response<DocumentResult> response = cloudantService.putLocalDocument(putLocalDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putLocalDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("batch"), "ok");
  }

  // Test the putLocalDocument operation with and without retries enabled
  @Test
  public void testPutLocalDocumentWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPutLocalDocumentWOptions();

    cloudantService.disableRetries();
    testPutLocalDocumentWOptions();
  }

  // Test the putLocalDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutLocalDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.putLocalDocument(null).execute();
  }

  // Test the postRevsDiff operation with a valid options model parameter
  @Test
  public void testPostRevsDiffWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"mapKey\": {\"missing\": [\"missing\"], \"possible_ancestors\": [\"possibleAncestors\"]}}";
    String postRevsDiffPath = "/testString/_revs_diff";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostRevsDiffOptions model
    PostRevsDiffOptions postRevsDiffOptionsModel = new PostRevsDiffOptions.Builder()
      .db("testString")
      .documentRevisions(java.util.Collections.singletonMap("key1", java.util.Arrays.asList("testString")))
      .build();

    // Invoke postRevsDiff() with a valid options model and verify the result
    Response<Map<String, RevsDiff>> response = cloudantService.postRevsDiff(postRevsDiffOptionsModel).execute();
    assertNotNull(response);
    Map<String, RevsDiff> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postRevsDiffPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postRevsDiff operation with and without retries enabled
  @Test
  public void testPostRevsDiffWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostRevsDiffWOptions();

    cloudantService.disableRetries();
    testPostRevsDiffWOptions();
  }

  // Test the postRevsDiff operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostRevsDiffNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postRevsDiff(null).execute();
  }

  // Test the getShardsInformation operation with a valid options model parameter
  @Test
  public void testGetShardsInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"shards\": {\"mapKey\": [\"inner\"]}}";
    String getShardsInformationPath = "/testString/_shards";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetShardsInformationOptions model
    GetShardsInformationOptions getShardsInformationOptionsModel = new GetShardsInformationOptions.Builder()
      .db("testString")
      .build();

    // Invoke getShardsInformation() with a valid options model and verify the result
    Response<ShardsInformation> response = cloudantService.getShardsInformation(getShardsInformationOptionsModel).execute();
    assertNotNull(response);
    ShardsInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getShardsInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getShardsInformation operation with and without retries enabled
  @Test
  public void testGetShardsInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetShardsInformationWOptions();

    cloudantService.disableRetries();
    testGetShardsInformationWOptions();
  }

  // Test the getShardsInformation operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetShardsInformationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getShardsInformation(null).execute();
  }

  // Test the getDocumentShardsInfo operation with a valid options model parameter
  @Test
  public void testGetDocumentShardsInfoWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"nodes\": [\"nodes\"], \"range\": \"range\"}";
    String getDocumentShardsInfoPath = "/testString/_shards/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetDocumentShardsInfoOptions model
    GetDocumentShardsInfoOptions getDocumentShardsInfoOptionsModel = new GetDocumentShardsInfoOptions.Builder()
      .db("testString")
      .docId("testString")
      .build();

    // Invoke getDocumentShardsInfo() with a valid options model and verify the result
    Response<DocumentShardInfo> response = cloudantService.getDocumentShardsInfo(getDocumentShardsInfoOptionsModel).execute();
    assertNotNull(response);
    DocumentShardInfo responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentShardsInfoPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getDocumentShardsInfo operation with and without retries enabled
  @Test
  public void testGetDocumentShardsInfoWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetDocumentShardsInfoWOptions();

    cloudantService.disableRetries();
    testGetDocumentShardsInfoWOptions();
  }

  // Test the getDocumentShardsInfo operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentShardsInfoNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.getDocumentShardsInfo(null).execute();
  }

  // Test the headUpInformation operation with a valid options model parameter
  @Test
  public void testHeadUpInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String headUpInformationPath = "/_up";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the HeadUpInformationOptions model
    HeadUpInformationOptions headUpInformationOptionsModel = new HeadUpInformationOptions();

    // Invoke headUpInformation() with a valid options model and verify the result
    Response<Void> response = cloudantService.headUpInformation(headUpInformationOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, headUpInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the headUpInformation operation with and without retries enabled
  @Test
  public void testHeadUpInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testHeadUpInformationWOptions();

    cloudantService.disableRetries();
    testHeadUpInformationWOptions();
  }

  // Test the getActiveTasks operation with a valid options model parameter
  @Test
  public void testGetActiveTasksWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "[{\"bulk_get_attempts\": 0, \"bulk_get_docs\": 0, \"changes_done\": 0, \"changes_pending\": 0, \"checkpoint_interval\": 30000, \"checkpointed_source_seq\": \"checkpointedSourceSeq\", \"continuous\": false, \"database\": \"database\", \"design_document\": \"designDocument\", \"doc_id\": \"docId\", \"doc_write_failures\": 0, \"docs_read\": 0, \"docs_written\": 0, \"index\": \"index\", \"indexer_pid\": \"indexerPid\", \"missing_revisions_found\": 0, \"node\": \"node\", \"phase\": \"docid_sort\", \"pid\": \"pid\", \"process_status\": \"exiting\", \"progress\": 0, \"replication_id\": \"replicationId\", \"retry\": false, \"revisions_checked\": 0, \"source\": \"source\", \"source_seq\": \"sourceSeq\", \"started_on\": 0, \"target\": \"target\", \"through_seq\": \"throughSeq\", \"total_changes\": 0, \"type\": \"database_compaction\", \"updated_on\": 0, \"user\": \"user\", \"view\": 0}]";
    String getActiveTasksPath = "/_active_tasks";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetActiveTasksOptions model
    GetActiveTasksOptions getActiveTasksOptionsModel = new GetActiveTasksOptions();

    // Invoke getActiveTasks() with a valid options model and verify the result
    Response<List<ActiveTask>> response = cloudantService.getActiveTasks(getActiveTasksOptionsModel).execute();
    assertNotNull(response);
    List<ActiveTask> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getActiveTasksPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getActiveTasks operation with and without retries enabled
  @Test
  public void testGetActiveTasksWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetActiveTasksWOptions();

    cloudantService.disableRetries();
    testGetActiveTasksWOptions();
  }

  // Test the getUpInformation operation with a valid options model parameter
  @Test
  public void testGetUpInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"seeds\": {\"anyKey\": \"anyValue\"}, \"status\": \"maintenance_mode\"}";
    String getUpInformationPath = "/_up";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetUpInformationOptions model
    GetUpInformationOptions getUpInformationOptionsModel = new GetUpInformationOptions();

    // Invoke getUpInformation() with a valid options model and verify the result
    Response<UpInformation> response = cloudantService.getUpInformation(getUpInformationOptionsModel).execute();
    assertNotNull(response);
    UpInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getUpInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getUpInformation operation with and without retries enabled
  @Test
  public void testGetUpInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetUpInformationWOptions();

    cloudantService.disableRetries();
    testGetUpInformationWOptions();
  }

  // Test the getActivityTrackerEvents operation with a valid options model parameter
  @Test
  public void testGetActivityTrackerEventsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"types\": [\"management\"]}";
    String getActivityTrackerEventsPath = "/_api/v2/user/activity_tracker/events";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetActivityTrackerEventsOptions model
    GetActivityTrackerEventsOptions getActivityTrackerEventsOptionsModel = new GetActivityTrackerEventsOptions();

    // Invoke getActivityTrackerEvents() with a valid options model and verify the result
    Response<ActivityTrackerEvents> response = cloudantService.getActivityTrackerEvents(getActivityTrackerEventsOptionsModel).execute();
    assertNotNull(response);
    ActivityTrackerEvents responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getActivityTrackerEventsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getActivityTrackerEvents operation with and without retries enabled
  @Test
  public void testGetActivityTrackerEventsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetActivityTrackerEventsWOptions();

    cloudantService.disableRetries();
    testGetActivityTrackerEventsWOptions();
  }

  // Test the postActivityTrackerEvents operation with a valid options model parameter
  @Test
  public void testPostActivityTrackerEventsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ok\": true}";
    String postActivityTrackerEventsPath = "/_api/v2/user/activity_tracker/events";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostActivityTrackerEventsOptions model
    PostActivityTrackerEventsOptions postActivityTrackerEventsOptionsModel = new PostActivityTrackerEventsOptions.Builder()
      .types(java.util.Arrays.asList("management", "data"))
      .build();

    // Invoke postActivityTrackerEvents() with a valid options model and verify the result
    Response<Ok> response = cloudantService.postActivityTrackerEvents(postActivityTrackerEventsOptionsModel).execute();
    assertNotNull(response);
    Ok responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postActivityTrackerEventsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postActivityTrackerEvents operation with and without retries enabled
  @Test
  public void testPostActivityTrackerEventsWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testPostActivityTrackerEventsWOptions();

    cloudantService.disableRetries();
    testPostActivityTrackerEventsWOptions();
  }

  // Test the postActivityTrackerEvents operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostActivityTrackerEventsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cloudantService.postActivityTrackerEvents(null).execute();
  }

  // Test the getCurrentThroughputInformation operation with a valid options model parameter
  @Test
  public void testGetCurrentThroughputInformationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"throughput\": {\"query\": 0, \"read\": 0, \"write\": 0}}";
    String getCurrentThroughputInformationPath = "/_api/v2/user/current/throughput";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetCurrentThroughputInformationOptions model
    GetCurrentThroughputInformationOptions getCurrentThroughputInformationOptionsModel = new GetCurrentThroughputInformationOptions();

    // Invoke getCurrentThroughputInformation() with a valid options model and verify the result
    Response<CurrentThroughputInformation> response = cloudantService.getCurrentThroughputInformation(getCurrentThroughputInformationOptionsModel).execute();
    assertNotNull(response);
    CurrentThroughputInformation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCurrentThroughputInformationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getCurrentThroughputInformation operation with and without retries enabled
  @Test
  public void testGetCurrentThroughputInformationWRetries() throws Throwable {
    cloudantService.enableRetries(4, 30);
    testGetCurrentThroughputInformationWOptions();

    cloudantService.disableRetries();
    testGetCurrentThroughputInformationWOptions();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    cloudantService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    cloudantService = Cloudant.newInstance(serviceName);
    String url = server.url("/").toString();
    cloudantService.setServiceUrl(url);
  }
}