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
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postPartitionFind options.
 */
public class PostPartitionFindOptions extends GenericModel {

  /**
   * Whether to update the index prior to returning the result.
   */
  public interface Update {
    /** false. */
    String X_FALSE = "false";
    /** true. */
    String X_TRUE = "true";
    /** lazy. */
    String LAZY = "lazy";
  }

  protected String db;
  protected String partitionKey;
  protected Map<String, Object> selector;
  protected Boolean allowFallback;
  protected String bookmark;
  protected Boolean conflicts;
  protected Boolean executionStats;
  protected List<String> fields;
  protected Long limit;
  protected Long skip;
  protected List<Map<String, String>> sort;
  protected Boolean stable;
  protected String update;
  protected List<String> useIndex;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String partitionKey;
    private Map<String, Object> selector;
    private Boolean allowFallback;
    private String bookmark;
    private Boolean conflicts;
    private Boolean executionStats;
    private List<String> fields;
    private Long limit;
    private Long skip;
    private List<Map<String, String>> sort;
    private Boolean stable;
    private String update;
    private List<String> useIndex;

    /**
     * Instantiates a new Builder from an existing PostPartitionFindOptions instance.
     *
     * @param postPartitionFindOptions the instance to initialize the Builder with
     */
    private Builder(PostPartitionFindOptions postPartitionFindOptions) {
      this.db = postPartitionFindOptions.db;
      this.partitionKey = postPartitionFindOptions.partitionKey;
      this.selector = postPartitionFindOptions.selector;
      this.allowFallback = postPartitionFindOptions.allowFallback;
      this.bookmark = postPartitionFindOptions.bookmark;
      this.conflicts = postPartitionFindOptions.conflicts;
      this.executionStats = postPartitionFindOptions.executionStats;
      this.fields = postPartitionFindOptions.fields;
      this.limit = postPartitionFindOptions.limit;
      this.skip = postPartitionFindOptions.skip;
      this.sort = postPartitionFindOptions.sort;
      this.stable = postPartitionFindOptions.stable;
      this.update = postPartitionFindOptions.update;
      this.useIndex = postPartitionFindOptions.useIndex;
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
     * @param partitionKey the partitionKey
     * @param selector the selector
     */
    public Builder(String db, String partitionKey, Map<String, Object> selector) {
      this.db = db;
      this.partitionKey = partitionKey;
      this.selector = selector;
    }

    /**
     * Builds a PostPartitionFindOptions.
     *
     * @return the new PostPartitionFindOptions instance
     */
    public PostPartitionFindOptions build() {
      return new PostPartitionFindOptions(this);
    }

    /**
     * Adds a new element to fields.
     *
     * @param fields the new element to be added
     * @return the PostPartitionFindOptions builder
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
     * Adds a new element to sort.
     *
     * @param sort the new element to be added
     * @return the PostPartitionFindOptions builder
     */
    public Builder addSort(Map<String, String> sort) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(sort,
        "sort cannot be null");
      if (this.sort == null) {
        this.sort = new ArrayList<Map<String, String>>();
      }
      this.sort.add(sort);
      return this;
    }

    /**
     * Adds a new element to useIndex.
     *
     * @param useIndex the new element to be added
     * @return the PostPartitionFindOptions builder
     */
    public Builder addUseIndex(String useIndex) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(useIndex,
        "useIndex cannot be null");
      if (this.useIndex == null) {
        this.useIndex = new ArrayList<String>();
      }
      this.useIndex.add(useIndex);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostPartitionFindOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the partitionKey.
     *
     * @param partitionKey the partitionKey
     * @return the PostPartitionFindOptions builder
     */
    public Builder partitionKey(String partitionKey) {
      this.partitionKey = partitionKey;
      return this;
    }

    /**
     * Set the selector.
     *
     * @param selector the selector
     * @return the PostPartitionFindOptions builder
     */
    public Builder selector(Map<String, Object> selector) {
      this.selector = selector;
      return this;
    }

    /**
     * Set the allowFallback.
     *
     * @param allowFallback the allowFallback
     * @return the PostPartitionFindOptions builder
     */
    public Builder allowFallback(Boolean allowFallback) {
      this.allowFallback = allowFallback;
      return this;
    }

    /**
     * Set the bookmark.
     *
     * @param bookmark the bookmark
     * @return the PostPartitionFindOptions builder
     */
    public Builder bookmark(String bookmark) {
      this.bookmark = bookmark;
      return this;
    }

