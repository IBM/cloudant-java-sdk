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
 * The postMissingRevs options.
 */
public class PostMissingRevsOptions extends GenericModel {

  protected String db;
  protected Map<String, List<String>> missingRevs;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private Map<String, List<String>> missingRevs;

    private Builder(PostMissingRevsOptions postMissingRevsOptions) {
      this.db = postMissingRevsOptions.db;
      this.missingRevs = postMissingRevsOptions.missingRevs;
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
     * Builds a PostMissingRevsOptions.
     *
     * @return the new PostMissingRevsOptions instance
     */
    public PostMissingRevsOptions build() {
      return new PostMissingRevsOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostMissingRevsOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the missingRevs.
     *
     * @param missingRevs the missingRevs
     * @return the PostMissingRevsOptions builder
     */
    public Builder missingRevs(Map<String, List<String>> missingRevs) {
      this.missingRevs = missingRevs;
      return this;
    }
  }

  protected PostMissingRevsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    missingRevs = builder.missingRevs;
  }

  /**
   * New builder.
   *
   * @return a PostMissingRevsOptions builder
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
   * Gets the missingRevs.
   *
   * HTTP request body for postMissingRevs and postRevsDiff.
   *
   * @return the missingRevs
   */
  public Map<String, List<String>> missingRevs() {
    return missingRevs;
  }
}

