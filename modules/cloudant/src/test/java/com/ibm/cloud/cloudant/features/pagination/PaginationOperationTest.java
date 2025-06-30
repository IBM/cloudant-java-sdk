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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ibm.cloud.cloudant.features.MockCloudant;
import com.ibm.cloud.cloudant.features.MockCloudant.MockError;
import com.ibm.cloud.cloudant.features.MockCloudant.MockInstruction;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.MockPagerCloudant;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.OptionsProvider;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.PageSupplier;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.PageSupplierFactory;

public abstract class PaginationOperationTest<B, R, O, I> {

  protected final PageSupplierFactory<R, I> pageSupplierFactory;
  protected final OptionsProvider<B, O> provider;
  protected final boolean plusOnePaging;

  private Function<Pagination<O, I>, PagingResult<I>> pagerFn = p -> {
    PagingResult<I> result = new PagingResult<>();
    Pager<I> pager = p.pager();
    while (pager.hasNext()) {
      try {
        List<I> page = pager.getNext();
        result.handlePage(page);
      } catch (Exception e) {
        result.handleException(e);
      }
    }
    return result;
  };

  private Function<Pagination<O, I>, PagingResult<I>> pageStreamFn = p -> {
    PagingResult<I> result = new PagingResult<>();
    try {
      p.pageStream().forEach(result::handlePage);
    } catch (Exception e) {
      result.handleException(e);
    }
    return result;
  };

  private Function<Pagination<O, I>, PagingResult<I>> pagesFn = p -> {
    PagingResult<I> result = new PagingResult<>();
    try {
      for (List<I> page : p.pages()) {
        result.handlePage(page);
      }
    } catch (Exception e) {
      result.handleException(e);
    }
    return result;
  };

  private Function<Pagination<O, I>, PagingResult<I>> rowStreamFn = p -> {
    PagingResult<I> result = new PagingResult<>();
    try {
      p.rowStream().forEach(result::handleItem);
    } catch (Exception e) {
      result.handleException(e);
    }
    return result;
  };

  private Function<Pagination<O, I>, PagingResult<I>> rowsFn = p -> {
    PagingResult<I> result = new PagingResult<>();
    try {
      for (I row : p.rows()) {
        result.handleItem(row);
      }
    } catch (Exception e) {
      result.handleException(e);
    }
    return result;
  };

  PaginationOperationTest(PageSupplierFactory<R, I> pageSupplierFactory,
      OptionsProvider<B, O> provider, boolean plusOnePaging) {
    this.pageSupplierFactory = pageSupplierFactory;
    this.provider = provider;
    this.plusOnePaging = plusOnePaging;
  }

  private static final class TestCase {
    final int totalItems;
    final int pageSize;
    final int expectedPages;

    TestCase(int totalItems, int pageSize, boolean plusOnePaging) {
      this.totalItems = totalItems;
      this.pageSize = pageSize;
      this.expectedPages = (totalItems == 0) ? 1 : getExpectedPages(plusOnePaging);
    }

    private int getExpectedPages(boolean plusOnePaging) {
      int fullPages = (totalItems / pageSize);
      int partialPages = totalItems % pageSize == 0 ? 0 : 1;
      int expectedPages = fullPages + partialPages;
      // Need at least 1 empty page to know there are no more results
      // if not ending on a partial page, except if the first page or
      // using n+1 paging (because an exact user page is a partial real page).
      if (partialPages == 0 && (!plusOnePaging || expectedPages == 0)) {
        expectedPages += 1; // We will get at least 1 empty page
      }
      return expectedPages;
    }
  }

  private final List<BiConsumer<PagingResult<I>, TestCase>> pageAssertions =
      List.of(PagingResult::assertPageCount, PagingResult::assertItemCount,
          PagingResult::assertUniqueItemCount);
  private final List<BiConsumer<PagingResult<I>, TestCase>> itemAssertions =
      pageAssertions.subList(1, pageAssertions.size());


  private static final class PagingResult<I> {

    boolean assertable = false;
    Integer pageCount = 0;
    List<I> items = new ArrayList<>();
    List<Exception> errors = new ArrayList<>();

