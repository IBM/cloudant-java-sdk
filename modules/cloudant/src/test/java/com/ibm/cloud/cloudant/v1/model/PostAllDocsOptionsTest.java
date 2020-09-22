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

import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
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
 * Unit test class for the PostAllDocsOptions model.
 */
public class PostAllDocsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostAllDocsOptions() throws Throwable {
    PostAllDocsOptions postAllDocsOptionsModel = new PostAllDocsOptions.Builder()
      .db("testString")
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
      .key("testString")
      .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .startkey("testString")
      .build();
    assertEquals(postAllDocsOptionsModel.db(), "testString");
    assertEquals(postAllDocsOptionsModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(postAllDocsOptionsModel.attachments(), Boolean.valueOf(true));
    assertEquals(postAllDocsOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(postAllDocsOptionsModel.descending(), Boolean.valueOf(true));
    assertEquals(postAllDocsOptionsModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(postAllDocsOptionsModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(postAllDocsOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postAllDocsOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postAllDocsOptionsModel.updateSeq(), Boolean.valueOf(true));
    assertEquals(postAllDocsOptionsModel.endkey(), "testString");
    assertEquals(postAllDocsOptionsModel.key(), "testString");
    assertEquals(postAllDocsOptionsModel.keys(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postAllDocsOptionsModel.startkey(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostAllDocsOptionsError() throws Throwable {
    new PostAllDocsOptions.Builder().build();
  }

}