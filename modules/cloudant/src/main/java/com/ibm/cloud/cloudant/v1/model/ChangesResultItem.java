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
 * Schema for an item in the changes results array.
 */
public class ChangesResultItem extends GenericModel {

  protected List<Change> changes;
  protected Boolean deleted;
  protected Document doc;
  protected String id;
  protected String seq;

  protected ChangesResultItem() { }

  /**
   * Gets the changes.
   *
   * List of document's leaves with single field rev.
   *
   * @return the changes
   */
  public List<Change> getChanges() {
    return changes;
  }

  /**
   * Gets the deleted.
   *
   * if `true` then the document is deleted.
   *
   * @return the deleted
   */
  public Boolean isDeleted() {
    return deleted;
  }

  /**
   * Gets the doc.
   *
   * Schema for a document.
   *
   * @return the doc
   */
  public Document getDoc() {
    return doc;
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

  /**
   * Gets the seq.
   *
   * Update sequence.
   *
   * @return the seq
   */
  public String getSeq() {
    return seq;
  }
}

