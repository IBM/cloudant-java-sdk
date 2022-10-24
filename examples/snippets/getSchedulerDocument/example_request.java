// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.SchedulerDocument;
// section: code
Cloudant service = Cloudant.newInstance();

GetSchedulerDocumentOptions schedulerDocumentOptions =
    new GetSchedulerDocumentOptions.Builder()
        .docId("repldoc-example")
        .build();

SchedulerDocument response =
    service.getSchedulerDocument(schedulerDocumentOptions).execute()
        .getResult();

System.out.println(response);
