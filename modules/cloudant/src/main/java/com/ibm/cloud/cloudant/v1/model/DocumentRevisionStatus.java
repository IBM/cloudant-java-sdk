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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for information about revisions and their status.
 */
public class DocumentRevisionStatus extends GenericModel {

  /**
   * Status of the revision. May be one of: - `available`: Revision is available for retrieving with rev query parameter
   * - `missing`: Revision is not available - `deleted`: Revision belongs to deleted document.
   */
  public interface Status {
    /** available. */
    String AVAILABLE = "available";
    /** missing. */
    String MISSING = "missing";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String rev;
  protected String status;

  /**
   * Builder.
   */
  public static class Builder {
    private String rev;
    private String status;

    /**
     * Instantiates a new Builder from an existing DocumentRevisionStatus instance.
     *
     * @param documentRevisionStatus the instance to initialize the Builder with
     */
    private Builder(DocumentRevisionStatus documentRevisionStatus) {
      this.rev = documentRevisionStatus.rev;
      this.status = documentRevisionStatus.status;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param rev the rev
     * @param status the status
     */
    public Builder(String rev, String status) {
      this.rev = rev;
      this.status = status;
    }

    /**
     * Builds a DocumentRevisionStatus.
     *
     * @return the new DocumentRevisionStatus instance
     */
    public DocumentRevisionStatus build() {
      return new DocumentRevisionStatus(this);
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the DocumentRevisionStatus builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the DocumentRevisionStatus builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }
  }

  protected DocumentRevisionStatus() { }

  protected DocumentRevisionStatus(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.rev,
      "rev cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.status,
      "status cannot be null");
    rev = builder.rev;
    status = builder.status;
  }

  /**
   * New builder.
   *
   * @return a DocumentRevisionStatus builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the rev.
   *
   * Schema for a document revision identifier.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
  }

  /**
   * Gets the status.
   *
   * Status of the revision. May be one of: - `available`: Revision is available for retrieving with rev query parameter
   * - `missing`: Revision is not available - `deleted`: Revision belongs to deleted document.
   *
   * @return the status
   */
  public String status() {
    return status;
  }
}

