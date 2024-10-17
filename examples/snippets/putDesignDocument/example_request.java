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
        .map("function(doc) { if(doc.email_verified === true) { emit(doc.email, [doc.name, doc.email_verified, doc.joined]); }}")
        .build();

SearchIndexDefinition usersIndex =
    new SearchIndexDefinition.Builder()
        .index("function(doc) { index(\"name\", doc.name); index(\"active\", doc.active); }")
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

DocumentResult allusersResponse =
    service.putDesignDocument(designDocumentOptions).execute()
        .getResult();

System.out.println(allusersResponse);

DesignDocumentViewsMapReduce applianceView =
    new DesignDocumentViewsMapReduce.Builder()
        .map("function(doc) { emit(doc.productId, [doc.date, doc.eventType, doc.userId]); }")
        .build();

SearchIndexDefinition dateIndex =
    new SearchIndexDefinition.Builder()
        .index("function(doc) { index(\"date\", doc.date); }")
        .build();

DesignDocument partitionedDesignDocument = new DesignDocument();
partitionedDesignDocument.setViews(
    Collections.singletonMap("byProductId", applianceView));
partitionedDesignDocument.setIndexes(
    Collections.singletonMap("findByDate", dateIndex));

PutDesignDocumentOptions partitionedDesignDocumentOptions =
    new PutDesignDocumentOptions.Builder()
        .db("events")
        .designDocument(partitionedDesignDocument)
        .ddoc("checkout")
        .build();

DocumentResult appliancesResponse =
    service.putDesignDocument(partitionedDesignDocumentOptions).execute()
        .getResult();

System.out.println(appliancesResponse);
// section: markdown
// This example creates `allusers` design document in the `users` database and `checkout` design document in the partitioned `events` database.
