/*
 * (C) Copyright IBM Corp. 2022.
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
 * The postPartitionAllDocs options.
 */
public class PostPartitionAllDocsOptions extends GenericModel {

  protected String db;
  protected String partitionKey;
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
    private String partitionKey;
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

    private Builder(PostPartitionAllDocsOptions postPartitionAllDocsOptions) {
      this.db = postPartitionAllDocsOptions.db;
      this.partitionKey = postPartitionAllDocsOptions.partitionKey;
      this.attEncodingInfo = postPartitionAllDocsOptions.attEncodingInfo;
      this.attachments = postPartitionAllDocsOptions.attachments;
      this.conflicts = postPartitionAllDocsOptions.conflicts;
      this.descending = postPartitionAllDocsOptions.descending;
      this.includeDocs = postPartitionAllDocsOptions.includeDocs;
      this.inclusiveEnd = postPartitionAllDocsOptions.inclusiveEnd;
      this.limit = postPartitionAllDocsOptions.limit;
      this.skip = postPartitionAllDocsOptions.skip;
      this.updateSeq = postPartitionAllDocsOptions.updateSeq;
      this.endKey = postPartitionAllDocsOptions.endKey;
      this.key = postPartitionAllDocsOptions.key;
      this.keys = postPartitionAllDocsOptions.keys;
      this.startKey = postPartitionAllDocsOptions.startKey;
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
     * Builds a PostPartitionAllDocsOptions.
     *
     * @return the new PostPartitionAllDocsOptions instance
     */
    public PostPartitionAllDocsOptions build() {
      return new PostPartitionAllDocsOptions(this);
    }

    /**
     * Adds an keys to keys.
     *
     * @param keys the new keys
     * @return the PostPartitionAllDocsOptions builder
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
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the partitionKey.
     *
     * @param partitionKey the partitionKey
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder partitionKey(String partitionKey) {
      this.partitionKey = partitionKey;
      return this;
    }

    /**
     * Set the attEncodingInfo.
     *
     * @param attEncodingInfo the attEncodingInfo
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder attEncodingInfo(Boolean attEncodingInfo) {
      this.attEncodingInfo = attEncodingInfo;
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder attachments(Boolean attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the conflicts.
     *
     * @param conflicts the conflicts
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder conflicts(Boolean conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the descending.
     *
     * @param descending the descending
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder descending(Boolean descending) {
      this.descending = descending;
      return this;
    }

    /**
     * Set the includeDocs.
     *
     * @param includeDocs the includeDocs
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder includeDocs(Boolean includeDocs) {
      this.includeDocs = includeDocs;
      return this;
    }

    /**
     * Set the inclusiveEnd.
     *
     * @param inclusiveEnd the inclusiveEnd
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder inclusiveEnd(Boolean inclusiveEnd) {
      this.inclusiveEnd = inclusiveEnd;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the updateSeq.
     *
     * @param updateSeq the updateSeq
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder updateSeq(Boolean updateSeq) {
      this.updateSeq = updateSeq;
      return this;
    }

    /**
     * Set the endKey.
     *
     * @param endKey the endKey
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder endKey(String endKey) {
      this.endKey = endKey;
      return this;
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the PostPartitionAllDocsOptions builder
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
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder keys(List<String> keys) {
      this.keys = keys;
      return this;
    }

    /**
     * Set the startKey.
     *
     * @param startKey the startKey
     * @return the PostPartitionAllDocsOptions builder
     */
    public Builder startKey(String startKey) {
      this.startKey = startKey;
      return this;
    }
  }

  protected PostPartitionAllDocsOptions() { }

  protected PostPartitionAllDocsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.partitionKey,
      "partitionKey cannot be empty");
    db = builder.db;
    partitionKey = builder.partitionKey;
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
   * @return a PostPartitionAllDocsOptions builder
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

