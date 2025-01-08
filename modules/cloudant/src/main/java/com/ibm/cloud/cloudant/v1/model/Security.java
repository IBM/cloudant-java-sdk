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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a security document.
 */
public class Security extends GenericModel {

  protected SecurityObject admins;
  protected Map<String, List<String>> cloudant;
  @SerializedName("couchdb_auth_only")
  protected Boolean couchdbAuthOnly;
  protected SecurityObject members;

  /**
   * Builder.
   */
  public static class Builder {
    private SecurityObject admins;
    private Map<String, List<String>> cloudant;
    private Boolean couchdbAuthOnly;
    private SecurityObject members;

    /**
     * Instantiates a new Builder from an existing Security instance.
     *
     * @param security the instance to initialize the Builder with
     */
    private Builder(Security security) {
      this.admins = security.admins;
      this.cloudant = security.cloudant;
      this.couchdbAuthOnly = security.couchdbAuthOnly;
      this.members = security.members;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Security.
     *
     * @return the new Security instance
     */
    public Security build() {
      return new Security(this);
    }

    /**
     * Set the admins.
     *
     * @param admins the admins
     * @return the Security builder
     */
    public Builder admins(SecurityObject admins) {
      this.admins = admins;
      return this;
    }

    /**
     * Set the cloudant.
     *
     * @param cloudant the cloudant
     * @return the Security builder
     */
    public Builder cloudant(Map<String, List<String>> cloudant) {
      this.cloudant = cloudant;
      return this;
    }

    /**
     * Set the couchdbAuthOnly.
     *
     * @param couchdbAuthOnly the couchdbAuthOnly
     * @return the Security builder
     */
    public Builder couchdbAuthOnly(Boolean couchdbAuthOnly) {
      this.couchdbAuthOnly = couchdbAuthOnly;
      return this;
    }

    /**
     * Set the members.
     *
     * @param members the members
     * @return the Security builder
     */
    public Builder members(SecurityObject members) {
      this.members = members;
      return this;
    }
  }

  protected Security() { }

  protected Security(Builder builder) {
    admins = builder.admins;
    cloudant = builder.cloudant;
    couchdbAuthOnly = builder.couchdbAuthOnly;
    members = builder.members;
  }

  /**
   * New builder.
   *
   * @return a Security builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

