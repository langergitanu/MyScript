package androidx.compose.material;

import androidx.webkit.Profile;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SwipeToDismiss.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Landroidx/compose/material/DismissValue;", "", "<init>", "(Ljava/lang/String;I)V", Profile.DEFAULT_PROFILE_NAME, "DismissedToEnd", "DismissedToStart", "material"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DismissValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DismissValue[] $VALUES;
    public static final DismissValue Default = new DismissValue(Profile.DEFAULT_PROFILE_NAME, 0);
    public static final DismissValue DismissedToEnd = new DismissValue("DismissedToEnd", 1);
    public static final DismissValue DismissedToStart = new DismissValue("DismissedToStart", 2);

    private static final /* synthetic */ DismissValue[] $values() {
        return new DismissValue[]{Default, DismissedToEnd, DismissedToStart};
    }

    public static EnumEntries<DismissValue> getEntries() {
        return $ENTRIES;
    }

    public static DismissValue valueOf(String str) {
        return (DismissValue) Enum.valueOf(DismissValue.class, str);
    }

    public static DismissValue[] values() {
        return (DismissValue[]) $VALUES.clone();
    }

    private DismissValue(String str, int i) {
    }

    static {
        DismissValue[] dismissValueArr$values = $values();
        $VALUES = dismissValueArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(dismissValueArr$values);
    }
}
