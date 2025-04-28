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
import java.util.Map;
import java.util.Optional;
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

  static final OptionsHandler<PostAllDocsOptions.Builder, PostAllDocsOptions> POST_ALL_DOCS = new AllDocsOptionsHandler();
  static final OptionsHandler<PostDesignDocsOptions.Builder, PostDesignDocsOptions> POST_DESIGN_DOCS = new DesignDocsOptionsHandler();
  static final OptionsHandler<PostFindOptions.Builder, PostFindOptions> POST_FIND = new FindOptionsHandler();
  static final OptionsHandler<PostPartitionAllDocsOptions.Builder, PostPartitionAllDocsOptions> POST_PARTITION_ALL_DOCS =
      new PartitionAllDocsOptionsHandler();
  static final OptionsHandler<PostPartitionFindOptions.Builder, PostPartitionFindOptions> POST_PARTITION_FIND = new PartitionFindOptionsHandler();
  static final OptionsHandler<PostPartitionSearchOptions.Builder, PostPartitionSearchOptions> POST_PARTITION_SEARCH =
      new PartitionSearchOptionsHandler();
  static final OptionsHandler<PostPartitionViewOptions.Builder, PostPartitionViewOptions> POST_PARTITION_VIEW = new PartitionViewOptionsHandler();
  static final OptionsHandler<PostSearchOptions.Builder, PostSearchOptions> POST_SEARCH = new SearchOptionsHandler();
  static final OptionsHandler<PostViewOptions.Builder, PostViewOptions> POST_VIEW = new ViewOptionsHandler();

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

  O clone(O options) {
    return this.optionsFromBuilder(this.builderFromOptions(options));
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
          String.format("The option '%s' is invalid when using pagination.", option.getKey())
        );
      }
    }
  }

  private static final class AllDocsOptionsHandler
      extends OptionsHandler<PostAllDocsOptions.Builder, PostAllDocsOptions> {

    private AllDocsOptionsHandler() {
      super(PostAllDocsOptions.Builder::build, PostAllDocsOptions::newBuilder);
    }

    @Override
    void validate(PostAllDocsOptions options) {
      throw new UnsupportedOperationException("Not yet implemented.");
    }

  }

  private static final class DesignDocsOptionsHandler
      extends OptionsHandler<PostDesignDocsOptions.Builder, PostDesignDocsOptions> {

    private DesignDocsOptionsHandler() {
      super(PostDesignDocsOptions.Builder::build, PostDesignDocsOptions::newBuilder);
    }

    @Override
    void validate(PostDesignDocsOptions options) {
      throw new UnsupportedOperationException("Not yet implemented.");
    }

  }

  private static final class FindOptionsHandler
      extends OptionsHandler<PostFindOptions.Builder, PostFindOptions> {

    private FindOptionsHandler() {
      super(PostFindOptions.Builder::build, PostFindOptions::newBuilder);
    }

    @Override
    void validate(PostFindOptions options) {
      throw new UnsupportedOperationException("Not yet implemented.");
    }

  }

  private static final class PartitionAllDocsOptionsHandler
      extends OptionsHandler<PostPartitionAllDocsOptions.Builder, PostPartitionAllDocsOptions> {

    private PartitionAllDocsOptionsHandler() {
      super(PostPartitionAllDocsOptions.Builder::build, PostPartitionAllDocsOptions::newBuilder);
    }

    @Override
    void validate(PostPartitionAllDocsOptions options) {
      throw new UnsupportedOperationException("Not yet implemented.");
    }

  }

  private static final class PartitionFindOptionsHandler
      extends OptionsHandler<PostPartitionFindOptions.Builder, PostPartitionFindOptions> {

    private PartitionFindOptionsHandler() {
      super(PostPartitionFindOptions.Builder::build, PostPartitionFindOptions::newBuilder);
    }

    @Override
    void validate(PostPartitionFindOptions options) {
      throw new UnsupportedOperationException("Not yet implemented.");
    }

  }

  private static final class PartitionSearchOptionsHandler
      extends OptionsHandler<PostPartitionSearchOptions.Builder, PostPartitionSearchOptions> {

    private PartitionSearchOptionsHandler() {
      super(PostPartitionSearchOptions.Builder::build, PostPartitionSearchOptions::newBuilder);
    }

    @Override
    void validate(PostPartitionSearchOptions options) {
      throw new UnsupportedOperationException("Not yet implemented.");
    }

  }

  private static final class PartitionViewOptionsHandler
      extends OptionsHandler<PostPartitionViewOptions.Builder, PostPartitionViewOptions> {

    private PartitionViewOptionsHandler() {
      super(PostPartitionViewOptions.Builder::build, PostPartitionViewOptions::newBuilder);
    }

    @Override
    void validate(PostPartitionViewOptions options) {
      throw new UnsupportedOperationException("Not yet implemented.");
    }

  }

  private static final class SearchOptionsHandler
      extends OptionsHandler<PostSearchOptions.Builder, PostSearchOptions> {

    private SearchOptionsHandler() {
      super(PostSearchOptions.Builder::build, PostSearchOptions::newBuilder);
    }

    @Override
    void validate(PostSearchOptions options) {
      throw new UnsupportedOperationException("Not yet implemented.");
    }

  }


  private static final class ViewOptionsHandler
      extends OptionsHandler<PostViewOptions.Builder, PostViewOptions> {

    private ViewOptionsHandler() {
      super(PostViewOptions.Builder::build, PostViewOptions::newBuilder);
    }

    @Override
    void validate(PostViewOptions options) {
      throw new UnsupportedOperationException("Not yet implemented.");
    }

  }

}
