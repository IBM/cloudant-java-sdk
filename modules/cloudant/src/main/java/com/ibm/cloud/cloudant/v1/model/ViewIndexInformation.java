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
 * Schema for view index status for a design document.
 */
public class ViewIndexInformation extends GenericModel {

  protected Boolean ok;
  @SerializedName("caused_by")
  protected String causedBy;
  protected String error;
  protected String reason;
  protected Long ref;
  protected String ddoc;
  protected DesignDocumentViewIndex info;
  protected List<String> views;

  protected ViewIndexInformation() { }

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
   * Gets the ddoc.
   *
   * Schema for a design document ID including a `_design/` prefix.
   *
   * @return the ddoc
   */
  public String getDdoc() {
    return ddoc;
  }

  /**
   * Gets the info.
   *
   * View index information.
   *
   * @return the info
   */
  public DesignDocumentViewIndex getInfo() {
    return info;
  }

  /**
   * Gets the views.
   *
   * The map-reduce view names in the design document.
   *
   * @return the views
   */
  public List<String> getViews() {
    return views;
  }
}

