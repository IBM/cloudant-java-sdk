// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ApiKeysResult;
// section: code
Cloudant service = Cloudant.newInstance();

ApiKeysResult response =
    service.postApiKeys().execute().getResult();

System.out.println(response);
