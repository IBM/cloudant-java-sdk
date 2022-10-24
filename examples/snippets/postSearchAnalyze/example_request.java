// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostSearchAnalyzeOptions;
import com.ibm.cloud.cloudant.v1.model.SearchAnalyzeResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostSearchAnalyzeOptions searchAnalyzerOptions =
    new PostSearchAnalyzeOptions.Builder()
        .analyzer("english")
        .text("running is fun")
        .build();

SearchAnalyzeResult response =
    service.postSearchAnalyze(searchAnalyzerOptions).execute()
        .getResult();

System.out.println(response);
