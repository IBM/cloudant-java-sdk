// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.GetLocalDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetLocalDocumentOptions documentOptions =
    new GetLocalDocumentOptions.Builder()
        .db("orders")
        .docId("local-0007741142412418284")
        .build();

Document response =
    service.getLocalDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
