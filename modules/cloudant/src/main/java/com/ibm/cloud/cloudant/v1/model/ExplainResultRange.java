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
 * Range parameters passed to the underlying view.
 */
public class ExplainResultRange extends GenericModel {

  @SerializedName("end_key")
  protected List<Object> endKey;
  @SerializedName("start_key")
  protected List<Object> startKey;

  protected ExplainResultRange() { }

  /**
   * Gets the endKey.
   *
   * End key parameter passed to the underlying view.
   *
   * @return the endKey
   */
  public List<Object> getEndKey() {
    return endKey;
  }

  /**
   * Gets the startKey.
   *
   * Start key parameter passed to the underlying view.
   *
   * @return the startKey
   */
  public List<Object> getStartKey() {
    return startKey;
  }
}

