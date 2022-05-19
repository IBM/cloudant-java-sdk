// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PostGeoCleanupOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostGeoCleanupOptions geoCleanupOptions =
    new PostGeoCleanupOptions.Builder()
        .db("stores")
        .build();

Ok response =
    service.postGeoCleanup(geoCleanupOptions).execute()
        .getResult();

System.out.println(response);
