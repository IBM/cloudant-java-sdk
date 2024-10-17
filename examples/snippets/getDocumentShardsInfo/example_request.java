// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocumentShardInfo;
import com.ibm.cloud.cloudant.v1.model.GetDocumentShardsInfoOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDocumentShardsInfoOptions shardsInfoOptions =
    new GetDocumentShardsInfoOptions.Builder()
        .db("products")
        .docId("1000042")
        .build();

DocumentShardInfo response =
    service.getDocumentShardsInfo(shardsInfoOptions).execute()
        .getResult();

System.out.println(response);
