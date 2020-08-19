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

import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
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
 * Unit test class for the PostPartitionSearchOptions model.
 */
public class PostPartitionSearchOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostPartitionSearchOptions() throws Throwable {
    PostPartitionSearchOptions postPartitionSearchOptionsModel = new PostPartitionSearchOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .ddoc("testString")
      .index("testString")
      .bookmark("testString")
      .highlightFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .highlightNumber(Long.valueOf("1"))
      .highlightPostTag("testString")
      .highlightPreTag("testString")
      .highlightSize(Long.valueOf("1"))
      .includeDocs(true)
      .includeFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .limit(Long.valueOf("0"))
      .query("testString")
      .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .stale("ok")
      .build();
    assertEquals(postPartitionSearchOptionsModel.db(), "testString");
    assertEquals(postPartitionSearchOptionsModel.partitionKey(), "testString");
    assertEquals(postPartitionSearchOptionsModel.ddoc(), "testString");
    assertEquals(postPartitionSearchOptionsModel.index(), "testString");
    assertEquals(postPartitionSearchOptionsModel.bookmark(), "testString");
    assertEquals(postPartitionSearchOptionsModel.highlightFields(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postPartitionSearchOptionsModel.highlightNumber(), Long.valueOf("1"));
    assertEquals(postPartitionSearchOptionsModel.highlightPostTag(), "testString");
    assertEquals(postPartitionSearchOptionsModel.highlightPreTag(), "testString");
    assertEquals(postPartitionSearchOptionsModel.highlightSize(), Long.valueOf("1"));
    assertEquals(postPartitionSearchOptionsModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(postPartitionSearchOptionsModel.includeFields(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postPartitionSearchOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postPartitionSearchOptionsModel.query(), "testString");
    assertEquals(postPartitionSearchOptionsModel.sort(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postPartitionSearchOptionsModel.stale(), "ok");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionSearchOptionsError() throws Throwable {
    new PostPartitionSearchOptions.Builder().build();
  }

}