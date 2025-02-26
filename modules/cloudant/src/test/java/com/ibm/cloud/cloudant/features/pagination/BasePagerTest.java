package com.ibm.cloud.cloudant.features.pagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ibm.cloud.cloudant.features.MockCloudant;
import com.ibm.cloud.cloudant.features.MockCloudant.MockInstruction;
import com.ibm.cloud.cloudant.features.MockCloudant.QueuedSupplier;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions.Builder;
import com.ibm.cloud.sdk.core.http.ServiceCall;

public class BasePagerTest {
  
  private Cloudant mockClient = new MockPagerClient(null);

  static class PageSupplier extends QueuedSupplier<TestResult> {
    
    final List<Integer> allItems;
    final List<List<Integer>> pages;

    private PageSupplier(List<List<Integer>> pages) {
      super(pages.stream().map(TestResult::new).map(MockInstruction::new).collect(Collectors.toList()));
      this.pages = pages;
      this.allItems = this.pages.stream().flatMap(List::stream).collect(Collectors.toList());
    }

    static PageSupplier makePageSupplier(int total, int pageSize) {
      final List<List<Integer>> pages = new ArrayList<>();
      List<Integer> page = new ArrayList<>();
      for (int i = 0; i < total; i++) {
        page.add(i);
        if (i % pageSize == pageSize - 1) {
            pages.add(page);
            page = new ArrayList<>();
        }
      }
      // Add the final page, empty or otherwise
      pages.add(page);
      return new PageSupplier(pages);
    }
  }

  class MockPagerClient extends MockCloudant<TestResult> {

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

  /**
   * This test sub-class of BasePager implicitly tests that various abstract methods are correctly
   * called by non-abstract methods in the BasePager.
   */
  class TestPager extends BasePager<Builder, PostViewOptions, TestResult, Integer> {

    protected TestPager(Cloudant client, PostViewOptions options) {
      super(client, options);
    }
    
    Cloudant getClient() {
      return this.client;
    }

