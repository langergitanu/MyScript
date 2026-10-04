package com.survicate.surveys.core.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DateUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"ISO_DATE_WITH_MILLISECONDS_PATTERN", "", "ISO_DATE_WITHOUT_MILLISECONDS_PATTERN", "ISO_DATE_WITHOUT_COLON_PATTERN", "ISO_DATE_WITH_UTC_PATTERN", "ISO_DATE_WITHOUT_TIMEZONE_PATTERN", "DATE_ONLY_PATTERN", "DATE_ONLY_LENGTH", "", "getDateOnlyPart", "isValidIsoDate", "", "dateString", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DateUtilsKt {
    private static final int DATE_ONLY_LENGTH = 10;
    private static final String DATE_ONLY_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";
    private static final String ISO_DATE_WITHOUT_COLON_PATTERN = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}[+-]\\d{4}$";
    private static final String ISO_DATE_WITHOUT_MILLISECONDS_PATTERN = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}[+-]\\d{2}:\\d{2}$";
    private static final String ISO_DATE_WITHOUT_TIMEZONE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$";
    private static final String ISO_DATE_WITH_MILLISECONDS_PATTERN = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}[+-]\\d{2}:\\d{2}$";
    private static final String ISO_DATE_WITH_UTC_PATTERN = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z$";

    public static final String getDateOnlyPart(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (isValidIsoDate(str)) {
            return StringsKt.take(str, 10);
        }
        return null;
    }

    private static final boolean isValidIsoDate(String str) {
        String str2 = str;
        return new Regex(ISO_DATE_WITH_MILLISECONDS_PATTERN).matches(str2) || new Regex(ISO_DATE_WITHOUT_MILLISECONDS_PATTERN).matches(str2) || new Regex(ISO_DATE_WITHOUT_COLON_PATTERN).matches(str2) || new Regex(ISO_DATE_WITH_UTC_PATTERN).matches(str2) || new Regex(ISO_DATE_WITHOUT_TIMEZONE_PATTERN).matches(str2) || new Regex(DATE_ONLY_PATTERN).matches(str2);
    }
}
