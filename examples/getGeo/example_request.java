// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GeoResult;
import com.ibm.cloud.cloudant.v1.model.GetGeoOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetGeoOptions geoOptions = new GetGeoOptions.Builder()
    .db("stores")
    .ddoc("places")
    .index("pointsInEngland")
    .bbox("-50.52,-4.46,54.59,1.45")
    .includeDocs(true)
    .nearest(true)
    .build();

GeoResult response =
    service.getGeo(geoOptions).execute()
        .getResult();

System.out.println(response);
