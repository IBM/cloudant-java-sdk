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

import java.util.function.BiFunction;
import java.util.function.Function;
import com.ibm.cloud.cloudant.v1.Cloudant;

abstract class BookmarkPager<B, O, R, I> extends BasePager<B, O, R, I> {

  BookmarkPager(Cloudant client, O options) {
    super(client, options);
  }

  abstract Function<R, String> bookmarkGetter();

  abstract BiFunction<B, String, B> bookmarkSetter();

  @Override
  final void setNextPageOptions(B builder, R result) {
    String bookmark = bookmarkGetter().apply(result);
    bookmarkSetter().apply(builder, bookmark);
  }

}
