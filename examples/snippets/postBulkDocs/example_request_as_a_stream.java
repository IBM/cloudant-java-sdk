// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkDocsOptions;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
// section: code
Cloudant service = Cloudant.newInstance();

File file = new File("upload.json");
FileInputStream inputStream = new FileInputStream(file);

PostBulkDocsOptions bulkDocsOptions = new PostBulkDocsOptions.Builder()
    .db("events")
    .body(inputStream)
    .build();

List<DocumentResult> response =
    service.postBulkDocs(bulkDocsOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// Content of upload.json
// section: code
{
  "docs": [
    {
      "_id": "0007241142412418284",
      "type": "event",
      "userid": "abc123",
      "eventType": "addedToBasket",
      "productId": "1000042",
      "date": "2019-01-28T10:44:22.000Z"
    },
    {
      "_id": "0007241142412418285",
      "type": "event",
      "userid": "abc123",
      "eventType": "addedToBasket",
      "productId": "1000050",
      "date": "2019-01-25T20:00:00.000Z"
    }
  ]
}
