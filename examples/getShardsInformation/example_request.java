// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetShardsInformationOptions;
import com.ibm.cloud.cloudant.v1.model.ShardsInformation;
// section: code
Cloudant service = Cloudant.newInstance();

GetShardsInformationOptions shardsInformationOptions =
    new GetShardsInformationOptions.Builder()
        .db("products")
        .build();

ShardsInformation response =
    service.getShardsInformation(shardsInformationOptions)
        .execute().getResult();

System.out.println(response);
