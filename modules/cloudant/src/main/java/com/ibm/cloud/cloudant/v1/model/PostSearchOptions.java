/*
 * (C) Copyright IBM Corp. 2022.
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
 * The postSearch options.
 */
public class PostSearchOptions extends GenericModel {

  /**
   * Do not wait for the index to finish building to return results.
   */
  public interface Stale {
    /** ok. */
    String OK = "ok";
  }

  protected String db;
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
  protected List<String> counts;
  protected List<List<String>> drilldown;
  protected String groupField;
  protected Long groupLimit;
  protected List<String> groupSort;
  protected Map<String, Map<String, Map<String, String>>> ranges;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
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
    private List<String> counts;
    private List<List<String>> drilldown;
    private String groupField;
    private Long groupLimit;
    private List<String> groupSort;
    private Map<String, Map<String, Map<String, String>>> ranges;

    private Builder(PostSearchOptions postSearchOptions) {
      this.db = postSearchOptions.db;
      this.ddoc = postSearchOptions.ddoc;
      this.index = postSearchOptions.index;
      this.query = postSearchOptions.query;
      this.bookmark = postSearchOptions.bookmark;
      this.highlightFields = postSearchOptions.highlightFields;
      this.highlightNumber = postSearchOptions.highlightNumber;
      this.highlightPostTag = postSearchOptions.highlightPostTag;
      this.highlightPreTag = postSearchOptions.highlightPreTag;
      this.highlightSize = postSearchOptions.highlightSize;
      this.includeDocs = postSearchOptions.includeDocs;
      this.includeFields = postSearchOptions.includeFields;
      this.limit = postSearchOptions.limit;
      this.sort = postSearchOptions.sort;
      this.stale = postSearchOptions.stale;
      this.counts = postSearchOptions.counts;
      this.drilldown = postSearchOptions.drilldown;
      this.groupField = postSearchOptions.groupField;
      this.groupLimit = postSearchOptions.groupLimit;
      this.groupSort = postSearchOptions.groupSort;
      this.ranges = postSearchOptions.ranges;
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
     * @param ddoc the ddoc
     * @param index the index
     * @param query the query
     */
    public Builder(String db, String ddoc, String index, String query) {
      this.db = db;
      this.ddoc = ddoc;
      this.index = index;
      this.query = query;
    }

    /**
     * Builds a PostSearchOptions.
     *
     * @return the new PostSearchOptions instance
     */
    public PostSearchOptions build() {
      return new PostSearchOptions(this);
    }

    /**
     * Adds an highlightFields to highlightFields.
     *
     * @param highlightFields the new highlightFields
     * @return the PostSearchOptions builder
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
     * @return the PostSearchOptions builder
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
     * @return the PostSearchOptions builder
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
     * Adds an counts to counts.
     *
     * @param counts the new counts
     * @return the PostSearchOptions builder
     */
    public Builder addCounts(String counts) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(counts,
        "counts cannot be null");
      if (this.counts == null) {
        this.counts = new ArrayList<String>();
      }
      this.counts.add(counts);
      return this;
    }

