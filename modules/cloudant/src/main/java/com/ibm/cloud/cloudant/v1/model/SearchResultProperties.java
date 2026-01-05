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
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for the result of a query search operation.
 */
public class SearchResultProperties extends GenericModel {

  @SerializedName("total_rows")
  protected Long totalRows;
  protected String bookmark;
  protected String by;
  protected Map<String, Map<String, Long>> counts;
  protected Map<String, Map<String, Long>> ranges;
  protected List<SearchResultRow> rows;

  protected SearchResultProperties() { }

  /**
   * Gets the totalRows.
   *
   * Total number of rows in the index matching the search query. The limit may truncate the number of matches returned.
   *
   * @return the totalRows
   */
  public Long getTotalRows() {
    return totalRows;
  }

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
   * Gets the by.
   *
   * Grouped search matches.
   *
   * @return the by
   */
  public String getBy() {
    return by;
  }

  /**
   * Gets the counts.
   *
   * The counts facet syntax returns the number of query results for each unique value of each named field.
   *
   * @return the counts
   */
  public Map<String, Map<String, Long>> getCounts() {
    return counts;
  }

  /**
   * Gets the ranges.
   *
   * The range facet syntax reuses the standard Lucene syntax for ranges to return counts of results that fit into each
   * specified category.
   *
   * @return the ranges
   */
  public Map<String, Map<String, Long>> getRanges() {
    return ranges;
  }

  /**
   * Gets the rows.
   *
   * Array of row objects.
   *
   * @return the rows
   */
  public List<SearchResultRow> getRows() {
    return rows;
  }
}

