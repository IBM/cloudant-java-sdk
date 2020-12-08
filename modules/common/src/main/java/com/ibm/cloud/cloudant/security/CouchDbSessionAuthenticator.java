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

package com.ibm.cloud.cloudant.security;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.HttpClientSingleton;
import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ServiceCookieJar;
import com.ibm.cloud.sdk.core.security.AbstractToken;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.TokenRequestBasedAuthenticator;
import com.ibm.cloud.sdk.core.security.TokenServerResponse;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.cloudant.common.SdkCommon;

import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.IOException;
import java.net.CookieManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link Authenticator} that provides authentication via the Apache CouchDB
 * _session endpoint.
 */
public class CouchDbSessionAuthenticator
        extends TokenRequestBasedAuthenticator<CouchDbSessionAuthenticator.CouchDbSessionToken,
        CouchDbSessionAuthenticator.CouchDbSessionToken>
        implements Authenticator {

    public static final String AUTH_TYPE = "COUCHDB_SESSION";

    private final String user;
    private final String pass;
    private final ServiceCookieJar cookieJar;

    private HttpUrl sessionUrl = null;
    private HttpConfigOptions options = null;
    private Headers headers = null;
    private OkHttpClient client = null;

    /**
     * Get a new Authenticator instance for the supplied service URL and credentials that provides
     * authentication via the Apache CouchDB _session endpoint.
     *
     * @param username   the username
     * @param password   the password
     * @return new Authenticator instance
     */
    public static Authenticator newAuthenticator(String username, String password) {
        return new CouchDbSessionAuthenticator(username, password);
    }

    /**
     * This class should not be instantiated directly.
     * Use
     * {@link CouchDbSessionAuthenticator#newAuthenticator(String, String)}
     *  @param username   the username
     * @param password   the password
     */
    private CouchDbSessionAuthenticator(String username, String password) {
        this.user = username;
        this.pass = password;
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(java.net.CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        cookieJar = new ServiceCookieJar(cookieManager);
    }

    /**
     * Getter for the cookie jar used to store the session information.
     *
     * @return the cookie jar
     */
    public ServiceCookieJar getCookieJar() {
        return this.cookieJar;
    }

    /**
     * Setter to configure this authenticator with HttpConfigOptions. This is called
     * internally to
     * apply the configuration options of the
     * <a href="../v1/Cloudant.html"><code>Cloudant</code></a> client automatically.
     *
     * @param options the {@link com.ibm.cloud.sdk.core.http.HttpConfigOptions} object for modifying the client instance
     */
    public void setHttpConfigOptions(HttpConfigOptions options) {
        this.options = options;
    }

    /**
     * Setter to configure this authenticator with a new session URL derived from the supplied
     * service URL. This is called internally to apply the service URL from the
     * <a href="../v1/Cloudant.html"><code>Cloudant</code></a> client automatically.
     *
     * @param serviceUrl the base service URL associated with the service instance
     */
    public void setSessionUrl(String serviceUrl) {
        this.sessionUrl = RequestBuilder.constructHttpUrl(serviceUrl, new String[]{"_session"});
    }

    /**
     * @param headers map of header name and value pairs
     */
    @Override
    public void setHeaders(Map<String, String> headers) {
        Map<String, String> mergedHeaders = new HashMap<>();
        mergedHeaders.putAll(SdkCommon.getSdkHeaders("authenticatorPostSession"));
        mergedHeaders.putAll(headers);
        super.setHeaders(mergedHeaders);
        // Store the headers in OkHttp format
        this.headers = Headers.of(mergedHeaders);
    }

    @Override
    public void validate() {
        if (user == null || user.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(ERRORMSG_PROP_MISSING, "username"));
        } else if (pass == null || pass.isEmpty()) {
            throw new IllegalArgumentException(String.format(ERRORMSG_PROP_MISSING, "password"));
        }
    }

    @Override
    public String authenticationType() {
        return AUTH_TYPE;
    }

    @Override
    public void authenticate(okhttp3.Request.Builder requestBuilder) {
        // All we need to do is call getToken, because the storage of cookies from requests and the
        // addition of cookies from requests is handled automatically by the HTTP client's cookie
        // jar support.
        super.getToken();
    }

    @Override
    public CouchDbSessionToken requestToken() {
        JsonObject creds = new JsonObject();
        creds.addProperty("username", user);
        creds.addProperty("password", pass);
        RequestBuilder postSessionbuilder = RequestBuilder.post(sessionUrl)
                .bodyJson(creds);

        // Apply custom headers if necessary
        if (headers != null) {
            for (String key : headers.names()) {
                postSessionbuilder.header(key, headers.get(key));
            }
        }

        try {
            // Build the client if we need to
            if (client == null) {
                client = HttpClientSingleton
                        .getInstance()
                        .configureClient(options)
                        .newBuilder()
                        .cookieJar(cookieJar)
                        .build();
            }
            try (Response response = client.newCall(postSessionbuilder.build()).execute()) {
                if (response.isSuccessful()) {
                    List<Cookie> cookies = Cookie.parseAll(sessionUrl, response.headers());
                    for (Cookie cookie : cookies) {
                        if ("AuthSession".equals(cookie.name())) {
                            return new CouchDbSessionToken(cookie.expiresAt());
                        }
                    }
                }
                throw new ServiceResponseException(response.code(), response);
            }
        } catch (RuntimeException | IOException t) {
            return new CouchDbSessionToken(t);
        }
    }

    /**
     * For internal use to invalidate the local token and force a refresh cycle with the server.
     */
    public void invalidateToken() {
        this.tokenData = null;
    }

    /**
     * Implements {@link TokenServerResponse} for an Apache CouchDB session cookie.
     */
    public static class CouchDbSessionToken extends AbstractToken implements TokenServerResponse {

        public final long expiryTime;
        public final long refreshTime;

        /**
         * Constructor for a known expiry time.
         *
         * @param expiryTime time since epoch that represents the expiry time of this cookie token
         */
        public CouchDbSessionToken(long expiryTime) {
            this.expiryTime = expiryTime;
            this.refreshTime = expiryTime - ((expiryTime - System.currentTimeMillis()) / 5L);
        }

        /**
         * Constructor for an error scenario.
         *
         * @param throwable error or exception that prevented a cookie token being acquired
         */
        CouchDbSessionToken(Throwable throwable) {
            super(throwable);
            this.expiryTime = Long.MIN_VALUE;
            this.refreshTime = Long.MIN_VALUE;
        }

        @Override
        public boolean isTokenValid() {
            return System.currentTimeMillis() < expiryTime;
        }

        @Override
        public boolean needsRefresh() {
            return System.currentTimeMillis() > refreshTime;
        }

        @Override
        public String getAccessToken() {
            return null;
        }
    }
}

