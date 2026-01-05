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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about the currently provisioned and target throughput capacity.
 */
public class CapacityThroughputInformation extends GenericModel {

  protected CapacityThroughputInformationCurrent current;
  protected CapacityThroughputInformationTarget target;

  protected CapacityThroughputInformation() { }

  /**
   * Gets the current.
   *
   * Detailed information about provisioned throughput capacity.
   *
   * @return the current
   */
  public CapacityThroughputInformationCurrent getCurrent() {
    return current;
  }

  /**
   * Gets the target.
   *
   * Detailed information about target throughput capacity.
   *
   * @return the target
   */
  public CapacityThroughputInformationTarget getTarget() {
    return target;
  }
}

