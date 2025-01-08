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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The putAttachment options.
 */
public class PutAttachmentOptions extends GenericModel {

  protected String db;
  protected String docId;
  protected String attachmentName;
  protected InputStream attachment;
  protected String contentType;
  protected String ifMatch;
  protected String rev;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private String attachmentName;
    private InputStream attachment;
    private String contentType;
    private String ifMatch;
    private String rev;

    /**
     * Instantiates a new Builder from an existing PutAttachmentOptions instance.
     *
     * @param putAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(PutAttachmentOptions putAttachmentOptions) {
      this.db = putAttachmentOptions.db;
      this.docId = putAttachmentOptions.docId;
      this.attachmentName = putAttachmentOptions.attachmentName;
      this.attachment = putAttachmentOptions.attachment;
      this.contentType = putAttachmentOptions.contentType;
      this.ifMatch = putAttachmentOptions.ifMatch;
      this.rev = putAttachmentOptions.rev;
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
     * @param attachment the attachment
     * @param contentType the contentType
     */
    public Builder(String db, String docId, String attachmentName, InputStream attachment, String contentType) {
      this.db = db;
      this.docId = docId;
      this.attachmentName = attachmentName;
      this.attachment = attachment;
      this.contentType = contentType;
    }

    /**
     * Builds a PutAttachmentOptions.
     *
     * @return the new PutAttachmentOptions instance
     */
    public PutAttachmentOptions build() {
      return new PutAttachmentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PutAttachmentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the PutAttachmentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the attachmentName.
     *
     * @param attachmentName the attachmentName
     * @return the PutAttachmentOptions builder
     */
    public Builder attachmentName(String attachmentName) {
      this.attachmentName = attachmentName;
      return this;
    }

    /**
     * Set the attachment.
     *
     * @param attachment the attachment
     * @return the PutAttachmentOptions builder
     */
    public Builder attachment(InputStream attachment) {
      this.attachment = attachment;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the PutAttachmentOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the PutAttachmentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the PutAttachmentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the attachment.
     *
     * @param attachment the attachment
     * @return the PutAttachmentOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder attachment(File attachment) throws FileNotFoundException {
      this.attachment = new FileInputStream(attachment);
      return this;
    }
  }

  protected PutAttachmentOptions() { }

  protected PutAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentName,
      "attachmentName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attachment,
      "attachment cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.contentType,
      "contentType cannot be null");
    db = builder.db;
    docId = builder.docId;
    attachmentName = builder.attachmentName;
    attachment = builder.attachment;
    contentType = builder.contentType;
    ifMatch = builder.ifMatch;
    rev = builder.rev;
  }

  /**
   * New builder.
   *
   * @return a PutAttachmentOptions builder
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
   * Gets the attachment.
   *
   * HTTP request body for attachment operations.
   *
   * @return the attachment
   */
  public InputStream attachment() {
    return attachment;
  }

  /**
   * Gets the contentType.
   *
   * Content-Type of the attachment.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
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

