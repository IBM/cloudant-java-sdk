// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerDocsOptions;
import com.ibm.cloud.cloudant.v1.model.SchedulerDocsResult;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

GetSchedulerDocsOptions schedulerDocsOptions = new GetSchedulerDocsOptions.Builder()
    .limit(100)
    .states(Arrays.asList("completed"))
    .build();

SchedulerDocsResult response =
    service.getSchedulerDocs(schedulerDocsOptions).execute()
        .getResult();

System.out.println(response);
