/*
 * (C) Copyright IBM Corp. 2025.
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
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentRevisionStatus;
import com.ibm.cloud.cloudant.v1.model.PutDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.Revisions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PutDocumentOptions model.
 */
public class PutDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPutDocumentOptions() throws Throwable {
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
    assertEquals(attachmentModel.contentType(), "testString");
    assertEquals(attachmentModel.data(), TestUtilities.createMockByteArray("VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4="));
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

    Document documentModel = new Document.Builder()
      .attachments(java.util.Collections.singletonMap("key1", attachmentModel))
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("testString")
      .localSeq("testString")
      .rev("testString")
      .revisions(revisionsModel)
      .revsInfo(java.util.Arrays.asList(documentRevisionStatusModel))
      .add("foo", "testString")
      .build();
    assertEquals(documentModel.getAttachments(), java.util.Collections.singletonMap("key1", attachmentModel));
    assertEquals(documentModel.getConflicts(), java.util.Arrays.asList("testString"));
    assertEquals(documentModel.isDeleted(), Boolean.valueOf(true));
    assertEquals(documentModel.getDeletedConflicts(), java.util.Arrays.asList("testString"));
    assertEquals(documentModel.getId(), "testString");
    assertEquals(documentModel.getLocalSeq(), "testString");
    assertEquals(documentModel.getRev(), "testString");
    assertEquals(documentModel.getRevisions(), revisionsModel);
    assertEquals(documentModel.getRevsInfo(), java.util.Arrays.asList(documentRevisionStatusModel));
    assertEquals(documentModel.get("foo"), "testString");

    PutDocumentOptions putDocumentOptionsModel = new PutDocumentOptions.Builder()
      .db("testString")
      .docId("testString")
      .document(documentModel)
      .body(TestUtilities.createMockStream("This is a mock file."))
      .contentType("application/json")
      .ifMatch("testString")
      .batch("ok")
      .newEdits(false)
      .rev("testString")
      .build();
    assertEquals(putDocumentOptionsModel.db(), "testString");
    assertEquals(putDocumentOptionsModel.docId(), "testString");
    assertEquals(putDocumentOptionsModel.document(), documentModel);
    assertEquals(IOUtils.toString(putDocumentOptionsModel.body()), IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(putDocumentOptionsModel.contentType(), "application/json");
    assertEquals(putDocumentOptionsModel.ifMatch(), "testString");
    assertEquals(putDocumentOptionsModel.batch(), "ok");
    assertEquals(putDocumentOptionsModel.newEdits(), Boolean.valueOf(false));
    assertEquals(putDocumentOptionsModel.rev(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutDocumentOptionsError() throws Throwable {
    new PutDocumentOptions.Builder().build();
  }

}