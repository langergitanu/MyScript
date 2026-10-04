package com.dropbox.core.p013v2;

import com.dropbox.core.BadResponseException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.InvalidAccessTokenException;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.RetryException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.oauth.DbxOAuthError;
import com.dropbox.core.oauth.DbxOAuthException;
import com.dropbox.core.oauth.DbxRefreshResult;
import com.dropbox.core.p013v2.auth.AuthError;
import com.dropbox.core.p013v2.common.PathRoot;
import com.dropbox.core.stone.StoneSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DbxRawClientV2 {
    private static final JsonFactory JSON = new JsonFactory();
    private static final Random RAND = new Random();
    public static final String USER_AGENT_ID = "OfficialDropboxJavaSDKv2";
    private final DbxHost host;
    private final PathRoot pathRoot;
    private final DbxRequestConfig requestConfig;
    private final String userId;

    private interface RetriableExecution<T> {
        T execute() throws DbxException, DbxWrappedException;
    }

    protected abstract void addAuthHeaders(List<HttpRequestor.Header> list);

    protected abstract boolean canRefreshAccessToken();

    protected abstract boolean needsRefreshAccessToken();

    public abstract DbxRefreshResult refreshAccessToken() throws DbxException;

    protected abstract DbxRawClientV2 withPathRoot(PathRoot pathRoot);

    protected DbxRawClientV2(DbxRequestConfig dbxRequestConfig, DbxHost dbxHost, String str, PathRoot pathRoot) {
        if (dbxRequestConfig == null) {
            throw new NullPointerException("requestConfig");
        }
        if (dbxHost == null) {
            throw new NullPointerException(DiagnosticsTracker.HOST_KEY);
        }
        this.requestConfig = dbxRequestConfig;
        this.host = dbxHost;
        this.userId = str;
        this.pathRoot = pathRoot;
    }

    private void refreshAccessTokenIfNeeded() throws DbxException {
        if (needsRefreshAccessToken()) {
            try {
                refreshAccessToken();
            } catch (DbxOAuthException e) {
                if (!DbxOAuthError.INVALID_GRANT.equals(e.getDbxOAuthError().getError())) {
                    throw e;
                }
            }
        }
    }

    public <ArgT, ResT, ErrT> ResT rpcStyle(final String str, final String str2, ArgT argt, final boolean z, StoneSerializer<ArgT> stoneSerializer, final StoneSerializer<ResT> stoneSerializer2, final StoneSerializer<ErrT> stoneSerializer3) throws DbxException, DbxWrappedException {
        final byte[] bArrWriteAsBytes = writeAsBytes(stoneSerializer, argt);
        final ArrayList arrayList = new ArrayList();
        if (!z) {
            refreshAccessTokenIfNeeded();
        }
        if (!this.host.getNotify().equals(str)) {
            DbxRequestUtil.addUserLocaleHeader(arrayList, this.requestConfig);
            DbxRequestUtil.addPathRootHeader(arrayList, this.pathRoot);
        }
        arrayList.add(new HttpRequestor.Header("Content-Type", "application/json; charset=utf-8"));
        return (ResT) executeRetriableWithRefresh(this.requestConfig.getMaxRetries(), new RetriableExecution<ResT>() { // from class: com.dropbox.core.v2.DbxRawClientV2.1
            private String userIdAnon;

            @Override // com.dropbox.core.v2.DbxRawClientV2.RetriableExecution
            public ResT execute() throws DbxException, DbxWrappedException {
                if (!z) {
                    DbxRawClientV2.this.addAuthHeaders(arrayList);
                }
                HttpRequestor.Response responseStartPostRaw = DbxRequestUtil.startPostRaw(DbxRawClientV2.this.requestConfig, DbxRawClientV2.USER_AGENT_ID, str, str2, bArrWriteAsBytes, arrayList);
                try {
                    int statusCode = responseStartPostRaw.getStatusCode();
                    if (statusCode == 200) {
                        return (ResT) stoneSerializer2.deserialize(responseStartPostRaw.getBody());
                    }
                    if (statusCode == 409) {
                        throw DbxWrappedException.fromResponse(stoneSerializer3, responseStartPostRaw, this.userIdAnon);
                    }
                    throw DbxRequestUtil.unexpectedStatus(responseStartPostRaw, this.userIdAnon);
                } catch (JsonProcessingException e) {
                    throw new BadResponseException(DbxRequestUtil.getRequestId(responseStartPostRaw), "Bad JSON: " + e.getMessage(), e);
                } catch (IOException e2) {
                    throw new NetworkIOException(e2);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public RetriableExecution<ResT> init(String str3) {
                this.userIdAnon = str3;
                return this;
            }
        }.init(this.userId));
    }

    public <ArgT, ResT, ErrT> DbxDownloader<ResT> downloadStyle(final String str, final String str2, ArgT argt, final boolean z, List<HttpRequestor.Header> list, StoneSerializer<ArgT> stoneSerializer, final StoneSerializer<ResT> stoneSerializer2, final StoneSerializer<ErrT> stoneSerializer3) throws DbxException, DbxWrappedException {
        final ArrayList arrayList = new ArrayList(list);
        if (!z) {
            refreshAccessTokenIfNeeded();
        }
        DbxRequestUtil.addUserLocaleHeader(arrayList, this.requestConfig);
        DbxRequestUtil.addPathRootHeader(arrayList, this.pathRoot);
        arrayList.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(stoneSerializer, argt)));
        arrayList.add(new HttpRequestor.Header("Content-Type", ""));
        final byte[] bArr = new byte[0];
        return (DbxDownloader) executeRetriableWithRefresh(this.requestConfig.getMaxRetries(), new RetriableExecution<DbxDownloader<ResT>>() { // from class: com.dropbox.core.v2.DbxRawClientV2.2
            private String userIdAnon;

            @Override // com.dropbox.core.v2.DbxRawClientV2.RetriableExecution
            public DbxDownloader<ResT> execute() throws DbxException, DbxWrappedException {
                if (!z) {
                    DbxRawClientV2.this.addAuthHeaders(arrayList);
                }
                HttpRequestor.Response responseStartPostRaw = DbxRequestUtil.startPostRaw(DbxRawClientV2.this.requestConfig, DbxRawClientV2.USER_AGENT_ID, str, str2, bArr, arrayList);
                String requestId = DbxRequestUtil.getRequestId(responseStartPostRaw);
                String contentType = DbxRequestUtil.getContentType(responseStartPostRaw);
                try {
                    int statusCode = responseStartPostRaw.getStatusCode();
                    if (statusCode != 200 && statusCode != 206) {
                        if (statusCode == 409) {
                            throw DbxWrappedException.fromResponse(stoneSerializer3, responseStartPostRaw, this.userIdAnon);
                        }
                        throw DbxRequestUtil.unexpectedStatus(responseStartPostRaw, this.userIdAnon);
                    }
                    List<String> list2 = responseStartPostRaw.getHeaders().get("dropbox-api-result");
                    if (list2 == null) {
                        throw new BadResponseException(requestId, "Missing Dropbox-API-Result header; " + responseStartPostRaw.getHeaders());
                    }
                    if (list2.size() == 0) {
                        throw new BadResponseException(requestId, "No Dropbox-API-Result header; " + responseStartPostRaw.getHeaders());
                    }
                    String str3 = list2.get(0);
                    if (str3 == null) {
                        throw new BadResponseException(requestId, "Null Dropbox-API-Result header; " + responseStartPostRaw.getHeaders());
                    }
                    return new DbxDownloader<>(stoneSerializer2.deserialize(str3), responseStartPostRaw.getBody(), contentType);
                } catch (JsonProcessingException e) {
                    throw new BadResponseException(requestId, "Bad JSON: " + e.getMessage(), e);
                } catch (IOException e2) {
                    throw new NetworkIOException(e2);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public RetriableExecution<DbxDownloader<ResT>> init(String str3) {
                this.userIdAnon = str3;
                return this;
            }
        }.init(this.userId));
    }

    private static <T> byte[] writeAsBytes(StoneSerializer<T> stoneSerializer, T t) throws DbxException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            stoneSerializer.serialize(t, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw LangUtil.mkAssert("Impossible", e);
        }
    }

    private static <T> String headerSafeJson(StoneSerializer<T> stoneSerializer, T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            JsonGenerator jsonGeneratorCreateGenerator = JSON.createGenerator(stringWriter);
            jsonGeneratorCreateGenerator.setHighestNonEscapedChar(WebSocketProtocol.PAYLOAD_SHORT);
            stoneSerializer.serialize(t, jsonGeneratorCreateGenerator);
            jsonGeneratorCreateGenerator.flush();
            return stringWriter.toString();
        } catch (IOException e) {
            throw LangUtil.mkAssert("Impossible", e);
        }
    }

    public <ArgT> HttpRequestor.Uploader uploadStyle(String str, String str2, ArgT argt, boolean z, StoneSerializer<ArgT> stoneSerializer) throws DbxException {
        String strBuildUri = DbxRequestUtil.buildUri(str, str2);
        ArrayList arrayList = new ArrayList();
        if (!z) {
            refreshAccessTokenIfNeeded();
            addAuthHeaders(arrayList);
        }
        DbxRequestUtil.addUserLocaleHeader(arrayList, this.requestConfig);
        DbxRequestUtil.addPathRootHeader(arrayList, this.pathRoot);
        arrayList.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        List<HttpRequestor.Header> listAddUserAgentHeader = DbxRequestUtil.addUserAgentHeader(arrayList, this.requestConfig, USER_AGENT_ID);
        listAddUserAgentHeader.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(stoneSerializer, argt)));
        try {
            return this.requestConfig.getHttpRequestor().startPostInStreamingMode(strBuildUri, listAddUserAgentHeader);
        } catch (IOException e) {
            throw new NetworkIOException(e);
        }
    }

    public DbxRequestConfig getRequestConfig() {
        return this.requestConfig;
    }

    public DbxHost getHost() {
        return this.host;
    }

    public String getUserId() {
        return this.userId;
    }

    private static <T> T executeRetriable(int i, RetriableExecution<T> retriableExecution) throws DbxException, DbxWrappedException {
        if (i == 0) {
            return retriableExecution.execute();
        }
        int i2 = 0;
        while (true) {
            try {
                return retriableExecution.execute();
            } catch (RetryException e) {
                if (i2 < i) {
                    i2++;
                    sleepQuietlyWithJitter(e.getBackoffMillis());
                } else {
                    throw e;
                }
            }
        }
    }

    private <T> T executeRetriableWithRefresh(int i, RetriableExecution<T> retriableExecution) throws DbxException, DbxWrappedException {
        try {
            return (T) executeRetriable(i, retriableExecution);
        } catch (InvalidAccessTokenException e) {
            if (e.getMessage() == null) {
                throw e;
            }
            if (AuthError.EXPIRED_ACCESS_TOKEN.equals(e.getAuthError()) && canRefreshAccessToken()) {
                refreshAccessToken();
                return (T) executeRetriable(i, retriableExecution);
            }
            throw e;
        }
    }

    private static void sleepQuietlyWithJitter(long j) {
        long jNextInt = j + ((long) RAND.nextInt(1000));
        if (jNextInt <= 0) {
            return;
        }
        try {
            Thread.sleep(jNextInt);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
