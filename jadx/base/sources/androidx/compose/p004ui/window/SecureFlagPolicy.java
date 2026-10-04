package androidx.compose.p004ui.window;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SecureFlagPolicy.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Landroidx/compose/ui/window/SecureFlagPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Inherit", "SecureOn", "SecureOff", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SecureFlagPolicy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SecureFlagPolicy[] $VALUES;
    public static final SecureFlagPolicy Inherit = new SecureFlagPolicy("Inherit", 0);
    public static final SecureFlagPolicy SecureOn = new SecureFlagPolicy("SecureOn", 1);
    public static final SecureFlagPolicy SecureOff = new SecureFlagPolicy("SecureOff", 2);

    private static final /* synthetic */ SecureFlagPolicy[] $values() {
        return new SecureFlagPolicy[]{Inherit, SecureOn, SecureOff};
    }

    public static EnumEntries<SecureFlagPolicy> getEntries() {
        return $ENTRIES;
    }

    public static SecureFlagPolicy valueOf(String str) {
        return (SecureFlagPolicy) Enum.valueOf(SecureFlagPolicy.class, str);
    }

    public static SecureFlagPolicy[] values() {
        return (SecureFlagPolicy[]) $VALUES.clone();
    }

    private SecureFlagPolicy(String str, int i) {
    }

    static {
        SecureFlagPolicy[] secureFlagPolicyArr$values = $values();
        $VALUES = secureFlagPolicyArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(secureFlagPolicyArr$values);
    }
}
