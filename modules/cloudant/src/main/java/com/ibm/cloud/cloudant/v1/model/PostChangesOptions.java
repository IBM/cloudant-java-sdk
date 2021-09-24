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
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postChanges options.
 */
public class PostChangesOptions extends GenericModel {

  /**
   * Query parameter to specify the changes feed type.
   */
  public interface Feed {
    /** continuous. */
    String CONTINUOUS = "continuous";
    /** eventsource. */
    String EVENTSOURCE = "eventsource";
    /** longpoll. */
    String LONGPOLL = "longpoll";
    /** normal. */
    String NORMAL = "normal";
  }

  protected String db;
  protected List<String> docIds;
  protected List<String> fields;
  protected Map<String, Object> selector;
  protected String lastEventId;
  protected Boolean attEncodingInfo;
  protected Boolean attachments;
  protected Boolean conflicts;
  protected Boolean descending;
  protected String feed;
  protected String filter;
  protected Long heartbeat;
  protected Boolean includeDocs;
  protected Long limit;
  protected Long seqInterval;
  protected String since;
  protected String style;
  protected Long timeout;
  protected String view;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private List<String> docIds;
    private List<String> fields;
    private Map<String, Object> selector;
    private String lastEventId;
    private Boolean attEncodingInfo;
    private Boolean attachments;
    private Boolean conflicts;
    private Boolean descending;
    private String feed;
    private String filter;
    private Long heartbeat;
    private Boolean includeDocs;
    private Long limit;
    private Long seqInterval;
    private String since;
    private String style;
    private Long timeout;
    private String view;

