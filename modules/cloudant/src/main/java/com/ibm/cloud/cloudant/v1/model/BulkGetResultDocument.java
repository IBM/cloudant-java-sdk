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
 * Schema for BulkGetResult object containing a successfully retrieved document or error information.
 */
public class BulkGetResultDocument extends GenericModel {

  protected DocumentResult error;
  protected Document ok;

  /**
   * Gets the error.
   *
   * Schema for the result of a document modification.
   *
   * @return the error
   */
  public DocumentResult getError() {
    return error;
  }

  /**
   * Gets the ok.
   *
   * Schema for a document.
   *
   * @return the ok
   */
  public Document getOk() {
    return ok;
  }
}

