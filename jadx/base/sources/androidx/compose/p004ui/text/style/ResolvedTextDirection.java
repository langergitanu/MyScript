package androidx.compose.p004ui.text.style;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ResolvedTextDirection.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Landroidx/compose/ui/text/style/ResolvedTextDirection;", "", "<init>", "(Ljava/lang/String;I)V", "Ltr", "Rtl", "ui-text"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ResolvedTextDirection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ResolvedTextDirection[] $VALUES;
    public static final ResolvedTextDirection Ltr = new ResolvedTextDirection("Ltr", 0);
    public static final ResolvedTextDirection Rtl = new ResolvedTextDirection("Rtl", 1);

    private static final /* synthetic */ ResolvedTextDirection[] $values() {
        return new ResolvedTextDirection[]{Ltr, Rtl};
    }

    public static EnumEntries<ResolvedTextDirection> getEntries() {
        return $ENTRIES;
    }

    public static ResolvedTextDirection valueOf(String str) {
        return (ResolvedTextDirection) Enum.valueOf(ResolvedTextDirection.class, str);
    }

    public static ResolvedTextDirection[] values() {
        return (ResolvedTextDirection[]) $VALUES.clone();
    }

    private ResolvedTextDirection(String str, int i) {
    }

    static {
        ResolvedTextDirection[] resolvedTextDirectionArr$values = $values();
        $VALUES = resolvedTextDirectionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(resolvedTextDirectionArr$values);
    }
}
