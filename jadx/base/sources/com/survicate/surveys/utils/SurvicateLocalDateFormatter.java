package com.survicate.surveys.utils;

import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SurvicateLocalDateFormatter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/utils/SurvicateLocalDateFormatter;", "", "<init>", "()V", "RESPONDENT_API_DATE_FORMAT", "", "formatYear", QuestionSurveyAnswerType.DATE, "Lcom/survicate/surveys/utils/SurvicateLocalDate;", "formatMonth", "formatDay", "formatAsContentDescription", "formatAsRespondentDate", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateLocalDateFormatter {
    public static final SurvicateLocalDateFormatter INSTANCE = new SurvicateLocalDateFormatter();
    private static final String RESPONDENT_API_DATE_FORMAT = "yyyy-MM-dd";

    private SurvicateLocalDateFormatter() {
    }

    public final String formatYear(SurvicateLocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return String.valueOf(date.getYear());
    }

    public final String formatMonth(SurvicateLocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return StringsKt.padStart(String.valueOf(date.getMonth()), 2, '0');
    }

    public final String formatDay(SurvicateLocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return StringsKt.padStart(String.valueOf(date.getDay()), 2, '0');
    }

    public final String formatAsContentDescription(SurvicateLocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String str = DateFormat.getDateInstance(1).format(Long.valueOf(date.toCalendar().getTimeInMillis()));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String formatAsRespondentDate(SurvicateLocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String str = new SimpleDateFormat(RESPONDENT_API_DATE_FORMAT, Locale.US).format(Long.valueOf(date.toCalendar().getTimeInMillis()));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
