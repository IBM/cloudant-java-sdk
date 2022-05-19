// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CapacityThroughputInformation;
import com.ibm.cloud.cloudant.v1.model.PutCapacityThroughputConfigurationOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PutCapacityThroughputConfigurationOptions options =
    new PutCapacityThroughputConfigurationOptions.Builder()
        .blocks(1)
        .build();

CapacityThroughputInformation response =
    service.putCapacityThroughputConfiguration(options).execute().getResult();

System.out.println(response);
