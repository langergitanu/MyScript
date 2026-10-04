package aws.smithy.kotlin.runtime.telemetry.trace;

import kotlin.Metadata;

/* JADX INFO: compiled from: SpanContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/SpanContext;", "", "traceId", "", "getTraceId", "()Ljava/lang/String;", "spanId", "getSpanId", "isRemote", "", "()Z", "isValid", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SpanContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String getSpanId();

    String getTraceId();

    boolean isRemote();

    boolean isValid();

    /* JADX INFO: compiled from: SpanContext.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/SpanContext$Companion;", "", "<init>", "()V", "Invalid", "Laws/smithy/kotlin/runtime/telemetry/trace/SpanContext;", "getInvalid", "()Laws/smithy/kotlin/runtime/telemetry/trace/SpanContext;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SpanContext Invalid = InvalidSpanContext.INSTANCE;

        private Companion() {
        }

        public final SpanContext getInvalid() {
            return Invalid;
        }
    }
}
