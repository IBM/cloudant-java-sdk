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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getReplicationDocument options.
 */
public class GetReplicationDocumentOptions extends GenericModel {

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
     * Instantiates a new Builder from an existing GetReplicationDocumentOptions instance.
     *
     * @param getReplicationDocumentOptions the instance to initialize the Builder with
     */
    private Builder(GetReplicationDocumentOptions getReplicationDocumentOptions) {
      this.docId = getReplicationDocumentOptions.docId;
      this.ifNoneMatch = getReplicationDocumentOptions.ifNoneMatch;
      this.attachments = getReplicationDocumentOptions.attachments;
      this.attEncodingInfo = getReplicationDocumentOptions.attEncodingInfo;
      this.conflicts = getReplicationDocumentOptions.conflicts;
      this.deletedConflicts = getReplicationDocumentOptions.deletedConflicts;
      this.latest = getReplicationDocumentOptions.latest;
      this.localSeq = getReplicationDocumentOptions.localSeq;
      this.meta = getReplicationDocumentOptions.meta;
      this.rev = getReplicationDocumentOptions.rev;
      this.revs = getReplicationDocumentOptions.revs;
      this.revsInfo = getReplicationDocumentOptions.revsInfo;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param docId the docId
     */
    public Builder(String docId) {
      this.docId = docId;
    }

    /**
     * Builds a GetReplicationDocumentOptions.
     *
     * @return the new GetReplicationDocumentOptions instance
     */
    public GetReplicationDocumentOptions build() {
      return new GetReplicationDocumentOptions(this);
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the ifNoneMatch.
     *
     * @param ifNoneMatch the ifNoneMatch
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder ifNoneMatch(String ifNoneMatch) {
      this.ifNoneMatch = ifNoneMatch;
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder attachments(Boolean attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the attEncodingInfo.
     *
     * @param attEncodingInfo the attEncodingInfo
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder attEncodingInfo(Boolean attEncodingInfo) {
      this.attEncodingInfo = attEncodingInfo;
      return this;
    }

    /**
     * Set the conflicts.
     *
     * @param conflicts the conflicts
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder conflicts(Boolean conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the deletedConflicts.
     *
     * @param deletedConflicts the deletedConflicts
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder deletedConflicts(Boolean deletedConflicts) {
      this.deletedConflicts = deletedConflicts;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the localSeq.
     *
     * @param localSeq the localSeq
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder localSeq(Boolean localSeq) {
      this.localSeq = localSeq;
      return this;
    }

    /**
     * Set the meta.
     *
     * @param meta the meta
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder meta(Boolean meta) {
      this.meta = meta;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the revs.
     *
     * @param revs the revs
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder revs(Boolean revs) {
      this.revs = revs;
      return this;
    }

    /**
     * Set the revsInfo.
     *
     * @param revsInfo the revsInfo
     * @return the GetReplicationDocumentOptions builder
     */
    public Builder revsInfo(Boolean revsInfo) {
      this.revsInfo = revsInfo;
      return this;
    }
  }

  protected GetReplicationDocumentOptions() { }

  protected GetReplicationDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
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
   * @return a GetReplicationDocumentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Header parameter to specify a double quoted document revision token for cache control.
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

