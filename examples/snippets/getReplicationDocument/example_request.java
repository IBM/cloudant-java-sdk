// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.ReplicationDocument;
// section: code
Cloudant service = Cloudant.newInstance();

GetReplicationDocumentOptions replicationDocOptions =
    new GetReplicationDocumentOptions.Builder()
        .docId("repldoc-example")
        .build();

ReplicationDocument response =
    service.getReplicationDocument(replicationDocOptions).execute()
        .getResult();

System.out.println(response);
