package aws.smithy.kotlin.runtime.telemetry.metrics;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractUpDownCounter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/AbstractUpDownCounter;", "Laws/smithy/kotlin/runtime/telemetry/metrics/UpDownCounter;", "<init>", "()V", "add", "", "value", "", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractUpDownCounter implements UpDownCounter {
    @Override // aws.smithy.kotlin.runtime.telemetry.metrics.UpDownCounter
    public void add(long value, Attributes attributes, Context context) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }
}
