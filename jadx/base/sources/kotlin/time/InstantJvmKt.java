package kotlin.time;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InstantJvm.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0080\u0080\u0004\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"systemClock", "Lkotlin/time/Clock;", "systemClockNow", "Lkotlin/time/Instant;", "serializedInstant", "", "instant", "kotlin-stdlib"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InstantJvmKt {
    private static final Clock systemClock = PlatformImplementationsKt.IMPLEMENTATIONS.getSystemClock();

    public static final Instant systemClockNow() {
        return systemClock.now();
    }

    public static final Object serializedInstant(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return new InstantSerialized(instant.getEpochSeconds(), instant.getNanosecondsOfSecond());
    }
}
