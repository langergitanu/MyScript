package aws.smithy.kotlin.runtime.telemetry.metrics;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.lang.Number;
import kotlin.Metadata;

/* JADX INFO: compiled from: Gauge.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurement;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "record", "", "value", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "(Ljava/lang/Number;Laws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/telemetry/context/Context;)V", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AsyncMeasurement<T extends Number> {
    void record(T value, Attributes attributes, Context context);

    /* JADX INFO: compiled from: Gauge.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void record$default(AsyncMeasurement asyncMeasurement, Number number, Attributes attributes, Context context, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record");
        }
        if ((i & 2) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        if ((i & 4) != 0) {
            context = null;
        }
        asyncMeasurement.record(number, attributes, context);
    }
}
