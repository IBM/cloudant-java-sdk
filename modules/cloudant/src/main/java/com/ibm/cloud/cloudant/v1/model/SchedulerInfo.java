/*
 * (C) Copyright IBM Corp. 2022.
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
 * Schema for scheduler document information. A JSON object that may contain additional information about the state. For
 * error states this will contain an error field and string value.
 */
public class SchedulerInfo extends GenericModel {

  @SerializedName("changes_pending")
  protected Long changesPending;
  @SerializedName("checkpointed_source_seq")
  protected String checkpointedSourceSeq;
  @SerializedName("doc_write_failures")
  protected Long docWriteFailures;
  @SerializedName("docs_read")
  protected Long docsRead;
  @SerializedName("docs_written")
  protected Long docsWritten;
  protected String error;
  @SerializedName("missing_revisions_found")
  protected Long missingRevisionsFound;
  @SerializedName("revisions_checked")
  protected Long revisionsChecked;
  @SerializedName("source_seq")
  protected String sourceSeq;
  @SerializedName("through_seq")
  protected String throughSeq;

  /**
   * Gets the changesPending.
   *
   * The count of changes not yet replicated.
   *
   * @return the changesPending
   */
  public Long getChangesPending() {
    return changesPending;
  }

  /**
   * Gets the checkpointedSourceSeq.
   *
   * The source sequence id which was last successfully replicated.
   *
   * @return the checkpointedSourceSeq
   */
  public String getCheckpointedSourceSeq() {
    return checkpointedSourceSeq;
  }

  /**
   * Gets the docWriteFailures.
   *
   * The count of docs which failed to be written to the target.
   *
   * @return the docWriteFailures
   */
  public Long getDocWriteFailures() {
    return docWriteFailures;
  }

  /**
   * Gets the docsRead.
   *
   * The count of docs which have been read from the source.
   *
   * @return the docsRead
   */
  public Long getDocsRead() {
    return docsRead;
  }

  /**
   * Gets the docsWritten.
   *
   * The count of docs which have been written to the target.
   *
   * @return the docsWritten
   */
  public Long getDocsWritten() {
    return docsWritten;
  }

  /**
   * Gets the error.
   *
   * Replication error message.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Gets the missingRevisionsFound.
   *
   * The count of revisions which were found on the source, but missing from the target.
   *
   * @return the missingRevisionsFound
   */
  public Long getMissingRevisionsFound() {
    return missingRevisionsFound;
  }

  /**
   * Gets the revisionsChecked.
   *
   * The count of revisions which have been checked since this replication began.
   *
   * @return the revisionsChecked
   */
  public Long getRevisionsChecked() {
    return revisionsChecked;
  }

  /**
   * Gets the sourceSeq.
   *
   * The last sequence number obtained from the source database changes feed.
   *
   * @return the sourceSeq
   */
  public String getSourceSeq() {
    return sourceSeq;
  }

  /**
   * Gets the throughSeq.
   *
   * The last sequence number processed by the replicator.
   *
   * @return the throughSeq
   */
  public String getThroughSeq() {
    return throughSeq;
  }
}

