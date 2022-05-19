// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteReplicationDocumentOptions replicationDocOptions =
    new DeleteReplicationDocumentOptions.Builder()
        .docId("repldoc-example")
        .rev("3-a0ccbdc6fe95b4184f9031d086034d85")
        .build();

DocumentResult response =
    service.deleteReplicationDocument(replicationDocOptions).execute()
        .getResult();

System.out.println(response);
