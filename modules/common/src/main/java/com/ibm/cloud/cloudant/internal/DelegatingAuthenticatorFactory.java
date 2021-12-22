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

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.cloudant.security.CouchDbSessionAuthenticator;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * This class serves as an Authenticator factory.
 * It will detect and use various configuration sources in order to produce an Authenticator
 * instance.
 */
public class DelegatingAuthenticatorFactory extends ConfigBasedAuthenticatorFactory {

    // The default ctor is hidden since this is a utility class.
    private DelegatingAuthenticatorFactory() {
        super();
    }

    public static Authenticator getAuthenticator(String serviceName) {
        return getAuthenticator(serviceName, CredentialUtils.getServiceProperties(serviceName));
    }

    static Authenticator getAuthenticator(String serviceName,
                                                 Map<String, String> serviceProperties) {
        if (serviceProperties != null && !serviceProperties.isEmpty()) {
            String authType = serviceProperties.get(Authenticator.PROPNAME_AUTH_TYPE);

            if (StringUtils.isEmpty(authType)) {
                // this property doesn't have an according Authenticator constant
                authType = serviceProperties.get("AUTHTYPE");
            }

            // If the auth type is COUCHDB_SESSION create the authenticator
            if (CouchDbSessionAuthenticator.AUTH_TYPE.equalsIgnoreCase(authType)) {
                return CouchDbSessionAuthenticator.newAuthenticator(
                        serviceProperties.get(Authenticator.PROPNAME_USERNAME),
                        serviceProperties.get(Authenticator.PROPNAME_PASSWORD));
            }
        }

        // For all other auth types, delegate to the core factory
        return ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    }
}
