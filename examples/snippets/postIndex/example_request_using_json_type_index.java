// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.IndexDefinition;
import com.ibm.cloud.cloudant.v1.model.IndexField;
import com.ibm.cloud.cloudant.v1.model.IndexResult;
import com.ibm.cloud.cloudant.v1.model.PostIndexOptions;
// section: code
Cloudant service = Cloudant.newInstance();
// Type "json" index fields require an object that maps the name of a field to a sort direction.

IndexField field = new IndexField.Builder()
    .add("email", "asc")
    .build();

IndexDefinition indexDefinition = new IndexDefinition.Builder()
    .addFields(field)
    .build();

PostIndexOptions indexOptions = new PostIndexOptions.Builder()
    .db("users")
    .ddoc("json-index")
    .index(indexDefinition)
    .name("getUserByEmail")
    .type("json")
    .build();

IndexResult response =
    service.postIndex(indexOptions).execute()
        .getResult();

System.out.println(response);
