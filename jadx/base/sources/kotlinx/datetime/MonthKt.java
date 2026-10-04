package kotlinx.datetime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"kotlinx/datetime/MonthKt__MonthJvmKt", "kotlinx/datetime/MonthKt__MonthKt"}, m1600k = 4, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MonthKt {
    /* JADX INFO: renamed from: Month, reason: collision with other method in class */
    public static final Month m16116Month(int i) {
        return MonthKt__MonthKt.Month(i);
    }

    public static final int getNumber(java.time.Month month) {
        return MonthKt__MonthJvmKt.getNumber(month);
    }

    public static final int getNumber(Month month) {
        return MonthKt__MonthKt.getNumber(month);
    }
}
