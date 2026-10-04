package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.retries.delay.AdaptiveRateLimiter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

/* JADX INFO: compiled from: AdaptiveRateLimiter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateMeasurer;", "", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "config", "Lkotlin/time/TimeSource;", "timeSource", "Lkotlin/time/TimeMark;", "lastTxBucketMark", "", "measuredTxRate", "", "requestCount", "<init>", "(Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;Lkotlin/time/TimeSource;Lkotlin/time/TimeMark;DI)V", "updateMeasuredRate", "()D", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "Lkotlin/time/TimeSource;", "Lkotlin/time/TimeMark;", "D", "getMeasuredTxRate$runtime_core", "setMeasuredTxRate$runtime_core", "(D)V", "I", "bucketsPerSecond", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AdaptiveRateMeasurer {
    private final double bucketsPerSecond;
    private final AdaptiveRateLimiter.Config config;
    private TimeMark lastTxBucketMark;
    private double measuredTxRate;
    private int requestCount;
    private final TimeSource timeSource;

    public AdaptiveRateMeasurer(AdaptiveRateLimiter.Config config, TimeSource timeSource, TimeMark lastTxBucketMark, double d, int i) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(lastTxBucketMark, "lastTxBucketMark");
        this.config = config;
        this.timeSource = timeSource;
        this.lastTxBucketMark = lastTxBucketMark;
        this.measuredTxRate = d;
        this.requestCount = i;
        this.bucketsPerSecond = ((double) 1) / Duration.m15892toDoubleimpl(config.m12237getMeasurementBucketDurationUwyO8pc(), DurationUnit.SECONDS);
    }

    public /* synthetic */ AdaptiveRateMeasurer(AdaptiveRateLimiter.Config config, TimeSource timeSource, TimeMark timeMark, double d, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(config, timeSource, (i2 & 4) != 0 ? timeSource.markNow() : timeMark, (i2 & 8) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d, (i2 & 16) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: getMeasuredTxRate$runtime_core, reason: from getter */
    public final double getMeasuredTxRate() {
        return this.measuredTxRate;
    }

    public final void setMeasuredTxRate$runtime_core(double d) {
        this.measuredTxRate = d;
    }

    public final double updateMeasuredRate() {
        this.requestCount++;
        double dFloor = Math.floor(Duration.m15857divLRDsOJo(this.lastTxBucketMark.mo15844elapsedNowUwyO8pc(), this.config.m12237getMeasurementBucketDurationUwyO8pc()));
        if (dFloor >= 1.0d) {
            this.measuredTxRate = ((((double) this.requestCount) / dFloor) * this.bucketsPerSecond * this.config.getSmoothing()) + (this.measuredTxRate * (((double) 1) - this.config.getSmoothing()));
            this.lastTxBucketMark = this.lastTxBucketMark.mo15847plusLRDsOJo(Duration.m15886timesUwyO8pc(this.config.m12237getMeasurementBucketDurationUwyO8pc(), dFloor));
            this.requestCount = 0;
        }
        return this.measuredTxRate;
    }
}
