/*
 * (C) Copyright IBM Corp. 2026.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A reason for index's exclusion.
 */
public class IndexAnalysisExclusionReason extends GenericModel {

  /**
   * A reason code for index's exclusion.
   *
   * The full list of possible reason codes is following:
   *
   * * alphabetically_comes_after: json
   *   There is another suitable index whose name comes before that of
   *   this index.
   * * empty_selector: text
   * "text" indexes do not support queries with empty selectors.
   * * excluded_by_user: any use_index was used to manually specify the index.
   * * field_mismatch: any Fields in "selector" of the query do match with the fields available in the index.
   * * is_partial: json, text Partial indexes can be selected only manually.
   * * less_overlap: json There is a better match of fields available within the indexes for the query.
   * * needs_text_search: json The use of the $text operator requires a "text" index.
   * * scope_mismatch: json The scope of the query and the index is not the same.
   * * sort_order_mismatch: json, special Fields in "sort" of the query do not match with the fields available in the
   * index.
   * * too_many_fields: json The index has more fields than the chosen one.
   * * unfavored_type: any The type of the index is not preferred.
   */
  public interface Name {
    /** alphabetically_comes_after. */
    String ALPHABETICALLY_COMES_AFTER = "alphabetically_comes_after";
    /** empty_selector. */
    String EMPTY_SELECTOR = "empty_selector";
    /** excluded_by_user. */
    String EXCLUDED_BY_USER = "excluded_by_user";
    /** field_mismatch. */
    String FIELD_MISMATCH = "field_mismatch";
    /** is_partial. */
    String IS_PARTIAL = "is_partial";
    /** less_overlap. */
    String LESS_OVERLAP = "less_overlap";
    /** needs_text_search. */
    String NEEDS_TEXT_SEARCH = "needs_text_search";
    /** scope_mismatch. */
    String SCOPE_MISMATCH = "scope_mismatch";
    /** sort_order_mismatch. */
    String SORT_ORDER_MISMATCH = "sort_order_mismatch";
    /** too_many_fields. */
    String TOO_MANY_FIELDS = "too_many_fields";
    /** unfavored_type. */
    String UNFAVORED_TYPE = "unfavored_type";
  }

  protected String name;

  protected IndexAnalysisExclusionReason() { }

  /**
   * Gets the name.
   *
   * A reason code for index's exclusion.
   *
   * The full list of possible reason codes is following:
   *
   * * alphabetically_comes_after: json
   *   There is another suitable index whose name comes before that of
   *   this index.
   * * empty_selector: text
   * "text" indexes do not support queries with empty selectors.
   * * excluded_by_user: any use_index was used to manually specify the index.
   * * field_mismatch: any Fields in "selector" of the query do match with the fields available in the index.
   * * is_partial: json, text Partial indexes can be selected only manually.
   * * less_overlap: json There is a better match of fields available within the indexes for the query.
   * * needs_text_search: json The use of the $text operator requires a "text" index.
   * * scope_mismatch: json The scope of the query and the index is not the same.
   * * sort_order_mismatch: json, special Fields in "sort" of the query do not match with the fields available in the
   * index.
   * * too_many_fields: json The index has more fields than the chosen one.
   * * unfavored_type: any The type of the index is not preferred.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}

