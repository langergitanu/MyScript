package aws.smithy.kotlin.runtime.telemetry.trace;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.telemetry.context.Scope;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: compiled from: TraceSpan.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\b\u0010\u0006\u001a\u00020\u0007H\u0016J.\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u000e\u001a\u0002H\nH¦\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "Laws/smithy/kotlin/runtime/telemetry/context/Scope;", "spanContext", "Laws/smithy/kotlin/runtime/telemetry/trace/SpanContext;", "getSpanContext", "()Laws/smithy/kotlin/runtime/telemetry/trace/SpanContext;", "asContextElement", "Lkotlin/coroutines/CoroutineContext;", "set", "", ExifInterface.GPS_DIRECTION_TRUE, "", SubscriberAttributeKt.JSON_NAME_KEY, "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "value", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;Ljava/lang/Object;)V", "mergeAttributes", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "emitEvent", "name", "", "setStatus", NotificationCompat.CATEGORY_STATUS, "Laws/smithy/kotlin/runtime/telemetry/trace/SpanStatus;", "close", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface TraceSpan extends Scope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void emitEvent(String name, Attributes attributes);

    SpanContext getSpanContext();

    void mergeAttributes(Attributes attributes);

    <T> void set(AttributeKey<T> key, T value);

    void setStatus(SpanStatus status);

    /* JADX INFO: compiled from: TraceSpan.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final TraceSpan None = new AbstractTraceSpan() { // from class: aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan$Companion$None$1
        };

        private Companion() {
        }

        public final TraceSpan getNone() {
            return None;
        }
    }

    /* JADX INFO: compiled from: TraceSpan.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static CoroutineContext asContextElement(TraceSpan traceSpan) {
            return TraceSpan.super.asContextElement();
        }
    }

    default CoroutineContext asContextElement() {
        return EmptyCoroutineContext.INSTANCE;
    }

    static /* synthetic */ void emitEvent$default(TraceSpan traceSpan, String str, Attributes attributes, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: emitEvent");
        }
        if ((i & 2) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        traceSpan.emitEvent(str, attributes);
    }
}
