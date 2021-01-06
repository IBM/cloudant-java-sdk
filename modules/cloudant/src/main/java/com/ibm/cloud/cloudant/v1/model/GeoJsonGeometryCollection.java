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

/**
 * Schema for a GeoJSON GeometryCollection type geometry.
 */
public class GeoJsonGeometryCollection extends GeoJsonGeometryObject {

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

}

