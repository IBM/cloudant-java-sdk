# Pagination

<details open>
<summary>Table of Contents</summary>

<!-- toc -->
- [Introduction](#introduction)
- [Limitations](#limitations)
- [Capacity considerations](#capacity-considerations)
- [Available operations](#available-operations)
- [Creating a pagination](#creating-a-pagination)
  * [Initialize the service](#initialize-the-service)
  * [Set the options](#set-the-options)
  * [Create the pagination](#create-the-pagination)
- [Using pagination](#using-pagination)
  - [Stream pages](#stream-pages)
  - [Stream rows](#stream-rows)
  * [Iterate pages](#iterate-pages)
  * [Iterate rows](#iterate-rows)
  * [Pager](#pager)
    + [Get each page from a pager](#get-each-page-from-a-pager)
    + [Get all results from a pager](#get-all-results-from-a-pager)
</details>

## Introduction

The pagination feature (currently beta) accepts options for a single operation and automatically
creates the multiple requests to the server necessary to page through the results a fixed number at a time.

Pagination is a best-practice to break apart large queries into multiple server requests.
This has a number of advantages:
* Keeping requests within server imposed limits, for example
  * `200` max results for text search
  * `2000` max results for partitioned queries
* Fetching only the necessary data, for example
  * User finds required result on first page, no need to continue fetching results
* Reducing the duration of any individual query
  * Reduce risk of query timing out on the server
  * Reduce risk of network request timeouts

## Limitations

Limitations of pagination:
* Forward only, no backwards paging
* Limitations on `_all_docs` and `_design_docs` operations
  * No pagination for `key` option.
    There is no need to paginate as IDs are unique and this returns only a single row.
    This is better achieved with a single document get request.
  * No pagination for `keys` option.
* Limitations on `_view` operations
  * No pagination for `key` option. Pass the same `key` as a start and end key instead.
  * No pagination for `keys` option.
  * Views that emit multiple identical keys (with the same or different values)
    from the same document cannot paginate if those key rows with the same ID
    span a page boundary.
    The pagination feature detects this condition and an error occurs.
    It may be possible to workaround using a different page size.
* Limitations on `_search` operations
  * No pagination of grouped results.
  * No pagination of faceted `counts` or `ranges` results.

## Capacity considerations

Pagination can make many requests rapidly from a single program call.

For IBM Cloudant take care to ensure you have appropriate plan capacity
in place to avoid consuming all the permitted requests.
If there is no remaining plan allowance and retries are not enabled or insufficient
then a `429 Too Many Requests` error occurs.

## Available operations

Pagination is available for these operations:
* Query all documents [global](https://cloud.ibm.com/apidocs/cloudant?code=java#postalldocs)
  and [partitioned](https://cloud.ibm.com/apidocs/cloudant?code=java#postpartitionalldocs)
  * [Global all documents examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/modules/examples/src/main/java/features/pagination/AllDocsPagination.java)
  * [Partitioned all documents examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/modules/examples/src/main/java/features/pagination/PartitionAllDocsPagination.java)
* Query all [design documents](https://cloud.ibm.com/apidocs/cloudant?code=java#postdesigndocs)
  * [Design documents examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/modules/examples/src/main/java/features/pagination/DesignDocsPagination.java)
* Query with selector syntax [global](https://cloud.ibm.com/apidocs/cloudant?code=java#postfind)
  and [partitioned](https://cloud.ibm.com/apidocs/cloudant?code=java#postpartitionfind)
  * [Global find selector query examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/modules/examples/src/main/java/features/pagination/FindPagination.java)
  * [Partitioned find selector query examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/modules/examples/src/main/java/features/pagination/PartitionFindPagination.java)
* Query a search index [global](https://cloud.ibm.com/apidocs/cloudant?code=java#postsearch)
  and [partitioned](https://cloud.ibm.com/apidocs/cloudant?code=java#postpartitionsearch)
  * [Global search examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/modules/examples/src/main/java/features/pagination/SearchPagination.java)
  * [Partitioned search examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/modules/examples/src/main/java/features/pagination/PartitionSearchPagination.java)
* Query a MapReduce view [global](https://cloud.ibm.com/apidocs/cloudant?code=java#postview)
  and [partitioned](https://cloud.ibm.com/apidocs/cloudant?code=java#postpartitionview)
  * [Global view examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/modules/examples/src/main/java/features/pagination/ViewPagination.java)
  * [Partitioned view examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/modules/examples/src/main/java/features/pagination/PartitionViewPagination.java)

The examples presented in this `README` are for all documents in a partition.
The links in the list are to equivalent examples for each of the other available operations.

## Creating a pagination

Make a new pagination from a client
and the options for the chosen operation.
Use the `limit` option to configure the page size (default and maximum `200`).

Imports required for these examples:

<details open>
<summary>Java:</summary>

```java
import java.util.List;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocsResultRow;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
import com.ibm.cloud.cloudant.features.pagination.Pager;
import com.ibm.cloud.cloudant.features.pagination.Pagination;
```

</details>

### Initialize the service

<details open>
<summary>Java:</summary>

```java
// Initialize service
Cloudant service = Cloudant.newInstance();
```

</details>

### Set the options

<details open>
<summary>Java:</summary>

```java
// Setup options
PostPartitionAllDocsOptions options = new PostPartitionAllDocsOptions.Builder()
  .db("events") // example database name
  .limit(50) // limit option sets the page size
  .partitionKey("ns1HJS13AMkK") // query only this partition
  .build();
```

</details>

### Create the pagination

<details open>
<summary>Java:</summary>

```java
// Create pagination
Pagination<PostPartitionAllDocsOptions, DocsResultRow> pagination = Pagination.newPagination(service, options);
// pagination can be reused without side-effects as a factory for iterables, streams or pagers
// options are fixed at pagination creation time
```

</details>

## Using pagination

Once you have a pagination factory there are multiple options available.
* Stream pages
* Stream rows
* Iterate pages
* Iterate rows
* Get each page from a pager
* Get all results from a pager

All the paging styles produce equivalent results and make identical page requests.
The style of paging to choose depends on the use case requirements
in particular whether to process a page at a time or a row at a time.

The pagination factory is reusable and can repeatedly produce new instances
of the same or different pagination styles for the same operation options.

Here are examples for each paging style.

##### Stream pages

Streaming pages is ideal for lazy functional processing of pages
and leveraging Java's built-in stream utilities, for example, to limit the total number of pages.

<details open>
<summary>Java:</summary>

```java
// Option: stream pages
// Ideal for lazy functional processing of pages and total page limits
pagination.pageStream() // a new stream of the pages
  .limit(20) // use Java stream limit to get only the first 20 pages (different from 50 limit used for page size)
  .forEach(page -> {  // stream operations e.g. terminal forEach
    // Do something with page
  });
```

</details>

##### Stream rows

Streaming rows is ideal for lazy functional processing of each result row
and leveraging Java's built-in stream utilities, for example, to limit the total number of results.

<details open>
<summary>Java:</summary>

```java
// Option: stream rows
// Ideal for lazy functional processing of rows and total row limits
pagination.rowStream() // a new stream of the rows
  .limit(1000) // use Java stream limit to cap at 1000 rows (20 page requests of 50 rows each in this example)
  .forEach(row -> {  // stream operations e.g. terminal forEach
    // Do something with row
  });
```

</details>

### Iterate pages

Iterating pages is ideal for using an enhanced for loop to process a page at a time.

<details open>
<summary>Java:</summary>

```java
// Option: iterate pages
// Ideal for using an enhanced for loop with each page.
// The Iterable returned from pages() is reusable in that
// calling iterator() returns a new iterator each time.
// The returned iterators, however, are single use.
for (List<DocsResultRow> page : pagination.pages()) {
  // Do something with page
}
```

</details>

### Iterate rows

Iterating rows is ideal for using an enhanced for loop to process a result row at a time.

<details open>
<summary>Java:</summary>

```java
// Option: iterate rows
// Ideal for using an enhanced for loop with each row.
// The Iterable returned from rows() is reusable in that
// calling iterator() returns a new iterator each time.
// The returned iterators, however, are single use.
for (DocsResultRow row : pagination.rows()) {
  // Do something with row
}
```

</details>

### Pager

The pager style is similar to other [IBM Cloud SDKs](https://github.com/IBM/ibm-cloud-sdk-common?tab=readme-ov-file#pagination).
Users familiar with that style of pagination may find using them preferable
to the native language style iterators.

In the Cloudant SDKs these pagers are single use and traverse the complete set of pages once and only once.
After exhaustion they cannot be re-used, simply create a new one from the pagination factory if needed.

Pagers are only valid for one of either page at a time or getting all results.
For example, calling for the next page then calling for all results causes an error.

#### Get each page from a pager

This is useful for calling to retrieve one page at a time, for example,
in a user interface with a "next page" interaction.

If calling for the next page errors, it is valid to call for the next page again
to continue paging.

<details open>
<summary>Java:</summary>

```java
// Option: use pager next page
// For retrieving one page at a time with a method call.
Pager<DocsResultRow> pagePager = pagination.pager();
if (pagePager.hasNext()) {
  List<DocsResultRow> page = pagePager.getNext();
  // Do something with page
}
```

</details>

#### Get all results from a pager

This is useful to retrieve all results in a single call.
However, this approach requires sufficient memory for the entire collection of results.
So although it may be convenient for small result sets generally prefer iterating pages
or rows with the other paging styles, especially for large result sets.

If calling for all the results errors, then calling for all the results again restarts the pagination.

<details open>
<summary>Java:</summary>

```java
// Option: use pager all results
// For retrieving all result rows in a single list
// Note: all result rows may be very large!
// Preferably use streams/iterables instead of getAll for memory efficiency with large result sets.
Pager<DocsResultRow> allPager = pagination.pager();
List<DocsResultRow> allRows = allPager.getAll();
for (DocsResultRow row : allRows) {
  // Do something with row
}
```

</details>
