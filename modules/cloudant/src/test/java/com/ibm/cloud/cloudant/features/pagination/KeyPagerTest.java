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
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.MockPagerClient;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.PageSupplier;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.TestResult;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions.Builder;
import com.ibm.cloud.sdk.core.http.ServiceCall;

import static com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.getDefaultTestOptions;
import static com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.getRequiredTestOptionsBuilder;
import static com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.newKeyPageSupplier;

public class KeyPagerTest {

  private Cloudant mockClient = new MockPagerClient(null);

  /**
   * This test sub-class of KeyPager implicitly tests that various abstract methods are correctly
   * called.
   */
  class TestKeyPager extends KeyPager<Integer, Builder, PostViewOptions, TestResult, Integer> {

    protected TestKeyPager(Cloudant client, PostViewOptions options) {
      super(client, options, OptionsHandler.POST_VIEW);
    }

    Cloudant getClient() {
      return this.client;
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

    @Override
    protected BiFunction<Builder, Integer, Builder> nextKeySetter() {
      return Builder::startKey;
    }

    @Override
    protected Optional<BiFunction<Builder, String, Builder>> nextKeyIdSetter() {
      return Optional.of(Builder::startKeyDocId);
    }

    @Override
    protected Function<Integer, Integer> nextKeyGetter() {
      return Function.identity();
    }

    @Override
    protected Function<Integer, String> nextKeyIdGetter() {
      return String::valueOf;
    }

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

    @Override
    Optional<String> checkBoundary(Integer penultimateItem, Integer lastItem) {
      return Optional.empty();
    }

  }

  // Test page size default (+1)
  @Test
  void testDefaultPageSize() {
    TestKeyPager pager = new TestKeyPager(mockClient, getRequiredTestOptionsBuilder().build());
    // Assert the default limit as page size
    Assert.assertEquals(pager.pageSize, 201,
        "The page size should be one more than the default limit.");
  }

  // Test page size limit (+1)
  @Test
  void testLimitPageSize() {
    TestKeyPager pager = new TestKeyPager(mockClient, getDefaultTestOptions(42));
    // Assert the limit provided as page size
    Assert.assertEquals(pager.pageSize, 43,
        "The page size should be one more than the supplied limit.");
  }

