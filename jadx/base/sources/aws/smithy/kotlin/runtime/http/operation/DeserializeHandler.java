package aws.smithy.kotlin.runtime.http.operation;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.operation.HttpDeserializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.Handler;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkOperationExecution.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u0003BG\u0012\u001c\u0010\b\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0010\u001a\u00028\u00012\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0096@¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\b\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/DeserializeHandler;", "Input", "Output", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/http/HttpCall;", "inner", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "deserializer", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "interceptors", "<init>", "(Laws/smithy/kotlin/runtime/io/Handler;Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;)V", "request", NotificationCompat.CATEGORY_CALL, "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class DeserializeHandler<Input, Output> implements Handler<OperationRequest<HttpRequestBuilder>, Output> {
    private final HttpDeserializer<Output> deserializer;
    private final Handler<OperationRequest<HttpRequestBuilder>, HttpCall> inner;
    private final InterceptorExecutor<Input, Output> interceptors;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.DeserializeHandler$call$1 */
    /* JADX INFO: compiled from: SdkOperationExecution.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.DeserializeHandler", m1609f = "SdkOperationExecution.kt", m1610i = {0, 1, 1, 2, 2, 2, 3, 3, 3}, m1611l = {PDFACompliance.e_PDFA3_4_1, 343, WorkflowTransitionState.SLIDE_DURATION_MS, PDFACompliance.e_PDFA3_5_3}, m1612m = NotificationCompat.CATEGORY_CALL, m1613n = {"request", "request", NotificationCompat.CATEGORY_CALL, "request", NotificationCompat.CATEGORY_CALL, "modified", "request", NotificationCompat.CATEGORY_CALL, "modified"}, m1614nl = {343, 344, PDFACompliance.e_PDFA3_5_1, 348}, m1615s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C37281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DeserializeHandler<Input, Output> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37281(DeserializeHandler<Input, Output> deserializeHandler, Continuation<? super C37281> continuation) {
            super(continuation);
            this.this$0 = deserializeHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.call((OperationRequest<HttpRequestBuilder>) null, (Continuation) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeserializeHandler(Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> inner, HttpDeserializer<Output> deserializer, InterceptorExecutor<Input, Output> interceptors) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.inner = inner;
        this.deserializer = deserializer;
        this.interceptors = interceptors;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object call(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super Output> continuation) {
        C37281 c37281;
        OperationRequest<HttpRequestBuilder> operationRequest2;
        HttpCall httpCall;
        HttpDeserializer<Output> httpDeserializer;
        HttpCall httpCall2;
        OperationRequest<HttpRequestBuilder> operationRequest3;
        if (continuation instanceof C37281) {
            c37281 = (C37281) continuation;
            if ((c37281.label & Integer.MIN_VALUE) != 0) {
                c37281.label -= Integer.MIN_VALUE;
            } else {
                c37281 = new C37281(this, continuation);
            }
        }
        Object objCall = c37281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37281.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCall);
            Handler<OperationRequest<HttpRequestBuilder>, HttpCall> handler = this.inner;
            c37281.L$0 = operationRequest;
            c37281.label = 1;
            objCall = handler.call(operationRequest, c37281);
            if (objCall != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    httpCall2 = (HttpCall) c37281.L$2;
                    ResultKt.throwOnFailure(objCall);
                    this.interceptors.readAfterDeserialization((Output) objCall, httpCall2);
                    return objCall;
                }
                httpCall2 = (HttpCall) c37281.L$2;
                operationRequest3 = (OperationRequest) c37281.L$0;
                ResultKt.throwOnFailure(objCall);
                objCall = ((HttpDeserializer.NonStreaming) this.deserializer).deserialize(operationRequest3.getContext(), httpCall2, (byte[]) objCall);
                this.interceptors.readAfterDeserialization((Output) objCall, httpCall2);
                return objCall;
            }
            httpCall = (HttpCall) c37281.L$1;
            operationRequest2 = (OperationRequest) c37281.L$0;
            ResultKt.throwOnFailure(objCall);
            HttpCall httpCallCopy$default = HttpCall.copy$default(httpCall, null, (HttpResponse) objCall, 1, null);
            this.interceptors.readBeforeDeserialization(httpCallCopy$default);
            httpDeserializer = this.deserializer;
            if (!(httpDeserializer instanceof HttpDeserializer.NonStreaming)) {
                HttpBody body = httpCallCopy$default.getResponse().getBody();
                c37281.L$0 = operationRequest2;
                c37281.L$1 = SpillingKt.nullOutSpilledVariable(httpCall);
                c37281.L$2 = httpCallCopy$default;
                c37281.label = 3;
                Object all = HttpBodyKt.readAll(body, c37281);
                if (all != coroutine_suspended) {
                    objCall = all;
                    httpCall2 = httpCallCopy$default;
                    operationRequest3 = operationRequest2;
                    objCall = ((HttpDeserializer.NonStreaming) this.deserializer).deserialize(operationRequest3.getContext(), httpCall2, (byte[]) objCall);
                    this.interceptors.readAfterDeserialization((Output) objCall, httpCall2);
                    return objCall;
                }
            } else {
                if (!(httpDeserializer instanceof HttpDeserializer.Streaming)) {
                    throw new NoWhenBranchMatchedException();
                }
                ExecutionContext context = operationRequest2.getContext();
                c37281.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest2);
                c37281.L$1 = SpillingKt.nullOutSpilledVariable(httpCall);
                c37281.L$2 = httpCallCopy$default;
                c37281.label = 4;
                Object objDeserialize = ((HttpDeserializer.Streaming) httpDeserializer).deserialize(context, httpCallCopy$default, c37281);
                if (objDeserialize != coroutine_suspended) {
                    objCall = objDeserialize;
                    httpCall2 = httpCallCopy$default;
                    this.interceptors.readAfterDeserialization((Output) objCall, httpCall2);
                    return objCall;
                }
            }
            return coroutine_suspended;
        }
        operationRequest = (OperationRequest) c37281.L$0;
        ResultKt.throwOnFailure(objCall);
        HttpCall httpCall3 = (HttpCall) objCall;
        InterceptorExecutor<Input, Output> interceptorExecutor = this.interceptors;
        c37281.L$0 = operationRequest;
        c37281.L$1 = httpCall3;
        c37281.label = 2;
        Object objModifyBeforeDeserialization = interceptorExecutor.modifyBeforeDeserialization(httpCall3, c37281);
        if (objModifyBeforeDeserialization != coroutine_suspended) {
            operationRequest2 = operationRequest;
            httpCall = httpCall3;
            objCall = objModifyBeforeDeserialization;
            HttpCall httpCallCopy$default2 = HttpCall.copy$default(httpCall, null, (HttpResponse) objCall, 1, null);
            this.interceptors.readBeforeDeserialization(httpCallCopy$default2);
            httpDeserializer = this.deserializer;
            if (!(httpDeserializer instanceof HttpDeserializer.NonStreaming)) {
            }
        }
        return coroutine_suspended;
    }
}
