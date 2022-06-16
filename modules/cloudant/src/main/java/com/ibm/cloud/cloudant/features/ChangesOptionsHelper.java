/**
 * © Copyright IBM Corporation 2021, 2022. All Rights Reserved.
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

package com.ibm.cloud.cloudant.features;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;

class ChangesOptionsHelper {

    // 1 minute is the sort of number that is very likely to be used as a client timeout so it makes sense
    // to set as our minimum acceptable client timeout.
    static final long MIN_CLIENT_TIMEOUT = Duration.ofMinutes(1L).toMillis();
    // To give the changes request a chance to be answered before the client timeout it is set to 3 seconds less.
    static final long LONGPOLL_TIMEOUT = MIN_CLIENT_TIMEOUT - TimeUnit.SECONDS.toMillis(3L);

    private static final String singleOptionErrorFormat = "The option %s is invalid when using %s.";
    private static final String multipleOptionErrorFormat = "The options %s are invalid when using %s.";

    private ChangesOptionsHelper() {
        // Static only, hide instance construction
    }

    static PostChangesOptions cloneOptions(PostChangesOptions options) {
        return cloneOptions(options, options.since(), options.limit());
    }

    static PostChangesOptions cloneOptionsWithNewLimit(PostChangesOptions options, Long limit) {
        return cloneOptions(options, options.since(), limit);
    }

    static PostChangesOptions cloneOptionsWithNewSince(PostChangesOptions options, String since) {
        return cloneOptions(options, since, options.limit());
    }

    private static PostChangesOptions cloneOptions(PostChangesOptions options, String since, Long limit) {
        // Now merge and set defaults
        PostChangesOptions.Builder builder = new PostChangesOptions.Builder(options.db())
        .attEncodingInfo(options.attEncodingInfo())
        .attachments(options.attachments())
        .conflicts(options.conflicts())
        // no descending
        .docIds(options.docIds())
        .feed(PostChangesOptions.Feed.LONGPOLL)
        .fields(options.fields())
        .filter(options.filter())
        // no heartbeat
        .includeDocs(options.includeDocs())
        // no lastEventId
        // limit handled after
        .selector(options.selector())
        // seq interval handled after
        .since(since)
        .style(options.style())
        .timeout(LONGPOLL_TIMEOUT)
        .view(options.view());

        // Handle options that might NPE during unboxing
        if (limit != null) {
            builder.limit(limit);
        }
        if (options.seqInterval() != null) {
            builder.seqInterval(options.seqInterval());
        }

        return builder.build();
    }

    private static String throwInvalidOptionsMessageWith(String suffix, List<String> invalidOptions) {

        String errorMsgFormat = (invalidOptions.size() > 1) ? multipleOptionErrorFormat : singleOptionErrorFormat;
        String errorMsg = String.format(errorMsgFormat,
                                        invalidOptions.stream()
                                            .collect(Collectors.joining("', '", "'", "'")),
                                        ChangesFollower.class.getSimpleName());
        throw new IllegalArgumentException(errorMsg);
    }

    static void validateOptions(PostChangesOptions options) {
        List<String> invalidOptions = new ArrayList<>();
        // First; invalid options
        if (options.descending() != null) {
            invalidOptions.add("descending");
        }
        if (options.feed() != null) {
            invalidOptions.add("feed");
        }
        if (options.heartbeat() != null) {
            invalidOptions.add("heartbeat");
        }
        if (options.lastEventId() != null) {
            invalidOptions.add("lastEventId");
        }
        if (options.timeout() != null) {
            invalidOptions.add("timeout");
        }
        if (options.filter() != null && !"_selector".equals(options.filter())) {
            invalidOptions.add(String.format("filter=%s", options.filter()));
        }
        if (invalidOptions.size() > 0) {
            throwInvalidOptionsMessageWith(String.format(" when using %s.", ChangesFollower.class.getSimpleName()), invalidOptions);
        }
    }
}
