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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Analyzer configuration for search indexes. The default and fields properties are only applicable for the `perfield`
 * analyzer name.
 */
public class AnalyzerConfiguration extends GenericModel {

  /**
   * Schema for the name of the Apache Lucene analyzer to use for text indexing. The default value varies depending on
   * the analyzer usage:
   * * For search indexes the default is `standard`
   * * For query text indexes the default is `keyword`
   * * For a query text index default_field the default is `standard`.
   */
  public interface Name {
    /** classic. */
    String CLASSIC = "classic";
    /** email. */
    String EMAIL = "email";
    /** keyword. */
    String KEYWORD = "keyword";
    /** perfield. */
    String PERFIELD = "perfield";
    /** simple. */
    String SIMPLE = "simple";
    /** simple_asciifolding. */
    String SIMPLE_ASCIIFOLDING = "simple_asciifolding";
    /** standard. */
    String STANDARD = "standard";
    /** whitespace. */
    String WHITESPACE = "whitespace";
    /** arabic. */
    String ARABIC = "arabic";
    /** armenian. */
    String ARMENIAN = "armenian";
    /** basque. */
    String BASQUE = "basque";
    /** brazilian. */
    String BRAZILIAN = "brazilian";
    /** bulgarian. */
    String BULGARIAN = "bulgarian";
    /** catalan. */
    String CATALAN = "catalan";
    /** chinese. */
    String CHINESE = "chinese";
    /** cjk. */
    String CJK = "cjk";
    /** czech. */
    String CZECH = "czech";
    /** danish. */
    String DANISH = "danish";
    /** dutch. */
    String DUTCH = "dutch";
    /** english. */
    String ENGLISH = "english";
    /** finnish. */
    String FINNISH = "finnish";
    /** french. */
    String FRENCH = "french";
    /** galician. */
    String GALICIAN = "galician";
    /** german. */
    String GERMAN = "german";
    /** greek. */
    String GREEK = "greek";
    /** hindi. */
    String HINDI = "hindi";
    /** hungarian. */
    String HUNGARIAN = "hungarian";
    /** indonesian. */
    String INDONESIAN = "indonesian";
    /** irish. */
    String IRISH = "irish";
    /** italian. */
    String ITALIAN = "italian";
    /** japanese. */
    String JAPANESE = "japanese";
    /** latvian. */
    String LATVIAN = "latvian";
    /** norwegian. */
    String NORWEGIAN = "norwegian";
    /** persian. */
    String PERSIAN = "persian";
    /** polish. */
    String POLISH = "polish";
    /** portuguese. */
    String PORTUGUESE = "portuguese";
    /** romanian. */
    String ROMANIAN = "romanian";
    /** russian. */
    String RUSSIAN = "russian";
    /** spanish. */
    String SPANISH = "spanish";
    /** swedish. */
    String SWEDISH = "swedish";
    /** thai. */
    String THAI = "thai";
    /** turkish. */
    String TURKISH = "turkish";
  }

  protected String name;
  protected List<String> stopwords;
  @SerializedName("default")
  protected Analyzer xDefault;
  protected Map<String, Analyzer> fields;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private List<String> stopwords;
    private Analyzer xDefault;
    private Map<String, Analyzer> fields;

    /**
     * Instantiates a new Builder from an existing AnalyzerConfiguration instance.
     *
     * @param analyzerConfiguration the instance to initialize the Builder with
     */
    private Builder(AnalyzerConfiguration analyzerConfiguration) {
      this.name = analyzerConfiguration.name;
      this.stopwords = analyzerConfiguration.stopwords;
      this.xDefault = analyzerConfiguration.xDefault;
      this.fields = analyzerConfiguration.fields;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a AnalyzerConfiguration.
     *
     * @return the new AnalyzerConfiguration instance
     */
    public AnalyzerConfiguration build() {
      return new AnalyzerConfiguration(this);
    }

    /**
     * Adds a new element to stopwords.
     *
     * @param stopwords the new element to be added
     * @return the AnalyzerConfiguration builder
     */
    public Builder addStopwords(String stopwords) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(stopwords,
        "stopwords cannot be null");
      if (this.stopwords == null) {
        this.stopwords = new ArrayList<String>();
      }
      this.stopwords.add(stopwords);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AnalyzerConfiguration builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the stopwords.
     * Existing stopwords will be replaced.
     *
     * @param stopwords the stopwords
     * @return the AnalyzerConfiguration builder
     */
    public Builder stopwords(List<String> stopwords) {
      this.stopwords = stopwords;
      return this;
    }

    /**
     * Set the xDefault.
     *
     * @param xDefault the xDefault
     * @return the AnalyzerConfiguration builder
     */
    public Builder xDefault(Analyzer xDefault) {
      this.xDefault = xDefault;
      return this;
    }

    /**
     * Set the fields.
     *
     * @param fields the fields
     * @return the AnalyzerConfiguration builder
     */
    public Builder fields(Map<String, Analyzer> fields) {
      this.fields = fields;
      return this;
    }
  }

  protected AnalyzerConfiguration() { }

  protected AnalyzerConfiguration(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    name = builder.name;
    stopwords = builder.stopwords;
    xDefault = builder.xDefault;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a AnalyzerConfiguration builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Schema for the name of the Apache Lucene analyzer to use for text indexing. The default value varies depending on
   * the analyzer usage:
   * * For search indexes the default is `standard`
   * * For query text indexes the default is `keyword`
   * * For a query text index default_field the default is `standard`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the stopwords.
   *
   * Custom stopwords to use with the named analyzer.
   *
   * @return the stopwords
   */
  public List<String> stopwords() {
    return stopwords;
  }

  /**
   * Gets the xDefault.
   *
   * Schema for a full text search analyzer.
   *
   * @return the xDefault
   */
  public Analyzer xDefault() {
    return xDefault;
  }

  /**
   * Gets the fields.
   *
   * Schema for mapping a field name to a per field analyzer.
   *
   * @return the fields
   */
  public Map<String, Analyzer> fields() {
    return fields;
  }
}

