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

import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthBasic;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplicationDatabaseAuthBasic model.
 */
public class ReplicationDatabaseAuthBasicTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplicationDatabaseAuthBasic() throws Throwable {
    ReplicationDatabaseAuthBasic replicationDatabaseAuthBasicModel = new ReplicationDatabaseAuthBasic.Builder()
      .password("testString")
      .username("testString")
      .build();
    assertEquals(replicationDatabaseAuthBasicModel.password(), "testString");
    assertEquals(replicationDatabaseAuthBasicModel.username(), "testString");

    String json = TestUtilities.serialize(replicationDatabaseAuthBasicModel);

    ReplicationDatabaseAuthBasic replicationDatabaseAuthBasicModelNew = TestUtilities.deserialize(json, ReplicationDatabaseAuthBasic.class);
    assertTrue(replicationDatabaseAuthBasicModelNew instanceof ReplicationDatabaseAuthBasic);
    assertEquals(replicationDatabaseAuthBasicModelNew.password(), "testString");
    assertEquals(replicationDatabaseAuthBasicModelNew.username(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplicationDatabaseAuthBasicError() throws Throwable {
    new ReplicationDatabaseAuthBasic.Builder().build();
  }

}