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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about the server instance.
 */
public class ServerInformation extends GenericModel {

  protected String couchdb;
  protected List<String> features;
  protected ServerVendor vendor;
  protected String version;
  @SerializedName("features_flags")
  protected List<String> featuresFlags;

  /**
   * Gets the couchdb.
   *
   * Welcome message.
   *
   * @return the couchdb
   */
  public String getCouchdb() {
    return couchdb;
  }

  /**
   * Gets the features.
   *
   * List of enabled optional features.
   *
   * @return the features
   */
  public List<String> getFeatures() {
    return features;
  }

  /**
   * Gets the vendor.
   *
   * Schema for server vendor information.
   *
   * @return the vendor
   */
  public ServerVendor getVendor() {
    return vendor;
  }

  /**
   * Gets the version.
   *
   * Apache CouchDB version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the featuresFlags.
   *
   * List of feature flags.
   *
   * @return the featuresFlags
   */
  public List<String> getFeaturesFlags() {
    return featuresFlags;
  }
}

