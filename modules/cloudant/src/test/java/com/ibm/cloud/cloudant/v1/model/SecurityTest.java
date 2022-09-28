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

import com.ibm.cloud.cloudant.v1.model.Security;
import com.ibm.cloud.cloudant.v1.model.SecurityObject;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Security model.
 */
public class SecurityTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSecurity() throws Throwable {
    SecurityObject securityObjectModel = new SecurityObject.Builder()
      .names(java.util.Arrays.asList("testString"))
      .roles(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(securityObjectModel.names(), java.util.Arrays.asList("testString"));
    assertEquals(securityObjectModel.roles(), java.util.Arrays.asList("testString"));

    Security securityModel = new Security.Builder()
      .admins(securityObjectModel)
      .members(securityObjectModel)
      .cloudant(java.util.Collections.singletonMap("foo", java.util.Arrays.asList("_reader")))
      .couchdbAuthOnly(true)
      .build();
    assertEquals(securityModel.admins(), securityObjectModel);
    assertEquals(securityModel.members(), securityObjectModel);
    assertEquals(securityModel.cloudant(), java.util.Collections.singletonMap("foo", java.util.Arrays.asList("_reader")));
    assertEquals(securityModel.couchdbAuthOnly(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(securityModel);

    Security securityModelNew = TestUtilities.deserialize(json, Security.class);
    assertTrue(securityModelNew instanceof Security);
    assertEquals(securityModelNew.admins().toString(), securityObjectModel.toString());
    assertEquals(securityModelNew.members().toString(), securityObjectModel.toString());
    assertEquals(securityModelNew.couchdbAuthOnly(), Boolean.valueOf(true));
  }
}