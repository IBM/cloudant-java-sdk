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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ibm.cloud.cloudant.features.MockCloudant.MockInstruction;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.MockPagerClient;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.PageSupplier;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.TestResult;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions.Builder;
import com.ibm.cloud.sdk.core.http.ServiceCall;

import static com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.getDefaultTestOptions;
import static com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.getRequiredTestOptionsBuilder;
import static com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.newPageSupplierFromList;

public class BasePageIteratorTest {

  private Cloudant mockClient = new MockPagerClient(null);

  /**
   * This test sub-class of BasePager implicitly tests that various abstract methods are correctly
   * called by non-abstract methods in the BasePager.
   */
  private static class TestPager extends BasePageIterator<Builder, PostViewOptions, TestResult, Integer> {

    protected TestPager(Cloudant client, PostViewOptions options) {
      super(client, options, OptionsHandler.POST_VIEW);
    }

    Cloudant getClient() {
      return this.client;
    }

    /**
     * Implicitly tests that limit gets applied per page, otherwise the default would be used and
     * page counts would be wrong.
     */
    @Override
    protected Function<PostViewOptions, Builder> optionsToBuilderFunction() {
      return PostViewOptions::newBuilder;
    }

    @Override
    protected Function<Builder, PostViewOptions> builderToOptionsFunction() {
      return Builder::build;
    }

    @Override
    protected Function<TestResult, List<Integer>> itemsGetter() {
      return TestResult::getRows;
    }

    /**
     * These tests don't actually use the options, but we set a startKey so we can validate calls to
     * setNextPageOptions.
     */
    @Override
    protected void setNextPageOptions(Builder builder, TestResult result) {
      List<Integer> rows = result.getRows();
      if (rows.isEmpty()) {
        throw new IllegalStateException("Test failure: tried to setNextPageOptions on empty page.");
      } else {
        Integer i = rows.get(rows.size() - 1);
        builder.startKey(i);
      }
    }

    /**
     * Delegates to our next mock. If the BasePager didn't correctly call this the mocks wouldn't
     * work.
     */
    @Override
    protected BiFunction<Cloudant, PostViewOptions, ServiceCall<TestResult>> nextRequestFunction() {
      return (c, o) -> {
        return ((MockPagerClient) c).testCall();
      };
    }

    @Override
    protected Function<PostViewOptions, Long> limitGetter() {
      return PostViewOptions::limit;
    }

  }

  private static class ThrowingTestPager extends TestPager {

    private int callCounter = 0;

    protected ThrowingTestPager(Cloudant client, PostViewOptions options) {
      super(client, options);
    }

    @Override
    List<Integer> nextRequest() {
      callCounter++;
      switch (callCounter) {
        case 2:
          throw new RuntimeException("Test issue with request");
        default:
          return super.nextRequest();
      }
    }

  }

  private Pagination<PostViewOptions, Integer> newPagination(Cloudant client,
      PostViewOptions options) {
    return new Pagination<>(client, options, TestPager::new);
  }

  private Pagination<PostViewOptions, Integer> newThrowingPagination(Cloudant client,
      PostViewOptions options) {
    return new Pagination<>(client, options, ThrowingTestPager::new);
  }

  // test constructor
  @Test
  void testConstructor() {
    TestPager pager = new TestPager(mockClient, getDefaultTestOptions(42));
    // Assert the client
    Assert.assertEquals(((TestPager) pager).getClient(), mockClient,
        "The client should be the supplied one.");
  }

  // test page size default
  @Test
  void testDefaultPageSize() {
    TestPager pager = new TestPager(mockClient, getRequiredTestOptionsBuilder().build());
    // Assert the default page size
    Assert.assertEquals(pager.pageSize, 200, "The page size should be the default.");
  }

  // test page size limit
  @Test
  void testLimitPageSize() {
    TestPager pager = new TestPager(mockClient, getDefaultTestOptions(42));
    // Assert the limit provided as page size
    Assert.assertEquals(pager.pageSize, 42, "The page size should match the limit.");
  }

  // test hasNext
  @Test
  void testHasNextIsTrueInitially() {
    TestPager pager = new TestPager(mockClient, getDefaultTestOptions(42));
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should initially return true.");
  }

