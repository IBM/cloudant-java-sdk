/*
 * (C) Copyright IBM Corp. 2021.
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
 * Schema for the text index default field configuration. The default field is used to index the text of all fields
 * within a document for use with the `$text` operator.
 */
public class IndexTextOperatorDefaultField extends GenericModel {

  protected Analyzer analyzer;
  protected Boolean enabled;

  /**
   * Builder.
   */
  public static class Builder {
    private Analyzer analyzer;
    private Boolean enabled;

    private Builder(IndexTextOperatorDefaultField indexTextOperatorDefaultField) {
      this.analyzer = indexTextOperatorDefaultField.analyzer;
      this.enabled = indexTextOperatorDefaultField.enabled;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a IndexTextOperatorDefaultField.
     *
     * @return the new IndexTextOperatorDefaultField instance
     */
    public IndexTextOperatorDefaultField build() {
      return new IndexTextOperatorDefaultField(this);
    }

    /**
     * Set the analyzer.
     *
     * @param analyzer the analyzer
     * @return the IndexTextOperatorDefaultField builder
     */
    public Builder analyzer(Analyzer analyzer) {
      this.analyzer = analyzer;
      return this;
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the IndexTextOperatorDefaultField builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }
  }

  protected IndexTextOperatorDefaultField(Builder builder) {
    analyzer = builder.analyzer;
    enabled = builder.enabled;
  }

  /**
   * New builder.
   *
   * @return a IndexTextOperatorDefaultField builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the analyzer.
   *
   * Schema for a full text search analyzer.
   *
   * @return the analyzer
   */
  public Analyzer analyzer() {
    return analyzer;
  }

  /**
   * Gets the enabled.
   *
   * Whether or not the default_field is enabled.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }
}

