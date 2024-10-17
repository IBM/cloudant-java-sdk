// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSearchInfoOptions;
import com.ibm.cloud.cloudant.v1.model.SearchInfoResult;
// section: code
Cloudant service = Cloudant.newInstance();

GetSearchInfoOptions infoOptions =
    new GetSearchInfoOptions.Builder()
        .db("events")
        .ddoc("checkout")
        .index("findByDate")
        .build();

SearchInfoResult response =
    service.getSearchInfo(infoOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `findByDate` Cloudant Search partitioned index to exist. To create the design document with this index, see [Create or modify a design document.](#putdesigndocument)
