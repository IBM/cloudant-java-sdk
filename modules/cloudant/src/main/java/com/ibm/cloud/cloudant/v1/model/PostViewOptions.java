/*
 * (C) Copyright IBM Corp. 2024.
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
 * The postView options.
 */
public class PostViewOptions extends GenericModel {

  /**
   * Parameter to specify whether or not the view in question should be updated prior to responding to the user.
   *
   * * `true` - Return results after the view is updated.
   * * `false` - Return results without updating the view.
   * * `lazy` - Return the view results without waiting for an update, but update them immediately after the request.
   */
  public interface Update {
    /** true. */
    String X_TRUE = "true";
    /** false. */
    String X_FALSE = "false";
    /** lazy. */
    String LAZY = "lazy";
  }

  protected String db;
  protected String ddoc;
  protected String view;
  protected Boolean attEncodingInfo;
  protected Boolean attachments;
  protected Boolean conflicts;
  protected Boolean descending;
  protected Boolean includeDocs;
  protected Boolean inclusiveEnd;
  protected Long limit;
  protected Long skip;
  protected Boolean updateSeq;
  protected Object endKey;
  protected String endKeyDocId;
  protected Boolean group;
  protected Long groupLevel;
  protected Object key;
  protected List<Object> keys;
  protected Boolean reduce;
  protected Boolean stable;
  protected Object startKey;
  protected String startKeyDocId;
  protected String update;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String ddoc;
    private String view;
    private Boolean attEncodingInfo;
    private Boolean attachments;
    private Boolean conflicts;
    private Boolean descending;
    private Boolean includeDocs;
    private Boolean inclusiveEnd;
    private Long limit;
    private Long skip;
    private Boolean updateSeq;
    private Object endKey;
    private String endKeyDocId;
    private Boolean group;
    private Long groupLevel;
    private Object key;
    private List<Object> keys;
    private Boolean reduce;
    private Boolean stable;
    private Object startKey;
    private String startKeyDocId;
    private String update;

