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

import com.ibm.cloud.cloudant.v1.model.PutAttachmentOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PutAttachmentOptions model.
 */
public class PutAttachmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPutAttachmentOptions() throws Throwable {
    PutAttachmentOptions putAttachmentOptionsModel = new PutAttachmentOptions.Builder()
      .db("testString")
      .docId("testString")
      .attachmentName("testString")
      .attachment(TestUtilities.createMockStream("This is a mock file."))
      .contentType("testString")
      .ifMatch("testString")
      .rev("testString")
      .build();
    assertEquals(putAttachmentOptionsModel.db(), "testString");
    assertEquals(putAttachmentOptionsModel.docId(), "testString");
    assertEquals(putAttachmentOptionsModel.attachmentName(), "testString");
    assertEquals(IOUtils.toString(putAttachmentOptionsModel.attachment()), IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(putAttachmentOptionsModel.contentType(), "testString");
    assertEquals(putAttachmentOptionsModel.ifMatch(), "testString");
    assertEquals(putAttachmentOptionsModel.rev(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutAttachmentOptionsError() throws Throwable {
    new PutAttachmentOptions.Builder().build();
  }

}