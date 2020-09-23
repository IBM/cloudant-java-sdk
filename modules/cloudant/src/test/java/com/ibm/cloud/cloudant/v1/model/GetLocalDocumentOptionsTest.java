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

import com.ibm.cloud.cloudant.v1.model.GetLocalDocumentOptions;
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
 * Unit test class for the GetLocalDocumentOptions model.
 */
public class GetLocalDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetLocalDocumentOptions() throws Throwable {
    GetLocalDocumentOptions getLocalDocumentOptionsModel = new GetLocalDocumentOptions.Builder()
      .db("testString")
      .docId("testString")
      .accept("application/json")
      .ifNoneMatch("testString")
      .attachments(true)
      .attEncodingInfo(true)
      .attsSince(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .localSeq(true)
      .build();
    assertEquals(getLocalDocumentOptionsModel.db(), "testString");
    assertEquals(getLocalDocumentOptionsModel.docId(), "testString");
    assertEquals(getLocalDocumentOptionsModel.accept(), "application/json");
    assertEquals(getLocalDocumentOptionsModel.ifNoneMatch(), "testString");
    assertEquals(getLocalDocumentOptionsModel.attachments(), Boolean.valueOf(true));
    assertEquals(getLocalDocumentOptionsModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(getLocalDocumentOptionsModel.attsSince(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(getLocalDocumentOptionsModel.localSeq(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLocalDocumentOptionsError() throws Throwable {
    new GetLocalDocumentOptions.Builder().build();
  }

}