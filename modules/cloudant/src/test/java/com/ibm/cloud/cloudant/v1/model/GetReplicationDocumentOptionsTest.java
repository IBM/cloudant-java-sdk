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

import com.ibm.cloud.cloudant.v1.model.GetReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetReplicationDocumentOptions model.
 */
public class GetReplicationDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetReplicationDocumentOptions() throws Throwable {
    GetReplicationDocumentOptions getReplicationDocumentOptionsModel = new GetReplicationDocumentOptions.Builder()
      .docId("testString")
      .ifNoneMatch("testString")
      .attachments(false)
      .attEncodingInfo(false)
      .conflicts(false)
      .deletedConflicts(false)
      .latest(false)
      .localSeq(false)
      .meta(false)
      .rev("testString")
      .revs(false)
      .revsInfo(false)
      .build();
    assertEquals(getReplicationDocumentOptionsModel.docId(), "testString");
    assertEquals(getReplicationDocumentOptionsModel.ifNoneMatch(), "testString");
    assertEquals(getReplicationDocumentOptionsModel.attachments(), Boolean.valueOf(false));
    assertEquals(getReplicationDocumentOptionsModel.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(getReplicationDocumentOptionsModel.conflicts(), Boolean.valueOf(false));
    assertEquals(getReplicationDocumentOptionsModel.deletedConflicts(), Boolean.valueOf(false));
    assertEquals(getReplicationDocumentOptionsModel.latest(), Boolean.valueOf(false));
    assertEquals(getReplicationDocumentOptionsModel.localSeq(), Boolean.valueOf(false));
    assertEquals(getReplicationDocumentOptionsModel.meta(), Boolean.valueOf(false));
    assertEquals(getReplicationDocumentOptionsModel.rev(), "testString");
    assertEquals(getReplicationDocumentOptionsModel.revs(), Boolean.valueOf(false));
    assertEquals(getReplicationDocumentOptionsModel.revsInfo(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReplicationDocumentOptionsError() throws Throwable {
    new GetReplicationDocumentOptions.Builder().build();
  }

}