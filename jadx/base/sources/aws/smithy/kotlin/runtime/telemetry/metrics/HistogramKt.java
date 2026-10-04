package aws.smithy.kotlin.runtime.telemetry.metrics;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;

/* JADX INFO: compiled from: Histogram.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0005\u001a\u00020\u0006*\f\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aI\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0011*\f\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a;\u0010\u0015\u001a\u00020\u0006*\f\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u0016*\u0016\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0016\u0010\u0003\"\b\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00040\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, m1599d2 = {"LongHistogram", "Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "", "DoubleHistogram", "", "recordSeconds", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleHistogram;", "value", "Lkotlin/time/Duration;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "recordSeconds-dWUq8MI", "(Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;JLaws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/telemetry/context/Context;)V", "measureSeconds", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;Laws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/telemetry/context/Context;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recordPayloadSize", "(Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;Ljava/lang/Long;Laws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/telemetry/context/Context;)V", "telemetry-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HistogramKt {
    /* JADX INFO: renamed from: recordSeconds-dWUq8MI$default, reason: not valid java name */
    public static /* synthetic */ void m12286recordSecondsdWUq8MI$default(Histogram histogram, long j, Attributes attributes, Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        if ((i & 4) != 0) {
            context = null;
        }
        m12285recordSecondsdWUq8MI(histogram, j, attributes, context);
    }

    @InternalApi
    /* JADX INFO: renamed from: recordSeconds-dWUq8MI, reason: not valid java name */
    public static final void m12285recordSecondsdWUq8MI(Histogram<Double> recordSeconds, long j, Attributes attributes, Context context) {
        Intrinsics.checkNotNullParameter(recordSeconds, "$this$recordSeconds");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        recordSeconds.record(Double.valueOf(Duration.m15869getInWholeNanosecondsimpl(j) / ((double) 1000000000)), attributes, context);
    }

    public static /* synthetic */ Object measureSeconds$default(Histogram histogram, Attributes attributes, Context context, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        if ((i & 2) != 0) {
            context = null;
        }
        Intrinsics.checkNotNullParameter(histogram, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(block, "block");
        TimedValue timedValue = new TimedValue(block.invoke(), TimeSource.Monotonic.ValueTimeMark.m15979elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m15974markNowz9LOYto()), null);
        m12285recordSecondsdWUq8MI(histogram, timedValue.m15996getDurationUwyO8pc(), attributes, context);
        return timedValue.getValue();
    }

    public static /* synthetic */ void recordPayloadSize$default(Histogram histogram, Long l, Attributes attributes, Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        if ((i & 4) != 0) {
            context = null;
        }
        recordPayloadSize(histogram, l, attributes, context);
    }

    @InternalApi
    public static final void recordPayloadSize(Histogram<Double> histogram, Long l, Attributes attributes, Context context) {
        Intrinsics.checkNotNullParameter(histogram, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        histogram.record(Double.valueOf(l != null ? l.longValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), attributes, context);
    }

    public static final <T> T measureSeconds(Histogram<Double> histogram, Attributes attributes, Context context, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(histogram, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(block, "block");
        TimedValue timedValue = new TimedValue(block.invoke(), TimeSource.Monotonic.ValueTimeMark.m15979elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m15974markNowz9LOYto()), null);
        m12285recordSecondsdWUq8MI(histogram, timedValue.m15996getDurationUwyO8pc(), attributes, context);
        return (T) timedValue.getValue();
    }
}
