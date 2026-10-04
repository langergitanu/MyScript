package aws.smithy.kotlin.runtime.telemetry.trace;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import kotlin.Metadata;

/* JADX INFO: compiled from: Tracer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/Tracer;", "", "createSpan", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "name", "", "initialAttributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "spanKind", "Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;", "parentContext", "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Tracer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    TraceSpan createSpan(String name, Attributes initialAttributes, SpanKind spanKind, Context parentContext);

    /* JADX INFO: compiled from: Tracer.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/Tracer$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/trace/Tracer;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/trace/Tracer;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Tracer None = new AbstractTracer() { // from class: aws.smithy.kotlin.runtime.telemetry.trace.Tracer$Companion$None$1
        };

        private Companion() {
        }

        public final Tracer getNone() {
            return None;
        }
    }

    /* JADX INFO: compiled from: Tracer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ TraceSpan createSpan$default(Tracer tracer, String str, Attributes attributes, SpanKind spanKind, Context context, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSpan");
        }
        if ((i & 2) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        if ((i & 4) != 0) {
            spanKind = SpanKind.INTERNAL;
        }
        if ((i & 8) != 0) {
            context = null;
        }
        return tracer.createSpan(str, attributes, spanKind, context);
    }
}
