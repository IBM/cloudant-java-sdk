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
 * The postDbsInfo options.
 */
public class PostDbsInfoOptions extends GenericModel {

  protected List<String> keys;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> keys;

    private Builder(PostDbsInfoOptions postDbsInfoOptions) {
      this.keys = postDbsInfoOptions.keys;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PostDbsInfoOptions.
     *
     * @return the new PostDbsInfoOptions instance
     */
    public PostDbsInfoOptions build() {
      return new PostDbsInfoOptions(this);
    }

    /**
     * Adds an keys to keys.
     *
     * @param keys the new keys
     * @return the PostDbsInfoOptions builder
     */
    public Builder addKeys(String keys) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(keys,
        "keys cannot be null");
      if (this.keys == null) {
        this.keys = new ArrayList<String>();
      }
      this.keys.add(keys);
      return this;
    }

    /**
     * Set the keys.
     * Existing keys will be replaced.
     *
     * @param keys the keys
     * @return the PostDbsInfoOptions builder
     */
    public Builder keys(List<String> keys) {
      this.keys = keys;
      return this;
    }
  }

  protected PostDbsInfoOptions(Builder builder) {
    keys = builder.keys;
  }

  /**
   * New builder.
   *
   * @return a PostDbsInfoOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the keys.
   *
   * A list of database names.
   *
   * @return the keys
   */
  public List<String> keys() {
    return keys;
  }
}

