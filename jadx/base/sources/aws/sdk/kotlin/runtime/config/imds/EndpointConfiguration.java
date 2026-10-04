package aws.sdk.kotlin.runtime.config.imds;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImdsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, TypedValues.Custom.NAME, "ModeOverride", "Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration$Custom;", "Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration$Default;", "Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration$ModeOverride;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class EndpointConfiguration {
    public /* synthetic */ EndpointConfiguration(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private EndpointConfiguration() {
    }

    /* JADX INFO: compiled from: ImdsClient.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration$Default;", "Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;", "<init>", "()V", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Default extends EndpointConfiguration {
        public static final Default INSTANCE = new Default();

        private Default() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ImdsClient.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration$Custom;", "Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;", "endpoint", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "<init>", "(Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;)V", "getEndpoint", "()Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Custom extends EndpointConfiguration {
        private final Endpoint endpoint;

        public static /* synthetic */ Custom copy$default(Custom custom, Endpoint endpoint, int i, Object obj) {
            if ((i & 1) != 0) {
                endpoint = custom.endpoint;
            }
            return custom.copy(endpoint);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Endpoint getEndpoint() {
            return this.endpoint;
        }

        public final Custom copy(Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            return new Custom(endpoint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Custom) && Intrinsics.areEqual(this.endpoint, ((Custom) other).endpoint);
        }

        public int hashCode() {
            return this.endpoint.hashCode();
        }

        public String toString() {
            return "Custom(endpoint=" + this.endpoint + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(Endpoint endpoint) {
            super(null);
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.endpoint = endpoint;
        }

        public final Endpoint getEndpoint() {
            return this.endpoint;
        }
    }

    /* JADX INFO: compiled from: ImdsClient.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration$ModeOverride;", "Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;", "mode", "Laws/sdk/kotlin/runtime/config/imds/EndpointMode;", "<init>", "(Laws/sdk/kotlin/runtime/config/imds/EndpointMode;)V", "getMode", "()Laws/sdk/kotlin/runtime/config/imds/EndpointMode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ModeOverride extends EndpointConfiguration {
        private final EndpointMode mode;

        public static /* synthetic */ ModeOverride copy$default(ModeOverride modeOverride, EndpointMode endpointMode, int i, Object obj) {
            if ((i & 1) != 0) {
                endpointMode = modeOverride.mode;
            }
            return modeOverride.copy(endpointMode);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final EndpointMode getMode() {
            return this.mode;
        }

        public final ModeOverride copy(EndpointMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            return new ModeOverride(mode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ModeOverride) && this.mode == ((ModeOverride) other).mode;
        }

        public int hashCode() {
            return this.mode.hashCode();
        }

        public String toString() {
            return "ModeOverride(mode=" + this.mode + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModeOverride(EndpointMode mode) {
            super(null);
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
        }

        public final EndpointMode getMode() {
            return this.mode;
        }
    }
}
