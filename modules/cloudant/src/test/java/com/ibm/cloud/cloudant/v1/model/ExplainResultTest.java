/*
 * (C) Copyright IBM Corp. 2025.
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

import com.ibm.cloud.cloudant.v1.model.Analyzer;
import com.ibm.cloud.cloudant.v1.model.ExplainResult;
import com.ibm.cloud.cloudant.v1.model.ExplainResultMrArgs;
import com.ibm.cloud.cloudant.v1.model.ExplainResultOpts;
import com.ibm.cloud.cloudant.v1.model.IndexAnalysis;
import com.ibm.cloud.cloudant.v1.model.IndexAnalysisExclusionReason;
import com.ibm.cloud.cloudant.v1.model.IndexCandidate;
import com.ibm.cloud.cloudant.v1.model.IndexDefinition;
import com.ibm.cloud.cloudant.v1.model.IndexField;
import com.ibm.cloud.cloudant.v1.model.IndexInformation;
import com.ibm.cloud.cloudant.v1.model.IndexTextOperatorDefaultField;
import com.ibm.cloud.cloudant.v1.model.SelectorHint;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ExplainResult model.
 */
public class ExplainResultTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testExplainResult() throws Throwable {
    ExplainResult explainResultModel = new ExplainResult();
    assertNull(explainResultModel.isCovering());
    assertNull(explainResultModel.getDbname());
    assertNull(explainResultModel.getFields());
    assertNull(explainResultModel.getIndex());
    assertNull(explainResultModel.getIndexCandidates());
    assertNull(explainResultModel.getLimit());
    assertNull(explainResultModel.getMrargs());
    assertNull(explainResultModel.getOpts());
    assertNull(explainResultModel.getPartitioned());
    assertNull(explainResultModel.getSelector());
    assertNull(explainResultModel.getSelectorHints());
    assertNull(explainResultModel.getSkip());
  }
}