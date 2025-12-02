# Code examples

<details open>
<summary>Table of Contents</summary>

<!-- toc -->
- [1. Create a database and add a document](#1-create-a-database-and-add-a-document)
- [2. Retrieve information from an existing database](#2-retrieve-information-from-an-existing-database)
- [3. Update your previously created document](#3-update-your-previously-created-document)
- [4. Delete your previously created document](#4-delete-your-previously-created-document)
- [Further code examples](#further-code-examples)
</details>

The following code examples
[authenticate with the environment variables](Authentication.md#authentication-with-environment-variables).

## 1. Create a database and add a document

**Note:** This example code assumes that `orders` database does not exist in your account.

This example code creates `orders` database and adds a new document "example"
into it. To connect, you must set your environment variables with
the *service url*, *authentication type* and *authentication credentials*
of your Cloudant service.

Cloudant environment variable naming starts with a *service name* prefix that identifies your service.
By default, this is `CLOUDANT`, see the settings in the
[authentication with environment variables section](Authentication.md#authentication-with-environment-variables).

If you would like to rename your Cloudant service from `CLOUDANT`,
you must use your defined service name as the prefix for all Cloudant related environment variables.

Once the environment variables are set, you can try out the code examples.

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

When you run the code, you see a result similar to the following output.

```text
"orders" database created.
You have created the document:
{
  "_id": "example",
  "_rev": "1-1b403633540686aa32d013fda9041a5d",
  "joined": "2019-01-24T10:42:99.000Z",
  "name": "Bob Smith"
}
```

## 2. Retrieve information from an existing database

**Note**: This example code assumes that you have created both the `orders`
database and the `example` document by
[running the previous example code](#1-create-a-database-and-add-a-document)
successfully. Otherwise, the following error message occurs, "Cannot delete document because either 'orders'
database or 'example' document was not found."

<details open>
<summary>Gather database information example</summary>

```java
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformation;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.ServerInformation;

public class GetInfoFromExistingDatabase {
    public static void main(String[] args) {
        // 1. Create a client with `CLOUDANT` default service name ============
        Cloudant client = Cloudant.newInstance();

        // 2. Get server information ==========================================
        ServerInformation serverInformation = client
            .getServerInformation()
            .execute()
            .getResult();

        System.out.println("Server Version: " +
            serverInformation.getVersion());

        // 3. Get database information for "orders" =========================
        String dbName = "orders";

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

        // 5. Get "example" document out of the database by document id ===========
        GetDocumentOptions getDocOptions = new GetDocumentOptions.Builder()
            .db(dbName)
            .docId("example")
            .build();

        Document documentExample = client
            .getDocument(getDocOptions)
            .execute()
            .getResult();

        System.out.println("Document retrieved from database:\n" +
            documentExample);
    }
}
```

</details>
When you run the code, you see a result similar to the following output.

```text
Server Version: 2.1.1
Document count in "orders" database is 1.
Document retrieved from database:
{
  "_id": "example",
  "_rev": "1-1b403633540686aa32d013fda9041a5d",
  "name": "Bob Smith",
  "joined": "2019-01-24T10:42:99.000Z"
}
```

## 3. Update your previously created document

**Note**: This example code assumes that you have created both the `orders`
database and the `example` document by
[running the previous example code](#1-create-a-database-and-add-a-document)
successfully. Otherwise, the following error message occurs, "Cannot update document because either 'orders'
database or 'example' document was not found."

<details open>
<summary>Update code example</summary>

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

```text
You have updated the document:
{
  "_id": "example",
  "_rev": "2-4e2178e85cffb32d38ba4e451f6ca376",
  "address": "19 Front Street, Darlington, DL5 1TY",
  "name": "Bob Smith"
}
```

## 4. Delete your previously created document

**Note**: This example code assumes that you have created both the `orders`
database and the `example` document by
[running the previous example code](#1-create-a-database-and-add-a-document)
successfully. Otherwise, the following error message occurs, "Cannot delete document because either 'orders'
database or 'example' document was not found."

<details open>
<summary>Delete code example</summary>

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

```text
You have deleted the document.
```

## Further code examples

For a complete list of code examples, see the [examples directory](https://github.com/IBM/cloudant-java-sdk/tree/v0.10.13/examples#examples-for-java).
