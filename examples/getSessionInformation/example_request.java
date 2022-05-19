// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.SessionInformation;
// section: code
Cloudant service = Cloudant.newInstance();

SessionInformation response =
    service.getSessionInformation().execute().getResult();

System.out.println(response);
// section: markdown
// For more details on Session Authentication, see [Authentication.](#authentication)
