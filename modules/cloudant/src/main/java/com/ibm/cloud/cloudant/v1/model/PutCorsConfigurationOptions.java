/*
 * (C) Copyright IBM Corp. 2020.
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

  protected Boolean allowCredentials;
  protected Boolean enableCors;
  protected List<String> origins;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean allowCredentials;
    private Boolean enableCors;
    private List<String> origins;

    private Builder(PutCorsConfigurationOptions putCorsConfigurationOptions) {
      this.allowCredentials = putCorsConfigurationOptions.allowCredentials;
      this.enableCors = putCorsConfigurationOptions.enableCors;
      this.origins = putCorsConfigurationOptions.origins;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
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
     * Adds an origins to origins.
     *
     * @param origins the new origins
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
     * Set the corsConfiguration.
     *
     * @param corsConfiguration the corsConfiguration
     * @return the PutCorsConfigurationOptions builder
     */
    public Builder corsConfiguration(CorsConfiguration corsConfiguration) {
      this.allowCredentials = corsConfiguration.allowCredentials();
      this.enableCors = corsConfiguration.enableCors();
      this.origins = corsConfiguration.origins();
      return this;
    }
  }

  protected PutCorsConfigurationOptions(Builder builder) {
    allowCredentials = builder.allowCredentials;
    enableCors = builder.enableCors;
    origins = builder.origins;
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
}

