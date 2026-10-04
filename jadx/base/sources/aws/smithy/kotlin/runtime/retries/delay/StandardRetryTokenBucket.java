package aws.smithy.kotlin.runtime.retries.delay;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket;
import aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import aws.smithy.kotlin.runtime.util.DslFactory;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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

/* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0003$%&B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R$\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket;", "Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;", "config", "Lkotlin/time/TimeSource;", "timeSource", "<init>", "(Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;Lkotlin/time/TimeSource;)V", "options", "(Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;)V", "Laws/smithy/kotlin/runtime/retries/delay/RetryToken;", "acquireToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "size", "", "checkoutCapacity", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refillCapacity", "()V", "returnCapacity", "Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;", "getConfig", "()Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;", "Lkotlin/time/TimeSource;", "value", "capacity", "I", "getCapacity$runtime_core", "()I", "Lkotlin/time/TimeMark;", "lastTimeMark", "Lkotlin/time/TimeMark;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Companion", "StandardRetryToken", "Config", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StandardRetryTokenBucket implements RetryTokenBucket {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int capacity;
    private final Config config;
    private TimeMark lastTimeMark;
    private final Mutex mutex;
    private final TimeSource timeSource;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$acquireToken$1 */
    /* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket", m1609f = "StandardRetryTokenBucket.kt", m1610i = {}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m1612m = "acquireToken", m1613n = {}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m1615s = {}, m1616v = 2)
    static final class C37751 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C37751(Continuation<? super C37751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StandardRetryTokenBucket.this.acquireToken(this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$checkoutCapacity$1 */
    /* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket", m1609f = "StandardRetryTokenBucket.kt", m1610i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, m1611l = {PDFACompliance.e_PDFA2_4_2, 67}, m1612m = "checkoutCapacity", m1613n = {"$this$withLock_u24default$iv", "size", "$i$f$withLock", "$this$withLock_u24default$iv", "size", "$i$f$withLock", "$i$a$-withLock$default-StandardRetryTokenBucket$checkoutCapacity$2", "extraRequiredCapacity", "delayDuration"}, m1614nl = {PDFACompliance.e_PDFA2_4_3, 68}, m1615s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "I$2", "I$3", "J$0"}, m1616v = 2)
    static final class C37761 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C37761(Continuation<? super C37761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StandardRetryTokenBucket.this.checkoutCapacity(0, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$returnCapacity$1 */
    /* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket", m1609f = "StandardRetryTokenBucket.kt", m1610i = {0, 0, 0}, m1611l = {PDFACompliance.e_PDFA2_4_2}, m1612m = "returnCapacity", m1613n = {"$this$withLock_u24default$iv", "size", "$i$f$withLock"}, m1614nl = {PDFACompliance.e_PDFA2_4_3}, m1615s = {"L$0", "I$0", "I$1"}, m1616v = 2)
    static final class C37771 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C37771(Continuation<? super C37771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StandardRetryTokenBucket.this.returnCapacity(0, this);
        }
    }

    public StandardRetryTokenBucket(Config config, TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.config = config;
        this.timeSource = timeSource;
        this.capacity = getConfig().getMaxCapacity();
        this.lastTimeMark = timeSource.markNow();
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket
    public Config getConfig() {
        return this.config;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StandardRetryTokenBucket(Config options) {
        this(options, TimeSource.Monotonic.INSTANCE);
        Intrinsics.checkNotNullParameter(options, "options");
    }

    public /* synthetic */ StandardRetryTokenBucket(Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Config.INSTANCE.getDefault() : config);
    }

    /* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Companion;", "Laws/smithy/kotlin/runtime/util/DslFactory;", "Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion implements DslFactory<Config.Builder, StandardRetryTokenBucket> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // aws.smithy.kotlin.runtime.util.DslFactory
        public StandardRetryTokenBucket invoke(Function1<? super Config.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config.Builder builder = new Config.Builder();
            block.invoke(builder);
            return new StandardRetryTokenBucket(new Config(builder));
        }
    }

    /* JADX INFO: renamed from: getCapacity$runtime_core, reason: from getter */
    public final int getCapacity() {
        return this.capacity;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object acquireToken(Continuation<? super RetryToken> continuation) {
        C37751 c37751;
        if (continuation instanceof C37751) {
            c37751 = (C37751) continuation;
            if ((c37751.label & Integer.MIN_VALUE) != 0) {
                c37751.label -= Integer.MIN_VALUE;
            } else {
                c37751 = new C37751(continuation);
            }
        }
        Object obj = c37751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37751.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int initialTryCost = getConfig().getInitialTryCost();
            c37751.label = 1;
            if (checkoutCapacity(initialTryCost, c37751) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return new StandardRetryToken(getConfig().getInitialTrySuccessIncrement());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkoutCapacity(int i, Continuation<? super Unit> continuation) throws Throwable {
        C37761 c37761;
        Mutex mutex;
        int i2;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C37761) {
            c37761 = (C37761) continuation;
            if ((c37761.label & Integer.MIN_VALUE) != 0) {
                c37761.label -= Integer.MIN_VALUE;
            } else {
                c37761 = new C37761(continuation);
            }
        }
        Object obj = c37761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c37761.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                c37761.L$0 = mutex;
                c37761.I$0 = i;
                c37761.I$1 = 0;
                c37761.label = 1;
                if (mutex.lock(null, c37761) != coroutine_suspended) {
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j = c37761.J$0;
                int i4 = c37761.I$3;
                int i5 = c37761.I$2;
                int i6 = c37761.I$1;
                int i7 = c37761.I$0;
                mutex2 = (Mutex) c37761.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.capacity = 0;
                    this.lastTimeMark = this.timeSource.markNow();
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i8 = c37761.I$1;
            int i9 = c37761.I$0;
            Mutex mutex3 = (Mutex) c37761.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i8;
            i = i9;
            mutex = mutex3;
            refillCapacity();
            int i10 = this.capacity;
            if (i <= i10) {
                this.capacity = i10 - i;
                mutex2 = mutex;
                this.lastTimeMark = this.timeSource.markNow();
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return unit2;
            }
            if (getConfig().getUseCircuitBreakerMode()) {
                throw new RetryCapacityExceededException("Insufficient capacity to attempt retry");
            }
            int i11 = i - this.capacity;
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(Math.ceil(((double) i11) / ((double) getConfig().getRefillUnitsPerSecond())), DurationUnit.SECONDS);
            c37761.L$0 = mutex;
            c37761.I$0 = i;
            c37761.I$1 = i2;
            c37761.I$2 = 0;
            c37761.I$3 = i11;
            c37761.J$0 = duration;
            c37761.label = 2;
            if (DelayKt.m16008delayVtjQ1oo(duration, c37761) != coroutine_suspended) {
                mutex2 = mutex;
                this.capacity = 0;
                this.lastTimeMark = this.timeSource.markNow();
                Unit unit22 = Unit.INSTANCE;
                mutex2.unlock(null);
                return unit22;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    private final void refillCapacity() {
        this.capacity = Math.min(getConfig().getMaxCapacity(), this.capacity + ((int) Math.floor(((double) getConfig().getRefillUnitsPerSecond()) * Duration.m15892toDoubleimpl(this.lastTimeMark.mo15844elapsedNowUwyO8pc(), DurationUnit.SECONDS))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object returnCapacity(int i, Continuation<? super Unit> continuation) {
        C37771 c37771;
        Mutex mutex;
        if (continuation instanceof C37771) {
            c37771 = (C37771) continuation;
            if ((c37771.label & Integer.MIN_VALUE) != 0) {
                c37771.label -= Integer.MIN_VALUE;
            } else {
                c37771 = new C37771(continuation);
            }
        }
        Object obj = c37771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c37771.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c37771.L$0 = mutex2;
            c37771.I$0 = i;
            c37771.I$1 = 0;
            c37771.label = 1;
            if (mutex2.lock(null, c37771) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c37771.I$1;
            i = c37771.I$0;
            mutex = (Mutex) c37771.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            refillCapacity();
            this.capacity = Math.min(getConfig().getMaxCapacity(), this.capacity + i);
            this.lastTimeMark = this.timeSource.markNow();
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\bJ\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$StandardRetryToken;", "Laws/smithy/kotlin/runtime/retries/delay/RetryToken;", "", "returnSize", "<init>", "(Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket;I)V", "", "notifyFailure", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifySuccess", "Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;", "reason", "scheduleRetry", "(Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public final class StandardRetryToken implements RetryToken {
        private final int returnSize;

        /* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RetryErrorType.values().length];
                try {
                    iArr[RetryErrorType.Transient.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RetryErrorType.Throttling.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public StandardRetryToken(int i) {
            this.returnSize = i;
        }

        @Override // aws.smithy.kotlin.runtime.retries.delay.RetryToken
        public Object notifyFailure(Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @Override // aws.smithy.kotlin.runtime.retries.delay.RetryToken
        public Object notifySuccess(Continuation<? super Unit> continuation) {
            Object objReturnCapacity = StandardRetryTokenBucket.this.returnCapacity(this.returnSize, continuation);
            return objReturnCapacity == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objReturnCapacity : Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // aws.smithy.kotlin.runtime.retries.delay.RetryToken
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object scheduleRetry(RetryErrorType retryErrorType, Continuation<? super RetryToken> continuation) {
            StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1 standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1;
            int timeoutRetryCost;
            int i;
            if (continuation instanceof StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1) {
                standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1 = (StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1) continuation;
                if ((standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1.label & Integer.MIN_VALUE) != 0) {
                    standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1.label -= Integer.MIN_VALUE;
                } else {
                    standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1 = new StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1(this, continuation);
                }
            }
            Object obj = standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                int i3 = WhenMappings.$EnumSwitchMapping$0[retryErrorType.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    timeoutRetryCost = StandardRetryTokenBucket.this.getConfig().getTimeoutRetryCost();
                } else {
                    timeoutRetryCost = StandardRetryTokenBucket.this.getConfig().getRetryCost();
                }
                StandardRetryTokenBucket standardRetryTokenBucket = StandardRetryTokenBucket.this;
                standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1.L$0 = SpillingKt.nullOutSpilledVariable(retryErrorType);
                standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1.I$0 = timeoutRetryCost;
                standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1.label = 1;
                if (standardRetryTokenBucket.checkoutCapacity(timeoutRetryCost, standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = timeoutRetryCost;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = standardRetryTokenBucket$StandardRetryToken$scheduleRetry$1.I$0;
                ResultKt.throwOnFailure(obj);
            }
            return StandardRetryTokenBucket.this.new StandardRetryToken(i);
        }
    }

    /* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000  2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0017¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u001e\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015¨\u0006\""}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config;", "Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config$Builder;", "builder", "<init>", "(Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config$Builder;)V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "()Lkotlin/jvm/functions/Function1;", "", "useCircuitBreakerMode", "Z", "getUseCircuitBreakerMode", "()Z", "", "initialTryCost", "I", "getInitialTryCost", "()I", "initialTrySuccessIncrement", "getInitialTrySuccessIncrement", "maxCapacity", "getMaxCapacity", "refillUnitsPerSecond", "getRefillUnitsPerSecond", "retryCost", "getRetryCost", "timeoutRetryCost", "getTimeoutRetryCost", "Companion", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Config implements RetryTokenBucket.Config {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Config Default = new Config(new Builder());
        private final int initialTryCost;
        private final int initialTrySuccessIncrement;
        private final int maxCapacity;
        private final int refillUnitsPerSecond;
        private final int retryCost;
        private final int timeoutRetryCost;
        private final boolean useCircuitBreakerMode;

        /* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;", "getDefault", "()Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Config getDefault() {
                return Config.Default;
            }

            public final Config invoke(Function1<? super Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                Builder builder = new Builder();
                block.invoke(builder);
                return new Config(builder);
            }
        }

        public Config(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.useCircuitBreakerMode = builder.getUseCircuitBreakerMode();
            this.initialTryCost = builder.getInitialTryCost();
            this.initialTrySuccessIncrement = builder.getInitialTrySuccessIncrement();
            this.maxCapacity = builder.getMaxCapacity();
            this.refillUnitsPerSecond = builder.getRefillUnitsPerSecond();
            this.retryCost = builder.getRetryCost();
            this.timeoutRetryCost = builder.getTimeoutRetryCost();
        }

        public final boolean getUseCircuitBreakerMode() {
            return this.useCircuitBreakerMode;
        }

        public final int getInitialTryCost() {
            return this.initialTryCost;
        }

        public final int getInitialTrySuccessIncrement() {
            return this.initialTrySuccessIncrement;
        }

        public final int getMaxCapacity() {
            return this.maxCapacity;
        }

        public final int getRefillUnitsPerSecond() {
            return this.refillUnitsPerSecond;
        }

        public final int getRetryCost() {
            return this.retryCost;
        }

        public final int getTimeoutRetryCost() {
            return this.timeoutRetryCost;
        }

        @Override // aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket.Config
        @InternalApi
        public Function1<RetryTokenBucket.Config.Builder, Unit> toBuilderApplicator() {
            return new Function1() { // from class: aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$Config$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StandardRetryTokenBucket.Config.toBuilderApplicator$lambda$0(this.f$0, (RetryTokenBucket.Config.Builder) obj);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit toBuilderApplicator$lambda$0(Config config, RetryTokenBucket.Config.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<this>");
            if (builder instanceof Builder) {
                Builder builder2 = (Builder) builder;
                builder2.setUseCircuitBreakerMode(config.useCircuitBreakerMode);
                builder2.setInitialTryCost(config.initialTryCost);
                builder2.setInitialTrySuccessIncrement(config.initialTrySuccessIncrement);
                builder2.setMaxCapacity(config.maxCapacity);
                builder2.setRefillUnitsPerSecond(config.refillUnitsPerSecond);
                builder2.setRetryCost(config.retryCost);
                builder2.setTimeoutRetryCost(config.timeoutRetryCost);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
        @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R*\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\"\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006\""}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config$Builder;", "<init>", "()V", "", "useCircuitBreakerMode", "Z", "getUseCircuitBreakerMode", "()Z", "setUseCircuitBreakerMode", "(Z)V", "", "initialTryCost", "I", "getInitialTryCost", "()I", "setInitialTryCost", "(I)V", "initialTrySuccessIncrement", "getInitialTrySuccessIncrement", "setInitialTrySuccessIncrement", "maxCapacity", "getMaxCapacity", "setMaxCapacity", "value", "refillUnitsPerSecond", "getRefillUnitsPerSecond", "setRefillUnitsPerSecond", "retryCost", "getRetryCost", "setRetryCost", "timeoutRetryCost", "getTimeoutRetryCost", "setTimeoutRetryCost", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Builder implements RetryTokenBucket.Config.Builder {
            private int initialTryCost;
            private int refillUnitsPerSecond;
            private boolean useCircuitBreakerMode = true;
            private int initialTrySuccessIncrement = 1;
            private int maxCapacity = 500;
            private int retryCost = 5;
            private int timeoutRetryCost = 10;

            public final boolean getUseCircuitBreakerMode() {
                return this.useCircuitBreakerMode;
            }

            public final void setUseCircuitBreakerMode(boolean z) {
                this.useCircuitBreakerMode = z;
            }

            public final int getInitialTryCost() {
                return this.initialTryCost;
            }

            public final void setInitialTryCost(int i) {
                this.initialTryCost = i;
            }

            public final int getInitialTrySuccessIncrement() {
                return this.initialTrySuccessIncrement;
            }

            public final void setInitialTrySuccessIncrement(int i) {
                this.initialTrySuccessIncrement = i;
            }

            public final int getMaxCapacity() {
                return this.maxCapacity;
            }

            public final void setMaxCapacity(int i) {
                this.maxCapacity = i;
            }

            public final int getRefillUnitsPerSecond() {
                return this.refillUnitsPerSecond;
            }

            public final void setRefillUnitsPerSecond(int i) {
                if (i == 0) {
                    this.useCircuitBreakerMode = true;
                }
                this.refillUnitsPerSecond = i;
            }

            public final int getRetryCost() {
                return this.retryCost;
            }

            public final void setRetryCost(int i) {
                this.retryCost = i;
            }

            public final int getTimeoutRetryCost() {
                return this.timeoutRetryCost;
            }

            public final void setTimeoutRetryCost(int i) {
                this.timeoutRetryCost = i;
            }
        }
    }
}
