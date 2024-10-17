// section: code imports
import com.ibm.cloud.sdk.core.http.Headers;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadDesignDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

HeadDesignDocumentOptions designDocumentOptions =
    new HeadDesignDocumentOptions.Builder()
        .db("events")
        .ddoc("checkout")
        .build();

int statusCode =
    service.headDesignDocument(designDocumentOptions).execute()
        .getStatusCode();

Headers headers =
    service.headDesignDocument(designDocumentOptions).execute()
        .getHeaders();

System.out.println(statusCode);
System.out.println(headers.values("ETag"));
