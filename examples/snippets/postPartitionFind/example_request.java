// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.FindResult;
import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, String> typeEqualsProduct = new HashMap<>();
typeEqualsProduct.put("$eq", "product");

Map<String, Object> selector = new HashMap<>();
selector.put("type", typeEqualsProduct);

PostPartitionFindOptions findOptions =
    new PostPartitionFindOptions.Builder()
        .db("products")
        .partitionKey("small-appliances")
        .fields(Arrays.asList("productid", "name", "description"))
        .selector(selector)
        .build();

FindResult response =
    service.postPartitionFind(findOptions).execute()
        .getResult();

System.out.println(response);
