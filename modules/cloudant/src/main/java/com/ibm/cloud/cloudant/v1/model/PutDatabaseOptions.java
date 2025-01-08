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
 * The putDatabase options.
 */
public class PutDatabaseOptions extends GenericModel {

  protected String db;
  protected Boolean partitioned;
  protected Long q;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private Boolean partitioned;
    private Long q;

    /**
     * Instantiates a new Builder from an existing PutDatabaseOptions instance.
     *
     * @param putDatabaseOptions the instance to initialize the Builder with
     */
    private Builder(PutDatabaseOptions putDatabaseOptions) {
      this.db = putDatabaseOptions.db;
      this.partitioned = putDatabaseOptions.partitioned;
      this.q = putDatabaseOptions.q;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param db the db
     */
    public Builder(String db) {
      this.db = db;
    }

    /**
     * Builds a PutDatabaseOptions.
     *
     * @return the new PutDatabaseOptions instance
     */
    public PutDatabaseOptions build() {
      return new PutDatabaseOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PutDatabaseOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the partitioned.
     *
     * @param partitioned the partitioned
     * @return the PutDatabaseOptions builder
     */
    public Builder partitioned(Boolean partitioned) {
      this.partitioned = partitioned;
      return this;
    }

    /**
     * Set the q.
     *
     * @param q the q
     * @return the PutDatabaseOptions builder
     */
    public Builder q(long q) {
      this.q = q;
      return this;
    }
  }

  protected PutDatabaseOptions() { }

  protected PutDatabaseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    partitioned = builder.partitioned;
    q = builder.q;
  }

  /**
   * New builder.
   *
   * @return a PutDatabaseOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the db.
   *
   * Path parameter to specify the database name.
   *
   * @return the db
   */
  public String db() {
    return db;
  }

  /**
   * Gets the partitioned.
   *
   * Query parameter to specify whether to enable database partitions when creating a database.
   *
   * Before using read the
   * [FAQs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-database-partitioning#partitioned-databases-database-partitioning)
   * to understand the limitations and appropriate use cases.
   *
   * @return the partitioned
   */
  public Boolean partitioned() {
    return partitioned;
  }

  /**
   * Gets the q.
   *
   * The number of shards in the database. Each shard is a partition of the hash value range. Cloudant recommends using
   * the default value for most databases. However, if your database is expected to be larger than 250 GB or have a lot
   * of indexes, you may need to adjust the settings. In these cases, it's best to reach out to IBM Cloudant customer
   * support for guidance on how to meet your specific needs and requirements.
   *
   * @return the q
   */
  public Long q() {
    return q;
  }
}

