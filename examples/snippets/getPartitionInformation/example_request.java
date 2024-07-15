// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetPartitionInformationOptions;
import com.ibm.cloud.cloudant.v1.model.PartitionInformation;
// section: code
Cloudant service = Cloudant.newInstance();

GetPartitionInformationOptions informationOptions =
    new GetPartitionInformationOptions.Builder()
        .db("products")
        .partitionKey("small-appliances")
        .build();

PartitionInformation response =
    service.getPartitionInformation(informationOptions).execute()
        .getResult();

System.out.println(response);
