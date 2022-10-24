// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.UuidsResult;
// section: code
Cloudant service = Cloudant.newInstance();

GetUuidsOptions uuidsOptions = new GetUuidsOptions.Builder()
    .count(10)
    .build();

UuidsResult response =
    service.getUuids(uuidsOptions).execute()
        .getResult();

System.out.println(response);
