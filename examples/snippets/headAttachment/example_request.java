// section: code imports
import com.ibm.cloud.sdk.core.http.Headers;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadAttachmentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

HeadAttachmentOptions attachmentOptions =
    new HeadAttachmentOptions.Builder()
        .db("products")
        .docId("1000042")
        .attachmentName("product_details.txt")
        .build();

int statusCode =
    service.headAttachment(attachmentOptions).execute()
        .getStatusCode();

Headers headers =
    service.headAttachment(attachmentOptions).execute()
        .getHeaders();

System.out.println(statusCode);
System.out.println(headers.values("Content-Length"));
System.out.println(headers.values("Content-Type"));
// section: markdown
// This example requires the `product_details.txt` attachment in `1000042` document to exist. To create the attachment, see [Create or modify an attachment.](#putattachment)
