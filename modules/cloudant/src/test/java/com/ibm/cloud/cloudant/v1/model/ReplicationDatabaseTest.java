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

import com.ibm.cloud.cloudant.v1.model.ReplicationDatabase;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuth;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthBasic;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthIam;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplicationDatabase model.
 */
public class ReplicationDatabaseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplicationDatabase() throws Throwable {
    ReplicationDatabaseAuthBasic replicationDatabaseAuthBasicModel = new ReplicationDatabaseAuthBasic.Builder()
      .password("testString")
      .username("testString")
      .build();
    assertEquals(replicationDatabaseAuthBasicModel.password(), "testString");
    assertEquals(replicationDatabaseAuthBasicModel.username(), "testString");

    ReplicationDatabaseAuthIam replicationDatabaseAuthIamModel = new ReplicationDatabaseAuthIam.Builder()
      .apiKey("testString")
      .build();
    assertEquals(replicationDatabaseAuthIamModel.apiKey(), "testString");

    ReplicationDatabaseAuth replicationDatabaseAuthModel = new ReplicationDatabaseAuth.Builder()
      .basic(replicationDatabaseAuthBasicModel)
      .iam(replicationDatabaseAuthIamModel)
      .build();
    assertEquals(replicationDatabaseAuthModel.basic(), replicationDatabaseAuthBasicModel);
    assertEquals(replicationDatabaseAuthModel.iam(), replicationDatabaseAuthIamModel);

    ReplicationDatabase replicationDatabaseModel = new ReplicationDatabase.Builder()
      .auth(replicationDatabaseAuthModel)
      .headers(java.util.Collections.singletonMap("foo", "testString"))
      .url("testString")
      .build();
    assertEquals(replicationDatabaseModel.auth(), replicationDatabaseAuthModel);
    assertEquals(replicationDatabaseModel.headers(), java.util.Collections.singletonMap("foo", "testString"));
    assertEquals(replicationDatabaseModel.url(), "testString");

    String json = TestUtilities.serialize(replicationDatabaseModel);

    ReplicationDatabase replicationDatabaseModelNew = TestUtilities.deserialize(json, ReplicationDatabase.class);
    assertTrue(replicationDatabaseModelNew instanceof ReplicationDatabase);
    assertEquals(replicationDatabaseModelNew.auth().toString(), replicationDatabaseAuthModel.toString());
    assertEquals(replicationDatabaseModelNew.url(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplicationDatabaseError() throws Throwable {
    new ReplicationDatabase.Builder().build();
  }

}