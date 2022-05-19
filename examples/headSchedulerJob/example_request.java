// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadSchedulerJobOptions;
// section: code
Cloudant service = Cloudant.newInstance();

HeadSchedulerJobOptions schedulerJobOptions =
    new HeadSchedulerJobOptions.Builder()
        .jobId("7b94915cd8c4a0173c77c55cd0443939+continuous")
        .build();

int statusCode =
    service.headSchedulerJob(schedulerJobOptions).execute()
        .getStatusCode();

System.out.println(statusCode);
