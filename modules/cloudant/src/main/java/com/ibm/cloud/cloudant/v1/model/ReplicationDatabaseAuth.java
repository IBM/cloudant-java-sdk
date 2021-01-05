/*
 * (C) Copyright IBM Corp. 2021.
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
 * Schema for replication source or target database authentication.
 */
public class ReplicationDatabaseAuth extends GenericModel {

  protected ReplicationDatabaseAuthIam iam;

  /**
   * Builder.
   */
  public static class Builder {
    private ReplicationDatabaseAuthIam iam;

    private Builder(ReplicationDatabaseAuth replicationDatabaseAuth) {
      this.iam = replicationDatabaseAuth.iam;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ReplicationDatabaseAuth.
     *
     * @return the new ReplicationDatabaseAuth instance
     */
    public ReplicationDatabaseAuth build() {
      return new ReplicationDatabaseAuth(this);
    }

    /**
     * Set the iam.
     *
     * @param iam the iam
     * @return the ReplicationDatabaseAuth builder
     */
    public Builder iam(ReplicationDatabaseAuthIam iam) {
      this.iam = iam;
      return this;
    }
  }

  protected ReplicationDatabaseAuth(Builder builder) {
    iam = builder.iam;
  }

  /**
   * New builder.
   *
   * @return a ReplicationDatabaseAuth builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the iam.
   *
   * Schema for an IAM API key for replication database authentication.
   *
   * @return the iam
   */
  public ReplicationDatabaseAuthIam iam() {
    return iam;
  }
}

