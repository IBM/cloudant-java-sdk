// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PutAttachmentOptions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
// section: code
Cloudant service = Cloudant.newInstance();

String detailedDescription = "This appliance includes...";

InputStream detailedDescriptionStream =
    new ByteArrayInputStream(detailedDescription
        .getBytes(StandardCharsets.UTF_8));

PutAttachmentOptions attachmentOptions =
    new PutAttachmentOptions.Builder()
        .db("products")
        .docId("1000042")
        .attachmentName("product_details.txt")
        .attachment(detailedDescriptionStream)
        .contentType("text/plain")
        .build();

DocumentResult response =
    service.putAttachment(attachmentOptions).execute()
        .getResult();

System.out.println(response);
