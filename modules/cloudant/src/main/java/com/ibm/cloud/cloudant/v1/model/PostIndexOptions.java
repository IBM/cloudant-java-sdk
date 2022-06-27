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
 * The postIndex options.
 */
public class PostIndexOptions extends GenericModel {

  /**
   * Schema for the type of an index.
   */
  public interface Type {
    /** json. */
    String JSON = "json";
    /** special. */
    String SPECIAL = "special";
    /** text. */
    String TEXT = "text";
  }

  protected String db;
  protected IndexDefinition index;
  protected String ddoc;
  protected IndexDefinition def;
  protected String name;
  protected Boolean partitioned;
  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private IndexDefinition index;
    private String ddoc;
    private IndexDefinition def;
    private String name;
    private Boolean partitioned;
    private String type;

    private Builder(PostIndexOptions postIndexOptions) {
      this.db = postIndexOptions.db;
      this.index = postIndexOptions.index;
      this.ddoc = postIndexOptions.ddoc;
      this.def = postIndexOptions.def;
      this.name = postIndexOptions.name;
      this.partitioned = postIndexOptions.partitioned;
      this.type = postIndexOptions.type;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param db the db
     * @param index the index
     */
    public Builder(String db, IndexDefinition index) {
      this.db = db;
      this.index = index;
    }

    /**
     * Builds a PostIndexOptions.
     *
     * @return the new PostIndexOptions instance
     */
    public PostIndexOptions build() {
      return new PostIndexOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostIndexOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the index.
     *
     * @param index the index
     * @return the PostIndexOptions builder
     */
    public Builder index(IndexDefinition index) {
      this.index = index;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the PostIndexOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the def.
     *
     * @param def the def
     * @return the PostIndexOptions builder
     */
    public Builder def(IndexDefinition def) {
      this.def = def;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the PostIndexOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the partitioned.
     *
     * @param partitioned the partitioned
     * @return the PostIndexOptions builder
     */
    public Builder partitioned(Boolean partitioned) {
      this.partitioned = partitioned;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the PostIndexOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected PostIndexOptions() { }

  protected PostIndexOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.index,
      "index cannot be null");
    db = builder.db;
    index = builder.index;
    ddoc = builder.ddoc;
    def = builder.def;
    name = builder.name;
    partitioned = builder.partitioned;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a PostIndexOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the db.
   *
   * Path parameter to specify the database name.
   *
   * @return the db
   */
  public String db() {
    return db;
  }

  /**
   * Gets the index.
   *
   * Schema for a `json` or `text` query index definition. Indexes of type `text` have additional configuration
   * properties that do not apply to `json` indexes, these are:
   * * `default_analyzer` - the default text analyzer to use * `default_field` - whether to index the text in all
   * document fields and what analyzer to use for that purpose.
   *
   * @return the index
   */
  public IndexDefinition index() {
    return index;
  }

  /**
   * Gets the ddoc.
   *
   * Name of the design document in which the index will be created.
   *
   * @return the ddoc
   */
  public String ddoc() {
    return ddoc;
  }

  /**
   * Gets the def.
   *
   * Schema for a `json` or `text` query index definition. Indexes of type `text` have additional configuration
   * properties that do not apply to `json` indexes, these are:
   * * `default_analyzer` - the default text analyzer to use * `default_field` - whether to index the text in all
   * document fields and what analyzer to use for that purpose.
   *
   * @return the def
   */
  public IndexDefinition def() {
    return def;
  }

  /**
   * Gets the name.
   *
   * name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the partitioned.
   *
   * The default value is `true` for databases with `partitioned: true` and `false` otherwise. For databases with
   * `partitioned: false` if this option is specified the value must be `false`.
   *
   * @return the partitioned
   */
  public Boolean partitioned() {
    return partitioned;
  }

  /**
   * Gets the type.
   *
   * Schema for the type of an index.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

