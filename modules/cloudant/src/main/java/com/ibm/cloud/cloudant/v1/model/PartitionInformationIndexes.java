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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about the partition index count and limit in a database.
 */
public class PartitionInformationIndexes extends GenericModel {

  protected Long count;
  protected PartitionInformationIndexesIndexes indexes;
  protected Long limit;

  /**
   * Gets the count.
   *
   * Total count of the partitioned indexes.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the indexes.
   *
   * The count breakdown of partitioned indexes.
   *
   * @return the indexes
   */
  public PartitionInformationIndexesIndexes getIndexes() {
    return indexes;
  }

  /**
   * Gets the limit.
   *
   * The partitioned index limit.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }
}

