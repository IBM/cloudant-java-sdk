// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSecurityOptions;
import com.ibm.cloud.cloudant.v1.model.Security;
// section: code
Cloudant service = Cloudant.newInstance();

GetSecurityOptions securityOptions =
    new GetSecurityOptions.Builder()
        .db("products")
        .build();

Security response =
    service.getSecurity(securityOptions).execute()
        .getResult();

System.out.println(response);
