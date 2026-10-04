package aws.smithy.kotlin.runtime.http.operation;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.Handler;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkOperationExecution.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\n\u001a\u00028\u00002\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0096@¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\f¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/MutateHandler;", "Output", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "inner", "<init>", "(Laws/smithy/kotlin/runtime/io/Handler;)V", "request", NotificationCompat.CATEGORY_CALL, "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/Handler;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class MutateHandler<Output> implements Handler<OperationRequest<HttpRequestBuilder>, Output> {
    private final Handler<OperationRequest<HttpRequestBuilder>, Output> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public MutateHandler(Handler<? super OperationRequest<HttpRequestBuilder>, ? extends Output> inner) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.inner = inner;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.Handler
    public Object call(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super Output> continuation) {
        return this.inner.call(operationRequest, continuation);
    }
}
