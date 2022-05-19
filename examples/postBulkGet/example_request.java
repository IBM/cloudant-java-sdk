// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.BulkGetQueryDocument;
import com.ibm.cloud.cloudant.v1.model.BulkGetResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkGetOptions;

import java.util.ArrayList;
import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

String docId = "order00067";
List<BulkGetQueryDocument> bulkGetDocs = new ArrayList<>();

bulkGetDocs.add(
    new BulkGetQueryDocument.Builder()
        .id(docId)
        .rev("3-917fa2381192822767f010b95b45325b")
        .build());
bulkGetDocs.add(
    new BulkGetQueryDocument.Builder()
        .id(docId)
        .rev("4-a5be949eeb7296747cc271766e9a498b")
        .build());

PostBulkGetOptions bulkGetOptions = new PostBulkGetOptions.Builder()
    .db("orders")
    .docs(bulkGetDocs)
    .build();

BulkGetResult response =
    service.postBulkGet(bulkGetOptions).execute()
        .getResult();

System.out.println(response);
