/*
 * (C) Copyright IBM Corp. 2026.
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
 * IAM API key for replication database authentication.
 */
public class ReplicationDatabaseAuthIBMIam extends GenericModel {

  @SerializedName("api_key")
  protected String apiKey;

  /**
   * Builder.
   */
  public static class Builder {
    private String apiKey;

    /**
     * Instantiates a new Builder from an existing ReplicationDatabaseAuthIBMIam instance.
     *
     * @param replicationDatabaseAuthIbmIam the instance to initialize the Builder with
     */
    private Builder(ReplicationDatabaseAuthIBMIam replicationDatabaseAuthIbmIam) {
      this.apiKey = replicationDatabaseAuthIbmIam.apiKey;
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
     * Builds a ReplicationDatabaseAuthIBMIam.
     *
     * @return the new ReplicationDatabaseAuthIBMIam instance
     */
    public ReplicationDatabaseAuthIBMIam build() {
      return new ReplicationDatabaseAuthIBMIam(this);
    }

    /**
     * Set the apiKey.
     *
     * @param apiKey the apiKey
     * @return the ReplicationDatabaseAuthIBMIam builder
     */
    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }
  }

  protected ReplicationDatabaseAuthIBMIam() { }

  protected ReplicationDatabaseAuthIBMIam(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.apiKey,
      "apiKey cannot be null");
    apiKey = builder.apiKey;
  }

  /**
   * New builder.
   *
   * @return a ReplicationDatabaseAuthIBMIam builder
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

