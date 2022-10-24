// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CorsConfiguration;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PutCorsConfigurationOptions;
// section: code
Cloudant service = Cloudant.newInstance();

CorsConfiguration configuration = new CorsConfiguration.Builder()
    .addOrigins("https://example.com")
    .enableCors(true)
    .build();

PutCorsConfigurationOptions configurationOptions =
    new PutCorsConfigurationOptions.Builder()
        .corsConfiguration(configuration)
        .build();

Ok response =
    service.putCorsConfiguration(configurationOptions).execute()
        .getResult();

System.out.println(response);
