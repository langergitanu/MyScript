package kotlinx.datetime;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.YearMonth;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: YearMonthJvm.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\"#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m1599d2 = {"toEpochMonths", "", "Lkotlinx/datetime/YearMonth;", "fromEpochMonths", "Lkotlinx/datetime/YearMonth$Companion;", "months", "isoFormat", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "getIsoFormat", "()Ljava/time/format/DateTimeFormatter;", "isoFormat$delegate", "Lkotlin/Lazy;", "kotlinx-datetime"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class YearMonthJvmKt {
    private static final Lazy isoFormat$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.YearMonthJvmKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return YearMonthJvmKt.isoFormat_delegate$lambda$0();
        }
    });

    public static final long toEpochMonths(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        return (((((long) yearMonth.getYear()) - 1970) * ((long) 12)) + ((long) yearMonth.getMonthNumber$kotlinx_datetime())) - 1;
    }

    public static final YearMonth fromEpochMonths(YearMonth.Companion companion, long j) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        long j2 = 12;
        long j3 = j / j2;
        if ((j ^ j2) < 0 && j3 * j2 != j) {
            j3--;
        }
        long j4 = j % j2;
        return new YearMonth((int) (j3 + ((long) 1970)), ((int) (j4 + (j2 & (((j4 ^ j2) & ((-j4) | j4)) >> 63)))) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter getIsoFormat() {
        return (DateTimeFormatter) isoFormat$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter isoFormat_delegate$lambda$0() {
        return new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral(Soundex.SILENT_MARKER).appendValue(ChronoField.MONTH_OF_YEAR, 2).toFormatter();
    }
}
