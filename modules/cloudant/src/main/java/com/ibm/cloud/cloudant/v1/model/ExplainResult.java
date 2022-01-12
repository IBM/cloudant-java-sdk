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

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about the index used for a find query.
 */
public class ExplainResult extends GenericModel {

  protected String dbname;
  protected List<String> fields;
  protected IndexInformation index;
  protected Long limit;
  protected Map<String, Object> opts;
  protected ExplainResultRange range;
  protected Map<String, Object> selector;
  protected Long skip;

  /**
   * Gets the dbname.
   *
   * dbname.
   *
   * @return the dbname
   */
  public String getDbname() {
    return dbname;
  }

  /**
   * Gets the fields.
   *
   * fields.
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
   * Gets the limit.
   *
   * limit.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the opts.
   *
   * opts.
   *
   * @return the opts
   */
  public Map<String, Object> getOpts() {
    return opts;
  }

  /**
   * Gets the range.
   *
   * range.
   *
   * @return the range
   */
  public ExplainResultRange getRange() {
    return range;
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
    return selector;
  }

  /**
   * Gets the skip.
   *
   * skip.
   *
   * @return the skip
   */
  public Long getSkip() {
    return skip;
  }
}

