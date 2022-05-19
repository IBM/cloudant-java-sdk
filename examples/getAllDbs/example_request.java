// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetAllDbsOptions;

import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

List<String> response =
    service.getAllDbs().execute().getResult();

System.out.println(response);
