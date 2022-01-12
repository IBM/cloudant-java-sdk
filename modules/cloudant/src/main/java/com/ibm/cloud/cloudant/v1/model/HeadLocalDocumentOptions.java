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
 * The headLocalDocument options.
 */
public class HeadLocalDocumentOptions extends GenericModel {

  protected String db;
  protected String docId;
  protected String ifNoneMatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private String ifNoneMatch;

    private Builder(HeadLocalDocumentOptions headLocalDocumentOptions) {
      this.db = headLocalDocumentOptions.db;
      this.docId = headLocalDocumentOptions.docId;
      this.ifNoneMatch = headLocalDocumentOptions.ifNoneMatch;
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
     * Builds a HeadLocalDocumentOptions.
     *
     * @return the new HeadLocalDocumentOptions instance
     */
    public HeadLocalDocumentOptions build() {
      return new HeadLocalDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the HeadLocalDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the HeadLocalDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the ifNoneMatch.
     *
     * @param ifNoneMatch the ifNoneMatch
     * @return the HeadLocalDocumentOptions builder
     */
    public Builder ifNoneMatch(String ifNoneMatch) {
      this.ifNoneMatch = ifNoneMatch;
      return this;
    }
  }

  protected HeadLocalDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    db = builder.db;
    docId = builder.docId;
    ifNoneMatch = builder.ifNoneMatch;
  }

  /**
   * New builder.
   *
   * @return a HeadLocalDocumentOptions builder
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
   * Header parameter to specify a double quoted document revision token for cache control.
   *
   * @return the ifNoneMatch
   */
  public String ifNoneMatch() {
    return ifNoneMatch;
  }
}

