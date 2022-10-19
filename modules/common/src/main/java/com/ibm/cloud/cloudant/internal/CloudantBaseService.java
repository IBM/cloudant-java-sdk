/**
 * © Copyright IBM Corporation 2020, 2021. All Rights Reserved.
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

package com.ibm.cloud.cloudant.internal;

import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.cloudant.security.CouchDbSessionAuthenticator;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * This class provides customizations to the generated Cloudant class.
 * It is not public API, but is used in the class hierarchy to bridge the generated Cloudant
 * class to the SDK core BaseService.
 */
public abstract class CloudantBaseService extends BaseService {

    private int serviceUrlPathSegmentSize = 0;

    public CloudantBaseService(String serviceName, Authenticator authenticator) {
        super(serviceName, authenticator);
    }

    @Override
    protected OkHttpClient configureHttpClient() {
        OkHttpClient.Builder builder = super.configureHttpClient().newBuilder();
        // Overwrite default read timeout to 2.5 minutes
        builder.readTimeout(150L, TimeUnit.SECONDS);
        // If we are using a CouchDB session authenticator we need to customize the cookie jar
        customizeAuthenticator(a -> builder
                .cookieJar(a.getCookieJar()));
        return builder.build();
    }

    @Override
    public void setServiceUrl(String serviceUrl) {
        super.setServiceUrl(serviceUrl);
        // Get the now sanitized value
        serviceUrl = getServiceUrl();
        HttpUrl sUrl = HttpUrl.parse(serviceUrl);
        if (sUrl != null) {
            List<String> serviceUrlSegements = sUrl.encodedPathSegments();
            if (serviceUrlSegements.size() == 1 && serviceUrlSegements.get(0).isEmpty()) {
                serviceUrlPathSegmentSize = 0;
            } else {
                serviceUrlPathSegmentSize = serviceUrlSegements.size();
            }
        }
        customizeAuthenticator(a -> {
            a.setSessionUrl(getServiceUrl());
            a.invalidateToken();
        });
    }

    @Override
    public void configureClient(HttpConfigOptions options) {
        super.configureClient(options);
        customizeAuthenticator(a -> a.setHttpConfigOptions(options));
    }

    @Override
    public void setDefaultHeaders(Map<String, String> headers) {
        super.setDefaultHeaders(headers);
        customizeAuthenticator(a -> a.setHeaders(headers));
    }

    /**
     * Utility function to apply customizations to CouchDbSessionAuthenticator instances.
     *
     * @param consumer consumer function
     */
    private void customizeAuthenticator(Consumer<CouchDbSessionAuthenticator> consumer) {
        Authenticator authenticator = getAuthenticator();
        // Apply customizations only to instances of CouchDbSessionAuthenticator
        if (authenticator instanceof CouchDbSessionAuthenticator) {
            consumer.accept((CouchDbSessionAuthenticator) authenticator);
        }
    }

    private enum ValidationRule {
        DOC_ID(
            1, // Doc ID is in path segment 1 (database is 0)
            "Document ID",
            Arrays.asList(
                "deleteDocument",
                "getDocument",
                "getDocumentAsMixed",
                "getDocumentAsRelated",
                "getDocumentAsStream",
                "headDocument",
                "putDocument",
                "deleteAttachment",
                "getAttachment",
                "headAttachment",
                "putAttachment"
            )
        ),
        ATT_NAME(
            2, // Attachment name is in path segment 2 (database is 0, doc is 1)
            "Attachment name",
            Arrays.asList(
                "deleteAttachment",
                "getAttachment",
                "headAttachment",
                "putAttachment"
            )
        );

        private static final EnumSet<ValidationRule> NONE = EnumSet.noneOf(ValidationRule.class);
        private final int pathSegmentIndex;
        private final String errorParameterName;
        private final List<String> operationIds;

        ValidationRule(int pathSegmentIndex, String errorParameterName, List<String> operationIds) {
            this.pathSegmentIndex = pathSegmentIndex;
            this.errorParameterName = errorParameterName;
            this.operationIds = operationIds;
        }
    }
    static final Map<String, EnumSet<ValidationRule>> rulesByOperation = new TreeMap<>();
    static {
        for (ValidationRule rule : ValidationRule.values()) {
            for (String operationId : rule.operationIds) {
                EnumSet<ValidationRule> existing = rulesByOperation.putIfAbsent(operationId, EnumSet.of(rule));
                if (existing != null) {
                    existing.add(rule);
                }
            }
        }
    }

    @Override
    protected <T> ServiceCall<T> createServiceCall(Request request,
            ResponseConverter<T> converter) {
        // Extract the operation ID from the request headers.
        String operationId = null;
        String header = request.header("X-IBMCloud-SDK-Analytics");
        if (header != null) {
            StringTokenizer tokenizer = new StringTokenizer(request.header("X-IBMCloud-SDK-Analytics"), "=;");
            while (tokenizer.hasMoreTokens()) {
                if ("operation_id".equals(tokenizer.nextToken())) {
                    operationId = tokenizer.nextToken();
                    break;
                }
            }
        }
        if (operationId != null) {
            List<String> requestUrlPathSegments = request.url().pathSegments();
            if (requestUrlPathSegments.size() == 1 && requestUrlPathSegments.contains("")) {
                requestUrlPathSegments = Collections.emptyList();
            }
            // Check each validation rule that applies to the operation.
            for (ValidationRule rule : rulesByOperation.getOrDefault(operationId, ValidationRule.NONE)) {
                // Allow for any path segments that might exist in e.g. the URL of a proxy by offseting from the service URL index.
                int pathSegmentIndex = serviceUrlPathSegmentSize + rule.pathSegmentIndex;
                if (requestUrlPathSegments.size() > pathSegmentIndex) {
                    String segmentToValidate = requestUrlPathSegments.get(pathSegmentIndex);
                    if (segmentToValidate.startsWith("_")) {
                        throw new IllegalArgumentException(String.format("%s %s starts with the invalid _ character.", rule.errorParameterName, segmentToValidate));
                    }
                }
            }
        }
        return super.createServiceCall(request, converter);
    }
}
