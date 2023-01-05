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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The headReplicationDocument options.
 */
public class HeadReplicationDocumentOptions extends GenericModel {

  protected String docId;
  protected String ifNoneMatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String docId;
    private String ifNoneMatch;

    /**
     * Instantiates a new Builder from an existing HeadReplicationDocumentOptions instance.
     *
     * @param headReplicationDocumentOptions the instance to initialize the Builder with
     */
    private Builder(HeadReplicationDocumentOptions headReplicationDocumentOptions) {
      this.docId = headReplicationDocumentOptions.docId;
      this.ifNoneMatch = headReplicationDocumentOptions.ifNoneMatch;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param docId the docId
     */
    public Builder(String docId) {
      this.docId = docId;
    }

    /**
     * Builds a HeadReplicationDocumentOptions.
     *
     * @return the new HeadReplicationDocumentOptions instance
     */
    public HeadReplicationDocumentOptions build() {
      return new HeadReplicationDocumentOptions(this);
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the HeadReplicationDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the ifNoneMatch.
     *
     * @param ifNoneMatch the ifNoneMatch
     * @return the HeadReplicationDocumentOptions builder
     */
    public Builder ifNoneMatch(String ifNoneMatch) {
      this.ifNoneMatch = ifNoneMatch;
      return this;
    }
  }

  protected HeadReplicationDocumentOptions() { }

  protected HeadReplicationDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    docId = builder.docId;
    ifNoneMatch = builder.ifNoneMatch;
  }

  /**
   * New builder.
   *
   * @return a HeadReplicationDocumentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the ifNoneMatch.
   *
   * Header parameter to specify a double quoted document revision token for cache control.
   *
   * @return the ifNoneMatch
   */
  public String ifNoneMatch() {
    return ifNoneMatch;
  }
}

