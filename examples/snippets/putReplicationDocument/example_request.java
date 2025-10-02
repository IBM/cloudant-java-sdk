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
    .url("https://~replace-with-source-host~.cloudantnosqldb.appdomain.cloud/animaldb")
    .build();

ReplicationDatabaseAuthIam targetAuthIam =
    new ReplicationDatabaseAuthIam.Builder()
        .apiKey("a1b2c3d4e5f6f1g4h7j3k6l9m2p5q8s1t4v7x0z3") //use your own IAM API key
        .build();

ReplicationDatabaseAuth targetAuth = new ReplicationDatabaseAuth.Builder()
    .iam(targetAuthIam)
    .build();

ReplicationDatabase targetDb = new ReplicationDatabase.Builder()
    .auth(targetAuth)
    .url("https://~replace-with-target-host~.cloudantnosqldb.appdomain.cloud/animaldb-target")
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
