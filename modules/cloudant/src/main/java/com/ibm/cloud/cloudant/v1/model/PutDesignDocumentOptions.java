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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The putDesignDocument options.
 */
public class PutDesignDocumentOptions extends GenericModel {

  /**
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   */
  public interface Batch {
    /** ok. */
    String OK = "ok";
  }

  protected String db;
  protected String ddoc;
  protected DesignDocument designDocument;
  protected String ifMatch;
  protected String batch;
  protected Boolean newEdits;
  protected String rev;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String ddoc;
    private DesignDocument designDocument;
    private String ifMatch;
    private String batch;
    private Boolean newEdits;
    private String rev;

    private Builder(PutDesignDocumentOptions putDesignDocumentOptions) {
      this.db = putDesignDocumentOptions.db;
      this.ddoc = putDesignDocumentOptions.ddoc;
      this.designDocument = putDesignDocumentOptions.designDocument;
      this.ifMatch = putDesignDocumentOptions.ifMatch;
      this.batch = putDesignDocumentOptions.batch;
      this.newEdits = putDesignDocumentOptions.newEdits;
      this.rev = putDesignDocumentOptions.rev;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param db the db
     * @param ddoc the ddoc
     * @param designDocument the designDocument
     */
    public Builder(String db, String ddoc, DesignDocument designDocument) {
      this.db = db;
      this.ddoc = ddoc;
      this.designDocument = designDocument;
    }

    /**
     * Builds a PutDesignDocumentOptions.
     *
     * @return the new PutDesignDocumentOptions instance
     */
    public PutDesignDocumentOptions build() {
      return new PutDesignDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PutDesignDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the PutDesignDocumentOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the designDocument.
     *
     * @param designDocument the designDocument
     * @return the PutDesignDocumentOptions builder
     */
    public Builder designDocument(DesignDocument designDocument) {
      this.designDocument = designDocument;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the PutDesignDocumentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the PutDesignDocumentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }

    /**
     * Set the newEdits.
     *
     * @param newEdits the newEdits
     * @return the PutDesignDocumentOptions builder
     */
    public Builder newEdits(Boolean newEdits) {
      this.newEdits = newEdits;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the PutDesignDocumentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }
  }

  protected PutDesignDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ddoc,
      "ddoc cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.designDocument,
      "designDocument cannot be null");
    db = builder.db;
    ddoc = builder.ddoc;
    designDocument = builder.designDocument;
    ifMatch = builder.ifMatch;
    batch = builder.batch;
    newEdits = builder.newEdits;
    rev = builder.rev;
  }

  /**
   * New builder.
   *
   * @return a PutDesignDocumentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the db.
   *
   * Path parameter to specify the database name.
   *
   * @return the db
   */
  public String db() {
    return db;
  }

  /**
   * Gets the ddoc.
   *
   * Path parameter to specify the design document name. The design document name is the design document ID excluding
   * the `_design/` prefix.
   *
   * @return the ddoc
   */
  public String ddoc() {
    return ddoc;
  }

  /**
   * Gets the designDocument.
   *
   * HTTP request body for DesignDocument operations.
   *
   * @return the designDocument
   */
  public DesignDocument designDocument() {
    return designDocument;
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

