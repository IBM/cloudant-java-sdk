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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The count breakdown of partitioned indexes.
 */
public class PartitionInformationIndexesIndexes extends GenericModel {

  protected Long search;
  protected Long view;

  protected PartitionInformationIndexesIndexes() { }

  /**
   * Gets the search.
   *
   * Number of partitioned search indexes.
   *
   * @return the search
   */
  public Long getSearch() {
    return search;
  }

  /**
   * Gets the view.
   *
   * Number of partitioned view indexes.
   *
   * @return the view
   */
  public Long getView() {
    return view;
  }
}

