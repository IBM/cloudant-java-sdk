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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import com.ibm.cloud.cloudant.features.MockCloudant;
import com.ibm.cloud.cloudant.features.MockCloudant.MockInstruction;
import com.ibm.cloud.cloudant.features.MockCloudant.QueuedSupplier;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions.Builder;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
import com.ibm.cloud.cloudant.v1.model.ViewResultRow;
import com.ibm.cloud.sdk.core.http.ServiceCall;

public class PaginationTestHelpers {

  static class MockPagerClient extends MockCloudant<TestResult> {

    MockPagerClient(Supplier<MockInstruction<TestResult>> instructionSupplier) {
      super(instructionSupplier);
    }
 
    ServiceCall<TestResult> testCall() {
      return new MockServiceCall(mocks.get());
    }

  }

  static class TestResult {
    private List<Integer> rows;
    TestResult(List<Integer> rows) {
      this.rows = rows;
    }

    List<Integer> getRows() {
      return this.rows;
    }
  }

  private static class PageSupplierFactory<R, I> {

    Function<List<I>, R> itemsToPageResultFn;
    Function<Integer, I> integerRowWrapFn;

    PageSupplierFactory(Function<List<I>, R> itemsToPageResultFn, Function<Integer, I> integerRowWrapFn) {
      this.itemsToPageResultFn = itemsToPageResultFn;
      this.integerRowWrapFn = integerRowWrapFn;
    }

    private List<List<I>> getPages(int total, int pageSize) {
      final List<List<I>> pages = new ArrayList<>();
      List<I> page = new ArrayList<>();
      for (int i = 0; i < total; i++) {
        page.add(this.integerRowWrapFn.apply(i));
        if (i % pageSize == pageSize - 1) {
            pages.add(page);
            page = new ArrayList<>();
        }
      }
      // Add the final page, empty or otherwise
      pages.add(page);
      return pages;
    }

    PageSupplier<R, I> newPageSupplier(int total, int pageSize) {
      return new PageSupplier<R, I>(this.itemsToPageResultFn, getPages(total, pageSize));
    }

    PageSupplier<R, I> newExtraRowPageSupplier(int total, int pageSize) {
      List<List<I>> pages = getPages(total, pageSize);
      List<List<I>> responsePages = repageForKeyBased(pages);
      return new PageSupplier<R, I>(this.itemsToPageResultFn, pages, responsePages);
    }

    private List<List<I>> repageForKeyBased(List<List<I>> pages) {
      List<List<I>> responsePages = new ArrayList<>(pages.size());
      int index = 0;
      for (List<I> page : pages) {
        List<I> responsePage = new ArrayList<>(page);
        // Add the first element from the next page as n + 1
        try {
          List<I> nextPage = pages.get(index + 1);
          responsePage.add(nextPage.get(0));
        } catch(IndexOutOfBoundsException e) {
          // Suppress exception if pages/elements exhuasted
        }
        responsePages.add(responsePage);
        index++;
      }
      return responsePages;
    }

  }

  static class PageSupplier<R, I> extends QueuedSupplier<R> {
    
    final List<I> allItems;
    final List<List<I>> pages;
   
    private PageSupplier(Function<List<I>, R> itemsToPageFn, List<List<I>> pages) {
      this(itemsToPageFn, pages, pages);
    }

    private PageSupplier(Function<List<I>, R> itemsToPageFn, List<List<I>> pages, List<List<I>> responsePages) {
      super(responsePages.stream().map(itemsToPageFn).map(MockInstruction::new).collect(Collectors.toList()));
      this.pages = pages;
      this.allItems = this.pages.stream().flatMap(List::stream).collect(Collectors.toList());
    }
  }
 
  private static class TestViewResultRow extends ViewResultRow {
    private TestViewResultRow(Integer i) {
      this.id = "testdoc" + String.valueOf(i);
      this.key = i;
    }
  }

  private static class TestViewResult extends ViewResult {
    private TestViewResult(List<ViewResultRow> rows) {
      this.rows = rows;
    }
  }

  static PageSupplier<TestResult, Integer> newBasePageSupplier(int total, int pageSize) {
    return new PageSupplierFactory<>(TestResult::new, Function.identity()).newPageSupplier(total, pageSize);
  }

  static PageSupplier<TestResult, Integer> newKeyPageSupplier(int total, int pageSize) {
    return new PageSupplierFactory<TestResult, Integer>(TestResult::new, Function.identity()).newExtraRowPageSupplier(total, pageSize);
  }

  static PageSupplier<ViewResult, ViewResultRow> newViewPageSupplier(int total, int pageSize) {
    return new PageSupplierFactory<ViewResult, ViewResultRow>(TestViewResult::new, TestViewResultRow::new).newExtraRowPageSupplier(total, pageSize);
  }

  static PostViewOptions getDefaultTestOptions(int limit) {
    return getRequiredTestOptionsBuilder()
      .limit(limit)
      .build();
  }

  static Builder getRequiredTestOptionsBuilder() {
    return new Builder()
      .db("example-database")
      .ddoc("test-ddoc")
      .view("test-view");
  }

}
