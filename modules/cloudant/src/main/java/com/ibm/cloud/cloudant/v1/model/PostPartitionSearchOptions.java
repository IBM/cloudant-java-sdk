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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postPartitionSearch options.
 */
public class PostPartitionSearchOptions extends GenericModel {

  /**
   * Do not wait for the index to finish building to return results.
   */
  public interface Stale {
    /** ok. */
    String OK = "ok";
  }

  protected String db;
  protected String partitionKey;
  protected String ddoc;
  protected String index;
  protected String query;
  protected String bookmark;
  protected List<String> highlightFields;
  protected Long highlightNumber;
  protected String highlightPostTag;
  protected String highlightPreTag;
  protected Long highlightSize;
  protected Boolean includeDocs;
  protected List<String> includeFields;
  protected Long limit;
  protected List<String> sort;
  protected String stale;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String partitionKey;
    private String ddoc;
    private String index;
    private String query;
    private String bookmark;
    private List<String> highlightFields;
    private Long highlightNumber;
    private String highlightPostTag;
    private String highlightPreTag;
    private Long highlightSize;
    private Boolean includeDocs;
    private List<String> includeFields;
    private Long limit;
    private List<String> sort;
    private String stale;

    /**
     * Instantiates a new Builder from an existing PostPartitionSearchOptions instance.
     *
     * @param postPartitionSearchOptions the instance to initialize the Builder with
     */
    private Builder(PostPartitionSearchOptions postPartitionSearchOptions) {
      this.db = postPartitionSearchOptions.db;
      this.partitionKey = postPartitionSearchOptions.partitionKey;
      this.ddoc = postPartitionSearchOptions.ddoc;
      this.index = postPartitionSearchOptions.index;
      this.query = postPartitionSearchOptions.query;
      this.bookmark = postPartitionSearchOptions.bookmark;
      this.highlightFields = postPartitionSearchOptions.highlightFields;
      this.highlightNumber = postPartitionSearchOptions.highlightNumber;
      this.highlightPostTag = postPartitionSearchOptions.highlightPostTag;
      this.highlightPreTag = postPartitionSearchOptions.highlightPreTag;
      this.highlightSize = postPartitionSearchOptions.highlightSize;
      this.includeDocs = postPartitionSearchOptions.includeDocs;
      this.includeFields = postPartitionSearchOptions.includeFields;
      this.limit = postPartitionSearchOptions.limit;
      this.sort = postPartitionSearchOptions.sort;
      this.stale = postPartitionSearchOptions.stale;
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
     * @param ddoc the ddoc
     * @param index the index
     * @param query the query
     */
    public Builder(String db, String partitionKey, String ddoc, String index, String query) {
      this.db = db;
      this.partitionKey = partitionKey;
      this.ddoc = ddoc;
      this.index = index;
      this.query = query;
    }

    /**
     * Builds a PostPartitionSearchOptions.
     *
     * @return the new PostPartitionSearchOptions instance
     */
    public PostPartitionSearchOptions build() {
      return new PostPartitionSearchOptions(this);
    }

    /**
     * Adds an highlightFields to highlightFields.
     *
     * @param highlightFields the new highlightFields
     * @return the PostPartitionSearchOptions builder
     */
    public Builder addHighlightFields(String highlightFields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(highlightFields,
        "highlightFields cannot be null");
      if (this.highlightFields == null) {
        this.highlightFields = new ArrayList<String>();
      }
      this.highlightFields.add(highlightFields);
      return this;
    }

    /**
     * Adds an includeFields to includeFields.
     *
     * @param includeFields the new includeFields
     * @return the PostPartitionSearchOptions builder
     */
    public Builder addIncludeFields(String includeFields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(includeFields,
        "includeFields cannot be null");
      if (this.includeFields == null) {
        this.includeFields = new ArrayList<String>();
      }
      this.includeFields.add(includeFields);
      return this;
    }

    /**
     * Adds an sort to sort.
     *
     * @param sort the new sort
     * @return the PostPartitionSearchOptions builder
     */
    public Builder addSort(String sort) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(sort,
        "sort cannot be null");
      if (this.sort == null) {
        this.sort = new ArrayList<String>();
      }
      this.sort.add(sort);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostPartitionSearchOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the partitionKey.
     *
     * @param partitionKey the partitionKey
     * @return the PostPartitionSearchOptions builder
     */
    public Builder partitionKey(String partitionKey) {
      this.partitionKey = partitionKey;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the PostPartitionSearchOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the index.
     *
     * @param index the index
     * @return the PostPartitionSearchOptions builder
     */
    public Builder index(String index) {
      this.index = index;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the PostPartitionSearchOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the bookmark.
     *
     * @param bookmark the bookmark
     * @return the PostPartitionSearchOptions builder
     */
    public Builder bookmark(String bookmark) {
      this.bookmark = bookmark;
      return this;
    }

    /**
     * Set the highlightFields.
     * Existing highlightFields will be replaced.
     *
     * @param highlightFields the highlightFields
     * @return the PostPartitionSearchOptions builder
     */
    public Builder highlightFields(List<String> highlightFields) {
      this.highlightFields = highlightFields;
      return this;
    }

    /**
     * Set the highlightNumber.
     *
     * @param highlightNumber the highlightNumber
     * @return the PostPartitionSearchOptions builder
     */
    public Builder highlightNumber(long highlightNumber) {
      this.highlightNumber = highlightNumber;
      return this;
    }

    /**
     * Set the highlightPostTag.
     *
     * @param highlightPostTag the highlightPostTag
     * @return the PostPartitionSearchOptions builder
     */
    public Builder highlightPostTag(String highlightPostTag) {
      this.highlightPostTag = highlightPostTag;
      return this;
    }

    /**
     * Set the highlightPreTag.
     *
     * @param highlightPreTag the highlightPreTag
     * @return the PostPartitionSearchOptions builder
     */
    public Builder highlightPreTag(String highlightPreTag) {
      this.highlightPreTag = highlightPreTag;
      return this;
    }

    /**
     * Set the highlightSize.
     *
     * @param highlightSize the highlightSize
     * @return the PostPartitionSearchOptions builder
     */
    public Builder highlightSize(long highlightSize) {
      this.highlightSize = highlightSize;
      return this;
    }

    /**
     * Set the includeDocs.
     *
     * @param includeDocs the includeDocs
     * @return the PostPartitionSearchOptions builder
     */
    public Builder includeDocs(Boolean includeDocs) {
      this.includeDocs = includeDocs;
      return this;
    }

    /**
     * Set the includeFields.
     * Existing includeFields will be replaced.
     *
     * @param includeFields the includeFields
     * @return the PostPartitionSearchOptions builder
     */
    public Builder includeFields(List<String> includeFields) {
      this.includeFields = includeFields;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the PostPartitionSearchOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the sort.
     * Existing sort will be replaced.
     *
     * @param sort the sort
     * @return the PostPartitionSearchOptions builder
     */
    public Builder sort(List<String> sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the stale.
     *
     * @param stale the stale
     * @return the PostPartitionSearchOptions builder
     */
    public Builder stale(String stale) {
      this.stale = stale;
      return this;
    }
  }

  protected PostPartitionSearchOptions() { }

  protected PostPartitionSearchOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.partitionKey,
      "partitionKey cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ddoc,
      "ddoc cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.index,
      "index cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.query,
      "query cannot be null");
    db = builder.db;
    partitionKey = builder.partitionKey;
    ddoc = builder.ddoc;
    index = builder.index;
    query = builder.query;
    bookmark = builder.bookmark;
    highlightFields = builder.highlightFields;
    highlightNumber = builder.highlightNumber;
    highlightPostTag = builder.highlightPostTag;
    highlightPreTag = builder.highlightPreTag;
    highlightSize = builder.highlightSize;
    includeDocs = builder.includeDocs;
    includeFields = builder.includeFields;
    limit = builder.limit;
    sort = builder.sort;
    stale = builder.stale;
  }

  /**
   * New builder.
   *
   * @return a PostPartitionSearchOptions builder
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
   * Gets the index.
   *
   * Path parameter to specify the index name.
   *
   * @return the index
   */
  public String index() {
    return index;
  }

  /**
   * Gets the query.
   *
   * The Lucene query to execute.
   *
   * @return the query
   */
  public String query() {
    return query;
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
   * Gets the highlightFields.
   *
   * Specifies which fields to highlight. If specified, the result object contains a highlights field with an entry for
   * each specified field.
   *
   * @return the highlightFields
   */
  public List<String> highlightFields() {
    return highlightFields;
  }

  /**
   * Gets the highlightNumber.
   *
   * Number of fragments that are returned in highlights. If the search term occurs less often than the number of
   * fragments that are specified, longer fragments are returned.
   *
   * @return the highlightNumber
   */
  public Long highlightNumber() {
    return highlightNumber;
  }

  /**
   * Gets the highlightPostTag.
   *
   * A string that is inserted after the highlighted word in the highlights output.
   *
   * @return the highlightPostTag
   */
  public String highlightPostTag() {
    return highlightPostTag;
  }

  /**
   * Gets the highlightPreTag.
   *
   * A string that is inserted before the highlighted word in the highlights output.
   *
   * @return the highlightPreTag
   */
  public String highlightPreTag() {
    return highlightPreTag;
  }

  /**
   * Gets the highlightSize.
   *
   * Number of characters in each fragment for highlights.
   *
   * @return the highlightSize
   */
  public Long highlightSize() {
    return highlightSize;
  }

  /**
   * Gets the includeDocs.
   *
   * Include the full content of the documents in the return.
   *
   * @return the includeDocs
   */
  public Boolean includeDocs() {
    return includeDocs;
  }

  /**
   * Gets the includeFields.
   *
   * A JSON array of field names to include in search results. Any fields that are included must be indexed with the
   * store:true option. The default is all fields.
   *
   * @return the includeFields
   */
  public List<String> includeFields() {
    return includeFields;
  }

  /**
   * Gets the limit.
   *
   * Limit the number of the returned documents to the specified number.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the sort.
   *
   * Specifies the sort order of the results. In a grouped search (when group_field is used), this parameter specifies
   * the sort order within a group. The default sort order is relevance.  A JSON string of the form
   * "fieldname&amp;lt;type&amp;gt;" or "-fieldname&amp;lt;type&amp;gt;" for descending order, where fieldname is the
   * name of a string or number field, and type is either a number, a string, or a JSON array of strings. The type part
   * is optional, and defaults to number. Some examples are "foo", "-foo", "bar&amp;lt;string&amp;gt;",
   * "-foo&amp;lt;number&amp;gt;" and ["-foo&amp;lt;number&amp;gt;", "bar&amp;lt;string&amp;gt;"]. String fields that
   * are used for sorting must not be analyzed fields. Fields that are used for sorting must be indexed by the same
   * indexer that is used for the search query.
   *
   * @return the sort
   */
  public List<String> sort() {
    return sort;
  }

  /**
   * Gets the stale.
   *
   * Do not wait for the index to finish building to return results.
   *
   * @return the stale
   */
  public String stale() {
    return stale;
  }
}

