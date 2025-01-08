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
 * Detailed information about provisioned throughput capacity.
 */
public class CapacityThroughputInformationCurrent extends GenericModel {

  protected ThroughputInformation throughput;

  protected CapacityThroughputInformationCurrent() { }

  /**
   * Gets the throughput.
   *
   * Schema for detailed information about throughput capacity with breakdown by specific throughput requests classes.
   *
   * @return the throughput
   */
  public ThroughputInformation getThroughput() {
    return throughput;
  }
}

