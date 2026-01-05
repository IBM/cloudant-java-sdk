/*
 * (C) Copyright IBM Corp. 2026.
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postBulkDocs options.
 */
public class PostBulkDocsOptions extends GenericModel {

  protected String db;
  protected BulkDocs bulkDocs;
  protected InputStream body;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private BulkDocs bulkDocs;
    private InputStream body;

    /**
     * Instantiates a new Builder from an existing PostBulkDocsOptions instance.
     *
     * @param postBulkDocsOptions the instance to initialize the Builder with
     */
    private Builder(PostBulkDocsOptions postBulkDocsOptions) {
      this.db = postBulkDocsOptions.db;
      this.bulkDocs = postBulkDocsOptions.bulkDocs;
      this.body = postBulkDocsOptions.body;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param db the db
     */
    public Builder(String db) {
      this.db = db;
    }

    /**
     * Builds a PostBulkDocsOptions.
     *
     * @return the new PostBulkDocsOptions instance
     */
    public PostBulkDocsOptions build() {
      return new PostBulkDocsOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostBulkDocsOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the bulkDocs.
     *
     * @param bulkDocs the bulkDocs
     * @return the PostBulkDocsOptions builder
     */
    public Builder bulkDocs(BulkDocs bulkDocs) {
      this.bulkDocs = bulkDocs;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the PostBulkDocsOptions builder
     */
    public Builder body(InputStream body) {
      this.body = body;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the PostBulkDocsOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder body(File body) throws FileNotFoundException {
      this.body = new FileInputStream(body);
      return this;
    }
  }

  protected PostBulkDocsOptions() { }

  protected PostBulkDocsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    bulkDocs = builder.bulkDocs;
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a PostBulkDocsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the db.
   *
   * Path parameter to specify the database name.
   *
   * @return the db
   */
  public String db() {
    return db;
  }

  /**
   * Gets the bulkDocs.
   *
   * HTTP request body for postBulkDocs.
   *
   * @return the bulkDocs
   */
  public BulkDocs bulkDocs() {
    return bulkDocs;
  }

  /**
   * Gets the body.
   *
   * HTTP request body for postBulkDocs.
   *
   * @return the body
   */
  public InputStream body() {
    return body;
  }
}