  @Test
  void testHasNextIsTrueForResultEqualToLimit() {
    // Mock a one element page
    MockPagerClient c = new MockPagerClient(() -> {
      return new MockInstruction<TestResult>(new TestResult(Collections.singletonList(1)));
    });
    TestPager pager = new TestPager(c, getDefaultTestOptions(1));
    // Get the first page (size 1)
    pager.next();
    // hasNext should return true because results size is the same as limit
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should return true.");
  }

  @Test
  void testHasNextIsFalseForResultLessThanLimit() {
    // Mock a zero size page
    MockPagerClient c = new MockPagerClient(() -> {
      return new MockInstruction<TestResult>(new TestResult(Collections.emptyList()));
    });
    TestPager pager = new TestPager(c, getDefaultTestOptions(1));
    // Get the first page (size 0)
    pager.next();
    // hasNext should return false because results size smaller than limit
    Assert.assertEquals(pager.hasNext(), false, "hasNext() should return false.");
  }

  // test next
  @Test
  void testNextFirstPage() {
    int pageSize = 25;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
  }

  @Test
  void testNextTwoPages() {
    int pageSize = 3;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(2 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should return true.");
    List<Integer> actualPage1 = pager.next();
    // Assert pages
    Assert.assertEquals(actualPage1, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should return true.");
    List<Integer> actualPage2 = pager.next();
    Assert.assertEquals(actualPage2, pageSupplier.pages.get(1),
        "The actual page should match the expected page.");
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should return true.");
  }

  @Test
  void testNextUntilEmpty() {
    int pageSize = 3;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(3 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualItems = new ArrayList<>();
    int pageCount = 0;
    while (pager.hasNext()) {
      pageCount++;
      List<Integer> page = pager.next();
      actualItems.addAll(page);
      // Assert each page is the same or smaller than the limit
      // to make sure we aren't getting all the results in a single page
      Assert.assertTrue(page.size() <= pageSize,
          "The actual page size should be smaller or equal to the expected page size.");
    }
    Assert.assertEquals(actualItems, pageSupplier.allItems,
        "The results should match all the pages.");
    Assert.assertEquals(pageCount, pageSupplier.pages.size(),
        "There should have been the correct number of pages.");
  }

  @Test
  void testNextUntilSmaller() {
    int pageSize = 3;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(10, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualItems = new ArrayList<>();
    int pageCount = 0;
    while (pager.hasNext()) {
      pageCount++;
      List<Integer> page = pager.next();
      actualItems.addAll(page);
      // Assert each page is the same or smaller than the limit
      // to make sure we aren't getting all the results in a single page
      Assert.assertTrue(page.size() <= pageSize,
          "The actual page size should be smaller or equal to the expected page size.");
    }
    Assert.assertEquals(actualItems, pageSupplier.allItems,
        "The results should match all the pages.");
    Assert.assertEquals(pageCount, pageSupplier.pages.size(),
        "There should have been the correct number of pages.");
  }

  @Test
  void testNextException() {
    int pageSize = 2;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(pageSize - 1, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // hasNext false
    Assert.assertEquals(pager.hasNext(), false, "hasNext() should return false.");
    // next throws
    Assert.assertThrows(NoSuchElementException.class, () -> {
      pager.next();
    });
  }

  @Test
  void testPagesAreImmutable() {
    int pageSize = 1;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert immutable
    Assert.assertThrows(UnsupportedOperationException.class, () -> {
      actualPage.add(17);
    });
  }

  // test setNextPageOptions
  @Test
  void testSetNextPageOptions() {
    int pageSize = 1;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(5 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    Assert.assertNull(pager.nextPageOptionsRef.get().startKey(),
        "startKey should initially be null.");
    // Since we use a page size of 1, each next page options key, is the same as the element from
    // the page
    int page = 0;
    while (pager.hasNext()) {
      pager.next();
      if (pager.hasNext()) {
        Assert.assertEquals(pager.nextPageOptionsRef.get().startKey(), page,
            "the startKey should increment per page.");
      } else {
        // Options don't change for last page
        Assert.assertEquals(pager.nextPageOptionsRef.get().startKey(), page - 1,
            "The options should not be set for the final page.");
      }
      page++;
    }
  }

  @Test
  void testNextResumesAfterError() {
    int pageSize = 3;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(2 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new ThrowingTestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage1 = pager.next();
    // Assert pages
    Assert.assertEquals(actualPage1, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // The startKey should point to row 2 (the last row we saw, note this is not doing n+1 paging)
    Assert.assertEquals(pager.nextPageOptionsRef.get().startKey(), 2,
        "The startKey should be 2 for the second page.");
    Assert.assertThrows(RuntimeException.class, () -> pager.next());
    // Assert hasNext
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should return true.");
    // The startKey should still point to the second page
    Assert.assertEquals(pager.nextPageOptionsRef.get().startKey(), 2,
        "The startKey should be 2 for the second page.");
    List<Integer> actualPage2 = pager.next();
    Assert.assertEquals(actualPage2, pageSupplier.pages.get(1),
        "The actual page should match the expected page.");
  }

  // asPager (getNext)
  @Test
  void testAsPagerGetNextFirstPage() {
    int pageSize = 7;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(2 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    Pager<Integer> pager = newPagination(c, getDefaultTestOptions(pageSize)).pager();
    List<Integer> actualPage = pager.getNext();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
  }

    // asPager (getNext until consumed)
    @Test
    void testAsPagerGetNextUntilConsumed() {
      int pageSize = 7;
      PageSupplier<TestResult, Integer> pageSupplier =
          PaginationTestHelpers.newBasePageSupplier(2 * pageSize, pageSize);
      MockPagerClient c = new MockPagerClient(pageSupplier);
      Pager<Integer> pager = newPagination(c, getDefaultTestOptions(pageSize)).pager();
      List<Integer> actualItems = new ArrayList<>();
      Iterator<List<Integer>> expectedPages = pageSupplier.pages.iterator();
      int pageCount = 0;
      while (pager.hasNext()) {
        List<Integer> page = pager.getNext();
        Assert.assertEquals(page, expectedPages.next());
        actualItems.addAll(page);
        pageCount++;
      }
      // Assert items
      Assert.assertEquals(actualItems, pageSupplier.allItems,
        "The results should match all the pages.");
      // Assert page count, note 3 because third page is empty
      Assert.assertEquals(pageCount, 3,
        "There should have been the correct number of pages.");
      // Assert cannot be called again
      Assert.assertThrows(IllegalStateException.class,
        () -> pager.getNext()
      );
    }

  // asPager (getAll)
  @Test
  void testAsPagerGetAll() {
    int pageSize = 11;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(71, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    Pager<Integer> pager = newPagination(c, getDefaultTestOptions(pageSize)).pager();
    List<Integer> actualItems = pager.getAll();
    Assert.assertEquals(actualItems, pageSupplier.allItems,
        "The results should match all the pages.");
    // Assert consumed state prevents calling again
    Assert.assertThrows(IllegalStateException.class,
      () -> pager.getAll()
    );
  }

  // asPager (getNext exception)
  @Test
  void testAsPagerGetNextResumesAfterError() {
    // This is like testNextResumesAfterError but for Pager getNext
    // We can't introspect the options here, but if we get the right results the options must be
    // right since we tested that arleady in testNextResumesAfterError
    int pageSize = 3;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(2 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    Pager<Integer> pager = newThrowingPagination(c, getDefaultTestOptions(pageSize)).pager();
    List<Integer> actualPage1 = pager.getNext();
    // Assert pages
    Assert.assertEquals(actualPage1, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    Assert.assertThrows(RuntimeException.class, () -> pager.getNext());
    // Assert hasNext
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should return true.");
    List<Integer> actualPage2 = pager.getNext();
    Assert.assertEquals(actualPage2, pageSupplier.pages.get(1),
        "The actual page should match the expected page.");
  }

  // asPager (getAll exception)
  @Test
  void testAsPagerGetAllRestartsAfterError() {
    int pageSize = 1;
    // Set up a supplier to do first page, [error], first page, second page, empty page
    PageSupplier<TestResult, Integer> pageSupplier = newPageSupplierFromList(
        List.of(List.of(1), // first page
        List.of(1), // error, followed by first page replay
        List.of(2), // second page
        Collections.emptyList())); // final empty page
    MockPagerClient c = new MockPagerClient(pageSupplier);
    final AtomicInteger constructedOnce = new AtomicInteger();
    Pagination<PostViewOptions, Integer> errorOnFirst = new Pagination<PostViewOptions, Integer>(c,
        getDefaultTestOptions(pageSize), (client, opts) -> {
          // Note that Pager automatically makes an iterator for hasNext/getNext so that is call 0
          // Call 1 is the first getAll (that will throw)
          // Call 2 should not throw
          if (constructedOnce.getAndIncrement() > 1) {
            return new TestPager(client, opts);
          } else {
            return new ThrowingTestPager(client, opts);
          }
        });
    Pager<Integer> pager = errorOnFirst.pager();
    Assert.assertThrows(RuntimeException.class, () -> pager.getAll());
    Assert.assertEquals(pager.getAll(), List.of(1, 2), "The results should match all the pages.");
    // Assert consumed state prevents calling again
    Assert.assertThrows(IllegalStateException.class,
      () -> pager.getAll()
    );
  }

  // asPager (getNext then getAll)
  @Test
  void testAsPagerGetNextGetAllThrows() {
    int pageSize = 7;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(2 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    Pager<Integer> pager = newPagination(c, getDefaultTestOptions(pageSize)).pager();
    // Assert first page
    Assert.assertEquals(pager.getNext(), pageSupplier.pages.get(0),
      "The actual page should match the expected page.");
    // Assert cannot call getAll once getNext has been called
    Assert.assertThrows(IllegalStateException.class,
      () -> pager.getAll()
    );
    // Ensure we can call getNext() again
    // Assert second page
    Assert.assertEquals(pager.getNext(), pageSupplier.pages.get(1),
      "The actual page should match the expected page.");
  }

  // asPager (getAll then getNext)
  @Test
  void testAsPagerGetAllGetNextThrows() {
    int pageSize = 7;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(2 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    Pager<Integer> pager = new Pagination<PostViewOptions, Integer>(c,
    getDefaultTestOptions(pageSize), ThrowingTestPager::new).pager();
    // Make sure we stop the getAll in a non-consumed state
    Assert.assertThrows(RuntimeException.class,
      () -> pager.getAll()
    );
    // Assert cannot call getNext once getAll has been called
    Assert.assertThrows(IllegalStateException.class,
      () -> pager.getNext()
    );
  }

  // asIterable (pages)
  @Test
  void testPagesIterable() {
    int pageSize = 23;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(3 * pageSize - 1, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    Iterator<List<Integer>> expectedPages = pageSupplier.pages.iterator();
    for (List<Integer> page : newPagination(c, getDefaultTestOptions(pageSize)).pages()) {
      Assert.assertEquals(page, expectedPages.next());
    }
  }

  // asIterable (rows)
  @Test
  void testRowsIterable() {
    int pageSize = 23;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(3 * pageSize - 1, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    Iterator<Integer> expectedRows = pageSupplier.allItems.iterator();
    for (Integer row : newPagination(c, getDefaultTestOptions(pageSize)).rows()) {
      Assert.assertEquals(row, expectedRows.next());
    }
  }

  // asStream (pages)
  @Test
  void testPagesStream() {
    int pageSize = 23;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(4 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    Iterator<List<Integer>> expectedPages = pageSupplier.pages.iterator();
    newPagination(c, getDefaultTestOptions(pageSize)).pages()
        .forEach(i -> Assert.assertEquals(i, expectedPages.next()));
  }

  // asStream (rows)
  @Test
  void testRowsStream() {
    int pageSize = 17;
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newBasePageSupplier(4 * pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    Iterator<Integer> expectedRows = pageSupplier.allItems.iterator();
    newPagination(c, getDefaultTestOptions(pageSize)).rows()
        .forEach(i -> Assert.assertEquals(i, expectedRows.next()));
  }

}
