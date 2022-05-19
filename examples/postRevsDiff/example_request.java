// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocumentRevisions;
import com.ibm.cloud.cloudant.v1.model.PostRevsDiffOptions;
import com.ibm.cloud.cloudant.v1.model.RevsDiffResult;
// section: code
Cloudant service = Cloudant.newInstance();

DocumentRevisions revsDiff = new DocumentRevisions();
revsDiff.put("order00077", Arrays.asList("<1-missing-revision>",
  "<2-missing-revision>", "<3-possible-ancestor-revision>"));

PostRevsDiffOptions revsDiffOptions =
    new PostRevsDiffOptions.Builder()
        .db("orders")
        .revsDiffRequest(revsDiff)
        .build();

RevsDiffResult response =
    service.postRevsDiff(revsDiffOptions).execute()
        .getResult();

System.out.println(response);
