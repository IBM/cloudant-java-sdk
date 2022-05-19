// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.FindResult;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, Object> selector = Collections.singletonMap(
    "address",
    Collections.singletonMap("$regex", "Street"));

PostFindOptions findOptions = new PostFindOptions.Builder()
    .db("users")
    .selector(selector)
    .fields(Arrays.asList("_id", "type", "name", "email", "address"))
    .limit(3)
    .build();

FindResult response =
    service.postFind(findOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `getUserByAddress` Cloudant Query "text" index to exist. To create the index, see [Create a new index on a database.](#postindex)
