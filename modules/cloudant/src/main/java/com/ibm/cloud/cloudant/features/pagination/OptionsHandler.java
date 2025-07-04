/**
 * © Copyright IBM Corporation 2025. All Rights Reserved.
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

package com.ibm.cloud.cloudant.features.pagination;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;

abstract class OptionsHandler<B, O> {

  static final OptionsHandler<PostAllDocsOptions.Builder, PostAllDocsOptions> POST_ALL_DOCS =
      new AllDocsOptionsHandler();
  static final OptionsHandler<PostDesignDocsOptions.Builder, PostDesignDocsOptions> POST_DESIGN_DOCS =
      new DesignDocsOptionsHandler();
  static final OptionsHandler<PostFindOptions.Builder, PostFindOptions> POST_FIND =
      new FindOptionsHandler();
  static final OptionsHandler<PostPartitionAllDocsOptions.Builder, PostPartitionAllDocsOptions> POST_PARTITION_ALL_DOCS =
      new PartitionAllDocsOptionsHandler();
  static final OptionsHandler<PostPartitionFindOptions.Builder, PostPartitionFindOptions> POST_PARTITION_FIND =
      new PartitionFindOptionsHandler();
  static final OptionsHandler<PostPartitionSearchOptions.Builder, PostPartitionSearchOptions> POST_PARTITION_SEARCH =
      new PartitionSearchOptionsHandler();
  static final OptionsHandler<PostPartitionViewOptions.Builder, PostPartitionViewOptions> POST_PARTITION_VIEW =
      new PartitionViewOptionsHandler();
  static final OptionsHandler<PostSearchOptions.Builder, PostSearchOptions> POST_SEARCH =
      new SearchOptionsHandler();
  static final OptionsHandler<PostViewOptions.Builder, PostViewOptions> POST_VIEW =
      new ViewOptionsHandler();

  // The maximum and minimum limit values (i.e. page size)
  static final Long MAX_LIMIT = 200L;
  static final Long MIN_LIMIT = 1L;

  private final Function<B, O> builderToOptions;
  private final Function<O, B> optionsToBuilder;
  private final Function<O, Long> limitGetter;
  private final BiFunction<B, Long, B> limitSetter;

  private OptionsHandler(Function<B, O> builderToOptions, Function<O, B> optionsToBuilder,
      Function<O, Long> limitGetter, BiFunction<B, Long, B> limitSetter) {
    this.builderToOptions = builderToOptions;
    this.optionsToBuilder = optionsToBuilder;
    this.limitGetter = limitGetter;
    this.limitSetter = limitSetter;
  }

  B builderFromOptions(O options) {
    return this.optionsToBuilder.apply(options);
  }

  O optionsFromBuilder(B builder) {
    return this.builderToOptions.apply(builder);
  }

  protected void validate(O options) {
    validateLimit(options);
  }

  private O copy(O options) {
    return this.optionsFromBuilder(this.builderFromOptions(options));
  }

  B applyLimit(B builder, Long newLimit) {
    return this.limitSetter.apply(builder, newLimit);
  }

  B removeOptsForSubsequentPage(O options, B builder) {
    // Default is a no-op
    return builder;
  }

  Long getPageSizeFromOptionsLimit(O opts) {
    return Optional.ofNullable(this.limitGetter.apply(opts)).orElse(MAX_LIMIT);
  }

  static final PostAllDocsOptions duplicate(PostAllDocsOptions opts) {
    return POST_ALL_DOCS.copy(opts);
  }

  static final PostDesignDocsOptions duplicate(PostDesignDocsOptions opts) {
    return POST_DESIGN_DOCS.copy(opts);
  }

  static final PostFindOptions duplicate(PostFindOptions opts) {
    return POST_FIND.copy(opts);
  }

  static final PostPartitionAllDocsOptions duplicate(PostPartitionAllDocsOptions opts) {
    return POST_PARTITION_ALL_DOCS.copy(opts);
  }

  static final PostPartitionFindOptions duplicate(PostPartitionFindOptions opts) {
    return POST_PARTITION_FIND.copy(opts);
  }

  static final PostPartitionSearchOptions duplicate(PostPartitionSearchOptions opts) {
    return POST_PARTITION_SEARCH.copy(opts);
  }

  static final PostPartitionViewOptions duplicate(PostPartitionViewOptions opts) {
    return POST_PARTITION_VIEW.copy(opts);
  }

  static final PostSearchOptions duplicate(PostSearchOptions opts) {
    return POST_SEARCH.copy(opts);
  }

  static final PostViewOptions duplicate(PostViewOptions opts) {
    return POST_VIEW.copy(opts);
  }

  protected void validateLimit(O opts) {
    // If limit is set check it is within range
    // Else it is unset and we will set the valid default value later
    if (optionIsPresent(opts, this.limitGetter)) {
      Long limit = this.limitGetter.apply(opts);
      if (limit > MAX_LIMIT) {
        throw new IllegalArgumentException(String.format(
            "The provided limit %d exceeds the maximum page size value of %d.", limit, MAX_LIMIT));
      }
      if (limit < MIN_LIMIT) {
        throw new IllegalArgumentException(
            String.format("The provided limit %d is lower than the minimum page size value of %d.",
                limit, MIN_LIMIT));
      }
    }
  }

  protected <V> Optional<V> getOptionalOption(final O opts, final Function<O, V> optionGetter) {
    return Optional.ofNullable(optionGetter.apply(opts));
  }

  protected <V> boolean optionIsPresent(final O opts, final Function<O, V> optionGetter) {
    return getOptionalOption(opts, optionGetter).isPresent();
  }

  protected void validateOptionsAbsent(final O opts,
      final Map<String, Function<O, ?>> optionGetters, final String messageReason) {
    for (Map.Entry<String, Function<O, ?>> optionGetter : optionGetters.entrySet()) {
      if (optionIsPresent(opts, optionGetter.getValue())) {
        throw new IllegalArgumentException(
            String.format("The option '%s' is invalid %s", optionGetter.getKey(), messageReason));
      }
    }
  }

  protected void validateOptionsAbsent(final O options,
      final Map<String, Function<O, ?>> optionGetters) {
    validateOptionsAbsent(options, optionGetters, "when using pagination.");
  }

  private abstract static class KeyOptionsHandler<B, O, K> extends OptionsHandler<B, O> {

    protected final Function<O, K> keyGetter;
    private final Function<O, List<K>> keysGetter;
    protected final Function<O, Long> skipGetter;
    private final String keyErrorMsg =
        keyErrorMessage(new StringBuilder("when using pagination. "));

    protected KeyOptionsHandler(Function<B, O> builderToOptions, Function<O, B> optionsToBuilder,
        Function<O, Long> limitGetter, BiFunction<B, Long, B> limitSetter, Function<O, K> keyGetter,
        Function<O, List<K>> keysGetter, Function<O, Long> skipGetter) {
      super(builderToOptions, optionsToBuilder, limitGetter, limitSetter);
      this.keyGetter = keyGetter;
      this.keysGetter = keysGetter;
      this.skipGetter = skipGetter;
    }

    protected String keyErrorMessage(StringBuilder baseMessage) {
      // Default for all docs style, override for views
      return baseMessage.append("No need to paginate as 'key' returns a single result for an ID.")
          .toString();
    }

    @Override
    Long getPageSizeFromOptionsLimit(O opts) {
      return super.getPageSizeFromOptionsLimit(opts) + 1;
    }

    @Override
    protected void validate(O options) {
      validateOptionsAbsent(options, Collections.singletonMap("keys", this.keysGetter));
      validateOptionsAbsent(options, Collections.singletonMap("key", this.keyGetter),
          this.keyErrorMsg);
      super.validate(options);
    }

    @Override
    B removeOptsForSubsequentPage(O options, B builder) {
      // Unset the skip option if necessary
      if (optionIsPresent(options, this.skipGetter)) {
        builder = this.builderFromOptions(replaceOpts(builder));
      }
      return super.removeOptsForSubsequentPage(options, builder);
    }

    protected abstract O replaceOpts(B builder);
  }

  private abstract static class ViewsOptionsHandler<B, O> extends KeyOptionsHandler<B, O, Object> {

    protected ViewsOptionsHandler(Function<B, O> builderToOptions, Function<O, B> optionsToBuilder,
        Function<O, Long> limitGetter, BiFunction<B, Long, B> limitSetter,
        Function<O, Object> keyGetter, Function<O, List<Object>> keysGetter,
        Function<O, Long> skipGetter) {
      super(builderToOptions, optionsToBuilder, limitGetter, limitSetter, keyGetter, keysGetter,
          skipGetter);
    }

    @Override
    protected String keyErrorMessage(StringBuilder baseMessage) {
      return baseMessage.append("Use startKey and endKey instead.").toString();
    }

  }

  private abstract static class BookmarkOptionsHandler<B, O> extends OptionsHandler<B, O> {

    BookmarkOptionsHandler(Function<B, O> builderToOptions, Function<O, B> optionsToBuilder,
        Function<O, Long> limitGetter, BiFunction<B, Long, B> limitSetter) {
      super(builderToOptions, optionsToBuilder, limitGetter, limitSetter);
    }

  }

  private static final class AllDocsOptionsHandler
      extends KeyOptionsHandler<PostAllDocsOptions.Builder, PostAllDocsOptions, String> {

    private AllDocsOptionsHandler() {
      super(PostAllDocsOptions.Builder::build, PostAllDocsOptions::newBuilder,
          PostAllDocsOptions::limit, PostAllDocsOptions.Builder::limit, PostAllDocsOptions::key,
          PostAllDocsOptions::keys, PostAllDocsOptions::skip);
    }

    @Override
    protected PostAllDocsOptions replaceOpts(PostAllDocsOptions.Builder builder) {
      return new PostAllDocsOptions(builder) {
        PostAllDocsOptions unsetOpts() {
          this.skip = null;
          return this;
        }
      }.unsetOpts();
    }

  }

  private static final class DesignDocsOptionsHandler
      extends KeyOptionsHandler<PostDesignDocsOptions.Builder, PostDesignDocsOptions, String> {

    private DesignDocsOptionsHandler() {
      super(PostDesignDocsOptions.Builder::build, PostDesignDocsOptions::newBuilder,
          PostDesignDocsOptions::limit, PostDesignDocsOptions.Builder::limit,
          PostDesignDocsOptions::key, PostDesignDocsOptions::keys, PostDesignDocsOptions::skip);
    }

    @Override
    protected PostDesignDocsOptions replaceOpts(PostDesignDocsOptions.Builder builder) {
      return new PostDesignDocsOptions(builder) {
        PostDesignDocsOptions unsetOpts() {
          this.skip = null;
          return this;
        }
      }.unsetOpts();
    }

  }

  private static final class FindOptionsHandler
      extends BookmarkOptionsHandler<PostFindOptions.Builder, PostFindOptions> {

    private final Function<PostFindOptions, Long> skipGetter = PostFindOptions::skip;

    private FindOptionsHandler() {
      super(PostFindOptions.Builder::build, PostFindOptions::newBuilder, PostFindOptions::limit,
          PostFindOptions.Builder::limit);
    }

    @Override
    PostFindOptions.Builder removeOptsForSubsequentPage(PostFindOptions options,
        PostFindOptions.Builder builder) {
      if (optionIsPresent(options, this.skipGetter)) {
        return new PostFindOptions(builder) {
          PostFindOptions unsetOpts() {
            this.skip = null;
            return this;
          }
        }.unsetOpts().newBuilder();
      }
      return builder;
    }

  }

  private static final class PartitionAllDocsOptionsHandler extends
      KeyOptionsHandler<PostPartitionAllDocsOptions.Builder, PostPartitionAllDocsOptions, String> {

    private PartitionAllDocsOptionsHandler() {
      super(PostPartitionAllDocsOptions.Builder::build, PostPartitionAllDocsOptions::newBuilder,
          PostPartitionAllDocsOptions::limit, PostPartitionAllDocsOptions.Builder::limit,
          PostPartitionAllDocsOptions::key, PostPartitionAllDocsOptions::keys,
          PostPartitionAllDocsOptions::skip);
    }

    @Override
    protected PostPartitionAllDocsOptions replaceOpts(PostPartitionAllDocsOptions.Builder builder) {
      return new PostPartitionAllDocsOptions(builder) {
        PostPartitionAllDocsOptions unsetOpts() {
          this.skip = null;
          return this;
        }
      }.unsetOpts();
    }

  }

  private static final class PartitionFindOptionsHandler
      extends BookmarkOptionsHandler<PostPartitionFindOptions.Builder, PostPartitionFindOptions> {

    private final Function<PostPartitionFindOptions, Long> skipGetter =
        PostPartitionFindOptions::skip;

    private PartitionFindOptionsHandler() {
      super(PostPartitionFindOptions.Builder::build, PostPartitionFindOptions::newBuilder,
          PostPartitionFindOptions::limit, PostPartitionFindOptions.Builder::limit);
    }

    @Override
    PostPartitionFindOptions.Builder removeOptsForSubsequentPage(PostPartitionFindOptions options,
        PostPartitionFindOptions.Builder builder) {
      if (optionIsPresent(options, this.skipGetter)) {
        return new PostPartitionFindOptions(builder) {
          PostPartitionFindOptions unsetOpts() {
            this.skip = null;
            return this;
          }
        }.unsetOpts().newBuilder();
      }
      return builder;
    }

  }

  private static final class PartitionSearchOptionsHandler extends
      BookmarkOptionsHandler<PostPartitionSearchOptions.Builder, PostPartitionSearchOptions> {

    private PartitionSearchOptionsHandler() {
      super(PostPartitionSearchOptions.Builder::build, PostPartitionSearchOptions::newBuilder,
          PostPartitionSearchOptions::limit, PostPartitionSearchOptions.Builder::limit);
    }

  }

  private static final class PartitionViewOptionsHandler
      extends ViewsOptionsHandler<PostPartitionViewOptions.Builder, PostPartitionViewOptions> {

    private PartitionViewOptionsHandler() {
      super(PostPartitionViewOptions.Builder::build, PostPartitionViewOptions::newBuilder,
          PostPartitionViewOptions::limit, PostPartitionViewOptions.Builder::limit,
          PostPartitionViewOptions::key, PostPartitionViewOptions::keys,
          PostPartitionViewOptions::skip);
    }

    @Override
    protected PostPartitionViewOptions replaceOpts(PostPartitionViewOptions.Builder builder) {
      return new PostPartitionViewOptions(builder) {
        PostPartitionViewOptions unsetOpts() {
          this.skip = null;
          return this;
        }
      }.unsetOpts();
    }

  }

  private static final class SearchOptionsHandler
      extends BookmarkOptionsHandler<PostSearchOptions.Builder, PostSearchOptions> {

    private SearchOptionsHandler() {
      super(PostSearchOptions.Builder::build, PostSearchOptions::newBuilder,
          PostSearchOptions::limit, PostSearchOptions.Builder::limit);
    }

    @Override
    protected void validate(PostSearchOptions options) {
      Map<String, Function<PostSearchOptions, ?>> invalidOptions = new HashMap<>(5, 1);
      invalidOptions.put("counts", PostSearchOptions::counts);
      invalidOptions.put("groupField", PostSearchOptions::groupField);
      invalidOptions.put("groupLimit", PostSearchOptions::groupLimit);
      invalidOptions.put("groupSort", PostSearchOptions::groupSort);
      invalidOptions.put("ranges", PostSearchOptions::ranges);
      validateOptionsAbsent(options, invalidOptions);
      super.validate(options);
    }

  }

  private static final class ViewOptionsHandler
      extends ViewsOptionsHandler<PostViewOptions.Builder, PostViewOptions> {

    private ViewOptionsHandler() {
      super(PostViewOptions.Builder::build, PostViewOptions::newBuilder, PostViewOptions::limit,
          PostViewOptions.Builder::limit, PostViewOptions::key, PostViewOptions::keys,
          PostViewOptions::skip);
    }

    @Override
    protected PostViewOptions replaceOpts(PostViewOptions.Builder builder) {
      return new PostViewOptions(builder) {
        PostViewOptions unsetOpts() {
          this.skip = null;
          return this;
        }
      }.unsetOpts();
    }

  }

}
