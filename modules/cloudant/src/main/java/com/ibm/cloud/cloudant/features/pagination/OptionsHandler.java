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
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
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

  private OptionsHandler(Function<B, O> builderToOptions, Function<O, B> optionsToBuilder) {
    this.builderToOptions = builderToOptions;
    this.optionsToBuilder = optionsToBuilder;
  }

  B builderFromOptions(O options) {
    return this.optionsToBuilder.apply(options);
  }

  O optionsFromBuilder(B builder) {
    return this.builderToOptions.apply(builder);
  }

  abstract void validate(O options);

  private O clone(O options) {
    return this.optionsFromBuilder(this.builderFromOptions(options));
  }

  B applyLimit(B builder, Long newLimit) {
    return this.limitSetter().apply(builder, newLimit);
  }

  abstract BiFunction<B, Long, B> limitSetter();

  abstract Function<O, Long> limitGetter();

  Long getPageSizeFromOptionsLimit(O opts) {
    return Optional.ofNullable(limitGetter().apply(opts)).orElse(MAX_LIMIT);
  }

  static final PostAllDocsOptions duplicate(PostAllDocsOptions opts) {
    return POST_ALL_DOCS.clone(opts);
  }

  static final PostDesignDocsOptions duplicate(PostDesignDocsOptions opts) {
    return POST_DESIGN_DOCS.clone(opts);
  }

  static final PostFindOptions duplicate(PostFindOptions opts) {
    return POST_FIND.clone(opts);
  }

  static final PostPartitionAllDocsOptions duplicate(PostPartitionAllDocsOptions opts) {
    return POST_PARTITION_ALL_DOCS.clone(opts);
  }

  static final PostPartitionFindOptions duplicate(PostPartitionFindOptions opts) {
    return POST_PARTITION_FIND.clone(opts);
  }

  static final PostPartitionSearchOptions duplicate(PostPartitionSearchOptions opts) {
    return POST_PARTITION_SEARCH.clone(opts);
  }

  static final PostPartitionViewOptions duplicate(PostPartitionViewOptions opts) {
    return POST_PARTITION_VIEW.clone(opts);
  }

  static final PostSearchOptions duplicate(PostSearchOptions opts) {
    return POST_SEARCH.clone(opts);
  }

  static final PostViewOptions duplicate(PostViewOptions opts) {
    return POST_VIEW.clone(opts);
  }

  private static void validateLimit(Supplier<Long> limitSupplier) {
    // If limit is set check it is within range
    // Else it is unset and we will set the valid default value later
    if (optionIsPresent(limitSupplier)) {
      Long limit = limitSupplier.get();
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

  private static <V> boolean optionIsPresent(final Supplier<V> optionSupplier) {
    return Optional.ofNullable(optionSupplier.get()).isPresent();
  }

  private static void validateOptionsAbsent(final Map<String, Supplier<?>> options) {
    for (Map.Entry<String, Supplier<?>> option : options.entrySet()) {
      if (optionIsPresent(option.getValue())) {
        throw new IllegalArgumentException(
            String.format("The option '%s' is invalid when using pagination.", option.getKey()));
      }
    }
  }

  private abstract static class KeyOptionsHandler<B, O>
      extends OptionsHandler<B, O> {

    KeyOptionsHandler(Function<B, O> builderToOptions, Function<O, B> optionsToBuilder) {
      super(builderToOptions, optionsToBuilder);
    }

    @Override
    Long getPageSizeFromOptionsLimit(O opts) {
      return super.getPageSizeFromOptionsLimit(opts) + 1;
    }

  }

  private abstract static class BookmarkOptionsHandler<B, O>
      extends OptionsHandler<B, O> {

    BookmarkOptionsHandler(Function<B, O> builderToOptions, Function<O, B> optionsToBuilder) {
      super(builderToOptions, optionsToBuilder);
    }

  }

  private static final class AllDocsOptionsHandler
      extends KeyOptionsHandler<PostAllDocsOptions.Builder, PostAllDocsOptions> {

    private AllDocsOptionsHandler() {
      super(PostAllDocsOptions.Builder::build, PostAllDocsOptions::newBuilder);
    }

    @Override
    Function<PostAllDocsOptions, Long> limitGetter() {
      return PostAllDocsOptions::limit;
    }

    @Override
    BiFunction<PostAllDocsOptions.Builder, Long, PostAllDocsOptions.Builder> limitSetter() {
      return PostAllDocsOptions.Builder::limit;
    }

    @Override
    void validate(PostAllDocsOptions options) {
      validateLimit(options::limit);
      validateOptionsAbsent(Collections.singletonMap("keys", options::keys));
    }

  }

  private static final class DesignDocsOptionsHandler
      extends KeyOptionsHandler<PostDesignDocsOptions.Builder, PostDesignDocsOptions> {

    private DesignDocsOptionsHandler() {
      super(PostDesignDocsOptions.Builder::build, PostDesignDocsOptions::newBuilder);
    }

    @Override
    Function<PostDesignDocsOptions, Long> limitGetter() {
      return PostDesignDocsOptions::limit;
    }

    @Override
    BiFunction<PostDesignDocsOptions.Builder, Long, PostDesignDocsOptions.Builder> limitSetter() {
      return PostDesignDocsOptions.Builder::limit;
    }

    @Override
    void validate(PostDesignDocsOptions options) {
      validateLimit(options::limit);
      validateOptionsAbsent(Collections.singletonMap("keys", options::keys));
    }

  }

  private static final class FindOptionsHandler
      extends BookmarkOptionsHandler<PostFindOptions.Builder, PostFindOptions> {

    private FindOptionsHandler() {
      super(PostFindOptions.Builder::build, PostFindOptions::newBuilder);
    }

    @Override
    Function<PostFindOptions, Long> limitGetter() {
      return PostFindOptions::limit;
    }

    @Override
    BiFunction<PostFindOptions.Builder, Long, PostFindOptions.Builder> limitSetter() {
      return PostFindOptions.Builder::limit;
    }

    @Override
    void validate(PostFindOptions options) {
      validateLimit(options::limit);
    }

  }

  private static final class PartitionAllDocsOptionsHandler
      extends KeyOptionsHandler<PostPartitionAllDocsOptions.Builder, PostPartitionAllDocsOptions> {

    private PartitionAllDocsOptionsHandler() {
      super(PostPartitionAllDocsOptions.Builder::build, PostPartitionAllDocsOptions::newBuilder);
    }

    @Override
    Function<PostPartitionAllDocsOptions, Long> limitGetter() {
      return PostPartitionAllDocsOptions::limit;
    }

    @Override
    BiFunction<PostPartitionAllDocsOptions.Builder, Long, PostPartitionAllDocsOptions.Builder> limitSetter() {
      return PostPartitionAllDocsOptions.Builder::limit;
    }

    @Override
    void validate(PostPartitionAllDocsOptions options) {
      validateLimit(options::limit);
      validateOptionsAbsent(Collections.singletonMap("keys", options::keys));
    }

  }

  private static final class PartitionFindOptionsHandler
      extends BookmarkOptionsHandler<PostPartitionFindOptions.Builder, PostPartitionFindOptions> {

    private PartitionFindOptionsHandler() {
      super(PostPartitionFindOptions.Builder::build, PostPartitionFindOptions::newBuilder);
    }

    @Override
    Function<PostPartitionFindOptions, Long> limitGetter() {
      return PostPartitionFindOptions::limit;
    }

    @Override
    BiFunction<PostPartitionFindOptions.Builder, Long, PostPartitionFindOptions.Builder> limitSetter() {
      return PostPartitionFindOptions.Builder::limit;
    }

    @Override
    void validate(PostPartitionFindOptions options) {
      validateLimit(options::limit);
    }

  }

  private static final class PartitionSearchOptionsHandler
      extends BookmarkOptionsHandler<PostPartitionSearchOptions.Builder, PostPartitionSearchOptions> {

    private PartitionSearchOptionsHandler() {
      super(PostPartitionSearchOptions.Builder::build, PostPartitionSearchOptions::newBuilder);
    }

    @Override
    Function<PostPartitionSearchOptions, Long> limitGetter() {
      return PostPartitionSearchOptions::limit;
    }

    @Override
    BiFunction<PostPartitionSearchOptions.Builder, Long, PostPartitionSearchOptions.Builder> limitSetter() {
      return PostPartitionSearchOptions.Builder::limit;
    }

    @Override
    void validate(PostPartitionSearchOptions options) {
      validateLimit(options::limit);
    }

  }

  private static final class PartitionViewOptionsHandler
      extends KeyOptionsHandler<PostPartitionViewOptions.Builder, PostPartitionViewOptions> {

    private PartitionViewOptionsHandler() {
      super(PostPartitionViewOptions.Builder::build, PostPartitionViewOptions::newBuilder);
    }

    @Override
    Function<PostPartitionViewOptions, Long> limitGetter() {
      return PostPartitionViewOptions::limit;
    }

    @Override
    BiFunction<PostPartitionViewOptions.Builder, Long, PostPartitionViewOptions.Builder> limitSetter() {
      return PostPartitionViewOptions.Builder::limit;
    }

    @Override
    void validate(PostPartitionViewOptions options) {
      validateLimit(options::limit);
      validateOptionsAbsent(Collections.singletonMap("keys", options::keys));
    }

  }

  private static final class SearchOptionsHandler
      extends BookmarkOptionsHandler<PostSearchOptions.Builder, PostSearchOptions> {

    private SearchOptionsHandler() {
      super(PostSearchOptions.Builder::build, PostSearchOptions::newBuilder);
    }

    @Override
    Function<PostSearchOptions, Long> limitGetter() {
      return PostSearchOptions::limit;
    }

    @Override
    BiFunction<PostSearchOptions.Builder, Long, PostSearchOptions.Builder> limitSetter() {
      return PostSearchOptions.Builder::limit;
    }

    @Override
    void validate(PostSearchOptions options) {
      validateLimit(options::limit);
      Map<String, Supplier<?>> invalidOptions = new HashMap<>(5);
      invalidOptions.put("counts", options::counts);
      invalidOptions.put("groupField", options::groupField);
      invalidOptions.put("groupLimit", options::groupLimit);
      invalidOptions.put("groupSort", options::groupSort);
      invalidOptions.put("ranges", options::ranges);
      validateOptionsAbsent(invalidOptions);
    }

  }

  private static final class ViewOptionsHandler
      extends KeyOptionsHandler<PostViewOptions.Builder, PostViewOptions> {

    private ViewOptionsHandler() {
      super(PostViewOptions.Builder::build, PostViewOptions::newBuilder);
    }

    @Override
    Function<PostViewOptions, Long> limitGetter() {
      return PostViewOptions::limit;
    }

    @Override
    BiFunction<PostViewOptions.Builder, Long, PostViewOptions.Builder> limitSetter() {
      return PostViewOptions.Builder::limit;
    }

    @Override
    void validate(PostViewOptions options) {
      validateLimit(options::limit);
      validateOptionsAbsent(Collections.singletonMap("keys", options::keys));
    }

  }

}
