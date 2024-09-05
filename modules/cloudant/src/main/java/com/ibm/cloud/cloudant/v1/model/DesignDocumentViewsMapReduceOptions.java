/*
 * (C) Copyright IBM Corp. 2024.
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

import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Options of view build resuls.
 *
 * This type supports additional properties of type Object.
 */
public class DesignDocumentViewsMapReduceOptions extends DynamicModel<Object> {


  public DesignDocumentViewsMapReduceOptions() {
    super(new TypeToken<Object>() { });
  }

  /**
   * Builder.
   */
  public static class Builder {
    private Map<String, Object> dynamicProperties;

    /**
     * Instantiates a new Builder from an existing DesignDocumentViewsMapReduceOptions instance.
     *
     * @param designDocumentViewsMapReduceOptions the instance to initialize the Builder with
     */
    private Builder(DesignDocumentViewsMapReduceOptions designDocumentViewsMapReduceOptions) {
      this.dynamicProperties = designDocumentViewsMapReduceOptions.getProperties();
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DesignDocumentViewsMapReduceOptions.
     *
     * @return the new DesignDocumentViewsMapReduceOptions instance
     */
    public DesignDocumentViewsMapReduceOptions build() {
      return new DesignDocumentViewsMapReduceOptions(this);
    }

    /**
     * Add an arbitrary property.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the DesignDocumentViewsMapReduceOptions builder
     */
    public Builder add(String name, Object value) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(name, "name cannot be null");
      if (this.dynamicProperties == null) {
        this.dynamicProperties = new HashMap<String, Object>();
      }
      this.dynamicProperties.put(name, value);
      return this;
    }
  }

  protected DesignDocumentViewsMapReduceOptions(Builder builder) {
    super(new TypeToken<Object>() { });
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a DesignDocumentViewsMapReduceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
