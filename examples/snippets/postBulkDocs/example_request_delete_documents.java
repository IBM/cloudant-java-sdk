// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.BulkDocs;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkDocsOptions;

import java.util.Arrays;
import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

Document eventDoc1 = new Document();
eventDoc1.setId("ns1HJS13AMkK:0007241142412418284");
eventDoc1.setRev("1-00000000000000000000000000000000");
eventDoc1.setDeleted(true);

Document eventDoc2 = new Document();
eventDoc2.setId("H8tDIwfadxp9:0007241142412418285");
eventDoc1.setRev("1-00000000000000000000000000000000");
eventDoc1.setDeleted(true);

BulkDocs bulkDocs = new BulkDocs.Builder()
    .docs(Arrays.asList(eventDoc1, eventDoc2))
    .build();

PostBulkDocsOptions bulkDocsOptions = new PostBulkDocsOptions.Builder()
    .db("events")
    .bulkDocs(bulkDocs)
    .build();

List<DocumentResult> response =
    service.postBulkDocs(bulkDocsOptions).execute()
        .getResult();

System.out.println(response);
