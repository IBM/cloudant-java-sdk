/*
 * (C) Copyright IBM Corp. 2021.
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
 * Schema for a design document.
 */
public class DesignDocument extends DynamicModel<Object> {

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
  @SerializedName("autoupdate")
  protected Boolean autoupdate;
  @SerializedName("filters")
  protected Map<String, String> filters;
  @SerializedName("indexes")
  protected Map<String, SearchIndexDefinition> indexes;
  @SerializedName("language")
  protected String language;
  @SerializedName("options")
  protected DesignDocumentOptions options;
  @SerializedName("updates")
  protected Map<String, String> updates;
  @SerializedName("validate_doc_update")
  protected Map<String, String> validateDocUpdate;
  @SerializedName("views")
  protected Map<String, DesignDocumentViewsMapReduce> views;
  @SerializedName("st_indexes")
  protected Map<String, GeoIndexDefinition> stIndexes;

  public DesignDocument() {
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
    private Boolean autoupdate;
    private Map<String, String> filters;
    private Map<String, SearchIndexDefinition> indexes;
    private String language;
    private DesignDocumentOptions options;
    private Map<String, String> updates;
    private Map<String, String> validateDocUpdate;
    private Map<String, DesignDocumentViewsMapReduce> views;
    private Map<String, GeoIndexDefinition> stIndexes;
    private Map<String, Object> dynamicProperties;

    private Builder(DesignDocument designDocument) {
      this.attachments = designDocument.attachments;
      this.conflicts = designDocument.conflicts;
      this.deleted = designDocument.deleted;
      this.deletedConflicts = designDocument.deletedConflicts;
      this.id = designDocument.id;
      this.localSeq = designDocument.localSeq;
      this.rev = designDocument.rev;
      this.revisions = designDocument.revisions;
      this.revsInfo = designDocument.revsInfo;
      this.autoupdate = designDocument.autoupdate;
      this.filters = designDocument.filters;
      this.indexes = designDocument.indexes;
      this.language = designDocument.language;
      this.options = designDocument.options;
      this.updates = designDocument.updates;
      this.validateDocUpdate = designDocument.validateDocUpdate;
      this.views = designDocument.views;
      this.stIndexes = designDocument.stIndexes;
      this.dynamicProperties = designDocument.getProperties();
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DesignDocument.
     *
     * @return the new DesignDocument instance
     */
    public DesignDocument build() {
      return new DesignDocument(this);
    }

    /**
     * Adds an conflicts to conflicts.
     *
     * @param conflicts the new conflicts
     * @return the DesignDocument builder
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
     * Adds an deletedConflicts to deletedConflicts.
     *
     * @param deletedConflicts the new deletedConflicts
     * @return the DesignDocument builder
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
     * Adds an revsInfo to revsInfo.
     *
     * @param revsInfo the new revsInfo
     * @return the DesignDocument builder
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
     * @return the DesignDocument builder
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
     * @return the DesignDocument builder
     */
    public Builder conflicts(List<String> conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the deleted.
     *
     * @param deleted the deleted
     * @return the DesignDocument builder
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
     * @return the DesignDocument builder
     */
    public Builder deletedConflicts(List<String> deletedConflicts) {
      this.deletedConflicts = deletedConflicts;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the DesignDocument builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the localSeq.
     *
     * @param localSeq the localSeq
     * @return the DesignDocument builder
     */
    public Builder localSeq(String localSeq) {
      this.localSeq = localSeq;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the DesignDocument builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the revisions.
     *
     * @param revisions the revisions
     * @return the DesignDocument builder
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
     * @return the DesignDocument builder
     */
    public Builder revsInfo(List<DocumentRevisionStatus> revsInfo) {
      this.revsInfo = revsInfo;
      return this;
    }

    /**
     * Set the autoupdate.
     *
     * @param autoupdate the autoupdate
     * @return the DesignDocument builder
     */
    public Builder autoupdate(Boolean autoupdate) {
      this.autoupdate = autoupdate;
      return this;
    }

    /**
     * Set the filters.
     *
     * @param filters the filters
     * @return the DesignDocument builder
     */
    public Builder filters(Map<String, String> filters) {
      this.filters = filters;
      return this;
    }

    /**
     * Set the indexes.
     *
     * @param indexes the indexes
     * @return the DesignDocument builder
     */
    public Builder indexes(Map<String, SearchIndexDefinition> indexes) {
      this.indexes = indexes;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the DesignDocument builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the options.
     *
     * @param options the options
     * @return the DesignDocument builder
     */
    public Builder options(DesignDocumentOptions options) {
      this.options = options;
      return this;
    }

    /**
     * Set the updates.
     *
     * @param updates the updates
     * @return the DesignDocument builder
     */
    public Builder updates(Map<String, String> updates) {
      this.updates = updates;
      return this;
    }

    /**
     * Set the validateDocUpdate.
     *
     * @param validateDocUpdate the validateDocUpdate
     * @return the DesignDocument builder
     */
    public Builder validateDocUpdate(Map<String, String> validateDocUpdate) {
      this.validateDocUpdate = validateDocUpdate;
      return this;
    }

    /**
     * Set the views.
     *
     * @param views the views
     * @return the DesignDocument builder
     */
    public Builder views(Map<String, DesignDocumentViewsMapReduce> views) {
      this.views = views;
      return this;
    }

    /**
     * Set the stIndexes.
     *
     * @param stIndexes the stIndexes
     * @return the DesignDocument builder
     */
    public Builder stIndexes(Map<String, GeoIndexDefinition> stIndexes) {
      this.stIndexes = stIndexes;
      return this;
    }

    /**
     * Add an arbitrary property.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the DesignDocument builder
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

  protected DesignDocument(Builder builder) {
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
    autoupdate = builder.autoupdate;
    filters = builder.filters;
    indexes = builder.indexes;
    language = builder.language;
    options = builder.options;
    updates = builder.updates;
    validateDocUpdate = builder.validateDocUpdate;
    views = builder.views;
    stIndexes = builder.stIndexes;
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a DesignDocument builder
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
   * Document ID.
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

  /**
   * Gets the autoupdate.
   *
   * Indicates whether to automatically build indexes defined in this design document.
   *
   * @return the autoupdate
   */
  public Boolean isAutoupdate() {
    return this.autoupdate;
  }

  /**
   * Sets the autoupdate.
   *
   * @param autoupdate the new autoupdate
   */
  public void setAutoupdate(final Boolean autoupdate) {
    this.autoupdate = autoupdate;
  }

  /**
   * Gets the filters.
   *
   * Schema for filter functions definition. This schema is a map where keys are the names of the filter functions and
   * values are the function definition in string format.
   *
   * @return the filters
   */
  public Map<String, String> getFilters() {
    return this.filters;
  }

  /**
   * Sets the filters.
   *
   * @param filters the new filters
   */
  public void setFilters(final Map<String, String> filters) {
    this.filters = filters;
  }

  /**
   * Gets the indexes.
   *
   * Search (text) index function definitions.
   *
   * @return the indexes
   */
  public Map<String, SearchIndexDefinition> getIndexes() {
    return this.indexes;
  }

  /**
   * Sets the indexes.
   *
   * @param indexes the new indexes
   */
  public void setIndexes(final Map<String, SearchIndexDefinition> indexes) {
    this.indexes = indexes;
  }

  /**
   * Gets the language.
   *
   * Defines Query Server key to process design document functions.
   *
   * @return the language
   */
  public String getLanguage() {
    return this.language;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Gets the options.
   *
   * Schema for design document options.
   *
   * @return the options
   */
  public DesignDocumentOptions getOptions() {
    return this.options;
  }

  /**
   * Sets the options.
   *
   * @param options the new options
   */
  public void setOptions(final DesignDocumentOptions options) {
    this.options = options;
  }

  /**
   * Gets the updates.
   *
   * Schema for update function definitions.
   *
   * @return the updates
   */
  public Map<String, String> getUpdates() {
    return this.updates;
  }

  /**
   * Sets the updates.
   *
   * @param updates the new updates
   */
  public void setUpdates(final Map<String, String> updates) {
    this.updates = updates;
  }

  /**
   * Gets the validateDocUpdate.
   *
   * Schema for validate document update functions definition.
   *
   * @return the validateDocUpdate
   */
  public Map<String, String> getValidateDocUpdate() {
    return this.validateDocUpdate;
  }

  /**
   * Sets the validateDocUpdate.
   *
   * @param validateDocUpdate the new validateDocUpdate
   */
  public void setValidateDocUpdate(final Map<String, String> validateDocUpdate) {
    this.validateDocUpdate = validateDocUpdate;
  }

  /**
   * Gets the views.
   *
   * Schema for design document views.
   *
   * @return the views
   */
  public Map<String, DesignDocumentViewsMapReduce> getViews() {
    return this.views;
  }

  /**
   * Sets the views.
   *
   * @param views the new views
   */
  public void setViews(final Map<String, DesignDocumentViewsMapReduce> views) {
    this.views = views;
  }

  /**
   * Gets the stIndexes.
   *
   * Schema for geospatial index function definitions.
   *
   * @return the stIndexes
   */
  public Map<String, GeoIndexDefinition> getStIndexes() {
    return this.stIndexes;
  }

  /**
   * Sets the stIndexes.
   *
   * @param stIndexes the new stIndexes
   */
  public void setStIndexes(final Map<String, GeoIndexDefinition> stIndexes) {
    this.stIndexes = stIndexes;
  }
}
