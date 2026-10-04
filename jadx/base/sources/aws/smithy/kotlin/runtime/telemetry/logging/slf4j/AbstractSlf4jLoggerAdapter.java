package aws.smithy.kotlin.runtime.telemetry.logging.slf4j;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractSlf4jLoggerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J \u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J \u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J \u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J \u0010\u0012\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/slf4j/AbstractSlf4jLoggerAdapter;", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "delegate", "Lorg/slf4j/Logger;", "<init>", "(Lorg/slf4j/Logger;)V", "getDelegate", "()Lorg/slf4j/Logger;", "trace", "", "t", "", NotificationCompat.CATEGORY_MESSAGE, "Lkotlin/Function0;", "", "debug", "info", "warn", "error", "isEnabledFor", "", FirebaseAnalytics.Param.LEVEL, "Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;", "logging-slf4j2"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractSlf4jLoggerAdapter implements Logger {
    private final org.slf4j.Logger delegate;

    /* JADX INFO: compiled from: AbstractSlf4jLoggerAdapter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.Trace.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.Debug.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.Warning.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogLevel.Error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractSlf4jLoggerAdapter(org.slf4j.Logger delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    protected final org.slf4j.Logger getDelegate() {
        return this.delegate;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void trace(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Trace)) {
            if (t != null) {
                this.delegate.trace(msg.invoke(), t);
            } else {
                this.delegate.trace(msg.invoke());
            }
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void debug(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Debug)) {
            if (t != null) {
                this.delegate.debug(msg.invoke(), t);
            } else {
                this.delegate.debug(msg.invoke());
            }
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void info(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Info)) {
            if (t != null) {
                this.delegate.info(msg.invoke(), t);
            } else {
                this.delegate.info(msg.invoke());
            }
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void warn(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Warning)) {
            if (t != null) {
                this.delegate.warn(msg.invoke(), t);
            } else {
                this.delegate.warn(msg.invoke());
            }
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void error(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Error)) {
            if (t != null) {
                this.delegate.error(msg.invoke(), t);
            } else {
                this.delegate.error(msg.invoke());
            }
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public boolean isEnabledFor(LogLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        int i = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i == 1) {
            return this.delegate.isTraceEnabled();
        }
        if (i == 2) {
            return this.delegate.isDebugEnabled();
        }
        if (i == 3) {
            return this.delegate.isInfoEnabled();
        }
        if (i == 4) {
            return this.delegate.isWarnEnabled();
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return this.delegate.isErrorEnabled();
    }
}
