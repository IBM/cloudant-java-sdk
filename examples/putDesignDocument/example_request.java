// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DesignDocument;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentViewsMapReduce;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PutDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.SearchIndexDefinition;

import java.util.Collections;
// section: code
Cloudant service = Cloudant.newInstance();

DesignDocumentViewsMapReduce emailViewMapReduce =
    new DesignDocumentViewsMapReduce.Builder()
        .map("function(doc) { if(doc.email_verified  === true){\n  emit(doc.email, [doc.name, doc.email_verified, doc.joined]) }}")
        .build();

SearchIndexDefinition usersIndex =
    new SearchIndexDefinition.Builder()
        .index("function (doc) {\n  index(\"name\", doc.name);\n  index(\"active\", doc.active);\n}")
        .build();

DesignDocument designDocument = new DesignDocument();
designDocument.setViews(
    Collections.singletonMap("getVerifiedEmails", emailViewMapReduce));
designDocument.setIndexes(
    Collections.singletonMap("activeUsers", usersIndex));

PutDesignDocumentOptions designDocumentOptions =
    new PutDesignDocumentOptions.Builder()
        .db("users")
        .designDocument(designDocument)
        .ddoc("allusers")
        .build();

DocumentResult response =
    service.putDesignDocument(designDocumentOptions).execute()
        .getResult();

DesignDocumentViewsMapReduce applianceView =
    new DesignDocumentViewsMapReduce.Builder()
        .map("function(doc) { emit(doc.productid, [doc.brand, doc.name, doc.description]) }")
        .build();

SearchIndexDefinition priceIndex =
    new SearchIndexDefinition.Builder()
        .index("function (doc) {  index(\"price\", doc.price);}")
        .build();

DesignDocument partitionedDesignDocument = new DesignDocument();
partitionedDesignDocument.setViews(
    Collections.singletonMap("byApplianceProdId", applianceView));
partitionedDesignDocument.setIndexes(
    Collections.singletonMap("findByPrice", priceIndex));

PutDesignDocumentOptions partitionedDesignDocumentOptions =
    new PutDesignDocumentOptions.Builder()
        .db("products")
        .designDocument(partitionedDesignDocument)
        .ddoc("appliances")
        .build();

DocumentResult response =
    service.putDesignDocument(partitionedDesignDocumentOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example creates `allusers` design document in the `users` database and `appliances` design document in the partitioned `products` database.
