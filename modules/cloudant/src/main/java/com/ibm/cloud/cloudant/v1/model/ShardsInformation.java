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
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a shards object that maps the hash value range for each shard to the array of nodes that contain a copy of
 * that shard.
 */
public class ShardsInformation extends GenericModel {

  protected Map<String, List<String>> shards;

  /**
   * Gets the shards.
   *
   * Mapping of shard hash value range to a list of nodes.
   *
   * @return the shards
   */
  public Map<String, List<String>> getShards() {
    return shards;
  }
}

