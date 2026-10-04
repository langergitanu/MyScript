package com.dropbox.core.http;

import androidx.collection.SieveCacheKt;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.ProgressOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes4.dex */
public class StandardHttpRequestor extends HttpRequestor {
    private final Config config;
    private static final Logger LOGGER = Logger.getLogger(StandardHttpRequestor.class.getCanonicalName());
    public static final StandardHttpRequestor INSTANCE = new StandardHttpRequestor(Config.DEFAULT_INSTANCE);
    private static volatile boolean certPinningWarningLogged = false;

    protected void configure(HttpURLConnection httpURLConnection) throws IOException {
    }

    @Deprecated
    protected void configureConnection(HttpsURLConnection httpsURLConnection) throws IOException {
    }

    protected void interceptResponse(HttpURLConnection httpURLConnection) throws IOException {
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public /* bridge */ /* synthetic */ HttpRequestor.Uploader startPost(String str, Iterable iterable) throws IOException {
        return startPost(str, (Iterable<HttpRequestor.Header>) iterable);
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public /* bridge */ /* synthetic */ HttpRequestor.Uploader startPostInStreamingMode(String str, Iterable iterable) throws IOException {
        return startPostInStreamingMode(str, (Iterable<HttpRequestor.Header>) iterable);
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public /* bridge */ /* synthetic */ HttpRequestor.Uploader startPut(String str, Iterable iterable) throws IOException {
        return startPut(str, (Iterable<HttpRequestor.Header>) iterable);
    }

    public StandardHttpRequestor(Config config) {
        this.config = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpRequestor.Response toResponse(HttpURLConnection httpURLConnection) throws IOException {
        InputStream errorStream;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 400 || responseCode == -1) {
            errorStream = httpURLConnection.getErrorStream();
        } else {
            errorStream = httpURLConnection.getInputStream();
        }
        interceptResponse(httpURLConnection);
        return new HttpRequestor.Response(responseCode, errorStream, httpURLConnection.getHeaderFields());
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public HttpRequestor.Response doGet(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        HttpURLConnection httpURLConnectionPrepRequest = prepRequest(str, iterable, false);
        httpURLConnectionPrepRequest.setRequestMethod("GET");
        httpURLConnectionPrepRequest.connect();
        return toResponse(httpURLConnectionPrepRequest);
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public Uploader startPost(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        HttpURLConnection httpURLConnectionPrepRequest = prepRequest(str, iterable, false);
        httpURLConnectionPrepRequest.setRequestMethod("POST");
        return new Uploader(httpURLConnectionPrepRequest);
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public Uploader startPostInStreamingMode(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        HttpURLConnection httpURLConnectionPrepRequest = prepRequest(str, iterable, true);
        httpURLConnectionPrepRequest.setRequestMethod("POST");
        return new Uploader(httpURLConnectionPrepRequest);
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public Uploader startPut(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        HttpURLConnection httpURLConnectionPrepRequest = prepRequest(str, iterable, false);
        httpURLConnectionPrepRequest.setRequestMethod("PUT");
        return new Uploader(httpURLConnectionPrepRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OutputStream getOutputStream(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.setDoOutput(true);
        return httpURLConnection.getOutputStream();
    }

    private class Uploader extends HttpRequestor.Uploader {
        private HttpURLConnection conn;
        private final ProgressOutputStream out;

        public Uploader(HttpURLConnection httpURLConnection) throws IOException {
            this.conn = httpURLConnection;
            this.out = new ProgressOutputStream(StandardHttpRequestor.getOutputStream(httpURLConnection));
            httpURLConnection.connect();
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public OutputStream getBody() {
            return this.out;
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void abort() {
            HttpURLConnection httpURLConnection = this.conn;
            if (httpURLConnection == null) {
                throw new IllegalStateException("Can't abort().  Uploader already closed.");
            }
            httpURLConnection.disconnect();
            this.conn = null;
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void close() {
            HttpURLConnection httpURLConnection = this.conn;
            if (httpURLConnection == null) {
                return;
            }
            if (httpURLConnection.getDoOutput()) {
                try {
                    IOUtil.closeQuietly(this.conn.getOutputStream());
                } catch (IOException unused) {
                }
            }
            this.conn = null;
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public HttpRequestor.Response finish() throws IOException {
            HttpURLConnection httpURLConnection = this.conn;
            if (httpURLConnection != null) {
                try {
                    return StandardHttpRequestor.this.toResponse(httpURLConnection);
                } finally {
                    this.conn = null;
                }
            }
            throw new IllegalStateException("Can't finish().  Uploader already closed.");
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void setProgressListener(IOUtil.ProgressListener progressListener) {
            this.out.setListener(progressListener);
        }
    }

    protected HttpURLConnection prepRequest(String str, Iterable<HttpRequestor.Header> iterable, boolean z) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection(this.config.getProxy());
        httpURLConnection.setConnectTimeout((int) this.config.getConnectTimeoutMillis());
        httpURLConnection.setReadTimeout((int) this.config.getReadTimeoutMillis());
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        if (z) {
            httpURLConnection.setChunkedStreamingMode(16384);
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            if (this.config.getSslSocketFactory() != null) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.config.getSslSocketFactory());
            }
            configureConnection((HttpsURLConnection) httpURLConnection);
        } else if (this.config.getSslSocketFactory() != null) {
            logCertificatePinningWarning();
        }
        configure(httpURLConnection);
        for (HttpRequestor.Header header : iterable) {
            httpURLConnection.addRequestProperty(header.getKey(), header.getValue());
        }
        return httpURLConnection;
    }

    private static void logCertificatePinningWarning() {
        if (certPinningWarningLogged) {
            return;
        }
        certPinningWarningLogged = true;
        LOGGER.warning("Certificate pinning disabled for HTTPS connections. This is likely because your JRE does not return javax.net.ssl.HttpsURLConnection objects for https network connections. Be aware your app may be prone to man-in-the-middle attacks without proper SSL certificate validation. If you are using Google App Engine, please configure DbxRequestConfig to use GoogleAppEngineRequestor.");
    }

    public static final class Config {
        public static final Config DEFAULT_INSTANCE = builder().build();
        private final long connectTimeoutMillis;
        private final Proxy proxy;
        private final long readTimeoutMillis;
        private final SSLSocketFactory sslSocketFactory;

        private Config(Proxy proxy, long j, long j2, SSLSocketFactory sSLSocketFactory) {
            this.proxy = proxy;
            this.connectTimeoutMillis = j;
            this.readTimeoutMillis = j2;
            this.sslSocketFactory = sSLSocketFactory;
        }

        public Proxy getProxy() {
            return this.proxy;
        }

        public long getConnectTimeoutMillis() {
            return this.connectTimeoutMillis;
        }

        public long getReadTimeoutMillis() {
            return this.readTimeoutMillis;
        }

        @Nullable
        public SSLSocketFactory getSslSocketFactory() {
            return this.sslSocketFactory;
        }

        public Builder copy() {
            return new Builder(this.proxy, this.connectTimeoutMillis, this.readTimeoutMillis, this.sslSocketFactory);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static final class Builder {
            private long connectTimeoutMillis;
            private Proxy proxy;
            private long readTimeoutMillis;
            private SSLSocketFactory sslSocketFactory;

            private Builder() {
                this(Proxy.NO_PROXY, HttpRequestor.DEFAULT_CONNECT_TIMEOUT_MILLIS, HttpRequestor.DEFAULT_READ_TIMEOUT_MILLIS, null);
            }

            private Builder(Proxy proxy, long j, long j2, SSLSocketFactory sSLSocketFactory) {
                this.proxy = proxy;
                this.connectTimeoutMillis = j;
                this.readTimeoutMillis = j2;
                this.sslSocketFactory = sSLSocketFactory;
            }

            public Builder withProxy(Proxy proxy) {
                if (proxy == null) {
                    throw new NullPointerException("proxy");
                }
                this.proxy = proxy;
                return this;
            }

            public Builder withNoConnectTimeout() {
                return withConnectTimeout(0L, TimeUnit.MILLISECONDS);
            }

            public Builder withConnectTimeout(long j, TimeUnit timeUnit) {
                this.connectTimeoutMillis = checkTimeoutMillis(j, timeUnit);
                return this;
            }

            public Builder withNoReadTimeout() {
                return withReadTimeout(0L, TimeUnit.MILLISECONDS);
            }

            public Builder withReadTimeout(long j, TimeUnit timeUnit) {
                this.readTimeoutMillis = checkTimeoutMillis(j, timeUnit);
                return this;
            }

            public Builder withSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
                this.sslSocketFactory = sSLSocketFactory;
                return this;
            }

            public Config build() {
                return new Config(this.proxy, this.connectTimeoutMillis, this.readTimeoutMillis, this.sslSocketFactory);
            }

            private static long checkTimeoutMillis(long j, TimeUnit timeUnit) {
                if (timeUnit == null) {
                    throw new NullPointerException("unit");
                }
                if (j < 0) {
                    throw new IllegalArgumentException("timeout must be non-negative");
                }
                long millis = timeUnit.toMillis(j);
                if (SieveCacheKt.NodeLinkMask >= millis) {
                    return millis;
                }
                throw new IllegalArgumentException("timeout too large, must be less than: 2147483647");
            }
        }
    }
}
