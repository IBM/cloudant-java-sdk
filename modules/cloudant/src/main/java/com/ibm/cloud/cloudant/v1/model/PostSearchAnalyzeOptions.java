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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postSearchAnalyze options.
 */
public class PostSearchAnalyzeOptions extends GenericModel {

  /**
   * analyzer.
   */
  public interface Analyzer {
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
    /** classic. */
    String CLASSIC = "classic";
    /** czech. */
    String CZECH = "czech";
    /** danish. */
    String DANISH = "danish";
    /** dutch. */
    String DUTCH = "dutch";
    /** email. */
    String EMAIL = "email";
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
    /** keyword. */
    String KEYWORD = "keyword";
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
    /** simple. */
    String SIMPLE = "simple";
    /** spanish. */
    String SPANISH = "spanish";
    /** standard. */
    String STANDARD = "standard";
    /** swedish. */
    String SWEDISH = "swedish";
    /** thai. */
    String THAI = "thai";
    /** turkish. */
    String TURKISH = "turkish";
    /** whitespace. */
    String WHITESPACE = "whitespace";
  }

  protected String analyzer;
  protected String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String analyzer;
    private String text;

    private Builder(PostSearchAnalyzeOptions postSearchAnalyzeOptions) {
      this.analyzer = postSearchAnalyzeOptions.analyzer;
      this.text = postSearchAnalyzeOptions.text;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PostSearchAnalyzeOptions.
     *
     * @return the new PostSearchAnalyzeOptions instance
     */
    public PostSearchAnalyzeOptions build() {
      return new PostSearchAnalyzeOptions(this);
    }

    /**
     * Set the analyzer.
     *
     * @param analyzer the analyzer
     * @return the PostSearchAnalyzeOptions builder
     */
    public Builder analyzer(String analyzer) {
      this.analyzer = analyzer;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the PostSearchAnalyzeOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected PostSearchAnalyzeOptions(Builder builder) {
    analyzer = builder.analyzer;
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a PostSearchAnalyzeOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the analyzer.
   *
   * analyzer.
   *
   * @return the analyzer
   */
  public String analyzer() {
    return analyzer;
  }

  /**
   * Gets the text.
   *
   * text.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}

