// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerJobsOptions;
import com.ibm.cloud.cloudant.v1.model.SchedulerJobsResult;
// section: code
Cloudant service = Cloudant.newInstance();

GetSchedulerJobsOptions schedulerJobsOptions =
    new GetSchedulerJobsOptions.Builder()
        .limit(100)
        .build();

SchedulerJobsResult response =
    service.getSchedulerJobs(schedulerJobsOptions).execute()
        .getResult();

System.out.println(response);
