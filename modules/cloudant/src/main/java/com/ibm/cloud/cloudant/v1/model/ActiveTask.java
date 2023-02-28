/*
 * (C) Copyright IBM Corp. 2023.
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

  /**
   * The phase the active task is in. `docid_sort`, `docid_copy`, `document_copy` phases are available for
   * `database_compaction`, while `ids` and `view` phases are available for `view_compaction` type tasks.
   */
  public interface Phase {
    /** docid_sort. */
    String DOCID_SORT = "docid_sort";
    /** docid_copy. */
    String DOCID_COPY = "docid_copy";
    /** document_copy. */
    String DOCUMENT_COPY = "document_copy";
    /** ids. */
    String IDS = "ids";
    /** view. */
    String VIEW = "view";
  }

  /**
   * Process status.
   */
  public interface ProcessStatus {
    /** exiting. */
    String EXITING = "exiting";
    /** garbage_collecting. */
    String GARBAGE_COLLECTING = "garbage_collecting";
    /** runnable. */
    String RUNNABLE = "runnable";
    /** running. */
    String RUNNING = "running";
    /** suspended. */
    String SUSPENDED = "suspended";
    /** waiting. */
    String WAITING = "waiting";
  }

  /**
   * Operation type.
   */
  public interface Type {
    /** database_compaction. */
    String DATABASE_COMPACTION = "database_compaction";
    /** indexer. */
    String INDEXER = "indexer";
    /** replication. */
    String REPLICATION = "replication";
    /** search_indexer. */
    String SEARCH_INDEXER = "search_indexer";
    /** view_compaction. */
    String VIEW_COMPACTION = "view_compaction";
  }

  @SerializedName("bulk_get_attempts")
  protected Long bulkGetAttempts;
  @SerializedName("bulk_get_docs")
  protected Long bulkGetDocs;
  @SerializedName("changes_done")
  protected Long changesDone;
  @SerializedName("changes_pending")
  protected Long changesPending;
  @SerializedName("checkpoint_interval")
  protected Long checkpointInterval;
  @SerializedName("checkpointed_source_seq")
  protected String checkpointedSourceSeq;
  protected Boolean continuous;
  protected String database;
  @SerializedName("design_document")
  protected String designDocument;
  @SerializedName("doc_id")
  protected String docId;
  @SerializedName("doc_write_failures")
  protected Long docWriteFailures;
  @SerializedName("docs_read")
  protected Long docsRead;
  @SerializedName("docs_written")
  protected Long docsWritten;
  protected String index;
  @SerializedName("indexer_pid")
  protected String indexerPid;
  @SerializedName("missing_revisions_found")
  protected Long missingRevisionsFound;
  protected String node;
  protected String phase;
  protected String pid;
  @SerializedName("process_status")
  protected String processStatus;
  protected Long progress;
  @SerializedName("replication_id")
  protected String replicationId;
  protected Boolean retry;
  @SerializedName("revisions_checked")
  protected Long revisionsChecked;
  protected String source;
  @SerializedName("source_seq")
  protected String sourceSeq;
  @SerializedName("started_on")
  protected Long startedOn;
  protected String target;
  @SerializedName("through_seq")
  protected String throughSeq;
  @SerializedName("total_changes")
  protected Long totalChanges;
  protected String type;
  @SerializedName("updated_on")
  protected Long updatedOn;
  protected String user;
  protected Long view;

  protected ActiveTask() { }

  /**
   * Gets the bulkGetAttempts.
   *
   * The total count of attempted doc revisions fetched with `_bulk_get`. Available for `replication` type tasks.
   *
   * @return the bulkGetAttempts
   */
  public Long getBulkGetAttempts() {
    return bulkGetAttempts;
  }

  /**
   * Gets the bulkGetDocs.
   *
   * The total count of successful docs fetched with `_bulk_get`. Available for `replication` type tasks.
   *
   * @return the bulkGetDocs
   */
  public Long getBulkGetDocs() {
    return bulkGetDocs;
  }

  /**
   * Gets the changesDone.
   *
   * Processed changes. Available for `database_compaction`, `indexer`, `search_indexer`, `view_compaction` type tasks.
   *
   * @return the changesDone
   */
  public Long getChangesDone() {
    return changesDone;
  }

  /**
   * Gets the changesPending.
   *
   * The count of changes not yet replicated. Available for `replication` type tasks.
   *
   * @return the changesPending
   */
  public Long getChangesPending() {
    return changesPending;
  }

  /**
   * Gets the checkpointInterval.
   *
   * Specifies the checkpoint interval in ms. Available for `replication` type tasks.
   *
   * @return the checkpointInterval
   */
  public Long getCheckpointInterval() {
    return checkpointInterval;
  }

  /**
   * Gets the checkpointedSourceSeq.
   *
   * The source sequence id which was last successfully replicated. Available for `replication` type tasks.
   *
   * @return the checkpointedSourceSeq
   */
  public String getCheckpointedSourceSeq() {
    return checkpointedSourceSeq;
  }

  /**
   * Gets the continuous.
   *
   * The replication configured to be continuous. Available for `replication` type tasks.
   *
   * @return the continuous
   */
  public Boolean isContinuous() {
    return continuous;
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
   * Gets the designDocument.
   *
   * The design document that belongs to this task. Available for `indexer`, `search_indexer`, `view_compaction` type
   * tasks.
   *
   * @return the designDocument
   */
  public String getDesignDocument() {
    return designDocument;
  }

  /**
   * Gets the docId.
   *
   * Replication document ID. Available for `replication` type tasks.
   *
   * @return the docId
   */
  public String getDocId() {
    return docId;
  }

  /**
   * Gets the docWriteFailures.
   *
   * Number of document write failures. Available for `replication` type tasks.
   *
   * @return the docWriteFailures
   */
  public Long getDocWriteFailures() {
    return docWriteFailures;
  }

  /**
   * Gets the docsRead.
   *
   * Number of documents read. Available for `replication` type tasks.
   *
   * @return the docsRead
   */
  public Long getDocsRead() {
    return docsRead;
  }

  /**
   * Gets the docsWritten.
   *
   * Number of documents written to target. Available for `replication` type tasks.
   *
   * @return the docsWritten
   */
  public Long getDocsWritten() {
    return docsWritten;
  }

  /**
   * Gets the index.
   *
   * The search index that belongs to this task. Available for `search_indexer` type tasks.
   *
   * @return the index
   */
  public String getIndex() {
    return index;
  }

  /**
   * Gets the indexerPid.
   *
   * Indexer process ID. Available for `indexer` type tasks.
   *
   * @return the indexerPid
   */
  public String getIndexerPid() {
    return indexerPid;
  }

  /**
   * Gets the missingRevisionsFound.
   *
   * The count of docs which have been read from the source. Available for `replication` type tasks.
   *
   * @return the missingRevisionsFound
   */
  public Long getMissingRevisionsFound() {
    return missingRevisionsFound;
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
   * Gets the phase.
   *
   * The phase the active task is in. `docid_sort`, `docid_copy`, `document_copy` phases are available for
   * `database_compaction`, while `ids` and `view` phases are available for `view_compaction` type tasks.
   *
   * @return the phase
   */
  public String getPhase() {
    return phase;
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
   * Gets the processStatus.
   *
   * Process status.
   *
   * @return the processStatus
   */
  public String getProcessStatus() {
    return processStatus;
  }

  /**
   * Gets the progress.
   *
   * Current percentage progress. Available for `database_compaction`, `indexer`, `search_indexer`, `view_compaction`
   * type tasks.
   *
   * @return the progress
   */
  public Long getProgress() {
    return progress;
  }

  /**
   * Gets the replicationId.
   *
   * Replication ID. Available for `replication` type tasks.
   *
   * @return the replicationId
   */
  public String getReplicationId() {
    return replicationId;
  }

  /**
   * Gets the retry.
   *
   * Indicates whether a compaction retry is currently running on the database. Available for `database_compaction` type
   * tasks.
   *
   * @return the retry
   */
  public Boolean isRetry() {
    return retry;
  }

  /**
   * Gets the revisionsChecked.
   *
   * The count of revisions which have been checked since this replication began. Available for `replication` type
   * tasks.
   *
   * @return the revisionsChecked
   */
  public Long getRevisionsChecked() {
    return revisionsChecked;
  }

  /**
   * Gets the source.
   *
   * Replication source. Available for `replication` type tasks.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the sourceSeq.
   *
   * The last sequence number obtained from the source database changes feed. Available for `replication` type tasks.
   *
   * @return the sourceSeq
   */
  public String getSourceSeq() {
    return sourceSeq;
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
   * Gets the target.
   *
   * Replication target. Available for `replication` type tasks.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the throughSeq.
   *
   * The last sequence number processed by the replicator. Available for `replication` type tasks.
   *
   * @return the throughSeq
   */
  public String getThroughSeq() {
    return throughSeq;
  }

  /**
   * Gets the totalChanges.
   *
   * Total changes to process. Available for `database_compaction`, `indexer`, `search_indexer`, `view_compaction` type
   * tasks.
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

  /**
   * Gets the user.
   *
   * Name of user running replication or owning the indexer. Available for `indexer`, `replication` type tasks.
   *
   * @return the user
   */
  public String getUser() {
    return user;
  }

  /**
   * Gets the view.
   *
   * Number of view indexes. Available for `view_compaction` type tasks.
   *
   * @return the view
   */
  public Long getView() {
    return view;
  }
}

