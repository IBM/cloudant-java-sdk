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
 * The getAllDbs options.
 */
public class GetAllDbsOptions extends GenericModel {

  protected Boolean descending;
  protected String endkey;
  protected Long limit;
  protected Long skip;
  protected String startkey;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean descending;
    private String endkey;
    private Long limit;
    private Long skip;
    private String startkey;

    private Builder(GetAllDbsOptions getAllDbsOptions) {
      this.descending = getAllDbsOptions.descending;
      this.endkey = getAllDbsOptions.endkey;
      this.limit = getAllDbsOptions.limit;
      this.skip = getAllDbsOptions.skip;
      this.startkey = getAllDbsOptions.startkey;
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
     * Set the endkey.
     *
     * @param endkey the endkey
     * @return the GetAllDbsOptions builder
     */
    public Builder endkey(String endkey) {
      this.endkey = endkey;
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
     * Set the startkey.
     *
     * @param startkey the startkey
     * @return the GetAllDbsOptions builder
     */
    public Builder startkey(String startkey) {
      this.startkey = startkey;
      return this;
    }
  }

  protected GetAllDbsOptions(Builder builder) {
    descending = builder.descending;
    endkey = builder.endkey;
    limit = builder.limit;
    skip = builder.skip;
    startkey = builder.startkey;
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
   * Query parameter to specify whether to return the documents in descending by key order.
   *
   * @return the descending
   */
  public Boolean descending() {
    return descending;
  }

  /**
   * Gets the endkey.
   *
   * Query parameter to specify to stop returning records when the specified key is reached. String representation of
   * any JSON type that matches the key type emitted by the view function.
   *
   * @return the endkey
   */
  public String endkey() {
    return endkey;
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
   * Gets the startkey.
   *
   * Query parameter to specify to start returning records from the specified key. String representation of any JSON
   * type that matches the key type emitted by the view function.
   *
   * @return the startkey
   */
  public String startkey() {
    return startkey;
  }
}

