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
 * The getAllDbs options.
 */
public class GetAllDbsOptions extends GenericModel {

  protected Boolean descending;
  protected String endKey;
  protected Long limit;
  protected Long skip;
  protected String startKey;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean descending;
    private String endKey;
    private Long limit;
    private Long skip;
    private String startKey;

    /**
     * Instantiates a new Builder from an existing GetAllDbsOptions instance.
     *
     * @param getAllDbsOptions the instance to initialize the Builder with
     */
    private Builder(GetAllDbsOptions getAllDbsOptions) {
      this.descending = getAllDbsOptions.descending;
      this.endKey = getAllDbsOptions.endKey;
      this.limit = getAllDbsOptions.limit;
      this.skip = getAllDbsOptions.skip;
      this.startKey = getAllDbsOptions.startKey;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetAllDbsOptions.
     *
     * @return the new GetAllDbsOptions instance
     */
    public GetAllDbsOptions build() {
      return new GetAllDbsOptions(this);
    }

    /**
     * Set the descending.
     *
     * @param descending the descending
     * @return the GetAllDbsOptions builder
     */
    public Builder descending(Boolean descending) {
      this.descending = descending;
      return this;
    }

    /**
     * Set the endKey.
     *
     * @param endKey the endKey
     * @return the GetAllDbsOptions builder
     */
    public Builder endKey(String endKey) {
      this.endKey = endKey;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetAllDbsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the GetAllDbsOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the startKey.
     *
     * @param startKey the startKey
     * @return the GetAllDbsOptions builder
     */
    public Builder startKey(String startKey) {
      this.startKey = startKey;
      return this;
    }
  }

  protected GetAllDbsOptions() { }

  protected GetAllDbsOptions(Builder builder) {
    descending = builder.descending;
    endKey = builder.endKey;
    limit = builder.limit;
    skip = builder.skip;
    startKey = builder.startKey;
  }

  /**
   * New builder.
   *
   * @return a GetAllDbsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the descending.
   *
   * Query parameter to specify whether to return rows in descending by key order.
   *
   * @return the descending
   */
  public Boolean descending() {
    return descending;
  }

  /**
   * Gets the endKey.
   *
   * Query parameter to specify to stop returning records when the specified key is reached. String representation of
   * any JSON type that matches the key type emitted by the view function.
   *
   * @return the endKey
   */
  public String endKey() {
    return endKey;
  }

  /**
   * Gets the limit.
   *
   * Query parameter to specify the number of returned documents to limit the result to.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the skip.
   *
   * Query parameter to specify the number of records before starting to return the results.
   *
   * @return the skip
   */
  public Long skip() {
    return skip;
  }

  /**
   * Gets the startKey.
   *
   * Query parameter to specify to start returning records from the specified key. String representation of any JSON
   * type that matches the key type emitted by the view function.
   *
   * @return the startKey
   */
  public String startKey() {
    return startKey;
  }
}

