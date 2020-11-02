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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a database change event.
 */
public class DbEvent extends GenericModel {

  /**
   * A database event.
   */
  public interface Type {
    /** created. */
    String CREATED = "created";
    /** deleted. */
    String DELETED = "deleted";
    /** updated. */
    String UPDATED = "updated";
  }

  protected String account;
  @SerializedName("db_name")
  protected String dbName;
  protected String seq;
  protected String type;

  /**
   * Gets the account.
   *
   * Account name.
   *
   * @return the account
   */
  public String getAccount() {
    return account;
  }

  /**
   * Gets the dbName.
   *
   * Database name.
   *
   * @return the dbName
   */
  public String getDbName() {
    return dbName;
  }

  /**
   * Gets the seq.
   *
   * Sequence number.
   *
   * @return the seq
   */
  public String getSeq() {
    return seq;
  }

  /**
   * Gets the type.
   *
   * A database event.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}

