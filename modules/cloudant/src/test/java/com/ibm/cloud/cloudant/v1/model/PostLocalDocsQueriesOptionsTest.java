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

import com.ibm.cloud.cloudant.v1.model.AllDocsQuery;
import com.ibm.cloud.cloudant.v1.model.PostLocalDocsQueriesOptions;
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
 * Unit test class for the PostLocalDocsQueriesOptions model.
 */
public class PostLocalDocsQueriesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostLocalDocsQueriesOptions() throws Throwable {
    AllDocsQuery allDocsQueryModel = new AllDocsQuery.Builder()
      .attEncodingInfo(true)
      .attachments(true)
      .conflicts(true)
      .descending(true)
      .includeDocs(true)
      .inclusiveEnd(true)
      .limit(Long.valueOf("0"))
      .skip(Long.valueOf("0"))
      .updateSeq(true)
      .endkey("testString")
      .key("testString")
      .keys(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .startkey("testString")
      .build();
    assertEquals(allDocsQueryModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(allDocsQueryModel.attachments(), Boolean.valueOf(true));
    assertEquals(allDocsQueryModel.conflicts(), Boolean.valueOf(true));
    assertEquals(allDocsQueryModel.descending(), Boolean.valueOf(true));
    assertEquals(allDocsQueryModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(allDocsQueryModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(allDocsQueryModel.limit(), Long.valueOf("0"));
    assertEquals(allDocsQueryModel.skip(), Long.valueOf("0"));
    assertEquals(allDocsQueryModel.updateSeq(), Boolean.valueOf(true));
    assertEquals(allDocsQueryModel.endkey(), "testString");
    assertEquals(allDocsQueryModel.key(), "testString");
    assertEquals(allDocsQueryModel.keys(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(allDocsQueryModel.startkey(), "testString");

    PostLocalDocsQueriesOptions postLocalDocsQueriesOptionsModel = new PostLocalDocsQueriesOptions.Builder()
      .db("testString")
      .accept("application/json")
      .queries(new java.util.ArrayList<AllDocsQuery>(java.util.Arrays.asList(allDocsQueryModel)))
      .build();
    assertEquals(postLocalDocsQueriesOptionsModel.db(), "testString");
    assertEquals(postLocalDocsQueriesOptionsModel.accept(), "application/json");
    assertEquals(postLocalDocsQueriesOptionsModel.queries(), new java.util.ArrayList<AllDocsQuery>(java.util.Arrays.asList(allDocsQueryModel)));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostLocalDocsQueriesOptionsError() throws Throwable {
    new PostLocalDocsQueriesOptions.Builder().build();
  }

}