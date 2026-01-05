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
 * Schema for metadata information about a search index.
 */
public class SearchIndexInfo extends GenericModel {

  @SerializedName("committed_seq")
  protected Long committedSeq;
  @SerializedName("disk_size")
  protected Long diskSize;
  @SerializedName("doc_count")
  protected Long docCount;
  @SerializedName("doc_del_count")
  protected Long docDelCount;
  @SerializedName("pending_seq")
  protected Long pendingSeq;
  protected String signature;

  protected SearchIndexInfo() { }

  /**
   * Gets the committedSeq.
   *
   * The committed sequence identifier.
   *
   * @return the committedSeq
   */
  public Long getCommittedSeq() {
    return committedSeq;
  }

  /**
   * Gets the diskSize.
   *
   * The size of the search index on disk.
   *
   * @return the diskSize
   */
  public Long getDiskSize() {
    return diskSize;
  }

  /**
   * Gets the docCount.
   *
   * The count of the number of indexed documents.
   *
   * @return the docCount
   */
  public Long getDocCount() {
    return docCount;
  }

  /**
   * Gets the docDelCount.
   *
   * The number of deleted documents.
   *
   * @return the docDelCount
   */
  public Long getDocDelCount() {
    return docDelCount;
  }

  /**
   * Gets the pendingSeq.
   *
   * The pending sequence identifier.
   *
   * @return the pendingSeq
   */
  public Long getPendingSeq() {
    return pendingSeq;
  }

  /**
   * Gets the signature.
   *
   * Unique signature of the search index.
   *
   * @return the signature
   */
  public String getSignature() {
    return signature;
  }
}

