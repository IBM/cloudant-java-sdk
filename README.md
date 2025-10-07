[![Build Status](https://github.com/IBM/cloudant-java-sdk/actions/workflows/test.yml/badge.svg?branch=main&event=push)](https://github.com/IBM/cloudant-java-sdk/actions/workflows/test.yml)
[![Release](https://img.shields.io/github/v/release/IBM/cloudant-java-sdk?include_prereleases&sort=semver)](https://github.com/IBM/cloudant-java-sdk/releases/latest)
[![Docs](https://img.shields.io/static/v1?label=Javadoc&message=latest&color=blue)](https://ibm.github.io/cloudant-java-sdk/)

# IBM Cloudant Java SDK Version 0.10.8

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

<!-- toc -->
- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
  * [Maven](#maven)
  * [Gradle](#gradle)
- [Using the SDK](#using-the-sdk)
  * [Authentication](#authentication)
  * [Automatic retries](#automatic-retries)
  * [Request timeout configuration](#request-timeout-configuration)
  * [Code examples](#code-examples)
  * [Error handling](#error-handling)
  * [Raw IO](#raw-io)
  * [Further resources](#further-resources)
- [Questions](#questions)
- [Issues](#issues)
- [Versioning and LTS support](#versioning-and-lts-support)
- [Open source at IBM](#open-source-at-ibm)
- [Contributing](#contributing)
- [License](#license)

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
  - IBM Cloudant.
  - [Apache CouchDB 3.x](https://docs.couchdb.org/en/stable/) for data operations.
- Includes all the most popular and latest supported endpoints for
  applications.
- Handles the authentication.
- Familiar user experience with IBM Cloud SDKs.
- Flexibility to use either built-in models or byte-based requests and responses for documents.
- Built-in [Changes feed follower](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/docs/Changes_Follower.md)
- Built-in [Pagination](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/docs/Pagination.md) (beta)
- HTTP2 support for higher performance connections to IBM Cloudant.
- Perform requests either synchronously or asynchronously.
- Instances of the client are unconditionally thread-safe.
- Transparently compresses request and response bodies.

## Prerequisites

- A
  [Cloudant](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-getting-started-with-cloudant)
  service instance or a
  [CouchDB](https://docs.couchdb.org/en/latest/install/index.html)
  server.
- Java 8, 11, 17, 21, 25.

## Installation

The current version of this SDK is: 0.10.8

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
        <version>0.10.8</version>
  </dependency>
</dependencies>
```

### Gradle

Add the `cloudant` library to the *dependencies* in your `build.gradle` file:

```groovy
dependencies {
    // other dependencies...
    implementation group: "com.ibm.cloud", name: "cloudant", version: "0.10.8"
}
```

## Using the SDK

For fundamental SDK usage information and config options, please see the common [IBM Cloud SDK](https://github.com/IBM/ibm-cloud-sdk-common/blob/main/README.md) documentation.

This library requires configuration with a service URL and
[Cloudant service credentials][service-credentials] to authenticate with your
account.

There are several ways to **set** these authentication properties:

1. As [environment variables](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/docs/Authentication.md#authentication-with-environment-variables)
2. The [programmatic approach](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/docs/Authentication.md#programmatic-authentication)
3. With an [external credentials file](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/docs/Authentication.md#authentication-with-external-configuration)

The following section describes the different authentication types and provides environment variable examples.
Examples for other configuration methods are available by following the provided links.

### Authentication

Consult the [authentication document](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/docs/Authentication.md)
for comprehensive details of all the available authentication methods and how to configure them with environment settings
or programmatically.

Quick start for Cloudant with an IAM API key:
```sh
CLOUDANT_URL=https://~replace-with-cloudant-host~.cloudantnosqldb.appdomain.cloud # use your own Cloudant public or private URL
CLOUDANT_APIKEY=a1b2c3d4e5f6f1g4h7j3k6l9m2p5q8s1t4v7x0z3 # use your own IAM API key
```

Quick start for Apache CouchDB with a username/password session:
```sh
CLOUDANT_AUTH_TYPE=COUCHDB_SESSION
CLOUDANT_URL=https://~replace-with-your-unique-host~.example:6984 # use your CouchDB URL
CLOUDANT_USERNAME=username # replace with your username
CLOUDANT_PASSWORD=password # replace with your password
```

### Automatic retries

The SDK supports a generalized retry feature that can automatically retry on common errors.

The [automatic retries](https://github.com/IBM/ibm-cloud-sdk-common#automatic-retries) section has details on how to enable the retries with default values and customize the retries programmatically or with external configuration.

### Request timeout configuration

No request timeout is defined, but a 60s connect, a 2.5m read and a 60s write timeout are set by default. Be sure to set a request timeout appropriate to your application usage and environment.
The [request timeout](https://github.com/IBM/ibm-cloud-sdk-common#configuring-request-timeouts) section contains details on how to change the value.

**Note:** System settings may take precedence over configured timeout values.

### Code examples

Quick start example to list all databases (assumes environment variable [authentication](#authentication)):

```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;

import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

List<String> response =
    service.getAllDbs().execute().getResult();

System.out.println(response);
```

[More tutorial examples](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/docs/Examples.md) for creating a database
and document create, read, update and delete operations.

For a complete list of code examples, see the [examples directory](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/examples#examples-for-java).

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

The [update document](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/docs/Examples.md#3-update-your-previously-created-document) section
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

- [Cloudant Java SDK feature docs](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/docs)
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
[KNOWN_ISSUES file](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/KNOWN_ISSUES.md) to verify that your issue hasn't been reported yet.

Please consult the [security policy](https://github.com/IBM/cloudant-java-sdk/security/policy) before opening security related issues.

## Versioning and LTS support

This SDK follows semantic versioning with respect to the definition of user facing APIs.
This means under some circumstances breaking changes may occur within a major or minor version
of the SDK related to changes in supported language platforms.

The SDK is supported on the available LTS releases of the language platform.
The LTS language versions are listed in the prerequisites:
* [LTS versions currently supported by the SDK](https://github.com/IBM/cloudant-java-sdk/#prerequisites)
* [LTS versions for this release of the SDK](#prerequisites)

Incompatible changes from new language versions are not added to the SDK
until they are available in the minimum supported language version.

When language LTS versions move out of support the following will happen:
* Existing SDK releases will continue to run on obsolete language versions, but will no longer be supported.
* The minimum language version supported by the SDK will be updated to the next available LTS.
* New language features may be added in subsequent SDK releases that will cause breaking changes
  if the new releases of the SDK are used with older, now unsupported, language levels.

## Open source at IBM

Find more open source projects on the [IBM GitHub](http://ibm.github.io/) page.

## Contributing

For more information, see [CONTRIBUTING](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/CONTRIBUTING.md).

## License

This SDK is released under the Apache 2.0 license. To read the full text of the license, see [LICENSE](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.8/LICENSE).
