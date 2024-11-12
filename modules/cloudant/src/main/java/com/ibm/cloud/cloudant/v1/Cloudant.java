/*
 * (C) Copyright IBM Corp. 2024.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.cloudant.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.cloudant.v1.model.ActiveTask;
import com.ibm.cloud.cloudant.v1.model.ActivityTrackerEvents;
import com.ibm.cloud.cloudant.v1.model.AllDocsQueriesResult;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.ApiKeysResult;
import com.ibm.cloud.cloudant.v1.model.BulkGetResult;
import com.ibm.cloud.cloudant.v1.model.CapacityThroughputInformation;
import com.ibm.cloud.cloudant.v1.model.ChangesResult;
import com.ibm.cloud.cloudant.v1.model.CorsInformation;
import com.ibm.cloud.cloudant.v1.model.CurrentThroughputInformation;
import com.ibm.cloud.cloudant.v1.model.DatabaseInformation;
import com.ibm.cloud.cloudant.v1.model.DbUpdates;
import com.ibm.cloud.cloudant.v1.model.DbsInfoResult;
import com.ibm.cloud.cloudant.v1.model.DeleteAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteDatabaseOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteIndexOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DeleteReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.DesignDocument;
import com.ibm.cloud.cloudant.v1.model.DesignDocumentInformation;
import com.ibm.cloud.cloudant.v1.model.Document;
import com.ibm.cloud.cloudant.v1.model.DocumentResult;
import com.ibm.cloud.cloudant.v1.model.DocumentShardInfo;
import com.ibm.cloud.cloudant.v1.model.ExplainResult;
import com.ibm.cloud.cloudant.v1.model.FindResult;
import com.ibm.cloud.cloudant.v1.model.GetActiveTasksOptions;
import com.ibm.cloud.cloudant.v1.model.GetActivityTrackerEventsOptions;
import com.ibm.cloud.cloudant.v1.model.GetAllDbsOptions;
import com.ibm.cloud.cloudant.v1.model.GetAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.GetCapacityThroughputInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetCorsInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetCurrentThroughputInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetDatabaseInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetDbUpdatesOptions;
import com.ibm.cloud.cloudant.v1.model.GetDesignDocumentInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetDocumentShardsInfoOptions;
import com.ibm.cloud.cloudant.v1.model.GetIndexesInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetMembershipInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetPartitionInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerDocsOptions;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerJobOptions;
import com.ibm.cloud.cloudant.v1.model.GetSchedulerJobsOptions;
import com.ibm.cloud.cloudant.v1.model.GetSearchInfoOptions;
import com.ibm.cloud.cloudant.v1.model.GetSecurityOptions;
import com.ibm.cloud.cloudant.v1.model.GetServerInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetSessionInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetShardsInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetUpInformationOptions;
import com.ibm.cloud.cloudant.v1.model.GetUuidsOptions;
import com.ibm.cloud.cloudant.v1.model.HeadAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadDatabaseOptions;
import com.ibm.cloud.cloudant.v1.model.HeadDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadSchedulerDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.HeadSchedulerJobOptions;
import com.ibm.cloud.cloudant.v1.model.HeadUpInformationOptions;
import com.ibm.cloud.cloudant.v1.model.IndexResult;
import com.ibm.cloud.cloudant.v1.model.IndexesInformation;
import com.ibm.cloud.cloudant.v1.model.MembershipInformation;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PartitionInformation;
import com.ibm.cloud.cloudant.v1.model.PostActivityTrackerEventsOptions;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsQueriesOptions;
import com.ibm.cloud.cloudant.v1.model.PostApiKeysOptions;
import com.ibm.cloud.cloudant.v1.model.PostBulkDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostBulkGetOptions;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
import com.ibm.cloud.cloudant.v1.model.PostDbsInfoOptions;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsQueriesOptions;
import com.ibm.cloud.cloudant.v1.model.PostDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PostExplainOptions;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostIndexOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionExplainOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostReplicatorOptions;
import com.ibm.cloud.cloudant.v1.model.PostRevsDiffOptions;
import com.ibm.cloud.cloudant.v1.model.PostSearchAnalyzeOptions;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewQueriesOptions;
import com.ibm.cloud.cloudant.v1.model.PutAttachmentOptions;
import com.ibm.cloud.cloudant.v1.model.PutCapacityThroughputConfigurationOptions;
import com.ibm.cloud.cloudant.v1.model.PutCloudantSecurityConfigurationOptions;
import com.ibm.cloud.cloudant.v1.model.PutCorsConfigurationOptions;
import com.ibm.cloud.cloudant.v1.model.PutDatabaseOptions;
import com.ibm.cloud.cloudant.v1.model.PutDesignDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutLocalDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutReplicationDocumentOptions;
import com.ibm.cloud.cloudant.v1.model.PutSecurityOptions;
import com.ibm.cloud.cloudant.v1.model.ReplicationDocument;
import com.ibm.cloud.cloudant.v1.model.RevsDiff;
import com.ibm.cloud.cloudant.v1.model.SchedulerDocsResult;
import com.ibm.cloud.cloudant.v1.model.SchedulerDocument;
import com.ibm.cloud.cloudant.v1.model.SchedulerJob;
import com.ibm.cloud.cloudant.v1.model.SchedulerJobsResult;
import com.ibm.cloud.cloudant.v1.model.SearchAnalyzeResult;
import com.ibm.cloud.cloudant.v1.model.SearchInfoResult;
import com.ibm.cloud.cloudant.v1.model.SearchResult;
import com.ibm.cloud.cloudant.v1.model.Security;
import com.ibm.cloud.cloudant.v1.model.ServerInformation;
import com.ibm.cloud.cloudant.v1.model.SessionInformation;
import com.ibm.cloud.cloudant.v1.model.ShardsInformation;
import com.ibm.cloud.cloudant.v1.model.UpInformation;
import com.ibm.cloud.cloudant.v1.model.UuidsResult;
import com.ibm.cloud.cloudant.v1.model.ViewQueriesResult;
import com.ibm.cloud.cloudant.v1.model.ViewResult;
import com.ibm.cloud.cloudant.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;


import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * NoSQL database based on Apache CouchDB.
 *
 * See: https://cloud.ibm.com/docs/services/Cloudant/
 */
public class Cloudant extends com.ibm.cloud.cloudant.internal.CloudantBaseService {
  private static final Logger LOGGER = Logger.getLogger(Cloudant.class.getName());

