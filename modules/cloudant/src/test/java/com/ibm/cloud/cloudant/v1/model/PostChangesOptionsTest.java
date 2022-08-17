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

import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PostChangesOptions model.
 */
public class PostChangesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostChangesOptions() throws Throwable {
    PostChangesOptions postChangesOptionsModel = new PostChangesOptions.Builder()
      .db("testString")
      .docIds(java.util.Arrays.asList("testString"))
      .fields(java.util.Arrays.asList("testString"))
      .selector(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .lastEventId("testString")
      .attEncodingInfo(false)
      .attachments(false)
      .conflicts(false)
      .descending(false)
      .feed("normal")
      .filter("testString")
      .heartbeat(Long.valueOf("0"))
      .includeDocs(false)
      .limit(Long.valueOf("0"))
      .seqInterval(Long.valueOf("1"))
      .since("0")
      .style("main_only")
      .timeout(Long.valueOf("0"))
      .view("testString")
      .build();
    assertEquals(postChangesOptionsModel.db(), "testString");
    assertEquals(postChangesOptionsModel.docIds(), java.util.Arrays.asList("testString"));
    assertEquals(postChangesOptionsModel.fields(), java.util.Arrays.asList("testString"));
    assertEquals(postChangesOptionsModel.selector(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(postChangesOptionsModel.lastEventId(), "testString");
    assertEquals(postChangesOptionsModel.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(postChangesOptionsModel.attachments(), Boolean.valueOf(false));
    assertEquals(postChangesOptionsModel.conflicts(), Boolean.valueOf(false));
    assertEquals(postChangesOptionsModel.descending(), Boolean.valueOf(false));
    assertEquals(postChangesOptionsModel.feed(), "normal");
    assertEquals(postChangesOptionsModel.filter(), "testString");
    assertEquals(postChangesOptionsModel.heartbeat(), Long.valueOf("0"));
    assertEquals(postChangesOptionsModel.includeDocs(), Boolean.valueOf(false));
    assertEquals(postChangesOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postChangesOptionsModel.seqInterval(), Long.valueOf("1"));
    assertEquals(postChangesOptionsModel.since(), "0");
    assertEquals(postChangesOptionsModel.style(), "main_only");
    assertEquals(postChangesOptionsModel.timeout(), Long.valueOf("0"));
    assertEquals(postChangesOptionsModel.view(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostChangesOptionsError() throws Throwable {
    new PostChangesOptions.Builder().build();
  }

}