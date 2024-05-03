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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getDocument options.
 */
public class GetDocumentOptions extends GenericModel {

  protected String db;
  protected String docId;
  protected String ifNoneMatch;
  protected Boolean attachments;
  protected Boolean attEncodingInfo;
  protected Boolean conflicts;
  protected Boolean deletedConflicts;
  protected Boolean latest;
  protected Boolean localSeq;
  protected Boolean meta;
  protected String rev;
  protected Boolean revs;
  protected Boolean revsInfo;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private String ifNoneMatch;
    private Boolean attachments;
    private Boolean attEncodingInfo;
    private Boolean conflicts;
    private Boolean deletedConflicts;
    private Boolean latest;
    private Boolean localSeq;
    private Boolean meta;
    private String rev;
    private Boolean revs;
    private Boolean revsInfo;

    /**
     * Instantiates a new Builder from an existing GetDocumentOptions instance.
     *
     * @param getDocumentOptions the instance to initialize the Builder with
     */
    private Builder(GetDocumentOptions getDocumentOptions) {
      this.db = getDocumentOptions.db;
      this.docId = getDocumentOptions.docId;
      this.ifNoneMatch = getDocumentOptions.ifNoneMatch;
      this.attachments = getDocumentOptions.attachments;
      this.attEncodingInfo = getDocumentOptions.attEncodingInfo;
      this.conflicts = getDocumentOptions.conflicts;
      this.deletedConflicts = getDocumentOptions.deletedConflicts;
      this.latest = getDocumentOptions.latest;
      this.localSeq = getDocumentOptions.localSeq;
      this.meta = getDocumentOptions.meta;
      this.rev = getDocumentOptions.rev;
      this.revs = getDocumentOptions.revs;
      this.revsInfo = getDocumentOptions.revsInfo;
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
     * @param docId the docId
     */
    public Builder(String db, String docId) {
      this.db = db;
      this.docId = docId;
    }

    /**
     * Builds a GetDocumentOptions.
     *
     * @return the new GetDocumentOptions instance
     */
    public GetDocumentOptions build() {
      return new GetDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the GetDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the GetDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the ifNoneMatch.
     *
     * @param ifNoneMatch the ifNoneMatch
     * @return the GetDocumentOptions builder
     */
    public Builder ifNoneMatch(String ifNoneMatch) {
      this.ifNoneMatch = ifNoneMatch;
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the GetDocumentOptions builder
     */
    public Builder attachments(Boolean attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the attEncodingInfo.
     *
     * @param attEncodingInfo the attEncodingInfo
     * @return the GetDocumentOptions builder
     */
    public Builder attEncodingInfo(Boolean attEncodingInfo) {
      this.attEncodingInfo = attEncodingInfo;
      return this;
    }

    /**
     * Set the conflicts.
     *
     * @param conflicts the conflicts
     * @return the GetDocumentOptions builder
     */
    public Builder conflicts(Boolean conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the deletedConflicts.
     *
     * @param deletedConflicts the deletedConflicts
     * @return the GetDocumentOptions builder
     */
    public Builder deletedConflicts(Boolean deletedConflicts) {
      this.deletedConflicts = deletedConflicts;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the GetDocumentOptions builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the localSeq.
     *
     * @param localSeq the localSeq
     * @return the GetDocumentOptions builder
     */
    public Builder localSeq(Boolean localSeq) {
      this.localSeq = localSeq;
      return this;
    }

    /**
     * Set the meta.
     *
     * @param meta the meta
     * @return the GetDocumentOptions builder
     */
    public Builder meta(Boolean meta) {
      this.meta = meta;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the GetDocumentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the revs.
     *
     * @param revs the revs
     * @return the GetDocumentOptions builder
     */
    public Builder revs(Boolean revs) {
      this.revs = revs;
      return this;
    }

    /**
     * Set the revsInfo.
     *
     * @param revsInfo the revsInfo
     * @return the GetDocumentOptions builder
     */
    public Builder revsInfo(Boolean revsInfo) {
      this.revsInfo = revsInfo;
      return this;
    }
  }

  protected GetDocumentOptions() { }

  protected GetDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    db = builder.db;
    docId = builder.docId;
    ifNoneMatch = builder.ifNoneMatch;
    attachments = builder.attachments;
    attEncodingInfo = builder.attEncodingInfo;
    conflicts = builder.conflicts;
    deletedConflicts = builder.deletedConflicts;
    latest = builder.latest;
    localSeq = builder.localSeq;
    meta = builder.meta;
    rev = builder.rev;
    revs = builder.revs;
    revsInfo = builder.revsInfo;
  }

  /**
   * New builder.
   *
   * @return a GetDocumentOptions builder
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
   * Gets the docId.
   *
   * Path parameter to specify the document ID.
   *
   * @return the docId
   */
  public String docId() {
    return docId;
  }

  /**
   * Gets the ifNoneMatch.
   *
   * Header parameter for a conditional HTTP request not matching an ETag.
   *
   * @return the ifNoneMatch
   */
  public String ifNoneMatch() {
    return ifNoneMatch;
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
   * Gets the conflicts.
   *
   * Query parameter to specify whether to include a list of conflicted revisions in each returned document. Active only
   * when `include_docs` is `true`.
   *
   * @return the conflicts
   */
  public Boolean conflicts() {
    return conflicts;
  }

  /**
   * Gets the deletedConflicts.
   *
   * Query parameter to specify whether to include a list of deleted conflicted revisions in the `_deleted_conflicts`
   * property of the returned document.
   *
   * @return the deletedConflicts
   */
  public Boolean deletedConflicts() {
    return deletedConflicts;
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
   * Gets the localSeq.
   *
   * Query parameter to specify whether to include the last update sequence for the document.
   *
   * @return the localSeq
   */
  public Boolean localSeq() {
    return localSeq;
  }

  /**
   * Gets the meta.
   *
   * Query parameter to specify whether to include document meta information. Acts the same as specifying all of the
   * conflicts, deleted_conflicts and open_revs query parameters.
   *
   * @return the meta
   */
  public Boolean meta() {
    return meta;
  }

  /**
   * Gets the rev.
   *
   * Query parameter to specify a document revision.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
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

  /**
   * Gets the revsInfo.
   *
   * Query parameter to specify whether to includes detailed information for all known document revisions.
   *
   * @return the revsInfo
   */
  public Boolean revsInfo() {
    return revsInfo;
  }
}

