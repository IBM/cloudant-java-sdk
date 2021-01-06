/*
 * (C) Copyright IBM Corp. 2021.
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
 * Schema for session authentication information.
 */
public class SessionAuthentication extends GenericModel {

  protected String authenticated;
  @SerializedName("authentication_db")
  protected String authenticationDb;
  @SerializedName("authentication_handlers")
  protected List<String> authenticationHandlers;

  /**
   * Gets the authenticated.
   *
   * authenticated.
   *
   * @return the authenticated
   */
  public String getAuthenticated() {
    return authenticated;
  }

  /**
   * Gets the authenticationDb.
   *
   * authentication_db.
   *
   * @return the authenticationDb
   */
  public String getAuthenticationDb() {
    return authenticationDb;
  }

  /**
   * Gets the authenticationHandlers.
   *
   * authentication_handlers.
   *
   * @return the authenticationHandlers
   */
  public List<String> getAuthenticationHandlers() {
    return authenticationHandlers;
  }
}

