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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about pending updates for an index, calculated across all available copies of all shards.
 */
public class UpdatesPending extends GenericModel {

  protected Long copies;
  @SerializedName("copies_expected")
  protected Long copiesExpected;
  protected Long maximum;
  protected Long minimum;
  protected Long preferred;
  protected Long total;

  protected UpdatesPending() { }

  /**
   * Gets the copies.
   *
   * The number of shard copies that reported an answer. Copies that are unreachable or in maintenance mode are not
   * included. Compare with the `copies_expected` value.
   *
   * @return the copies
   */
  public Long getCopies() {
    return copies;
  }

  /**
   * Gets the copiesExpected.
   *
   * The expected number of shard copy responses. If `copies` is less than this value, the results might be partial and
   * `maximum` might not represent the true backlog.
   *
   * @return the copiesExpected
   */
  public Long getCopiesExpected() {
    return copiesExpected;
  }

  /**
   * Gets the maximum.
   *
   * The backlog of the least up-to-date copy of each shard range. A value of `0` means the index is fully built on
   * every copy.
   *
   * @return the maximum
   */
  public Long getMaximum() {
    return maximum;
  }

  /**
   * Gets the minimum.
   *
   * The backlog of the most up-to-date copy of each shard range. A value of `0` means that at least one complete copy
   * exists for every shard range.
   *
   * @return the minimum
   */
  public Long getMinimum() {
    return minimum;
  }

  /**
   * Gets the preferred.
   *
   * The backlog of the preferred shard copies, which are the copies that queries are routed to by default.
   *
   * @return the preferred
   */
  public Long getPreferred() {
    return preferred;
  }

  /**
   * Gets the total.
   *
   * The total backlog across all shard copies.
   *
   * @return the total
   */
  public Long getTotal() {
    return total;
  }
}

