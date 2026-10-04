package com.survicate.surveys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DateUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u0005*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u001c¨\u0006\u001d"}, m1599d2 = {"Lcom/survicate/surveys/utils/DateUtils;", "", "<init>", "()V", "differenceBetweenDates", "", "oldDate", "Ljava/util/Date;", "newDate", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "oldDateMs", "newDateMs", "fromIsoStringToMillis", "dateTimeIso", "", "fromIsoStringToMillis$survicate_sdk_release", "(Ljava/lang/String;)Ljava/lang/Long;", "tryParseToMillis", "Ljava/text/SimpleDateFormat;", "input", "(Ljava/text/SimpleDateFormat;Ljava/lang/String;)Ljava/lang/Long;", "isZonedDateTimeIsoString", "", "value", "isZonedDateTimeIsoString$survicate_sdk_release", "getDateOnlyPart", "inputDate", "getDateOnlyPart$survicate_sdk_release", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DateUtils {
    public static final DateUtils INSTANCE = new DateUtils();

    private DateUtils() {
    }

    @JvmStatic
    public static final long differenceBetweenDates(Date oldDate, Date newDate, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(oldDate, "oldDate");
        Intrinsics.checkNotNullParameter(newDate, "newDate");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        return INSTANCE.differenceBetweenDates(oldDate.getTime(), newDate.getTime(), timeUnit);
    }

    public final long differenceBetweenDates(long oldDateMs, long newDateMs, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        return timeUnit.convert(newDateMs - oldDateMs, TimeUnit.MILLISECONDS);
    }

    public final Long fromIsoStringToMillis$survicate_sdk_release(String dateTimeIso) {
        Intrinsics.checkNotNullParameter(dateTimeIso, "dateTimeIso");
        String strReplace$default = StringsKt.replace$default(dateTimeIso, "Z", "+00:00", false, 4, (Object) null);
        String str = StringsKt.dropLast(strReplace$default, 3) + StringsKt.takeLast(strReplace$default, 2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Long lTryParseToMillis = tryParseToMillis(simpleDateFormat, str);
        if (lTryParseToMillis != null) {
            return lTryParseToMillis;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        return tryParseToMillis(simpleDateFormat2, str);
    }

    public final Long tryParseToMillis(SimpleDateFormat simpleDateFormat, String input) {
        Intrinsics.checkNotNullParameter(simpleDateFormat, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            Date date = simpleDateFormat.parse(input);
            if (date != null) {
                return Long.valueOf(date.getTime());
            }
        } catch (ParseException unused) {
        }
        return null;
    }

    public final boolean isZonedDateTimeIsoString$survicate_sdk_release(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return fromIsoStringToMillis$survicate_sdk_release(value) != null;
    }

    public final String getDateOnlyPart$survicate_sdk_release(String inputDate) {
        Intrinsics.checkNotNullParameter(inputDate, "inputDate");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = simpleDateFormat.parse(inputDate);
            if (date == null) {
                return null;
            }
            return simpleDateFormat.format(date);
        } catch (ParseException unused) {
            return null;
        }
    }
}
