package com.dropbox.core.http;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.http.OkHttpUtil;
import com.dropbox.core.util.IOUtil;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: loaded from: classes4.dex */
public class OkHttp3Requestor extends HttpRequestor {
    private final OkHttpClient client;

    protected void configureRequest(Request.Builder builder) {
    }

    protected Response interceptResponse(Response response) {
        return response;
    }

    public static OkHttpClient defaultOkHttpClient() {
        return defaultOkHttpClientBuilder().build();
    }

    public static OkHttpClient.Builder defaultOkHttpClientBuilder() {
        return new OkHttpClient.Builder().connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS).readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS).writeTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
    }

    public OkHttp3Requestor(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            throw new NullPointerException("client");
        }
        OkHttpUtil.assertNotSameThreadExecutor(okHttpClient.dispatcher().executorService());
        this.client = okHttpClient;
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
            this.callback = new AsyncCallback(pipedRequestBody);
            Call callNewCall = OkHttp3Requestor.this.client.newCall(this.request.build());
            this.call = callNewCall;
            callNewCall.enqueue(this.callback);
            return pipedRequestBody.getOutputStream();
        }

        private void setBody(RequestBody requestBody) {
            assertNoBody();
            this.body = requestBody;
            this.request.method(this.method, requestBody);
            OkHttp3Requestor.this.configureRequest(this.request);
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void upload(File file) {
            setBody(RequestBody.INSTANCE.create(file, (MediaType) null));
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void upload(byte[] bArr) {
            setBody(RequestBody.INSTANCE.create(bArr, (MediaType) null));
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void close() {
            Object obj = this.body;
            if (obj != null && (obj instanceof Closeable)) {
                try {
                    ((Closeable) obj).close();
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
                Call callNewCall = OkHttp3Requestor.this.client.newCall(this.request.build());
                this.call = callNewCall;
                response = callNewCall.execute();
            } else {
                try {
                    getBody().close();
                } catch (IOException unused) {
                }
                response = this.callback.getResponse();
            }
            Response responseInterceptResponse = OkHttp3Requestor.this.interceptResponse(response);
            return new HttpRequestor.Response(responseInterceptResponse.code(), responseInterceptResponse.body().byteStream(), OkHttp3Requestor.fromOkHttpHeaders(responseInterceptResponse.headers()));
        }
    }

    public static final class AsyncCallback implements Callback {
        private PipedRequestBody body;
        private IOException error;
        private Response response;

        private AsyncCallback(PipedRequestBody pipedRequestBody) {
            this.body = pipedRequestBody;
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

        @Override // okhttp3.Callback
        public synchronized void onFailure(Call call, IOException iOException) {
            this.error = iOException;
            this.body.close();
            notifyAll();
        }

        @Override // okhttp3.Callback
        public synchronized void onResponse(Call call, Response response) throws IOException {
            this.response = response;
            notifyAll();
        }
    }

    private static class PipedRequestBody extends RequestBody implements Closeable {
        private IOUtil.ProgressListener listener;
        private final OkHttpUtil.PipedStream stream = new OkHttpUtil.PipedStream();

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return -1L;
        }

        @Override // okhttp3.RequestBody
        /* JADX INFO: renamed from: contentType */
        public MediaType getContentType() {
            return null;
        }

        @Override // okhttp3.RequestBody
        public boolean isOneShot() {
            return true;
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

        @Override // okhttp3.RequestBody
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
