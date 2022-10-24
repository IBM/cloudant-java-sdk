// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.UpInformation;
// section: code
Cloudant service = Cloudant.newInstance();

UpInformation response =
    service.getUpInformation().execute().getResult();

System.out.println(response);
