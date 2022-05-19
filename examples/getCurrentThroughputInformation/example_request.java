// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CurrentThroughputInformation;
// section: code
Cloudant service = Cloudant.newInstance();

CurrentThroughputInformation response =
    service.getCurrentThroughputInformation().execute().getResult();

System.out.println(response);
