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

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import com.ibm.cloud.cloudant.v1.Cloudant;

abstract class KeyPager<K, B, O, R, I> extends BasePager<B, O, R, I> {

  private Optional<String> boundaryFailure = Optional.empty();

  KeyPager(Cloudant client, O options) {
    super(client, options);
  }

  abstract BiFunction<B, K, B> nextKeySetter();

  abstract Optional<BiFunction<B, String, B>> nextKeyIdSetter();

  abstract Function<I, K> nextKeyGetter();

  abstract Function<I, String> nextKeyIdGetter();

  List<I> nextRequest() {
    // If the previous request had the duplicate boundary error
    // throw it now because we cannot safely get the next page.
    if (boundaryFailure.isPresent()) {
      throw new UnsupportedOperationException(boundaryFailure.get());
    }
    List<I> items = super.nextRequest();
    if (this.hasNext()) {
      I lastItem = items.remove(items.size() - 1);
      if (items.size() > 0) {
        I penultimateItem = items.get(items.size() - 1);
        // Defer a throw for a boundary failure to the next request
        boundaryFailure = checkBoundary(penultimateItem, lastItem);
      }
    }
    return items;
  }

  @Override
  final void setNextPageOptions(B builder, R result) {
    List<I> items = itemsGetter().apply(result);
    I lastItem = items.get(items.size() - 1);
    K nextKey = nextKeyGetter().apply(lastItem);
    String nextId = nextKeyIdGetter().apply(lastItem);
    nextKeySetter().apply(builder, nextKey);
    nextKeyIdSetter().ifPresent(f -> f.apply(builder, nextId));
  }

  @Override
  Long getPageSizeFromOptionsLimit(O opts) {
      return super.getPageSizeFromOptionsLimit(opts) + 1;
  }

  abstract Optional<String> checkBoundary(I penultimateItem, I lastItem);

}
