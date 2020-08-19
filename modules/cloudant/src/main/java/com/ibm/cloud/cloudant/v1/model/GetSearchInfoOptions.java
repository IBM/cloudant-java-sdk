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
 * The getSearchInfo options.
 */
public class GetSearchInfoOptions extends GenericModel {

  protected String db;
  protected String ddoc;
  protected String index;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String ddoc;
    private String index;

    private Builder(GetSearchInfoOptions getSearchInfoOptions) {
      this.db = getSearchInfoOptions.db;
      this.ddoc = getSearchInfoOptions.ddoc;
      this.index = getSearchInfoOptions.index;
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
     * @param ddoc the ddoc
     * @param index the index
     */
    public Builder(String db, String ddoc, String index) {
      this.db = db;
      this.ddoc = ddoc;
      this.index = index;
    }

    /**
     * Builds a GetSearchInfoOptions.
     *
     * @return the new GetSearchInfoOptions instance
     */
    public GetSearchInfoOptions build() {
      return new GetSearchInfoOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the GetSearchInfoOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the GetSearchInfoOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the index.
     *
     * @param index the index
     * @return the GetSearchInfoOptions builder
     */
    public Builder index(String index) {
      this.index = index;
      return this;
    }
  }

  protected GetSearchInfoOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ddoc,
      "ddoc cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.index,
      "index cannot be empty");
    db = builder.db;
    ddoc = builder.ddoc;
    index = builder.index;
  }

  /**
   * New builder.
   *
   * @return a GetSearchInfoOptions builder
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
   * Gets the ddoc.
   *
   * Path parameter to specify the design document name. The design document name is the design document ID excluding
   * the `_design/` prefix.
   *
   * @return the ddoc
   */
  public String ddoc() {
    return ddoc;
  }

  /**
   * Gets the index.
   *
   * Path parameter to specify the index name.
   *
   * @return the index
   */
  public String index() {
    return index;
  }
}