  /**
   * Default service name used when configuring the `Cloudant` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "cloudant";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://~replace-with-cloudant-host~.cloudantnosqldb.appdomain.cloud";

 /**
   * Class method which constructs an instance of the `Cloudant` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `Cloudant` client using external configuration
   */
  public static Cloudant newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `Cloudant` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `Cloudant` client using external configuration
   */
  public static Cloudant newInstance(String serviceName) {
    Authenticator authenticator = com.ibm.cloud.cloudant.internal.DelegatingAuthenticatorFactory.getAuthenticator(serviceName);
    Cloudant service = new Cloudant(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `Cloudant` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public Cloudant(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    enableGzipCompression(true);
  }

  /**
   * Retrieve server instance information.
   *
   * When you access the root of an instance, IBM Cloudant returns meta-information about the instance. The response
   * includes a JSON structure that contains information about the server, including a welcome message and the server's
   * version.
   *
   * **Tip:**  The authentication for this endpoint is only enforced when using IAM.
   *
   * @param getServerInformationOptions the {@link GetServerInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ServerInformation}
   */
  public ServiceCall<ServerInformation> getServerInformation(GetServerInformationOptions getServerInformationOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getServerInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ServerInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServerInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve server instance information.
   *
   * When you access the root of an instance, IBM Cloudant returns meta-information about the instance. The response
   * includes a JSON structure that contains information about the server, including a welcome message and the server's
   * version.
   *
   * **Tip:**  The authentication for this endpoint is only enforced when using IAM.
   *
   * @return a {@link ServiceCall} with a result of type {@link ServerInformation}
   */
  public ServiceCall<ServerInformation> getServerInformation() {
    return getServerInformation(null);
  }

  /**
   * Retrieve one or more UUIDs.
   *
   * Requests one or more Universally Unique Identifiers (UUIDs) from the instance. The response is a JSON object that
   * provides a list of UUIDs.
   *
   * **Tip:**  The authentication for this endpoint is only enforced when using IAM.
   *
   * @param getUuidsOptions the {@link GetUuidsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link UuidsResult}
   */
  public ServiceCall<UuidsResult> getUuids(GetUuidsOptions getUuidsOptions) {
    if (getUuidsOptions == null) {
      getUuidsOptions = new GetUuidsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_uuids"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getUuids");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getUuidsOptions.count() != null) {
      builder.query("count", String.valueOf(getUuidsOptions.count()));
    }
    ResponseConverter<UuidsResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UuidsResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve one or more UUIDs.
   *
   * Requests one or more Universally Unique Identifiers (UUIDs) from the instance. The response is a JSON object that
   * provides a list of UUIDs.
   *
   * **Tip:**  The authentication for this endpoint is only enforced when using IAM.
   *
   * @return a {@link ServiceCall} with a result of type {@link UuidsResult}
   */
  public ServiceCall<UuidsResult> getUuids() {
    return getUuids(null);
  }

  /**
   * Retrieve provisioned throughput capacity information.
   *
   * View the amount of provisioned throughput capacity that is allocated to an IBM Cloudant instance and what is the
   * target provisioned throughput capacity.
   *
   * @param getCapacityThroughputInformationOptions the {@link GetCapacityThroughputInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CapacityThroughputInformation}
   */
  public ServiceCall<CapacityThroughputInformation> getCapacityThroughputInformation(GetCapacityThroughputInformationOptions getCapacityThroughputInformationOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_api/v2/user/capacity/throughput"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getCapacityThroughputInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<CapacityThroughputInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CapacityThroughputInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve provisioned throughput capacity information.
   *
   * View the amount of provisioned throughput capacity that is allocated to an IBM Cloudant instance and what is the
   * target provisioned throughput capacity.
   *
   * @return a {@link ServiceCall} with a result of type {@link CapacityThroughputInformation}
   */
  public ServiceCall<CapacityThroughputInformation> getCapacityThroughputInformation() {
    return getCapacityThroughputInformation(null);
  }

  /**
   * Update the target provisioned throughput capacity.
   *
   * Sets the target provisioned throughput capacity for an IBM Cloudant instance. When target capacity is changed, the
   * current capacity asynchronously changes to meet the target capacity.
   *
   * @param putCapacityThroughputConfigurationOptions the {@link PutCapacityThroughputConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CapacityThroughputInformation}
   */
  public ServiceCall<CapacityThroughputInformation> putCapacityThroughputConfiguration(PutCapacityThroughputConfigurationOptions putCapacityThroughputConfigurationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putCapacityThroughputConfigurationOptions,
      "putCapacityThroughputConfigurationOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_api/v2/user/capacity/throughput"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putCapacityThroughputConfiguration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("blocks", putCapacityThroughputConfigurationOptions.blocks());
    builder.bodyJson(contentJson);
    ResponseConverter<CapacityThroughputInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CapacityThroughputInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve change events for all databases.
   *
   * **This endpoint is not available in IBM Cloudant.**
   *
   * Lists changes to databases, like a global changes feed. Types of changes include updating the database and creating
   * or deleting a database. Like the changes feed, the feed is not guaranteed to return changes in the correct order
   * and might repeat changes. Polling modes for this method work like polling modes for the changes feed.
   *
   * @param getDbUpdatesOptions the {@link GetDbUpdatesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DbUpdates}
   * @deprecated this method is deprecated and may be removed in a future release
   */
   @Deprecated
  public ServiceCall<DbUpdates> getDbUpdates(GetDbUpdatesOptions getDbUpdatesOptions) {
    LOGGER.warning("A deprecated operation has been invoked: getDbUpdates");
    if (getDbUpdatesOptions == null) {
      getDbUpdatesOptions = new GetDbUpdatesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_db_updates"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDbUpdates");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getDbUpdatesOptions.descending() != null) {
      builder.query("descending", String.valueOf(getDbUpdatesOptions.descending()));
    }
    if (getDbUpdatesOptions.feed() != null) {
      builder.query("feed", String.valueOf(getDbUpdatesOptions.feed()));
    }
    if (getDbUpdatesOptions.heartbeat() != null) {
      builder.query("heartbeat", String.valueOf(getDbUpdatesOptions.heartbeat()));
    }
    if (getDbUpdatesOptions.limit() != null) {
      builder.query("limit", String.valueOf(getDbUpdatesOptions.limit()));
    }
    if (getDbUpdatesOptions.timeout() != null) {
      builder.query("timeout", String.valueOf(getDbUpdatesOptions.timeout()));
    }
    if (getDbUpdatesOptions.since() != null) {
      builder.query("since", String.valueOf(getDbUpdatesOptions.since()));
    }
    ResponseConverter<DbUpdates> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DbUpdates>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve change events for all databases.
   *
   * **This endpoint is not available in IBM Cloudant.**
   *
   * Lists changes to databases, like a global changes feed. Types of changes include updating the database and creating
   * or deleting a database. Like the changes feed, the feed is not guaranteed to return changes in the correct order
   * and might repeat changes. Polling modes for this method work like polling modes for the changes feed.
   *
   * @return a {@link ServiceCall} with a result of type {@link DbUpdates}
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public ServiceCall<DbUpdates> getDbUpdates() {
    return getDbUpdates(null);
  }

  /**
   * Query the database document changes feed.
   *
   * Requests the database changes feed in the same way as `GET /{db}/_changes` does. It is widely used with the
   * `filter` query parameter because it allows one to pass more information to the filter.
   *
   * ### Note
   *
   * Before using the changes feed read the
   * [FAQs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-faq-using-changes-feed) to understand the limitations and
   * appropriate use cases.
   *
   * If you need to pass parameters to dynamically change the filtered content use the `_selector` filter type for
   * better performance and compatibility. The SDKs have full support for change requests using selector filters, but
   * don't support passing parameters to design document filters.
   *
   * @param postChangesOptions the {@link PostChangesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ChangesResult}
   */
  public ServiceCall<ChangesResult> postChanges(PostChangesOptions postChangesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postChangesOptions,
      "postChangesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postChangesOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_changes", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postChanges");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (postChangesOptions.lastEventId() != null) {
      builder.header("Last-Event-ID", postChangesOptions.lastEventId());
    }
    if (postChangesOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(postChangesOptions.attEncodingInfo()));
    }
    if (postChangesOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(postChangesOptions.attachments()));
    }
    if (postChangesOptions.conflicts() != null) {
      builder.query("conflicts", String.valueOf(postChangesOptions.conflicts()));
    }
    if (postChangesOptions.descending() != null) {
      builder.query("descending", String.valueOf(postChangesOptions.descending()));
    }
    if (postChangesOptions.feed() != null) {
      builder.query("feed", String.valueOf(postChangesOptions.feed()));
    }
    if (postChangesOptions.filter() != null) {
      builder.query("filter", String.valueOf(postChangesOptions.filter()));
    }
    if (postChangesOptions.heartbeat() != null) {
      builder.query("heartbeat", String.valueOf(postChangesOptions.heartbeat()));
    }
    if (postChangesOptions.includeDocs() != null) {
      builder.query("include_docs", String.valueOf(postChangesOptions.includeDocs()));
    }
    if (postChangesOptions.limit() != null) {
      builder.query("limit", String.valueOf(postChangesOptions.limit()));
    }
    if (postChangesOptions.seqInterval() != null) {
      builder.query("seq_interval", String.valueOf(postChangesOptions.seqInterval()));
    }
    if (postChangesOptions.since() != null) {
      builder.query("since", String.valueOf(postChangesOptions.since()));
    }
    if (postChangesOptions.style() != null) {
      builder.query("style", String.valueOf(postChangesOptions.style()));
    }
    if (postChangesOptions.timeout() != null) {
      builder.query("timeout", String.valueOf(postChangesOptions.timeout()));
    }
    if (postChangesOptions.view() != null) {
      builder.query("view", String.valueOf(postChangesOptions.view()));
    }
    final JsonObject contentJson = new JsonObject();
    if (postChangesOptions.docIds() != null) {
      contentJson.add("doc_ids", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postChangesOptions.docIds()));
    }
    if (postChangesOptions.fields() != null) {
      contentJson.add("fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postChangesOptions.fields()));
    }
    if (postChangesOptions.selector() != null) {
      contentJson.add("selector", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postChangesOptions.selector()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ChangesResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ChangesResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query the database document changes feed as stream.
   *
   * Requests the database changes feed in the same way as `GET /{db}/_changes` does. It is widely used with the
   * `filter` query parameter because it allows one to pass more information to the filter.
   *
   * ### Note
   *
   * Before using the changes feed read the
   * [FAQs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-faq-using-changes-feed) to understand the limitations and
   * appropriate use cases.
   *
   * If you need to pass parameters to dynamically change the filtered content use the `_selector` filter type for
   * better performance and compatibility. The SDKs have full support for change requests using selector filters, but
   * don't support passing parameters to design document filters.
   *
   * @param postChangesOptions the {@link PostChangesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postChangesAsStream(PostChangesOptions postChangesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postChangesOptions,
      "postChangesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postChangesOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_changes", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postChangesAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (postChangesOptions.lastEventId() != null) {
      builder.header("Last-Event-ID", postChangesOptions.lastEventId());
    }
    if (postChangesOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(postChangesOptions.attEncodingInfo()));
    }
    if (postChangesOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(postChangesOptions.attachments()));
    }
    if (postChangesOptions.conflicts() != null) {
      builder.query("conflicts", String.valueOf(postChangesOptions.conflicts()));
    }
    if (postChangesOptions.descending() != null) {
      builder.query("descending", String.valueOf(postChangesOptions.descending()));
    }
    if (postChangesOptions.feed() != null) {
      builder.query("feed", String.valueOf(postChangesOptions.feed()));
    }
    if (postChangesOptions.filter() != null) {
      builder.query("filter", String.valueOf(postChangesOptions.filter()));
    }
    if (postChangesOptions.heartbeat() != null) {
      builder.query("heartbeat", String.valueOf(postChangesOptions.heartbeat()));
    }
    if (postChangesOptions.includeDocs() != null) {
      builder.query("include_docs", String.valueOf(postChangesOptions.includeDocs()));
    }
    if (postChangesOptions.limit() != null) {
      builder.query("limit", String.valueOf(postChangesOptions.limit()));
    }
    if (postChangesOptions.seqInterval() != null) {
      builder.query("seq_interval", String.valueOf(postChangesOptions.seqInterval()));
    }
    if (postChangesOptions.since() != null) {
      builder.query("since", String.valueOf(postChangesOptions.since()));
    }
    if (postChangesOptions.style() != null) {
      builder.query("style", String.valueOf(postChangesOptions.style()));
    }
    if (postChangesOptions.timeout() != null) {
      builder.query("timeout", String.valueOf(postChangesOptions.timeout()));
    }
    if (postChangesOptions.view() != null) {
      builder.query("view", String.valueOf(postChangesOptions.view()));
    }
    final JsonObject contentJson = new JsonObject();
    if (postChangesOptions.docIds() != null) {
      contentJson.add("doc_ids", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postChangesOptions.docIds()));
    }
    if (postChangesOptions.fields() != null) {
      contentJson.add("fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postChangesOptions.fields()));
    }
    if (postChangesOptions.selector() != null) {
      contentJson.add("selector", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postChangesOptions.selector()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the HTTP headers for a database.
   *
   * Returns the HTTP headers that contain a minimal amount of information about the specified database. Since the
   * response body is empty, using the HEAD method is a lightweight way to check if the database exists or not.
   *
   * @param headDatabaseOptions the {@link HeadDatabaseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headDatabase(HeadDatabaseOptions headDatabaseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(headDatabaseOptions,
      "headDatabaseOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", headDatabaseOptions.db());
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "headDatabase");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a list of all database names in the instance.
   *
   * Query to retrieve a list of database names from the instance.
   *
   * @param getAllDbsOptions the {@link GetAllDbsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<String>> getAllDbs(GetAllDbsOptions getAllDbsOptions) {
    if (getAllDbsOptions == null) {
      getAllDbsOptions = new GetAllDbsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_all_dbs"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getAllDbs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAllDbsOptions.descending() != null) {
      builder.query("descending", String.valueOf(getAllDbsOptions.descending()));
    }
    if (getAllDbsOptions.endKey() != null) {
      builder.query("end_key", String.valueOf(getAllDbsOptions.endKey()));
    }
    if (getAllDbsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getAllDbsOptions.limit()));
    }
    if (getAllDbsOptions.skip() != null) {
      builder.query("skip", String.valueOf(getAllDbsOptions.skip()));
    }
    if (getAllDbsOptions.startKey() != null) {
      builder.query("start_key", String.valueOf(getAllDbsOptions.startKey()));
    }
    ResponseConverter<List<String>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<String>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a list of all database names in the instance.
   *
   * Query to retrieve a list of database names from the instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<String>> getAllDbs() {
    return getAllDbs(null);
  }

  /**
   * Query information about multiple databases.
   *
   * This operation enables you to request information about multiple databases in a single request, instead of issuing
   * multiple `GET /{db}` requests. It returns a list that contains an information object for each database specified in
   * the request.
   *
   * @param postDbsInfoOptions the {@link PostDbsInfoOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<DbsInfoResult>> postDbsInfo(PostDbsInfoOptions postDbsInfoOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postDbsInfoOptions,
      "postDbsInfoOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_dbs_info"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postDbsInfo");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postDbsInfoOptions.keys()));
    builder.bodyJson(contentJson);
    ResponseConverter<List<DbsInfoResult>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<DbsInfoResult>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a database.
   *
   * Deletes the specified database and all documents and attachments contained within it. To avoid deleting a database,
   * the server responds with a 400 HTTP status code when the request URL includes a `?rev=` parameter. This response
   * suggests that a user wanted to delete a document but forgot to add the document ID to the URL.
   *
   * @param deleteDatabaseOptions the {@link DeleteDatabaseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Ok}
   */
  public ServiceCall<Ok> deleteDatabase(DeleteDatabaseOptions deleteDatabaseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteDatabaseOptions,
      "deleteDatabaseOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", deleteDatabaseOptions.db());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "deleteDatabase");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Ok> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Ok>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information about a database.
   *
   * Retrieve detailed information about the database.
   *
   * @param getDatabaseInformationOptions the {@link GetDatabaseInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DatabaseInformation}
   */
  public ServiceCall<DatabaseInformation> getDatabaseInformation(GetDatabaseInformationOptions getDatabaseInformationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDatabaseInformationOptions,
      "getDatabaseInformationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getDatabaseInformationOptions.db());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDatabaseInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<DatabaseInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DatabaseInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a database.
   *
   * Create a new database with the requested properties.
   *
   * @param putDatabaseOptions the {@link PutDatabaseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Ok}
   */
  public ServiceCall<Ok> putDatabase(PutDatabaseOptions putDatabaseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putDatabaseOptions,
      "putDatabaseOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", putDatabaseOptions.db());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putDatabase");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (putDatabaseOptions.partitioned() != null) {
      builder.query("partitioned", String.valueOf(putDatabaseOptions.partitioned()));
    }
    if (putDatabaseOptions.q() != null) {
      builder.query("q", String.valueOf(putDatabaseOptions.q()));
    }
    ResponseConverter<Ok> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Ok>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the HTTP headers for the document.
   *
   * This method supports the same query arguments as the `GET /{db}/{docid}` method, but only the header information
   * (including document size and the revision as an ETag) is returned. The ETag header shows the current revision for
   * the requested document, and the Content-Length specifies the length of the data if the document was requested in
   * full. Add any of the query arguments, then the resulting HTTP headers that correspond to it are returned.
   *
   * @param headDocumentOptions the {@link HeadDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headDocument(HeadDocumentOptions headDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(headDocumentOptions,
      "headDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", headDocumentOptions.db());
    pathParamsMap.put("doc_id", headDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "headDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (headDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", headDocumentOptions.ifNoneMatch());
    }
    if (headDocumentOptions.latest() != null) {
      builder.query("latest", String.valueOf(headDocumentOptions.latest()));
    }
    if (headDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(headDocumentOptions.rev()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create or modify a document in a database.
   *
   * Creates or modifies a document in the specified database by using the supplied JSON document.
   *
   * For creation, you may specify the document ID but you should not specify the revision. If you don't specify the
   * document ID, then the server generates an ID for your document.
   *
   * For modification, you must specify the document ID and a revision identifier in the JSON document.
   *
   * If your document ID includes the `_local/` or `_design/` prefix, then this operation creates or modifies a local or
   * a design document respectively.
   *
   * @param postDocumentOptions the {@link PostDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> postDocument(PostDocumentOptions postDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postDocumentOptions,
      "postDocumentOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((postDocumentOptions.document() != null) || (postDocumentOptions.body() != null),
      "One of [postDocumentOptions.document(), postDocumentOptions.body()] must be specified");

    if (postDocumentOptions.document() != null && postDocumentOptions.contentType() == null) {
      postDocumentOptions = postDocumentOptions.newBuilder().contentType("application/json").build();
    }
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postDocumentOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (postDocumentOptions.contentType() != null) {
      builder.header("Content-Type", postDocumentOptions.contentType());
    }
    if (postDocumentOptions.batch() != null) {
      builder.query("batch", String.valueOf(postDocumentOptions.batch()));
    }
    builder.bodyContent(postDocumentOptions.contentType(), postDocumentOptions.document(),
      null, postDocumentOptions.body());
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a list of all documents in a database.
   *
   * Queries the primary index (all document IDs). The results that match the request body parameters are returned in a
   * JSON object, including a list of matching documents with basic contents, such as the ID and revision. When no
   * request body parameters are specified, results for all documents in the database are returned. Optionally, document
   * content or additional metadata can be included in the response.
   *
   * @param postAllDocsOptions the {@link PostAllDocsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AllDocsResult}
   */
  public ServiceCall<AllDocsResult> postAllDocs(PostAllDocsOptions postAllDocsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postAllDocsOptions,
      "postAllDocsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postAllDocsOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_all_docs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postAllDocs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (postAllDocsOptions.attEncodingInfo() != null) {
      contentJson.addProperty("att_encoding_info", postAllDocsOptions.attEncodingInfo());
    }
    if (postAllDocsOptions.attachments() != null) {
      contentJson.addProperty("attachments", postAllDocsOptions.attachments());
    }
    if (postAllDocsOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postAllDocsOptions.conflicts());
    }
    if (postAllDocsOptions.descending() != null) {
      contentJson.addProperty("descending", postAllDocsOptions.descending());
    }
    if (postAllDocsOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postAllDocsOptions.includeDocs());
    }
    if (postAllDocsOptions.inclusiveEnd() != null) {
      contentJson.addProperty("inclusive_end", postAllDocsOptions.inclusiveEnd());
    }
    if (postAllDocsOptions.limit() != null) {
      contentJson.addProperty("limit", postAllDocsOptions.limit());
    }
    if (postAllDocsOptions.skip() != null) {
      contentJson.addProperty("skip", postAllDocsOptions.skip());
    }
    if (postAllDocsOptions.updateSeq() != null) {
      contentJson.addProperty("update_seq", postAllDocsOptions.updateSeq());
    }
    if (postAllDocsOptions.endKey() != null) {
      contentJson.addProperty("end_key", postAllDocsOptions.endKey());
    }
    if (postAllDocsOptions.key() != null) {
      contentJson.addProperty("key", postAllDocsOptions.key());
    }
    if (postAllDocsOptions.keys() != null) {
      contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postAllDocsOptions.keys()));
    }
    if (postAllDocsOptions.startKey() != null) {
      contentJson.addProperty("start_key", postAllDocsOptions.startKey());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AllDocsResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AllDocsResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a list of all documents in a database as stream.
   *
   * Queries the primary index (all document IDs). The results that match the request body parameters are returned in a
   * JSON object, including a list of matching documents with basic contents, such as the ID and revision. When no
   * request body parameters are specified, results for all documents in the database are returned. Optionally, document
   * content or additional metadata can be included in the response.
   *
   * @param postAllDocsOptions the {@link PostAllDocsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postAllDocsAsStream(PostAllDocsOptions postAllDocsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postAllDocsOptions,
      "postAllDocsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postAllDocsOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_all_docs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postAllDocsAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (postAllDocsOptions.attEncodingInfo() != null) {
      contentJson.addProperty("att_encoding_info", postAllDocsOptions.attEncodingInfo());
    }
    if (postAllDocsOptions.attachments() != null) {
      contentJson.addProperty("attachments", postAllDocsOptions.attachments());
    }
    if (postAllDocsOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postAllDocsOptions.conflicts());
    }
    if (postAllDocsOptions.descending() != null) {
      contentJson.addProperty("descending", postAllDocsOptions.descending());
    }
    if (postAllDocsOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postAllDocsOptions.includeDocs());
    }
    if (postAllDocsOptions.inclusiveEnd() != null) {
      contentJson.addProperty("inclusive_end", postAllDocsOptions.inclusiveEnd());
    }
    if (postAllDocsOptions.limit() != null) {
      contentJson.addProperty("limit", postAllDocsOptions.limit());
    }
    if (postAllDocsOptions.skip() != null) {
      contentJson.addProperty("skip", postAllDocsOptions.skip());
    }
    if (postAllDocsOptions.updateSeq() != null) {
      contentJson.addProperty("update_seq", postAllDocsOptions.updateSeq());
    }
    if (postAllDocsOptions.endKey() != null) {
      contentJson.addProperty("end_key", postAllDocsOptions.endKey());
    }
    if (postAllDocsOptions.key() != null) {
      contentJson.addProperty("key", postAllDocsOptions.key());
    }
    if (postAllDocsOptions.keys() != null) {
      contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postAllDocsOptions.keys()));
    }
    if (postAllDocsOptions.startKey() != null) {
      contentJson.addProperty("start_key", postAllDocsOptions.startKey());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Multi-query the list of all documents in a database.
   *
   * Runs multiple queries using the primary index (all document IDs). Returns a JSON object that contains a list of
   * result objects, one for each query, with a structure equivalent to that of a single `_all_docs` request. This
   * enables you to request multiple queries in a single request, in place of multiple `POST /{db}/_all_docs` requests.
   *
   * @param postAllDocsQueriesOptions the {@link PostAllDocsQueriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AllDocsQueriesResult}
   */
  public ServiceCall<AllDocsQueriesResult> postAllDocsQueries(PostAllDocsQueriesOptions postAllDocsQueriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postAllDocsQueriesOptions,
      "postAllDocsQueriesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postAllDocsQueriesOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_all_docs/queries", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postAllDocsQueries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("queries", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postAllDocsQueriesOptions.queries()));
    builder.bodyJson(contentJson);
    ResponseConverter<AllDocsQueriesResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AllDocsQueriesResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Multi-query the list of all documents in a database as stream.
   *
   * Runs multiple queries using the primary index (all document IDs). Returns a JSON object that contains a list of
   * result objects, one for each query, with a structure equivalent to that of a single `_all_docs` request. This
   * enables you to request multiple queries in a single request, in place of multiple `POST /{db}/_all_docs` requests.
   *
   * @param postAllDocsQueriesOptions the {@link PostAllDocsQueriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postAllDocsQueriesAsStream(PostAllDocsQueriesOptions postAllDocsQueriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postAllDocsQueriesOptions,
      "postAllDocsQueriesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postAllDocsQueriesOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_all_docs/queries", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postAllDocsQueriesAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("queries", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postAllDocsQueriesOptions.queries()));
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Bulk modify multiple documents in a database.
   *
   * The bulk document API allows you to create, update, and delete multiple documents at the same time within a single
   * request. The basic operation is similar to creating, updating, or deleting a single document, except that you batch
   * the document structure and information.
   *
   * @param postBulkDocsOptions the {@link PostBulkDocsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<DocumentResult>> postBulkDocs(PostBulkDocsOptions postBulkDocsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postBulkDocsOptions,
      "postBulkDocsOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((postBulkDocsOptions.bulkDocs() != null) || (postBulkDocsOptions.body() != null),
      "One of [postBulkDocsOptions.bulkDocs(), postBulkDocsOptions.body()] must be specified");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postBulkDocsOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_bulk_docs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postBulkDocs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent("application/json", postBulkDocsOptions.bulkDocs(),
      null, postBulkDocsOptions.body());
    ResponseConverter<List<DocumentResult>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<DocumentResult>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Bulk query revision information for multiple documents.
   *
   * Fetch specific revisions or revision histories for multiple documents in bulk as replicators do.
   *
   * @param postBulkGetOptions the {@link PostBulkGetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BulkGetResult}
   */
  public ServiceCall<BulkGetResult> postBulkGet(PostBulkGetOptions postBulkGetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postBulkGetOptions,
      "postBulkGetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postBulkGetOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_bulk_get", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postBulkGet");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (postBulkGetOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(postBulkGetOptions.attachments()));
    }
    if (postBulkGetOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(postBulkGetOptions.attEncodingInfo()));
    }
    if (postBulkGetOptions.latest() != null) {
      builder.query("latest", String.valueOf(postBulkGetOptions.latest()));
    }
    if (postBulkGetOptions.revs() != null) {
      builder.query("revs", String.valueOf(postBulkGetOptions.revs()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("docs", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postBulkGetOptions.docs()));
    builder.bodyJson(contentJson);
    ResponseConverter<BulkGetResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BulkGetResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Bulk query revision information for multiple documents as mixed.
   *
   * Fetch specific revisions or revision histories for multiple documents in bulk as replicators do.
   *
   * @param postBulkGetOptions the {@link PostBulkGetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postBulkGetAsMixed(PostBulkGetOptions postBulkGetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postBulkGetOptions,
      "postBulkGetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postBulkGetOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_bulk_get", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postBulkGetAsMixed");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "multipart/mixed");
    if (postBulkGetOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(postBulkGetOptions.attachments()));
    }
    if (postBulkGetOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(postBulkGetOptions.attEncodingInfo()));
    }
    if (postBulkGetOptions.latest() != null) {
      builder.query("latest", String.valueOf(postBulkGetOptions.latest()));
    }
    if (postBulkGetOptions.revs() != null) {
      builder.query("revs", String.valueOf(postBulkGetOptions.revs()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("docs", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postBulkGetOptions.docs()));
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Bulk query revision information for multiple documents as related.
   *
   * Fetch specific revisions or revision histories for multiple documents in bulk as replicators do.
   *
   * @param postBulkGetOptions the {@link PostBulkGetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postBulkGetAsRelated(PostBulkGetOptions postBulkGetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postBulkGetOptions,
      "postBulkGetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postBulkGetOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_bulk_get", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postBulkGetAsRelated");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "multipart/related");
    if (postBulkGetOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(postBulkGetOptions.attachments()));
    }
    if (postBulkGetOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(postBulkGetOptions.attEncodingInfo()));
    }
    if (postBulkGetOptions.latest() != null) {
      builder.query("latest", String.valueOf(postBulkGetOptions.latest()));
    }
    if (postBulkGetOptions.revs() != null) {
      builder.query("revs", String.valueOf(postBulkGetOptions.revs()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("docs", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postBulkGetOptions.docs()));
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Bulk query revision information for multiple documents as stream.
   *
   * Fetch specific revisions or revision histories for multiple documents in bulk as replicators do.
   *
   * @param postBulkGetOptions the {@link PostBulkGetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postBulkGetAsStream(PostBulkGetOptions postBulkGetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postBulkGetOptions,
      "postBulkGetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postBulkGetOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_bulk_get", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postBulkGetAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (postBulkGetOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(postBulkGetOptions.attachments()));
    }
    if (postBulkGetOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(postBulkGetOptions.attEncodingInfo()));
    }
    if (postBulkGetOptions.latest() != null) {
      builder.query("latest", String.valueOf(postBulkGetOptions.latest()));
    }
    if (postBulkGetOptions.revs() != null) {
      builder.query("revs", String.valueOf(postBulkGetOptions.revs()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("docs", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postBulkGetOptions.docs()));
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a document.
   *
   * Marks the specified document as deleted by adding a `_deleted` field with the value `true`. Documents with this
   * field are not returned within requests anymore but stay in the database. You must supply the current (latest)
   * revision, either by using the `rev` parameter or by using the `If-Match` header to specify the revision.
   *
   * @param deleteDocumentOptions the {@link DeleteDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> deleteDocument(DeleteDocumentOptions deleteDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteDocumentOptions,
      "deleteDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", deleteDocumentOptions.db());
    pathParamsMap.put("doc_id", deleteDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "deleteDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteDocumentOptions.ifMatch() != null) {
      builder.header("If-Match", deleteDocumentOptions.ifMatch());
    }
    if (deleteDocumentOptions.batch() != null) {
      builder.query("batch", String.valueOf(deleteDocumentOptions.batch()));
    }
    if (deleteDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(deleteDocumentOptions.rev()));
    }
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a document.
   *
   * Returns document with the specified `doc_id` from the specified database. Unless you request a specific revision,
   * the latest revision of the document is always returned.
   *
   * @param getDocumentOptions the {@link GetDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Document}
   */
  public ServiceCall<Document> getDocument(GetDocumentOptions getDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentOptions,
      "getDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getDocumentOptions.db());
    pathParamsMap.put("doc_id", getDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", getDocumentOptions.ifNoneMatch());
    }
    if (getDocumentOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(getDocumentOptions.attachments()));
    }
    if (getDocumentOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(getDocumentOptions.attEncodingInfo()));
    }
    if (getDocumentOptions.conflicts() != null) {
      builder.query("conflicts", String.valueOf(getDocumentOptions.conflicts()));
    }
    if (getDocumentOptions.deletedConflicts() != null) {
      builder.query("deleted_conflicts", String.valueOf(getDocumentOptions.deletedConflicts()));
    }
    if (getDocumentOptions.latest() != null) {
      builder.query("latest", String.valueOf(getDocumentOptions.latest()));
    }
    if (getDocumentOptions.localSeq() != null) {
      builder.query("local_seq", String.valueOf(getDocumentOptions.localSeq()));
    }
    if (getDocumentOptions.meta() != null) {
      builder.query("meta", String.valueOf(getDocumentOptions.meta()));
    }
    if (getDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(getDocumentOptions.rev()));
    }
    if (getDocumentOptions.revs() != null) {
      builder.query("revs", String.valueOf(getDocumentOptions.revs()));
    }
    if (getDocumentOptions.revsInfo() != null) {
      builder.query("revs_info", String.valueOf(getDocumentOptions.revsInfo()));
    }
    ResponseConverter<Document> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Document>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a document as mixed.
   *
   * Returns document with the specified `doc_id` from the specified database. Unless you request a specific revision,
   * the latest revision of the document is always returned.
   *
   * @param getDocumentOptions the {@link GetDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getDocumentAsMixed(GetDocumentOptions getDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentOptions,
      "getDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getDocumentOptions.db());
    pathParamsMap.put("doc_id", getDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDocumentAsMixed");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "multipart/mixed");
    if (getDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", getDocumentOptions.ifNoneMatch());
    }
    if (getDocumentOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(getDocumentOptions.attachments()));
    }
    if (getDocumentOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(getDocumentOptions.attEncodingInfo()));
    }
    if (getDocumentOptions.conflicts() != null) {
      builder.query("conflicts", String.valueOf(getDocumentOptions.conflicts()));
    }
    if (getDocumentOptions.deletedConflicts() != null) {
      builder.query("deleted_conflicts", String.valueOf(getDocumentOptions.deletedConflicts()));
    }
    if (getDocumentOptions.latest() != null) {
      builder.query("latest", String.valueOf(getDocumentOptions.latest()));
    }
    if (getDocumentOptions.localSeq() != null) {
      builder.query("local_seq", String.valueOf(getDocumentOptions.localSeq()));
    }
    if (getDocumentOptions.meta() != null) {
      builder.query("meta", String.valueOf(getDocumentOptions.meta()));
    }
    if (getDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(getDocumentOptions.rev()));
    }
    if (getDocumentOptions.revs() != null) {
      builder.query("revs", String.valueOf(getDocumentOptions.revs()));
    }
    if (getDocumentOptions.revsInfo() != null) {
      builder.query("revs_info", String.valueOf(getDocumentOptions.revsInfo()));
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a document as related.
   *
   * Returns document with the specified `doc_id` from the specified database. Unless you request a specific revision,
   * the latest revision of the document is always returned.
   *
   * @param getDocumentOptions the {@link GetDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getDocumentAsRelated(GetDocumentOptions getDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentOptions,
      "getDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getDocumentOptions.db());
    pathParamsMap.put("doc_id", getDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDocumentAsRelated");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "multipart/related");
    if (getDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", getDocumentOptions.ifNoneMatch());
    }
    if (getDocumentOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(getDocumentOptions.attachments()));
    }
    if (getDocumentOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(getDocumentOptions.attEncodingInfo()));
    }
    if (getDocumentOptions.conflicts() != null) {
      builder.query("conflicts", String.valueOf(getDocumentOptions.conflicts()));
    }
    if (getDocumentOptions.deletedConflicts() != null) {
      builder.query("deleted_conflicts", String.valueOf(getDocumentOptions.deletedConflicts()));
    }
    if (getDocumentOptions.latest() != null) {
      builder.query("latest", String.valueOf(getDocumentOptions.latest()));
    }
    if (getDocumentOptions.localSeq() != null) {
      builder.query("local_seq", String.valueOf(getDocumentOptions.localSeq()));
    }
    if (getDocumentOptions.meta() != null) {
      builder.query("meta", String.valueOf(getDocumentOptions.meta()));
    }
    if (getDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(getDocumentOptions.rev()));
    }
    if (getDocumentOptions.revs() != null) {
      builder.query("revs", String.valueOf(getDocumentOptions.revs()));
    }
    if (getDocumentOptions.revsInfo() != null) {
      builder.query("revs_info", String.valueOf(getDocumentOptions.revsInfo()));
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a document as stream.
   *
   * Returns document with the specified `doc_id` from the specified database. Unless you request a specific revision,
   * the latest revision of the document is always returned.
   *
   * @param getDocumentOptions the {@link GetDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getDocumentAsStream(GetDocumentOptions getDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentOptions,
      "getDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getDocumentOptions.db());
    pathParamsMap.put("doc_id", getDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDocumentAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", getDocumentOptions.ifNoneMatch());
    }
    if (getDocumentOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(getDocumentOptions.attachments()));
    }
    if (getDocumentOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(getDocumentOptions.attEncodingInfo()));
    }
    if (getDocumentOptions.conflicts() != null) {
      builder.query("conflicts", String.valueOf(getDocumentOptions.conflicts()));
    }
    if (getDocumentOptions.deletedConflicts() != null) {
      builder.query("deleted_conflicts", String.valueOf(getDocumentOptions.deletedConflicts()));
    }
    if (getDocumentOptions.latest() != null) {
      builder.query("latest", String.valueOf(getDocumentOptions.latest()));
    }
    if (getDocumentOptions.localSeq() != null) {
      builder.query("local_seq", String.valueOf(getDocumentOptions.localSeq()));
    }
    if (getDocumentOptions.meta() != null) {
      builder.query("meta", String.valueOf(getDocumentOptions.meta()));
    }
    if (getDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(getDocumentOptions.rev()));
    }
    if (getDocumentOptions.revs() != null) {
      builder.query("revs", String.valueOf(getDocumentOptions.revs()));
    }
    if (getDocumentOptions.revsInfo() != null) {
      builder.query("revs_info", String.valueOf(getDocumentOptions.revsInfo()));
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create or modify a document.
   *
   * Creates or modifies a document in the specified database.
   *
   * For creation, you must specify the document ID but you should not specify the revision.
   *
   * For modification, you must specify the document ID and a revision  identifier.
   *
   * @param putDocumentOptions the {@link PutDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> putDocument(PutDocumentOptions putDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putDocumentOptions,
      "putDocumentOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((putDocumentOptions.document() != null) || (putDocumentOptions.body() != null),
      "One of [putDocumentOptions.document(), putDocumentOptions.body()] must be specified");

    if (putDocumentOptions.document() != null && putDocumentOptions.contentType() == null) {
      putDocumentOptions = putDocumentOptions.newBuilder().contentType("application/json").build();
    }
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", putDocumentOptions.db());
    pathParamsMap.put("doc_id", putDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (putDocumentOptions.contentType() != null) {
      builder.header("Content-Type", putDocumentOptions.contentType());
    }
    if (putDocumentOptions.ifMatch() != null) {
      builder.header("If-Match", putDocumentOptions.ifMatch());
    }
    if (putDocumentOptions.batch() != null) {
      builder.query("batch", String.valueOf(putDocumentOptions.batch()));
    }
    if (putDocumentOptions.newEdits() != null) {
      builder.query("new_edits", String.valueOf(putDocumentOptions.newEdits()));
    }
    if (putDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(putDocumentOptions.rev()));
    }
    builder.bodyContent(putDocumentOptions.contentType(), putDocumentOptions.document(),
      null, putDocumentOptions.body());
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the HTTP headers for a design document.
   *
   * This method supports the same query arguments as the `GET /{db}/_design/{ddoc}` method, but the results include
   * only the header information (including design document size, and the revision as an ETag). The ETag header shows
   * the current revision for the requested design document, and if you requested the design document in full, the
   * Content-Length specifies the length of the data. If you add any of the query arguments, then the resulting HTTP
   * headers correspond to what is returned for the equivalent GET request.
   *
   * @param headDesignDocumentOptions the {@link HeadDesignDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headDesignDocument(HeadDesignDocumentOptions headDesignDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(headDesignDocumentOptions,
      "headDesignDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", headDesignDocumentOptions.db());
    pathParamsMap.put("ddoc", headDesignDocumentOptions.ddoc());
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "headDesignDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (headDesignDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", headDesignDocumentOptions.ifNoneMatch());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a design document.
   *
   * Marks the specified design document as deleted by adding a `_deleted` field with the value `true`. Documents with
   * this field are not returned with requests but stay in the database. You must supply the current (latest) revision,
   * either by using the `rev` parameter or by using the `If-Match` header to specify the revision.
   *
   * @param deleteDesignDocumentOptions the {@link DeleteDesignDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> deleteDesignDocument(DeleteDesignDocumentOptions deleteDesignDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteDesignDocumentOptions,
      "deleteDesignDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", deleteDesignDocumentOptions.db());
    pathParamsMap.put("ddoc", deleteDesignDocumentOptions.ddoc());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "deleteDesignDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteDesignDocumentOptions.ifMatch() != null) {
      builder.header("If-Match", deleteDesignDocumentOptions.ifMatch());
    }
    if (deleteDesignDocumentOptions.batch() != null) {
      builder.query("batch", String.valueOf(deleteDesignDocumentOptions.batch()));
    }
    if (deleteDesignDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(deleteDesignDocumentOptions.rev()));
    }
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a design document.
   *
   * Returns design document with the specified `doc_id` from the specified database. Unless you request a specific
   * revision, the current revision of the design document is always returned.
   *
   * @param getDesignDocumentOptions the {@link GetDesignDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DesignDocument}
   */
  public ServiceCall<DesignDocument> getDesignDocument(GetDesignDocumentOptions getDesignDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDesignDocumentOptions,
      "getDesignDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getDesignDocumentOptions.db());
    pathParamsMap.put("ddoc", getDesignDocumentOptions.ddoc());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDesignDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getDesignDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", getDesignDocumentOptions.ifNoneMatch());
    }
    if (getDesignDocumentOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(getDesignDocumentOptions.attachments()));
    }
    if (getDesignDocumentOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(getDesignDocumentOptions.attEncodingInfo()));
    }
    if (getDesignDocumentOptions.conflicts() != null) {
      builder.query("conflicts", String.valueOf(getDesignDocumentOptions.conflicts()));
    }
    if (getDesignDocumentOptions.deletedConflicts() != null) {
      builder.query("deleted_conflicts", String.valueOf(getDesignDocumentOptions.deletedConflicts()));
    }
    if (getDesignDocumentOptions.latest() != null) {
      builder.query("latest", String.valueOf(getDesignDocumentOptions.latest()));
    }
    if (getDesignDocumentOptions.localSeq() != null) {
      builder.query("local_seq", String.valueOf(getDesignDocumentOptions.localSeq()));
    }
    if (getDesignDocumentOptions.meta() != null) {
      builder.query("meta", String.valueOf(getDesignDocumentOptions.meta()));
    }
    if (getDesignDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(getDesignDocumentOptions.rev()));
    }
    if (getDesignDocumentOptions.revs() != null) {
      builder.query("revs", String.valueOf(getDesignDocumentOptions.revs()));
    }
    if (getDesignDocumentOptions.revsInfo() != null) {
      builder.query("revs_info", String.valueOf(getDesignDocumentOptions.revsInfo()));
    }
    ResponseConverter<DesignDocument> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DesignDocument>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create or modify a design document.
   *
   * The PUT method creates a new named design document, or creates a new revision of the existing design document.
   *
   * @param putDesignDocumentOptions the {@link PutDesignDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> putDesignDocument(PutDesignDocumentOptions putDesignDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putDesignDocumentOptions,
      "putDesignDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", putDesignDocumentOptions.db());
    pathParamsMap.put("ddoc", putDesignDocumentOptions.ddoc());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putDesignDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (putDesignDocumentOptions.ifMatch() != null) {
      builder.header("If-Match", putDesignDocumentOptions.ifMatch());
    }
    if (putDesignDocumentOptions.batch() != null) {
      builder.query("batch", String.valueOf(putDesignDocumentOptions.batch()));
    }
    if (putDesignDocumentOptions.newEdits() != null) {
      builder.query("new_edits", String.valueOf(putDesignDocumentOptions.newEdits()));
    }
    if (putDesignDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(putDesignDocumentOptions.rev()));
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(putDesignDocumentOptions.designDocument()), "application/json");
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information about a design document.
   *
   * Retrieves information about the specified design document, including the index, index size, and current status of
   * the design document and associated index information.
   *
   * @param getDesignDocumentInformationOptions the {@link GetDesignDocumentInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DesignDocumentInformation}
   */
  public ServiceCall<DesignDocumentInformation> getDesignDocumentInformation(GetDesignDocumentInformationOptions getDesignDocumentInformationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDesignDocumentInformationOptions,
      "getDesignDocumentInformationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getDesignDocumentInformationOptions.db());
    pathParamsMap.put("ddoc", getDesignDocumentInformationOptions.ddoc());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}/_info", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDesignDocumentInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<DesignDocumentInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DesignDocumentInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a list of all design documents in a database.
   *
   * Queries the index of all design document IDs. The results matching the request body parameters are returned in a
   * JSON object, including a list of matching design documents with basic contents, such as the ID and revision. When
   * no request body parameters are specified, results for all design documents in the database are returned.
   * Optionally, the design document content or additional metadata can be included in the response.
   *
   * @param postDesignDocsOptions the {@link PostDesignDocsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AllDocsResult}
   */
  public ServiceCall<AllDocsResult> postDesignDocs(PostDesignDocsOptions postDesignDocsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postDesignDocsOptions,
      "postDesignDocsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postDesignDocsOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design_docs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postDesignDocs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (postDesignDocsOptions.attEncodingInfo() != null) {
      contentJson.addProperty("att_encoding_info", postDesignDocsOptions.attEncodingInfo());
    }
    if (postDesignDocsOptions.attachments() != null) {
      contentJson.addProperty("attachments", postDesignDocsOptions.attachments());
    }
    if (postDesignDocsOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postDesignDocsOptions.conflicts());
    }
    if (postDesignDocsOptions.descending() != null) {
      contentJson.addProperty("descending", postDesignDocsOptions.descending());
    }
    if (postDesignDocsOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postDesignDocsOptions.includeDocs());
    }
    if (postDesignDocsOptions.inclusiveEnd() != null) {
      contentJson.addProperty("inclusive_end", postDesignDocsOptions.inclusiveEnd());
    }
    if (postDesignDocsOptions.limit() != null) {
      contentJson.addProperty("limit", postDesignDocsOptions.limit());
    }
    if (postDesignDocsOptions.skip() != null) {
      contentJson.addProperty("skip", postDesignDocsOptions.skip());
    }
    if (postDesignDocsOptions.updateSeq() != null) {
      contentJson.addProperty("update_seq", postDesignDocsOptions.updateSeq());
    }
    if (postDesignDocsOptions.endKey() != null) {
      contentJson.addProperty("end_key", postDesignDocsOptions.endKey());
    }
    if (postDesignDocsOptions.key() != null) {
      contentJson.addProperty("key", postDesignDocsOptions.key());
    }
    if (postDesignDocsOptions.keys() != null) {
      contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postDesignDocsOptions.keys()));
    }
    if (postDesignDocsOptions.startKey() != null) {
      contentJson.addProperty("start_key", postDesignDocsOptions.startKey());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AllDocsResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AllDocsResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Multi-query the list of all design documents.
   *
   * This operation runs multiple view queries of all design documents in the database. This operation enables you to
   * request numerous queries in a single request, in place of multiple POST `/{db}/_design_docs` requests.
   *
   * @param postDesignDocsQueriesOptions the {@link PostDesignDocsQueriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AllDocsQueriesResult}
   */
  public ServiceCall<AllDocsQueriesResult> postDesignDocsQueries(PostDesignDocsQueriesOptions postDesignDocsQueriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postDesignDocsQueriesOptions,
      "postDesignDocsQueriesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postDesignDocsQueriesOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design_docs/queries", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postDesignDocsQueries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (postDesignDocsQueriesOptions.accept() != null) {
      builder.header("Accept", postDesignDocsQueriesOptions.accept());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("queries", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postDesignDocsQueriesOptions.queries()));
    builder.bodyJson(contentJson);
    ResponseConverter<AllDocsQueriesResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AllDocsQueriesResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a MapReduce view.
   *
   * This operation queries the specified MapReduce view of the specified design document. By default, the map and
   * reduce functions of the view are run to update the view before returning the response. The advantage of using the
   * HTTP `POST` method is that the query is submitted as a JSON object in the request body. This avoids the limitations
   * of passing query options as URL query parameters of a `GET` request.
   *
   * @param postViewOptions the {@link PostViewOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ViewResult}
   */
  public ServiceCall<ViewResult> postView(PostViewOptions postViewOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postViewOptions,
      "postViewOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postViewOptions.db());
    pathParamsMap.put("ddoc", postViewOptions.ddoc());
    pathParamsMap.put("view", postViewOptions.view());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}/_view/{view}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postView");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (postViewOptions.attEncodingInfo() != null) {
      contentJson.addProperty("att_encoding_info", postViewOptions.attEncodingInfo());
    }
    if (postViewOptions.attachments() != null) {
      contentJson.addProperty("attachments", postViewOptions.attachments());
    }
    if (postViewOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postViewOptions.conflicts());
    }
    if (postViewOptions.descending() != null) {
      contentJson.addProperty("descending", postViewOptions.descending());
    }
    if (postViewOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postViewOptions.includeDocs());
    }
    if (postViewOptions.inclusiveEnd() != null) {
      contentJson.addProperty("inclusive_end", postViewOptions.inclusiveEnd());
    }
    if (postViewOptions.limit() != null) {
      contentJson.addProperty("limit", postViewOptions.limit());
    }
    if (postViewOptions.skip() != null) {
      contentJson.addProperty("skip", postViewOptions.skip());
    }
    if (postViewOptions.updateSeq() != null) {
      contentJson.addProperty("update_seq", postViewOptions.updateSeq());
    }
    if (postViewOptions.endKey() != null) {
      contentJson.add("end_key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewOptions.endKey()));
    }
    if (postViewOptions.endKeyDocId() != null) {
      contentJson.addProperty("end_key_doc_id", postViewOptions.endKeyDocId());
    }
    if (postViewOptions.group() != null) {
      contentJson.addProperty("group", postViewOptions.group());
    }
    if (postViewOptions.groupLevel() != null) {
      contentJson.addProperty("group_level", postViewOptions.groupLevel());
    }
    if (postViewOptions.key() != null) {
      contentJson.add("key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewOptions.key()));
    }
    if (postViewOptions.keys() != null) {
      contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewOptions.keys()));
    }
    if (postViewOptions.reduce() != null) {
      contentJson.addProperty("reduce", postViewOptions.reduce());
    }
    if (postViewOptions.stable() != null) {
      contentJson.addProperty("stable", postViewOptions.stable());
    }
    if (postViewOptions.startKey() != null) {
      contentJson.add("start_key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewOptions.startKey()));
    }
    if (postViewOptions.startKeyDocId() != null) {
      contentJson.addProperty("start_key_doc_id", postViewOptions.startKeyDocId());
    }
    if (postViewOptions.update() != null) {
      contentJson.addProperty("update", postViewOptions.update());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ViewResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ViewResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a MapReduce view as stream.
   *
   * This operation queries the specified MapReduce view of the specified design document. By default, the map and
   * reduce functions of the view are run to update the view before returning the response. The advantage of using the
   * HTTP `POST` method is that the query is submitted as a JSON object in the request body. This avoids the limitations
   * of passing query options as URL query parameters of a `GET` request.
   *
   * @param postViewOptions the {@link PostViewOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postViewAsStream(PostViewOptions postViewOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postViewOptions,
      "postViewOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postViewOptions.db());
    pathParamsMap.put("ddoc", postViewOptions.ddoc());
    pathParamsMap.put("view", postViewOptions.view());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}/_view/{view}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postViewAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (postViewOptions.attEncodingInfo() != null) {
      contentJson.addProperty("att_encoding_info", postViewOptions.attEncodingInfo());
    }
    if (postViewOptions.attachments() != null) {
      contentJson.addProperty("attachments", postViewOptions.attachments());
    }
    if (postViewOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postViewOptions.conflicts());
    }
    if (postViewOptions.descending() != null) {
      contentJson.addProperty("descending", postViewOptions.descending());
    }
    if (postViewOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postViewOptions.includeDocs());
    }
    if (postViewOptions.inclusiveEnd() != null) {
      contentJson.addProperty("inclusive_end", postViewOptions.inclusiveEnd());
    }
    if (postViewOptions.limit() != null) {
      contentJson.addProperty("limit", postViewOptions.limit());
    }
    if (postViewOptions.skip() != null) {
      contentJson.addProperty("skip", postViewOptions.skip());
    }
    if (postViewOptions.updateSeq() != null) {
      contentJson.addProperty("update_seq", postViewOptions.updateSeq());
    }
    if (postViewOptions.endKey() != null) {
      contentJson.add("end_key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewOptions.endKey()));
    }
    if (postViewOptions.endKeyDocId() != null) {
      contentJson.addProperty("end_key_doc_id", postViewOptions.endKeyDocId());
    }
    if (postViewOptions.group() != null) {
      contentJson.addProperty("group", postViewOptions.group());
    }
    if (postViewOptions.groupLevel() != null) {
      contentJson.addProperty("group_level", postViewOptions.groupLevel());
    }
    if (postViewOptions.key() != null) {
      contentJson.add("key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewOptions.key()));
    }
    if (postViewOptions.keys() != null) {
      contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewOptions.keys()));
    }
    if (postViewOptions.reduce() != null) {
      contentJson.addProperty("reduce", postViewOptions.reduce());
    }
    if (postViewOptions.stable() != null) {
      contentJson.addProperty("stable", postViewOptions.stable());
    }
    if (postViewOptions.startKey() != null) {
      contentJson.add("start_key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewOptions.startKey()));
    }
    if (postViewOptions.startKeyDocId() != null) {
      contentJson.addProperty("start_key_doc_id", postViewOptions.startKeyDocId());
    }
    if (postViewOptions.update() != null) {
      contentJson.addProperty("update", postViewOptions.update());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Multi-query a MapReduce view.
   *
   * This operation runs multiple specified view queries against the view function from the specified design document.
   *
   * @param postViewQueriesOptions the {@link PostViewQueriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ViewQueriesResult}
   */
  public ServiceCall<ViewQueriesResult> postViewQueries(PostViewQueriesOptions postViewQueriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postViewQueriesOptions,
      "postViewQueriesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postViewQueriesOptions.db());
    pathParamsMap.put("ddoc", postViewQueriesOptions.ddoc());
    pathParamsMap.put("view", postViewQueriesOptions.view());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}/_view/{view}/queries", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postViewQueries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("queries", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewQueriesOptions.queries()));
    builder.bodyJson(contentJson);
    ResponseConverter<ViewQueriesResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ViewQueriesResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Multi-query a MapReduce view as stream.
   *
   * This operation runs multiple specified view queries against the view function from the specified design document.
   *
   * @param postViewQueriesOptions the {@link PostViewQueriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postViewQueriesAsStream(PostViewQueriesOptions postViewQueriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postViewQueriesOptions,
      "postViewQueriesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postViewQueriesOptions.db());
    pathParamsMap.put("ddoc", postViewQueriesOptions.ddoc());
    pathParamsMap.put("view", postViewQueriesOptions.view());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}/_view/{view}/queries", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postViewQueriesAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("queries", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postViewQueriesOptions.queries()));
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information about a database partition.
   *
   * Given a partition key, return the database name, sizes, partition, doc count, and doc delete count.
   *
   * @param getPartitionInformationOptions the {@link GetPartitionInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PartitionInformation}
   */
  public ServiceCall<PartitionInformation> getPartitionInformation(GetPartitionInformationOptions getPartitionInformationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPartitionInformationOptions,
      "getPartitionInformationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getPartitionInformationOptions.db());
    pathParamsMap.put("partition_key", getPartitionInformationOptions.partitionKey());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getPartitionInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<PartitionInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PartitionInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a list of all documents in a database partition.
   *
   * Queries the primary index (all document IDs). The results that match the query parameters are returned in a JSON
   * object, including a list of matching documents with basic contents, such as the ID and revision. When no query
   * parameters are specified, results for all documents in the database partition are returned. Optionally, document
   * content or additional metadata can be included in the response.
   *
   * @param postPartitionAllDocsOptions the {@link PostPartitionAllDocsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AllDocsResult}
   */
  public ServiceCall<AllDocsResult> postPartitionAllDocs(PostPartitionAllDocsOptions postPartitionAllDocsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPartitionAllDocsOptions,
      "postPartitionAllDocsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postPartitionAllDocsOptions.db());
    pathParamsMap.put("partition_key", postPartitionAllDocsOptions.partitionKey());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}/_all_docs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postPartitionAllDocs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (postPartitionAllDocsOptions.attEncodingInfo() != null) {
      contentJson.addProperty("att_encoding_info", postPartitionAllDocsOptions.attEncodingInfo());
    }
    if (postPartitionAllDocsOptions.attachments() != null) {
      contentJson.addProperty("attachments", postPartitionAllDocsOptions.attachments());
    }
    if (postPartitionAllDocsOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postPartitionAllDocsOptions.conflicts());
    }
    if (postPartitionAllDocsOptions.descending() != null) {
      contentJson.addProperty("descending", postPartitionAllDocsOptions.descending());
    }
    if (postPartitionAllDocsOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postPartitionAllDocsOptions.includeDocs());
    }
    if (postPartitionAllDocsOptions.inclusiveEnd() != null) {
      contentJson.addProperty("inclusive_end", postPartitionAllDocsOptions.inclusiveEnd());
    }
    if (postPartitionAllDocsOptions.limit() != null) {
      contentJson.addProperty("limit", postPartitionAllDocsOptions.limit());
    }
    if (postPartitionAllDocsOptions.skip() != null) {
      contentJson.addProperty("skip", postPartitionAllDocsOptions.skip());
    }
    if (postPartitionAllDocsOptions.updateSeq() != null) {
      contentJson.addProperty("update_seq", postPartitionAllDocsOptions.updateSeq());
    }
    if (postPartitionAllDocsOptions.endKey() != null) {
      contentJson.addProperty("end_key", postPartitionAllDocsOptions.endKey());
    }
    if (postPartitionAllDocsOptions.key() != null) {
      contentJson.addProperty("key", postPartitionAllDocsOptions.key());
    }
    if (postPartitionAllDocsOptions.keys() != null) {
      contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionAllDocsOptions.keys()));
    }
    if (postPartitionAllDocsOptions.startKey() != null) {
      contentJson.addProperty("start_key", postPartitionAllDocsOptions.startKey());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AllDocsResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AllDocsResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a list of all documents in a database partition as stream.
   *
   * Queries the primary index (all document IDs). The results that match the query parameters are returned in a JSON
   * object, including a list of matching documents with basic contents, such as the ID and revision. When no query
   * parameters are specified, results for all documents in the database partition are returned. Optionally, document
   * content or additional metadata can be included in the response.
   *
   * @param postPartitionAllDocsOptions the {@link PostPartitionAllDocsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postPartitionAllDocsAsStream(PostPartitionAllDocsOptions postPartitionAllDocsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPartitionAllDocsOptions,
      "postPartitionAllDocsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postPartitionAllDocsOptions.db());
    pathParamsMap.put("partition_key", postPartitionAllDocsOptions.partitionKey());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}/_all_docs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postPartitionAllDocsAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (postPartitionAllDocsOptions.attEncodingInfo() != null) {
      contentJson.addProperty("att_encoding_info", postPartitionAllDocsOptions.attEncodingInfo());
    }
    if (postPartitionAllDocsOptions.attachments() != null) {
      contentJson.addProperty("attachments", postPartitionAllDocsOptions.attachments());
    }
    if (postPartitionAllDocsOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postPartitionAllDocsOptions.conflicts());
    }
    if (postPartitionAllDocsOptions.descending() != null) {
      contentJson.addProperty("descending", postPartitionAllDocsOptions.descending());
    }
    if (postPartitionAllDocsOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postPartitionAllDocsOptions.includeDocs());
    }
    if (postPartitionAllDocsOptions.inclusiveEnd() != null) {
      contentJson.addProperty("inclusive_end", postPartitionAllDocsOptions.inclusiveEnd());
    }
    if (postPartitionAllDocsOptions.limit() != null) {
      contentJson.addProperty("limit", postPartitionAllDocsOptions.limit());
    }
    if (postPartitionAllDocsOptions.skip() != null) {
      contentJson.addProperty("skip", postPartitionAllDocsOptions.skip());
    }
    if (postPartitionAllDocsOptions.updateSeq() != null) {
      contentJson.addProperty("update_seq", postPartitionAllDocsOptions.updateSeq());
    }
    if (postPartitionAllDocsOptions.endKey() != null) {
      contentJson.addProperty("end_key", postPartitionAllDocsOptions.endKey());
    }
    if (postPartitionAllDocsOptions.key() != null) {
      contentJson.addProperty("key", postPartitionAllDocsOptions.key());
    }
    if (postPartitionAllDocsOptions.keys() != null) {
      contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionAllDocsOptions.keys()));
    }
    if (postPartitionAllDocsOptions.startKey() != null) {
      contentJson.addProperty("start_key", postPartitionAllDocsOptions.startKey());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a database partition search index.
   *
   * Partitioned Search indexes, which are defined in design documents, allow partition databases to be queried by using
   * Lucene Query Parser Syntax. Search indexes are defined by an index function, similar to a map function in MapReduce
   * views. The index function decides what data to index and store in the index.
   *
   * Before using read the
   * [FAQs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-database-partitioning#partition-querying) to understand
   * the limitations and appropriate use cases.
   *
   * @param postPartitionSearchOptions the {@link PostPartitionSearchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SearchResult}
   */
  public ServiceCall<SearchResult> postPartitionSearch(PostPartitionSearchOptions postPartitionSearchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPartitionSearchOptions,
      "postPartitionSearchOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postPartitionSearchOptions.db());
    pathParamsMap.put("partition_key", postPartitionSearchOptions.partitionKey());
    pathParamsMap.put("ddoc", postPartitionSearchOptions.ddoc());
    pathParamsMap.put("index", postPartitionSearchOptions.index());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}/_design/{ddoc}/_search/{index}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postPartitionSearch");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("query", postPartitionSearchOptions.query());
    if (postPartitionSearchOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postPartitionSearchOptions.bookmark());
    }
    if (postPartitionSearchOptions.highlightFields() != null) {
      contentJson.add("highlight_fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionSearchOptions.highlightFields()));
    }
    if (postPartitionSearchOptions.highlightNumber() != null) {
      contentJson.addProperty("highlight_number", postPartitionSearchOptions.highlightNumber());
    }
    if (postPartitionSearchOptions.highlightPostTag() != null) {
      contentJson.addProperty("highlight_post_tag", postPartitionSearchOptions.highlightPostTag());
    }
    if (postPartitionSearchOptions.highlightPreTag() != null) {
      contentJson.addProperty("highlight_pre_tag", postPartitionSearchOptions.highlightPreTag());
    }
    if (postPartitionSearchOptions.highlightSize() != null) {
      contentJson.addProperty("highlight_size", postPartitionSearchOptions.highlightSize());
    }
    if (postPartitionSearchOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postPartitionSearchOptions.includeDocs());
    }
    if (postPartitionSearchOptions.includeFields() != null) {
      contentJson.add("include_fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionSearchOptions.includeFields()));
    }
    if (postPartitionSearchOptions.limit() != null) {
      contentJson.addProperty("limit", postPartitionSearchOptions.limit());
    }
    if (postPartitionSearchOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionSearchOptions.sort()));
    }
    if (postPartitionSearchOptions.stale() != null) {
      contentJson.addProperty("stale", postPartitionSearchOptions.stale());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<SearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a database partition search index as stream.
   *
   * Partitioned Search indexes, which are defined in design documents, allow partition databases to be queried by using
   * Lucene Query Parser Syntax. Search indexes are defined by an index function, similar to a map function in MapReduce
   * views. The index function decides what data to index and store in the index.
   *
   * Before using read the
   * [FAQs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-database-partitioning#partition-querying) to understand
   * the limitations and appropriate use cases.
   *
   * @param postPartitionSearchOptions the {@link PostPartitionSearchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postPartitionSearchAsStream(PostPartitionSearchOptions postPartitionSearchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPartitionSearchOptions,
      "postPartitionSearchOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postPartitionSearchOptions.db());
    pathParamsMap.put("partition_key", postPartitionSearchOptions.partitionKey());
    pathParamsMap.put("ddoc", postPartitionSearchOptions.ddoc());
    pathParamsMap.put("index", postPartitionSearchOptions.index());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}/_design/{ddoc}/_search/{index}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postPartitionSearchAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("query", postPartitionSearchOptions.query());
    if (postPartitionSearchOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postPartitionSearchOptions.bookmark());
    }
    if (postPartitionSearchOptions.highlightFields() != null) {
      contentJson.add("highlight_fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionSearchOptions.highlightFields()));
    }
    if (postPartitionSearchOptions.highlightNumber() != null) {
      contentJson.addProperty("highlight_number", postPartitionSearchOptions.highlightNumber());
    }
    if (postPartitionSearchOptions.highlightPostTag() != null) {
      contentJson.addProperty("highlight_post_tag", postPartitionSearchOptions.highlightPostTag());
    }
    if (postPartitionSearchOptions.highlightPreTag() != null) {
      contentJson.addProperty("highlight_pre_tag", postPartitionSearchOptions.highlightPreTag());
    }
    if (postPartitionSearchOptions.highlightSize() != null) {
      contentJson.addProperty("highlight_size", postPartitionSearchOptions.highlightSize());
    }
    if (postPartitionSearchOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postPartitionSearchOptions.includeDocs());
    }
    if (postPartitionSearchOptions.includeFields() != null) {
      contentJson.add("include_fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionSearchOptions.includeFields()));
    }
    if (postPartitionSearchOptions.limit() != null) {
      contentJson.addProperty("limit", postPartitionSearchOptions.limit());
    }
    if (postPartitionSearchOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionSearchOptions.sort()));
    }
    if (postPartitionSearchOptions.stale() != null) {
      contentJson.addProperty("stale", postPartitionSearchOptions.stale());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a database partition MapReduce view function.
   *
   * Runs the specified view function from the specified design document. Unlike `GET /{db}/_design/{ddoc}/_view/{view}`
   * for accessing views, the POST method supports the specification of explicit keys to be retrieved from the view
   * results. The remainder of the POST view functionality is identical to the `GET /{db}/_design/{ddoc}/_view/{view}`
   * API.
   *
   * Before using read the
   * [FAQs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-database-partitioning#partition-querying) to understand
   * the limitations and appropriate use cases.
   *
   * @param postPartitionViewOptions the {@link PostPartitionViewOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ViewResult}
   */
  public ServiceCall<ViewResult> postPartitionView(PostPartitionViewOptions postPartitionViewOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPartitionViewOptions,
      "postPartitionViewOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postPartitionViewOptions.db());
    pathParamsMap.put("partition_key", postPartitionViewOptions.partitionKey());
    pathParamsMap.put("ddoc", postPartitionViewOptions.ddoc());
    pathParamsMap.put("view", postPartitionViewOptions.view());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}/_design/{ddoc}/_view/{view}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postPartitionView");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (postPartitionViewOptions.attEncodingInfo() != null) {
      contentJson.addProperty("att_encoding_info", postPartitionViewOptions.attEncodingInfo());
    }
    if (postPartitionViewOptions.attachments() != null) {
      contentJson.addProperty("attachments", postPartitionViewOptions.attachments());
    }
    if (postPartitionViewOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postPartitionViewOptions.conflicts());
    }
    if (postPartitionViewOptions.descending() != null) {
      contentJson.addProperty("descending", postPartitionViewOptions.descending());
    }
    if (postPartitionViewOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postPartitionViewOptions.includeDocs());
    }
    if (postPartitionViewOptions.inclusiveEnd() != null) {
      contentJson.addProperty("inclusive_end", postPartitionViewOptions.inclusiveEnd());
    }
    if (postPartitionViewOptions.limit() != null) {
      contentJson.addProperty("limit", postPartitionViewOptions.limit());
    }
    if (postPartitionViewOptions.skip() != null) {
      contentJson.addProperty("skip", postPartitionViewOptions.skip());
    }
    if (postPartitionViewOptions.updateSeq() != null) {
      contentJson.addProperty("update_seq", postPartitionViewOptions.updateSeq());
    }
    if (postPartitionViewOptions.endKey() != null) {
      contentJson.add("end_key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionViewOptions.endKey()));
    }
    if (postPartitionViewOptions.endKeyDocId() != null) {
      contentJson.addProperty("end_key_doc_id", postPartitionViewOptions.endKeyDocId());
    }
    if (postPartitionViewOptions.group() != null) {
      contentJson.addProperty("group", postPartitionViewOptions.group());
    }
    if (postPartitionViewOptions.groupLevel() != null) {
      contentJson.addProperty("group_level", postPartitionViewOptions.groupLevel());
    }
    if (postPartitionViewOptions.key() != null) {
      contentJson.add("key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionViewOptions.key()));
    }
    if (postPartitionViewOptions.keys() != null) {
      contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionViewOptions.keys()));
    }
    if (postPartitionViewOptions.reduce() != null) {
      contentJson.addProperty("reduce", postPartitionViewOptions.reduce());
    }
    if (postPartitionViewOptions.startKey() != null) {
      contentJson.add("start_key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionViewOptions.startKey()));
    }
    if (postPartitionViewOptions.startKeyDocId() != null) {
      contentJson.addProperty("start_key_doc_id", postPartitionViewOptions.startKeyDocId());
    }
    if (postPartitionViewOptions.update() != null) {
      contentJson.addProperty("update", postPartitionViewOptions.update());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ViewResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ViewResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a database partition MapReduce view function as stream.
   *
   * Runs the specified view function from the specified design document. Unlike `GET /{db}/_design/{ddoc}/_view/{view}`
   * for accessing views, the POST method supports the specification of explicit keys to be retrieved from the view
   * results. The remainder of the POST view functionality is identical to the `GET /{db}/_design/{ddoc}/_view/{view}`
   * API.
   *
   * Before using read the
   * [FAQs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-database-partitioning#partition-querying) to understand
   * the limitations and appropriate use cases.
   *
   * @param postPartitionViewOptions the {@link PostPartitionViewOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postPartitionViewAsStream(PostPartitionViewOptions postPartitionViewOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPartitionViewOptions,
      "postPartitionViewOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postPartitionViewOptions.db());
    pathParamsMap.put("partition_key", postPartitionViewOptions.partitionKey());
    pathParamsMap.put("ddoc", postPartitionViewOptions.ddoc());
    pathParamsMap.put("view", postPartitionViewOptions.view());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}/_design/{ddoc}/_view/{view}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postPartitionViewAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (postPartitionViewOptions.attEncodingInfo() != null) {
      contentJson.addProperty("att_encoding_info", postPartitionViewOptions.attEncodingInfo());
    }
    if (postPartitionViewOptions.attachments() != null) {
      contentJson.addProperty("attachments", postPartitionViewOptions.attachments());
    }
    if (postPartitionViewOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postPartitionViewOptions.conflicts());
    }
    if (postPartitionViewOptions.descending() != null) {
      contentJson.addProperty("descending", postPartitionViewOptions.descending());
    }
    if (postPartitionViewOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postPartitionViewOptions.includeDocs());
    }
    if (postPartitionViewOptions.inclusiveEnd() != null) {
      contentJson.addProperty("inclusive_end", postPartitionViewOptions.inclusiveEnd());
    }
    if (postPartitionViewOptions.limit() != null) {
      contentJson.addProperty("limit", postPartitionViewOptions.limit());
    }
    if (postPartitionViewOptions.skip() != null) {
      contentJson.addProperty("skip", postPartitionViewOptions.skip());
    }
    if (postPartitionViewOptions.updateSeq() != null) {
      contentJson.addProperty("update_seq", postPartitionViewOptions.updateSeq());
    }
    if (postPartitionViewOptions.endKey() != null) {
      contentJson.add("end_key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionViewOptions.endKey()));
    }
    if (postPartitionViewOptions.endKeyDocId() != null) {
      contentJson.addProperty("end_key_doc_id", postPartitionViewOptions.endKeyDocId());
    }
    if (postPartitionViewOptions.group() != null) {
      contentJson.addProperty("group", postPartitionViewOptions.group());
    }
    if (postPartitionViewOptions.groupLevel() != null) {
      contentJson.addProperty("group_level", postPartitionViewOptions.groupLevel());
    }
    if (postPartitionViewOptions.key() != null) {
      contentJson.add("key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionViewOptions.key()));
    }
    if (postPartitionViewOptions.keys() != null) {
      contentJson.add("keys", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionViewOptions.keys()));
    }
    if (postPartitionViewOptions.reduce() != null) {
      contentJson.addProperty("reduce", postPartitionViewOptions.reduce());
    }
    if (postPartitionViewOptions.startKey() != null) {
      contentJson.add("start_key", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionViewOptions.startKey()));
    }
    if (postPartitionViewOptions.startKeyDocId() != null) {
      contentJson.addProperty("start_key_doc_id", postPartitionViewOptions.startKeyDocId());
    }
    if (postPartitionViewOptions.update() != null) {
      contentJson.addProperty("update", postPartitionViewOptions.update());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information about which partition index is used for a query.
   *
   * Shows which index is being used by the query. Parameters are the same as the
   * [`/{db}/_partition/{partition_key}/_find` endpoint](#postpartitionfind-queries).
   *
   * @param postPartitionExplainOptions the {@link PostPartitionExplainOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ExplainResult}
   */
  public ServiceCall<ExplainResult> postPartitionExplain(PostPartitionExplainOptions postPartitionExplainOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPartitionExplainOptions,
      "postPartitionExplainOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postPartitionExplainOptions.db());
    pathParamsMap.put("partition_key", postPartitionExplainOptions.partitionKey());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}/_explain", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postPartitionExplain");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("selector", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionExplainOptions.selector()));
    if (postPartitionExplainOptions.allowFallback() != null) {
      contentJson.addProperty("allow_fallback", postPartitionExplainOptions.allowFallback());
    }
    if (postPartitionExplainOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postPartitionExplainOptions.bookmark());
    }
    if (postPartitionExplainOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postPartitionExplainOptions.conflicts());
    }
    if (postPartitionExplainOptions.executionStats() != null) {
      contentJson.addProperty("execution_stats", postPartitionExplainOptions.executionStats());
    }
    if (postPartitionExplainOptions.fields() != null) {
      contentJson.add("fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionExplainOptions.fields()));
    }
    if (postPartitionExplainOptions.limit() != null) {
      contentJson.addProperty("limit", postPartitionExplainOptions.limit());
    }
    if (postPartitionExplainOptions.skip() != null) {
      contentJson.addProperty("skip", postPartitionExplainOptions.skip());
    }
    if (postPartitionExplainOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionExplainOptions.sort()));
    }
    if (postPartitionExplainOptions.stable() != null) {
      contentJson.addProperty("stable", postPartitionExplainOptions.stable());
    }
    if (postPartitionExplainOptions.update() != null) {
      contentJson.addProperty("update", postPartitionExplainOptions.update());
    }
    if (postPartitionExplainOptions.useIndex() != null) {
      contentJson.add("use_index", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionExplainOptions.useIndex()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ExplainResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ExplainResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a database partition index by using selector syntax.
   *
   * Query documents by using a declarative JSON querying syntax. It's best practice to create an appropriate index for
   * all fields in selector by using the `_index` endpoint.
   *
   * Queries without an appropriate backing index by default fallback to using the built-in `_all_docs` index. This
   * isn't recommended because it has a significant performance impact causing a full scan of the partition with each
   * request. In this case the response body includes a warning field recommending the creation of an index.
   *
   * To avoid the fallback behavior set the `allow_fallback` option to `false` and the server responds with a `400`
   * status code if no suitable index exists. If you want to use only a specific index for your query set
   * `allow_fallback` to `false` and set the `use_index` option.
   *
   * Before using read the
   * [FAQs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-database-partitioning#partition-querying) to understand
   * the limitations and appropriate use cases.
   *
   * @param postPartitionFindOptions the {@link PostPartitionFindOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link FindResult}
   */
  public ServiceCall<FindResult> postPartitionFind(PostPartitionFindOptions postPartitionFindOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPartitionFindOptions,
      "postPartitionFindOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postPartitionFindOptions.db());
    pathParamsMap.put("partition_key", postPartitionFindOptions.partitionKey());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}/_find", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postPartitionFind");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("selector", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionFindOptions.selector()));
    if (postPartitionFindOptions.allowFallback() != null) {
      contentJson.addProperty("allow_fallback", postPartitionFindOptions.allowFallback());
    }
    if (postPartitionFindOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postPartitionFindOptions.bookmark());
    }
    if (postPartitionFindOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postPartitionFindOptions.conflicts());
    }
    if (postPartitionFindOptions.executionStats() != null) {
      contentJson.addProperty("execution_stats", postPartitionFindOptions.executionStats());
    }
    if (postPartitionFindOptions.fields() != null) {
      contentJson.add("fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionFindOptions.fields()));
    }
    if (postPartitionFindOptions.limit() != null) {
      contentJson.addProperty("limit", postPartitionFindOptions.limit());
    }
    if (postPartitionFindOptions.skip() != null) {
      contentJson.addProperty("skip", postPartitionFindOptions.skip());
    }
    if (postPartitionFindOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionFindOptions.sort()));
    }
    if (postPartitionFindOptions.stable() != null) {
      contentJson.addProperty("stable", postPartitionFindOptions.stable());
    }
    if (postPartitionFindOptions.update() != null) {
      contentJson.addProperty("update", postPartitionFindOptions.update());
    }
    if (postPartitionFindOptions.useIndex() != null) {
      contentJson.add("use_index", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionFindOptions.useIndex()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<FindResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<FindResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a database partition index by using selector syntax as stream.
   *
   * Query documents by using a declarative JSON querying syntax. It's best practice to create an appropriate index for
   * all fields in selector by using the `_index` endpoint.
   *
   * Queries without an appropriate backing index by default fallback to using the built-in `_all_docs` index. This
   * isn't recommended because it has a significant performance impact causing a full scan of the partition with each
   * request. In this case the response body includes a warning field recommending the creation of an index.
   *
   * To avoid the fallback behavior set the `allow_fallback` option to `false` and the server responds with a `400`
   * status code if no suitable index exists. If you want to use only a specific index for your query set
   * `allow_fallback` to `false` and set the `use_index` option.
   *
   * Before using read the
   * [FAQs](https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-database-partitioning#partition-querying) to understand
   * the limitations and appropriate use cases.
   *
   * @param postPartitionFindOptions the {@link PostPartitionFindOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postPartitionFindAsStream(PostPartitionFindOptions postPartitionFindOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postPartitionFindOptions,
      "postPartitionFindOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postPartitionFindOptions.db());
    pathParamsMap.put("partition_key", postPartitionFindOptions.partitionKey());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_partition/{partition_key}/_find", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postPartitionFindAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("selector", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionFindOptions.selector()));
    if (postPartitionFindOptions.allowFallback() != null) {
      contentJson.addProperty("allow_fallback", postPartitionFindOptions.allowFallback());
    }
    if (postPartitionFindOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postPartitionFindOptions.bookmark());
    }
    if (postPartitionFindOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postPartitionFindOptions.conflicts());
    }
    if (postPartitionFindOptions.executionStats() != null) {
      contentJson.addProperty("execution_stats", postPartitionFindOptions.executionStats());
    }
    if (postPartitionFindOptions.fields() != null) {
      contentJson.add("fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionFindOptions.fields()));
    }
    if (postPartitionFindOptions.limit() != null) {
      contentJson.addProperty("limit", postPartitionFindOptions.limit());
    }
    if (postPartitionFindOptions.skip() != null) {
      contentJson.addProperty("skip", postPartitionFindOptions.skip());
    }
    if (postPartitionFindOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionFindOptions.sort()));
    }
    if (postPartitionFindOptions.stable() != null) {
      contentJson.addProperty("stable", postPartitionFindOptions.stable());
    }
    if (postPartitionFindOptions.update() != null) {
      contentJson.addProperty("update", postPartitionFindOptions.update());
    }
    if (postPartitionFindOptions.useIndex() != null) {
      contentJson.add("use_index", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postPartitionFindOptions.useIndex()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information about which index is used for a query.
   *
   * Shows which index is being used by the query. Parameters are the same as the [`_find` endpoint](#postfind).
   *
   * @param postExplainOptions the {@link PostExplainOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ExplainResult}
   */
  public ServiceCall<ExplainResult> postExplain(PostExplainOptions postExplainOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postExplainOptions,
      "postExplainOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postExplainOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_explain", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postExplain");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("selector", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postExplainOptions.selector()));
    if (postExplainOptions.allowFallback() != null) {
      contentJson.addProperty("allow_fallback", postExplainOptions.allowFallback());
    }
    if (postExplainOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postExplainOptions.bookmark());
    }
    if (postExplainOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postExplainOptions.conflicts());
    }
    if (postExplainOptions.executionStats() != null) {
      contentJson.addProperty("execution_stats", postExplainOptions.executionStats());
    }
    if (postExplainOptions.fields() != null) {
      contentJson.add("fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postExplainOptions.fields()));
    }
    if (postExplainOptions.limit() != null) {
      contentJson.addProperty("limit", postExplainOptions.limit());
    }
    if (postExplainOptions.skip() != null) {
      contentJson.addProperty("skip", postExplainOptions.skip());
    }
    if (postExplainOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postExplainOptions.sort()));
    }
    if (postExplainOptions.stable() != null) {
      contentJson.addProperty("stable", postExplainOptions.stable());
    }
    if (postExplainOptions.update() != null) {
      contentJson.addProperty("update", postExplainOptions.update());
    }
    if (postExplainOptions.useIndex() != null) {
      contentJson.add("use_index", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postExplainOptions.useIndex()));
    }
    if (postExplainOptions.r() != null) {
      contentJson.addProperty("r", postExplainOptions.r());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ExplainResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ExplainResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query an index by using selector syntax.
   *
   * Query documents by using a declarative JSON querying syntax. It's best practice to create an appropriate index for
   * all fields in selector by using the `_index` endpoint.
   *
   * Queries without an appropriate backing index by default fallback to using the built-in `_all_docs` index. This
   * isn't recommended because it has a significant performance impact causing a full scan of the database with each
   * request. In this case the response body includes a warning field recommending the creation of an index.
   *
   * To avoid the fallback behavior set the `allow_fallback` option to `false` and the server responds with a `400`
   * status code if no suitable index exists. If you want to use only a specific index for your query set
   * `allow_fallback` to `false` and set the `use_index` option.
   *
   * @param postFindOptions the {@link PostFindOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link FindResult}
   */
  public ServiceCall<FindResult> postFind(PostFindOptions postFindOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postFindOptions,
      "postFindOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postFindOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_find", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postFind");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("selector", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postFindOptions.selector()));
    if (postFindOptions.allowFallback() != null) {
      contentJson.addProperty("allow_fallback", postFindOptions.allowFallback());
    }
    if (postFindOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postFindOptions.bookmark());
    }
    if (postFindOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postFindOptions.conflicts());
    }
    if (postFindOptions.executionStats() != null) {
      contentJson.addProperty("execution_stats", postFindOptions.executionStats());
    }
    if (postFindOptions.fields() != null) {
      contentJson.add("fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postFindOptions.fields()));
    }
    if (postFindOptions.limit() != null) {
      contentJson.addProperty("limit", postFindOptions.limit());
    }
    if (postFindOptions.skip() != null) {
      contentJson.addProperty("skip", postFindOptions.skip());
    }
    if (postFindOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postFindOptions.sort()));
    }
    if (postFindOptions.stable() != null) {
      contentJson.addProperty("stable", postFindOptions.stable());
    }
    if (postFindOptions.update() != null) {
      contentJson.addProperty("update", postFindOptions.update());
    }
    if (postFindOptions.useIndex() != null) {
      contentJson.add("use_index", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postFindOptions.useIndex()));
    }
    if (postFindOptions.r() != null) {
      contentJson.addProperty("r", postFindOptions.r());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<FindResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<FindResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query an index by using selector syntax as stream.
   *
   * Query documents by using a declarative JSON querying syntax. It's best practice to create an appropriate index for
   * all fields in selector by using the `_index` endpoint.
   *
   * Queries without an appropriate backing index by default fallback to using the built-in `_all_docs` index. This
   * isn't recommended because it has a significant performance impact causing a full scan of the database with each
   * request. In this case the response body includes a warning field recommending the creation of an index.
   *
   * To avoid the fallback behavior set the `allow_fallback` option to `false` and the server responds with a `400`
   * status code if no suitable index exists. If you want to use only a specific index for your query set
   * `allow_fallback` to `false` and set the `use_index` option.
   *
   * @param postFindOptions the {@link PostFindOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postFindAsStream(PostFindOptions postFindOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postFindOptions,
      "postFindOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postFindOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_find", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postFindAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("selector", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postFindOptions.selector()));
    if (postFindOptions.allowFallback() != null) {
      contentJson.addProperty("allow_fallback", postFindOptions.allowFallback());
    }
    if (postFindOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postFindOptions.bookmark());
    }
    if (postFindOptions.conflicts() != null) {
      contentJson.addProperty("conflicts", postFindOptions.conflicts());
    }
    if (postFindOptions.executionStats() != null) {
      contentJson.addProperty("execution_stats", postFindOptions.executionStats());
    }
    if (postFindOptions.fields() != null) {
      contentJson.add("fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postFindOptions.fields()));
    }
    if (postFindOptions.limit() != null) {
      contentJson.addProperty("limit", postFindOptions.limit());
    }
    if (postFindOptions.skip() != null) {
      contentJson.addProperty("skip", postFindOptions.skip());
    }
    if (postFindOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postFindOptions.sort()));
    }
    if (postFindOptions.stable() != null) {
      contentJson.addProperty("stable", postFindOptions.stable());
    }
    if (postFindOptions.update() != null) {
      contentJson.addProperty("update", postFindOptions.update());
    }
    if (postFindOptions.useIndex() != null) {
      contentJson.add("use_index", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postFindOptions.useIndex()));
    }
    if (postFindOptions.r() != null) {
      contentJson.addProperty("r", postFindOptions.r());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information about all indexes.
   *
   * When you make a GET request to `/db/_index`, you get a list of all the indexes using `"language":"query"` in the
   * database and the primary index. In addition to the information available through this API, the indexes are stored
   * in the `indexes` property of their respective design documents.
   *
   * @param getIndexesInformationOptions the {@link GetIndexesInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link IndexesInformation}
   */
  public ServiceCall<IndexesInformation> getIndexesInformation(GetIndexesInformationOptions getIndexesInformationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getIndexesInformationOptions,
      "getIndexesInformationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getIndexesInformationOptions.db());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_index", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getIndexesInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<IndexesInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<IndexesInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a new index on a database.
   *
   * Create a new index on a database.
   *
   * @param postIndexOptions the {@link PostIndexOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link IndexResult}
   */
  public ServiceCall<IndexResult> postIndex(PostIndexOptions postIndexOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postIndexOptions,
      "postIndexOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postIndexOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_index", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postIndex");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("index", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postIndexOptions.index()));
    if (postIndexOptions.ddoc() != null) {
      contentJson.addProperty("ddoc", postIndexOptions.ddoc());
    }
    if (postIndexOptions.name() != null) {
      contentJson.addProperty("name", postIndexOptions.name());
    }
    if (postIndexOptions.partitioned() != null) {
      contentJson.addProperty("partitioned", postIndexOptions.partitioned());
    }
    if (postIndexOptions.type() != null) {
      contentJson.addProperty("type", postIndexOptions.type());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<IndexResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<IndexResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an index.
   *
   * Delete the index functions from the design document and index files on the server.
   *
   * @param deleteIndexOptions the {@link DeleteIndexOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Ok}
   */
  public ServiceCall<Ok> deleteIndex(DeleteIndexOptions deleteIndexOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteIndexOptions,
      "deleteIndexOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", deleteIndexOptions.db());
    pathParamsMap.put("ddoc", deleteIndexOptions.ddoc());
    pathParamsMap.put("type", deleteIndexOptions.type());
    pathParamsMap.put("index", deleteIndexOptions.index());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_index/_design/{ddoc}/{type}/{index}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "deleteIndex");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Ok> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Ok>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query tokenization of sample text.
   *
   * Returns the results of analyzer tokenization of the provided sample text. This endpoint can be used for testing
   * analyzer tokenization.
   *
   * @param postSearchAnalyzeOptions the {@link PostSearchAnalyzeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SearchAnalyzeResult}
   */
  public ServiceCall<SearchAnalyzeResult> postSearchAnalyze(PostSearchAnalyzeOptions postSearchAnalyzeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postSearchAnalyzeOptions,
      "postSearchAnalyzeOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_search_analyze"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postSearchAnalyze");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("analyzer", postSearchAnalyzeOptions.analyzer());
    contentJson.addProperty("text", postSearchAnalyzeOptions.text());
    builder.bodyJson(contentJson);
    ResponseConverter<SearchAnalyzeResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SearchAnalyzeResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a search index.
   *
   * Search indexes, which are defined in design documents, allow databases to be queried by using Lucene Query Parser
   * Syntax. An index function defines a search index, similar to a map function in MapReduce views. The index function
   * decides what data to index and what data to store in the index. The advantage of using the HTTP `POST` method is
   * that the query is submitted as a JSON object in the request body. This avoids the limitations of passing query
   * options as URL query parameters of a `GET` request.
   *
   * @param postSearchOptions the {@link PostSearchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SearchResult}
   */
  public ServiceCall<SearchResult> postSearch(PostSearchOptions postSearchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postSearchOptions,
      "postSearchOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postSearchOptions.db());
    pathParamsMap.put("ddoc", postSearchOptions.ddoc());
    pathParamsMap.put("index", postSearchOptions.index());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}/_search/{index}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postSearch");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("query", postSearchOptions.query());
    if (postSearchOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postSearchOptions.bookmark());
    }
    if (postSearchOptions.highlightFields() != null) {
      contentJson.add("highlight_fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.highlightFields()));
    }
    if (postSearchOptions.highlightNumber() != null) {
      contentJson.addProperty("highlight_number", postSearchOptions.highlightNumber());
    }
    if (postSearchOptions.highlightPostTag() != null) {
      contentJson.addProperty("highlight_post_tag", postSearchOptions.highlightPostTag());
    }
    if (postSearchOptions.highlightPreTag() != null) {
      contentJson.addProperty("highlight_pre_tag", postSearchOptions.highlightPreTag());
    }
    if (postSearchOptions.highlightSize() != null) {
      contentJson.addProperty("highlight_size", postSearchOptions.highlightSize());
    }
    if (postSearchOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postSearchOptions.includeDocs());
    }
    if (postSearchOptions.includeFields() != null) {
      contentJson.add("include_fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.includeFields()));
    }
    if (postSearchOptions.limit() != null) {
      contentJson.addProperty("limit", postSearchOptions.limit());
    }
    if (postSearchOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.sort()));
    }
    if (postSearchOptions.stale() != null) {
      contentJson.addProperty("stale", postSearchOptions.stale());
    }
    if (postSearchOptions.counts() != null) {
      contentJson.add("counts", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.counts()));
    }
    if (postSearchOptions.drilldown() != null) {
      contentJson.add("drilldown", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.drilldown()));
    }
    if (postSearchOptions.groupField() != null) {
      contentJson.addProperty("group_field", postSearchOptions.groupField());
    }
    if (postSearchOptions.groupLimit() != null) {
      contentJson.addProperty("group_limit", postSearchOptions.groupLimit());
    }
    if (postSearchOptions.groupSort() != null) {
      contentJson.add("group_sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.groupSort()));
    }
    if (postSearchOptions.ranges() != null) {
      contentJson.add("ranges", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.ranges()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<SearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a search index as stream.
   *
   * Search indexes, which are defined in design documents, allow databases to be queried by using Lucene Query Parser
   * Syntax. An index function defines a search index, similar to a map function in MapReduce views. The index function
   * decides what data to index and what data to store in the index. The advantage of using the HTTP `POST` method is
   * that the query is submitted as a JSON object in the request body. This avoids the limitations of passing query
   * options as URL query parameters of a `GET` request.
   *
   * @param postSearchOptions the {@link PostSearchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> postSearchAsStream(PostSearchOptions postSearchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postSearchOptions,
      "postSearchOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postSearchOptions.db());
    pathParamsMap.put("ddoc", postSearchOptions.ddoc());
    pathParamsMap.put("index", postSearchOptions.index());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}/_search/{index}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postSearchAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("query", postSearchOptions.query());
    if (postSearchOptions.bookmark() != null) {
      contentJson.addProperty("bookmark", postSearchOptions.bookmark());
    }
    if (postSearchOptions.highlightFields() != null) {
      contentJson.add("highlight_fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.highlightFields()));
    }
    if (postSearchOptions.highlightNumber() != null) {
      contentJson.addProperty("highlight_number", postSearchOptions.highlightNumber());
    }
    if (postSearchOptions.highlightPostTag() != null) {
      contentJson.addProperty("highlight_post_tag", postSearchOptions.highlightPostTag());
    }
    if (postSearchOptions.highlightPreTag() != null) {
      contentJson.addProperty("highlight_pre_tag", postSearchOptions.highlightPreTag());
    }
    if (postSearchOptions.highlightSize() != null) {
      contentJson.addProperty("highlight_size", postSearchOptions.highlightSize());
    }
    if (postSearchOptions.includeDocs() != null) {
      contentJson.addProperty("include_docs", postSearchOptions.includeDocs());
    }
    if (postSearchOptions.includeFields() != null) {
      contentJson.add("include_fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.includeFields()));
    }
    if (postSearchOptions.limit() != null) {
      contentJson.addProperty("limit", postSearchOptions.limit());
    }
    if (postSearchOptions.sort() != null) {
      contentJson.add("sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.sort()));
    }
    if (postSearchOptions.stale() != null) {
      contentJson.addProperty("stale", postSearchOptions.stale());
    }
    if (postSearchOptions.counts() != null) {
      contentJson.add("counts", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.counts()));
    }
    if (postSearchOptions.drilldown() != null) {
      contentJson.add("drilldown", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.drilldown()));
    }
    if (postSearchOptions.groupField() != null) {
      contentJson.addProperty("group_field", postSearchOptions.groupField());
    }
    if (postSearchOptions.groupLimit() != null) {
      contentJson.addProperty("group_limit", postSearchOptions.groupLimit());
    }
    if (postSearchOptions.groupSort() != null) {
      contentJson.add("group_sort", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.groupSort()));
    }
    if (postSearchOptions.ranges() != null) {
      contentJson.add("ranges", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postSearchOptions.ranges()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information about a search index.
   *
   * Retrieve search index metadata information, such as the size of the index on disk.
   *
   * @param getSearchInfoOptions the {@link GetSearchInfoOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SearchInfoResult}
   */
  public ServiceCall<SearchInfoResult> getSearchInfo(GetSearchInfoOptions getSearchInfoOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSearchInfoOptions,
      "getSearchInfoOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getSearchInfoOptions.db());
    pathParamsMap.put("ddoc", getSearchInfoOptions.ddoc());
    pathParamsMap.put("index", getSearchInfoOptions.index());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_design/{ddoc}/_search_info/{index}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getSearchInfo");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SearchInfoResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SearchInfoResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the HTTP headers for a persistent replication.
   *
   * Retrieves the HTTP headers containing minimal amount of information about the specified replication document from
   * the `_replicator` database.  The method supports the same query arguments as the `GET /_replicator/{doc_id}`
   * method, but only headers like content length and the revision (ETag header) are returned.
   *
   * @param headReplicationDocumentOptions the {@link HeadReplicationDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headReplicationDocument(HeadReplicationDocumentOptions headReplicationDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(headReplicationDocumentOptions,
      "headReplicationDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("doc_id", headReplicationDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_replicator/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "headReplicationDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (headReplicationDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", headReplicationDocumentOptions.ifNoneMatch());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve HTTP headers for a replication scheduler document.
   *
   * Retrieves the HTTP headers containing minimal amount of information about the specified replication scheduler
   * document.  Since the response body is empty, using the HEAD method is a lightweight way to check if the replication
   * scheduler document exists or not.
   *
   * @param headSchedulerDocumentOptions the {@link HeadSchedulerDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headSchedulerDocument(HeadSchedulerDocumentOptions headSchedulerDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(headSchedulerDocumentOptions,
      "headSchedulerDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("doc_id", headSchedulerDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_scheduler/docs/_replicator/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "headSchedulerDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the HTTP headers for a replication scheduler job.
   *
   * Returns the HTTP headers that contain a minimal amount of information about the specified replication task. Only
   * the header information is returned.
   *
   * @param headSchedulerJobOptions the {@link HeadSchedulerJobOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headSchedulerJob(HeadSchedulerJobOptions headSchedulerJobOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(headSchedulerJobOptions,
      "headSchedulerJobOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("job_id", headSchedulerJobOptions.jobId());
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_scheduler/jobs/{job_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "headSchedulerJob");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a persistent replication with a generated ID.
   *
   * Creates or modifies a document in the `_replicator` database to start a new replication or to edit an existing
   * replication.
   *
   * @param postReplicatorOptions the {@link PostReplicatorOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> postReplicator(PostReplicatorOptions postReplicatorOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postReplicatorOptions,
      "postReplicatorOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_replicator"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postReplicator");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (postReplicatorOptions.batch() != null) {
      builder.query("batch", String.valueOf(postReplicatorOptions.batch()));
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(postReplicatorOptions.replicationDocument()), "application/json");
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Cancel a persistent replication.
   *
   * Cancels a replication by deleting the document that describes it from the `_replicator` database.
   *
   * @param deleteReplicationDocumentOptions the {@link DeleteReplicationDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> deleteReplicationDocument(DeleteReplicationDocumentOptions deleteReplicationDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteReplicationDocumentOptions,
      "deleteReplicationDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("doc_id", deleteReplicationDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_replicator/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "deleteReplicationDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteReplicationDocumentOptions.ifMatch() != null) {
      builder.header("If-Match", deleteReplicationDocumentOptions.ifMatch());
    }
    if (deleteReplicationDocumentOptions.batch() != null) {
      builder.query("batch", String.valueOf(deleteReplicationDocumentOptions.batch()));
    }
    if (deleteReplicationDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(deleteReplicationDocumentOptions.rev()));
    }
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the configuration for a persistent replication.
   *
   * Retrieves a replication document from the `_replicator` database to view the configuration of the replication. The
   * status of the replication is no longer recorded in the document but can be checked via the replication scheduler.
   *
   * @param getReplicationDocumentOptions the {@link GetReplicationDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReplicationDocument}
   */
  public ServiceCall<ReplicationDocument> getReplicationDocument(GetReplicationDocumentOptions getReplicationDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReplicationDocumentOptions,
      "getReplicationDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("doc_id", getReplicationDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_replicator/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getReplicationDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReplicationDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", getReplicationDocumentOptions.ifNoneMatch());
    }
    if (getReplicationDocumentOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(getReplicationDocumentOptions.attachments()));
    }
    if (getReplicationDocumentOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(getReplicationDocumentOptions.attEncodingInfo()));
    }
    if (getReplicationDocumentOptions.conflicts() != null) {
      builder.query("conflicts", String.valueOf(getReplicationDocumentOptions.conflicts()));
    }
    if (getReplicationDocumentOptions.deletedConflicts() != null) {
      builder.query("deleted_conflicts", String.valueOf(getReplicationDocumentOptions.deletedConflicts()));
    }
    if (getReplicationDocumentOptions.latest() != null) {
      builder.query("latest", String.valueOf(getReplicationDocumentOptions.latest()));
    }
    if (getReplicationDocumentOptions.localSeq() != null) {
      builder.query("local_seq", String.valueOf(getReplicationDocumentOptions.localSeq()));
    }
    if (getReplicationDocumentOptions.meta() != null) {
      builder.query("meta", String.valueOf(getReplicationDocumentOptions.meta()));
    }
    if (getReplicationDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(getReplicationDocumentOptions.rev()));
    }
    if (getReplicationDocumentOptions.revs() != null) {
      builder.query("revs", String.valueOf(getReplicationDocumentOptions.revs()));
    }
    if (getReplicationDocumentOptions.revsInfo() != null) {
      builder.query("revs_info", String.valueOf(getReplicationDocumentOptions.revsInfo()));
    }
    ResponseConverter<ReplicationDocument> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReplicationDocument>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create or modify a persistent replication.
   *
   * Creates or modifies a document in the `_replicator` database to start a new replication or to edit an existing
   * replication.
   *
   * @param putReplicationDocumentOptions the {@link PutReplicationDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> putReplicationDocument(PutReplicationDocumentOptions putReplicationDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putReplicationDocumentOptions,
      "putReplicationDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("doc_id", putReplicationDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_replicator/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putReplicationDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (putReplicationDocumentOptions.ifMatch() != null) {
      builder.header("If-Match", putReplicationDocumentOptions.ifMatch());
    }
    if (putReplicationDocumentOptions.batch() != null) {
      builder.query("batch", String.valueOf(putReplicationDocumentOptions.batch()));
    }
    if (putReplicationDocumentOptions.newEdits() != null) {
      builder.query("new_edits", String.valueOf(putReplicationDocumentOptions.newEdits()));
    }
    if (putReplicationDocumentOptions.rev() != null) {
      builder.query("rev", String.valueOf(putReplicationDocumentOptions.rev()));
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(putReplicationDocumentOptions.replicationDocument()), "application/json");
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve replication scheduler documents.
   *
   * Lists replication documents, including information about all documents, even the ones in a completed or failed
   * state. For each document, the endpoint returns the document ID, database, replication ID, source and target, and
   * other information.
   *
   * @param getSchedulerDocsOptions the {@link GetSchedulerDocsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SchedulerDocsResult}
   */
  public ServiceCall<SchedulerDocsResult> getSchedulerDocs(GetSchedulerDocsOptions getSchedulerDocsOptions) {
    if (getSchedulerDocsOptions == null) {
      getSchedulerDocsOptions = new GetSchedulerDocsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_scheduler/docs"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getSchedulerDocs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getSchedulerDocsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getSchedulerDocsOptions.limit()));
    }
    if (getSchedulerDocsOptions.skip() != null) {
      builder.query("skip", String.valueOf(getSchedulerDocsOptions.skip()));
    }
    if (getSchedulerDocsOptions.states() != null) {
      builder.query("states", RequestUtils.join(getSchedulerDocsOptions.states(), ","));
    }
    ResponseConverter<SchedulerDocsResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SchedulerDocsResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve replication scheduler documents.
   *
   * Lists replication documents, including information about all documents, even the ones in a completed or failed
   * state. For each document, the endpoint returns the document ID, database, replication ID, source and target, and
   * other information.
   *
   * @return a {@link ServiceCall} with a result of type {@link SchedulerDocsResult}
   */
  public ServiceCall<SchedulerDocsResult> getSchedulerDocs() {
    return getSchedulerDocs(null);
  }

  /**
   * Retrieve a replication scheduler document.
   *
   * Retrieves information about a replication document from the replicator database. The endpoint returns the document
   * ID, database, replication ID, source and target, and other information.
   *
   * @param getSchedulerDocumentOptions the {@link GetSchedulerDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SchedulerDocument}
   */
  public ServiceCall<SchedulerDocument> getSchedulerDocument(GetSchedulerDocumentOptions getSchedulerDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSchedulerDocumentOptions,
      "getSchedulerDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("doc_id", getSchedulerDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_scheduler/docs/_replicator/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getSchedulerDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SchedulerDocument> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SchedulerDocument>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve replication scheduler jobs.
   *
   * Retrieves information about replications that were created via `/_replicate` endpoint, as well as those created
   * from replication documents. It doesn't include replications that completed or failed to start because replication
   * documents were malformed. Each job description includes source and target information, replication ID, history of
   * recent events, and other information.
   *
   * @param getSchedulerJobsOptions the {@link GetSchedulerJobsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SchedulerJobsResult}
   */
  public ServiceCall<SchedulerJobsResult> getSchedulerJobs(GetSchedulerJobsOptions getSchedulerJobsOptions) {
    if (getSchedulerJobsOptions == null) {
      getSchedulerJobsOptions = new GetSchedulerJobsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_scheduler/jobs"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getSchedulerJobs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getSchedulerJobsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getSchedulerJobsOptions.limit()));
    }
    if (getSchedulerJobsOptions.skip() != null) {
      builder.query("skip", String.valueOf(getSchedulerJobsOptions.skip()));
    }
    ResponseConverter<SchedulerJobsResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SchedulerJobsResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve replication scheduler jobs.
   *
   * Retrieves information about replications that were created via `/_replicate` endpoint, as well as those created
   * from replication documents. It doesn't include replications that completed or failed to start because replication
   * documents were malformed. Each job description includes source and target information, replication ID, history of
   * recent events, and other information.
   *
   * @return a {@link ServiceCall} with a result of type {@link SchedulerJobsResult}
   */
  public ServiceCall<SchedulerJobsResult> getSchedulerJobs() {
    return getSchedulerJobs(null);
  }

  /**
   * Retrieve a replication scheduler job.
   *
   * Retrieves the state of a single replication task based on its replication ID.
   *
   * @param getSchedulerJobOptions the {@link GetSchedulerJobOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SchedulerJob}
   */
  public ServiceCall<SchedulerJob> getSchedulerJob(GetSchedulerJobOptions getSchedulerJobOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSchedulerJobOptions,
      "getSchedulerJobOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("job_id", getSchedulerJobOptions.jobId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_scheduler/jobs/{job_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getSchedulerJob");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SchedulerJob> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SchedulerJob>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve current session cookie information.
   *
   * Retrieves information about the authenticated user's session.
   *
   * @param getSessionInformationOptions the {@link GetSessionInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SessionInformation}
   */
  public ServiceCall<SessionInformation> getSessionInformation(GetSessionInformationOptions getSessionInformationOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_session"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getSessionInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SessionInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SessionInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve current session cookie information.
   *
   * Retrieves information about the authenticated user's session.
   *
   * @return a {@link ServiceCall} with a result of type {@link SessionInformation}
   */
  public ServiceCall<SessionInformation> getSessionInformation() {
    return getSessionInformation(null);
  }

  /**
   * Retrieve database permissions information.
   *
   * See who has permission to read, write, and manage the database. The credentials you use to log in to the dashboard
   * automatically include `_admin` permissions to all databases you create. Everyone and everything else, including
   * users you share databases with and API keys you create, must be given a permission level explicitly.
   *
   * @param getSecurityOptions the {@link GetSecurityOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Security}
   */
  public ServiceCall<Security> getSecurity(GetSecurityOptions getSecurityOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSecurityOptions,
      "getSecurityOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getSecurityOptions.db());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_security", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getSecurity");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Security> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Security>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Modify database permissions.
   *
   * Modify who has permission to read, write, or manage a database. This endpoint can be used to modify both Cloudant
   * and CouchDB related permissions. Be careful: by removing a Cloudant API key, a member or an admin from the list of
   * users that have access permissions, you remove it from the list of users that have access to the database.
   *
   * ### Note about nobody role
   *
   * The `nobody` username applies to all unauthenticated connection attempts. For example, if an application tries to
   * read data from a database, but did not identify itself, the task can continue only if the `nobody` user has the
   * role `_reader`.
   *
   * @param putSecurityOptions the {@link PutSecurityOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Ok}
   */
  public ServiceCall<Ok> putSecurity(PutSecurityOptions putSecurityOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putSecurityOptions,
      "putSecurityOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", putSecurityOptions.db());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_security", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putSecurity");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (putSecurityOptions.admins() != null) {
      contentJson.add("admins", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putSecurityOptions.admins()));
    }
    if (putSecurityOptions.members() != null) {
      contentJson.add("members", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putSecurityOptions.members()));
    }
    if (putSecurityOptions.cloudant() != null) {
      contentJson.add("cloudant", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putSecurityOptions.cloudant()));
    }
    if (putSecurityOptions.couchdbAuthOnly() != null) {
      contentJson.addProperty("couchdb_auth_only", putSecurityOptions.couchdbAuthOnly());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Ok> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Ok>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Generates API keys for apps or persons to enable database access.
   *
   * Generates API keys to enable database access for a person or application, but without creating a new IBM Cloudant
   * account for that person or application. An API key is a randomly generated username and password. The key is given
   * the wanted access permissions for a database.
   *
   * @param postApiKeysOptions the {@link PostApiKeysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiKeysResult}
   */
  public ServiceCall<ApiKeysResult> postApiKeys(PostApiKeysOptions postApiKeysOptions) {
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_api/v2/api_keys"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postApiKeys");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ApiKeysResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiKeysResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Generates API keys for apps or persons to enable database access.
   *
   * Generates API keys to enable database access for a person or application, but without creating a new IBM Cloudant
   * account for that person or application. An API key is a randomly generated username and password. The key is given
   * the wanted access permissions for a database.
   *
   * @return a {@link ServiceCall} with a result of type {@link ApiKeysResult}
   */
  public ServiceCall<ApiKeysResult> postApiKeys() {
    return postApiKeys(null);
  }

  /**
   * Modify only Cloudant related database permissions.
   *
   * Modify only Cloudant related permissions to database. Be careful: by removing an API key from the list, you remove
   * the API key from the list of users that have access to the database.
   *
   * ### Note about nobody role
   *
   * The `nobody` username applies to all unauthenticated connection attempts. For example, if an application tries to
   * read data from a database, but did not identify itself, the task can continue only if the `nobody` user has the
   * role `_reader`.
   *
   * @param putCloudantSecurityConfigurationOptions the {@link PutCloudantSecurityConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Ok}
   */
  public ServiceCall<Ok> putCloudantSecurityConfiguration(PutCloudantSecurityConfigurationOptions putCloudantSecurityConfigurationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putCloudantSecurityConfigurationOptions,
      "putCloudantSecurityConfigurationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", putCloudantSecurityConfigurationOptions.db());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_api/v2/db/{db}/_security", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putCloudantSecurityConfiguration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("cloudant", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putCloudantSecurityConfigurationOptions.cloudant()));
    if (putCloudantSecurityConfigurationOptions.admins() != null) {
      contentJson.add("admins", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putCloudantSecurityConfigurationOptions.admins()));
    }
    if (putCloudantSecurityConfigurationOptions.members() != null) {
      contentJson.add("members", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putCloudantSecurityConfigurationOptions.members()));
    }
    if (putCloudantSecurityConfigurationOptions.couchdbAuthOnly() != null) {
      contentJson.addProperty("couchdb_auth_only", putCloudantSecurityConfigurationOptions.couchdbAuthOnly());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Ok> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Ok>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve CORS configuration information.
   *
   * Lists all Cross-origin resource sharing (CORS) configuration. CORS defines a way in which the browser and the
   * server interact to determine whether or not to allow the request.
   *
   * @param getCorsInformationOptions the {@link GetCorsInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CorsInformation}
   */
  public ServiceCall<CorsInformation> getCorsInformation(GetCorsInformationOptions getCorsInformationOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_api/v2/user/config/cors"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getCorsInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<CorsInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CorsInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve CORS configuration information.
   *
   * Lists all Cross-origin resource sharing (CORS) configuration. CORS defines a way in which the browser and the
   * server interact to determine whether or not to allow the request.
   *
   * @return a {@link ServiceCall} with a result of type {@link CorsInformation}
   */
  public ServiceCall<CorsInformation> getCorsInformation() {
    return getCorsInformation(null);
  }

  /**
   * Modify CORS configuration.
   *
   * Sets the CORS configuration. The configuration applies to all databases and all account level endpoints in your
   * account.
   *
   * @param putCorsConfigurationOptions the {@link PutCorsConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Ok}
   */
  public ServiceCall<Ok> putCorsConfiguration(PutCorsConfigurationOptions putCorsConfigurationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putCorsConfigurationOptions,
      "putCorsConfigurationOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_api/v2/user/config/cors"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putCorsConfiguration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("origins", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putCorsConfigurationOptions.origins()));
    if (putCorsConfigurationOptions.allowCredentials() != null) {
      contentJson.addProperty("allow_credentials", putCorsConfigurationOptions.allowCredentials());
    }
    if (putCorsConfigurationOptions.enableCors() != null) {
      contentJson.addProperty("enable_cors", putCorsConfigurationOptions.enableCors());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Ok> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Ok>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the HTTP headers for an attachment.
   *
   * Returns the HTTP headers that contain a minimal amount of information about the specified attachment. This method
   * supports the same query arguments as the `GET /{db}/{doc_id}/{attachment_name}` method, but only the header
   * information (including attachment size, encoding, and the MD5 hash as an ETag), is returned.
   *
   * @param headAttachmentOptions the {@link HeadAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headAttachment(HeadAttachmentOptions headAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(headAttachmentOptions,
      "headAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", headAttachmentOptions.db());
    pathParamsMap.put("doc_id", headAttachmentOptions.docId());
    pathParamsMap.put("attachment_name", headAttachmentOptions.attachmentName());
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}/{attachment_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "headAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (headAttachmentOptions.ifMatch() != null) {
      builder.header("If-Match", headAttachmentOptions.ifMatch());
    }
    if (headAttachmentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", headAttachmentOptions.ifNoneMatch());
    }
    if (headAttachmentOptions.rev() != null) {
      builder.query("rev", String.valueOf(headAttachmentOptions.rev()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an attachment.
   *
   * Deletes the attachment with the filename, `{attachment_name}`, from the specified doc. You must supply the `rev`
   * query parameter or `If-Match` header with the current revision to delete the attachment.
   *
   * @param deleteAttachmentOptions the {@link DeleteAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> deleteAttachment(DeleteAttachmentOptions deleteAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteAttachmentOptions,
      "deleteAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", deleteAttachmentOptions.db());
    pathParamsMap.put("doc_id", deleteAttachmentOptions.docId());
    pathParamsMap.put("attachment_name", deleteAttachmentOptions.attachmentName());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}/{attachment_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "deleteAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteAttachmentOptions.ifMatch() != null) {
      builder.header("If-Match", deleteAttachmentOptions.ifMatch());
    }
    if (deleteAttachmentOptions.rev() != null) {
      builder.query("rev", String.valueOf(deleteAttachmentOptions.rev()));
    }
    if (deleteAttachmentOptions.batch() != null) {
      builder.query("batch", String.valueOf(deleteAttachmentOptions.batch()));
    }
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve an attachment.
   *
   * Returns the file attachment that is associated with the document. The raw data of the associated attachment is
   * returned, just as if you were accessing a static file. The returned Content-Type header is the same as the content
   * type set when the document attachment was submitted to the database.
   *
   * @param getAttachmentOptions the {@link GetAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getAttachment(GetAttachmentOptions getAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAttachmentOptions,
      "getAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getAttachmentOptions.db());
    pathParamsMap.put("doc_id", getAttachmentOptions.docId());
    pathParamsMap.put("attachment_name", getAttachmentOptions.attachmentName());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}/{attachment_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getAttachmentOptions.accept() != null) {
      builder.header("Accept", getAttachmentOptions.accept());
    }
    if (getAttachmentOptions.ifMatch() != null) {
      builder.header("If-Match", getAttachmentOptions.ifMatch());
    }
    if (getAttachmentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", getAttachmentOptions.ifNoneMatch());
    }
    if (getAttachmentOptions.range() != null) {
      builder.header("Range", getAttachmentOptions.range());
    }
    if (getAttachmentOptions.rev() != null) {
      builder.query("rev", String.valueOf(getAttachmentOptions.rev()));
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create or modify an attachment.
   *
   * Uploads the supplied content as an attachment to the specified document. The attachment name that you provide must
   * be a URL encoded string. You must supply the Content-Type header, and for an existing document, you must also
   * supply either the `rev` query argument or the `If-Match` HTTP header. If you omit the revision, a new, otherwise
   * empty, document is created with the provided attachment, or a conflict occurs. If the uploaded attachment uses an
   * existing attachment name in the remote database, it updates the corresponding stored content of the database. Since
   * you must supply the revision information to add an attachment to the document, this serves as validation to update
   * the existing attachment.
   *
   * @param putAttachmentOptions the {@link PutAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> putAttachment(PutAttachmentOptions putAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putAttachmentOptions,
      "putAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", putAttachmentOptions.db());
    pathParamsMap.put("doc_id", putAttachmentOptions.docId());
    pathParamsMap.put("attachment_name", putAttachmentOptions.attachmentName());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/{doc_id}/{attachment_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Content-Type", putAttachmentOptions.contentType());
    if (putAttachmentOptions.ifMatch() != null) {
      builder.header("If-Match", putAttachmentOptions.ifMatch());
    }
    if (putAttachmentOptions.rev() != null) {
      builder.query("rev", String.valueOf(putAttachmentOptions.rev()));
    }
    builder.bodyContent(putAttachmentOptions.contentType(), null,
      null, putAttachmentOptions.attachment());
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve HTTP headers for a local document.
   *
   * Retrieves the HTTP headers containing minimal amount of information about the specified local document. Since the
   * response body is empty, using the HEAD method is a lightweight way to check if the local document exists or not.
   *
   * @param headLocalDocumentOptions the {@link HeadLocalDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headLocalDocument(HeadLocalDocumentOptions headLocalDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(headLocalDocumentOptions,
      "headLocalDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", headLocalDocumentOptions.db());
    pathParamsMap.put("doc_id", headLocalDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_local/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "headLocalDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (headLocalDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", headLocalDocumentOptions.ifNoneMatch());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a local document.
   *
   * Deletes the specified local document. The semantics are identical to deleting a standard document in the specified
   * database, except that the document is not replicated.
   *
   * @param deleteLocalDocumentOptions the {@link DeleteLocalDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> deleteLocalDocument(DeleteLocalDocumentOptions deleteLocalDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteLocalDocumentOptions,
      "deleteLocalDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", deleteLocalDocumentOptions.db());
    pathParamsMap.put("doc_id", deleteLocalDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_local/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "deleteLocalDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteLocalDocumentOptions.batch() != null) {
      builder.query("batch", String.valueOf(deleteLocalDocumentOptions.batch()));
    }
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a local document.
   *
   * Retrieves the specified local document. The semantics are identical to accessing a standard document in the
   * specified database, except that the document is not replicated.
   *
   * @param getLocalDocumentOptions the {@link GetLocalDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Document}
   */
  public ServiceCall<Document> getLocalDocument(GetLocalDocumentOptions getLocalDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getLocalDocumentOptions,
      "getLocalDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getLocalDocumentOptions.db());
    pathParamsMap.put("doc_id", getLocalDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_local/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getLocalDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getLocalDocumentOptions.accept() != null) {
      builder.header("Accept", getLocalDocumentOptions.accept());
    }
    if (getLocalDocumentOptions.ifNoneMatch() != null) {
      builder.header("If-None-Match", getLocalDocumentOptions.ifNoneMatch());
    }
    if (getLocalDocumentOptions.attachments() != null) {
      builder.query("attachments", String.valueOf(getLocalDocumentOptions.attachments()));
    }
    if (getLocalDocumentOptions.attEncodingInfo() != null) {
      builder.query("att_encoding_info", String.valueOf(getLocalDocumentOptions.attEncodingInfo()));
    }
    if (getLocalDocumentOptions.localSeq() != null) {
      builder.query("local_seq", String.valueOf(getLocalDocumentOptions.localSeq()));
    }
    ResponseConverter<Document> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Document>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create or modify a local document.
   *
   * Stores the specified local document. The semantics are identical to storing a standard document in the specified
   * database, except that the document is not replicated.
   *
   * @param putLocalDocumentOptions the {@link PutLocalDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentResult}
   */
  public ServiceCall<DocumentResult> putLocalDocument(PutLocalDocumentOptions putLocalDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putLocalDocumentOptions,
      "putLocalDocumentOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((putLocalDocumentOptions.document() != null) || (putLocalDocumentOptions.body() != null),
      "One of [putLocalDocumentOptions.document(), putLocalDocumentOptions.body()] must be specified");

    if (putLocalDocumentOptions.document() != null && putLocalDocumentOptions.contentType() == null) {
      putLocalDocumentOptions = putLocalDocumentOptions.newBuilder().contentType("application/json").build();
    }
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", putLocalDocumentOptions.db());
    pathParamsMap.put("doc_id", putLocalDocumentOptions.docId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_local/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "putLocalDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (putLocalDocumentOptions.contentType() != null) {
      builder.header("Content-Type", putLocalDocumentOptions.contentType());
    }
    if (putLocalDocumentOptions.batch() != null) {
      builder.query("batch", String.valueOf(putLocalDocumentOptions.batch()));
    }
    builder.bodyContent(putLocalDocumentOptions.contentType(), putLocalDocumentOptions.document(),
      null, putLocalDocumentOptions.body());
    ResponseConverter<DocumentResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query the document revisions and possible ancestors missing from the database.
   *
   * The replicator is the primary user of this operation. After receiving a set of new revision IDs from the source
   * database, the replicator sends this set to the destination database's `_revs_diff` to find out which of them
   * already exists there. It can then avoid fetching and sending already-known document bodies.
   *
   * @param postRevsDiffOptions the {@link PostRevsDiffOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Map}
   */
  public ServiceCall<Map<String, RevsDiff>> postRevsDiff(PostRevsDiffOptions postRevsDiffOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postRevsDiffOptions,
      "postRevsDiffOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", postRevsDiffOptions.db());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_revs_diff", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postRevsDiff");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(postRevsDiffOptions.documentRevisions()), "application/json");
    ResponseConverter<Map<String, RevsDiff>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Map<String, RevsDiff>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve shard information.
   *
   * List each shard range and the corresponding replicas for a specified database.
   *
   * @param getShardsInformationOptions the {@link GetShardsInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ShardsInformation}
   */
  public ServiceCall<ShardsInformation> getShardsInformation(GetShardsInformationOptions getShardsInformationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getShardsInformationOptions,
      "getShardsInformationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getShardsInformationOptions.db());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_shards", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getShardsInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ShardsInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ShardsInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve shard information for a specific document.
   *
   * Retrieves information about a specific shard where a particular document is stored, along with information about
   * the nodes where that shard has a replica.
   *
   * @param getDocumentShardsInfoOptions the {@link GetDocumentShardsInfoOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentShardInfo}
   */
  public ServiceCall<DocumentShardInfo> getDocumentShardsInfo(GetDocumentShardsInfoOptions getDocumentShardsInfoOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentShardsInfoOptions,
      "getDocumentShardsInfoOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("db", getDocumentShardsInfoOptions.db());
    pathParamsMap.put("doc_id", getDocumentShardsInfoOptions.docId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{db}/_shards/{doc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDocumentShardsInfo");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<DocumentShardInfo> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DocumentShardInfo>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve HTTP headers about whether the server is up.
   *
   * Retrieves the HTTP headers about whether the server is up.
   *
   * @param headUpInformationOptions the {@link HeadUpInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headUpInformation(HeadUpInformationOptions headUpInformationOptions) {
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_up"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "headUpInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve HTTP headers about whether the server is up.
   *
   * Retrieves the HTTP headers about whether the server is up.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> headUpInformation() {
    return headUpInformation(null);
  }

  /**
   * Retrieve list of running tasks.
   *
   * Lists running tasks, including the task type, name, status, and process ID. The result includes a JSON array of the
   * currently running tasks, with each task described as a single object. Depending on the operation type, the set of
   * response object fields might be different.
   *
   * @param getActiveTasksOptions the {@link GetActiveTasksOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<ActiveTask>> getActiveTasks(GetActiveTasksOptions getActiveTasksOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_active_tasks"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getActiveTasks");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<List<ActiveTask>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<ActiveTask>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve list of running tasks.
   *
   * Lists running tasks, including the task type, name, status, and process ID. The result includes a JSON array of the
   * currently running tasks, with each task described as a single object. Depending on the operation type, the set of
   * response object fields might be different.
   *
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<ActiveTask>> getActiveTasks() {
    return getActiveTasks(null);
  }

  /**
   * Retrieve cluster membership information.
   *
   * Displays the nodes that are part of the cluster as `cluster_nodes`. The field, `all_nodes`, displays all nodes this
   * node knows about, including the ones that are part of the cluster. This endpoint is useful when you set up a
   * cluster.
   *
   * @param getMembershipInformationOptions the {@link GetMembershipInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link MembershipInformation}
   */
  public ServiceCall<MembershipInformation> getMembershipInformation(GetMembershipInformationOptions getMembershipInformationOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_membership"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getMembershipInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<MembershipInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<MembershipInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve cluster membership information.
   *
   * Displays the nodes that are part of the cluster as `cluster_nodes`. The field, `all_nodes`, displays all nodes this
   * node knows about, including the ones that are part of the cluster. This endpoint is useful when you set up a
   * cluster.
   *
   * @return a {@link ServiceCall} with a result of type {@link MembershipInformation}
   */
  public ServiceCall<MembershipInformation> getMembershipInformation() {
    return getMembershipInformation(null);
  }

  /**
   * Retrieve information about whether the server is up.
   *
   * Confirms that the server is up, running, and ready to respond to requests. If `maintenance_mode` is `true` or
   * `nolb`, the endpoint returns a 404 response.
   *
   * **Tip:**  The authentication for this endpoint is only enforced when using IAM.
   *
   * @param getUpInformationOptions the {@link GetUpInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link UpInformation}
   */
  public ServiceCall<UpInformation> getUpInformation(GetUpInformationOptions getUpInformationOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_up"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getUpInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<UpInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UpInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information about whether the server is up.
   *
   * Confirms that the server is up, running, and ready to respond to requests. If `maintenance_mode` is `true` or
   * `nolb`, the endpoint returns a 404 response.
   *
   * **Tip:**  The authentication for this endpoint is only enforced when using IAM.
   *
   * @return a {@link ServiceCall} with a result of type {@link UpInformation}
   */
  public ServiceCall<UpInformation> getUpInformation() {
    return getUpInformation(null);
  }

  /**
   * Retrieve Activity Tracker events information.
   *
   * Check event types that are being sent to IBM Cloud Activity Tracker for the IBM Cloudant instance.
   *
   * @param getActivityTrackerEventsOptions the {@link GetActivityTrackerEventsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ActivityTrackerEvents}
   */
  public ServiceCall<ActivityTrackerEvents> getActivityTrackerEvents(GetActivityTrackerEventsOptions getActivityTrackerEventsOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_api/v2/user/activity_tracker/events"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getActivityTrackerEvents");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ActivityTrackerEvents> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ActivityTrackerEvents>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve Activity Tracker events information.
   *
   * Check event types that are being sent to IBM Cloud Activity Tracker for the IBM Cloudant instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link ActivityTrackerEvents}
   */
  public ServiceCall<ActivityTrackerEvents> getActivityTrackerEvents() {
    return getActivityTrackerEvents(null);
  }

  /**
   * Modify Activity Tracker events configuration.
   *
   * Configure event types that are being sent to IBM Cloud Activity Tracker for the IBM Cloudant instance.
   *
   * @param postActivityTrackerEventsOptions the {@link PostActivityTrackerEventsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Ok}
   */
  public ServiceCall<Ok> postActivityTrackerEvents(PostActivityTrackerEventsOptions postActivityTrackerEventsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postActivityTrackerEventsOptions,
      "postActivityTrackerEventsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_api/v2/user/activity_tracker/events"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "postActivityTrackerEvents");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("types", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(postActivityTrackerEventsOptions.types()));
    builder.bodyJson(contentJson);
    ResponseConverter<Ok> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Ok>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the current provisioned throughput capacity consumption.
   *
   * View the current consumption of provisioned throughput capacity for an IBM Cloudant instance. The current
   * consumption shows the quantities of reads, writes, and global queries conducted against the instance for a given
   * second.
   *
   * @param getCurrentThroughputInformationOptions the {@link GetCurrentThroughputInformationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CurrentThroughputInformation}
   */
  public ServiceCall<CurrentThroughputInformation> getCurrentThroughputInformation(GetCurrentThroughputInformationOptions getCurrentThroughputInformationOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/_api/v2/user/current/throughput"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getCurrentThroughputInformation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<CurrentThroughputInformation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CurrentThroughputInformation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the current provisioned throughput capacity consumption.
   *
   * View the current consumption of provisioned throughput capacity for an IBM Cloudant instance. The current
   * consumption shows the quantities of reads, writes, and global queries conducted against the instance for a given
   * second.
   *
   * @return a {@link ServiceCall} with a result of type {@link CurrentThroughputInformation}
   */
  public ServiceCall<CurrentThroughputInformation> getCurrentThroughputInformation() {
    return getCurrentThroughputInformation(null);
  }

}
