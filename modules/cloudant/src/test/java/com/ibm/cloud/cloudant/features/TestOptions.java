/**
 * © Copyright IBM Corporation 2022. All Rights Reserved.
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

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
import com.ibm.cloud.cloudant.features.ChangesFollower.Mode;
import com.ibm.cloud.cloudant.v1.model.GetDbUpdatesOptions.Feed;

/**
 * Combinations of options to test with.
 */
enum TestOptions {

    NONE(false, () -> new PostChangesOptions.Builder()),

    MINIMUM(true, () -> new PostChangesOptions.Builder("test")),

    INCLUDE_DOCS(true, () -> MINIMUM.getBuilder()
                    .includeDocs(true)
                    .attEncodingInfo(true)
                    .attachments(true)
                    .conflicts(true)),

    DOC_IDS(false, () -> MINIMUM.getBuilder()
                    .includeDocs(true)
                    .filter("_doc_ids")
                    .addDocIds("foo")
                    .addDocIds("bar")
                    .addDocIds("baz")
                    .attEncodingInfo(true)
                    .attachments(true)
                    .conflicts(true)),

    SELECTOR(true, () -> MINIMUM.getBuilder()
                    .filter("_selector")
                    .selector(Collections.singletonMap("selector", Collections.singletonMap("foo", "bar")))
                    .includeDocs(true)
                    .addFields("foo")
                    .addFields("bar")
                    .addFields("baz")),

    SELECTOR_FILTER(true, () -> MINIMUM.getBuilder()
                    .filter("_selector")),

    DDOC_FILTER(false, () -> MINIMUM.getBuilder()
                    .filter("foo/bar")),


    DOC_ID_FILTER(false, () -> MINIMUM.getBuilder()
                    .filter("_doc_ids")),

    DESIGN_FILTER(false, () -> MINIMUM.getBuilder()
                    .filter("_design")),

    VIEW_FILTER(false, () -> MINIMUM.getBuilder()
                    .filter("_view")),

    VIEW(false, () -> MINIMUM.getBuilder()
                    .filter("_view")
                    .view("foo/bar")),

    DESCENDING(false, () -> MINIMUM.getBuilder()
                    .descending(true)),

    FEED(false, () -> MINIMUM.getBuilder()
                    .feed(Feed.CONTINUOUS)),

    HEARTBEAT(false, () -> MINIMUM.getBuilder()
                    .heartbeat(150L)),

    LAST_EVENT_ID(false, () -> MINIMUM.getBuilder()
                    .lastEventId("9876-alotofcharactersthatarenotreallyrandom")),

    TIMEOUT(false, () -> MINIMUM.getBuilder()
                    .timeout(TimeUnit.HOURS.toMillis(1L))),

    MULTI_INVALID(false, () -> MINIMUM.getBuilder()
    .descending(true)
    .feed(Feed.CONTINUOUS)
    .heartbeat(150L)
    .lastEventId("9876-alotofcharactersthatarenotreallyrandom")
    .timeout(TimeUnit.HOURS.toMillis(1L)));

    static Object[][] filteredValuesAsDataProvider(Predicate<TestOptions> predicate) {
        return Stream.of(TestOptions.values()).filter(predicate)
                .map(o -> new Object[]{o.name(), o})
                .toArray(Object[][]::new);
    }

    private final boolean valid;
    private final Supplier<PostChangesOptions.Builder> optionsBuilderSupplier;

    /**
     * 
     * @param valid whether the options are considered valid
     * @param optionsBuilderSupplier a supplier of PostChangesOptions.Builder
     */
    TestOptions(boolean valid, Supplier<PostChangesOptions.Builder> optionsBuilderSupplier) {
        this.valid = valid;
        this.optionsBuilderSupplier = optionsBuilderSupplier;
    }

    // True if it represents a valid set of options, false otherwise
    boolean valid() {
        return this.valid;
    }

    PostChangesOptions.Builder getBuilder() {
        return optionsBuilderSupplier.get();
    }

    PostChangesOptions getOptions() {
        return this.getBuilder().build();
    }

    // Adds in the implementation expected changes
    PostChangesOptions.Builder getExpectedOptionsBuilder(Mode mode) {
        PostChangesOptions.Builder b = this.getBuilder();
        if (mode != null) {
            switch (mode) {
                case FINITE:
                    b.feed(Feed.NORMAL);
                    break;
                case LISTEN:
                    b.feed(Feed.LONGPOLL);
                    b.timeout(ChangesOptionsHelper.LONGPOLL_TIMEOUT);
                    break;
            }   
        }
        return b;
    }

    // Adds in the implementation expected changes
    PostChangesOptions getExpectedOptions(Mode mode) {
        return this.getExpectedOptionsBuilder(mode).build();
    }
}
