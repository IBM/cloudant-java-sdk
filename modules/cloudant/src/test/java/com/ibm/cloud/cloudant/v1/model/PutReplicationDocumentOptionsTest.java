/*
 * (C) Copyright IBM Corp. 2022.
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

package com.ibm.cloud.cloudant.v1.model;

import com.ibm.cloud.cloudant.v1.model.Attachment;
import com.ibm.cloud.cloudant.v1.model.DocumentRevisionStatus;
import com.ibm.cloud.cloudant.v1.model.PutReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.ReplicationCreateTargetParameters;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabase;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuth;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthBasic;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthIam;
import com.ibm.cloud.cloudant.v1.model.ReplicationDocument;
import com.ibm.cloud.cloudant.v1.model.Revisions;
import com.ibm.cloud.cloudant.v1.model.UserContext;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PutReplicationDocumentOptions model.
 */
public class PutReplicationDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPutReplicationDocumentOptions() throws Throwable {
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
    assertEquals(attachmentModel.contentType(), "testString");
    assertEquals(attachmentModel.data(), TestUtilities.createMockByteArray("This is a mock byte array value."));
    assertEquals(attachmentModel.digest(), "testString");
    assertEquals(attachmentModel.encodedLength(), Long.valueOf("0"));
    assertEquals(attachmentModel.encoding(), "testString");
    assertEquals(attachmentModel.follows(), Boolean.valueOf(true));
    assertEquals(attachmentModel.length(), Long.valueOf("0"));
    assertEquals(attachmentModel.revpos(), Long.valueOf("1"));
    assertEquals(attachmentModel.stub(), Boolean.valueOf(true));

    Revisions revisionsModel = new Revisions.Builder()
      .ids(java.util.Arrays.asList("testString"))
      .start(Long.valueOf("1"))
      .build();
    assertEquals(revisionsModel.ids(), java.util.Arrays.asList("testString"));
    assertEquals(revisionsModel.start(), Long.valueOf("1"));

    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
      .rev("testString")
      .status("available")
      .build();
    assertEquals(documentRevisionStatusModel.rev(), "testString");
    assertEquals(documentRevisionStatusModel.status(), "available");

    ReplicationCreateTargetParameters replicationCreateTargetParametersModel = new ReplicationCreateTargetParameters.Builder()
      .n(Long.valueOf("1"))
      .partitioned(false)
      .q(Long.valueOf("26"))
      .build();
    assertEquals(replicationCreateTargetParametersModel.n(), Long.valueOf("1"));
    assertEquals(replicationCreateTargetParametersModel.partitioned(), Boolean.valueOf(false));
    assertEquals(replicationCreateTargetParametersModel.q(), Long.valueOf("26"));

    ReplicationDatabaseAuthBasic replicationDatabaseAuthBasicModel = new ReplicationDatabaseAuthBasic.Builder()
      .password("testString")
      .username("testString")
      .build();
    assertEquals(replicationDatabaseAuthBasicModel.password(), "testString");
    assertEquals(replicationDatabaseAuthBasicModel.username(), "testString");

    ReplicationDatabaseAuthIam replicationDatabaseAuthIamModel = new ReplicationDatabaseAuthIam.Builder()
      .apiKey("testString")
      .build();
    assertEquals(replicationDatabaseAuthIamModel.apiKey(), "testString");

    ReplicationDatabaseAuth replicationDatabaseAuthModel = new ReplicationDatabaseAuth.Builder()
      .basic(replicationDatabaseAuthBasicModel)
      .iam(replicationDatabaseAuthIamModel)
      .build();
    assertEquals(replicationDatabaseAuthModel.basic(), replicationDatabaseAuthBasicModel);
    assertEquals(replicationDatabaseAuthModel.iam(), replicationDatabaseAuthIamModel);

    ReplicationDatabase replicationDatabaseModel = new ReplicationDatabase.Builder()
      .auth(replicationDatabaseAuthModel)
      .headers(java.util.Collections.singletonMap("foo", "testString"))
      .url("testString")
      .build();
    assertEquals(replicationDatabaseModel.auth(), replicationDatabaseAuthModel);
    assertEquals(replicationDatabaseModel.headers(), java.util.Collections.singletonMap("foo", "testString"));
    assertEquals(replicationDatabaseModel.url(), "testString");

    UserContext userContextModel = new UserContext.Builder()
      .db("testString")
      .name("testString")
      .roles(java.util.Arrays.asList("_reader"))
      .build();
    assertEquals(userContextModel.db(), "testString");
    assertEquals(userContextModel.name(), "testString");
    assertEquals(userContextModel.roles(), java.util.Arrays.asList("_reader"));

