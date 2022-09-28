/*
 * (C) Copyright IBM Corp. 2022.
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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for submitting documents for bulk modifications.
 */
public class BulkDocs extends GenericModel {

  protected List<Document> docs;
  @SerializedName("new_edits")
  protected Boolean newEdits;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Document> docs;
    private Boolean newEdits;

    /**
     * Instantiates a new Builder from an existing BulkDocs instance.
     *
     * @param bulkDocs the instance to initialize the Builder with
     */
    private Builder(BulkDocs bulkDocs) {
      this.docs = bulkDocs.docs;
      this.newEdits = bulkDocs.newEdits;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param docs the docs
     */
    public Builder(List<Document> docs) {
      this.docs = docs;
    }

    /**
     * Builds a BulkDocs.
     *
     * @return the new BulkDocs instance
     */
    public BulkDocs build() {
      return new BulkDocs(this);
    }

    /**
     * Adds an docs to docs.
     *
     * @param docs the new docs
     * @return the BulkDocs builder
     */
    public Builder addDocs(Document docs) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(docs,
        "docs cannot be null");
      if (this.docs == null) {
        this.docs = new ArrayList<Document>();
      }
      this.docs.add(docs);
      return this;
    }

    /**
     * Set the docs.
     * Existing docs will be replaced.
     *
     * @param docs the docs
     * @return the BulkDocs builder
     */
    public Builder docs(List<Document> docs) {
      this.docs = docs;
      return this;
    }

    /**
     * Set the newEdits.
     *
     * @param newEdits the newEdits
     * @return the BulkDocs builder
     */
    public Builder newEdits(Boolean newEdits) {
      this.newEdits = newEdits;
      return this;
    }
  }

  protected BulkDocs() { }

  protected BulkDocs(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.docs,
      "docs cannot be null");
    docs = builder.docs;
    newEdits = builder.newEdits;
  }

  /**
   * New builder.
   *
   * @return a BulkDocs builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the docs.
   *
   * Array of documents.
   *
   * @return the docs
   */
  public List<Document> docs() {
    return docs;
  }

  /**
   * Gets the newEdits.
   *
   * If `false`, prevents the database from assigning them new revision IDs. Default is `true`.
   *
   * @return the newEdits
   */
  public Boolean newEdits() {
    return newEdits;
  }
}

