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
 * Schema for a GeoJSON geometry object.
 *
 * Classes which extend this class:
 * - GeoJsonGeometry
 * - GeoJsonGeometryCollection
 */
public class GeoJsonGeometryObject extends GenericModel {

  /**
   * The type of GeoJSON Geometry.
   */
  public interface Type {
    /** Point. */
    String POINT = "Point";
    /** MultiPoint. */
    String MULTIPOINT = "MultiPoint";
    /** LineString. */
    String LINESTRING = "LineString";
    /** MultiLineString. */
    String MULTILINESTRING = "MultiLineString";
    /** Polygon. */
    String POLYGON = "Polygon";
    /** MultiPolygon. */
    String MULTIPOLYGON = "MultiPolygon";
    /** GeometryCollection. */
    String GEOMETRYCOLLECTION = "GeometryCollection";
  }

  protected String type;
  protected List<Object> coordinates;
  protected List<GeoJsonGeometry> geometries;

  protected GeoJsonGeometryObject() {
  }

  /**
   * Gets the type.
   *
   * The type of GeoJSON Geometry.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the coordinates.
   *
   * Used for all geometry types except `GeometryCollection`. The structure of the elements in the array varies by
   * geometry type.
   *
   * @return the coordinates
   */
  public List<Object> getCoordinates() {
    return coordinates;
  }

  /**
   * Gets the geometries.
   *
   * Used for the `GeometryCollection` type.
   *
   * @return the geometries
   */
  public List<GeoJsonGeometry> getGeometries() {
    return geometries;
  }
}

