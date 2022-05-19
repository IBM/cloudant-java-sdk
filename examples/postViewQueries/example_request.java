// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostViewQueriesOptions;
import com.ibm.cloud.cloudant.v1.model.ViewQueriesResult;
import com.ibm.cloud.cloudant.v1.model.ViewQuery;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

ViewQuery query1 = new ViewQuery.Builder()
    .includeDocs(true)
    .limit(5)
    .build();

ViewQuery query2 = new ViewQuery.Builder()
    .descending(true)
    .skip(1)
    .build();

PostViewQueriesOptions queriesOptions =
    new PostViewQueriesOptions.Builder()
        .db("users")
        .ddoc("allusers")
        .queries(Arrays.asList(query1, query2))
        .view("getVerifiedEmails")
        .build();

ViewQueriesResult response =
    service.postViewQueries(queriesOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `getVerifiedEmails` view to exist. To create the design document with this view, see [Create or modify a design document.](#putdesigndocument)
