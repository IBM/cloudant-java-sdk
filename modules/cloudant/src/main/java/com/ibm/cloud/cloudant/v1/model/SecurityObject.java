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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for names and roles to map to a database permission.
 */
public class SecurityObject extends GenericModel {

  protected List<String> names;
  protected List<String> roles;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> names;
    private List<String> roles;

    /**
     * Instantiates a new Builder from an existing SecurityObject instance.
     *
     * @param securityObject the instance to initialize the Builder with
     */
    private Builder(SecurityObject securityObject) {
      this.names = securityObject.names;
      this.roles = securityObject.roles;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SecurityObject.
     *
     * @return the new SecurityObject instance
     */
    public SecurityObject build() {
      return new SecurityObject(this);
    }

    /**
     * Adds a new element to names.
     *
     * @param names the new element to be added
     * @return the SecurityObject builder
     */
    public Builder addNames(String names) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(names,
        "names cannot be null");
      if (this.names == null) {
        this.names = new ArrayList<String>();
      }
      this.names.add(names);
      return this;
    }

    /**
     * Adds a new element to roles.
     *
     * @param roles the new element to be added
     * @return the SecurityObject builder
     */
    public Builder addRoles(String roles) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(roles,
        "roles cannot be null");
      if (this.roles == null) {
        this.roles = new ArrayList<String>();
      }
      this.roles.add(roles);
      return this;
    }

    /**
     * Set the names.
     * Existing names will be replaced.
     *
     * @param names the names
     * @return the SecurityObject builder
     */
    public Builder names(List<String> names) {
      this.names = names;
      return this;
    }

    /**
     * Set the roles.
     * Existing roles will be replaced.
     *
     * @param roles the roles
     * @return the SecurityObject builder
     */
    public Builder roles(List<String> roles) {
      this.roles = roles;
      return this;
    }
  }

  protected SecurityObject() { }

  protected SecurityObject(Builder builder) {
    names = builder.names;
    roles = builder.roles;
  }

  /**
   * New builder.
   *
   * @return a SecurityObject builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the names.
   *
   * List of usernames.
   *
   * @return the names
   */
  public List<String> names() {
    return names;
  }

  /**
   * Gets the roles.
   *
   * List of roles.
   *
   * @return the roles
   */
  public List<String> roles() {
    return roles;
  }
}