    private Builder(PostChangesOptions postChangesOptions) {
      this.db = postChangesOptions.db;
      this.docIds = postChangesOptions.docIds;
      this.fields = postChangesOptions.fields;
      this.selector = postChangesOptions.selector;
      this.lastEventId = postChangesOptions.lastEventId;
      this.attEncodingInfo = postChangesOptions.attEncodingInfo;
      this.attachments = postChangesOptions.attachments;
      this.conflicts = postChangesOptions.conflicts;
      this.descending = postChangesOptions.descending;
      this.feed = postChangesOptions.feed;
      this.filter = postChangesOptions.filter;
      this.heartbeat = postChangesOptions.heartbeat;
      this.includeDocs = postChangesOptions.includeDocs;
      this.limit = postChangesOptions.limit;
      this.seqInterval = postChangesOptions.seqInterval;
      this.since = postChangesOptions.since;
      this.style = postChangesOptions.style;
      this.timeout = postChangesOptions.timeout;
      this.view = postChangesOptions.view;
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
     */
    public Builder(String db) {
      this.db = db;
    }

    /**
     * Builds a PostChangesOptions.
     *
     * @return the new PostChangesOptions instance
     */
    public PostChangesOptions build() {
      return new PostChangesOptions(this);
    }

    /**
     * Adds an docIds to docIds.
     *
     * @param docIds the new docIds
     * @return the PostChangesOptions builder
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
     * Adds an fields to fields.
     *
     * @param fields the new fields
     * @return the PostChangesOptions builder
     */
    public Builder addFields(String fields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(fields,
        "fields cannot be null");
      if (this.fields == null) {
        this.fields = new ArrayList<String>();
      }
      this.fields.add(fields);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostChangesOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docIds.
     * Existing docIds will be replaced.
     *
     * @param docIds the docIds
     * @return the PostChangesOptions builder
     */
    public Builder docIds(List<String> docIds) {
      this.docIds = docIds;
      return this;
    }

    /**
     * Set the fields.
     * Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the PostChangesOptions builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the selector.
     *
     * @param selector the selector
     * @return the PostChangesOptions builder
     */
    public Builder selector(Map<String, Object> selector) {
      this.selector = selector;
      return this;
    }

    /**
     * Set the lastEventId.
     *
     * @param lastEventId the lastEventId
     * @return the PostChangesOptions builder
     */
    public Builder lastEventId(String lastEventId) {
      this.lastEventId = lastEventId;
      return this;
    }

    /**
     * Set the attEncodingInfo.
     *
     * @param attEncodingInfo the attEncodingInfo
     * @return the PostChangesOptions builder
     */
    public Builder attEncodingInfo(Boolean attEncodingInfo) {
      this.attEncodingInfo = attEncodingInfo;
      return this;
    }

    /**
     * Set the attachments.
     *
     * @param attachments the attachments
     * @return the PostChangesOptions builder
     */
    public Builder attachments(Boolean attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the conflicts.
     *
     * @param conflicts the conflicts
     * @return the PostChangesOptions builder
     */
    public Builder conflicts(Boolean conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the descending.
     *
     * @param descending the descending
     * @return the PostChangesOptions builder
     */
    public Builder descending(Boolean descending) {
      this.descending = descending;
      return this;
    }

    /**
     * Set the feed.
     *
     * @param feed the feed
     * @return the PostChangesOptions builder
     */
    public Builder feed(String feed) {
      this.feed = feed;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the PostChangesOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the heartbeat.
     *
     * @param heartbeat the heartbeat
     * @return the PostChangesOptions builder
     */
    public Builder heartbeat(long heartbeat) {
      this.heartbeat = heartbeat;
      return this;
    }

    /**
     * Set the includeDocs.
     *
     * @param includeDocs the includeDocs
     * @return the PostChangesOptions builder
     */
    public Builder includeDocs(Boolean includeDocs) {
      this.includeDocs = includeDocs;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the PostChangesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the seqInterval.
     *
     * @param seqInterval the seqInterval
     * @return the PostChangesOptions builder
     */
    public Builder seqInterval(long seqInterval) {
      this.seqInterval = seqInterval;
      return this;
    }

    /**
     * Set the since.
     *
     * @param since the since
     * @return the PostChangesOptions builder
     */
    public Builder since(String since) {
      this.since = since;
      return this;
    }

    /**
     * Set the style.
     *
     * @param style the style
     * @return the PostChangesOptions builder
     */
    public Builder style(String style) {
      this.style = style;
      return this;
    }

    /**
     * Set the timeout.
     *
     * @param timeout the timeout
     * @return the PostChangesOptions builder
     */
    public Builder timeout(long timeout) {
      this.timeout = timeout;
      return this;
    }

    /**
     * Set the view.
     *
     * @param view the view
     * @return the PostChangesOptions builder
     */
    public Builder view(String view) {
      this.view = view;
      return this;
    }
  }

  protected PostChangesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    docIds = builder.docIds;
    fields = builder.fields;
    selector = builder.selector;
    lastEventId = builder.lastEventId;
    attEncodingInfo = builder.attEncodingInfo;
    attachments = builder.attachments;
    conflicts = builder.conflicts;
    descending = builder.descending;
    feed = builder.feed;
    filter = builder.filter;
    heartbeat = builder.heartbeat;
    includeDocs = builder.includeDocs;
    limit = builder.limit;
    seqInterval = builder.seqInterval;
    since = builder.since;
    style = builder.style;
    timeout = builder.timeout;
    view = builder.view;
  }

  /**
   * New builder.
   *
   * @return a PostChangesOptions builder
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
   * Gets the docIds.
   *
   * Schema for a list of document IDs.
   *
   * @return the docIds
   */
  public List<String> docIds() {
    return docIds;
  }

  /**
   * Gets the fields.
   *
   * JSON array that uses the field syntax. Use this parameter to specify which fields of a document must be returned.
   * If it is omitted, the entire document is returned.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
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
  public Map<String, Object> selector() {
    return selector;
  }

  /**
   * Gets the lastEventId.
   *
   * Header parameter to specify the ID of the last events received by the server on a previous connection. Overrides
   * `since` query parameter.
   *
   * @return the lastEventId
   */
  public String lastEventId() {
    return lastEventId;
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
   * Gets the conflicts.
   *
   * Query parameter to specify whether to include a list of conflicted revisions in the `_conflicts` property of the
   * returned document. Ignored if `include_docs` isn't `true`.
   *
   * @return the conflicts
   */
  public Boolean conflicts() {
    return conflicts;
  }

  /**
   * Gets the descending.
   *
   * Query parameter to specify whether to return the documents in descending by key order.
   *
   * @return the descending
   */
  public Boolean descending() {
    return descending;
  }

  /**
   * Gets the feed.
   *
   * Query parameter to specify the changes feed type.
   *
   * @return the feed
   */
  public String feed() {
    return feed;
  }

  /**
   * Gets the filter.
   *
   * Query parameter to specify a filter function from a design document that will filter the changes stream emitting
   * only filtered events. For example: `design_doc/filtername`.
   *
   * Additionally, some keywords are reserved for built-in filters:
   *
   *   * `_design` - Returns only changes to design documents.
   *   * `_doc_ids` - Returns changes for documents with an ID matching one specified in
   *       `doc_ids` request body parameter.
   *   * `_selector` - Returns changes for documents that match the `selector`
   *       request body parameter. The selector syntax is the same as used for
   *       `_find`.
   *   * `_view` - Returns changes for documents that match an existing map
   *       function in the view specified by the query parameter `view`.
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the heartbeat.
   *
   * Query parameter to specify the period in milliseconds after which an empty line is sent in the results. Only
   * applicable for longpoll, continuous, and eventsource feeds. Overrides any timeout to keep the feed alive
   * indefinitely. May also be `true` to use default value of 60000.
   *
   * @return the heartbeat
   */
  public Long heartbeat() {
    return heartbeat;
  }

  /**
   * Gets the includeDocs.
   *
   * Query parameter to specify whether to include the full content of the documents in the response.
   *
   * @return the includeDocs
   */
  public Boolean includeDocs() {
    return includeDocs;
  }

  /**
   * Gets the limit.
   *
   * Query parameter to specify the number of returned documents to limit the result to.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the seqInterval.
   *
   * Query parameter to specify that the update seq should only be calculated with every Nth result returned. When
   * fetching changes in a batch, setting &lt;code&gt;seq_interval=&amp;lt;batch size&amp;gt;&lt;/code&gt;, where
   * &amp;lt;batch size&amp;gt; is the number of results requested per batch, load can be reduced on the source database
   * as computing the seq value across many shards (especially in highly-sharded databases) is expensive.
   *
   * @return the seqInterval
   */
  public Long seqInterval() {
    return seqInterval;
  }

  /**
   * Gets the since.
   *
   * Query parameter to specify to start the results from the change immediately after the given update sequence. Can be
   * a valid update sequence or `now` value. Default is `0` i.e. all changes.
   *
   * @return the since
   */
  public String since() {
    return since;
  }

  /**
   * Gets the style.
   *
   * Query parameter to specify how many revisions are returned in the changes array. The default, `main_only`, will
   * only return the current "winning" revision; all_docs will return all leaf revisions (including conflicts and
   * deleted former conflicts).
   *
   * @return the style
   */
  public String style() {
    return style;
  }

  /**
   * Gets the timeout.
   *
   * Query parameter to specify the maximum period in milliseconds to wait for a change before the response is sent,
   * even if there are no results. Only applicable for `longpoll` or `continuous` feeds. Default value is specified by
   * `httpd/changes_timeout` configuration option. Note that `60000` value is also the default maximum timeout to
   * prevent undetected dead connections.
   *
   * @return the timeout
   */
  public Long timeout() {
    return timeout;
  }

  /**
   * Gets the view.
   *
   * Query parameter to specify a view function as a filter. Documents pass the filter if the view's map function emits
   * at least one record for them.
   *
   * @return the view
   */
  public String view() {
    return view;
  }
}

