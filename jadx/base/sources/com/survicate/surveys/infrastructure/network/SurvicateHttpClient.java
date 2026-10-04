package com.survicate.surveys.infrastructure.network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: SurvicateHttpClient.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;", "", "<init>", "()V", "okHttp", "Lokhttp3/OkHttpClient;", "loadUrlResponse", "", "request", "Lcom/survicate/surveys/infrastructure/network/URLRequest;", "readErrorBodySafely", "response", "Lokhttp3/Response;", "buildOkHttpRequest", "Lokhttp3/Request;", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateHttpClient {
    public static final long CONNECT_TIMEOUT_MS = 10000;
    private static final String CONTENT_TYPE_VALUE = "application/json; charset=utf-8";
    public static final long READ_TIMEOUT_MS = 10000;
    public static final long WRITE_TIMEOUT_MS = 10000;
    private final OkHttpClient okHttp = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(10000, TimeUnit.MILLISECONDS).writeTimeout(10000, TimeUnit.MILLISECONDS).build();

    public final String loadUrlResponse(URLRequest request) throws IOException {
        String strString;
        Intrinsics.checkNotNullParameter(request, "request");
        Response responseExecute = this.okHttp.newCall(buildOkHttpRequest(request)).execute();
        try {
            Response response = responseExecute;
            if (response.getIsSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody == null || (strString = responseBodyBody.string()) == null || strString.length() <= 0) {
                    strString = null;
                }
                CloseableKt.closeFinally(responseExecute, null);
                return strString;
            }
            throw new HttpException(response.code(), readErrorBodySafely(response));
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(responseExecute, th);
                throw th2;
            }
        }
    }

    private final String readErrorBodySafely(Response response) {
        String strString;
        try {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody != null && (strString = responseBodyBody.string()) != null) {
                if (strString.length() > 0) {
                    return strString;
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    private final Request buildOkHttpRequest(URLRequest request) throws MalformedURLException {
        Request.Builder builder = new Request.Builder();
        URL url = request.getUrl().toURL();
        Intrinsics.checkNotNullExpressionValue(url, "toURL(...)");
        Request.Builder builderUrl = builder.url(url);
        String body = request.getBody();
        if (body == null || body.length() == 0) {
            builderUrl.method(request.getMethod(), null);
        } else {
            builderUrl.method(request.getMethod(), RequestBody.INSTANCE.create(request.getBody(), MediaType.INSTANCE.get(CONTENT_TYPE_VALUE)));
        }
        return builderUrl.build();
    }
}
