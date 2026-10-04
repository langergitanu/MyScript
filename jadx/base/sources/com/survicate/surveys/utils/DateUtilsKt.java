package com.survicate.surveys.utils;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DateUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0000\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"RFC_822_PATTERN_NO_MILLIS", "", "RFC_822_PATTERN_WITH_MILLIS", "ISO_TIMEZONE_SUFFIX", "", "RFC_TIMEZONE_SUFFIX", "DATE_ONLY_ISO_PATTERN", "toIsoString", "Ljava/util/Date;", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "Ljava/util/TimeZone;", "getDateOnlyPart", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DateUtilsKt {
    private static final String DATE_ONLY_ISO_PATTERN = "yyyy-MM-dd";
    private static final int ISO_TIMEZONE_SUFFIX = 3;
    private static final String RFC_822_PATTERN_NO_MILLIS = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static final String RFC_822_PATTERN_WITH_MILLIS = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final int RFC_TIMEZONE_SUFFIX = 2;

    public static /* synthetic */ String toIsoString$default(Date date, TimeZone timeZone, int i, Object obj) {
        if ((i & 1) != 0) {
            timeZone = TimeZone.getDefault();
        }
        return toIsoString(date, timeZone);
    }

    public static final String toIsoString(Date date, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RFC_822_PATTERN_NO_MILLIS, Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        String str = simpleDateFormat.format(date);
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull(str);
        return sb.append(StringsKt.dropLast(str, 2)).append(AbstractJsonLexerKt.COLON).append(StringsKt.takeLast(str, 2)).toString();
    }

    public static final String getDateOnlyPart(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return DateUtils.INSTANCE.getDateOnlyPart$survicate_sdk_release(str);
    }
}
