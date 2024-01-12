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
 * The getSchedulerJobs options.
 */
public class GetSchedulerJobsOptions extends GenericModel {

  protected Long limit;
  protected Long skip;

  /**
   * Builder.
   */
  public static class Builder {
    private Long limit;
    private Long skip;

    /**
     * Instantiates a new Builder from an existing GetSchedulerJobsOptions instance.
     *
     * @param getSchedulerJobsOptions the instance to initialize the Builder with
     */
    private Builder(GetSchedulerJobsOptions getSchedulerJobsOptions) {
      this.limit = getSchedulerJobsOptions.limit;
      this.skip = getSchedulerJobsOptions.skip;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetSchedulerJobsOptions.
     *
     * @return the new GetSchedulerJobsOptions instance
     */
    public GetSchedulerJobsOptions build() {
      return new GetSchedulerJobsOptions(this);
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetSchedulerJobsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the GetSchedulerJobsOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }
  }

  protected GetSchedulerJobsOptions() { }

  protected GetSchedulerJobsOptions(Builder builder) {
    limit = builder.limit;
    skip = builder.skip;
  }

  /**
   * New builder.
   *
   * @return a GetSchedulerJobsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the limit.
   *
   * Query parameter to specify the number of returned jobs to limit the result to.
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
}

