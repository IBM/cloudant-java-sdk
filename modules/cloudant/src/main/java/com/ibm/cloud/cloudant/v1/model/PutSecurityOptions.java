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

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The putSecurity options.
 */
public class PutSecurityOptions extends GenericModel {

  protected String db;
  protected SecurityObject admins;
  protected Map<String, List<String>> cloudant;
  protected Boolean couchdbAuthOnly;
  protected SecurityObject members;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private SecurityObject admins;
    private Map<String, List<String>> cloudant;
    private Boolean couchdbAuthOnly;
    private SecurityObject members;

    /**
     * Instantiates a new Builder from an existing PutSecurityOptions instance.
     *
     * @param putSecurityOptions the instance to initialize the Builder with
     */
    private Builder(PutSecurityOptions putSecurityOptions) {
      this.db = putSecurityOptions.db;
      this.admins = putSecurityOptions.admins;
      this.cloudant = putSecurityOptions.cloudant;
      this.couchdbAuthOnly = putSecurityOptions.couchdbAuthOnly;
      this.members = putSecurityOptions.members;
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
     * Builds a PutSecurityOptions.
     *
     * @return the new PutSecurityOptions instance
     */
    public PutSecurityOptions build() {
      return new PutSecurityOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PutSecurityOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the admins.
     *
     * @param admins the admins
     * @return the PutSecurityOptions builder
     */
    public Builder admins(SecurityObject admins) {
      this.admins = admins;
      return this;
    }

    /**
     * Set the cloudant.
     *
     * @param cloudant the cloudant
     * @return the PutSecurityOptions builder
     */
    public Builder cloudant(Map<String, List<String>> cloudant) {
      this.cloudant = cloudant;
      return this;
    }

    /**
     * Set the couchdbAuthOnly.
     *
     * @param couchdbAuthOnly the couchdbAuthOnly
     * @return the PutSecurityOptions builder
     */
    public Builder couchdbAuthOnly(Boolean couchdbAuthOnly) {
      this.couchdbAuthOnly = couchdbAuthOnly;
      return this;
    }

    /**
     * Set the members.
     *
     * @param members the members
     * @return the PutSecurityOptions builder
     */
    public Builder members(SecurityObject members) {
      this.members = members;
      return this;
    }

    /**
     * Set the security.
     *
     * @param security the security
     * @return the PutSecurityOptions builder
     */
    public Builder security(Security security) {
      this.admins = security.admins();
      this.cloudant = security.cloudant();
      this.couchdbAuthOnly = security.couchdbAuthOnly();
      this.members = security.members();
      return this;
    }
  }

  protected PutSecurityOptions() { }

  protected PutSecurityOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    admins = builder.admins;
    cloudant = builder.cloudant;
    couchdbAuthOnly = builder.couchdbAuthOnly;
    members = builder.members;
  }

  /**
   * New builder.
   *
   * @return a PutSecurityOptions builder
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
   * Gets the couchdbAuthOnly.
   *
   * Manage permissions using the `_users` database only.
   *
   * @return the couchdbAuthOnly
   */
  public Boolean couchdbAuthOnly() {
    return couchdbAuthOnly;
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
}

