// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDocumentOptions documentOptions =
    new GetDocumentOptions.Builder()
        .db("products")
        .docId("1000042")
        .build();

Document response =
    service.getDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
