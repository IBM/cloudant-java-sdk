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
 * Schema for a replication document. Note that `selector`, `doc_ids`, and `filter` are incompatible with each other.
 */
public class ReplicationDocument extends DynamicModel<Object> {

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
  @SerializedName("cancel")
  protected Boolean cancel;
  @SerializedName("checkpoint_interval")
  protected Long checkpointInterval;
  @SerializedName("connection_timeout")
  protected Long connectionTimeout;
  @SerializedName("continuous")
  protected Boolean continuous;
  @SerializedName("create_target")
  protected Boolean createTarget;
  @SerializedName("create_target_params")
  protected ReplicationCreateTargetParameters createTargetParams;
  @SerializedName("doc_ids")
  protected List<String> docIds;
  @SerializedName("filter")
  protected String filter;
  @SerializedName("http_connections")
  protected Long httpConnections;
  @SerializedName("query_params")
  protected Map<String, String> queryParams;
  @SerializedName("retries_per_request")
  protected Long retriesPerRequest;
  @SerializedName("selector")
  protected Map<String, Object> selector;
  @SerializedName("since_seq")
  protected String sinceSeq;
  @SerializedName("socket_options")
  protected String socketOptions;
  @SerializedName("source")
  protected ReplicationDatabase source;
  @SerializedName("source_proxy")
  protected String sourceProxy;
  @SerializedName("target")
  protected ReplicationDatabase target;
  @SerializedName("target_proxy")
  protected String targetProxy;
  @SerializedName("use_checkpoints")
  protected Boolean useCheckpoints;
  @SerializedName("user_ctx")
  protected UserContext userCtx;
  @SerializedName("worker_batch_size")
  protected Long workerBatchSize;
  @SerializedName("worker_processes")
  protected Long workerProcesses;

