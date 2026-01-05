/*
 * (C) Copyright IBM Corp. 2026.
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
import com.ibm.cloud.cloudant.v1.model.BulkDocs;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentRevisionStatus;
import com.ibm.cloud.cloudant.v1.model.Revisions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the BulkDocs model.
 */
public class BulkDocsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testBulkDocs() throws Throwable {
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

    BulkDocs bulkDocsModel = new BulkDocs.Builder()
      .docs(java.util.Arrays.asList(documentModel))
      .newEdits(true)
      .build();
    assertEquals(bulkDocsModel.docs(), java.util.Arrays.asList(documentModel));
    assertEquals(bulkDocsModel.newEdits(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(bulkDocsModel);

    BulkDocs bulkDocsModelNew = TestUtilities.deserialize(json, BulkDocs.class);
    assertTrue(bulkDocsModelNew instanceof BulkDocs);
    assertEquals(bulkDocsModelNew.newEdits(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testBulkDocsError() throws Throwable {
    new BulkDocs.Builder().build();
  }

}