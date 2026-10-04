package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Month.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, m1599d2 = {"number", "", "Lkotlinx/datetime/Month;", "getNumber", "(Lkotlinx/datetime/Month;)I", "Month", "kotlinx-datetime"}, m1600k = 5, m1601mv = {2, 1, 0}, m1603xi = 48, m1604xs = "kotlinx/datetime/MonthKt")
final /* synthetic */ class MonthKt__MonthKt {
    public static final int getNumber(Month month) {
        Intrinsics.checkNotNullParameter(month, "<this>");
        return month.ordinal() + 1;
    }

    public static final Month Month(int i) {
        if (1 > i || i >= 13) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return Month.getEntries().get(i - 1);
    }
}
