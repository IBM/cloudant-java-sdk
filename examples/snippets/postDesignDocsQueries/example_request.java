// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsQueriesResult;
import com.ibm.cloud.cloudant.v1.model.AllDocsQuery;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsQueriesOptions;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

AllDocsQuery query1 = new AllDocsQuery.Builder()
    .descending(true)
    .includeDocs(true)
    .limit(10)
    .build();
AllDocsQuery query2 = new AllDocsQuery.Builder()
    .inclusiveEnd(true)
    .startKey("_design/allusers")
    .skip(1)
    .build();

PostDesignDocsQueriesOptions queriesOptions =
    new PostDesignDocsQueriesOptions.Builder()
        .db("users")
        .queries(Arrays.asList(query1, query2))
        .build();

AllDocsQueriesResult response =
    service.postDesignDocsQueries(queriesOptions).execute()
        .getResult();

System.out.println(response);
