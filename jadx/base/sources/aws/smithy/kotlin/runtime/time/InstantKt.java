package aws.smithy.kotlin.runtime.time;

import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: Instant.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0007\u001a\u00020\u0000*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\r8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\r8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\r8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f\"\u0015\u0010\u0014\u001a\u00020\u0005*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/Instant;", "", "toEpochDouble", "(Laws/smithy/kotlin/runtime/time/Instant;)D", "Laws/smithy/kotlin/runtime/time/Instant$Companion;", "", "milliseconds", "fromEpochMilliseconds", "(Laws/smithy/kotlin/runtime/time/Instant$Companion;J)Laws/smithy/kotlin/runtime/time/Instant;", "other", "Lkotlin/time/Duration;", "until", "(Laws/smithy/kotlin/runtime/time/Instant;Laws/smithy/kotlin/runtime/time/Instant;)J", "", "NS_PER_SEC", "I", "MILLISEC_PER_SEC", "NS_PER_MILLISEC", "getEpochMilliseconds", "(Laws/smithy/kotlin/runtime/time/Instant;)J", "epochMilliseconds", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InstantKt {
    public static final int MILLISEC_PER_SEC = 1000;
    public static final int NS_PER_MILLISEC = 1000000;
    public static final int NS_PER_SEC = 1000000000;

    public static final double toEpochDouble(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.getEpochSeconds() + (((double) instant.getNanosecondsOfSecond()) / ((double) 1000000000));
    }

    public static final long getEpochMilliseconds(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return (instant.getEpochSeconds() * ((long) 1000)) + ((long) (instant.getNanosecondsOfSecond() / 1000000));
    }

    public static final Instant fromEpochMilliseconds(Instant.Companion companion, long j) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        long j2 = 1000;
        long j3 = j / j2;
        return companion.fromEpochSeconds(j3, (int) ((j - (j2 * j3)) * ((long) 1000000)));
    }

    public static final long until(Instant instant, Instant other) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration(getEpochMilliseconds(other) - getEpochMilliseconds(instant), DurationUnit.MILLISECONDS);
    }
}
