package aws.smithy.kotlin.runtime.telemetry.metrics;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: UpDownCounter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/UpDownCounter;", "", "add", "", "value", "", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface UpDownCounter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void add(long value, Attributes attributes, Context context);

    /* JADX INFO: compiled from: UpDownCounter.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/UpDownCounter$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/metrics/UpDownCounter;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/metrics/UpDownCounter;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final UpDownCounter None = new AbstractUpDownCounter() { // from class: aws.smithy.kotlin.runtime.telemetry.metrics.UpDownCounter$Companion$None$1
        };

        private Companion() {
        }

        public final UpDownCounter getNone() {
            return None;
        }
    }

    /* JADX INFO: compiled from: UpDownCounter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void add$default(UpDownCounter upDownCounter, long j, Attributes attributes, Context context, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: add");
        }
        if ((i & 2) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        if ((i & 4) != 0) {
            context = null;
        }
        upDownCounter.add(j, attributes, context);
    }
}
