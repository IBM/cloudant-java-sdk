// section: code imports
import com.ibm.cloud.sdk.core.http.Headers;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();
HeadDocumentOptions documentOptions =
    new HeadDocumentOptions.Builder()
        .db("orders")
        .docId("order00058")
        .build();

int statusCode =
    service.headDocument(documentOptions).execute()
        .getStatusCode();
Headers headers =
    service.headDocument(documentOptions).execute()
        .getHeaders();

System.out.println(statusCode);
System.out.println(headers.values("ETag"));