    /**
     * Set the conflicts.
     *
     * @param conflicts the conflicts
     * @return the PostPartitionFindOptions builder
     */
    public Builder conflicts(Boolean conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the executionStats.
     *
     * @param executionStats the executionStats
     * @return the PostPartitionFindOptions builder
     */
    public Builder executionStats(Boolean executionStats) {
      this.executionStats = executionStats;
      return this;
    }

    /**
     * Set the fields.
     * Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the PostPartitionFindOptions builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the PostPartitionFindOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the PostPartitionFindOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the sort.
     * Existing sort will be replaced.
     *
     * @param sort the sort
     * @return the PostPartitionFindOptions builder
     */
    public Builder sort(List<Map<String, String>> sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the stable.
     *
     * @param stable the stable
     * @return the PostPartitionFindOptions builder
     */
    public Builder stable(Boolean stable) {
      this.stable = stable;
      return this;
    }

    /**
     * Set the update.
     *
     * @param update the update
     * @return the PostPartitionFindOptions builder
     */
    public Builder update(String update) {
      this.update = update;
      return this;
    }

    /**
     * Set the useIndex.
     * Existing useIndex will be replaced.
     *
     * @param useIndex the useIndex
     * @return the PostPartitionFindOptions builder
     */
    public Builder useIndex(List<String> useIndex) {
      this.useIndex = useIndex;
      return this;
    }
  }

  protected PostPartitionFindOptions() { }

  protected PostPartitionFindOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.partitionKey,
      "partitionKey cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.selector,
      "selector cannot be null");
    db = builder.db;
    partitionKey = builder.partitionKey;
    selector = builder.selector;
    allowFallback = builder.allowFallback;
    bookmark = builder.bookmark;
    conflicts = builder.conflicts;
    executionStats = builder.executionStats;
    fields = builder.fields;
    limit = builder.limit;
    skip = builder.skip;
    sort = builder.sort;
    stable = builder.stable;
    update = builder.update;
    useIndex = builder.useIndex;
  }

  /**
   * New builder.
   *
   * @return a PostPartitionFindOptions builder
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
   * Gets the partitionKey.
   *
   * Path parameter to specify the database partition key.
   *
   * @return the partitionKey
   */
  public String partitionKey() {
    return partitionKey;
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
   * * Combination operators: applied at the topmost level of selection. They are used to combine selectors. A
   * combination operator takes a single argument. The argument is either another selector, or an array of selectors.
   * * Condition operators: are specific to a field, and are used to evaluate the value stored in that field. For
   * instance, the basic `$eq` operator matches when the specified field contains a value that is equal to the supplied
   * argument.
   *
   * It is important for query performance to use appropriate selectors:
   * * Only equality operators such as `$eq`, `$gt`, `$gte`, `$lt`, and `$lte` (but not `$ne`) can be used as the basis
   * of a query. You should include at least one of these in a selector.
   * * Some operators such as `$not`, `$or`, `$in`, and `$regex` cannot be answered from an index. For query selectors
   * use these operators in conjunction with equality operators or create and use a partial index to reduce the number
   * of documents that will need to be scanned.
   *
   * See [the Cloudant Docs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-operators)for a list of all available
   * combination and conditional operators.
   *
   * For further reference see [selector syntax](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-selector-syntax).
   *
   * @return the selector
   */
  public Map<String, Object> selector() {
    return selector;
  }

  /**
   * Gets the allowFallback.
   *
   * Whether to allow fallback to other indexes.  Default is true.
   *
   * @return the allowFallback
   */
  public Boolean allowFallback() {
    return allowFallback;
  }

  /**
   * Gets the bookmark.
   *
   * Opaque bookmark token used when paginating results.
   *
   * @return the bookmark
   */
  public String bookmark() {
    return bookmark;
  }

  /**
   * Gets the conflicts.
   *
   * A boolean value that indicates whether or not to include information about existing conflicts in the document.
   *
   * @return the conflicts
   */
  public Boolean conflicts() {
    return conflicts;
  }

  /**
   * Gets the executionStats.
   *
   * Use this option to find information about the query that was run. This information includes total key lookups,
   * total document lookups (when `include_docs=true` is used), and total quorum document lookups (when each document
   * replica is fetched).
   *
   * @return the executionStats
   */
  public Boolean executionStats() {
    return executionStats;
  }

  /**
   * Gets the fields.
   *
   * JSON array that uses the field syntax. Use this parameter to specify which fields of a document must be returned.
   * If it is omitted or empty, the entire document is returned.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
  }

  /**
   * Gets the limit.
   *
   * Maximum number of results returned. The `type: text` indexes are limited to 200 results when queried.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the skip.
   *
   * Skip the first 'n' results, where 'n' is the value that is specified.
   *
   * @return the skip
   */
  public Long skip() {
    return skip;
  }

  /**
   * Gets the sort.
   *
   * The sort field contains a list of pairs, each mapping a field name to a sort direction (asc or desc). The first
   * field name and direction pair is the topmost level of sort. The second pair, if provided, is the next level of
   * sort. The field can be any field, using dotted notation if desired for sub-document fields.
   *
   * For example in JSON: `[{"fieldName1": "desc"}, {"fieldName2.subFieldName1": "desc"}]`
   *
   * When sorting with multiple fields, ensure that there is an index already defined with all the sort fields in the
   * same order and each object in the sort array has a single key or at least one of the sort fields is included in the
   * selector. All sorting fields must use the same sort direction, either all ascending or all descending.
   *
   * @return the sort
   */
  public List<Map<String, String>> sort() {
    return sort;
  }

  /**
   * Gets the stable.
   *
   * Whether or not the view results should be returned from a "stable" set of shards.
   *
   * @return the stable
   */
  public Boolean stable() {
    return stable;
  }

  /**
   * Gets the update.
   *
   * Whether to update the index prior to returning the result.
   *
   * @return the update
   */
  public String update() {
    return update;
  }

  /**
   * Gets the useIndex.
   *
   * Use this option to identify a specific index to answer the query, rather than letting the IBM Cloudant query
   * planner choose an index. Specified as a two element array of design document id followed by index name, for example
   * `["my_design_doc", "my_index"]`.
   *
   * It’s recommended to specify indexes explicitly in your queries to prevent existing queries being affected by new
   * indexes that might get added later.
   *
   * If the specified index doesn't exist or can't answer the query then the server ignores the value and answers using
   * another index or a full scan of all documents. To change this behavior set `allow_fallback` to `false` and the
   * server responds instead with a `400` status code if the requested index is unsuitable to answer the query.
   *
   * @return the useIndex
   */
  public List<String> useIndex() {
    return useIndex;
  }
}

