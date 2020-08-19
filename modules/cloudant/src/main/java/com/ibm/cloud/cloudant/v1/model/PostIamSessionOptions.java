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
 * The postIamSession options.
 */
public class PostIamSessionOptions extends GenericModel {

  protected String accessToken;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessToken;

    private Builder(PostIamSessionOptions postIamSessionOptions) {
      this.accessToken = postIamSessionOptions.accessToken;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PostIamSessionOptions.
     *
     * @return the new PostIamSessionOptions instance
     */
    public PostIamSessionOptions build() {
      return new PostIamSessionOptions(this);
    }

    /**
     * Set the accessToken.
     *
     * @param accessToken the accessToken
     * @return the PostIamSessionOptions builder
     */
    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }
  }

  protected PostIamSessionOptions(Builder builder) {
    accessToken = builder.accessToken;
  }

  /**
   * New builder.
   *
   * @return a PostIamSessionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accessToken.
   *
   * Token obtained from the IAM service.
   *
   * @return the accessToken
   */
  public String accessToken() {
    return accessToken;
  }
}

