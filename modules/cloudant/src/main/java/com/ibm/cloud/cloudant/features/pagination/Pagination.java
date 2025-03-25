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

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocsResultRow;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.SearchResultRow;
import com.ibm.cloud.cloudant.v1.model.ViewResultRow;

/**
 * {@link Pagination} is the entry point for pagination features.
 *
 * Use the static methods to create new {@link Pagination} instances. The instances in turn can be
 * used to create:
 * <UL>
 * <LI>{@link Stream} of result rows via {@link #rowStream()}
 * <LI>{@link Stream} of pages via {@link #pageStream()}
 * <LI>{@link Iterator}s of result rows via the {@link Iterable} {@link #rows()}
 * <LI>{@link Iterator}s of pages via the {@link Iterable}{@link #pages()}
 * <LI>IBM Cloud SDK style {@link Pager}s via {@link #pager()}
 * </UL>
 *
 * @param <O> the type of the options object used to configure the operation.
 * @param <I> the reslt row type of the operation.
 */
public class Pagination<O, I> {

  private final Cloudant client;
  private final O opts;
  private final BiFunction<Cloudant, O, BasePageIterator<?, O, ?, I>> iteratorCtor;
  private final Iterable<List<I>> pageIterable = new PageIterable();
  private final Iterable<I> rowIterable = new RowIterable();

  Pagination(Cloudant client, O opts, BiFunction<Cloudant, O, BasePageIterator<?, O, ?, I>> iteratorCtor) {
    this.client = client;
    this.opts = opts;
    this.iteratorCtor = iteratorCtor;
  }

  private final class PageIterable implements Iterable<List<I>> {

    /**
     * Makes a new lazy {@link Iterator} over the operation result pages as defined by the options.
     *
     * @return new {@link Iterator} over the pages
     */
    @Override
    public Iterator<List<I>> iterator() {
      return Pagination.this.iteratorCtor.apply(Pagination.this.client, Pagination.this.opts);
    }

    /**
     * Makes a new lazy {@link Spliterator.ORDERED} {@link Spliterator.NONNULL}
     * {@link Spliterator.IMMUTABLE} {@link Spliterator} over the operation result pages as defined
     * by the options.
     *
     * @return new {@link Spliterator} over the pages
     */
    @Override
    public Spliterator<List<I>> spliterator() {
      return Spliterators.spliteratorUnknownSize(this.iterator(),
          Spliterator.ORDERED | Spliterator.NONNULL | Spliterator.IMMUTABLE);
    }
  }

  private final class RowIterable implements Iterable<I> {

    /**
     * Makes a new lazy (page at a time) {@link Iterator} over the operation result rows from all
     * the pages as defined by the options.
     *
     * @return new {@link Iterator} over the result rows
     */
    @Override
    public Iterator<I> iterator() {
      return Pagination.this.rowStream().iterator();
    }
  }

  /**
   * Get a new IBM Cloud SDK style Pager for the operation.
   *
   * This type is useful for retrieving one page at a time through a function call.
   *
   * @return a new IBM Cloud SDK style Pager
   */
  public Pager<I> pager() {
    return new IteratorPager<O, I>(this.pages());
  }

  /**
   * Get an Iterable for all the pages.
   *
   * This method is useful for handling pages in an enhanced for loop e.g. {@code
   * for (List<AllDocsResultRow> page : Pagination.newPagination(client, allDocsOptions).pages()) {
   * } }
   *
   * @return an {@link Iterable} over all the pages
   */
  public Iterable<List<I>> pages() {
    return this.pageIterable;
  }

  /**
   * Get a page by page stream of all the pages.
   *
   * @return a {@link Stream} of all the pages
   */
  public Stream<List<I>> pageStream() {
    return StreamSupport.stream(this.pages().spliterator(), false);
  }

  /**
   * Get an Iterable for all the rows from all the pages.
   *
   * This type is useful for handling rows in an enhanced for loop e.g. {@code
   * for (AllDocsResultRow row : Pagination.newPagination(client, allDocsOptions).rows()) { } }
   *
   * @return an {@link Iterable} over all the result rows
   */
  public Iterable<I> rows() {
    return this.rowIterable;
  }

