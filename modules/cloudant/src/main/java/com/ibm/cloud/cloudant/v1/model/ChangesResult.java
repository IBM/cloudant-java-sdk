/*
 * (C) Copyright IBM Corp. 2020.
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
 * Schema for normal changes feed result.
 */
public class ChangesResult extends GenericModel {

  @SerializedName("last_seq")
  protected String lastSeq;
  protected Long pending;
  protected List<ChangesResultItem> results;

  /**
   * Gets the lastSeq.
   *
   * last_seq.
   *
   * @return the lastSeq
   */
  public String getLastSeq() {
    return lastSeq;
  }

  /**
   * Gets the pending.
   *
   * pending.
   *
   * @return the pending
   */
  public Long getPending() {
    return pending;
  }

  /**
   * Gets the results.
   *
   * results.
   *
   * @return the results
   */
  public List<ChangesResultItem> getResults() {
    return results;
  }
}

