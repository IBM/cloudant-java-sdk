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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * IBM IAM replication auth for CouchDB or Cloudant.
 */
public class ReplicationDatabaseAuthIBM extends GenericModel {

  protected ReplicationDatabaseAuthIBMIam iam;

  /**
   * Builder.
   */
  public static class Builder {
    private ReplicationDatabaseAuthIBMIam iam;

    /**
     * Instantiates a new Builder from an existing ReplicationDatabaseAuthIBM instance.
     *
     * @param replicationDatabaseAuthIbm the instance to initialize the Builder with
     */
    private Builder(ReplicationDatabaseAuthIBM replicationDatabaseAuthIbm) {
      this.iam = replicationDatabaseAuthIbm.iam;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param iam the iam
     */
    public Builder(ReplicationDatabaseAuthIBMIam iam) {
      this.iam = iam;
    }

    /**
     * Builds a ReplicationDatabaseAuthIBM.
     *
     * @return the new ReplicationDatabaseAuthIBM instance
     */
    public ReplicationDatabaseAuthIBM build() {
      return new ReplicationDatabaseAuthIBM(this);
    }

    /**
     * Set the iam.
     *
     * @param iam the iam
     * @return the ReplicationDatabaseAuthIBM builder
     */
    public Builder iam(ReplicationDatabaseAuthIBMIam iam) {
      this.iam = iam;
      return this;
    }
  }

  protected ReplicationDatabaseAuthIBM() { }

  protected ReplicationDatabaseAuthIBM(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.iam,
      "iam cannot be null");
    iam = builder.iam;
  }

  /**
   * New builder.
   *
   * @return a ReplicationDatabaseAuthIBM builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the iam.
   *
   * IAM API key for replication database authentication.
   *
   * @return the iam
   */
  public ReplicationDatabaseAuthIBMIam iam() {
    return iam;
  }
}

