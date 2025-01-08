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
 * Schema for the result of creating an index.
 */
public class IndexResult extends GenericModel {

  /**
   * Flag to show whether the index was created or one already exists.
   */
  public interface Result {
    /** created. */
    String CREATED = "created";
    /** exists. */
    String EXISTS = "exists";
  }

  protected String id;
  protected String name;
  protected String result;

  protected IndexResult() { }

  /**
   * Gets the id.
   *
   * Id of the design document the index was created in.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Name of the index created.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the result.
   *
   * Flag to show whether the index was created or one already exists.
   *
   * @return the result
   */
  public String getResult() {
    return result;
  }
}

