// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostPartitionSearchOptions searchOptions =
    new PostPartitionSearchOptions.Builder()
        .db("products")
        .partitionKey("small-appliances")
        .ddoc("appliances")
        .index("findByPrice")
        .query("price:[14 TO 20]")
        .build();

SearchResult response =
    service.postPartitionSearch(searchOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `findByPrice` Cloudant Search partitioned index to exist. To create the design document with this index, see [Create or modify a design document.](#putdesigndocument)
