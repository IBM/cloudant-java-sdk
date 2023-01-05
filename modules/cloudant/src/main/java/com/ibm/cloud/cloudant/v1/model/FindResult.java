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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for the result of a query find operation.
 */
public class FindResult extends GenericModel {

  protected String bookmark;
  protected List<Document> docs;
  @SerializedName("execution_stats")
  protected ExecutionStats executionStats;
  protected String warning;

  protected FindResult() { }

  /**
   * Gets the bookmark.
   *
   * Opaque bookmark token used when paginating results.
   *
   * @return the bookmark
   */
  public String getBookmark() {
    return bookmark;
  }

  /**
   * Gets the docs.
   *
   * Documents matching the selector.
   *
   * @return the docs
   */
  public List<Document> getDocs() {
    return docs;
  }

  /**
   * Gets the executionStats.
   *
   * Schema for find query execution statistics.
   *
   * @return the executionStats
   */
  public ExecutionStats getExecutionStats() {
    return executionStats;
  }

  /**
   * Gets the warning.
   *
   * warning.
   *
   * @return the warning
   */
  public String getWarning() {
    return warning;
  }
}

