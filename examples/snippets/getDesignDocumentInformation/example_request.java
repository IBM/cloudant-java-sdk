// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentInformation;
import com.ibm.cloud.cloudant.v1.model.GetDesignDocumentInformationOptions;


// section: code
Cloudant service = Cloudant.newInstance();

GetDesignDocumentInformationOptions informationOptions =
    new GetDesignDocumentInformationOptions.Builder()
        .db("stores")
        .ddoc("appliances")
        .build();

DesignDocumentInformation response =
    service.getDesignDocumentInformation(informationOptions).execute()
        .getResult();

System.out.println(response);
