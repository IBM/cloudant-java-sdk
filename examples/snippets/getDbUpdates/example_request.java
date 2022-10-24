// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DbUpdates;
import com.ibm.cloud.cloudant.v1.model.GetDbUpdatesOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDbUpdatesOptions dbUpdatesOptions = new GetDbUpdatesOptions.Builder()
    .feed("normal")
    .heartbeat(10000)
    .since("now")
    .build();

DbUpdates response =
    service.getDbUpdates(dbUpdatesOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This request requires `server_admin` access.
