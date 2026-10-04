package aws.smithy.kotlin.runtime.telemetry.logging;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoroutineContextLogExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J \u0010\u000f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J \u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J \u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J \u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/ContextAwareLogger;", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", WebViewMessageType.CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "delegate", "sourceComponent", "", "<init>", "(Lkotlin/coroutines/CoroutineContext;Laws/smithy/kotlin/runtime/telemetry/logging/Logger;Ljava/lang/String;)V", "trace", "", "t", "", NotificationCompat.CATEGORY_MESSAGE, "Lkotlin/Function0;", "debug", "info", "warn", "error", "isEnabledFor", "", FirebaseAnalytics.Param.LEVEL, "Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;", "atLevel", "Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ContextAwareLogger implements Logger {
    private final CoroutineContext context;
    private final Logger delegate;
    private final String sourceComponent;

    public ContextAwareLogger(CoroutineContext context, Logger delegate, String sourceComponent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(sourceComponent, "sourceComponent");
        this.context = context;
        this.delegate = delegate;
        this.sourceComponent = sourceComponent;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void trace(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        CoroutineContextLogExtKt.trace(this.context, this.sourceComponent, t, msg);
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void debug(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        CoroutineContextLogExtKt.debug(this.context, this.sourceComponent, t, msg);
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void info(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        CoroutineContextLogExtKt.info(this.context, this.sourceComponent, t, msg);
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void warn(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        CoroutineContextLogExtKt.warn(this.context, this.sourceComponent, t, msg);
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void error(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        CoroutineContextLogExtKt.error(this.context, this.sourceComponent, t, msg);
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public boolean isEnabledFor(LogLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        return this.delegate.isEnabledFor(level);
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public LogRecordBuilder atLevel(LogLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        return this.delegate.atLevel(level);
    }
}
