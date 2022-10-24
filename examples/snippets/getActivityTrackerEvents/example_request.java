// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ActivityTrackerEvents;
// section: code
Cloudant service = Cloudant.newInstance();

ActivityTrackerEvents response =
    service.getActivityTrackerEvents().execute().getResult();

System.out.println(response);
