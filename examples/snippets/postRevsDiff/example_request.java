// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostRevsDiffOptions;
import com.ibm.cloud.cloudant.v1.model.RevsDiff;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, List<String>> docRevisions = 
    Collections.singletonMap("prder00077", Arrays.asList("<1-missing-revision>",
        "<2-missing-revision>", "<3-possible-ancestor-revision>"));

PostRevsDiffOptions revsDiffOptions =
    new PostRevsDiffOptions.Builder()
        .db("orders")
        .documentRevisions(docRevisions)
        .build();

Map<String,RevsDiff> response =
    service.postRevsDiff(revsDiffOptions).execute()
        .getResult();

System.out.println(response);