    /**
     * Adds an drilldown to drilldown.
     *
     * @param drilldown the new drilldown
     * @return the PostSearchOptions builder
     */
    public Builder addDrilldown(List<String> drilldown) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(drilldown,
        "drilldown cannot be null");
      if (this.drilldown == null) {
        this.drilldown = new ArrayList<List<String>>();
      }
      this.drilldown.add(drilldown);
      return this;
    }

    /**
     * Adds an groupSort to groupSort.
     *
     * @param groupSort the new groupSort
     * @return the PostSearchOptions builder
     */
    public Builder addGroupSort(String groupSort) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(groupSort,
        "groupSort cannot be null");
      if (this.groupSort == null) {
        this.groupSort = new ArrayList<String>();
      }
      this.groupSort.add(groupSort);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostSearchOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the PostSearchOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the index.
     *
     * @param index the index
     * @return the PostSearchOptions builder
     */
    public Builder index(String index) {
      this.index = index;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the PostSearchOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the bookmark.
     *
     * @param bookmark the bookmark
     * @return the PostSearchOptions builder
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
     * @return the PostSearchOptions builder
     */
    public Builder highlightFields(List<String> highlightFields) {
      this.highlightFields = highlightFields;
      return this;
    }

    /**
     * Set the highlightNumber.
     *
     * @param highlightNumber the highlightNumber
     * @return the PostSearchOptions builder
     */
    public Builder highlightNumber(long highlightNumber) {
      this.highlightNumber = highlightNumber;
      return this;
    }

    /**
     * Set the highlightPostTag.
     *
     * @param highlightPostTag the highlightPostTag
     * @return the PostSearchOptions builder
     */
    public Builder highlightPostTag(String highlightPostTag) {
      this.highlightPostTag = highlightPostTag;
      return this;
    }

    /**
     * Set the highlightPreTag.
     *
     * @param highlightPreTag the highlightPreTag
     * @return the PostSearchOptions builder
     */
    public Builder highlightPreTag(String highlightPreTag) {
      this.highlightPreTag = highlightPreTag;
      return this;
    }

    /**
     * Set the highlightSize.
     *
     * @param highlightSize the highlightSize
     * @return the PostSearchOptions builder
     */
    public Builder highlightSize(long highlightSize) {
      this.highlightSize = highlightSize;
      return this;
    }

    /**
     * Set the includeDocs.
     *
     * @param includeDocs the includeDocs
     * @return the PostSearchOptions builder
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
     * @return the PostSearchOptions builder
     */
    public Builder includeFields(List<String> includeFields) {
      this.includeFields = includeFields;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the PostSearchOptions builder
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
     * @return the PostSearchOptions builder
     */
    public Builder sort(List<String> sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the stale.
     *
     * @param stale the stale
     * @return the PostSearchOptions builder
     */
    public Builder stale(String stale) {
      this.stale = stale;
      return this;
    }

    /**
     * Set the counts.
     * Existing counts will be replaced.
     *
     * @param counts the counts
     * @return the PostSearchOptions builder
     */
    public Builder counts(List<String> counts) {
      this.counts = counts;
      return this;
    }

    /**
     * Set the drilldown.
     * Existing drilldown will be replaced.
     *
     * @param drilldown the drilldown
     * @return the PostSearchOptions builder
     */
    public Builder drilldown(List<List<String>> drilldown) {
      this.drilldown = drilldown;
      return this;
    }

    /**
     * Set the groupField.
     *
     * @param groupField the groupField
     * @return the PostSearchOptions builder
     */
    public Builder groupField(String groupField) {
      this.groupField = groupField;
      return this;
    }

    /**
     * Set the groupLimit.
     *
     * @param groupLimit the groupLimit
     * @return the PostSearchOptions builder
     */
    public Builder groupLimit(long groupLimit) {
      this.groupLimit = groupLimit;
      return this;
    }

    /**
     * Set the groupSort.
     * Existing groupSort will be replaced.
     *
     * @param groupSort the groupSort
     * @return the PostSearchOptions builder
     */
    public Builder groupSort(List<String> groupSort) {
      this.groupSort = groupSort;
      return this;
    }

    /**
     * Set the ranges.
     *
     * @param ranges the ranges
     * @return the PostSearchOptions builder
     */
    public Builder ranges(Map<String, Map<String, Map<String, String>>> ranges) {
      this.ranges = ranges;
      return this;
    }
  }

  protected PostSearchOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ddoc,
      "ddoc cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.index,
      "index cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.query,
      "query cannot be null");
    db = builder.db;
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
    counts = builder.counts;
    drilldown = builder.drilldown;
    groupField = builder.groupField;
    groupLimit = builder.groupLimit;
    groupSort = builder.groupSort;
    ranges = builder.ranges;
  }

  /**
   * New builder.
   *
   * @return a PostSearchOptions builder
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

  /**
   * Gets the counts.
   *
   * This field defines an array of names of string fields, for which counts are requested. The response contains counts
   * for each unique value of this field name among the documents that match the search query. Faceting must be enabled
   * for this parameter to function. This option is only available when making global queries.
   *
   * @return the counts
   */
  public List<String> counts() {
    return counts;
  }

  /**
   * Gets the drilldown.
   *
   * Restrict results to documents with a dimension equal to the specified label(s). The search matches only documents
   * containing the value that was provided in the named field. It differs from using "fieldname:value" in the q
   * parameter only in that the values are not analyzed. Faceting must be enabled for this parameter to function.
   *
   * @return the drilldown
   */
  public List<List<String>> drilldown() {
    return drilldown;
  }

  /**
   * Gets the groupField.
   *
   * Field by which to group search matches. A string that contains the name of a string field. Fields containing other
   * data such as numbers, objects, or arrays cannot be used. This option is only available when making global queries.
   *
   * @return the groupField
   */
  public String groupField() {
    return groupField;
  }

  /**
   * Gets the groupLimit.
   *
   * Maximum group count. This field can be used only if group_field is specified. This option is only available when
   * making global queries.
   *
   * @return the groupLimit
   */
  public Long groupLimit() {
    return groupLimit;
  }

  /**
   * Gets the groupSort.
   *
   * This field defines the order of the groups in a search that uses group_field. The default sort order is relevance.
   * This field can have the same values as the sort field, so single fields and arrays of fields are supported. This
   * option is only available when making global queries.
   *
   * @return the groupSort
   */
  public List<String> groupSort() {
    return groupSort;
  }

  /**
   * Gets the ranges.
   *
   * This field defines ranges for faceted, numeric search fields. The value is a JSON object where the fields names are
   * faceted numeric search fields, and the values of the fields are JSON objects. The field names of the JSON objects
   * are names for ranges. The values are strings that describe the range, for example "[0 TO 10]". This option is only
   * available when making global queries.
   *
   * @return the ranges
   */
  public Map<String, Map<String, Map<String, String>>> ranges() {
    return ranges;
  }
}

