package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.retries.delay.AdaptiveRateLimiter;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
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
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010 R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020&8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010 ¨\u0006/"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/CubicRateCalculator;", "", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "config", "Lkotlin/time/TimeSource;", "timeSource", "", "lastMaxRate", "Lkotlin/time/TimeMark;", "lastThrottleTime", "<init>", "(Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;Lkotlin/time/TimeSource;DLkotlin/time/TimeMark;)V", "Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;", "errorType", "measuredTxRate", "refillUnitsPerSecond", "calculate", "(Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;DD)D", "calculateTimeWindow$runtime_core", "()D", "calculateTimeWindow", "cubicSuccess$runtime_core", "cubicSuccess", "rate", "cubicThrottle$runtime_core", "(D)D", "cubicThrottle", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "Lkotlin/time/TimeSource;", "D", "getLastMaxRate$runtime_core", "setLastMaxRate$runtime_core", "(D)V", "Lkotlin/time/TimeMark;", "getLastThrottleTime$runtime_core", "()Lkotlin/time/TimeMark;", "setLastThrottleTime$runtime_core", "(Lkotlin/time/TimeMark;)V", "", "value", "throttlingEnabled", "Z", "getThrottlingEnabled", "()Z", "timeWindow", "getTimeWindow$runtime_core", "setTimeWindow$runtime_core", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CubicRateCalculator {
    private final AdaptiveRateLimiter.Config config;
    private double lastMaxRate;
    private TimeMark lastThrottleTime;
    private boolean throttlingEnabled;
    private final TimeSource timeSource;
    private double timeWindow;

    public CubicRateCalculator(AdaptiveRateLimiter.Config config, TimeSource timeSource, double d, TimeMark lastThrottleTime) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(lastThrottleTime, "lastThrottleTime");
        this.config = config;
        this.timeSource = timeSource;
        this.lastMaxRate = d;
        this.lastThrottleTime = lastThrottleTime;
        this.timeWindow = calculateTimeWindow$runtime_core();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CubicRateCalculator(AdaptiveRateLimiter.Config config, TimeSource.Monotonic monotonic, double d, TimeMark timeMark, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TimeSource timeSource = (i & 2) != 0 ? TimeSource.Monotonic.INSTANCE : monotonic;
        this(config, timeSource, (i & 4) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d, (i & 8) != 0 ? timeSource.markNow() : timeMark);
    }

    /* JADX INFO: renamed from: getLastMaxRate$runtime_core, reason: from getter */
    public final double getLastMaxRate() {
        return this.lastMaxRate;
    }

    public final void setLastMaxRate$runtime_core(double d) {
        this.lastMaxRate = d;
    }

    /* JADX INFO: renamed from: getLastThrottleTime$runtime_core, reason: from getter */
    public final TimeMark getLastThrottleTime() {
        return this.lastThrottleTime;
    }

    public final void setLastThrottleTime$runtime_core(TimeMark timeMark) {
        Intrinsics.checkNotNullParameter(timeMark, "<set-?>");
        this.lastThrottleTime = timeMark;
    }

    public final boolean getThrottlingEnabled() {
        return this.throttlingEnabled;
    }

    /* JADX INFO: renamed from: getTimeWindow$runtime_core, reason: from getter */
    public final double getTimeWindow() {
        return this.timeWindow;
    }

    public final void setTimeWindow$runtime_core(double d) {
        this.timeWindow = d;
    }

    public final double calculate(RetryErrorType errorType, double measuredTxRate, double refillUnitsPerSecond) {
        if (errorType == RetryErrorType.Throttling) {
            if (this.throttlingEnabled) {
                measuredTxRate = Math.min(measuredTxRate, refillUnitsPerSecond);
            }
            this.lastMaxRate = measuredTxRate;
            this.timeWindow = calculateTimeWindow$runtime_core();
            this.lastThrottleTime = this.timeSource.markNow();
            this.throttlingEnabled = true;
            return cubicThrottle$runtime_core(this.lastMaxRate);
        }
        return cubicSuccess$runtime_core();
    }

    public final double calculateTimeWindow$runtime_core() {
        return Math.cbrt((this.lastMaxRate * (((double) 1) - this.config.getBeta())) / this.config.getScaleConstant());
    }

    public final double cubicSuccess$runtime_core() {
        return (this.config.getScaleConstant() * Math.pow(Duration.m15892toDoubleimpl(this.lastThrottleTime.mo15844elapsedNowUwyO8pc(), DurationUnit.SECONDS) - this.timeWindow, 3)) + this.lastMaxRate;
    }

    public final double cubicThrottle$runtime_core(double rate) {
        return rate * this.config.getBeta();
    }
}
