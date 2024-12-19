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

import com.ibm.cloud.cloudant.v1.model.ReplicationCreateTargetParameters;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplicationCreateTargetParameters model.
 */
public class ReplicationCreateTargetParametersTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplicationCreateTargetParameters() throws Throwable {
    ReplicationCreateTargetParameters replicationCreateTargetParametersModel = new ReplicationCreateTargetParameters.Builder()
      .n(Long.valueOf("3"))
      .partitioned(false)
      .q(Long.valueOf("16"))
      .build();
    assertEquals(replicationCreateTargetParametersModel.n(), Long.valueOf("3"));
    assertEquals(replicationCreateTargetParametersModel.partitioned(), Boolean.valueOf(false));
    assertEquals(replicationCreateTargetParametersModel.q(), Long.valueOf("16"));

    String json = TestUtilities.serialize(replicationCreateTargetParametersModel);

    ReplicationCreateTargetParameters replicationCreateTargetParametersModelNew = TestUtilities.deserialize(json, ReplicationCreateTargetParameters.class);
    assertTrue(replicationCreateTargetParametersModelNew instanceof ReplicationCreateTargetParameters);
    assertEquals(replicationCreateTargetParametersModelNew.n(), Long.valueOf("3"));
    assertEquals(replicationCreateTargetParametersModelNew.partitioned(), Boolean.valueOf(false));
    assertEquals(replicationCreateTargetParametersModelNew.q(), Long.valueOf("16"));
  }
}