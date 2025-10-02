// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteDesignDocumentOptions designDocumentOptions =
    new DeleteDesignDocumentOptions.Builder()
        .db("products")
        .ddoc("appliances")
        .rev("1-00000000000000000000000000000000")
        .build();

DocumentResult response =
    service.deleteDesignDocument(designDocumentOptions).execute()
        .getResult();

System.out.println(response);
