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
eventDoc1.setId("0007241142412418284");
eventDoc1.put("type", "event");
eventDoc1.put("userid", "abc123");
eventDoc1.put("eventType", "addedToBasket");
eventDoc1.put("productId", "1000042");
eventDoc1.put("date", "2019-01-28T10:44:22.000Z");

Document eventDoc2 = new Document();
eventDoc2.setId("0007241142412418285");
eventDoc2.put("type", "event");
eventDoc2.put("userid", "abc234");
eventDoc2.put("eventType", "addedToBasket");
eventDoc2.put("productId", "1000050");
eventDoc2.put("date", "2019-01-28T10:44:22.000Z");

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
