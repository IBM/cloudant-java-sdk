// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostPartitionViewOptions viewOptions =
    new PostPartitionViewOptions.Builder()
        .db("events")
        .ddoc("checkout")
        .includeDocs(true)
        .limit(10)
        .partitionKey("ns1HJS13AMkK")
        .view("byProductId")
        .build();

ViewResult response =
    service.postPartitionView(viewOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `byProductId` partitioned view to exist. To create the design document with this view, see [Create or modify a design document.](#putdesigndocument)
