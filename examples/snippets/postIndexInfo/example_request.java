// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.IndexInfoResult;
import com.ibm.cloud.cloudant.v1.model.PostIndexInfoOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostIndexInfoOptions indexInfoOptions =
    new PostIndexInfoOptions.Builder()
        .db("recipes")
        .build();

IndexInfoResult response =
    service.postIndexInfo(indexInfoOptions).execute()
        .getResult();

System.out.println(response);
