package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.YearMonth;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;

/* JADX INFO: compiled from: YearMonthFormat.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¨\u0006\u0015À\u0006\u0003"}, m1599d2 = {"Lkotlinx/datetime/format/AbstractWithYearMonthBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithYearMonth;", "addFormatStructureForYearMonth", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/YearMonthFieldContainer;", "year", "padding", "Lkotlinx/datetime/format/Padding;", "yearTwoDigits", "baseYear", "", "monthNumber", "monthName", "names", "Lkotlinx/datetime/format/MonthNames;", "yearMonth", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/YearMonth;", "kotlinx-datetime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface AbstractWithYearMonthBuilder extends DateTimeFormatBuilder.WithYearMonth {
    void addFormatStructureForYearMonth(FormatStructure<? super YearMonthFieldContainer> structure);

    /* JADX INFO: compiled from: YearMonthFormat.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void year(AbstractWithYearMonthBuilder abstractWithYearMonthBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithYearMonthBuilder.super.year(padding);
        }

        @Deprecated
        public static void yearTwoDigits(AbstractWithYearMonthBuilder abstractWithYearMonthBuilder, int i) {
            AbstractWithYearMonthBuilder.super.yearTwoDigits(i);
        }

        @Deprecated
        public static void monthNumber(AbstractWithYearMonthBuilder abstractWithYearMonthBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithYearMonthBuilder.super.monthNumber(padding);
        }

        @Deprecated
        public static void monthName(AbstractWithYearMonthBuilder abstractWithYearMonthBuilder, MonthNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            AbstractWithYearMonthBuilder.super.monthName(names);
        }

        @Deprecated
        public static void yearMonth(AbstractWithYearMonthBuilder abstractWithYearMonthBuilder, DateTimeFormat<YearMonth> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithYearMonthBuilder.super.yearMonth(format);
        }
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithYearMonth
    default void year(Padding padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        addFormatStructureForYearMonth(new BasicFormatStructure(new YearDirective(padding, false, 2, null)));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithYearMonth
    default void yearTwoDigits(int baseYear) {
        addFormatStructureForYearMonth(new BasicFormatStructure(new ReducedYearDirective(baseYear, false, 2, null)));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithYearMonth
    default void monthNumber(Padding padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        addFormatStructureForYearMonth(new BasicFormatStructure(new MonthDirective(padding)));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithYearMonth
    default void monthName(MonthNames names) {
        Intrinsics.checkNotNullParameter(names, "names");
        addFormatStructureForYearMonth(new BasicFormatStructure(new MonthNameDirective(names)));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithYearMonth
    default void yearMonth(DateTimeFormat<YearMonth> format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (format instanceof YearMonthFormat) {
            addFormatStructureForYearMonth(((YearMonthFormat) format).getActualFormat());
        }
    }
}
