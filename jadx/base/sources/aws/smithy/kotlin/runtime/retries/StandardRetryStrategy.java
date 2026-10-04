package aws.smithy.kotlin.runtime.retries;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.p007ts.TsExtractor;
import aws.smithy.kotlin.runtime.ClientErrorContext;
import aws.smithy.kotlin.runtime.ErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.retries.Outcome;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.retries.delay.DelayProvider;
import aws.smithy.kotlin.runtime.retries.delay.ExponentialBackoffWithJitter;
import aws.smithy.kotlin.runtime.retries.delay.RetryCapacityExceededException;
import aws.smithy.kotlin.runtime.retries.delay.RetryToken;
import aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket;
import aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import aws.smithy.kotlin.runtime.util.DslBuilderProperty;
import aws.smithy.kotlin.runtime.util.DslFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
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
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: StandardRetryStrategy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u000b\b\u0016\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JH\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJX\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00062\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0082P¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u0094@¢\u0006\u0004\b\u0017\u0010\u0018JB\u0010\u001d\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0094@¢\u0006\u0004\b\u001d\u0010\u001eJB\u0010\u001f\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0094@¢\u0006\u0004\b\u001f\u0010\u001eJ:\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00062\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0082@¢\u0006\u0004\b\"\u0010#J5\u0010'\u001a\u00020&\"\u0004\b\u0000\u0010\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019H\u0002¢\u0006\u0004\b'\u0010(J+\u0010)\u001a\u00020&\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0002¢\u0006\u0004\b)\u0010*J+\u0010+\u001a\u00020&\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0002¢\u0006\u0004\b+\u0010*R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010.¨\u00061"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy;", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config;", "config", "<init>", "(Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config;)V", "R", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "policy", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "Laws/smithy/kotlin/runtime/retries/Outcome;", "retry", "(Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "attempt", "Laws/smithy/kotlin/runtime/retries/delay/RetryToken;", "fromToken", "doTryLoop", "(Lkotlin/jvm/functions/Function1;Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;ILaws/smithy/kotlin/runtime/retries/delay/RetryToken;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "beforeInitialTry", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Result;", "callResult", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "evaluation", "afterTry", "(ILjava/lang/Object;Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "beforeRetry", "token", "result", FirebaseAnalytics.Param.SUCCESS, "(Laws/smithy/kotlin/runtime/retries/delay/RetryToken;ILjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/retries/delay/RetryCapacityExceededException;", "cause", "", "throwCapacityExceeded", "(Laws/smithy/kotlin/runtime/retries/delay/RetryCapacityExceededException;ILkotlin/Result;)Ljava/lang/Void;", "throwFailure", "(ILjava/lang/Object;)Ljava/lang/Void;", "throwTooManyAttempts", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config;", "getConfig", "()Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config;", "Companion", "Config", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class StandardRetryStrategy implements RetryStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Config config;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$doTryLoop$1 */
    /* JADX INFO: compiled from: StandardRetryStrategy.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.StandardRetryStrategy", m1609f = "StandardRetryStrategy.kt", m1610i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6}, m1611l = {63, 68, 72, 82, 83, 86, PDFACompliance.e_PDFA9_1}, m1612m = "doTryLoop", m1613n = {"block", "policy", "fromToken", "$this$doTryLoop_u24lambda_u240", "attempt", "$i$a$-runCatching-StandardRetryStrategy$doTryLoop$callResult$1", "block", "policy", "fromToken", "callResult", "evaluation", "attempt", "block", "policy", "fromToken", "callResult", "evaluation", "attempt", "block", "policy", "fromToken", "callResult", "evaluation", "attempt", "block", "policy", "fromToken", "callResult", "evaluation", "attempt", "block", "policy", "fromToken", "callResult", "evaluation", "it", "attempt", "$i$a$-also-StandardRetryStrategy$doTryLoop$nextToken$1", "block", "policy", "fromToken", "callResult", "evaluation", "ex", "attempt"}, m1614nl = {63, 70, 74, 83, 70, 87, PDFACompliance.e_PDFA9_2}, m1615s = {"L$0", "L$1", "L$2", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$7", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, m1616v = 2)
    static final class C37691<R> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C37691(Continuation<? super C37691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StandardRetryStrategy.this.doTryLoop(null, null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$retry$1 */
    /* JADX INFO: compiled from: StandardRetryStrategy.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.StandardRetryStrategy", m1609f = "StandardRetryStrategy.kt", m1610i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, m1611l = {38, 43, 43}, m1612m = "retry$suspendImpl", m1613n = {"$this", "policy", "block", "$this", "policy", "block", "$this", "policy", "block"}, m1614nl = {39, 43, -1}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C37701<R> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C37701(Continuation<? super C37701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StandardRetryStrategy.retry$suspendImpl(StandardRetryStrategy.this, null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$success$1 */
    /* JADX INFO: compiled from: StandardRetryStrategy.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.StandardRetryStrategy", m1609f = "StandardRetryStrategy.kt", m1610i = {0, 0, 0}, m1611l = {128}, m1612m = FirebaseAnalytics.Param.SUCCESS, m1613n = {"token", "result", "attempt"}, m1614nl = {TsExtractor.TS_STREAM_TYPE_AC3}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C37711<R> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37711(Continuation<? super C37711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StandardRetryStrategy.this.success(null, 0, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StandardRetryStrategy() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    protected <R> Object afterTry(int i, Object obj, RetryDirective retryDirective, RetryPolicy<? super R> retryPolicy, Continuation<? super Unit> continuation) {
        return afterTry$suspendImpl(this, i, obj, retryDirective, retryPolicy, continuation);
    }

    protected Object beforeInitialTry(Continuation<? super Unit> continuation) {
        return beforeInitialTry$suspendImpl(this, continuation);
    }

    protected <R> Object beforeRetry(int i, Object obj, RetryDirective retryDirective, RetryPolicy<? super R> retryPolicy, Continuation<? super Unit> continuation) {
        return beforeRetry$suspendImpl(this, i, obj, retryDirective, retryPolicy, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.retries.RetryStrategy
    public <R> Object retry(RetryPolicy<? super R> retryPolicy, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super Outcome<? extends R>> continuation) {
        return retry$suspendImpl(this, retryPolicy, function1, continuation);
    }

    /* JADX INFO: compiled from: StandardRetryStrategy.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Companion;", "Laws/smithy/kotlin/runtime/util/DslFactory;", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion implements DslFactory<Config.Builder, StandardRetryStrategy> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // aws.smithy.kotlin.runtime.util.DslFactory
        public StandardRetryStrategy invoke(Function1<? super Config.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config.Builder builder = new Config.Builder();
            block.invoke(builder);
            return new StandardRetryStrategy(new Config(builder));
        }
    }

    public StandardRetryStrategy(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public /* synthetic */ StandardRetryStrategy(Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Config.INSTANCE.m12235default() : config);
    }

    @Override // aws.smithy.kotlin.runtime.retries.RetryStrategy
    public Config getConfig() {
        return this.config;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ <R> Object retry$suspendImpl(StandardRetryStrategy standardRetryStrategy, RetryPolicy<? super R> retryPolicy, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super Outcome<? extends R>> continuation) throws Throwable {
        C37701 c37701;
        StandardRetryStrategy standardRetryStrategy2;
        StandardRetryStrategy standardRetryStrategy3;
        RetryPolicy<? super R> retryPolicy2;
        RetryPolicy<? super R> retryPolicy3;
        Function1<? super Continuation<? super R>, ? extends Object> function12;
        if (continuation instanceof C37701) {
            c37701 = (C37701) continuation;
            if ((c37701.label & Integer.MIN_VALUE) != 0) {
                c37701.label -= Integer.MIN_VALUE;
            } else {
                c37701 = standardRetryStrategy.new C37701(continuation);
            }
        }
        C37701 c377012 = c37701;
        Object objAcquireToken = c377012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c377012.label;
        int i2 = 1;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAcquireToken);
                c377012.L$0 = standardRetryStrategy;
                c377012.L$1 = retryPolicy;
                c377012.L$2 = function1;
                c377012.label = 1;
                if (standardRetryStrategy.beforeInitialTry(c377012) != coroutine_suspended) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objAcquireToken);
                    return objAcquireToken;
                }
                i2 = c377012.I$0;
                RetryPolicy<? super R> retryPolicy4 = (RetryPolicy) c377012.L$5;
                function12 = (Function1) c377012.L$4;
                StandardRetryStrategy standardRetryStrategy4 = (StandardRetryStrategy) c377012.L$3;
                Function1<? super Continuation<? super R>, ? extends Object> function13 = (Function1) c377012.L$2;
                RetryPolicy<? super R> retryPolicy5 = (RetryPolicy) c377012.L$1;
                standardRetryStrategy3 = (StandardRetryStrategy) c377012.L$0;
                ResultKt.throwOnFailure(objAcquireToken);
                retryPolicy3 = retryPolicy4;
                retryPolicy2 = retryPolicy5;
                standardRetryStrategy2 = standardRetryStrategy4;
                function1 = function13;
                c377012.L$0 = SpillingKt.nullOutSpilledVariable(standardRetryStrategy3);
                c377012.L$1 = SpillingKt.nullOutSpilledVariable(retryPolicy2);
                c377012.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c377012.L$3 = null;
                c377012.L$4 = null;
                c377012.L$5 = null;
                c377012.label = 3;
                Object objDoTryLoop = standardRetryStrategy2.doTryLoop(function12, retryPolicy3, i2, (RetryToken) objAcquireToken, c377012);
                return objDoTryLoop != coroutine_suspended ? coroutine_suspended : objDoTryLoop;
            }
            function1 = (Function1) c377012.L$2;
            retryPolicy = (RetryPolicy) c377012.L$1;
            standardRetryStrategy = (StandardRetryStrategy) c377012.L$0;
            ResultKt.throwOnFailure(objAcquireToken);
            RetryTokenBucket tokenBucket = standardRetryStrategy.getConfig().getTokenBucket();
            c377012.L$0 = SpillingKt.nullOutSpilledVariable(standardRetryStrategy);
            c377012.L$1 = SpillingKt.nullOutSpilledVariable(retryPolicy);
            c377012.L$2 = SpillingKt.nullOutSpilledVariable(function1);
            c377012.L$3 = standardRetryStrategy;
            c377012.L$4 = function1;
            c377012.L$5 = retryPolicy;
            c377012.I$0 = 1;
            c377012.label = 2;
            objAcquireToken = tokenBucket.acquireToken(c377012);
            if (objAcquireToken != coroutine_suspended) {
                standardRetryStrategy2 = standardRetryStrategy;
                standardRetryStrategy3 = standardRetryStrategy2;
                retryPolicy2 = retryPolicy;
                retryPolicy3 = retryPolicy2;
                function12 = function1;
                c377012.L$0 = SpillingKt.nullOutSpilledVariable(standardRetryStrategy3);
                c377012.L$1 = SpillingKt.nullOutSpilledVariable(retryPolicy2);
                c377012.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c377012.L$3 = null;
                c377012.L$4 = null;
                c377012.L$5 = null;
                c377012.label = 3;
                Object objDoTryLoop2 = standardRetryStrategy2.doTryLoop(function12, retryPolicy3, i2, (RetryToken) objAcquireToken, c377012);
                if (objDoTryLoop2 != coroutine_suspended) {
                }
            }
        } catch (RetryCapacityExceededException e) {
            standardRetryStrategy.throwCapacityExceeded(e, 1, null);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009e A[PHI: r0 r2 r4 r6 r9 r10 r11 r12 r13 r14
      0x009e: PHI (r0v12 java.lang.Object) = (r0v1 java.lang.Object), (r0v20 java.lang.Object) binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r2v10 aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$doTryLoop$1) = 
      (r2v2 aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$doTryLoop$1)
      (r2v14 aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$doTryLoop$1)
     binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r4v13 int) = (r4v10 int), (r4v15 int) binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r6v3 int) = (r6v0 int), (r6v8 int) binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r9v14 aws.smithy.kotlin.runtime.retries.policy.RetryDirective) = 
      (r9v11 aws.smithy.kotlin.runtime.retries.policy.RetryDirective)
      (r9v18 aws.smithy.kotlin.runtime.retries.policy.RetryDirective)
     binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r10v11 java.lang.Object) = (r10v8 java.lang.Object), (r10v13 java.lang.Object) binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r11v14 kotlin.jvm.internal.Ref$ObjectRef) = (r11v11 kotlin.jvm.internal.Ref$ObjectRef), (r11v18 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r12v10 aws.smithy.kotlin.runtime.retries.delay.RetryToken) = (r12v8 aws.smithy.kotlin.runtime.retries.delay.RetryToken), (r12v13 aws.smithy.kotlin.runtime.retries.delay.RetryToken) binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r13v9 aws.smithy.kotlin.runtime.retries.policy.RetryPolicy<? super R>) = 
      (r13v8 aws.smithy.kotlin.runtime.retries.policy.RetryPolicy<? super R>)
      (r13v12 aws.smithy.kotlin.runtime.retries.policy.RetryPolicy<? super R>)
     binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r14v9 kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object>) = 
      (r14v8 kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object>)
      (r14v12 kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object>)
     binds: [B:17:0x009b, B:76:0x0255] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d4 A[Catch: all -> 0x010b, RetryCapacityExceededException -> 0x010e, TryCatch #9 {RetryCapacityExceededException -> 0x010e, all -> 0x010b, blocks: (B:14:0x0072, B:60:0x01d0, B:62:0x01d4, B:66:0x01fe, B:68:0x0202, B:70:0x0206, B:72:0x0214, B:75:0x0239, B:87:0x02a7, B:88:0x02b3, B:89:0x02b4, B:90:0x02b9, B:91:0x02ba, B:92:0x02c6, B:17:0x009b, B:20:0x00c3, B:23:0x00e5, B:26:0x0106), top: B:116:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01fe A[Catch: all -> 0x010b, RetryCapacityExceededException -> 0x010e, TryCatch #9 {RetryCapacityExceededException -> 0x010e, all -> 0x010b, blocks: (B:14:0x0072, B:60:0x01d0, B:62:0x01d4, B:66:0x01fe, B:68:0x0202, B:70:0x0206, B:72:0x0214, B:75:0x0239, B:87:0x02a7, B:88:0x02b3, B:89:0x02b4, B:90:0x02b9, B:91:0x02ba, B:92:0x02c6, B:17:0x009b, B:20:0x00c3, B:23:0x00e5, B:26:0x0106), top: B:116:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x028a  */
    /* JADX WARN: Type inference failed for: r6v14, types: [T, aws.smithy.kotlin.runtime.retries.StandardRetryStrategy] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x028a -> B:82:0x0290). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <R> Object doTryLoop(Function1<? super Continuation<? super R>, ? extends Object> function1, RetryPolicy<? super R> retryPolicy, int i, RetryToken retryToken, Continuation<? super Outcome<? extends R>> continuation) throws Throwable {
        C37691 c37691;
        Function1<? super Continuation<? super R>, ? extends Object> function12;
        RetryPolicy<? super R> retryPolicy2;
        RetryToken retryToken2;
        Object obj;
        RetryDirective retryDirective;
        Ref.ObjectRef objectRef;
        RetryPolicy<? super R> retryPolicy3;
        int i2;
        RetryToken retryToken3;
        Ref.ObjectRef objectRef2;
        C37691 c376912;
        Function1<? super Continuation<? super R>, ? extends Object> function13;
        int i3;
        Ref.ObjectRef objectRef3;
        RetryPolicy<? super R> retryPolicy4;
        Function1<? super Continuation<? super R>, ? extends Object> function14;
        RetryDirective retryDirective2;
        RetryToken retryToken4;
        RetryPolicy<? super R> retryPolicy5;
        Function1<? super Continuation<? super R>, ? extends Object> function15;
        Throwable th;
        Object objM14499constructorimpl;
        Function1<? super Continuation<? super R>, ? extends Object> function16;
        RetryToken retryToken5;
        RetryPolicy<? super R> retryPolicy6;
        C37691 c376913;
        Ref.ObjectRef objectRef4;
        RetryDirective retryDirective3;
        int i4;
        int i5;
        CancellationException cancellationException;
        RetryPolicy<? super R> retryPolicy7;
        C37691 c376914;
        if (continuation instanceof C37691) {
            c37691 = (C37691) continuation;
            if ((c37691.label & Integer.MIN_VALUE) != 0) {
                c37691.label -= Integer.MIN_VALUE;
            } else {
                c37691 = new C37691(continuation);
            }
        }
        Object objScheduleRetry = c37691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = c37691.label;
        int i7 = 1;
        try {
        } catch (RetryCapacityExceededException e) {
            e = e;
        } catch (Throwable th2) {
            th = th2;
        }
        switch (i6) {
            case 0:
                ResultKt.throwOnFailure(objScheduleRetry);
                Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
                objectRef5.element = this;
                retryPolicy3 = retryPolicy;
                i2 = i;
                retryToken3 = retryToken;
                objectRef2 = objectRef5;
                c376912 = c37691;
                function13 = function1;
                T t = objectRef2.element;
                try {
                } catch (Throwable th3) {
                    th = th3;
                    Ref.ObjectRef objectRef6 = objectRef2;
                    function14 = function13;
                    c37691 = c376912;
                    retryPolicy4 = retryPolicy3;
                    i3 = i2;
                    objectRef3 = objectRef6;
                    Result.Companion companion = Result.INSTANCE;
                    objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                    Object obj2 = objM14499constructorimpl;
                    int i8 = i3;
                    Function1<? super Continuation<? super R>, ? extends Object> function17 = function14;
                    objectRef = objectRef3;
                    Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(obj2);
                    if (!(thM14502exceptionOrNullimpl instanceof CancellationException)) {
                    }
                    if (cancellationException == null) {
                    }
                }
                Result.Companion companion2 = Result.INSTANCE;
                c376912.L$0 = function13;
                c376912.L$1 = retryPolicy3;
                c376912.L$2 = retryToken3;
                c376912.L$3 = objectRef2;
                c376912.L$4 = SpillingKt.nullOutSpilledVariable((StandardRetryStrategy) t);
                c376912.L$5 = null;
                c376912.L$6 = null;
                c376912.L$7 = null;
                c376912.I$0 = i2;
                c376912.I$1 = 0;
                c376912.label = i7;
                objScheduleRetry = function13.invoke(c376912);
                if (objScheduleRetry != coroutine_suspended) {
                    Ref.ObjectRef objectRef7 = objectRef2;
                    function14 = function13;
                    c37691 = c376912;
                    retryPolicy4 = retryPolicy3;
                    i3 = i2;
                    objectRef3 = objectRef7;
                    objM14499constructorimpl = Result.m14499constructorimpl(objScheduleRetry);
                    Object obj22 = objM14499constructorimpl;
                    int i82 = i3;
                    Function1<? super Continuation<? super R>, ? extends Object> function172 = function14;
                    objectRef = objectRef3;
                    Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(obj22);
                    cancellationException = !(thM14502exceptionOrNullimpl2 instanceof CancellationException) ? (CancellationException) thM14502exceptionOrNullimpl2 : null;
                    if (cancellationException == null) {
                        throw cancellationException;
                    }
                    RetryDirective retryDirectiveEvaluate = retryPolicy4.evaluate(obj22);
                    try {
                        try {
                            try {
                                StandardRetryStrategy standardRetryStrategy = (StandardRetryStrategy) objectRef.element;
                                c37691.L$0 = function172;
                                c37691.L$1 = retryPolicy4;
                                c37691.L$2 = retryToken3;
                                c37691.L$3 = objectRef;
                                c37691.L$4 = obj22;
                                c37691.L$5 = retryDirectiveEvaluate;
                                c37691.L$6 = null;
                                c37691.L$7 = null;
                                c37691.I$0 = i82;
                                c37691.label = 2;
                                if (standardRetryStrategy.afterTry(i82, obj22, retryDirectiveEvaluate, retryPolicy7, c376914) != coroutine_suspended) {
                                    retryToken4 = retryToken3;
                                    obj = obj22;
                                    retryDirective2 = retryDirectiveEvaluate;
                                    c37691 = c376914;
                                    function15 = function172;
                                    i6 = i82;
                                    retryPolicy5 = retryPolicy7;
                                    if (retryDirective2 instanceof RetryDirective.TerminateAndSucceed) {
                                        StandardRetryStrategy standardRetryStrategy2 = (StandardRetryStrategy) objectRef.element;
                                        c37691.L$0 = SpillingKt.nullOutSpilledVariable(function15);
                                        c37691.L$1 = SpillingKt.nullOutSpilledVariable(retryPolicy5);
                                        c37691.L$2 = retryToken4;
                                        c37691.L$3 = objectRef;
                                        c37691.L$4 = obj;
                                        c37691.L$5 = SpillingKt.nullOutSpilledVariable(retryDirective2);
                                        c37691.I$0 = i6;
                                        c37691.label = 3;
                                        Object objSuccess = standardRetryStrategy2.success(retryToken4, i6, obj, c37691);
                                        if (objSuccess != coroutine_suspended) {
                                            return objSuccess;
                                        }
                                    } else {
                                        if (retryDirective2 instanceof RetryDirective.TerminateAndFail) {
                                            ((StandardRetryStrategy) objectRef.element).throwFailure(i6, obj);
                                            throw new KotlinNothingValueException();
                                        }
                                        if (!(retryDirective2 instanceof RetryDirective.RetryError)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        if (i6 >= ((StandardRetryStrategy) objectRef.element).getConfig().getMaxAttempts()) {
                                            ((StandardRetryStrategy) objectRef.element).throwTooManyAttempts(i6, obj);
                                            throw new KotlinNothingValueException();
                                        }
                                        DelayProvider delayProvider = ((StandardRetryStrategy) objectRef.element).getConfig().getDelayProvider();
                                        c37691.L$0 = function15;
                                        c37691.L$1 = retryPolicy5;
                                        c37691.L$2 = retryToken4;
                                        c37691.L$3 = objectRef;
                                        c37691.L$4 = obj;
                                        c37691.L$5 = retryDirective2;
                                        c37691.I$0 = i6;
                                        c37691.label = 4;
                                        if (delayProvider.backoff(i6, c37691) != coroutine_suspended) {
                                            RetryErrorType reason = ((RetryDirective.RetryError) retryDirective2).getReason();
                                            c37691.L$0 = function15;
                                            c37691.L$1 = retryPolicy5;
                                            c37691.L$2 = retryToken4;
                                            c37691.L$3 = objectRef;
                                            c37691.L$4 = obj;
                                            c37691.L$5 = retryDirective2;
                                            c37691.I$0 = i6;
                                            c37691.label = 5;
                                            objScheduleRetry = retryToken4.scheduleRetry(reason, c37691);
                                            if (objScheduleRetry != coroutine_suspended) {
                                                function16 = function15;
                                                retryToken5 = retryToken4;
                                                retryPolicy6 = retryPolicy5;
                                                c376913 = c37691;
                                                objectRef4 = objectRef;
                                                retryDirective3 = retryDirective2;
                                                try {
                                                    RetryToken retryToken6 = (RetryToken) objScheduleRetry;
                                                    c376913.L$0 = function16;
                                                    c376913.L$1 = retryPolicy6;
                                                    c376913.L$2 = retryToken5;
                                                    c376913.L$3 = objectRef4;
                                                    c376913.L$4 = obj;
                                                    i4 = i7;
                                                    c376913.L$5 = SpillingKt.nullOutSpilledVariable(retryDirective3);
                                                    c376913.L$6 = retryToken6;
                                                    c376913.L$7 = SpillingKt.nullOutSpilledVariable(retryToken6);
                                                    c376913.I$0 = i6;
                                                    c376913.I$1 = 0;
                                                    c376913.label = 6;
                                                    if (((StandardRetryStrategy) objectRef4.element).beforeRetry(i6 + 1, obj, retryDirective3, retryPolicy6, c376913) != coroutine_suspended) {
                                                        retryToken3 = retryToken6;
                                                        objectRef2 = objectRef4;
                                                        i5 = i6;
                                                        retryPolicy3 = retryPolicy6;
                                                        c376912 = c376913;
                                                        function13 = function16;
                                                        i2 = i5 + 1;
                                                        objectRef2.element = (StandardRetryStrategy) objectRef2.element;
                                                        i7 = i4;
                                                        T t2 = objectRef2.element;
                                                        Result.Companion companion22 = Result.INSTANCE;
                                                        c376912.L$0 = function13;
                                                        c376912.L$1 = retryPolicy3;
                                                        c376912.L$2 = retryToken3;
                                                        c376912.L$3 = objectRef2;
                                                        c376912.L$4 = SpillingKt.nullOutSpilledVariable((StandardRetryStrategy) t2);
                                                        c376912.L$5 = null;
                                                        c376912.L$6 = null;
                                                        c376912.L$7 = null;
                                                        c376912.I$0 = i2;
                                                        c376912.I$1 = 0;
                                                        c376912.label = i7;
                                                        objScheduleRetry = function13.invoke(c376912);
                                                        if (objScheduleRetry != coroutine_suspended) {
                                                        }
                                                    }
                                                } catch (RetryCapacityExceededException e2) {
                                                    e = e2;
                                                    objectRef = objectRef4;
                                                    ((StandardRetryStrategy) objectRef.element).throwCapacityExceeded(e, i6, Result.m14498boximpl(obj));
                                                    throw new KotlinNothingValueException();
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    retryDirective = retryDirective3;
                                                    c37691 = c376913;
                                                    retryPolicy2 = retryPolicy6;
                                                    retryToken2 = retryToken5;
                                                    function12 = function16;
                                                    c37691.L$0 = SpillingKt.nullOutSpilledVariable(function12);
                                                    c37691.L$1 = SpillingKt.nullOutSpilledVariable(retryPolicy2);
                                                    c37691.L$2 = SpillingKt.nullOutSpilledVariable(retryToken2);
                                                    c37691.L$3 = SpillingKt.nullOutSpilledVariable(obj);
                                                    c37691.L$4 = SpillingKt.nullOutSpilledVariable(retryDirective);
                                                    c37691.L$5 = th;
                                                    c37691.L$6 = null;
                                                    c37691.L$7 = null;
                                                    c37691.I$0 = i6;
                                                    c37691.label = 7;
                                                    if (retryToken2.notifyFailure(c37691) != coroutine_suspended) {
                                                    }
                                                    return coroutine_suspended;
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (RetryCapacityExceededException e3) {
                                e = e3;
                                i6 = i82;
                                obj = obj22;
                                ((StandardRetryStrategy) objectRef.element).throwCapacityExceeded(e, i6, Result.m14498boximpl(obj));
                                throw new KotlinNothingValueException();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            retryToken2 = retryToken3;
                            obj = obj22;
                            retryDirective = retryDirectiveEvaluate;
                            c37691 = c376914;
                            function12 = function172;
                            i6 = i82;
                            retryPolicy2 = retryPolicy7;
                            c37691.L$0 = SpillingKt.nullOutSpilledVariable(function12);
                            c37691.L$1 = SpillingKt.nullOutSpilledVariable(retryPolicy2);
                            c37691.L$2 = SpillingKt.nullOutSpilledVariable(retryToken2);
                            c37691.L$3 = SpillingKt.nullOutSpilledVariable(obj);
                            c37691.L$4 = SpillingKt.nullOutSpilledVariable(retryDirective);
                            c37691.L$5 = th;
                            c37691.L$6 = null;
                            c37691.L$7 = null;
                            c37691.I$0 = i6;
                            c37691.label = 7;
                            if (retryToken2.notifyFailure(c37691) != coroutine_suspended) {
                                throw th;
                            }
                            return coroutine_suspended;
                        }
                        c376914 = c37691;
                        retryPolicy7 = retryPolicy4;
                    } catch (Throwable th6) {
                        th = th6;
                        retryPolicy7 = retryPolicy4;
                        retryToken2 = retryToken3;
                        obj = obj22;
                        retryDirective = retryDirectiveEvaluate;
                    }
                }
                return coroutine_suspended;
            case 1:
                int i9 = c37691.I$1;
                i3 = c37691.I$0;
                objectRef3 = (Ref.ObjectRef) c37691.L$3;
                retryToken3 = (RetryToken) c37691.L$2;
                retryPolicy4 = (RetryPolicy) c37691.L$1;
                function14 = (Function1) c37691.L$0;
                try {
                    ResultKt.throwOnFailure(objScheduleRetry);
                } catch (Throwable th7) {
                    th = th7;
                    Result.Companion companion3 = Result.INSTANCE;
                    objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                    Object obj222 = objM14499constructorimpl;
                    int i822 = i3;
                    Function1<? super Continuation<? super R>, ? extends Object> function1722 = function14;
                    objectRef = objectRef3;
                    Throwable thM14502exceptionOrNullimpl22 = Result.m14502exceptionOrNullimpl(obj222);
                    if (!(thM14502exceptionOrNullimpl22 instanceof CancellationException)) {
                    }
                    if (cancellationException == null) {
                    }
                }
                objM14499constructorimpl = Result.m14499constructorimpl(objScheduleRetry);
                Object obj2222 = objM14499constructorimpl;
                int i8222 = i3;
                Function1<? super Continuation<? super R>, ? extends Object> function17222 = function14;
                objectRef = objectRef3;
                Throwable thM14502exceptionOrNullimpl222 = Result.m14502exceptionOrNullimpl(obj2222);
                if (!(thM14502exceptionOrNullimpl222 instanceof CancellationException)) {
                }
                if (cancellationException == null) {
                }
                break;
            case 2:
                i6 = c37691.I$0;
                retryDirective2 = (RetryDirective) c37691.L$5;
                obj = c37691.L$4;
                objectRef = (Ref.ObjectRef) c37691.L$3;
                retryToken4 = (RetryToken) c37691.L$2;
                retryPolicy5 = (RetryPolicy) c37691.L$1;
                function15 = (Function1) c37691.L$0;
                ResultKt.throwOnFailure(objScheduleRetry);
                if (retryDirective2 instanceof RetryDirective.TerminateAndSucceed) {
                }
                return coroutine_suspended;
            case 3:
                int i10 = c37691.I$0;
                Object obj3 = c37691.L$4;
                ResultKt.throwOnFailure(objScheduleRetry);
                return objScheduleRetry;
            case 4:
                i6 = c37691.I$0;
                retryDirective2 = (RetryDirective) c37691.L$5;
                obj = c37691.L$4;
                objectRef = (Ref.ObjectRef) c37691.L$3;
                retryToken4 = (RetryToken) c37691.L$2;
                retryPolicy5 = (RetryPolicy) c37691.L$1;
                function15 = (Function1) c37691.L$0;
                ResultKt.throwOnFailure(objScheduleRetry);
                RetryErrorType reason2 = ((RetryDirective.RetryError) retryDirective2).getReason();
                c37691.L$0 = function15;
                c37691.L$1 = retryPolicy5;
                c37691.L$2 = retryToken4;
                c37691.L$3 = objectRef;
                c37691.L$4 = obj;
                c37691.L$5 = retryDirective2;
                c37691.I$0 = i6;
                c37691.label = 5;
                objScheduleRetry = retryToken4.scheduleRetry(reason2, c37691);
                if (objScheduleRetry != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 5:
                i6 = c37691.I$0;
                retryDirective2 = (RetryDirective) c37691.L$5;
                obj = c37691.L$4;
                objectRef = (Ref.ObjectRef) c37691.L$3;
                retryToken4 = (RetryToken) c37691.L$2;
                retryPolicy5 = (RetryPolicy) c37691.L$1;
                function15 = (Function1) c37691.L$0;
                ResultKt.throwOnFailure(objScheduleRetry);
                function16 = function15;
                retryToken5 = retryToken4;
                retryPolicy6 = retryPolicy5;
                c376913 = c37691;
                objectRef4 = objectRef;
                retryDirective3 = retryDirective2;
                RetryToken retryToken62 = (RetryToken) objScheduleRetry;
                c376913.L$0 = function16;
                c376913.L$1 = retryPolicy6;
                c376913.L$2 = retryToken5;
                c376913.L$3 = objectRef4;
                c376913.L$4 = obj;
                i4 = i7;
                c376913.L$5 = SpillingKt.nullOutSpilledVariable(retryDirective3);
                c376913.L$6 = retryToken62;
                c376913.L$7 = SpillingKt.nullOutSpilledVariable(retryToken62);
                c376913.I$0 = i6;
                c376913.I$1 = 0;
                c376913.label = 6;
                if (((StandardRetryStrategy) objectRef4.element).beforeRetry(i6 + 1, obj, retryDirective3, retryPolicy6, c376913) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 6:
                int i11 = c37691.I$1;
                int i12 = c37691.I$0;
                RetryToken retryToken7 = (RetryToken) c37691.L$6;
                Object obj4 = c37691.L$4;
                objectRef2 = (Ref.ObjectRef) c37691.L$3;
                RetryPolicy<? super R> retryPolicy8 = (RetryPolicy) c37691.L$1;
                Function1<? super Continuation<? super R>, ? extends Object> function18 = (Function1) c37691.L$0;
                ResultKt.throwOnFailure(objScheduleRetry);
                c376912 = c37691;
                i5 = i12;
                i4 = 1;
                retryToken3 = retryToken7;
                retryPolicy3 = retryPolicy8;
                function13 = function18;
                i2 = i5 + 1;
                objectRef2.element = (StandardRetryStrategy) objectRef2.element;
                i7 = i4;
                T t22 = objectRef2.element;
                Result.Companion companion222 = Result.INSTANCE;
                c376912.L$0 = function13;
                c376912.L$1 = retryPolicy3;
                c376912.L$2 = retryToken3;
                c376912.L$3 = objectRef2;
                c376912.L$4 = SpillingKt.nullOutSpilledVariable((StandardRetryStrategy) t22);
                c376912.L$5 = null;
                c376912.L$6 = null;
                c376912.L$7 = null;
                c376912.I$0 = i2;
                c376912.I$1 = 0;
                c376912.label = i7;
                objScheduleRetry = function13.invoke(c376912);
                if (objScheduleRetry != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 7:
                int i13 = c37691.I$0;
                Throwable th8 = (Throwable) c37691.L$5;
                Object obj5 = c37691.L$3;
                ResultKt.throwOnFailure(objScheduleRetry);
                throw th8;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ Object beforeInitialTry$suspendImpl(StandardRetryStrategy standardRetryStrategy, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ <R> Object afterTry$suspendImpl(StandardRetryStrategy standardRetryStrategy, int i, Object obj, RetryDirective retryDirective, RetryPolicy<? super R> retryPolicy, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ <R> Object beforeRetry$suspendImpl(StandardRetryStrategy standardRetryStrategy, int i, Object obj, RetryDirective retryDirective, RetryPolicy<? super R> retryPolicy, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <R> Object success(RetryToken retryToken, int i, Object obj, Continuation<? super Outcome<? extends R>> continuation) {
        C37711 c37711;
        if (continuation instanceof C37711) {
            c37711 = (C37711) continuation;
            if ((c37711.label & Integer.MIN_VALUE) != 0) {
                c37711.label -= Integer.MIN_VALUE;
            } else {
                c37711 = new C37711(continuation);
            }
        }
        Object obj2 = c37711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c37711.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            c37711.L$0 = SpillingKt.nullOutSpilledVariable(retryToken);
            c37711.L$1 = obj;
            c37711.I$0 = i;
            c37711.label = 1;
            if (retryToken.notifySuccess(c37711) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c37711.I$0;
            obj = c37711.L$1;
            ResultKt.throwOnFailure(obj2);
        }
        Object obj3 = Result.m14505isFailureimpl(obj) ? null : obj;
        if (obj3 == null) {
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(obj);
            Intrinsics.checkNotNull(thM14502exceptionOrNullimpl);
            return new Outcome.Exception(i, thM14502exceptionOrNullimpl);
        }
        return new Outcome.Response(i, obj3);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <R> Void throwCapacityExceeded(RetryCapacityExceededException cause, int attempt, Result<? extends R> result) throws Throwable {
        Object obj;
        String str = "Insufficient client capacity to attempt retry, halting on attempt " + attempt + " of " + getConfig().getMaxAttempts();
        Throwable thM14502exceptionOrNullimpl = result != null ? Result.m14502exceptionOrNullimpl(result.getValue()) : null;
        if (thM14502exceptionOrNullimpl == null) {
            RetryCapacityExceededException retryCapacityExceededException = cause;
            if (result != null) {
                Object value = result.getValue();
                obj = Result.m14505isFailureimpl(value) ? null : value;
            }
            throw new TooManyAttemptsException(str, retryCapacityExceededException, attempt, obj, result != null ? Result.m14502exceptionOrNullimpl(result.getValue()) : null);
        }
        if (thM14502exceptionOrNullimpl instanceof ServiceException) {
            AttributesKt.appendValue(((ServiceException) thM14502exceptionOrNullimpl).getSdkErrorMetadata().getAttributes(), ErrorMetadata.INSTANCE.getClientContext(), new ClientErrorContext("Early retry termination", str));
            throw thM14502exceptionOrNullimpl;
        }
        throw thM14502exceptionOrNullimpl;
    }

    private final <R> Void throwFailure(int attempt, Object result) throws Throwable {
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(result);
        if (thM14502exceptionOrNullimpl == null) {
            if (Result.m14505isFailureimpl(result)) {
                result = null;
            }
            throw new RetryFailureException("The operation resulted in a non-retryable failure", null, attempt, result);
        }
        throw thM14502exceptionOrNullimpl;
    }

    private final <R> Void throwTooManyAttempts(int attempt, Object result) throws Throwable {
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(result);
        if (thM14502exceptionOrNullimpl == null) {
            throw new TooManyAttemptsException("Took more than " + getConfig().getMaxAttempts() + " attempts to get a successful response", null, attempt, Result.m14505isFailureimpl(result) ? null : result, Result.m14502exceptionOrNullimpl(result));
        }
        throw thM14502exceptionOrNullimpl;
    }

    /* JADX INFO: compiled from: StandardRetryStrategy.kt */
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config;", "Laws/smithy/kotlin/runtime/retries/RetryStrategy$Config;", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;", "builder", "<init>", "(Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;)V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/RetryStrategy$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "()Lkotlin/jvm/functions/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider;", "delayProvider", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider;", "getDelayProvider", "()Laws/smithy/kotlin/runtime/retries/delay/DelayProvider;", "", "maxAttempts", "I", "getMaxAttempts", "()I", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket;", "tokenBucket", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket;", "getTokenBucket", "()Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket;", "Companion", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static class Config implements RetryStrategy.Config {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int DEFAULT_MAX_ATTEMPTS = 3;
        private final DelayProvider delayProvider;
        private final int maxAttempts;
        private final RetryTokenBucket tokenBucket;

        /* JADX INFO: compiled from: StandardRetryStrategy.kt */
        @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config;", "default", "()Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config;", "", "DEFAULT_MAX_ATTEMPTS", "I", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: default, reason: not valid java name */
            public final Config m12235default() {
                return new Config(new Builder());
            }
        }

        public Config(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.delayProvider = builder.getDelayProviderProperty$runtime_core().getSupply().invoke();
            this.maxAttempts = builder.getMaxAttempts();
            this.tokenBucket = builder.getTokenBucketProperty$runtime_core().getSupply().invoke();
        }

        public final DelayProvider getDelayProvider() {
            return this.delayProvider;
        }

        @Override // aws.smithy.kotlin.runtime.retries.RetryStrategy.Config
        public int getMaxAttempts() {
            return this.maxAttempts;
        }

        public final RetryTokenBucket getTokenBucket() {
            return this.tokenBucket;
        }

        @Override // aws.smithy.kotlin.runtime.retries.RetryStrategy.Config
        public Function1<RetryStrategy.Config.Builder, Unit> toBuilderApplicator() {
            return new Function1() { // from class: aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$Config$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StandardRetryStrategy.Config.toBuilderApplicator$lambda$0(this.f$0, (RetryStrategy.Config.Builder) obj);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit toBuilderApplicator$lambda$0(Config config, RetryStrategy.Config.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<this>");
            if (builder instanceof Builder) {
                Builder builder2 = (Builder) builder;
                builder2.setDelayProvider(config.delayProvider);
                builder2.setMaxAttempts(config.getMaxAttempts());
                builder2.setTokenBucket(config.tokenBucket);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: compiled from: StandardRetryStrategy.kt */
        @Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nJN\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\f*\u00020\u000b\"\b\b\u0001\u0010\u000e*\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\u0011J&\u0010\u0013\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\u0013\u0010\nJN\u0010\u0013\u001a\u00020\u0006\"\b\b\u0000\u0010\f*\u00020\u0014\"\b\b\u0001\u0010\u0016*\u00020\u00152\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\u0013\u0010\u0011R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR/\u0010\t\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 *\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001bR/\u0010\u0013\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/*\u0004\b0\u0010\"¨\u00061"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/RetryStrategy$Config$Builder;", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "delayProvider", "(Lkotlin/jvm/functions/Function1;)V", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider$Config$Builder;", "B", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider;", "D", "Laws/smithy/kotlin/runtime/util/DslFactory;", "factory", "(Laws/smithy/kotlin/runtime/util/DslFactory;Lkotlin/jvm/functions/Function1;)V", "Laws/smithy/kotlin/runtime/retries/delay/StandardRetryTokenBucket$Config$Builder;", "tokenBucket", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/util/DslBuilderProperty;", "delayProviderProperty", "Laws/smithy/kotlin/runtime/util/DslBuilderProperty;", "getDelayProviderProperty$runtime_core", "()Laws/smithy/kotlin/runtime/util/DslBuilderProperty;", "<set-?>", "getDelayProvider", "()Laws/smithy/kotlin/runtime/retries/delay/DelayProvider;", "setDelayProvider", "(Laws/smithy/kotlin/runtime/retries/delay/DelayProvider;)V", "getDelayProvider$delegate", "(Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;)Ljava/lang/Object;", "", "maxAttempts", "I", "getMaxAttempts", "()I", "setMaxAttempts", "(I)V", "tokenBucketProperty", "getTokenBucketProperty$runtime_core", "getTokenBucket", "()Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket;", "setTokenBucket", "(Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket;)V", "getTokenBucket$delegate", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static class Builder implements RetryStrategy.Config.Builder {
            private final DslBuilderProperty<DelayProvider.Config.Builder, DelayProvider> delayProviderProperty = new DslBuilderProperty<>(ExponentialBackoffWithJitter.INSTANCE, new Function1() { // from class: aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$Config$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StandardRetryStrategy.Config.Builder.delayProviderProperty$lambda$0((DelayProvider) obj);
                }
            }, null, 4, null);
            private int maxAttempts = 3;
            private final DslBuilderProperty<RetryTokenBucket.Config.Builder, RetryTokenBucket> tokenBucketProperty = new DslBuilderProperty<>(StandardRetryTokenBucket.INSTANCE, new Function1() { // from class: aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$Config$Builder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StandardRetryStrategy.Config.Builder.tokenBucketProperty$lambda$0((RetryTokenBucket) obj);
                }
            }, null, 4, null);

            public final DslBuilderProperty<DelayProvider.Config.Builder, DelayProvider> getDelayProviderProperty$runtime_core() {
                return this.delayProviderProperty;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Function1 delayProviderProperty$lambda$0(DelayProvider DslBuilderProperty) {
                Intrinsics.checkNotNullParameter(DslBuilderProperty, "$this$DslBuilderProperty");
                return DslBuilderProperty.getConfig().toBuilderApplicator();
            }

            public final DelayProvider getDelayProvider() {
                return this.delayProviderProperty.getInstance();
            }

            public final void setDelayProvider(DelayProvider delayProvider) {
                this.delayProviderProperty.setInstance(delayProvider);
            }

            public final void delayProvider(Function1<? super ExponentialBackoffWithJitter.Config.Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                this.delayProviderProperty.dsl(ExponentialBackoffWithJitter.INSTANCE, block);
            }

            public final <B extends DelayProvider.Config.Builder, D extends DelayProvider> void delayProvider(DslFactory<? extends B, ? extends D> factory, Function1<? super B, Unit> block) {
                Intrinsics.checkNotNullParameter(factory, "factory");
                Intrinsics.checkNotNullParameter(block, "block");
                this.delayProviderProperty.dsl(factory, block);
            }

            @Override // aws.smithy.kotlin.runtime.retries.RetryStrategy.Config.Builder
            public int getMaxAttempts() {
                return this.maxAttempts;
            }

            @Override // aws.smithy.kotlin.runtime.retries.RetryStrategy.Config.Builder
            public void setMaxAttempts(int i) {
                this.maxAttempts = i;
            }

            public final DslBuilderProperty<RetryTokenBucket.Config.Builder, RetryTokenBucket> getTokenBucketProperty$runtime_core() {
                return this.tokenBucketProperty;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Function1 tokenBucketProperty$lambda$0(RetryTokenBucket DslBuilderProperty) {
                Intrinsics.checkNotNullParameter(DslBuilderProperty, "$this$DslBuilderProperty");
                return DslBuilderProperty.getConfig().toBuilderApplicator();
            }

            public final RetryTokenBucket getTokenBucket() {
                return this.tokenBucketProperty.getInstance();
            }

            public final void setTokenBucket(RetryTokenBucket retryTokenBucket) {
                this.tokenBucketProperty.setInstance(retryTokenBucket);
            }

            public final void tokenBucket(Function1<? super StandardRetryTokenBucket.Config.Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                this.tokenBucketProperty.dsl(StandardRetryTokenBucket.INSTANCE, block);
            }

            public final <B extends RetryTokenBucket.Config.Builder, T extends RetryTokenBucket> void tokenBucket(DslFactory<? extends B, ? extends T> factory, Function1<? super B, Unit> block) {
                Intrinsics.checkNotNullParameter(factory, "factory");
                Intrinsics.checkNotNullParameter(block, "block");
                this.tokenBucketProperty.dsl(factory, block);
            }
        }
    }
}
