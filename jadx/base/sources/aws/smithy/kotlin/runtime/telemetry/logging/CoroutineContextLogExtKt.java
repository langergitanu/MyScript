package aws.smithy.kotlin.runtime.telemetry.logging;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanContext;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CoroutineContextLogExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a`\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2*\u0010\r\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000f0\u000e\"\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000f2\u001e\b\u0004\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011H\u0087H¢\u0006\u0002\u0010\u0013\u001a6\u0010\u0014\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0007\u001a<\u0010\u0014\u001a\u00020\u0015\"\u0006\b\u0000\u0010\u001d\u0018\u0001*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\b\b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\bø\u0001\u0000\u001a.\u0010\u001e\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0007\u001a4\u0010\u001e\u001a\u00020\u0015\"\u0006\b\u0000\u0010\u001d\u0018\u0001*\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\b\b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\bø\u0001\u0000\u001a.\u0010\u001f\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0007\u001a4\u0010\u001f\u001a\u00020\u0015\"\u0006\b\u0000\u0010\u001d\u0018\u0001*\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\b\b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\bø\u0001\u0000\u001a.\u0010 \u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0007\u001a4\u0010 \u001a\u00020\u0015\"\u0006\b\u0000\u0010\u001d\u0018\u0001*\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\b\b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\bø\u0001\u0000\u001a.\u0010!\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0007\u001a4\u0010!\u001a\u00020\u0015\"\u0006\b\u0000\u0010\u001d\u0018\u0001*\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\b\b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\bø\u0001\u0000\u001a.\u0010\"\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0007\u001a4\u0010\"\u001a\u00020\u0015\"\u0006\b\u0000\u0010\u001d\u0018\u0001*\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\b\b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\bø\u0001\u0000\u001a\u0014\u0010#\u001a\u00020$*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0001H\u0007\u001a\u0015\u0010#\u001a\u00020$\"\u0006\b\u0000\u0010\u001d\u0018\u0001*\u00020\u0006H\u0087\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"*\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, m1599d2 = {"TRACE_ID_KEY", "", "SPAN_ID_KEY", "loggingContext", "", "", "Lkotlin/coroutines/CoroutineContext;", "getLoggingContext$annotations", "(Lkotlin/coroutines/CoroutineContext;)V", "getLoggingContext", "(Lkotlin/coroutines/CoroutineContext;)Ljava/util/Map;", "withLogCtx", "R", "kvPairs", "", "Lkotlin/Pair;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "([Lkotlin/Pair;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "log", "", FirebaseAnalytics.Param.LEVEL, "Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;", "sourceComponent", "ex", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", ExifInterface.GPS_DIRECTION_TRUE, "error", "warn", "info", "debug", "trace", "logger", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "telemetry-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CoroutineContextLogExtKt {
    private static final String SPAN_ID_KEY = "span_id";
    private static final String TRACE_ID_KEY = "trace_id";

    @InternalApi
    public static /* synthetic */ void getLoggingContext$annotations(CoroutineContext coroutineContext) {
    }

    public static final Map<String, Object> getLoggingContext(CoroutineContext coroutineContext) {
        Map<String, Object> kvPairs;
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        LoggingContextElement loggingContextElement = (LoggingContextElement) coroutineContext.get(LoggingContextElement.INSTANCE);
        return (loggingContextElement == null || (kvPairs = loggingContextElement.getKvPairs()) == null) ? MapsKt.emptyMap() : kvPairs;
    }

    @InternalApi
    public static final <R> Object withLogCtx(Pair<String, ? extends Object>[] pairArr, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        Map mutableMap = MapsKt.toMutableMap(getLoggingContext(continuation.get$context()));
        MapsKt.putAll(mutableMap, pairArr);
        return BuildersKt.withContext(new LoggingContextElement((Map<String, ? extends Object>) mutableMap), new C37862(function1, null), continuation);
    }

    @InternalApi
    private static final <R> Object withLogCtx$$forInline(Pair<String, ? extends Object>[] pairArr, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        Continuation continuation2 = null;
        continuation2.get$context();
        throw null;
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt$withLogCtx$2 */
    /* JADX INFO: compiled from: CoroutineContextLogExt.kt */
    @Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 176)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt$withLogCtx$2", m1609f = "CoroutineContextLogExt.kt", m1610i = {}, m1611l = {60}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    public static final class C37862<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C37862(Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super C37862> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C37862(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((C37862) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            Function1<Continuation<? super R>, Object> function1 = this.$block;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke(this);
        }
    }

    public static /* synthetic */ void log$default(CoroutineContext coroutineContext, LogLevel logLevel, String str, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        log(coroutineContext, logLevel, str, th, function0);
    }

    @InternalApi
    public static final void log(CoroutineContext coroutineContext, LogLevel level, String sourceComponent, Throwable th, Function0<String> content) {
        SpanContext spanContext;
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(sourceComponent, "sourceComponent");
        Intrinsics.checkNotNullParameter(content, "content");
        Logger orCreateLogger = TelemetryProviderContextKt.getTelemetryProvider(coroutineContext).getLoggerProvider().getOrCreateLogger(sourceComponent);
        if (orCreateLogger.isEnabledFor(level)) {
            Map<String, Object> loggingContext = getLoggingContext(coroutineContext);
            TraceSpan traceSpan = CoroutineContextTraceExtKt.getTraceSpan(coroutineContext);
            SpanContext spanContext2 = null;
            if (traceSpan != null && (spanContext = traceSpan.getSpanContext()) != null && spanContext.isValid()) {
                spanContext2 = spanContext;
            }
            LogRecordBuilder logRecordBuilderAtLevel = orCreateLogger.atLevel(level);
            if (th != null) {
                logRecordBuilderAtLevel.setCause(th);
            }
            logRecordBuilderAtLevel.setMessage(content);
            for (Map.Entry<String, Object> entry : loggingContext.entrySet()) {
                logRecordBuilderAtLevel.setKeyValuePair(entry.getKey(), entry.getValue());
            }
            if (spanContext2 != null) {
                logRecordBuilderAtLevel.setKeyValuePair(TRACE_ID_KEY, spanContext2.getTraceId());
                logRecordBuilderAtLevel.setKeyValuePair(SPAN_ID_KEY, spanContext2.getSpanId());
            }
            logRecordBuilderAtLevel.emit();
        }
    }

    public static /* synthetic */ void log$default(CoroutineContext coroutineContext, LogLevel level, Throwable th, Function0 content, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, level, qualifiedName, th, content);
    }

    @InternalApi
    public static final /* synthetic */ <T> void log(CoroutineContext coroutineContext, LogLevel level, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, level, qualifiedName, th, content);
    }

    @InternalApi
    public static final void error(CoroutineContext coroutineContext, String sourceComponent, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(sourceComponent, "sourceComponent");
        Intrinsics.checkNotNullParameter(content, "content");
        log(coroutineContext, LogLevel.Error, sourceComponent, th, content);
    }

    public static /* synthetic */ void error$default(CoroutineContext coroutineContext, String str, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        error(coroutineContext, str, th, function0);
    }

    @InternalApi
    public static final /* synthetic */ <T> void error(CoroutineContext coroutineContext, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Error;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    public static /* synthetic */ void error$default(CoroutineContext coroutineContext, Throwable th, Function0 content, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Error;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    @InternalApi
    public static final void warn(CoroutineContext coroutineContext, String sourceComponent, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(sourceComponent, "sourceComponent");
        Intrinsics.checkNotNullParameter(content, "content");
        log(coroutineContext, LogLevel.Warning, sourceComponent, th, content);
    }

    public static /* synthetic */ void warn$default(CoroutineContext coroutineContext, String str, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        warn(coroutineContext, str, th, function0);
    }

    @InternalApi
    public static final /* synthetic */ <T> void warn(CoroutineContext coroutineContext, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Warning;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    public static /* synthetic */ void warn$default(CoroutineContext coroutineContext, Throwable th, Function0 content, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Warning;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    @InternalApi
    public static final void info(CoroutineContext coroutineContext, String sourceComponent, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(sourceComponent, "sourceComponent");
        Intrinsics.checkNotNullParameter(content, "content");
        log(coroutineContext, LogLevel.Info, sourceComponent, th, content);
    }

    public static /* synthetic */ void info$default(CoroutineContext coroutineContext, String str, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        info(coroutineContext, str, th, function0);
    }

    @InternalApi
    public static final /* synthetic */ <T> void info(CoroutineContext coroutineContext, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Info;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    public static /* synthetic */ void info$default(CoroutineContext coroutineContext, Throwable th, Function0 content, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Info;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    @InternalApi
    public static final void debug(CoroutineContext coroutineContext, String sourceComponent, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(sourceComponent, "sourceComponent");
        Intrinsics.checkNotNullParameter(content, "content");
        log(coroutineContext, LogLevel.Debug, sourceComponent, th, content);
    }

    public static /* synthetic */ void debug$default(CoroutineContext coroutineContext, String str, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        debug(coroutineContext, str, th, function0);
    }

    @InternalApi
    public static final /* synthetic */ <T> void debug(CoroutineContext coroutineContext, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Debug;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    public static /* synthetic */ void debug$default(CoroutineContext coroutineContext, Throwable th, Function0 content, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Debug;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    @InternalApi
    public static final void trace(CoroutineContext coroutineContext, String sourceComponent, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(sourceComponent, "sourceComponent");
        Intrinsics.checkNotNullParameter(content, "content");
        log(coroutineContext, LogLevel.Trace, sourceComponent, th, content);
    }

    public static /* synthetic */ void trace$default(CoroutineContext coroutineContext, String str, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        trace(coroutineContext, str, th, function0);
    }

    @InternalApi
    public static final /* synthetic */ <T> void trace(CoroutineContext coroutineContext, Throwable th, Function0<String> content) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Trace;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    public static /* synthetic */ void trace$default(CoroutineContext coroutineContext, Throwable th, Function0 content, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        LogLevel logLevel = LogLevel.Trace;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        log(coroutineContext, logLevel, qualifiedName, th, content);
    }

    @InternalApi
    public static final Logger logger(CoroutineContext coroutineContext, String sourceComponent) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(sourceComponent, "sourceComponent");
        return new ContextAwareLogger(coroutineContext, TelemetryProviderContextKt.getTelemetryProvider(coroutineContext).getLoggerProvider().getOrCreateLogger(sourceComponent), sourceComponent);
    }

    @InternalApi
    public static final /* synthetic */ <T> Logger logger(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
        }
        return logger(coroutineContext, qualifiedName);
    }
}
