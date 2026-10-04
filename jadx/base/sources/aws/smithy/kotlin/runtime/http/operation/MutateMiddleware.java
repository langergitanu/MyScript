package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.middleware.Middleware;
import aws.smithy.kotlin.runtime.p011io.middleware.Phase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationMiddleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00028\u00000\u0002J!\u0010\t\u001a\u00020\b2\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0006H\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/MutateMiddleware;", "Response", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "op", "", "install", "(Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface MutateMiddleware<Response> extends Middleware<OperationRequest<HttpRequestBuilder>, Response> {

    /* JADX INFO: compiled from: OperationMiddleware.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @InternalApi
        @Deprecated
        public static <Response> void install(MutateMiddleware<Response> mutateMiddleware, SdkHttpOperation<?, Response> op) {
            Intrinsics.checkNotNullParameter(op, "op");
            MutateMiddleware.super.install(op);
        }
    }

    @InternalApi
    default void install(SdkHttpOperation<?, Response> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        Phase.register$default(op.getExecution().getMutate(), this, (Phase.Order) null, 2, (Object) null);
    }
}
