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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postDocument options.
 */
public class PostDocumentOptions extends GenericModel {

  /**
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   */
  public interface Batch {
    /** ok. */
    String OK = "ok";
  }

  protected String db;
  protected Document document;
  protected InputStream body;
  protected String contentType;
  protected String batch;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private Document document;
    private InputStream body;
    private String contentType;
    private String batch;

    /**
     * Instantiates a new Builder from an existing PostDocumentOptions instance.
     *
     * @param postDocumentOptions the instance to initialize the Builder with
     */
    private Builder(PostDocumentOptions postDocumentOptions) {
      this.db = postDocumentOptions.db;
      this.document = postDocumentOptions.document;
      this.body = postDocumentOptions.body;
      this.contentType = postDocumentOptions.contentType;
      this.batch = postDocumentOptions.batch;
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
     * Builds a PostDocumentOptions.
     *
     * @return the new PostDocumentOptions instance
     */
    public PostDocumentOptions build() {
      return new PostDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the document.
     *
     * @param document the document
     * @return the PostDocumentOptions builder
     */
    public Builder document(Document document) {
      this.document = document;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the PostDocumentOptions builder
     */
    public Builder body(InputStream body) {
      this.body = body;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the PostDocumentOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the PostDocumentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the PostDocumentOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder body(File body) throws FileNotFoundException {
      this.body = new FileInputStream(body);
      return this;
    }
  }

  protected PostDocumentOptions() { }

  protected PostDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    db = builder.db;
    document = builder.document;
    body = builder.body;
    contentType = builder.contentType;
    batch = builder.batch;
  }

  /**
   * New builder.
   *
   * @return a PostDocumentOptions builder
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
   * Gets the document.
   *
   * HTTP request body for Document operations.
   *
   * @return the document
   */
  public Document document() {
    return document;
  }

  /**
   * Gets the body.
   *
   * HTTP request body for Document operations.
   *
   * @return the body
   */
  public InputStream body() {
    return body;
  }

  /**
   * Gets the contentType.
   *
   * The type of the input.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the batch.
   *
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   *
   * @return the batch
   */
  public String batch() {
    return batch;
  }
}

