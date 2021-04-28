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

import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetDocumentOptions model.
 */
public class GetDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetDocumentOptions() throws Throwable {
    GetDocumentOptions getDocumentOptionsModel = new GetDocumentOptions.Builder()
      .db("testString")
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
    assertEquals(getDocumentOptionsModel.db(), "testString");
    assertEquals(getDocumentOptionsModel.docId(), "testString");
    assertEquals(getDocumentOptionsModel.ifNoneMatch(), "testString");
    assertEquals(getDocumentOptionsModel.attachments(), Boolean.valueOf(true));
    assertEquals(getDocumentOptionsModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(getDocumentOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(getDocumentOptionsModel.deletedConflicts(), Boolean.valueOf(true));
    assertEquals(getDocumentOptionsModel.latest(), Boolean.valueOf(true));
    assertEquals(getDocumentOptionsModel.localSeq(), Boolean.valueOf(true));
    assertEquals(getDocumentOptionsModel.meta(), Boolean.valueOf(true));
    assertEquals(getDocumentOptionsModel.rev(), "testString");
    assertEquals(getDocumentOptionsModel.revs(), Boolean.valueOf(true));
    assertEquals(getDocumentOptionsModel.revsInfo(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentOptionsError() throws Throwable {
    new GetDocumentOptions.Builder().build();
  }

}