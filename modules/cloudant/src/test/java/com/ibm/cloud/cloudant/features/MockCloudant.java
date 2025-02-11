/**
 * © Copyright IBM Corporation 2022, 2023. All Rights Reserved.
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

package com.ibm.cloud.cloudant.features;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Supplier;
import com.google.gson.stream.MalformedJsonException;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.http.ServiceCallback;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.BadRequestException;
import com.ibm.cloud.sdk.core.service.exception.ForbiddenException;
import com.ibm.cloud.sdk.core.service.exception.InternalServerErrorException;
import com.ibm.cloud.sdk.core.service.exception.InvalidServiceResponseException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.exception.ServiceUnavailableException;
import com.ibm.cloud.sdk.core.service.exception.TooManyRequestsException;
import com.ibm.cloud.sdk.core.service.exception.UnauthorizedException;
import org.testng.Assert;
import io.reactivex.Single;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Mock client that simulates changes responses
 */
public class MockCloudant<R> extends Cloudant {

    /**
     * Make a mock client that supplies results or exceptions as indicated by the supplier.
     * @param instructionSupplier
     */
    public MockCloudant(Supplier<MockInstruction<R>> instructionSupplier) {
        super(null, new NoAuthAuthenticator());
        this.mocks = instructionSupplier;
    }

    protected static final okhttp3.Request MOCK_REQUEST = new okhttp3.Request.Builder()
                                                            .url("https://test.example/foo/bar/baz")
                                                            .method("POST",
                                                                RequestBody.create("{}", 
                                                                MediaType.get("application/json")))
                                                            .build();
    protected static final okhttp3.Response SUCCESS_RESPONSE = new okhttp3.Response.Builder()
                                                            .code(200)
                                                            .message("OK")
                                                            .protocol(Protocol.HTTP_2)
                                                            .request(MOCK_REQUEST)
                                                            .build();
    
    protected final Supplier<MockInstruction<R>> mocks;
    protected final List<ServiceCall<R>> cancelledRequests = Collections.synchronizedList(new ArrayList<>());
    
    /**
     * Mock errors
     */
    enum MockError {
        TERMINAL_400,
        TERMINAL_401,
        TERMINAL_403,
        TERMINAL_404,
        TRANSIENT_429,
        TRANSIENT_500,
        TRANSIENT_502,
        TRANSIENT_503,
        TRANSIENT_504,
        TRANSIENT_BAD_JSON,
        TRANSIENT_IO;

        static EnumSet<MockError> getTerminalErrors() {
            return EnumSet.of(
                TERMINAL_400,
                TERMINAL_401,
                TERMINAL_403,
                TERMINAL_404);
        }

        static EnumSet<MockError> getTransientErrors() {
            return EnumSet.of(
                TRANSIENT_429,
                TRANSIENT_500,
                TRANSIENT_502,
                TRANSIENT_503,
                TRANSIENT_504,
                TRANSIENT_BAD_JSON,
                TRANSIENT_IO);
        }

        private okhttp3.Response makeResponse(okhttp3.Response.Builder rb, int code, String error) {
            rb.code(code)
                .protocol(Protocol.HTTP_2)
                .request(MOCK_REQUEST);
            switch (code) {
                case 200:
                    rb.message("OK");
                    // make some invalid JSON
                    rb.body(ResponseBody.create("{", MediaType.get("application/json")));
                    break;
                case 502:
                    rb.message("BAD_GATEWAY");
                    rb.body(ResponseBody.create("", MediaType.get("text/plain")));
                    break;
                case 504:
                    rb.message("GATEWAY_TIMEOUT");
                    rb.body(ResponseBody.create("", MediaType.get("text/plain")));
                    break;
                default:
                    rb.message(error);
                    rb.body(ResponseBody.create(
                            String.format("{\"error\":\"%s\", \"reason\":\"test error\"}", error),
                            MediaType.get("application/json")));
                    break;
            }
            return rb.build();
        }

