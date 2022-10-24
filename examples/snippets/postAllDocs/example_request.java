// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostAllDocsOptions docsOptions =
    new PostAllDocsOptions.Builder()
        .db("orders")
        .includeDocs(true)
        .startKey("abc")
        .limit(10)
        .build();

AllDocsResult response =
    service.postAllDocs(docsOptions).execute().getResult();

System.out.println(response);
