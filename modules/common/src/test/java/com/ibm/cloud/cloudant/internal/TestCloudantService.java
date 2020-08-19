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

import com.ibm.cloud.cloudant.common.SdkCommon;
import com.ibm.cloud.cloudant.internal.CloudantBaseService;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;

import java.util.Map;

public class TestCloudantService extends CloudantBaseService {
    public TestCloudantService(String serviceName, Authenticator authenticator) {
        super(serviceName, authenticator);
    }

    public ServiceCall<Map<String,Object>> getSessionInformation() {
        String[] pathSegments = { "_session" };
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cloudant", "v1", "getSessionInformation");
        for (Map.Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        builder.header("Accept", "application/json");
        ResponseConverter<Map<String,Object>> responseConverter =
                ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Map<String,Object>>() { }.getType());
        return createServiceCall(builder.build(), responseConverter);
    }
}
