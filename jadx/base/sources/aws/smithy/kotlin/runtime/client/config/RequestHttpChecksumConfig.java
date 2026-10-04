package aws.smithy.kotlin.runtime.client.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HttpChecksumConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "", "<init>", "(Ljava/lang/String;I)V", "WHEN_SUPPORTED", "WHEN_REQUIRED", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RequestHttpChecksumConfig {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RequestHttpChecksumConfig[] $VALUES;
    public static final RequestHttpChecksumConfig WHEN_SUPPORTED = new RequestHttpChecksumConfig("WHEN_SUPPORTED", 0);
    public static final RequestHttpChecksumConfig WHEN_REQUIRED = new RequestHttpChecksumConfig("WHEN_REQUIRED", 1);

    private static final /* synthetic */ RequestHttpChecksumConfig[] $values() {
        return new RequestHttpChecksumConfig[]{WHEN_SUPPORTED, WHEN_REQUIRED};
    }

    public static EnumEntries<RequestHttpChecksumConfig> getEntries() {
        return $ENTRIES;
    }

    public static RequestHttpChecksumConfig valueOf(String str) {
        return (RequestHttpChecksumConfig) Enum.valueOf(RequestHttpChecksumConfig.class, str);
    }

    public static RequestHttpChecksumConfig[] values() {
        return (RequestHttpChecksumConfig[]) $VALUES.clone();
    }

    private RequestHttpChecksumConfig(String str, int i) {
    }

    static {
        RequestHttpChecksumConfig[] requestHttpChecksumConfigArr$values = $values();
        $VALUES = requestHttpChecksumConfigArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(requestHttpChecksumConfigArr$values);
    }
}
