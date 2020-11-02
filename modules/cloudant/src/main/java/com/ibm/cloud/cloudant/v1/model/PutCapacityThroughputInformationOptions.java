/*
 * (C) Copyright IBM Corp. 2020.
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
 * The putCapacityThroughputInformation options.
 */
public class PutCapacityThroughputInformationOptions extends GenericModel {

  protected Long blocks;

  /**
   * Builder.
   */
  public static class Builder {
    private Long blocks;

    private Builder(PutCapacityThroughputInformationOptions putCapacityThroughputInformationOptions) {
      this.blocks = putCapacityThroughputInformationOptions.blocks;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param blocks the blocks
     */
    public Builder(Long blocks) {
      this.blocks = blocks;
    }

    /**
     * Builds a PutCapacityThroughputInformationOptions.
     *
     * @return the new PutCapacityThroughputInformationOptions instance
     */
    public PutCapacityThroughputInformationOptions build() {
      return new PutCapacityThroughputInformationOptions(this);
    }

    /**
     * Set the blocks.
     *
     * @param blocks the blocks
     * @return the PutCapacityThroughputInformationOptions builder
     */
    public Builder blocks(long blocks) {
      this.blocks = blocks;
      return this;
    }
  }

  protected PutCapacityThroughputInformationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.blocks,
      "blocks cannot be null");
    blocks = builder.blocks;
  }

  /**
   * New builder.
   *
   * @return a PutCapacityThroughputInformationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the blocks.
   *
   * A number of blocks of throughput units. A block consists of 100 reads/sec, 50 writes/sec, and 5 global queries/sec
   * of provisioned throughput capacity.
   *
   * @return the blocks
   */
  public Long blocks() {
    return blocks;
  }
}

