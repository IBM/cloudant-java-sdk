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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for a search index definition.
 */
public class SearchIndexDefinition extends GenericModel {

  protected AnalyzerConfiguration analyzer;
  protected String index;

  /**
   * Builder.
   */
  public static class Builder {
    private AnalyzerConfiguration analyzer;
    private String index;

    /**
     * Instantiates a new Builder from an existing SearchIndexDefinition instance.
     *
     * @param searchIndexDefinition the instance to initialize the Builder with
     */
    private Builder(SearchIndexDefinition searchIndexDefinition) {
      this.analyzer = searchIndexDefinition.analyzer;
      this.index = searchIndexDefinition.index;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param index the index
     */
    public Builder(String index) {
      this.index = index;
    }

    /**
     * Builds a SearchIndexDefinition.
     *
     * @return the new SearchIndexDefinition instance
     */
    public SearchIndexDefinition build() {
      return new SearchIndexDefinition(this);
    }

    /**
     * Set the analyzer.
     *
     * @param analyzer the analyzer
     * @return the SearchIndexDefinition builder
     */
    public Builder analyzer(AnalyzerConfiguration analyzer) {
      this.analyzer = analyzer;
      return this;
    }

    /**
     * Set the index.
     *
     * @param index the index
     * @return the SearchIndexDefinition builder
     */
    public Builder index(String index) {
      this.index = index;
      return this;
    }
  }

  protected SearchIndexDefinition() { }

  protected SearchIndexDefinition(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.index,
      "index cannot be null");
    analyzer = builder.analyzer;
    index = builder.index;
  }

  /**
   * New builder.
   *
   * @return a SearchIndexDefinition builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the analyzer.
   *
   * Schema for a search analyzer configuration.
   *
   * @return the analyzer
   */
  public AnalyzerConfiguration analyzer() {
    return analyzer;
  }

  /**
   * Gets the index.
   *
   * String form of a JavaScript function that is called for each document in the database. The function takes the
   * document as a parameter, extracts some data from it, and then calls the `index` function to index that data. The
   * index function takes 2, or optionally 3, parameters.
   *
   * * The first parameter is the name of the field you intend to use when
   *   querying the index. If the special value `"default"` is used when you
   *   define the name, you do not have to specify a field name at query time.
   * * The second parameter is the data to be indexed. This data must be only a
   *   string, number, or boolean. Other types will cause an error to be thrown
   *   by the index function call.
   * * The optional third parameter is a JavaScript object with these
   *   properties:
   *
   *     * `facet` - boolean, default `false` - Creates a faceted index.
   *     * `index` - boolean, default `true` - If set to `false`, the data
   *       cannot be used for searches, but can still be retrieved from the
   *       index if `store` is set to `true`.
   *     * `store` - boolean, default `true` - If true, the value is returned
   *       in the search result; otherwise, the value is not returned.
   *
   * @return the index
   */
  public String index() {
    return index;
  }
}

