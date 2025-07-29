// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.IndexDefinition;
import com.ibm.cloud.cloudant.v1.model.IndexField;
import com.ibm.cloud.cloudant.v1.model.IndexResult;
import com.ibm.cloud.cloudant.v1.model.PostIndexOptions;
// section: code
Cloudant service = Cloudant.newInstance();

// Type "text" index fields require an object with a name and type properties for the field.
IndexField field = new IndexField.Builder()
    .name("address")
    .type(IndexField.Type.STRING)
    .build();

IndexDefinition indexDefinition = new IndexDefinition.Builder()
    .addFields(field)
    .build();

PostIndexOptions indexOptions = new PostIndexOptions.Builder()
    .db("users")
    .ddoc("text-index")
    .index(indexDefinition)
    .name("getUserByAddress")
    .type("text")
    .build();

IndexResult response =
    service.postIndex(indexOptions).execute()
        .getResult();

System.out.println(response);
