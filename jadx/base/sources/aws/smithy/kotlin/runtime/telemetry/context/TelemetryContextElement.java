package aws.smithy.kotlin.runtime.telemetry.context;

import aws.smithy.kotlin.runtime.InternalApi;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: compiled from: TelemetryContextElementJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0010B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/context/TelemetryContextElement;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlinx/coroutines/ThreadContextElement;", "Laws/smithy/kotlin/runtime/telemetry/context/Scope;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "<init>", "(Laws/smithy/kotlin/runtime/telemetry/context/Context;)V", "getContext", "()Laws/smithy/kotlin/runtime/telemetry/context/Context;", "updateThreadContext", "Lkotlin/coroutines/CoroutineContext;", "restoreThreadContext", "", "oldState", "Key", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TelemetryContextElement extends AbstractCoroutineContextElement implements CoroutineContext.Element, ThreadContextElement<Scope> {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TelemetryContextElement(Context context) {
        super(INSTANCE);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElement$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TelemetryContextElementJVM.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/context/TelemetryContextElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Laws/smithy/kotlin/runtime/telemetry/context/TelemetryContextElement;", "<init>", "()V", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion implements CoroutineContext.Key<TelemetryContextElement> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.ThreadContextElement
    public Scope updateThreadContext(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.context.makeCurrent();
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(CoroutineContext context, Scope oldState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        oldState.close();
    }
}
