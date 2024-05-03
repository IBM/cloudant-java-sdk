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
 * The headDocument options.
 */
public class HeadDocumentOptions extends GenericModel {

  protected String db;
  protected String docId;
  protected String ifNoneMatch;
  protected Boolean latest;
  protected String rev;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private String ifNoneMatch;
    private Boolean latest;
    private String rev;

    /**
     * Instantiates a new Builder from an existing HeadDocumentOptions instance.
     *
     * @param headDocumentOptions the instance to initialize the Builder with
     */
    private Builder(HeadDocumentOptions headDocumentOptions) {
      this.db = headDocumentOptions.db;
      this.docId = headDocumentOptions.docId;
      this.ifNoneMatch = headDocumentOptions.ifNoneMatch;
      this.latest = headDocumentOptions.latest;
      this.rev = headDocumentOptions.rev;
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
     * Builds a HeadDocumentOptions.
     *
     * @return the new HeadDocumentOptions instance
     */
    public HeadDocumentOptions build() {
      return new HeadDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the HeadDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the HeadDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the ifNoneMatch.
     *
     * @param ifNoneMatch the ifNoneMatch
     * @return the HeadDocumentOptions builder
     */
    public Builder ifNoneMatch(String ifNoneMatch) {
      this.ifNoneMatch = ifNoneMatch;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the HeadDocumentOptions builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the HeadDocumentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }
  }

  protected HeadDocumentOptions() { }

  protected HeadDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    db = builder.db;
    docId = builder.docId;
    ifNoneMatch = builder.ifNoneMatch;
    latest = builder.latest;
    rev = builder.rev;
  }

  /**
   * New builder.
   *
   * @return a HeadDocumentOptions builder
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
   * Gets the latest.
   *
   * Query parameter to specify whether to force retrieving latest leaf revision, no matter what rev was requested.
   *
   * @return the latest
   */
  public Boolean latest() {
    return latest;
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

