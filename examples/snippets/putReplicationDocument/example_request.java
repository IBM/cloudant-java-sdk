// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PutReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabase;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuth;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthIam;
import com.ibm.cloud.cloudant.v1.model.ReplicationDocument;
// section: code
Cloudant service = Cloudant.newInstance();

ReplicationDatabase sourceDb = new ReplicationDatabase.Builder()
    .url("<your-source-service-url>/animaldb")
    .build();

ReplicationDatabaseAuthIam targetAuthIam =
    new ReplicationDatabaseAuthIam.Builder()
        .apiKey("<your-iam-api-key>")
        .build();

ReplicationDatabaseAuth targetAuth = new ReplicationDatabaseAuth.Builder()
    .iam(targetAuthIam)
    .build();

ReplicationDatabase targetDb = new ReplicationDatabase.Builder()
    .auth(targetAuth)
    .url("<your-target-service-url>/animaldb-target")
    .build();

ReplicationDocument replDocument = new ReplicationDocument();
replDocument.setCreateTarget(true);
replDocument.setSource(sourceDb);
replDocument.setTarget(targetDb);

PutReplicationDocumentOptions replicationDocumentOptions =
    new PutReplicationDocumentOptions.Builder()
        .docId("repldoc-example")
        .replicationDocument(replDocument)
        .build();

DocumentResult response =
    service.putReplicationDocument(replicationDocumentOptions).execute()
        .getResult();

System.out.println(response);
