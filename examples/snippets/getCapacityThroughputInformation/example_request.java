// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CapacityThroughputInformation;
// section: code
Cloudant service = Cloudant.newInstance();

CapacityThroughputInformation response =
    service.getCapacityThroughputInformation().execute().getResult();

System.out.println(response);
