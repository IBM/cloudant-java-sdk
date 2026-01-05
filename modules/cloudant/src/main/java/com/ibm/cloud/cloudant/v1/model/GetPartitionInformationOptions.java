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
 * The getPartitionInformation options.
 */
public class GetPartitionInformationOptions extends GenericModel {

  protected String db;
  protected String partitionKey;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String partitionKey;

    /**
     * Instantiates a new Builder from an existing GetPartitionInformationOptions instance.
     *
     * @param getPartitionInformationOptions the instance to initialize the Builder with
     */
    private Builder(GetPartitionInformationOptions getPartitionInformationOptions) {
      this.db = getPartitionInformationOptions.db;
      this.partitionKey = getPartitionInformationOptions.partitionKey;
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
     * @param partitionKey the partitionKey
     */
    public Builder(String db, String partitionKey) {
      this.db = db;
      this.partitionKey = partitionKey;
    }

    /**
     * Builds a GetPartitionInformationOptions.
     *
     * @return the new GetPartitionInformationOptions instance
     */
    public GetPartitionInformationOptions build() {
      return new GetPartitionInformationOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the GetPartitionInformationOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the partitionKey.
     *
     * @param partitionKey the partitionKey
     * @return the GetPartitionInformationOptions builder
     */
    public Builder partitionKey(String partitionKey) {
      this.partitionKey = partitionKey;
      return this;
    }
  }

  protected GetPartitionInformationOptions() { }

  protected GetPartitionInformationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.partitionKey,
      "partitionKey cannot be empty");
    db = builder.db;
    partitionKey = builder.partitionKey;
  }

  /**
   * New builder.
   *
   * @return a GetPartitionInformationOptions builder
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
   * Gets the partitionKey.
   *
   * Path parameter to specify the database partition key.
   *
   * @return the partitionKey
   */
  public String partitionKey() {
    return partitionKey;
  }
}

