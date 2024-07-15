// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CorsInformation;
// section: code
Cloudant service = Cloudant.newInstance();

CorsInformation response =
    service.getCorsInformation().execute().getResult();

System.out.println(response);
