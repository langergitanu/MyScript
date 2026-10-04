package aws.sdk.kotlin.runtime.config.endpoints;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AccountIdEndpointMode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/endpoints/AccountIdEndpointMode;", "", "<init>", "(Ljava/lang/String;I)V", "PREFERRED", "DISABLED", "REQUIRED", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AccountIdEndpointMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AccountIdEndpointMode[] $VALUES;
    public static final AccountIdEndpointMode PREFERRED = new AccountIdEndpointMode("PREFERRED", 0);
    public static final AccountIdEndpointMode DISABLED = new AccountIdEndpointMode("DISABLED", 1);
    public static final AccountIdEndpointMode REQUIRED = new AccountIdEndpointMode("REQUIRED", 2);

    private static final /* synthetic */ AccountIdEndpointMode[] $values() {
        return new AccountIdEndpointMode[]{PREFERRED, DISABLED, REQUIRED};
    }

    public static EnumEntries<AccountIdEndpointMode> getEntries() {
        return $ENTRIES;
    }

    public static AccountIdEndpointMode valueOf(String str) {
        return (AccountIdEndpointMode) Enum.valueOf(AccountIdEndpointMode.class, str);
    }

    public static AccountIdEndpointMode[] values() {
        return (AccountIdEndpointMode[]) $VALUES.clone();
    }

    private AccountIdEndpointMode(String str, int i) {
    }

    static {
        AccountIdEndpointMode[] accountIdEndpointModeArr$values = $values();
        $VALUES = accountIdEndpointModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(accountIdEndpointModeArr$values);
    }
}
