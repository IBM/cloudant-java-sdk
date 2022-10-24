// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostViewOptions viewOptions = new PostViewOptions.Builder()
    .db("users")
    .ddoc("allusers")
    .view("getVerifiedEmails")
    .build();

ViewResult response =
    service.postView(viewOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `getVerifiedEmails` view to exist. To create the design document with this view, see [Create or modify a design document.](#putdesigndocument)
