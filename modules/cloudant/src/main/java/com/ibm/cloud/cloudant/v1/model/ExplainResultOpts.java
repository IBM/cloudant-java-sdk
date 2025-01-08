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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Options used for the request.
 */
public class ExplainResultOpts extends GenericModel {

  protected String bookmark;
  protected Boolean conflicts;
  @SerializedName("execution_stats")
  protected Boolean executionStats;
  protected List<String> fields;
  protected Long limit;
  protected String partition;
  protected Long r;
  protected Long skip;
  protected Object sort;
  protected Boolean stable;
  protected Boolean stale;
  protected Boolean update;
  @SerializedName("use_index")
  protected List<String> useIndex;

  protected ExplainResultOpts() { }

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
   * Gets the conflicts.
   *
   * Conflicts used in the request query.
   *
   * @return the conflicts
   */
  public Boolean isConflicts() {
    return conflicts;
  }

  /**
   * Gets the executionStats.
   *
   * Execution statistics used in the request query.
   *
   * @return the executionStats
   */
  public Boolean isExecutionStats() {
    return executionStats;
  }

  /**
   * Gets the fields.
   *
   * JSON array that uses the field syntax. Use this parameter to specify which fields of a document must be returned.
   * If it is omitted or empty, the entire document is returned.
   *
   * @return the fields
   */
  public List<String> getFields() {
    return fields;
  }

  /**
   * Gets the limit.
   *
   * Limit used in the request query.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the partition.
   *
   * On which database partition the request was used. If it was not used on a database partition, it returns with `""`.
   *
   * @return the partition
   */
  public String getPartition() {
    return partition;
  }

  /**
   * Gets the r.
   *
   * The read quorum that is needed for the result.
   *
   * @return the r
   */
  public Long getR() {
    return r;
  }

  /**
   * Gets the skip.
   *
   * Skip used in the request query.
   *
   * @return the skip
   */
  public Long getSkip() {
    return skip;
  }

  /**
   * Gets the sort.
   *
   * Schema for any JSON type.
   *
   * @return the sort
   */
  public Object getSort() {
    return sort;
  }

  /**
   * Gets the stable.
   *
   * Stable used in the request query.
   *
   * @return the stable
   */
  public Boolean isStable() {
    return stable;
  }

  /**
   * Gets the stale.
   *
   * Stale used in the request query.
   *
   * @return the stale
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Boolean isStale() {
    return stale;
  }

  /**
   * Gets the update.
   *
   * Update used in the request query.
   *
   * @return the update
   */
  public Boolean isUpdate() {
    return update;
  }

  /**
   * Gets the useIndex.
   *
   * Use index used in the request query.
   *
   * @return the useIndex
   */
  public List<String> getUseIndex() {
    return useIndex;
  }
}

