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
 * Schema for the result of a document modification.
 */
public class DocumentResult extends GenericModel {

  protected String id;
  protected String rev;
  protected Boolean ok;
  @SerializedName("caused_by")
  protected String causedBy;
  protected String error;
  protected String reason;

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
   * Gets the rev.
   *
   * Schema for a document revision identifier.
   *
   * @return the rev
   */
  public String getRev() {
    return rev;
  }

  /**
   * Gets the ok.
   *
   * ok.
   *
   * @return the ok
   */
  public Boolean isOk() {
    return ok;
  }

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
}

