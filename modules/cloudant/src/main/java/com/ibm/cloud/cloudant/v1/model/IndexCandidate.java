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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for an index that was not chosen for serving the query with the reason for the exclusion.
 */
public class IndexCandidate extends GenericModel {

  protected IndexAnalysis analysis;
  protected IndexInformation index;

  protected IndexCandidate() { }

  /**
   * Gets the analysis.
   *
   * Schema for detailed explanation of why the specific index was excluded by the query planner.
   *
   * @return the analysis
   */
  public IndexAnalysis getAnalysis() {
    return analysis;
  }

  /**
   * Gets the index.
   *
   * Schema for information about an index.
   *
   * @return the index
   */
  public IndexInformation getIndex() {
    return index;
  }
}

