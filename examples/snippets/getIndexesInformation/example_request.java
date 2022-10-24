// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetIndexesInformationOptions;
import com.ibm.cloud.cloudant.v1.model.IndexesInformation;
// section: code
Cloudant service = Cloudant.newInstance();

GetIndexesInformationOptions indexesInformationOptions =
    new GetIndexesInformationOptions.Builder()
        .db("users")
        .build();

IndexesInformation response =
    service.getIndexesInformation(indexesInformationOptions).execute()
        .getResult();

System.out.println(response);
