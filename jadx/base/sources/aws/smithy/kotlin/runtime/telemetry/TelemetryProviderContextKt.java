package aws.smithy.kotlin.runtime.telemetry;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TelemetryProviderContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "Lkotlin/coroutines/CoroutineContext;", "getTelemetryProvider$annotations", "(Lkotlin/coroutines/CoroutineContext;)V", "getTelemetryProvider", "(Lkotlin/coroutines/CoroutineContext;)Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "telemetry-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TelemetryProviderContextKt {
    @InternalApi
    public static /* synthetic */ void getTelemetryProvider$annotations(CoroutineContext coroutineContext) {
    }

    public static final TelemetryProvider getTelemetryProvider(CoroutineContext coroutineContext) {
        TelemetryProvider provider;
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) coroutineContext.get(TelemetryProviderContext.INSTANCE);
        return (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null) ? TelemetryProvider.INSTANCE.getNone() : provider;
    }
}
