package aws.smithy.kotlin.runtime.telemetry.logging.slf4j;

import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

/* JADX INFO: compiled from: Slf4jLoggerProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/slf4j/Slf4jLoggerProvider;", "Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "<init>", "()V", "useSlf4j2x", "", "getOrCreateLogger", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "name", "", "logging-slf4j2"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Slf4jLoggerProvider implements LoggerProvider {
    public static final Slf4jLoggerProvider INSTANCE = new Slf4jLoggerProvider();
    private static final boolean useSlf4j2x;

    private Slf4jLoggerProvider() {
    }

    static {
        boolean z;
        try {
            LoggerFactory.getLogger("version_check").atLevel(Level.DEBUG);
            z = true;
        } catch (NoSuchMethodError unused) {
            LoggerFactory.getLogger((Class<?>) Slf4jLoggerProvider.class).warn("falling back to SLF4J 1.x compatible binding");
            z = false;
        }
        useSlf4j2x = z;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider
    public Logger getOrCreateLogger(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        org.slf4j.Logger logger = LoggerFactory.getLogger(name);
        if (useSlf4j2x) {
            Intrinsics.checkNotNull(logger);
            return new Slf4j2xLoggerAdapter(logger);
        }
        Intrinsics.checkNotNull(logger);
        return new Slf4j1xLoggerAdapter(logger);
    }
}
