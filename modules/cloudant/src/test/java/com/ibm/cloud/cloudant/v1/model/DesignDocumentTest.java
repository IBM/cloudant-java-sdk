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

import com.ibm.cloud.cloudant.v1.model.Analyzer;
import com.ibm.cloud.cloudant.v1.model.AnalyzerConfiguration;
import com.ibm.cloud.cloudant.v1.model.Attachment;
import com.ibm.cloud.cloudant.v1.model.DesignDocument;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentViewsMapReduce;
import com.ibm.cloud.cloudant.v1.model.DocumentRevisionStatus;
import com.ibm.cloud.cloudant.v1.model.GeoIndexDefinition;
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
 * Unit test class for the DesignDocument model.
 */
public class DesignDocumentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDesignDocument() throws Throwable {
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

    Analyzer analyzerModel = new Analyzer.Builder()
      .name("classic")
      .stopwords(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(analyzerModel.name(), "classic");
    assertEquals(analyzerModel.stopwords(), java.util.Arrays.asList("testString"));

    AnalyzerConfiguration analyzerConfigurationModel = new AnalyzerConfiguration.Builder()
      .name("classic")
      .stopwords(java.util.Arrays.asList("testString"))
      .fields(new java.util.HashMap<String, Analyzer>() { { put("foo", analyzerModel); } })
      .build();
    assertEquals(analyzerConfigurationModel.name(), "classic");
    assertEquals(analyzerConfigurationModel.stopwords(), java.util.Arrays.asList("testString"));
    assertEquals(analyzerConfigurationModel.fields(), new java.util.HashMap<String, Analyzer>() { { put("foo", analyzerModel); } });

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

    GeoIndexDefinition geoIndexDefinitionModel = new GeoIndexDefinition.Builder()
      .index("testString")
      .build();
    assertEquals(geoIndexDefinitionModel.index(), "testString");

    DesignDocument designDocumentModel = new DesignDocument.Builder()
      .attachments(new java.util.HashMap<String, Attachment>() { { put("foo", attachmentModel); } })
      .conflicts(java.util.Arrays.asList("testString"))
      .deleted(true)
      .deletedConflicts(java.util.Arrays.asList("testString"))
      .id("testString")
      .localSeq("testString")
      .rev("testString")
      .revisions(revisionsModel)
      .revsInfo(java.util.Arrays.asList(documentRevisionStatusModel))
      .autoupdate(true)
      .filters(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
      .indexes(new java.util.HashMap<String, SearchIndexDefinition>() { { put("foo", searchIndexDefinitionModel); } })
      .language("javascript")
      .options(designDocumentOptionsModel)
      .validateDocUpdate("testString")
      .views(new java.util.HashMap<String, DesignDocumentViewsMapReduce>() { { put("foo", designDocumentViewsMapReduceModel); } })
      .stIndexes(new java.util.HashMap<String, GeoIndexDefinition>() { { put("foo", geoIndexDefinitionModel); } })
      .add("foo", "testString")
      .build();
    assertEquals(designDocumentModel.getAttachments(), new java.util.HashMap<String, Attachment>() { { put("foo", attachmentModel); } });
    assertEquals(designDocumentModel.getConflicts(), java.util.Arrays.asList("testString"));
    assertEquals(designDocumentModel.isDeleted(), Boolean.valueOf(true));
    assertEquals(designDocumentModel.getDeletedConflicts(), java.util.Arrays.asList("testString"));
    assertEquals(designDocumentModel.getId(), "testString");
    assertEquals(designDocumentModel.getLocalSeq(), "testString");
    assertEquals(designDocumentModel.getRev(), "testString");
    assertEquals(designDocumentModel.getRevisions(), revisionsModel);
    assertEquals(designDocumentModel.getRevsInfo(), java.util.Arrays.asList(documentRevisionStatusModel));
    assertEquals(designDocumentModel.isAutoupdate(), Boolean.valueOf(true));
    assertEquals(designDocumentModel.getFilters(), new java.util.HashMap<String, String>() { { put("foo", "testString"); } });
    assertEquals(designDocumentModel.getIndexes(), new java.util.HashMap<String, SearchIndexDefinition>() { { put("foo", searchIndexDefinitionModel); } });
    assertEquals(designDocumentModel.getLanguage(), "javascript");
    assertEquals(designDocumentModel.getOptions(), designDocumentOptionsModel);
    assertEquals(designDocumentModel.getValidateDocUpdate(), "testString");
    assertEquals(designDocumentModel.getViews(), new java.util.HashMap<String, DesignDocumentViewsMapReduce>() { { put("foo", designDocumentViewsMapReduceModel); } });
    assertEquals(designDocumentModel.getStIndexes(), new java.util.HashMap<String, GeoIndexDefinition>() { { put("foo", geoIndexDefinitionModel); } });
    assertEquals(designDocumentModel.get("foo"), "testString");

    String json = TestUtilities.serialize(designDocumentModel);

    DesignDocument designDocumentModelNew = TestUtilities.deserialize(json, DesignDocument.class);
    assertTrue(designDocumentModelNew instanceof DesignDocument);
    assertEquals(designDocumentModelNew.isDeleted(), Boolean.valueOf(true));
    assertEquals(designDocumentModelNew.getId(), "testString");
    assertEquals(designDocumentModelNew.getLocalSeq(), "testString");
    assertEquals(designDocumentModelNew.getRev(), "testString");
    assertEquals(designDocumentModelNew.getRevisions().toString(), revisionsModel.toString());
    assertEquals(designDocumentModelNew.isAutoupdate(), Boolean.valueOf(true));
    assertEquals(designDocumentModelNew.getLanguage(), "javascript");
    assertEquals(designDocumentModelNew.getOptions().toString(), designDocumentOptionsModel.toString());
    assertEquals(designDocumentModelNew.getValidateDocUpdate(), "testString");
    assertEquals(designDocumentModelNew.get("foo"), "testString");
  }
}