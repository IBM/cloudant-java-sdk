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
 * The deleteReplicationDocument options.
 */
public class DeleteReplicationDocumentOptions extends GenericModel {

  /**
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   */
  public interface Batch {
    /** ok. */
    String OK = "ok";
  }

  protected String docId;
  protected String ifMatch;
  protected String batch;
  protected String rev;

  /**
   * Builder.
   */
  public static class Builder {
    private String docId;
    private String ifMatch;
    private String batch;
    private String rev;

    /**
     * Instantiates a new Builder from an existing DeleteReplicationDocumentOptions instance.
     *
     * @param deleteReplicationDocumentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteReplicationDocumentOptions deleteReplicationDocumentOptions) {
      this.docId = deleteReplicationDocumentOptions.docId;
      this.ifMatch = deleteReplicationDocumentOptions.ifMatch;
      this.batch = deleteReplicationDocumentOptions.batch;
      this.rev = deleteReplicationDocumentOptions.rev;
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
     */
    public Builder(String docId) {
      this.docId = docId;
    }

    /**
     * Builds a DeleteReplicationDocumentOptions.
     *
     * @return the new DeleteReplicationDocumentOptions instance
     */
    public DeleteReplicationDocumentOptions build() {
      return new DeleteReplicationDocumentOptions(this);
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the DeleteReplicationDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the DeleteReplicationDocumentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the DeleteReplicationDocumentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the DeleteReplicationDocumentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }
  }

  protected DeleteReplicationDocumentOptions() { }

  protected DeleteReplicationDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    docId = builder.docId;
    ifMatch = builder.ifMatch;
    batch = builder.batch;
    rev = builder.rev;
  }

  /**
   * New builder.
   *
   * @return a DeleteReplicationDocumentOptions builder
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

