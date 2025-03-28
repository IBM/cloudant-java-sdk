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

import com.ibm.cloud.cloudant.v1.model.Analyzer;
import com.ibm.cloud.cloudant.v1.model.AnalyzerConfiguration;
import com.ibm.cloud.cloudant.v1.model.Attachment;
import com.ibm.cloud.cloudant.v1.model.DesignDocument;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentViewsMapReduce;
import com.ibm.cloud.cloudant.v1.model.DocumentRevisionStatus;
import com.ibm.cloud.cloudant.v1.model.PutDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.Revisions;
import com.ibm.cloud.cloudant.v1.model.SearchIndexDefinition;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PutDesignDocumentOptions model.
 */
public class PutDesignDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPutDesignDocumentOptions() throws Throwable {
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

    Analyzer analyzerModel = new Analyzer.Builder()
      .name("classic")
      .stopwords(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(analyzerModel.name(), "classic");
    assertEquals(analyzerModel.stopwords(), java.util.Arrays.asList("testString"));

    AnalyzerConfiguration analyzerConfigurationModel = new AnalyzerConfiguration.Builder()
      .name("classic")
      .stopwords(java.util.Arrays.asList("testString"))
      .fields(java.util.Collections.singletonMap("key1", analyzerModel))
      .build();
    assertEquals(analyzerConfigurationModel.name(), "classic");
    assertEquals(analyzerConfigurationModel.stopwords(), java.util.Arrays.asList("testString"));
    assertEquals(analyzerConfigurationModel.fields(), java.util.Collections.singletonMap("key1", analyzerModel));

    SearchIndexDefinition searchIndexDefinitionModel = new SearchIndexDefinition.Builder()
      .analyzer(analyzerConfigurationModel)
      .index("testString")
      .build();
    assertEquals(searchIndexDefinitionModel.analyzer(), analyzerConfigurationModel);
    assertEquals(searchIndexDefinitionModel.index(), "testString");

    DesignDocumentOptions designDocumentOptionsModel = new DesignDocumentOptions.Builder()
      .partitioned(true)
      .build();
    assertEquals(designDocumentOptionsModel.partitioned(), Boolean.valueOf(true));

    DesignDocumentViewsMapReduce designDocumentViewsMapReduceModel = new DesignDocumentViewsMapReduce.Builder()
      .map("testString")
      .reduce("testString")
      .build();
    assertEquals(designDocumentViewsMapReduceModel.map(), "testString");
    assertEquals(designDocumentViewsMapReduceModel.reduce(), "testString");

    DesignDocument designDocumentModel = new DesignDocument.Builder()
      .attachments(java.util.Collections.singletonMap("key1", attachmentModel))
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("testString")
      .localSeq("testString")
      .rev("testString")
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
    assertEquals(designDocumentModel.getAttachments(), java.util.Collections.singletonMap("key1", attachmentModel));
    assertEquals(designDocumentModel.getConflicts(), java.util.Arrays.asList("testString"));
    assertEquals(designDocumentModel.isDeleted(), Boolean.valueOf(true));
    assertEquals(designDocumentModel.getDeletedConflicts(), java.util.Arrays.asList("testString"));
    assertEquals(designDocumentModel.getId(), "testString");
    assertEquals(designDocumentModel.getLocalSeq(), "testString");
    assertEquals(designDocumentModel.getRev(), "testString");
    assertEquals(designDocumentModel.getRevisions(), revisionsModel);
    assertEquals(designDocumentModel.getRevsInfo(), java.util.Arrays.asList(documentRevisionStatusModel));
    assertEquals(designDocumentModel.isAutoupdate(), Boolean.valueOf(true));
    assertEquals(designDocumentModel.getFilters(), java.util.Collections.singletonMap("key1", "testString"));
    assertEquals(designDocumentModel.getIndexes(), java.util.Collections.singletonMap("key1", searchIndexDefinitionModel));
    assertEquals(designDocumentModel.getLanguage(), "javascript");
    assertEquals(designDocumentModel.getOptions(), designDocumentOptionsModel);
    assertEquals(designDocumentModel.getValidateDocUpdate(), "testString");
    assertEquals(designDocumentModel.getViews(), java.util.Collections.singletonMap("key1", designDocumentViewsMapReduceModel));
    assertEquals(designDocumentModel.get("foo"), "testString");

    PutDesignDocumentOptions putDesignDocumentOptionsModel = new PutDesignDocumentOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .designDocument(designDocumentModel)
      .ifMatch("testString")
      .batch("ok")
      .newEdits(false)
      .rev("testString")
      .build();
    assertEquals(putDesignDocumentOptionsModel.db(), "testString");
    assertEquals(putDesignDocumentOptionsModel.ddoc(), "testString");
    assertEquals(putDesignDocumentOptionsModel.designDocument(), designDocumentModel);
    assertEquals(putDesignDocumentOptionsModel.ifMatch(), "testString");
    assertEquals(putDesignDocumentOptionsModel.batch(), "ok");
    assertEquals(putDesignDocumentOptionsModel.newEdits(), Boolean.valueOf(false));
    assertEquals(putDesignDocumentOptionsModel.rev(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutDesignDocumentOptionsError() throws Throwable {
    new PutDesignDocumentOptions.Builder().build();
  }

}