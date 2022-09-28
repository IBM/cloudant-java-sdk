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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for the user context of a session.
 */
public class UserContext extends GenericModel {

  /**
   * Schema for a security role.
   */
  public interface Roles {
    /** _reader. */
    String READER = "_reader";
    /** _writer. */
    String WRITER = "_writer";
    /** _admin. */
    String ADMIN = "_admin";
    /** _replicator. */
    String REPLICATOR = "_replicator";
    /** _db_updates. */
    String DB_UPDATES = "_db_updates";
    /** _design. */
    String DESIGN = "_design";
    /** _shards. */
    String SHARDS = "_shards";
    /** _security. */
    String SECURITY = "_security";
  }

  protected String db;
  protected String name;
  protected List<String> roles;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String name;
    private List<String> roles;

    /**
     * Instantiates a new Builder from an existing UserContext instance.
     *
     * @param userContext the instance to initialize the Builder with
     */
    private Builder(UserContext userContext) {
      this.db = userContext.db;
      this.name = userContext.name;
      this.roles = userContext.roles;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param roles the roles
     */
    public Builder(String name, List<String> roles) {
      this.name = name;
      this.roles = roles;
    }

    /**
     * Builds a UserContext.
     *
     * @return the new UserContext instance
     */
    public UserContext build() {
      return new UserContext(this);
    }

    /**
     * Adds an roles to roles.
     *
     * @param roles the new roles
     * @return the UserContext builder
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
     * Set the db.
     *
     * @param db the db
     * @return the UserContext builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UserContext builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the roles.
     * Existing roles will be replaced.
     *
     * @param roles the roles
     * @return the UserContext builder
     */
    public Builder roles(List<String> roles) {
      this.roles = roles;
      return this;
    }
  }

  protected UserContext() { }

  protected UserContext(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roles,
      "roles cannot be null");
    db = builder.db;
    name = builder.name;
    roles = builder.roles;
  }

  /**
   * New builder.
   *
   * @return a UserContext builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the db.
   *
   * Database name in the context of the provided operation.
   *
   * @return the db
   */
  public String db() {
    return db;
  }

  /**
   * Gets the name.
   *
   * User name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the roles.
   *
   * List of user roles.
   *
   * @return the roles
   */
  public List<String> roles() {
    return roles;
  }
}

