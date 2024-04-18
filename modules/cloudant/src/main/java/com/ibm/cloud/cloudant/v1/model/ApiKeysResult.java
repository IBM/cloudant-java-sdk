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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for api keys.
 */
public class ApiKeysResult extends GenericModel {

  protected Boolean ok;
  protected String key;
  protected String password;

  protected ApiKeysResult() { }

  /**
   * Gets the ok.
   *
   * ok.
   *
   * @return the ok
   */
  public Boolean isOk() {
    return ok;
  }

  /**
   * Gets the key.
   *
   * The generated api key.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the password.
   *
   * The password associated with the api key.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }
}

