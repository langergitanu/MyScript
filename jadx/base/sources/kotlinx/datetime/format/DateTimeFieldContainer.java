package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.DecimalFraction;

/* JADX INFO: compiled from: LocalDateTimeFormat.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003À\u0006\u0003"}, m1599d2 = {"Lkotlinx/datetime/format/DateTimeFieldContainer;", "Lkotlinx/datetime/format/DateFieldContainer;", "Lkotlinx/datetime/format/TimeFieldContainer;", "kotlinx-datetime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface DateTimeFieldContainer extends DateFieldContainer, TimeFieldContainer {

    /* JADX INFO: compiled from: LocalDateTimeFormat.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static DecimalFraction getFractionOfSecond(DateTimeFieldContainer dateTimeFieldContainer) {
            return DateTimeFieldContainer.super.getFractionOfSecond();
        }

        @Deprecated
        public static void setFractionOfSecond(DateTimeFieldContainer dateTimeFieldContainer, DecimalFraction decimalFraction) {
            DateTimeFieldContainer.super.setFractionOfSecond(decimalFraction);
        }
    }
}
