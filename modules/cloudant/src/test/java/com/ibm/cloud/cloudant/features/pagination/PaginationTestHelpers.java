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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.annotations.DataProvider;
import com.ibm.cloud.cloudant.features.MockCloudant;
import com.ibm.cloud.cloudant.features.MockCloudant.MockInstruction;
import com.ibm.cloud.cloudant.features.MockCloudant.QueuedSupplier;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.DocsResultRow;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.FindResult;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
import com.ibm.cloud.cloudant.v1.model.SearchResultRow;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
import com.ibm.cloud.cloudant.v1.model.ViewResultRow;
import com.ibm.cloud.sdk.core.http.ServiceCall;

public class PaginationTestHelpers {

  static class MockPagerCloudant<R> extends MockCloudant<R> {

    MockPagerCloudant(Supplier<MockInstruction<R>> instructionSupplier) {
      super(instructionSupplier);
    }

    @Override
    public com.ibm.cloud.sdk.core.http.ServiceCall<AllDocsResult> postAllDocs(
        PostAllDocsOptions postAllDocsOptions) {
      return (ServiceCall<AllDocsResult>) this.testCall();
    }

    @Override
    public com.ibm.cloud.sdk.core.http.ServiceCall<AllDocsResult> postDesignDocs(
        PostDesignDocsOptions postDesignDocsOptions) {
      return (ServiceCall<AllDocsResult>) this.testCall();
    }

    @Override
    public com.ibm.cloud.sdk.core.http.ServiceCall<FindResult> postFind(
        PostFindOptions postFindOptions) {
      return (ServiceCall<FindResult>) this.testCall();
    }

    @Override
    public com.ibm.cloud.sdk.core.http.ServiceCall<AllDocsResult> postPartitionAllDocs(
        PostPartitionAllDocsOptions postPartitionAllDocsOptions) {
      return (ServiceCall<AllDocsResult>) this.testCall();
    }

    @Override
    public com.ibm.cloud.sdk.core.http.ServiceCall<FindResult> postPartitionFind(
        PostPartitionFindOptions postPartitionFindOptions) {
      return (ServiceCall<FindResult>) this.testCall();
    }

    @Override
    public com.ibm.cloud.sdk.core.http.ServiceCall<SearchResult> postPartitionSearch(
        PostPartitionSearchOptions postPartitionSearchOptions) {
      return (ServiceCall<SearchResult>) this.testCall();
    }

    @Override
    public com.ibm.cloud.sdk.core.http.ServiceCall<ViewResult> postPartitionView(
        PostPartitionViewOptions postPartitionViewOptions) {
      return (ServiceCall<ViewResult>) this.testCall();
    }

    @Override
    public com.ibm.cloud.sdk.core.http.ServiceCall<SearchResult> postSearch(
        PostSearchOptions postSearchOptions) {
      return (ServiceCall<SearchResult>) this.testCall();
    }

    @Override
    public com.ibm.cloud.sdk.core.http.ServiceCall<ViewResult> postView(
        PostViewOptions postViewOptions) {
      return (ServiceCall<ViewResult>) this.testCall();
    }

    ServiceCall<R> testCall() {
      return new MockServiceCall(mocks.get());
    }

  }

