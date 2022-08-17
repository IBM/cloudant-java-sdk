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

import com.ibm.cloud.cloudant.v1.model.UserContext;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UserContext model.
 */
public class UserContextTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUserContext() throws Throwable {
    UserContext userContextModel = new UserContext.Builder()
      .db("testString")
      .name("testString")
      .roles(java.util.Arrays.asList("_reader"))
      .build();
    assertEquals(userContextModel.db(), "testString");
    assertEquals(userContextModel.name(), "testString");
    assertEquals(userContextModel.roles(), java.util.Arrays.asList("_reader"));

    String json = TestUtilities.serialize(userContextModel);

    UserContext userContextModelNew = TestUtilities.deserialize(json, UserContext.class);
    assertTrue(userContextModelNew instanceof UserContext);
    assertEquals(userContextModelNew.db(), "testString");
    assertEquals(userContextModelNew.name(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUserContextError() throws Throwable {
    new UserContext.Builder().build();
  }

}