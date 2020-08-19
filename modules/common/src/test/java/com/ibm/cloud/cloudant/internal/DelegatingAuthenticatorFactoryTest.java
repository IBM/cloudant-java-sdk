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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ibm.cloud.cloudant.internal.DelegatingAuthenticatorFactory;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.cloudant.security.CouchDbSessionAuthenticator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class DelegatingAuthenticatorFactoryTest {

    // Mock service properties
    private static final Map<String, String> servicePropsBase = new HashMap<>();

    static {
        // URL
        servicePropsBase.put(BaseService.PROPNAME_URL, "https://cloudant.example");
        // Username
        servicePropsBase.put(Authenticator.PROPNAME_USERNAME, "testuser");
        // Password
        servicePropsBase.put(Authenticator.PROPNAME_PASSWORD, "testpass");
    }

    private Map<String, String> getServicePropsWithAuthType(String authType) {
        Map<String, String> serviceProps = new HashMap<>();
        serviceProps.putAll(servicePropsBase);
        serviceProps.put(Authenticator.PROPNAME_AUTH_TYPE, authType);
        return serviceProps;
    }

    @Test
    void getAuthenticatorForSessionAuthType() {
        Authenticator authenticator = DelegatingAuthenticatorFactory.getAuthenticator("test",
                getServicePropsWithAuthType("COUCHDB_SESSION"));
        assertTrue(authenticator instanceof CouchDbSessionAuthenticator, "Should return an " +
                "instance of CouchDbSessionAuthenticator");
    }

    @Test
    void getAuthenticatorForOtherAuthType() {
        Authenticator authenticator = DelegatingAuthenticatorFactory.getAuthenticator("test",
                getServicePropsWithAuthType("BASIC"));
        assertFalse(authenticator instanceof CouchDbSessionAuthenticator, "Should not return " +
                "an instance of CouchDbSessionAuthenticator");
    }
}