  static class MockPagerClient extends MockPagerCloudant<TestResult> {
    MockPagerClient(Supplier<MockInstruction<TestResult>> instructionSupplier) {
      super(instructionSupplier);
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

  static class PageSupplierFactory<R, I> {

    final boolean plusOnePaging;
    final Function<List<I>, R> itemsToPageResultFn;
    final Function<Integer, I> integerRowWrapFn;

    PageSupplierFactory(Function<List<I>, R> itemsToPageResultFn,
        Function<Integer, I> integerRowWrapFn) {
      this(itemsToPageResultFn, integerRowWrapFn, false);
    }

    PageSupplierFactory(Function<List<I>, R> itemsToPageResultFn,
        Function<Integer, I> integerRowWrapFn, boolean plusOnePaging) {
      this.itemsToPageResultFn = itemsToPageResultFn;
      this.integerRowWrapFn = integerRowWrapFn;
      this.plusOnePaging = plusOnePaging;
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
      List<List<I>> pages = getPages(total, pageSize);
      if (this.plusOnePaging) {
        List<List<I>> responsePages = repageForKeyBased(pages);
        return new PageSupplier<R, I>(this.itemsToPageResultFn, pages, responsePages);
      } else {
        return new PageSupplier<R, I>(this.itemsToPageResultFn, pages);
      }

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
        } catch (IndexOutOfBoundsException e) {
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

    private PageSupplier(Function<List<I>, R> itemsToPageFn, List<List<I>> pages,
        List<List<I>> responsePages) {
      super(responsePages.stream().map(itemsToPageFn).map(MockInstruction::new)
          .collect(Collectors.toList()));
      this.pages = pages;
      this.allItems = this.pages.stream().flatMap(List::stream).collect(Collectors.toList());
    }
  }

  static PageSupplier<TestResult, Integer> newBasePageSupplier(int total, int pageSize) {
    return new PageSupplierFactory<>(TestResult::new, Function.identity()).newPageSupplier(total,
        pageSize);
  }

  static PageSupplier<TestResult, Integer> newKeyPageSupplier(int total, int pageSize) {
    return new PageSupplierFactory<TestResult, Integer>(TestResult::new, Function.identity(), true)
        .newPageSupplier(total, pageSize);
  }

  static PageSupplier<ViewResult, ViewResultRow> newViewPageSupplier(int total, int pageSize) {
    return new PageSupplierFactory<ViewResult, ViewResultRow>(TestViewResult::new,
        TestViewResultRow::new, true).newPageSupplier(total, pageSize);
  }

  static PageSupplier<TestResult, Integer> newPageSupplierFromList(List<List<Integer>> pages) {
    return new PageSupplier<TestResult, Integer>(TestResult::new, pages);
  }

  static PostViewOptions getDefaultTestOptions(int limit) {
    return getRequiredTestOptionsBuilder().limit(limit).build();
  }

  static PostViewOptions.Builder getRequiredTestOptionsBuilder() {
    return new PostViewOptions.Builder().db("example-database").ddoc("test-ddoc").view("test-view");
  }

  static PostFindOptions getDefaultTestFindOptions(int limit) {
    return getRequiredTestFindOptionsBuilder().limit(limit).build();
  }

  static PostFindOptions.Builder getRequiredTestFindOptionsBuilder() {
    return new PostFindOptions.Builder().db("example-database")
        .selector(Collections.singletonMap("testField", "testValue"));
  }

  static final class OptionsWrapper<B, O> {

    static final OptionsWrapper<PostAllDocsOptions.Builder, PostAllDocsOptions> POST_ALL_DOCS =
        new OptionsWrapper<>(OptionsHandler.POST_ALL_DOCS, PostAllDocsOptions.Builder::new);
    static final OptionsWrapper<PostDesignDocsOptions.Builder, PostDesignDocsOptions> POST_DESIGN_DOCS =
        new OptionsWrapper<>(OptionsHandler.POST_DESIGN_DOCS, PostDesignDocsOptions.Builder::new);
    static final OptionsWrapper<PostFindOptions.Builder, PostFindOptions> POST_FIND =
        new OptionsWrapper<>(OptionsHandler.POST_FIND, PostFindOptions.Builder::new);
    static final OptionsWrapper<PostPartitionAllDocsOptions.Builder, PostPartitionAllDocsOptions> POST_PARTITION_ALL_DOCS =
        new OptionsWrapper<>(OptionsHandler.POST_PARTITION_ALL_DOCS,
            PostPartitionAllDocsOptions.Builder::new);
    static final OptionsWrapper<PostPartitionFindOptions.Builder, PostPartitionFindOptions> POST_PARTITION_FIND =
        new OptionsWrapper<>(OptionsHandler.POST_PARTITION_FIND,
            PostPartitionFindOptions.Builder::new);
    static final OptionsWrapper<PostPartitionSearchOptions.Builder, PostPartitionSearchOptions> POST_PARTITION_SEARCH =
        new OptionsWrapper<>(OptionsHandler.POST_PARTITION_SEARCH,
            PostPartitionSearchOptions.Builder::new);
    static final OptionsWrapper<PostPartitionViewOptions.Builder, PostPartitionViewOptions> POST_PARTITION_VIEW =
        new OptionsWrapper<>(OptionsHandler.POST_PARTITION_VIEW,
            PostPartitionViewOptions.Builder::new);
    static final OptionsWrapper<PostSearchOptions.Builder, PostSearchOptions> POST_SEARCH =
        new OptionsWrapper<>(OptionsHandler.POST_SEARCH, PostSearchOptions.Builder::new);
    static final OptionsWrapper<PostViewOptions.Builder, PostViewOptions> POST_VIEW =
        new OptionsWrapper<>(OptionsHandler.POST_VIEW, PostViewOptions.Builder::new);

    private final OptionsHandler<B, O> handler;
    private final Supplier<B> builderSupplier;

    OptionsWrapper(OptionsHandler<B, O> handler, Supplier<B> builderSupplier) {
      this.handler = handler;
      this.builderSupplier = builderSupplier;
    }

    OptionsProvider<B, O> newProvider() {
      return new OptionsProvider<B, O>(this.handler, this.builderSupplier.get());
    }

  }

  static final class OptionsProvider<B, O> {

    final OptionsHandler<B, O> handler;
    private final B builder;

    OptionsProvider(OptionsHandler<B, O> handler, B builder) {
      this.handler = handler;
      this.builder = builder;
    }

    void setRequiredOpts() throws Exception {
      // database is always required
      this.set("db", "testdb");

      // For partitioned operations we need
      // partitionKey
      if (OptionsHandler.POST_PARTITION_ALL_DOCS.equals(handler)
          || OptionsHandler.POST_PARTITION_FIND.equals(handler)
          || OptionsHandler.POST_PARTITION_SEARCH.equals(handler)
          || OptionsHandler.POST_PARTITION_VIEW.equals(handler)) {
        this.set("partitionKey", "testpart");
      }

      // For find operations we need
      // selector
      if (OptionsHandler.POST_FIND.equals(handler)
          || OptionsHandler.POST_PARTITION_FIND.equals(handler)) {
        Map<String, Object> selector = Collections.emptyMap();
        this.set("selector", selector);
      }

      // For search operations we need
      // ddoc
      // index
      // query
      if (OptionsHandler.POST_PARTITION_SEARCH.equals(handler)
          || OptionsHandler.POST_SEARCH.equals(handler)) {
        this.set("ddoc", "testddoc");
        this.set("index", "testsearchindex");
        this.set("query", "*:*");
      }

      // For view operations we need
      // ddoc
      // view
      if (OptionsHandler.POST_PARTITION_VIEW.equals(handler)
          || OptionsHandler.POST_VIEW.equals(handler)) {
        this.set("ddoc", "testddoc");
        this.set("view", "testview");
      }
    }

    void set(String name, Object... values) throws Exception {
      List<Class<?>> argTypes = Arrays.asList(values).stream().map(a -> {
        Class<?> c = a.getClass();
        if (List.class.isAssignableFrom(c)) {
          c = List.class;
        }
        if (Long.class.equals(c)) {
          c = long.class;
        }
        if (Map.class.isAssignableFrom(c)) {
          c = Map.class;
        }
        return c;
      }).collect(Collectors.toList());
      Class<?>[] argTypesArray = argTypes.toArray(new Class[argTypes.size()]);
      Method method = this.builder.getClass().getMethod(name, argTypesArray);
      method.invoke(this.builder, values);
    }

    O build() {
      return this.handler.optionsFromBuilder(this.builder);
    }

  }

  List<OptionsWrapper<?, ?>> allDocsOptions = List.of(OptionsWrapper.POST_ALL_DOCS,
      OptionsWrapper.POST_DESIGN_DOCS, OptionsWrapper.POST_PARTITION_ALL_DOCS);

  List<OptionsWrapper<?, ?>> viewOptions =
      List.of(OptionsWrapper.POST_PARTITION_VIEW, OptionsWrapper.POST_VIEW);

  List<OptionsWrapper<?, ?>> viewLikeOptions =
      Stream.of(allDocsOptions, viewOptions).flatMap(List::stream).collect(Collectors.toList());

  List<OptionsWrapper<?, ?>> findOptions =
      List.of(OptionsWrapper.POST_FIND, OptionsWrapper.POST_PARTITION_FIND);

  List<OptionsWrapper<?, ?>> searchOptions =
      List.of(OptionsWrapper.POST_PARTITION_SEARCH, OptionsWrapper.POST_SEARCH);

  List<OptionsWrapper<?, ?>> allOptions = Stream.of(findOptions, searchOptions, viewLikeOptions)
      .flatMap(List::stream).collect(Collectors.toList());

  public Iterator<Object[]> getIteratorFor(List<OptionsWrapper<?, ?>> options) {
    return options.stream().map(w -> {
      return new Object[] {w.newProvider()};
    }).iterator();
  }

  @DataProvider(name = "allDocsOptions")
  public Iterator<Object[]> allDocsOptions() {
    return getIteratorFor(allDocsOptions);
  }

  @DataProvider(name = "allOptions")
  public Iterator<Object[]> allOptions() {
    return getIteratorFor(allOptions);
  }

  @DataProvider(name = "findOptions")
  public Iterator<Object[]> findOptions() {
    return getIteratorFor(findOptions);
  }

  @DataProvider(name = "searchOptions")
  public Iterator<Object[]> searchOptions() {
    return getIteratorFor(searchOptions);
  }

  @DataProvider(name = "searchFacetOptions")
  public Iterator<Object[]> facets() {
    List<Object[]> options = new ArrayList<>(5);
    options.add(new Object[] {"counts", Collections.singletonList("aTestFieldToCount")});
    options.add(new Object[] {"groupField", "testField"});
    options.add(new Object[] {"groupLimit", 6L});
    options.add(new Object[] {"groupSort", Collections.singletonList("aTestFieldToGroupSort")});
    options.add(new Object[] {"ranges", Collections.singletonMap("aTestFieldForRanges",
        Map.of("low", "[0 TO 5}", "high", "[5 TO 10]"))});
    return options.iterator();
  }

  @DataProvider(name = "viewLikeOptions")
  public Iterator<Object[]> viewLikeOptions() {
    return getIteratorFor(viewLikeOptions);
  }

  @DataProvider(name = "viewOptions")
  public Iterator<Object[]> viewOptions() {
    return getIteratorFor(viewLikeOptions);
  }

  static class TestDesignDocsResultRow extends DocsResultRow {
    TestDesignDocsResultRow(Integer i) {
      this.id = "_design/testdoc" + String.valueOf(i);
      this.key = this.id;
    }
  }

  static class TestDocsResultRow extends DocsResultRow {
    TestDocsResultRow(Integer i) {
      this.id = "testdoc" + String.valueOf(i);
      this.key = this.id;
    }
  }

  static class TestAllDocsResult extends AllDocsResult {
    TestAllDocsResult(List<DocsResultRow> rows) {
      this.rows = rows;
    }
  }

  static class TestFindDocument extends Document {

    TestFindDocument() {
      super();
    }

    TestFindDocument(Integer i) {
      super();
      this.id = "testdoc" + String.valueOf(i);
    }
  }

  static class TestFindResult extends FindResult {
    TestFindResult(List<Document> rows) {
      this.docs = rows;
    }
  }

  static class TestSearchResultRow extends SearchResultRow {
    TestSearchResultRow(Integer i) {
      this.id = "testdoc" + String.valueOf(i);
    }
  }

  static class TestSearchResult extends SearchResult {
    TestSearchResult(List<SearchResultRow> rows) {
      this.rows = rows;
    }
  }

  static class TestViewResultRow extends ViewResultRow {
    TestViewResultRow(Integer i) {
      this.id = "testdoc" + String.valueOf(i);
      this.key = i;
    }
  }

  static class TestViewResult extends ViewResult {
    TestViewResult(List<ViewResultRow> rows) {
      this.rows = rows;
    }
  }

}
