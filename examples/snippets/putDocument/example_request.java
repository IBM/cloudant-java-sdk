// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PutDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

Document eventDoc = new Document();
eventDoc.put("type", "event");
eventDoc.put("userId", "abc123");
eventDoc.put("eventType", "addedToBasket");
eventDoc.put("productId", "1000042");
eventDoc.put("date", "2019-01-28T10:44:22.000Z");

PutDocumentOptions documentOptions =
    new PutDocumentOptions.Builder()
        .db("events")
        .docId("ns1HJS13AMkK:0007241142412418284")
        .document(eventDoc)
        .build();

DocumentResult response =
    service.putDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
