package aws.smithy.kotlin.runtime.retries;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.retries.delay.AdaptiveRateLimiter;
import aws.smithy.kotlin.runtime.retries.delay.RateLimiter;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import aws.smithy.kotlin.runtime.util.DslBuilderProperty;
import aws.smithy.kotlin.runtime.util.DslFactory;
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

/* JADX INFO: compiled from: AdaptiveRetryStrategy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0094@¢\u0006\u0004\b\u0007\u0010\bJB\u0010\u0012\u001a\u00020\u0006\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0094@¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u0014\u001a\u00020\u0006\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0094@¢\u0006\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy;", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy;", "Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config;", "config", "<init>", "(Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config;)V", "", "beforeInitialTry", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "", "attempt", "Lkotlin/Result;", "callResult", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "evaluation", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "policy", "afterTry", "(ILjava/lang/Object;Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "beforeRetry", "Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config;", "getConfig", "()Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config;", "Companion", "Config", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AdaptiveRetryStrategy extends StandardRetryStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Config config;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy$afterTry$1 */
    /* JADX INFO: compiled from: AdaptiveRetryStrategy.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy", m1609f = "AdaptiveRetryStrategy.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {39, 41}, m1612m = "afterTry", m1613n = {"callResult", "evaluation", "policy", "attempt", "callResult", "evaluation", "policy", "errorType", "attempt"}, m1614nl = {40, 42}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
    static final class C37661<R> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C37661(Continuation<? super C37661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AdaptiveRetryStrategy.this.afterTry(0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy$beforeInitialTry$1 */
    /* JADX INFO: compiled from: AdaptiveRetryStrategy.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy", m1609f = "AdaptiveRetryStrategy.kt", m1610i = {}, m1611l = {29, 30}, m1612m = "beforeInitialTry", m1613n = {}, m1614nl = {30, 31}, m1615s = {}, m1616v = 2)
    static final class C37671 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C37671(Continuation<? super C37671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AdaptiveRetryStrategy.this.beforeInitialTry(this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy$beforeRetry$1 */
    /* JADX INFO: compiled from: AdaptiveRetryStrategy.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy", m1609f = "AdaptiveRetryStrategy.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1}, m1611l = {50, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m1612m = "beforeRetry", m1613n = {"callResult", "evaluation", "policy", "attempt", "callResult", "evaluation", "policy", "attempt"}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, m1616v = 2)
    static final class C37681<R> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C37681(Continuation<? super C37681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AdaptiveRetryStrategy.this.beforeRetry(0, null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdaptiveRetryStrategy() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: compiled from: AdaptiveRetryStrategy.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Companion;", "Laws/smithy/kotlin/runtime/util/DslFactory;", "Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion implements DslFactory<Config.Builder, AdaptiveRetryStrategy> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // aws.smithy.kotlin.runtime.util.DslFactory
        public AdaptiveRetryStrategy invoke(Function1<? super Config.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config.Builder builder = new Config.Builder();
            block.invoke(builder);
            return new AdaptiveRetryStrategy(new Config(builder));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveRetryStrategy(Config config) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public /* synthetic */ AdaptiveRetryStrategy(Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Config.INSTANCE.getDefault() : config);
    }

    @Override // aws.smithy.kotlin.runtime.retries.StandardRetryStrategy, aws.smithy.kotlin.runtime.retries.RetryStrategy
    public Config getConfig() {
        return this.config;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r6.acquire(1, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.retries.StandardRetryStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Object beforeInitialTry(Continuation<? super Unit> continuation) {
        C37671 c37671;
        if (continuation instanceof C37671) {
            c37671 = (C37671) continuation;
            if ((c37671.label & Integer.MIN_VALUE) != 0) {
                c37671.label -= Integer.MIN_VALUE;
            } else {
                c37671 = new C37671(continuation);
            }
        }
        Object obj = c37671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37671.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c37671.label = 1;
            if (super.beforeInitialTry(c37671) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        RateLimiter rateLimiter = getConfig().getRateLimiter();
        c37671.label = 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b6, code lost:
    
        if (r13.update(r1, r6) == r0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.retries.StandardRetryStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected <R> Object afterTry(int i, Object obj, RetryDirective retryDirective, RetryPolicy<? super R> retryPolicy, Continuation<? super Unit> continuation) {
        C37661 c37661;
        int i2;
        Object obj2;
        RetryDirective retryDirective2;
        RetryPolicy<? super R> retryPolicy2;
        if (continuation instanceof C37661) {
            c37661 = (C37661) continuation;
            if ((c37661.label & Integer.MIN_VALUE) != 0) {
                c37661.label -= Integer.MIN_VALUE;
            } else {
                c37661 = new C37661(continuation);
            }
        }
        C37661 c376612 = c37661;
        Object obj3 = c376612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c376612.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj3);
            c376612.L$0 = SpillingKt.nullOutSpilledVariable(obj);
            c376612.L$1 = retryDirective;
            c376612.L$2 = SpillingKt.nullOutSpilledVariable(retryPolicy);
            c376612.I$0 = i;
            c376612.label = 1;
            if (super.afterTry(i, obj, retryDirective, retryPolicy, c376612) != coroutine_suspended) {
                i2 = i;
                obj2 = obj;
                retryDirective2 = retryDirective;
                retryPolicy2 = retryPolicy;
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c376612.I$0;
            Object obj4 = c376612.L$0;
            ResultKt.throwOnFailure(obj3);
            return Unit.INSTANCE;
        }
        i2 = c376612.I$0;
        retryPolicy2 = (RetryPolicy) c376612.L$2;
        retryDirective2 = (RetryDirective) c376612.L$1;
        obj2 = c376612.L$0;
        ResultKt.throwOnFailure(obj3);
        RetryDirective.RetryError retryError = retryDirective2 instanceof RetryDirective.RetryError ? (RetryDirective.RetryError) retryDirective2 : null;
        RetryErrorType reason = retryError != null ? retryError.getReason() : null;
        RateLimiter rateLimiter = getConfig().getRateLimiter();
        c376612.L$0 = SpillingKt.nullOutSpilledVariable(obj2);
        c376612.L$1 = SpillingKt.nullOutSpilledVariable(retryDirective2);
        c376612.L$2 = SpillingKt.nullOutSpilledVariable(retryPolicy2);
        c376612.L$3 = SpillingKt.nullOutSpilledVariable(reason);
        c376612.I$0 = i2;
        c376612.label = 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a0, code lost:
    
        if (r14.acquire(1, r6) == r0) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.retries.StandardRetryStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected <R> Object beforeRetry(int i, Object obj, RetryDirective retryDirective, RetryPolicy<? super R> retryPolicy, Continuation<? super Unit> continuation) {
        C37681 c37681;
        int i2;
        Object obj2;
        RetryDirective retryDirective2;
        RetryPolicy<? super R> retryPolicy2;
        if (continuation instanceof C37681) {
            c37681 = (C37681) continuation;
            if ((c37681.label & Integer.MIN_VALUE) != 0) {
                c37681.label -= Integer.MIN_VALUE;
            } else {
                c37681 = new C37681(continuation);
            }
        }
        C37681 c376812 = c37681;
        Object obj3 = c376812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c376812.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj3);
            c376812.L$0 = SpillingKt.nullOutSpilledVariable(obj);
            c376812.L$1 = SpillingKt.nullOutSpilledVariable(retryDirective);
            c376812.L$2 = SpillingKt.nullOutSpilledVariable(retryPolicy);
            c376812.I$0 = i;
            c376812.label = 1;
            if (super.beforeRetry(i, obj, retryDirective, retryPolicy, c376812) != coroutine_suspended) {
                i2 = i;
                obj2 = obj;
                retryDirective2 = retryDirective;
                retryPolicy2 = retryPolicy;
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c376812.I$0;
            Object obj4 = c376812.L$0;
            ResultKt.throwOnFailure(obj3);
            return Unit.INSTANCE;
        }
        i2 = c376812.I$0;
        retryPolicy2 = (RetryPolicy) c376812.L$2;
        retryDirective2 = (RetryDirective) c376812.L$1;
        obj2 = c376812.L$0;
        ResultKt.throwOnFailure(obj3);
        RateLimiter rateLimiter = getConfig().getRateLimiter();
        c376812.L$0 = SpillingKt.nullOutSpilledVariable(obj2);
        c376812.L$1 = SpillingKt.nullOutSpilledVariable(retryDirective2);
        c376812.L$2 = SpillingKt.nullOutSpilledVariable(retryPolicy2);
        c376812.I$0 = i2;
        c376812.label = 2;
    }

    /* JADX INFO: compiled from: AdaptiveRetryStrategy.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config;", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config;", "Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config$Builder;", "builder", "<init>", "(Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config$Builder;)V", "Laws/smithy/kotlin/runtime/retries/delay/RateLimiter;", "rateLimiter", "Laws/smithy/kotlin/runtime/retries/delay/RateLimiter;", "getRateLimiter", "()Laws/smithy/kotlin/runtime/retries/delay/RateLimiter;", "Companion", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Config extends StandardRetryStrategy.Config {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Config Default = new Config(new Builder());
        private final RateLimiter rateLimiter;

        /* JADX INFO: compiled from: AdaptiveRetryStrategy.kt */
        @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config;", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config;", "getDefault", "()Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Config(Builder builder) {
            super(builder);
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.rateLimiter = builder.getRateLimiterProperty$runtime_core().getSupply().invoke();
        }

        public final RateLimiter getRateLimiter() {
            return this.rateLimiter;
        }

        /* JADX INFO: compiled from: AdaptiveRetryStrategy.kt */
        @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nJN\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\f*\u00020\u000b\"\b\b\u0001\u0010\u000e*\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\u0011R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R/\u0010\t\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b*\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/AdaptiveRateLimiter$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "rateLimiter", "(Lkotlin/jvm/functions/Function1;)V", "Laws/smithy/kotlin/runtime/retries/delay/RateLimiter$Config$Builder;", "B", "Laws/smithy/kotlin/runtime/retries/delay/RateLimiter;", "C", "Laws/smithy/kotlin/runtime/util/DslFactory;", "factory", "(Laws/smithy/kotlin/runtime/util/DslFactory;Lkotlin/jvm/functions/Function1;)V", "Laws/smithy/kotlin/runtime/util/DslBuilderProperty;", "rateLimiterProperty", "Laws/smithy/kotlin/runtime/util/DslBuilderProperty;", "getRateLimiterProperty$runtime_core", "()Laws/smithy/kotlin/runtime/util/DslBuilderProperty;", "<set-?>", "getRateLimiter", "()Laws/smithy/kotlin/runtime/retries/delay/RateLimiter;", "setRateLimiter", "(Laws/smithy/kotlin/runtime/retries/delay/RateLimiter;)V", "getRateLimiter$delegate", "(Laws/smithy/kotlin/runtime/retries/AdaptiveRetryStrategy$Config$Builder;)Ljava/lang/Object;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Builder extends StandardRetryStrategy.Config.Builder {
            private final DslBuilderProperty<RateLimiter.Config.Builder, RateLimiter> rateLimiterProperty = new DslBuilderProperty<>(AdaptiveRateLimiter.INSTANCE, new Function1() { // from class: aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy$Config$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AdaptiveRetryStrategy.Config.Builder.rateLimiterProperty$lambda$0((RateLimiter) obj);
                }
            }, null, 4, null);

            public final DslBuilderProperty<RateLimiter.Config.Builder, RateLimiter> getRateLimiterProperty$runtime_core() {
                return this.rateLimiterProperty;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Function1 rateLimiterProperty$lambda$0(RateLimiter DslBuilderProperty) {
                Intrinsics.checkNotNullParameter(DslBuilderProperty, "$this$DslBuilderProperty");
                return DslBuilderProperty.getConfig().toBuilderApplicator();
            }

            public final RateLimiter getRateLimiter() {
                return this.rateLimiterProperty.getInstance();
            }

            public final void setRateLimiter(RateLimiter rateLimiter) {
                this.rateLimiterProperty.setInstance(rateLimiter);
            }

            public final void rateLimiter(Function1<? super AdaptiveRateLimiter.Config.Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                this.rateLimiterProperty.dsl(AdaptiveRateLimiter.INSTANCE, block);
            }

            public final <B extends RateLimiter.Config.Builder, C extends RateLimiter> void rateLimiter(DslFactory<? extends B, ? extends C> factory, Function1<? super B, Unit> block) {
                Intrinsics.checkNotNullParameter(factory, "factory");
                Intrinsics.checkNotNullParameter(block, "block");
                this.rateLimiterProperty.dsl(factory, block);
            }
        }
    }
}
