package aws.smithy.kotlin.runtime.telemetry.trace;

import kotlin.Metadata;

/* JADX INFO: compiled from: SpanContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/InvalidSpanContext;", "Laws/smithy/kotlin/runtime/telemetry/trace/SpanContext;", "<init>", "()V", "traceId", "", "getTraceId", "()Ljava/lang/String;", "spanId", "getSpanId", "isRemote", "", "()Z", "isValid", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class InvalidSpanContext implements SpanContext {
    private static final boolean isRemote = false;
    private static final boolean isValid = false;
    public static final InvalidSpanContext INSTANCE = new InvalidSpanContext();
    private static final String traceId = "00000000000000000000000000000000";
    private static final String spanId = "0000000000000000";

    private InvalidSpanContext() {
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.SpanContext
    public String getTraceId() {
        return traceId;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.SpanContext
    public String getSpanId() {
        return spanId;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.SpanContext
    public boolean isRemote() {
        return isRemote;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.trace.SpanContext
    public boolean isValid() {
        return isValid;
    }
}
