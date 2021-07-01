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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a replication result.
 */
public class ReplicationResult extends GenericModel {

  protected List<ReplicationHistory> history;
  protected Boolean ok;
  @SerializedName("replication_id_version")
  protected Long replicationIdVersion;
  @SerializedName("session_id")
  protected String sessionId;
  @SerializedName("source_last_seq")
  protected String sourceLastSeq;

  /**
   * Gets the history.
   *
   * Replication history.
   *
   * @return the history
   */
  public List<ReplicationHistory> getHistory() {
    return history;
  }

  /**
   * Gets the ok.
   *
   * Replication status.
   *
   * @return the ok
   */
  public Boolean isOk() {
    return ok;
  }

  /**
   * Gets the replicationIdVersion.
   *
   * Replication protocol version.
   *
   * @return the replicationIdVersion
   */
  public Long getReplicationIdVersion() {
    return replicationIdVersion;
  }

  /**
   * Gets the sessionId.
   *
   * Unique session ID.
   *
   * @return the sessionId
   */
  public String getSessionId() {
    return sessionId;
  }

  /**
   * Gets the sourceLastSeq.
   *
   * Last sequence number read from source database.
   *
   * @return the sourceLastSeq
   */
  public String getSourceLastSeq() {
    return sourceLastSeq;
  }
}

