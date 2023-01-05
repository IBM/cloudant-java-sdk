/*
 * (C) Copyright IBM Corp. 2023.
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
 * Schema for detailed information about throughput capacity with breakdown by specific throughput requests classes.
 */
public class ThroughputInformation extends GenericModel {

  protected Long blocks;
  protected Long query;
  protected Long read;
  protected Long write;

  protected ThroughputInformation() { }

  /**
   * Gets the blocks.
   *
   * A number of blocks of throughput units. A block consists of 100 reads/sec, 50 writes/sec, and 5 global queries/sec
   * of provisioned throughput capacity.
   *
   * @return the blocks
   */
  public Long getBlocks() {
    return blocks;
  }

  /**
   * Gets the query.
   *
   * Provisioned global queries capacity in operations per second.
   *
   * @return the query
   */
  public Long getQuery() {
    return query;
  }

  /**
   * Gets the read.
   *
   * Provisioned reads capacity in operations per second.
   *
   * @return the read
   */
  public Long getRead() {
    return read;
  }

  /**
   * Gets the write.
   *
   * Provisioned writes capacity in operations per second.
   *
   * @return the write
   */
  public Long getWrite() {
    return write;
  }
}

