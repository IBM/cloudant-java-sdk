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

import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
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
 * Unit test class for the PostDesignDocsOptions model.
 */
public class PostDesignDocsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostDesignDocsOptions() throws Throwable {
    PostDesignDocsOptions postDesignDocsOptionsModel = new PostDesignDocsOptions.Builder()
      .db("testString")
      .accept("application/json")
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
    assertEquals(postDesignDocsOptionsModel.db(), "testString");
    assertEquals(postDesignDocsOptionsModel.accept(), "application/json");
    assertEquals(postDesignDocsOptionsModel.attEncodingInfo(), Boolean.valueOf(true));
    assertEquals(postDesignDocsOptionsModel.attachments(), Boolean.valueOf(true));
    assertEquals(postDesignDocsOptionsModel.conflicts(), Boolean.valueOf(true));
    assertEquals(postDesignDocsOptionsModel.descending(), Boolean.valueOf(true));
    assertEquals(postDesignDocsOptionsModel.includeDocs(), Boolean.valueOf(true));
    assertEquals(postDesignDocsOptionsModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(postDesignDocsOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postDesignDocsOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postDesignDocsOptionsModel.updateSeq(), Boolean.valueOf(true));
    assertEquals(postDesignDocsOptionsModel.endkey(), "testString");
    assertEquals(postDesignDocsOptionsModel.key(), "testString");
    assertEquals(postDesignDocsOptionsModel.keys(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(postDesignDocsOptionsModel.startkey(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDesignDocsOptionsError() throws Throwable {
    new PostDesignDocsOptions.Builder().build();
  }

}