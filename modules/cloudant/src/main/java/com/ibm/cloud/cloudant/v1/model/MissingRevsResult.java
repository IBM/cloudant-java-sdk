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
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for mapping document IDs to lists of missing revisions.
 */
public class MissingRevsResult extends GenericModel {

  @SerializedName("missing_revs")
  protected Map<String, List<String>> missingRevs;

  /**
   * Gets the missingRevs.
   *
   * Schema for mapping document IDs to lists of revisions.
   *
   * @return the missingRevs
   */
  public Map<String, List<String>> getMissingRevs() {
    return missingRevs;
  }
}

