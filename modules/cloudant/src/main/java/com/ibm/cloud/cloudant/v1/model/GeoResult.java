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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for the result of a geospatial query operation. For the `legacy`, `geojson`, or `application/vnd.geo+json`
 * format this is a GeoJson FeatureCollection with additional metadata in foreign members.
 */
public class GeoResult extends GenericModel {

  /**
   * Declaration of the GeoJSON type: FeatureCollection Object.
   */
  public interface Type {
    /** FeatureCollection. */
    String FEATURECOLLECTION = "FeatureCollection";
  }

  protected String bookmark;
  protected List<GeoJsonFeature> features;
  protected List<GeoResultRow> rows;
  protected String type;

  /**
   * Gets the bookmark.
   *
   * Opaque bookmark token used when paginating results.
   *
   * @return the bookmark
   */
  public String getBookmark() {
    return bookmark;
  }

  /**
   * Gets the features.
   *
   * The array of GeoJSON Feature Objects matching the geospatial query.
   *
   * @return the features
   */
  public List<GeoJsonFeature> getFeatures() {
    return features;
  }

  /**
   * Gets the rows.
   *
   * The array of rows matching the geospatial query. Present only when using `view` format.
   *
   * @return the rows
   */
  public List<GeoResultRow> getRows() {
    return rows;
  }

  /**
   * Gets the type.
   *
   * Declaration of the GeoJSON type: FeatureCollection Object.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}

