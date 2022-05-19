// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ServerInformation;
// section: code
Cloudant service = Cloudant.newInstance();

ServerInformation response =
    service.getServerInformation().execute().getResult();

System.out.println(response);
