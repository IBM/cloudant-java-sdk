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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a row of a geospatial result using view format.
 */
public class GeoResultRow extends GenericModel {

  protected Document doc;
  protected GeoJsonGeometry geometry;
  protected String id;
  protected String rev;

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
   * Gets the geometry.
   *
   * Schema for a GeoJSON geometry.
   *
   * @return the geometry
   */
  public GeoJsonGeometry getGeometry() {
    return geometry;
  }

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
}

