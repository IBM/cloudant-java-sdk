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

package com.ibm.cloud.cloudant.v1.model;

import com.ibm.cloud.cloudant.v1.model.Analyzer;
import com.ibm.cloud.cloudant.v1.model.IndexDefinition;
import com.ibm.cloud.cloudant.v1.model.IndexField;
import com.ibm.cloud.cloudant.v1.model.IndexTextOperatorDefaultField;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the IndexDefinition model.
 */
public class IndexDefinitionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testIndexDefinition() throws Throwable {
    Analyzer analyzerModel = new Analyzer.Builder()
      .name("classic")
      .stopwords(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(analyzerModel.name(), "classic");
    assertEquals(analyzerModel.stopwords(), java.util.Arrays.asList("testString"));

    IndexTextOperatorDefaultField indexTextOperatorDefaultFieldModel = new IndexTextOperatorDefaultField.Builder()
      .analyzer(analyzerModel)
      .enabled(true)
      .build();
    assertEquals(indexTextOperatorDefaultFieldModel.analyzer(), analyzerModel);
    assertEquals(indexTextOperatorDefaultFieldModel.enabled(), Boolean.valueOf(true));

    IndexField indexFieldModel = new IndexField.Builder()
      .name("testString")
      .type("boolean")
      .add("foo", "asc")
      .build();
    assertEquals(indexFieldModel.getName(), "testString");
    assertEquals(indexFieldModel.getType(), "boolean");
    assertEquals(indexFieldModel.get("foo"), "asc");

    IndexDefinition indexDefinitionModel = new IndexDefinition.Builder()
      .defaultAnalyzer(analyzerModel)
      .defaultField(indexTextOperatorDefaultFieldModel)
      .fields(java.util.Arrays.asList(indexFieldModel))
      .indexArrayLengths(true)
      .partialFilterSelector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();
    assertEquals(indexDefinitionModel.defaultAnalyzer(), analyzerModel);
    assertEquals(indexDefinitionModel.defaultField(), indexTextOperatorDefaultFieldModel);
    assertEquals(indexDefinitionModel.fields(), java.util.Arrays.asList(indexFieldModel));
    assertEquals(indexDefinitionModel.indexArrayLengths(), Boolean.valueOf(true));
    assertEquals(indexDefinitionModel.partialFilterSelector(), java.util.Collections.singletonMap("anyKey", "anyValue"));

    String json = TestUtilities.serialize(indexDefinitionModel);

    IndexDefinition indexDefinitionModelNew = TestUtilities.deserialize(json, IndexDefinition.class);
    assertTrue(indexDefinitionModelNew instanceof IndexDefinition);
    assertEquals(indexDefinitionModelNew.defaultAnalyzer().toString(), analyzerModel.toString());
    assertEquals(indexDefinitionModelNew.defaultField().toString(), indexTextOperatorDefaultFieldModel.toString());
    assertEquals(indexDefinitionModelNew.indexArrayLengths(), Boolean.valueOf(true));
    assertEquals(indexDefinitionModelNew.partialFilterSelector().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
  }
}