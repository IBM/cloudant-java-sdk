/**
 * © Copyright IBM Corporation 2020, 2022. All Rights Reserved.
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
