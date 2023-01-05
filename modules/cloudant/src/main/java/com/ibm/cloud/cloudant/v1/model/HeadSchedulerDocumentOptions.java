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
 * The headSchedulerDocument options.
 */
public class HeadSchedulerDocumentOptions extends GenericModel {

  protected String docId;

  /**
   * Builder.
   */
  public static class Builder {
    private String docId;

    /**
     * Instantiates a new Builder from an existing HeadSchedulerDocumentOptions instance.
     *
     * @param headSchedulerDocumentOptions the instance to initialize the Builder with
     */
    private Builder(HeadSchedulerDocumentOptions headSchedulerDocumentOptions) {
      this.docId = headSchedulerDocumentOptions.docId;
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
     * Builds a HeadSchedulerDocumentOptions.
     *
     * @return the new HeadSchedulerDocumentOptions instance
     */
    public HeadSchedulerDocumentOptions build() {
      return new HeadSchedulerDocumentOptions(this);
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the HeadSchedulerDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }
  }

  protected HeadSchedulerDocumentOptions() { }

  protected HeadSchedulerDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    docId = builder.docId;
  }

  /**
   * New builder.
   *
   * @return a HeadSchedulerDocumentOptions builder
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
}

