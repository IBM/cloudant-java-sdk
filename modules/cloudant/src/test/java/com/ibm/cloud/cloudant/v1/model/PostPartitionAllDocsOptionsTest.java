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

import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
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
 * Unit test class for the PostPartitionAllDocsOptions model.
 */
public class PostPartitionAllDocsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostPartitionAllDocsOptions() throws Throwable {
    PostPartitionAllDocsOptions postPartitionAllDocsOptionsModel = new PostPartitionAllDocsOptions.Builder()
      .db("testString")
      .partitionKey("testString")
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
    assertEquals(postPartitionAllDocsOptionsModel.db(), "testString");
    assertEquals(postPartitionAllDocsOptionsModel.partitionKey(), "testString");
    assertEquals(postPartitionAllDocsOptionsModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(postPartitionAllDocsOptionsModel.attachments(), Boolean.valueOf(true));
    assertEquals(postPartitionAllDocsOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(postPartitionAllDocsOptionsModel.descending(), Boolean.valueOf(true));
    assertEquals(postPartitionAllDocsOptionsModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(postPartitionAllDocsOptionsModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(postPartitionAllDocsOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postPartitionAllDocsOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postPartitionAllDocsOptionsModel.updateSeq(), Boolean.valueOf(true));
    assertEquals(postPartitionAllDocsOptionsModel.endkey(), "testString");
    assertEquals(postPartitionAllDocsOptionsModel.key(), "testString");
    assertEquals(postPartitionAllDocsOptionsModel.keys(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postPartitionAllDocsOptionsModel.startkey(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionAllDocsOptionsError() throws Throwable {
    new PostPartitionAllDocsOptions.Builder().build();
  }

}