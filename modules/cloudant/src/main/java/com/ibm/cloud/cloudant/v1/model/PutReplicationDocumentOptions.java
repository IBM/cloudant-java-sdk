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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The putReplicationDocument options.
 */
public class PutReplicationDocumentOptions extends GenericModel {

  /**
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   */
  public interface Batch {
    /** ok. */
    String OK = "ok";
  }

  protected String docId;
  protected ReplicationDocument replicationDocument;
  protected String ifMatch;
  protected String batch;
  protected Boolean newEdits;
  protected String rev;

  /**
   * Builder.
   */
  public static class Builder {
    private String docId;
    private ReplicationDocument replicationDocument;
    private String ifMatch;
    private String batch;
    private Boolean newEdits;
    private String rev;

    /**
     * Instantiates a new Builder from an existing PutReplicationDocumentOptions instance.
     *
     * @param putReplicationDocumentOptions the instance to initialize the Builder with
     */
    private Builder(PutReplicationDocumentOptions putReplicationDocumentOptions) {
      this.docId = putReplicationDocumentOptions.docId;
      this.replicationDocument = putReplicationDocumentOptions.replicationDocument;
      this.ifMatch = putReplicationDocumentOptions.ifMatch;
      this.batch = putReplicationDocumentOptions.batch;
      this.newEdits = putReplicationDocumentOptions.newEdits;
      this.rev = putReplicationDocumentOptions.rev;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param docId the docId
     * @param replicationDocument the replicationDocument
     */
    public Builder(String docId, ReplicationDocument replicationDocument) {
      this.docId = docId;
      this.replicationDocument = replicationDocument;
    }

    /**
     * Builds a PutReplicationDocumentOptions.
     *
     * @return the new PutReplicationDocumentOptions instance
     */
    public PutReplicationDocumentOptions build() {
      return new PutReplicationDocumentOptions(this);
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the PutReplicationDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the replicationDocument.
     *
     * @param replicationDocument the replicationDocument
     * @return the PutReplicationDocumentOptions builder
     */
    public Builder replicationDocument(ReplicationDocument replicationDocument) {
      this.replicationDocument = replicationDocument;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the PutReplicationDocumentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the PutReplicationDocumentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }

    /**
     * Set the newEdits.
     *
     * @param newEdits the newEdits
     * @return the PutReplicationDocumentOptions builder
     */
    public Builder newEdits(Boolean newEdits) {
      this.newEdits = newEdits;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the PutReplicationDocumentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }
  }

  protected PutReplicationDocumentOptions() { }

  protected PutReplicationDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.replicationDocument,
      "replicationDocument cannot be null");
    docId = builder.docId;
    replicationDocument = builder.replicationDocument;
    ifMatch = builder.ifMatch;
    batch = builder.batch;
    newEdits = builder.newEdits;
    rev = builder.rev;
  }

  /**
   * New builder.
   *
   * @return a PutReplicationDocumentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the docId.
   *
   * Path parameter to specify the document ID.
   *
   * @return the docId
   */
  public String docId() {
    return docId;
  }

  /**
   * Gets the replicationDocument.
   *
   * HTTP request body for replication operations.
   *
   * @return the replicationDocument
   */
  public ReplicationDocument replicationDocument() {
    return replicationDocument;
  }

  /**
   * Gets the ifMatch.
   *
   * Header parameter to specify the document revision. Alternative to rev query parameter.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the batch.
   *
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   *
   * @return the batch
   */
  public String batch() {
    return batch;
  }

  /**
   * Gets the newEdits.
   *
   * Query parameter to specify whether to prevent insertion of conflicting document revisions. If false, a well-formed
   * _rev must be included in the document. False is used by the replicator to insert documents into the target database
   * even if that leads to the creation of conflicts.
   *
   * @return the newEdits
   */
  public Boolean newEdits() {
    return newEdits;
  }

  /**
   * Gets the rev.
   *
   * Query parameter to specify a document revision.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
  }
}

