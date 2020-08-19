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

import com.ibm.cloud.cloudant.v1.model.GetAttachmentOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetAttachmentOptions model.
 */
public class GetAttachmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetAttachmentOptions() throws Throwable {
    GetAttachmentOptions getAttachmentOptionsModel = new GetAttachmentOptions.Builder()
      .db("testString")
      .docId("testString")
      .attachmentName("testString")
      .accept("testString")
      .ifMatch("testString")
      .ifNoneMatch("testString")
      .range("testString")
      .rev("testString")
      .build();
    assertEquals(getAttachmentOptionsModel.db(), "testString");
    assertEquals(getAttachmentOptionsModel.docId(), "testString");
    assertEquals(getAttachmentOptionsModel.attachmentName(), "testString");
    assertEquals(getAttachmentOptionsModel.accept(), "testString");
    assertEquals(getAttachmentOptionsModel.ifMatch(), "testString");
    assertEquals(getAttachmentOptionsModel.ifNoneMatch(), "testString");
    assertEquals(getAttachmentOptionsModel.range(), "testString");
    assertEquals(getAttachmentOptionsModel.rev(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAttachmentOptionsError() throws Throwable {
    new GetAttachmentOptions.Builder().build();
  }

}