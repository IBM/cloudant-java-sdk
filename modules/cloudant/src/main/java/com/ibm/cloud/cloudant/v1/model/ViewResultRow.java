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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a row of a view result.
 */
public class ViewResultRow extends GenericModel {

  @SerializedName("caused_by")
  protected String causedBy;
  protected String error;
  protected String reason;
  protected Long ref;
  protected Document doc;
  protected String id;
  protected Object key;
  protected Object value;

  protected ViewResultRow() { }

  /**
   * Gets the causedBy.
   *
   * The cause of the error (if available).
   *
   * @return the causedBy
   */
  public String getCausedBy() {
    return causedBy;
  }

  /**
   * Gets the error.
   *
   * The name of the error.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Gets the reason.
   *
   * The reason the error occurred (if available).
   *
   * @return the reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * Gets the ref.
   *
   * An internal error reference (if available).
   *
   * @return the ref
   */
  public Long getRef() {
    return ref;
  }

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
   * Gets the id.
   *
   * Schema for a document ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the key.
   *
   * Schema for any JSON type.
   *
   * @return the key
   */
  public Object getKey() {
    return key;
  }

  /**
   * Gets the value.
   *
   * Schema for any JSON type.
   *
   * @return the value
   */
  public Object getValue() {
    return value;
  }
}

