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

import com.ibm.cloud.cloudant.v1.model.PostExplainOptions;
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
 * Unit test class for the PostExplainOptions model.
 */
public class PostExplainOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostExplainOptions() throws Throwable {
    PostExplainOptions postExplainOptionsModel = new PostExplainOptions.Builder()
      .db("testString")
      .bookmark("testString")
      .conflicts(true)
      .executionStats(true)
      .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .limit(Long.valueOf("0"))
      .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .skip(Long.valueOf("0"))
      .sort(new java.util.ArrayList<java.util.Map<String, String>>(java.util.Arrays.asList(new java.util.HashMap<String, String>() { { put("foo", "asc"); } })))
      .stable(true)
      .update("false")
      .useIndex(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .r(Long.valueOf("1"))
      .build();
    assertEquals(postExplainOptionsModel.db(), "testString");
    assertEquals(postExplainOptionsModel.bookmark(), "testString");
    assertEquals(postExplainOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(postExplainOptionsModel.executionStats(), Boolean.valueOf(true));
    assertEquals(postExplainOptionsModel.fields(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postExplainOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postExplainOptionsModel.selector(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(postExplainOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postExplainOptionsModel.sort(), new java.util.ArrayList<java.util.Map<String, String>>(java.util.Arrays.asList(new java.util.HashMap<String, String>() { { put("foo", "asc"); } })));
    assertEquals(postExplainOptionsModel.stable(), Boolean.valueOf(true));
    assertEquals(postExplainOptionsModel.update(), "false");
    assertEquals(postExplainOptionsModel.useIndex(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postExplainOptionsModel.r(), Long.valueOf("1"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostExplainOptionsError() throws Throwable {
    new PostExplainOptions.Builder().build();
  }

}