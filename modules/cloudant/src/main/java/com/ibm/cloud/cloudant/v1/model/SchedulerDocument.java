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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a replication scheduler document.
 */
public class SchedulerDocument extends GenericModel {

  /**
   * Schema for replication state.
   */
  public interface State {
    /** initializing. */
    String INITIALIZING = "initializing";
    /** error. */
    String ERROR = "error";
    /** pending. */
    String PENDING = "pending";
    /** running. */
    String RUNNING = "running";
    /** crashing. */
    String CRASHING = "crashing";
    /** completed. */
    String COMPLETED = "completed";
    /** failed. */
    String FAILED = "failed";
  }

  protected String database;
  @SerializedName("doc_id")
  protected String docId;
  @SerializedName("error_count")
  protected Long errorCount;
  protected String id;
  protected SchedulerInfo info;
  @SerializedName("last_updated")
  protected Date lastUpdated;
  protected String node;
  protected String source;
  @SerializedName("source_proxy")
  protected String sourceProxy;
  @SerializedName("start_time")
  protected Date startTime;
  protected String state;
  protected String target;
  @SerializedName("target_proxy")
  protected String targetProxy;

  protected SchedulerDocument() { }

  /**
   * Gets the database.
   *
   * Database where replication document came from.
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
   * Gets the errorCount.
   *
   * Consecutive errors count. Indicates how many times in a row this replication has crashed. Replication will be
   * retried with an exponential backoff based on this number. As soon as the replication succeeds this count is reset
   * to 0. To can be used to get an idea why a particular replication is not making progress.
   *
   * @return the errorCount
   */
  public Long getErrorCount() {
    return errorCount;
  }

  /**
   * Gets the id.
   *
   * Replication ID, or null if state is completed or failed.
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
   * Gets the lastUpdated.
   *
   * Timestamp of last state update.
   *
   * @return the lastUpdated
   */
  public Date getLastUpdated() {
    return lastUpdated;
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
   * Gets the sourceProxy.
   *
   * Forbidden in IBM Cloudant mediated replications.
   *
   * Address of the (http or socks5 protocol) proxy server through which replication with the source database occurs.
   *
   * @return the sourceProxy
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String getSourceProxy() {
    return sourceProxy;
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
   * Gets the state.
   *
   * Schema for replication state.
   *
   * @return the state
   */
  public String getState() {
    return state;
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
   * Gets the targetProxy.
   *
   * Forbidden in IBM Cloudant mediated replications.
   *
   * Address of the (http or socks5 protocol) proxy server through which replication with the target database occurs.
   *
   * @return the targetProxy
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String getTargetProxy() {
    return targetProxy;
  }
}