  // Test all items on page when no more pages
  @Test
  void testnextPageLessThanLimit() {
    int pageSize = 21;
    PageSupplier<TestResult, Integer> pageSupplier = newKeyPageSupplier(pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestKeyPager pager = new TestKeyPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // Assert size is pageSize
    Assert.assertEquals(actualPage.size(), pageSize,
        "The actual page size should match the expected page size.");
    // Assert hasNext false because n+1 limit is 1 more than user page size
    Assert.assertFalse(pager.hasNext(), "hasNext() should return false.");
  }

  // Test correct items on page when n+1
  @Test
  void testnextPageEqualToLimit() {
    int pageSize = 14;
    PageSupplier<TestResult, Integer> pageSupplier = newKeyPageSupplier(pageSize + 1, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestKeyPager pager = new TestKeyPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // Assert size is pageSize
    Assert.assertEquals(actualPage.size(), pageSize,
        "The actual page size should match the expected page size.");
    // Assert hasNext true
    Assert.assertTrue(pager.hasNext(), "hasNext() should return true.");
    // Assert start key is correct, note the result rows start at zero, so pageSize, not pageSize +
    // 1
    Assert.assertEquals(pager.nextPageOptionsRef.get().startKey(), pageSize,
        "The start key should be page size.");
    // Get next page
    List<Integer> actualSecondPage = pager.next();
    // Assert first item on second page is correct (again we start at zero, so pageSize not pageSize
    // + 1)
    Assert.assertEquals(actualSecondPage.get(0), pageSize,
        "The first item on the second page should be as expected.");
    // Assert size is 1
    Assert.assertEquals(actualSecondPage.size(), 1,
        "The actual page size should match the expected page size.");
    // Assert second page
    Assert.assertEquals(actualSecondPage, pageSupplier.pages.get(1),
        "The actual page should match the expected page.");
    // Assert hasNext false
    Assert.assertFalse(pager.hasNext(), "hasNext() should return false.");
  }

  // Test correct items on page when n+more
  @Test
  void testNextPageGreaterThanLimit() {
    int pageSize = 7;
    PageSupplier<TestResult, Integer> pageSupplier = newKeyPageSupplier(pageSize + 2, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestKeyPager pager = new TestKeyPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // Assert size is pageSize
    Assert.assertEquals(actualPage.size(), pageSize,
        "The actual page size should match the expected page size.");
    // Assert hasNext true
    Assert.assertTrue(pager.hasNext(), "hasNext() should return true.");
    // Assert start key is correct, note the result rows start at zero, so pageSize, not pageSize +
    // 1
    Assert.assertEquals(pager.nextPageOptionsRef.get().startKey(), pageSize,
        "The start key should be page size plus one.");
    // Get next page
    List<Integer> actualSecondPage = pager.next();
    // Assert first item on second page is correct (again we start at zero, so pageSize not pageSize
    // + 1)
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
    PageSupplier<TestResult, Integer> pageSupplier = newKeyPageSupplier(pageSize * 12, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    List<Integer> actualItems = new Pagination<PostViewOptions, Integer>(c,
        getDefaultTestOptions(pageSize), TestKeyPager::new).pager().getAll();
    Assert.assertEquals(actualItems, pageSupplier.allItems,
        "The results should match all the pages.");
  }

  @Test
  void testNoBoundaryCheckByDefault() {
    int pageSize = 1;
    // Make pages with identical rows
    List<Integer> pageOne = new ArrayList<>(List.of(1, 1));
    List<Integer> pageTwo = new ArrayList<>(List.of(1, 1));
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newPageSupplierFromList(List.of(pageOne, pageTwo));
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestKeyPager pager = new TestKeyPager(c, getDefaultTestOptions(pageSize));
    // Get and assert page
    Assert.assertEquals(pager.next(), pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // Assert hasNext true
    Assert.assertTrue(pager.hasNext(), "hasNext() should return true.");
    // Boundary check implementation should not throw
    Assert.assertEquals(pager.next(), pageSupplier.pages.get(1),
        "The actual page should match the expected page.");
  }

  @Test
  void testBoundaryFailureThrowsOnNext() {
    int pageSize = 1;
    // Make pages with identical rows
    List<Integer> pageOne = new ArrayList<>(List.of(1, 1));
    List<Integer> pageTwo = new ArrayList<>(List.of(1, 1));
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newPageSupplierFromList(List.of(pageOne, pageTwo));
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestKeyPager pager = new TestKeyPager(c, getDefaultTestOptions(pageSize)) {
      @Override
      Optional<String> checkBoundary(Integer penultimateItem, Integer lastItem) {
        return Optional.of("Test boundary check failure");
      }
    };
    // Get and assert page
    Assert.assertEquals(pager.next(), pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // Assert hasNext true
    Assert.assertTrue(pager.hasNext(), "hasNext() should return true.");
    // The optional isn't empty so it check boundary should throw
    Assert.assertThrows(UnsupportedOperationException.class, () -> {
      pager.next();
    });
  }

  @Test
  void testNoBoundaryCheckWhenNoItemsLeft() {
    int pageSize = 1;
    // Make pages with identical rows
    List<Integer> pageOne = new ArrayList<>(List.of(1));
    PageSupplier<TestResult, Integer> pageSupplier =
        PaginationTestHelpers.newPageSupplierFromList(List.of(pageOne));
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestKeyPager pager = new TestKeyPager(c, getDefaultTestOptions(pageSize)) {
      @Override
      Optional<String> checkBoundary(Integer penultimateItem, Integer lastItem) {
        // Throw here to cause the test to fail if checkBoundary is called.
        throw new RuntimeException("Test failure, checkBoundary should not be called.");
      }
    };
    // Get and assert page
    Assert.assertEquals(pager.next(), pageSupplier.pages.get(0),
        "The actual page should match the expected page.");
    // Assert hasNext false
    Assert.assertFalse(pager.hasNext(), "hasNext() should return false.");
  }

}
