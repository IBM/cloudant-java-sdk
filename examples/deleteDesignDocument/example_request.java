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
        .rev("1-98e6a25b3b45df62e7d47095ac15b16a")
        .build();

DocumentResult response =
    service.deleteDesignDocument(designDocumentOptions).execute()
        .getResult();

System.out.println(response);
