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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The postLocalDocsQueries options.
 */
public class PostLocalDocsQueriesOptions extends GenericModel {

  protected String db;
  protected List<AllDocsQuery> queries;
  protected String accept;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private List<AllDocsQuery> queries;
    private String accept;

    private Builder(PostLocalDocsQueriesOptions postLocalDocsQueriesOptions) {
      this.db = postLocalDocsQueriesOptions.db;
      this.queries = postLocalDocsQueriesOptions.queries;
      this.accept = postLocalDocsQueriesOptions.accept;
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
     * @param queries the queries
     */
    public Builder(String db, List<AllDocsQuery> queries) {
      this.db = db;
      this.queries = queries;
    }

    /**
     * Builds a PostLocalDocsQueriesOptions.
     *
     * @return the new PostLocalDocsQueriesOptions instance
     */
    public PostLocalDocsQueriesOptions build() {
      return new PostLocalDocsQueriesOptions(this);
    }

    /**
     * Adds an queries to queries.
     *
     * @param queries the new queries
     * @return the PostLocalDocsQueriesOptions builder
     */
    public Builder addQueries(AllDocsQuery queries) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(queries,
        "queries cannot be null");
      if (this.queries == null) {
        this.queries = new ArrayList<AllDocsQuery>();
      }
      this.queries.add(queries);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostLocalDocsQueriesOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the queries.
     * Existing queries will be replaced.
     *
     * @param queries the queries
     * @return the PostLocalDocsQueriesOptions builder
     */
    public Builder queries(List<AllDocsQuery> queries) {
      this.queries = queries;
      return this;
    }

    /**
     * Set the accept.
     *
     * @param accept the accept
     * @return the PostLocalDocsQueriesOptions builder
     */
    public Builder accept(String accept) {
      this.accept = accept;
      return this;
    }
  }

  protected PostLocalDocsQueriesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.queries,
      "queries cannot be null");
    db = builder.db;
    queries = builder.queries;
    accept = builder.accept;
  }

  /**
   * New builder.
   *
   * @return a PostLocalDocsQueriesOptions builder
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
   * Gets the queries.
   *
   * An array of query objects with fields for the parameters of each individual view query to be executed. The field
   * names and their meaning are the same as the query parameters of a regular `/_all_docs` request.
   *
   * @return the queries
   */
  public List<AllDocsQuery> queries() {
    return queries;
  }

  /**
   * Gets the accept.
   *
   * The type of the response: application/json or application/octet-stream.
   *
   * @return the accept
   */
  public String accept() {
    return accept;
  }
}

