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
 * Schema for information about a database.
 */
public class DatabaseInformation extends GenericModel {

  protected DatabaseInformationCluster cluster;
  @SerializedName("committed_update_seq")
  protected String committedUpdateSeq;
  @SerializedName("compact_running")
  protected Boolean compactRunning;
  @SerializedName("compacted_seq")
  protected String compactedSeq;
  @SerializedName("db_name")
  protected String dbName;
  @SerializedName("disk_format_version")
  protected Long diskFormatVersion;
  @SerializedName("doc_count")
  protected Long docCount;
  @SerializedName("doc_del_count")
  protected Long docDelCount;
  protected String engine;
  @SerializedName("instance_start_time")
  protected String instanceStartTime;
  protected DatabaseInformationProps props;
  protected ContentInformationSizes sizes;
  @SerializedName("update_seq")
  protected String updateSeq;
  protected String uuid;
  @SerializedName("partitioned_indexes")
  protected PartitionedIndexesInformation partitionedIndexes;

  protected DatabaseInformation() { }

  /**
   * Gets the cluster.
   *
   * Schema for database cluster information.
   *
   * @return the cluster
   */
  public DatabaseInformationCluster getCluster() {
    return cluster;
  }

  /**
   * Gets the committedUpdateSeq.
   *
   * An opaque string that describes the committed state of the database.
   *
   * @return the committedUpdateSeq
   */
  public String getCommittedUpdateSeq() {
    return committedUpdateSeq;
  }

  /**
   * Gets the compactRunning.
   *
   * True if the database compaction routine is operating on this database.
   *
   * @return the compactRunning
   */
  public Boolean isCompactRunning() {
    return compactRunning;
  }

  /**
   * Gets the compactedSeq.
   *
   * An opaque string that describes the compaction state of the database.
   *
   * @return the compactedSeq
   */
  public String getCompactedSeq() {
    return compactedSeq;
  }

  /**
   * Gets the dbName.
   *
   * The name of the database.
   *
   * @return the dbName
   */
  public String getDbName() {
    return dbName;
  }

  /**
   * Gets the diskFormatVersion.
   *
   * The version of the physical format used for the data when it is stored on disk.
   *
   * @return the diskFormatVersion
   */
  public Long getDiskFormatVersion() {
    return diskFormatVersion;
  }

  /**
   * Gets the docCount.
   *
   * A count of the documents in the specified database.
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
   * Gets the engine.
   *
   * The engine used for the database.
   *
   * @return the engine
   */
  public String getEngine() {
    return engine;
  }

  /**
   * Gets the instanceStartTime.
   *
   * An opaque string to detect whether a database has been recreated. The field name is for compatibility with old
   * replicator versions. Do not use the value to infer timing infromation. Typically only used by replicators.
   *
   * @return the instanceStartTime
   */
  public String getInstanceStartTime() {
    return instanceStartTime;
  }

  /**
   * Gets the props.
   *
   * Schema for database properties.
   *
   * @return the props
   */
  public DatabaseInformationProps getProps() {
    return props;
  }

  /**
   * Gets the sizes.
   *
   * Schema for size information of content.
   *
   * @return the sizes
   */
  public ContentInformationSizes getSizes() {
    return sizes;
  }

  /**
   * Gets the updateSeq.
   *
   * An opaque string that describes the state of the database. Do not rely on this string for counting the number of
   * updates.
   *
   * @return the updateSeq
   */
  public String getUpdateSeq() {
    return updateSeq;
  }

  /**
   * Gets the uuid.
   *
   * The UUID of the database.
   *
   * @return the uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * Gets the partitionedIndexes.
   *
   * Information about database's partitioned indexes.
   *
   * @return the partitionedIndexes
   */
  public PartitionedIndexesInformation getPartitionedIndexes() {
    return partitionedIndexes;
  }
}

