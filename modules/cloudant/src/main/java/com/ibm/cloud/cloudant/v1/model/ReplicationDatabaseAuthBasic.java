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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for basic authentication of replication source or target database.
 */
public class ReplicationDatabaseAuthBasic extends GenericModel {

  protected String password;
  protected String username;

  /**
   * Builder.
   */
  public static class Builder {
    private String password;
    private String username;

    /**
     * Instantiates a new Builder from an existing ReplicationDatabaseAuthBasic instance.
     *
     * @param replicationDatabaseAuthBasic the instance to initialize the Builder with
     */
    private Builder(ReplicationDatabaseAuthBasic replicationDatabaseAuthBasic) {
      this.password = replicationDatabaseAuthBasic.password;
      this.username = replicationDatabaseAuthBasic.username;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param password the password
     * @param username the username
     */
    public Builder(String password, String username) {
      this.password = password;
      this.username = username;
    }

    /**
     * Builds a ReplicationDatabaseAuthBasic.
     *
     * @return the new ReplicationDatabaseAuthBasic instance
     */
    public ReplicationDatabaseAuthBasic build() {
      return new ReplicationDatabaseAuthBasic(this);
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the ReplicationDatabaseAuthBasic builder
     */
    public Builder password(String password) {
      this.password = password;
      return this;
    }

    /**
     * Set the username.
     *
     * @param username the username
     * @return the ReplicationDatabaseAuthBasic builder
     */
    public Builder username(String username) {
      this.username = username;
      return this;
    }
  }

  protected ReplicationDatabaseAuthBasic() { }

  protected ReplicationDatabaseAuthBasic(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.password,
      "password cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.username,
      "username cannot be null");
    password = builder.password;
    username = builder.username;
  }

  /**
   * New builder.
   *
   * @return a ReplicationDatabaseAuthBasic builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the password.
   *
   * The password associated with the username.
   *
   * @return the password
   */
  public String password() {
    return password;
  }

  /**
   * Gets the username.
   *
   * Schema for a username.
   *
   * @return the username
   */
  public String username() {
    return username;
  }
}

