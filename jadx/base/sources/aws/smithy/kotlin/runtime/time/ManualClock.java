package aws.smithy.kotlin.runtime.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: compiled from: ManualClock.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/ManualClock;", "Laws/smithy/kotlin/runtime/time/Clock;", "Laws/smithy/kotlin/runtime/time/Instant;", "epoch", "<init>", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "Lkotlin/time/Duration;", TypedValues.TransitionType.S_DURATION, "", "advance-LRDsOJo", "(J)V", "advance", "now", "()Laws/smithy/kotlin/runtime/time/Instant;", "Laws/smithy/kotlin/runtime/time/Instant;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ManualClock implements Clock {
    private Instant now;

    /* JADX WARN: Multi-variable type inference failed */
    public ManualClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ManualClock(Instant epoch) {
        Intrinsics.checkNotNullParameter(epoch, "epoch");
        this.now = epoch;
    }

    public /* synthetic */ ManualClock(Instant instant, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Instant.INSTANCE.now() : instant);
    }

    @Override // aws.smithy.kotlin.runtime.time.Clock
    /* JADX INFO: renamed from: now, reason: from getter */
    public Instant getNow() {
        return this.now;
    }

    /* JADX INFO: renamed from: advance-LRDsOJo, reason: not valid java name */
    public final void m12290advanceLRDsOJo(long duration) {
        this.now = Instant.INSTANCE.fromEpochSeconds(this.now.getEpochSeconds() + Duration.m15870getInWholeSecondsimpl(duration), this.now.getNanosecondsOfSecond() + Duration.m15872getNanosecondsComponentimpl(duration));
    }
}
