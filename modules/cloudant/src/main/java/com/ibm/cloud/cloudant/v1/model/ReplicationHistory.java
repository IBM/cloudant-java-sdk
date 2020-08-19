/*
 * (C) Copyright IBM Corp. 2020.
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
 * Schema for replication history information.
 */
public class ReplicationHistory extends GenericModel {

  @SerializedName("doc_write_failures")
  protected Long docWriteFailures;
  @SerializedName("docs_read")
  protected Long docsRead;
  @SerializedName("docs_written")
  protected Long docsWritten;
  @SerializedName("end_last_seq")
  protected String endLastSeq;
  @SerializedName("end_time")
  protected String endTime;
  @SerializedName("missing_checked")
  protected Long missingChecked;
  @SerializedName("missing_found")
  protected Long missingFound;
  @SerializedName("recorded_seq")
  protected String recordedSeq;
  @SerializedName("session_id")
  protected String sessionId;
  @SerializedName("start_last_seq")
  protected String startLastSeq;
  @SerializedName("start_time")
  protected String startTime;

  /**
   * Gets the docWriteFailures.
   *
   * Number of document write failures.
   *
   * @return the docWriteFailures
   */
  public Long getDocWriteFailures() {
    return docWriteFailures;
  }

  /**
   * Gets the docsRead.
   *
   * Number of documents read.
   *
   * @return the docsRead
   */
  public Long getDocsRead() {
    return docsRead;
  }

  /**
   * Gets the docsWritten.
   *
   * Number of documents written to target.
   *
   * @return the docsWritten
   */
  public Long getDocsWritten() {
    return docsWritten;
  }

  /**
   * Gets the endLastSeq.
   *
   * Last sequence number in changes stream.
   *
   * @return the endLastSeq
   */
  public String getEndLastSeq() {
    return endLastSeq;
  }

  /**
   * Gets the endTime.
   *
   * Date/Time replication operation completed in RFC 2822 format.
   *
   * @return the endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * Gets the missingChecked.
   *
   * Number of missing documents checked.
   *
   * @return the missingChecked
   */
  public Long getMissingChecked() {
    return missingChecked;
  }

  /**
   * Gets the missingFound.
   *
   * Number of missing documents found.
   *
   * @return the missingFound
   */
  public Long getMissingFound() {
    return missingFound;
  }

  /**
   * Gets the recordedSeq.
   *
   * Last recorded sequence number.
   *
   * @return the recordedSeq
   */
  public String getRecordedSeq() {
    return recordedSeq;
  }

  /**
   * Gets the sessionId.
   *
   * Session ID for this replication operation.
   *
   * @return the sessionId
   */
  public String getSessionId() {
    return sessionId;
  }

  /**
   * Gets the startLastSeq.
   *
   * First sequence number in changes stream.
   *
   * @return the startLastSeq
   */
  public String getStartLastSeq() {
    return startLastSeq;
  }

  /**
   * Gets the startTime.
   *
   * Date/Time replication operation started in RFC 2822 format.
   *
   * @return the startTime
   */
  public String getStartTime() {
    return startTime;
  }
}

