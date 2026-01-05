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
 * Schema for the result of an all documents operation.
 */
public class AllDocsResult extends GenericModel {

  @SerializedName("total_rows")
  protected Long totalRows;
  protected List<DocsResultRow> rows;
  @SerializedName("update_seq")
  protected String updateSeq;

  protected AllDocsResult() { }

  /**
   * Gets the totalRows.
   *
   * Total number of document results.
   *
   * @return the totalRows
   */
  public Long getTotalRows() {
    return totalRows;
  }

  /**
   * Gets the rows.
   *
   * List of doc results.
   *
   * @return the rows
   */
  public List<DocsResultRow> getRows() {
    return rows;
  }

  /**
   * Gets the updateSeq.
   *
   * Current update sequence for the database.
   *
   * @return the updateSeq
   */
  public String getUpdateSeq() {
    return updateSeq;
  }
}

