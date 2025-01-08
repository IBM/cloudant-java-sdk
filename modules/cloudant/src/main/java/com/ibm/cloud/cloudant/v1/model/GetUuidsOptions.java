/*
 * (C) Copyright IBM Corp. 2025.
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
 * The getUuids options.
 */
public class GetUuidsOptions extends GenericModel {

  protected Long count;

  /**
   * Builder.
   */
  public static class Builder {
    private Long count;

    /**
     * Instantiates a new Builder from an existing GetUuidsOptions instance.
     *
     * @param getUuidsOptions the instance to initialize the Builder with
     */
    private Builder(GetUuidsOptions getUuidsOptions) {
      this.count = getUuidsOptions.count;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetUuidsOptions.
     *
     * @return the new GetUuidsOptions instance
     */
    public GetUuidsOptions build() {
      return new GetUuidsOptions(this);
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the GetUuidsOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  protected GetUuidsOptions() { }

  protected GetUuidsOptions(Builder builder) {
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a GetUuidsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the count.
   *
   * Query parameter to specify the number of UUIDs to return.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }
}

