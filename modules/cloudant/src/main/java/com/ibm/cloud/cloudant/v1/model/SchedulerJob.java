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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a replication scheduler job.
 */
public class SchedulerJob extends GenericModel {

  protected String database;
  @SerializedName("doc_id")
  protected String docId;
  protected List<SchedulerJobEvent> history;
  protected String id;
  protected SchedulerInfo info;
  protected String node;
  protected String pid;
  protected String source;
  @SerializedName("start_time")
  protected Date startTime;
  protected String target;
  protected String user;

  protected SchedulerJob() { }

  /**
   * Gets the database.
   *
   * Replication document database.
   *
   * @return the database
   */
  public String getDatabase() {
    return database;
  }

  /**
   * Gets the docId.
   *
   * Replication document ID.
   *
   * @return the docId
   */
  public String getDocId() {
    return docId;
  }

  /**
   * Gets the history.
   *
   * Timestamped history of events as a list of objects.
   *
   * @return the history
   */
  public List<SchedulerJobEvent> getHistory() {
    return history;
  }

  /**
   * Gets the id.
   *
   * Schema for a replication job id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the info.
   *
   * Schema for scheduler document information. A JSON object that may contain additional information about the state.
   * For error states this will contain an error field and string value.
   *
   * @return the info
   */
  public SchedulerInfo getInfo() {
    return info;
  }

  /**
   * Gets the node.
   *
   * Cluster node where the job is running.
   *
   * @return the node
   */
  public String getNode() {
    return node;
  }

  /**
   * Gets the pid.
   *
   * Replication process ID.
   *
   * @return the pid
   */
  public String getPid() {
    return pid;
  }

  /**
   * Gets the source.
   *
   * Replication source.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the startTime.
   *
   * Timestamp of when the replication was started.
   *
   * @return the startTime
   */
  public Date getStartTime() {
    return startTime;
  }

  /**
   * Gets the target.
   *
   * Replication target.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the user.
   *
   * Name of user running replication.
   *
   * @return the user
   */
  public String getUser() {
    return user;
  }
}

