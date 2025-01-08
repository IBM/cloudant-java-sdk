/*
 * (C) Copyright IBM Corp. 2025.
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
 * The deleteDocument options.
 */
public class DeleteDocumentOptions extends GenericModel {

  /**
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   */
  public interface Batch {
    /** ok. */
    String OK = "ok";
  }

  protected String db;
  protected String docId;
  protected String ifMatch;
  protected String batch;
  protected String rev;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private String ifMatch;
    private String batch;
    private String rev;

    /**
     * Instantiates a new Builder from an existing DeleteDocumentOptions instance.
     *
     * @param deleteDocumentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteDocumentOptions deleteDocumentOptions) {
      this.db = deleteDocumentOptions.db;
      this.docId = deleteDocumentOptions.docId;
      this.ifMatch = deleteDocumentOptions.ifMatch;
      this.batch = deleteDocumentOptions.batch;
      this.rev = deleteDocumentOptions.rev;
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
     * @param docId the docId
     */
    public Builder(String db, String docId) {
      this.db = db;
      this.docId = docId;
    }

    /**
     * Builds a DeleteDocumentOptions.
     *
     * @return the new DeleteDocumentOptions instance
     */
    public DeleteDocumentOptions build() {
      return new DeleteDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the DeleteDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the DeleteDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the DeleteDocumentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the DeleteDocumentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the DeleteDocumentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }
  }

  protected DeleteDocumentOptions() { }

  protected DeleteDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    db = builder.db;
    docId = builder.docId;
    ifMatch = builder.ifMatch;
    batch = builder.batch;
    rev = builder.rev;
  }

  /**
   * New builder.
   *
   * @return a DeleteDocumentOptions builder
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
   * Gets the ifMatch.
   *
   * Header parameter for a conditional HTTP request matching an ETag.
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

