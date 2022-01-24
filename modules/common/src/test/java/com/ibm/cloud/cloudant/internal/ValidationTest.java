/**
 * © Copyright IBM Corporation 2021, 2022 All Rights Reserved.
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

import static org.testng.Assert.assertEquals;

import java.util.Map;
import java.util.Map.Entry;
import com.ibm.cloud.cloudant.common.SdkCommon;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import org.testng.annotations.Test;
import okhttp3.HttpUrl;
import okhttp3.Request;

public class ValidationTest {
    
    private final String dbName = "testDatabase";
    private final String docId = "_testDocument";
    
    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".+_testDocument.+")
    void validatesDocumentId() {
        CloudantBaseService cloudantBaseService = new CloudantBaseService(null, new NoAuthAuthenticator()) {
        };
        cloudantBaseService.setServiceUrl("https://cloudant.example");
        HttpUrl requestUrl =  HttpUrl.parse(cloudantBaseService.getServiceUrl()).newBuilder().addPathSegment(dbName).addPathSegment(docId).build();
        Request.Builder rb = new Request.Builder().url(requestUrl).get();
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDocument");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
          rb.header(header.getKey(), header.getValue());
        }
        cloudantBaseService.createServiceCall(rb.build(), null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".+_testDocument.+")
    void validatesDocumentIdAtLongServicePath() {
        CloudantBaseService cloudantBaseService = new CloudantBaseService(null, new NoAuthAuthenticator()) {
        };
        cloudantBaseService.setServiceUrl("https://cloudant.example/some/proxy/path");
        HttpUrl requestUrl =  HttpUrl.parse(cloudantBaseService.getServiceUrl()).newBuilder().addPathSegment(dbName).addPathSegment(docId).build();
        Request.Builder rb = new Request.Builder().url(requestUrl).get();
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDocument");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
          rb.header(header.getKey(), header.getValue());
        }
        cloudantBaseService.createServiceCall(rb.build(), null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".+_testDocument.+")
    void validatesDocumentIdAtLongServicePathAfterChange() {
        CloudantBaseService cloudantBaseService = new CloudantBaseService(null, new NoAuthAuthenticator()) {
        };
        cloudantBaseService.setServiceUrl("https://cloudant.example");
        HttpUrl requestUrl =  HttpUrl.parse(cloudantBaseService.getServiceUrl()).newBuilder().addPathSegment(dbName).addPathSegment(docId).build();
        Request.Builder rb = new Request.Builder().url(requestUrl).get();
        cloudantBaseService.createServiceCall(rb.build(), null);
        cloudantBaseService.setServiceUrl("https://cloudant.example/some/proxy/path");
        requestUrl =  HttpUrl.parse(cloudantBaseService.getServiceUrl()).newBuilder().addPathSegment(dbName).addPathSegment(docId).build();
        rb = new Request.Builder().url(requestUrl).get();
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getDocument");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
          rb.header(header.getKey(), header.getValue());
        }
        cloudantBaseService.createServiceCall(rb.build(), null);
    }

    @Test
    void validatesStripTrailingSlash() {
        CloudantBaseService cloudantBaseService = new CloudantBaseService(null, new NoAuthAuthenticator()) {
        };
        cloudantBaseService.setServiceUrl("https://cloudant.example/");
        assertEquals(cloudantBaseService.getServiceUrl(), "https://cloudant.example");
    }
}
