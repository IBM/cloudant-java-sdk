// section: code imports
import com.ibm.cloud.sdk.core.http.Headers;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadDatabaseOptions;
// section: code
Cloudant service = Cloudant.newInstance();

HeadDatabaseOptions databaseOptions =
    new HeadDatabaseOptions.Builder()
        .db("products")
        .build();

int statusCode =
    service.headDatabase(databaseOptions).execute().getStatusCode();

System.out.println(statusCode);
