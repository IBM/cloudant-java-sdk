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
 * The putDocument options.
 */
public class PutDocumentOptions extends GenericModel {

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
  protected String ifMatch;
  protected String batch;
  protected Boolean newEdits;
  protected String rev;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String docId;
    private Document document;
    private InputStream body;
    private String contentType;
    private String ifMatch;
    private String batch;
    private Boolean newEdits;
    private String rev;

    /**
     * Instantiates a new Builder from an existing PutDocumentOptions instance.
     *
     * @param putDocumentOptions the instance to initialize the Builder with
     */
    private Builder(PutDocumentOptions putDocumentOptions) {
      this.db = putDocumentOptions.db;
      this.docId = putDocumentOptions.docId;
      this.document = putDocumentOptions.document;
      this.body = putDocumentOptions.body;
      this.contentType = putDocumentOptions.contentType;
      this.ifMatch = putDocumentOptions.ifMatch;
      this.batch = putDocumentOptions.batch;
      this.newEdits = putDocumentOptions.newEdits;
      this.rev = putDocumentOptions.rev;
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
     * Builds a PutDocumentOptions.
     *
     * @return the new PutDocumentOptions instance
     */
    public PutDocumentOptions build() {
      return new PutDocumentOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PutDocumentOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the PutDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the document.
     *
     * @param document the document
     * @return the PutDocumentOptions builder
     */
    public Builder document(Document document) {
      this.document = document;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the PutDocumentOptions builder
     */
    public Builder body(InputStream body) {
      this.body = body;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the PutDocumentOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the PutDocumentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the batch.
     *
     * @param batch the batch
     * @return the PutDocumentOptions builder
     */
    public Builder batch(String batch) {
      this.batch = batch;
      return this;
    }

    /**
     * Set the newEdits.
     *
     * @param newEdits the newEdits
     * @return the PutDocumentOptions builder
     */
    public Builder newEdits(Boolean newEdits) {
      this.newEdits = newEdits;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the PutDocumentOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the PutDocumentOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder body(File body) throws FileNotFoundException {
      this.body = new FileInputStream(body);
      return this;
    }
  }

  protected PutDocumentOptions() { }

  protected PutDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    db = builder.db;
    docId = builder.docId;
    document = builder.document;
    body = builder.body;
    contentType = builder.contentType;
    ifMatch = builder.ifMatch;
    batch = builder.batch;
    newEdits = builder.newEdits;
    rev = builder.rev;
  }

  /**
   * New builder.
   *
   * @return a PutDocumentOptions builder
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
   * Gets the ifMatch.
   *
   * Header parameter to specify the document revision. Alternative to rev query parameter.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
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

  /**
   * Gets the newEdits.
   *
   * Query parameter to specify whether to prevent insertion of conflicting document revisions. If false, a well-formed
   * _rev must be included in the document. False is used by the replicator to insert documents into the target database
   * even if that leads to the creation of conflicts.
   *
   * @return the newEdits
   */
  public Boolean newEdits() {
    return newEdits;
  }

  /**
   * Gets the rev.
   *
   * Query parameter to specify a document revision.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
  }
}

