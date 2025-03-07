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
import java.util.function.Function;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
import com.ibm.cloud.cloudant.v1.model.SearchResultRow;

abstract class SearchBasePager<B, O> extends BookmarkPager<B, O, SearchResult, SearchResultRow> {

  SearchBasePager(Cloudant client, O options) {
    super(client, options);
  }

  @Override
  final Function<SearchResult, List<SearchResultRow>> itemsGetter() {
    return SearchResult::getRows;
  }

  @Override
  final Function<SearchResult, String> bookmarkGetter() {
    return SearchResult::getBookmark;
  }

}
