<!--
  The example codes and outputs below are generated using the `embedmd` go
  package.

      https://github.com/campoy/embedmd

  You should regenerate the example codes after making any changes to
  examples in the modules/examples/ folder.

      embedmd -w README.md
  -->

[![Build Status](https://travis-ci.com/IBM/cloudant-java-sdk.svg?branch=master)](https://travis-ci.com/IBM/cloudant-java-sdk)
<!-- [![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release) -->

# IBM Cloudant Java SDK Version 0.0.19

Java client library to interact with the
[IBM Cloudant APIs](https://cloud.ibm.com/apidocs/cloudant?code=java).

Disclaimer: this SDK is being released initially as a **pre-release** version.
Changes might occur which impact applications that use this SDK.

<details>
<summary>Table of Contents</summary>

<!--
  The TOC below is generated using the `markdown-toc` node package.

      https://github.com/jonschlinkert/markdown-toc

  You should regenerate the TOC after making changes to this file.

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
  * [Authenticate with environment variables](#authenticate-with-environment-variables)
    + [IAM authentication](#iam-authentication)
    + [Session cookie authentication](#session-cookie-authentication)
    + [Basic authentication](#basic-authentication)
  * [Authenticate with external configuration](#authenticate-with-external-configuration)
  * [Authenticate programmatically](#authenticate-programmatically)
- [Code examples](#code-examples)
  * [1. Retrieve information from an existing database](#1-retrieve-information-from-an-existing-database)
  * [2. Create your own database and add a document](#2-create-your-own-database-and-add-a-document)
  * [3. Update your previously created document](#3-update-your-previously-created-document)
  * [4. Delete your previously created document](#4-delete-your-previously-created-document)
- [Error handling](#error-handling)
- [Using the SDK](#using-the-sdk)
- [Questions](#questions)
- [Issues](#issues)
- [Further resources](#further-resources)
- [Open source @ IBM](#open-source--ibm)
- [Contributing](#contributing)
- [License](#license)

<!-- tocstop -->

</details>

## Overview

The IBM Cloudant Java SDK allows developers to programmatically
interact with IBM [Cloudant](https://cloud.ibm.com/apidocs/cloudant)
with the help of the `com.ibm.cloud.cloudant` package.

## Features

The purpose of this Java SDK is to wrap most of the HTTP request APIs
provided by Cloudant and supply other functions to ease the usage of Cloudant.
Moreover, it has limited support for CouchDB as well.
This SDK should make life easier for programmers to do what’s really important
for them: develop.

Reasons why you should consider using Cloudant Java SDK in your
project:

- Supported by IBM Cloudant.
- Includes all the most popular and latest supported endpoints for
  applications.
- Handles the authentication.
- Familiar user experience of IBM Cloud SDKs.
- HTTP2 support for higher performance connections to IBM Cloudant.
- Perform requests either synchronously or asynchronously.
- Instances of the client are unconditionally thread-safe.
- Transparently compresses request and response bodies.

## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

- An [IBM Cloud][ibm-cloud-onboarding] account.
- An IAM API key to allow the SDK to access your account.
  Create one [here](https://cloud.ibm.com/iam/apikeys).
- Java 8, 11 or 14.

## Installation

The current version of this SDK is: 0.0.19

The project artifacts are published on the following public maven repositories:

- [JCenter](https://bintray.com/bintray/jcenter) - For information on how to use
the public JCenter maven repository, open [this link](https://bintray.com/bintray/jcenter)
then click the `Set Me Up!` button.
- [Maven Central](https://repo1.maven.org/maven2/) - This is the default public repository
used by maven when searching for dependencies.  To use this repository within your
gradle build, please see
[this link](https://docs.gradle.org/current/userguide/declaring_repositories.html).

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
        <version>0.0.19</version>
  </dependency>
</dependencies>
```

### Gradle

Add the `cloudant` library to *Gradle dependencies* in your `build.gradle` file:

```groovy
dependencies {
    // other dependencies...
    implementation group: "com.ibm.cloud", name: "cloudant", version: "0.0.19"
}
```

## Authentication

[service-credentials]: https://cloud.ibm.com/docs/Cloudant?topic=cloudant-creating-an-ibm-cloudant-instance-on-ibm-cloud#locating-your-service-credentials
[cloud-IAM-mgmt]: https://cloud.ibm.com/docs/Cloudant?topic=cloudant-ibm-cloud-identity-and-access-management-iam-
[couch-cookie-auth]: https://docs.couchdb.org/en/stable/api/server/authn.html#cookie-authentication
[cloudant-cookie-auth]: https://cloud.ibm.com/docs/Cloudant?topic=cloudant-authentication#cookie-authentication
[couch-basic-auth]: https://docs.couchdb.org/en/stable/api/server/authn.html#basic-authentication
[cloudant-basic-auth]: https://cloud.ibm.com/docs/services/Cloudant/api?topic=cloudant-authentication#basic-authentication

This library requires some of your
[Cloudant service credentials][service-credentials] to authenticate with your
account.

1. `IAM`, `COUCHDB_SESSION`, `BASIC` or `NOAUTH` **authentication type**.
    1. [*IAM authentication*](#iam-authentication) is highly recommended when your
    back-end database server is [**Cloudant**][cloud-IAM-mgmt]. This
    authentication type requires a server-generated `apikey` instead of a
    user-given password.
    1. [*Session cookie (`COUCHDB_SESSION`) authentication*](#session-cookie-authentication)
    is recommended for [Apache CouchDB][couch-cookie-auth] or for
    [Cloudant][cloudant-cookie-auth] when IAM is unavailable. It exchanges username
    and password credentials for an `AuthSession` cookie from the `/_session`
    endpoint.
    1. [*Basic* (or legacy) *authentication*](#basic-authentication) is a fallback
    for both [Cloudant][cloudant-basic-auth] and [Apache CouchDB][couch-basic-auth]
    back-end database servers. This authentication type requires the good old
    `username` and `password` credentials.
    1. *Noauth* authentication does not need any credentials. Note that this
    authentication type will only work for queries against a database with read
    access for everyone.
1. The service `url`.

There are several ways to **set** these properties:

1. As [environment variables](#authenticate-with-environment-variables)
1. The [programmatic approach](#authenticate-programmatically)
1. With an [external credentials file](#authenticate-with-external-configuration)

### Authenticate with environment variables

#### IAM authentication

For Cloudant *IAM authentication* set the following environmental variables by
replacing `<url>` and `<apikey>` with your proper
[service credentials][service-credentials]. There is no need to set
`CLOUDANT_AUTH_TYPE` to `IAM` because it is the default.

```bash
CLOUDANT_URL=<url>
CLOUDANT_APIKEY=<apikey>
```

#### Session cookie authentication

For `COUCHDB_SESSION` authentication set the following environmental variables
by replacing `<url>`, `<username>` and `<password>` with your proper
[service credentials][service-credentials].

```bash
CLOUDANT_AUTH_TYPE=COUCHDB_SESSION
CLOUDANT_URL=<url>
CLOUDANT_USERNAME=<username>
CLOUDANT_PASSWORD=<password>
```

#### Basic authentication

For *Basic authentication* set the following environmental variables by
replacing `<url>`, `<username>` and `<password>` with your proper
[service credentials][service-credentials].

```bash
CLOUDANT_AUTH_TYPE=BASIC
CLOUDANT_URL=<url>
CLOUDANT_USERNAME=<username>
CLOUDANT_PASSWORD=<password>
```

**Note**: We recommend using [IAM](#iam-authentication) for Cloudant and
[Session](#session-cookie-authentication) for CouchDB authentication.

### Authenticate with external configuration

To use an external configuration file, the
[Cloudant API docs](https://cloud.ibm.com/apidocs/cloudant?code=java#authentication-with-external-configuration),
or the
[general SDK usage information](https://github.com/IBM/ibm-cloud-sdk-common#using-external-configuration)
will guide you.

### Authenticate programmatically

To learn more about how to use programmatic authentication, see the related
documentation in the
[Cloudant API docs](https://cloud.ibm.com/apidocs/cloudant?code=python#programmatic-authentication)
or in the
[Java SDK Core document about authentication](https://github.com/IBM/java-sdk-core/blob/master/Authentication.md).

## Code examples

The code examples below will follow the
[authentication with environment variables](#authenticate-with-environment-variables).

### 1. Retrieve information from an existing database

This example code gathers some information about an existing database hosted on
the https://examples.cloudant.com/ service `url`. To do this, you need to
extend your environment variables with the *service url* and *authentication
type* to use `NOAUTH` authentication while reaching the `animaldb` database.
This step is necessary for the SDK to distinguish the `EXAMPLES` custom service
name from the default service name which is `CLOUDANT`.

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

The result of the code is similar to the following output.

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

### 2. Create your own database and add a document

Now comes the exciting part of creating your own `orders` database and adding
a document about *Bob Smith* with your own [IAM](#iam-authentication) or
[Basic](#basic-authentication) service credentials.

[embedmd]:# (modules/examples/src/main/java/CreateDbAndDoc.java /import com./ $)
```java
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PostDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutDatabaseOptions;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
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
        exampleDocument.setId(exampleDocId);

        // Add "name" and "joined" fields to the document
        exampleDocument.put("name", "Bob Smith");
        exampleDocument.put("joined", "2019-01-24T10:42:99.000Z");

        // Set the options to get the document out of the database if it exists
        GetDocumentOptions documentInfoOptions =
                new GetDocumentOptions.Builder()
                        .db(exampleDbName)
                        .docId(exampleDocId)
                        .build();

        /* Try to get the document and set revision of exampleDocument to the
           latest one if it previously existed in the database */
        try {
            Document documentInfo = client
                    .getDocument(documentInfoOptions)
                    .execute()
                    .getResult();
            exampleDocument.setRev(documentInfo.getRev());
            System.out.println("The document revision for " + exampleDocId +
                    " is set to " + exampleDocument.getRev() + ".");
        } catch (NotFoundException nfe) {
        }

        // Save the document in the database
        PostDocumentOptions createDocumentOptions =
                new PostDocumentOptions.Builder()
                        .db(exampleDbName)
                        .document(exampleDocument)
                        .build();
        DocumentResult createDocumentResponse = client
                .postDocument(createDocumentOptions)
                .execute()
                .getResult();

        // Keep track of the revision number from the `example` document object
        exampleDocument.setRev(createDocumentResponse.getRev());
        System.out.println("You have created the document:\n"
                + exampleDocument);
    }
}
```

The result of the code is similar to the following output.

[embedmd]:# (modules/examples/output/CreateDbAndDoc.txt)
```txt
"orders" database created.
You have created the document:
{
  "_id": "example",
  "_rev": "1-2c3b9502ed7c4a41d35c92bcf734869c",
  "joined": "2019-01-24T10:42:99.000Z",
  "name": "Bob Smith"
}
```

### 3. Update your previously created document

**Note**: this example code assumes that you have created both the `orders`
database and the `example` document by
[running this previous example code](#2-create-your-own-database-and-add-a-document)
successfully, otherwise you get the `Cannot update document because either "orders"
database or "example" document was not found.` message.

[embedmd]:# (modules/examples/src/main/java/UpdateDoc.java /import com./ $)
```java
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PostDocumentOptions;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;

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
            DocumentResult updateDocumentResponse = client
                    .postDocument(updateDocumentOptions)
                    .execute()
                    .getResult();

            // Keeping track with the revision number of the document object:
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

The result of the code is similar to the following output.

[embedmd]:# (modules/examples/output/UpdateDoc.txt)
```txt
You have updated the document:
{
  "_id": "example",
  "_rev": "2-6cc06e9484d776322f7e697c03fb23f7",
  "address": "19 Front Street, Darlington, DL5 1TY",
  "name": "Bob Smith"
}
```

### 4. Delete your previously created document

**Note**: this example code assumes that you have created both the `orders`
database and the `example` document by
[running this previous example code](#2-create-your-own-database-and-add-a-document)
successfully, otherwise you get the `Cannot delete document because either "orders"
database or "example" document was not found.` message.

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
                            .rev(document.getRev())
                            .docId(exampleDocId)
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

The result of the code is the following output.

[embedmd]:# (modules/examples/output/DeleteDoc.txt)
```txt
You have deleted the document.
```

## Error handling

For sample code on handling errors, please see
[Cloudant API docs](https://cloud.ibm.com/apidocs/cloudant?code=java#error-handling).

## Using the SDK

For general SDK usage information, please see
[this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md).

## Questions

If you are having difficulties using this SDK or have a question about the
IBM Cloud services, please ask a question on
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues

If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/IBM/cloudant-java-sdk/issues).
Before that, please search for similar issues. It's possible that someone
has already reported the problem.

## Further resources

- [Cloudant API docs](https://cloud.ibm.com/apidocs/cloudant?code=java):
  API examples for Cloudant Java SDK.
- [Cloudant docs](https://cloud.ibm.com/docs/services/Cloudant?topic=cloudant-overview#overview):
  The official documentation page for Cloudant.
- [Cloudant Learning Center](https://developer.ibm.com/clouddataservices/docs/compose/cloudant/):
  The official learning center with several useful videos which help you to use
  Cloudant successfully.
- [Cloudant blog](https://blog.cloudant.com/):
  Many useful articles how to optimize Cloudant for common problems.

## Open source @ IBM

Find more open source projects on the [IBM Github Page](http://ibm.github.io/).

## Contributing

See [CONTRIBUTING](CONTRIBUTING.md).

## License

This SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
