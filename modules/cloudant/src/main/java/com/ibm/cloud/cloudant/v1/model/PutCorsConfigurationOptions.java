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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The putCorsConfiguration options.
 */
public class PutCorsConfigurationOptions extends GenericModel {

  protected List<String> origins;
  protected Boolean allowCredentials;
  protected Boolean enableCors;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> origins;
    private Boolean allowCredentials;
    private Boolean enableCors;

    /**
     * Instantiates a new Builder from an existing PutCorsConfigurationOptions instance.
     *
     * @param putCorsConfigurationOptions the instance to initialize the Builder with
     */
    private Builder(PutCorsConfigurationOptions putCorsConfigurationOptions) {
      this.origins = putCorsConfigurationOptions.origins;
      this.allowCredentials = putCorsConfigurationOptions.allowCredentials;
      this.enableCors = putCorsConfigurationOptions.enableCors;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param origins the origins
     */
    public Builder(List<String> origins) {
      this.origins = origins;
    }

    /**
     * Builds a PutCorsConfigurationOptions.
     *
     * @return the new PutCorsConfigurationOptions instance
     */
    public PutCorsConfigurationOptions build() {
      return new PutCorsConfigurationOptions(this);
    }

    /**
     * Adds a new element to origins.
     *
     * @param origins the new element to be added
     * @return the PutCorsConfigurationOptions builder
     */
    public Builder addOrigins(String origins) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(origins,
        "origins cannot be null");
      if (this.origins == null) {
        this.origins = new ArrayList<String>();
      }
      this.origins.add(origins);
      return this;
    }

    /**
     * Set the origins.
     * Existing origins will be replaced.
     *
     * @param origins the origins
     * @return the PutCorsConfigurationOptions builder
     */
    public Builder origins(List<String> origins) {
      this.origins = origins;
      return this;
    }

    /**
     * Set the allowCredentials.
     *
     * @param allowCredentials the allowCredentials
     * @return the PutCorsConfigurationOptions builder
     */
    public Builder allowCredentials(Boolean allowCredentials) {
      this.allowCredentials = allowCredentials;
      return this;
    }

    /**
     * Set the enableCors.
     *
     * @param enableCors the enableCors
     * @return the PutCorsConfigurationOptions builder
     */
    public Builder enableCors(Boolean enableCors) {
      this.enableCors = enableCors;
      return this;
    }
  }

  protected PutCorsConfigurationOptions() { }

  protected PutCorsConfigurationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.origins,
      "origins cannot be null");
    origins = builder.origins;
    allowCredentials = builder.allowCredentials;
    enableCors = builder.enableCors;
  }

  /**
   * New builder.
   *
   * @return a PutCorsConfigurationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the origins.
   *
   * An array of strings that contain allowed origin domains. You have to specify the full URL including the protocol.
   * It is recommended that only the HTTPS protocol is used. Subdomains count as separate domains, so you have to
   * specify all subdomains used.
   *
   * @return the origins
   */
  public List<String> origins() {
    return origins;
  }

  /**
   * Gets the allowCredentials.
   *
   * Boolean value to allow authentication credentials. If set to true, browser requests must be done by using
   * withCredentials = true.
   *
   * @return the allowCredentials
   */
  public Boolean allowCredentials() {
    return allowCredentials;
  }

  /**
   * Gets the enableCors.
   *
   * Boolean value to turn CORS on and off.
   *
   * @return the enableCors
   */
  public Boolean enableCors() {
    return enableCors;
  }
}

