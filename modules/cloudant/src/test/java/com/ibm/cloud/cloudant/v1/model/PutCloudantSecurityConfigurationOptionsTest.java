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

import com.ibm.cloud.cloudant.v1.model.PutCloudantSecurityConfigurationOptions;
import com.ibm.cloud.cloudant.v1.model.SecurityObject;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PutCloudantSecurityConfigurationOptions model.
 */
public class PutCloudantSecurityConfigurationOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPutCloudantSecurityConfigurationOptions() throws Throwable {
    SecurityObject securityObjectModel = new SecurityObject.Builder()
      .names(java.util.Arrays.asList("testString"))
      .roles(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(securityObjectModel.names(), java.util.Arrays.asList("testString"));
    assertEquals(securityObjectModel.roles(), java.util.Arrays.asList("testString"));

    PutCloudantSecurityConfigurationOptions putCloudantSecurityConfigurationOptionsModel = new PutCloudantSecurityConfigurationOptions.Builder()
      .db("testString")
      .cloudant(java.util.Collections.singletonMap("key1", java.util.Arrays.asList("_reader")))
      .admins(securityObjectModel)
      .members(securityObjectModel)
      .couchdbAuthOnly(true)
      .build();
    assertEquals(putCloudantSecurityConfigurationOptionsModel.db(), "testString");
    assertEquals(putCloudantSecurityConfigurationOptionsModel.cloudant(), java.util.Collections.singletonMap("key1", java.util.Arrays.asList("_reader")));
    assertEquals(putCloudantSecurityConfigurationOptionsModel.admins(), securityObjectModel);
    assertEquals(putCloudantSecurityConfigurationOptionsModel.members(), securityObjectModel);
    assertEquals(putCloudantSecurityConfigurationOptionsModel.couchdbAuthOnly(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutCloudantSecurityConfigurationOptionsError() throws Throwable {
    new PutCloudantSecurityConfigurationOptions.Builder().build();
  }

}