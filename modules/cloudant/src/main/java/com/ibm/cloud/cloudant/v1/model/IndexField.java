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

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Schema for indexed fields for use with declarative JSON query.
 *
 * This type supports additional properties of type String. Schema for sort direction.
 */
public class IndexField extends DynamicModel<String> {

  /**
   * The type of the named field.
   */
  public interface Type {
    /** boolean. */
    String X_BOOLEAN = "boolean";
    /** number. */
    String NUMBER = "number";
    /** string. */
    String STRING = "string";
  }

  @SerializedName("name")
  protected String name;
  @SerializedName("type")
  protected String type;

  public IndexField() {
    super(new TypeToken<String>() { });
  }

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String type;
    private Map<String, String> dynamicProperties;

    /**
     * Instantiates a new Builder from an existing IndexField instance.
     *
     * @param indexField the instance to initialize the Builder with
     */
    private Builder(IndexField indexField) {
      this.name = indexField.name;
      this.type = indexField.type;
      this.dynamicProperties = indexField.getProperties();
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a IndexField.
     *
     * @return the new IndexField instance
     */
    public IndexField build() {
      return new IndexField(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the IndexField builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the IndexField builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Add an arbitrary property.
     * Schema for sort direction.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the IndexField builder
     */
    public Builder add(String name, String value) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(name, "name cannot be null");
      if (this.dynamicProperties == null) {
        this.dynamicProperties = new HashMap<String, String>();
      }
      this.dynamicProperties.put(name, value);
      return this;
    }
  }

  protected IndexField(Builder builder) {
    super(new TypeToken<String>() { });
    name = builder.name;
    type = builder.type;
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a IndexField builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Name of the field.
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Gets the type.
   *
   * The type of the named field.
   *
   * @return the type
   */
  public String getType() {
    return this.type;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }
}
