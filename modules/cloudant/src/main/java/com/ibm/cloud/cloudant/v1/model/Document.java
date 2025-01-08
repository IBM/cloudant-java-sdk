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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Schema for a document.
 *
 * This type supports additional properties of type Object.
 */
public class Document extends DynamicModel<Object> {

  @SerializedName("_attachments")
  protected Map<String, Attachment> attachments;
  @SerializedName("_conflicts")
  protected List<String> conflicts;
  @SerializedName("_deleted")
  protected Boolean deleted;
  @SerializedName("_deleted_conflicts")
  protected List<String> deletedConflicts;
  @SerializedName("_id")
  protected String id;
  @SerializedName("_local_seq")
  protected String localSeq;
  @SerializedName("_rev")
  protected String rev;
  @SerializedName("_revisions")
  protected Revisions revisions;
  @SerializedName("_revs_info")
  protected List<DocumentRevisionStatus> revsInfo;

  public Document() {
    super(new TypeToken<Object>() { });
  }

  /**
   * Builder.
   */
  public static class Builder {
    private Map<String, Attachment> attachments;
    private List<String> conflicts;
    private Boolean deleted;
    private List<String> deletedConflicts;
    private String id;
    private String localSeq;
    private String rev;
    private Revisions revisions;
    private List<DocumentRevisionStatus> revsInfo;
    private Map<String, Object> dynamicProperties;

    /**
     * Instantiates a new Builder from an existing Document instance.
     *
     * @param document the instance to initialize the Builder with
     */
    private Builder(Document document) {
      this.attachments = document.attachments;
      this.conflicts = document.conflicts;
      this.deleted = document.deleted;
      this.deletedConflicts = document.deletedConflicts;
      this.id = document.id;
      this.localSeq = document.localSeq;
      this.rev = document.rev;
      this.revisions = document.revisions;
      this.revsInfo = document.revsInfo;
      this.dynamicProperties = document.getProperties();
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Document.
     *
     * @return the new Document instance
     */
    public Document build() {
      return new Document(this);
    }

    /**
     * Adds a new element to conflicts.
     *
     * @param conflicts the new element to be added
     * @return the Document builder
     */
    public Builder addConflicts(String conflicts) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(conflicts,
        "conflicts cannot be null");
      if (this.conflicts == null) {
        this.conflicts = new ArrayList<String>();
      }
      this.conflicts.add(conflicts);
      return this;
    }

    /**
     * Adds a new element to deletedConflicts.
     *
     * @param deletedConflicts the new element to be added
     * @return the Document builder
     */
    public Builder addDeletedConflicts(String deletedConflicts) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(deletedConflicts,
        "deletedConflicts cannot be null");
      if (this.deletedConflicts == null) {
        this.deletedConflicts = new ArrayList<String>();
      }
      this.deletedConflicts.add(deletedConflicts);
      return this;
    }

