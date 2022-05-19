// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetAttachmentOptions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
// section: code
Cloudant service = Cloudant.newInstance();

GetAttachmentOptions attachmentOptions =
    new GetAttachmentOptions.Builder()
        .db("products")
        .docId("small-appliances:100001")
        .attachmentName("product_details.txt")
        .build();

InputStream streamResult =
    service.getAttachment(attachmentOptions).execute()
        .getResult();

String response =
    new BufferedReader(new InputStreamReader(streamResult))
        .lines().collect(Collectors.joining("\n"));

System.out.println(response);
// section: markdown
// This example requires the `product_details.txt` attachment in `small-appliances:100001` document to exist. To create the attachment, see [Create or modify an attachment.](#putattachment)
