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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about the up state of the server.
 */
public class UpInformation extends GenericModel {

  /**
   * status.
   */
  public interface Status {
    /** maintenance_mode. */
    String MAINTENANCE_MODE = "maintenance_mode";
    /** nolb. */
    String NOLB = "nolb";
    /** ok. */
    String OK = "ok";
  }

  protected Map<String, Object> seeds;
  protected String status;

  protected UpInformation() { }

  /**
   * Gets the seeds.
   *
   * seeds.
   *
   * @return the seeds
   */
  public Map<String, Object> getSeeds() {
    return seeds;
  }

  /**
   * Gets the status.
   *
   * status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