    private void setAssertable() {
      if (!this.assertable) {
        this.assertable = true;
      }
    }

    private void handleException(Exception e) {
      setAssertable();
      errors.add(e);
    }

    private void handleItem(I item) {
      setAssertable();
      items.add(item);
    }

    private void handlePage(Collection<I> page) {
      setAssertable();
      pageCount++;
      items.addAll(page);
    }

    private void assertItemCount(TestCase t) {
      Assert.assertEquals(items.size(), t.totalItems,
          "There should be the expected number of items.");
    }

    private void assertPageCount(TestCase t) {
      Assert.assertTrue(this.assertable, "PagingResult handled no pages.");
      Assert.assertEquals(pageCount, t.expectedPages,
          "There should be the expected number of pages.");
    }

    private void assertUniqueItemCount(TestCase t) {
      Set<I> uniqueItems = new HashSet<>();
      uniqueItems.addAll(items);
      Assert.assertEquals(uniqueItems.size(), t.totalItems, "The items should be unique.");
    }

  }

  @DataProvider(name = "pageSets")
  Object[][] getPageSets() {
    int pageSize = 10;
    return new Object[][] {makeTestCase(0, pageSize), // Empty page
        makeTestCase(1, pageSize), // Partial page
        makeTestCase(pageSize - 1, pageSize), // One less than a whole page
        makeTestCase(pageSize, pageSize), // Exactly one page
        makeTestCase(pageSize + 1, pageSize), // One more than a whole page
        makeTestCase(3 * pageSize, pageSize), // Multiple pages, exact
        makeTestCase(3 * pageSize + 1, pageSize), // Multiple pages, plus one
        makeTestCase(4 * pageSize - 1, pageSize) // Multiple pages, partial finish
    };
  }

  @DataProvider(name = "errorSuppliers")
  Iterator<Object[]> getErrorSuppliers() {
    return Arrays.stream(MockError.values()).flatMap(mockError -> {
      return List.of(new Object[] {mockError, true}, new Object[] {mockError, false}).stream();
    }).iterator();
  }

  Object[] makeTestCase(int total, int pageSize) {
    return new Object[] {new TestCase(total, pageSize, plusOnePaging)};
  }

  protected abstract Pagination<O, I> makeNewPagination(MockCloudant<R> c, O options);

  private Pagination<O, I> makeTestPagination(int pageSize, Supplier<MockInstruction<R>> supplier)
      throws Exception {
    this.provider.setRequiredOpts();
    this.provider.set("limit", (long) pageSize);
    return makeNewPagination(new MockPagerCloudant<R>(supplier), provider.build());
  }

  private void runPaginationTest(TestCase t,
      Function<Pagination<O, I>, PagingResult<I>> pagingFunction,
      List<BiConsumer<PagingResult<I>, TestCase>> assertions) throws Exception {
    Pagination<O, I> pagination = makeTestPagination(t.pageSize,
        this.pageSupplierFactory.newPageSupplier(t.totalItems, t.pageSize));
    PagingResult<I> r = pagingFunction.apply(pagination);
    for (BiConsumer<PagingResult<I>, TestCase> assertion : assertions) {
      assertion.accept(r, t);
    }
  }

