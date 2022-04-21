[![Build Status](https://travis-ci.com/IBM/cloudant-java-sdk.svg?branch=master)](https://travis-ci.com/IBM/cloudant-java-sdk)
[![Release](https://img.shields.io/github/v/release/IBM/cloudant-java-sdk?include_prereleases&sort=semver)](https://github.com/IBM/cloudant-java-sdk/releases/latest)
[![Docs](https://img.shields.io/static/v1?label=Javadoc&message=latest&color=blue)](https://ibm.github.io/cloudant-java-sdk/)

# IBM Cloudant Java SDK Version 0.1.1

IBM Cloudant Java SDK is a client library that interacts with the
[IBM Cloudant APIs](https://cloud.ibm.com/apidocs/cloudant?code=java).

Disclaimer: This library is still a 0.x release. We do consider this
library production-ready and capable, but there are still some
limitations we’re working to resolve, and refinements we want to
deliver. We are working really hard to minimise the disruption from
now until the 1.0 release, but there may still be some changes that
impact applications using this SDK. For now, be sure to pin versions
to avoid surprises.

<details>
<summary>Table of Contents</summary>

<!--
  The TOC below is generated using the `markdown-toc` node package.

      https://github.com/jonschlinkert/markdown-toc

      npx markdown-toc -i README.md
  -->

<!-- toc -->

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
  * [Maven](#maven)
  * [Gradle](#gradle)
- [Authentication](#authentication)
  * [Authentication with environment variables](#authentication-with-environment-variables)
    + [IAM authentication](#iam-authentication)
    + [Session cookie authentication](#session-cookie-authentication)
    + [Basic authentication](#basic-authentication)
  * [Authentication with external configuration](#authentication-with-external-configuration)
  * [Programmatic authentication](#programmatic-authentication)
- [Using the SDK](#using-the-sdk)
  * [Request timeout configuration](#request-timeout-configuration)
  * [Code examples](#code-examples)
    + [1. Retrieve information from an existing database](#1-retrieve-information-from-an-existing-database)
    + [2. Create your own database and add a document](#2-create-your-own-database-and-add-a-document)
    + [3. Update your previously created document](#3-update-your-previously-created-document)
    + [4. Delete your previously created document](#4-delete-your-previously-created-document)
  * [Error handling](#error-handling)
  * [Raw IO](#raw-io)
  * [Further resources](#further-resources)
- [Questions](#questions)
- [Issues](#issues)
- [Open source at IBM](#open-source-at-ibm)
- [Contributing](#contributing)
- [License](#license)

<!-- tocstop -->

</details>

## Overview

The IBM Cloudant Java SDK allows developers to programmatically
interact with [IBM Cloudant](https://cloud.ibm.com/apidocs/cloudant)
with the help of the `com.ibm.cloud.cloudant` package.

## Features

The purpose of this Java SDK is to wrap most of the HTTP request APIs
provided by Cloudant and supply other functions to ease the usage of Cloudant.
This SDK should make life easier for programmers to do what’s really important
to them: developing software.

Reasons why you should consider using Cloudant Java SDK in your
project:

- Supported by IBM Cloudant.
- Server compatibility with:
    - IBM Cloudant "Classic".
    - [Cloudant "Standard on Transaction Engine"](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-overview-te) for APIs compatible with Cloudant "Classic". For more information, see the [Feature Parity](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-overview-te#feature-parity-between-ibm-cloudant-on-the-transaction-engine-vs-classic-architecture) page.
    - [Apache CouchDB 3.x](https://docs.couchdb.org/en/stable/) for data operations.
- Includes all the most popular and latest supported endpoints for
  applications.
- Handles the authentication.
- Familiar user experience with IBM Cloud SDKs.
- Flexibility to use either built-in models or byte-based requests and responses for documents.
- HTTP2 support for higher performance connections to IBM Cloudant.
- Perform requests either synchronously or asynchronously.
- Instances of the client are unconditionally thread-safe.
- Transparently compresses request and response bodies.

## Prerequisites

- A
  [Cloudant](https://cloud.ibm.com/docs/Cloudant/getting-started.html#step-1-connect-to-your-cloudant-nosql-db-service-instance-on-ibm-cloud)
  service instance or a
  [CouchDB](https://docs.couchdb.org/en/latest/install/index.html)
  server.
- Java 8, 11.

## Installation

The current version of this SDK is: 0.1.1

The project artifacts are published on the
[Maven Central](https://repo1.maven.org/maven2/com/ibm/cloud/cloudant/). 
This is the default public repository used by *Maven* when searching for dependencies.

To use Maven Central within your *Gradle* build add `mavenCentral()` to the *repositories* in your `build.gradle` file:
```groovy
repositories {
  // other repositories...
  mavenCentral()
}
```

To use the Cloudant Java SDK, define a dependency that contains the
artifact coordinates (group id, artifact id and version) for the service, like this:

### Maven

Extend *Maven dependencies* in your `pom.xml` file with the `cloudant` library.

```xml
<dependencies>
  <!--> other dependencies... </-->
  <dependency>
    <groupId>com.ibm.cloud</groupId>
      <artifactId>cloudant</artifactId>
        <version>0.1.1</version>
  </dependency>
</dependencies>
```

### Gradle

Add the `cloudant` library to the *dependencies* in your `build.gradle` file:

```groovy
dependencies {
    // other dependencies...
    implementation group: "com.ibm.cloud", name: "cloudant", version: "0.1.1"
}
```

## Authentication

[service-credentials]: https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-locating-your-service-credentials
[cloud-IAM-mgmt]: https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-managing-access-for-cloudant#introduction-iam-ai
[couch-cookie-auth]: https://docs.couchdb.org/en/stable/api/server/authn.html#cookie-authentication
[cloudant-cookie-auth]: https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-work-with-your-account#cookie-authentication
[couch-basic-auth]: https://docs.couchdb.org/en/stable/api/server/authn.html#basic-authentication
[cloudant-basic-auth]: https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-work-with-your-account#basic-authentication

This library requires some of your
[Cloudant service credentials][service-credentials] to authenticate with your
account.

1. `IAM`, `COUCHDB_SESSION`, `BASIC` or `NOAUTH` **authentication type**.
    1. [*IAM authentication*](#iam-authentication) is highly recommended when your
    back-end database server is [**Cloudant**][cloud-IAM-mgmt]. This
    authentication type requires a server-generated `apikey` instead of a
    user-given password. You can create one
    [here](https://cloud.ibm.com/iam/apikeys).
    1. [*Session cookie (`COUCHDB_SESSION`) authentication*](#session-cookie-authentication)
    is recommended for [Apache CouchDB][couch-cookie-auth] or for
    [Cloudant][cloudant-cookie-auth] when IAM is unavailable. It exchanges username
    and password credentials for an `AuthSession` cookie from the `/_session`
    endpoint.
    1. [*Basic* (or legacy) *authentication*](#basic-authentication) is a fallback
    for both [Cloudant][cloudant-basic-auth] and [Apache CouchDB][couch-basic-auth]
    back-end database servers. This authentication type requires the good old
    `username` and `password` credentials.
    1. *Noauth* authentication does not require credentials. Note that this
    authentication type only works with queries against a database with read
    access for everyone.
1. The service `url`.

There are several ways to **set** these properties:

1. As [environment variables](#authentication-with-environment-variables)
1. The [programmatic approach](#programmatic-authentication)
1. With an [external credentials file](#authentication-with-external-configuration)

### Authentication with environment variables

#### IAM authentication

For Cloudant *IAM authentication*, set the following environmental variables by
replacing the `<url>` and `<apikey>` with your proper
[service credentials][service-credentials]. There is no need to set
`CLOUDANT_AUTH_TYPE` to `IAM` because it is the default.

```bash
CLOUDANT_URL=<url>
CLOUDANT_APIKEY=<apikey>
```

#### Session cookie authentication

For `COUCHDB_SESSION` authentication, set the following environmental variables
by replacing the `<url>`, `<username>` and `<password>` with your proper
[service credentials][service-credentials].

```bash
CLOUDANT_AUTH_TYPE=COUCHDB_SESSION
CLOUDANT_URL=<url>
CLOUDANT_USERNAME=<username>
CLOUDANT_PASSWORD=<password>
```

#### Basic authentication

For *Basic authentication*, set the following environmental variables by
replacing the `<url>`, `<username>` and `<password>` with your proper
[service credentials][service-credentials].

```bash
CLOUDANT_AUTH_TYPE=BASIC
CLOUDANT_URL=<url>
CLOUDANT_USERNAME=<username>
CLOUDANT_PASSWORD=<password>
```

**Note**: We recommend that you use [IAM](#iam-authentication) for Cloudant and
[Session](#session-cookie-authentication) for CouchDB authentication.

### Authentication with external configuration

To use an external configuration file, the
[Cloudant API docs](https://cloud.ibm.com/apidocs/cloudant?code=java#authentication-with-external-configuration),
or the
[general SDK usage information](https://github.com/IBM/ibm-cloud-sdk-common#using-external-configuration)
will guide you.

### Programmatic authentication

To learn more about how to use programmatic authentication, see the related
documentation in the
[Cloudant API docs](https://cloud.ibm.com/apidocs/cloudant?code=java#programmatic-authentication)
or in the
[Java SDK Core document](https://github.com/IBM/java-sdk-core/blob/master/Authentication.md) about authentication.

## Using the SDK

For fundamental SDK usage information and config options, please see the common [IBM Cloud SDK](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md) documentation. 

### Request timeout configuration

No request timeout is defined, but a 60s connect, a 2.5m read and a 60s write timeout are set by default. Be sure to set a request timeout appropriate to your application usage and environment. 
The [request timeout](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md) section contains details on how to change the value.

**Note:** System settings may take precedence over configured timeout values.

### Code examples

The following code examples
[authenticate with the environment variables](#authenticate-with-environment-variables).

#### 1. Retrieve information from an existing database

**Note:** This example code assumes that `animaldb` database does not exist in your account.

This example code gathers information about an existing database hosted on
the https://examples.cloudant.com/ service `url`. To connect, you must
extend your environment variables with the *service url* and *authentication
type* to use `NOAUTH` authentication while you connect to the `animaldb` database.
This step is necessary for the SDK to distinguish the `EXAMPLES` custom service
name from the default service name which is `CLOUDANT`.

Cloudant environment variable naming starts with a *service name* prefix that identifies your service.
By default this is `CLOUDANT`, see the settings in the
[authentication with environment variables section](#authentication-with-environment-variables).

If you would like to rename your Cloudant service from `CLOUDANT`,
you must use your defined service name as the prefix for all Cloudant related environment variables.
The code block below provides an example of instantiating a user-defined `EXAMPLES` service name.

```bash
EXAMPLES_URL=https://examples.cloudant.com
EXAMPLES_AUTH_TYPE=NOAUTH
```

Once the environment variables are set, you can try out the code examples.

[embedmd]:# (modules/examples/src/main/java/GetInfoFromExistingDatabase.java /import com./ $)
```java
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformation;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.ServerInformation;

public class GetInfoFromExistingDatabase {
    public static void main(String[] args) {
        // 1. Create a Cloudant client with "EXAMPLES" service name ===========
        Cloudant client = Cloudant.newInstance("EXAMPLES");

        // 2. Get server information ==========================================
        ServerInformation serverInformation = client
            .getServerInformation()
            .execute()
            .getResult();

        System.out.println("Server Version: " +
            serverInformation.getVersion());

        // 3. Get database information for "animaldb" =========================
        String dbName = "animaldb";

        GetDatabaseInformationOptions dbInformationOptions =
            new GetDatabaseInformationOptions.Builder(dbName).build();

        DatabaseInformation dbInformationResponse = client
            .getDatabaseInformation(dbInformationOptions)
            .execute()
            .getResult();

        // 4. Show document count in database =================================
        Long documentCount = dbInformationResponse.getDocCount();

        System.out.println("Document count in \"" +
            dbInformationResponse.getDbName() +
            "\" database is " + documentCount +
            ".");

        // 5. Get zebra document out of the database by document id ===========
        GetDocumentOptions getDocOptions = new GetDocumentOptions.Builder()
            .db(dbName)
            .docId("zebra")
            .build();

        Document documentAboutZebra = client
            .getDocument(getDocOptions)
            .execute()
            .getResult();

        System.out.println("Document retrieved from database:\n" +
            documentAboutZebra);
    }
}
```

When you run the code, you see a result similar to the following output.

[embedmd]:# (modules/examples/output/GetInfoFromExistingDatabase.txt)
```txt
Server Version: 2.1.1
Document count in "animaldb" database is 11.
Document retrieved from database:
{
  "_id": "zebra",
  "_rev": "3-750dac460a6cc41e6999f8943b8e603e",
  "max_weight": 387,
  "min_length": 2,
  "diet": "herbivore",
  "min_weight": 175,
  "class": "mammal",
  "wiki_page": "http://en.wikipedia.org/wiki/Plains_zebra",
  "max_length": 2.5
}
```

#### 2. Create your own database and add a document

**Note:** This example code assumes that `orders` database does not exist in your account.

Now comes the exciting part, you create your own `orders` database and add a document about *Bob Smith* with your own [IAM](#iam-authentication) or
[Basic](#basic-authentication) service credentials.

<details>
<summary>Create code example</summary>

[embedmd]:# (modules/examples/src/main/java/CreateDbAndDoc.java /import com./ $)
```java
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PostDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutDatabaseOptions;
// Uncomment import below if using "putDocument" method
// import com.ibm.cloud.cloudant.v1.model.PutDocumentOptions;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

public class CreateDbAndDoc {
    public static void main(String[] args) {
        // 1. Create a client with `CLOUDANT` default service name ============
        Cloudant client = Cloudant.newInstance();

        // 2. Create a database ===============================================
        // Create a database object with "orders" id
        String exampleDbName = "orders";
        PutDatabaseOptions putDbOptions =
            new PutDatabaseOptions.Builder().db(exampleDbName).build();

        // Try to create database if it doesn't exist
        try {
            Ok putDatabaseResult = client
                .putDatabase(putDbOptions)
                .execute()
                .getResult();

            if (putDatabaseResult.isOk()) {
                System.out.println("\"" + exampleDbName +
                    "\" database created.");
            }
        } catch (ServiceResponseException sre) {
            if (sre.getStatusCode() == 412)
                System.out.println("Cannot create \"" + exampleDbName +
                    "\" database, it already exists.");
        }

        // 3. Create a document ===============================================
        // Create a document object with "example" id
        String exampleDocId = "example";
        Document exampleDocument = new Document();

        // Setting id for the document is optional when "postDocument" method is used for CREATE.
        // When id is not provided the server will generate one for your document.
        exampleDocument.setId(exampleDocId);

        // Add "name" and "joined" fields to the document
        exampleDocument.put("name", "Bob Smith");
        exampleDocument.put("joined", "2019-01-24T10:42:59.000Z");

        // Save the document in the database with "postDocument" method
        PostDocumentOptions createDocumentOptions =
            new PostDocumentOptions.Builder()
                .db(exampleDbName)
                .document(exampleDocument)
                .build();

        DocumentResult createDocumentResponse = client
            .postDocument(createDocumentOptions)
            .execute()
            .getResult();

        // ====================================================================
        // Note: saving the document can also be done with the "putDocument"
        // method. In this case `docId` is required for a CREATE operation:
        /*
        PutDocumentOptions createDocumentOptions =
            new PutDocumentOptions.Builder()
                .db(exampleDbName)
                .docId(exampleDocId)
                .document(exampleDocument)
                .build();
        DocumentResult createDocumentResponse = client
            .putDocument(createDocumentOptions)
            .execute()
            .getResult();
        */
        // ====================================================================

        // Keeping track of the revision number of the document object
        // is necessary for further UPDATE/DELETE operations:
        exampleDocument.setRev(createDocumentResponse.getRev());
        System.out.println("You have created the document:\n" +
            exampleDocument);
    }
}
```


</details>
When you run the code, you see a result similar to the following output.

[embedmd]:# (modules/examples/output/CreateDbAndDoc.txt)
```txt
"orders" database created.
You have created the document:
{
  "_id": "example",
  "_rev": "1-1b403633540686aa32d013fda9041a5d",
  "joined": "2019-01-24T10:42:99.000Z",
  "name": "Bob Smith"
}
```

#### 3. Update your previously created document

**Note**: This example code assumes that you have created both the `orders`
database and the `example` document by
[running the previous example code](#2-create-your-own-database-and-add-a-document)
successfully. Otherwise, the following error message occurs, "Cannot update document because either 'orders'
database or 'example' document was not found."

<details>
<summary>Update code example</summary>

[embedmd]:# (modules/examples/src/main/java/UpdateDoc.java /import com./ $)
```java
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PostDocumentOptions;
// Uncomment import below if using "putDocument" method
// import com.ibm.cloud.cloudant.v1.model.PutDocumentOptions;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;

// Uncomment import below if using response byte stream
// import java.io.InputStream;

public class UpdateDoc {
    public static void main(String[] args) {
        // 1. Create a client with `CLOUDANT` default service name ============
        Cloudant client = Cloudant.newInstance();

        // 2. Update the document =============================================
        // Set the options to get the document out of the database if it exists
        String exampleDbName = "orders";
        GetDocumentOptions documentInfoOptions =
            new GetDocumentOptions.Builder()
                .db(exampleDbName)
                .docId("example")
                .build();

        try {
            // Try to get the document if it previously existed in the database
            Document document = client
                .getDocument(documentInfoOptions)
                .execute()
                .getResult();

            // Note: for response byte stream use:
            /*
            InputStream documentAsByteStream =
                client.getDocumentAsStream(documentInfoOptions)
                    .execute()
                    .getResult();
            */

            // Add Bob Smith's address to the document
            document.put("address", "19 Front Street, Darlington, DL5 1TY");

            // Remove the joined property from document object
            document.removeProperty("joined");

            // Update the document in the database
            PostDocumentOptions updateDocumentOptions =
                new PostDocumentOptions.Builder()
                    .db(exampleDbName)
                    .document(document)
                    .build();

            // ================================================================
            // Note: for request byte stream use:
            /*
            PostDocumentOptions updateDocumentOptions =
                new PostDocumentOptions.Builder()
                    .db(exampleDbName)
                    .contentType("application/json")
                    .body(documentAsByteStream)
                    .build();
            */
            // ================================================================

            DocumentResult updateDocumentResponse = client
                .postDocument(updateDocumentOptions)
                .execute()
                .getResult();

            // ====================================================================
            // Note: updating the document can also be done with the "putDocument"
            // method. docId and rev are required for an UPDATE operation,
            // but rev can be provided in the document object too:
            /*
            PutDocumentOptions updateDocumentOptions =
                new PutDocumentOptions.Builder()
                    .db(exampleDbName)
                    .docId(document.getId()) // docId is a required parameter
                    .rev(document.getRev())
                    .document(document) // rev in the document object CAN replace above `rev` parameter
                    .build();
            DocumentResult updateDocumentResponse = client
                .putDocument(updateDocumentOptions)
                .execute()
                .getResult();
            */
            // ====================================================================

            // Keeping track of the latest revision number of the document object
            // is necessary for further UPDATE/DELETE operations:
            document.setRev(updateDocumentResponse.getRev());
            System.out.println("You have updated the document:\n" + document);
        } catch (NotFoundException nfe) {
            System.out.println("Cannot update document because " +
                "either \"orders\" database or the \"example\" " +
                "document was not found.");
        }
    }
}
```


</details>
When you run the code, you see a result similar to the following output.

[embedmd]:# (modules/examples/output/UpdateDoc.txt)
```txt
You have updated the document:
{
  "_id": "example",
  "_rev": "2-4e2178e85cffb32d38ba4e451f6ca376",
  "address": "19 Front Street, Darlington, DL5 1TY",
  "name": "Bob Smith"
}
```

#### 4. Delete your previously created document

**Note**: This example code assumes that you have created both the `orders`
database and the `example` document by
[running the previous example code](#2-create-your-own-database-and-add-a-document)
successfully. Otherwise, the following error message occurs, "Cannot delete document because either 'orders'
database or 'example' document was not found."

<details>
<summary>Delete code example</summary>

[embedmd]:# (modules/examples/src/main/java/DeleteDoc.java /import com./ $)
```java
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;

public class DeleteDoc {
    public static void main(String[] args) {
        // 1. Create a client with `CLOUDANT` default service name ============
        Cloudant client = Cloudant.newInstance();

        // 2. Delete the document =============================================
        // Set the options to get the document out of the database if it exists
        String exampleDbName = "orders";
        String exampleDocId = "example";
        GetDocumentOptions documentInfoOptions =
            new GetDocumentOptions.Builder()
                .db(exampleDbName)
                .docId(exampleDocId)
                .build();

        try {
            // Try to get the document if it previously existed in the database
            Document document = client
                .getDocument(documentInfoOptions)
                .execute()
                .getResult();

            // Delete the document from the database
            DeleteDocumentOptions deleteDocumentOptions =
                    new DeleteDocumentOptions.Builder()
                        .db(exampleDbName)
                        .docId(exampleDocId)    // docId is required for DELETE
                        .rev(document.getRev()) // rev is required for DELETE
                        .build();
            DocumentResult deleteDocumentResponse = client
                .deleteDocument(deleteDocumentOptions)
                .execute()
                .getResult();
            if (deleteDocumentResponse.isOk()) {
                System.out.println("You have deleted the document.");
            }

        } catch (NotFoundException nfe) {
            System.out.println("Cannot delete document because " +
                "either \"orders\" database or the \"example\" " +
                "document was not found.");
        }
    }
}
```


</details>
When you run the code, you see the following output.

[embedmd]:# (modules/examples/output/DeleteDoc.txt)
```txt
You have deleted the document.
```

### Error handling

For sample code on handling errors, see
[Cloudant API docs](https://cloud.ibm.com/apidocs/cloudant?code=java#error-handling).

### Raw IO

For endpoints that read or write document content it is possible to bypass
usage of the built-in object with byte streams. 

Depending on the specific SDK operation it may be possible to:
* accept a user-provided byte stream to send to the server as a request body
* return a byte stream of the server response body to the user

Request byte stream can be supplied for builder objects that have the `body` method.
For these cases you can pass this byte stream directly to the HTTP request body.

Response byte stream is supported in functions with the suffix of `AsStream`.
The returned byte stream allows the response body to be consumed
without triggering JSON unmarshalling that is typically performed by the SDK.

The [update document](#3-update-your-previously-created-document) section
contains examples for both request and response byte stream cases.

The API reference contains further examples of using byte streams. 
They are titled "Example request as stream" and are initially collapsed. 
Expand them to see examples of:

- Byte requests:
  - [Bulk modify multiple documents in a database](https://cloud.ibm.com/apidocs/cloudant?code=java#postbulkdocs)

- Byte responses:
  - [Query a list of all documents in a database](https://cloud.ibm.com/apidocs/cloudant?code=java#postalldocs)
  - [Query the database document changes feed](https://cloud.ibm.com/apidocs/cloudant?code=java#postchanges)

### Further resources

- [Cloudant API docs](https://cloud.ibm.com/apidocs/cloudant?code=java):
  API reference including usage examples for Cloudant Java SDK API.
- [Javadoc](https://ibm.github.io/cloudant-java-sdk/):
  Cloudant Java SDK API Documentation.
- [Cloudant docs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-getting-started-with-cloudant):
  The official documentation page for Cloudant.
- [Cloudant blog](https://blog.cloudant.com/):
  Many useful articles about how to optimize Cloudant for common problems.

## Questions

If you are having difficulties using this SDK or have a question about the
IBM Cloud services, ask a question on
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues

If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/IBM/cloudant-java-sdk/issues).
Before you submit a bug report, search for
[similar issues](https://github.com/IBM/cloudant-java-sdk/issues?q=is%3Aissue) and review the
[KNOWN_ISSUES file](KNOWN_ISSUES.md) to verify that your issue hasn't been reported yet.

## Open source at IBM

Find more open source projects on the [IBM Github](http://ibm.github.io/) page.

## Contributing

For more information, see [CONTRIBUTING](CONTRIBUTING.md).

## License

This SDK is released under the Apache 2.0 license. To read the full text of the license, see [LICENSE](LICENSE).
