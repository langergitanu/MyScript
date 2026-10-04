package aws.sdk.kotlin.runtime.http.middleware;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.http.operation.MutateMiddleware;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.p011io.middleware.Phase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsRetryHeaderMiddleware.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\fH\u0016JH\u0010\r\u001a\u00028\u0000\"\u001e\b\u0001\u0010\u000e*\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00110\u0010j\u0002`\u0012\u0012\u0004\u0012\u00028\u00000\u000f2\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00110\u0010j\u0002`\u00122\u0006\u0010\u0014\u001a\u0002H\u000eH\u0096@¢\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u00020\n2\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00110\u0010j\u0002`\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0017"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/middleware/AwsRetryHeaderMiddleware;", "O", "Laws/smithy/kotlin/runtime/http/operation/MutateMiddleware;", "<init>", "()V", "attempt", "", "maxAttempts", "Ljava/lang/Integer;", "install", "", "op", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "handle", "H", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "request", "next", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttempt", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final class AwsRetryHeaderMiddleware<O> implements MutateMiddleware<O> {
    private int attempt;
    private Integer maxAttempts;

    @Override // aws.smithy.kotlin.runtime.http.operation.MutateMiddleware
    public void install(SdkHttpOperation<?, O> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        this.maxAttempts = Integer.valueOf(op.getExecution().getRetryStrategy().getConfig().getMaxAttempts());
        Phase.register$default(op.getExecution().getOnEachAttempt(), this, (Phase.Order) null, 2, (Object) null);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.middleware.Middleware
    public <H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends O>> Object handle(OperationRequest<HttpRequestBuilder> operationRequest, H h, Continuation<? super O> continuation) {
        this.attempt++;
        HttpRequestBuilderKt.header(operationRequest.getSubject(), AwsRetryHeaderMiddlewareKt.AMZ_SDK_INVOCATION_ID_HEADER, SdkHttpOperationKt.getSdkInvocationId(operationRequest.getContext()));
        onAttempt(operationRequest, this.attempt);
        return h.call(operationRequest, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onAttempt(OperationRequest<HttpRequestBuilder> request, int attempt) {
        String str;
        Integer num = this.maxAttempts;
        if (num != null) {
            str = "; max=" + num.intValue();
            if (str == null) {
                str = "";
            }
        }
        HttpRequestBuilderKt.header(request.getSubject(), AwsRetryHeaderMiddlewareKt.AMZ_SDK_REQUEST_HEADER, "attempt=" + attempt + str);
    }
}
