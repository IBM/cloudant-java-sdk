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

import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PostPartitionFindOptions model.
 */
public class PostPartitionFindOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostPartitionFindOptions() throws Throwable {
    PostPartitionFindOptions postPartitionFindOptionsModel = new PostPartitionFindOptions.Builder()
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
    assertEquals(postPartitionFindOptionsModel.db(), "testString");
    assertEquals(postPartitionFindOptionsModel.partitionKey(), "testString");
    assertEquals(postPartitionFindOptionsModel.selector(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(postPartitionFindOptionsModel.allowFallback(), Boolean.valueOf(true));
    assertEquals(postPartitionFindOptionsModel.bookmark(), "testString");
    assertEquals(postPartitionFindOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(postPartitionFindOptionsModel.executionStats(), Boolean.valueOf(true));
    assertEquals(postPartitionFindOptionsModel.fields(), java.util.Arrays.asList("testString"));
    assertEquals(postPartitionFindOptionsModel.limit(), Long.valueOf("25"));
    assertEquals(postPartitionFindOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postPartitionFindOptionsModel.sort(), java.util.Arrays.asList(java.util.Collections.singletonMap("key1", "asc")));
    assertEquals(postPartitionFindOptionsModel.stable(), Boolean.valueOf(true));
    assertEquals(postPartitionFindOptionsModel.update(), "true");
    assertEquals(postPartitionFindOptionsModel.useIndex(), java.util.Arrays.asList("testString"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostPartitionFindOptionsError() throws Throwable {
    new PostPartitionFindOptions.Builder().build();
  }

}