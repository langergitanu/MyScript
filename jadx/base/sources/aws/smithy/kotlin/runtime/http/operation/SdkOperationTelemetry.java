package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanKind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationTelemetry.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011¨\u0006*"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/SdkOperationTelemetry;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "provider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "setProvider", "(Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "", "spanName", "Ljava/lang/String;", "getSpanName", "()Ljava/lang/String;", "setSpanName", "(Ljava/lang/String;)V", "Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;", "spanKind", "Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;", "getSpanKind", "()Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;", "setSpanKind", "(Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;)V", "Laws/smithy/kotlin/runtime/collections/Attributes;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "setAttributes", "(Laws/smithy/kotlin/runtime/collections/Attributes;)V", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "metrics", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "getMetrics", "()Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "setMetrics", "(Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;)V", "scope", "getScope", "setScope", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkOperationTelemetry {
    private String scope;
    private String spanName;
    private TelemetryProvider provider = TelemetryProvider.INSTANCE.getNone();
    private SpanKind spanKind = SpanKind.CLIENT;
    private Attributes attributes = AttributesKt.emptyAttributes();
    private OperationMetrics metrics = OperationMetrics.INSTANCE.getNone();

    public final TelemetryProvider getProvider() {
        return this.provider;
    }

    public final void setProvider(TelemetryProvider telemetryProvider) {
        Intrinsics.checkNotNullParameter(telemetryProvider, "<set-?>");
        this.provider = telemetryProvider;
    }

    public final String getSpanName() {
        return this.spanName;
    }

    public final void setSpanName(String str) {
        this.spanName = str;
    }

    public final SpanKind getSpanKind() {
        return this.spanKind;
    }

    public final void setSpanKind(SpanKind spanKind) {
        Intrinsics.checkNotNullParameter(spanKind, "<set-?>");
        this.spanKind = spanKind;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final void setAttributes(Attributes attributes) {
        Intrinsics.checkNotNullParameter(attributes, "<set-?>");
        this.attributes = attributes;
    }

    public final OperationMetrics getMetrics() {
        return this.metrics;
    }

    public final void setMetrics(OperationMetrics operationMetrics) {
        Intrinsics.checkNotNullParameter(operationMetrics, "<set-?>");
        this.metrics = operationMetrics;
    }

    public final String getScope() {
        return this.scope;
    }

    public final void setScope(String str) {
        this.scope = str;
    }
}
