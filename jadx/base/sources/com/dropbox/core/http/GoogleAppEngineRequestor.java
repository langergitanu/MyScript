package com.dropbox.core.http;

import androidx.core.app.NotificationCompat;
import com.dropbox.core.http.HttpRequestor;
import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GoogleAppEngineRequestor extends HttpRequestor {
    private final FetchOptions options;
    private final URLFetchService service;

    public GoogleAppEngineRequestor() {
        this(newDefaultOptions());
    }

    public GoogleAppEngineRequestor(FetchOptions fetchOptions) {
        this(fetchOptions, URLFetchServiceFactory.getURLFetchService());
    }

    public GoogleAppEngineRequestor(FetchOptions fetchOptions, URLFetchService uRLFetchService) {
        if (fetchOptions == null) {
            throw new NullPointerException("options");
        }
        if (uRLFetchService == null) {
            throw new NullPointerException(NotificationCompat.CATEGORY_SERVICE);
        }
        this.options = fetchOptions;
        this.service = uRLFetchService;
    }

    public FetchOptions getOptions() {
        return this.options;
    }

    public URLFetchService getService() {
        return this.service;
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public HttpRequestor.Response doGet(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        return toRequestorResponse(this.service.fetch(newRequest(str, HTTPMethod.GET, iterable)));
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public HttpRequestor.Uploader startPost(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        return new FetchServiceUploader(this.service, newRequest(str, HTTPMethod.POST, iterable), new ByteArrayOutputStream());
    }

    @Override // com.dropbox.core.http.HttpRequestor
    public HttpRequestor.Uploader startPut(String str, Iterable<HttpRequestor.Header> iterable) throws IOException {
        return new FetchServiceUploader(this.service, newRequest(str, HTTPMethod.POST, iterable), new ByteArrayOutputStream());
    }

    private HTTPRequest newRequest(String str, HTTPMethod hTTPMethod, Iterable<HttpRequestor.Header> iterable) throws IOException {
        HTTPRequest hTTPRequest = new HTTPRequest(new URL(str), hTTPMethod, this.options);
        for (HttpRequestor.Header header : iterable) {
            hTTPRequest.addHeader(new HTTPHeader(header.getKey(), header.getValue()));
        }
        return hTTPRequest;
    }

    public static FetchOptions newDefaultOptions() {
        return FetchOptions.Builder.withDefaults().validateCertificate().doNotFollowRedirects().disallowTruncate().setDeadline(Double.valueOf((DEFAULT_CONNECT_TIMEOUT_MILLIS + DEFAULT_READ_TIMEOUT_MILLIS) / 1000.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HttpRequestor.Response toRequestorResponse(HTTPResponse hTTPResponse) {
        HashMap map = new HashMap();
        for (HTTPHeader hTTPHeader : hTTPResponse.getHeadersUncombined()) {
            List arrayList = (List) map.get(hTTPHeader.getName());
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(hTTPHeader.getName(), arrayList);
            }
            arrayList.add(hTTPHeader.getValue());
        }
        return new HttpRequestor.Response(hTTPResponse.getResponseCode(), new ByteArrayInputStream(hTTPResponse.getContent()), map);
    }

    private static class FetchServiceUploader extends HttpRequestor.Uploader {
        private final ByteArrayOutputStream body;
        private HTTPRequest request;
        private final URLFetchService service;

        public FetchServiceUploader(URLFetchService uRLFetchService, HTTPRequest hTTPRequest, ByteArrayOutputStream byteArrayOutputStream) {
            this.service = uRLFetchService;
            this.request = hTTPRequest;
            this.body = byteArrayOutputStream;
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public OutputStream getBody() {
            return this.body;
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void close() {
            if (this.request != null) {
                try {
                    this.body.close();
                } catch (IOException unused) {
                }
                this.request = null;
            }
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public void abort() {
            if (this.request == null) {
                throw new IllegalStateException("Uploader already closed.");
            }
            close();
        }

        @Override // com.dropbox.core.http.HttpRequestor.Uploader
        public HttpRequestor.Response finish() throws IOException {
            HTTPRequest hTTPRequest = this.request;
            if (hTTPRequest == null) {
                throw new IllegalStateException("Uploader already closed.");
            }
            hTTPRequest.setPayload(this.body.toByteArray());
            HttpRequestor.Response requestorResponse = GoogleAppEngineRequestor.toRequestorResponse(this.service.fetch(this.request));
            close();
            if (this.progressListener != null) {
                this.progressListener.onProgress(this.request.getPayload().length);
            }
            return requestorResponse;
        }
    }
}
