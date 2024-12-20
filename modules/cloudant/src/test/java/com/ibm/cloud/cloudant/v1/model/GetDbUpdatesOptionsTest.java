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

import com.ibm.cloud.cloudant.v1.model.GetDbUpdatesOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetDbUpdatesOptions model.
 */
public class GetDbUpdatesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetDbUpdatesOptions() throws Throwable {
    GetDbUpdatesOptions getDbUpdatesOptionsModel = new GetDbUpdatesOptions.Builder()
      .descending(false)
      .feed("normal")
      .heartbeat(Long.valueOf("1"))
      .limit(Long.valueOf("0"))
      .timeout(Long.valueOf("60000"))
      .since("0")
      .build();
    assertEquals(getDbUpdatesOptionsModel.descending(), Boolean.valueOf(false));
    assertEquals(getDbUpdatesOptionsModel.feed(), "normal");
    assertEquals(getDbUpdatesOptionsModel.heartbeat(), Long.valueOf("1"));
    assertEquals(getDbUpdatesOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(getDbUpdatesOptionsModel.timeout(), Long.valueOf("60000"));
    assertEquals(getDbUpdatesOptionsModel.since(), "0");
  }
}