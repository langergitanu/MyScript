package aws.smithy.kotlin.runtime.telemetry.trace;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContext;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import aws.smithy.kotlin.runtime.telemetry.context.ContextManager;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElement;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElementKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a~\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00022>\b\u0004\u0010\u0011\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0014\u0012\b\b\n\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012¢\u0006\u0002\b\u0018H\u0087H¢\u0006\u0002\u0010\u0019\u001af\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00022>\b\u0004\u0010\u0011\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0014\u0012\b\b\n\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012¢\u0006\u0002\b\u0018H\u0087H¢\u0006\u0002\u0010\u001a\u001a\u0082\u0001\u0010\u0007\u001a\u0002H\b\"\u0006\b\u0000\u0010\u001b\u0018\u0001\"\u0004\b\u0001\u0010\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00022>\b\u0004\u0010\u0011\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0014\u0012\b\b\n\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012¢\u0006\u0002\b\u0018H\u0087H¢\u0006\u0002\u0010\u001c\u001a\u0082\u0001\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00022>\b\u0004\u0010\u0011\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0014\u0012\b\b\n\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012¢\u0006\u0002\b\u0018H\u0087H¢\u0006\u0002\u0010\u001e\" \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, m1599d2 = {"traceSpan", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "Lkotlin/coroutines/CoroutineContext;", "getTraceSpan$annotations", "(Lkotlin/coroutines/CoroutineContext;)V", "getTraceSpan", "(Lkotlin/coroutines/CoroutineContext;)Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "withSpan", "R", "Laws/smithy/kotlin/runtime/telemetry/trace/Tracer;", "name", "", "initialAttributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "spanKind", "Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;", WebViewMessageType.CONTEXT, "block", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", TtmlNode.TAG_SPAN, "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Laws/smithy/kotlin/runtime/telemetry/trace/Tracer;Ljava/lang/String;Laws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;Laws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sourceComponent", "(Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "telemetry-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CoroutineContextTraceExtKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt$withSpan$1 */
    /* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 176)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt", m1609f = "CoroutineContextTraceExt.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {PDFACompliance.e_PDFA1_3_2}, m1612m = "withSpan", m1613n = {"$this$withSpan", "name", "initialAttributes", "spanKind", WebViewMessageType.CONTEXT, "block", "parent", TtmlNode.TAG_SPAN, "span$iv", "context$iv", "telemetryCtxElement$iv", "updatedCtx$iv", "$i$f$withSpan", "$i$f$withSpan"}, m1614nl = {PDFACompliance.e_PDFA1_3_3}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1"}, m1616v = 2)
    static final class C37871<R> extends ContinuationImpl {
        int I$0;
        int I$1;
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

        C37871(Continuation<? super C37871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineContextTraceExtKt.withSpan((Tracer) null, (String) null, (Attributes) null, (SpanKind) null, (CoroutineContext) null, (Function3) null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt$withSpan$2 */
    /* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 176)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt", m1609f = "CoroutineContextTraceExt.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {74}, m1612m = "withSpan", m1613n = {TtmlNode.TAG_SPAN, WebViewMessageType.CONTEXT, "block", "updatedCtx", "telemetryCtxElement", "$i$f$withSpan"}, m1614nl = {87}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m1616v = 2)
    static final class C37882<R> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C37882(Continuation<? super C37882> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineContextTraceExtKt.withSpan(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt$withSpan$5 */
    /* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 176)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt", m1609f = "CoroutineContextTraceExt.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {135}, m1612m = "withSpan", m1613n = {"sourceComponent", "name", "initialAttributes", "spanKind", WebViewMessageType.CONTEXT, "block", "tracer", "$this$withSpan$iv", "name$iv", "initialAttributes$iv", "spanKind$iv", "context$iv", "parent$iv", "span$iv", "span$iv$iv", "context$iv$iv", "telemetryCtxElement$iv$iv", "updatedCtx$iv$iv", "$i$f$withSpan", "$i$f$withSpan", "$i$f$withSpan"}, m1614nl = {TsExtractor.TS_STREAM_TYPE_DTS_HD}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "I$2"}, m1616v = 2)
    static final class C37905<R> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
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

        C37905(Continuation<? super C37905> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineContextTraceExtKt.withSpan((String) null, (String) null, (Attributes) null, (SpanKind) null, (CoroutineContext) null, (Function3) null, this);
        }
    }

    @InternalApi
    public static /* synthetic */ void getTraceSpan$annotations(CoroutineContext coroutineContext) {
    }

    public static final TraceSpan getTraceSpan(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        TraceSpanContext traceSpanContext = (TraceSpanContext) coroutineContext.get(TraceSpanContext.INSTANCE);
        if (traceSpanContext != null) {
            return traceSpanContext.getTraceSpan();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x013b A[Catch: all -> 0x005f, TryCatch #3 {all -> 0x005f, blocks: (B:12:0x005a, B:46:0x0137, B:48:0x013b, B:50:0x0150, B:49:0x0145), top: B:53:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0145 A[Catch: all -> 0x005f, TryCatch #3 {all -> 0x005f, blocks: (B:12:0x005a, B:46:0x0137, B:48:0x013b, B:50:0x0150, B:49:0x0145), top: B:53:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object withSpan(Tracer tracer, String str, Attributes attributes, SpanKind spanKind, CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super TraceSpan, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) throws Throwable {
        C37871 c37871;
        TraceSpan traceSpan;
        CoroutineContext telemetryContextElement;
        TelemetryProvider provider;
        ContextManager contextManager;
        if (continuation instanceof C37871) {
            c37871 = (C37871) continuation;
            if ((c37871.label & Integer.MIN_VALUE) != 0) {
                c37871.label -= Integer.MIN_VALUE;
            } else {
                c37871 = new C37871(continuation);
            }
        }
        Object objWithContext = c37871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37871.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c37871.I$1;
            int i3 = c37871.I$0;
            traceSpan = (TraceSpan) c37871.L$8;
            try {
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    traceSpan.close();
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
            } catch (Throwable th) {
                th = th;
                traceSpan.close();
                throw th;
            }
        }
        ResultKt.throwOnFailure(objWithContext);
        Context telemetryContext = TelemetryContextElementKt.getTelemetryContext(c37871.get$context());
        TraceSpan traceSpanCreateSpan = tracer.createSpan(str, attributes, spanKind, telemetryContext);
        try {
            TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) c37871.get$context().get(TelemetryProviderContext.INSTANCE);
            Context contextCurrent = (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null || (contextManager = provider.getContextManager()) == null) ? null : contextManager.current();
            if (contextCurrent != null) {
                telemetryContextElement = new TelemetryContextElement(contextCurrent);
            } else {
                telemetryContextElement = (TelemetryContextElement) c37871.get$context().get(TelemetryContextElement.INSTANCE);
                if (telemetryContextElement == null) {
                    telemetryContextElement = EmptyCoroutineContext.INSTANCE;
                }
            }
            CoroutineContext coroutineContext2 = telemetryContextElement;
            CoroutineContext coroutineContextPlus = coroutineContext.plus(new TraceSpanContext(traceSpanCreateSpan)).plus(coroutineContext2).plus(traceSpanCreateSpan.asContextElement());
            C37893 c37893 = new C37893(function3, traceSpanCreateSpan, null);
            c37871.L$0 = SpillingKt.nullOutSpilledVariable(tracer);
            c37871.L$1 = SpillingKt.nullOutSpilledVariable(str);
            c37871.L$2 = SpillingKt.nullOutSpilledVariable(attributes);
            c37871.L$3 = SpillingKt.nullOutSpilledVariable(spanKind);
            c37871.L$4 = SpillingKt.nullOutSpilledVariable(coroutineContext);
            c37871.L$5 = SpillingKt.nullOutSpilledVariable(function3);
            c37871.L$6 = SpillingKt.nullOutSpilledVariable(telemetryContext);
            c37871.L$7 = SpillingKt.nullOutSpilledVariable(traceSpanCreateSpan);
            c37871.L$8 = traceSpanCreateSpan;
            c37871.L$9 = SpillingKt.nullOutSpilledVariable(coroutineContext);
            c37871.L$10 = SpillingKt.nullOutSpilledVariable(coroutineContext2);
            c37871.L$11 = SpillingKt.nullOutSpilledVariable(contextCurrent);
            c37871.I$0 = 0;
            c37871.I$1 = 0;
            c37871.label = 1;
            objWithContext = BuildersKt.withContext(coroutineContextPlus, c37893, c37871);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            traceSpan = traceSpanCreateSpan;
            traceSpan.close();
            return objWithContext;
        } catch (Exception e2) {
            e = e2;
            traceSpan = traceSpanCreateSpan;
            if (e instanceof CancellationException) {
            }
            throw e;
        } catch (Throwable th2) {
            th = th2;
            traceSpan = traceSpanCreateSpan;
            traceSpan.close();
            throw th;
        }
    }

    public static /* synthetic */ Object withSpan$default(Tracer tracer, String str, Attributes attributes, SpanKind spanKind, CoroutineContext coroutineContext, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            AttributesKt.emptyAttributes();
        }
        if ((i & 4) != 0) {
            SpanKind spanKind2 = SpanKind.INTERNAL;
        }
        if ((i & 8) != 0) {
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        Continuation continuation2 = null;
        continuation2.get$context();
        throw null;
    }

    @InternalApi
    private static final <R> Object withSpan$$forInline(Tracer tracer, String str, Attributes attributes, SpanKind spanKind, CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super TraceSpan, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        Continuation continuation2 = null;
        continuation2.get$context();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object withSpan(TraceSpan traceSpan, CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super TraceSpan, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        C37882 c37882;
        CoroutineContext telemetryContextElement;
        TelemetryProvider provider;
        ContextManager contextManager;
        if (continuation instanceof C37882) {
            c37882 = (C37882) continuation;
            if ((c37882.label & Integer.MIN_VALUE) != 0) {
                c37882.label -= Integer.MIN_VALUE;
            } else {
                c37882 = new C37882(continuation);
            }
        }
        Object objWithContext = c37882.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37882.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(objWithContext);
                    TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) c37882.get$context().get(TelemetryProviderContext.INSTANCE);
                    Context contextCurrent = (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null || (contextManager = provider.getContextManager()) == null) ? null : contextManager.current();
                    if (contextCurrent != null) {
                        telemetryContextElement = new TelemetryContextElement(contextCurrent);
                    } else {
                        telemetryContextElement = (TelemetryContextElement) c37882.get$context().get(TelemetryContextElement.INSTANCE);
                        if (telemetryContextElement == null) {
                            telemetryContextElement = EmptyCoroutineContext.INSTANCE;
                        }
                    }
                    CoroutineContext coroutineContext2 = telemetryContextElement;
                    CoroutineContext coroutineContextPlus = coroutineContext.plus(new TraceSpanContext(traceSpan)).plus(coroutineContext2).plus(traceSpan.asContextElement());
                    C37893 c37893 = new C37893(function3, traceSpan, null);
                    c37882.L$0 = traceSpan;
                    c37882.L$1 = SpillingKt.nullOutSpilledVariable(coroutineContext);
                    c37882.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c37882.L$3 = SpillingKt.nullOutSpilledVariable(contextCurrent);
                    c37882.L$4 = SpillingKt.nullOutSpilledVariable(coroutineContext2);
                    c37882.I$0 = 0;
                    c37882.label = 1;
                    objWithContext = BuildersKt.withContext(coroutineContextPlus, c37893, c37882);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i2 = c37882.I$0;
                    traceSpan = (TraceSpan) c37882.L$0;
                    ResultKt.throwOnFailure(objWithContext);
                }
                return objWithContext;
            } catch (Exception e) {
                if (e instanceof CancellationException) {
                    TraceSpanExtKt.setAttribute(traceSpan, "cancelled", Boxing.boxBoolean(true));
                } else {
                    traceSpan.setStatus(SpanStatus.ERROR);
                    TraceSpanExtKt.recordException(traceSpan, e, true);
                }
                throw e;
            }
        } finally {
            traceSpan.close();
        }
    }

    public static /* synthetic */ Object withSpan$default(TraceSpan traceSpan, CoroutineContext coroutineContext, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        Continuation continuation2 = null;
        try {
            try {
                continuation2.get$context();
                throw null;
            } catch (Exception e) {
                if (e instanceof CancellationException) {
                    TraceSpanExtKt.setAttribute(traceSpan, "cancelled", true);
                } else {
                    traceSpan.setStatus(SpanStatus.ERROR);
                    TraceSpanExtKt.recordException(traceSpan, e, true);
                }
                throw e;
            }
        } catch (Throwable th) {
            traceSpan.close();
            throw th;
        }
    }

    @InternalApi
    private static final <R> Object withSpan$$forInline(TraceSpan traceSpan, CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super TraceSpan, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        Continuation continuation2 = null;
        try {
            try {
                continuation2.get$context();
                throw null;
            } catch (Exception e) {
                if (e instanceof CancellationException) {
                    TraceSpanExtKt.setAttribute(traceSpan, "cancelled", true);
                } else {
                    traceSpan.setStatus(SpanStatus.ERROR);
                    TraceSpanExtKt.recordException(traceSpan, e, true);
                }
                throw e;
            }
        } catch (Throwable th) {
            traceSpan.close();
            throw th;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt$withSpan$3 */
    /* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
    @Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 176)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt$withSpan$3", m1609f = "CoroutineContextTraceExt.kt", m1610i = {0}, m1611l = {75}, m1612m = "invokeSuspend", m1613n = {"$this$withContext"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
    public static final class C37893<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function3<CoroutineScope, TraceSpan, Continuation<? super R>, Object> $block;
        final /* synthetic */ TraceSpan $span;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C37893(Function3<? super CoroutineScope, ? super TraceSpan, ? super Continuation<? super R>, ? extends Object> function3, TraceSpan traceSpan, Continuation<? super C37893> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$span = traceSpan;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C37893 c37893 = new C37893(this.$block, this.$span, continuation);
            c37893.L$0 = obj;
            return c37893;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((C37893) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function3<CoroutineScope, TraceSpan, Continuation<? super R>, Object> function3 = this.$block;
            TraceSpan traceSpan = this.$span;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.label = 1;
            Object objInvoke = function3.invoke(coroutineScope, traceSpan, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke((CoroutineScope) this.L$0, this.$span, this);
        }
    }

    public static /* synthetic */ Object withSpan$default(String str, Attributes attributes, SpanKind spanKind, CoroutineContext coroutineContext, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            AttributesKt.emptyAttributes();
        }
        if ((i & 4) != 0) {
            SpanKind spanKind2 = SpanKind.INTERNAL;
        }
        if ((i & 8) != 0) {
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        if (Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName() == null) {
            throw new IllegalArgumentException("withSpan<T> cannot be used on an anonymous object".toString());
        }
        Continuation continuation2 = null;
        continuation2.get$context();
        throw null;
    }

    @InternalApi
    public static final /* synthetic */ <T, R> Object withSpan(String str, Attributes attributes, SpanKind spanKind, CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super TraceSpan, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        if (Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName() == null) {
            throw new IllegalArgumentException("withSpan<T> cannot be used on an anonymous object".toString());
        }
        Continuation continuation2 = null;
        continuation2.get$context();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x019a A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:12:0x0076, B:46:0x0196, B:48:0x019a, B:50:0x01b1, B:49:0x01a5), top: B:53:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a5 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:12:0x0076, B:46:0x0196, B:48:0x019a, B:50:0x01b1, B:49:0x01a5), top: B:53:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object withSpan(String str, String str2, Attributes attributes, SpanKind spanKind, CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super TraceSpan, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) throws Throwable {
        C37905 c37905;
        TraceSpan traceSpan;
        CoroutineContext telemetryContextElement;
        TelemetryProvider provider;
        ContextManager contextManager;
        if (continuation instanceof C37905) {
            c37905 = (C37905) continuation;
            if ((c37905.label & Integer.MIN_VALUE) != 0) {
                c37905.label -= Integer.MIN_VALUE;
            } else {
                c37905 = new C37905(continuation);
            }
        }
        Object objWithContext = c37905.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37905.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c37905.I$2;
            int i3 = c37905.I$1;
            int i4 = c37905.I$0;
            traceSpan = (TraceSpan) c37905.L$14;
            try {
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    traceSpan.close();
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
            } catch (Throwable th) {
                th = th;
                traceSpan.close();
                throw th;
            }
        }
        ResultKt.throwOnFailure(objWithContext);
        Tracer orCreateTracer = TelemetryProviderContextKt.getTelemetryProvider(c37905.get$context()).getTracerProvider().getOrCreateTracer(str);
        Context telemetryContext = TelemetryContextElementKt.getTelemetryContext(c37905.get$context());
        TraceSpan traceSpanCreateSpan = orCreateTracer.createSpan(str2, attributes, spanKind, telemetryContext);
        try {
            TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) c37905.get$context().get(TelemetryProviderContext.INSTANCE);
            Context contextCurrent = (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null || (contextManager = provider.getContextManager()) == null) ? null : contextManager.current();
            if (contextCurrent != null) {
                telemetryContextElement = new TelemetryContextElement(contextCurrent);
            } else {
                telemetryContextElement = (TelemetryContextElement) c37905.get$context().get(TelemetryContextElement.INSTANCE);
                if (telemetryContextElement == null) {
                    telemetryContextElement = EmptyCoroutineContext.INSTANCE;
                }
            }
            CoroutineContext coroutineContext2 = telemetryContextElement;
            CoroutineContext coroutineContextPlus = coroutineContext.plus(new TraceSpanContext(traceSpanCreateSpan)).plus(coroutineContext2).plus(traceSpanCreateSpan.asContextElement());
            C37893 c37893 = new C37893(function3, traceSpanCreateSpan, null);
            c37905.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c37905.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c37905.L$2 = SpillingKt.nullOutSpilledVariable(attributes);
            c37905.L$3 = SpillingKt.nullOutSpilledVariable(spanKind);
            c37905.L$4 = SpillingKt.nullOutSpilledVariable(coroutineContext);
            c37905.L$5 = SpillingKt.nullOutSpilledVariable(function3);
            c37905.L$6 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
            c37905.L$7 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
            c37905.L$8 = SpillingKt.nullOutSpilledVariable(str2);
            c37905.L$9 = SpillingKt.nullOutSpilledVariable(attributes);
            c37905.L$10 = SpillingKt.nullOutSpilledVariable(spanKind);
            c37905.L$11 = SpillingKt.nullOutSpilledVariable(coroutineContext);
            c37905.L$12 = SpillingKt.nullOutSpilledVariable(telemetryContext);
            c37905.L$13 = SpillingKt.nullOutSpilledVariable(traceSpanCreateSpan);
            c37905.L$14 = traceSpanCreateSpan;
            c37905.L$15 = SpillingKt.nullOutSpilledVariable(coroutineContext);
            c37905.L$16 = SpillingKt.nullOutSpilledVariable(coroutineContext2);
            c37905.L$17 = SpillingKt.nullOutSpilledVariable(contextCurrent);
            c37905.I$0 = 0;
            c37905.I$1 = 0;
            c37905.I$2 = 0;
            c37905.label = 1;
            objWithContext = BuildersKt.withContext(coroutineContextPlus, c37893, c37905);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            traceSpan = traceSpanCreateSpan;
            traceSpan.close();
            return objWithContext;
        } catch (Exception e2) {
            e = e2;
            traceSpan = traceSpanCreateSpan;
            if (e instanceof CancellationException) {
            }
            throw e;
        } catch (Throwable th2) {
            th = th2;
            traceSpan = traceSpanCreateSpan;
            traceSpan.close();
            throw th;
        }
    }

    public static /* synthetic */ Object withSpan$default(String str, String str2, Attributes attributes, SpanKind spanKind, CoroutineContext coroutineContext, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            AttributesKt.emptyAttributes();
        }
        if ((i & 8) != 0) {
            SpanKind spanKind2 = SpanKind.INTERNAL;
        }
        if ((i & 16) != 0) {
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        Continuation continuation2 = null;
        continuation2.get$context();
        throw null;
    }

    @InternalApi
    private static final <R> Object withSpan$$forInline(String str, String str2, Attributes attributes, SpanKind spanKind, CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super TraceSpan, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        Continuation continuation2 = null;
        continuation2.get$context();
        throw null;
    }
}
