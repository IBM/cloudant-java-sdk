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

import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
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
 * Unit test class for the PostSearchOptions model.
 */
public class PostSearchOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostSearchOptions() throws Throwable {
    PostSearchOptions postSearchOptionsModel = new PostSearchOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .index("testString")
      .query("testString")
      .bookmark("testString")
      .highlightFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .highlightNumber(Long.valueOf("1"))
      .highlightPostTag("testString")
      .highlightPreTag("testString")
      .highlightSize(Long.valueOf("1"))
      .includeDocs(true)
      .includeFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .limit(Long.valueOf("0"))
      .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .stale("ok")
      .counts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .drilldown(new java.util.ArrayList<List<String>>(java.util.Arrays.asList(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))))
      .groupField("testString")
      .groupLimit(Long.valueOf("1"))
      .groupSort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .ranges(new java.util.HashMap<String, Map<String, Map<String, String>>>() { { put("foo", new java.util.HashMap<String, Map<String, String>>() { { put("foo", new java.util.HashMap<String, String>() { { put("foo", "testString"); } }); } }); } })
      .build();
    assertEquals(postSearchOptionsModel.db(), "testString");
    assertEquals(postSearchOptionsModel.ddoc(), "testString");
    assertEquals(postSearchOptionsModel.index(), "testString");
    assertEquals(postSearchOptionsModel.query(), "testString");
    assertEquals(postSearchOptionsModel.bookmark(), "testString");
    assertEquals(postSearchOptionsModel.highlightFields(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postSearchOptionsModel.highlightNumber(), Long.valueOf("1"));
    assertEquals(postSearchOptionsModel.highlightPostTag(), "testString");
    assertEquals(postSearchOptionsModel.highlightPreTag(), "testString");
    assertEquals(postSearchOptionsModel.highlightSize(), Long.valueOf("1"));
    assertEquals(postSearchOptionsModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(postSearchOptionsModel.includeFields(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postSearchOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postSearchOptionsModel.sort(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postSearchOptionsModel.stale(), "ok");
    assertEquals(postSearchOptionsModel.counts(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postSearchOptionsModel.drilldown(), new java.util.ArrayList<List<String>>(java.util.Arrays.asList(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))));
    assertEquals(postSearchOptionsModel.groupField(), "testString");
    assertEquals(postSearchOptionsModel.groupLimit(), Long.valueOf("1"));
    assertEquals(postSearchOptionsModel.groupSort(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postSearchOptionsModel.ranges(), new java.util.HashMap<String, Map<String, Map<String, String>>>() { { put("foo", new java.util.HashMap<String, Map<String, String>>() { { put("foo", new java.util.HashMap<String, String>() { { put("foo", "testString"); } }); } }); } });
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostSearchOptionsError() throws Throwable {
    new PostSearchOptions.Builder().build();
  }

}