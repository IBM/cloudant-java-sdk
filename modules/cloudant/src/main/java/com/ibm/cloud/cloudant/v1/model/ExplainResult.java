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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about the index used for a find query.
 */
public class ExplainResult extends GenericModel {

  protected Boolean covering;
  protected String dbname;
  protected List<String> fields;
  protected IndexInformation index;
  @SerializedName("index_candidates")
  protected List<IndexCandidate> indexCandidates;
  protected Long limit;
  protected ExplainResultMrArgs mrargs;
  protected ExplainResultOpts opts;
  protected Object partitioned;
  protected Map<String, Object> selector;
  @SerializedName("selector_hints")
  protected List<SelectorHint> selectorHints;
  protected Long skip;

  protected ExplainResult() { }

  /**
   * Gets the covering.
   *
   * When `true`, the query is answered using the index only and no documents are fetched.
   *
   * @return the covering
   */
  public Boolean isCovering() {
    return covering;
  }

  /**
   * Gets the dbname.
   *
   * Schema for a database name.
   *
   * @return the dbname
   */
  public String getDbname() {
    return dbname;
  }

  /**
   * Gets the fields.
   *
   * Fields that were requested to be projected from the document. If no fields were requested to be projected this will
   * be empty and all fields will be returned.
   *
   * @return the fields
   */
  public List<String> getFields() {
    return fields;
  }

  /**
   * Gets the index.
   *
   * Schema for information about an index.
   *
   * @return the index
   */
  public IndexInformation getIndex() {
    return index;
  }

  /**
   * Gets the indexCandidates.
   *
   * Schema for the list of all the other indexes that were not chosen for serving the query.
   *
   * @return the indexCandidates
   */
  public List<IndexCandidate> getIndexCandidates() {
    return indexCandidates;
  }

  /**
   * Gets the limit.
   *
   * The used maximum number of results returned.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the mrargs.
   *
   * Arguments passed to the underlying view.
   *
   * @return the mrargs
   */
  public ExplainResultMrArgs getMrargs() {
    return mrargs;
  }

  /**
   * Gets the opts.
   *
   * Options used for the request.
   *
   * @return the opts
   */
  public ExplainResultOpts getOpts() {
    return opts;
  }

  /**
   * Gets the partitioned.
   *
   * Schema for any JSON type.
   *
   * @return the partitioned
   */
  public Object getPartitioned() {
    return partitioned;
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
   * * Only equality operators such as `$eq`, `$gt`, `$gte`, `$lt`, and
   * `$lte` (but not `$ne`) can be used as the basis of a query. You should include at least one of these in a selector.
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
  public Map<String, Object> getSelector() {
    return selector;
  }

  /**
   * Gets the selectorHints.
   *
   * Schema for a list of objects with extra information on the selector to provide insights about its usability.
   *
   * @return the selectorHints
   */
  public List<SelectorHint> getSelectorHints() {
    return selectorHints;
  }

  /**
   * Gets the skip.
   *
   * Skip parameter used.
   *
   * @return the skip
   */
  public Long getSkip() {
    return skip;
  }
}

