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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Arguments passed to the underlying view.
 */
public class ExplainResultMrArgs extends GenericModel {

  /**
   * Direction parameter passed to the underlying view.
   */
  public interface Direction {
    /** fwd. */
    String FWD = "fwd";
    /** rev. */
    String REV = "rev";
  }

  /**
   * The type of the underlying view.
   */
  public interface ViewType {
    /** map. */
    String MAP = "map";
    /** reduce. */
    String REDUCE = "reduce";
  }

  protected Object conflicts;
  protected String direction;
  @SerializedName("end_key")
  protected Object endKey;
  @SerializedName("include_docs")
  protected Boolean includeDocs;
  protected String partition;
  protected Boolean reduce;
  protected Boolean stable;
  @SerializedName("start_key")
  protected Object startKey;
  protected Object update;
  @SerializedName("view_type")
  protected String viewType;

  protected ExplainResultMrArgs() { }

  /**
   * Gets the conflicts.
   *
   * Schema for any JSON type.
   *
   * @return the conflicts
   */
  public Object getConflicts() {
    return conflicts;
  }

  /**
   * Gets the direction.
   *
   * Direction parameter passed to the underlying view.
   *
   * @return the direction
   */
  public String getDirection() {
    return direction;
  }

  /**
   * Gets the endKey.
   *
   * Schema for any JSON type.
   *
   * @return the endKey
   */
  public Object getEndKey() {
    return endKey;
  }

  /**
   * Gets the includeDocs.
   *
   * A parameter that specifies whether to include the full content of the documents in the response in the underlying
   * view.
   *
   * @return the includeDocs
   */
  public Boolean isIncludeDocs() {
    return includeDocs;
  }

  /**
   * Gets the partition.
   *
   * Partition parameter passed to the underlying view.
   *
   * @return the partition
   */
  public String getPartition() {
    return partition;
  }

  /**
   * Gets the reduce.
   *
   * A parameter that specifies returning only documents that match any of the specified keys in the underlying view.
   *
   * @return the reduce
   */
  public Boolean isReduce() {
    return reduce;
  }

  /**
   * Gets the stable.
   *
   * A parameter that specifies whether the view results should be returned form a "stable" set of shards passed to the
   * underlying view.
   *
   * @return the stable
   */
  public Boolean isStable() {
    return stable;
  }

  /**
   * Gets the startKey.
   *
   * Schema for any JSON type.
   *
   * @return the startKey
   */
  public Object getStartKey() {
    return startKey;
  }

  /**
   * Gets the update.
   *
   * Schema for any JSON type.
   *
   * @return the update
   */
  public Object getUpdate() {
    return update;
  }

  /**
   * Gets the viewType.
   *
   * The type of the underlying view.
   *
   * @return the viewType
   */
  public String getViewType() {
    return viewType;
  }
}

