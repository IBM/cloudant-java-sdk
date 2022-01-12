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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for list of revision information.
 */
public class Revisions extends GenericModel {

  protected List<String> ids;
  protected Long start;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> ids;
    private Long start;

    private Builder(Revisions revisions) {
      this.ids = revisions.ids;
      this.start = revisions.start;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ids the ids
     * @param start the start
     */
    public Builder(List<String> ids, Long start) {
      this.ids = ids;
      this.start = start;
    }

    /**
     * Builds a Revisions.
     *
     * @return the new Revisions instance
     */
    public Revisions build() {
      return new Revisions(this);
    }

    /**
     * Adds an ids to ids.
     *
     * @param ids the new ids
     * @return the Revisions builder
     */
    public Builder addIds(String ids) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(ids,
        "ids cannot be null");
      if (this.ids == null) {
        this.ids = new ArrayList<String>();
      }
      this.ids.add(ids);
      return this;
    }

    /**
     * Set the ids.
     * Existing ids will be replaced.
     *
     * @param ids the ids
     * @return the Revisions builder
     */
    public Builder ids(List<String> ids) {
      this.ids = ids;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the Revisions builder
     */
    public Builder start(long start) {
      this.start = start;
      return this;
    }
  }

  protected Revisions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ids,
      "ids cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.start,
      "start cannot be null");
    ids = builder.ids;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a Revisions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ids.
   *
   * Array of valid revision IDs, in reverse order (latest first).
   *
   * @return the ids
   */
  public List<String> ids() {
    return ids;
  }

  /**
   * Gets the start.
   *
   * Prefix number for the latest revision.
   *
   * @return the start
   */
  public Long start() {
    return start;
  }
}

