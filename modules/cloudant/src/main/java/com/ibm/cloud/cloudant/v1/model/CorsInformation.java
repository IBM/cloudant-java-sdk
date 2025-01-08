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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about the CORS configuration.
 */
public class CorsInformation extends GenericModel {

  @SerializedName("allow_credentials")
  protected Boolean allowCredentials;
  @SerializedName("enable_cors")
  protected Boolean enableCors;
  protected List<String> origins;

  protected CorsInformation() { }

  /**
   * Gets the allowCredentials.
   *
   * Boolean value to allow authentication credentials. If set to true, browser requests must be done by using
   * withCredentials = true.
   *
   * @return the allowCredentials
   */
  public Boolean isAllowCredentials() {
    return allowCredentials;
  }

  /**
   * Gets the enableCors.
   *
   * Boolean value to turn CORS on and off.
   *
   * @return the enableCors
   */
  public Boolean isEnableCors() {
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
  public List<String> getOrigins() {
    return origins;
  }
}

