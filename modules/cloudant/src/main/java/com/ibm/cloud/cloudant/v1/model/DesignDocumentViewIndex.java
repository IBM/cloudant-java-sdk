/*
 * (C) Copyright IBM Corp. 2021.
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
 * View index information.
 */
public class DesignDocumentViewIndex extends GenericModel {

  @SerializedName("compact_running")
  protected Boolean compactRunning;
  protected String language;
  protected String signature;
  protected ContentInformationSizes sizes;
  @SerializedName("updater_running")
  protected Boolean updaterRunning;
  @SerializedName("waiting_clients")
  protected Long waitingClients;
  @SerializedName("waiting_commit")
  protected Boolean waitingCommit;

  /**
   * Gets the compactRunning.
   *
   * Indicates whether a compaction routine is currently running on the view.
   *
   * @return the compactRunning
   */
  public Boolean isCompactRunning() {
    return compactRunning;
  }

  /**
   * Gets the language.
   *
   * Language for the defined views.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the signature.
   *
   * MD5 signature of the views for the design document.
   *
   * @return the signature
   */
  public String getSignature() {
    return signature;
  }

  /**
   * Gets the sizes.
   *
   * Schema for size information of content.
   *
   * @return the sizes
   */
  public ContentInformationSizes getSizes() {
    return sizes;
  }

  /**
   * Gets the updaterRunning.
   *
   * Indicates if the view is currently being updated.
   *
   * @return the updaterRunning
   */
  public Boolean isUpdaterRunning() {
    return updaterRunning;
  }

  /**
   * Gets the waitingClients.
   *
   * Number of clients waiting on views from this design document.
   *
   * @return the waitingClients
   */
  public Long getWaitingClients() {
    return waitingClients;
  }

  /**
   * Gets the waitingCommit.
   *
   * Indicates if there are outstanding commits to the underlying database that need to processed.
   *
   * @return the waitingCommit
   */
  public Boolean isWaitingCommit() {
    return waitingCommit;
  }
}

