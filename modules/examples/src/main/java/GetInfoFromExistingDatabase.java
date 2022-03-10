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
