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

import com.ibm.cloud.cloudant.v1.model.PostLocalDocsOptions;
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
 * Unit test class for the PostLocalDocsOptions model.
 */
public class PostLocalDocsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostLocalDocsOptions() throws Throwable {
    PostLocalDocsOptions postLocalDocsOptionsModel = new PostLocalDocsOptions.Builder()
      .db("testString")
      .accept("application/json")
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
    assertEquals(postLocalDocsOptionsModel.db(), "testString");
    assertEquals(postLocalDocsOptionsModel.accept(), "application/json");
    assertEquals(postLocalDocsOptionsModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(postLocalDocsOptionsModel.attachments(), Boolean.valueOf(true));
    assertEquals(postLocalDocsOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(postLocalDocsOptionsModel.descending(), Boolean.valueOf(true));
    assertEquals(postLocalDocsOptionsModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(postLocalDocsOptionsModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(postLocalDocsOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postLocalDocsOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postLocalDocsOptionsModel.updateSeq(), Boolean.valueOf(true));
    assertEquals(postLocalDocsOptionsModel.endkey(), "testString");
    assertEquals(postLocalDocsOptionsModel.key(), "testString");
    assertEquals(postLocalDocsOptionsModel.keys(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postLocalDocsOptionsModel.startkey(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostLocalDocsOptionsError() throws Throwable {
    new PostLocalDocsOptions.Builder().build();
  }

}