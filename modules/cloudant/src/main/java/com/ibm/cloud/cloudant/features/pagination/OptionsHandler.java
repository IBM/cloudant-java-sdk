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

class OptionsHandler<B, O> {

  static final OptionsHandler<PostAllDocsOptions.Builder, PostAllDocsOptions> POST_ALL_DOCS =
      new OptionsHandler<>(PostAllDocsOptions.Builder::build, PostAllDocsOptions::newBuilder);
  static final OptionsHandler<PostDesignDocsOptions.Builder, PostDesignDocsOptions> POST_DESIGN_DOCS =
      new OptionsHandler<>(PostDesignDocsOptions.Builder::build, PostDesignDocsOptions::newBuilder);
  static final OptionsHandler<PostFindOptions.Builder, PostFindOptions> POST_FIND =
      new OptionsHandler<>(PostFindOptions.Builder::build, PostFindOptions::newBuilder);
  static final OptionsHandler<PostPartitionAllDocsOptions.Builder, PostPartitionAllDocsOptions> POST_PARTITION_ALL_DOCS =
      new OptionsHandler<>(PostPartitionAllDocsOptions.Builder::build,
          PostPartitionAllDocsOptions::newBuilder);
  static final OptionsHandler<PostPartitionFindOptions.Builder, PostPartitionFindOptions> POST_PARTITION_FIND =
      new OptionsHandler<>(PostPartitionFindOptions.Builder::build,
          PostPartitionFindOptions::newBuilder);
  static final OptionsHandler<PostPartitionSearchOptions.Builder, PostPartitionSearchOptions> POST_PARTITION_SEARCH =
      new OptionsHandler<>(PostPartitionSearchOptions.Builder::build,
          PostPartitionSearchOptions::newBuilder);
  static final OptionsHandler<PostPartitionViewOptions.Builder, PostPartitionViewOptions> POST_PARTITION_VIEW =
      new OptionsHandler<>(PostPartitionViewOptions.Builder::build,
          PostPartitionViewOptions::newBuilder);
  static final OptionsHandler<PostSearchOptions.Builder, PostSearchOptions> POST_SEARCH =
      new OptionsHandler<>(PostSearchOptions.Builder::build, PostSearchOptions::newBuilder);
  static final OptionsHandler<PostViewOptions.Builder, PostViewOptions> POST_VIEW =
      new OptionsHandler<>(PostViewOptions.Builder::build, PostViewOptions::newBuilder);

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

  void validate(O options) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

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

}
