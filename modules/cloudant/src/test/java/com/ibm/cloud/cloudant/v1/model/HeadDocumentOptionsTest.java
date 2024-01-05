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

import com.ibm.cloud.cloudant.v1.model.HeadDocumentOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the HeadDocumentOptions model.
 */
public class HeadDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testHeadDocumentOptions() throws Throwable {
    HeadDocumentOptions headDocumentOptionsModel = new HeadDocumentOptions.Builder()
      .db("testString")
      .docId("testString")
      .ifNoneMatch("testString")
      .latest(false)
      .rev("testString")
      .build();
    assertEquals(headDocumentOptionsModel.db(), "testString");
    assertEquals(headDocumentOptionsModel.docId(), "testString");
    assertEquals(headDocumentOptionsModel.ifNoneMatch(), "testString");
    assertEquals(headDocumentOptionsModel.latest(), Boolean.valueOf(false));
    assertEquals(headDocumentOptionsModel.rev(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadDocumentOptionsError() throws Throwable {
    new HeadDocumentOptions.Builder().build();
  }

}