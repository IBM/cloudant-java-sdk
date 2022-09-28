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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a replication source or target database.
 */
public class ReplicationDatabase extends GenericModel {

  protected ReplicationDatabaseAuth auth;
  protected Map<String, String> headers;
  protected String url;

  /**
   * Builder.
   */
  public static class Builder {
    private ReplicationDatabaseAuth auth;
    private Map<String, String> headers;
    private String url;

    /**
     * Instantiates a new Builder from an existing ReplicationDatabase instance.
     *
     * @param replicationDatabase the instance to initialize the Builder with
     */
    private Builder(ReplicationDatabase replicationDatabase) {
      this.auth = replicationDatabase.auth;
      this.headers = replicationDatabase.headers;
      this.url = replicationDatabase.url;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     */
    public Builder(String url) {
      this.url = url;
    }

    /**
     * Builds a ReplicationDatabase.
     *
     * @return the new ReplicationDatabase instance
     */
    public ReplicationDatabase build() {
      return new ReplicationDatabase(this);
    }

    /**
     * Set the auth.
     *
     * @param auth the auth
     * @return the ReplicationDatabase builder
     */
    public Builder auth(ReplicationDatabaseAuth auth) {
      this.auth = auth;
      return this;
    }

    /**
     * Set the headers.
     *
     * @param headers the headers
     * @return the ReplicationDatabase builder
     */
    public Builder headers(Map<String, String> headers) {
      this.headers = headers;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the ReplicationDatabase builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }
  }

  protected ReplicationDatabase() { }

  protected ReplicationDatabase(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url,
      "url cannot be null");
    auth = builder.auth;
    headers = builder.headers;
    url = builder.url;
  }

  /**
   * New builder.
   *
   * @return a ReplicationDatabase builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the auth.
   *
   * Schema for replication source or target database authentication.
   *
   * @return the auth
   */
  public ReplicationDatabaseAuth auth() {
    return auth;
  }

  /**
   * Gets the headers.
   *
   * Replication request headers.
   *
   * @return the headers
   */
  public Map<String, String> headers() {
    return headers;
  }

  /**
   * Gets the url.
   *
   * Replication database URL.
   *
   * @return the url
   */
  public String url() {
    return url;
  }
}

