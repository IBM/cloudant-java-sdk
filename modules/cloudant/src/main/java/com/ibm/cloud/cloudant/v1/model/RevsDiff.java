/*
 * (C) Copyright IBM Corp. 2021.
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
 * Schema for information about missing revs and possible ancestors.
 */
public class RevsDiff extends GenericModel {

  protected List<String> missing;
  @SerializedName("possible_ancestors")
  protected List<String> possibleAncestors;

  /**
   * Gets the missing.
   *
   * List of missing revisions.
   *
   * @return the missing
   */
  public List<String> getMissing() {
    return missing;
  }

  /**
   * Gets the possibleAncestors.
   *
   * List of possible ancestor revisions.
   *
   * @return the possibleAncestors
   */
  public List<String> getPossibleAncestors() {
    return possibleAncestors;
  }
}

