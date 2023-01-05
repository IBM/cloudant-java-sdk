/*
 * (C) Copyright IBM Corp. 2023.
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
 * The putLocalDocument options.
 */
public class PutLocalDocumentOptions extends GenericModel {

  /**
   * Query parameter to specify whether to store in batch mode. The server will respond with a HTTP 202 Accepted
   * response code immediately.
   */
  public interface Batch {
    /** ok. */
    String OK = "ok";
  }

  protected String db;
  protected String docId;
  protected Document document;
  protected InputStream body;
  protected String contentType;
  protected String batch;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private Document document;
    private InputStream body;
    private String contentType;
    private String batch;

    /**
     * Instantiates a new Builder from an existing PutLocalDocumentOptions instance.
     *
     * @param putLocalDocumentOptions the instance to initialize the Builder with
     */
    private Builder(PutLocalDocumentOptions putLocalDocumentOptions) {
      this.db = putLocalDocumentOptions.db;
      this.docId = putLocalDocumentOptions.docId;
      this.document = putLocalDocumentOptions.document;
      this.body = putLocalDocumentOptions.body;
      this.contentType = putLocalDocumentOptions.contentType;
      this.batch = putLocalDocumentOptions.batch;
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
     * @param docId the docId
     */
    public Builder(String db, String docId) {
      this.db = db;
      this.docId = docId;
    }

    /**
     * Builds a PutLocalDocumentOptions.
     *
     * @return the new PutLocalDocumentOptions instance
     */
    public PutLocalDocumentOptions build() {
      return new PutLocalDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PutLocalDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the PutLocalDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the PutLocalDocumentOptions builder
     */
    public Builder body(InputStream body) {
      this.body = body;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the PutLocalDocumentOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the PutLocalDocumentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }

    /**
     * Set the document.
     *
     * @param document the document
     * @return the PutLocalDocumentOptions builder
     */
    public Builder document(Document document) {
      this.document = document;
      this.contentType = "application/json";
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the PutLocalDocumentOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder body(File body) throws FileNotFoundException {
      this.body = new FileInputStream(body);
      return this;
    }
  }

  protected PutLocalDocumentOptions() { }

  protected PutLocalDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    db = builder.db;
    docId = builder.docId;
    document = builder.document;
    body = builder.body;
    contentType = builder.contentType;
    batch = builder.batch;
  }

  /**
   * New builder.
   *
   * @return a PutLocalDocumentOptions builder
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
   * Gets the docId.
   *
   * Path parameter to specify the document ID.
   *
   * @return the docId
   */
  public String docId() {
    return docId;
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