        Class<? extends RuntimeException> getExceptionClass() {
            return getException().getClass();
        }

        RuntimeException getException() {
            okhttp3.Response.Builder rb = new okhttp3.Response.Builder();
            switch(this) {
                case TERMINAL_400:
                    return new BadRequestException(makeResponse(rb, 400, "bad_request"));
                case TERMINAL_401:
                    return new UnauthorizedException(makeResponse(rb, 401, "unauthorized"));
                case TERMINAL_403:
                    return new ForbiddenException(makeResponse(rb, 403, "forbidden"));
                case TERMINAL_404:
                    return new NotFoundException(makeResponse(rb, 404, "not_found"));
                case TRANSIENT_429:
                    return new TooManyRequestsException(makeResponse(rb, 429, "too_many_requests"));
                case TRANSIENT_500:
                    return new InternalServerErrorException(makeResponse(rb, 500, "internal_server_error"));
                case TRANSIENT_503:
                    return new ServiceUnavailableException(makeResponse(rb, 503, "service_unavailable"));
                case TRANSIENT_502:
                    return new ServiceResponseException(502, makeResponse(rb, 502, null));
                case TRANSIENT_504:
                    return new ServiceResponseException(504, makeResponse(rb, 504, null));
                case TRANSIENT_BAD_JSON:
                    return new InvalidServiceResponseException(makeResponse(rb, 200, null), "Bad request body", new MalformedJsonException("test bad json"));
                case TRANSIENT_IO:
                    return new RuntimeException("Bad IO", new IOException("test bad IO"));
                default:
                    return new RuntimeException("Unimplemented test exception");
            }
        }

        void throwException() throws RuntimeException {
            throw getException();
        }
    }

    /**
     * An instruction to return a result or an error
     */
    public static class MockInstruction<R> {

        private final MockError e;
        private final R result;

        public MockInstruction(MockError e) {
            this.e = e;
            this.result = null;
        }

        public MockInstruction(R result) {
            this.result = result;
            this.e = null;
        }

        R getResultOrThrow() {
            if (result != null) {
                return result;
            } else {
                e.throwException();
                return null;
            }
        }
    }

    protected final class MockServiceCall implements ServiceCall<R> {

        private final MockInstruction<R> mockI;
        private volatile boolean isCancelled = false;

        public MockServiceCall(MockInstruction<R> mockI) {
            this.mockI = mockI;
        }

        @Override
        public ServiceCall<R> addHeader(String name, String value) {
            throw new UnsupportedOperationException("NOT MOCKED");
        }

        @Override
        public Response<R> execute() throws RuntimeException {
            if (isCancelled) {
                throw new RuntimeException("Execution of MockServiceCall after cancellation.");                
            }
            return new Response<R>(mockI.getResultOrThrow(), SUCCESS_RESPONSE);
        }

        @Override
        public void enqueue(ServiceCallback<R> callback) {
            throw new UnsupportedOperationException("NOT MOCKED");
        }

        @Override
        public Single<Response<R>> reactiveRequest() {
            throw new UnsupportedOperationException("NOT MOCKED");
        }

        @Override
        public void cancel() {
            isCancelled = true;
            cancelledRequests.add(this);
        }
    }

    /**
     * A MockInstruction supplier that uses a queue.
     */
    public static class QueuedSupplier<R> implements Supplier<MockInstruction<R>> {

        protected final Collection<MockInstruction<R>> instructions;
        protected final Queue<MockInstruction<R>> q;

        protected QueuedSupplier(Collection<MockInstruction<R>> instructions) {
            this.instructions = instructions;
            this.q = new ArrayDeque<>(instructions);
        }

        @Override
        public MockInstruction<R> get() {
            try {
                return q.remove();
            } catch(NoSuchElementException e) {
                Assert.fail("Test error: no mock instruction available for request.");
                // The assert throw should take care of the exit, but the compiler
                // doesn't seem to notice.
                return null;
            }
        }
    }

}
