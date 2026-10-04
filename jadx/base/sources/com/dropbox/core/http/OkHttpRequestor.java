package com.dropbox.core.http;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.http.OkHttpUtil;
import com.dropbox.core.util.IOUtil;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: loaded from: classes4.dex */
public class OkHttpRequestor extends HttpRequestor {
    private final OkHttpClient client;

    protected void configureRequest(Request.Builder builder) {
    }

    protected Response interceptResponse(Response response) {
        return response;
    }

    public static OkHttpClient defaultOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public OkHttpRequestor(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            throw new NullPointerException("client");
        }
        OkHttpUtil.assertNotSameThreadExecutor(okHttpClient.getDispatcher().getExecutorService());
        this.client = okHttpClient.clone();
    }

    public OkHttpClient getClient() {
        return this.client;
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public HttpRequestor.Response doGet(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        Request.Builder builderUrl = new Request.Builder().get().url(str);
        toOkHttpHeaders(iterable, builderUrl);
        configureRequest(builderUrl);
        Response responseInterceptResponse = interceptResponse(this.client.newCall(builderUrl.build()).execute());
        return new HttpRequestor.Response(responseInterceptResponse.code(), responseInterceptResponse.body().byteStream(), fromOkHttpHeaders(responseInterceptResponse.headers()));
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public HttpRequestor.Uploader startPost(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        return startUpload(str, iterable, "POST");
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public HttpRequestor.Uploader startPut(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        return startUpload(str, iterable, "PUT");
    }

    private BufferedUploader startUpload(String str, Iterable<HttpRequestor.Header> iterable, String str2) {
        Request.Builder builderUrl = new Request.Builder().url(str);
        toOkHttpHeaders(iterable, builderUrl);
        return new BufferedUploader(str2, builderUrl);
    }

    private static void toOkHttpHeaders(Iterable<HttpRequestor.Header> iterable, Request.Builder builder) {
        for (HttpRequestor.Header header : iterable) {
            builder.addHeader(header.getKey(), header.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<String>> fromOkHttpHeaders(Headers headers) {
        HashMap map = new HashMap(headers.size());
        for (String str : headers.names()) {
            map.put(str, headers.values(str));
        }
        return map;
    }

    private class BufferedUploader extends HttpRequestor.Uploader {
        private final String method;
        private final Request.Builder request;
        private RequestBody body = null;
        private Call call = null;
        private AsyncCallback callback = null;
        private boolean closed = false;
        private boolean cancelled = false;

        public BufferedUploader(String str, Request.Builder builder) {
            this.method = str;
            this.request = builder;
        }

        private void assertNoBody() {
            if (this.body != null) {
                throw new IllegalStateException("Request body already set.");
            }
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public OutputStream getBody() {
            RequestBody requestBody = this.body;
            if (requestBody instanceof PipedRequestBody) {
                return ((PipedRequestBody) requestBody).getOutputStream();
            }
            PipedRequestBody pipedRequestBody = new PipedRequestBody();
            if (this.progressListener != null) {
                pipedRequestBody.setListener(this.progressListener);
            }
            setBody(pipedRequestBody);
            this.callback = new AsyncCallback();
            Call callNewCall = OkHttpRequestor.this.client.newCall(this.request.build());
            this.call = callNewCall;
            callNewCall.enqueue(this.callback);
            return pipedRequestBody.getOutputStream();
        }

        private void setBody(RequestBody requestBody) {
            assertNoBody();
            this.body = requestBody;
            this.request.method(this.method, requestBody);
            OkHttpRequestor.this.configureRequest(this.request);
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void upload(File file) {
            setBody(RequestBody.create((MediaType) null, file));
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void upload(byte[] bArr) {
            setBody(RequestBody.create((MediaType) null, bArr));
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void close() {
            Closeable closeable = this.body;
            if (closeable != null && (closeable instanceof Closeable)) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
            this.closed = true;
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void abort() {
            Call call = this.call;
            if (call != null) {
                call.cancel();
            }
            this.cancelled = true;
            close();
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public HttpRequestor.Response finish() throws IOException {
            Response response;
            if (this.cancelled) {
                throw new IllegalStateException("Already aborted");
            }
            if (this.body == null) {
                upload(new byte[0]);
            }
            if (this.callback == null) {
                Call callNewCall = OkHttpRequestor.this.client.newCall(this.request.build());
                this.call = callNewCall;
                response = callNewCall.execute();
            } else {
                try {
                    getBody().close();
                } catch (IOException unused) {
                }
                response = this.callback.getResponse();
            }
            Response responseInterceptResponse = OkHttpRequestor.this.interceptResponse(response);
            return new HttpRequestor.Response(responseInterceptResponse.code(), responseInterceptResponse.body().byteStream(), OkHttpRequestor.fromOkHttpHeaders(responseInterceptResponse.headers()));
        }
    }

    public static final class AsyncCallback implements Callback {
        private IOException error;
        private Response response;

        private AsyncCallback() {
            this.error = null;
            this.response = null;
        }

        public synchronized Response getResponse() throws IOException {
            IOException iOException;
            while (true) {
                iOException = this.error;
                if (iOException != null || this.response != null) {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            }
            if (iOException != null) {
                throw iOException;
            }
            return this.response;
        }

        public synchronized void onFailure(Request request, IOException iOException) {
            this.error = iOException;
            notifyAll();
        }

        public synchronized void onResponse(Response response) throws IOException {
            this.response = response;
            notifyAll();
        }
    }

    private static class PipedRequestBody extends RequestBody implements Closeable {
        private IOUtil.ProgressListener listener;
        private final OkHttpUtil.PipedStream stream = new OkHttpUtil.PipedStream();

        public long contentLength() {
            return -1L;
        }

        public MediaType contentType() {
            return null;
        }

        public void setListener(IOUtil.ProgressListener progressListener) {
            this.listener = progressListener;
        }

        public OutputStream getOutputStream() {
            return this.stream.getOutputStream();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.stream.close();
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            BufferedSink bufferedSinkBuffer = Okio.buffer(new CountingSink(bufferedSink));
            this.stream.writeTo(bufferedSinkBuffer);
            bufferedSinkBuffer.flush();
            close();
        }

        private final class CountingSink extends ForwardingSink {
            private long bytesWritten;

            public CountingSink(Sink sink) {
                super(sink);
                this.bytesWritten = 0L;
            }

            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer buffer, long j) throws IOException {
                super.write(buffer, j);
                this.bytesWritten += j;
                if (PipedRequestBody.this.listener != null) {
                    PipedRequestBody.this.listener.onProgress(this.bytesWritten);
                }
            }
        }
    }
}
