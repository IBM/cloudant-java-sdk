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
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions.Builder;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
import com.ibm.cloud.sdk.core.http.ServiceCall;

final class SearchPageIterator extends SearchBasePageIterator<PostSearchOptions.Builder, PostSearchOptions> {

  SearchPageIterator(Cloudant client, PostSearchOptions options) {
    super(client, options, OptionsHandler.POST_SEARCH);
  }

  @Override
  BiFunction<Builder, String, Builder> bookmarkSetter() {
    return Builder::bookmark;
  }

  @Override
  BiFunction<Cloudant, PostSearchOptions, ServiceCall<SearchResult>> nextRequestFunction() {
    return Cloudant::postSearch;
  }

}
