package aws.sdk.kotlin.runtime.config.profile;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ConfigSection.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;", "", "<init>", "(Ljava/lang/String;I)V", "PROFILE", "SSO_SESSION", "SERVICES", "UNKNOWN", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ConfigSectionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConfigSectionType[] $VALUES;
    public static final ConfigSectionType PROFILE = new ConfigSectionType("PROFILE", 0);
    public static final ConfigSectionType SSO_SESSION = new ConfigSectionType("SSO_SESSION", 1);
    public static final ConfigSectionType SERVICES = new ConfigSectionType("SERVICES", 2);
    public static final ConfigSectionType UNKNOWN = new ConfigSectionType("UNKNOWN", 3);

    private static final /* synthetic */ ConfigSectionType[] $values() {
        return new ConfigSectionType[]{PROFILE, SSO_SESSION, SERVICES, UNKNOWN};
    }

    public static EnumEntries<ConfigSectionType> getEntries() {
        return $ENTRIES;
    }

    public static ConfigSectionType valueOf(String str) {
        return (ConfigSectionType) Enum.valueOf(ConfigSectionType.class, str);
    }

    public static ConfigSectionType[] values() {
        return (ConfigSectionType[]) $VALUES.clone();
    }

    private ConfigSectionType(String str, int i) {
    }

    static {
        ConfigSectionType[] configSectionTypeArr$values = $values();
        $VALUES = configSectionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(configSectionTypeArr$values);
    }
}
