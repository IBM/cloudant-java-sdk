/*
 * (C) Copyright IBM Corp. 2022.
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

import com.ibm.cloud.cloudant.v1.model.BulkGetQueryDocument;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the BulkGetQueryDocument model.
 */
public class BulkGetQueryDocumentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testBulkGetQueryDocument() throws Throwable {
    BulkGetQueryDocument bulkGetQueryDocumentModel = new BulkGetQueryDocument.Builder()
      .attsSince(java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"))
      .id("testString")
      .rev("testString")
      .build();
    assertEquals(bulkGetQueryDocumentModel.attsSince(), java.util.Arrays.asList("1-99b02e08da151943c2dcb40090160bb8"));
    assertEquals(bulkGetQueryDocumentModel.id(), "testString");
    assertEquals(bulkGetQueryDocumentModel.rev(), "testString");

    String json = TestUtilities.serialize(bulkGetQueryDocumentModel);

    BulkGetQueryDocument bulkGetQueryDocumentModelNew = TestUtilities.deserialize(json, BulkGetQueryDocument.class);
    assertTrue(bulkGetQueryDocumentModelNew instanceof BulkGetQueryDocument);
    assertEquals(bulkGetQueryDocumentModelNew.id(), "testString");
    assertEquals(bulkGetQueryDocumentModelNew.rev(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testBulkGetQueryDocumentError() throws Throwable {
    new BulkGetQueryDocument.Builder().build();
  }

}