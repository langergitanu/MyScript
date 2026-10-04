package aws.smithy.kotlin.runtime.telemetry.context;

import java.io.Closeable;
import kotlin.Metadata;

/* JADX INFO: compiled from: Scope.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00032\u00060\u0001j\u0002`\u0002:\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/context/Scope;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Scope extends Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: Scope.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/context/Scope$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/context/Scope;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/context/Scope;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Scope None = new AbstractScope() { // from class: aws.smithy.kotlin.runtime.telemetry.context.Scope$Companion$None$1
        };

        private Companion() {
        }

        public final Scope getNone() {
            return None;
        }
    }
}
