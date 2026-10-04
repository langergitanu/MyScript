package aws.smithy.kotlin.runtime.telemetry.trace;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractTracerProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/AbstractTracerProvider;", "Laws/smithy/kotlin/runtime/telemetry/trace/TracerProvider;", "<init>", "()V", "getOrCreateTracer", "Laws/smithy/kotlin/runtime/telemetry/trace/Tracer;", "scope", "", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractTracerProvider implements TracerProvider {
    @Override // aws.smithy.kotlin.runtime.telemetry.trace.TracerProvider
    public Tracer getOrCreateTracer(String scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        return Tracer.INSTANCE.getNone();
    }
}
