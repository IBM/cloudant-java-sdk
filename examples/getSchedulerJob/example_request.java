// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerJobOptions;
import com.ibm.cloud.cloudant.v1.model.SchedulerJob;
// section: code
Cloudant service = Cloudant.newInstance();

GetSchedulerJobOptions schedulerJobOptions =
    new GetSchedulerJobOptions.Builder()
        .jobId("7b94915cd8c4a0173c77c55cd0443939+continuous")
        .build();

SchedulerJob response =
    service.getSchedulerJob(schedulerJobOptions).execute()
        .getResult();

System.out.println(response);
