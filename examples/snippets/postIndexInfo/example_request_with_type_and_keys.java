// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.IndexInfoResult;
import com.ibm.cloud.cloudant.v1.model.PostIndexInfoOptions;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

PostIndexInfoOptions indexInfoOptions =
    new PostIndexInfoOptions.Builder()
        .db("recipes")
        .keys(Arrays.asList("_design/cookbook"))
        .type(Arrays.asList("search"))
        .build();

IndexInfoResult response =
    service.postIndexInfo(indexInfoOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `cookbook` design document to exist with a Cloudant Search index. To create the design document, see [Create or modify a design document.](#putdesigndocument)
