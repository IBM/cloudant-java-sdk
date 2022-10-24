// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;

import java.io.InputStream;
import java.io.File;
import java.nio.file.StandardCopyOption;
// section: code
Cloudant service = Cloudant.newInstance();

PostAllDocsOptions docsOptions =
    new PostAllDocsOptions.Builder()
        .db("orders")
        .includeDocs(true)
        .startKey("abc")
        .limit(10)
        .build();

File file = new File("result.json");

try (InputStream response =
        service.postAllDocsAsStream(docsOptions).execute()
            .getResult()) {
    java.nio.file.Files.copy(
        response,
        file.toPath(),
        StandardCopyOption.REPLACE_EXISTING);
}
