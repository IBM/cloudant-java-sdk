# Limitations, Restrictions, and Known Issues

## All Cloudant SDKs

### Path elements containing the `+` character

Path elements containing the `+` character in the SDKs are not interoperable with:
* Cloudant 
* Apache CouchDB versions older than 3.2.0
* Apache CouchDB versions 3.2.0 or newer with the setting `decode_plus_to_space = true`

This is because standard URL encoding libraries following the [RFC3986 URI specification](https://tools.ietf.org/html/rfc3986#section-3.3) do not encode the `+` character in path elements.
* It is possible to workaround for document names with a `+` in the ID (e.g. `docidwith+char`) by using:
    * For reading: use the `post` all docs operation and the `key` or `keys` parameter with a value of the document ID including the `+`.
    * For writing: use the `post` document operation or `post` bulk docs operation with the value of the document ID including the `+`.
* There is no pre-encoding workaround because the result is a double encoding e.g. using `%2b` in the path element ends up being double encoded as `%252b`.

### Views

#### Objects as keys

Using JSON objects as keys (e.g. `start_key`, `end_key`, `key`, `keys`)
can cause inconsistent results because the ordering of the members of the JSON
object after serialization is not guaranteed.

### Documents

#### Attachments

The `atts_since` parameter is not supported when retrieving a document.
The workaround is to call `POST /{db}/_bulk_get` using the `atts_since` field under the `docs` request body. See the [alternative example request for `atts_since` using the `/_bulk_get` endpoint](https://cloud.ibm.com/apidocs/cloudant#postbulkget) in our API Docs.
Example JSON request body:
```json
{
  "docs": [{"id": "order00058", "atts_since": "1-99b02e08da151943c2dcb40090160bb8"}]
}
```

#### Open revisions

The `open_revs` parameter is not supported when retrieving a document.
If you want to retrieve documents with all leaf revisions (`open_revs=all`), the workaround is to call `POST /{db}/_bulk_get` using the `id` field within the `docs` array request body.
See the [alternative example request for `open_revs=all` using the `/_bulk_get` endpoint](https://cloud.ibm.com/apidocs/cloudant#postbulkget) in our API Docs.
Example JSON request body:
```json
{
  "docs": [{"id": "order00067"}]
}
```

If you want to retrieve documents of specified leaf revisions (e.g. `open_revs=["3-917fa2381192822767f010b95b45325b", "4-a5be949eeb7296747cc271766e9a498b"]`), the workaround is to call `POST /{db}/_bulk_get` using the same `id` value for each unique `rev` value within of the `docs` array request body.
See the [default example request using the `/_bulk_get` endpoint](https://cloud.ibm.com/apidocs/cloudant#postbulkget) in our API Docs.
Example JSON request body:
```json
{
  "docs": [
    {
      "id": "order00067",
      "rev": "3-917fa2381192822767f010b95b45325b"
    },
    {
      "id": "order00067",
      "rev": "4-a5be949eeb7296747cc271766e9a498b"
    }
  ]
}
```

### Compression

* Manually setting an `Accept-Encoding` header on requests will disable the transparent gzip decompression of response bodies from the server.
* Manually setting a `Content-Encoding` header on requests will disable the transparent gzip compression of request bodies to the server.

### Changes feed

#### Filter functions

The SDK does not support passing user-defined query or body parameters in `_changes` requests for dynamic filter functions in design documents. 
The workaround and recommended option is to use a `selector` type filter.
For example, if you are using a `_changes` request like `/{db}/_changes?filter=myDdoc/byName&name=Jane` with a filter function like:
```javascript
function(doc, req) {
    if (doc.name !== req.query.name) {
        return false;
    }
    return true; 
}
```
It can be replaced with a request using a selector filter:
```java
Cloudant service = Cloudant.newInstance();

PostChangesOptions changesOptions = new PostChangesOptions.Builder()
        .db("example")
        .filter("_selector")
        .selector(Collections.singletonMap("name", "Jane"))
        .build();

ChangesResult response =
        service.postChanges(changesOptions).execute()
                .getResult();
```


## Cloudant SDK for Java
<!-- KNOWN_ISSUES specific to Java -->
### Search
#### Analyzer definitions should be in object format

In order to be able to deserialize a design document with a search index analyzer into the model
object the analyzer must be stored in the design document described in object format, not a string format e.g.
  ```json
  {
    "analyzer": {
      "name": "keyword"
    }
  }
  ```
  not
  ```json
  {
    "analyzer": "keyword"
  }
  ```
Note that analyzers created using the Java SDK object models will use the object format.
As such the issue will only manifest when trying to read a design document created from another source with this exception:
  ```
  Expected BEGIN_OBJECT but was STRING
  ```

#### Facet counting deserialization errors in no match cases

In Apache CouchDB versions `3.3.2` or older and Cloudant versions `8435` and older
when obtaining a `SearchResult` with `counts` if there are no matches a deserialization error is encountered:
```
java.lang.IllegalStateException: Expected BEGIN_OBJECT but was NUMBER
```

The workaround is to use [Raw IO](/#raw-io) functions to custom deserialize the response.

See [issue #211](https://github.com/IBM/cloudant-java-sdk/issues/211).

### Changes
#### Cannot automatically use the server default heartbeat interval

* It is not possible to specify `heartbeat=true` to use the server side default heartbeat interval. The workaround is to specify a numerical heartbeat interval.

### Optional booleans

Methods named `is*` may return a `Boolean` that can be `null` when the member is omitted from a response.
An example is `Document#isDeleted()`. As such using a method reference like `Document::isDeleted` can
result in a `NullPointerException`. A workaround is to wrap the method call in an `Optional` e.g.
```
Optional.ofNullable(doc.isDeleted()).orElse(false);
```

See [issue #152](https://github.com/IBM/cloudant-java-sdk/issues/152).

### Disabling request body compression

Some issues with older server versions can be worked around by disabling
compression of request bodies. This is an example of how to do that.

```java
import com.ibm.cloud.cloudant.v1.Cloudant;

Cloudant client = Cloudant.newInstance("YOUR_SERVICE_NAME");
client.enableGzipCompression(false);
...
```

### Replication Documents

In order to be able to deserialize a replication document into the model
object the source and target databases must be stored in an object format, not a string format e.g.

  ```json
  {
    "source": {
      "url": "https://<SERVICE_URL>/animaldb",
      "auth" : {
        "basic": {
          "username": "<SERVICE_USERNAME>",
          "password": "<SERVICE_PASSWORD>"
        }
      }
    },
    "target": {
      "url": "https://<TARGET_SERVICE_URL>/animaldb-target",
      "auth" : {
        "basic": {
          "username": "<TARGET_SERVICE_USERNAME>",
          "password": "<TARGET_SERVICE_PASSWORD>"
        }
      }
    }
  }
  ```
  not
  ```json
  {
    "source": "https://<SERVICE_USERNAME>:<SERVICE_PASSWORD>@<SERVICE_URL>",
    "target": "https://<TARGET_SERVICE_USERNAME>:<TARGET_SERVICE_PASSWORD>@<TARGET_SERVICE_URL>"
  }
  ```
Note that replication documents created using the Java SDK object models will use the object format.
As such the issue will only manifest when trying to read a replication document created from another source with this exception:
  ```sh
  java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING
  ```

If you need to read a replication document that uses string format source or target URLs the workaround is to use the `getDocumentAsStream` [Raw IO](/#raw-io) function with the `_replicator` database name and your replication document id to custom deserialize the response.

### Queries

#### Explain response

With Apache CouchDB versions `3.3.2` or older and Cloudant versions `8442` and older
deserialization of the `_explain` response fails when the request does not
list any `fields` to project and hence the response includes `"fields": "all_fields"`.

If it is not possible to use a newer server version the workaround is to use
[Raw IO](/#raw-io) functions to custom deserialize the response.

### Design documents

#### Query language design documents

The type of the `map` function for `views` differs between design documents with `"language":"javascript"` (`map` function is a string) and `"language":"query"` (`map` function is an object).

The SDK model for a design document expects a `javascript` design document and the [`getDesignDocument` operation](https://cloud.ibm.com/apidocs/cloudant?code=java#getdesigndocument) fails for a `query` design document with an error such as `com.ibm.cloud.sdk.core.service.exception.InvalidServiceResponseException: Error processing the HTTP response` `Caused by: com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected a string but was BEGIN_OBJECT at line 1 column 152 path $.views..map`.

In general manage `query` design documents using the `_index` endpoint operations: [`postIndex`](https://cloud.ibm.com/apidocs/cloudant?code=java#postindex), [`deleteIndex`](https://cloud.ibm.com/apidocs/cloudant?code=java#deleteindex), and [`getIndexesInformation`](https://cloud.ibm.com/apidocs/cloudant?code=java#getindexesinformation). However, if you must retrieve the content of a `query` design document workaround the error by using the [`postDesignDocs` operation](https://cloud.ibm.com/apidocs/cloudant?code=java#postdesigndocs) with the `includeDocs` parameter and the `key` parameter to limit the response to a single specific design document. If a completely raw response is preferred then instead use the [`postAllDocsAsStream operation`](https://cloud.ibm.com/apidocs/cloudant?code=java#postalldocs).
