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
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.sdk.core.http.ServiceCall;

abstract class BasePager<B, O, R, I> implements Iterator<List<I>> {

  protected final Cloudant client;
  protected final long pageSize;
  protected final OptionsHandler<B, O> optsHandler;
  protected final AtomicReference<O> nextPageOptionsRef = new AtomicReference<>();
  protected volatile boolean hasNext = true;

  BasePager(Cloudant client, O options, OptionsHandler<B, O> optsHandler) {
    this.client = client;
    this.optsHandler = optsHandler;
    // Set the page size from the supplied options limit
    this.pageSize = getPageSizeFromOptionsLimit(options);
    // Set the first page options
    buildAndSetOptions(optsHandler.builderFromOptions(options));
  }

  @Override
  public final boolean hasNext() {
    return this.hasNext;
  }

  @Override
  public List<I> next() {
    if (this.hasNext()) {
      return Collections.unmodifiableList(this.nextRequest());
    } else {
      throw new NoSuchElementException();
    }
  }

  List<I> nextRequest() {
    ServiceCall<R> request = nextRequestFunction().apply(this.client, this.nextPageOptionsRef.get());
    R result = request.execute().getResult();
    List<I> items = itemsGetter().apply(result);
    if (items.size() < this.pageSize) {
      this.hasNext = false;
    } else {
      B optionsBuilder = optsHandler.builderFromOptions(this.nextPageOptionsRef.get());
      setNextPageOptions(optionsBuilder, result);
      buildAndSetOptions(optionsBuilder);
    }
    return items;
  }

  private void buildAndSetOptions(B optionsBuilder) {
    this.nextPageOptionsRef.set(optsHandler.optionsFromBuilder(optionsBuilder));
  }

  abstract Function<O, B> optionsToBuilderFunction();

  abstract Function<B, O> builderToOptionsFunction();

  abstract Function<R, List<I>> itemsGetter();

  abstract void setNextPageOptions(B builder, R result);

  abstract BiFunction<Cloudant, O, ServiceCall<R>> nextRequestFunction();

  abstract Function<O, Long> limitGetter();

  Long getPageSizeFromOptionsLimit(O opts) {
    return Optional.ofNullable(limitGetter().apply(opts)).orElse(200L);
  }

}
