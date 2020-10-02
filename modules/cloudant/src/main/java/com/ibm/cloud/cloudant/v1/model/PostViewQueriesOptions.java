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
 * The postViewQueries options.
 */
public class PostViewQueriesOptions extends GenericModel {

  protected String db;
  protected String ddoc;
  protected String view;
  protected List<ViewQuery> queries;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String ddoc;
    private String view;
    private List<ViewQuery> queries;

    private Builder(PostViewQueriesOptions postViewQueriesOptions) {
      this.db = postViewQueriesOptions.db;
      this.ddoc = postViewQueriesOptions.ddoc;
      this.view = postViewQueriesOptions.view;
      this.queries = postViewQueriesOptions.queries;
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
     * @param ddoc the ddoc
     * @param view the view
     * @param queries the queries
     */
    public Builder(String db, String ddoc, String view, List<ViewQuery> queries) {
      this.db = db;
      this.ddoc = ddoc;
      this.view = view;
      this.queries = queries;
    }

    /**
     * Builds a PostViewQueriesOptions.
     *
     * @return the new PostViewQueriesOptions instance
     */
    public PostViewQueriesOptions build() {
      return new PostViewQueriesOptions(this);
    }

    /**
     * Adds an queries to queries.
     *
     * @param queries the new queries
     * @return the PostViewQueriesOptions builder
     */
    public Builder addQueries(ViewQuery queries) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(queries,
        "queries cannot be null");
      if (this.queries == null) {
        this.queries = new ArrayList<ViewQuery>();
      }
      this.queries.add(queries);
      return this;
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the PostViewQueriesOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the PostViewQueriesOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the view.
     *
     * @param view the view
     * @return the PostViewQueriesOptions builder
     */
    public Builder view(String view) {
      this.view = view;
      return this;
    }

    /**
     * Set the queries.
     * Existing queries will be replaced.
     *
     * @param queries the queries
     * @return the PostViewQueriesOptions builder
     */
    public Builder queries(List<ViewQuery> queries) {
      this.queries = queries;
      return this;
    }
  }

  protected PostViewQueriesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ddoc,
      "ddoc cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.view,
      "view cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.queries,
      "queries cannot be null");
    db = builder.db;
    ddoc = builder.ddoc;
    view = builder.view;
    queries = builder.queries;
  }

  /**
   * New builder.
   *
   * @return a PostViewQueriesOptions builder
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
   * Gets the ddoc.
   *
   * Path parameter to specify the design document name. The design document name is the design document ID excluding
   * the `_design/` prefix.
   *
   * @return the ddoc
   */
  public String ddoc() {
    return ddoc;
  }

  /**
   * Gets the view.
   *
   * Path parameter to specify the map reduce view function name.
   *
   * @return the view
   */
  public String view() {
    return view;
  }

  /**
   * Gets the queries.
   *
   * An array of query objects with fields for the parameters of each individual view query to be executed. The field
   * names and their meaning are the same as the query parameters of a regular view request.
   *
   * @return the queries
   */
  public List<ViewQuery> queries() {
    return queries;
  }
}

