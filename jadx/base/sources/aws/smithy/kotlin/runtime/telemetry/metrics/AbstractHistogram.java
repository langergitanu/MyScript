package aws.smithy.kotlin.runtime.telemetry.metrics;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.lang.Number;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractHistogram.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/AbstractHistogram;", ExifInterface.GPS_DIRECTION_TRUE, "", "Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "<init>", "()V", "record", "", "value", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "(Ljava/lang/Number;Laws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/telemetry/context/Context;)V", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractHistogram<T extends Number> implements Histogram<T> {
    @Override // aws.smithy.kotlin.runtime.telemetry.metrics.Histogram
    public void record(T value, Attributes attributes, Context context) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }
}
