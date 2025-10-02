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
    Collections.singletonMap("order00077", Arrays.asList(
        "1-00000000000000000000000000000000", // missing revision
        "2-11111111111111111111111111111111", // missing revision
        "3-22222222222222222222222222222222"  // possible ancestor revision
    ));

PostRevsDiffOptions revsDiffOptions =
    new PostRevsDiffOptions.Builder()
        .db("orders")
        .documentRevisions(docRevisions)
        .build();

Map<String,RevsDiff> response =
    service.postRevsDiff(revsDiffOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the example revisions in the POST body to be replaced with valid revisions.
