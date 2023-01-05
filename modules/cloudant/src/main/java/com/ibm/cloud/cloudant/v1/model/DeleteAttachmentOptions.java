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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteAttachment options.
 */
public class DeleteAttachmentOptions extends GenericModel {

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
  protected String attachmentName;
  protected String ifMatch;
  protected String rev;
  protected String batch;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private String attachmentName;
    private String ifMatch;
    private String rev;
    private String batch;

    /**
     * Instantiates a new Builder from an existing DeleteAttachmentOptions instance.
     *
     * @param deleteAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteAttachmentOptions deleteAttachmentOptions) {
      this.db = deleteAttachmentOptions.db;
      this.docId = deleteAttachmentOptions.docId;
      this.attachmentName = deleteAttachmentOptions.attachmentName;
      this.ifMatch = deleteAttachmentOptions.ifMatch;
      this.rev = deleteAttachmentOptions.rev;
      this.batch = deleteAttachmentOptions.batch;
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
     * @param attachmentName the attachmentName
     */
    public Builder(String db, String docId, String attachmentName) {
      this.db = db;
      this.docId = docId;
      this.attachmentName = attachmentName;
    }

    /**
     * Builds a DeleteAttachmentOptions.
     *
     * @return the new DeleteAttachmentOptions instance
     */
    public DeleteAttachmentOptions build() {
      return new DeleteAttachmentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the DeleteAttachmentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the DeleteAttachmentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the attachmentName.
     *
     * @param attachmentName the attachmentName
     * @return the DeleteAttachmentOptions builder
     */
    public Builder attachmentName(String attachmentName) {
      this.attachmentName = attachmentName;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the DeleteAttachmentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the DeleteAttachmentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the DeleteAttachmentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }
  }

  protected DeleteAttachmentOptions() { }

  protected DeleteAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentName,
      "attachmentName cannot be empty");
    db = builder.db;
    docId = builder.docId;
    attachmentName = builder.attachmentName;
    ifMatch = builder.ifMatch;
    rev = builder.rev;
    batch = builder.batch;
  }

  /**
   * New builder.
   *
   * @return a DeleteAttachmentOptions builder
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
   * Gets the attachmentName.
   *
   * Path parameter to specify the attachment name.
   *
   * @return the attachmentName
   */
  public String attachmentName() {
    return attachmentName;
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
   * Gets the rev.
   *
   * Query parameter to specify a document revision.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
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

