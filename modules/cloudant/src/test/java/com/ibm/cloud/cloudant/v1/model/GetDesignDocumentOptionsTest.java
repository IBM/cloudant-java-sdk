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

import com.ibm.cloud.cloudant.v1.model.GetDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetDesignDocumentOptions model.
 */
public class GetDesignDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetDesignDocumentOptions() throws Throwable {
    GetDesignDocumentOptions getDesignDocumentOptionsModel = new GetDesignDocumentOptions.Builder()
      .db("testString")
      .ddoc("testString")
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
    assertEquals(getDesignDocumentOptionsModel.db(), "testString");
    assertEquals(getDesignDocumentOptionsModel.ddoc(), "testString");
    assertEquals(getDesignDocumentOptionsModel.ifNoneMatch(), "testString");
    assertEquals(getDesignDocumentOptionsModel.attachments(), Boolean.valueOf(false));
    assertEquals(getDesignDocumentOptionsModel.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(getDesignDocumentOptionsModel.conflicts(), Boolean.valueOf(false));
    assertEquals(getDesignDocumentOptionsModel.deletedConflicts(), Boolean.valueOf(false));
    assertEquals(getDesignDocumentOptionsModel.latest(), Boolean.valueOf(false));
    assertEquals(getDesignDocumentOptionsModel.localSeq(), Boolean.valueOf(false));
    assertEquals(getDesignDocumentOptionsModel.meta(), Boolean.valueOf(false));
    assertEquals(getDesignDocumentOptionsModel.rev(), "testString");
    assertEquals(getDesignDocumentOptionsModel.revs(), Boolean.valueOf(false));
    assertEquals(getDesignDocumentOptionsModel.revsInfo(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDesignDocumentOptionsError() throws Throwable {
    new GetDesignDocumentOptions.Builder().build();
  }

}