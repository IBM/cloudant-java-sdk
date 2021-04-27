/*
 * (C) Copyright IBM Corp. 2021.
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
      .attachments(true)
      .attEncodingInfo(true)
      .conflicts(true)
      .deletedConflicts(true)
      .latest(true)
      .localSeq(true)
      .meta(true)
      .rev("testString")
      .revs(true)
      .revsInfo(true)
      .build();
    assertEquals(getReplicationDocumentOptionsModel.docId(), "testString");
    assertEquals(getReplicationDocumentOptionsModel.ifNoneMatch(), "testString");
    assertEquals(getReplicationDocumentOptionsModel.attachments(), Boolean.valueOf(true));
    assertEquals(getReplicationDocumentOptionsModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(getReplicationDocumentOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(getReplicationDocumentOptionsModel.deletedConflicts(), Boolean.valueOf(true));
    assertEquals(getReplicationDocumentOptionsModel.latest(), Boolean.valueOf(true));
    assertEquals(getReplicationDocumentOptionsModel.localSeq(), Boolean.valueOf(true));
    assertEquals(getReplicationDocumentOptionsModel.meta(), Boolean.valueOf(true));
    assertEquals(getReplicationDocumentOptionsModel.rev(), "testString");
    assertEquals(getReplicationDocumentOptionsModel.revs(), Boolean.valueOf(true));
    assertEquals(getReplicationDocumentOptionsModel.revsInfo(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReplicationDocumentOptionsError() throws Throwable {
    new GetReplicationDocumentOptions.Builder().build();
  }

}