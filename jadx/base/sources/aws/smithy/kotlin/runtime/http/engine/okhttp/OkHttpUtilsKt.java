package aws.smithy.kotlin.runtime.http.engine.okhttp;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpErrorCode;
import aws.smithy.kotlin.runtime.http.HttpException;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.engine.internal.HttpClientMetrics;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.http.response.HttpResponseKt;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.url.QueryParameters;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.net.url.UrlPath;
import aws.smithy.kotlin.runtime.net.url.UserInfo;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import aws.smithy.kotlin.runtime.p011io.internal.ConvertKt;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: OkHttpUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0007\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0007\u001a%\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0010\u0010\u0017\u001a\u00020\u0018*\u00060\u0019j\u0002`\u001aH\u0007\u001a\u0010\u0010\u001b\u001a\u00020\u001c*\u00060\u0019j\u0002`\u001aH\u0002\u001a\u0010\u0010\u001d\u001a\u00020\u001c*\u00060\u0019j\u0002`\u001aH\u0002\u001a\u0019\u0010\u001e\u001a\u00020\u001c\"\u0006\b\u0000\u0010\u0013\u0018\u0001*\u00060\u0019j\u0002`\u001aH\u0082\b\u001a \u0010\u001f\u001a\u0004\u0018\u0001H\u0013\"\u0006\b\u0000\u0010\u0013\u0018\u0001*\u00060\u0019j\u0002`\u001aH\u0082\b¢\u0006\u0002\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m1599d2 = {"toOkHttpRequest", "Lokhttp3/Request;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "execContext", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "metrics", "Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;", "toOkHttpHeaders", "Lokhttp3/Headers;", "Laws/smithy/kotlin/runtime/http/Headers;", "toSdkResponse", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Lokhttp3/Response;", "toUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "Ljava/net/URI;", "mapOkHttpExceptions", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "errCode", "Laws/smithy/kotlin/runtime/http/HttpErrorCode;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isConnectTimeoutException", "", "isConnectionClosedException", "isCauseOrSuppressed", "findCauseOrSuppressed", "(Ljava/lang/Exception;)Ljava/lang/Object;", "http-client-engine-okhttp"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OkHttpUtilsKt {
    @InternalApi
    public static final Request toOkHttpRequest(HttpRequest httpRequest, ExecutionContext execContext, CoroutineContext callContext, HttpClientMetrics metrics) {
        Long contentLength;
        Intrinsics.checkNotNullParameter(httpRequest, "<this>");
        Intrinsics.checkNotNullParameter(execContext, "execContext");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Request.Builder builder = new Request.Builder();
        builder.tag((Class<? super SdkRequestTag>) SdkRequestTag.class, new SdkRequestTag(execContext, callContext, metrics));
        builder.url(httpRequest.getUrl().getEncoded());
        builder.headers(toOkHttpHeaders(httpRequest.getHeaders()));
        StreamingRequestBody streamingRequestBody = null;
        httpBody = null;
        HttpBody httpBody = null;
        if (HttpMethod.permitsRequestBody(httpRequest.getMethod().name())) {
            HttpBody body = httpRequest.getBody();
            if (body instanceof HttpBody.Empty) {
                streamingRequestBody = RequestBody.INSTANCE.create(new byte[0], (MediaType) null, 0, 0);
            } else if (body instanceof HttpBody.Bytes) {
                byte[] bytes = ((HttpBody.Bytes) body).getBytes();
                streamingRequestBody = RequestBody.INSTANCE.create(bytes, (MediaType) null, 0, bytes.length);
            } else {
                boolean z = body instanceof HttpBody.SourceContent;
                if (!z && !(body instanceof HttpBody.ChannelContent)) {
                    throw new NoWhenBranchMatchedException();
                }
                String str = httpRequest.getHeaders().get("Content-Length");
                if (str != null) {
                    if (body.getContentLength() == null || ((contentLength = body.getContentLength()) != null && contentLength.longValue() == -1)) {
                        if (z) {
                            httpBody = HttpBodyKt.toHttpBody(((HttpBody.SourceContent) body).get$this_toHttpBody(), Long.valueOf(Long.parseLong(str)));
                        } else {
                            if (!(body instanceof HttpBody.ChannelContent)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            httpBody = HttpBodyKt.toHttpBody(((HttpBody.ChannelContent) body).get$ch(), Long.valueOf(Long.parseLong(str)));
                        }
                    }
                    if (httpBody != null) {
                        body = httpBody;
                    }
                }
                streamingRequestBody = new StreamingRequestBody(body, callContext);
            }
        } else if (!(httpRequest.getBody() instanceof HttpBody.Empty)) {
            throw new IllegalStateException(("unexpected HTTP body for method " + httpRequest.getMethod()).toString());
        }
        builder.method(httpRequest.getMethod().name(), streamingRequestBody);
        return builder.build();
    }

    @InternalApi
    public static final Headers toOkHttpHeaders(aws.smithy.kotlin.runtime.http.Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        final Headers.Builder builder = new Headers.Builder();
        headers.forEach(new Function2() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpUtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return OkHttpUtilsKt.toOkHttpHeaders$lambda$0$0(builder, (String) obj, (List) obj2);
            }
        });
        if (!headers.contains("Accept-Encoding")) {
            builder.addUnsafeNonAscii("Accept-Encoding", HTTP.IDENTITY_CODING);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toOkHttpHeaders$lambda$0$0(Headers.Builder builder, String key, List values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        Iterator it = values.iterator();
        while (it.hasNext()) {
            builder.addUnsafeNonAscii(key, (String) it.next());
        }
        return Unit.INSTANCE;
    }

    @InternalApi
    public static final HttpResponse toSdkResponse(final Response response) {
        HttpBody.SourceContent sourceContent;
        Intrinsics.checkNotNullParameter(response, "<this>");
        OkHttpHeadersAdapter okHttpHeadersAdapter = new OkHttpHeadersAdapter(response.headers());
        if (response.body().getContentLength() == 0) {
            sourceContent = HttpBody.Empty.INSTANCE;
        } else {
            sourceContent = new HttpBody.SourceContent() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpUtilsKt$toSdkResponse$httpBody$1
                private final Long contentLength;
                private final boolean isOneShot = true;

                {
                    this.contentLength = this.$this_toSdkResponse.body().getContentLength() >= 0 ? Long.valueOf(this.$this_toSdkResponse.body().getContentLength()) : null;
                }

                @Override // aws.smithy.kotlin.runtime.http.HttpBody
                /* JADX INFO: renamed from: isOneShot, reason: from getter */
                public boolean getIsOneShot() {
                    return this.isOneShot;
                }

                @Override // aws.smithy.kotlin.runtime.http.HttpBody
                public Long getContentLength() {
                    return this.contentLength;
                }

                @Override // aws.smithy.kotlin.runtime.http.HttpBody.SourceContent
                /* JADX INFO: renamed from: readFrom */
                public SdkSource get$this_toHttpBody() {
                    return ConvertKt.toSdk(this.$this_toSdkResponse.body().getBodySource());
                }
            };
        }
        return HttpResponseKt.HttpResponse(HttpStatusCode.INSTANCE.fromValue(response.code()), okHttpHeadersAdapter, sourceContent);
    }

    @InternalApi
    public static final Url toUrl(URI uri) {
        String host;
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Url.Companion companion = Url.INSTANCE;
        Url.Builder builder = new Url.Builder();
        Scheme.Companion companion2 = Scheme.INSTANCE;
        String scheme = uri.getScheme();
        Intrinsics.checkNotNullExpressionValue(scheme, "getScheme(...)");
        builder.setScheme(companion2.parse(scheme));
        Host.Companion companion3 = Host.INSTANCE;
        String host2 = uri.getHost();
        Intrinsics.checkNotNullExpressionValue(host2, "getHost(...)");
        if (StringsKt.startsWith$default(host2, "[", false, 2, (Object) null)) {
            String host3 = uri.getHost();
            Intrinsics.checkNotNullExpressionValue(host3, "getHost(...)");
            host = StringsKt.substring(host3, RangesKt.until(1, uri.getHost().length() - 1));
        } else {
            host = uri.getHost();
        }
        Intrinsics.checkNotNull(host);
        builder.setHost(companion3.parse(host));
        Integer numValueOf = Integer.valueOf(uri.getPort());
        builder.setPort(Boolean.valueOf(numValueOf.intValue() > 0).booleanValue() ? numValueOf : null);
        UrlPath.Builder path = builder.getPath();
        String rawPath = uri.getRawPath();
        Intrinsics.checkNotNullExpressionValue(rawPath, "getRawPath(...)");
        path.setEncoded(rawPath);
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && !StringsKt.isBlank(rawQuery)) {
            QueryParameters.Builder parameters = builder.getParameters();
            String rawQuery2 = uri.getRawQuery();
            Intrinsics.checkNotNullExpressionValue(rawQuery2, "getRawQuery(...)");
            parameters.setEncoded(rawQuery2);
        }
        String rawUserInfo = uri.getRawUserInfo();
        if (rawUserInfo != null && !StringsKt.isBlank(rawUserInfo)) {
            UserInfo.Builder userInfo = builder.getUserInfo();
            UserInfo.Companion companion4 = UserInfo.INSTANCE;
            String rawUserInfo2 = uri.getRawUserInfo();
            Intrinsics.checkNotNullExpressionValue(rawUserInfo2, "getRawUserInfo(...)");
            userInfo.copyFrom(companion4.parseEncoded(rawUserInfo2));
        }
        builder.setEncodedFragment(uri.getRawFragment());
        return builder.build();
    }

    @InternalApi
    public static final <T> T mapOkHttpExceptions(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke();
        } catch (IOException e) {
            throw new HttpException((Throwable) e, errCode(e), true);
        }
    }

    @InternalApi
    public static final HttpErrorCode errCode(Exception exc) {
        Object next;
        Exception exc2;
        Object next2;
        Intrinsics.checkNotNullParameter(exc, "<this>");
        if (isConnectTimeoutException(exc)) {
            return HttpErrorCode.CONNECT_TIMEOUT;
        }
        if (isConnectionClosedException(exc)) {
            return HttpErrorCode.CONNECTION_CLOSED;
        }
        if (exc instanceof SocketTimeoutException) {
            exc2 = exc;
        } else if (exc.getCause() instanceof SocketTimeoutException) {
            Throwable cause = exc.getCause();
            if (cause == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.SocketTimeoutException");
            }
            exc2 = (SocketTimeoutException) cause;
        } else {
            Iterator<T> it = ExceptionsKt.getSuppressedExceptions(exc).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Throwable) next) instanceof SocketTimeoutException) {
                    break;
                }
            }
            if (!(next instanceof SocketTimeoutException)) {
                next = null;
            }
            exc2 = (SocketTimeoutException) next;
        }
        if (exc2 != null) {
            return HttpErrorCode.SOCKET_TIMEOUT;
        }
        if (!(exc instanceof SSLHandshakeException)) {
            if (exc.getCause() instanceof SSLHandshakeException) {
                Throwable cause2 = exc.getCause();
                if (cause2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLHandshakeException");
                }
                exc = (SSLHandshakeException) cause2;
            } else {
                Iterator<T> it2 = ExceptionsKt.getSuppressedExceptions(exc).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    if (((Throwable) next2) instanceof SSLHandshakeException) {
                        break;
                    }
                }
                exc = (SSLHandshakeException) (next2 instanceof SSLHandshakeException ? next2 : null);
            }
        }
        if (exc != null) {
            return HttpErrorCode.TLS_NEGOTIATION_ERROR;
        }
        return HttpErrorCode.SDK_UNKNOWN;
    }

    private static final boolean isConnectionClosedException(Exception exc) {
        String message;
        Object next;
        String message2 = exc.getMessage();
        if (message2 != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "unexpected end of stream", false, 2, (Object) null)) {
            Throwable cause = exc.getCause();
            Exception exc2 = cause instanceof Exception ? (Exception) cause : null;
            if (exc2 != null) {
                if (!(exc2 instanceof EOFException)) {
                    if (exc2.getCause() instanceof EOFException) {
                        Throwable cause2 = exc2.getCause();
                        if (cause2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.io.EOFException");
                        }
                        exc2 = (EOFException) cause2;
                    } else {
                        Iterator<T> it = ExceptionsKt.getSuppressedExceptions(exc2).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            if (((Throwable) next) instanceof EOFException) {
                                break;
                            }
                        }
                        if (!(next instanceof EOFException)) {
                            next = null;
                        }
                        exc2 = (EOFException) next;
                    }
                }
                EOFException eOFException = (EOFException) exc2;
                if (eOFException != null && (message = eOFException.getMessage()) != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "\\n not found: limit=0", false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T findCauseOrSuppressed(Exception exc) {
        T next;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (exc instanceof Object) {
            return exc;
        }
        Throwable cause = exc.getCause();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (cause instanceof Object) {
            Object cause2 = exc.getCause();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) cause2;
        }
        Iterator<T> it = ExceptionsKt.getSuppressedExceptions(exc).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (((Throwable) next) instanceof Object) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = next;
        return (T) next;
    }

    private static final boolean isConnectTimeoutException(Exception exc) {
        String message;
        Object next;
        if (!(exc instanceof SocketTimeoutException)) {
            if (exc.getCause() instanceof SocketTimeoutException) {
                Throwable cause = exc.getCause();
                if (cause == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.net.SocketTimeoutException");
                }
                exc = (SocketTimeoutException) cause;
            } else {
                Iterator<T> it = ExceptionsKt.getSuppressedExceptions(exc).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((Throwable) next) instanceof SocketTimeoutException) {
                        break;
                    }
                }
                exc = (SocketTimeoutException) (next instanceof SocketTimeoutException ? next : null);
            }
        }
        SocketTimeoutException socketTimeoutException = (SocketTimeoutException) exc;
        return (socketTimeoutException == null || (message = socketTimeoutException.getMessage()) == null || !StringsKt.contains((CharSequence) message, (CharSequence) "connect", true)) ? false : true;
    }

    private static final /* synthetic */ <T> boolean isCauseOrSuppressed(Exception exc) {
        Throwable th;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        boolean z = exc instanceof Object;
        Throwable th2 = exc;
        if (!z) {
            Throwable cause = exc.getCause();
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (cause instanceof Object) {
                Throwable cause2 = exc.getCause();
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                th2 = cause2;
            } else {
                Iterator<T> it = ExceptionsKt.getSuppressedExceptions(exc).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        th = null;
                        break;
                    }
                    T next = it.next();
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (((Throwable) next) instanceof Object) {
                        th = next;
                        break;
                    }
                }
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                th2 = th;
            }
        }
        return th2 != null;
    }
}
