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

import com.ibm.cloud.cloudant.v1.model.GetGeoOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetGeoOptions model.
 */
public class GetGeoOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetGeoOptions() throws Throwable {
    GetGeoOptions getGeoOptionsModel = new GetGeoOptions.Builder()
      .db("testString")
      .ddoc("testString")
      .index("testString")
      .bbox("testString")
      .bookmark("testString")
      .format("legacy")
      .g("testString")
      .includeDocs(true)
      .lat(Double.valueOf("-90"))
      .limit(Long.valueOf("0"))
      .lon(Double.valueOf("-180"))
      .nearest(true)
      .radius(Double.valueOf("0"))
      .rangex(Double.valueOf("0"))
      .rangey(Double.valueOf("0"))
      .relation("contains")
      .skip(Long.valueOf("0"))
      .stale("ok")
      .build();
    assertEquals(getGeoOptionsModel.db(), "testString");
    assertEquals(getGeoOptionsModel.ddoc(), "testString");
    assertEquals(getGeoOptionsModel.index(), "testString");
    assertEquals(getGeoOptionsModel.bbox(), "testString");
    assertEquals(getGeoOptionsModel.bookmark(), "testString");
    assertEquals(getGeoOptionsModel.format(), "legacy");
    assertEquals(getGeoOptionsModel.g(), "testString");
    assertEquals(getGeoOptionsModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(getGeoOptionsModel.lat(), Double.valueOf("-90"));
    assertEquals(getGeoOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(getGeoOptionsModel.lon(), Double.valueOf("-180"));
    assertEquals(getGeoOptionsModel.nearest(), Boolean.valueOf(true));
    assertEquals(getGeoOptionsModel.radius(), Double.valueOf("0"));
    assertEquals(getGeoOptionsModel.rangex(), Double.valueOf("0"));
    assertEquals(getGeoOptionsModel.rangey(), Double.valueOf("0"));
    assertEquals(getGeoOptionsModel.relation(), "contains");
    assertEquals(getGeoOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(getGeoOptionsModel.stale(), "ok");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetGeoOptionsError() throws Throwable {
    new GetGeoOptions.Builder().build();
  }

}