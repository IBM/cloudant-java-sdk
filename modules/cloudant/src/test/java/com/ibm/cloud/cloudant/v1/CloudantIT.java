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
import com.ibm.cloud.cloudant.v1.model.PostReplicatorOptions;
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
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.test.SdkIntegrationTestBase;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the Cloudant service.
 */
public class CloudantIT extends SdkIntegrationTestBase {
  public Cloudant service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../cloudant_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = Cloudant.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(Cloudant.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetServerInformation() throws Exception {
    try {
      GetServerInformationOptions getServerInformationOptions = new GetServerInformationOptions();

      // Invoke operation
      Response<ServerInformation> response = service.getServerInformation(getServerInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ServerInformation serverInformationResult = response.getResult();
      assertNotNull(serverInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetServerInformation" })
  public void testGetCapacityThroughputInformation() throws Exception {
    try {
      GetCapacityThroughputInformationOptions getCapacityThroughputInformationOptions = new GetCapacityThroughputInformationOptions();

      // Invoke operation
      Response<CapacityThroughputInformation> response = service.getCapacityThroughputInformation(getCapacityThroughputInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CapacityThroughputInformation capacityThroughputInformationResult = response.getResult();
      assertNotNull(capacityThroughputInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetCapacityThroughputInformation" })
  public void testPutCapacityThroughputConfiguration() throws Exception {
    try {
      PutCapacityThroughputConfigurationOptions putCapacityThroughputConfigurationOptions = new PutCapacityThroughputConfigurationOptions.Builder()
        .blocks(Long.valueOf("10"))
        .build();

      // Invoke operation
      Response<CapacityThroughputInformation> response = service.putCapacityThroughputConfiguration(putCapacityThroughputConfigurationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CapacityThroughputInformation capacityThroughputInformationResult = response.getResult();
      assertNotNull(capacityThroughputInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutCapacityThroughputConfiguration" })
  public void testGetUuids() throws Exception {
    try {
      GetUuidsOptions getUuidsOptions = new GetUuidsOptions.Builder()
        .count(Long.valueOf("1"))
        .build();

      // Invoke operation
      Response<UuidsResult> response = service.getUuids(getUuidsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      UuidsResult uuidsResultResult = response.getResult();
      assertNotNull(uuidsResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetUuids" })
  public void testGetDbUpdates() throws Exception {
    try {
      GetDbUpdatesOptions getDbUpdatesOptions = new GetDbUpdatesOptions.Builder()
        .descending(false)
        .feed("normal")
        .heartbeat(Long.valueOf("1"))
        .limit(Long.valueOf("0"))
        .timeout(Long.valueOf("60000"))
        .since("0")
        .build();

      // Invoke operation
      Response<DbUpdates> response = service.getDbUpdates(getDbUpdatesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DbUpdates dbUpdatesResult = response.getResult();
      assertNotNull(dbUpdatesResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDbUpdates" })
  public void testPostChanges() throws Exception {
    try {
      PostChangesOptions postChangesOptions = new PostChangesOptions.Builder()
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
        .heartbeat(Long.valueOf("1"))
        .includeDocs(false)
        .limit(Long.valueOf("0"))
        .seqInterval(Long.valueOf("1"))
        .since("0")
        .style("main_only")
        .timeout(Long.valueOf("60000"))
        .view("testString")
        .build();

      // Invoke operation
      Response<ChangesResult> response = service.postChanges(postChangesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ChangesResult changesResultResult = response.getResult();
      assertNotNull(changesResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostChanges" })
  public void testPostChangesAsStream() throws Exception {
    try {
      PostChangesOptions postChangesOptions = new PostChangesOptions.Builder()
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
        .heartbeat(Long.valueOf("1"))
        .includeDocs(false)
        .limit(Long.valueOf("0"))
        .seqInterval(Long.valueOf("1"))
        .since("0")
        .style("main_only")
        .timeout(Long.valueOf("60000"))
        .view("testString")
        .build();

      // Invoke operation
      Response<InputStream> response = service.postChangesAsStream(postChangesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostChangesAsStream" })
  public void testHeadDatabase() throws Exception {
    try {
      HeadDatabaseOptions headDatabaseOptions = new HeadDatabaseOptions.Builder()
        .db("testString")
        .build();

      // Invoke operation
      Response<Void> response = service.headDatabase(headDatabaseOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testHeadDatabase" })
  public void testGetAllDbs() throws Exception {
    try {
      GetAllDbsOptions getAllDbsOptions = new GetAllDbsOptions.Builder()
        .descending(false)
        .endKey("testString")
        .limit(Long.valueOf("0"))
        .skip(Long.valueOf("0"))
        .startKey("testString")
        .build();

      // Invoke operation
      Response<List<String>> response = service.getAllDbs(getAllDbsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      List<String> resultResult = response.getResult();
      assertNotNull(resultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetAllDbs" })
  public void testPostDbsInfo() throws Exception {
    try {
      PostDbsInfoOptions postDbsInfoOptions = new PostDbsInfoOptions.Builder()
        .keys(java.util.Arrays.asList("products", "users", "orders"))
        .build();

      // Invoke operation
      Response<List<DbsInfoResult>> response = service.postDbsInfo(postDbsInfoOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      List<DbsInfoResult> listDbsInfoResultResult = response.getResult();
      assertNotNull(listDbsInfoResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostDbsInfo" })
  public void testGetDatabaseInformation() throws Exception {
    try {
      GetDatabaseInformationOptions getDatabaseInformationOptions = new GetDatabaseInformationOptions.Builder()
        .db("testString")
        .build();

      // Invoke operation
      Response<DatabaseInformation> response = service.getDatabaseInformation(getDatabaseInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DatabaseInformation databaseInformationResult = response.getResult();
      assertNotNull(databaseInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDatabaseInformation" })
  public void testPutDatabase() throws Exception {
    try {
      PutDatabaseOptions putDatabaseOptions = new PutDatabaseOptions.Builder()
        .db("testString")
        .partitioned(false)
        .q(Long.valueOf("16"))
        .build();

      // Invoke operation
      Response<Ok> response = service.putDatabase(putDatabaseOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Ok okResult = response.getResult();
      assertNotNull(okResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutDatabase" })
  public void testHeadDocument() throws Exception {
    try {
      HeadDocumentOptions headDocumentOptions = new HeadDocumentOptions.Builder()
        .db("testString")
        .docId("testString")
        .ifNoneMatch("testString")
        .latest(false)
        .rev("testString")
        .build();

      // Invoke operation
      Response<Void> response = service.headDocument(headDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testHeadDocument" })
  public void testPostDocument() throws Exception {
    try {
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

      Revisions revisionsModel = new Revisions.Builder()
        .ids(java.util.Arrays.asList("testString"))
        .start(Long.valueOf("1"))
        .build();

      DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
        .rev("testString")
        .status("available")
        .build();

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

      PostDocumentOptions postDocumentOptions = new PostDocumentOptions.Builder()
        .db("testString")
        .document(documentModel)
        .contentType("application/json")
        .batch("ok")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.postDocument(postDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostDocument" })
  public void testPostAllDocs() throws Exception {
    try {
      PostAllDocsOptions postAllDocsOptions = new PostAllDocsOptions.Builder()
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

      // Invoke operation
      Response<AllDocsResult> response = service.postAllDocs(postAllDocsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AllDocsResult allDocsResultResult = response.getResult();
      assertNotNull(allDocsResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostAllDocs" })
  public void testPostAllDocsAsStream() throws Exception {
    try {
      PostAllDocsOptions postAllDocsOptions = new PostAllDocsOptions.Builder()
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

      // Invoke operation
      Response<InputStream> response = service.postAllDocsAsStream(postAllDocsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostAllDocsAsStream" })
  public void testPostAllDocsQueries() throws Exception {
    try {
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

      PostAllDocsQueriesOptions postAllDocsQueriesOptions = new PostAllDocsQueriesOptions.Builder()
        .db("testString")
        .queries(java.util.Arrays.asList(allDocsQueryModel))
        .build();

      // Invoke operation
      Response<AllDocsQueriesResult> response = service.postAllDocsQueries(postAllDocsQueriesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AllDocsQueriesResult allDocsQueriesResultResult = response.getResult();
      assertNotNull(allDocsQueriesResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostAllDocsQueries" })
  public void testPostAllDocsQueriesAsStream() throws Exception {
    try {
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

      PostAllDocsQueriesOptions postAllDocsQueriesOptions = new PostAllDocsQueriesOptions.Builder()
        .db("testString")
        .queries(java.util.Arrays.asList(allDocsQueryModel))
        .build();

      // Invoke operation
      Response<InputStream> response = service.postAllDocsQueriesAsStream(postAllDocsQueriesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostAllDocsQueriesAsStream" })
  public void testPostBulkDocs() throws Exception {
    try {
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

      Revisions revisionsModel = new Revisions.Builder()
        .ids(java.util.Arrays.asList("testString"))
        .start(Long.valueOf("1"))
        .build();

      DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
        .rev("testString")
        .status("available")
        .build();

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

      BulkDocs bulkDocsModel = new BulkDocs.Builder()
        .docs(java.util.Arrays.asList(documentModel))
        .newEdits(true)
        .build();

      PostBulkDocsOptions postBulkDocsOptions = new PostBulkDocsOptions.Builder()
        .db("testString")
        .bulkDocs(bulkDocsModel)
        .build();

      // Invoke operation
      Response<List<DocumentResult>> response = service.postBulkDocs(postBulkDocsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      List<DocumentResult> listDocumentResultResult = response.getResult();
      assertNotNull(listDocumentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostBulkDocs" })
  public void testPostBulkGet() throws Exception {
    try {
      BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
        .attsSince(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"))
        .id("order00067")
        .rev("3-917fa2381192822767f010b95b45325b")
        .build();

      PostBulkGetOptions postBulkGetOptions = new PostBulkGetOptions.Builder()
        .db("testString")
        .docs(java.util.Arrays.asList(bulkGetQueryDocumentModel))
        .attachments(false)
        .attEncodingInfo(false)
        .latest(false)
        .revs(false)
        .build();

      // Invoke operation
      Response<BulkGetResult> response = service.postBulkGet(postBulkGetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BulkGetResult bulkGetResultResult = response.getResult();
      assertNotNull(bulkGetResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostBulkGet" })
  public void testPostBulkGetAsMixed() throws Exception {
    try {
      BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
        .attsSince(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"))
        .id("order00067")
        .rev("3-917fa2381192822767f010b95b45325b")
        .build();

      PostBulkGetOptions postBulkGetOptions = new PostBulkGetOptions.Builder()
        .db("testString")
        .docs(java.util.Arrays.asList(bulkGetQueryDocumentModel))
        .attachments(false)
        .attEncodingInfo(false)
        .latest(false)
        .revs(false)
        .build();

      // Invoke operation
      Response<InputStream> response = service.postBulkGetAsMixed(postBulkGetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostBulkGetAsMixed" })
  public void testPostBulkGetAsRelated() throws Exception {
    try {
      BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
        .attsSince(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"))
        .id("order00067")
        .rev("3-917fa2381192822767f010b95b45325b")
        .build();

      PostBulkGetOptions postBulkGetOptions = new PostBulkGetOptions.Builder()
        .db("testString")
        .docs(java.util.Arrays.asList(bulkGetQueryDocumentModel))
        .attachments(false)
        .attEncodingInfo(false)
        .latest(false)
        .revs(false)
        .build();

      // Invoke operation
      Response<InputStream> response = service.postBulkGetAsRelated(postBulkGetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostBulkGetAsRelated" })
  public void testPostBulkGetAsStream() throws Exception {
    try {
      BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
        .attsSince(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"))
        .id("order00067")
        .rev("3-917fa2381192822767f010b95b45325b")
        .build();

      PostBulkGetOptions postBulkGetOptions = new PostBulkGetOptions.Builder()
        .db("testString")
        .docs(java.util.Arrays.asList(bulkGetQueryDocumentModel))
        .attachments(false)
        .attEncodingInfo(false)
        .latest(false)
        .revs(false)
        .build();

      // Invoke operation
      Response<InputStream> response = service.postBulkGetAsStream(postBulkGetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostBulkGetAsStream" })
  public void testGetDocument() throws Exception {
    try {
      GetDocumentOptions getDocumentOptions = new GetDocumentOptions.Builder()
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

      // Invoke operation
      Response<Document> response = service.getDocument(getDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Document documentResult = response.getResult();
      assertNotNull(documentResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDocument" })
  public void testGetDocumentAsMixed() throws Exception {
    try {
      GetDocumentOptions getDocumentOptions = new GetDocumentOptions.Builder()
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

      // Invoke operation
      Response<InputStream> response = service.getDocumentAsMixed(getDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDocumentAsMixed" })
  public void testGetDocumentAsRelated() throws Exception {
    try {
      GetDocumentOptions getDocumentOptions = new GetDocumentOptions.Builder()
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

      // Invoke operation
      Response<InputStream> response = service.getDocumentAsRelated(getDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDocumentAsRelated" })
  public void testGetDocumentAsStream() throws Exception {
    try {
      GetDocumentOptions getDocumentOptions = new GetDocumentOptions.Builder()
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

      // Invoke operation
      Response<InputStream> response = service.getDocumentAsStream(getDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDocumentAsStream" })
  public void testPutDocument() throws Exception {
    try {
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

      Revisions revisionsModel = new Revisions.Builder()
        .ids(java.util.Arrays.asList("testString"))
        .start(Long.valueOf("1"))
        .build();

      DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
        .rev("testString")
        .status("available")
        .build();

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

      PutDocumentOptions putDocumentOptions = new PutDocumentOptions.Builder()
        .db("testString")
        .docId("testString")
        .document(documentModel)
        .contentType("application/json")
        .ifMatch("testString")
        .batch("ok")
        .newEdits(false)
        .rev("testString")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.putDocument(putDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutDocument" })
  public void testHeadDesignDocument() throws Exception {
    try {
      HeadDesignDocumentOptions headDesignDocumentOptions = new HeadDesignDocumentOptions.Builder()
        .db("testString")
        .ddoc("testString")
        .ifNoneMatch("testString")
        .build();

      // Invoke operation
      Response<Void> response = service.headDesignDocument(headDesignDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testHeadDesignDocument" })
  public void testGetDesignDocument() throws Exception {
    try {
      GetDesignDocumentOptions getDesignDocumentOptions = new GetDesignDocumentOptions.Builder()
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

      // Invoke operation
      Response<DesignDocument> response = service.getDesignDocument(getDesignDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DesignDocument designDocumentResult = response.getResult();
      assertNotNull(designDocumentResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDesignDocument" })
  public void testPutDesignDocument() throws Exception {
    try {
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

      Revisions revisionsModel = new Revisions.Builder()
        .ids(java.util.Arrays.asList("testString"))
        .start(Long.valueOf("1"))
        .build();

      DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
        .rev("testString")
        .status("available")
        .build();

      Analyzer analyzerModel = new Analyzer.Builder()
        .name("classic")
        .stopwords(java.util.Arrays.asList("testString"))
        .build();

      AnalyzerConfiguration analyzerConfigurationModel = new AnalyzerConfiguration.Builder()
        .name("standard")
        .stopwords(java.util.Arrays.asList("testString"))
        .fields(java.util.Collections.singletonMap("key1", analyzerModel))
        .build();

      SearchIndexDefinition searchIndexDefinitionModel = new SearchIndexDefinition.Builder()
        .analyzer(analyzerConfigurationModel)
        .index("function (doc) {\n  index(\"price\", doc.price);\n}")
        .build();

      DesignDocumentOptions designDocumentOptionsModel = new DesignDocumentOptions.Builder()
        .partitioned(true)
        .build();

      DesignDocumentViewsMapReduce designDocumentViewsMapReduceModel = new DesignDocumentViewsMapReduce.Builder()
        .map("function(doc) { \n  emit(doc.productid, [doc.brand, doc.name, doc.description]) \n}")
        .reduce("testString")
        .build();

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

      PutDesignDocumentOptions putDesignDocumentOptions = new PutDesignDocumentOptions.Builder()
        .db("testString")
        .ddoc("testString")
        .designDocument(designDocumentModel)
        .ifMatch("testString")
        .batch("ok")
        .newEdits(false)
        .rev("testString")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.putDesignDocument(putDesignDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutDesignDocument" })
  public void testGetDesignDocumentInformation() throws Exception {
    try {
      GetDesignDocumentInformationOptions getDesignDocumentInformationOptions = new GetDesignDocumentInformationOptions.Builder()
        .db("testString")
        .ddoc("testString")
        .build();

      // Invoke operation
      Response<DesignDocumentInformation> response = service.getDesignDocumentInformation(getDesignDocumentInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DesignDocumentInformation designDocumentInformationResult = response.getResult();
      assertNotNull(designDocumentInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDesignDocumentInformation" })
  public void testPostDesignDocs() throws Exception {
    try {
      PostDesignDocsOptions postDesignDocsOptions = new PostDesignDocsOptions.Builder()
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

      // Invoke operation
      Response<AllDocsResult> response = service.postDesignDocs(postDesignDocsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AllDocsResult allDocsResultResult = response.getResult();
      assertNotNull(allDocsResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostDesignDocs" })
  public void testPostDesignDocsQueries() throws Exception {
    try {
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

      PostDesignDocsQueriesOptions postDesignDocsQueriesOptions = new PostDesignDocsQueriesOptions.Builder()
        .db("testString")
        .queries(java.util.Arrays.asList(allDocsQueryModel))
        .accept("application/json")
        .build();

      // Invoke operation
      Response<AllDocsQueriesResult> response = service.postDesignDocsQueries(postDesignDocsQueriesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AllDocsQueriesResult allDocsQueriesResultResult = response.getResult();
      assertNotNull(allDocsQueriesResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostDesignDocsQueries" })
  public void testPostView() throws Exception {
    try {
      PostViewOptions postViewOptions = new PostViewOptions.Builder()
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

      // Invoke operation
      Response<ViewResult> response = service.postView(postViewOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ViewResult viewResultResult = response.getResult();
      assertNotNull(viewResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostView" })
  public void testPostViewAsStream() throws Exception {
    try {
      PostViewOptions postViewOptions = new PostViewOptions.Builder()
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

      // Invoke operation
      Response<InputStream> response = service.postViewAsStream(postViewOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostViewAsStream" })
  public void testPostViewQueries() throws Exception {
    try {
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

      PostViewQueriesOptions postViewQueriesOptions = new PostViewQueriesOptions.Builder()
        .db("testString")
        .ddoc("testString")
        .view("testString")
        .queries(java.util.Arrays.asList(viewQueryModel))
        .build();

      // Invoke operation
      Response<ViewQueriesResult> response = service.postViewQueries(postViewQueriesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ViewQueriesResult viewQueriesResultResult = response.getResult();
      assertNotNull(viewQueriesResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostViewQueries" })
  public void testPostViewQueriesAsStream() throws Exception {
    try {
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

      PostViewQueriesOptions postViewQueriesOptions = new PostViewQueriesOptions.Builder()
        .db("testString")
        .ddoc("testString")
        .view("testString")
        .queries(java.util.Arrays.asList(viewQueryModel))
        .build();

      // Invoke operation
      Response<InputStream> response = service.postViewQueriesAsStream(postViewQueriesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostViewQueriesAsStream" })
  public void testGetPartitionInformation() throws Exception {
    try {
      GetPartitionInformationOptions getPartitionInformationOptions = new GetPartitionInformationOptions.Builder()
        .db("testString")
        .partitionKey("testString")
        .build();

      // Invoke operation
      Response<PartitionInformation> response = service.getPartitionInformation(getPartitionInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PartitionInformation partitionInformationResult = response.getResult();
      assertNotNull(partitionInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetPartitionInformation" })
  public void testPostPartitionAllDocs() throws Exception {
    try {
      PostPartitionAllDocsOptions postPartitionAllDocsOptions = new PostPartitionAllDocsOptions.Builder()
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

      // Invoke operation
      Response<AllDocsResult> response = service.postPartitionAllDocs(postPartitionAllDocsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AllDocsResult allDocsResultResult = response.getResult();
      assertNotNull(allDocsResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostPartitionAllDocs" })
  public void testPostPartitionAllDocsAsStream() throws Exception {
    try {
      PostPartitionAllDocsOptions postPartitionAllDocsOptions = new PostPartitionAllDocsOptions.Builder()
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

      // Invoke operation
      Response<InputStream> response = service.postPartitionAllDocsAsStream(postPartitionAllDocsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostPartitionAllDocsAsStream" })
  public void testPostPartitionSearch() throws Exception {
    try {
      PostPartitionSearchOptions postPartitionSearchOptions = new PostPartitionSearchOptions.Builder()
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

      // Invoke operation
      Response<SearchResult> response = service.postPartitionSearch(postPartitionSearchOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SearchResult searchResultResult = response.getResult();
      assertNotNull(searchResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostPartitionSearch" })
  public void testPostPartitionSearchAsStream() throws Exception {
    try {
      PostPartitionSearchOptions postPartitionSearchOptions = new PostPartitionSearchOptions.Builder()
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

      // Invoke operation
      Response<InputStream> response = service.postPartitionSearchAsStream(postPartitionSearchOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostPartitionSearchAsStream" })
  public void testPostPartitionView() throws Exception {
    try {
      PostPartitionViewOptions postPartitionViewOptions = new PostPartitionViewOptions.Builder()
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

      // Invoke operation
      Response<ViewResult> response = service.postPartitionView(postPartitionViewOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ViewResult viewResultResult = response.getResult();
      assertNotNull(viewResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostPartitionView" })
  public void testPostPartitionViewAsStream() throws Exception {
    try {
      PostPartitionViewOptions postPartitionViewOptions = new PostPartitionViewOptions.Builder()
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

      // Invoke operation
      Response<InputStream> response = service.postPartitionViewAsStream(postPartitionViewOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostPartitionViewAsStream" })
  public void testPostPartitionExplain() throws Exception {
    try {
      PostPartitionExplainOptions postPartitionExplainOptions = new PostPartitionExplainOptions.Builder()
        .db("testString")
        .partitionKey("testString")
        .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .allowFallback(true)
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

      // Invoke operation
      Response<ExplainResult> response = service.postPartitionExplain(postPartitionExplainOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ExplainResult explainResultResult = response.getResult();
      assertNotNull(explainResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostPartitionExplain" })
  public void testPostPartitionFind() throws Exception {
    try {
      PostPartitionFindOptions postPartitionFindOptions = new PostPartitionFindOptions.Builder()
        .db("testString")
        .partitionKey("testString")
        .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .allowFallback(true)
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

      // Invoke operation
      Response<FindResult> response = service.postPartitionFind(postPartitionFindOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      FindResult findResultResult = response.getResult();
      assertNotNull(findResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostPartitionFind" })
  public void testPostPartitionFindAsStream() throws Exception {
    try {
      PostPartitionFindOptions postPartitionFindOptions = new PostPartitionFindOptions.Builder()
        .db("testString")
        .partitionKey("testString")
        .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .allowFallback(true)
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

      // Invoke operation
      Response<InputStream> response = service.postPartitionFindAsStream(postPartitionFindOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostPartitionFindAsStream" })
  public void testPostExplain() throws Exception {
    try {
      PostExplainOptions postExplainOptions = new PostExplainOptions.Builder()
        .db("testString")
        .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .allowFallback(true)
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

      // Invoke operation
      Response<ExplainResult> response = service.postExplain(postExplainOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ExplainResult explainResultResult = response.getResult();
      assertNotNull(explainResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostExplain" })
  public void testPostFind() throws Exception {
    try {
      PostFindOptions postFindOptions = new PostFindOptions.Builder()
        .db("testString")
        .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .allowFallback(true)
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

      // Invoke operation
      Response<FindResult> response = service.postFind(postFindOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      FindResult findResultResult = response.getResult();
      assertNotNull(findResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostFind" })
  public void testPostFindAsStream() throws Exception {
    try {
      PostFindOptions postFindOptions = new PostFindOptions.Builder()
        .db("testString")
        .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .allowFallback(true)
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

      // Invoke operation
      Response<InputStream> response = service.postFindAsStream(postFindOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostFindAsStream" })
  public void testGetIndexesInformation() throws Exception {
    try {
      GetIndexesInformationOptions getIndexesInformationOptions = new GetIndexesInformationOptions.Builder()
        .db("testString")
        .build();

      // Invoke operation
      Response<IndexesInformation> response = service.getIndexesInformation(getIndexesInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      IndexesInformation indexesInformationResult = response.getResult();
      assertNotNull(indexesInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetIndexesInformation" })
  public void testPostIndex() throws Exception {
    try {
      Analyzer analyzerModel = new Analyzer.Builder()
        .name("classic")
        .stopwords(java.util.Arrays.asList("testString"))
        .build();

      IndexTextOperatorDefaultField indexTextOperatorDefaultFieldModel = new IndexTextOperatorDefaultField.Builder()
        .analyzer(analyzerModel)
        .enabled(true)
        .build();

      IndexField indexFieldModel = new IndexField.Builder()
        .name("asc")
        .type("boolean")
        .add("foo", "asc")
        .build();

      IndexDefinition indexDefinitionModel = new IndexDefinition.Builder()
        .defaultAnalyzer(analyzerModel)
        .defaultField(indexTextOperatorDefaultFieldModel)
        .fields(java.util.Arrays.asList(indexFieldModel))
        .indexArrayLengths(true)
        .partialFilterSelector(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .build();

      PostIndexOptions postIndexOptions = new PostIndexOptions.Builder()
        .db("testString")
        .index(indexDefinitionModel)
        .ddoc("json-index")
        .name("getUserByName")
        .partitioned(true)
        .type("json")
        .build();

      // Invoke operation
      Response<IndexResult> response = service.postIndex(postIndexOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      IndexResult indexResultResult = response.getResult();
      assertNotNull(indexResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostIndex" })
  public void testPostSearchAnalyze() throws Exception {
    try {
      PostSearchAnalyzeOptions postSearchAnalyzeOptions = new PostSearchAnalyzeOptions.Builder()
        .analyzer("english")
        .text("running is fun")
        .build();

      // Invoke operation
      Response<SearchAnalyzeResult> response = service.postSearchAnalyze(postSearchAnalyzeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SearchAnalyzeResult searchAnalyzeResultResult = response.getResult();
      assertNotNull(searchAnalyzeResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostSearchAnalyze" })
  public void testPostSearch() throws Exception {
    try {
      PostSearchOptions postSearchOptions = new PostSearchOptions.Builder()
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
        .ranges(java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", "testString")))
        .build();

      // Invoke operation
      Response<SearchResult> response = service.postSearch(postSearchOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SearchResult searchResultResult = response.getResult();
      assertNotNull(searchResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostSearch" })
  public void testPostSearchAsStream() throws Exception {
    try {
      PostSearchOptions postSearchOptions = new PostSearchOptions.Builder()
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
        .ranges(java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", "testString")))
        .build();

      // Invoke operation
      Response<InputStream> response = service.postSearchAsStream(postSearchOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream resultResult = response.getResult();) {
          assertNotNull(resultResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostSearchAsStream" })
  public void testGetSearchInfo() throws Exception {
    try {
      GetSearchInfoOptions getSearchInfoOptions = new GetSearchInfoOptions.Builder()
        .db("testString")
        .ddoc("testString")
        .index("testString")
        .build();

      // Invoke operation
      Response<SearchInfoResult> response = service.getSearchInfo(getSearchInfoOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SearchInfoResult searchInfoResultResult = response.getResult();
      assertNotNull(searchInfoResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSearchInfo" })
  public void testHeadReplicationDocument() throws Exception {
    try {
      HeadReplicationDocumentOptions headReplicationDocumentOptions = new HeadReplicationDocumentOptions.Builder()
        .docId("testString")
        .ifNoneMatch("testString")
        .build();

      // Invoke operation
      Response<Void> response = service.headReplicationDocument(headReplicationDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testHeadReplicationDocument" })
  public void testHeadSchedulerDocument() throws Exception {
    try {
      HeadSchedulerDocumentOptions headSchedulerDocumentOptions = new HeadSchedulerDocumentOptions.Builder()
        .docId("testString")
        .build();

      // Invoke operation
      Response<Void> response = service.headSchedulerDocument(headSchedulerDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testHeadSchedulerDocument" })
  public void testHeadSchedulerJob() throws Exception {
    try {
      HeadSchedulerJobOptions headSchedulerJobOptions = new HeadSchedulerJobOptions.Builder()
        .jobId("testString")
        .build();

      // Invoke operation
      Response<Void> response = service.headSchedulerJob(headSchedulerJobOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testHeadSchedulerJob" })
  public void testPostReplicator() throws Exception {
    try {
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

      Revisions revisionsModel = new Revisions.Builder()
        .ids(java.util.Arrays.asList("testString"))
        .start(Long.valueOf("1"))
        .build();

      DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
        .rev("testString")
        .status("available")
        .build();

      ReplicationCreateTargetParameters replicationCreateTargetParametersModel = new ReplicationCreateTargetParameters.Builder()
        .n(Long.valueOf("3"))
        .partitioned(false)
        .q(Long.valueOf("1"))
        .build();

      ReplicationDatabaseAuthBasic replicationDatabaseAuthBasicModel = new ReplicationDatabaseAuthBasic.Builder()
        .password("testString")
        .username("testString")
        .build();

      ReplicationDatabaseAuthIam replicationDatabaseAuthIamModel = new ReplicationDatabaseAuthIam.Builder()
        .apiKey("testString")
        .build();

      ReplicationDatabaseAuth replicationDatabaseAuthModel = new ReplicationDatabaseAuth.Builder()
        .basic(replicationDatabaseAuthBasicModel)
        .iam(replicationDatabaseAuthIamModel)
        .build();

      ReplicationDatabase replicationDatabaseModel = new ReplicationDatabase.Builder()
        .auth(replicationDatabaseAuthModel)
        .headers(java.util.Collections.singletonMap("key1", "testString"))
        .url("https://my-source-instance.cloudantnosqldb.appdomain.cloud.example/animaldb")
        .build();

      UserContext userContextModel = new UserContext.Builder()
        .db("testString")
        .name("john")
        .roles(java.util.Arrays.asList("_replicator"))
        .build();

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

      PostReplicatorOptions postReplicatorOptions = new PostReplicatorOptions.Builder()
        .replicationDocument(replicationDocumentModel)
        .batch("ok")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.postReplicator(postReplicatorOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostReplicator" })
  public void testGetReplicationDocument() throws Exception {
    try {
      GetReplicationDocumentOptions getReplicationDocumentOptions = new GetReplicationDocumentOptions.Builder()
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

      // Invoke operation
      Response<ReplicationDocument> response = service.getReplicationDocument(getReplicationDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ReplicationDocument replicationDocumentResult = response.getResult();
      assertNotNull(replicationDocumentResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReplicationDocument" })
  public void testPutReplicationDocument() throws Exception {
    try {
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

      Revisions revisionsModel = new Revisions.Builder()
        .ids(java.util.Arrays.asList("testString"))
        .start(Long.valueOf("1"))
        .build();

      DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
        .rev("testString")
        .status("available")
        .build();

      ReplicationCreateTargetParameters replicationCreateTargetParametersModel = new ReplicationCreateTargetParameters.Builder()
        .n(Long.valueOf("3"))
        .partitioned(false)
        .q(Long.valueOf("1"))
        .build();

      ReplicationDatabaseAuthBasic replicationDatabaseAuthBasicModel = new ReplicationDatabaseAuthBasic.Builder()
        .password("testString")
        .username("testString")
        .build();

      ReplicationDatabaseAuthIam replicationDatabaseAuthIamModel = new ReplicationDatabaseAuthIam.Builder()
        .apiKey("testString")
        .build();

      ReplicationDatabaseAuth replicationDatabaseAuthModel = new ReplicationDatabaseAuth.Builder()
        .basic(replicationDatabaseAuthBasicModel)
        .iam(replicationDatabaseAuthIamModel)
        .build();

      ReplicationDatabase replicationDatabaseModel = new ReplicationDatabase.Builder()
        .auth(replicationDatabaseAuthModel)
        .headers(java.util.Collections.singletonMap("key1", "testString"))
        .url("https://my-source-instance.cloudantnosqldb.appdomain.cloud.example/animaldb")
        .build();

      UserContext userContextModel = new UserContext.Builder()
        .db("testString")
        .name("john")
        .roles(java.util.Arrays.asList("_replicator"))
        .build();

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

      PutReplicationDocumentOptions putReplicationDocumentOptions = new PutReplicationDocumentOptions.Builder()
        .docId("testString")
        .replicationDocument(replicationDocumentModel)
        .ifMatch("testString")
        .batch("ok")
        .newEdits(false)
        .rev("testString")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.putReplicationDocument(putReplicationDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutReplicationDocument" })
  public void testGetSchedulerDocs() throws Exception {
    try {
      GetSchedulerDocsOptions getSchedulerDocsOptions = new GetSchedulerDocsOptions.Builder()
        .limit(Long.valueOf("0"))
        .skip(Long.valueOf("0"))
        .states(java.util.Arrays.asList("initializing"))
        .build();

      // Invoke operation
      Response<SchedulerDocsResult> response = service.getSchedulerDocs(getSchedulerDocsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SchedulerDocsResult schedulerDocsResultResult = response.getResult();
      assertNotNull(schedulerDocsResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSchedulerDocs" })
  public void testGetSchedulerDocument() throws Exception {
    try {
      GetSchedulerDocumentOptions getSchedulerDocumentOptions = new GetSchedulerDocumentOptions.Builder()
        .docId("testString")
        .build();

      // Invoke operation
      Response<SchedulerDocument> response = service.getSchedulerDocument(getSchedulerDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SchedulerDocument schedulerDocumentResult = response.getResult();
      assertNotNull(schedulerDocumentResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSchedulerDocument" })
  public void testGetSchedulerJobs() throws Exception {
    try {
      GetSchedulerJobsOptions getSchedulerJobsOptions = new GetSchedulerJobsOptions.Builder()
        .limit(Long.valueOf("25"))
        .skip(Long.valueOf("0"))
        .build();

      // Invoke operation
      Response<SchedulerJobsResult> response = service.getSchedulerJobs(getSchedulerJobsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SchedulerJobsResult schedulerJobsResultResult = response.getResult();
      assertNotNull(schedulerJobsResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSchedulerJobs" })
  public void testGetSchedulerJob() throws Exception {
    try {
      GetSchedulerJobOptions getSchedulerJobOptions = new GetSchedulerJobOptions.Builder()
        .jobId("testString")
        .build();

      // Invoke operation
      Response<SchedulerJob> response = service.getSchedulerJob(getSchedulerJobOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SchedulerJob schedulerJobResult = response.getResult();
      assertNotNull(schedulerJobResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSchedulerJob" })
  public void testGetSessionInformation() throws Exception {
    try {
      GetSessionInformationOptions getSessionInformationOptions = new GetSessionInformationOptions();

      // Invoke operation
      Response<SessionInformation> response = service.getSessionInformation(getSessionInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SessionInformation sessionInformationResult = response.getResult();
      assertNotNull(sessionInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSessionInformation" })
  public void testPostApiKeys() throws Exception {
    try {
      PostApiKeysOptions postApiKeysOptions = new PostApiKeysOptions();

      // Invoke operation
      Response<ApiKeysResult> response = service.postApiKeys(postApiKeysOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ApiKeysResult apiKeysResultResult = response.getResult();
      assertNotNull(apiKeysResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostApiKeys" })
  public void testPutCloudantSecurityConfiguration() throws Exception {
    try {
      SecurityObject securityObjectModel = new SecurityObject.Builder()
        .names(java.util.Arrays.asList("testString"))
        .roles(java.util.Arrays.asList("testString"))
        .build();

      PutCloudantSecurityConfigurationOptions putCloudantSecurityConfigurationOptions = new PutCloudantSecurityConfigurationOptions.Builder()
        .db("testString")
        .cloudant(java.util.Collections.singletonMap("key1", java.util.Arrays.asList("_reader")))
        .admins(securityObjectModel)
        .couchdbAuthOnly(true)
        .members(securityObjectModel)
        .build();

      // Invoke operation
      Response<Ok> response = service.putCloudantSecurityConfiguration(putCloudantSecurityConfigurationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Ok okResult = response.getResult();
      assertNotNull(okResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutCloudantSecurityConfiguration" })
  public void testGetSecurity() throws Exception {
    try {
      GetSecurityOptions getSecurityOptions = new GetSecurityOptions.Builder()
        .db("testString")
        .build();

      // Invoke operation
      Response<Security> response = service.getSecurity(getSecurityOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Security securityResult = response.getResult();
      assertNotNull(securityResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSecurity" })
  public void testPutSecurity() throws Exception {
    try {
      SecurityObject securityObjectModel = new SecurityObject.Builder()
        .names(java.util.Arrays.asList("superuser"))
        .roles(java.util.Arrays.asList("admins"))
        .build();

      PutSecurityOptions putSecurityOptions = new PutSecurityOptions.Builder()
        .db("testString")
        .admins(securityObjectModel)
        .cloudant(java.util.Collections.singletonMap("key1", java.util.Arrays.asList("_reader")))
        .couchdbAuthOnly(true)
        .members(securityObjectModel)
        .build();

      // Invoke operation
      Response<Ok> response = service.putSecurity(putSecurityOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Ok okResult = response.getResult();
      assertNotNull(okResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutSecurity" })
  public void testGetCorsInformation() throws Exception {
    try {
      GetCorsInformationOptions getCorsInformationOptions = new GetCorsInformationOptions();

      // Invoke operation
      Response<CorsInformation> response = service.getCorsInformation(getCorsInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CorsInformation corsInformationResult = response.getResult();
      assertNotNull(corsInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetCorsInformation" })
  public void testPutCorsConfiguration() throws Exception {
    try {
      PutCorsConfigurationOptions putCorsConfigurationOptions = new PutCorsConfigurationOptions.Builder()
        .origins(java.util.Arrays.asList("https://example.com", "https://www.example.com"))
        .allowCredentials(true)
        .enableCors(true)
        .build();

      // Invoke operation
      Response<Ok> response = service.putCorsConfiguration(putCorsConfigurationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Ok okResult = response.getResult();
      assertNotNull(okResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutCorsConfiguration" })
  public void testHeadAttachment() throws Exception {
    try {
      HeadAttachmentOptions headAttachmentOptions = new HeadAttachmentOptions.Builder()
        .db("testString")
        .docId("testString")
        .attachmentName("testString")
        .ifMatch("testString")
        .ifNoneMatch("testString")
        .rev("testString")
        .build();

      // Invoke operation
      Response<Void> response = service.headAttachment(headAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testHeadAttachment" })
  public void testGetAttachment() throws Exception {
    try {
      GetAttachmentOptions getAttachmentOptions = new GetAttachmentOptions.Builder()
        .db("testString")
        .docId("testString")
        .attachmentName("testString")
        .accept("testString")
        .ifMatch("testString")
        .ifNoneMatch("testString")
        .range("testString")
        .rev("testString")
        .build();

      // Invoke operation
      Response<InputStream> response = service.getAttachment(getAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream inputStreamResult = response.getResult();) {
          assertNotNull(inputStreamResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetAttachment" })
  public void testPutAttachment() throws Exception {
    try {
      PutAttachmentOptions putAttachmentOptions = new PutAttachmentOptions.Builder()
        .db("testString")
        .docId("testString")
        .attachmentName("testString")
        .attachment(TestUtilities.createMockStream("This is a mock file."))
        .contentType("application/octet-stream")
        .ifMatch("testString")
        .rev("testString")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.putAttachment(putAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutAttachment" })
  public void testHeadLocalDocument() throws Exception {
    try {
      HeadLocalDocumentOptions headLocalDocumentOptions = new HeadLocalDocumentOptions.Builder()
        .db("testString")
        .docId("testString")
        .ifNoneMatch("testString")
        .build();

      // Invoke operation
      Response<Void> response = service.headLocalDocument(headLocalDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testHeadLocalDocument" })
  public void testGetLocalDocument() throws Exception {
    try {
      GetLocalDocumentOptions getLocalDocumentOptions = new GetLocalDocumentOptions.Builder()
        .db("testString")
        .docId("testString")
        .accept("application/json")
        .ifNoneMatch("testString")
        .attachments(false)
        .attEncodingInfo(false)
        .localSeq(false)
        .build();

      // Invoke operation
      Response<Document> response = service.getLocalDocument(getLocalDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Document documentResult = response.getResult();
      assertNotNull(documentResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetLocalDocument" })
  public void testPutLocalDocument() throws Exception {
    try {
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

      Revisions revisionsModel = new Revisions.Builder()
        .ids(java.util.Arrays.asList("testString"))
        .start(Long.valueOf("1"))
        .build();

      DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
        .rev("testString")
        .status("available")
        .build();

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

      PutLocalDocumentOptions putLocalDocumentOptions = new PutLocalDocumentOptions.Builder()
        .db("testString")
        .docId("testString")
        .document(documentModel)
        .contentType("application/json")
        .batch("ok")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.putLocalDocument(putLocalDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPutLocalDocument" })
  public void testPostRevsDiff() throws Exception {
    try {
      PostRevsDiffOptions postRevsDiffOptions = new PostRevsDiffOptions.Builder()
        .db("testString")
        .documentRevisions(java.util.Collections.singletonMap("key1", java.util.Arrays.asList("testString")))
        .build();

      // Invoke operation
      Response<Map<String, RevsDiff>> response = service.postRevsDiff(postRevsDiffOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Map<String, RevsDiff> mapStringRevsDiffResult = response.getResult();
      assertNotNull(mapStringRevsDiffResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostRevsDiff" })
  public void testGetShardsInformation() throws Exception {
    try {
      GetShardsInformationOptions getShardsInformationOptions = new GetShardsInformationOptions.Builder()
        .db("testString")
        .build();

      // Invoke operation
      Response<ShardsInformation> response = service.getShardsInformation(getShardsInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ShardsInformation shardsInformationResult = response.getResult();
      assertNotNull(shardsInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetShardsInformation" })
  public void testGetDocumentShardsInfo() throws Exception {
    try {
      GetDocumentShardsInfoOptions getDocumentShardsInfoOptions = new GetDocumentShardsInfoOptions.Builder()
        .db("testString")
        .docId("testString")
        .build();

      // Invoke operation
      Response<DocumentShardInfo> response = service.getDocumentShardsInfo(getDocumentShardsInfoOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DocumentShardInfo documentShardInfoResult = response.getResult();
      assertNotNull(documentShardInfoResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDocumentShardsInfo" })
  public void testHeadUpInformation() throws Exception {
    try {
      HeadUpInformationOptions headUpInformationOptions = new HeadUpInformationOptions();

      // Invoke operation
      Response<Void> response = service.headUpInformation(headUpInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testHeadUpInformation" })
  public void testGetActiveTasks() throws Exception {
    try {
      GetActiveTasksOptions getActiveTasksOptions = new GetActiveTasksOptions();

      // Invoke operation
      Response<List<ActiveTask>> response = service.getActiveTasks(getActiveTasksOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      List<ActiveTask> listActiveTaskResult = response.getResult();
      assertNotNull(listActiveTaskResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetActiveTasks" })
  public void testGetActivityTrackerEvents() throws Exception {
    try {
      GetActivityTrackerEventsOptions getActivityTrackerEventsOptions = new GetActivityTrackerEventsOptions();

      // Invoke operation
      Response<ActivityTrackerEvents> response = service.getActivityTrackerEvents(getActivityTrackerEventsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ActivityTrackerEvents activityTrackerEventsResult = response.getResult();
      assertNotNull(activityTrackerEventsResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetActivityTrackerEvents" })
  public void testPostActivityTrackerEvents() throws Exception {
    try {
      PostActivityTrackerEventsOptions postActivityTrackerEventsOptions = new PostActivityTrackerEventsOptions.Builder()
        .types(java.util.Arrays.asList("management", "data"))
        .build();

      // Invoke operation
      Response<Ok> response = service.postActivityTrackerEvents(postActivityTrackerEventsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Ok okResult = response.getResult();
      assertNotNull(okResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostActivityTrackerEvents" })
  public void testGetCurrentThroughputInformation() throws Exception {
    try {
      GetCurrentThroughputInformationOptions getCurrentThroughputInformationOptions = new GetCurrentThroughputInformationOptions();

      // Invoke operation
      Response<CurrentThroughputInformation> response = service.getCurrentThroughputInformation(getCurrentThroughputInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CurrentThroughputInformation currentThroughputInformationResult = response.getResult();
      assertNotNull(currentThroughputInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetCurrentThroughputInformation" })
  public void testGetMembershipInformation() throws Exception {
    try {
      GetMembershipInformationOptions getMembershipInformationOptions = new GetMembershipInformationOptions();

      // Invoke operation
      Response<MembershipInformation> response = service.getMembershipInformation(getMembershipInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      MembershipInformation membershipInformationResult = response.getResult();
      assertNotNull(membershipInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetMembershipInformation" })
  public void testGetUpInformation() throws Exception {
    try {
      GetUpInformationOptions getUpInformationOptions = new GetUpInformationOptions();

      // Invoke operation
      Response<UpInformation> response = service.getUpInformation(getUpInformationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      UpInformation upInformationResult = response.getResult();
      assertNotNull(upInformationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetUpInformation" })
  public void testDeleteDatabase() throws Exception {
    try {
      DeleteDatabaseOptions deleteDatabaseOptions = new DeleteDatabaseOptions.Builder()
        .db("testString")
        .build();

      // Invoke operation
      Response<Ok> response = service.deleteDatabase(deleteDatabaseOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Ok okResult = response.getResult();
      assertNotNull(okResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteDatabase" })
  public void testDeleteDocument() throws Exception {
    try {
      DeleteDocumentOptions deleteDocumentOptions = new DeleteDocumentOptions.Builder()
        .db("testString")
        .docId("testString")
        .ifMatch("testString")
        .batch("ok")
        .rev("testString")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.deleteDocument(deleteDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteDocument" })
  public void testDeleteDesignDocument() throws Exception {
    try {
      DeleteDesignDocumentOptions deleteDesignDocumentOptions = new DeleteDesignDocumentOptions.Builder()
        .db("testString")
        .ddoc("testString")
        .ifMatch("testString")
        .batch("ok")
        .rev("testString")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.deleteDesignDocument(deleteDesignDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteDesignDocument" })
  public void testDeleteIndex() throws Exception {
    try {
      DeleteIndexOptions deleteIndexOptions = new DeleteIndexOptions.Builder()
        .db("testString")
        .ddoc("testString")
        .type("json")
        .index("testString")
        .build();

      // Invoke operation
      Response<Ok> response = service.deleteIndex(deleteIndexOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Ok okResult = response.getResult();
      assertNotNull(okResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteIndex" })
  public void testDeleteReplicationDocument() throws Exception {
    try {
      DeleteReplicationDocumentOptions deleteReplicationDocumentOptions = new DeleteReplicationDocumentOptions.Builder()
        .docId("testString")
        .ifMatch("testString")
        .batch("ok")
        .rev("testString")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.deleteReplicationDocument(deleteReplicationDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteReplicationDocument" })
  public void testDeleteAttachment() throws Exception {
    try {
      DeleteAttachmentOptions deleteAttachmentOptions = new DeleteAttachmentOptions.Builder()
        .db("testString")
        .docId("testString")
        .attachmentName("testString")
        .ifMatch("testString")
        .rev("testString")
        .batch("ok")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.deleteAttachment(deleteAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteAttachment" })
  public void testDeleteLocalDocument() throws Exception {
    try {
      DeleteLocalDocumentOptions deleteLocalDocumentOptions = new DeleteLocalDocumentOptions.Builder()
        .db("testString")
        .docId("testString")
        .batch("ok")
        .build();

      // Invoke operation
      Response<DocumentResult> response = service.deleteLocalDocument(deleteLocalDocumentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DocumentResult documentResultResult = response.getResult();
      assertNotNull(documentResultResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
