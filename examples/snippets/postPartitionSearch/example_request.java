// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostPartitionSearchOptions searchOptions =
    new PostPartitionSearchOptions.Builder()
        .db("events")
        .partitionKey("ns1HJS13AMkK")
        .ddoc("checkout")
        .index("findByDate")
        .query("date:[2019-01-01T12:00:00.000Z TO 2019-01-31T12:00:00.000Z]")
        .build();

SearchResult response =
    service.postPartitionSearch(searchOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `findByDate` Cloudant Search partitioned index to exist. To create the design document with this index, see [Create or modify a design document.](#putdesigndocument)
