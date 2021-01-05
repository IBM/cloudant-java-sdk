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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getSchedulerDocs options.
 */
public class GetSchedulerDocsOptions extends GenericModel {

  /**
   * Schema for replication state.
   */
  public interface States {
    /** initializing. */
    String INITIALIZING = "initializing";
    /** error. */
    String ERROR = "error";
    /** pending. */
    String PENDING = "pending";
    /** running. */
    String RUNNING = "running";
    /** crashing. */
    String CRASHING = "crashing";
    /** completed. */
    String COMPLETED = "completed";
    /** failed. */
    String FAILED = "failed";
  }

  protected Long limit;
  protected Long skip;
  protected List<String> states;

  /**
   * Builder.
   */
  public static class Builder {
    private Long limit;
    private Long skip;
    private List<String> states;

    private Builder(GetSchedulerDocsOptions getSchedulerDocsOptions) {
      this.limit = getSchedulerDocsOptions.limit;
      this.skip = getSchedulerDocsOptions.skip;
      this.states = getSchedulerDocsOptions.states;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetSchedulerDocsOptions.
     *
     * @return the new GetSchedulerDocsOptions instance
     */
    public GetSchedulerDocsOptions build() {
      return new GetSchedulerDocsOptions(this);
    }

    /**
     * Adds an states to states.
     *
     * @param states the new states
     * @return the GetSchedulerDocsOptions builder
     */
    public Builder addStates(String states) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(states,
        "states cannot be null");
      if (this.states == null) {
        this.states = new ArrayList<String>();
      }
      this.states.add(states);
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetSchedulerDocsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the GetSchedulerDocsOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the states.
     * Existing states will be replaced.
     *
     * @param states the states
     * @return the GetSchedulerDocsOptions builder
     */
    public Builder states(List<String> states) {
      this.states = states;
      return this;
    }
  }

  protected GetSchedulerDocsOptions(Builder builder) {
    limit = builder.limit;
    skip = builder.skip;
    states = builder.states;
  }

  /**
   * New builder.
   *
   * @return a GetSchedulerDocsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the states.
   *
   * Query parameter to include only replication documents in the specified states. String must be a comma-delimited
   * string.
   *
   * @return the states
   */
  public List<String> states() {
    return states;
  }
}

