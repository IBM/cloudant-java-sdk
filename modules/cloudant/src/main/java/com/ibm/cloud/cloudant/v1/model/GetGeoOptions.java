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
 * The getGeo options.
 */
public class GetGeoOptions extends GenericModel {

  /**
   * Query parameter that causes the geospatial query output to be returned in the specified format.
   */
  public interface Format {
    /** legacy. */
    String LEGACY = "legacy";
    /** geojson. */
    String GEOJSON = "geojson";
    /** view. */
    String VIEW = "view";
    /** application/vnd.geo+json. */
    String APPLICATION_VND_GEO_JSON = "application/vnd.geo+json";
  }

  /**
   * Query parameter to specify the DE-9IM (Dimensionally Extended nine-Intersection Model)geospatial relationship
   * between the query geometry and the result documents.
   */
  public interface Relation {
    /** contains. */
    String CONTAINS = "contains";
    /** contains_properly. */
    String CONTAINS_PROPERLY = "contains_properly";
    /** covered_by. */
    String COVERED_BY = "covered_by";
    /** covers. */
    String COVERS = "covers";
    /** crosses. */
    String CROSSES = "crosses";
    /** disjoint. */
    String DISJOINT = "disjoint";
    /** intersects. */
    String INTERSECTS = "intersects";
    /** overlaps. */
    String OVERLAPS = "overlaps";
    /** touches. */
    String TOUCHES = "touches";
    /** within. */
    String WITHIN = "within";
  }

  /**
   * Query parameter to specify to not wait for the index to finish building before returning results.
   */
  public interface Stale {
    /** ok. */
    String OK = "ok";
  }

  protected String db;
  protected String ddoc;
  protected String index;
  protected String bbox;
  protected String bookmark;
  protected String format;
  protected String g;
  protected Boolean includeDocs;
  protected Double lat;
  protected Long limit;
  protected Double lon;
  protected Boolean nearest;
  protected Double radius;
  protected Double rangex;
  protected Double rangey;
  protected String relation;
  protected Long skip;
  protected String stale;

  /**
   * Builder.
   */
  public static class Builder {
    private String db;
    private String ddoc;
    private String index;
    private String bbox;
    private String bookmark;
    private String format;
    private String g;
    private Boolean includeDocs;
    private Double lat;
    private Long limit;
    private Double lon;
    private Boolean nearest;
    private Double radius;
    private Double rangex;
    private Double rangey;
    private String relation;
    private Long skip;
    private String stale;

