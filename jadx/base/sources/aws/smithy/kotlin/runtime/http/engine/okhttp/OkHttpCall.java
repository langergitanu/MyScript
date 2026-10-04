package aws.smithy.kotlin.runtime.http.engine.okhttp;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;

/* JADX INFO: compiled from: OkHttpUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpCall;", "Laws/smithy/kotlin/runtime/http/HttpCall;", "request", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "response", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "requestTime", "Laws/smithy/kotlin/runtime/time/Instant;", "responseTime", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "<init>", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Laws/smithy/kotlin/runtime/time/Instant;Laws/smithy/kotlin/runtime/time/Instant;Lkotlin/coroutines/CoroutineContext;Lokhttp3/Call;)V", "getCall", "()Lokhttp3/Call;", "copy", "cancelInFlight", "", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OkHttpCall extends HttpCall {
    private final Call call;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpCall(HttpRequest request, HttpResponse response, Instant requestTime, Instant responseTime, CoroutineContext coroutineContext, Call call) {
        super(request, response, requestTime, responseTime, coroutineContext);
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        Intrinsics.checkNotNullParameter(responseTime, "responseTime");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(call, "call");
        this.call = call;
    }

    public /* synthetic */ OkHttpCall(HttpRequest httpRequest, HttpResponse httpResponse, Instant instant, Instant instant2, EmptyCoroutineContext emptyCoroutineContext, Call call, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpRequest, httpResponse, instant, instant2, (i & 16) != 0 ? EmptyCoroutineContext.INSTANCE : emptyCoroutineContext, call);
    }

    public final Call getCall() {
        return this.call;
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpCall
    public HttpCall copy(HttpRequest request, HttpResponse response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        return new OkHttpCall(request, response, getRequestTime(), getResponseTime(), getCoroutineContext(), this.call);
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpCall
    public void cancelInFlight() {
        super.cancelInFlight();
        this.call.cancel();
    }
}
