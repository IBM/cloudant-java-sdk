// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostSearchOptions searchOptions = new PostSearchOptions.Builder()
    .db("users")
    .ddoc("allusers")
    .index("activeUsers")
    .query("name:Jane* AND active:True")
    .build();

SearchResult response =
    service.postSearch(searchOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `activeUsers` Cloudant Search index to exist. To create the design document with this index, see [Create or modify a design document.](#putdesigndocument)
