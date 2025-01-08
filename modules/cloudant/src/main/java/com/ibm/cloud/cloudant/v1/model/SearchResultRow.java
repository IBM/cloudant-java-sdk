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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a row of the result of a query search operation.
 */
public class SearchResultRow extends GenericModel {

  protected Document doc;
  protected Map<String, Object> fields;
  protected Map<String, List<String>> highlights;
  protected String id;

  protected SearchResultRow() { }

  /**
   * Gets the doc.
   *
   * Schema for a document.
   *
   * @return the doc
   */
  public Document getDoc() {
    return doc;
  }

  /**
   * Gets the fields.
   *
   * Schema for the fields returned by a query search operation, a map of field name to value.
   *
   * @return the fields
   */
  public Map<String, Object> getFields() {
    return fields;
  }

  /**
   * Gets the highlights.
   *
   * Returns the context in which a search term was mentioned so that you can display more emphasized results to a user.
   *
   * @return the highlights
   */
  public Map<String, List<String>> getHighlights() {
    return highlights;
  }

  /**
   * Gets the id.
   *
   * Schema for a document ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }
}

