package kotlinx.datetime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"kotlinx/datetime/DayOfWeekKt__DayOfWeekJvmKt", "kotlinx/datetime/DayOfWeekKt__DayOfWeekKt"}, m1600k = 4, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DayOfWeekKt {
    /* JADX INFO: renamed from: DayOfWeek, reason: collision with other method in class */
    public static final DayOfWeek m16106DayOfWeek(int i) {
        return DayOfWeekKt__DayOfWeekKt.DayOfWeek(i);
    }

    public static final int getIsoDayNumber(java.time.DayOfWeek dayOfWeek) {
        return DayOfWeekKt__DayOfWeekJvmKt.getIsoDayNumber(dayOfWeek);
    }

    public static final int getIsoDayNumber(DayOfWeek dayOfWeek) {
        return DayOfWeekKt__DayOfWeekKt.getIsoDayNumber(dayOfWeek);
    }
}
