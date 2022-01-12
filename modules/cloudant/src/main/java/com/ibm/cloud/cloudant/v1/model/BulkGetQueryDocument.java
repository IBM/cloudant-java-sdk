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
 * Schema for a document item in a bulk get query.
 */
public class BulkGetQueryDocument extends GenericModel {

  @SerializedName("atts_since")
  protected List<String> attsSince;
  protected String id;
  protected String rev;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> attsSince;
    private String id;
    private String rev;

    private Builder(BulkGetQueryDocument bulkGetQueryDocument) {
      this.attsSince = bulkGetQueryDocument.attsSince;
      this.id = bulkGetQueryDocument.id;
      this.rev = bulkGetQueryDocument.rev;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a BulkGetQueryDocument.
     *
     * @return the new BulkGetQueryDocument instance
     */
    public BulkGetQueryDocument build() {
      return new BulkGetQueryDocument(this);
    }

    /**
     * Adds an attsSince to attsSince.
     *
     * @param attsSince the new attsSince
     * @return the BulkGetQueryDocument builder
     */
    public Builder addAttsSince(String attsSince) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attsSince,
        "attsSince cannot be null");
      if (this.attsSince == null) {
        this.attsSince = new ArrayList<String>();
      }
      this.attsSince.add(attsSince);
      return this;
    }

    /**
     * Set the attsSince.
     * Existing attsSince will be replaced.
     *
     * @param attsSince the attsSince
     * @return the BulkGetQueryDocument builder
     */
    public Builder attsSince(List<String> attsSince) {
      this.attsSince = attsSince;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the BulkGetQueryDocument builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the BulkGetQueryDocument builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }
  }

  protected BulkGetQueryDocument(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    attsSince = builder.attsSince;
    id = builder.id;
    rev = builder.rev;
  }

  /**
   * New builder.
   *
   * @return a BulkGetQueryDocument builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attsSince.
   *
   * Includes attachments only since specified revisions.
   *
   * @return the attsSince
   */
  public List<String> attsSince() {
    return attsSince;
  }

  /**
   * Gets the id.
   *
   * Schema for a document ID.
   *
   * @return the id
   */
  public String id() {
    return id;
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
}

