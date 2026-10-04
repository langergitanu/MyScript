package aws.sdk.kotlin.runtime.auth.credentials.profile;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ProfileChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/RoleArnSource;", "", "<init>", "(Ljava/lang/String;I)V", "SOURCE_PROFILE", "CREDENTIALS_SOURCE", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RoleArnSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RoleArnSource[] $VALUES;
    public static final RoleArnSource SOURCE_PROFILE = new RoleArnSource("SOURCE_PROFILE", 0);
    public static final RoleArnSource CREDENTIALS_SOURCE = new RoleArnSource("CREDENTIALS_SOURCE", 1);

    private static final /* synthetic */ RoleArnSource[] $values() {
        return new RoleArnSource[]{SOURCE_PROFILE, CREDENTIALS_SOURCE};
    }

    public static EnumEntries<RoleArnSource> getEntries() {
        return $ENTRIES;
    }

    public static RoleArnSource valueOf(String str) {
        return (RoleArnSource) Enum.valueOf(RoleArnSource.class, str);
    }

    public static RoleArnSource[] values() {
        return (RoleArnSource[]) $VALUES.clone();
    }

    private RoleArnSource(String str, int i) {
    }

    static {
        RoleArnSource[] roleArnSourceArr$values = $values();
        $VALUES = roleArnSourceArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(roleArnSourceArr$values);
    }
}
