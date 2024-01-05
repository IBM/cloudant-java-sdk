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
 * The getSchedulerJob options.
 */
public class GetSchedulerJobOptions extends GenericModel {

  protected String jobId;

  /**
   * Builder.
   */
  public static class Builder {
    private String jobId;

    /**
     * Instantiates a new Builder from an existing GetSchedulerJobOptions instance.
     *
     * @param getSchedulerJobOptions the instance to initialize the Builder with
     */
    private Builder(GetSchedulerJobOptions getSchedulerJobOptions) {
      this.jobId = getSchedulerJobOptions.jobId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param jobId the jobId
     */
    public Builder(String jobId) {
      this.jobId = jobId;
    }

    /**
     * Builds a GetSchedulerJobOptions.
     *
     * @return the new GetSchedulerJobOptions instance
     */
    public GetSchedulerJobOptions build() {
      return new GetSchedulerJobOptions(this);
    }

    /**
     * Set the jobId.
     *
     * @param jobId the jobId
     * @return the GetSchedulerJobOptions builder
     */
    public Builder jobId(String jobId) {
      this.jobId = jobId;
      return this;
    }
  }

  protected GetSchedulerJobOptions() { }

  protected GetSchedulerJobOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.jobId,
      "jobId cannot be empty");
    jobId = builder.jobId;
  }

  /**
   * New builder.
   *
   * @return a GetSchedulerJobOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the jobId.
   *
   * Path parameter to specify the replication job id.
   *
   * @return the jobId
   */
  public String jobId() {
    return jobId;
  }
}

