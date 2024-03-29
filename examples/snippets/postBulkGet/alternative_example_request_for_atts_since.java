// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.BulkGetQueryDocument;
import com.ibm.cloud.cloudant.v1.model.BulkGetResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkGetOptions;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

BulkGetQueryDocument bulkGetQueryDocument =
    new BulkGetQueryDocument.Builder()
        .id("order00058")
        .addAttsSince("1-99b02e08da151943c2dcb40090160bb8")
        .build();

PostBulkGetOptions postBulkGetOptions =
    new PostBulkGetOptions.Builder()
        .db("orders")
        .docs(Arrays.asList(bulkGetQueryDocument)).build();

BulkGetResult response =
    service.postBulkGet(postBulkGetOptions).execute()
        .getResult();

System.out.println(response);
