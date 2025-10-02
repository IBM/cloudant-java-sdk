# Examples for java

## getServerInformation

_GET `/`_

### [Example request](snippets/getServerInformation/example_request.java)

[embedmd]:# (snippets/getServerInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ServerInformation;
// section: code
Cloudant service = Cloudant.newInstance();

ServerInformation response =
    service.getServerInformation().execute().getResult();

System.out.println(response);
```

## getActiveTasks

_GET `/_active_tasks`_

### [Example request](snippets/getActiveTasks/example_request.java)

[embedmd]:# (snippets/getActiveTasks/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ActiveTask;
// section: code
Cloudant service = Cloudant.newInstance();

List<ActiveTask> response =
    service.getActiveTasks().execute().getResult();

System.out.println(response);
```

## getAllDbs

_GET `/_all_dbs`_

### [Example request](snippets/getAllDbs/example_request.java)

[embedmd]:# (snippets/getAllDbs/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;

import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

List<String> response =
    service.getAllDbs().execute().getResult();

System.out.println(response);
```

## postApiKeys

_POST `/_api/v2/api_keys`_

### [Example request](snippets/postApiKeys/example_request.java)

[embedmd]:# (snippets/postApiKeys/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ApiKeysResult;
// section: code
Cloudant service = Cloudant.newInstance();

ApiKeysResult response =
    service.postApiKeys().execute().getResult();

System.out.println(response);
```

## putCloudantSecurity

_PUT `/_api/v2/db/{db}/_security`_

### [Example request](snippets/putCloudantSecurity/example_request.java)

[embedmd]:# (snippets/putCloudantSecurity/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PutCloudantSecurityConfigurationOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, List<String>> securityObject = new HashMap<>();
securityObject.put("nobody", Arrays.asList("_reader"));

PutCloudantSecurityConfigurationOptions securityOptions =
    new PutCloudantSecurityConfigurationOptions.Builder()
        .db("products")
        .cloudant(securityObject)
        .build();

Ok response =
    service.putCloudantSecurityConfiguration(securityOptions)
        .execute()
        .getResult();

System.out.println(response);
// section: markdown
// The `nobody` username applies to all unauthenticated connection attempts. For example, if an application tries to read data from a database, but didn't identify itself, the task can continue only if the `nobody` user has the role `_reader`.
// section: markdown
// If instead of using Cloudant's security model for managing permissions you opt to use the Apache CouchDB `_users` database (that is using legacy credentials _and_ the `couchdb_auth_only:true` option) then be aware that the user must already exist in `_users` database before adding permissions. For information on the `_users` database, see <a href="https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-work-with-your-account#using-the-users-database-with-cloudant-nosql-db" target="_blank">Using the `_users` database with Cloudant</a>.
```

## getActivityTrackerEvents

_GET `/_api/v2/user/activity_tracker/events`_

### [Example request](snippets/getActivityTrackerEvents/example_request.java)

[embedmd]:# (snippets/getActivityTrackerEvents/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ActivityTrackerEvents;
// section: code
Cloudant service = Cloudant.newInstance();

ActivityTrackerEvents response =
    service.getActivityTrackerEvents().execute().getResult();

System.out.println(response);
```

## postActivityTrackerEvents

_POST `/_api/v2/user/activity_tracker/events`_

### [Example request](snippets/postActivityTrackerEvents/example_request.java)

[embedmd]:# (snippets/postActivityTrackerEvents/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PostActivityTrackerEventsOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostActivityTrackerEventsOptions options =
    new PostActivityTrackerEventsOptions.Builder()
        .addTypes("management")
        .build();

Ok response =
    service.postActivityTrackerEvents(options).execute().getResult();

System.out.println(response);
```

## getCapacityThroughputInformation

_GET `/_api/v2/user/capacity/throughput`_

### [Example request](snippets/getCapacityThroughputInformation/example_request.java)

[embedmd]:# (snippets/getCapacityThroughputInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CapacityThroughputInformation;
// section: code
Cloudant service = Cloudant.newInstance();

CapacityThroughputInformation response =
    service.getCapacityThroughputInformation().execute().getResult();

System.out.println(response);
```

## putCapacityThroughputConfiguration

_PUT `/_api/v2/user/capacity/throughput`_

### [Example request](snippets/putCapacityThroughputConfiguration/example_request.java)

[embedmd]:# (snippets/putCapacityThroughputConfiguration/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CapacityThroughputInformation;
import com.ibm.cloud.cloudant.v1.model.PutCapacityThroughputConfigurationOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PutCapacityThroughputConfigurationOptions options =
    new PutCapacityThroughputConfigurationOptions.Builder()
        .blocks(1)
        .build();

CapacityThroughputInformation response =
    service.putCapacityThroughputConfiguration(options).execute().getResult();

System.out.println(response);
```

## getCorsInformation

_GET `/_api/v2/user/config/cors`_

### [Example request](snippets/getCorsInformation/example_request.java)

[embedmd]:# (snippets/getCorsInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CorsInformation;
// section: code
Cloudant service = Cloudant.newInstance();

CorsInformation response =
    service.getCorsInformation().execute().getResult();

System.out.println(response);
```

## putCorsConfiguration

_PUT `/_api/v2/user/config/cors`_

### [Example request](snippets/putCorsConfiguration/example_request.java)

[embedmd]:# (snippets/putCorsConfiguration/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PutCorsConfigurationOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PutCorsConfigurationOptions configurationOptions =
    new PutCorsConfigurationOptions.Builder()
        .addOrigins("https://example.com")
        .enableCors(true)
        .build();

Ok response =
    service.putCorsConfiguration(configurationOptions).execute()
        .getResult();

System.out.println(response);
```

## getCurrentThroughputInformation

_GET `/_api/v2/user/current/throughput`_

### [Example request](snippets/getCurrentThroughputInformation/example_request.java)

[embedmd]:# (snippets/getCurrentThroughputInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.CurrentThroughputInformation;
// section: code
Cloudant service = Cloudant.newInstance();

CurrentThroughputInformation response =
    service.getCurrentThroughputInformation().execute().getResult();

System.out.println(response);
```

## getDbUpdates

_GET `/_db_updates`_

### [Example request](snippets/getDbUpdates/example_request.java)

[embedmd]:# (snippets/getDbUpdates/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DbUpdates;
import com.ibm.cloud.cloudant.v1.model.GetDbUpdatesOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDbUpdatesOptions dbUpdatesOptions = new GetDbUpdatesOptions.Builder()
    .feed("normal")
    .heartbeat(10000)
    .since("now")
    .build();

