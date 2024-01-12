// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ExplainResult;
import com.ibm.cloud.cloudant.v1.model.PostExplainOptions;

import java.util.Collections;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, Object> selector = Collections.singletonMap(
    "type",
    Collections.singletonMap("$eq", "user"));

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
