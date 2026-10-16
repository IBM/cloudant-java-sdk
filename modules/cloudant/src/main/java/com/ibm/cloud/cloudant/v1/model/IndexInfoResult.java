/*
 * (C) Copyright IBM Corp. 2026.
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
 * Schema for the result of an _index_info request.
 */
public class IndexInfoResult extends GenericModel {

  protected String bookmark;
  @SerializedName("search_indexes")
  protected List<SearchIndexInformation> searchIndexes;
  @SerializedName("total_rows")
  protected Long totalRows;
  @SerializedName("view_indexes")
  protected List<ViewIndexInformation> viewIndexes;

  protected IndexInfoResult() { }

  /**
   * Gets the bookmark.
   *
   * The ID of the first design document after the current page of results. Pass this value as `start_key` to retrieve
   * the next page. This field is `null` when no more design documents are available, or when the request includes a
   * `keys` parameter.
   *
   * @return the bookmark
   */
  public String getBookmark() {
    return bookmark;
  }

  /**
   * Gets the searchIndexes.
   *
   * The status of each search index across the design documents in the current page of results.
   *
   * @return the searchIndexes
   */
  public List<SearchIndexInformation> getSearchIndexes() {
    return searchIndexes;
  }

  /**
   * Gets the totalRows.
   *
   * The total number of design documents in the database. A design document can contain multiple indexes.
   *
   * @return the totalRows
   */
  public Long getTotalRows() {
    return totalRows;
  }

  /**
   * Gets the viewIndexes.
   *
   * The view index status for each design document in the current page of results.
   *
   * @return the viewIndexes
   */
  public List<ViewIndexInformation> getViewIndexes() {
    return viewIndexes;
  }
}

