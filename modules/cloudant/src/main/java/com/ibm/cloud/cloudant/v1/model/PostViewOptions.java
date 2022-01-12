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
 * The postView options.
 */
public class PostViewOptions extends GenericModel {

  /**
   * Parameter to specify whether or not the view in question should be updated prior to responding to the user.
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
  protected Object endkey;
  protected String endkeyDocid;
  protected Boolean group;
  protected Long groupLevel;
  protected Object key;
  protected List<Object> keys;
  protected Boolean reduce;
  protected Boolean stable;
  protected Object startkey;
  protected String startkeyDocid;
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
    private Object endkey;
    private String endkeyDocid;
    private Boolean group;
    private Long groupLevel;
    private Object key;
    private List<Object> keys;
    private Boolean reduce;
    private Boolean stable;
    private Object startkey;
    private String startkeyDocid;
    private String update;

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
      this.endkey = postViewOptions.endkey;
      this.endkeyDocid = postViewOptions.endkeyDocid;
      this.group = postViewOptions.group;
      this.groupLevel = postViewOptions.groupLevel;
      this.key = postViewOptions.key;
      this.keys = postViewOptions.keys;
      this.reduce = postViewOptions.reduce;
      this.stable = postViewOptions.stable;
      this.startkey = postViewOptions.startkey;
      this.startkeyDocid = postViewOptions.startkeyDocid;
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
     * Adds an keys to keys.
     *
     * @param keys the new keys
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
     * Set the endkey.
     *
     * @param endkey the endkey
     * @return the PostViewOptions builder
     */
    public Builder endkey(Object endkey) {
      this.endkey = endkey;
      return this;
    }

    /**
     * Set the endkeyDocid.
     *
     * @param endkeyDocid the endkeyDocid
     * @return the PostViewOptions builder
     */
    public Builder endkeyDocid(String endkeyDocid) {
      this.endkeyDocid = endkeyDocid;
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
     * Set the startkey.
     *
     * @param startkey the startkey
     * @return the PostViewOptions builder
     */
    public Builder startkey(Object startkey) {
      this.startkey = startkey;
      return this;
    }

    /**
     * Set the startkeyDocid.
     *
     * @param startkeyDocid the startkeyDocid
     * @return the PostViewOptions builder
     */
    public Builder startkeyDocid(String startkeyDocid) {
      this.startkeyDocid = startkeyDocid;
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
    endkey = builder.endkey;
    endkeyDocid = builder.endkeyDocid;
    group = builder.group;
    groupLevel = builder.groupLevel;
    key = builder.key;
    keys = builder.keys;
    reduce = builder.reduce;
    stable = builder.stable;
    startkey = builder.startkey;
    startkeyDocid = builder.startkeyDocid;
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
   * Parameter to specify whether to include a list of conflicted revisions in the `_conflicts` property of the returned
   * document. Ignored if `include_docs` isn't `true`.
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
   * Gets the endkey.
   *
   * Schema for any JSON type.
   *
   * @return the endkey
   */
  public Object endkey() {
    return endkey;
  }

  /**
   * Gets the endkeyDocid.
   *
   * Schema for a document ID.
   *
   * @return the endkeyDocid
   */
  public String endkeyDocid() {
    return endkeyDocid;
  }

  /**
   * Gets the group.
   *
   * Parameter to specify whether to group the results using the reduce function to a group rather than a single row.
   * Implies reduce is true and the maximum group_level.
   *
   * @return the group
   */
  public Boolean group() {
    return group;
  }

  /**
   * Gets the groupLevel.
   *
   * Parameter to specify the group level to be used. Implies group is true.
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
   * Parameter to specify to return only documents that match the specified keys. String representation of a JSON array
   * containing elements that match the key type emitted by the view function.
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
   * Parameter to specify whether view results should be returned from a stable set of shards.
   *
   * @return the stable
   */
  public Boolean stable() {
    return stable;
  }

  /**
   * Gets the startkey.
   *
   * Schema for any JSON type.
   *
   * @return the startkey
   */
  public Object startkey() {
    return startkey;
  }

  /**
   * Gets the startkeyDocid.
   *
   * Schema for a document ID.
   *
   * @return the startkeyDocid
   */
  public String startkeyDocid() {
    return startkeyDocid;
  }

  /**
   * Gets the update.
   *
   * Parameter to specify whether or not the view in question should be updated prior to responding to the user.
   *
   * @return the update
   */
  public String update() {
    return update;
  }
}