  /**
   * Get a row by row stream of all the rows from all the pages.
   *
   * @return a {@link Stream} of all the result rows
   */
  public Stream<I> rowStream() {
    return this.pageStream().flatMap(List::stream);
  }

  /**
   * Get a Pagination for the postAllDocs operation. The page size is configured with the limit
   * paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions for the query
   * @return a Pagination for all the documents in the database
   */
  public static Pagination<PostAllDocsOptions, DocsResultRow> newPagination(Cloudant client,
      PostAllDocsOptions options) {
    return new Pagination<PostAllDocsOptions, DocsResultRow>(client,
        OptionsHandler.duplicate(options), AllDocsPageIterator::new);
  }

  /**
   * Get a Pagination for the postPartitionAllDocs operation. The page size is configured with the
   * limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions for the query
   * @return a Pagination for all the documents in a database partition
   */
  public static Pagination<PostPartitionAllDocsOptions, DocsResultRow> newPagination(
      Cloudant client, PostPartitionAllDocsOptions options) {
    return new Pagination<PostPartitionAllDocsOptions, DocsResultRow>(client,
        OptionsHandler.duplicate(options), AllDocsPartitionPageIterator::new);
  }

  /**
   * Get a Pagination for the postPartitionAllDocs operation. The page size is configured with the
   * limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions for the query
   * @return a Pagination for all the documents in a database partition
   */
  public static Pagination<PostDesignDocsOptions, DocsResultRow> newPagination(
      Cloudant client, PostDesignDocsOptions options) {
    return new Pagination<PostDesignDocsOptions, DocsResultRow>(client,
        OptionsHandler.duplicate(options), DesignDocsPageIterator::new);
  }

  /**
   * Get a Pagination for the postFind operation. The page size is configured with the limit
   * paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostFindOptions for the query
   * @return a Pagination for the result of a find query
   */
  public static Pagination<PostFindOptions, Document> newPagination(Cloudant client,
      PostFindOptions options) {
    return new Pagination<PostFindOptions, Document>(client, OptionsHandler.duplicate(options),
        FindPager::new);
  }

  /**
   * Get a Pagination for the postPartitionFind operation.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions for the query
   * @return a Pagination for the result of a partition find query
   */
  public static Pagination<PostPartitionFindOptions, Document> newPagination(Cloudant client,
      PostPartitionFindOptions options) {
    return new Pagination<PostPartitionFindOptions, Document>(client,
        OptionsHandler.duplicate(options), FindPartitionPager::new);
  }

  /**
   * Get a Pagination for the postSearch operation. The page size is configured with the limit
   * paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostSearchOptions for the query
   * @return a Pagination for the result of a search query
   */
  public static Pagination<PostSearchOptions, SearchResultRow> newPagination(Cloudant client,
      PostSearchOptions options) {
    return new Pagination<PostSearchOptions, SearchResultRow>(client,
        OptionsHandler.duplicate(options), SearchPageIterator::new);
  }

  /**
   * Get a Pagination for the postPartitionSearch operation. The page size is configured with the
   * limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions for the query
   * @return a Pagination for the result of a partition search query
   */
  public static Pagination<PostPartitionSearchOptions, SearchResultRow> newPagination(
      Cloudant client, PostPartitionSearchOptions options) {
    return new Pagination<PostPartitionSearchOptions, SearchResultRow>(client,
        OptionsHandler.duplicate(options), SearchPartitionPageIterator::new);
  }

  /**
   * Get a Pagination for the postView operation. The page size is configured with the limit
   * paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostViewOptions for the query
   * @return a Pagination for the result of a view query
   */
  public static Pagination<PostViewOptions, ViewResultRow> newPagination(Cloudant client,
      PostViewOptions options) {
    return new Pagination<PostViewOptions, ViewResultRow>(client, OptionsHandler.duplicate(options),
        ViewPageIterator::new);
  }

  /**
   * Get a Pagination for the postPartitionView operation. The page size is configured with the
   * limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions for the query
   * @return a Pagination for the result of a partition view query
   */
  public static Pagination<PostPartitionViewOptions, ViewResultRow> newPagination(Cloudant client,
      PostPartitionViewOptions options) {
    return new Pagination<PostPartitionViewOptions, ViewResultRow>(client,
        OptionsHandler.duplicate(options), ViewPartitionPageIterator::new);
  }

}
