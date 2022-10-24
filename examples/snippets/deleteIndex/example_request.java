// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteIndexOptions;
import com.ibm.cloud.cloudant.v1.model.Ok;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteIndexOptions indexOptions = new DeleteIndexOptions.Builder()
    .db("users")
    .ddoc("json-index")
    .index("getUserByName")
    .type("json")
    .build();

Ok response =
    service.deleteIndex(indexOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example will fail if `getUserByName` index doesn't exist. To create the index, see [Create a new index on a database.](#postindex)
