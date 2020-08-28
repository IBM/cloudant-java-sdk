/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postRevsDiff options.
 */
public class PostRevsDiffOptions extends GenericModel {

  protected String db;
  protected Map<String, List<String>> documentRevisions;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private Map<String, List<String>> documentRevisions;

    private Builder(PostRevsDiffOptions postRevsDiffOptions) {
      this.db = postRevsDiffOptions.db;
      this.documentRevisions = postRevsDiffOptions.documentRevisions;
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
     */
    public Builder(String db) {
      this.db = db;
    }

    /**
     * Builds a PostRevsDiffOptions.
     *
     * @return the new PostRevsDiffOptions instance
     */
    public PostRevsDiffOptions build() {
      return new PostRevsDiffOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostRevsDiffOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the documentRevisions.
     *
     * @param documentRevisions the documentRevisions
     * @return the PostRevsDiffOptions builder
     */
    public Builder documentRevisions(Map<String, List<String>> documentRevisions) {
      this.documentRevisions = documentRevisions;
      return this;
    }
  }

  protected PostRevsDiffOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    documentRevisions = builder.documentRevisions;
  }

  /**
   * New builder.
   *
   * @return a PostRevsDiffOptions builder
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
   * Gets the documentRevisions.
   *
   * HTTP request body for postMissingRevs and postRevsDiff.
   *
   * @return the documentRevisions
   */
  public Map<String, List<String>> documentRevisions() {
    return documentRevisions;
  }
}

