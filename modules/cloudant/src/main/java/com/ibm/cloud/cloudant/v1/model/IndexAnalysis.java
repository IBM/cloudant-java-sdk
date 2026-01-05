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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for detailed explanation of why the specific index was excluded by the query planner.
 */
public class IndexAnalysis extends GenericModel {

  protected Boolean covering;
  protected Long ranking;
  protected List<IndexAnalysisExclusionReason> reasons;
  protected Boolean usable;

  protected IndexAnalysis() { }

  /**
   * Gets the covering.
   *
   * When `true`, the query is answered using the index only and no documents are fetched.
   *
   * @return the covering
   */
  public Boolean isCovering() {
    return covering;
  }

  /**
   * Gets the ranking.
   *
   * A position of the unused index based on its potential relevance to the query.
   *
   * @return the ranking
   */
  public Long getRanking() {
    return ranking;
  }

  /**
   * Gets the reasons.
   *
   * A list of reasons explaining why index was not chosen for the query.
   *
   * @return the reasons
   */
  public List<IndexAnalysisExclusionReason> getReasons() {
    return reasons;
  }

  /**
   * Gets the usable.
   *
   * Indicates whether an index can still be used for the query.
   *
   * @return the usable
   */
  public Boolean isUsable() {
    return usable;
  }
}

