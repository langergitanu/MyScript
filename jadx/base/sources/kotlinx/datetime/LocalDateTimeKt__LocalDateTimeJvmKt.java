package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalDateTimeJvm.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¨\u0006\u000b"}, m1599d2 = {"LocalDateTime", "Lkotlinx/datetime/LocalDateTime;", "year", "", "month", "Ljava/time/Month;", "dayOfMonth", "hour", "minute", "second", "nanosecond", "kotlinx-datetime"}, m1600k = 5, m1601mv = {2, 1, 0}, m1603xi = 48, m1604xs = "kotlinx/datetime/LocalDateTimeKt")
final /* synthetic */ class LocalDateTimeKt__LocalDateTimeJvmKt {
    public static /* synthetic */ LocalDateTime LocalDateTime$default(int i, java.time.Month month, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 32) != 0) {
            i5 = 0;
        }
        if ((i7 & 64) != 0) {
            i6 = 0;
        }
        return LocalDateTimeKt.LocalDateTime(i, month, i2, i3, i4, i5, i6);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the constructor that accepts a 'day'", replaceWith = @ReplaceWith(expression = "LocalDateTime(year = year, month = month.toKotlinMonth(), day = dayOfMonth, hour = hour, minute = minute, second = second, nanosecond = nanosecond)", imports = {}))
    public static final LocalDateTime LocalDateTime(int i, java.time.Month month, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(month, "month");
        return new LocalDateTime(i, ConvertersKt.toKotlinMonth(month), i2, i3, i4, i5, i6);
    }
}
