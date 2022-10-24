// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteLocalDocumentOptions documentOptions =
    new DeleteLocalDocumentOptions.Builder()
        .db("orders")
        .docId("local-0007741142412418284")
        .build();

DocumentResult response =
    service.deleteLocalDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
