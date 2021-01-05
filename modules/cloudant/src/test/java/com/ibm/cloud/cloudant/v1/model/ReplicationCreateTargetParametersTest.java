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
      .n(Long.valueOf("1"))
      .partitioned(true)
      .q(Long.valueOf("1"))
      .build();
    assertEquals(replicationCreateTargetParametersModel.n(), Long.valueOf("1"));
    assertEquals(replicationCreateTargetParametersModel.partitioned(), Boolean.valueOf(true));
    assertEquals(replicationCreateTargetParametersModel.q(), Long.valueOf("1"));

    String json = TestUtilities.serialize(replicationCreateTargetParametersModel);

    ReplicationCreateTargetParameters replicationCreateTargetParametersModelNew = TestUtilities.deserialize(json, ReplicationCreateTargetParameters.class);
    assertTrue(replicationCreateTargetParametersModelNew instanceof ReplicationCreateTargetParameters);
    assertEquals(replicationCreateTargetParametersModelNew.n(), Long.valueOf("1"));
    assertEquals(replicationCreateTargetParametersModelNew.partitioned(), Boolean.valueOf(true));
    assertEquals(replicationCreateTargetParametersModelNew.q(), Long.valueOf("1"));
  }
}