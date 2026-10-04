package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LocalTimeFormat.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lkotlinx/datetime/format/AmPmMarker;", "", "<init>", "(Ljava/lang/String;I)V", "AM", "PM", "kotlinx-datetime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AmPmMarker {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AmPmMarker[] $VALUES;

    /* JADX INFO: renamed from: AM */
    public static final AmPmMarker f2335AM = new AmPmMarker("AM", 0);

    /* JADX INFO: renamed from: PM */
    public static final AmPmMarker f2336PM = new AmPmMarker("PM", 1);

    private static final /* synthetic */ AmPmMarker[] $values() {
        return new AmPmMarker[]{f2335AM, f2336PM};
    }

    public static EnumEntries<AmPmMarker> getEntries() {
        return $ENTRIES;
    }

    private AmPmMarker(String str, int i) {
    }

    static {
        AmPmMarker[] amPmMarkerArr$values = $values();
        $VALUES = amPmMarkerArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(amPmMarkerArr$values);
    }

    public static AmPmMarker valueOf(String str) {
        return (AmPmMarker) Enum.valueOf(AmPmMarker.class, str);
    }

    public static AmPmMarker[] values() {
        return (AmPmMarker[]) $VALUES.clone();
    }
}
