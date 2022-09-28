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
 * The deleteDesignDocument options.
 */
public class DeleteDesignDocumentOptions extends GenericModel {

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
  protected String ifMatch;
  protected String batch;
  protected String rev;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String ddoc;
    private String ifMatch;
    private String batch;
    private String rev;

    /**
     * Instantiates a new Builder from an existing DeleteDesignDocumentOptions instance.
     *
     * @param deleteDesignDocumentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteDesignDocumentOptions deleteDesignDocumentOptions) {
      this.db = deleteDesignDocumentOptions.db;
      this.ddoc = deleteDesignDocumentOptions.ddoc;
      this.ifMatch = deleteDesignDocumentOptions.ifMatch;
      this.batch = deleteDesignDocumentOptions.batch;
      this.rev = deleteDesignDocumentOptions.rev;
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
     */
    public Builder(String db, String ddoc) {
      this.db = db;
      this.ddoc = ddoc;
    }

    /**
     * Builds a DeleteDesignDocumentOptions.
     *
     * @return the new DeleteDesignDocumentOptions instance
     */
    public DeleteDesignDocumentOptions build() {
      return new DeleteDesignDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the DeleteDesignDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the DeleteDesignDocumentOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the DeleteDesignDocumentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the DeleteDesignDocumentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the DeleteDesignDocumentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }
  }

  protected DeleteDesignDocumentOptions() { }

  protected DeleteDesignDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ddoc,
      "ddoc cannot be empty");
    db = builder.db;
    ddoc = builder.ddoc;
    ifMatch = builder.ifMatch;
    batch = builder.batch;
    rev = builder.rev;
  }

  /**
   * New builder.
   *
   * @return a DeleteDesignDocumentOptions builder
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

