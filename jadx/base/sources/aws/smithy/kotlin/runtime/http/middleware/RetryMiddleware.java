package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.TimeoutScope;
import aws.smithy.kotlin.runtime.http.operation.TimeoutsKt$scopedTimeout$exceptionType$1;
import aws.smithy.kotlin.runtime.http.operation.TimeoutsKt$scopedTimeout$exceptionType$2;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.p011io.middleware.Middleware;
import aws.smithy.kotlin.runtime.retries.Outcome;
import aws.smithy.kotlin.runtime.retries.OutcomeKt;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
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
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: RetryMiddleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u0003B1\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJJ\u0010\u0013\u001a\u00028\u0001\"\u001e\b\u0002\u0010\u0010*\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u000f2\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0012\u001a\u00028\u0002H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014JN\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u001c\u0010\u0012\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001cR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001d¨\u0006\u001e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/middleware/RetryMiddleware;", "I", "O", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "strategy", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "policy", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "interceptors", "<init>", "(Laws/smithy/kotlin/runtime/retries/RetryStrategy;Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;)V", "Laws/smithy/kotlin/runtime/io/Handler;", "H", "request", "next", "handle", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "attempt", "Lkotlin/Result;", "tryAttempt-BWLJW6A", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/io/Handler;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAttempt", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RetryMiddleware<I, O> implements Middleware<OperationRequest<HttpRequestBuilder>, O> {
    private final InterceptorExecutor<I, O> interceptors;
    private final RetryPolicy<O> policy;
    private final RetryStrategy strategy;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$1 */
    /* JADX INFO: compiled from: RetryMiddleware.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware", m1609f = "RetryMiddleware.kt", m1610i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {40, 49, 146}, m1612m = "handle", m1613n = {"request", "next", "request", "next", "modified", "attempt", "wrappedPolicy", "request", "next", "modified", "attempt", "name$iv", "initialAttributes$iv", "spanKind$iv", "context$iv", "sourceComponent$iv$iv", "name$iv$iv", "sourceComponent$iv", "initialAttributes$iv$iv", "spanKind$iv$iv", "context$iv$iv", "tracer$iv$iv", "$this$withSpan$iv$iv$iv", "name$iv$iv$iv", "initialAttributes$iv$iv$iv", "spanKind$iv$iv$iv", "context$iv$iv$iv", "parent$iv$iv$iv", "span$iv$iv$iv", "span$iv$iv$iv$iv", "context$iv$iv$iv$iv", "telemetryCtxElement$iv$iv$iv$iv", "updatedCtx$iv$iv$iv$iv", "$i$f$withSpan", "$i$f$withSpan", "$i$f$withSpan", "$i$f$withSpan"}, m1614nl = {41, 68, 147}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "I$0", "I$1", "I$2", "I$3"}, m1616v = 2)
    static final class C37241<H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends O>> extends ContinuationImpl {
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
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RetryMiddleware<I, O> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37241(RetryMiddleware<I, O> retryMiddleware, Continuation<? super C37241> continuation) {
            super(continuation);
            this.this$0 = retryMiddleware;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handle((OperationRequest<HttpRequestBuilder>) null, (Handler) null, (Continuation) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RetryMiddleware(RetryStrategy strategy, RetryPolicy<? super O> policy, InterceptorExecutor<I, O> interceptors) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.strategy = strategy;
        this.policy = policy;
        this.interceptors = interceptors;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0159, code lost:
    
        if (r0 == r8) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x02c4, code lost:
    
        if (r0 == r8) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r1v14, types: [aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v20, types: [aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v23, types: [aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan] */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v6, types: [aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan] */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    @Override // aws.smithy.kotlin.runtime.p011io.middleware.Middleware
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends O>> Object handle(OperationRequest<HttpRequestBuilder> operationRequest, H h, Continuation<? super O> continuation) throws Throwable {
        C37241 c37241;
        ?? r22;
        OperationRequest<HttpRequestBuilder> operationRequest2;
        Handler handler;
        Context contextCurrent;
        CoroutineContext telemetryContextElement;
        CoroutineContext coroutineContext;
        TelemetryProvider provider;
        ContextManager contextManager;
        Object result;
        if (continuation instanceof C37241) {
            c37241 = (C37241) continuation;
            if ((c37241.label & Integer.MIN_VALUE) != 0) {
                c37241.label -= Integer.MIN_VALUE;
            } else {
                c37241 = new C37241(this, continuation);
            }
        }
        C37241 c372412 = c37241;
        Object objModifyBeforeRetryLoop = c372412.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? CreateSpan = c372412.label;
        ?? r10 = 1;
        r10 = 1;
        try {
            try {
                if (CreateSpan == 0) {
                    ResultKt.throwOnFailure(objModifyBeforeRetryLoop);
                    InterceptorExecutor<I, O> interceptorExecutor = this.interceptors;
                    HttpRequest httpRequestImmutableView = HttpRequestBuilderKt.immutableView(operationRequest.getSubject(), true);
                    operationRequest2 = operationRequest;
                    c372412.L$0 = operationRequest2;
                    handler = h;
                    c372412.L$1 = handler;
                    c372412.label = 1;
                    objModifyBeforeRetryLoop = interceptorExecutor.modifyBeforeRetryLoop(httpRequestImmutableView, c372412);
                    if (objModifyBeforeRetryLoop != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (CreateSpan != 1) {
                    if (CreateSpan == 2) {
                        ResultKt.throwOnFailure(objModifyBeforeRetryLoop);
                        result = OutcomeKt.toResult((Outcome) objModifyBeforeRetryLoop);
                        ResultKt.throwOnFailure(result);
                        return result;
                    }
                    if (CreateSpan != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i = c372412.I$3;
                    int i2 = c372412.I$2;
                    int i3 = c372412.I$1;
                    int i4 = c372412.I$0;
                    TraceSpan traceSpan = (TraceSpan) c372412.L$22;
                    ResultKt.throwOnFailure(objModifyBeforeRetryLoop);
                    CreateSpan = traceSpan;
                    CreateSpan.close();
                    result = ((Result) objModifyBeforeRetryLoop).getValue();
                    ResultKt.throwOnFailure(result);
                    return result;
                }
                Handler handler2 = (Handler) c372412.L$1;
                operationRequest2 = (OperationRequest) c372412.L$0;
                ResultKt.throwOnFailure(objModifyBeforeRetryLoop);
                handler = handler2;
                OperationRequest<HttpRequestBuilder> operationRequest3 = operationRequest2;
                OperationRequest operationRequestCopy$default = OperationRequest.copy$default(operationRequest3, null, HttpRequestKt.toBuilder((HttpRequest) objModifyBeforeRetryLoop), 1, null);
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = 1;
                if (RetryMiddlewareKt.isRetryable((HttpRequestBuilder) operationRequestCopy$default.getSubject())) {
                    PolicyLogger policyLogger = new PolicyLogger(this.policy, c372412.getContext());
                    RetryMiddleware$handle$result$outcome$1 retryMiddleware$handle$result$outcome$1 = new RetryMiddleware$handle$result$outcome$1(intRef, this, operationRequestCopy$default, handler, null);
                    c372412.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest3);
                    c372412.L$1 = SpillingKt.nullOutSpilledVariable(handler);
                    c372412.L$2 = SpillingKt.nullOutSpilledVariable(operationRequestCopy$default);
                    c372412.L$3 = SpillingKt.nullOutSpilledVariable(intRef);
                    c372412.L$4 = SpillingKt.nullOutSpilledVariable(policyLogger);
                    c372412.label = 2;
                    objModifyBeforeRetryLoop = this.strategy.retry(policyLogger, retryMiddleware$handle$result$outcome$1, c372412);
                } else {
                    Attributes attributesEmptyAttributes = AttributesKt.emptyAttributes();
                    SpanKind spanKind = SpanKind.INTERNAL;
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                    String qualifiedName = Reflection.getOrCreateKotlinClass(RetryMiddleware.class).getQualifiedName();
                    if (qualifiedName == null) {
                        throw new IllegalArgumentException("withSpan<T> cannot be used on an anonymous object".toString());
                    }
                    Tracer orCreateTracer = TelemetryProviderContextKt.getTelemetryProvider(c372412.getContext()).getTracerProvider().getOrCreateTracer(qualifiedName);
                    Context telemetryContext = TelemetryContextElementKt.getTelemetryContext(c372412.getContext());
                    CreateSpan = orCreateTracer.createSpan("Non-retryable attempt", attributesEmptyAttributes, spanKind, telemetryContext);
                    r22 = 1;
                    try {
                        TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) c372412.getContext().get(TelemetryProviderContext.INSTANCE);
                        contextCurrent = (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null || (contextManager = provider.getContextManager()) == null) ? null : contextManager.current();
                        if (contextCurrent != null) {
                            telemetryContextElement = new TelemetryContextElement(contextCurrent);
                        } else {
                            telemetryContextElement = (TelemetryContextElement) c372412.getContext().get(TelemetryContextElement.INSTANCE);
                            if (telemetryContextElement == null) {
                                telemetryContextElement = EmptyCoroutineContext.INSTANCE;
                            }
                        }
                        coroutineContext = telemetryContextElement;
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        CoroutineContext coroutineContextPlus = emptyCoroutineContext.plus(new TraceSpanContext(CreateSpan)).plus(coroutineContext).plus(CreateSpan.asContextElement());
                        CreateSpan = CreateSpan;
                        Handler handler3 = handler;
                        RetryMiddleware$handle$$inlined$withSpan$default$1 retryMiddleware$handle$$inlined$withSpan$default$1 = new RetryMiddleware$handle$$inlined$withSpan$default$1(CreateSpan, null, this, operationRequestCopy$default, handler3, intRef);
                        c372412.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest3);
                        c372412.L$1 = SpillingKt.nullOutSpilledVariable(handler3);
                        c372412.L$2 = SpillingKt.nullOutSpilledVariable(operationRequestCopy$default);
                        c372412.L$3 = SpillingKt.nullOutSpilledVariable(intRef);
                        c372412.L$4 = SpillingKt.nullOutSpilledVariable("Non-retryable attempt");
                        c372412.L$5 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
                        c372412.L$6 = SpillingKt.nullOutSpilledVariable(spanKind);
                        c372412.L$7 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                        c372412.L$8 = SpillingKt.nullOutSpilledVariable(qualifiedName);
                        c372412.L$9 = SpillingKt.nullOutSpilledVariable("Non-retryable attempt");
                        c372412.L$10 = SpillingKt.nullOutSpilledVariable(qualifiedName);
                        c372412.L$11 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
                        c372412.L$12 = SpillingKt.nullOutSpilledVariable(spanKind);
                        c372412.L$13 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                        c372412.L$14 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
                        c372412.L$15 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
                        c372412.L$16 = SpillingKt.nullOutSpilledVariable("Non-retryable attempt");
                        c372412.L$17 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
                        c372412.L$18 = SpillingKt.nullOutSpilledVariable(spanKind);
                        c372412.L$19 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                        c372412.L$20 = SpillingKt.nullOutSpilledVariable(telemetryContext);
                        c372412.L$21 = SpillingKt.nullOutSpilledVariable(CreateSpan);
                        c372412.L$22 = CreateSpan;
                        c372412.L$23 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                        c372412.L$24 = SpillingKt.nullOutSpilledVariable(coroutineContext);
                        c372412.L$25 = SpillingKt.nullOutSpilledVariable(contextCurrent);
                        c372412.I$0 = 0;
                        c372412.I$1 = 0;
                        c372412.I$2 = 0;
                        c372412.I$3 = 0;
                        c372412.label = 3;
                        objModifyBeforeRetryLoop = BuildersKt.withContext(coroutineContextPlus, retryMiddleware$handle$$inlined$withSpan$default$1, c372412);
                        CreateSpan = CreateSpan;
                        r10 = contextCurrent;
                    } catch (Exception e2) {
                        e = e2;
                        CreateSpan = CreateSpan;
                        if (e instanceof CancellationException) {
                            TraceSpanExtKt.setAttribute(CreateSpan, "cancelled", Boxing.boxBoolean(r22));
                        } else {
                            CreateSpan.setStatus(SpanStatus.ERROR);
                            TraceSpanExtKt.recordException(CreateSpan, e, r22);
                        }
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        CreateSpan = CreateSpan;
                        CreateSpan.close();
                        throw th;
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            r22 = r10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0149, code lost:
    
        if (r0 == r6) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0182, code lost:
    
        if (r0 == r6) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a8 A[Catch: all -> 0x01c6, TryCatch #1 {all -> 0x01c6, blocks: (B:38:0x0186, B:40:0x018c, B:42:0x01a8, B:44:0x01b0, B:48:0x01bf, B:49:0x01c5, B:45:0x01b5, B:46:0x01ba, B:47:0x01bb, B:30:0x00ef, B:32:0x010c, B:35:0x014d), top: B:69:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01bb A[Catch: all -> 0x01c6, TryCatch #1 {all -> 0x01c6, blocks: (B:38:0x0186, B:40:0x018c, B:42:0x01a8, B:44:0x01b0, B:48:0x01bf, B:49:0x01c5, B:45:0x01b5, B:46:0x01ba, B:47:0x01bb, B:30:0x00ef, B:32:0x010c, B:35:0x014d), top: B:69:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX INFO: renamed from: tryAttempt-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12216tryAttemptBWLJW6A(OperationRequest<HttpRequestBuilder> operationRequest, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends O> handler, int i, Continuation<? super Result<? extends O>> continuation) {
        RetryMiddleware$tryAttempt$1 retryMiddleware$tryAttempt$1;
        Object objCreateFailure;
        Object objM14499constructorimpl;
        Object objM12210modifyBeforeAttemptCompletion3t6e044;
        HttpCall httpCall;
        HttpRequest httpRequest;
        Duration duration;
        TimeoutScope.Attempt attempt;
        TimeoutsKt$scopedTimeout$exceptionType$1 timeoutsKt$scopedTimeout$exceptionType$1;
        OperationRequest<HttpRequestBuilder> operationRequest2 = operationRequest;
        Handler handler2 = handler;
        int i2 = i;
        if (continuation instanceof RetryMiddleware$tryAttempt$1) {
            retryMiddleware$tryAttempt$1 = (RetryMiddleware$tryAttempt$1) continuation;
            if ((retryMiddleware$tryAttempt$1.label & Integer.MIN_VALUE) != 0) {
                retryMiddleware$tryAttempt$1.label -= Integer.MIN_VALUE;
            } else {
                retryMiddleware$tryAttempt$1 = new RetryMiddleware$tryAttempt$1(this, continuation);
            }
        }
        Object objM16018withTimeoutKLykuaI = retryMiddleware$tryAttempt$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = retryMiddleware$tryAttempt$1.label;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (i3 == 0) {
            ResultKt.throwOnFailure(objM16018withTimeoutKLykuaI);
            objCreateFailure = this.interceptors.m12213readBeforeAttemptIoAF18A(HttpRequestBuilderKt.immutableView$default(operationRequest2.getSubject(), false, 1, null));
            if (Result.m14506isSuccessimpl(objCreateFailure)) {
                Result.Companion companion = Result.INSTANCE;
                Unit unit = (Unit) objCreateFailure;
                duration = (Duration) operationRequest2.getContext().getOrNull(HttpOperationContext.INSTANCE.getAttemptTimeout());
                attempt = new TimeoutScope.Attempt(i2);
                if (duration == null) {
                    retryMiddleware$tryAttempt$1.L$0 = operationRequest2;
                    retryMiddleware$tryAttempt$1.L$1 = SpillingKt.nullOutSpilledVariable(handler2);
                    retryMiddleware$tryAttempt$1.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                    retryMiddleware$tryAttempt$1.L$3 = SpillingKt.nullOutSpilledVariable(duration);
                    retryMiddleware$tryAttempt$1.L$4 = SpillingKt.nullOutSpilledVariable(attempt);
                    retryMiddleware$tryAttempt$1.L$5 = SpillingKt.nullOutSpilledVariable(duration);
                    retryMiddleware$tryAttempt$1.L$6 = SpillingKt.nullOutSpilledVariable(retryMiddleware$tryAttempt$1);
                    retryMiddleware$tryAttempt$1.L$7 = SpillingKt.nullOutSpilledVariable(retryMiddleware$tryAttempt$1);
                    retryMiddleware$tryAttempt$1.I$0 = i2;
                    retryMiddleware$tryAttempt$1.I$1 = 0;
                    retryMiddleware$tryAttempt$1.I$2 = 0;
                    retryMiddleware$tryAttempt$1.I$3 = 0;
                    retryMiddleware$tryAttempt$1.label = 1;
                    objM16018withTimeoutKLykuaI = handler2.call(operationRequest2, retryMiddleware$tryAttempt$1);
                } else {
                    try {
                        long rawValue = duration.getRawValue();
                        C3726x207d93e2 c3726x207d93e2 = new C3726x207d93e2(null, handler2, operationRequest2);
                        retryMiddleware$tryAttempt$1.L$0 = operationRequest2;
                        retryMiddleware$tryAttempt$1.L$1 = SpillingKt.nullOutSpilledVariable(handler2);
                        retryMiddleware$tryAttempt$1.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                        retryMiddleware$tryAttempt$1.L$3 = SpillingKt.nullOutSpilledVariable(duration);
                        retryMiddleware$tryAttempt$1.L$4 = attempt;
                        retryMiddleware$tryAttempt$1.L$5 = duration;
                        retryMiddleware$tryAttempt$1.L$6 = SpillingKt.nullOutSpilledVariable(retryMiddleware$tryAttempt$1);
                        retryMiddleware$tryAttempt$1.I$0 = i2;
                        retryMiddleware$tryAttempt$1.I$1 = 0;
                        retryMiddleware$tryAttempt$1.I$2 = 0;
                        retryMiddleware$tryAttempt$1.label = 2;
                        objM16018withTimeoutKLykuaI = TimeoutKt.m16018withTimeoutKLykuaI(rawValue, c3726x207d93e2, retryMiddleware$tryAttempt$1);
                    } catch (TimeoutCancellationException e) {
                        e = e;
                        String str = attempt.getDescription() + " exceeded configured timeout of " + duration;
                        if (!(attempt instanceof TimeoutScope.Attempt)) {
                            timeoutsKt$scopedTimeout$exceptionType$1 = TimeoutsKt$scopedTimeout$exceptionType$1.INSTANCE;
                        } else {
                            if (!Intrinsics.areEqual(attempt, TimeoutScope.Call.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            timeoutsKt$scopedTimeout$exceptionType$1 = TimeoutsKt$scopedTimeout$exceptionType$2.INSTANCE;
                        }
                        throw ((Throwable) timeoutsKt$scopedTimeout$exceptionType$1.invoke(str, e));
                    }
                }
            }
            objM14499constructorimpl = Result.m14499constructorimpl(objCreateFailure);
        } else if (i3 == 1) {
            int i4 = retryMiddleware$tryAttempt$1.I$3;
            int i5 = retryMiddleware$tryAttempt$1.I$2;
            int i6 = retryMiddleware$tryAttempt$1.I$1;
            int i7 = retryMiddleware$tryAttempt$1.I$0;
            handler2 = (Handler) retryMiddleware$tryAttempt$1.L$1;
            OperationRequest<HttpRequestBuilder> operationRequest3 = (OperationRequest) retryMiddleware$tryAttempt$1.L$0;
            try {
                ResultKt.throwOnFailure(objM16018withTimeoutKLykuaI);
                i2 = i7;
                operationRequest2 = operationRequest3;
                objM14499constructorimpl = Result.m14499constructorimpl(objM16018withTimeoutKLykuaI);
            } catch (Throwable th2) {
                th = th2;
                i2 = i7;
                operationRequest2 = operationRequest3;
                Result.Companion companion2 = Result.INSTANCE;
                objCreateFailure = ResultKt.createFailure(th);
                objM14499constructorimpl = Result.m14499constructorimpl(objCreateFailure);
            }
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i8 = retryMiddleware$tryAttempt$1.I$0;
                httpRequest = (HttpRequest) retryMiddleware$tryAttempt$1.L$5;
                httpCall = (HttpCall) retryMiddleware$tryAttempt$1.L$4;
                Object obj = retryMiddleware$tryAttempt$1.L$2;
                ResultKt.throwOnFailure(objM16018withTimeoutKLykuaI);
                objM12210modifyBeforeAttemptCompletion3t6e044 = ((Result) objM16018withTimeoutKLykuaI).getValue();
                this.interceptors.readAfterAttempt(objM12210modifyBeforeAttemptCompletion3t6e044, httpRequest, httpCall != null ? httpCall.getResponse() : null);
                return objM12210modifyBeforeAttemptCompletion3t6e044;
            }
            int i9 = retryMiddleware$tryAttempt$1.I$2;
            int i10 = retryMiddleware$tryAttempt$1.I$1;
            int i11 = retryMiddleware$tryAttempt$1.I$0;
            Duration duration2 = (Duration) retryMiddleware$tryAttempt$1.L$5;
            TimeoutScope timeoutScope = (TimeoutScope) retryMiddleware$tryAttempt$1.L$4;
            Handler handler3 = (Handler) retryMiddleware$tryAttempt$1.L$1;
            OperationRequest<HttpRequestBuilder> operationRequest4 = (OperationRequest) retryMiddleware$tryAttempt$1.L$0;
            try {
                ResultKt.throwOnFailure(objM16018withTimeoutKLykuaI);
                i2 = i11;
                handler2 = handler3;
                operationRequest2 = operationRequest4;
                objM14499constructorimpl = Result.m14499constructorimpl(objM16018withTimeoutKLykuaI);
            } catch (TimeoutCancellationException e2) {
                e = e2;
                duration = duration2;
                attempt = timeoutScope;
                String str2 = attempt.getDescription() + " exceeded configured timeout of " + duration;
                if (!(attempt instanceof TimeoutScope.Attempt)) {
                }
                throw ((Throwable) timeoutsKt$scopedTimeout$exceptionType$1.invoke(str2, e));
            } catch (Throwable th3) {
                th = th3;
                i2 = i11;
                handler2 = handler3;
                operationRequest2 = operationRequest4;
                Result.Companion companion22 = Result.INSTANCE;
                objCreateFailure = ResultKt.createFailure(th);
                objM14499constructorimpl = Result.m14499constructorimpl(objCreateFailure);
            }
        }
        List listEmptyList = (List) operationRequest2.getContext().getOrNull(HttpOperationContext.INSTANCE.getHttpCallList());
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        HttpCall httpCall2 = (HttpCall) CollectionsKt.getOrNull(listEmptyList, i2 - 1);
        HttpRequest httpRequestImmutableView$default = HttpRequestBuilderKt.immutableView$default(operationRequest2.getSubject(), false, 1, null);
        InterceptorExecutor<I, O> interceptorExecutor = this.interceptors;
        HttpResponse response = httpCall2 != null ? httpCall2.getResponse() : null;
        retryMiddleware$tryAttempt$1.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest2);
        retryMiddleware$tryAttempt$1.L$1 = SpillingKt.nullOutSpilledVariable(handler2);
        retryMiddleware$tryAttempt$1.L$2 = SpillingKt.nullOutSpilledVariable(objM14499constructorimpl);
        retryMiddleware$tryAttempt$1.L$3 = SpillingKt.nullOutSpilledVariable(listEmptyList);
        retryMiddleware$tryAttempt$1.L$4 = httpCall2;
        retryMiddleware$tryAttempt$1.L$5 = httpRequestImmutableView$default;
        retryMiddleware$tryAttempt$1.L$6 = null;
        retryMiddleware$tryAttempt$1.L$7 = null;
        retryMiddleware$tryAttempt$1.I$0 = i2;
        retryMiddleware$tryAttempt$1.label = 3;
        objM12210modifyBeforeAttemptCompletion3t6e044 = interceptorExecutor.m12210modifyBeforeAttemptCompletion3t6e044(objM14499constructorimpl, httpRequestImmutableView$default, response, retryMiddleware$tryAttempt$1);
        if (objM12210modifyBeforeAttemptCompletion3t6e044 != coroutine_suspended) {
            httpCall = httpCall2;
            httpRequest = httpRequestImmutableView$default;
            this.interceptors.readAfterAttempt(objM12210modifyBeforeAttemptCompletion3t6e044, httpRequest, httpCall != null ? httpCall.getResponse() : null);
            return objM12210modifyBeforeAttemptCompletion3t6e044;
        }
        return coroutine_suspended;
    }
}
