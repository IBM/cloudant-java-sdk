// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GeoIndexInformation;
import com.ibm.cloud.cloudant.v1.model.GetGeoIndexInformationOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetGeoIndexInformationOptions informationOptions =
    new GetGeoIndexInformationOptions.Builder()
        .db("stores")
        .ddoc("places")
        .index("pointsInEngland")
        .build();

GeoIndexInformation response =
    service.getGeoIndexInformation(informationOptions).execute()
        .getResult();

System.out.println(response);