    /**
     * Instantiates a new Builder from an existing PostViewOptions instance.
     *
     * @param postViewOptions the instance to initialize the Builder with
     */
    private Builder(PostViewOptions postViewOptions) {
      this.db = postViewOptions.db;
      this.ddoc = postViewOptions.ddoc;
      this.view = postViewOptions.view;
      this.attEncodingInfo = postViewOptions.attEncodingInfo;
      this.attachments = postViewOptions.attachments;
      this.conflicts = postViewOptions.conflicts;
      this.descending = postViewOptions.descending;
      this.includeDocs = postViewOptions.includeDocs;
      this.inclusiveEnd = postViewOptions.inclusiveEnd;
      this.limit = postViewOptions.limit;
      this.skip = postViewOptions.skip;
      this.updateSeq = postViewOptions.updateSeq;
      this.endKey = postViewOptions.endKey;
      this.endKeyDocId = postViewOptions.endKeyDocId;
      this.group = postViewOptions.group;
      this.groupLevel = postViewOptions.groupLevel;
      this.key = postViewOptions.key;
      this.keys = postViewOptions.keys;
      this.reduce = postViewOptions.reduce;
      this.stable = postViewOptions.stable;
      this.startKey = postViewOptions.startKey;
      this.startKeyDocId = postViewOptions.startKeyDocId;
      this.update = postViewOptions.update;
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
     * @param view the view
     */
    public Builder(String db, String ddoc, String view) {
      this.db = db;
      this.ddoc = ddoc;
      this.view = view;
    }

    /**
     * Builds a PostViewOptions.
     *
     * @return the new PostViewOptions instance
     */
    public PostViewOptions build() {
      return new PostViewOptions(this);
    }

    /**
     * Adds a new element to keys.
     *
     * @param keys the new element to be added
     * @return the PostViewOptions builder
     */
    public Builder addKeys(Object keys) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(keys,
        "keys cannot be null");
      if (this.keys == null) {
        this.keys = new ArrayList<Object>();
      }
      this.keys.add(keys);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostViewOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the PostViewOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the view.
     *
     * @param view the view
     * @return the PostViewOptions builder
     */
    public Builder view(String view) {
      this.view = view;
      return this;
    }

    /**
     * Set the attEncodingInfo.
     *
     * @param attEncodingInfo the attEncodingInfo
     * @return the PostViewOptions builder
     */
    public Builder attEncodingInfo(Boolean attEncodingInfo) {
      this.attEncodingInfo = attEncodingInfo;
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the PostViewOptions builder
     */
    public Builder attachments(Boolean attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the conflicts.
     *
     * @param conflicts the conflicts
     * @return the PostViewOptions builder
     */
    public Builder conflicts(Boolean conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the descending.
     *
     * @param descending the descending
     * @return the PostViewOptions builder
     */
    public Builder descending(Boolean descending) {
      this.descending = descending;
      return this;
    }

    /**
     * Set the includeDocs.
     *
     * @param includeDocs the includeDocs
     * @return the PostViewOptions builder
     */
    public Builder includeDocs(Boolean includeDocs) {
      this.includeDocs = includeDocs;
      return this;
    }

    /**
     * Set the inclusiveEnd.
     *
     * @param inclusiveEnd the inclusiveEnd
     * @return the PostViewOptions builder
     */
    public Builder inclusiveEnd(Boolean inclusiveEnd) {
      this.inclusiveEnd = inclusiveEnd;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the PostViewOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the PostViewOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the updateSeq.
     *
     * @param updateSeq the updateSeq
     * @return the PostViewOptions builder
     */
    public Builder updateSeq(Boolean updateSeq) {
      this.updateSeq = updateSeq;
      return this;
    }

    /**
     * Set the endKey.
     *
     * @param endKey the endKey
     * @return the PostViewOptions builder
     */
    public Builder endKey(Object endKey) {
      this.endKey = endKey;
      return this;
    }

    /**
     * Set the endKeyDocId.
     *
     * @param endKeyDocId the endKeyDocId
     * @return the PostViewOptions builder
     */
    public Builder endKeyDocId(String endKeyDocId) {
      this.endKeyDocId = endKeyDocId;
      return this;
    }

    /**
     * Set the group.
     *
     * @param group the group
     * @return the PostViewOptions builder
     */
    public Builder group(Boolean group) {
      this.group = group;
      return this;
    }

    /**
     * Set the groupLevel.
     *
     * @param groupLevel the groupLevel
     * @return the PostViewOptions builder
     */
    public Builder groupLevel(long groupLevel) {
      this.groupLevel = groupLevel;
      return this;
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the PostViewOptions builder
     */
    public Builder key(Object key) {
      this.key = key;
      return this;
    }

    /**
     * Set the keys.
     * Existing keys will be replaced.
     *
     * @param keys the keys
     * @return the PostViewOptions builder
     */
    public Builder keys(List<Object> keys) {
      this.keys = keys;
      return this;
    }

    /**
     * Set the reduce.
     *
     * @param reduce the reduce
     * @return the PostViewOptions builder
     */
    public Builder reduce(Boolean reduce) {
      this.reduce = reduce;
      return this;
    }

    /**
     * Set the stable.
     *
     * @param stable the stable
     * @return the PostViewOptions builder
     */
    public Builder stable(Boolean stable) {
      this.stable = stable;
      return this;
    }

    /**
     * Set the startKey.
     *
     * @param startKey the startKey
     * @return the PostViewOptions builder
     */
    public Builder startKey(Object startKey) {
      this.startKey = startKey;
      return this;
    }

    /**
     * Set the startKeyDocId.
     *
     * @param startKeyDocId the startKeyDocId
     * @return the PostViewOptions builder
     */
    public Builder startKeyDocId(String startKeyDocId) {
      this.startKeyDocId = startKeyDocId;
      return this;
    }

    /**
     * Set the update.
     *
     * @param update the update
     * @return the PostViewOptions builder
     */
    public Builder update(String update) {
      this.update = update;
      return this;
    }
  }

  protected PostViewOptions() { }

  protected PostViewOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ddoc,
      "ddoc cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.view,
      "view cannot be empty");
    db = builder.db;
    ddoc = builder.ddoc;
    view = builder.view;
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
    endKeyDocId = builder.endKeyDocId;
    group = builder.group;
    groupLevel = builder.groupLevel;
    key = builder.key;
    keys = builder.keys;
    reduce = builder.reduce;
    stable = builder.stable;
    startKey = builder.startKey;
    startKeyDocId = builder.startKeyDocId;
    update = builder.update;
  }

  /**
   * New builder.
   *
   * @return a PostViewOptions builder
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
   * Gets the view.
   *
   * Path parameter to specify the map reduce view function name.
   *
   * @return the view
   */
  public String view() {
    return view;
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
   * Schema for any JSON type.
   *
   * @return the endKey
   */
  public Object endKey() {
    return endKey;
  }

  /**
   * Gets the endKeyDocId.
   *
   * Schema for a document ID.
   *
   * @return the endKeyDocId
   */
  public String endKeyDocId() {
    return endKeyDocId;
  }

  /**
   * Gets the group.
   *
   * Parameter to specify whether to group reduced results by key. Valid only if a reduce function defined in the view.
   * If the view emits key in JSON array format, then it is possible to reduce groups further based on the number of
   * array elements with the `group_level` parameter.
   *
   * @return the group
   */
  public Boolean group() {
    return group;
  }

  /**
   * Gets the groupLevel.
   *
   * Parameter to specify a group level to be used. Only applicable if the view uses keys that are JSON arrays. Implies
   * group is `true`. Group level groups the reduced results by the specified number of array elements. If unset,
   * results are grouped by the entire array key, returning a reduced value for each complete key.
   *
   * @return the groupLevel
   */
  public Long groupLevel() {
    return groupLevel;
  }

  /**
   * Gets the key.
   *
   * Schema for any JSON type.
   *
   * @return the key
   */
  public Object key() {
    return key;
  }

  /**
   * Gets the keys.
   *
   * Parameter to specify returning only documents that match any of the specified keys. A JSON array of keys that match
   * the key type emitted by the view function.
   *
   * @return the keys
   */
  public List<Object> keys() {
    return keys;
  }

  /**
   * Gets the reduce.
   *
   * Parameter to specify whether to use the reduce function in a map-reduce view. Default is true when a reduce
   * function is defined.
   *
   * @return the reduce
   */
  public Boolean reduce() {
    return reduce;
  }

  /**
   * Gets the stable.
   *
   * Query parameter to specify whether use the same replica of  the index on each request. The default value `false`
   * contacts all  replicas and returns the result from the first, fastest, responder. Setting it to `true` when used in
   * conjunction with `update=false`  may improve consistency at the expense of increased latency and decreased
   * throughput if the selected replica is not the fastest of the available  replicas.
   *
   * **Note:** In general setting `true` is discouraged and is strictly not recommended when using `update=true`.
   *
   * @return the stable
   */
  public Boolean stable() {
    return stable;
  }

  /**
   * Gets the startKey.
   *
   * Schema for any JSON type.
   *
   * @return the startKey
   */
  public Object startKey() {
    return startKey;
  }

  /**
   * Gets the startKeyDocId.
   *
   * Schema for a document ID.
   *
   * @return the startKeyDocId
   */
  public String startKeyDocId() {
    return startKeyDocId;
  }

  /**
   * Gets the update.
   *
   * Parameter to specify whether or not the view in question should be updated prior to responding to the user.
   *
   * * `true` - Return results after the view is updated.
   * * `false` - Return results without updating the view.
   * * `lazy` - Return the view results without waiting for an update, but update them immediately after the request.
   *
   * @return the update
   */
  public String update() {
    return update;
  }
}

