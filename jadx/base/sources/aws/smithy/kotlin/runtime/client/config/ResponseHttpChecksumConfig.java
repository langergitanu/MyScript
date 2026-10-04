package aws.smithy.kotlin.runtime.client.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HttpChecksumConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "", "<init>", "(Ljava/lang/String;I)V", "WHEN_SUPPORTED", "WHEN_REQUIRED", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResponseHttpChecksumConfig {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ResponseHttpChecksumConfig[] $VALUES;
    public static final ResponseHttpChecksumConfig WHEN_SUPPORTED = new ResponseHttpChecksumConfig("WHEN_SUPPORTED", 0);
    public static final ResponseHttpChecksumConfig WHEN_REQUIRED = new ResponseHttpChecksumConfig("WHEN_REQUIRED", 1);

    private static final /* synthetic */ ResponseHttpChecksumConfig[] $values() {
        return new ResponseHttpChecksumConfig[]{WHEN_SUPPORTED, WHEN_REQUIRED};
    }

    public static EnumEntries<ResponseHttpChecksumConfig> getEntries() {
        return $ENTRIES;
    }

    public static ResponseHttpChecksumConfig valueOf(String str) {
        return (ResponseHttpChecksumConfig) Enum.valueOf(ResponseHttpChecksumConfig.class, str);
    }

    public static ResponseHttpChecksumConfig[] values() {
        return (ResponseHttpChecksumConfig[]) $VALUES.clone();
    }

    private ResponseHttpChecksumConfig(String str, int i) {
    }

    static {
        ResponseHttpChecksumConfig[] responseHttpChecksumConfigArr$values = $values();
        $VALUES = responseHttpChecksumConfigArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(responseHttpChecksumConfigArr$values);
    }
}
