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


import com.ibm.cloud.cloudant.security.CouchDbSessionAuthenticator.CouchDbSessionToken;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;


public class CouchDbSessionTokenTest {

    /**
     * Test that a token with an expiry time in the past is not valid.
     */
    @Test
    public void isTokenValid() {
        CouchDbSessionToken t = new CouchDbSessionToken(System.currentTimeMillis() - 1000);
        assertFalse(t.isTokenValid(), "The token should not be valid.");
    }

    /**
     * Test that a token needs refresh after 80% of it's lifetime
     */
    @Test
    public void needsRefresh() throws Exception {
        // 1 second lifetime
        CouchDbSessionToken t = new CouchDbSessionToken(System.currentTimeMillis() + 1000);
        // The minimum refresh time is 800 ms, sleep for slightly longer than that (850 ms) to allow
        // for slight delay in construction etc
        Thread.sleep(850);
        assertTrue(t.needsRefresh(), "The token should need a refresh.");
        assertTrue(t.isTokenValid(), "The token should not be expired.");
    }

    /**
     * Since the access token is stored as a cookie and not explicitly in the token class calling
     * getAccessToken should always return null.
     */
    @Test
    public void getAccessToken() {
        CouchDbSessionToken t = new CouchDbSessionToken(System.currentTimeMillis());
        assertNull(t.getAccessToken(), "The access token should always be null.");
    }

    /**
     * Test that a token refresh calculation is correct
     */
    @Test
    public void refreshTimeCalculation() throws Exception {
        long currentTime = System.currentTimeMillis();
        CouchDbSessionToken t = new CouchDbSessionToken(currentTime + 1000);
        assertEquals(200, t.expiryTime - t.refreshTime, "The time between refresh and expiry should be 200 ms");
    }
}
