package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: DefaultAwsSignerJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/DefaultAwsSignerBuilder;", "", "<init>", "()V", "telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "setTelemetryProvider", "(Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "build", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultAwsSignerBuilder {
    private TelemetryProvider telemetryProvider;

    public final TelemetryProvider getTelemetryProvider() {
        return this.telemetryProvider;
    }

    public final void setTelemetryProvider(TelemetryProvider telemetryProvider) {
        this.telemetryProvider = telemetryProvider;
    }

    public final AwsSigner build() {
        return new DefaultAwsSignerImpl(null, null, this.telemetryProvider, 3, null);
    }
}
