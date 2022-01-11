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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for geospatial index statistics.
 */
public class GeoIndexStats extends GenericModel {

  @SerializedName("data_size")
  protected Long dataSize;
  @SerializedName("disk_size")
  protected Long diskSize;
  @SerializedName("doc_count")
  protected Long docCount;

  /**
   * Gets the dataSize.
   *
   * The size of the geospatial index, in bytes.
   *
   * @return the dataSize
   */
  public Long getDataSize() {
    return dataSize;
  }

  /**
   * Gets the diskSize.
   *
   * The size of the geospatial index, as stored on disk, in bytes.
   *
   * @return the diskSize
   */
  public Long getDiskSize() {
    return diskSize;
  }

  /**
   * Gets the docCount.
   *
   * Number of documents in the geospatial index.
   *
   * @return the docCount
   */
  public Long getDocCount() {
    return docCount;
  }
}

