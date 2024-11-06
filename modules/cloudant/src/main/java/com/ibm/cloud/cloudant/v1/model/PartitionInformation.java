/*
 * (C) Copyright IBM Corp. 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about a database partition.
 */
public class PartitionInformation extends GenericModel {

  @SerializedName("db_name")
  protected String dbName;
  @SerializedName("doc_count")
  protected Long docCount;
  @SerializedName("doc_del_count")
  protected Long docDelCount;
  protected String partition;
  @SerializedName("partitioned_indexes")
  protected PartitionInformationIndexes partitionedIndexes;
  protected PartitionInformationSizes sizes;

  protected PartitionInformation() { }

  /**
   * Gets the dbName.
   *
   * Schema for a database name.
   *
   * @return the dbName
   */
  public String getDbName() {
    return dbName;
  }

  /**
   * Gets the docCount.
   *
   * A count of the documents in the specified database partition.
   *
   * @return the docCount
   */
  public Long getDocCount() {
    return docCount;
  }

  /**
   * Gets the docDelCount.
   *
   * Number of deleted documents.
   *
   * @return the docDelCount
   */
  public Long getDocDelCount() {
    return docDelCount;
  }

  /**
   * Gets the partition.
   *
   * Schema for a partition key.
   *
   * @return the partition
   */
  public String getPartition() {
    return partition;
  }

  /**
   * Gets the partitionedIndexes.
   *
   * Schema for information about the partition index count and limit in a database.
   *
   * @return the partitionedIndexes
   */
  public PartitionInformationIndexes getPartitionedIndexes() {
    return partitionedIndexes;
  }

  /**
   * Gets the sizes.
   *
   * The size of active and external data, in bytes.
   *
   * @return the sizes
   */
  public PartitionInformationSizes getSizes() {
    return sizes;
  }
}

