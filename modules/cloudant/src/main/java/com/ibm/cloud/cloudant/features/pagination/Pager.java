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

import java.util.List;
import java.util.stream.Stream;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocsResultRow;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
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
 * Interface for pagination of database operations.
 *
 * Use the static methods to instantiate a Pager instance for
 * the required operation.
 *
 * @param <I> the item type of the page rows
 */
public interface Pager<I> extends Iterable<List<I>> {

  /**
   * Returns {@code true} if there may be another page.
   *
   * @return {@code false} if there are no more pages
   */
  boolean hasNext();

  /**
   * Get the next page in the sequence.
   *
   * @return java.util.List of the rows from the next page
   */
  List<I> getNext();

  /**
   * Get all the avaialble pages and collect them into a
   * single java.util.List. This operation is not lazy and
   * may consume significant memory to hold the entire
   * results collection for large queries.
   *
   * @return java.util.List of the rows from all the pages
   */
  List<I> getAll();

  /**
   * Stream all the rows from all the available pages one at
   * a time. This operation is lazy and requests pages as
   * needed.
   *
   * @return java.util.Stream of the rows from all the pages
   */
  Stream<I> getRows();

  /**
   * Get a Pager for the postAllDocs operation.
   * The page size is configured with the limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions for the query
   * @return a pager for all the documents in the database
   */
  static Pager<DocsResultRow> newPager(Cloudant client, PostAllDocsOptions options) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

  /**
   * Get a Pager for the postPartitionAllDocs operation.
   * The page size is configured with the limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions for the query
   * @return a pager for all the documents in a database partition
   */
  static Pager<DocsResultRow> newPager(Cloudant client, PostPartitionAllDocsOptions options) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

  /**
   * Get a Pager for the postFind operation.
   * The page size is configured with the limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostFindOptions for the query
   * @return a pager for the result of a find query
   */
  static Pager<Document> newPager(Cloudant client, PostFindOptions options) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

  /**
   * Get a Pager for the postPartitionFind operation.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions for the query
   * @return a pager for the result of a partition find query
   */
  static Pager<Document> newPager(Cloudant client, PostPartitionFindOptions options) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

  /**
   * Get a Pager for the postSearch operation.
   * The page size is configured with the limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostSearchOptions for the query
   * @return a pager for the result of a search query
   */
  static Pager<SearchResultRow> newPager(Cloudant client, PostSearchOptions options) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

  /**
   * Get a Pager for the postPartitionSearch operation.
   * The page size is configured with the limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions for the query
   * @return a pager for the result of a partition search query
   */
  static Pager<SearchResultRow> newPager(Cloudant client, PostPartitionSearchOptions options) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

  /**
   * Get a Pager for the postView operation.
   * The page size is configured with the limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostViewOptions for the query
   * @return a pager for the result of a view query
   */
  static Pager<ViewResultRow> newPager(Cloudant client, PostViewOptions options) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

  /**
   * Get a Pager for the postPartitionView operation.
   * The page size is configured with the limit paramater of the options.
   *
   * @param client com.ibm.cloud.cloudant.v1.Cloudant instance to make page requests
   * @param options com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions for the query
   * @return a pager for the result of a partition view query
   */
  static Pager<ViewResultRow> newPager(Cloudant client, PostPartitionViewOptions options) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

}
