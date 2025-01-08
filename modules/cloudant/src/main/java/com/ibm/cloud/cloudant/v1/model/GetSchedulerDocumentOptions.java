/*
 * (C) Copyright IBM Corp. 2025.
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
 * The getSchedulerDocument options.
 */
public class GetSchedulerDocumentOptions extends GenericModel {

  protected String docId;

  /**
   * Builder.
   */
  public static class Builder {
    private String docId;

    /**
     * Instantiates a new Builder from an existing GetSchedulerDocumentOptions instance.
     *
     * @param getSchedulerDocumentOptions the instance to initialize the Builder with
     */
    private Builder(GetSchedulerDocumentOptions getSchedulerDocumentOptions) {
      this.docId = getSchedulerDocumentOptions.docId;
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
     * Builds a GetSchedulerDocumentOptions.
     *
     * @return the new GetSchedulerDocumentOptions instance
     */
    public GetSchedulerDocumentOptions build() {
      return new GetSchedulerDocumentOptions(this);
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the GetSchedulerDocumentOptions builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }
  }

  protected GetSchedulerDocumentOptions() { }

  protected GetSchedulerDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.docId,
      "docId cannot be empty");
    docId = builder.docId;
  }

  /**
   * New builder.
   *
   * @return a GetSchedulerDocumentOptions builder
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

