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
import java.util.function.Function;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
import com.ibm.cloud.cloudant.v1.model.ViewResultRow;

abstract class ViewBasePager<B, O> extends KeyPager<Object, B, O, ViewResult, ViewResultRow> {

  ViewBasePager(Cloudant client, O options) {
    super(client, options);
  }

  @Override
  final Function<ViewResult, List<ViewResultRow>> itemsGetter() {
    return ViewResult::getRows;
  }

  @Override
  final Function<ViewResultRow, Object> nextKeyGetter() {
    return ViewResultRow::getKey;
  }

  @Override
  final Function<ViewResultRow, String> nextKeyIdGetter() {
    return ViewResultRow::getId;
  }

  @Override
  final Optional<String> checkBoundary(ViewResultRow penultimateItem, ViewResultRow lastItem) {
    String pId = penultimateItem.getId();
    String lId = lastItem.getId();
    if (pId.equals(lId)) {
      // ID's are the same, check the keys
      Object pKey = penultimateItem.getKey();
      Object lKey = lastItem.getKey();
      // Check reference equality first (e.g. null)
      // Then check values
      if (pKey == lKey || pKey != null && pKey.equals(lKey)) {
        // Identical keys, set an error message
        return Optional.of(
          String.format(
            "Cannot paginate on a boundary containing identical keys '%s' and document IDs '%s'",
            String.valueOf(lKey),
            lId));
      }
    }
    return Optional.empty();
  }

}
