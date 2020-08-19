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
 * The postReplicate options.
 */
public class PostReplicateOptions extends GenericModel {

  protected ReplicationDocument replicationDocument;

  /**
   * Builder.
   */
  public static class Builder {
    private ReplicationDocument replicationDocument;

    private Builder(PostReplicateOptions postReplicateOptions) {
      this.replicationDocument = postReplicateOptions.replicationDocument;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PostReplicateOptions.
     *
     * @return the new PostReplicateOptions instance
     */
    public PostReplicateOptions build() {
      return new PostReplicateOptions(this);
    }

    /**
     * Set the replicationDocument.
     *
     * @param replicationDocument the replicationDocument
     * @return the PostReplicateOptions builder
     */
    public Builder replicationDocument(ReplicationDocument replicationDocument) {
      this.replicationDocument = replicationDocument;
      return this;
    }
  }

  protected PostReplicateOptions(Builder builder) {
    replicationDocument = builder.replicationDocument;
  }

  /**
   * New builder.
   *
   * @return a PostReplicateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the replicationDocument.
   *
   * HTTP request body for replication operations.
   *
   * @return the replicationDocument
   */
  public ReplicationDocument replicationDocument() {
    return replicationDocument;
  }
}

