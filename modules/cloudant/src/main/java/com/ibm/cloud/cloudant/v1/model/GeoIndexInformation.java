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
 * Schema for information about a geospatial index.
 */
public class GeoIndexInformation extends GenericModel {

  @SerializedName("geo_index")
  protected GeoIndexStats geoIndex;
  protected String name;

  /**
   * Gets the geoIndex.
   *
   * Schema for geospatial index statistics.
   *
   * @return the geoIndex
   */
  public GeoIndexStats getGeoIndex() {
    return geoIndex;
  }

  /**
   * Gets the name.
   *
   * The name of the geospatial index design document.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}

