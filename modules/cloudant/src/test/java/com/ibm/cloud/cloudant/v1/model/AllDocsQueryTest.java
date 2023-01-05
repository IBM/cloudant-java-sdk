/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.cloudant.v1.model.AllDocsQuery;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AllDocsQuery model.
 */
public class AllDocsQueryTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAllDocsQuery() throws Throwable {
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
      .keys(java.util.Arrays.asList("testString"))
      .startKey("testString")
      .build();
    assertEquals(allDocsQueryModel.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModel.attachments(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModel.conflicts(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModel.descending(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModel.includeDocs(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(allDocsQueryModel.limit(), Long.valueOf("0"));
    assertEquals(allDocsQueryModel.skip(), Long.valueOf("0"));
    assertEquals(allDocsQueryModel.updateSeq(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModel.endKey(), "testString");
    assertEquals(allDocsQueryModel.key(), "testString");
    assertEquals(allDocsQueryModel.keys(), java.util.Arrays.asList("testString"));
    assertEquals(allDocsQueryModel.startKey(), "testString");

    String json = TestUtilities.serialize(allDocsQueryModel);

    AllDocsQuery allDocsQueryModelNew = TestUtilities.deserialize(json, AllDocsQuery.class);
    assertTrue(allDocsQueryModelNew instanceof AllDocsQuery);
    assertEquals(allDocsQueryModelNew.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModelNew.attachments(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModelNew.conflicts(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModelNew.descending(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModelNew.includeDocs(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModelNew.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(allDocsQueryModelNew.limit(), Long.valueOf("0"));
    assertEquals(allDocsQueryModelNew.skip(), Long.valueOf("0"));
    assertEquals(allDocsQueryModelNew.updateSeq(), Boolean.valueOf(false));
    assertEquals(allDocsQueryModelNew.endKey(), "testString");
    assertEquals(allDocsQueryModelNew.key(), "testString");
    assertEquals(allDocsQueryModelNew.startKey(), "testString");
  }
}