  private void runPaginationErrorTest(Function<Pagination<O, I>, PagingResult<I>> pagingFunction,
      MockError error, boolean errorOnFirstPage) throws Exception {
    int pageSize = OptionsHandler.MAX_LIMIT.intValue();
    int wholePages = 2;
    int expectedItems = wholePages * pageSize;
    List<MockInstruction<R>> instructions = new ArrayList<>();
    PageSupplier<R, I> supplier = this.pageSupplierFactory.newPageSupplier(expectedItems, pageSize);
    if (!errorOnFirstPage) {
      instructions.add(supplier.get()); // Add a successful page
    }
    instructions.add(new MockInstruction<>(error)); // Add the error
    // Add remaining instructions that might be needed
    // For error on first page it is first page, second page, empty page (i.e. 3)
    // For error on second page it is second page, empty page (i.e. 2)
    int remainingInstructions = (errorOnFirstPage ? 1 : 0) + wholePages;
    Stream.generate(supplier).limit(remainingInstructions).forEach(instructions::add);
    Pagination<O, I> pagination =
        makeTestPagination(pageSize, new MockCloudant.QueuedSupplier<R>(instructions));
    PagingResult<I> r = pagingFunction.apply(pagination);
    // Assert that there was a single exception
    Assert.assertEquals(r.errors.size(), 1, "There should be a single exception.");
    Assert.assertEquals(r.errors.get(0).getClass(), error.getExceptionClass(),
        "The correct exception should be received.");
    TestCase t;
    if (pagerFn.equals(pagingFunction)) {
      // If using pager then expect all pages/items
      t = new TestCase(expectedItems, pageSize, this.plusOnePaging);
      r.assertPageCount(new TestCase(expectedItems, pageSize, this.plusOnePaging));
      r.assertItemCount(new TestCase(expectedItems, pageSize, this.plusOnePaging));
    } else {
      // Else (pages, rows, streams) expect only up to the error
      int expectedPages = (errorOnFirstPage) ? 0 : 1;
      expectedItems = expectedPages * pageSize;
      if (!rowsFn.equals(pagingFunction) && !rowStreamFn.equals(pagingFunction)) {
        // Only assert page count if we are handling pages
        Assert.assertEquals(r.pageCount, expectedPages,
            "There should be the correct number of pages.");
      }
      Assert.assertEquals(r.items.size(), expectedItems,
          "There should be the correct number of items.");
    }

  }

  // Check validation is wired
  @Test
  public void testValidationEnabled() throws Exception {
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          runPaginationTest(
              new TestCase(0, Math.toIntExact(OptionsHandler.MIN_LIMIT - 1), plusOnePaging),
              p -> null, Collections.emptyList());
        });
  }

  // Check Pager
  @Test(dataProvider = "pageSets")
  public void testPager(TestCase t) throws Exception {
    runPaginationTest(t, pagerFn, pageAssertions);
  }

  // Check PageStream
  @Test(dataProvider = "pageSets")
  public void testPageStream(TestCase t) throws Exception {
    runPaginationTest(t, pageStreamFn, pageAssertions);
  }

  // Check Pages
  @Test(dataProvider = "pageSets")
  public void testPages(TestCase t) throws Exception {
    runPaginationTest(t, pagesFn, pageAssertions);
  }

  // Check RowStream
  @Test(dataProvider = "pageSets")
  public void testRowStream(TestCase t) throws Exception {
    runPaginationTest(t, rowStreamFn, itemAssertions);
  }

  // Check Rows
  @Test(dataProvider = "pageSets")
  public void testRows(TestCase t) throws Exception {
    runPaginationTest(t, rowsFn, itemAssertions);
  }

  // Check Pager errors
  @Test(dataProvider = "errorSuppliers")
  public void testPagerErrors(MockError error, boolean errorOnFirstPage) throws Exception {
    runPaginationErrorTest(pagerFn, error, errorOnFirstPage);
  }

  // Check PageStream errors
  @Test(dataProvider = "errorSuppliers")
  public void testPageStreamErrors(MockError error, boolean errorOnFirstPage) throws Exception {
    runPaginationErrorTest(pageStreamFn, error, errorOnFirstPage);
  }

  // Check Pages errors
  @Test(dataProvider = "errorSuppliers")
  public void testPagesErrors(MockError error, boolean errorOnFirstPage) throws Exception {
    runPaginationErrorTest(pagesFn, error, errorOnFirstPage);
  }

  // Check RowStream errors
  @Test(dataProvider = "errorSuppliers")
  public void testRowStreamErrors(MockError error, boolean errorOnFirstPage) throws Exception {
    runPaginationErrorTest(rowStreamFn, error, errorOnFirstPage);
  }

  // Check Rows errors
  @Test(dataProvider = "errorSuppliers")
  public void testRowsErrors(MockError error, boolean errorOnFirstPage) throws Exception {
    runPaginationErrorTest(rowsFn, error, errorOnFirstPage);
  }


}
