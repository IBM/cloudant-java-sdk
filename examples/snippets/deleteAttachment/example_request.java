// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteAttachmentOptions attachmentOptions =
    new DeleteAttachmentOptions.Builder()
        .db("products")
        .docId("1000042")
        .attachmentName("product_details.txt")
        .rev("4-33333333333333333333333333333333")
        .build();

DocumentResult response =
    service.deleteAttachment(attachmentOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `product_details.txt` attachment in `1000042` document to exist. To create the attachment, see [Create or modify an attachment.](#putattachment)
