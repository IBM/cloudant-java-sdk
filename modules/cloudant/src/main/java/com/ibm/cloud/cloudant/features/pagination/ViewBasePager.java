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
import com.ibm.cloud.cloudant.v1.model.ViewResult;
import com.ibm.cloud.cloudant.v1.model.ViewResultRow;

abstract class ViewBasePager<B, O> extends KeyPager<Object, B, O, ViewResult, ViewResultRow> {

  protected ViewBasePager(O options) {
    super(options);
    //TODO Auto-generated constructor stub
  }

  @Override
  protected final Function<ViewResult, List<ViewResultRow>> itemsGetter() {
    return ViewResult::getRows;
  }

  @Override
  protected final Function<ViewResultRow, Object> nextKeyGetter() {
    return ViewResultRow::getKey;
  }

  @Override
  protected final Function<ViewResultRow, String> nextKeyIdGetter() {
    return ViewResultRow::getId;
  }

}
