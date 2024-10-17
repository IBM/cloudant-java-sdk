// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ExplainResult;
import com.ibm.cloud.cloudant.v1.model.PostPartitionExplainOptions;

import java.util.Collections;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, Object> selector = Collections.singletonMap(
    "userId",
    Collections.singletonMap("$eq", "abc123"));

PostPartitionExplainOptions explainOptions =
    new PostPartitionExplainOptions.Builder()
        .db("events")
        .executionStats(true)
        .limit(10)
        .partitionKey("ns1HJS13AMkK")
        .selector(selector)
        .build();

ExplainResult response =
    service.postPartitionExplain(explainOptions).execute()
        .getResult();

System.out.println(response);
