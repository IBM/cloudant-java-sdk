// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ChangesResult;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;

import java.io.InputStream;
import java.io.File;
import java.nio.file.StandardCopyOption;
// section: code
Cloudant service = Cloudant.newInstance();

PostChangesOptions changesOptions = new PostChangesOptions.Builder()
    .db("orders")
    .build();

File file = new File("result.json");

try (InputStream response =
        service.postChangesAsStream(changesOptions).execute()
            .getResult()) {
    java.nio.file.Files.copy(
        response,
        file.toPath(),
        StandardCopyOption.REPLACE_EXISTING);
}
