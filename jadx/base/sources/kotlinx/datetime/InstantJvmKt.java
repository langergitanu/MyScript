package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.time.Instant;
import kotlinx.datetime.DateTimeUnit;

/* JADX INFO: compiled from: Instant.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"kotlinx/datetime/InstantJvmKt__InstantKt"}, m1600k = 4, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class InstantJvmKt {
    public static final Instant minus(Instant instant, int i, DateTimeUnit dateTimeUnit, TimeZone timeZone) {
        return InstantJvmKt__InstantKt.minus(instant, i, dateTimeUnit, timeZone);
    }

    public static final DateTimePeriod periodUntil(Instant instant, Instant instant2, TimeZone timeZone) {
        return InstantJvmKt__InstantKt.periodUntil(instant, instant2, timeZone);
    }

    public static final Instant plus(Instant instant, int i, DateTimeUnit dateTimeUnit, TimeZone timeZone) {
        return InstantJvmKt__InstantKt.plus(instant, i, dateTimeUnit, timeZone);
    }

    public static final Instant plus(Instant instant, long j, DateTimeUnit.TimeBased timeBased) {
        return InstantJvmKt__InstantKt.plus(instant, j, timeBased);
    }

    public static final Instant plus(Instant instant, long j, DateTimeUnit dateTimeUnit, TimeZone timeZone) {
        return InstantJvmKt__InstantKt.plus(instant, j, dateTimeUnit, timeZone);
    }

    public static final Instant plus(Instant instant, DateTimePeriod dateTimePeriod, TimeZone timeZone) {
        return InstantJvmKt__InstantKt.plus(instant, dateTimePeriod, timeZone);
    }

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit, timeZone)", imports = {}))
    public static final Instant plus(Instant instant, DateTimeUnit dateTimeUnit, TimeZone timeZone) {
        return InstantJvmKt__InstantKt.plus(instant, dateTimeUnit, timeZone);
    }

    public static final long until(Instant instant, Instant instant2, DateTimeUnit dateTimeUnit, TimeZone timeZone) {
        return InstantJvmKt__InstantKt.until(instant, instant2, dateTimeUnit, timeZone);
    }
}
