// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.exception.ServiceUnavailableException;
// section: code
Cloudant service = Cloudant.newInstance();

try {
    // Execute the health check
    Response<Void> response = service.headUpInformation().execute();
    // Check the status code to determine service health
    System.out.println("Service is up and healthy");
} catch (ServiceUnavailableException e) {
    System.out.println("Service unavailable:" + " \"" + e.getMessage() + "\" " + "Status code: "
            + e.getStatusCode());
} catch (ServiceResponseException e) {
    System.out.println("Issue performing health check: \"" + e.getMessage() + "\" Status code: "
            + e.getStatusCode());
}
