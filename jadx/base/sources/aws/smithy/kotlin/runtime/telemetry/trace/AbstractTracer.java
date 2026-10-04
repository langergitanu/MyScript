package aws.smithy.kotlin.runtime.telemetry.trace;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractTracer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/AbstractTracer;", "Laws/smithy/kotlin/runtime/telemetry/trace/Tracer;", "<init>", "()V", "createSpan", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "name", "", "initialAttributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "spanKind", "Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;", "parentContext", "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractTracer implements Tracer {
    @Override // aws.smithy.kotlin.runtime.telemetry.trace.Tracer
    public TraceSpan createSpan(String name, Attributes initialAttributes, SpanKind spanKind, Context parentContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(initialAttributes, "initialAttributes");
        Intrinsics.checkNotNullParameter(spanKind, "spanKind");
        return TraceSpan.INSTANCE.getNone();
    }
}
