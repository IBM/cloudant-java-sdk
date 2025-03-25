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

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions.Builder;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
import com.ibm.cloud.sdk.core.http.ServiceCall;

final class ViewPartitionPageIterator extends ViewBasePageIterator<PostPartitionViewOptions.Builder, PostPartitionViewOptions> {

  ViewPartitionPageIterator(Cloudant client, PostPartitionViewOptions options) {
    super(client, options, OptionsHandler.POST_PARTITION_VIEW);
  }

  @Override
  Function<PostPartitionViewOptions, Builder> optionsToBuilderFunction() {
    return PostPartitionViewOptions::newBuilder;
  }

  @Override
  Function<Builder, PostPartitionViewOptions> builderToOptionsFunction() {
    return Builder::build;
  }

  @Override
  BiFunction<Cloudant, PostPartitionViewOptions, ServiceCall<ViewResult>> nextRequestFunction() {
    return Cloudant::postPartitionView;
  }

  @Override
  BiFunction<Builder, Object, Builder> nextKeySetter() {
    return Builder::startKey;
  }

  @Override
  Optional<BiFunction<Builder, String, Builder>> nextKeyIdSetter() {
    return Optional.of(Builder::startKeyDocId);
  }

  @Override
  Function<PostPartitionViewOptions, Long> limitGetter() {
    return PostPartitionViewOptions::limit;
  }

}
