package aws.smithy.kotlin.runtime.telemetry.context;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TelemetryContextElement.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\" \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"telemetryContext", "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "Lkotlin/coroutines/CoroutineContext;", "getTelemetryContext$annotations", "(Lkotlin/coroutines/CoroutineContext;)V", "getTelemetryContext", "(Lkotlin/coroutines/CoroutineContext;)Laws/smithy/kotlin/runtime/telemetry/context/Context;", "telemetry-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TelemetryContextElementKt {
    @InternalApi
    public static /* synthetic */ void getTelemetryContext$annotations(CoroutineContext coroutineContext) {
    }

    public static final Context getTelemetryContext(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        TelemetryContextElement telemetryContextElement = (TelemetryContextElement) coroutineContext.get(TelemetryContextElement.INSTANCE);
        if (telemetryContextElement != null) {
            return telemetryContextElement.getContext();
        }
        return null;
    }
}
