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
 * The postBulkGet options.
 */
public class PostBulkGetOptions extends GenericModel {

  protected String db;
  protected List<BulkGetQueryDocument> docs;
  protected Boolean attachments;
  protected Boolean attEncodingInfo;
  protected Boolean latest;
  protected Boolean revs;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private List<BulkGetQueryDocument> docs;
    private Boolean attachments;
    private Boolean attEncodingInfo;
    private Boolean latest;
    private Boolean revs;

    /**
     * Instantiates a new Builder from an existing PostBulkGetOptions instance.
     *
     * @param postBulkGetOptions the instance to initialize the Builder with
     */
    private Builder(PostBulkGetOptions postBulkGetOptions) {
      this.db = postBulkGetOptions.db;
      this.docs = postBulkGetOptions.docs;
      this.attachments = postBulkGetOptions.attachments;
      this.attEncodingInfo = postBulkGetOptions.attEncodingInfo;
      this.latest = postBulkGetOptions.latest;
      this.revs = postBulkGetOptions.revs;
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
     * @param docs the docs
     */
    public Builder(String db, List<BulkGetQueryDocument> docs) {
      this.db = db;
      this.docs = docs;
    }

    /**
     * Builds a PostBulkGetOptions.
     *
     * @return the new PostBulkGetOptions instance
     */
    public PostBulkGetOptions build() {
      return new PostBulkGetOptions(this);
    }

    /**
     * Adds a new element to docs.
     *
     * @param docs the new element to be added
     * @return the PostBulkGetOptions builder
     */
    public Builder addDocs(BulkGetQueryDocument docs) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(docs,
        "docs cannot be null");
      if (this.docs == null) {
        this.docs = new ArrayList<BulkGetQueryDocument>();
      }
      this.docs.add(docs);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostBulkGetOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docs.
     * Existing docs will be replaced.
     *
     * @param docs the docs
     * @return the PostBulkGetOptions builder
     */
    public Builder docs(List<BulkGetQueryDocument> docs) {
      this.docs = docs;
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the PostBulkGetOptions builder
     */
    public Builder attachments(Boolean attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the attEncodingInfo.
     *
     * @param attEncodingInfo the attEncodingInfo
     * @return the PostBulkGetOptions builder
     */
    public Builder attEncodingInfo(Boolean attEncodingInfo) {
      this.attEncodingInfo = attEncodingInfo;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the PostBulkGetOptions builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the revs.
     *
     * @param revs the revs
     * @return the PostBulkGetOptions builder
     */
    public Builder revs(Boolean revs) {
      this.revs = revs;
      return this;
    }
  }

  protected PostBulkGetOptions() { }

  protected PostBulkGetOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.docs,
      "docs cannot be null");
    db = builder.db;
    docs = builder.docs;
    attachments = builder.attachments;
    attEncodingInfo = builder.attEncodingInfo;
    latest = builder.latest;
    revs = builder.revs;
  }

  /**
   * New builder.
   *
   * @return a PostBulkGetOptions builder
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
   * Gets the docs.
   *
   * List of document items to get in bulk.
   *
   * @return the docs
   */
  public List<BulkGetQueryDocument> docs() {
    return docs;
  }

  /**
   * Gets the attachments.
   *
   * Query parameter to specify whether to include attachments bodies in a response.
   *
   * @return the attachments
   */
  public Boolean attachments() {
    return attachments;
  }

  /**
   * Gets the attEncodingInfo.
   *
   * Query parameter to specify whether to include the encoding information in attachment stubs if the particular
   * attachment is compressed.
   *
   * @return the attEncodingInfo
   */
  public Boolean attEncodingInfo() {
    return attEncodingInfo;
  }

  /**
   * Gets the latest.
   *
   * Query parameter to specify whether to force retrieving latest leaf revision, no matter what rev was requested.
   *
   * @return the latest
   */
  public Boolean latest() {
    return latest;
  }

  /**
   * Gets the revs.
   *
   * Query parameter to specify whether to include a list of all known document revisions.
   *
   * @return the revs
   */
  public Boolean revs() {
    return revs;
  }
}

