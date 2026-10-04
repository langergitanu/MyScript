package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HttpCall.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\u0017\u001a\u00020\u0018H\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpCall;", "Lkotlinx/coroutines/CoroutineScope;", "request", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "response", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "requestTime", "Laws/smithy/kotlin/runtime/time/Instant;", "responseTime", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Laws/smithy/kotlin/runtime/time/Instant;Laws/smithy/kotlin/runtime/time/Instant;Lkotlin/coroutines/CoroutineContext;)V", "getRequest", "()Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "getResponse", "()Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "getRequestTime", "()Laws/smithy/kotlin/runtime/time/Instant;", "getResponseTime", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "copy", "cancelInFlight", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class HttpCall implements CoroutineScope {
    private final CoroutineContext coroutineContext;
    private final HttpRequest request;
    private final Instant requestTime;
    private final HttpResponse response;
    private final Instant responseTime;

    public HttpCall(HttpRequest request, HttpResponse response, Instant requestTime, Instant responseTime, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        Intrinsics.checkNotNullParameter(responseTime, "responseTime");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.request = request;
        this.response = response;
        this.requestTime = requestTime;
        this.responseTime = responseTime;
        this.coroutineContext = coroutineContext;
    }

    public final HttpRequest getRequest() {
        return this.request;
    }

    public final HttpResponse getResponse() {
        return this.response;
    }

    public /* synthetic */ HttpCall(HttpRequest httpRequest, HttpResponse httpResponse, Instant instant, Instant instant2, EmptyCoroutineContext emptyCoroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpRequest, httpResponse, (i & 4) != 0 ? Instant.INSTANCE.now() : instant, (i & 8) != 0 ? Instant.INSTANCE.now() : instant2, (i & 16) != 0 ? EmptyCoroutineContext.INSTANCE : emptyCoroutineContext);
    }

    public final Instant getRequestTime() {
        return this.requestTime;
    }

    public final Instant getResponseTime() {
        return this.responseTime;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public static /* synthetic */ HttpCall copy$default(HttpCall httpCall, HttpRequest httpRequest, HttpResponse httpResponse, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            httpRequest = httpCall.request;
        }
        if ((i & 2) != 0) {
            httpResponse = httpCall.response;
        }
        return httpCall.copy(httpRequest, httpResponse);
    }

    @InternalApi
    public HttpCall copy(HttpRequest request, HttpResponse response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        return new HttpCall(request, response, this.requestTime, this.responseTime, getCoroutineContext());
    }

    @InternalApi
    public void cancelInFlight() {
        SdkByteReadChannel from;
        try {
            Result.Companion companion = Result.INSTANCE;
            HttpCall httpCall = this;
            HttpBody body = this.response.getBody();
            Boolean boolValueOf = null;
            HttpBody.ChannelContent channelContent = body instanceof HttpBody.ChannelContent ? (HttpBody.ChannelContent) body : null;
            if (channelContent != null && (from = channelContent.get$ch()) != null) {
                boolValueOf = Boolean.valueOf(from.cancel(null));
            }
            Result.m14499constructorimpl(boolValueOf);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }
}
