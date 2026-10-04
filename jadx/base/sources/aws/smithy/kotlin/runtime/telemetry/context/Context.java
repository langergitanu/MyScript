package aws.smithy.kotlin.runtime.telemetry.context;

import kotlin.Metadata;

/* JADX INFO: compiled from: Context.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/context/Context;", "", "makeCurrent", "Laws/smithy/kotlin/runtime/telemetry/context/Scope;", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Context {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Scope makeCurrent();

    /* JADX INFO: compiled from: Context.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/context/Context$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/context/Context;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Context None = new AbstractContext() { // from class: aws.smithy.kotlin.runtime.telemetry.context.Context$Companion$None$1
        };

        private Companion() {
        }

        public final Context getNone() {
            return None;
        }
    }
}
