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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Schema for a GeoJSON feature object. Note that the content of the feature objects varies depending on the response
 * format chosen and whether the `include_docs` parameter is `true`.
 */
public class GeoJsonFeature extends DynamicModel<Object> {

  /**
   * Declaration of the GeoJSON type: Feature Object.
   */
  public interface Type {
    /** Feature. */
    String FEATURE = "Feature";
  }

  @SerializedName("_id")
  protected String id;
  @SerializedName("_rev")
  protected String rev;
  @SerializedName("bbox")
  protected List<Double> bbox;
  @SerializedName("geometry")
  protected GeoJsonGeometryObject geometry;
  @SerializedName("properties")
  protected Map<String, Object> xProperties;
  @SerializedName("type")
  protected String type;

  public GeoJsonFeature() {
    super(new TypeToken<Object>() { });
  }

  /**
   * Gets the id.
   *
   * Schema for a document ID.
   *
   * @return the id
   */
  public String getId() {
    return this.id;
  }

  /**
   * Gets the rev.
   *
   * Schema for a document revision identifier.
   *
   * @return the rev
   */
  public String getRev() {
    return this.rev;
  }

  /**
   * Gets the bbox.
   *
   * Schema for a GeoJSON bounding box.
   *
   * @return the bbox
   */
  public List<Double> getBbox() {
    return this.bbox;
  }

  /**
   * Gets the geometry.
   *
   * Schema for a GeoJSON geometry object.
   *
   * @return the geometry
   */
  public GeoJsonGeometryObject getGeometry() {
    return this.geometry;
  }

  /**
   * Gets the xProperties.
   *
   * Schema for the properties of a GeoJSON feature object.
   *
   * @return the xProperties
   */
  public Map<String, Object> getXProperties() {
    return this.xProperties;
  }

  /**
   * Gets the type.
   *
   * Declaration of the GeoJSON type: Feature Object.
   *
   * @return the type
   */
  public String getType() {
    return this.type;
  }
}
