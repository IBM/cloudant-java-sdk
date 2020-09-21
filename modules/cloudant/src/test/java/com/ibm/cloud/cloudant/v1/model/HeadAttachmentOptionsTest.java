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

import com.ibm.cloud.cloudant.v1.model.HeadAttachmentOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the HeadAttachmentOptions model.
 */
public class HeadAttachmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testHeadAttachmentOptions() throws Throwable {
    HeadAttachmentOptions headAttachmentOptionsModel = new HeadAttachmentOptions.Builder()
      .db("testString")
      .docId("testString")
      .attachmentName("testString")
      .ifMatch("testString")
      .ifNoneMatch("testString")
      .rev("testString")
      .build();
    assertEquals(headAttachmentOptionsModel.db(), "testString");
    assertEquals(headAttachmentOptionsModel.docId(), "testString");
    assertEquals(headAttachmentOptionsModel.attachmentName(), "testString");
    assertEquals(headAttachmentOptionsModel.ifMatch(), "testString");
    assertEquals(headAttachmentOptionsModel.ifNoneMatch(), "testString");
    assertEquals(headAttachmentOptionsModel.rev(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testHeadAttachmentOptionsError() throws Throwable {
    new HeadAttachmentOptions.Builder().build();
  }

}