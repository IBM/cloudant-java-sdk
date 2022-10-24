// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteAttachmentOptions attachmentOptions =
    new DeleteAttachmentOptions.Builder()
        .db("products")
        .docId("small-appliances:100001")
        .attachmentName("product_details.txt")
        .rev("4-1a0d1cd6f40472509e9aac646183736a")
        .build();

DocumentResult response =
    service.deleteAttachment(attachmentOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `product_details.txt` attachment in `small-appliances:100001` document to exist. To create the attachment, see [Create or modify an attachment.](#putattachment)
