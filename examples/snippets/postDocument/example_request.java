// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PostDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

Document productsDocument = new Document();
productsDocument.setId("small-appliances:1000042");
productsDocument.put("type", "product");
productsDocument.put("productid", "1000042");
productsDocument.put("brand", "Salter");
productsDocument.put("name", "Digital Kitchen Scales");
productsDocument.put("description", "Slim Colourful Design Electronic"
    + "Cooking Appliance for Home/Kitchen, Weigh up to 5kg + Aquatronic"
    + "for Liquids ml + fl. oz. 15Yr Guarantee - Green");
productsDocument.put("price", 14.99);
productsDocument.put("image", "assets/img/0gmsnghhew.jpg");

PostDocumentOptions documentOptions =
    new PostDocumentOptions.Builder()
        .db("products")
        .document(productsDocument)
        .build();

DocumentResult response =
    service.postDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
