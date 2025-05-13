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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ibm.cloud.cloudant.features.MockCloudant;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.MockPagerCloudant;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.OptionsProvider;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.PageSupplierFactory;

public abstract class PaginationOperationTest<B, R, O, I> {

  protected final PageSupplierFactory<R, I> pageSupplierFactory;
  protected final OptionsProvider<B, O> provider;
  protected final boolean plusOnePaging;

  PaginationOperationTest(PageSupplierFactory<R, I> pageSupplierFactory, OptionsProvider<B, O> provider, boolean plusOnePaging) {
    this.pageSupplierFactory = pageSupplierFactory;
    this.provider = provider;
    this.plusOnePaging = plusOnePaging;
  }

  @DataProvider(name = "pageSets")
  Object[][] getPageSets() {
    int pageSize = 10;
    return new Object[][] {getTestPageParams(0, pageSize), // Empty page
        getTestPageParams(1, pageSize), // Partial page
        getTestPageParams(pageSize - 1, pageSize), // One less than a whole page
        getTestPageParams(pageSize, pageSize), // Exactly one page
        getTestPageParams(pageSize + 1, pageSize), // One more than a whole page
        getTestPageParams(3 * pageSize, pageSize), // Multiple pages, exact
        getTestPageParams(3 * pageSize + 1, pageSize), // Multiple pages, plus one
        getTestPageParams(4 * pageSize - 1, pageSize) // Multiple pages, partial finish
    };
  }

  Object[] getTestPageParams(int total, int pageSize) {
    int fullPages = (total / pageSize);
    int partialPages = total % pageSize == 0 ? 0 : 1;
    int expectedPages = fullPages + partialPages;
    // Need at least 1 empty page to know there are no more results
    // if not ending on a partial page, except if the first page or
    // using n+1 paging (because an exact user page is a partial real page).
    if (partialPages == 0 && (!plusOnePaging || expectedPages == 0)) {
      expectedPages += 1; // We will get at least 1 empty page
    }
    return new Object[] {total, pageSize, expectedPages};
  }

  protected abstract Pagination<O, I> makeNewPagination(MockCloudant<R> c, O options);

  // Check validation is wired
  @Test
  public void testValidationEnabled() throws Exception {
    this.provider.setRequiredOpts();
    this.provider.set("limit", OptionsHandler.MIN_LIMIT - 1);
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          makeNewPagination(new MockPagerCloudant<R>(pageSupplierFactory.newPageSupplier(0, 0)),
              provider.build());
        });
  }

  // Check Pager
  @Test(dataProvider = "pageSets")
  public void testPager(int totalItems, int pageSize, int expectedPages) throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", Integer.valueOf(pageSize).longValue());
    Pagination<O, I> pagination = makeNewPagination(
        new MockPagerCloudant<R>(this.pageSupplierFactory.newPageSupplier(totalItems, pageSize)),
        provider.build());
    Pager<I> pager = pagination.pager();
    int pageCount = 0;
    int items = 0;
    Set<I> uniqueItems = new HashSet<>(totalItems);
    while (pager.hasNext()) {
      List<I> page = pager.getNext();
      pageCount++;
      items += page.size();
      uniqueItems.addAll(page);
    }
    Assert.assertEquals(pageCount, expectedPages, "There should be the expected number of pages.");
    Assert.assertEquals(items, totalItems, "There should be the expected number of items.");
    Assert.assertEquals(uniqueItems.size(), totalItems, "The items should be unique.");
  }

  // Check PageStream
  @Test(dataProvider = "pageSets")
  public void testPageStream(int totalItems, int pageSize, int expectedPages) throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", Integer.valueOf(pageSize).longValue());
    Pagination<O, I> pagination = makeNewPagination(
        new MockPagerCloudant<R>(this.pageSupplierFactory.newPageSupplier(totalItems, pageSize)),
        provider.build());
    Assert.assertEquals(pagination.pageStream().count(), expectedPages,
        "There should be the expected number of pages.");
    // Reset the mocks for another stream
    pagination = makeNewPagination(
        new MockPagerCloudant<R>(this.pageSupplierFactory.newPageSupplier(totalItems, pageSize)),
        provider.build());
    Assert.assertEquals(pagination.pageStream().flatMap(List::stream).distinct().count(),
        totalItems, "There should be the expected number of distinct items.");
  }

  // Check Pages
  @Test(dataProvider = "pageSets")
  public void testPages(int totalItems, int pageSize, int expectedPages) throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", Integer.valueOf(pageSize).longValue());
    Pagination<O, I> pagination = makeNewPagination(
        new MockPagerCloudant<R>(this.pageSupplierFactory.newPageSupplier(totalItems, pageSize)),
        provider.build());
    int pageCount = 0;
    int items = 0;
    Set<I> uniqueItems = new HashSet<>(totalItems);
    for (List<I> page : pagination.pages()) {
      pageCount++;
      items += page.size();
      uniqueItems.addAll(page);
    }
    Assert.assertEquals(pageCount, expectedPages, "There should be the expected number of pages.");
    Assert.assertEquals(items, totalItems, "There should be the expected number of items.");
    Assert.assertEquals(uniqueItems.size(), totalItems, "The items should be unique.");
  }

  // Check RowStream
  @Test(dataProvider = "pageSets")
  public void testRowStream(int totalItems, int pageSize, int expectedPages) throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", Integer.valueOf(pageSize).longValue());
    Pagination<O, I> pagination = makeNewPagination(
        new MockPagerCloudant<R>(this.pageSupplierFactory.newPageSupplier(totalItems, pageSize)),
        provider.build());
    Assert.assertEquals(pagination.rowStream().count(), totalItems,
        "There should be the expected number of items.");
    // Reset mocks for another stream
    pagination = makeNewPagination(
        new MockPagerCloudant<R>(this.pageSupplierFactory.newPageSupplier(totalItems, pageSize)),
        provider.build());
    Assert.assertEquals(pagination.rowStream().distinct().count(), totalItems,
        "There should be the expected number of distinct items.");
  }

  // Check Rows
  @Test(dataProvider = "pageSets")
  public void testRows(int totalItems, int pageSize, int expectedPages) throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", Integer.valueOf(pageSize).longValue());
    Pagination<O, I> pagination = makeNewPagination(
        new MockPagerCloudant<R>(this.pageSupplierFactory.newPageSupplier(totalItems, pageSize)),
        provider.build());
    int items = 0;
    Set<I> uniqueItems = new HashSet<>(totalItems);
    for (I row : pagination.rows()) {
      items++;
      uniqueItems.add(row);
    }
    Assert.assertEquals(items, totalItems, "There should be the expected number of items.");
    Assert.assertEquals(uniqueItems.size(), totalItems, "The items should be unique.");
  }

}
