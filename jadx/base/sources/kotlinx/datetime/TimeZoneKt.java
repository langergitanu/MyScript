package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.time.Instant;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"kotlinx/datetime/TimeZoneKt__TimeZoneJvmKt", "kotlinx/datetime/TimeZoneKt__TimeZoneKt"}, m1600k = 4, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TimeZoneKt {
    public static final Instant atStartOfDayIn(LocalDate localDate, TimeZone timeZone, OverloadMarker overloadMarker) {
        return TimeZoneKt__TimeZoneJvmKt.atStartOfDayIn(localDate, timeZone, overloadMarker);
    }

    public static final UtcOffset offsetAt(TimeZone timeZone, Instant instant) {
        return TimeZoneKt__TimeZoneJvmKt.offsetAt(timeZone, instant);
    }

    public static final UtcOffset offsetIn(Instant instant, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneKt.offsetIn(instant, timeZone);
    }

    public static final Instant toInstant(LocalDateTime localDateTime, TimeZone timeZone, OverloadMarker overloadMarker) {
        return TimeZoneKt__TimeZoneJvmKt.toInstant(localDateTime, timeZone, overloadMarker);
    }

    public static final Instant toInstant(LocalDateTime localDateTime, UtcOffset utcOffset, OverloadMarker overloadMarker) {
        return TimeZoneKt__TimeZoneJvmKt.toInstant(localDateTime, utcOffset, overloadMarker);
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneJvmKt.toLocalDateTime(instant, timeZone);
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, UtcOffset utcOffset) {
        return TimeZoneKt__TimeZoneJvmKt.toLocalDateTime(instant, utcOffset);
    }
}
