// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ExplainResult;
import com.ibm.cloud.cloudant.v1.model.PostExplainOptions;
import com.ibm.cloud.cloudant.v1.model.Selector;

import java.util.HashMap;
// section: code
Cloudant service = Cloudant.newInstance();

Selector selector = new Selector();
selector.put("type", new HashMap<>().put("$eq", "user"));

PostExplainOptions explainOptions =
    new PostExplainOptions.Builder()
        .db("users")
        .executionStats(true)
        .limit(10)
        .selector(selector)
        .build();

ExplainResult response =
    service.postExplain(explainOptions).execute()
        .getResult();

System.out.println(response);
