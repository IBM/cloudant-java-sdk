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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for view functions definition.
 */
public class DesignDocumentViewsMapReduce extends GenericModel {

  protected String map;
  protected String reduce;

  /**
   * Builder.
   */
  public static class Builder {
    private String map;
    private String reduce;

    /**
     * Instantiates a new Builder from an existing DesignDocumentViewsMapReduce instance.
     *
     * @param designDocumentViewsMapReduce the instance to initialize the Builder with
     */
    private Builder(DesignDocumentViewsMapReduce designDocumentViewsMapReduce) {
      this.map = designDocumentViewsMapReduce.map;
      this.reduce = designDocumentViewsMapReduce.reduce;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param map the map
     */
    public Builder(String map) {
      this.map = map;
    }

    /**
     * Builds a DesignDocumentViewsMapReduce.
     *
     * @return the new DesignDocumentViewsMapReduce instance
     */
    public DesignDocumentViewsMapReduce build() {
      return new DesignDocumentViewsMapReduce(this);
    }

    /**
     * Set the map.
     *
     * @param map the map
     * @return the DesignDocumentViewsMapReduce builder
     */
    public Builder map(String map) {
      this.map = map;
      return this;
    }

    /**
     * Set the reduce.
     *
     * @param reduce the reduce
     * @return the DesignDocumentViewsMapReduce builder
     */
    public Builder reduce(String reduce) {
      this.reduce = reduce;
      return this;
    }
  }

  protected DesignDocumentViewsMapReduce() { }

  protected DesignDocumentViewsMapReduce(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.map,
      "map cannot be null");
    map = builder.map;
    reduce = builder.reduce;
  }

  /**
   * New builder.
   *
   * @return a DesignDocumentViewsMapReduce builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the map.
   *
   * JavaScript map function as a string.
   *
   * @return the map
   */
  public String map() {
    return map;
  }

  /**
   * Gets the reduce.
   *
   * JavaScript reduce function as a string.
   *
   * @return the reduce
   */
  public String reduce() {
    return reduce;
  }
}

