// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostPartitionAllDocsOptions allDocsOptions =
    new PostPartitionAllDocsOptions.Builder()
        .db("events")
        .partitionKey("ns1HJS13AMkK")
        .includeDocs(true)
        .build();

AllDocsResult response =
    service.postPartitionAllDocs(allDocsOptions).execute()
        .getResult();

System.out.println(response);
