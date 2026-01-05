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

import com.ibm.cloud.cloudant.v1.model.Analyzer;
import com.ibm.cloud.cloudant.v1.model.AnalyzerConfiguration;
import com.ibm.cloud.cloudant.v1.model.SearchIndexDefinition;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SearchIndexDefinition model.
 */
public class SearchIndexDefinitionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSearchIndexDefinition() throws Throwable {
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

    String json = TestUtilities.serialize(searchIndexDefinitionModel);

    SearchIndexDefinition searchIndexDefinitionModelNew = TestUtilities.deserialize(json, SearchIndexDefinition.class);
    assertTrue(searchIndexDefinitionModelNew instanceof SearchIndexDefinition);
    assertEquals(searchIndexDefinitionModelNew.analyzer().toString(), analyzerConfigurationModel.toString());
    assertEquals(searchIndexDefinitionModelNew.index(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchIndexDefinitionError() throws Throwable {
    new SearchIndexDefinition.Builder().build();
  }

}