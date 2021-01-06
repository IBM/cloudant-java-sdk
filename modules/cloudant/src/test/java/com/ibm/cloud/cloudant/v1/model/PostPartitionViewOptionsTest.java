/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
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
 * Unit test class for the PostPartitionViewOptions model.
 */
public class PostPartitionViewOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostPartitionViewOptions() throws Throwable {
    PostPartitionViewOptions postPartitionViewOptionsModel = new PostPartitionViewOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .ddoc("testString")
      .view("testString")
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
    assertEquals(postPartitionViewOptionsModel.db(), "testString");
    assertEquals(postPartitionViewOptionsModel.partitionKey(), "testString");
    assertEquals(postPartitionViewOptionsModel.ddoc(), "testString");
    assertEquals(postPartitionViewOptionsModel.view(), "testString");
    assertEquals(postPartitionViewOptionsModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.attachments(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.descending(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postPartitionViewOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postPartitionViewOptionsModel.updateSeq(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.endkey(), "testString");
    assertEquals(postPartitionViewOptionsModel.endkeyDocid(), "testString");
    assertEquals(postPartitionViewOptionsModel.group(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.groupLevel(), Long.valueOf("1"));
    assertEquals(postPartitionViewOptionsModel.key(), "testString");
    assertEquals(postPartitionViewOptionsModel.keys(), new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")));
    assertEquals(postPartitionViewOptionsModel.reduce(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.stable(), Boolean.valueOf(true));
    assertEquals(postPartitionViewOptionsModel.startkey(), "testString");
    assertEquals(postPartitionViewOptionsModel.startkeyDocid(), "testString");
    assertEquals(postPartitionViewOptionsModel.update(), "true");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionViewOptionsError() throws Throwable {
    new PostPartitionViewOptions.Builder().build();
  }

}