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

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

final class IteratorPager<O, I> implements Pager<I> {

  private State state = State.NEW;
  private final Iterable<List<I>> pageIterable;
  private final Iterator<List<I>> pageIterator;

  enum State {
    NEW, GET_NEXT, GET_ALL, CONSUMED
  }

  IteratorPager(Iterable<List<I>> pageIterable) {
    this.pageIterable = pageIterable;
    this.pageIterator = pageIterable.iterator();
  }

  @Override
  public boolean hasNext() {
    return this.pageIterator.hasNext();
  }

  @Override
  public List<I> getNext() {
    checkState(State.GET_NEXT);
    List<I> page = this.pageIterator.next();
    if (!this.hasNext()) {
      state = State.CONSUMED;
    }
    return page;
  }

  @Override
  public List<I> getAll() {
    checkState(State.GET_ALL);
    List<I> allRows = StreamSupport.stream(this.pageIterable.spliterator(), false)
        .flatMap(List::stream).collect(Collectors.toList());
    // If it didn't throw we can set the consumed state
    state = State.CONSUMED;
    return allRows;
  }

  private void checkState(State mode) {
    if (state == mode) {
      return;
    }
    switch (state) {
      case NEW:
        state = mode;
        break;
      case CONSUMED:
        throw new IllegalStateException("This pager has been consumed use a new Pager.");
      default:
        throw new IllegalStateException(
            "Cannot mix getAll() and getNext() use only one method or get a a new Pager.");
    }
  }
}
