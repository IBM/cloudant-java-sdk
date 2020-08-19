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

import com.ibm.cloud.cloudant.v1.model.ViewQuery;
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
 * Unit test class for the ViewQuery model.
 */
public class ViewQueryTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testViewQuery() throws Throwable {
    ViewQuery viewQueryModel = new ViewQuery.Builder()
      .attEncodingInfo(true)
      .attachments(true)
      .conflicts(true)
      .descending(true)
      .includeDocs(true)
      .inclusiveEnd(true)
      .limit(Long.valueOf("0"))
      .skip(Long.valueOf("0"))
      .updateSeq(true)
      .endkey("testString")
      .endkeyDocid("testString")
      .group(true)
      .groupLevel(Long.valueOf("1"))
      .key("testString")
      .keys(new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")))
      .reduce(true)
      .stable(true)
      .startkey("testString")
      .startkeyDocid("testString")
      .update("true")
      .build();
    assertEquals(viewQueryModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.attachments(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.conflicts(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.descending(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.limit(), Long.valueOf("0"));
    assertEquals(viewQueryModel.skip(), Long.valueOf("0"));
    assertEquals(viewQueryModel.updateSeq(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.endkey(), "testString");
    assertEquals(viewQueryModel.endkeyDocid(), "testString");
    assertEquals(viewQueryModel.group(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.groupLevel(), Long.valueOf("1"));
    assertEquals(viewQueryModel.key(), "testString");
    assertEquals(viewQueryModel.keys(), new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")));
    assertEquals(viewQueryModel.reduce(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.stable(), Boolean.valueOf(true));
    assertEquals(viewQueryModel.startkey(), "testString");
    assertEquals(viewQueryModel.startkeyDocid(), "testString");
    assertEquals(viewQueryModel.update(), "true");

    String json = TestUtilities.serialize(viewQueryModel);

    ViewQuery viewQueryModelNew = TestUtilities.deserialize(json, ViewQuery.class);
    assertTrue(viewQueryModelNew instanceof ViewQuery);
    assertEquals(viewQueryModelNew.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.attachments(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.conflicts(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.descending(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.includeDocs(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.limit(), Long.valueOf("0"));
    assertEquals(viewQueryModelNew.skip(), Long.valueOf("0"));
    assertEquals(viewQueryModelNew.updateSeq(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.endkey(), "testString");
    assertEquals(viewQueryModelNew.endkeyDocid(), "testString");
    assertEquals(viewQueryModelNew.group(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.groupLevel(), Long.valueOf("1"));
    assertEquals(viewQueryModelNew.key(), "testString");
    assertEquals(viewQueryModelNew.reduce(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.stable(), Boolean.valueOf(true));
    assertEquals(viewQueryModelNew.startkey(), "testString");
    assertEquals(viewQueryModelNew.startkeyDocid(), "testString");
    assertEquals(viewQueryModelNew.update(), "true");
  }
}