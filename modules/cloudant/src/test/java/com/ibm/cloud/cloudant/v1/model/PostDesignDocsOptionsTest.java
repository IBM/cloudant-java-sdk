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

import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
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
      .attEncodingInfo(false)
      .attachments(false)
      .conflicts(false)
      .descending(false)
      .includeDocs(false)
      .inclusiveEnd(true)
      .limit(Long.valueOf("0"))
      .skip(Long.valueOf("0"))
      .updateSeq(false)
      .endKey("testString")
      .key("testString")
      .keys(java.util.Arrays.asList("testString"))
      .startKey("testString")
      .build();
    assertEquals(postDesignDocsOptionsModel.db(), "testString");
    assertEquals(postDesignDocsOptionsModel.accept(), "application/json");
    assertEquals(postDesignDocsOptionsModel.attEncodingInfo(), Boolean.valueOf(false));
    assertEquals(postDesignDocsOptionsModel.attachments(), Boolean.valueOf(false));
    assertEquals(postDesignDocsOptionsModel.conflicts(), Boolean.valueOf(false));
    assertEquals(postDesignDocsOptionsModel.descending(), Boolean.valueOf(false));
    assertEquals(postDesignDocsOptionsModel.includeDocs(), Boolean.valueOf(false));
    assertEquals(postDesignDocsOptionsModel.inclusiveEnd(), Boolean.valueOf(true));
    assertEquals(postDesignDocsOptionsModel.limit(), Long.valueOf("0"));
    assertEquals(postDesignDocsOptionsModel.skip(), Long.valueOf("0"));
    assertEquals(postDesignDocsOptionsModel.updateSeq(), Boolean.valueOf(false));
    assertEquals(postDesignDocsOptionsModel.endKey(), "testString");
    assertEquals(postDesignDocsOptionsModel.key(), "testString");
    assertEquals(postDesignDocsOptionsModel.keys(), java.util.Arrays.asList("testString"));
    assertEquals(postDesignDocsOptionsModel.startKey(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostDesignDocsOptionsError() throws Throwable {
    new PostDesignDocsOptions.Builder().build();
  }

}