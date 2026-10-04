package aws.smithy.kotlin.runtime.telemetry.logging.slf4j;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KFunction;
import org.slf4j.MDC;

/* JADX INFO: compiled from: Slf4j1xLoggerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0016\u0010\u0017\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/slf4j/Slf4j1xLogRecordBuilderAdapter;", "Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "delegate", "Laws/smithy/kotlin/runtime/telemetry/logging/slf4j/Slf4j1xLoggerAdapter;", FirebaseAnalytics.Param.LEVEL, "Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;", "<init>", "(Laws/smithy/kotlin/runtime/telemetry/logging/slf4j/Slf4j1xLoggerAdapter;Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;)V", NotificationCompat.CATEGORY_MESSAGE, "Lkotlin/Function0;", "", "cause", "", "kvp", "", "", "getKvp", "()Ljava/util/Map;", "kvp$delegate", "Lkotlin/Lazy;", "setCause", "", "ex", "setMessage", "message", "setKeyValuePair", SubscriberAttributeKt.JSON_NAME_KEY, "value", "emit", "logging-slf4j2"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class Slf4j1xLogRecordBuilderAdapter implements LogRecordBuilder {
    private Throwable cause;
    private final Slf4j1xLoggerAdapter delegate;

    /* JADX INFO: renamed from: kvp$delegate, reason: from kotlin metadata */
    private final Lazy kvp;
    private final LogLevel level;
    private Function0<String> msg;

    /* JADX INFO: compiled from: Slf4j1xLoggerAdapter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.Error.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.Warning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.Debug.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogLevel.Trace.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setMessage$lambda$0(String str) {
        return str;
    }

    public Slf4j1xLogRecordBuilderAdapter(Slf4j1xLoggerAdapter delegate, LogLevel level) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(level, "level");
        this.delegate = delegate;
        this.level = level;
        this.kvp = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.slf4j.Slf4j1xLogRecordBuilderAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Slf4j1xLogRecordBuilderAdapter.kvp_delegate$lambda$0();
            }
        });
    }

    private final Map<String, Object> getKvp() {
        return (Map) this.kvp.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map kvp_delegate$lambda$0() {
        return new LinkedHashMap();
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setCause(Throwable ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        this.cause = ex;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setMessage(final String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.msg = new Function0() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.slf4j.Slf4j1xLogRecordBuilderAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Slf4j1xLogRecordBuilderAdapter.setMessage$lambda$0(message);
            }
        };
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setMessage(Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.msg = message;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setKeyValuePair(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        getKvp().put(key, value);
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void emit() {
        KAnnotatedElement kAnnotatedElement;
        Function0<String> function0 = this.msg;
        if (function0 == null) {
            throw new IllegalArgumentException("no message provided to LogRecordBuilder".toString());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.level.ordinal()];
        if (i == 1) {
            kAnnotatedElement = (KFunction) new Slf4j1xLogRecordBuilderAdapter$emit$logMethod$1(this.delegate);
        } else if (i == 2) {
            kAnnotatedElement = (KFunction) new Slf4j1xLogRecordBuilderAdapter$emit$logMethod$2(this.delegate);
        } else if (i == 3) {
            kAnnotatedElement = (KFunction) new Slf4j1xLogRecordBuilderAdapter$emit$logMethod$3(this.delegate);
        } else if (i == 4) {
            kAnnotatedElement = (KFunction) new Slf4j1xLogRecordBuilderAdapter$emit$logMethod$4(this.delegate);
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            kAnnotatedElement = (KFunction) new Slf4j1xLogRecordBuilderAdapter$emit$logMethod$5(this.delegate);
        }
        if (!getKvp().isEmpty()) {
            Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();
            try {
                for (Map.Entry<String, Object> entry : getKvp().entrySet()) {
                    MDC.put(entry.getKey(), entry.getValue().toString());
                }
                ((Function2) kAnnotatedElement).invoke(this.cause, function0);
                if (copyOfContextMap == null) {
                    MDC.clear();
                    return;
                } else {
                    MDC.setContextMap(copyOfContextMap);
                    return;
                }
            } catch (Throwable th) {
                if (copyOfContextMap == null) {
                    MDC.clear();
                } else {
                    MDC.setContextMap(copyOfContextMap);
                }
                throw th;
            }
        }
        ((Function2) kAnnotatedElement).invoke(this.cause, function0);
    }
}
