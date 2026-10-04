package com.survicate.surveys.infrastructure.storage.contacts;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: ContactAttributesThrottle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0004"}, m1599d2 = {"TIMER_INTERVAL", "Lkotlin/time/Duration;", "J", "THROTTLE_DELAY", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ContactAttributesThrottleKt {
    private static final long THROTTLE_DELAY;
    private static final long TIMER_INTERVAL;

    static {
        Duration.Companion companion = Duration.INSTANCE;
        TIMER_INTERVAL = DurationKt.toDuration(1, DurationUnit.MINUTES);
        Duration.Companion companion2 = Duration.INSTANCE;
        THROTTLE_DELAY = DurationKt.toDuration(5, DurationUnit.MINUTES);
    }
}
