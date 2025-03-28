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

import java.util.Date;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a replication scheduler job event.
 */
public class SchedulerJobEvent extends GenericModel {

  protected String reason;
  protected Date timestamp;
  protected String type;

  protected SchedulerJobEvent() { }

  /**
   * Gets the reason.
   *
   * Reason for current state of event.
   *
   * @return the reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * Gets the timestamp.
   *
   * Timestamp of the event.
   *
   * @return the timestamp
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Gets the type.
   *
   * Type of the event.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}

