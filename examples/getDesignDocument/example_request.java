// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DesignDocument;
import com.ibm.cloud.cloudant.v1.model.GetDesignDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDesignDocumentOptions designDocumentOptions = new GetDesignDocumentOptions.Builder()
    .db("products")
    .ddoc("appliances")
    .latest(true)
    .build();

DesignDocument response =
    service.getDesignDocument(designDocumentOptions).execute()
        .getResult();

System.out.println(response);
