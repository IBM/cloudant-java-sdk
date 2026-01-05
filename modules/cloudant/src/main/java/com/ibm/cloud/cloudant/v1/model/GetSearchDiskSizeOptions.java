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
 * The getSearchDiskSize options.
 */
public class GetSearchDiskSizeOptions extends GenericModel {

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

    /**
     * Instantiates a new Builder from an existing GetSearchDiskSizeOptions instance.
     *
     * @param getSearchDiskSizeOptions the instance to initialize the Builder with
     */
    private Builder(GetSearchDiskSizeOptions getSearchDiskSizeOptions) {
      this.db = getSearchDiskSizeOptions.db;
      this.ddoc = getSearchDiskSizeOptions.ddoc;
      this.index = getSearchDiskSizeOptions.index;
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
     * Builds a GetSearchDiskSizeOptions.
     *
     * @return the new GetSearchDiskSizeOptions instance
     */
    public GetSearchDiskSizeOptions build() {
      return new GetSearchDiskSizeOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the GetSearchDiskSizeOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the GetSearchDiskSizeOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the index.
     *
     * @param index the index
     * @return the GetSearchDiskSizeOptions builder
     */
    public Builder index(String index) {
      this.index = index;
      return this;
    }
  }

  protected GetSearchDiskSizeOptions() { }

  protected GetSearchDiskSizeOptions(Builder builder) {
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
   * @return a GetSearchDiskSizeOptions builder
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

