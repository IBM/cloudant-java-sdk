// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ActiveTask;
// section: code
Cloudant service = Cloudant.newInstance();

List<ActiveTask> response =
    service.getActiveTasks().execute().getResult();

System.out.println(response);