    private Builder(GetGeoOptions getGeoOptions) {
      this.db = getGeoOptions.db;
      this.ddoc = getGeoOptions.ddoc;
      this.index = getGeoOptions.index;
      this.bbox = getGeoOptions.bbox;
      this.bookmark = getGeoOptions.bookmark;
      this.format = getGeoOptions.format;
      this.g = getGeoOptions.g;
      this.includeDocs = getGeoOptions.includeDocs;
      this.lat = getGeoOptions.lat;
      this.limit = getGeoOptions.limit;
      this.lon = getGeoOptions.lon;
      this.nearest = getGeoOptions.nearest;
      this.radius = getGeoOptions.radius;
      this.rangex = getGeoOptions.rangex;
      this.rangey = getGeoOptions.rangey;
      this.relation = getGeoOptions.relation;
      this.skip = getGeoOptions.skip;
      this.stale = getGeoOptions.stale;
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
     * @param index the index
     */
    public Builder(String db, String ddoc, String index) {
      this.db = db;
      this.ddoc = ddoc;
      this.index = index;
    }

    /**
     * Builds a GetGeoOptions.
     *
     * @return the new GetGeoOptions instance
     */
    public GetGeoOptions build() {
      return new GetGeoOptions(this);
    }

    /**
     * Set the db.
     *
     * @param db the db
     * @return the GetGeoOptions builder
     */
    public Builder db(String db) {
      this.db = db;
      return this;
    }

    /**
     * Set the ddoc.
     *
     * @param ddoc the ddoc
     * @return the GetGeoOptions builder
     */
    public Builder ddoc(String ddoc) {
      this.ddoc = ddoc;
      return this;
    }

    /**
     * Set the index.
     *
     * @param index the index
     * @return the GetGeoOptions builder
     */
    public Builder index(String index) {
      this.index = index;
      return this;
    }

    /**
     * Set the bbox.
     *
     * @param bbox the bbox
     * @return the GetGeoOptions builder
     */
    public Builder bbox(String bbox) {
      this.bbox = bbox;
      return this;
    }

    /**
     * Set the bookmark.
     *
     * @param bookmark the bookmark
     * @return the GetGeoOptions builder
     */
    public Builder bookmark(String bookmark) {
      this.bookmark = bookmark;
      return this;
    }

    /**
     * Set the format.
     *
     * @param format the format
     * @return the GetGeoOptions builder
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }

    /**
     * Set the g.
     *
     * @param g the g
     * @return the GetGeoOptions builder
     */
    public Builder g(String g) {
      this.g = g;
      return this;
    }

    /**
     * Set the includeDocs.
     *
     * @param includeDocs the includeDocs
     * @return the GetGeoOptions builder
     */
    public Builder includeDocs(Boolean includeDocs) {
      this.includeDocs = includeDocs;
      return this;
    }

    /**
     * Set the lat.
     *
     * @param lat the lat
     * @return the GetGeoOptions builder
     */
    public Builder lat(Double lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetGeoOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the lon.
     *
     * @param lon the lon
     * @return the GetGeoOptions builder
     */
    public Builder lon(Double lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Set the nearest.
     *
     * @param nearest the nearest
     * @return the GetGeoOptions builder
     */
    public Builder nearest(Boolean nearest) {
      this.nearest = nearest;
      return this;
    }

    /**
     * Set the radius.
     *
     * @param radius the radius
     * @return the GetGeoOptions builder
     */
    public Builder radius(Double radius) {
      this.radius = radius;
      return this;
    }

    /**
     * Set the rangex.
     *
     * @param rangex the rangex
     * @return the GetGeoOptions builder
     */
    public Builder rangex(Double rangex) {
      this.rangex = rangex;
      return this;
    }

    /**
     * Set the rangey.
     *
     * @param rangey the rangey
     * @return the GetGeoOptions builder
     */
    public Builder rangey(Double rangey) {
      this.rangey = rangey;
      return this;
    }

    /**
     * Set the relation.
     *
     * @param relation the relation
     * @return the GetGeoOptions builder
     */
    public Builder relation(String relation) {
      this.relation = relation;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the GetGeoOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the stale.
     *
     * @param stale the stale
     * @return the GetGeoOptions builder
     */
    public Builder stale(String stale) {
      this.stale = stale;
      return this;
    }
  }

  protected GetGeoOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.db,
      "db cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ddoc,
      "ddoc cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.index,
      "index cannot be empty");
    db = builder.db;
    ddoc = builder.ddoc;
    index = builder.index;
    bbox = builder.bbox;
    bookmark = builder.bookmark;
    format = builder.format;
    g = builder.g;
    includeDocs = builder.includeDocs;
    lat = builder.lat;
    limit = builder.limit;
    lon = builder.lon;
    nearest = builder.nearest;
    radius = builder.radius;
    rangex = builder.rangex;
    rangey = builder.rangey;
    relation = builder.relation;
    skip = builder.skip;
    stale = builder.stale;
  }

  /**
   * New builder.
   *
   * @return a GetGeoOptions builder
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
   * Gets the index.
   *
   * Path parameter to specify the index name.
   *
   * @return the index
   */
  public String index() {
    return index;
  }

  /**
   * Gets the bbox.
   *
   * Query parameter to specify a geospatial query bounding box with two latitude,longitude coordinates for the
   * lower-left and upper-right corners. An example is `-11.05987446,12.28339928,-101.05987446,62.28339928`.
   *
   * @return the bbox
   */
  public String bbox() {
    return bbox;
  }

  /**
   * Gets the bookmark.
   *
   * Query parameter to specify a bookmark that was received from a previous request. This parameter enables paging
   * through the results. If there are no more results after the bookmark, you get a response containing no further
   * results and the same bookmark, confirming the end of the result list.
   *
   * @return the bookmark
   */
  public String bookmark() {
    return bookmark;
  }

  /**
   * Gets the format.
   *
   * Query parameter that causes the geospatial query output to be returned in the specified format.
   *
   * @return the format
   */
  public String format() {
    return format;
  }

  /**
   * Gets the g.
   *
   * Query parameter to specify a Well Known Text (WKT) representation of a geospatial query geometry. The valid values
   * for the WKT parameter include `Point`, `LineString`, `Polygon`, `MultiPoint`, `MultiLineString`, `MultiPolygon`,
   * and `GeometryCollection`.
   *
   * @return the g
   */
  public String g() {
    return g;
  }

  /**
   * Gets the includeDocs.
   *
   * Query parameter to specify whether to include the full content of the documents in the response.
   *
   * @return the includeDocs
   */
  public Boolean includeDocs() {
    return includeDocs;
  }

  /**
   * Gets the lat.
   *
   * Query parameter to specify a latitude coordinate for use with radius or ellipse geospatial queries.
   *
   * @return the lat
   */
  public Double lat() {
    return lat;
  }

  /**
   * Gets the limit.
   *
   * Query parameter to specify the number of returned documents to limit the result to.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the lon.
   *
   * Query parameter to specify a longitude coordinate for use with radius or ellipse geospatial queries.
   *
   * @return the lon
   */
  public Double lon() {
    return lon;
  }

  /**
   * Gets the nearest.
   *
   * Query parameter to specify whether to perform a nearest neighbour (NN) search. If provided, the `nearest=true`
   * search returns all results by sorting their distances to the center of the query geometry. NN search can be used
   * alone or with any of the supported DE-9IM (Dimensionally Extended nine-Intersection Model) specification geometric
   * relations documented.
   *
   * @return the nearest
   */
  public Boolean nearest() {
    return nearest;
  }

  /**
   * Gets the radius.
   *
   * Query parameter to specify the radius, in meters, to search from a lat,lon coordinate point in a circular
   * geospatial query.
   *
   * @return the radius
   */
  public Double radius() {
    return radius;
  }

  /**
   * Gets the rangex.
   *
   * Query parameter to specify the first radius, in meters, to search from a lat,lon coordinate point in an ellipse
   * geospatial query.
   *
   * @return the rangex
   */
  public Double rangex() {
    return rangex;
  }

  /**
   * Gets the rangey.
   *
   * Query parameter to specify the second radius, in meters, to search from a lat,lon coordinate point in an ellipse
   * geospatial query.
   *
   * @return the rangey
   */
  public Double rangey() {
    return rangey;
  }

  /**
   * Gets the relation.
   *
   * Query parameter to specify the DE-9IM (Dimensionally Extended nine-Intersection Model)geospatial relationship
   * between the query geometry and the result documents.
   *
   * @return the relation
   */
  public String relation() {
    return relation;
  }

  /**
   * Gets the skip.
   *
   * Query parameter to specify the number of records before starting to return the results.
   *
   * @return the skip
   */
  public Long skip() {
    return skip;
  }

  /**
   * Gets the stale.
   *
   * Query parameter to specify to not wait for the index to finish building before returning results.
   *
   * @return the stale
   */
  public String stale() {
    return stale;
  }
}

