// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsQuery;
import com.ibm.cloud.cloudant.v1.model.AllDocsQueriesResult;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsQueriesOptions;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

AllDocsQuery query1 = new AllDocsQuery.Builder()
    .keys(Arrays.asList("small-appliances:1000042",
        "small-appliances:1000043"))
    .build();

AllDocsQuery query2 = new AllDocsQuery.Builder()
    .limit(3)
    .skip(2)
    .build();

PostAllDocsQueriesOptions queriesOptions =
    new PostAllDocsQueriesOptions.Builder()
        .queries(Arrays.asList(query1, query2))
        .db("products")
        .build();

AllDocsQueriesResult response =
    service.postAllDocsQueries(queriesOptions).execute()
        .getResult();

System.out.println(response);
