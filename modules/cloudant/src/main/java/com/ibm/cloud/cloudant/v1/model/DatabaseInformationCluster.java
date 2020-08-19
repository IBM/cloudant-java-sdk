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
 * Schema for database cluster information.
 */
public class DatabaseInformationCluster extends GenericModel {

  protected Long n;
  protected Long q;
  protected Long r;
  protected Long w;

  /**
   * Gets the n.
   *
   * Schema for the number of replicas of a database in a cluster.
   *
   * @return the n
   */
  public Long getN() {
    return n;
  }

  /**
   * Gets the q.
   *
   * Schema for the number of shards in a database. Each shard is a partition of the hash value range.
   *
   * @return the q
   */
  public Long getQ() {
    return q;
  }

  /**
   * Gets the r.
   *
   * Read quorum. The number of consistent copies of a document that need to be read before a successful reply.
   *
   * @return the r
   */
  public Long getR() {
    return r;
  }

  /**
   * Gets the w.
   *
   * Write quorum. The number of copies of a document that need to be written before a successful reply.
   *
   * @return the w
   */
  public Long getW() {
    return w;
  }
}

