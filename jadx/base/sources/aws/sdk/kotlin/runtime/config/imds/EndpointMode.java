package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ImdsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/EndpointMode;", "", "defaultEndpoint", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "<init>", "(Ljava/lang/String;ILaws/smithy/kotlin/runtime/client/endpoints/Endpoint;)V", "getDefaultEndpoint$aws_config", "()Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "IPv4", "IPv6", "Companion", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EndpointMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EndpointMode[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final EndpointMode IPv4 = new EndpointMode("IPv4", 0, new Endpoint("http://169.254.169.254"));
    public static final EndpointMode IPv6 = new EndpointMode("IPv6", 1, new Endpoint("http://[fd00:ec2::254]"));
    private final Endpoint defaultEndpoint;

    private static final /* synthetic */ EndpointMode[] $values() {
        return new EndpointMode[]{IPv4, IPv6};
    }

    public static EnumEntries<EndpointMode> getEntries() {
        return $ENTRIES;
    }

    public static EndpointMode valueOf(String str) {
        return (EndpointMode) Enum.valueOf(EndpointMode.class, str);
    }

    public static EndpointMode[] values() {
        return (EndpointMode[]) $VALUES.clone();
    }

    private EndpointMode(String str, int i, Endpoint endpoint) {
        this.defaultEndpoint = endpoint;
    }

    /* JADX INFO: renamed from: getDefaultEndpoint$aws_config, reason: from getter */
    public final Endpoint getDefaultEndpoint() {
        return this.defaultEndpoint;
    }

    static {
        EndpointMode[] endpointModeArr$values = $values();
        $VALUES = endpointModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(endpointModeArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: ImdsClient.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/EndpointMode$Companion;", "", "<init>", "()V", "fromValue", "Laws/sdk/kotlin/runtime/config/imds/EndpointMode;", "value", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EndpointMode fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String lowerCase = value.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "ipv4")) {
                return EndpointMode.IPv4;
            }
            if (Intrinsics.areEqual(lowerCase, "ipv6")) {
                return EndpointMode.IPv6;
            }
            throw new IllegalArgumentException("invalid EndpointMode: `" + value + '`');
        }
    }
}
