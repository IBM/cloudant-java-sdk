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

import com.ibm.cloud.cloudant.v1.model.PostPartitionExplainOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PostPartitionExplainOptions model.
 */
public class PostPartitionExplainOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostPartitionExplainOptions() throws Throwable {
    PostPartitionExplainOptions postPartitionExplainOptionsModel = new PostPartitionExplainOptions.Builder()
      .db("testString")
      .partitionKey("testString")
      .selector(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .allowFallback(true)
      .bookmark("testString")
      .conflicts(true)
      .executionStats(true)
      .fields(java.util.Arrays.asList("testString"))
      .limit(Long.valueOf("25"))
      .skip(Long.valueOf("0"))
      .sort(java.util.Arrays.asList(java.util.Collections.singletonMap("key1", "asc")))
      .stable(true)
      .update("true")
      .useIndex(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(postPartitionExplainOptionsModel.db(), "testString");
    assertEquals(postPartitionExplainOptionsModel.partitionKey(), "testString");
    assertEquals(postPartitionExplainOptionsModel.selector(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(postPartitionExplainOptionsModel.allowFallback(), Boolean.valueOf(true));
    assertEquals(postPartitionExplainOptionsModel.bookmark(), "testString");
    assertEquals(postPartitionExplainOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(postPartitionExplainOptionsModel.executionStats(), Boolean.valueOf(true));
    assertEquals(postPartitionExplainOptionsModel.fields(), java.util.Arrays.asList("testString"));
    assertEquals(postPartitionExplainOptionsModel.limit(), Long.valueOf("25"));
    assertEquals(postPartitionExplainOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postPartitionExplainOptionsModel.sort(), java.util.Arrays.asList(java.util.Collections.singletonMap("key1", "asc")));
    assertEquals(postPartitionExplainOptionsModel.stable(), Boolean.valueOf(true));
    assertEquals(postPartitionExplainOptionsModel.update(), "true");
    assertEquals(postPartitionExplainOptionsModel.useIndex(), java.util.Arrays.asList("testString"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionExplainOptionsError() throws Throwable {
    new PostPartitionExplainOptions.Builder().build();
  }

}