/*
 * (C) Copyright IBM Corp. 2025.
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

import com.ibm.cloud.cloudant.v1.model.DeleteReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteReplicationDocumentOptions model.
 */
public class DeleteReplicationDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteReplicationDocumentOptions() throws Throwable {
    DeleteReplicationDocumentOptions deleteReplicationDocumentOptionsModel = new DeleteReplicationDocumentOptions.Builder()
      .docId("testString")
      .ifMatch("testString")
      .batch("ok")
      .rev("testString")
      .build();
    assertEquals(deleteReplicationDocumentOptionsModel.docId(), "testString");
    assertEquals(deleteReplicationDocumentOptionsModel.ifMatch(), "testString");
    assertEquals(deleteReplicationDocumentOptionsModel.batch(), "ok");
    assertEquals(deleteReplicationDocumentOptionsModel.rev(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteReplicationDocumentOptionsError() throws Throwable {
    new DeleteReplicationDocumentOptions.Builder().build();
  }

}