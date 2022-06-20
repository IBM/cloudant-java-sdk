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
 * Schema for a geospatial index definition.
 */
public class GeoIndexDefinition extends GenericModel {

  protected String index;

  /**
   * Builder.
   */
  public static class Builder {
    private String index;

    private Builder(GeoIndexDefinition geoIndexDefinition) {
      this.index = geoIndexDefinition.index;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param index the index
     */
    public Builder(String index) {
      this.index = index;
    }

    /**
     * Builds a GeoIndexDefinition.
     *
     * @return the new GeoIndexDefinition instance
     */
    public GeoIndexDefinition build() {
      return new GeoIndexDefinition(this);
    }

    /**
     * Set the index.
     *
     * @param index the index
     * @return the GeoIndexDefinition builder
     */
    public Builder index(String index) {
      this.index = index;
      return this;
    }
  }

  protected GeoIndexDefinition() { }

  protected GeoIndexDefinition(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.index,
      "index cannot be null");
    index = builder.index;
  }

  /**
   * New builder.
   *
   * @return a GeoIndexDefinition builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the index.
   *
   * String form of a JavaScript function that is called for each document in the database. The function takes the
   * document as a parameter, extracts some geospatial data from it, and then calls the `st_index` function to index
   * that data. The `st_index` takes a GeoJSON geometry as a parameter.
   *
   * @return the index
   */
  public String index() {
    return index;
  }
}

