// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.MembershipInformation;
// section: code
Cloudant service = Cloudant.newInstance();

MembershipInformation response =
    service.getMembershipInformation().execute().getResult();

System.out.println(response);
