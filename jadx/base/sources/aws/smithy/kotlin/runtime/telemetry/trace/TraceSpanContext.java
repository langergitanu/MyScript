package aws.smithy.kotlin.runtime.telemetry.trace;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpanContext;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "traceSpan", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "<init>", "(Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;)V", "getTraceSpan", "()Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "Key", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class TraceSpanContext extends AbstractCoroutineContextElement {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TraceSpan traceSpan;

    public static /* synthetic */ TraceSpanContext copy$default(TraceSpanContext traceSpanContext, TraceSpan traceSpan, int i, Object obj) {
        if ((i & 1) != 0) {
            traceSpan = traceSpanContext.traceSpan;
        }
        return traceSpanContext.copy(traceSpan);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TraceSpan getTraceSpan() {
        return this.traceSpan;
    }

    public final TraceSpanContext copy(TraceSpan traceSpan) {
        Intrinsics.checkNotNullParameter(traceSpan, "traceSpan");
        return new TraceSpanContext(traceSpan);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TraceSpanContext) && Intrinsics.areEqual(this.traceSpan, ((TraceSpanContext) other).traceSpan);
    }

    public int hashCode() {
        return this.traceSpan.hashCode();
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanContext$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpanContext$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpanContext;", "<init>", "()V", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion implements CoroutineContext.Key<TraceSpanContext> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraceSpanContext(TraceSpan traceSpan) {
        super(INSTANCE);
        Intrinsics.checkNotNullParameter(traceSpan, "traceSpan");
        this.traceSpan = traceSpan;
    }

    public final TraceSpan getTraceSpan() {
        return this.traceSpan;
    }

    public String toString() {
        return "TraceSpanContextElement(" + this.traceSpan + ')';
    }
}
