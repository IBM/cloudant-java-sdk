// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ActivityTrackerEvents;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PostActivityTrackerEventsOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostActivityTrackerEventsOptions options =
    new PostActivityTrackerEventsOptions.Builder()
        .addTypes(ActivityTrackerEvents.Types.MANAGEMENT)
        .addTypes(ActivityTrackerEvents.Types.DATA)
        .build();

Ok response =
    service.postActivityTrackerEvents(options).execute().getResult();

System.out.println(response);
