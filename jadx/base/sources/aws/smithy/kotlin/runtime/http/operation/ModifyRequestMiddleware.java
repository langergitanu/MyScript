package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.middleware.ModifyRequest;
import aws.smithy.kotlin.runtime.p011io.middleware.Phase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationMiddleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0017¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/ModifyRequestMiddleware;", "Laws/smithy/kotlin/runtime/io/middleware/ModifyRequest;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "op", "", "install", "(Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ModifyRequestMiddleware extends ModifyRequest<OperationRequest<HttpRequestBuilder>> {

    /* JADX INFO: compiled from: OperationMiddleware.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @InternalApi
        @Deprecated
        public static void install(ModifyRequestMiddleware modifyRequestMiddleware, SdkHttpOperation<?, ?> op) {
            Intrinsics.checkNotNullParameter(op, "op");
            ModifyRequestMiddleware.super.install(op);
        }
    }

    @InternalApi
    default void install(SdkHttpOperation<?, ?> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        Phase.register$default(op.getExecution().getMutate(), this, (Phase.Order) null, 2, (Object) null);
    }
}