    ReplicationDocument replicationDocumentModel = new ReplicationDocument.Builder()
      .attachments(java.util.Collections.singletonMap("foo", attachmentModel))
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("testString")
      .localSeq("testString")
      .rev("testString")
      .revisions(revisionsModel)
      .revsInfo(java.util.Arrays.asList(documentRevisionStatusModel))
      .cancel(true)
      .checkpointInterval(Long.valueOf("0"))
      .connectionTimeout(Long.valueOf("0"))
      .continuous(false)
      .createTarget(false)
      .createTargetParams(replicationCreateTargetParametersModel)
      .docIds(java.util.Arrays.asList("testString"))
      .filter("testString")
      .httpConnections(Long.valueOf("1"))
      .queryParams(java.util.Collections.singletonMap("foo", "testString"))
      .retriesPerRequest(Long.valueOf("0"))
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .sinceSeq("testString")
      .socketOptions("testString")
      .source(replicationDatabaseModel)
      .sourceProxy("testString")
      .target(replicationDatabaseModel)
      .targetProxy("testString")
      .useBulkGet(true)
      .useCheckpoints(true)
      .userCtx(userContextModel)
      .winningRevsOnly(false)
      .workerBatchSize(Long.valueOf("1"))
      .workerProcesses(Long.valueOf("1"))
      .add("foo", "testString")
      .build();
    assertEquals(replicationDocumentModel.getAttachments(), java.util.Collections.singletonMap("foo", attachmentModel));
    assertEquals(replicationDocumentModel.getConflicts(), java.util.Arrays.asList("testString"));
    assertEquals(replicationDocumentModel.isDeleted(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModel.getDeletedConflicts(), java.util.Arrays.asList("testString"));
    assertEquals(replicationDocumentModel.getId(), "testString");
    assertEquals(replicationDocumentModel.getLocalSeq(), "testString");
    assertEquals(replicationDocumentModel.getRev(), "testString");
    assertEquals(replicationDocumentModel.getRevisions(), revisionsModel);
    assertEquals(replicationDocumentModel.getRevsInfo(), java.util.Arrays.asList(documentRevisionStatusModel));
    assertEquals(replicationDocumentModel.isCancel(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModel.getCheckpointInterval(), Long.valueOf("0"));
    assertEquals(replicationDocumentModel.getConnectionTimeout(), Long.valueOf("0"));
    assertEquals(replicationDocumentModel.isContinuous(), Boolean.valueOf(false));
    assertEquals(replicationDocumentModel.isCreateTarget(), Boolean.valueOf(false));
    assertEquals(replicationDocumentModel.getCreateTargetParams(), replicationCreateTargetParametersModel);
    assertEquals(replicationDocumentModel.getDocIds(), java.util.Arrays.asList("testString"));
    assertEquals(replicationDocumentModel.getFilter(), "testString");
    assertEquals(replicationDocumentModel.getHttpConnections(), Long.valueOf("1"));
    assertEquals(replicationDocumentModel.getQueryParams(), java.util.Collections.singletonMap("foo", "testString"));
    assertEquals(replicationDocumentModel.getRetriesPerRequest(), Long.valueOf("0"));
    assertEquals(replicationDocumentModel.getSelector(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(replicationDocumentModel.getSinceSeq(), "testString");
    assertEquals(replicationDocumentModel.getSocketOptions(), "testString");
    assertEquals(replicationDocumentModel.getSource(), replicationDatabaseModel);
    assertEquals(replicationDocumentModel.getSourceProxy(), "testString");
    assertEquals(replicationDocumentModel.getTarget(), replicationDatabaseModel);
    assertEquals(replicationDocumentModel.getTargetProxy(), "testString");
    assertEquals(replicationDocumentModel.isUseBulkGet(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModel.isUseCheckpoints(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModel.getUserCtx(), userContextModel);
    assertEquals(replicationDocumentModel.isWinningRevsOnly(), Boolean.valueOf(false));
    assertEquals(replicationDocumentModel.getWorkerBatchSize(), Long.valueOf("1"));
    assertEquals(replicationDocumentModel.getWorkerProcesses(), Long.valueOf("1"));
    assertEquals(replicationDocumentModel.get("foo"), "testString");

    PutReplicationDocumentOptions putReplicationDocumentOptionsModel = new PutReplicationDocumentOptions.Builder()
      .docId("testString")
      .replicationDocument(replicationDocumentModel)
      .ifMatch("testString")
      .batch("ok")
      .newEdits(false)
      .rev("testString")
      .build();
    assertEquals(putReplicationDocumentOptionsModel.docId(), "testString");
    assertEquals(putReplicationDocumentOptionsModel.replicationDocument(), replicationDocumentModel);
    assertEquals(putReplicationDocumentOptionsModel.ifMatch(), "testString");
    assertEquals(putReplicationDocumentOptionsModel.batch(), "ok");
    assertEquals(putReplicationDocumentOptionsModel.newEdits(), Boolean.valueOf(false));
    assertEquals(putReplicationDocumentOptionsModel.rev(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutReplicationDocumentOptionsError() throws Throwable {
    new PutReplicationDocumentOptions.Builder().build();
  }

}