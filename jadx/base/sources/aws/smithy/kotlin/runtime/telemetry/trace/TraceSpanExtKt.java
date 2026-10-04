package aws.smithy.kotlin.runtime.telemetry.trace;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: TraceSpanExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a)\u0010\u0007\u001a\u00020\u0001\"\b\b\u0000\u0010\b*\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m1599d2 = {"recordException", "", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "ex", "", "escaped", "", "setAttribute", ExifInterface.GPS_DIRECTION_TRUE, "", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "(Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;Ljava/lang/String;Ljava/lang/Object;)V", "telemetry-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TraceSpanExtKt {
    public static final void recordException(TraceSpan traceSpan, Throwable ex, boolean z) {
        Intrinsics.checkNotNullParameter(traceSpan, "<this>");
        Intrinsics.checkNotNullParameter(ex, "ex");
        String qualifiedName = Reflection.getOrCreateKotlinClass(ex.getClass()).getQualifiedName();
        if (qualifiedName == null) {
            qualifiedName = Reflection.getOrCreateKotlinClass(ex.getClass()).getSimpleName();
        }
        setAttribute(traceSpan, "error", true);
        String message = ex.getMessage();
        if (message != null) {
            setAttribute(traceSpan, "exception.message", message);
        }
        if (qualifiedName != null) {
            setAttribute(traceSpan, "exception.type", qualifiedName);
        }
        setAttribute(traceSpan, "exception.stacktrace", ExceptionsKt.stackTraceToString(ex));
        Throwable cause = ex.getCause();
        if (cause != null) {
            setAttribute(traceSpan, "exception.cause", cause.toString());
        }
        setAttribute(traceSpan, "exception.escaped", Boolean.valueOf(z));
    }

    public static final <T> void setAttribute(TraceSpan traceSpan, String key, T value) {
        Intrinsics.checkNotNullParameter(traceSpan, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        traceSpan.set(new AttributeKey<>(key), value);
    }
}
