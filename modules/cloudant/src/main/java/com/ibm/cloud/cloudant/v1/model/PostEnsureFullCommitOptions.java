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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postEnsureFullCommit options.
 */
public class PostEnsureFullCommitOptions extends GenericModel {

  protected String db;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;

    private Builder(PostEnsureFullCommitOptions postEnsureFullCommitOptions) {
      this.db = postEnsureFullCommitOptions.db;
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
     * Builds a PostEnsureFullCommitOptions.
     *
     * @return the new PostEnsureFullCommitOptions instance
     */
    public PostEnsureFullCommitOptions build() {
      return new PostEnsureFullCommitOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostEnsureFullCommitOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }
  }

  protected PostEnsureFullCommitOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
  }

  /**
   * New builder.
   *
   * @return a PostEnsureFullCommitOptions builder
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
}

