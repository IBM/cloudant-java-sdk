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
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.DocsResultRow;

abstract class AllDocsBasePager<B, O> extends KeyPager<String, B, O, AllDocsResult, DocsResultRow> {

  AllDocsBasePager(Cloudant client, O options, OptionsHandler<B, O> optsHandler) {
    super(client, options, optsHandler);
  }

  @Override
  final Function<AllDocsResult, List<DocsResultRow>> itemsGetter() {
    return AllDocsResult::getRows;
  }

  @Override
  final Function<DocsResultRow, String> nextKeyGetter() {
    return DocsResultRow::getKey;
  }

  @Override
  final Function<DocsResultRow, String> nextKeyIdGetter() {
    return DocsResultRow::getId;
  }

  /**
   * Setting start key doc ID is a no-op for all_docs based paging where
   * key is the same as id.
   */
  @Override
  final Optional<BiFunction<B, String, B>> nextKeyIdSetter() {
    return Optional.empty();
  }

  @Override
  final Optional<String> checkBoundary(DocsResultRow penultimateItem, DocsResultRow lastItem) {
    // AllDocs and DesignDocs pagers always have unique keys (because they are document IDs)
    return Optional.empty();
  }
}
