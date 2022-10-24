// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DbsInfoResult;
import com.ibm.cloud.cloudant.v1.model.PostDbsInfoOptions;

import java.util.Arrays;
import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

PostDbsInfoOptions dbsInfoOptions =
    new PostDbsInfoOptions.Builder()
        .keys(Arrays.asList("products", "users", "orders"))
        .build();

List<DbsInfoResult> response =
    service.postDbsInfo(dbsInfoOptions).execute()
        .getResult();

System.out.println(response);
