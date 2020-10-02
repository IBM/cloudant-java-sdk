/*
 * (C) Copyright IBM Corp. 2020.
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
import com.ibm.cloud.cloudant.v1.model.ReplicationCreateTargetParameters;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabase;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuth;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthIam;
import com.ibm.cloud.cloudant.v1.model.ReplicationDocument;
import com.ibm.cloud.cloudant.v1.model.Revisions;
import com.ibm.cloud.cloudant.v1.model.UserContext;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplicationDocument model.
 */
public class ReplicationDocumentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplicationDocument() throws Throwable {
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
      .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .start(Long.valueOf("1"))
      .build();
    assertEquals(revisionsModel.ids(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(revisionsModel.start(), Long.valueOf("1"));

    DocumentRevisionStatus documentRevisionStatusModel = new DocumentRevisionStatus.Builder()
      .rev("testString")
      .status("available")
      .build();
    assertEquals(documentRevisionStatusModel.rev(), "testString");
    assertEquals(documentRevisionStatusModel.status(), "available");

    ReplicationCreateTargetParameters replicationCreateTargetParametersModel = new ReplicationCreateTargetParameters.Builder()
      .n(Long.valueOf("1"))
      .partitioned(true)
      .q(Long.valueOf("1"))
      .build();
    assertEquals(replicationCreateTargetParametersModel.n(), Long.valueOf("1"));
    assertEquals(replicationCreateTargetParametersModel.partitioned(), Boolean.valueOf(true));
    assertEquals(replicationCreateTargetParametersModel.q(), Long.valueOf("1"));

    ReplicationDatabaseAuthIam replicationDatabaseAuthIamModel = new ReplicationDatabaseAuthIam.Builder()
      .apiKey("testString")
      .build();
    assertEquals(replicationDatabaseAuthIamModel.apiKey(), "testString");

    ReplicationDatabaseAuth replicationDatabaseAuthModel = new ReplicationDatabaseAuth.Builder()
      .iam(replicationDatabaseAuthIamModel)
      .build();
    assertEquals(replicationDatabaseAuthModel.iam(), replicationDatabaseAuthIamModel);

    ReplicationDatabase replicationDatabaseModel = new ReplicationDatabase.Builder()
      .auth(replicationDatabaseAuthModel)
      .headers(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
      .url("testString")
      .build();
    assertEquals(replicationDatabaseModel.auth(), replicationDatabaseAuthModel);
    assertEquals(replicationDatabaseModel.headers(), new java.util.HashMap<String, String>() { { put("foo", "testString"); } });
    assertEquals(replicationDatabaseModel.url(), "testString");

    UserContext userContextModel = new UserContext.Builder()
      .db("testString")
      .name("testString")
      .roles(new java.util.ArrayList<String>(java.util.Arrays.asList("_reader")))
      .build();
    assertEquals(userContextModel.db(), "testString");
    assertEquals(userContextModel.name(), "testString");
    assertEquals(userContextModel.roles(), new java.util.ArrayList<String>(java.util.Arrays.asList("_reader")));

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
      .continuous(true)
      .createTarget(true)
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
    assertEquals(replicationDocumentModel.getAttachments(), new java.util.HashMap<String, Attachment>() { { put("foo", attachmentModel); } });
    assertEquals(replicationDocumentModel.getConflicts(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(replicationDocumentModel.isDeleted(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModel.getDeletedConflicts(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(replicationDocumentModel.getId(), "testString");
    assertEquals(replicationDocumentModel.getLocalSeq(), "testString");
    assertEquals(replicationDocumentModel.getRev(), "testString");
    assertEquals(replicationDocumentModel.getRevisions(), revisionsModel);
    assertEquals(replicationDocumentModel.getRevsInfo(), new java.util.ArrayList<DocumentRevisionStatus>(java.util.Arrays.asList(documentRevisionStatusModel)));
    assertEquals(replicationDocumentModel.isCancel(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModel.getCheckpointInterval(), Long.valueOf("0"));
    assertEquals(replicationDocumentModel.getConnectionTimeout(), Long.valueOf("0"));
    assertEquals(replicationDocumentModel.isContinuous(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModel.isCreateTarget(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModel.getCreateTargetParams(), replicationCreateTargetParametersModel);
    assertEquals(replicationDocumentModel.getDocIds(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(replicationDocumentModel.getFilter(), "testString");
    assertEquals(replicationDocumentModel.getHttpConnections(), Long.valueOf("1"));
    assertEquals(replicationDocumentModel.getQueryParams(), new java.util.HashMap<String, String>() { { put("foo", "testString"); } });
    assertEquals(replicationDocumentModel.getRetriesPerRequest(), Long.valueOf("0"));
    assertEquals(replicationDocumentModel.getSelector(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(replicationDocumentModel.getSinceSeq(), "testString");
    assertEquals(replicationDocumentModel.getSocketOptions(), "testString");
    assertEquals(replicationDocumentModel.getSource(), replicationDatabaseModel);
    assertEquals(replicationDocumentModel.getSourceProxy(), "testString");
    assertEquals(replicationDocumentModel.getTarget(), replicationDatabaseModel);
    assertEquals(replicationDocumentModel.getTargetProxy(), "testString");
    assertEquals(replicationDocumentModel.isUseCheckpoints(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModel.getUserCtx(), userContextModel);
    assertEquals(replicationDocumentModel.getWorkerBatchSize(), Long.valueOf("1"));
    assertEquals(replicationDocumentModel.getWorkerProcesses(), Long.valueOf("1"));
    assertEquals(replicationDocumentModel.get("foo"), "testString");

    String json = TestUtilities.serialize(replicationDocumentModel);

    ReplicationDocument replicationDocumentModelNew = TestUtilities.deserialize(json, ReplicationDocument.class);
    assertTrue(replicationDocumentModelNew instanceof ReplicationDocument);
    assertEquals(replicationDocumentModelNew.isDeleted(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModelNew.getId(), "testString");
    assertEquals(replicationDocumentModelNew.getLocalSeq(), "testString");
    assertEquals(replicationDocumentModelNew.getRev(), "testString");
    assertEquals(replicationDocumentModelNew.getRevisions().toString(), revisionsModel.toString());
    assertEquals(replicationDocumentModelNew.isCancel(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModelNew.getCheckpointInterval(), Long.valueOf("0"));
    assertEquals(replicationDocumentModelNew.getConnectionTimeout(), Long.valueOf("0"));
    assertEquals(replicationDocumentModelNew.isContinuous(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModelNew.isCreateTarget(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModelNew.getCreateTargetParams().toString(), replicationCreateTargetParametersModel.toString());
    assertEquals(replicationDocumentModelNew.getFilter(), "testString");
    assertEquals(replicationDocumentModelNew.getHttpConnections(), Long.valueOf("1"));
    assertEquals(replicationDocumentModelNew.getRetriesPerRequest(), Long.valueOf("0"));
    assertEquals(replicationDocumentModelNew.getSinceSeq(), "testString");
    assertEquals(replicationDocumentModelNew.getSocketOptions(), "testString");
    assertEquals(replicationDocumentModelNew.getSource().toString(), replicationDatabaseModel.toString());
    assertEquals(replicationDocumentModelNew.getSourceProxy(), "testString");
    assertEquals(replicationDocumentModelNew.getTarget().toString(), replicationDatabaseModel.toString());
    assertEquals(replicationDocumentModelNew.getTargetProxy(), "testString");
    assertEquals(replicationDocumentModelNew.isUseCheckpoints(), Boolean.valueOf(true));
    assertEquals(replicationDocumentModelNew.getUserCtx().toString(), userContextModel.toString());
    assertEquals(replicationDocumentModelNew.getWorkerBatchSize(), Long.valueOf("1"));
    assertEquals(replicationDocumentModelNew.getWorkerProcesses(), Long.valueOf("1"));
    assertEquals(replicationDocumentModelNew.get("foo"), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplicationDocumentError() throws Throwable {
    new ReplicationDocument.Builder().build();
  }

}