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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getIndexInfo options.
 */
public class GetIndexInfoOptions extends GenericModel {

  public interface Type {
    /** search. */
    String SEARCH = "search";
    /** view. */
    String VIEW = "view";
  }

  protected String db;
  protected Boolean descending;
  protected String endKey;
  protected Boolean inclusiveEnd;
  protected String keys;
  protected Long limit;
  protected Long skip;
  protected String startKey;
  protected List<String> type;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private Boolean descending;
    private String endKey;
    private Boolean inclusiveEnd;
    private String keys;
    private Long limit;
    private Long skip;
    private String startKey;
    private List<String> type;

    /**
     * Instantiates a new Builder from an existing GetIndexInfoOptions instance.
     *
     * @param getIndexInfoOptions the instance to initialize the Builder with
     */
    private Builder(GetIndexInfoOptions getIndexInfoOptions) {
      this.db = getIndexInfoOptions.db;
      this.descending = getIndexInfoOptions.descending;
      this.endKey = getIndexInfoOptions.endKey;
      this.inclusiveEnd = getIndexInfoOptions.inclusiveEnd;
      this.keys = getIndexInfoOptions.keys;
      this.limit = getIndexInfoOptions.limit;
      this.skip = getIndexInfoOptions.skip;
      this.startKey = getIndexInfoOptions.startKey;
      this.type = getIndexInfoOptions.type;
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
     * Builds a GetIndexInfoOptions.
     *
     * @return the new GetIndexInfoOptions instance
     */
    public GetIndexInfoOptions build() {
      return new GetIndexInfoOptions(this);
    }

    /**
     * Adds a new element to type.
     *
     * @param type the new element to be added
     * @return the GetIndexInfoOptions builder
     */
    public Builder addType(String type) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(type,
        "type cannot be null");
      if (this.type == null) {
        this.type = new ArrayList<String>();
      }
      this.type.add(type);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the GetIndexInfoOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the descending.
     *
     * @param descending the descending
     * @return the GetIndexInfoOptions builder
     */
    public Builder descending(Boolean descending) {
      this.descending = descending;
      return this;
    }

    /**
     * Set the endKey.
     *
     * @param endKey the endKey
     * @return the GetIndexInfoOptions builder
     */
    public Builder endKey(String endKey) {
      this.endKey = endKey;
      return this;
    }

    /**
     * Set the inclusiveEnd.
     *
     * @param inclusiveEnd the inclusiveEnd
     * @return the GetIndexInfoOptions builder
     */
    public Builder inclusiveEnd(Boolean inclusiveEnd) {
      this.inclusiveEnd = inclusiveEnd;
      return this;
    }

    /**
     * Set the keys.
     *
     * @param keys the keys
     * @return the GetIndexInfoOptions builder
     */
    public Builder keys(String keys) {
      this.keys = keys;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetIndexInfoOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the GetIndexInfoOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the startKey.
     *
     * @param startKey the startKey
     * @return the GetIndexInfoOptions builder
     */
    public Builder startKey(String startKey) {
      this.startKey = startKey;
      return this;
    }

    /**
     * Set the type.
     * Existing type will be replaced.
     *
     * @param type the type
     * @return the GetIndexInfoOptions builder
     */
    public Builder type(List<String> type) {
      this.type = type;
      return this;
    }
  }

  protected GetIndexInfoOptions() { }

  protected GetIndexInfoOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    descending = builder.descending;
    endKey = builder.endKey;
    inclusiveEnd = builder.inclusiveEnd;
    keys = builder.keys;
    limit = builder.limit;
    skip = builder.skip;
    startKey = builder.startKey;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a GetIndexInfoOptions builder
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
   * Gets the inclusiveEnd.
   *
   * Query parameter to specify whether the specified end key should be included in the result.
   *
   * @return the inclusiveEnd
   */
  public Boolean inclusiveEnd() {
    return inclusiveEnd;
  }

  /**
   * Gets the keys.
   *
   * Query parameter to specify returning only rows that match any of the specified keys. String representation of a
   * JSON array of keys that match the key type emitted by the view function. Must be URL encoded.
   *
   * @return the keys
   */
  public String keys() {
    return keys;
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

  /**
   * Gets the type.
   *
   * Index types to filter results by. Can be `view`, `search`, or both values comma-separated. If omitted, the response
   * includes all index types.
   *
   * @return the type
   */
  public List<String> type() {
    return type;
  }
}

