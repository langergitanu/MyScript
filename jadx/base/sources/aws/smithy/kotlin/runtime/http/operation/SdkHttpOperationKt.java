package aws.smithy.kotlin.runtime.http.operation;

import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpCallKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContext;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import aws.smithy.kotlin.runtime.telemetry.context.ContextManager;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElement;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanStatus;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanContext;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanExtKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: SdkHttpOperation.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aV\u0010\u000b\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022 \u0010\t\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\b2\u0006\u0010\n\u001a\u00028\u0000H\u0087@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0080\u0001\u0010\u0012\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\r*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022 \u0010\t\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\b2\u0006\u0010\n\u001a\u00028\u00002\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0087@¢\u0006\u0004\b\u0012\u0010\u0013\u001aH\u0010\u0019\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00142\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u0017*\u00020\u0016H\u0082@¢\u0006\u0004\b\u001b\u0010\u001c\"\u001e\u0010\"\u001a\u00020\u001d*\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"I", "O", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/http/HttpCall;", "Laws/smithy/kotlin/runtime/http/HttpHandler;", "httpHandler", "input", "roundTrip", "(Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;Laws/smithy/kotlin/runtime/io/Handler;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "block", "execute", "(Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;Laws/smithy/kotlin/runtime/io/Handler;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperationBuilder;", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "", "Lkotlin/ExtensionFunctionType;", WebViewMessageType.CONTEXT, "(Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperationBuilder;Lkotlin/jvm/functions/Function1;)V", "cleanup", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getSdkInvocationId", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Ljava/lang/String;", "getSdkInvocationId$annotations", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;)V", "sdkInvocationId", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkHttpOperationKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$cleanup$1 */
    /* JADX INFO: compiled from: SdkHttpOperation.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt", m1609f = "SdkHttpOperation.kt", m1610i = {0, 0, 0, 0, 0, 0, 1}, m1611l = {176, 179}, m1612m = "cleanup", m1613n = {"$this$cleanup", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-SdkHttpOperationKt$cleanup$2", "$this$cleanup"}, m1614nl = {PDFACompliance.e_PDFA1_8_2, SensibleDefaults.X_OFFSET}, m1615s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "L$0"}, m1616v = 2)
    static final class C37321 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C37321(Continuation<? super C37321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkHttpOperationKt.cleanup(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$execute$1 */
    /* JADX INFO: compiled from: SdkHttpOperation.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt", m1609f = "SdkHttpOperation.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {TsExtractor.TS_PACKET_SIZE, 118, 118}, m1612m = "execute", m1613n = {"$this$execute", "httpHandler", "input", "block", "handler", "request", TtmlNode.TAG_SPAN, "telemetryCtx", "span$iv", "context$iv", "telemetryCtxElement$iv", "updatedCtx$iv", "$i$f$withSpan", "$this$execute", "httpHandler", "input", "block", "handler", "request", TtmlNode.TAG_SPAN, "telemetryCtx", "$this$execute", "httpHandler", "input", "block", "handler", "request", TtmlNode.TAG_SPAN, "telemetryCtx"}, m1614nl = {PsExtractor.PRIVATE_STREAM_1, 113, -1}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, m1616v = 2)
    static final class C37331<I, O, R> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C37331(Continuation<? super C37331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkHttpOperationKt.execute(null, null, null, null, this);
        }
    }

    @InternalApi
    public static /* synthetic */ void getSdkInvocationId$annotations(ExecutionContext executionContext) {
    }

    public static final String getSdkInvocationId(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        return (String) AttributesKt.get(executionContext, HttpOperationContext.INSTANCE.getSdkInvocationId());
    }

    /* JADX INFO: Add missing generic type declarations: [O] */
    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$roundTrip$2 */
    /* JADX INFO: compiled from: SdkHttpOperation.kt */
    @Metadata(m1598d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\n"}, m1599d2 = {"<anonymous>", "O", "it"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$roundTrip$2", m1609f = "SdkHttpOperation.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C37342<O> extends SuspendLambda implements Function2<O, Continuation<? super O>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C37342(Continuation<? super C37342> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C37342 c37342 = new C37342(continuation);
            c37342.L$0 = obj;
            return c37342;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(O o, Continuation<? super O> continuation) {
            return ((C37342) create(o, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2 = this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj2;
        }
    }

    @InternalApi
    public static final <I, O> Object roundTrip(SdkHttpOperation<I, O> sdkHttpOperation, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler, I i, Continuation<? super O> continuation) {
        return execute(sdkHttpOperation, handler, i, new C37342(null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0206 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0228 A[Catch: all -> 0x023e, TryCatch #9 {all -> 0x023e, blocks: (B:70:0x0224, B:72:0x0228, B:74:0x023d, B:73:0x0232), top: B:88:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0232 A[Catch: all -> 0x023e, TryCatch #9 {all -> 0x023e, blocks: (B:70:0x0224, B:72:0x0228, B:74:0x023d, B:73:0x0232), top: B:88:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <I, O, R> Object execute(SdkHttpOperation<I, O> sdkHttpOperation, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler, I i, Function2<? super O, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws Throwable {
        C37331 c37331;
        Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler2;
        OperationRequest operationRequest;
        Object obj;
        TraceSpan traceSpanComponent1;
        CoroutineContext coroutineContext;
        TraceSpan traceSpan;
        Handler handler3;
        Function2<? super O, ? super Continuation<? super R>, ? extends Object> function22;
        CoroutineContext telemetryContextElement;
        Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler4;
        CoroutineContext coroutineContext2;
        OperationRequest operationRequest2;
        Object obj2;
        SdkHttpOperation<I, O> sdkHttpOperation2;
        TraceSpan traceSpan2;
        TelemetryProvider provider;
        ContextManager contextManager;
        ExecutionContext context;
        ExecutionContext context2;
        SdkHttpOperation<I, O> sdkHttpOperation3 = sdkHttpOperation;
        if (continuation instanceof C37331) {
            c37331 = (C37331) continuation;
            if ((c37331.label & Integer.MIN_VALUE) != 0) {
                c37331.label -= Integer.MIN_VALUE;
            } else {
                c37331 = new C37331(continuation);
            }
        }
        Object objWithContext = c37331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c37331.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            handler2 = handler;
            Handler handlerDecorate = SdkOperationExecutionKt.decorate(sdkHttpOperation3.getExecution(), handler2, sdkHttpOperation3);
            obj = i;
            operationRequest = new OperationRequest(sdkHttpOperation3.getContext(), obj);
            Pair<TraceSpan, CoroutineContext> pairInstrument = OperationTelemetryKt.instrument(sdkHttpOperation3);
            traceSpanComponent1 = pairInstrument.component1();
            CoroutineContext coroutineContextComponent2 = pairInstrument.component2();
            try {
                TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) c37331.get$context().get(TelemetryProviderContext.INSTANCE);
                Context contextCurrent = (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null || (contextManager = provider.getContextManager()) == null) ? null : contextManager.current();
                if (contextCurrent != null) {
                    telemetryContextElement = new TelemetryContextElement(contextCurrent);
                } else {
                    telemetryContextElement = (TelemetryContextElement) c37331.get$context().get(TelemetryContextElement.INSTANCE);
                    if (telemetryContextElement == null) {
                        telemetryContextElement = EmptyCoroutineContext.INSTANCE;
                    }
                }
                CoroutineContext coroutineContext3 = telemetryContextElement;
                CoroutineContext coroutineContextPlus = coroutineContextComponent2.plus(new TraceSpanContext(traceSpanComponent1)).plus(coroutineContext3).plus(traceSpanComponent1.asContextElement());
                try {
                    coroutineContext = coroutineContextComponent2;
                    try {
                        SdkHttpOperationKt$execute$$inlined$withSpan$1 sdkHttpOperationKt$execute$$inlined$withSpan$1 = new SdkHttpOperationKt$execute$$inlined$withSpan$1(traceSpanComponent1, null, handlerDecorate, operationRequest, function2);
                        c37331.L$0 = sdkHttpOperation3;
                        c37331.L$1 = SpillingKt.nullOutSpilledVariable(handler2);
                        c37331.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        c37331.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                        c37331.L$4 = SpillingKt.nullOutSpilledVariable(handlerDecorate);
                        c37331.L$5 = SpillingKt.nullOutSpilledVariable(operationRequest);
                        c37331.L$6 = SpillingKt.nullOutSpilledVariable(traceSpanComponent1);
                        c37331.L$7 = SpillingKt.nullOutSpilledVariable(coroutineContext);
                        c37331.L$8 = traceSpanComponent1;
                        c37331.L$9 = SpillingKt.nullOutSpilledVariable(coroutineContext);
                        c37331.L$10 = SpillingKt.nullOutSpilledVariable(coroutineContext3);
                        c37331.L$11 = SpillingKt.nullOutSpilledVariable(contextCurrent);
                        c37331.I$0 = 0;
                        c37331.label = 1;
                        objWithContext = BuildersKt.withContext(coroutineContextPlus, sdkHttpOperationKt$execute$$inlined$withSpan$1, c37331);
                        if (objWithContext != coroutine_suspended) {
                            handler4 = handler2;
                            traceSpan = traceSpanComponent1;
                            handler3 = handlerDecorate;
                            coroutineContext2 = coroutineContext;
                            function22 = function2;
                            operationRequest2 = operationRequest;
                            obj2 = obj;
                            sdkHttpOperation2 = sdkHttpOperation3;
                            traceSpan2 = traceSpan;
                            traceSpan2.close();
                            context2 = sdkHttpOperation2.getContext();
                            c37331.L$0 = SpillingKt.nullOutSpilledVariable(sdkHttpOperation2);
                            c37331.L$1 = SpillingKt.nullOutSpilledVariable(handler4);
                            c37331.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                            c37331.L$3 = SpillingKt.nullOutSpilledVariable(function22);
                            c37331.L$4 = SpillingKt.nullOutSpilledVariable(handler3);
                            c37331.L$5 = SpillingKt.nullOutSpilledVariable(operationRequest2);
                            c37331.L$6 = SpillingKt.nullOutSpilledVariable(traceSpan);
                            c37331.L$7 = SpillingKt.nullOutSpilledVariable(coroutineContext2);
                            c37331.L$8 = objWithContext;
                            c37331.L$9 = null;
                            c37331.L$10 = null;
                            c37331.L$11 = null;
                            c37331.label = 2;
                            if (cleanup(context2, c37331) == coroutine_suspended) {
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        traceSpan = traceSpanComponent1;
                        handler3 = handlerDecorate;
                        function22 = function2;
                        if (e instanceof CancellationException) {
                            traceSpanComponent1.setStatus(SpanStatus.ERROR);
                            TraceSpanExtKt.recordException(traceSpanComponent1, e, true);
                        } else {
                            TraceSpanExtKt.setAttribute(traceSpanComponent1, "cancelled", Boxing.boxBoolean(true));
                        }
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        traceSpan = traceSpanComponent1;
                        handler3 = handlerDecorate;
                        function22 = function2;
                        traceSpanComponent1.close();
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    coroutineContext = coroutineContextComponent2;
                } catch (Throwable th2) {
                    th = th2;
                    coroutineContext = coroutineContextComponent2;
                }
            } catch (Exception e3) {
                e = e3;
                coroutineContext = coroutineContextComponent2;
            } catch (Throwable th3) {
                th = th3;
                coroutineContext = coroutineContextComponent2;
            }
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    Object obj3 = c37331.L$8;
                    Object obj4 = c37331.L$2;
                    ResultKt.throwOnFailure(objWithContext);
                    return obj3;
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Throwable th4 = (Throwable) c37331.L$8;
                Object obj5 = c37331.L$2;
                ResultKt.throwOnFailure(objWithContext);
                throw th4;
            }
            int i3 = c37331.I$0;
            traceSpan2 = (TraceSpan) c37331.L$8;
            coroutineContext2 = (CoroutineContext) c37331.L$7;
            traceSpan = (TraceSpan) c37331.L$6;
            operationRequest2 = (OperationRequest) c37331.L$5;
            handler3 = (Handler) c37331.L$4;
            function22 = (Function2) c37331.L$3;
            obj2 = c37331.L$2;
            handler4 = (Handler) c37331.L$1;
            sdkHttpOperation2 = (SdkHttpOperation) c37331.L$0;
            try {
                ResultKt.throwOnFailure(objWithContext);
                try {
                    traceSpan2.close();
                    context2 = sdkHttpOperation2.getContext();
                    c37331.L$0 = SpillingKt.nullOutSpilledVariable(sdkHttpOperation2);
                    c37331.L$1 = SpillingKt.nullOutSpilledVariable(handler4);
                    c37331.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                    c37331.L$3 = SpillingKt.nullOutSpilledVariable(function22);
                    c37331.L$4 = SpillingKt.nullOutSpilledVariable(handler3);
                    c37331.L$5 = SpillingKt.nullOutSpilledVariable(operationRequest2);
                    c37331.L$6 = SpillingKt.nullOutSpilledVariable(traceSpan);
                    c37331.L$7 = SpillingKt.nullOutSpilledVariable(coroutineContext2);
                    c37331.L$8 = objWithContext;
                    c37331.L$9 = null;
                    c37331.L$10 = null;
                    c37331.L$11 = null;
                    c37331.label = 2;
                    if (cleanup(context2, c37331) == coroutine_suspended) {
                        return objWithContext;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    Throwable th6 = th;
                    context = sdkHttpOperation2.getContext();
                    c37331.L$0 = SpillingKt.nullOutSpilledVariable(sdkHttpOperation2);
                    c37331.L$1 = SpillingKt.nullOutSpilledVariable(handler4);
                    c37331.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                    c37331.L$3 = SpillingKt.nullOutSpilledVariable(function22);
                    c37331.L$4 = SpillingKt.nullOutSpilledVariable(handler3);
                    c37331.L$5 = SpillingKt.nullOutSpilledVariable(operationRequest2);
                    c37331.L$6 = SpillingKt.nullOutSpilledVariable(traceSpan);
                    c37331.L$7 = SpillingKt.nullOutSpilledVariable(coroutineContext2);
                    c37331.L$8 = th6;
                    c37331.L$9 = null;
                    c37331.L$10 = null;
                    c37331.L$11 = null;
                    c37331.label = 3;
                    if (cleanup(context, c37331) != coroutine_suspended) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                traceSpanComponent1 = traceSpan2;
                sdkHttpOperation3 = sdkHttpOperation2;
                obj = obj2;
                operationRequest = operationRequest2;
                coroutineContext = coroutineContext2;
                handler2 = handler4;
                try {
                    if (e instanceof CancellationException) {
                    }
                    throw e;
                } catch (Throwable th7) {
                    th = th7;
                    try {
                        traceSpanComponent1.close();
                        throw th;
                    } catch (Throwable th8) {
                        th = th8;
                        handler4 = handler2;
                        operationRequest2 = operationRequest;
                        obj2 = obj;
                        coroutineContext2 = coroutineContext;
                        sdkHttpOperation2 = sdkHttpOperation3;
                        Throwable th62 = th;
                        context = sdkHttpOperation2.getContext();
                        c37331.L$0 = SpillingKt.nullOutSpilledVariable(sdkHttpOperation2);
                        c37331.L$1 = SpillingKt.nullOutSpilledVariable(handler4);
                        c37331.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                        c37331.L$3 = SpillingKt.nullOutSpilledVariable(function22);
                        c37331.L$4 = SpillingKt.nullOutSpilledVariable(handler3);
                        c37331.L$5 = SpillingKt.nullOutSpilledVariable(operationRequest2);
                        c37331.L$6 = SpillingKt.nullOutSpilledVariable(traceSpan);
                        c37331.L$7 = SpillingKt.nullOutSpilledVariable(coroutineContext2);
                        c37331.L$8 = th62;
                        c37331.L$9 = null;
                        c37331.L$10 = null;
                        c37331.L$11 = null;
                        c37331.label = 3;
                        if (cleanup(context, c37331) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        throw th62;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                traceSpanComponent1 = traceSpan2;
                sdkHttpOperation3 = sdkHttpOperation2;
                obj = obj2;
                operationRequest = operationRequest2;
                coroutineContext = coroutineContext2;
                handler2 = handler4;
                traceSpanComponent1.close();
                throw th;
            }
        }
        return coroutine_suspended;
    }

    @InternalApi
    public static final <I, O> void context(SdkHttpOperationBuilder<I, O> sdkHttpOperationBuilder, Function1<? super ExecutionContext, Unit> block) {
        Intrinsics.checkNotNullParameter(sdkHttpOperationBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(sdkHttpOperationBuilder.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00bd, code lost:
    
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r11, r0) != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bf, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object cleanup(ExecutionContext executionContext, Continuation<? super Unit> continuation) {
        C37321 c37321;
        Iterator it;
        Iterable iterable;
        int i;
        if (continuation instanceof C37321) {
            c37321 = (C37321) continuation;
            if ((c37321.label & Integer.MIN_VALUE) != 0) {
                c37321.label -= Integer.MIN_VALUE;
            } else {
                c37321 = new C37321(continuation);
            }
        }
        Object obj = c37321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c37321.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) executionContext.getOrNull(HttpOperationContext.INSTANCE.getHttpCallList());
            if (list != null) {
                List list2 = list;
                it = list2.iterator();
                iterable = list2;
                i = 0;
            }
            Job job = JobKt.getJob(executionContext.getCoroutineContext());
            c37321.L$0 = SpillingKt.nullOutSpilledVariable(executionContext);
            c37321.L$1 = null;
            c37321.L$2 = null;
            c37321.L$3 = null;
            c37321.L$4 = null;
            c37321.label = 2;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            int i3 = c37321.I$1;
            int i4 = c37321.I$0;
            Object obj2 = c37321.L$3;
            it = (Iterator) c37321.L$2;
            iterable = (Iterable) c37321.L$1;
            ExecutionContext executionContext2 = (ExecutionContext) c37321.L$0;
            ResultKt.throwOnFailure(obj);
            i = i4;
            executionContext = executionContext2;
        }
        while (it.hasNext()) {
            Object next = it.next();
            HttpCall httpCall = (HttpCall) next;
            c37321.L$0 = executionContext;
            c37321.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
            c37321.L$2 = it;
            c37321.L$3 = SpillingKt.nullOutSpilledVariable(next);
            c37321.L$4 = SpillingKt.nullOutSpilledVariable(httpCall);
            c37321.I$0 = i;
            c37321.I$1 = 0;
            c37321.label = 1;
            if (HttpCallKt.complete(httpCall, c37321) == coroutine_suspended) {
                break;
            }
        }
        Job job2 = JobKt.getJob(executionContext.getCoroutineContext());
        c37321.L$0 = SpillingKt.nullOutSpilledVariable(executionContext);
        c37321.L$1 = null;
        c37321.L$2 = null;
        c37321.L$3 = null;
        c37321.L$4 = null;
        c37321.label = 2;
    }
}
