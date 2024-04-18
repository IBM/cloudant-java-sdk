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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for server vendor information.
 */
public class ServerVendor extends GenericModel {

  protected String name;
  protected String variant;
  protected String version;

  protected ServerVendor() { }

  /**
   * Gets the name.
   *
   * Vendor name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the variant.
   *
   * Vendor variant.
   *
   * @return the variant
   */
  public String getVariant() {
    return variant;
  }

  /**
   * Gets the version.
   *
   * Vendor version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }
}

