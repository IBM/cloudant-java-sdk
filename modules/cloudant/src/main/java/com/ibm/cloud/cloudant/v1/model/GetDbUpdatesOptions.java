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
 * The getDbUpdates options.
 */
public class GetDbUpdatesOptions extends GenericModel {

  /**
   * Query parameter to specify the changes feed type.
   */
  public interface Feed {
    /** continuous. */
    String CONTINUOUS = "continuous";
    /** eventsource. */
    String EVENTSOURCE = "eventsource";
    /** longpoll. */
    String LONGPOLL = "longpoll";
    /** normal. */
    String NORMAL = "normal";
  }

  protected String feed;
  protected Long heartbeat;
  protected Long timeout;
  protected String since;

  /**
   * Builder.
   */
  public static class Builder {
    private String feed;
    private Long heartbeat;
    private Long timeout;
    private String since;

    private Builder(GetDbUpdatesOptions getDbUpdatesOptions) {
      this.feed = getDbUpdatesOptions.feed;
      this.heartbeat = getDbUpdatesOptions.heartbeat;
      this.timeout = getDbUpdatesOptions.timeout;
      this.since = getDbUpdatesOptions.since;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetDbUpdatesOptions.
     *
     * @return the new GetDbUpdatesOptions instance
     */
    public GetDbUpdatesOptions build() {
      return new GetDbUpdatesOptions(this);
    }

    /**
     * Set the feed.
     *
     * @param feed the feed
     * @return the GetDbUpdatesOptions builder
     */
    public Builder feed(String feed) {
      this.feed = feed;
      return this;
    }

    /**
     * Set the heartbeat.
     *
     * @param heartbeat the heartbeat
     * @return the GetDbUpdatesOptions builder
     */
    public Builder heartbeat(long heartbeat) {
      this.heartbeat = heartbeat;
      return this;
    }

    /**
     * Set the timeout.
     *
     * @param timeout the timeout
     * @return the GetDbUpdatesOptions builder
     */
    public Builder timeout(long timeout) {
      this.timeout = timeout;
      return this;
    }

    /**
     * Set the since.
     *
     * @param since the since
     * @return the GetDbUpdatesOptions builder
     */
    public Builder since(String since) {
      this.since = since;
      return this;
    }
  }

  protected GetDbUpdatesOptions(Builder builder) {
    feed = builder.feed;
    heartbeat = builder.heartbeat;
    timeout = builder.timeout;
    since = builder.since;
  }

  /**
   * New builder.
   *
   * @return a GetDbUpdatesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the feed.
   *
   * Query parameter to specify the changes feed type.
   *
   * @return the feed
   */
  public String feed() {
    return feed;
  }

  /**
   * Gets the heartbeat.
   *
   * Query parameter to specify the period in milliseconds after which an empty line is sent in the results. Only
   * applicable for longpoll, continuous, and eventsource feeds. Overrides any timeout to keep the feed alive
   * indefinitely. May also be `true` to use default value of 60000.
   *
   * @return the heartbeat
   */
  public Long heartbeat() {
    return heartbeat;
  }

  /**
   * Gets the timeout.
   *
   * Query parameter to specify the maximum period in milliseconds to wait for a change before the response is sent,
   * even if there are no results. Only applicable for `longpoll` or `continuous` feeds. Default value is specified by
   * `httpd/changes_timeout` configuration option. Note that `60000` value is also the default maximum timeout to
   * prevent undetected dead connections.
   *
   * @return the timeout
   */
  public Long timeout() {
    return timeout;
  }

  /**
   * Gets the since.
   *
   * Query parameter to specify to start the results from the change immediately after the given update sequence. Can be
   * a valid update sequence or `now` value. Default is `0` i.e. all changes.
   *
   * @return the since
   */
  public String since() {
    return since;
  }
}

