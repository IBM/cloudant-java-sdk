// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteDocumentOptions documentOptions =
    new DeleteDocumentOptions.Builder()
        .db("orders")
        .docId("order00058")
        .rev("1-00000000000000000000000000000000")
        .build();

DocumentResult response =
    service.deleteDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
