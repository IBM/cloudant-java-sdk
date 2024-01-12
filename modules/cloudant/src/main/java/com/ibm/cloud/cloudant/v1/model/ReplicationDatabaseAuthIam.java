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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for an IAM API key for replication database authentication.
 */
public class ReplicationDatabaseAuthIam extends GenericModel {

  @SerializedName("api_key")
  protected String apiKey;

  /**
   * Builder.
   */
  public static class Builder {
    private String apiKey;

    /**
     * Instantiates a new Builder from an existing ReplicationDatabaseAuthIam instance.
     *
     * @param replicationDatabaseAuthIam the instance to initialize the Builder with
     */
    private Builder(ReplicationDatabaseAuthIam replicationDatabaseAuthIam) {
      this.apiKey = replicationDatabaseAuthIam.apiKey;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param apiKey the apiKey
     */
    public Builder(String apiKey) {
      this.apiKey = apiKey;
    }

    /**
     * Builds a ReplicationDatabaseAuthIam.
     *
     * @return the new ReplicationDatabaseAuthIam instance
     */
    public ReplicationDatabaseAuthIam build() {
      return new ReplicationDatabaseAuthIam(this);
    }

    /**
     * Set the apiKey.
     *
     * @param apiKey the apiKey
     * @return the ReplicationDatabaseAuthIam builder
     */
    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }
  }

  protected ReplicationDatabaseAuthIam() { }

  protected ReplicationDatabaseAuthIam(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.apiKey,
      "apiKey cannot be null");
    apiKey = builder.apiKey;
  }

  /**
   * New builder.
   *
   * @return a ReplicationDatabaseAuthIam builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the apiKey.
   *
   * IAM API key.
   *
   * @return the apiKey
   */
  public String apiKey() {
    return apiKey;
  }
}

