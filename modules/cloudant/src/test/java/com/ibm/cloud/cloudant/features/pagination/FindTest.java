/**
 * © Copyright IBM Corporation 2025. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.cloud.cloudant.features.pagination;

import com.ibm.cloud.cloudant.features.MockCloudant;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.OptionsWrapper;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.PageSupplierFactory;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.TestFindDocument;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.TestFindResult;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.FindResult;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;

public class FindTest extends
    PaginationOperationTest<PostFindOptions.Builder, FindResult, PostFindOptions, Document> {

  FindTest() {
    super(new PageSupplierFactory<FindResult, Document>(TestFindResult::new, TestFindDocument::new,
        false), OptionsWrapper.POST_FIND.newProvider(), false);
  }

  // New Pagination
  @Override
  protected Pagination<PostFindOptions, Document> makeNewPagination(
      MockCloudant<FindResult> cloudant, PostFindOptions options) {
    return Pagination.newPagination(cloudant, options);
  }

}
