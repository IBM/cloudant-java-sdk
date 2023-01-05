/*
 * (C) Copyright IBM Corp. 2023.
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
      .build();
    assertEquals(postPartitionAllDocsOptionsModel.db(), "testString");
    assertEquals(postPartitionAllDocsOptionsModel.partitionKey(), "testString");
    assertEquals(postPartitionAllDocsOptionsModel.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(postPartitionAllDocsOptionsModel.attachments(), Boolean.valueOf(false));
    assertEquals(postPartitionAllDocsOptionsModel.conflicts(), Boolean.valueOf(false));
    assertEquals(postPartitionAllDocsOptionsModel.descending(), Boolean.valueOf(false));
    assertEquals(postPartitionAllDocsOptionsModel.includeDocs(), Boolean.valueOf(false));
    assertEquals(postPartitionAllDocsOptionsModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(postPartitionAllDocsOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postPartitionAllDocsOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postPartitionAllDocsOptionsModel.updateSeq(), Boolean.valueOf(false));
    assertEquals(postPartitionAllDocsOptionsModel.endKey(), "testString");
    assertEquals(postPartitionAllDocsOptionsModel.key(), "testString");
    assertEquals(postPartitionAllDocsOptionsModel.keys(), java.util.Arrays.asList("testString"));
    assertEquals(postPartitionAllDocsOptionsModel.startKey(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionAllDocsOptionsError() throws Throwable {
    new PostPartitionAllDocsOptions.Builder().build();
  }

}