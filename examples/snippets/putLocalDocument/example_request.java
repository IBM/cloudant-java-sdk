// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PutLocalDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

Document orderDocument = new Document();
orderDocument.put("type", "order");
orderDocument.put("user", "Bob Smith");
orderDocument.put("orderid", "0007741142412418284");
orderDocument.put("userid", "abc123");
orderDocument.put("total", 214.98);
orderDocument.put("deliveryAddress", "19 Front Street, Darlington, DL5 1TY");
orderDocument.put("delivered", true);
orderDocument.put("courier", "UPS");
orderDocument.put("courierid", "15125425151261289");
orderDocument.put("date", "2019-01-28T10:44:22.000Z");

PutLocalDocumentOptions documentOptions =
    new PutLocalDocumentOptions.Builder()
        .db("orders")
        .docId("local-0007741142412418284")
        .document(orderDocument)
        .build();

DocumentResult response =
    service.putLocalDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
