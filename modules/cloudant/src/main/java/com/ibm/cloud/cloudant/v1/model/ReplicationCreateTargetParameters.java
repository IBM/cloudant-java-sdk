/*
 * (C) Copyright IBM Corp. 2023.
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
 * Request parameters to use during target database creation.
 */
public class ReplicationCreateTargetParameters extends GenericModel {

  protected Long n;
  protected Boolean partitioned;
  protected Long q;

  /**
   * Builder.
   */
  public static class Builder {
    private Long n;
    private Boolean partitioned;
    private Long q;

    /**
     * Instantiates a new Builder from an existing ReplicationCreateTargetParameters instance.
     *
     * @param replicationCreateTargetParameters the instance to initialize the Builder with
     */
    private Builder(ReplicationCreateTargetParameters replicationCreateTargetParameters) {
      this.n = replicationCreateTargetParameters.n;
      this.partitioned = replicationCreateTargetParameters.partitioned;
      this.q = replicationCreateTargetParameters.q;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ReplicationCreateTargetParameters.
     *
     * @return the new ReplicationCreateTargetParameters instance
     */
    public ReplicationCreateTargetParameters build() {
      return new ReplicationCreateTargetParameters(this);
    }

    /**
     * Set the n.
     *
     * @param n the n
     * @return the ReplicationCreateTargetParameters builder
     */
    public Builder n(long n) {
      this.n = n;
      return this;
    }

    /**
     * Set the partitioned.
     *
     * @param partitioned the partitioned
     * @return the ReplicationCreateTargetParameters builder
     */
    public Builder partitioned(Boolean partitioned) {
      this.partitioned = partitioned;
      return this;
    }

    /**
     * Set the q.
     *
     * @param q the q
     * @return the ReplicationCreateTargetParameters builder
     */
    public Builder q(long q) {
      this.q = q;
      return this;
    }
  }

  protected ReplicationCreateTargetParameters() { }

  protected ReplicationCreateTargetParameters(Builder builder) {
    n = builder.n;
    partitioned = builder.partitioned;
    q = builder.q;
  }

  /**
   * New builder.
   *
   * @return a ReplicationCreateTargetParameters builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the n.
   *
   * Schema for the number of replicas of a database in a cluster. The cluster is using the default value and it cannot
   * be changed by the user.
   *
   * @return the n
   */
  public Long n() {
    return n;
  }

  /**
   * Gets the partitioned.
   *
   * Parameter to specify whether to enable database partitions when creating the target database.
   *
   * @return the partitioned
   */
  public Boolean partitioned() {
    return partitioned;
  }

  /**
   * Gets the q.
   *
   * Schema for the number of shards in a database. Each shard is a partition of the hash value range.
   *
   * @return the q
   */
  public Long q() {
    return q;
  }
}

