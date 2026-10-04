package com.dropbox.core;

import androidx.autofill.HintConstants;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.webkit.ProxyConfig;
import com.dropbox.core.ApiErrorResponse;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.p013v2.auth.AccessError;
import com.dropbox.core.p013v2.auth.AuthError;
import com.dropbox.core.p013v2.callbacks.DbxGlobalCallbackFactory;
import com.dropbox.core.p013v2.common.PathRoot;
import com.dropbox.core.p013v2.common.PathRootError;
import com.dropbox.core.stone.StoneSerializer;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.util.StringUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxRequestUtil {
    private static final Random RAND = new Random();
    public static DbxGlobalCallbackFactory sharedCallbackFactory;

    public static abstract class RequestMaker<T, E extends Throwable> {
        public abstract T run() throws Throwable;
    }

    public static abstract class ResponseHandler<T> {
        public abstract T handle(HttpRequestor.Response response) throws DbxException;
    }

    public static String encodeUrlParam(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw LangUtil.mkAssert("UTF-8 should always be supported", e);
        }
    }

    public static String buildUrlWithParams(String str, String str2, String str3, String[] strArr) {
        return buildUri(str2, str3) + "?" + encodeUrlParams(str, strArr);
    }

    public static String[] toParamsArray(Map<String, String> map) {
        String[] strArr = new String[map.size() * 2];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr[i] = entry.getKey();
            strArr[i + 1] = entry.getValue();
            i += 2;
        }
        return strArr;
    }

    public static String buildUri(String str, String str2) {
        try {
            return new URI(ProxyConfig.MATCH_HTTPS, str, DomExceptionUtils.SEPARATOR + str2, null).toASCIIString();
        } catch (URISyntaxException e) {
            throw LangUtil.mkAssert("URI creation failed, host=" + StringUtil.m531jq(str) + ", path=" + StringUtil.m531jq(str2), e);
        }
    }

    private static String encodeUrlParams(String str, String[] strArr) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str2 = "";
        } else {
            sb.append("locale=").append(encodeUrlParam(str));
            str2 = "&";
        }
        if (strArr != null) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("'params.length' is " + strArr.length + "; expecting a multiple of two");
            }
            for (int i = 0; i < strArr.length; i += 2) {
                String str3 = strArr[i];
                String str4 = strArr[i + 1];
                if (str3 == null) {
                    throw new IllegalArgumentException("params[" + i + "] is null");
                }
                if (str4 != null) {
                    sb.append(str2);
                    sb.append(encodeUrlParam(str3));
                    sb.append("=");
                    sb.append(encodeUrlParam(str4));
                    str2 = "&";
                }
            }
        }
        return sb.toString();
    }

    public static List<HttpRequestor.Header> addAuthHeader(List<HttpRequestor.Header> list, String str) {
        if (str == null) {
            throw new NullPointerException("accessToken");
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new HttpRequestor.Header("Authorization", "Bearer " + str));
        return list;
    }

    public static List<HttpRequestor.Header> addSelectUserHeader(List<HttpRequestor.Header> list, String str) {
        if (str == null) {
            throw new NullPointerException("memberId");
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new HttpRequestor.Header("Dropbox-API-Select-User", str));
        return list;
    }

    public static List<HttpRequestor.Header> addSelectAdminHeader(List<HttpRequestor.Header> list, String str) {
        if (str == null) {
            throw new NullPointerException("adminId");
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new HttpRequestor.Header("Dropbox-API-Select-Admin", str));
        return list;
    }

    public static List<HttpRequestor.Header> addBasicAuthHeader(List<HttpRequestor.Header> list, String str, String str2) {
        if (str == null) {
            throw new NullPointerException(HintConstants.AUTOFILL_HINT_USERNAME);
        }
        if (str2 == null) {
            throw new NullPointerException(HintConstants.AUTOFILL_HINT_PASSWORD);
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new HttpRequestor.Header("Authorization", "Basic " + StringUtil.base64Encode(StringUtil.stringToUtf8(str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2))));
        return list;
    }

    public static List<HttpRequestor.Header> addUserAgentHeader(List<HttpRequestor.Header> list, DbxRequestConfig dbxRequestConfig, String str) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(buildUserAgentHeader(dbxRequestConfig, str));
        return list;
    }

    public static List<HttpRequestor.Header> addUserLocaleHeader(List<HttpRequestor.Header> list, DbxRequestConfig dbxRequestConfig) {
        if (dbxRequestConfig.getUserLocale() == null) {
            return list;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new HttpRequestor.Header("Dropbox-API-User-Locale", dbxRequestConfig.getUserLocale()));
        return list;
    }

    public static HttpRequestor.Header buildUserAgentHeader(DbxRequestConfig dbxRequestConfig, String str) {
        return new HttpRequestor.Header("User-Agent", dbxRequestConfig.getClientIdentifier() + " " + str + "/7.0.0");
    }

    public static List<HttpRequestor.Header> addPathRootHeader(List<HttpRequestor.Header> list, PathRoot pathRoot) {
        if (pathRoot == null) {
            return list;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new HttpRequestor.Header("Dropbox-API-Path-Root", pathRoot.toString()));
        return list;
    }

    public static List<HttpRequestor.Header> removeAuthHeader(List<HttpRequestor.Header> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (HttpRequestor.Header header : list) {
            if ("Authorization".equals(header.getKey())) {
                arrayList.add(header);
            }
        }
        list.removeAll(arrayList);
        return list;
    }

    public static HttpRequestor.Response startGet(DbxRequestConfig dbxRequestConfig, String str, String str2, String str3, String str4, String[] strArr, List<HttpRequestor.Header> list) throws NetworkIOException {
        List<HttpRequestor.Header> listAddAuthHeader = addAuthHeader(addUserAgentHeader(copyHeaders(list), dbxRequestConfig, str2), str);
        try {
            return dbxRequestConfig.getHttpRequestor().doGet(buildUrlWithParams(dbxRequestConfig.getUserLocale(), str3, str4, strArr), listAddAuthHeader);
        } catch (IOException e) {
            throw new NetworkIOException(e);
        }
    }

    public static HttpRequestor.Uploader startPut(DbxRequestConfig dbxRequestConfig, String str, String str2, String str3, String str4, String[] strArr, List<HttpRequestor.Header> list) throws NetworkIOException {
        List<HttpRequestor.Header> listAddAuthHeader = addAuthHeader(addUserAgentHeader(copyHeaders(list), dbxRequestConfig, str2), str);
        try {
            return dbxRequestConfig.getHttpRequestor().startPut(buildUrlWithParams(dbxRequestConfig.getUserLocale(), str3, str4, strArr), listAddAuthHeader);
        } catch (IOException e) {
            throw new NetworkIOException(e);
        }
    }

    public static HttpRequestor.Response startPostNoAuth(DbxRequestConfig dbxRequestConfig, String str, String str2, String str3, String[] strArr, List<HttpRequestor.Header> list) throws NetworkIOException {
        byte[] bArrStringToUtf8 = StringUtil.stringToUtf8(encodeUrlParams(dbxRequestConfig.getUserLocale(), strArr));
        List<HttpRequestor.Header> listCopyHeaders = copyHeaders(list);
        listCopyHeaders.add(new HttpRequestor.Header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
        return startPostRaw(dbxRequestConfig, str, str2, str3, bArrStringToUtf8, listCopyHeaders);
    }

    public static HttpRequestor.Response startPostRaw(DbxRequestConfig dbxRequestConfig, String str, String str2, String str3, byte[] bArr, List<HttpRequestor.Header> list) throws NetworkIOException {
        String strBuildUri = buildUri(str2, str3);
        List<HttpRequestor.Header> listAddUserAgentHeader = addUserAgentHeader(copyHeaders(list), dbxRequestConfig, str);
        listAddUserAgentHeader.add(new HttpRequestor.Header("Content-Length", Integer.toString(bArr.length)));
        try {
            HttpRequestor.Uploader uploaderStartPost = dbxRequestConfig.getHttpRequestor().startPost(strBuildUri, listAddUserAgentHeader);
            try {
                uploaderStartPost.upload(bArr);
                return uploaderStartPost.finish();
            } finally {
                uploaderStartPost.close();
            }
        } catch (IOException e) {
            throw new NetworkIOException(e);
        }
    }

    private static List<HttpRequestor.Header> copyHeaders(List<HttpRequestor.Header> list) {
        if (list == null) {
            return new ArrayList();
        }
        return new ArrayList(list);
    }

    public static byte[] loadErrorBody(HttpRequestor.Response response) throws NetworkIOException {
        if (response.getBody() == null) {
            return new byte[0];
        }
        try {
            return IOUtil.slurp(response.getBody(), 4096);
        } catch (IOException e) {
            throw new NetworkIOException(e);
        }
    }

    public static String parseErrorBody(String str, int i, byte[] bArr) throws BadResponseException {
        try {
            return StringUtil.utf8ToString(bArr);
        } catch (CharacterCodingException e) {
            throw new BadResponseException(str, "Got non-UTF8 response body: " + i + ": " + e.getMessage());
        }
    }

    public static DbxException unexpectedStatus(HttpRequestor.Response response) throws NetworkIOException, BadResponseException {
        return unexpectedStatus(response, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[Catch: NumberFormatException -> 0x0075, TRY_LEAVE, TryCatch #2 {NumberFormatException -> 0x0075, blocks: (B:19:0x0056, B:21:0x0060, B:22:0x006e), top: B:67:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DbxException unexpectedStatus(HttpRequestor.Response response, String str) throws NetworkIOException, BadResponseException {
        DbxException badRequestException;
        String requestId = getRequestId(response);
        int statusCode = response.getStatusCode();
        if (statusCode == 400) {
            badRequestException = new BadRequestException(requestId, messageFromResponse(response, requestId));
        } else if (statusCode != 401) {
            if (statusCode == 403) {
                try {
                    ApiErrorResponse apiErrorResponseDeserialize = new ApiErrorResponse.Serializer(AccessError.Serializer.INSTANCE).deserialize(response.getBody());
                    badRequestException = new AccessErrorException(requestId, apiErrorResponseDeserialize.getUserMessage() != null ? apiErrorResponseDeserialize.getUserMessage().toString() : null, (AccessError) apiErrorResponseDeserialize.getError());
                } catch (JsonProcessingException e) {
                    throw new BadResponseException(requestId, "Bad JSON: " + e.getMessage(), e);
                } catch (IOException e2) {
                    throw new NetworkIOException(e2);
                }
            } else if (statusCode == 422) {
                try {
                    ApiErrorResponse apiErrorResponseDeserialize2 = new ApiErrorResponse.Serializer(PathRootError.Serializer.INSTANCE).deserialize(response.getBody());
                    badRequestException = new PathRootErrorException(requestId, apiErrorResponseDeserialize2.getUserMessage() != null ? apiErrorResponseDeserialize2.getUserMessage().toString() : null, (PathRootError) apiErrorResponseDeserialize2.getError());
                } catch (JsonProcessingException e3) {
                    throw new BadResponseException(requestId, "Bad JSON: " + e3.getMessage(), e3);
                } catch (IOException e4) {
                    throw new NetworkIOException(e4);
                }
            } else if (statusCode == 429) {
                try {
                    badRequestException = new RateLimitException(requestId, null, Integer.parseInt(getFirstHeader(response, "Retry-After")), TimeUnit.SECONDS);
                } catch (NumberFormatException unused) {
                    badRequestException = new BadResponseException(requestId, "Invalid value for HTTP header: \"Retry-After\"");
                }
            } else if (statusCode == 500) {
                badRequestException = new ServerException(requestId, null);
            } else if (statusCode == 503) {
                String firstHeaderMaybe = getFirstHeaderMaybe(response, "Retry-After");
                if (firstHeaderMaybe != null) {
                    try {
                        if (!firstHeaderMaybe.trim().isEmpty()) {
                            badRequestException = new RetryException(requestId, null, Integer.parseInt(firstHeaderMaybe), TimeUnit.SECONDS);
                        } else {
                            badRequestException = new RetryException(requestId, null);
                        }
                    } catch (NumberFormatException unused2) {
                        badRequestException = new BadResponseException(requestId, "Invalid value for HTTP header: \"Retry-After\"");
                    }
                }
            } else {
                badRequestException = new BadResponseCodeException(requestId, "unexpected HTTP status code: " + response.getStatusCode() + ": null", response.getStatusCode());
            }
        } else {
            String strMessageFromResponse = messageFromResponse(response, requestId);
            if (strMessageFromResponse.isEmpty()) {
                badRequestException = new InvalidAccessTokenException(requestId, strMessageFromResponse, AuthError.INVALID_ACCESS_TOKEN);
            } else {
                try {
                    badRequestException = new InvalidAccessTokenException(requestId, strMessageFromResponse, (AuthError) new ApiErrorResponse.Serializer(AuthError.Serializer.INSTANCE).deserialize(strMessageFromResponse).getError());
                } catch (JsonParseException e5) {
                    throw new BadResponseException(requestId, "Bad JSON: " + e5.getMessage(), e5);
                }
            }
        }
        DbxGlobalCallbackFactory dbxGlobalCallbackFactory = sharedCallbackFactory;
        if (dbxGlobalCallbackFactory != null) {
            dbxGlobalCallbackFactory.createNetworkErrorCallback(str).onNetworkError(badRequestException);
        }
        return badRequestException;
    }

    private static String messageFromResponse(HttpRequestor.Response response, String str) throws NetworkIOException, BadResponseException {
        return parseErrorBody(str, response.getStatusCode(), loadErrorBody(response));
    }

    public static <T> T readJsonFromResponse(JsonReader<T> jsonReader, HttpRequestor.Response response) throws NetworkIOException, BadResponseException {
        try {
            return jsonReader.readFully(response.getBody());
        } catch (JsonReadException e) {
            throw new BadResponseException(getRequestId(response), "error in response JSON: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new NetworkIOException(e2);
        }
    }

    public static <T> T readJsonFromErrorMessage(StoneSerializer<T> stoneSerializer, String str, String str2) throws JsonParseException {
        return new ApiErrorResponse.Serializer(stoneSerializer).deserialize(str).getError();
    }

    public static <T> T doGet(final DbxRequestConfig dbxRequestConfig, final String str, final String str2, final String str3, final String str4, final String[] strArr, final List<HttpRequestor.Header> list, final ResponseHandler<T> responseHandler) throws DbxException {
        return (T) runAndRetry(dbxRequestConfig.getMaxRetries(), new RequestMaker<T, DbxException>() { // from class: com.dropbox.core.DbxRequestUtil.1
            @Override // com.dropbox.core.DbxRequestUtil.RequestMaker
            public T run() throws DbxException {
                HttpRequestor.Response responseStartGet = DbxRequestUtil.startGet(dbxRequestConfig, str, str2, str3, str4, strArr, list);
                try {
                    T t = (T) responseHandler.handle(responseStartGet);
                    try {
                        responseStartGet.getBody().close();
                        return t;
                    } catch (IOException e) {
                        throw new NetworkIOException(e);
                    }
                } catch (Throwable th) {
                    try {
                        responseStartGet.getBody().close();
                        throw th;
                    } catch (IOException e2) {
                        throw new NetworkIOException(e2);
                    }
                }
            }
        });
    }

    public static <T> T doPost(DbxRequestConfig dbxRequestConfig, String str, String str2, String str3, String str4, String[] strArr, List<HttpRequestor.Header> list, ResponseHandler<T> responseHandler) throws DbxException {
        return (T) doPostNoAuth(dbxRequestConfig, str2, str3, str4, strArr, addAuthHeader(copyHeaders(list), str), responseHandler);
    }

    public static <T> T doPostNoAuth(final DbxRequestConfig dbxRequestConfig, final String str, final String str2, final String str3, final String[] strArr, final List<HttpRequestor.Header> list, final ResponseHandler<T> responseHandler) throws DbxException {
        return (T) runAndRetry(dbxRequestConfig.getMaxRetries(), new RequestMaker<T, DbxException>() { // from class: com.dropbox.core.DbxRequestUtil.2
            @Override // com.dropbox.core.DbxRequestUtil.RequestMaker
            public T run() throws DbxException {
                return (T) DbxRequestUtil.finishResponse(DbxRequestUtil.startPostNoAuth(dbxRequestConfig, str, str2, str3, strArr, list), responseHandler);
            }
        });
    }

    public static <T> T finishResponse(HttpRequestor.Response response, ResponseHandler<T> responseHandler) throws DbxException {
        try {
            return responseHandler.handle(response);
        } finally {
            if (response != null) {
                IOUtil.closeInput(response.getBody());
            }
        }
    }

    public static String getFirstHeader(HttpRequestor.Response response, String str) throws BadResponseException {
        List<String> list = response.getHeaders().get(str);
        if (list == null || list.isEmpty()) {
            throw new BadResponseException(getRequestId(response), "missing HTTP header \"" + str + "\"");
        }
        return list.get(0);
    }

    public static String getFirstHeaderMaybe(HttpRequestor.Response response, String str) {
        List<String> list = response.getHeaders().get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static String getRequestId(HttpRequestor.Response response) {
        return getFirstHeaderMaybe(response, "X-Dropbox-Request-Id");
    }

    public static String getContentType(HttpRequestor.Response response) {
        return getFirstHeaderMaybe(response, "Content-Type");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T, E extends Throwable> T runAndRetry(int i, RequestMaker<T, E> requestMaker) throws Throwable {
        long backoffMillis;
        Throwable th;
        int i2 = 0;
        while (true) {
            try {
                return requestMaker.run();
            } catch (RetryException e) {
                backoffMillis = e.getBackoffMillis();
                th = e;
                if (i2 < i) {
                    throw th;
                }
                long jNextInt = backoffMillis + ((long) RAND.nextInt(1000));
                if (jNextInt > 0) {
                    try {
                        Thread.sleep(jNextInt);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                i2++;
            } catch (ServerException e2) {
                backoffMillis = 0;
                th = e2;
                if (i2 < i) {
                }
            }
            i2++;
        }
    }
}
