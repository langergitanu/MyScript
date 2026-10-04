package com.revenuecat.purchases.p036ui.revenuecatui.utils;

import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateFormatter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0003J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/utils/DefaultDateFormatter;", "Lcom/revenuecat/purchases/ui/revenuecatui/utils/DateFormatter;", "()V", "format", "", QuestionSurveyAnswerType.DATE, "Ljava/util/Date;", "locale", "Ljava/util/Locale;", "formatUsingDateTimeFormatter", "formatUsingSimpleDateFormat", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class DefaultDateFormatter implements DateFormatter {
    public static final int $stable = 0;

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.utils.DateFormatter
    public String format(Date date, Locale locale) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return formatUsingDateTimeFormatter(date, locale);
    }

    private final String formatUsingDateTimeFormatter(Date date, Locale locale) {
        String str = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy", locale));
        Intrinsics.checkNotNullExpressionValue(str, "localDate.format(formatter)");
        return str;
    }

    private final String formatUsingSimpleDateFormat(Date date, Locale locale) {
        String str = new SimpleDateFormat("dd MMM yyyy", locale).format(date);
        Intrinsics.checkNotNullExpressionValue(str, "formatter.format(date)");
        return str;
    }
}
