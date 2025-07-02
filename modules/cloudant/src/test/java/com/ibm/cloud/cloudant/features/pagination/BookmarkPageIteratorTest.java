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

import static com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.getDefaultTestFindOptions;
import static com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.getRequiredTestFindOptionsBuilder;
import static com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.newBasePageSupplier;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.MockPagerClient;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.PageSupplier;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.TestResult;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions.Builder;
import com.ibm.cloud.sdk.core.http.ServiceCall;

public class BookmarkPageIteratorTest {

  private Cloudant mockClient = new MockPagerClient(null);

  /**
   * This test sub-class of BookmarkPager implicitly tests that various abstract methods are
   * correctly called.
   */
  class TestBookmarkPager extends BookmarkPageIterator<Builder, PostFindOptions, TestResult, Integer> {

    protected TestBookmarkPager(Cloudant client, PostFindOptions options) {
      super(client, options, OptionsHandler.POST_FIND);
    }

    Cloudant getClient() {
      return this.client;
    }

    /**
     * Delegates to our next mock. If the BasePager didn't correctly call this the mocks wouldn't
     * work.
     */
    @Override
    protected BiFunction<Cloudant, PostFindOptions, ServiceCall<TestResult>> nextRequestFunction() {
      return (c, o) -> {
        return ((MockPagerClient) c).testCall();
      };
    }

    @Override
    protected Function<TestResult, List<Integer>> itemsGetter() {
      return TestResult::getRows;
    }

    @Override
    Function<TestResult, String> bookmarkGetter() {
      // Use the last row value as the bookmark
      return result -> {
        List<Integer> rows = result.getRows();
        return String.valueOf(rows.get(rows.size() - 1));
      };
    }

    @Override
    BiFunction<Builder, String, Builder> bookmarkSetter() {
      return Builder::bookmark;
    }

  }

  // Test page size default
  @Test
  void testDefaultPageSize() {
    TestBookmarkPager pager =
        new TestBookmarkPager(mockClient, getRequiredTestFindOptionsBuilder().build());
    // Assert the limit provided as page size
    Assert.assertEquals(pager.pageSize, 200, "The page size should be the default limit.");
  }

  // Test page size limit
  @Test
  void testLimitPageSize() {
    TestBookmarkPager pager = new TestBookmarkPager(mockClient, getDefaultTestFindOptions(42));
    // Assert the limit provided as page size
    Assert.assertEquals(pager.pageSize, 42, "The page size should be the supplied limit.");
  }

  // Test all items on page when no more pages
  @Test
  void testNextPageLessThanLimit() {
    int pageSize = 21;
    PageSupplier<TestResult, Integer> pageSupplier = newBasePageSupplier(pageSize - 1, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestBookmarkPager pager = new TestBookmarkPager(c, getDefaultTestFindOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // Assert size
    Assert.assertEquals(actualPage.size(), pageSize - 1,
        "The actual page size should match the expected page size.");
    // Assert hasNext false
    Assert.assertFalse(pager.hasNext(), "hasNext() should return false.");
  }

  // Test correct items on page when limit
  @Test
  void testNextPageEqualToLimit() {
    int pageSize = 14;
    PageSupplier<TestResult, Integer> pageSupplier = newBasePageSupplier(pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestBookmarkPager pager = new TestBookmarkPager(c, getDefaultTestFindOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // Assert size is pageSize
    Assert.assertEquals(actualPage.size(), pageSize,
        "The actual page size should match the expected page size.");
    // Assert hasNext true
    Assert.assertTrue(pager.hasNext(), "hasNext() should return true.");
    // Assert bookmark is correct, note the result rows start at zero, so pageSize - 1, not pageSize
    Assert.assertEquals(pager.nextPageOptionsRef.get().bookmark(), String.valueOf(pageSize - 1),
        "The bookmark should be one less than the page size.");
    // Get next page
    List<Integer> actualSecondPage = pager.next();
    // Assert second page is empty
    Assert.assertEquals(actualSecondPage.size(), 0, "The second page should be empty.");
    // Assert hasNext false
    Assert.assertFalse(pager.hasNext(), "hasNext() should return false.");
  }

  // Test correct items on pages when more than limit
  @Test
  void testNextPageGreaterThanLimit() {
    int pageSize = 7;
    PageSupplier<TestResult, Integer> pageSupplier = newBasePageSupplier(pageSize + 2, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestBookmarkPager pager = new TestBookmarkPager(c, getDefaultTestFindOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // Assert size is pageSize
    Assert.assertEquals(actualPage.size(), pageSize,
        "The actual page size should match the expected page size.");
    // Assert hasNext true
    Assert.assertTrue(pager.hasNext(), "hasNext() should return true.");
    // Assert bookmark is correct, note the result rows start at zero, so pageSize - 1
    Assert.assertEquals(pager.nextPageOptionsRef.get().bookmark(), String.valueOf(pageSize - 1),
        "The bookmark should be one less than the page size.");
    // Get next page
    List<Integer> actualSecondPage = pager.next();
    // Assert first item on second page is correct
    Assert.assertEquals(actualSecondPage.get(0), pageSize,
        "The first item on the second page should be as expected.");
    // Assert size is 2
    Assert.assertEquals(actualSecondPage.size(), 2,
        "The actual page size should match the expected page size.");
    // Assert second page
    Assert.assertEquals(actualSecondPage, pageSupplier.pages.get(1),
        "The actual page should match the expected page.");
    // Assert hasNext false
    Assert.assertFalse(pager.hasNext(), "hasNext() should return false.");
  }

  // Test getting all items
  @Test
  void testGetAll() {
    int pageSize = 3;
    PageSupplier<TestResult, Integer> pageSupplier = newBasePageSupplier(pageSize * 12, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    List<Integer> actualItems = new Pagination<PostFindOptions, Integer>(c,
        getDefaultTestFindOptions(pageSize), TestBookmarkPager::new).pager().getAll();
    Assert.assertEquals(actualItems, pageSupplier.allItems,
        "The results should match all the pages.");
  }
}
