// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteDatabaseOptions;
import com.ibm.cloud.cloudant.v1.model.Ok;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteDatabaseOptions databaseOptions =
    new DeleteDatabaseOptions.Builder()
        .db("products")
        .build();

Ok response =
    service.deleteDatabase(databaseOptions).execute()
        .getResult();

System.out.println(response);
