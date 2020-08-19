/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.cloudant.v1.model.CorsConfiguration;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CorsConfiguration model.
 */
public class CorsConfigurationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCorsConfiguration() throws Throwable {
    CorsConfiguration corsConfigurationModel = new CorsConfiguration.Builder()
      .allowCredentials(true)
      .enableCors(true)
      .origins(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
    assertEquals(corsConfigurationModel.allowCredentials(), Boolean.valueOf(true));
    assertEquals(corsConfigurationModel.enableCors(), Boolean.valueOf(true));
    assertEquals(corsConfigurationModel.origins(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    String json = TestUtilities.serialize(corsConfigurationModel);

    CorsConfiguration corsConfigurationModelNew = TestUtilities.deserialize(json, CorsConfiguration.class);
    assertTrue(corsConfigurationModelNew instanceof CorsConfiguration);
    assertEquals(corsConfigurationModelNew.allowCredentials(), Boolean.valueOf(true));
    assertEquals(corsConfigurationModelNew.enableCors(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCorsConfigurationError() throws Throwable {
    new CorsConfiguration.Builder().build();
  }

}