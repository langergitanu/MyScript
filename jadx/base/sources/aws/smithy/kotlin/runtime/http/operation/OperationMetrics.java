package aws.smithy.kotlin.runtime.http.operation;

import androidx.media3.exoplayer.upstream.CmcdData;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.metrics.Histogram;
import aws.smithy.kotlin.runtime.telemetry.metrics.Meter;
import aws.smithy.kotlin.runtime.telemetry.metrics.MonotonicCounter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationMetrics.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR!\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R!\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R!\u0010\u001e\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014R!\u0010 \u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R!\u0010\"\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R!\u0010$\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014R!\u0010&\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014R!\u0010(\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014R!\u0010*\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014R!\u0010,\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006¢\u0006\f\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u0014¨\u0006/"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "", "", "scope", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "provider", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "Laws/smithy/kotlin/runtime/telemetry/metrics/Meter;", "meter", "Laws/smithy/kotlin/runtime/telemetry/metrics/Meter;", "Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleHistogram;", "rpcCallDuration", "Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "getRpcCallDuration", "()Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "rpcAttempts", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "getRpcAttempts", "()Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "rpcErrors", "getRpcErrors", "rpcAttemptDuration", "getRpcAttemptDuration", "rpcAttemptOverheadDuration", "getRpcAttemptOverheadDuration", "serializationDuration", "getSerializationDuration", "deserializationDuration", "getDeserializationDuration", "resolveEndpointDuration", "getResolveEndpointDuration", "resolveIdentityDuration", "getResolveIdentityDuration", "signingDuration", "getSigningDuration", "requestPayloadSize", "getRequestPayloadSize", "responsePayloadSize", "getResponsePayloadSize", "Companion", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OperationMetrics {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final OperationMetrics None = new OperationMetrics("NoOp", TelemetryProvider.INSTANCE.getNone());
    private final Histogram<Double> deserializationDuration;
    private final Meter meter;
    private final TelemetryProvider provider;
    private final Histogram<Double> requestPayloadSize;
    private final Histogram<Double> resolveEndpointDuration;
    private final Histogram<Double> resolveIdentityDuration;
    private final Histogram<Double> responsePayloadSize;
    private final Histogram<Double> rpcAttemptDuration;
    private final Histogram<Double> rpcAttemptOverheadDuration;
    private final MonotonicCounter rpcAttempts;
    private final Histogram<Double> rpcCallDuration;
    private final MonotonicCounter rpcErrors;
    private final Histogram<Double> serializationDuration;
    private final Histogram<Double> signingDuration;

    public OperationMetrics(String scope, TelemetryProvider provider) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.provider = provider;
        Meter orCreateMeter = provider.getMeterProvider().getOrCreateMeter(scope);
        this.meter = orCreateMeter;
        this.rpcCallDuration = orCreateMeter.createDoubleHistogram("smithy.client.call.duration", CmcdData.STREAMING_FORMAT_SS, "Overall call duration including retries");
        this.rpcAttempts = orCreateMeter.createMonotonicCounter("smithy.client.call.attempts", "{attempt}", "The number of attempts for an operation");
        this.rpcErrors = orCreateMeter.createMonotonicCounter("smithy.client.call.errors", "{error}", "The number of errors for an operation");
        this.rpcAttemptDuration = orCreateMeter.createDoubleHistogram("smithy.client.call.attempt_duration", CmcdData.STREAMING_FORMAT_SS, "The time it takes to connect to complete an entire call attempt, including identity resolution, endpoint resolution, signing, sending the request, and receiving the HTTP status code and headers from the response for an operation");
        this.rpcAttemptOverheadDuration = orCreateMeter.createDoubleHistogram("smithy.client.call.attempt_overhead_duration", CmcdData.STREAMING_FORMAT_SS, "The time it takes to execute an attempt minus the time spent waiting for a response from the remote server");
        this.serializationDuration = orCreateMeter.createDoubleHistogram("smithy.client.call.serialization_duration", CmcdData.STREAMING_FORMAT_SS, "The time it takes to serialize a request message body");
        this.deserializationDuration = orCreateMeter.createDoubleHistogram("smithy.client.call.deserialization_duration", CmcdData.STREAMING_FORMAT_SS, "The time it takes to deserialize a response message body");
        this.resolveEndpointDuration = orCreateMeter.createDoubleHistogram("smithy.client.call.resolve_endpoint_duration", CmcdData.STREAMING_FORMAT_SS, "The time it takes to resolve an endpoint for a request");
        this.resolveIdentityDuration = orCreateMeter.createDoubleHistogram("smithy.client.call.auth.resolve_identity_duration", CmcdData.STREAMING_FORMAT_SS, "The time it takes to resolve an identity for signing a request");
        this.signingDuration = orCreateMeter.createDoubleHistogram("smithy.client.call.auth.signing_duration", CmcdData.STREAMING_FORMAT_SS, "The time it takes to sign a request");
        this.requestPayloadSize = orCreateMeter.createDoubleHistogram("smithy.client.call.request_payload_size", "bytes", "The payload size of a request");
        this.responsePayloadSize = orCreateMeter.createDoubleHistogram("smithy.client.call.response_payload_size", "bytes", "The payload size of a response");
    }

    public final TelemetryProvider getProvider() {
        return this.provider;
    }

    /* JADX INFO: compiled from: OperationMetrics.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/OperationMetrics$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "None", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "getNone", "()Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OperationMetrics getNone() {
            return OperationMetrics.None;
        }
    }

    public final Histogram<Double> getRpcCallDuration() {
        return this.rpcCallDuration;
    }

    public final MonotonicCounter getRpcAttempts() {
        return this.rpcAttempts;
    }

    public final MonotonicCounter getRpcErrors() {
        return this.rpcErrors;
    }

    public final Histogram<Double> getRpcAttemptDuration() {
        return this.rpcAttemptDuration;
    }

    public final Histogram<Double> getRpcAttemptOverheadDuration() {
        return this.rpcAttemptOverheadDuration;
    }

    public final Histogram<Double> getSerializationDuration() {
        return this.serializationDuration;
    }

    public final Histogram<Double> getDeserializationDuration() {
        return this.deserializationDuration;
    }

    public final Histogram<Double> getResolveEndpointDuration() {
        return this.resolveEndpointDuration;
    }

    public final Histogram<Double> getResolveIdentityDuration() {
        return this.resolveIdentityDuration;
    }

    public final Histogram<Double> getSigningDuration() {
        return this.signingDuration;
    }

    public final Histogram<Double> getRequestPayloadSize() {
        return this.requestPayloadSize;
    }

    public final Histogram<Double> getResponsePayloadSize() {
        return this.responsePayloadSize;
    }
}
