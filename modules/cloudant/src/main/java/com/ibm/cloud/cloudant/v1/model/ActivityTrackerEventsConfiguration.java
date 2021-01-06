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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for Activity Tracker events configuration.
 */
public class ActivityTrackerEventsConfiguration extends GenericModel {

  public interface Types {
    /** management. */
    String MANAGEMENT = "management";
    /** data. */
    String DATA = "data";
  }

  protected List<String> types;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> types;

    private Builder(ActivityTrackerEventsConfiguration activityTrackerEventsConfiguration) {
      this.types = activityTrackerEventsConfiguration.types;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param types the types
     */
    public Builder(List<String> types) {
      this.types = types;
    }

    /**
     * Builds a ActivityTrackerEventsConfiguration.
     *
     * @return the new ActivityTrackerEventsConfiguration instance
     */
    public ActivityTrackerEventsConfiguration build() {
      return new ActivityTrackerEventsConfiguration(this);
    }

    /**
     * Adds an types to types.
     *
     * @param types the new types
     * @return the ActivityTrackerEventsConfiguration builder
     */
    public Builder addTypes(String types) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(types,
        "types cannot be null");
      if (this.types == null) {
        this.types = new ArrayList<String>();
      }
      this.types.add(types);
      return this;
    }

    /**
     * Set the types.
     * Existing types will be replaced.
     *
     * @param types the types
     * @return the ActivityTrackerEventsConfiguration builder
     */
    public Builder types(List<String> types) {
      this.types = types;
      return this;
    }
  }

  protected ActivityTrackerEventsConfiguration(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.types,
      "types cannot be null");
    types = builder.types;
  }

  /**
   * New builder.
   *
   * @return a ActivityTrackerEventsConfiguration builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the types.
   *
   * An array of event types that are being sent to IBM Cloud Activity Tracker with LogDNA for the IBM Cloudant
   * instance. "management" is a required element of this array.
   *
   * @return the types
   */
  public List<String> types() {
    return types;
  }
}

