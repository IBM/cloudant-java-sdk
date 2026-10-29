/*
 * (C) Copyright IBM Corp. 2026.
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

import com.ibm.cloud.cloudant.v1.model.PostIndexInfoOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PostIndexInfoOptions model.
 */
public class PostIndexInfoOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostIndexInfoOptions() throws Throwable {
    PostIndexInfoOptions postIndexInfoOptionsModel = new PostIndexInfoOptions.Builder()
      .db("testString")
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
      .key("testString")
      .keys(java.util.Arrays.asList("testString"))
      .startKey("testString")
      .type(java.util.Arrays.asList("search"))
      .build();
    assertEquals(postIndexInfoOptionsModel.db(), "testString");
    assertEquals(postIndexInfoOptionsModel.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(postIndexInfoOptionsModel.attachments(), Boolean.valueOf(false));
    assertEquals(postIndexInfoOptionsModel.conflicts(), Boolean.valueOf(false));
    assertEquals(postIndexInfoOptionsModel.descending(), Boolean.valueOf(false));
    assertEquals(postIndexInfoOptionsModel.includeDocs(), Boolean.valueOf(false));
    assertEquals(postIndexInfoOptionsModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(postIndexInfoOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postIndexInfoOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postIndexInfoOptionsModel.updateSeq(), Boolean.valueOf(false));
    assertEquals(postIndexInfoOptionsModel.endKey(), "testString");
    assertEquals(postIndexInfoOptionsModel.key(), "testString");
    assertEquals(postIndexInfoOptionsModel.keys(), java.util.Arrays.asList("testString"));
    assertEquals(postIndexInfoOptionsModel.startKey(), "testString");
    assertEquals(postIndexInfoOptionsModel.type(), java.util.Arrays.asList("search"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostIndexInfoOptionsError() throws Throwable {
    new PostIndexInfoOptions.Builder().build();
  }

}