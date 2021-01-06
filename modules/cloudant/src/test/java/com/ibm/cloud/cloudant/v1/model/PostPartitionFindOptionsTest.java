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

import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PostPartitionFindOptions model.
 */
public class PostPartitionFindOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostPartitionFindOptions() throws Throwable {
    PostPartitionFindOptions postPartitionFindOptionsModel = new PostPartitionFindOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .bookmark("testString")
      .conflicts(true)
      .executionStats(true)
      .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .limit(Long.valueOf("0"))
      .skip(Long.valueOf("0"))
      .sort(new java.util.ArrayList<java.util.Map<String, String>>(java.util.Arrays.asList(new java.util.HashMap<String, String>() { { put("foo", "asc"); } })))
      .stable(true)
      .update("false")
      .useIndex(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
    assertEquals(postPartitionFindOptionsModel.db(), "testString");
    assertEquals(postPartitionFindOptionsModel.partitionKey(), "testString");
    assertEquals(postPartitionFindOptionsModel.selector(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(postPartitionFindOptionsModel.bookmark(), "testString");
    assertEquals(postPartitionFindOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(postPartitionFindOptionsModel.executionStats(), Boolean.valueOf(true));
    assertEquals(postPartitionFindOptionsModel.fields(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postPartitionFindOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postPartitionFindOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postPartitionFindOptionsModel.sort(), new java.util.ArrayList<java.util.Map<String, String>>(java.util.Arrays.asList(new java.util.HashMap<String, String>() { { put("foo", "asc"); } })));
    assertEquals(postPartitionFindOptionsModel.stable(), Boolean.valueOf(true));
    assertEquals(postPartitionFindOptionsModel.update(), "false");
    assertEquals(postPartitionFindOptionsModel.useIndex(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionFindOptionsError() throws Throwable {
    new PostPartitionFindOptions.Builder().build();
  }

}