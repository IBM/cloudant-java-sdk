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

/**
 * Interface for pagination of database operations.
 *
 * Use the static methods to instantiate a Pager instance for
 * the required operation.
 *
 * @param <I> the item type of the page rows
 */
public interface Pager<I> {

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

}
