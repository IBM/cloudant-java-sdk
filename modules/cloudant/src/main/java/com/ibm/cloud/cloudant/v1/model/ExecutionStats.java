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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for find query execution statistics.
 */
public class ExecutionStats extends GenericModel {

  @SerializedName("execution_time_ms")
  protected Double executionTimeMs;
  @SerializedName("results_returned")
  protected Long resultsReturned;
  @SerializedName("total_docs_examined")
  protected Long totalDocsExamined;
  @SerializedName("total_keys_examined")
  protected Long totalKeysExamined;
  @SerializedName("total_quorum_docs_examined")
  protected Long totalQuorumDocsExamined;

  /**
   * Gets the executionTimeMs.
   *
   * Time to execute the query.
   *
   * @return the executionTimeMs
   */
  public Double getExecutionTimeMs() {
    return executionTimeMs;
  }

  /**
   * Gets the resultsReturned.
   *
   * Number of results returned.
   *
   * @return the resultsReturned
   */
  public Long getResultsReturned() {
    return resultsReturned;
  }

  /**
   * Gets the totalDocsExamined.
   *
   * Number of documents fetched from the index.
   *
   * @return the totalDocsExamined
   */
  public Long getTotalDocsExamined() {
    return totalDocsExamined;
  }

  /**
   * Gets the totalKeysExamined.
   *
   * Number of rows scanned in the index.
   *
   * @return the totalKeysExamined
   */
  public Long getTotalKeysExamined() {
    return totalKeysExamined;
  }

  /**
   * Gets the totalQuorumDocsExamined.
   *
   * Number of documents fetched from the primary index with the specified read quorum.
   *
   * @return the totalQuorumDocsExamined
   */
  public Long getTotalQuorumDocsExamined() {
    return totalQuorumDocsExamined;
  }
}

