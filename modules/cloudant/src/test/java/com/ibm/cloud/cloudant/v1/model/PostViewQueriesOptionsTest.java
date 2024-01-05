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

import com.ibm.cloud.cloudant.v1.model.PostViewQueriesOptions;
import com.ibm.cloud.cloudant.v1.model.ViewQuery;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PostViewQueriesOptions model.
 */
public class PostViewQueriesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostViewQueriesOptions() throws Throwable {
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

    PostViewQueriesOptions postViewQueriesOptionsModel = new PostViewQueriesOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .view("testString")
      .queries(java.util.Arrays.asList(viewQueryModel))
      .build();
    assertEquals(postViewQueriesOptionsModel.db(), "testString");
    assertEquals(postViewQueriesOptionsModel.ddoc(), "testString");
    assertEquals(postViewQueriesOptionsModel.view(), "testString");
    assertEquals(postViewQueriesOptionsModel.queries(), java.util.Arrays.asList(viewQueryModel));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewQueriesOptionsError() throws Throwable {
    new PostViewQueriesOptions.Builder().build();
  }

}