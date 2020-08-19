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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a row of document information in a DocsResult.
 */
public class DocsResultRow extends GenericModel {

  @SerializedName("caused_by")
  protected String causedBy;
  protected String error;
  protected String reason;
  protected Document doc;
  protected String id;
  protected String key;
  protected DocsResultRowValue value;

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
   * id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the key.
   *
   * Document ID.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the value.
   *
   * Value of built-in `/_all_docs` style view.
   *
   * @return the value
   */
  public DocsResultRowValue getValue() {
    return value;
  }
}

