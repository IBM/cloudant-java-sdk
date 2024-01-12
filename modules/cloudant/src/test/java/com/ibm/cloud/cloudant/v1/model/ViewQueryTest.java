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

import com.ibm.cloud.cloudant.v1.model.ViewQuery;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ViewQuery model.
 */
public class ViewQueryTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testViewQuery() throws Throwable {
    ViewQuery viewQueryModel = new ViewQuery.Builder()
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
    assertEquals(viewQueryModel.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(viewQueryModel.attachments(), Boolean.valueOf(false));
    assertEquals(viewQueryModel.conflicts(), Boolean.valueOf(false));
    assertEquals(viewQueryModel.descending(), Boolean.valueOf(false));
    assertEquals(viewQueryModel.includeDocs(), Boolean.valueOf(false));
    assertEquals(viewQueryModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.limit(), Long.valueOf("0"));
    assertEquals(viewQueryModel.skip(), Long.valueOf("0"));
    assertEquals(viewQueryModel.updateSeq(), Boolean.valueOf(false));
    assertEquals(viewQueryModel.endKey(), "testString");
    assertEquals(viewQueryModel.endKeyDocId(), "testString");
    assertEquals(viewQueryModel.group(), Boolean.valueOf(false));
    assertEquals(viewQueryModel.groupLevel(), Long.valueOf("1"));
    assertEquals(viewQueryModel.key(), "testString");
    assertEquals(viewQueryModel.keys(), java.util.Arrays.asList("testString"));
    assertEquals(viewQueryModel.reduce(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.stable(), Boolean.valueOf(false));
    assertEquals(viewQueryModel.startKey(), "testString");
    assertEquals(viewQueryModel.startKeyDocId(), "testString");
    assertEquals(viewQueryModel.update(), "true");

    String json = TestUtilities.serialize(viewQueryModel);

    ViewQuery viewQueryModelNew = TestUtilities.deserialize(json, ViewQuery.class);
    assertTrue(viewQueryModelNew instanceof ViewQuery);
    assertEquals(viewQueryModelNew.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(viewQueryModelNew.attachments(), Boolean.valueOf(false));
    assertEquals(viewQueryModelNew.conflicts(), Boolean.valueOf(false));
    assertEquals(viewQueryModelNew.descending(), Boolean.valueOf(false));
    assertEquals(viewQueryModelNew.includeDocs(), Boolean.valueOf(false));
    assertEquals(viewQueryModelNew.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.limit(), Long.valueOf("0"));
    assertEquals(viewQueryModelNew.skip(), Long.valueOf("0"));
    assertEquals(viewQueryModelNew.updateSeq(), Boolean.valueOf(false));
    assertEquals(viewQueryModelNew.endKey(), "testString");
    assertEquals(viewQueryModelNew.endKeyDocId(), "testString");
    assertEquals(viewQueryModelNew.group(), Boolean.valueOf(false));
    assertEquals(viewQueryModelNew.groupLevel(), Long.valueOf("1"));
    assertEquals(viewQueryModelNew.key(), "testString");
    assertEquals(viewQueryModelNew.reduce(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.stable(), Boolean.valueOf(false));
    assertEquals(viewQueryModelNew.startKey(), "testString");
    assertEquals(viewQueryModelNew.startKeyDocId(), "testString");
    assertEquals(viewQueryModelNew.update(), "true");
  }
}