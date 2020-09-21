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

import com.ibm.cloud.cloudant.v1.model.Attachment;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Attachment model.
 */
public class AttachmentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAttachment() throws Throwable {
    Attachment attachmentModel = new Attachment.Builder()
      .contentType("testString")
      .data(TestUtilities.createMockByteArray("This is a mock byte array value."))
      .digest("testString")
      .encodedLength(Long.valueOf("0"))
      .encoding("testString")
      .follows(true)
      .length(Long.valueOf("0"))
      .revpos(Long.valueOf("1"))
      .stub(true)
      .build();
    assertEquals(attachmentModel.contentType(), "testString");
    assertEquals(attachmentModel.data(), TestUtilities.createMockByteArray("This is a mock byte array value."));
    assertEquals(attachmentModel.digest(), "testString");
    assertEquals(attachmentModel.encodedLength(), Long.valueOf("0"));
    assertEquals(attachmentModel.encoding(), "testString");
    assertEquals(attachmentModel.follows(), Boolean.valueOf(true));
    assertEquals(attachmentModel.length(), Long.valueOf("0"));
    assertEquals(attachmentModel.revpos(), Long.valueOf("1"));
    assertEquals(attachmentModel.stub(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(attachmentModel);

    Attachment attachmentModelNew = TestUtilities.deserialize(json, Attachment.class);
    assertTrue(attachmentModelNew instanceof Attachment);
    assertEquals(attachmentModelNew.contentType(), "testString");
    assertEquals(attachmentModelNew.data(), TestUtilities.createMockByteArray("This is a mock byte array value."));
    assertEquals(attachmentModelNew.digest(), "testString");
    assertEquals(attachmentModelNew.encodedLength(), Long.valueOf("0"));
    assertEquals(attachmentModelNew.encoding(), "testString");
    assertEquals(attachmentModelNew.follows(), Boolean.valueOf(true));
    assertEquals(attachmentModelNew.length(), Long.valueOf("0"));
    assertEquals(attachmentModelNew.revpos(), Long.valueOf("1"));
    assertEquals(attachmentModelNew.stub(), Boolean.valueOf(true));
  }
}