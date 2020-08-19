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
 * The putCloudantSecurity options.
 */
public class PutCloudantSecurityOptions extends GenericModel {

  protected String db;
  protected Map<String, List<String>> cloudant;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private Map<String, List<String>> cloudant;

    private Builder(PutCloudantSecurityOptions putCloudantSecurityOptions) {
      this.db = putCloudantSecurityOptions.db;
      this.cloudant = putCloudantSecurityOptions.cloudant;
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
     * Builds a PutCloudantSecurityOptions.
     *
     * @return the new PutCloudantSecurityOptions instance
     */
    public PutCloudantSecurityOptions build() {
      return new PutCloudantSecurityOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PutCloudantSecurityOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the cloudant.
     *
     * @param cloudant the cloudant
     * @return the PutCloudantSecurityOptions builder
     */
    public Builder cloudant(Map<String, List<String>> cloudant) {
      this.cloudant = cloudant;
      return this;
    }
  }

  protected PutCloudantSecurityOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    cloudant = builder.cloudant;
  }

  /**
   * New builder.
   *
   * @return a PutCloudantSecurityOptions builder
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
   * Gets the cloudant.
   *
   * Database permissions for Cloudant users and/or API keys.
   *
   * @return the cloudant
   */
  public Map<String, List<String>> cloudant() {
    return cloudant;
  }
}

