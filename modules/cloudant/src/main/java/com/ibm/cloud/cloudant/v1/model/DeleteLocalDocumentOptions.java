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
 * The deleteLocalDocument options.
 */
public class DeleteLocalDocumentOptions extends GenericModel {

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
  protected String batch;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private String batch;

    private Builder(DeleteLocalDocumentOptions deleteLocalDocumentOptions) {
      this.db = deleteLocalDocumentOptions.db;
      this.docId = deleteLocalDocumentOptions.docId;
      this.batch = deleteLocalDocumentOptions.batch;
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
     * Builds a DeleteLocalDocumentOptions.
     *
     * @return the new DeleteLocalDocumentOptions instance
     */
    public DeleteLocalDocumentOptions build() {
      return new DeleteLocalDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the DeleteLocalDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the DeleteLocalDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the DeleteLocalDocumentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }
  }

  protected DeleteLocalDocumentOptions() { }

  protected DeleteLocalDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    db = builder.db;
    docId = builder.docId;
    batch = builder.batch;
  }

  /**
   * New builder.
   *
   * @return a DeleteLocalDocumentOptions builder
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
}

