// section: code imports
import com.ibm.cloud.sdk.core.http.Headers;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadReplicationDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

HeadReplicationDocumentOptions replicationDocOptions =
    new HeadReplicationDocumentOptions.Builder()
        .docId("repldoc-example")
        .build();

int statusCode =
    service.headReplicationDocument(replicationDocOptions).execute().getStatusCode();

Headers headers =
    service.headReplicationDocument(replicationDocOptions).execute().getHeaders();

System.out.println(statusCode);
System.out.println(headers.values("ETag"));
