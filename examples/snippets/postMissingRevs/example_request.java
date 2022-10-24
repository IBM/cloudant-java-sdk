// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocumentRevisions;
import com.ibm.cloud.cloudant.v1.model.MissingRevsResult;
import com.ibm.cloud.cloudant.v1.model.PostMissingRevsOptions;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

DocumentRevisions revs = new DocumentRevisions();
revs.put(
  "order00077",
  Arrays.asList("<order00077-existing-revision>", "<2-missing-revision>")
);

PostMissingRevsOptions missingRevsOptions =
    new PostMissingRevsOptions.Builder()
        .db("orders")
        .missingRevs(revs)
        .build();

MissingRevsResult response =
    service.postMissingRevs(missingRevsOptions).execute()
        .getResult();

System.out.println(response);
