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
 * Value of built-in `/_all_docs` style view.
 */
public class DocsResultRowValue extends GenericModel {

  protected Boolean deleted;
  protected String rev;

  protected DocsResultRowValue() { }

  /**
   * Gets the deleted.
   *
   * If `true` then the document is deleted. Not present for undeleted documents.
   *
   * @return the deleted
   */
  public Boolean isDeleted() {
    return deleted;
  }

  /**
   * Gets the rev.
   *
   * Schema for a document revision identifier.
   *
   * @return the rev
   */
  public String getRev() {
    return rev;
  }
}

