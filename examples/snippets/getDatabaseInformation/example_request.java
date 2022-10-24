// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformation;
import com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDatabaseInformationOptions databaseInfoOptions =
    new GetDatabaseInformationOptions.Builder()
        .db("products")
        .build();

DatabaseInformation response =
    service.getDatabaseInformation(databaseInfoOptions).execute()
        .getResult();

System.out.println(response);
