package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.middleware.Middleware;
import aws.smithy.kotlin.runtime.p011io.middleware.Phase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationMiddleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u0003J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0017¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/InitializeMiddleware;", "Request", "Response", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "op", "", "install", "(Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface InitializeMiddleware<Request, Response> extends Middleware<OperationRequest<Request>, Response> {

    /* JADX INFO: compiled from: OperationMiddleware.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @InternalApi
        @Deprecated
        public static <Request, Response> void install(InitializeMiddleware<Request, Response> initializeMiddleware, SdkHttpOperation<Request, Response> op) {
            Intrinsics.checkNotNullParameter(op, "op");
            InitializeMiddleware.super.install(op);
        }
    }

    @InternalApi
    default void install(SdkHttpOperation<Request, Response> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        Phase.register$default(op.getExecution().getInitialize(), this, (Phase.Order) null, 2, (Object) null);
    }
}
