package aws.smithy.kotlin.runtime.http.operation;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.operation.HttpSerializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.Handler;
import com.pdftron.pdf.pdfa.PDFACompliance;
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
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u0003BG\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000f\u001a\u00028\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\u0007\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/SerializeHandler;", "Input", "Output", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "inner", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "serializer", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "interceptors", "<init>", "(Laws/smithy/kotlin/runtime/io/Handler;Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;)V", "request", NotificationCompat.CATEGORY_CALL, "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class SerializeHandler<Input, Output> implements Handler<OperationRequest<Input>, Output> {
    private final Handler<OperationRequest<HttpRequestBuilder>, Output> inner;
    private final InterceptorExecutor<Input, Output> interceptors;
    private final HttpSerializer<Input> serializer;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.SerializeHandler$call$1 */
    /* JADX INFO: compiled from: SdkOperationExecution.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.SerializeHandler", m1609f = "SdkOperationExecution.kt", m1610i = {0, 1, 1, 2, 2, 2}, m1611l = {PDFACompliance.e_PDFA2_4_4, 254, 258}, m1612m = NotificationCompat.CATEGORY_CALL, m1613n = {"request", "request", "modified", "request", "modified", "requestBuilder"}, m1614nl = {245, PDFACompliance.e_PDFA2_5_2, -1}, m1615s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C37371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SerializeHandler<Input, Output> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37371(SerializeHandler<Input, Output> serializeHandler, Continuation<? super C37371> continuation) {
            super(continuation);
            this.this$0 = serializeHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.call((OperationRequest) null, (Continuation) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SerializeHandler(Handler<? super OperationRequest<HttpRequestBuilder>, ? extends Output> inner, HttpSerializer<Input> serializer, InterceptorExecutor<Input, Output> interceptors) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.inner = inner;
        this.serializer = serializer;
        this.interceptors = interceptors;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ff A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0100 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object call(OperationRequest<Input> operationRequest, Continuation<? super Output> continuation) {
        C37371 c37371;
        OperationRequest operationRequestCopy$default;
        OperationRequest<Input> operationRequest2;
        OperationRequest operationRequest3;
        HttpRequestBuilder httpRequestBuilderSerialize;
        if (continuation instanceof C37371) {
            c37371 = (C37371) continuation;
            if ((c37371.label & Integer.MIN_VALUE) != 0) {
                c37371.label -= Integer.MIN_VALUE;
            } else {
                c37371 = new C37371(this, continuation);
            }
        }
        Object objModifyBeforeSerialization = c37371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37371.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objModifyBeforeSerialization);
            InterceptorExecutor<Input, Output> interceptorExecutor = this.interceptors;
            Input subject = operationRequest.getSubject();
            c37371.L$0 = operationRequest;
            c37371.label = 1;
            objModifyBeforeSerialization = interceptorExecutor.modifyBeforeSerialization(subject, c37371);
            if (objModifyBeforeSerialization != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objModifyBeforeSerialization);
                return objModifyBeforeSerialization;
            }
            operationRequest3 = (OperationRequest) c37371.L$1;
            operationRequest2 = (OperationRequest) c37371.L$0;
            ResultKt.throwOnFailure(objModifyBeforeSerialization);
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) objModifyBeforeSerialization;
            operationRequestCopy$default = operationRequest3;
            operationRequest = operationRequest2;
            httpRequestBuilderSerialize = httpRequestBuilder;
            this.interceptors.readAfterSerialization(HttpRequestBuilderKt.immutableView$default(httpRequestBuilderSerialize, false, 1, null));
            Handler<OperationRequest<HttpRequestBuilder>, Output> handler = this.inner;
            OperationRequest<HttpRequestBuilder> operationRequest4 = new OperationRequest<>(operationRequestCopy$default.getContext(), httpRequestBuilderSerialize);
            c37371.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
            c37371.L$1 = SpillingKt.nullOutSpilledVariable(operationRequestCopy$default);
            c37371.L$2 = SpillingKt.nullOutSpilledVariable(httpRequestBuilderSerialize);
            c37371.label = 3;
            Object objCall = handler.call(operationRequest4, c37371);
            return objCall == coroutine_suspended ? coroutine_suspended : objCall;
        }
        operationRequest = (OperationRequest) c37371.L$0;
        ResultKt.throwOnFailure(objModifyBeforeSerialization);
        operationRequestCopy$default = OperationRequest.copy$default(operationRequest, null, objModifyBeforeSerialization, 1, null);
        this.interceptors.readBeforeSerialization((Input) operationRequestCopy$default.getSubject());
        ExecutionContext context = operationRequest.getContext();
        AttributeKey<Object> operationInput = HttpOperationContext.INSTANCE.getOperationInput();
        Object subject2 = operationRequestCopy$default.getSubject();
        Intrinsics.checkNotNull(subject2, "null cannot be cast to non-null type kotlin.Any");
        context.set(operationInput, subject2);
        HttpSerializer<Input> httpSerializer = this.serializer;
        if (!(httpSerializer instanceof HttpSerializer.NonStreaming)) {
            if (!(httpSerializer instanceof HttpSerializer.Streaming)) {
                throw new NoWhenBranchMatchedException();
            }
            ExecutionContext context2 = operationRequestCopy$default.getContext();
            Object subject3 = operationRequestCopy$default.getSubject();
            c37371.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
            c37371.L$1 = operationRequestCopy$default;
            c37371.label = 2;
            Object objSerialize = ((HttpSerializer.Streaming) httpSerializer).serialize(context2, subject3, c37371);
            if (objSerialize != coroutine_suspended) {
                operationRequest2 = operationRequest;
                operationRequest3 = operationRequestCopy$default;
                objModifyBeforeSerialization = objSerialize;
                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) objModifyBeforeSerialization;
                operationRequestCopy$default = operationRequest3;
                operationRequest = operationRequest2;
                httpRequestBuilderSerialize = httpRequestBuilder2;
                this.interceptors.readAfterSerialization(HttpRequestBuilderKt.immutableView$default(httpRequestBuilderSerialize, false, 1, null));
                Handler<OperationRequest<HttpRequestBuilder>, Output> handler2 = this.inner;
                OperationRequest<HttpRequestBuilder> operationRequest42 = new OperationRequest<>(operationRequestCopy$default.getContext(), httpRequestBuilderSerialize);
                c37371.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
                c37371.L$1 = SpillingKt.nullOutSpilledVariable(operationRequestCopy$default);
                c37371.L$2 = SpillingKt.nullOutSpilledVariable(httpRequestBuilderSerialize);
                c37371.label = 3;
                Object objCall2 = handler2.call(operationRequest42, c37371);
                if (objCall2 == coroutine_suspended) {
                }
            }
        }
        httpRequestBuilderSerialize = ((HttpSerializer.NonStreaming) httpSerializer).serialize(operationRequestCopy$default.getContext(), operationRequestCopy$default.getSubject());
        this.interceptors.readAfterSerialization(HttpRequestBuilderKt.immutableView$default(httpRequestBuilderSerialize, false, 1, null));
        Handler<OperationRequest<HttpRequestBuilder>, Output> handler22 = this.inner;
        OperationRequest<HttpRequestBuilder> operationRequest422 = new OperationRequest<>(operationRequestCopy$default.getContext(), httpRequestBuilderSerialize);
        c37371.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
        c37371.L$1 = SpillingKt.nullOutSpilledVariable(operationRequestCopy$default);
        c37371.L$2 = SpillingKt.nullOutSpilledVariable(httpRequestBuilderSerialize);
        c37371.label = 3;
        Object objCall22 = handler22.call(operationRequest422, c37371);
        if (objCall22 == coroutine_suspended) {
        }
    }
}
