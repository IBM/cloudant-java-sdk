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

import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
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
 * Unit test class for the PostViewOptions model.
 */
public class PostViewOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostViewOptions() throws Throwable {
    PostViewOptions postViewOptionsModel = new PostViewOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .view("testString")
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
      .keys(new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")))
      .reduce(true)
      .stable(false)
      .startKey("testString")
      .startKeyDocId("testString")
      .update("true")
      .build();
    assertEquals(postViewOptionsModel.db(), "testString");
    assertEquals(postViewOptionsModel.ddoc(), "testString");
    assertEquals(postViewOptionsModel.view(), "testString");
    assertEquals(postViewOptionsModel.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(postViewOptionsModel.attachments(), Boolean.valueOf(false));
    assertEquals(postViewOptionsModel.conflicts(), Boolean.valueOf(false));
    assertEquals(postViewOptionsModel.descending(), Boolean.valueOf(false));
    assertEquals(postViewOptionsModel.includeDocs(), Boolean.valueOf(false));
    assertEquals(postViewOptionsModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(postViewOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postViewOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postViewOptionsModel.updateSeq(), Boolean.valueOf(false));
    assertEquals(postViewOptionsModel.endKey(), "testString");
    assertEquals(postViewOptionsModel.endKeyDocId(), "testString");
    assertEquals(postViewOptionsModel.group(), Boolean.valueOf(false));
    assertEquals(postViewOptionsModel.groupLevel(), Long.valueOf("1"));
    assertEquals(postViewOptionsModel.key(), "testString");
    assertEquals(postViewOptionsModel.keys(), new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")));
    assertEquals(postViewOptionsModel.reduce(), Boolean.valueOf(true));
    assertEquals(postViewOptionsModel.stable(), Boolean.valueOf(false));
    assertEquals(postViewOptionsModel.startKey(), "testString");
    assertEquals(postViewOptionsModel.startKeyDocId(), "testString");
    assertEquals(postViewOptionsModel.update(), "true");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostViewOptionsError() throws Throwable {
    new PostViewOptions.Builder().build();
  }

}