    /**
     * Implicitly tests that limit gets applied per page, otherwise the default would
     * be used and page counts would be wrong.
     */
    @Override
    protected Function<PostViewOptions, Builder> optionsToBuilderFunction() {
      return o -> {
        return BasePagerTest.getRequiredTestOptionsBuilder();
      };
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
     * These tests don't actually use the options, but we set a key
     * so we can validate calls to setNextPageOptions.
     */
    @Override
    protected void setNextPageOptions(Builder builder, TestResult result) {
      List<Integer> rows = result.getRows();
      if (rows.isEmpty()) {
        throw new IllegalStateException("Test failure: tried to setNextPageOptions on empty page.");
      } else {
        Integer i = rows.get(rows.size() - 1);
        builder.key(i);
      }
    }

    /**
     * Delegates to our next mock.
     * If the BasePager didn't correctly call this the mocks wouldn't work.
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

  private PostViewOptions getDefaultTestOptions(int limit) {
    return getRequiredTestOptionsBuilder()
      .limit(limit)
      .build();
  }

  private static Builder getRequiredTestOptionsBuilder() {
    return new Builder()
      .db("example-database")
      .ddoc("test-ddoc")
      .view("test-view");
  }

  // test constructor
  @Test
  void testConstructor() {
    TestPager pager = new TestPager(mockClient, getDefaultTestOptions(42));
    // Assert the client
    Assert.assertEquals(pager.getClient(), mockClient, "The client should be the supplied one.");
  }

  // test page size limit
  @Test
  void testDefaultPageSize() {
    TestPager pager = new TestPager(mockClient, getRequiredTestOptionsBuilder().build());
    // Assert the default page size
    Assert.assertEquals(pager.pageSize, 20, "The page size should be the default.");
  }

  // test page size default
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
    pager.getNext();
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
    pager.getNext();
    // hasNext should return false because results size smaller than limit
    Assert.assertEquals(pager.hasNext(), false, "hasNext() should return false.");
  }

  // test getNext
  @Test
  void testGetNextFirstPage() {
    int pageSize = 25;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.getNext();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0), "The actual page should match the expected page.");
  }

  @Test
  void testGetNextTwoPages() {
    int pageSize = 3;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(2*pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should return true.");
    List<Integer> actualPage1 = pager.getNext();
    // Assert pages
    Assert.assertEquals(actualPage1, pageSupplier.pages.get(0), "The actual page should match the expected page.");
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should return true.");
    List<Integer> actualPage2 = pager.getNext();
    Assert.assertEquals(actualPage2, pageSupplier.pages.get(1), "The actual page should match the expected page.");
    Assert.assertEquals(pager.hasNext(), true, "hasNext() should return true.");
  }

  @Test
  void testGetNextUntilEmpty() {
    int pageSize = 3;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(10, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualItems = new ArrayList<>();
    int pageCount = 0;
    while(pager.hasNext()) {
      pageCount++;
      List<Integer> page = pager.getNext();
      actualItems.addAll(page);
      // Assert each page is the same or smaller than the limit
      // to make sure we aren't getting all the results in a single page
      Assert.assertTrue(page.size() <= pageSize, "The page should be smaller or equal to the page size.");
    }
    Assert.assertEquals(actualItems, pageSupplier.allItems, "The results should match all the pages.");
    Assert.assertEquals(pageCount, pageSupplier.pages.size(), "There should have been the correct number of pages.");
  }

  @Test
  void testGetNextException() {
    int pageSize = 2;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(pageSize - 1, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.getNext();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0), "The actual page should match the expected page.");
    // hasNext false
    Assert.assertEquals(pager.hasNext(), false, "hasNext() should return false.");
    // getNext throws
    Assert.assertThrows(NoSuchElementException.class, () -> {
      pager.getNext();
    });
  }

  // test getAll
  @Test
  void testGetAll() {
    int pageSize = 11;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(71, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualItems = pager.getAll();
    Assert.assertEquals(actualItems, pageSupplier.allItems, "The results should match all the pages.");
  }

  // test next
  @Test
  void testNextFirstPage() {
    int pageSize = 7;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(2*pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.next();
    // Assert first page
    Assert.assertEquals(actualPage, pageSupplier.pages.get(0), "The actual page should match the expected page.");
  }

  // test iterator
  @Test
  void testIterator() {
    int pageSize = 23;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(3*pageSize - 1, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    Assert.assertNotNull(pager.iterator(), "The iterator should not be null.");
    // Check pager is Iterable
    Iterator<List<Integer>> expectedPages = pageSupplier.pages.iterator();
    for (List<Integer> page : pager) {
      Assert.assertEquals(page, expectedPages.next());
    }
  }

  // test spliterator
  @Test
  void testSpliterator() {
    int pageSize = 23;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(3*pageSize - 1, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    Spliterator<List<Integer>> s = pager.spliterator();
    Assert.assertNotNull(s, "The spliterator should not be null.");
    Assert.assertTrue(s.hasCharacteristics(Spliterator.ORDERED), "The spliterator should be ordered.");
    Assert.assertTrue(s.hasCharacteristics(Spliterator.NONNULL), "The spliterator should be nonnull.");
    Assert.assertTrue(s.hasCharacteristics(Spliterator.IMMUTABLE), "The spliterator should be immutable.");
  }

  @Test
  void testPagesAreImmutable() {
    int pageSize = 1;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    List<Integer> actualPage = pager.getNext();
    // Assert immutable
    Assert.assertThrows( UnsupportedOperationException.class, () -> {
      actualPage.add(17);
    });
  }

  //test setNextPageOptions
  @Test
  void testSetNextPageOptions() {
    int pageSize = 1;
    PageSupplier pageSupplier = PageSupplier.makePageSupplier(5*pageSize, pageSize);
    MockPagerClient c = new MockPagerClient(pageSupplier);
    TestPager pager = new TestPager(c, getDefaultTestOptions(pageSize));
    Assert.assertNull(pager.nextPageOptions.key(), "key should initially be null.");
    // Since we use a page size of 1, each next page options key, is the same as the element from the page
    int page = 0;
    while(pager.hasNext()) {
      pager.getNext();
      if (pager.hasNext()) {
        Assert.assertEquals(pager.nextPageOptions.key(), page, "The key should increment per page.");
      } else {
        // Options don't change for last page
        Assert.assertEquals(pager.nextPageOptions.key(), page - 1, "The options should not be set for the final page.");
      }
      page++;
    }
  }

}
