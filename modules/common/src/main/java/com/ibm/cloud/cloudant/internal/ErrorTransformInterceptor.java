/**
 * © Copyright IBM Corporation 2024. All Rights Reserved.
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

import java.io.IOException;
import java.util.Optional;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ibm.cloud.sdk.core.util.GsonSingleton;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ErrorTransformInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        // Don't modify the request, but get the response
        Response response = chain.proceed(chain.request());
        if (!"HEAD".equals(chain.request().method()) // skip HEAD requests because they have no body
            && !response.isSuccessful() // skip successful responses
            && response.body() != null // skip cases with no body
            && response.body().contentType() != null // skip cases with no content type
            && "application".equals(response.body().contentType().type())
            && "json".equals(response.body().contentType().subtype()) // we only want to work with application/json
        ) {
            String errorResponse = response.body().string();
            JsonObject errorBody = null;
            try {
                errorBody = GsonSingleton.getGson().fromJson(errorResponse, JsonObject.class);
                if (errorBody != null) {
                    // Don't augment if there is already a trace present
                    if (!errorBody.has("trace")) {
                        String error = Optional.ofNullable(errorBody.get("error")).map(JsonElement::getAsString).orElse(null);
                        String reason = Optional.ofNullable(errorBody.get("reason")).map(JsonElement::getAsString).orElse(null);
                        if (!errorBody.has("errors")) {
                            if (error != null) {
                                // Augment with errors array model
                                JsonObject errorModel = new JsonObject();
                                errorModel.addProperty("code", error);
                                StringBuilder messageBuilder = new StringBuilder(error);
                                if (reason != null && !reason.isEmpty()) {
                                    messageBuilder.append(": ");
                                    messageBuilder.append(reason);
                                }
                                errorModel.addProperty("message", messageBuilder.toString());
                                JsonArray errors = new JsonArray(1);
                                errors.add(errorModel);
                                errorBody.getAsJsonObject().add("errors", errors);
                                // Propose the new augmented response, it may be augmented again by trace
                                errorResponse = errorBody.toString();
                            }
                        }
                        if (errorBody.has("errors")) {
                            String trace = response.header("x-couch-request-id");
                            if (trace != null && !trace.isEmpty()) {
                                // Augment with trace
                                errorBody.addProperty("trace", trace);
                                // Propose the new augmented response
                                errorResponse = errorBody.toString();
                            }
                        }
                    }
                }
            } catch (JsonParseException e) {
              // If response body is malformed, just return the original response
            }
            // Make a new body to return, either using the original repsonse or
            // the modified one.
            response = response
                        .newBuilder()
                        .body(ResponseBody.create(errorResponse,
                            response.body().contentType()))
                        .build();
        }
        return response;
    }
}
