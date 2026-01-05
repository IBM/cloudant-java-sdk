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
 * The postReplicator options.
 */
public class PostReplicatorOptions extends GenericModel {

  /**
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   */
  public interface Batch {
    /** ok. */
    String OK = "ok";
  }

  protected ReplicationDocument replicationDocument;
  protected String batch;

  /**
   * Builder.
   */
  public static class Builder {
    private ReplicationDocument replicationDocument;
    private String batch;

    /**
     * Instantiates a new Builder from an existing PostReplicatorOptions instance.
     *
     * @param postReplicatorOptions the instance to initialize the Builder with
     */
    private Builder(PostReplicatorOptions postReplicatorOptions) {
      this.replicationDocument = postReplicatorOptions.replicationDocument;
      this.batch = postReplicatorOptions.batch;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param replicationDocument the replicationDocument
     */
    public Builder(ReplicationDocument replicationDocument) {
      this.replicationDocument = replicationDocument;
    }

    /**
     * Builds a PostReplicatorOptions.
     *
     * @return the new PostReplicatorOptions instance
     */
    public PostReplicatorOptions build() {
      return new PostReplicatorOptions(this);
    }

    /**
     * Set the replicationDocument.
     *
     * @param replicationDocument the replicationDocument
     * @return the PostReplicatorOptions builder
     */
    public Builder replicationDocument(ReplicationDocument replicationDocument) {
      this.replicationDocument = replicationDocument;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the PostReplicatorOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }
  }

  protected PostReplicatorOptions() { }

  protected PostReplicatorOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.replicationDocument,
      "replicationDocument cannot be null");
    replicationDocument = builder.replicationDocument;
    batch = builder.batch;
  }

  /**
   * New builder.
   *
   * @return a PostReplicatorOptions builder
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

  /**
   * Gets the batch.
   *
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   *
   * @return the batch
   */
  public String batch() {
    return batch;
  }
}

