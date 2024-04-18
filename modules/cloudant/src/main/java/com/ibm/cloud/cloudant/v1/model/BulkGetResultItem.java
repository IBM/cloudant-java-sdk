/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for the document revisions information from a bulk get operation.
 */
public class BulkGetResultItem extends GenericModel {

  protected List<BulkGetResultDocument> docs;
  protected String id;

  protected BulkGetResultItem() { }

  /**
   * Gets the docs.
   *
   * Array of document revisions or error information.
   *
   * @return the docs
   */
  public List<BulkGetResultDocument> getDocs() {
    return docs;
  }

  /**
   * Gets the id.
   *
   * Schema for a document ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }
}

