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

import com.ibm.cloud.cloudant.v1.model.ActiveTask;
import com.ibm.cloud.cloudant.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ActiveTask model.
 */
public class ActiveTaskTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testActiveTask() throws Throwable {
    ActiveTask activeTaskModel = new ActiveTask();
    assertNull(activeTaskModel.getBulkGetAttempts());
    assertNull(activeTaskModel.getBulkGetDocs());
    assertNull(activeTaskModel.getChangesDone());
    assertNull(activeTaskModel.getChangesPending());
    assertNull(activeTaskModel.getCheckpointInterval());
    assertNull(activeTaskModel.getCheckpointedSourceSeq());
    assertNull(activeTaskModel.isContinuous());
    assertNull(activeTaskModel.getDatabase());
    assertNull(activeTaskModel.getDesignDocument());
    assertNull(activeTaskModel.getDocId());
    assertNull(activeTaskModel.getDocWriteFailures());
    assertNull(activeTaskModel.getDocsRead());
    assertNull(activeTaskModel.getDocsWritten());
    assertNull(activeTaskModel.getIndex());
    assertNull(activeTaskModel.getIndexerPid());
    assertNull(activeTaskModel.getMissingRevisionsFound());
    assertNull(activeTaskModel.getNode());
    assertNull(activeTaskModel.getPhase());
    assertNull(activeTaskModel.getPid());
    assertNull(activeTaskModel.getProcessStatus());
    assertNull(activeTaskModel.getProgress());
    assertNull(activeTaskModel.getReplicationId());
    assertNull(activeTaskModel.isRetry());
    assertNull(activeTaskModel.getRevisionsChecked());
    assertNull(activeTaskModel.getSource());
    assertNull(activeTaskModel.getSourceSeq());
    assertNull(activeTaskModel.getStartedOn());
    assertNull(activeTaskModel.getTarget());
    assertNull(activeTaskModel.getThroughSeq());
    assertNull(activeTaskModel.getTotalChanges());
    assertNull(activeTaskModel.getType());
    assertNull(activeTaskModel.getUpdatedOn());
    assertNull(activeTaskModel.getUser());
    assertNull(activeTaskModel.getView());
  }
}