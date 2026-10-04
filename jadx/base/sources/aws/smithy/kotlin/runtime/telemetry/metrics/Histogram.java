package aws.smithy.kotlin.runtime.telemetry.metrics;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.lang.Number;
import kotlin.Metadata;

/* JADX INFO: compiled from: Histogram.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\fJ+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000b¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "record", "", "value", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "(Ljava/lang/Number;Laws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/telemetry/context/Context;)V", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Histogram<T extends Number> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void record(T value, Attributes attributes, Context context);

    /* JADX INFO: compiled from: Histogram.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram$Companion;", "", "<init>", "()V", "DoubleNone", "Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleHistogram;", "getDoubleNone", "()Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "LongNone", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongHistogram;", "getLongNone", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Histogram<Double> DoubleNone = new AbstractHistogram<Double>() { // from class: aws.smithy.kotlin.runtime.telemetry.metrics.Histogram$Companion$DoubleNone$1
        };
        private static final Histogram<Long> LongNone = new AbstractHistogram<Long>() { // from class: aws.smithy.kotlin.runtime.telemetry.metrics.Histogram$Companion$LongNone$1
        };

        private Companion() {
        }

        public final Histogram<Double> getDoubleNone() {
            return DoubleNone;
        }

        public final Histogram<Long> getLongNone() {
            return LongNone;
        }
    }

    /* JADX INFO: compiled from: Histogram.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void record$default(Histogram histogram, Number number, Attributes attributes, Context context, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record");
        }
        if ((i & 2) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        if ((i & 4) != 0) {
            context = null;
        }
        histogram.record(number, attributes, context);
    }
}
