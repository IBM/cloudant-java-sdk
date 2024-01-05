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

import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
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
      .highlightFields(java.util.Arrays.asList("testString"))
      .highlightNumber(Long.valueOf("1"))
      .highlightPostTag("</em>")
      .highlightPreTag("<em>")
      .highlightSize(Long.valueOf("100"))
      .includeDocs(false)
      .includeFields(java.util.Arrays.asList("testString"))
      .limit(Long.valueOf("0"))
      .sort(java.util.Arrays.asList("testString"))
      .stale("ok")
      .counts(java.util.Arrays.asList("testString"))
      .drilldown(java.util.Arrays.asList(java.util.Arrays.asList("testString")))
      .groupField("testString")
      .groupLimit(Long.valueOf("1"))
      .groupSort(java.util.Arrays.asList("testString"))
      .ranges(java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", "testString"))))
      .build();
    assertEquals(postSearchOptionsModel.db(), "testString");
    assertEquals(postSearchOptionsModel.ddoc(), "testString");
    assertEquals(postSearchOptionsModel.index(), "testString");
    assertEquals(postSearchOptionsModel.query(), "testString");
    assertEquals(postSearchOptionsModel.bookmark(), "testString");
    assertEquals(postSearchOptionsModel.highlightFields(), java.util.Arrays.asList("testString"));
    assertEquals(postSearchOptionsModel.highlightNumber(), Long.valueOf("1"));
    assertEquals(postSearchOptionsModel.highlightPostTag(), "</em>");
    assertEquals(postSearchOptionsModel.highlightPreTag(), "<em>");
    assertEquals(postSearchOptionsModel.highlightSize(), Long.valueOf("100"));
    assertEquals(postSearchOptionsModel.includeDocs(), Boolean.valueOf(false));
    assertEquals(postSearchOptionsModel.includeFields(), java.util.Arrays.asList("testString"));
    assertEquals(postSearchOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postSearchOptionsModel.sort(), java.util.Arrays.asList("testString"));
    assertEquals(postSearchOptionsModel.stale(), "ok");
    assertEquals(postSearchOptionsModel.counts(), java.util.Arrays.asList("testString"));
    assertEquals(postSearchOptionsModel.drilldown(), java.util.Arrays.asList(java.util.Arrays.asList("testString")));
    assertEquals(postSearchOptionsModel.groupField(), "testString");
    assertEquals(postSearchOptionsModel.groupLimit(), Long.valueOf("1"));
    assertEquals(postSearchOptionsModel.groupSort(), java.util.Arrays.asList("testString"));
    assertEquals(postSearchOptionsModel.ranges(), java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", java.util.Collections.singletonMap("key1", "testString"))));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostSearchOptionsError() throws Throwable {
    new PostSearchOptions.Builder().build();
  }

}