// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PutCorsConfigurationOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PutCorsConfigurationOptions configurationOptions =
    new PutCorsConfigurationOptions.Builder()
        .addOrigins("https://example.com")
        .enableCors(true)
        .build();

Ok response =
    service.putCorsConfiguration(configurationOptions).execute()
        .getResult();

System.out.println(response);
