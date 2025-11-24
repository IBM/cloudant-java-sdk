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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for design document options.
 */
public class DesignDocumentOptions extends GenericModel {

  protected Boolean partitioned;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean partitioned;

    /**
     * Instantiates a new Builder from an existing DesignDocumentOptions instance.
     *
     * @param designDocumentOptions the instance to initialize the Builder with
     */
    private Builder(DesignDocumentOptions designDocumentOptions) {
      this.partitioned = designDocumentOptions.partitioned;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DesignDocumentOptions.
     *
     * @return the new DesignDocumentOptions instance
     */
    public DesignDocumentOptions build() {
      return new DesignDocumentOptions(this);
    }

    /**
     * Set the partitioned.
     *
     * @param partitioned the partitioned
     * @return the DesignDocumentOptions builder
     */
    public Builder partitioned(Boolean partitioned) {
      this.partitioned = partitioned;
      return this;
    }
  }

  protected DesignDocumentOptions() { }

  protected DesignDocumentOptions(Builder builder) {
    partitioned = builder.partitioned;
  }

  /**
   * New builder.
   *
   * @return a DesignDocumentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the partitioned.
   *
   * Whether this design document describes partitioned or global indexes. Set this option to `false` for a design
   * document that describes global indexes in a partitioned database. A design document describes either global or
   * partitioned indexes, but not both. By default, for a partitioned database this option is `true` and the design
   * document describes partitioned indexes for queries on a single partition at a time. When set to `false` this option
   * allows creating global indexes in this design document for queries spanning many partitions. For non-partitioned
   * databases, the default is `false` and design documents default to global. Only partitioned databases can have
   * partitioned indexes.
   *
   * @return the partitioned
   */
  public Boolean partitioned() {
    return partitioned;
  }
}

