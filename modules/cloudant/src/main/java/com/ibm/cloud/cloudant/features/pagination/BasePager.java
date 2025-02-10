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
import java.util.function.BiFunction;
import java.util.function.Function;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.sdk.core.http.ServiceCall;

abstract class BasePager<B, O, R, I> implements Pager<I> {

  protected O nextPageOptions;

  protected BasePager(Cloudant client, O options) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented constructor 'BasePager'");
  }

  @Override
  public final boolean hasNext() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
  }

  @Override
  public final List<I> getNext() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getNext'");
  }

  @Override
  public final List<I> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  protected final List<I> nextRequest() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'nextRequest'");
  }

  protected abstract Function<O, B> optionsToBuilderFunction();

  protected abstract Function<B, O> builderToOptionsFunction();

  protected abstract Function<R, List<I>> itemsGetter();

  protected abstract void setNextPageOptions(B builder, R result);

  protected abstract BiFunction<Cloudant, O, ServiceCall<R>> nextRequestFunction();

}
