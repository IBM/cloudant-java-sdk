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

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The putCloudantSecurityConfiguration options.
 */
public class PutCloudantSecurityConfigurationOptions extends GenericModel {

  protected String db;
  protected Map<String, List<String>> cloudant;
  protected SecurityObject admins;
  protected SecurityObject members;
  protected Boolean couchdbAuthOnly;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private Map<String, List<String>> cloudant;
    private SecurityObject admins;
    private SecurityObject members;
    private Boolean couchdbAuthOnly;

    /**
     * Instantiates a new Builder from an existing PutCloudantSecurityConfigurationOptions instance.
     *
     * @param putCloudantSecurityConfigurationOptions the instance to initialize the Builder with
     */
    private Builder(PutCloudantSecurityConfigurationOptions putCloudantSecurityConfigurationOptions) {
      this.db = putCloudantSecurityConfigurationOptions.db;
      this.cloudant = putCloudantSecurityConfigurationOptions.cloudant;
      this.admins = putCloudantSecurityConfigurationOptions.admins;
      this.members = putCloudantSecurityConfigurationOptions.members;
      this.couchdbAuthOnly = putCloudantSecurityConfigurationOptions.couchdbAuthOnly;
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
     * @param cloudant the cloudant
     */
    public Builder(String db, Map<String, List<String>> cloudant) {
      this.db = db;
      this.cloudant = cloudant;
    }

    /**
     * Builds a PutCloudantSecurityConfigurationOptions.
     *
     * @return the new PutCloudantSecurityConfigurationOptions instance
     */
    public PutCloudantSecurityConfigurationOptions build() {
      return new PutCloudantSecurityConfigurationOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PutCloudantSecurityConfigurationOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the cloudant.
     *
     * @param cloudant the cloudant
     * @return the PutCloudantSecurityConfigurationOptions builder
     */
    public Builder cloudant(Map<String, List<String>> cloudant) {
      this.cloudant = cloudant;
      return this;
    }

    /**
     * Set the admins.
     *
     * @param admins the admins
     * @return the PutCloudantSecurityConfigurationOptions builder
     */
    public Builder admins(SecurityObject admins) {
      this.admins = admins;
      return this;
    }

    /**
     * Set the members.
     *
     * @param members the members
     * @return the PutCloudantSecurityConfigurationOptions builder
     */
    public Builder members(SecurityObject members) {
      this.members = members;
      return this;
    }

    /**
     * Set the couchdbAuthOnly.
     *
     * @param couchdbAuthOnly the couchdbAuthOnly
     * @return the PutCloudantSecurityConfigurationOptions builder
     */
    public Builder couchdbAuthOnly(Boolean couchdbAuthOnly) {
      this.couchdbAuthOnly = couchdbAuthOnly;
      return this;
    }
  }

  protected PutCloudantSecurityConfigurationOptions() { }

  protected PutCloudantSecurityConfigurationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.cloudant,
      "cloudant cannot be null");
    db = builder.db;
    cloudant = builder.cloudant;
    admins = builder.admins;
    members = builder.members;
    couchdbAuthOnly = builder.couchdbAuthOnly;
  }

  /**
   * New builder.
   *
   * @return a PutCloudantSecurityConfigurationOptions builder
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

  /**
   * Gets the admins.
   *
   * Schema for names and roles to map to a database permission.
   *
   * @return the admins
   */
  public SecurityObject admins() {
    return admins;
  }

  /**
   * Gets the members.
   *
   * Schema for names and roles to map to a database permission.
   *
   * @return the members
   */
  public SecurityObject members() {
    return members;
  }

  /**
   * Gets the couchdbAuthOnly.
   *
   * Manage permissions using the `_users` database only.
   *
   * @return the couchdbAuthOnly
   */
  public Boolean couchdbAuthOnly() {
    return couchdbAuthOnly;
  }
}

