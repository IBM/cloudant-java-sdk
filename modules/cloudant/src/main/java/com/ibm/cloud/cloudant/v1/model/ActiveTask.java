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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about a running task.
 */
public class ActiveTask extends GenericModel {

  @SerializedName("changes_done")
  protected Long changesDone;
  protected String database;
  protected String node;
  protected String pid;
  protected Long progress;
  @SerializedName("started_on")
  protected Long startedOn;
  protected String status;
  protected String task;
  @SerializedName("total_changes")
  protected Long totalChanges;
  protected String type;
  @SerializedName("updated_on")
  protected Long updatedOn;

  /**
   * Gets the changesDone.
   *
   * Processed changes.
   *
   * @return the changesDone
   */
  public Long getChangesDone() {
    return changesDone;
  }

  /**
   * Gets the database.
   *
   * Source database.
   *
   * @return the database
   */
  public String getDatabase() {
    return database;
  }

  /**
   * Gets the node.
   *
   * Cluster node where the task is running.
   *
   * @return the node
   */
  public String getNode() {
    return node;
  }

  /**
   * Gets the pid.
   *
   * Process ID.
   *
   * @return the pid
   */
  public String getPid() {
    return pid;
  }

  /**
   * Gets the progress.
   *
   * Current percentage progress.
   *
   * @return the progress
   */
  public Long getProgress() {
    return progress;
  }

  /**
   * Gets the startedOn.
   *
   * Schema for a Unix epoch timestamp.
   *
   * @return the startedOn
   */
  public Long getStartedOn() {
    return startedOn;
  }

  /**
   * Gets the status.
   *
   * Task status message.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the task.
   *
   * Task name.
   *
   * @return the task
   */
  public String getTask() {
    return task;
  }

  /**
   * Gets the totalChanges.
   *
   * Total changes to process.
   *
   * @return the totalChanges
   */
  public Long getTotalChanges() {
    return totalChanges;
  }

  /**
   * Gets the type.
   *
   * Operation type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the updatedOn.
   *
   * Schema for a Unix epoch timestamp.
   *
   * @return the updatedOn
   */
  public Long getUpdatedOn() {
    return updatedOn;
  }
}

