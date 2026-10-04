package aws.smithy.kotlin.runtime.telemetry.logging;

import kotlin.Metadata;

/* JADX INFO: compiled from: LoggerProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "", "getOrCreateLogger", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "name", "", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface LoggerProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Logger getOrCreateLogger(String name);

    /* JADX INFO: compiled from: LoggerProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final LoggerProvider None = new AbstractLoggerProvider() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider$Companion$None$1
        };

        private Companion() {
        }

        public final LoggerProvider getNone() {
            return None;
        }
    }
}
