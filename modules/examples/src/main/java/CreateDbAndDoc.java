/**
 * © Copyright IBM Corporation 2020. All Rights Reserved.
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
