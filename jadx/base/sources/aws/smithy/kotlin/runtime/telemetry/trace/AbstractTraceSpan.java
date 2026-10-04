package aws.smithy.kotlin.runtime.telemetry.trace;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.collections.Attributes;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractTraceSpan.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0011\u001a\u00020\t\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00152\u0006\u0010\u0016\u001a\u0002H\u0012H\u0096\u0002¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/AbstractTraceSpan;", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "<init>", "()V", "spanContext", "Laws/smithy/kotlin/runtime/telemetry/trace/SpanContext;", "getSpanContext", "()Laws/smithy/kotlin/runtime/telemetry/trace/SpanContext;", "emitEvent", "", "name", "", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "setStatus", NotificationCompat.CATEGORY_STATUS, "Laws/smithy/kotlin/runtime/telemetry/trace/SpanStatus;", "set", ExifInterface.GPS_DIRECTION_TRUE, "", SubscriberAttributeKt.JSON_NAME_KEY, "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "value", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;Ljava/lang/Object;)V", "mergeAttributes", "close", "asContextElement", "Lkotlin/coroutines/CoroutineContext;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractTraceSpan implements TraceSpan {
    private final SpanContext spanContext = SpanContext.INSTANCE.getInvalid();

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan
    public void emitEvent(String name, Attributes attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan
    public void mergeAttributes(Attributes attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan
    public <T> void set(AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan
    public void setStatus(SpanStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan
    public SpanContext getSpanContext() {
        return this.spanContext;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan
    public CoroutineContext asContextElement() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
