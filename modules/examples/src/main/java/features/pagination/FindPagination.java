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
package features.pagination;

import java.util.Collections;
import java.util.List;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;
import com.ibm.cloud.cloudant.features.pagination.Pager;
import com.ibm.cloud.cloudant.features.pagination.Pagination;

public class FindPagination {

  public static void main(String[] args) {

    // Initialize service
    Cloudant service = Cloudant.newInstance();

    // Setup options
    PostFindOptions options = new PostFindOptions.Builder()
      .db("shoppers") // Database name
      .limit(50) // limit option sets the page size
      .fields(List.of("_id", "type", "name", "email")) // return these fields
      .selector(Collections.singletonMap("email_verified", "true")) // select docs with verified emails
      .sort(Collections.singletonList(Collections.singletonMap("email", "desc"))) // sort descending by email
      .build();

    // Create pagination
    Pagination<PostFindOptions, Document> pagination = Pagination.newPagination(service, options);
    // pagination can be reused without side-effects as a factory for iterables, streams or pagers
    // options are fixed at pagination creation time

    // Option: iterate pages
    // Ideal for using an enhanced for loop with each page.
    // The Iterable returned from pages() is reusable in that
    // calling iterator() returns a new iterator each time.
    // The returned iterators, however, are single use.
    for (List<Document> page : pagination.pages()) {
      // Do something with page
    }

    // Option: stream pages
    // Ideal for lazy functional processing of pages and total page limits
    pagination.pageStream() // a new stream of the pages
      .limit(20) // use Java stream limit to get only the first 20 pages (different from 50 limit used for page size)
      .forEach(page -> {  // stream operations e.g. terminal forEach
        // Do something with page
      });

    // Option: iterate rows
    // Ideal for using an enhanced for loop with each row.
    // The Iterable returned from rows() is reusable in that
    // calling iterator() returns a new iterator each time.
    // The returned iterators, however, are single use.
    for (Document row : pagination.rows()) {
      // Do something with row
    }

    // Option: stream rows
    // Ideal for lazy functional processing of rows and total row limits
    pagination.rowStream() // a new stream of the rows
      .limit(1000) // use Java stream limit to cap at 1000 rows (20 page requests of 50 rows each in this example)
      .forEach(row -> {  // stream operations e.g. terminal forEach
        // Do something with row
      });

    // Option: use pager next page
    // For retrieving one page at a time with a method call.
    Pager<Document> pagePager = pagination.pager();
    if (pagePager.hasNext()) {
      List<Document> page = pagePager.getNext();
      // Do something with page
    }

    // Option: use pager all results
    // For retrieving all result rows in a single list
    // Note: all result rows may be very large!
    // Preferably use streams/iterables instead of getAll for memory efficiency with large result sets.
    Pager<Document> allPager = pagination.pager();
    List<Document> allRows = allPager.getAll();
    for (Document row : allRows) {
      // Do something with row
    }

  }

}
