/*
 * (C) Copyright IBM Corp. 2026.
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
 * The getLocalDocument options.
 */
public class GetLocalDocumentOptions extends GenericModel {

  protected String db;
  protected String docId;
  protected String accept;
  protected String ifNoneMatch;
  protected Boolean attachments;
  protected Boolean attEncodingInfo;
  protected Boolean localSeq;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private String accept;
    private String ifNoneMatch;
    private Boolean attachments;
    private Boolean attEncodingInfo;
    private Boolean localSeq;

    /**
     * Instantiates a new Builder from an existing GetLocalDocumentOptions instance.
     *
     * @param getLocalDocumentOptions the instance to initialize the Builder with
     */
    private Builder(GetLocalDocumentOptions getLocalDocumentOptions) {
      this.db = getLocalDocumentOptions.db;
      this.docId = getLocalDocumentOptions.docId;
      this.accept = getLocalDocumentOptions.accept;
      this.ifNoneMatch = getLocalDocumentOptions.ifNoneMatch;
      this.attachments = getLocalDocumentOptions.attachments;
      this.attEncodingInfo = getLocalDocumentOptions.attEncodingInfo;
      this.localSeq = getLocalDocumentOptions.localSeq;
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
     * Builds a GetLocalDocumentOptions.
     *
     * @return the new GetLocalDocumentOptions instance
     */
    public GetLocalDocumentOptions build() {
      return new GetLocalDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the GetLocalDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the GetLocalDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the accept.
     *
     * @param accept the accept
     * @return the GetLocalDocumentOptions builder
     */
    public Builder accept(String accept) {
      this.accept = accept;
      return this;
    }

    /**
     * Set the ifNoneMatch.
     *
     * @param ifNoneMatch the ifNoneMatch
     * @return the GetLocalDocumentOptions builder
     */
    public Builder ifNoneMatch(String ifNoneMatch) {
      this.ifNoneMatch = ifNoneMatch;
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the GetLocalDocumentOptions builder
     */
    public Builder attachments(Boolean attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the attEncodingInfo.
     *
     * @param attEncodingInfo the attEncodingInfo
     * @return the GetLocalDocumentOptions builder
     */
    public Builder attEncodingInfo(Boolean attEncodingInfo) {
      this.attEncodingInfo = attEncodingInfo;
      return this;
    }

    /**
     * Set the localSeq.
     *
     * @param localSeq the localSeq
     * @return the GetLocalDocumentOptions builder
     */
    public Builder localSeq(Boolean localSeq) {
      this.localSeq = localSeq;
      return this;
    }
  }

  protected GetLocalDocumentOptions() { }

  protected GetLocalDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    db = builder.db;
    docId = builder.docId;
    accept = builder.accept;
    ifNoneMatch = builder.ifNoneMatch;
    attachments = builder.attachments;
    attEncodingInfo = builder.attEncodingInfo;
    localSeq = builder.localSeq;
  }

  /**
   * New builder.
   *
   * @return a GetLocalDocumentOptions builder
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
   * Gets the accept.
   *
   * The type of the response: application/json, multipart/mixed, multipart/related, or application/octet-stream.
   *
   * @return the accept
   */
  public String accept() {
    return accept;
  }

  /**
   * Gets the ifNoneMatch.
   *
   * Header parameter for a conditional HTTP request not matching an ETag.
   *
   * @return the ifNoneMatch
   */
  public String ifNoneMatch() {
    return ifNoneMatch;
  }

  /**
   * Gets the attachments.
   *
   * Query parameter to specify whether to include attachment content in the response. Note that when used with a
   * view-style query or changes feed this only applies when requesting documents in the response.
   *
   * @return the attachments
   */
  public Boolean attachments() {
    return attachments;
  }

  /**
   * Gets the attEncodingInfo.
   *
   * Query parameter to specify whether to include the encoding information for compressed attachments. Note that when
   * used with a view-style query or changes feed this only applies when requesting documents in the response.
   *
   * @return the attEncodingInfo
   */
  public Boolean attEncodingInfo() {
    return attEncodingInfo;
  }

  /**
   * Gets the localSeq.
   *
   * Query parameter to specify whether to include the last update sequence for the document.
   *
   * @return the localSeq
   */
  public Boolean localSeq() {
    return localSeq;
  }
}

