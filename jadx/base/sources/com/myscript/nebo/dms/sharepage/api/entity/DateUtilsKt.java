package com.myscript.nebo.dms.sharepage.api.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;

/* JADX INFO: compiled from: DateUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0006"}, m1599d2 = {"parseTimestampISO8601", "", "isoDate", "", "formatDateISO8601", "timestampMicros", "dms-share-page_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DateUtilsKt {
    public static final long parseTimestampISO8601(String isoDate) {
        Intrinsics.checkNotNullParameter(isoDate, "isoDate");
        return ISODateTimeFormat.dateTime().parseDateTime(isoDate).getMillis();
    }

    public static final String formatDateISO8601(long j) {
        DateTime dateTime = new DateTime();
        dateTime.withZone(DateTimeZone.UTC);
        dateTime.withMillis(j / ((long) 1000));
        String strPrint = ISODateTimeFormat.dateTime().print(dateTime);
        Intrinsics.checkNotNullExpressionValue(strPrint, "print(...)");
        return strPrint;
    }
}