  public ReplicationDocument() {
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
    private Boolean cancel;
    private Long checkpointInterval;
    private Long connectionTimeout;
    private Boolean continuous;
    private Boolean createTarget;
    private ReplicationCreateTargetParameters createTargetParams;
    private List<String> docIds;
    private String filter;
    private Long httpConnections;
    private Map<String, String> queryParams;
    private Long retriesPerRequest;
    private Map<String, Object> selector;
    private String sinceSeq;
    private String socketOptions;
    private ReplicationDatabase source;
    private String sourceProxy;
    private ReplicationDatabase target;
    private String targetProxy;
    private Boolean useCheckpoints;
    private UserContext userCtx;
    private Long workerBatchSize;
    private Long workerProcesses;
    private Map<String, Object> dynamicProperties;

    private Builder(ReplicationDocument replicationDocument) {
      this.attachments = replicationDocument.attachments;
      this.conflicts = replicationDocument.conflicts;
      this.deleted = replicationDocument.deleted;
      this.deletedConflicts = replicationDocument.deletedConflicts;
      this.id = replicationDocument.id;
      this.localSeq = replicationDocument.localSeq;
      this.rev = replicationDocument.rev;
      this.revisions = replicationDocument.revisions;
      this.revsInfo = replicationDocument.revsInfo;
      this.cancel = replicationDocument.cancel;
      this.checkpointInterval = replicationDocument.checkpointInterval;
      this.connectionTimeout = replicationDocument.connectionTimeout;
      this.continuous = replicationDocument.continuous;
      this.createTarget = replicationDocument.createTarget;
      this.createTargetParams = replicationDocument.createTargetParams;
      this.docIds = replicationDocument.docIds;
      this.filter = replicationDocument.filter;
      this.httpConnections = replicationDocument.httpConnections;
      this.queryParams = replicationDocument.queryParams;
      this.retriesPerRequest = replicationDocument.retriesPerRequest;
      this.selector = replicationDocument.selector;
      this.sinceSeq = replicationDocument.sinceSeq;
      this.socketOptions = replicationDocument.socketOptions;
      this.source = replicationDocument.source;
      this.sourceProxy = replicationDocument.sourceProxy;
      this.target = replicationDocument.target;
      this.targetProxy = replicationDocument.targetProxy;
      this.useCheckpoints = replicationDocument.useCheckpoints;
      this.userCtx = replicationDocument.userCtx;
      this.workerBatchSize = replicationDocument.workerBatchSize;
      this.workerProcesses = replicationDocument.workerProcesses;
      this.dynamicProperties = replicationDocument.getProperties();
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param source the source
     * @param target the target
     */
    public Builder(ReplicationDatabase source, ReplicationDatabase target) {
      this.source = source;
      this.target = target;
    }

    /**
     * Builds a ReplicationDocument.
     *
     * @return the new ReplicationDocument instance
     */
    public ReplicationDocument build() {
      return new ReplicationDocument(this);
    }

    /**
     * Adds an conflicts to conflicts.
     *
     * @param conflicts the new conflicts
     * @return the ReplicationDocument builder
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
     * @return the ReplicationDocument builder
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
     * @return the ReplicationDocument builder
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
     * Adds an docIds to docIds.
     *
     * @param docIds the new docIds
     * @return the ReplicationDocument builder
     */
    public Builder addDocIds(String docIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(docIds,
        "docIds cannot be null");
      if (this.docIds == null) {
        this.docIds = new ArrayList<String>();
      }
      this.docIds.add(docIds);
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the ReplicationDocument builder
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
     * @return the ReplicationDocument builder
     */
    public Builder conflicts(List<String> conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the deleted.
     *
     * @param deleted the deleted
     * @return the ReplicationDocument builder
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
     * @return the ReplicationDocument builder
     */
    public Builder deletedConflicts(List<String> deletedConflicts) {
      this.deletedConflicts = deletedConflicts;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ReplicationDocument builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the localSeq.
     *
     * @param localSeq the localSeq
     * @return the ReplicationDocument builder
     */
    public Builder localSeq(String localSeq) {
      this.localSeq = localSeq;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the ReplicationDocument builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the revisions.
     *
     * @param revisions the revisions
     * @return the ReplicationDocument builder
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
     * @return the ReplicationDocument builder
     */
    public Builder revsInfo(List<DocumentRevisionStatus> revsInfo) {
      this.revsInfo = revsInfo;
      return this;
    }

    /**
     * Set the cancel.
     *
     * @param cancel the cancel
     * @return the ReplicationDocument builder
     */
    public Builder cancel(Boolean cancel) {
      this.cancel = cancel;
      return this;
    }

    /**
     * Set the checkpointInterval.
     *
     * @param checkpointInterval the checkpointInterval
     * @return the ReplicationDocument builder
     */
    public Builder checkpointInterval(long checkpointInterval) {
      this.checkpointInterval = checkpointInterval;
      return this;
    }

    /**
     * Set the connectionTimeout.
     *
     * @param connectionTimeout the connectionTimeout
     * @return the ReplicationDocument builder
     */
    public Builder connectionTimeout(long connectionTimeout) {
      this.connectionTimeout = connectionTimeout;
      return this;
    }

    /**
     * Set the continuous.
     *
     * @param continuous the continuous
     * @return the ReplicationDocument builder
     */
    public Builder continuous(Boolean continuous) {
      this.continuous = continuous;
      return this;
    }

    /**
     * Set the createTarget.
     *
     * @param createTarget the createTarget
     * @return the ReplicationDocument builder
     */
    public Builder createTarget(Boolean createTarget) {
      this.createTarget = createTarget;
      return this;
    }

    /**
     * Set the createTargetParams.
     *
     * @param createTargetParams the createTargetParams
     * @return the ReplicationDocument builder
     */
    public Builder createTargetParams(ReplicationCreateTargetParameters createTargetParams) {
      this.createTargetParams = createTargetParams;
      return this;
    }

    /**
     * Set the docIds.
     * Existing docIds will be replaced.
     *
     * @param docIds the docIds
     * @return the ReplicationDocument builder
     */
    public Builder docIds(List<String> docIds) {
      this.docIds = docIds;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the ReplicationDocument builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the httpConnections.
     *
     * @param httpConnections the httpConnections
     * @return the ReplicationDocument builder
     */
    public Builder httpConnections(long httpConnections) {
      this.httpConnections = httpConnections;
      return this;
    }

    /**
     * Set the queryParams.
     *
     * @param queryParams the queryParams
     * @return the ReplicationDocument builder
     */
    public Builder queryParams(Map<String, String> queryParams) {
      this.queryParams = queryParams;
      return this;
    }

    /**
     * Set the retriesPerRequest.
     *
     * @param retriesPerRequest the retriesPerRequest
     * @return the ReplicationDocument builder
     */
    public Builder retriesPerRequest(long retriesPerRequest) {
      this.retriesPerRequest = retriesPerRequest;
      return this;
    }

    /**
     * Set the selector.
     *
     * @param selector the selector
     * @return the ReplicationDocument builder
     */
    public Builder selector(Map<String, Object> selector) {
      this.selector = selector;
      return this;
    }

    /**
     * Set the sinceSeq.
     *
     * @param sinceSeq the sinceSeq
     * @return the ReplicationDocument builder
     */
    public Builder sinceSeq(String sinceSeq) {
      this.sinceSeq = sinceSeq;
      return this;
    }

    /**
     * Set the socketOptions.
     *
     * @param socketOptions the socketOptions
     * @return the ReplicationDocument builder
     */
    public Builder socketOptions(String socketOptions) {
      this.socketOptions = socketOptions;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the ReplicationDocument builder
     */
    public Builder source(ReplicationDatabase source) {
      this.source = source;
      return this;
    }

    /**
     * Set the sourceProxy.
     *
     * @param sourceProxy the sourceProxy
     * @return the ReplicationDocument builder
     */
    public Builder sourceProxy(String sourceProxy) {
      this.sourceProxy = sourceProxy;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the ReplicationDocument builder
     */
    public Builder target(ReplicationDatabase target) {
      this.target = target;
      return this;
    }

    /**
     * Set the targetProxy.
     *
     * @param targetProxy the targetProxy
     * @return the ReplicationDocument builder
     */
    public Builder targetProxy(String targetProxy) {
      this.targetProxy = targetProxy;
      return this;
    }

    /**
     * Set the useCheckpoints.
     *
     * @param useCheckpoints the useCheckpoints
     * @return the ReplicationDocument builder
     */
    public Builder useCheckpoints(Boolean useCheckpoints) {
      this.useCheckpoints = useCheckpoints;
      return this;
    }

    /**
     * Set the userCtx.
     *
     * @param userCtx the userCtx
     * @return the ReplicationDocument builder
     */
    public Builder userCtx(UserContext userCtx) {
      this.userCtx = userCtx;
      return this;
    }

    /**
     * Set the workerBatchSize.
     *
     * @param workerBatchSize the workerBatchSize
     * @return the ReplicationDocument builder
     */
    public Builder workerBatchSize(long workerBatchSize) {
      this.workerBatchSize = workerBatchSize;
      return this;
    }

    /**
     * Set the workerProcesses.
     *
     * @param workerProcesses the workerProcesses
     * @return the ReplicationDocument builder
     */
    public Builder workerProcesses(long workerProcesses) {
      this.workerProcesses = workerProcesses;
      return this;
    }

    /**
     * Add an arbitrary property.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the ReplicationDocument builder
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

  protected ReplicationDocument(Builder builder) {
    super(new TypeToken<Object>() { });
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.source,
      "source cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    attachments = builder.attachments;
    conflicts = builder.conflicts;
    deleted = builder.deleted;
    deletedConflicts = builder.deletedConflicts;
    id = builder.id;
    localSeq = builder.localSeq;
    rev = builder.rev;
    revisions = builder.revisions;
    revsInfo = builder.revsInfo;
    cancel = builder.cancel;
    checkpointInterval = builder.checkpointInterval;
    connectionTimeout = builder.connectionTimeout;
    continuous = builder.continuous;
    createTarget = builder.createTarget;
    createTargetParams = builder.createTargetParams;
    docIds = builder.docIds;
    filter = builder.filter;
    httpConnections = builder.httpConnections;
    queryParams = builder.queryParams;
    retriesPerRequest = builder.retriesPerRequest;
    selector = builder.selector;
    sinceSeq = builder.sinceSeq;
    socketOptions = builder.socketOptions;
    source = builder.source;
    sourceProxy = builder.sourceProxy;
    target = builder.target;
    targetProxy = builder.targetProxy;
    useCheckpoints = builder.useCheckpoints;
    userCtx = builder.userCtx;
    workerBatchSize = builder.workerBatchSize;
    workerProcesses = builder.workerProcesses;
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a ReplicationDocument builder
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
   * Gets the cancel.
   *
   * Cancels the replication.
   *
   * @return the cancel
   */
  public Boolean isCancel() {
    return this.cancel;
  }

  /**
   * Sets the cancel.
   *
   * @param cancel the new cancel
   */
  public void setCancel(final Boolean cancel) {
    this.cancel = cancel;
  }

  /**
   * Gets the checkpointInterval.
   *
   * Defines replication checkpoint interval in milliseconds.
   *
   * @return the checkpointInterval
   */
  public Long getCheckpointInterval() {
    return this.checkpointInterval;
  }

  /**
   * Sets the checkpointInterval.
   *
   * @param checkpointInterval the new checkpointInterval
   */
  public void setCheckpointInterval(final long checkpointInterval) {
    this.checkpointInterval = checkpointInterval;
  }

  /**
   * Gets the connectionTimeout.
   *
   * HTTP connection timeout per replication. Even for very fast/reliable networks it might need to be increased if a
   * remote database is too busy.
   *
   * @return the connectionTimeout
   */
  public Long getConnectionTimeout() {
    return this.connectionTimeout;
  }

  /**
   * Sets the connectionTimeout.
   *
   * @param connectionTimeout the new connectionTimeout
   */
  public void setConnectionTimeout(final long connectionTimeout) {
    this.connectionTimeout = connectionTimeout;
  }

  /**
   * Gets the continuous.
   *
   * Configure the replication to be continuous.
   *
   * @return the continuous
   */
  public Boolean isContinuous() {
    return this.continuous;
  }

  /**
   * Sets the continuous.
   *
   * @param continuous the new continuous
   */
  public void setContinuous(final Boolean continuous) {
    this.continuous = continuous;
  }

  /**
   * Gets the createTarget.
   *
   * Creates the target database. Requires administrator privileges on target server.
   *
   * @return the createTarget
   */
  public Boolean isCreateTarget() {
    return this.createTarget;
  }

  /**
   * Sets the createTarget.
   *
   * @param createTarget the new createTarget
   */
  public void setCreateTarget(final Boolean createTarget) {
    this.createTarget = createTarget;
  }

  /**
   * Gets the createTargetParams.
   *
   * Request parameters to use during target database creation.
   *
   * @return the createTargetParams
   */
  public ReplicationCreateTargetParameters getCreateTargetParams() {
    return this.createTargetParams;
  }

  /**
   * Sets the createTargetParams.
   *
   * @param createTargetParams the new createTargetParams
   */
  public void setCreateTargetParams(final ReplicationCreateTargetParameters createTargetParams) {
    this.createTargetParams = createTargetParams;
  }

  /**
   * Gets the docIds.
   *
   * Schema for a list of document IDs.
   *
   * @return the docIds
   */
  public List<String> getDocIds() {
    return this.docIds;
  }

  /**
   * Sets the docIds.
   *
   * @param docIds the new docIds
   */
  public void setDocIds(final List<String> docIds) {
    this.docIds = docIds;
  }

  /**
   * Gets the filter.
   *
   * The name of a filter function which is defined in a design document in the source database in {ddoc_id}/{filter}
   * format. It determines which documents get replicated. Using the selector option provides performance benefits when
   * compared with using the filter option. Use the selector option when possible.
   *
   * @return the filter
   */
  public String getFilter() {
    return this.filter;
  }

  /**
   * Sets the filter.
   *
   * @param filter the new filter
   */
  public void setFilter(final String filter) {
    this.filter = filter;
  }

  /**
   * Gets the httpConnections.
   *
   * Maximum number of HTTP connections per replication.
   *
   * @return the httpConnections
   */
  public Long getHttpConnections() {
    return this.httpConnections;
  }

  /**
   * Sets the httpConnections.
   *
   * @param httpConnections the new httpConnections
   */
  public void setHttpConnections(final long httpConnections) {
    this.httpConnections = httpConnections;
  }

  /**
   * Gets the queryParams.
   *
   * Schema for a map of string key value pairs, such as query parameters.
   *
   * @return the queryParams
   */
  public Map<String, String> getQueryParams() {
    return this.queryParams;
  }

  /**
   * Sets the queryParams.
   *
   * @param queryParams the new queryParams
   */
  public void setQueryParams(final Map<String, String> queryParams) {
    this.queryParams = queryParams;
  }

  /**
   * Gets the retriesPerRequest.
   *
   * Number of times a replication request is retried. The requests are retried with a doubling exponential backoff
   * starting at 0.25 seconds, with a cap at 5 minutes.
   *
   * @return the retriesPerRequest
   */
  public Long getRetriesPerRequest() {
    return this.retriesPerRequest;
  }

  /**
   * Sets the retriesPerRequest.
   *
   * @param retriesPerRequest the new retriesPerRequest
   */
  public void setRetriesPerRequest(final long retriesPerRequest) {
    this.retriesPerRequest = retriesPerRequest;
  }

  /**
   * Gets the selector.
   *
   * JSON object describing criteria used to select documents. The selector specifies fields in the document, and
   * provides an expression to evaluate with the field content or other data.
   *
   * The selector object must:
   *   * Be structured as valid JSON.
   *   * Contain a valid query expression.
   *
   * Using a selector is significantly more efficient than using a JavaScript filter function, and is the recommended
   * option if filtering on document attributes only.
   *
   * Elementary selector syntax requires you to specify one or more fields, and the corresponding values required for
   * those fields. You can create more complex selector expressions by combining operators.
   *
   * Operators are identified by the use of a dollar sign `$` prefix in the name field.
   *
   * There are two core types of operators in the selector syntax:
   * * Combination operators: applied at the topmost level of selection. They are used to combine selectors. In addition
   * to the common boolean operators (`$and`, `$or`, `$not`, `$nor`) there are three combination operators: `$all`,
   * `$elemMatch`, and `$allMatch`. A combination operator takes a single argument. The argument is either another
   * selector, or an array of selectors.
   * * Condition operators: are specific to a field, and are used to evaluate the value stored in that field. For
   * instance, the basic `$eq` operator matches when the specified field contains a value that is equal to the supplied
   * argument.
   *
   * @return the selector
   */
  public Map<String, Object> getSelector() {
    return this.selector;
  }

  /**
   * Sets the selector.
   *
   * @param selector the new selector
   */
  public void setSelector(final Map<String, Object> selector) {
    this.selector = selector;
  }

  /**
   * Gets the sinceSeq.
   *
   * Start the replication at a specific sequence value.
   *
   * @return the sinceSeq
   */
  public String getSinceSeq() {
    return this.sinceSeq;
  }

  /**
   * Sets the sinceSeq.
   *
   * @param sinceSeq the new sinceSeq
   */
  public void setSinceSeq(final String sinceSeq) {
    this.sinceSeq = sinceSeq;
  }

  /**
   * Gets the socketOptions.
   *
   * Replication socket options.
   *
   * @return the socketOptions
   */
  public String getSocketOptions() {
    return this.socketOptions;
  }

  /**
   * Sets the socketOptions.
   *
   * @param socketOptions the new socketOptions
   */
  public void setSocketOptions(final String socketOptions) {
    this.socketOptions = socketOptions;
  }

  /**
   * Gets the source.
   *
   * Schema for a replication source or target database.
   *
   * @return the source
   */
  public ReplicationDatabase getSource() {
    return this.source;
  }

  /**
   * Sets the source.
   *
   * @param source the new source
   */
  public void setSource(final ReplicationDatabase source) {
    this.source = source;
  }

  /**
   * Gets the sourceProxy.
   *
   * Address of a (http or socks5 protocol) proxy server through which replication with the source database should
   * occur.
   *
   * @return the sourceProxy
   */
  public String getSourceProxy() {
    return this.sourceProxy;
  }

  /**
   * Sets the sourceProxy.
   *
   * @param sourceProxy the new sourceProxy
   */
  public void setSourceProxy(final String sourceProxy) {
    this.sourceProxy = sourceProxy;
  }

  /**
   * Gets the target.
   *
   * Schema for a replication source or target database.
   *
   * @return the target
   */
  public ReplicationDatabase getTarget() {
    return this.target;
  }

  /**
   * Sets the target.
   *
   * @param target the new target
   */
  public void setTarget(final ReplicationDatabase target) {
    this.target = target;
  }

  /**
   * Gets the targetProxy.
   *
   * Address of a (http or socks5 protocol) proxy server through which replication with the target database should
   * occur.
   *
   * @return the targetProxy
   */
  public String getTargetProxy() {
    return this.targetProxy;
  }

  /**
   * Sets the targetProxy.
   *
   * @param targetProxy the new targetProxy
   */
  public void setTargetProxy(final String targetProxy) {
    this.targetProxy = targetProxy;
  }

  /**
   * Gets the useCheckpoints.
   *
   * Specify if checkpoints should be saved during replication. Using checkpoints means a replication can be efficiently
   * resumed.
   *
   * @return the useCheckpoints
   */
  public Boolean isUseCheckpoints() {
    return this.useCheckpoints;
  }

  /**
   * Sets the useCheckpoints.
   *
   * @param useCheckpoints the new useCheckpoints
   */
  public void setUseCheckpoints(final Boolean useCheckpoints) {
    this.useCheckpoints = useCheckpoints;
  }

  /**
   * Gets the userCtx.
   *
   * Schema for the user context of a session.
   *
   * @return the userCtx
   */
  public UserContext getUserCtx() {
    return this.userCtx;
  }

  /**
   * Sets the userCtx.
   *
   * @param userCtx the new userCtx
   */
  public void setUserCtx(final UserContext userCtx) {
    this.userCtx = userCtx;
  }

  /**
   * Gets the workerBatchSize.
   *
   * Controls how many documents are processed. After each batch a checkpoint is written so this controls how frequently
   * checkpointing occurs.
   *
   * @return the workerBatchSize
   */
  public Long getWorkerBatchSize() {
    return this.workerBatchSize;
  }

  /**
   * Sets the workerBatchSize.
   *
   * @param workerBatchSize the new workerBatchSize
   */
  public void setWorkerBatchSize(final long workerBatchSize) {
    this.workerBatchSize = workerBatchSize;
  }

  /**
   * Gets the workerProcesses.
   *
   * Controls how many separate processes will read from the changes manager and write to the target. A higher number
   * can improve throughput.
   *
   * @return the workerProcesses
   */
  public Long getWorkerProcesses() {
    return this.workerProcesses;
  }

  /**
   * Sets the workerProcesses.
   *
   * @param workerProcesses the new workerProcesses
   */
  public void setWorkerProcesses(final long workerProcesses) {
    this.workerProcesses = workerProcesses;
  }
}
