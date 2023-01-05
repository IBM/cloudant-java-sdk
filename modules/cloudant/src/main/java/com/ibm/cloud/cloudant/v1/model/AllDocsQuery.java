/*
 * (C) Copyright IBM Corp. 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for an all documents query operation.
 */
public class AllDocsQuery extends GenericModel {

  @SerializedName("att_encoding_info")
  protected Boolean attEncodingInfo;
  protected Boolean attachments;
  protected Boolean conflicts;
  protected Boolean descending;
  @SerializedName("include_docs")
  protected Boolean includeDocs;
  @SerializedName("inclusive_end")
  protected Boolean inclusiveEnd;
  protected Long limit;
  protected Long skip;
  @SerializedName("update_seq")
  protected Boolean updateSeq;
  @SerializedName("end_key")
  protected String endKey;
  protected String key;
  protected List<String> keys;
  @SerializedName("start_key")
  protected String startKey;

  /**
   * Builder.
   */
  public static class Builder {
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
     * Instantiates a new Builder from an existing AllDocsQuery instance.
     *
     * @param allDocsQuery the instance to initialize the Builder with
     */
    private Builder(AllDocsQuery allDocsQuery) {
      this.attEncodingInfo = allDocsQuery.attEncodingInfo;
      this.attachments = allDocsQuery.attachments;
      this.conflicts = allDocsQuery.conflicts;
      this.descending = allDocsQuery.descending;
      this.includeDocs = allDocsQuery.includeDocs;
      this.inclusiveEnd = allDocsQuery.inclusiveEnd;
      this.limit = allDocsQuery.limit;
      this.skip = allDocsQuery.skip;
      this.updateSeq = allDocsQuery.updateSeq;
      this.endKey = allDocsQuery.endKey;
      this.key = allDocsQuery.key;
      this.keys = allDocsQuery.keys;
      this.startKey = allDocsQuery.startKey;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AllDocsQuery.
     *
     * @return the new AllDocsQuery instance
     */
    public AllDocsQuery build() {
      return new AllDocsQuery(this);
    }

    /**
     * Adds an keys to keys.
     *
     * @param keys the new keys
     * @return the AllDocsQuery builder
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
     * Set the attEncodingInfo.
     *
     * @param attEncodingInfo the attEncodingInfo
     * @return the AllDocsQuery builder
     */
    public Builder attEncodingInfo(Boolean attEncodingInfo) {
      this.attEncodingInfo = attEncodingInfo;
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the AllDocsQuery builder
     */
    public Builder attachments(Boolean attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the conflicts.
     *
     * @param conflicts the conflicts
     * @return the AllDocsQuery builder
     */
    public Builder conflicts(Boolean conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the descending.
     *
     * @param descending the descending
     * @return the AllDocsQuery builder
     */
    public Builder descending(Boolean descending) {
      this.descending = descending;
      return this;
    }

    /**
     * Set the includeDocs.
     *
     * @param includeDocs the includeDocs
     * @return the AllDocsQuery builder
     */
    public Builder includeDocs(Boolean includeDocs) {
      this.includeDocs = includeDocs;
      return this;
    }

    /**
     * Set the inclusiveEnd.
     *
     * @param inclusiveEnd the inclusiveEnd
     * @return the AllDocsQuery builder
     */
    public Builder inclusiveEnd(Boolean inclusiveEnd) {
      this.inclusiveEnd = inclusiveEnd;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the AllDocsQuery builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the AllDocsQuery builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the updateSeq.
     *
     * @param updateSeq the updateSeq
     * @return the AllDocsQuery builder
     */
    public Builder updateSeq(Boolean updateSeq) {
      this.updateSeq = updateSeq;
      return this;
    }

    /**
     * Set the endKey.
     *
     * @param endKey the endKey
     * @return the AllDocsQuery builder
     */
    public Builder endKey(String endKey) {
      this.endKey = endKey;
      return this;
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the AllDocsQuery builder
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
     * @return the AllDocsQuery builder
     */
    public Builder keys(List<String> keys) {
      this.keys = keys;
      return this;
    }

    /**
     * Set the startKey.
     *
     * @param startKey the startKey
     * @return the AllDocsQuery builder
     */
    public Builder startKey(String startKey) {
      this.startKey = startKey;
      return this;
    }
  }

  protected AllDocsQuery() { }

  protected AllDocsQuery(Builder builder) {
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
   * @return a AllDocsQuery builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

