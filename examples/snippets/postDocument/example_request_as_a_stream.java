// section: code imports
import java.io.FileInputStream;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PostDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

try (FileInputStream productsDocumentStream = new FileInputStream("products_doc.json")) {
    PostDocumentOptions documentOptions =
        new PostDocumentOptions.Builder()
            .db("products")
            .contentType("application/json")
            .body(productsDocumentStream)
            .build();

    DocumentResult response =
        service.postDocument(documentOptions).execute()
            .getResult();

    System.out.println(response);
}
