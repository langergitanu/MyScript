package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContext;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import aws.smithy.kotlin.runtime.telemetry.context.ContextManager;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElement;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElementKt;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanKind;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanStatus;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanContext;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanExtKt;
import aws.smithy.kotlin.runtime.telemetry.trace.Tracer;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: Add missing generic type declarations: [O] */
/* JADX INFO: compiled from: RetryMiddleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, m1599d2 = {"<anonymous>", "O"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1", m1609f = "RetryMiddleware.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {145}, m1612m = "invokeSuspend", m1613n = {"name$iv", "initialAttributes$iv", "spanKind$iv", "context$iv", "sourceComponent$iv$iv", "name$iv$iv", "sourceComponent$iv", "initialAttributes$iv$iv", "spanKind$iv$iv", "context$iv$iv", "tracer$iv$iv", "$this$withSpan$iv$iv$iv", "name$iv$iv$iv", "initialAttributes$iv$iv$iv", "spanKind$iv$iv$iv", "context$iv$iv$iv", "parent$iv$iv$iv", "span$iv$iv$iv", "span$iv$iv$iv$iv", "context$iv$iv$iv$iv", "telemetryCtxElement$iv$iv$iv$iv", "updatedCtx$iv$iv$iv$iv", "$i$f$withSpan", "$i$f$withSpan", "$i$f$withSpan", "$i$f$withSpan"}, m1614nl = {146}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "I$3"}, m1616v = 2)
final class RetryMiddleware$handle$result$outcome$1<O> extends SuspendLambda implements Function1<Continuation<? super O>, Object> {
    final /* synthetic */ Ref.IntRef $attempt;
    final /* synthetic */ OperationRequest<HttpRequestBuilder> $modified;

    /* JADX INFO: Incorrect field signature: TH; */
    final /* synthetic */ Handler $next;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$18;
    Object L$19;
    Object L$2;
    Object L$20;
    Object L$21;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ RetryMiddleware<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/internal/Ref$IntRef;Laws/smithy/kotlin/runtime/http/middleware/RetryMiddleware<TI;TO;>;Laws/smithy/kotlin/runtime/http/operation/OperationRequest<Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;>;TH;Lkotlin/coroutines/Continuation<-Laws/smithy/kotlin/runtime/http/middleware/RetryMiddleware$handle$result$outcome$1;>;)V */
    RetryMiddleware$handle$result$outcome$1(Ref.IntRef intRef, RetryMiddleware retryMiddleware, OperationRequest operationRequest, Handler handler, Continuation continuation) {
        super(1, continuation);
        this.$attempt = intRef;
        this.this$0 = retryMiddleware;
        this.$modified = operationRequest;
        this.$next = handler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new RetryMiddleware$handle$result$outcome$1(this.$attempt, this.this$0, this.$modified, this.$next, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super O> continuation) {
        return ((RetryMiddleware$handle$result$outcome$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e0 A[Catch: all -> 0x006e, TryCatch #2 {all -> 0x006e, blocks: (B:6:0x0066, B:41:0x01dc, B:43:0x01e0, B:45:0x01f8, B:44:0x01ec), top: B:50:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ec A[Catch: all -> 0x006e, TryCatch #2 {all -> 0x006e, blocks: (B:6:0x0066, B:41:0x01dc, B:43:0x01e0, B:45:0x01f8, B:44:0x01ec), top: B:50:0x0009 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        TraceSpan traceSpanCreateSpan;
        TraceSpan traceSpan;
        String str;
        CoroutineContext telemetryContextElement;
        Object objWithContext;
        TelemetryProvider provider;
        ContextManager contextManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        try {
            if (r2 != 0) {
                if (r2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                traceSpan = (TraceSpan) this.L$18;
                try {
                    ResultKt.throwOnFailure(obj);
                    traceSpanCreateSpan = traceSpan;
                    objWithContext = obj;
                    traceSpanCreateSpan.close();
                    return objWithContext;
                } catch (Exception e) {
                    e = e;
                    if (e instanceof CancellationException) {
                        traceSpan.setStatus(SpanStatus.ERROR);
                        TraceSpanExtKt.recordException(traceSpan, e, true);
                    } else {
                        TraceSpanExtKt.setAttribute(traceSpan, "cancelled", Boxing.boxBoolean(true));
                    }
                    throw e;
                }
            }
            ResultKt.throwOnFailure(obj);
            String str2 = "Attempt-" + this.$attempt.element;
            RetryMiddleware retryMiddleware = this.this$0;
            OperationRequest<HttpRequestBuilder> operationRequest = this.$modified;
            Ref.IntRef intRef = this.$attempt;
            Handler handler = this.$next;
            Attributes attributesEmptyAttributes = AttributesKt.emptyAttributes();
            SpanKind spanKind = SpanKind.INTERNAL;
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            String qualifiedName = Reflection.getOrCreateKotlinClass(RetryMiddleware.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("withSpan<T> cannot be used on an anonymous object".toString());
            }
            Tracer orCreateTracer = TelemetryProviderContextKt.getTelemetryProvider(get$context()).getTracerProvider().getOrCreateTracer(qualifiedName);
            Context telemetryContext = TelemetryContextElementKt.getTelemetryContext(get$context());
            traceSpanCreateSpan = orCreateTracer.createSpan(str2, attributesEmptyAttributes, spanKind, telemetryContext);
            try {
                TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) get$context().get(TelemetryProviderContext.INSTANCE);
                Context contextCurrent = (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null || (contextManager = provider.getContextManager()) == null) ? null : contextManager.current();
                if (contextCurrent != null) {
                    telemetryContextElement = new TelemetryContextElement(contextCurrent);
                    str = str2;
                } else {
                    str = str2;
                    CoroutineContext coroutineContext = (TelemetryContextElement) get$context().get(TelemetryContextElement.INSTANCE);
                    if (coroutineContext == null) {
                        coroutineContext = EmptyCoroutineContext.INSTANCE;
                    }
                    telemetryContextElement = coroutineContext;
                }
                CoroutineContext coroutineContext2 = telemetryContextElement;
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.L$1 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
                this.L$2 = SpillingKt.nullOutSpilledVariable(spanKind);
                this.L$3 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                this.L$4 = SpillingKt.nullOutSpilledVariable(qualifiedName);
                this.L$5 = SpillingKt.nullOutSpilledVariable(str);
                this.L$6 = SpillingKt.nullOutSpilledVariable(qualifiedName);
                this.L$7 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
                this.L$8 = SpillingKt.nullOutSpilledVariable(spanKind);
                this.L$9 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                this.L$10 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
                this.L$11 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
                this.L$12 = SpillingKt.nullOutSpilledVariable(str);
                this.L$13 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
                this.L$14 = SpillingKt.nullOutSpilledVariable(spanKind);
                this.L$15 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                this.L$16 = SpillingKt.nullOutSpilledVariable(telemetryContext);
                this.L$17 = SpillingKt.nullOutSpilledVariable(traceSpanCreateSpan);
                this.L$18 = traceSpanCreateSpan;
                this.L$19 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                this.L$20 = SpillingKt.nullOutSpilledVariable(coroutineContext2);
                this.L$21 = SpillingKt.nullOutSpilledVariable(contextCurrent);
                this.I$0 = 0;
                this.I$1 = 0;
                this.I$2 = 0;
                this.I$3 = 0;
                this.label = 1;
                objWithContext = BuildersKt.withContext(emptyCoroutineContext.plus(new TraceSpanContext(traceSpanCreateSpan)).plus(coroutineContext2).plus(traceSpanCreateSpan.asContextElement()), new C3725x5172f99d(traceSpanCreateSpan, null, retryMiddleware, operationRequest, intRef, handler), this);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                traceSpanCreateSpan.close();
                return objWithContext;
            } catch (Exception e2) {
                e = e2;
                traceSpan = traceSpanCreateSpan;
                if (e instanceof CancellationException) {
                }
                throw e;
            } catch (Throwable th) {
                th = th;
                r2 = traceSpanCreateSpan;
                r2.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
