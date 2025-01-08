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
 * Schema for an ability to tell if view is up-to-date without querying it.
 */
public class UpdatesPending extends GenericModel {

  protected Long minimum;
  protected Long preferred;
  protected Long total;

  protected UpdatesPending() { }

  /**
   * Gets the minimum.
   *
   * Sum of shard copies with the least amount of work to do.
   *
   * @return the minimum
   */
  public Long getMinimum() {
    return minimum;
  }

  /**
   * Gets the preferred.
   *
   * Sum of unique shards. This value is zero when at least one copy of every shard range is up-to-date and the view is
   * able to answer a query without index building delays.
   *
   * @return the preferred
   */
  public Long getPreferred() {
    return preferred;
  }

  /**
   * Gets the total.
   *
   * Sum of all shard copies.
   *
   * @return the total
   */
  public Long getTotal() {
    return total;
  }
}

