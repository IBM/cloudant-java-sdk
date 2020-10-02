/*
 * (C) Copyright IBM Corp. 2020.
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
 * The postFind options.
 */
public class PostFindOptions extends GenericModel {

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
  protected Map<String, Object> selector;
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
  protected Long r;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private Map<String, Object> selector;
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
    private Long r;

    private Builder(PostFindOptions postFindOptions) {
      this.db = postFindOptions.db;
      this.selector = postFindOptions.selector;
      this.bookmark = postFindOptions.bookmark;
      this.conflicts = postFindOptions.conflicts;
      this.executionStats = postFindOptions.executionStats;
      this.fields = postFindOptions.fields;
      this.limit = postFindOptions.limit;
      this.skip = postFindOptions.skip;
      this.sort = postFindOptions.sort;
      this.stable = postFindOptions.stable;
      this.update = postFindOptions.update;
      this.useIndex = postFindOptions.useIndex;
      this.r = postFindOptions.r;
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
     * @param selector the selector
     */
    public Builder(String db, Map<String, Object> selector) {
      this.db = db;
      this.selector = selector;
    }

    /**
     * Builds a PostFindOptions.
     *
     * @return the new PostFindOptions instance
     */
    public PostFindOptions build() {
      return new PostFindOptions(this);
    }

    /**
     * Adds an fields to fields.
     *
     * @param fields the new fields
     * @return the PostFindOptions builder
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
     * Adds an sort to sort.
     *
     * @param sort the new sort
     * @return the PostFindOptions builder
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
     * Adds an useIndex to useIndex.
     *
     * @param useIndex the new useIndex
     * @return the PostFindOptions builder
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
     * @return the PostFindOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the selector.
     *
     * @param selector the selector
     * @return the PostFindOptions builder
     */
    public Builder selector(Map<String, Object> selector) {
      this.selector = selector;
      return this;
    }

    /**
     * Set the bookmark.
     *
     * @param bookmark the bookmark
     * @return the PostFindOptions builder
     */
    public Builder bookmark(String bookmark) {
      this.bookmark = bookmark;
      return this;
    }

    /**
     * Set the conflicts.
     *
     * @param conflicts the conflicts
     * @return the PostFindOptions builder
     */
    public Builder conflicts(Boolean conflicts) {
      this.conflicts = conflicts;
      return this;
    }

    /**
     * Set the executionStats.
     *
     * @param executionStats the executionStats
     * @return the PostFindOptions builder
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
     * @return the PostFindOptions builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the PostFindOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the PostFindOptions builder
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
     * @return the PostFindOptions builder
     */
    public Builder sort(List<Map<String, String>> sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the stable.
     *
     * @param stable the stable
     * @return the PostFindOptions builder
     */
    public Builder stable(Boolean stable) {
      this.stable = stable;
      return this;
    }

    /**
     * Set the update.
     *
     * @param update the update
     * @return the PostFindOptions builder
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
     * @return the PostFindOptions builder
     */
    public Builder useIndex(List<String> useIndex) {
      this.useIndex = useIndex;
      return this;
    }

    /**
     * Set the r.
     *
     * @param r the r
     * @return the PostFindOptions builder
     */
    public Builder r(long r) {
      this.r = r;
      return this;
    }
  }

  protected PostFindOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.selector,
      "selector cannot be null");
    db = builder.db;
    selector = builder.selector;
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
    r = builder.r;
  }

  /**
   * New builder.
   *
   * @return a PostFindOptions builder
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
   * If it is omitted, the entire document is returned.
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
   * JSON array of sort syntax elements to determine the sort order of the results.
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
   * Use this option to identify a specific index for query to run against, rather than by using the IBM Cloudant Query
   * algorithm to find the best index.
   *
   * @return the useIndex
   */
  public List<String> useIndex() {
    return useIndex;
  }

  /**
   * Gets the r.
   *
   * The read quorum that is needed for the result. The value defaults to 1, in which case the document that was found
   * in the index is returned. If set to a higher value, each document is read from at least that many replicas before
   * it is returned in the results. The request will take more time than using only the document that is stored locally
   * with the index.
   *
   * @return the r
   */
  public Long r() {
    return r;
  }
}

