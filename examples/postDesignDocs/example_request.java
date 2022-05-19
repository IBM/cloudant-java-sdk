// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostDesignDocsOptions docsOptions =
    new PostDesignDocsOptions.Builder()
        .attachments(true)
        .db("users")
        .build();

AllDocsResult response =
    service.postDesignDocs(docsOptions).execute()
        .getResult();

System.out.println(response);
