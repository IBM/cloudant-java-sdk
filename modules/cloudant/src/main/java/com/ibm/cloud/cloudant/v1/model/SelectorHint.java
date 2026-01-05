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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for extra information on the selector.
 */
public class SelectorHint extends GenericModel {

  /**
   * A type of the index.
   */
  public interface Type {
    /** json. */
    String JSON = "json";
    /** text. */
    String TEXT = "text";
  }

  @SerializedName("indexable_fields")
  protected List<String> indexableFields;
  protected String type;
  @SerializedName("unindexable_fields")
  protected List<String> unindexableFields;

  protected SelectorHint() { }

  /**
   * Gets the indexableFields.
   *
   * A list of fields in the given selector that can be used to restrict the query.
   *
   * @return the indexableFields
   */
  public List<String> getIndexableFields() {
    return indexableFields;
  }

  /**
   * Gets the type.
   *
   * A type of the index.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the unindexableFields.
   *
   * A list of fields in the given selector that can't be used to restrict the query.
   *
   * @return the unindexableFields
   */
  public List<String> getUnindexableFields() {
    return unindexableFields;
  }
}

