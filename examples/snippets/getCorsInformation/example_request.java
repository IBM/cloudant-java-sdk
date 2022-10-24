// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CorsConfiguration;
// section: code
Cloudant service = Cloudant.newInstance();

CorsConfiguration response =
    service.getCorsInformation().execute().getResult();

System.out.println(response);
