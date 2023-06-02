/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.cloudant.v1.model.PutSecurityOptions;
import com.ibm.cloud.cloudant.v1.model.SecurityObject;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PutSecurityOptions model.
 */
public class PutSecurityOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPutSecurityOptions() throws Throwable {
    SecurityObject securityObjectModel = new SecurityObject.Builder()
      .names(java.util.Arrays.asList("testString"))
      .roles(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(securityObjectModel.names(), java.util.Arrays.asList("testString"));
    assertEquals(securityObjectModel.roles(), java.util.Arrays.asList("testString"));

    PutSecurityOptions putSecurityOptionsModel = new PutSecurityOptions.Builder()
      .db("testString")
      .admins(securityObjectModel)
      .members(securityObjectModel)
      .cloudant(java.util.Collections.singletonMap("key1", java.util.Arrays.asList("_reader")))
      .couchdbAuthOnly(true)
      .build();
    assertEquals(putSecurityOptionsModel.db(), "testString");
    assertEquals(putSecurityOptionsModel.admins(), securityObjectModel);
    assertEquals(putSecurityOptionsModel.members(), securityObjectModel);
    assertEquals(putSecurityOptionsModel.cloudant(), java.util.Collections.singletonMap("key1", java.util.Arrays.asList("_reader")));
    assertEquals(putSecurityOptionsModel.couchdbAuthOnly(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutSecurityOptionsError() throws Throwable {
    new PutSecurityOptions.Builder().build();
  }

}