package aws.sdk.kotlin.runtime.http.middleware;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.util.EnvironmentProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecursionDetection.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0096@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/middleware/RecursionDetection;", "Laws/smithy/kotlin/runtime/http/operation/ModifyRequestMiddleware;", "env", "Laws/smithy/kotlin/runtime/util/EnvironmentProvider;", "<init>", "(Laws/smithy/kotlin/runtime/util/EnvironmentProvider;)V", "modifyRequest", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "req", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final class RecursionDetection implements ModifyRequestMiddleware {
    private final EnvironmentProvider env;

    /* JADX WARN: Multi-variable type inference failed */
    public RecursionDetection() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public RecursionDetection(EnvironmentProvider env) {
        Intrinsics.checkNotNullParameter(env, "env");
        this.env = env;
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware
    @InternalApi
    public /* bridge */ void install(SdkHttpOperation<?, ?> sdkHttpOperation) {
        super.install(sdkHttpOperation);
    }

    public /* synthetic */ RecursionDetection(PlatformProvider platformProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.middleware.ModifyRequest
    public Object modifyRequest(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super OperationRequest<HttpRequestBuilder>> continuation) {
        if (!operationRequest.getSubject().getHeaders().contains(RecursionDetectionKt.HEADER_TRACE_ID)) {
            String str = this.env.getenv(RecursionDetectionKt.ENV_TRACE_ID);
            if (this.env.getenv(RecursionDetectionKt.ENV_FUNCTION_NAME) != null && str != null) {
                operationRequest.getSubject().getHeaders().set(RecursionDetectionKt.HEADER_TRACE_ID, RecursionDetectionKt.encoding.encode(str));
            }
        }
        return operationRequest;
    }
}
