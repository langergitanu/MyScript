package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.businessmetrics.SmithyBusinessMetric;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.OperationRequestKt;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [O] */
/* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withSpan$default$1 */
/* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "aws/smithy/kotlin/runtime/telemetry/trace/CoroutineContextTraceExtKt$withSpan$3"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withSpan$default$1", m1609f = "RetryMiddleware.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {140}, m1612m = "invokeSuspend", m1613n = {"$this$withContext", "$completion", "it", "$this$invokeSuspend_u24lambda_u240", "requestCopy", "$i$a$-withSpan$default-RetryMiddleware$handle$result$outcome$1$1"}, m1614nl = {PDFACompliance.e_PDFA1_4_1}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m1616v = 2)
public final class C3725x5172f99d<O> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super O>, Object> {
    final /* synthetic */ Ref.IntRef $attempt$inlined;
    final /* synthetic */ OperationRequest $modified$inlined;
    final /* synthetic */ Handler $next$inlined;
    final /* synthetic */ TraceSpan $span;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ RetryMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3725x5172f99d(TraceSpan traceSpan, Continuation continuation, RetryMiddleware retryMiddleware, OperationRequest operationRequest, Ref.IntRef intRef, Handler handler) {
        super(2, continuation);
        this.$span = traceSpan;
        this.this$0 = retryMiddleware;
        this.$modified$inlined = operationRequest;
        this.$attempt$inlined = intRef;
        this.$next$inlined = handler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C3725x5172f99d c3725x5172f99d = new C3725x5172f99d(this.$span, continuation, this.this$0, this.$modified$inlined, this.$attempt$inlined, this.$next$inlined);
        c3725x5172f99d.L$0 = obj;
        return c3725x5172f99d;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super O> continuation) {
        return ((C3725x5172f99d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM12216tryAttemptBWLJW6A;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TraceSpan traceSpan = this.$span;
            C3725x5172f99d<O> c3725x5172f99d = this;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(this.this$0.strategy.getClass());
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StandardRetryStrategy.class))) {
                BusinessMetricsUtilsKt.emitBusinessMetric(this.$modified$inlined.getContext(), (BusinessMetric) SmithyBusinessMetric.RETRY_MODE_STANDARD);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(AdaptiveRetryStrategy.class))) {
                BusinessMetricsUtilsKt.emitBusinessMetric(this.$modified$inlined.getContext(), (BusinessMetric) SmithyBusinessMetric.RETRY_MODE_ADAPTIVE);
            }
            if (this.$attempt$inlined.element > 1) {
                CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                final Ref.IntRef intRef = this.$attempt$inlined;
                Function0<String> function0 = new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "retrying request, attempt " + intRef.element;
                    }
                };
                LogLevel logLevel = LogLevel.Debug;
                String qualifiedName = Reflection.getOrCreateKotlinClass(RetryMiddleware.class).getQualifiedName();
                if (qualifiedName == null) {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
                CoroutineContextLogExtKt.log(coroutineContext, logLevel, qualifiedName, null, function0);
            }
            OperationRequest operationRequestDeepCopy = OperationRequestKt.deepCopy(this.$modified$inlined);
            RetryMiddleware retryMiddleware = this.this$0;
            Handler handler = this.$next$inlined;
            int i2 = this.$attempt$inlined.element;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(c3725x5172f99d);
            this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
            this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$4 = SpillingKt.nullOutSpilledVariable(operationRequestDeepCopy);
            this.I$0 = 0;
            this.label = 1;
            objM12216tryAttemptBWLJW6A = retryMiddleware.m12216tryAttemptBWLJW6A(operationRequestDeepCopy, handler, i2, this);
            if (objM12216tryAttemptBWLJW6A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM12216tryAttemptBWLJW6A = ((Result) obj).getValue();
        }
        this.$attempt$inlined.element++;
        ResultKt.throwOnFailure(objM12216tryAttemptBWLJW6A);
        return objM12216tryAttemptBWLJW6A;
    }
}
