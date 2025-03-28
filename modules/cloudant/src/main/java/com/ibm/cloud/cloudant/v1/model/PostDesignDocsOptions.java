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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postDesignDocs options.
 */
public class PostDesignDocsOptions extends GenericModel {

  protected String db;
  protected Boolean attEncodingInfo;
  protected Boolean attachments;
  protected Boolean conflicts;
  protected Boolean descending;
  protected Boolean includeDocs;
  protected Boolean inclusiveEnd;
  protected Long limit;
  protected Long skip;
  protected Boolean updateSeq;
  protected String endKey;
  protected String key;
  protected List<String> keys;
  protected String startKey;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private Boolean attEncodingInfo;
    private Boolean attachments;
    private Boolean conflicts;
    private Boolean descending;
    private Boolean includeDocs;
    private Boolean inclusiveEnd;
    private Long limit;
    private Long skip;
    private Boolean updateSeq;
    private String endKey;
    private String key;
    private List<String> keys;
    private String startKey;

    /**
     * Instantiates a new Builder from an existing PostDesignDocsOptions instance.
     *
     * @param postDesignDocsOptions the instance to initialize the Builder with
     */
    private Builder(PostDesignDocsOptions postDesignDocsOptions) {
      this.db = postDesignDocsOptions.db;
      this.attEncodingInfo = postDesignDocsOptions.attEncodingInfo;
      this.attachments = postDesignDocsOptions.attachments;
      this.conflicts = postDesignDocsOptions.conflicts;
      this.descending = postDesignDocsOptions.descending;
      this.includeDocs = postDesignDocsOptions.includeDocs;
      this.inclusiveEnd = postDesignDocsOptions.inclusiveEnd;
      this.limit = postDesignDocsOptions.limit;
      this.skip = postDesignDocsOptions.skip;
      this.updateSeq = postDesignDocsOptions.updateSeq;
      this.endKey = postDesignDocsOptions.endKey;
      this.key = postDesignDocsOptions.key;
      this.keys = postDesignDocsOptions.keys;
      this.startKey = postDesignDocsOptions.startKey;
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
     * Builds a PostDesignDocsOptions.
     *
     * @return the new PostDesignDocsOptions instance
     */
    public PostDesignDocsOptions build() {
      return new PostDesignDocsOptions(this);
    }

    /**
     * Adds a new element to keys.
     *
     * @param keys the new element to be added
     * @return the PostDesignDocsOptions builder
     */
    public Builder addKeys(String keys) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(keys,
        "keys cannot be null");
      if (this.keys == null) {
        this.keys = new ArrayList<String>();
      }
      this.keys.add(keys);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostDesignDocsOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the attEncodingInfo.
     *
     * @param attEncodingInfo the attEncodingInfo
     * @return the PostDesignDocsOptions builder
     */
    public Builder attEncodingInfo(Boolean attEncodingInfo) {
      this.attEncodingInfo = attEncodingInfo;
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the PostDesignDocsOptions builder
     */
    public Builder attachments(Boolean attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the conflicts.
     *
     * @param conflicts the conflicts
     * @return the PostDesignDocsOptions builder
     */
    public Builder conflicts(Boolean conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the descending.
     *
     * @param descending the descending
     * @return the PostDesignDocsOptions builder
     */
    public Builder descending(Boolean descending) {
      this.descending = descending;
      return this;
    }

    /**
     * Set the includeDocs.
     *
     * @param includeDocs the includeDocs
     * @return the PostDesignDocsOptions builder
     */
    public Builder includeDocs(Boolean includeDocs) {
      this.includeDocs = includeDocs;
      return this;
    }

    /**
     * Set the inclusiveEnd.
     *
     * @param inclusiveEnd the inclusiveEnd
     * @return the PostDesignDocsOptions builder
     */
    public Builder inclusiveEnd(Boolean inclusiveEnd) {
      this.inclusiveEnd = inclusiveEnd;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the PostDesignDocsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the PostDesignDocsOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the updateSeq.
     *
     * @param updateSeq the updateSeq
     * @return the PostDesignDocsOptions builder
     */
    public Builder updateSeq(Boolean updateSeq) {
      this.updateSeq = updateSeq;
      return this;
    }

    /**
     * Set the endKey.
     *
     * @param endKey the endKey
     * @return the PostDesignDocsOptions builder
     */
    public Builder endKey(String endKey) {
      this.endKey = endKey;
      return this;
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the PostDesignDocsOptions builder
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Set the keys.
     * Existing keys will be replaced.
     *
     * @param keys the keys
     * @return the PostDesignDocsOptions builder
     */
    public Builder keys(List<String> keys) {
      this.keys = keys;
      return this;
    }

    /**
     * Set the startKey.
     *
     * @param startKey the startKey
     * @return the PostDesignDocsOptions builder
     */
    public Builder startKey(String startKey) {
      this.startKey = startKey;
      return this;
    }
  }

  protected PostDesignDocsOptions() { }

  protected PostDesignDocsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    attEncodingInfo = builder.attEncodingInfo;
    attachments = builder.attachments;
    conflicts = builder.conflicts;
    descending = builder.descending;
    includeDocs = builder.includeDocs;
    inclusiveEnd = builder.inclusiveEnd;
    limit = builder.limit;
    skip = builder.skip;
    updateSeq = builder.updateSeq;
    endKey = builder.endKey;
    key = builder.key;
    keys = builder.keys;
    startKey = builder.startKey;
  }

  /**
   * New builder.
   *
   * @return a PostDesignDocsOptions builder
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
   * Gets the attEncodingInfo.
   *
   * Parameter to specify whether to include the encoding information in attachment stubs if the particular attachment
   * is compressed.
   *
   * @return the attEncodingInfo
   */
  public Boolean attEncodingInfo() {
    return attEncodingInfo;
  }

  /**
   * Gets the attachments.
   *
   * Parameter to specify whether to include attachments bodies in a response.
   *
   * @return the attachments
   */
  public Boolean attachments() {
    return attachments;
  }

  /**
   * Gets the conflicts.
   *
   * Parameter to specify whether to include a list of conflicted revisions in each returned document. Active only when
   * `include_docs` is `true`.
   *
   * @return the conflicts
   */
  public Boolean conflicts() {
    return conflicts;
  }

  /**
   * Gets the descending.
   *
   * Parameter to specify whether to return the documents in descending by key order.
   *
   * @return the descending
   */
  public Boolean descending() {
    return descending;
  }

  /**
   * Gets the includeDocs.
   *
   * Parameter to specify whether to include the full content of the documents in the response.
   *
   * @return the includeDocs
   */
  public Boolean includeDocs() {
    return includeDocs;
  }

  /**
   * Gets the inclusiveEnd.
   *
   * Parameter to specify whether the specified end key should be included in the result.
   *
   * @return the inclusiveEnd
   */
  public Boolean inclusiveEnd() {
    return inclusiveEnd;
  }

  /**
   * Gets the limit.
   *
   * Parameter to specify the number of returned documents to limit the result to.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the skip.
   *
   * Parameter to specify the number of records before starting to return the results.
   *
   * @return the skip
   */
  public Long skip() {
    return skip;
  }

  /**
   * Gets the updateSeq.
   *
   * Parameter to specify whether to include in the response an update_seq value indicating the sequence id of the
   * database the view reflects.
   *
   * @return the updateSeq
   */
  public Boolean updateSeq() {
    return updateSeq;
  }

  /**
   * Gets the endKey.
   *
   * Schema for a document ID.
   *
   * @return the endKey
   */
  public String endKey() {
    return endKey;
  }

  /**
   * Gets the key.
   *
   * Schema for a document ID.
   *
   * @return the key
   */
  public String key() {
    return key;
  }

  /**
   * Gets the keys.
   *
   * Schema for a list of document IDs.
   *
   * @return the keys
   */
  public List<String> keys() {
    return keys;
  }

  /**
   * Gets the startKey.
   *
   * Schema for a document ID.
   *
   * @return the startKey
   */
  public String startKey() {
    return startKey;
  }
}

