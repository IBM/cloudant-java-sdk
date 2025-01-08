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
 * The headDesignDocument options.
 */
public class HeadDesignDocumentOptions extends GenericModel {

  protected String db;
  protected String ddoc;
  protected String ifNoneMatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String ddoc;
    private String ifNoneMatch;

    /**
     * Instantiates a new Builder from an existing HeadDesignDocumentOptions instance.
     *
     * @param headDesignDocumentOptions the instance to initialize the Builder with
     */
    private Builder(HeadDesignDocumentOptions headDesignDocumentOptions) {
      this.db = headDesignDocumentOptions.db;
      this.ddoc = headDesignDocumentOptions.ddoc;
      this.ifNoneMatch = headDesignDocumentOptions.ifNoneMatch;
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
     * Builds a HeadDesignDocumentOptions.
     *
     * @return the new HeadDesignDocumentOptions instance
     */
    public HeadDesignDocumentOptions build() {
      return new HeadDesignDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the HeadDesignDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the HeadDesignDocumentOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the ifNoneMatch.
     *
     * @param ifNoneMatch the ifNoneMatch
     * @return the HeadDesignDocumentOptions builder
     */
    public Builder ifNoneMatch(String ifNoneMatch) {
      this.ifNoneMatch = ifNoneMatch;
      return this;
    }
  }

  protected HeadDesignDocumentOptions() { }

  protected HeadDesignDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ddoc,
      "ddoc cannot be empty");
    db = builder.db;
    ddoc = builder.ddoc;
    ifNoneMatch = builder.ifNoneMatch;
  }

  /**
   * New builder.
   *
   * @return a HeadDesignDocumentOptions builder
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
   * Gets the ifNoneMatch.
   *
   * Header parameter for a conditional HTTP request not matching an ETag.
   *
   * @return the ifNoneMatch
   */
  public String ifNoneMatch() {
    return ifNoneMatch;
  }
}

