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
 * Information about database's partitioned indexes.
 */
public class PartitionedIndexesInformation extends GenericModel {

  protected Long count;
  protected PartitionedIndexesDetailedInformation indexes;
  protected Long limit;

  protected PartitionedIndexesInformation() { }

  /**
   * Gets the count.
   *
   * Total number of partitioned indexes in the database.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the indexes.
   *
   * Number of partitioned indexes by type.
   *
   * @return the indexes
   */
  public PartitionedIndexesDetailedInformation getIndexes() {
    return indexes;
  }

  /**
   * Gets the limit.
   *
   * Maximum allowed number of partitioned indexes in the database.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }
}

