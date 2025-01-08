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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about known nodes and cluster membership.
 */
public class MembershipInformation extends GenericModel {

  @SerializedName("all_nodes")
  protected List<String> allNodes;
  @SerializedName("cluster_nodes")
  protected List<String> clusterNodes;

  protected MembershipInformation() { }

  /**
   * Gets the allNodes.
   *
   * List of nodes this node knows about, including the ones that are part of the cluster.
   *
   * @return the allNodes
   */
  public List<String> getAllNodes() {
    return allNodes;
  }

  /**
   * Gets the clusterNodes.
   *
   * All cluster nodes.
   *
   * @return the clusterNodes
   */
  public List<String> getClusterNodes() {
    return clusterNodes;
  }
}

