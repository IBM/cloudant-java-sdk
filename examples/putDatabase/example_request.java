// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PutDatabaseOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PutDatabaseOptions databaseOptions = new PutDatabaseOptions.Builder()
    .db("products")
    .partitioned(true)
    .build();

Ok response =
    service.putDatabase(databaseOptions).execute()
        .getResult();

System.out.println(response);
