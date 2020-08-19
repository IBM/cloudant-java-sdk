/**
 * © Copyright IBM Corporation 2020. All Rights Reserved.
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
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.cloudant.security.CouchDbSessionAuthenticator;

import okhttp3.OkHttpClient;

import java.util.Map;
import java.util.function.Consumer;

/**
 * This class provides customizations to the generated Cloudant class.
 * It is not public API, but is used in the class hierarchy to bridge the generated Cloudant
 * class to the SDK core BaseService.
 */
public abstract class CloudantBaseService extends BaseService {

    public CloudantBaseService(String serviceName, Authenticator authenticator) {
        super(serviceName, authenticator);
    }

    @Override
    protected OkHttpClient configureHttpClient() {
        OkHttpClient.Builder builder = super.configureHttpClient().newBuilder();
        // If we are using a CouchDB session authenticator we need to customize the cookie jar
        customizeAuthenticator(a -> builder
                .cookieJar(a.getCookieJar()));
        return builder.build();
    }

    @Override
    public void setServiceUrl(String serviceUrl) {
        super.setServiceUrl(serviceUrl);
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
}