    /**
     * Adds a new element to revsInfo.
     *
     * @param revsInfo the new element to be added
     * @return the Document builder
     */
    public Builder addRevsInfo(DocumentRevisionStatus revsInfo) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(revsInfo,
        "revsInfo cannot be null");
      if (this.revsInfo == null) {
        this.revsInfo = new ArrayList<DocumentRevisionStatus>();
      }
      this.revsInfo.add(revsInfo);
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the Document builder
     */
    public Builder attachments(Map<String, Attachment> attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the conflicts.
     * Existing conflicts will be replaced.
     *
     * @param conflicts the conflicts
     * @return the Document builder
     */
    public Builder conflicts(List<String> conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the deleted.
     *
     * @param deleted the deleted
     * @return the Document builder
     */
    public Builder deleted(Boolean deleted) {
      this.deleted = deleted;
      return this;
    }

    /**
     * Set the deletedConflicts.
     * Existing deletedConflicts will be replaced.
     *
     * @param deletedConflicts the deletedConflicts
     * @return the Document builder
     */
    public Builder deletedConflicts(List<String> deletedConflicts) {
      this.deletedConflicts = deletedConflicts;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Document builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the localSeq.
     *
     * @param localSeq the localSeq
     * @return the Document builder
     */
    public Builder localSeq(String localSeq) {
      this.localSeq = localSeq;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the Document builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the revisions.
     *
     * @param revisions the revisions
     * @return the Document builder
     */
    public Builder revisions(Revisions revisions) {
      this.revisions = revisions;
      return this;
    }

    /**
     * Set the revsInfo.
     * Existing revsInfo will be replaced.
     *
     * @param revsInfo the revsInfo
     * @return the Document builder
     */
    public Builder revsInfo(List<DocumentRevisionStatus> revsInfo) {
      this.revsInfo = revsInfo;
      return this;
    }

    /**
     * Add an arbitrary property.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the Document builder
     */
    public Builder add(String name, Object value) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(name, "name cannot be null");
      if (this.dynamicProperties == null) {
        this.dynamicProperties = new HashMap<String, Object>();
      }
      this.dynamicProperties.put(name, value);
      return this;
    }
  }

  protected Document(Builder builder) {
    super(new TypeToken<Object>() { });
    attachments = builder.attachments;
    conflicts = builder.conflicts;
    deleted = builder.deleted;
    deletedConflicts = builder.deletedConflicts;
    id = builder.id;
    localSeq = builder.localSeq;
    rev = builder.rev;
    revisions = builder.revisions;
    revsInfo = builder.revsInfo;
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a Document builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attachments.
   *
   * Schema for a map of attachment name to attachment metadata.
   *
   * @return the attachments
   */
  public Map<String, Attachment> getAttachments() {
    return this.attachments;
  }

  /**
   * Sets the attachments.
   *
   * @param attachments the new attachments
   */
  public void setAttachments(final Map<String, Attachment> attachments) {
    this.attachments = attachments;
  }

  /**
   * Gets the conflicts.
   *
   * Schema for a list of document revision identifiers.
   *
   * @return the conflicts
   */
  public List<String> getConflicts() {
    return this.conflicts;
  }

  /**
   * Sets the conflicts.
   *
   * @param conflicts the new conflicts
   */
  public void setConflicts(final List<String> conflicts) {
    this.conflicts = conflicts;
  }

  /**
   * Gets the deleted.
   *
   * Deletion flag. Available if document was removed.
   *
   * @return the deleted
   */
  public Boolean isDeleted() {
    return this.deleted;
  }

  /**
   * Sets the deleted.
   *
   * @param deleted the new deleted
   */
  public void setDeleted(final Boolean deleted) {
    this.deleted = deleted;
  }

  /**
   * Gets the deletedConflicts.
   *
   * Schema for a list of document revision identifiers.
   *
   * @return the deletedConflicts
   */
  public List<String> getDeletedConflicts() {
    return this.deletedConflicts;
  }

  /**
   * Sets the deletedConflicts.
   *
   * @param deletedConflicts the new deletedConflicts
   */
  public void setDeletedConflicts(final List<String> deletedConflicts) {
    this.deletedConflicts = deletedConflicts;
  }

  /**
   * Gets the id.
   *
   * Schema for a document ID.
   *
   * @return the id
   */
  public String getId() {
    return this.id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Gets the localSeq.
   *
   * Document's update sequence in current database. Available if requested with local_seq=true query parameter.
   *
   * @return the localSeq
   */
  public String getLocalSeq() {
    return this.localSeq;
  }

  /**
   * Sets the localSeq.
   *
   * @param localSeq the new localSeq
   */
  public void setLocalSeq(final String localSeq) {
    this.localSeq = localSeq;
  }

  /**
   * Gets the rev.
   *
   * Schema for a document revision identifier.
   *
   * @return the rev
   */
  public String getRev() {
    return this.rev;
  }

  /**
   * Sets the rev.
   *
   * @param rev the new rev
   */
  public void setRev(final String rev) {
    this.rev = rev;
  }

  /**
   * Gets the revisions.
   *
   * Schema for list of revision information.
   *
   * @return the revisions
   */
  public Revisions getRevisions() {
    return this.revisions;
  }

  /**
   * Sets the revisions.
   *
   * @param revisions the new revisions
   */
  public void setRevisions(final Revisions revisions) {
    this.revisions = revisions;
  }

  /**
   * Gets the revsInfo.
   *
   * Schema for a list of objects with information about local revisions and their status.
   *
   * @return the revsInfo
   */
  public List<DocumentRevisionStatus> getRevsInfo() {
    return this.revsInfo;
  }

  /**
   * Sets the revsInfo.
   *
   * @param revsInfo the new revsInfo
   */
  public void setRevsInfo(final List<DocumentRevisionStatus> revsInfo) {
    this.revsInfo = revsInfo;
  }
}
