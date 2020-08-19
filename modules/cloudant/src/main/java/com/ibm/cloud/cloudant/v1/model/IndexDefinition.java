/*
 * (C) Copyright IBM Corp. 2020.
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
 * Schema for a `json` or `text` query index definition. Indexes of type `text` have additional configuration properties
 * that do not apply to `json` indexes, these are:
 * * `default_analyzer` - the default text analyzer to use * `default_field` - whether to index the text in all document
 * fields and what analyzer to use for that purpose.
 */
public class IndexDefinition extends GenericModel {

  @SerializedName("default_analyzer")
  protected Analyzer defaultAnalyzer;
  @SerializedName("default_field")
  protected IndexTextOperatorDefaultField defaultField;
  protected List<IndexField> fields;
  @SerializedName("index_array_lengths")
  protected Boolean indexArrayLengths;

  /**
   * Builder.
   */
  public static class Builder {
    private Analyzer defaultAnalyzer;
    private IndexTextOperatorDefaultField defaultField;
    private List<IndexField> fields;
    private Boolean indexArrayLengths;

    private Builder(IndexDefinition indexDefinition) {
      this.defaultAnalyzer = indexDefinition.defaultAnalyzer;
      this.defaultField = indexDefinition.defaultField;
      this.fields = indexDefinition.fields;
      this.indexArrayLengths = indexDefinition.indexArrayLengths;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a IndexDefinition.
     *
     * @return the new IndexDefinition instance
     */
    public IndexDefinition build() {
      return new IndexDefinition(this);
    }

    /**
     * Adds an fields to fields.
     *
     * @param fields the new fields
     * @return the IndexDefinition builder
     */
    public Builder addFields(IndexField fields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(fields,
        "fields cannot be null");
      if (this.fields == null) {
        this.fields = new ArrayList<IndexField>();
      }
      this.fields.add(fields);
      return this;
    }

    /**
     * Set the defaultAnalyzer.
     *
     * @param defaultAnalyzer the defaultAnalyzer
     * @return the IndexDefinition builder
     */
    public Builder defaultAnalyzer(Analyzer defaultAnalyzer) {
      this.defaultAnalyzer = defaultAnalyzer;
      return this;
    }

    /**
     * Set the defaultField.
     *
     * @param defaultField the defaultField
     * @return the IndexDefinition builder
     */
    public Builder defaultField(IndexTextOperatorDefaultField defaultField) {
      this.defaultField = defaultField;
      return this;
    }

    /**
     * Set the fields.
     * Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the IndexDefinition builder
     */
    public Builder fields(List<IndexField> fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the indexArrayLengths.
     *
     * @param indexArrayLengths the indexArrayLengths
     * @return the IndexDefinition builder
     */
    public Builder indexArrayLengths(Boolean indexArrayLengths) {
      this.indexArrayLengths = indexArrayLengths;
      return this;
    }
  }

  protected IndexDefinition(Builder builder) {
    defaultAnalyzer = builder.defaultAnalyzer;
    defaultField = builder.defaultField;
    fields = builder.fields;
    indexArrayLengths = builder.indexArrayLengths;
  }

  /**
   * New builder.
   *
   * @return a IndexDefinition builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the defaultAnalyzer.
   *
   * Schema for a full text search analyzer.
   *
   * @return the defaultAnalyzer
   */
  public Analyzer defaultAnalyzer() {
    return defaultAnalyzer;
  }

  /**
   * Gets the defaultField.
   *
   * Schema for the text index default field configuration. The default field is used to index the text of all fields
   * within a document for use with the `$text` operator.
   *
   * @return the defaultField
   */
  public IndexTextOperatorDefaultField defaultField() {
    return defaultField;
  }

  /**
   * Gets the fields.
   *
   * List of fields to index.
   *
   * @return the fields
   */
  public List<IndexField> fields() {
    return fields;
  }

  /**
   * Gets the indexArrayLengths.
   *
   * Whether to scan every document for arrays and store the length for each array found. Set the index_array_lengths
   * field to false if:
   * * You do not need to know the length of an array. * You do not use the `$size` operator. * The documents in your
   * database are complex, or not completely under your control. As a result, it is difficult to estimate the impact of
   * the extra processing that is needed to determine and store the arrays lengths.
   *
   * @return the indexArrayLengths
   */
  public Boolean indexArrayLengths() {
    return indexArrayLengths;
  }
}