DbUpdates response =
    service.getDbUpdates(dbUpdatesOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This request requires `server_admin` access.
```

## postDbsInfo

_POST `/_dbs_info`_

### [Example request](snippets/postDbsInfo/example_request.java)

[embedmd]:# (snippets/postDbsInfo/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DbsInfoResult;
import com.ibm.cloud.cloudant.v1.model.PostDbsInfoOptions;

import java.util.Arrays;
import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

PostDbsInfoOptions dbsInfoOptions =
    new PostDbsInfoOptions.Builder()
        .keys(Arrays.asList("products", "users", "orders"))
        .build();

List<DbsInfoResult> response =
    service.postDbsInfo(dbsInfoOptions).execute()
        .getResult();

System.out.println(response);
```

## getMembershipInformation

_GET `/_membership`_

### [Example request](snippets/getMembershipInformation/example_request.java)

[embedmd]:# (snippets/getMembershipInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.MembershipInformation;
// section: code
Cloudant service = Cloudant.newInstance();

MembershipInformation response =
    service.getMembershipInformation().execute().getResult();

System.out.println(response);
```

## deleteReplicationDocument

_DELETE `/_replicator/{doc_id}`_

### [Example request](snippets/deleteReplicationDocument/example_request.java)

[embedmd]:# (snippets/deleteReplicationDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteReplicationDocumentOptions replicationDocOptions =
    new DeleteReplicationDocumentOptions.Builder()
        .docId("repldoc-example")
        .rev("1-00000000000000000000000000000000")
        .build();

DocumentResult response =
    service.deleteReplicationDocument(replicationDocOptions).execute()
        .getResult();

System.out.println(response);
```

## getReplicationDocument

_GET `/_replicator/{doc_id}`_

### [Example request](snippets/getReplicationDocument/example_request.java)

[embedmd]:# (snippets/getReplicationDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.ReplicationDocument;
// section: code
Cloudant service = Cloudant.newInstance();

GetReplicationDocumentOptions replicationDocOptions =
    new GetReplicationDocumentOptions.Builder()
        .docId("repldoc-example")
        .build();

ReplicationDocument response =
    service.getReplicationDocument(replicationDocOptions).execute()
        .getResult();

System.out.println(response);
```

## headReplicationDocument

_HEAD `/_replicator/{doc_id}`_

### [Example request](snippets/headReplicationDocument/example_request.java)

[embedmd]:# (snippets/headReplicationDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.sdk.core.http.Headers;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadReplicationDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

HeadReplicationDocumentOptions replicationDocOptions =
    new HeadReplicationDocumentOptions.Builder()
        .docId("repldoc-example")
        .build();

int statusCode =
    service.headReplicationDocument(replicationDocOptions).execute().getStatusCode();

Headers headers =
    service.headReplicationDocument(replicationDocOptions).execute().getHeaders();

System.out.println(statusCode);
System.out.println(headers.values("ETag"));
```

## putReplicationDocument

_PUT `/_replicator/{doc_id}`_

### [Example request](snippets/putReplicationDocument/example_request.java)

[embedmd]:# (snippets/putReplicationDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PutReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabase;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuth;
import com.ibm.cloud.cloudant.v1.model.ReplicationDatabaseAuthIam;
import com.ibm.cloud.cloudant.v1.model.ReplicationDocument;
// section: code
Cloudant service = Cloudant.newInstance();

ReplicationDatabase sourceDb = new ReplicationDatabase.Builder()
    .url("https://~replace-with-source-host~.cloudantnosqldb.appdomain.cloud/animaldb")
    .build();

ReplicationDatabaseAuthIam targetAuthIam =
    new ReplicationDatabaseAuthIam.Builder()
        .apiKey("a1b2c3d4e5f6f1g4h7j3k6l9m2p5q8s1t4v7x0z3") //use your own IAM API key
        .build();

ReplicationDatabaseAuth targetAuth = new ReplicationDatabaseAuth.Builder()
    .iam(targetAuthIam)
    .build();

ReplicationDatabase targetDb = new ReplicationDatabase.Builder()
    .auth(targetAuth)
    .url("https://~replace-with-target-host~.cloudantnosqldb.appdomain.cloud/animaldb-target")
    .build();

ReplicationDocument replDocument = new ReplicationDocument();
replDocument.setCreateTarget(true);
replDocument.setSource(sourceDb);
replDocument.setTarget(targetDb);

PutReplicationDocumentOptions replicationDocumentOptions =
    new PutReplicationDocumentOptions.Builder()
        .docId("repldoc-example")
        .replicationDocument(replDocument)
        .build();

DocumentResult response =
    service.putReplicationDocument(replicationDocumentOptions).execute()
        .getResult();

System.out.println(response);
```

## getSchedulerDocs

_GET `/_scheduler/docs`_

### [Example request](snippets/getSchedulerDocs/example_request.java)

[embedmd]:# (snippets/getSchedulerDocs/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerDocsOptions;
import com.ibm.cloud.cloudant.v1.model.SchedulerDocsResult;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

GetSchedulerDocsOptions schedulerDocsOptions = new GetSchedulerDocsOptions.Builder()
    .limit(100)
    .states(Arrays.asList("completed"))
    .build();

SchedulerDocsResult response =
    service.getSchedulerDocs(schedulerDocsOptions).execute()
        .getResult();

System.out.println(response);
```

## getSchedulerDocument

_GET `/_scheduler/docs/_replicator/{doc_id}`_

### [Example request](snippets/getSchedulerDocument/example_request.java)

[embedmd]:# (snippets/getSchedulerDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.SchedulerDocument;
// section: code
Cloudant service = Cloudant.newInstance();

GetSchedulerDocumentOptions schedulerDocumentOptions =
    new GetSchedulerDocumentOptions.Builder()
        .docId("repldoc-example")
        .build();

SchedulerDocument response =
    service.getSchedulerDocument(schedulerDocumentOptions).execute()
        .getResult();

System.out.println(response);
```

## getSchedulerJobs

_GET `/_scheduler/jobs`_

### [Example request](snippets/getSchedulerJobs/example_request.java)

[embedmd]:# (snippets/getSchedulerJobs/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerJobsOptions;
import com.ibm.cloud.cloudant.v1.model.SchedulerJobsResult;
// section: code
Cloudant service = Cloudant.newInstance();

GetSchedulerJobsOptions schedulerJobsOptions =
    new GetSchedulerJobsOptions.Builder()
        .limit(100)
        .build();

SchedulerJobsResult response =
    service.getSchedulerJobs(schedulerJobsOptions).execute()
        .getResult();

System.out.println(response);
```

## getSchedulerJob

_GET `/_scheduler/jobs/{job_id}`_

### [Example request](snippets/getSchedulerJob/example_request.java)

[embedmd]:# (snippets/getSchedulerJob/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerJobOptions;
import com.ibm.cloud.cloudant.v1.model.SchedulerJob;
// section: code
Cloudant service = Cloudant.newInstance();

GetSchedulerJobOptions schedulerJobOptions =
    new GetSchedulerJobOptions.Builder()
        .jobId("7b94915cd8c4a0173c77c55cd0443939+continuous")
        .build();

SchedulerJob response =
    service.getSchedulerJob(schedulerJobOptions).execute()
        .getResult();

System.out.println(response);
```

## headSchedulerJob

_HEAD `/_scheduler/jobs/{job_id}`_

### [Example request](snippets/headSchedulerJob/example_request.java)

[embedmd]:# (snippets/headSchedulerJob/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadSchedulerJobOptions;
// section: code
Cloudant service = Cloudant.newInstance();

HeadSchedulerJobOptions schedulerJobOptions =
    new HeadSchedulerJobOptions.Builder()
        .jobId("7b94915cd8c4a0173c77c55cd0443939+continuous")
        .build();

int statusCode =
    service.headSchedulerJob(schedulerJobOptions).execute()
        .getStatusCode();

System.out.println(statusCode);
```

## postSearchAnalyze

_POST `/_search_analyze`_

### [Example request](snippets/postSearchAnalyze/example_request.java)

[embedmd]:# (snippets/postSearchAnalyze/example_request.java)
```java
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
```

## getSessionInformation

_GET `/_session`_

### [Example request](snippets/getSessionInformation/example_request.java)

[embedmd]:# (snippets/getSessionInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.SessionInformation;
// section: code
Cloudant service = Cloudant.newInstance();

SessionInformation response =
    service.getSessionInformation().execute().getResult();

System.out.println(response);
// section: markdown
// For more details on Session Authentication, see [Authentication.](#authentication)
```

## getUpInformation

_GET `/_up`_

### [Example request](snippets/getUpInformation/example_request.java)

[embedmd]:# (snippets/getUpInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.UpInformation;
// section: code
Cloudant service = Cloudant.newInstance();

UpInformation response =
    service.getUpInformation().execute().getResult();

System.out.println(response);
```

## getUuids

_GET `/_uuids`_

### [Example request](snippets/getUuids/example_request.java)

[embedmd]:# (snippets/getUuids/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetUuidsOptions;
import com.ibm.cloud.cloudant.v1.model.UuidsResult;
// section: code
Cloudant service = Cloudant.newInstance();

GetUuidsOptions uuidsOptions = new GetUuidsOptions.Builder()
    .count(10)
    .build();

UuidsResult response =
    service.getUuids(uuidsOptions).execute()
        .getResult();

System.out.println(response);
```

## deleteDatabase

_DELETE `/{db}`_

### [Example request](snippets/deleteDatabase/example_request.java)

[embedmd]:# (snippets/deleteDatabase/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteDatabaseOptions;
import com.ibm.cloud.cloudant.v1.model.Ok;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteDatabaseOptions databaseOptions =
    new DeleteDatabaseOptions.Builder()
        .db("products")
        .build();

Ok response =
    service.deleteDatabase(databaseOptions).execute()
        .getResult();

System.out.println(response);
```

## getDatabaseInformation

_GET `/{db}`_

### [Example request](snippets/getDatabaseInformation/example_request.java)

[embedmd]:# (snippets/getDatabaseInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformation;
import com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDatabaseInformationOptions databaseInfoOptions =
    new GetDatabaseInformationOptions.Builder()
        .db("products")
        .build();

DatabaseInformation response =
    service.getDatabaseInformation(databaseInfoOptions).execute()
        .getResult();

System.out.println(response);
```

## headDatabase

_HEAD `/{db}`_

### [Example request](snippets/headDatabase/example_request.java)

[embedmd]:# (snippets/headDatabase/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadDatabaseOptions;
// section: code
Cloudant service = Cloudant.newInstance();

HeadDatabaseOptions databaseOptions =
    new HeadDatabaseOptions.Builder()
        .db("products")
        .build();

int statusCode =
    service.headDatabase(databaseOptions).execute().getStatusCode();

System.out.println(statusCode);
```

## postDocument

_POST `/{db}`_

### [Example request](snippets/postDocument/example_request.java)

[embedmd]:# (snippets/postDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PostDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

Document productsDocument = new Document();
productsDocument.setId("1000042");
productsDocument.put("type", "product");
productsDocument.put("productId", "1000042");
productsDocument.put("brand", "Salter");
productsDocument.put("name", "Digital Kitchen Scales");
productsDocument.put("description", "Slim Colourful Design Electronic"
    + "Cooking Appliance for Home / Kitchen, Weigh up to 5kg + Aquatronic"
    + "for Liquids ml + fl. oz. 15Yr Guarantee - Green");
productsDocument.put("price", 14.99);
productsDocument.put("image", "assets/img/0gmsnghhew.jpg");

PostDocumentOptions documentOptions =
    new PostDocumentOptions.Builder()
        .db("products")
        .document(productsDocument)
        .build();

DocumentResult response =
    service.postDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
```

## putDatabase

_PUT `/{db}`_

### [Example request](snippets/putDatabase/example_request.java)

[embedmd]:# (snippets/putDatabase/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PutDatabaseOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PutDatabaseOptions databaseOptions = new PutDatabaseOptions.Builder()
    .db("events")
    .partitioned(true)
    .build();

Ok response =
    service.putDatabase(databaseOptions).execute()
        .getResult();

System.out.println(response);
```

## postAllDocs

_POST `/{db}/_all_docs`_

### [Example request](snippets/postAllDocs/example_request.java)

[embedmd]:# (snippets/postAllDocs/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostAllDocsOptions docsOptions =
    new PostAllDocsOptions.Builder()
        .db("orders")
        .includeDocs(true)
        .startKey("abc")
        .limit(10)
        .build();

AllDocsResult response =
    service.postAllDocs(docsOptions).execute().getResult();

System.out.println(response);
```

### [Example request as a stream](snippets/postAllDocs/example_request_as_a_stream.java)

[embedmd]:# (snippets/postAllDocs/example_request_as_a_stream.java)
```java
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
```

## postAllDocsQueries

_POST `/{db}/_all_docs/queries`_

### [Example request](snippets/postAllDocsQueries/example_request.java)

[embedmd]:# (snippets/postAllDocsQueries/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsQuery;
import com.ibm.cloud.cloudant.v1.model.AllDocsQueriesResult;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsQueriesOptions;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

AllDocsQuery query1 = new AllDocsQuery.Builder()
    .keys(Arrays.asList("1000042",
        "1000043"))
    .build();

AllDocsQuery query2 = new AllDocsQuery.Builder()
    .limit(3)
    .skip(2)
    .build();

PostAllDocsQueriesOptions queriesOptions =
    new PostAllDocsQueriesOptions.Builder()
        .queries(Arrays.asList(query1, query2))
        .db("products")
        .build();

AllDocsQueriesResult response =
    service.postAllDocsQueries(queriesOptions).execute()
        .getResult();

System.out.println(response);
```

## postBulkDocs

_POST `/{db}/_bulk_docs`_

### [Example request: create documents](snippets/postBulkDocs/example_request_create_documents.java)

[embedmd]:# (snippets/postBulkDocs/example_request_create_documents.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.BulkDocs;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkDocsOptions;

import java.util.Arrays;
import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

Document eventDoc1 = new Document();
eventDoc1.setId("ns1HJS13AMkK:0007241142412418284");
eventDoc1.put("type", "event");
eventDoc1.put("userId", "abc123");
eventDoc1.put("eventType", "addedToBasket");
eventDoc1.put("productId", "1000042");
eventDoc1.put("date", "2019-01-28T10:44:22.000Z");

Document eventDoc2 = new Document();
eventDoc2.setId("H8tDIwfadxp9:0007241142412418285");
eventDoc2.put("type", "event");
eventDoc2.put("userId", "abc234");
eventDoc2.put("eventType", "addedToBasket");
eventDoc2.put("productId", "1000050");
eventDoc2.put("date", "2019-01-28T10:44:22.000Z");

BulkDocs bulkDocs = new BulkDocs.Builder()
    .docs(Arrays.asList(eventDoc1, eventDoc2))
    .build();

PostBulkDocsOptions bulkDocsOptions = new PostBulkDocsOptions.Builder()
    .db("events")
    .bulkDocs(bulkDocs)
    .build();

List<DocumentResult> response =
    service.postBulkDocs(bulkDocsOptions).execute()
        .getResult();

System.out.println(response);
```

### [Example request: delete documents](snippets/postBulkDocs/example_request_delete_documents.java)

[embedmd]:# (snippets/postBulkDocs/example_request_delete_documents.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.BulkDocs;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkDocsOptions;

import java.util.Arrays;
import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

Document eventDoc1 = new Document();
eventDoc1.setId("ns1HJS13AMkK:0007241142412418284");
eventDoc1.setRev("1-00000000000000000000000000000000");
eventDoc1.setDeleted(true);

Document eventDoc2 = new Document();
eventDoc2.setId("H8tDIwfadxp9:0007241142412418285");
eventDoc1.setRev("1-00000000000000000000000000000000");
eventDoc1.setDeleted(true);

BulkDocs bulkDocs = new BulkDocs.Builder()
    .docs(Arrays.asList(eventDoc1, eventDoc2))
    .build();

PostBulkDocsOptions bulkDocsOptions = new PostBulkDocsOptions.Builder()
    .db("events")
    .bulkDocs(bulkDocs)
    .build();

List<DocumentResult> response =
    service.postBulkDocs(bulkDocsOptions).execute()
        .getResult();

System.out.println(response);
```

### [Example request as a stream](snippets/postBulkDocs/example_request_as_a_stream.java)

[embedmd]:# (snippets/postBulkDocs/example_request_as_a_stream.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkDocsOptions;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
// section: code
Cloudant service = Cloudant.newInstance();

File file = new File("upload.json");
FileInputStream inputStream = new FileInputStream(file);

PostBulkDocsOptions bulkDocsOptions = new PostBulkDocsOptions.Builder()
    .db("events")
    .body(inputStream)
    .build();

List<DocumentResult> response =
    service.postBulkDocs(bulkDocsOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// Content of upload.json
// section: code
{
  "docs": [
    {
      "_id": "ns1HJS13AMkK:0007241142412418284",
      "type": "event",
      "userId": "abc123",
      "eventType": "addedToBasket",
      "productId": "1000042",
      "date": "2019-01-28T10:44:22.000Z"
    },
    {
      "_id": "H8tDIwfadxp9:0007241142412418285",
      "type": "event",
      "userId": "abc234",
      "eventType": "addedToBasket",
      "productId": "1000050",
      "date": "2019-01-25T20:00:00.000Z"
    }
  ]
}
```

## postBulkGet

_POST `/{db}/_bulk_get`_

### [Example request](snippets/postBulkGet/example_request.java)

[embedmd]:# (snippets/postBulkGet/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.BulkGetQueryDocument;
import com.ibm.cloud.cloudant.v1.model.BulkGetResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkGetOptions;

import java.util.ArrayList;
import java.util.List;
// section: code
Cloudant service = Cloudant.newInstance();

String docId = "order00067";
List<BulkGetQueryDocument> bulkGetDocs = new ArrayList<>();

bulkGetDocs.add(
    new BulkGetQueryDocument.Builder()
        .id(docId)
        .rev("3-22222222222222222222222222222222")
        .build());
bulkGetDocs.add(
    new BulkGetQueryDocument.Builder()
        .id(docId)
        .rev("4-33333333333333333333333333333333")
        .build());

PostBulkGetOptions bulkGetOptions = new PostBulkGetOptions.Builder()
    .db("orders")
    .docs(bulkGetDocs)
    .build();

BulkGetResult response =
    service.postBulkGet(bulkGetOptions).execute()
        .getResult();

System.out.println(response);
```

### [Alternative example request for `open_revs=all`](snippets/postBulkGet/alternative_example_request_for_open_revs_all.java)

[embedmd]:# (snippets/postBulkGet/alternative_example_request_for_open_revs_all.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.BulkGetQueryDocument;
import com.ibm.cloud.cloudant.v1.model.BulkGetResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkGetOptions;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

BulkGetQueryDocument bulkGetDoc =
    new BulkGetQueryDocument.Builder()
        .id("order00067")
        .build();

PostBulkGetOptions postBulkGetOptions =
    new PostBulkGetOptions.Builder()
        .db("orders")
        .docs(Arrays.asList(bulkGetDoc))
        .build();

BulkGetResult response =
    service.postBulkGet(postBulkGetOptions).execute()
        .getResult();

System.out.println(response);
```

### [Alternative example request for `atts_since`](snippets/postBulkGet/alternative_example_request_for_atts_since.java)

[embedmd]:# (snippets/postBulkGet/alternative_example_request_for_atts_since.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.BulkGetQueryDocument;
import com.ibm.cloud.cloudant.v1.model.BulkGetResult;
import com.ibm.cloud.cloudant.v1.model.PostBulkGetOptions;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

BulkGetQueryDocument bulkGetQueryDocument =
    new BulkGetQueryDocument.Builder()
        .id("order00058")
        .addAttsSince("1-00000000000000000000000000000000")
        .build();

PostBulkGetOptions postBulkGetOptions =
    new PostBulkGetOptions.Builder()
        .db("orders")
        .docs(Arrays.asList(bulkGetQueryDocument)).build();

BulkGetResult response =
    service.postBulkGet(postBulkGetOptions).execute()
        .getResult();

System.out.println(response);
```

## postChanges

_POST `/{db}/_changes`_

### [Example request](snippets/postChanges/example_request.java)

[embedmd]:# (snippets/postChanges/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ChangesResult;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostChangesOptions changesOptions = new PostChangesOptions.Builder()
    .db("orders")
    .build();

ChangesResult response =
    service.postChanges(changesOptions).execute()
        .getResult();

System.out.println(response);
```

### [Example request as a stream](snippets/postChanges/example_request_as_a_stream.java)

[embedmd]:# (snippets/postChanges/example_request_as_a_stream.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
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
```

## deleteDesignDocument

_DELETE `/{db}/_design/{ddoc}`_

### [Example request](snippets/deleteDesignDocument/example_request.java)

[embedmd]:# (snippets/deleteDesignDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteDesignDocumentOptions designDocumentOptions =
    new DeleteDesignDocumentOptions.Builder()
        .db("products")
        .ddoc("appliances")
        .rev("1-00000000000000000000000000000000")
        .build();

DocumentResult response =
    service.deleteDesignDocument(designDocumentOptions).execute()
        .getResult();

System.out.println(response);
```

## getDesignDocument

_GET `/{db}/_design/{ddoc}`_

### [Example request](snippets/getDesignDocument/example_request.java)

[embedmd]:# (snippets/getDesignDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DesignDocument;
import com.ibm.cloud.cloudant.v1.model.GetDesignDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDesignDocumentOptions designDocumentOptions = new GetDesignDocumentOptions.Builder()
    .db("products")
    .ddoc("appliances")
    .latest(true)
    .build();

DesignDocument response =
    service.getDesignDocument(designDocumentOptions).execute()
        .getResult();

System.out.println(response);
```

## headDesignDocument

_HEAD `/{db}/_design/{ddoc}`_

### [Example request](snippets/headDesignDocument/example_request.java)

[embedmd]:# (snippets/headDesignDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.sdk.core.http.Headers;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadDesignDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

HeadDesignDocumentOptions designDocumentOptions =
    new HeadDesignDocumentOptions.Builder()
        .db("events")
        .ddoc("checkout")
        .build();

int statusCode =
    service.headDesignDocument(designDocumentOptions).execute()
        .getStatusCode();

Headers headers =
    service.headDesignDocument(designDocumentOptions).execute()
        .getHeaders();

System.out.println(statusCode);
System.out.println(headers.values("ETag"));
```

## putDesignDocument

_PUT `/{db}/_design/{ddoc}`_

### [Example request](snippets/putDesignDocument/example_request.java)

[embedmd]:# (snippets/putDesignDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DesignDocument;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentViewsMapReduce;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PutDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.SearchIndexDefinition;

import java.util.Collections;
// section: code
Cloudant service = Cloudant.newInstance();

DesignDocumentViewsMapReduce emailViewMapReduce =
    new DesignDocumentViewsMapReduce.Builder()
        .map("function(doc) { if(doc.email_verified === true) { emit(doc.email, [doc.name, doc.email_verified, doc.joined]); }}")
        .build();

SearchIndexDefinition usersIndex =
    new SearchIndexDefinition.Builder()
        .index("function(doc) { index(\"name\", doc.name); index(\"active\", doc.active); }")
        .build();

DesignDocument designDocument = new DesignDocument();
designDocument.setViews(
    Collections.singletonMap("getVerifiedEmails", emailViewMapReduce));
designDocument.setIndexes(
    Collections.singletonMap("activeUsers", usersIndex));

PutDesignDocumentOptions designDocumentOptions =
    new PutDesignDocumentOptions.Builder()
        .db("users")
        .designDocument(designDocument)
        .ddoc("allusers")
        .build();

DocumentResult allusersResponse =
    service.putDesignDocument(designDocumentOptions).execute()
        .getResult();

System.out.println(allusersResponse);

DesignDocumentViewsMapReduce applianceView =
    new DesignDocumentViewsMapReduce.Builder()
        .map("function(doc) { emit(doc.productId, [doc.date, doc.eventType, doc.userId]); }")
        .build();

SearchIndexDefinition dateIndex =
    new SearchIndexDefinition.Builder()
        .index("function(doc) { index(\"date\", doc.date); }")
        .build();

DesignDocument partitionedDesignDocument = new DesignDocument();
partitionedDesignDocument.setViews(
    Collections.singletonMap("byProductId", applianceView));
partitionedDesignDocument.setIndexes(
    Collections.singletonMap("findByDate", dateIndex));

PutDesignDocumentOptions partitionedDesignDocumentOptions =
    new PutDesignDocumentOptions.Builder()
        .db("events")
        .designDocument(partitionedDesignDocument)
        .ddoc("checkout")
        .build();

DocumentResult appliancesResponse =
    service.putDesignDocument(partitionedDesignDocumentOptions).execute()
        .getResult();

System.out.println(appliancesResponse);
// section: markdown
// This example creates `allusers` design document in the `users` database and `checkout` design document in the partitioned `events` database.
```

## getDesignDocumentInformation

_GET `/{db}/_design/{ddoc}/_info`_

### [Example request](snippets/getDesignDocumentInformation/example_request.java)

[embedmd]:# (snippets/getDesignDocumentInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentInformation;
import com.ibm.cloud.cloudant.v1.model.GetDesignDocumentInformationOptions;


// section: code
Cloudant service = Cloudant.newInstance();

GetDesignDocumentInformationOptions informationOptions =
    new GetDesignDocumentInformationOptions.Builder()
        .db("products")
        .ddoc("appliances")
        .build();

DesignDocumentInformation response =
    service.getDesignDocumentInformation(informationOptions).execute()
        .getResult();

System.out.println(response);
```

## postSearch

_POST `/{db}/_design/{ddoc}/_search/{index}`_

### [Example request](snippets/postSearch/example_request.java)

[embedmd]:# (snippets/postSearch/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostSearchOptions searchOptions = new PostSearchOptions.Builder()
    .db("users")
    .ddoc("allusers")
    .index("activeUsers")
    .query("name:Jane* AND active:True")
    .build();

SearchResult response =
    service.postSearch(searchOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `activeUsers` Cloudant Search index to exist. To create the design document with this index, see [Create or modify a design document.](#putdesigndocument)
```

## getSearchInfo

_GET `/{db}/_design/{ddoc}/_search_info/{index}`_

### [Example request](snippets/getSearchInfo/example_request.java)

[embedmd]:# (snippets/getSearchInfo/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSearchInfoOptions;
import com.ibm.cloud.cloudant.v1.model.SearchInfoResult;
// section: code
Cloudant service = Cloudant.newInstance();

GetSearchInfoOptions infoOptions =
    new GetSearchInfoOptions.Builder()
        .db("events")
        .ddoc("checkout")
        .index("findByDate")
        .build();

SearchInfoResult response =
    service.getSearchInfo(infoOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `findByDate` Cloudant Search partitioned index to exist. To create the design document with this index, see [Create or modify a design document.](#putdesigndocument)
```

## postView

_POST `/{db}/_design/{ddoc}/_view/{view}`_

### [Example request](snippets/postView/example_request.java)

[embedmd]:# (snippets/postView/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostViewOptions viewOptions = new PostViewOptions.Builder()
    .db("users")
    .ddoc("allusers")
    .view("getVerifiedEmails")
    .build();

ViewResult response =
    service.postView(viewOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `getVerifiedEmails` view to exist. To create the design document with this view, see [Create or modify a design document.](#putdesigndocument)
```

## postViewQueries

_POST `/{db}/_design/{ddoc}/_view/{view}/queries`_

### [Example request](snippets/postViewQueries/example_request.java)

[embedmd]:# (snippets/postViewQueries/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostViewQueriesOptions;
import com.ibm.cloud.cloudant.v1.model.ViewQueriesResult;
import com.ibm.cloud.cloudant.v1.model.ViewQuery;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

ViewQuery query1 = new ViewQuery.Builder()
    .includeDocs(true)
    .limit(5)
    .build();

ViewQuery query2 = new ViewQuery.Builder()
    .descending(true)
    .skip(1)
    .build();

PostViewQueriesOptions queriesOptions =
    new PostViewQueriesOptions.Builder()
        .db("users")
        .ddoc("allusers")
        .queries(Arrays.asList(query1, query2))
        .view("getVerifiedEmails")
        .build();

ViewQueriesResult response =
    service.postViewQueries(queriesOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `getVerifiedEmails` view to exist. To create the design document with this view, see [Create or modify a design document.](#putdesigndocument)
```

## postDesignDocs

_POST `/{db}/_design_docs`_

### [Example request](snippets/postDesignDocs/example_request.java)

[embedmd]:# (snippets/postDesignDocs/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostDesignDocsOptions docsOptions =
    new PostDesignDocsOptions.Builder()
        .attachments(true)
        .db("users")
        .build();

AllDocsResult response =
    service.postDesignDocs(docsOptions).execute()
        .getResult();

System.out.println(response);
```

## postDesignDocsQueries

_POST `/{db}/_design_docs/queries`_

### [Example request](snippets/postDesignDocsQueries/example_request.java)

[embedmd]:# (snippets/postDesignDocsQueries/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsQueriesResult;
import com.ibm.cloud.cloudant.v1.model.AllDocsQuery;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsQueriesOptions;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

AllDocsQuery query1 = new AllDocsQuery.Builder()
    .descending(true)
    .includeDocs(true)
    .limit(10)
    .build();
AllDocsQuery query2 = new AllDocsQuery.Builder()
    .inclusiveEnd(true)
    .key("_design/allusers")
    .skip(1)
    .build();

PostDesignDocsQueriesOptions queriesOptions =
    new PostDesignDocsQueriesOptions.Builder()
        .db("users")
        .queries(Arrays.asList(query1, query2))
        .build();

AllDocsQueriesResult response =
    service.postDesignDocsQueries(queriesOptions).execute()
        .getResult();

System.out.println(response);
```

## postExplain

_POST `/{db}/_explain`_

### [Example request](snippets/postExplain/example_request.java)

[embedmd]:# (snippets/postExplain/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.ExplainResult;
import com.ibm.cloud.cloudant.v1.model.PostExplainOptions;

import java.util.Collections;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, Object> selector = Collections.singletonMap(
    "type",
    Collections.singletonMap("$eq", "user"));

PostExplainOptions explainOptions =
    new PostExplainOptions.Builder()
        .db("users")
        .executionStats(true)
        .limit(10)
        .selector(selector)
        .build();

ExplainResult response =
    service.postExplain(explainOptions).execute()
        .getResult();

System.out.println(response);
```

## postFind

_POST `/{db}/_find`_

### [Example request for "json" index type](snippets/postFind/example_request_for_json_index_type.java)

[embedmd]:# (snippets/postFind/example_request_for_json_index_type.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.FindResult;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, Object> selector = Collections.singletonMap(
    "email_verified",
    Collections.singletonMap("$eq", true));

Map<String, String> fieldSort = Collections.singletonMap("email", "desc");

PostFindOptions findOptions = new PostFindOptions.Builder()
    .db("users")
    .selector(selector)
    .fields(Arrays.asList("_id", "type", "name", "email"))
    .addSort(fieldSort)
    .limit(3)
    .build();

FindResult response =
    service.postFind(findOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `getUserByEmail` Cloudant Query "json" index to exist. To create the index, see [Create a new index on a database.](#postindex)
```

### [Example request for "text" index type](snippets/postFind/example_request_for_text_index_type.java)

[embedmd]:# (snippets/postFind/example_request_for_text_index_type.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.FindResult;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, Object> selector = Collections.singletonMap(
    "address",
    Collections.singletonMap("$regex", "Street"));

PostFindOptions findOptions = new PostFindOptions.Builder()
    .db("users")
    .selector(selector)
    .fields(Arrays.asList("_id", "type", "name", "email", "address"))
    .limit(3)
    .build();

FindResult response =
    service.postFind(findOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `getUserByAddress` Cloudant Query "text" index to exist. To create the index, see [Create a new index on a database.](#postindex)
```

## getIndexesInformation

_GET `/{db}/_index`_

### [Example request](snippets/getIndexesInformation/example_request.java)

[embedmd]:# (snippets/getIndexesInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetIndexesInformationOptions;
import com.ibm.cloud.cloudant.v1.model.IndexesInformation;
// section: code
Cloudant service = Cloudant.newInstance();

GetIndexesInformationOptions indexesInformationOptions =
    new GetIndexesInformationOptions.Builder()
        .db("users")
        .build();

IndexesInformation response =
    service.getIndexesInformation(indexesInformationOptions).execute()
        .getResult();

System.out.println(response);
```

## postIndex

_POST `/{db}/_index`_

### [Example request using "json" type index](snippets/postIndex/example_request_using_json_type_index.java)

[embedmd]:# (snippets/postIndex/example_request_using_json_type_index.java)
```java
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
```

### [Example request using "text" type index](snippets/postIndex/example_request_using_text_type_index.java)

[embedmd]:# (snippets/postIndex/example_request_using_text_type_index.java)
```java
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
```

## deleteIndex

_DELETE `/{db}/_index/_design/{ddoc}/{type}/{index}`_

### [Example request](snippets/deleteIndex/example_request.java)

[embedmd]:# (snippets/deleteIndex/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteIndexOptions;
import com.ibm.cloud.cloudant.v1.model.Ok;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteIndexOptions indexOptions = new DeleteIndexOptions.Builder()
    .db("users")
    .ddoc("json-index")
    .index("getUserByName")
    .type("json")
    .build();

Ok response =
    service.deleteIndex(indexOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example will fail if `getUserByName` index doesn't exist. To create the index, see [Create a new index on a database.](#postindex)
```

## deleteLocalDocument

_DELETE `/{db}/_local/{doc_id}`_

### [Example request](snippets/deleteLocalDocument/example_request.java)

[embedmd]:# (snippets/deleteLocalDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteLocalDocumentOptions documentOptions =
    new DeleteLocalDocumentOptions.Builder()
        .db("orders")
        .docId("local-0007741142412418284")
        .build();

DocumentResult response =
    service.deleteLocalDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
```

## getLocalDocument

_GET `/{db}/_local/{doc_id}`_

### [Example request](snippets/getLocalDocument/example_request.java)

[embedmd]:# (snippets/getLocalDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.GetLocalDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetLocalDocumentOptions documentOptions =
    new GetLocalDocumentOptions.Builder()
        .db("orders")
        .docId("local-0007741142412418284")
        .build();

Document response =
    service.getLocalDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
```

## putLocalDocument

_PUT `/{db}/_local/{doc_id}`_

### [Example request](snippets/putLocalDocument/example_request.java)

[embedmd]:# (snippets/putLocalDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PutLocalDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

Document orderDocument = new Document();
orderDocument.put("type", "order");
orderDocument.put("user", "Bob Smith");
orderDocument.put("orderId", "0007741142412418284");
orderDocument.put("userId", "abc123");
orderDocument.put("total", 214.98);
orderDocument.put("deliveryAddress", "19 Front Street, Darlington, DL5 1TY");
orderDocument.put("delivered", true);
orderDocument.put("courier", "UPS");
orderDocument.put("courierId", "15125425151261289");
orderDocument.put("date", "2019-01-28T10:44:22.000Z");

PutLocalDocumentOptions documentOptions =
    new PutLocalDocumentOptions.Builder()
        .db("orders")
        .docId("local-0007741142412418284")
        .document(orderDocument)
        .build();

DocumentResult response =
    service.putLocalDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
```

## getPartitionInformation

_GET `/{db}/_partition/{partition_key}`_

### [Example request](snippets/getPartitionInformation/example_request.java)

[embedmd]:# (snippets/getPartitionInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetPartitionInformationOptions;
import com.ibm.cloud.cloudant.v1.model.PartitionInformation;
// section: code
Cloudant service = Cloudant.newInstance();

GetPartitionInformationOptions informationOptions =
    new GetPartitionInformationOptions.Builder()
        .db("events")
        .partitionKey("ns1HJS13AMkK")
        .build();

PartitionInformation response =
    service.getPartitionInformation(informationOptions).execute()
        .getResult();

System.out.println(response);
```

## postPartitionAllDocs

_POST `/{db}/_partition/{partition_key}/_all_docs`_

### [Example request](snippets/postPartitionAllDocs/example_request.java)

[embedmd]:# (snippets/postPartitionAllDocs/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
// section: code
Cloudant service = Cloudant.newInstance();

PostPartitionAllDocsOptions allDocsOptions =
    new PostPartitionAllDocsOptions.Builder()
        .db("events")
        .partitionKey("ns1HJS13AMkK")
        .includeDocs(true)
        .build();

AllDocsResult response =
    service.postPartitionAllDocs(allDocsOptions).execute()
        .getResult();

System.out.println(response);
```

## postPartitionSearch

_POST `/{db}/_partition/{partition_key}/_design/{ddoc}/_search/{index}`_

### [Example request](snippets/postPartitionSearch/example_request.java)

[embedmd]:# (snippets/postPartitionSearch/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostPartitionSearchOptions searchOptions =
    new PostPartitionSearchOptions.Builder()
        .db("events")
        .partitionKey("ns1HJS13AMkK")
        .ddoc("checkout")
        .index("findByDate")
        .query("date:[2019-01-01T12:00:00.000Z TO 2019-01-31T12:00:00.000Z]")
        .build();

SearchResult response =
    service.postPartitionSearch(searchOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `findByDate` Cloudant Search partitioned index to exist. To create the design document with this index, see [Create or modify a design document.](#putdesigndocument)
```

## postPartitionView

_POST `/{db}/_partition/{partition_key}/_design/{ddoc}/_view/{view}`_

### [Example request](snippets/postPartitionView/example_request.java)

[embedmd]:# (snippets/postPartitionView/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
// section: code
Cloudant service = Cloudant.newInstance();

PostPartitionViewOptions viewOptions =
    new PostPartitionViewOptions.Builder()
        .db("events")
        .ddoc("checkout")
        .includeDocs(true)
        .limit(10)
        .partitionKey("ns1HJS13AMkK")
        .view("byProductId")
        .build();

ViewResult response =
    service.postPartitionView(viewOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the `byProductId` partitioned view to exist. To create the design document with this view, see [Create or modify a design document.](#putdesigndocument)
```

## postPartitionExplain

_POST `/{db}/_partition/{partition_key}/_explain`_

### [Example request](snippets/postPartitionExplain/example_request.java)

## postPartitionFind

_POST `/{db}/_partition/{partition_key}/_find`_

### [Example request](snippets/postPartitionFind/example_request.java)

[embedmd]:# (snippets/postPartitionFind/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.FindResult;
import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, String> typeEqualsProduct = new HashMap<>();
typeEqualsProduct.put("$eq", "abc123");

Map<String, Object> selector = new HashMap<>();
selector.put("userId", typeEqualsProduct);

PostPartitionFindOptions findOptions =
    new PostPartitionFindOptions.Builder()
        .db("events")
        .partitionKey("ns1HJS13AMkK")
        .fields(Arrays.asList("productId", "eventType", "date"))
        .selector(selector)
        .build();

FindResult response =
    service.postPartitionFind(findOptions).execute()
        .getResult();

System.out.println(response);
```

## postRevsDiff

_POST `/{db}/_revs_diff`_

### [Example request](snippets/postRevsDiff/example_request.java)

[embedmd]:# (snippets/postRevsDiff/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostRevsDiffOptions;
import com.ibm.cloud.cloudant.v1.model.RevsDiff;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, List<String>> docRevisions =
    Collections.singletonMap("order00077", Arrays.asList(
        "1-00000000000000000000000000000000", // missing revision
        "2-11111111111111111111111111111111", // missing revision
        "3-22222222222222222222222222222222"  // possible ancestor revision
    ));

PostRevsDiffOptions revsDiffOptions =
    new PostRevsDiffOptions.Builder()
        .db("orders")
        .documentRevisions(docRevisions)
        .build();

Map<String,RevsDiff> response =
    service.postRevsDiff(revsDiffOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// This example requires the example revisions in the POST body to be replaced with valid revisions.
```

## getSecurity

_GET `/{db}/_security`_

### [Example request](snippets/getSecurity/example_request.java)

[embedmd]:# (snippets/getSecurity/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetSecurityOptions;
import com.ibm.cloud.cloudant.v1.model.Security;
// section: code
Cloudant service = Cloudant.newInstance();

GetSecurityOptions securityOptions =
    new GetSecurityOptions.Builder()
        .db("products")
        .build();

Security response =
    service.getSecurity(securityOptions).execute()
        .getResult();

System.out.println(response);
```

## putSecurity

_PUT `/{db}/_security`_

### [Example request](snippets/putSecurity/example_request.java)

[embedmd]:# (snippets/putSecurity/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PutSecurityOptions;
import com.ibm.cloud.cloudant.v1.model.SecurityObject;

import java.util.Arrays;
// section: code
Cloudant service = Cloudant.newInstance();

SecurityObject members = new SecurityObject.Builder()
    .names(Arrays.asList("user1", "user2"))
    .roles(Arrays.asList("developers"))
    .build();

PutSecurityOptions securityOptions =
    new PutSecurityOptions.Builder()
        .db("products")
        .members(members)
        .build();

Ok response =
    service.putSecurity(securityOptions).execute()
        .getResult();

System.out.println(response);
// section: markdown
// The `nobody` username applies to all unauthenticated connection attempts. For example, if an application tries to read data from a database, but didn't identify itself, the task can continue only if the `nobody` user has the role `_reader`.
// section: markdown
// If instead of using Cloudant's security model for managing permissions you opt to use the Apache CouchDB `_users` database (that is using legacy credentials _and_ the `couchdb_auth_only:true` option) then be aware that the user must already exist in `_users` database before adding permissions. For information on the `_users` database, see <a href="https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-work-with-your-account#using-the-users-database-with-cloudant-nosql-db" target="_blank">Using the `_users` database with Cloudant</a>.
```

## getShardsInformation

_GET `/{db}/_shards`_

### [Example request](snippets/getShardsInformation/example_request.java)

[embedmd]:# (snippets/getShardsInformation/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.GetShardsInformationOptions;
import com.ibm.cloud.cloudant.v1.model.ShardsInformation;
// section: code
Cloudant service = Cloudant.newInstance();

GetShardsInformationOptions shardsInformationOptions =
    new GetShardsInformationOptions.Builder()
        .db("products")
        .build();

ShardsInformation response =
    service.getShardsInformation(shardsInformationOptions)
        .execute().getResult();

System.out.println(response);
```

## getDocumentShardsInfo

_GET `/{db}/_shards/{doc_id}`_

### [Example request](snippets/getDocumentShardsInfo/example_request.java)

[embedmd]:# (snippets/getDocumentShardsInfo/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DocumentShardInfo;
import com.ibm.cloud.cloudant.v1.model.GetDocumentShardsInfoOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDocumentShardsInfoOptions shardsInfoOptions =
    new GetDocumentShardsInfoOptions.Builder()
        .db("products")
        .docId("1000042")
        .build();

DocumentShardInfo response =
    service.getDocumentShardsInfo(shardsInfoOptions).execute()
        .getResult();

System.out.println(response);
```

## deleteDocument

_DELETE `/{db}/{doc_id}`_

### [Example request](snippets/deleteDocument/example_request.java)

[embedmd]:# (snippets/deleteDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.DeleteDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
// section: code
Cloudant service = Cloudant.newInstance();

DeleteDocumentOptions documentOptions =
    new DeleteDocumentOptions.Builder()
        .db("orders")
        .docId("order00058")
        .rev("1-00000000000000000000000000000000")
        .build();

DocumentResult response =
    service.deleteDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
```

## getDocument

_GET `/{db}/{doc_id}`_

### [Example request](snippets/getDocument/example_request.java)

[embedmd]:# (snippets/getDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

GetDocumentOptions documentOptions =
    new GetDocumentOptions.Builder()
        .db("products")
        .docId("1000042")
        .build();

Document response =
    service.getDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
```

## headDocument

_HEAD `/{db}/{doc_id}`_

### [Example request](snippets/headDocument/example_request.java)

[embedmd]:# (snippets/headDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.sdk.core.http.Headers;

import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.HeadDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();
HeadDocumentOptions documentOptions =
    new HeadDocumentOptions.Builder()
        .db("orders")
        .docId("order00058")
        .build();

int statusCode =
    service.headDocument(documentOptions).execute()
        .getStatusCode();
Headers headers =
    service.headDocument(documentOptions).execute()
        .getHeaders();

System.out.println(statusCode);
System.out.println(headers.values("ETag"));
```

## putDocument

_PUT `/{db}/{doc_id}`_

### [Example request](snippets/putDocument/example_request.java)

[embedmd]:# (snippets/putDocument/example_request.java)
```java
// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.PutDocumentOptions;
// section: code
Cloudant service = Cloudant.newInstance();

Document eventDoc = new Document();
eventDoc.put("type", "event");
eventDoc.put("userId", "abc123");
eventDoc.put("eventType", "addedToBasket");
eventDoc.put("productId", "1000042");
eventDoc.put("date", "2019-01-28T10:44:22.000Z");

PutDocumentOptions documentOptions =
    new PutDocumentOptions.Builder()
        .db("events")
        .docId("ns1HJS13AMkK:0007241142412418284")
        .document(eventDoc)
        .build();

DocumentResult response =
    service.putDocument(documentOptions).execute()
        .getResult();

System.out.println(response);
```

## deleteAttachment

_DELETE `/{db}/{doc_id}/{attachment_name}`_

### [Example request](snippets/deleteAttachment/example_request.java)

[embedmd]:# (snippets/deleteAttachment/example_request.java)
```java
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
```

## getAttachment

_GET `/{db}/{doc_id}/{attachment_name}`_

### [Example request](snippets/getAttachment/example_request.java)

[embedmd]:# (snippets/getAttachment/example_request.java)
```java
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
        .docId("1000042")
        .attachmentName("product_details.txt")
        .build();

try(InputStream streamResult =
        service.getAttachment(attachmentOptions).execute()
            .getResult()) {        
    String response =
        new BufferedReader(new InputStreamReader(streamResult))
            .lines().collect(Collectors.joining("\n"));
    
    System.out.println(response);
}

// section: markdown
// This example requires the `product_details.txt` attachment in `1000042` document to exist. To create the attachment, see [Create or modify an attachment.](#putattachment)
```

## headAttachment

_HEAD `/{db}/{doc_id}/{attachment_name}`_

### [Example request](snippets/headAttachment/example_request.java)

[embedmd]:# (snippets/headAttachment/example_request.java)
```java
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
```

## putAttachment

_PUT `/{db}/{doc_id}/{attachment_name}`_

### [Example request](snippets/putAttachment/example_request.java)

[embedmd]:# (snippets/putAttachment/example_request.java)
```java
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
```
