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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Detailed information about current consumption.
 */
public class CurrentThroughputInformationThroughput extends GenericModel {

  protected Long query;
  protected Long read;
  protected Long write;

  /**
   * Gets the query.
   *
   * Number of global queries conducted against the instance for a given second.
   *
   * @return the query
   */
  public Long getQuery() {
    return query;
  }

  /**
   * Gets the read.
   *
   * Number of reads conducted against the instance for a given second.
   *
   * @return the read
   */
  public Long getRead() {
    return read;
  }

  /**
   * Gets the write.
   *
   * Number of writes conducted against the instance for a given second.
   *
   * @return the write
   */
  public Long getWrite() {
    return write;
  }
}

