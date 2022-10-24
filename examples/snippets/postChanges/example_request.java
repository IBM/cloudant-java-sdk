// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ChangesResult;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostChangesOptions changesOptions = new PostChangesOptions.Builder()
    .db("orders")
    .build();

ChangesResult response =
    service.postChanges(changesOptions).execute()
        .getResult();

System.out.println(response);
