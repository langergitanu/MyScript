package aws.smithy.kotlin.runtime.telemetry;

import androidx.concurrent.futures.C1519xc40028dd;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlobalTelemetryProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/GlobalTelemetryProvider;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "provider", "", "set", "(Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "getInstance", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "instance", "telemetry-defaults"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GlobalTelemetryProvider {
    public static final GlobalTelemetryProvider INSTANCE = new GlobalTelemetryProvider();
    private static final /* synthetic */ _instanceRefVolatile globalTelemetryProvider$_instanceRefVolatile = new _instanceRefVolatile(DefaultTelemetryProvider.INSTANCE);
    private static final /* synthetic */ AtomicReferenceFieldUpdater _instance$FU = AtomicReferenceFieldUpdater.newUpdater(_instanceRefVolatile.class, Object.class, "_instance");

    /* synthetic */ class _instanceRefVolatile {
        volatile Object _instance;

        public _instanceRefVolatile(Object obj) {
            this._instance = obj;
        }
    }

    private GlobalTelemetryProvider() {
    }

    public final TelemetryProvider getInstance() {
        return (TelemetryProvider) globalTelemetryProvider$_instanceRefVolatile._instance;
    }

    public final void set(TelemetryProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (!C1519xc40028dd.m48m(_instance$FU, globalTelemetryProvider$_instanceRefVolatile, DefaultTelemetryProvider.INSTANCE, provider)) {
            throw new IllegalStateException("Global TelemetryProvider already set! Global provider must only be configured once!".toString());
        }
    }
}
