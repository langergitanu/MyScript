package aws.smithy.kotlin.runtime.retries.delay;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.retries.delay.AdaptiveRateLimiter;
import aws.smithy.kotlin.runtime.retries.delay.RateLimiter;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import aws.smithy.kotlin.runtime.util.DslFactory;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: AdaptiveRateLimiter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0002/0B+\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0013\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u0016\u0010\"\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010#\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u001bR\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010#R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00061"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter;", "Laws/smithy/kotlin/runtime/retries/delay/RateLimiter;", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "config", "Lkotlin/time/TimeSource;", "timeSource", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateMeasurer;", "rateMeasurer", "Laws/smithy/kotlin/runtime/retries/delay/CubicRateCalculator;", "rateCalculator", "<init>", "(Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;Lkotlin/time/TimeSource;Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateMeasurer;Laws/smithy/kotlin/runtime/retries/delay/CubicRateCalculator;)V", "(Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;)V", "", "cost", "", "acquire", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refillCapacity", "()V", "Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;", "errorType", "update", "(Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "newRate", "updateRefillRate", "(D)V", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "getConfig", "()Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "Lkotlin/time/TimeSource;", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateMeasurer;", "Laws/smithy/kotlin/runtime/retries/delay/CubicRateCalculator;", "capacity", "D", "Lkotlin/time/TimeMark;", "lastTimeMark", "Lkotlin/time/TimeMark;", "refillUnitsPerSecond", "getRefillUnitsPerSecond$runtime_core", "()D", "setRefillUnitsPerSecond$runtime_core", "maxCapacity", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Companion", "Config", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AdaptiveRateLimiter implements RateLimiter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private double capacity;
    private final Config config;
    private TimeMark lastTimeMark;
    private double maxCapacity;
    private final Mutex mutex;
    private final CubicRateCalculator rateCalculator;
    private final AdaptiveRateMeasurer rateMeasurer;
    private double refillUnitsPerSecond;
    private final TimeSource timeSource;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.delay.AdaptiveRateLimiter$acquire$1 */
    /* JADX INFO: compiled from: AdaptiveRateLimiter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.delay.AdaptiveRateLimiter", m1609f = "AdaptiveRateLimiter.kt", m1610i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, m1611l = {269, 60}, m1612m = "acquire", m1613n = {"$this$withLock_u24default$iv", "cost", "$i$f$withLock", "$this$withLock_u24default$iv", "cost", "$i$f$withLock", "$i$a$-withLock$default-AdaptiveRateLimiter$acquire$2", "extraRequiredCapacity", "delayDuration"}, m1614nl = {270, 61}, m1615s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "I$2", "D$0", "J$0"}, m1616v = 2)
    static final class C37721 extends ContinuationImpl {
        double D$0;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C37721(Continuation<? super C37721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AdaptiveRateLimiter.this.acquire(0, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.delay.AdaptiveRateLimiter$update$1 */
    /* JADX INFO: compiled from: AdaptiveRateLimiter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.delay.AdaptiveRateLimiter", m1609f = "AdaptiveRateLimiter.kt", m1610i = {0, 0, 0}, m1611l = {269}, m1612m = "update", m1613n = {"errorType", "$this$withLock_u24default$iv", "$i$f$withLock"}, m1614nl = {270}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C37731 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37731(Continuation<? super C37731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AdaptiveRateLimiter.this.update(null, this);
        }
    }

    public AdaptiveRateLimiter(Config config, TimeSource timeSource, AdaptiveRateMeasurer rateMeasurer, CubicRateCalculator rateCalculator) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(rateMeasurer, "rateMeasurer");
        Intrinsics.checkNotNullParameter(rateCalculator, "rateCalculator");
        this.config = config;
        this.timeSource = timeSource;
        this.rateMeasurer = rateMeasurer;
        this.rateCalculator = rateCalculator;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    public /* synthetic */ AdaptiveRateLimiter(Config config, TimeSource timeSource, AdaptiveRateMeasurer adaptiveRateMeasurer, CubicRateCalculator cubicRateCalculator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Config.INSTANCE.getDefault() : config, timeSource, adaptiveRateMeasurer, cubicRateCalculator);
    }

    @Override // aws.smithy.kotlin.runtime.retries.delay.RateLimiter
    public Config getConfig() {
        return this.config;
    }

    public /* synthetic */ AdaptiveRateLimiter(Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Config.INSTANCE.getDefault() : config);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdaptiveRateLimiter(Config config) {
        this(config, TimeSource.Monotonic.INSTANCE, new AdaptiveRateMeasurer(config, TimeSource.Monotonic.INSTANCE, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, 28, null), new CubicRateCalculator(config, TimeSource.Monotonic.INSTANCE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, 12, null));
        Intrinsics.checkNotNullParameter(config, "config");
    }

    /* JADX INFO: compiled from: AdaptiveRateLimiter.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Companion;", "Laws/smithy/kotlin/runtime/util/DslFactory;", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion implements DslFactory<Config.Builder, AdaptiveRateLimiter> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // aws.smithy.kotlin.runtime.util.DslFactory
        public AdaptiveRateLimiter invoke(Function1<? super Config.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config.Builder builder = new Config.Builder();
            block.invoke(builder);
            return new AdaptiveRateLimiter(new Config(builder));
        }
    }

    /* JADX INFO: renamed from: getRefillUnitsPerSecond$runtime_core, reason: from getter */
    public final double getRefillUnitsPerSecond() {
        return this.refillUnitsPerSecond;
    }

    public final void setRefillUnitsPerSecond$runtime_core(double d) {
        this.refillUnitsPerSecond = d;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.retries.delay.RateLimiter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object acquire(int i, Continuation<? super Unit> continuation) throws Throwable {
        C37721 c37721;
        Mutex mutex;
        int i2;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C37721) {
            c37721 = (C37721) continuation;
            if ((c37721.label & Integer.MIN_VALUE) != 0) {
                c37721.label -= Integer.MIN_VALUE;
            } else {
                c37721 = new C37721(continuation);
            }
        }
        Object obj = c37721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c37721.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                c37721.L$0 = mutex;
                c37721.I$0 = i;
                c37721.I$1 = 0;
                c37721.label = 1;
                if (mutex.lock(null, c37721) != coroutine_suspended) {
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j = c37721.J$0;
                double d = c37721.D$0;
                int i4 = c37721.I$2;
                int i5 = c37721.I$1;
                int i6 = c37721.I$0;
                mutex2 = (Mutex) c37721.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.capacity = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i7 = c37721.I$1;
            int i8 = c37721.I$0;
            Mutex mutex3 = (Mutex) c37721.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i7;
            i = i8;
            mutex = mutex3;
            if (this.rateCalculator.getThrottlingEnabled()) {
                refillCapacity();
                double d2 = i;
                double d3 = this.capacity;
                if (d2 <= d3) {
                    this.capacity = d3 - d2;
                } else {
                    double d4 = d2 - d3;
                    Duration.Companion companion = Duration.INSTANCE;
                    long duration = DurationKt.toDuration(d4 / this.refillUnitsPerSecond, DurationUnit.SECONDS);
                    c37721.L$0 = mutex;
                    c37721.I$0 = i;
                    c37721.I$1 = i2;
                    c37721.I$2 = 0;
                    c37721.D$0 = d4;
                    c37721.J$0 = duration;
                    c37721.label = 2;
                    if (DelayKt.m16008delayVtjQ1oo(duration, c37721) != coroutine_suspended) {
                        mutex2 = mutex;
                        this.capacity = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return unit2;
                    }
                    return coroutine_suspended;
                }
            }
            mutex2 = mutex;
            Unit unit22 = Unit.INSTANCE;
            mutex2.unlock(null);
            return unit22;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    private final void refillCapacity() {
        TimeMark timeMark = this.lastTimeMark;
        if (timeMark != null) {
            this.capacity = Math.min(this.maxCapacity, this.capacity + (this.refillUnitsPerSecond * Duration.m15892toDoubleimpl(timeMark.mo15844elapsedNowUwyO8pc(), DurationUnit.SECONDS)));
        }
        this.lastTimeMark = this.timeSource.markNow();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.retries.delay.RateLimiter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object update(RetryErrorType retryErrorType, Continuation<? super Unit> continuation) {
        C37731 c37731;
        RetryErrorType retryErrorType2;
        Mutex mutex;
        if (continuation instanceof C37731) {
            c37731 = (C37731) continuation;
            if ((c37731.label & Integer.MIN_VALUE) != 0) {
                c37731.label -= Integer.MIN_VALUE;
            } else {
                c37731 = new C37731(continuation);
            }
        }
        Object obj = c37731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37731.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c37731.L$0 = retryErrorType;
            c37731.L$1 = mutex2;
            c37731.I$0 = 0;
            c37731.label = 1;
            if (mutex2.lock(null, c37731) == coroutine_suspended) {
                return coroutine_suspended;
            }
            retryErrorType2 = retryErrorType;
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c37731.I$0;
            mutex = (Mutex) c37731.L$1;
            RetryErrorType retryErrorType3 = (RetryErrorType) c37731.L$0;
            ResultKt.throwOnFailure(obj);
            retryErrorType2 = retryErrorType3;
        }
        try {
            double dUpdateMeasuredRate = this.rateMeasurer.updateMeasuredRate();
            updateRefillRate(Math.min(this.rateCalculator.calculate(retryErrorType2, dUpdateMeasuredRate, this.refillUnitsPerSecond), ((double) 2) * dUpdateMeasuredRate));
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    private final void updateRefillRate(double newRate) {
        refillCapacity();
        this.refillUnitsPerSecond = Math.max(newRate, getConfig().getMinFillRate());
        double dMax = Math.max(newRate, getConfig().getMinCapacity());
        this.maxCapacity = dMax;
        this.capacity = Math.min(this.capacity, dMax);
    }

    /* JADX INFO: compiled from: AdaptiveRateLimiter.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u0017\u0010\u0018\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u001a\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\u001c\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010¨\u0006 "}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "Laws/smithy/kotlin/runtime/retries/delay/RateLimiter$Config;", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config$Builder;", "builder", "<init>", "(Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config$Builder;)V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/RateLimiter$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "()Lkotlin/jvm/functions/Function1;", "", "beta", "D", "getBeta", "()D", "Lkotlin/time/Duration;", "measurementBucketDuration", "J", "getMeasurementBucketDuration-UwyO8pc", "()J", "minCapacity", "getMinCapacity", "minFillRate", "getMinFillRate", "scaleConstant", "getScaleConstant", "smoothing", "getSmoothing", "Companion", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Config implements RateLimiter.Config {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Config Default = new Config(new Builder());
        private final double beta;
        private final long measurementBucketDuration;
        private final double minCapacity;
        private final double minFillRate;
        private final double scaleConstant;
        private final double smoothing;

        /* JADX INFO: compiled from: AdaptiveRateLimiter.kt */
        @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "getDefault", "()Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Config getDefault() {
                return Config.Default;
            }
        }

        public Config(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.beta = builder.getBeta();
            this.measurementBucketDuration = builder.getMeasurementBucketDuration();
            this.minCapacity = builder.getMinCapacity();
            this.minFillRate = builder.getMinFillRate();
            this.scaleConstant = builder.getScaleConstant();
            this.smoothing = builder.getSmoothing();
        }

        public final double getBeta() {
            return this.beta;
        }

        /* JADX INFO: renamed from: getMeasurementBucketDuration-UwyO8pc, reason: not valid java name and from getter */
        public final long getMeasurementBucketDuration() {
            return this.measurementBucketDuration;
        }

        public final double getMinCapacity() {
            return this.minCapacity;
        }

        public final double getMinFillRate() {
            return this.minFillRate;
        }

        public final double getScaleConstant() {
            return this.scaleConstant;
        }

        public final double getSmoothing() {
            return this.smoothing;
        }

        @Override // aws.smithy.kotlin.runtime.retries.delay.RateLimiter.Config
        public Function1<RateLimiter.Config.Builder, Unit> toBuilderApplicator() {
            return new Function1() { // from class: aws.smithy.kotlin.runtime.retries.delay.AdaptiveRateLimiter$Config$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AdaptiveRateLimiter.Config.toBuilderApplicator$lambda$0(this.f$0, (RateLimiter.Config.Builder) obj);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit toBuilderApplicator$lambda$0(Config config, RateLimiter.Config.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<this>");
            if (builder instanceof Builder) {
                Builder builder2 = (Builder) builder;
                builder2.setBeta(config.beta);
                builder2.m12239setMeasurementBucketDurationLRDsOJo(config.measurementBucketDuration);
                builder2.setMinCapacity(config.minCapacity);
                builder2.setMinFillRate(config.minFillRate);
                builder2.setScaleConstant(config.scaleConstant);
                builder2.setSmoothing(config.smoothing);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: compiled from: AdaptiveRateLimiter.kt */
        @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\n¨\u0006\u001e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/delay/RateLimiter$Config$Builder;", "<init>", "()V", "", "beta", "D", "getBeta", "()D", "setBeta", "(D)V", "Lkotlin/time/Duration;", "measurementBucketDuration", "J", "getMeasurementBucketDuration-UwyO8pc", "()J", "setMeasurementBucketDuration-LRDsOJo", "(J)V", "minCapacity", "getMinCapacity", "setMinCapacity", "minFillRate", "getMinFillRate", "setMinFillRate", "scaleConstant", "getScaleConstant", "setScaleConstant", "smoothing", "getSmoothing", "setSmoothing", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Builder implements RateLimiter.Config.Builder {
            private double beta = 0.7d;
            private long measurementBucketDuration;
            private double minCapacity;
            private double minFillRate;
            private double scaleConstant;
            private double smoothing;

            public Builder() {
                Duration.Companion companion = Duration.INSTANCE;
                this.measurementBucketDuration = DurationKt.toDuration(0.5d, DurationUnit.SECONDS);
                this.minCapacity = 1.0d;
                this.minFillRate = 0.5d;
                this.scaleConstant = 0.4d;
                this.smoothing = 0.8d;
            }

            public final double getBeta() {
                return this.beta;
            }

            public final void setBeta(double d) {
                this.beta = d;
            }

            /* JADX INFO: renamed from: getMeasurementBucketDuration-UwyO8pc, reason: not valid java name and from getter */
            public final long getMeasurementBucketDuration() {
                return this.measurementBucketDuration;
            }

            /* JADX INFO: renamed from: setMeasurementBucketDuration-LRDsOJo, reason: not valid java name */
            public final void m12239setMeasurementBucketDurationLRDsOJo(long j) {
                this.measurementBucketDuration = j;
            }

            public final double getMinCapacity() {
                return this.minCapacity;
            }

            public final void setMinCapacity(double d) {
                this.minCapacity = d;
            }

            public final double getMinFillRate() {
                return this.minFillRate;
            }

            public final void setMinFillRate(double d) {
                this.minFillRate = d;
            }

            public final double getScaleConstant() {
                return this.scaleConstant;
            }

            public final void setScaleConstant(double d) {
                this.scaleConstant = d;
            }

            public final double getSmoothing() {
                return this.smoothing;
            }

            public final void setSmoothing(double d) {
                this.smoothing = d;
            }
        }
    }
}
