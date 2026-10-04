package com.revenuecat.purchases.ads.rewardverification;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import com.fasterxml.jackson.core.JsonPointer;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.RewardVerificationException;
import com.revenuecat.purchases.RewardVerificationPollStatus;
import com.revenuecat.purchases.VerifiedReward;
import com.revenuecat.purchases.ads.rewardverification.Outcome;
import com.revenuecat.purchases.ads.rewardverification.VerifiedReward;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: Poller.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u00011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\r\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0082@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u009a\u0001\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00192$\b\u0002\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010 \u001a\u00020\t28\b\u0002\u0010!\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00120\u0010H\u0086@¢\u0006\u0002\u0010$JX\u0010%\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010 \u001a\u00020\tH\u0082@¢\u0006\u0002\u0010&J\f\u0010'\u001a\u00020\u0004*\u00020(H\u0002J\u0010\u0010'\u001a\u00020\u0004*\u00060)j\u0002`*H\u0002J\f\u0010+\u001a\u00020\u000e*\u00020(H\u0002J\f\u0010,\u001a\u00020\u0004*\u00020-H\u0002J\f\u0010.\u001a\u00020/*\u000200H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Poller;", "", "()V", "BACKOFF_SCHEDULING_FAILED_DESCRIPTION", "", "DEFAULT_JITTER_LOWER_BOUND_SECONDS", "", "DEFAULT_JITTER_UPPER_BOUND_SECONDS", "DEFAULT_MAX_ATTEMPTS", "", "MILLIS_PER_SECOND", "defaultJitterSeconds", "Lkotlin/Function0;", "awaitBackoff", "", "sleepSeconds", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "jitterSeconds", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchStep", "Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step;", "clientTransactionId", "fetcher", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationFetcher;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationFetcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logFailureToLogcat", "message", "isError", "poll", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome;", "maxAttempts", "logFailure", "Lkotlin/ParameterName;", "name", "(Ljava/lang/String;Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationFetcher;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollOutcome", "(Ljava/lang/String;Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationFetcher;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "describeForLog", "Lcom/revenuecat/purchases/PurchasesException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isTransientPollingError", "logDescription", "Lcom/revenuecat/purchases/RewardVerificationPollStatus;", "toAdMobReward", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "Lcom/revenuecat/purchases/VerifiedReward;", "Step", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class Poller {
    private static final String BACKOFF_SCHEDULING_FAILED_DESCRIPTION = "Failed to schedule the next reward verification poll attempt.";
    private static final double DEFAULT_JITTER_LOWER_BOUND_SECONDS = 0.75d;
    private static final double DEFAULT_JITTER_UPPER_BOUND_SECONDS = 1.25d;
    private static final int DEFAULT_MAX_ATTEMPTS = 10;
    private static final double MILLIS_PER_SECOND = 1000.0d;
    public static final Poller INSTANCE = new Poller();
    private static final Function0<Double> defaultJitterSeconds = new Function0<Double>() { // from class: com.revenuecat.purchases.ads.rewardverification.Poller$defaultJitterSeconds$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Double invoke() {
            return Double.valueOf(Random.INSTANCE.nextDouble(0.75d, 1.25d));
        }
    };

    /* JADX INFO: renamed from: com.revenuecat.purchases.ads.rewardverification.Poller$awaitBackoff$1 */
    /* JADX INFO: compiled from: Poller.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ads.rewardverification.Poller", m1609f = "Poller.kt", m1610i = {}, m1611l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m1612m = "awaitBackoff", m1613n = {}, m1615s = {})
    static final class C71091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C71091(Continuation<? super C71091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Poller.this.awaitBackoff(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ads.rewardverification.Poller$fetchStep$1 */
    /* JADX INFO: compiled from: Poller.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ads.rewardverification.Poller", m1609f = "Poller.kt", m1610i = {0, 0}, m1611l = {PDFACompliance.e_PDFA1_3_2}, m1612m = "fetchStep", m1613n = {"this", "clientTransactionId"}, m1615s = {"L$0", "L$1"})
    static final class C71101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C71101(Continuation<? super C71101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Poller.this.fetchStep(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ads.rewardverification.Poller$poll$1 */
    /* JADX INFO: compiled from: Poller.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ads.rewardverification.Poller", m1609f = "Poller.kt", m1610i = {0}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE}, m1612m = "poll", m1613n = {"logFailure"}, m1615s = {"L$0"})
    static final class C71111 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C71111(Continuation<? super C71111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Poller.this.poll(null, null, null, null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ads.rewardverification.Poller$pollOutcome$1 */
    /* JADX INFO: compiled from: Poller.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ads.rewardverification.Poller", m1609f = "Poller.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m1611l = {83, 86}, m1612m = "pollOutcome", m1613n = {"this", "clientTransactionId", "fetcher", "sleepSeconds", "jitterSeconds", "finalOutcome", "attempt", "maxAttempts", "sawUnknownStatus", "lastRetryWasTransientError", "this", "clientTransactionId", "fetcher", "sleepSeconds", "jitterSeconds", "finalOutcome", "attempt", "maxAttempts", "sawUnknownStatus", "lastRetryWasTransientError"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"})
    static final class C71141 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C71141(Continuation<? super C71141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Poller.this.pollOutcome(null, null, null, null, 0, this);
        }
    }

    private Poller() {
    }

    /* JADX INFO: compiled from: Poller.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step;", "", "RetryPending", "RetryTransientError", "RetryUnknown", "Terminal", "Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step$RetryPending;", "Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step$RetryTransientError;", "Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step$RetryUnknown;", "Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step$Terminal;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private interface Step {

        /* JADX INFO: compiled from: Poller.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step$Terminal;", "Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step;", "outcome", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome;", "(Lcom/revenuecat/purchases/ads/rewardverification/Outcome;)V", "getOutcome", "()Lcom/revenuecat/purchases/ads/rewardverification/Outcome;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Terminal implements Step {
            private final Outcome outcome;

            public Terminal(Outcome outcome) {
                Intrinsics.checkNotNullParameter(outcome, "outcome");
                this.outcome = outcome;
            }

            public final Outcome getOutcome() {
                return this.outcome;
            }
        }

        /* JADX INFO: compiled from: Poller.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step$RetryPending;", "Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class RetryPending implements Step {
            public static final RetryPending INSTANCE = new RetryPending();

            private RetryPending() {
            }
        }

        /* JADX INFO: compiled from: Poller.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step$RetryTransientError;", "Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class RetryTransientError implements Step {
            public static final RetryTransientError INSTANCE = new RetryTransientError();

            private RetryTransientError() {
            }
        }

        /* JADX INFO: compiled from: Poller.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step$RetryUnknown;", "Lcom/revenuecat/purchases/ads/rewardverification/Poller$Step;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class RetryUnknown implements Step {
            public static final RetryUnknown INSTANCE = new RetryUnknown();

            private RetryUnknown() {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object poll(String str, RewardVerificationFetcher rewardVerificationFetcher, Function2<? super Double, ? super Continuation<? super Unit>, ? extends Object> function2, Function0<Double> function0, int i, Function2<? super String, ? super Boolean, Unit> function22, Continuation<? super Outcome> continuation) {
        C71111 c71111;
        if (continuation instanceof C71111) {
            c71111 = (C71111) continuation;
            if ((c71111.label & Integer.MIN_VALUE) != 0) {
                c71111.label -= Integer.MIN_VALUE;
            } else {
                c71111 = new C71111(continuation);
            }
        }
        C71111 c711112 = c71111;
        Object objPollOutcome = c711112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c711112.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objPollOutcome);
            c711112.L$0 = function22;
            c711112.label = 1;
            objPollOutcome = pollOutcome(str, rewardVerificationFetcher, function2, function0, i, c711112);
            if (objPollOutcome == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function22 = (Function2) c711112.L$0;
            ResultKt.throwOnFailure(objPollOutcome);
        }
        Outcome outcome = (Outcome) objPollOutcome;
        if (outcome instanceof Outcome.Failed) {
            Outcome.Failed failed = (Outcome.Failed) outcome;
            function22.invoke(failed.getLogMessage(), Boxing.boxBoolean(failed.isUnexpected()));
        }
        return outcome;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.revenuecat.purchases.ads.rewardverification.Poller$poll$2 */
    /* JADX INFO: compiled from: Poller.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ads.rewardverification.Poller$poll$2", m1609f = "Poller.kt", m1610i = {}, m1611l = {49}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    public static final class C71122 extends SuspendLambda implements Function2<Double, Continuation<? super Unit>, Object> {
        /* synthetic */ double D$0;
        int label;

        C71122(Continuation<? super C71122> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C71122 c71122 = new C71122(continuation);
            c71122.D$0 = ((Number) obj).doubleValue();
            return c71122;
        }

        public final Object invoke(double d, Continuation<? super Unit> continuation) {
            return ((C71122) create(Double.valueOf(d), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Double d, Continuation<? super Unit> continuation) {
            return invoke(d.doubleValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay((long) (this.D$0 * 1000.0d), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object poll$default(Poller poller, String str, RewardVerificationFetcher rewardVerificationFetcher, Function2 function2, Function0 function0, int i, Function2 function22, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            rewardVerificationFetcher = RewardVerificationFetcher.INSTANCE.getDefault();
        }
        RewardVerificationFetcher rewardVerificationFetcher2 = rewardVerificationFetcher;
        if ((i2 & 4) != 0) {
            function2 = new C71122(null);
        }
        Function2 function23 = function2;
        if ((i2 & 8) != 0) {
            function0 = defaultJitterSeconds;
        }
        Function0 function02 = function0;
        if ((i2 & 16) != 0) {
            i = 10;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            function22 = new C71133(poller);
        }
        return poller.poll(str, rewardVerificationFetcher2, function23, function02, i3, function22, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.revenuecat.purchases.ads.rewardverification.Poller$poll$3 */
    /* JADX INFO: compiled from: Poller.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class C71133 extends FunctionReferenceImpl implements Function2<String, Boolean, Unit> {
        C71133(Object obj) {
            super(2, obj, Poller.class, "logFailureToLogcat", "logFailureToLogcat(Ljava/lang/String;Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
            invoke(str, bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(String p0, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((Poller) this.receiver).logFailureToLogcat(p0, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01d1, code lost:
    
        if (r2 != r3) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0184 -> B:56:0x0229). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01d1 -> B:42:0x01d4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pollOutcome(String str, RewardVerificationFetcher rewardVerificationFetcher, Function2<? super Double, ? super Continuation<? super Unit>, ? extends Object> function2, Function0<Double> function0, int i, Continuation<? super Outcome> continuation) {
        C71141 c71141;
        Poller poller;
        String str2;
        int i2;
        Ref.IntRef intRef;
        C71141 c711412;
        Poller poller2;
        Outcome terminalError;
        int i3;
        int i4;
        RewardVerificationFetcher rewardVerificationFetcher2;
        Function2<? super Double, ? super Continuation<? super Unit>, ? extends Object> function22;
        Function0<Double> function02;
        String str3;
        int i5;
        String str4;
        RewardVerificationFetcher rewardVerificationFetcher3;
        Function2<? super Double, ? super Continuation<? super Unit>, ? extends Object> function23;
        Function0<Double> function03;
        Outcome outcome;
        Ref.IntRef intRef2;
        int i6;
        int i7;
        Poller poller3;
        if (continuation instanceof C71141) {
            c71141 = (C71141) continuation;
            if ((c71141.label & Integer.MIN_VALUE) != 0) {
                c71141.label -= Integer.MIN_VALUE;
                poller = this;
            } else {
                poller = this;
                c71141 = poller.new C71141(continuation);
            }
        }
        Object obj = c71141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = c71141.label;
        String str5 = "[Purchases] - ";
        int i9 = 1;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                str2 = str;
                i2 = i;
                currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Reward verification poll start transactionId=" + str2 + " maxAttempts=" + i2);
            } else {
                str2 = str;
                i2 = i;
            }
            intRef = new Ref.IntRef();
            c711412 = c71141;
            poller2 = poller;
            terminalError = null;
            i3 = 0;
            i4 = 0;
            rewardVerificationFetcher2 = rewardVerificationFetcher;
            function22 = function2;
            function02 = function0;
            if (terminalError == null) {
            }
            if (terminalError == null) {
            }
        } else if (i8 == 1) {
            i5 = c71141.I$2;
            i7 = c71141.I$1;
            i6 = c71141.I$0;
            intRef2 = (Ref.IntRef) c71141.L$6;
            outcome = (Outcome) c71141.L$5;
            function03 = (Function0) c71141.L$4;
            function23 = (Function2) c71141.L$3;
            rewardVerificationFetcher3 = (RewardVerificationFetcher) c71141.L$2;
            str4 = (String) c71141.L$1;
            poller2 = (Poller) c71141.L$0;
            ResultKt.throwOnFailure(obj);
            str3 = "[Purchases] - ";
            if (((Boolean) obj).booleanValue()) {
            }
        } else {
            if (i8 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5 = c71141.I$2;
            int i10 = c71141.I$1;
            int i11 = c71141.I$0;
            Ref.IntRef intRef3 = (Ref.IntRef) c71141.L$6;
            Outcome outcome2 = (Outcome) c71141.L$5;
            Function0<Double> function04 = (Function0) c71141.L$4;
            Function2<? super Double, ? super Continuation<? super Unit>, ? extends Object> function24 = (Function2) c71141.L$3;
            RewardVerificationFetcher rewardVerificationFetcher4 = (RewardVerificationFetcher) c71141.L$2;
            str2 = (String) c71141.L$1;
            Poller poller4 = (Poller) c71141.L$0;
            ResultKt.throwOnFailure(obj);
            Object objFetchStep = obj;
            str3 = "[Purchases] - ";
            Step step = (Step) objFetchStep;
            if (step instanceof Step.Terminal) {
                intRef = intRef3;
                i4 = i10;
                i2 = i11;
                i3 = i5;
                function02 = function04;
                terminalError = ((Step.Terminal) step).getOutcome();
            } else {
                if (Intrinsics.areEqual(step, Step.RetryPending.INSTANCE)) {
                    poller3 = poller4;
                    function02 = function04;
                    c711412 = c71141;
                    terminalError = outcome2;
                    function22 = function24;
                    intRef = intRef3;
                    i4 = i10;
                    i2 = i11;
                    i3 = 0;
                } else if (Intrinsics.areEqual(step, Step.RetryTransientError.INSTANCE)) {
                    poller3 = poller4;
                    function02 = function04;
                    c711412 = c71141;
                    terminalError = outcome2;
                    function22 = function24;
                    intRef = intRef3;
                    i4 = i10;
                    i2 = i11;
                    i3 = 1;
                } else if (Intrinsics.areEqual(step, Step.RetryUnknown.INSTANCE)) {
                    poller3 = poller4;
                    i2 = i11;
                    function02 = function04;
                    i3 = 0;
                    c711412 = c71141;
                    terminalError = outcome2;
                    function22 = function24;
                    intRef = intRef3;
                    i4 = 1;
                } else {
                    int i12 = i11;
                    i3 = i5;
                    function02 = function04;
                    terminalError = outcome2;
                    intRef = intRef3;
                    i4 = i10;
                    i2 = i12;
                }
                intRef.element++;
                rewardVerificationFetcher2 = rewardVerificationFetcher4;
                i9 = 1;
                str5 = str3;
                poller2 = poller3;
                if (terminalError == null || intRef.element >= i2) {
                    if (terminalError == null) {
                        return terminalError;
                    }
                    if (i4 != 0) {
                        return Outcome.Failed.UnexpectedResponse.INSTANCE;
                    }
                    if (i3 != 0) {
                        return Outcome.Failed.ExhaustedWhileTransientErroring.INSTANCE;
                    }
                    return Outcome.Failed.ExhaustedWhilePending.INSTANCE;
                }
                LogLevel logLevel2 = LogLevel.VERBOSE;
                int i13 = i9;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    str3 = str5;
                    currentLogHandler2.mo1544v(str5 + logLevel2.name(), "Reward verification poll attempt " + (intRef.element + 1) + JsonPointer.SEPARATOR + i2 + " transactionId=" + str2);
                } else {
                    str3 = str5;
                }
                if (intRef.element > 0) {
                    c711412.L$0 = poller2;
                    c711412.L$1 = str2;
                    c711412.L$2 = rewardVerificationFetcher2;
                    c711412.L$3 = function22;
                    c711412.L$4 = function02;
                    c711412.L$5 = terminalError;
                    c711412.L$6 = intRef;
                    c711412.I$0 = i2;
                    c711412.I$1 = i4;
                    c711412.I$2 = i3;
                    c711412.label = i13;
                    Object objAwaitBackoff = poller2.awaitBackoff(function22, function02, c711412);
                    if (objAwaitBackoff != coroutine_suspended) {
                        str4 = str2;
                        i6 = i2;
                        intRef2 = intRef;
                        function23 = function22;
                        c71141 = c711412;
                        i7 = i4;
                        function03 = function02;
                        i5 = i3;
                        outcome = terminalError;
                        rewardVerificationFetcher3 = rewardVerificationFetcher2;
                        obj = objAwaitBackoff;
                        if (((Boolean) obj).booleanValue()) {
                            i3 = i5;
                            function02 = function03;
                            poller3 = poller2;
                            i4 = i7;
                            rewardVerificationFetcher4 = rewardVerificationFetcher3;
                            terminalError = new Outcome.Failed.TerminalError(BACKOFF_SCHEDULING_FAILED_DESCRIPTION);
                            c711412 = c71141;
                            function22 = function23;
                            intRef = intRef2;
                            i2 = i6;
                            str2 = str4;
                            intRef.element++;
                            rewardVerificationFetcher2 = rewardVerificationFetcher4;
                            i9 = 1;
                            str5 = str3;
                            poller2 = poller3;
                            if (terminalError == null) {
                            }
                            if (terminalError == null) {
                            }
                        } else {
                            Ref.IntRef intRef4 = intRef2;
                            i10 = i7;
                            poller4 = poller2;
                            rewardVerificationFetcher4 = rewardVerificationFetcher3;
                            function04 = function03;
                            intRef3 = intRef4;
                            Outcome outcome3 = outcome;
                            i11 = i6;
                            str2 = str4;
                            function24 = function23;
                            outcome2 = outcome3;
                            c71141.L$0 = poller4;
                            c71141.L$1 = str2;
                            c71141.L$2 = rewardVerificationFetcher4;
                            c71141.L$3 = function24;
                            c71141.L$4 = function04;
                            c71141.L$5 = outcome2;
                            c71141.L$6 = intRef3;
                            c71141.I$0 = i11;
                            c71141.I$1 = i10;
                            c71141.I$2 = i5;
                            c71141.label = 2;
                            objFetchStep = poller4.fetchStep(str2, rewardVerificationFetcher4, c71141);
                        }
                    }
                    return coroutine_suspended;
                }
                Outcome outcome4 = terminalError;
                function04 = function02;
                i5 = i3;
                i11 = i2;
                i10 = i4;
                intRef3 = intRef;
                outcome2 = outcome4;
                function24 = function22;
                c71141 = c711412;
                poller4 = poller2;
                rewardVerificationFetcher4 = rewardVerificationFetcher2;
                c71141.L$0 = poller4;
                c71141.L$1 = str2;
                c71141.L$2 = rewardVerificationFetcher4;
                c71141.L$3 = function24;
                c71141.L$4 = function04;
                c71141.L$5 = outcome2;
                c71141.L$6 = intRef3;
                c71141.I$0 = i11;
                c71141.I$1 = i10;
                c71141.I$2 = i5;
                c71141.label = 2;
                objFetchStep = poller4.fetchStep(str2, rewardVerificationFetcher4, c71141);
            }
            poller3 = poller4;
            c711412 = c71141;
            function22 = function24;
            intRef.element++;
            rewardVerificationFetcher2 = rewardVerificationFetcher4;
            i9 = 1;
            str5 = str3;
            poller2 = poller3;
            if (terminalError == null) {
            }
            if (terminalError == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitBackoff(Function2<? super Double, ? super Continuation<? super Unit>, ? extends Object> function2, Function0<Double> function0, Continuation<? super Boolean> continuation) {
        C71091 c71091;
        if (continuation instanceof C71091) {
            c71091 = (C71091) continuation;
            if ((c71091.label & Integer.MIN_VALUE) != 0) {
                c71091.label -= Integer.MIN_VALUE;
            } else {
                c71091 = new C71091(continuation);
            }
        }
        Object obj = c71091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c71091.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Double dInvoke = function0.invoke();
                c71091.label = 1;
                if (function2.invoke(dInvoke, c71091) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e A[Catch: Exception -> 0x0038, PurchasesException -> 0x003b, CancellationException -> 0x01a6, TryCatch #3 {CancellationException -> 0x01a6, blocks: (B:12:0x0034, B:25:0x0057, B:27:0x006e, B:28:0x009d, B:30:0x00a1, B:31:0x00c5, B:33:0x00cb, B:34:0x00db, B:36:0x00ec, B:38:0x00f0, B:40:0x010c, B:42:0x0114, B:44:0x0119, B:46:0x0121, B:48:0x0126, B:49:0x012b, B:21:0x0049), top: B:66:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1 A[Catch: Exception -> 0x0038, PurchasesException -> 0x003b, CancellationException -> 0x01a6, TryCatch #3 {CancellationException -> 0x01a6, blocks: (B:12:0x0034, B:25:0x0057, B:27:0x006e, B:28:0x009d, B:30:0x00a1, B:31:0x00c5, B:33:0x00cb, B:34:0x00db, B:36:0x00ec, B:38:0x00f0, B:40:0x010c, B:42:0x0114, B:44:0x0119, B:46:0x0121, B:48:0x0126, B:49:0x012b, B:21:0x0049), top: B:66:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ec A[Catch: Exception -> 0x0038, PurchasesException -> 0x003b, CancellationException -> 0x01a6, TryCatch #3 {CancellationException -> 0x01a6, blocks: (B:12:0x0034, B:25:0x0057, B:27:0x006e, B:28:0x009d, B:30:0x00a1, B:31:0x00c5, B:33:0x00cb, B:34:0x00db, B:36:0x00ec, B:38:0x00f0, B:40:0x010c, B:42:0x0114, B:44:0x0119, B:46:0x0121, B:48:0x0126, B:49:0x012b, B:21:0x0049), top: B:66:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchStep(String str, RewardVerificationFetcher rewardVerificationFetcher, Continuation<? super Step> continuation) {
        C71101 c71101;
        Poller poller;
        Step.Terminal terminal;
        RewardVerificationPollStatus rewardVerificationPollStatus;
        LogLevel logLevel;
        if (continuation instanceof C71101) {
            c71101 = (C71101) continuation;
            if ((c71101.label & Integer.MIN_VALUE) != 0) {
                c71101.label -= Integer.MIN_VALUE;
            } else {
                c71101 = new C71101(continuation);
            }
        }
        Object objFetch = c71101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c71101.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) c71101.L$1;
                poller = (Poller) c71101.L$0;
                try {
                    ResultKt.throwOnFailure(objFetch);
                    rewardVerificationPollStatus = (RewardVerificationPollStatus) objFetch;
                    logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Reward verification poll result=" + INSTANCE.logDescription(rewardVerificationPollStatus) + " transactionId=" + str);
                    }
                    if (!(rewardVerificationPollStatus instanceof RewardVerificationPollStatus.Verified)) {
                        VerifiedReward adMobReward = poller.toAdMobReward(((RewardVerificationPollStatus.Verified) rewardVerificationPollStatus).getReward());
                        List<com.revenuecat.purchases.VerifiedReward> moreRewards = ((RewardVerificationPollStatus.Verified) rewardVerificationPollStatus).getMoreRewards();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(moreRewards, 10));
                        Iterator<T> it = moreRewards.iterator();
                        while (it.hasNext()) {
                            arrayList.add(INSTANCE.toAdMobReward((com.revenuecat.purchases.VerifiedReward) it.next()));
                        }
                        return new Step.Terminal(new Outcome.Verified(adMobReward, arrayList));
                    }
                    if (rewardVerificationPollStatus instanceof RewardVerificationPollStatus.Failed) {
                        return new Step.Terminal(new Outcome.Failed.BackendRejected(((RewardVerificationPollStatus.Failed) rewardVerificationPollStatus).getMessage(), ((RewardVerificationPollStatus.Failed) rewardVerificationPollStatus).getFailureReason()));
                    }
                    if (Intrinsics.areEqual(rewardVerificationPollStatus, RewardVerificationPollStatus.PENDING.INSTANCE)) {
                        return Step.RetryPending.INSTANCE;
                    }
                    if (Intrinsics.areEqual(rewardVerificationPollStatus, RewardVerificationPollStatus.UNKNOWN.INSTANCE)) {
                        return Step.RetryUnknown.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                } catch (PurchasesException e) {
                    e = e;
                    if (poller.isTransientPollingError(e)) {
                    }
                    return terminal;
                } catch (Exception e2) {
                    e = e2;
                    return new Step.Terminal(new Outcome.Failed.TerminalError(poller.describeForLog(e)));
                }
            }
            ResultKt.throwOnFailure(objFetch);
            try {
                c71101.L$0 = this;
                c71101.L$1 = str;
                c71101.label = 1;
                objFetch = rewardVerificationFetcher.fetch(str, c71101);
                if (objFetch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                poller = this;
                rewardVerificationPollStatus = (RewardVerificationPollStatus) objFetch;
                logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                }
                if (!(rewardVerificationPollStatus instanceof RewardVerificationPollStatus.Verified)) {
                }
            } catch (PurchasesException e3) {
                e = e3;
                poller = this;
                if (poller.isTransientPollingError(e)) {
                    terminal = new Step.Terminal(new Outcome.Failed.TerminalError(poller.describeForLog(e)));
                } else {
                    LogLevel logLevel2 = LogLevel.VERBOSE;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler3.mo1544v("[Purchases] - " + logLevel2.name(), "Reward verification poll transient error, retrying: " + e.getCode() + " transactionId=" + str);
                    }
                    terminal = Step.RetryTransientError.INSTANCE;
                }
                return terminal;
            } catch (Exception e4) {
                e = e4;
                poller = this;
                return new Step.Terminal(new Outcome.Failed.TerminalError(poller.describeForLog(e)));
            }
        } catch (CancellationException e5) {
            throw e5;
        }
    }

    private final boolean isTransientPollingError(PurchasesException purchasesException) {
        if (purchasesException.getCode() != PurchasesErrorCode.NetworkError) {
            return (purchasesException instanceof RewardVerificationException) && ((RewardVerificationException) purchasesException).getIsServerError();
        }
        return true;
    }

    private final String describeForLog(PurchasesException purchasesException) {
        String underlyingErrorMessage = purchasesException.getUnderlyingErrorMessage();
        if (underlyingErrorMessage == null || StringsKt.isBlank(underlyingErrorMessage)) {
            underlyingErrorMessage = null;
        }
        return underlyingErrorMessage != null ? purchasesException.getMessage() + " (" + underlyingErrorMessage + ')' : purchasesException.getMessage();
    }

    private final String describeForLog(Exception exc) {
        String message = exc.getMessage();
        if (message != null) {
            if (StringsKt.isBlank(message)) {
                message = null;
            }
            if (message != null) {
                return message;
            }
        }
        String simpleName = exc.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
        return simpleName;
    }

    private final String logDescription(RewardVerificationPollStatus rewardVerificationPollStatus) {
        if (rewardVerificationPollStatus instanceof RewardVerificationPollStatus.Verified) {
            return "verified(reward=" + ((RewardVerificationPollStatus.Verified) rewardVerificationPollStatus).getReward() + ')';
        }
        if (Intrinsics.areEqual(rewardVerificationPollStatus, RewardVerificationPollStatus.PENDING.INSTANCE)) {
            return "pending";
        }
        if (rewardVerificationPollStatus instanceof RewardVerificationPollStatus.Failed) {
            return "failed";
        }
        if (Intrinsics.areEqual(rewardVerificationPollStatus, RewardVerificationPollStatus.UNKNOWN.INSTANCE)) {
            return "unknown";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final VerifiedReward toAdMobReward(com.revenuecat.purchases.VerifiedReward verifiedReward) {
        if (verifiedReward instanceof VerifiedReward.VirtualCurrency) {
            VerifiedReward.VirtualCurrency virtualCurrency = (VerifiedReward.VirtualCurrency) verifiedReward;
            return new VerifiedReward.VirtualCurrency(virtualCurrency.getCode(), virtualCurrency.getAmount());
        }
        if (verifiedReward instanceof VerifiedReward.Entitlement) {
            VerifiedReward.Entitlement entitlement = (VerifiedReward.Entitlement) verifiedReward;
            return new VerifiedReward.Entitlement(entitlement.getIdentifier(), entitlement.getExpiresAt());
        }
        if (Intrinsics.areEqual(verifiedReward, VerifiedReward.NoReward.INSTANCE)) {
            return VerifiedReward.NoReward.INSTANCE;
        }
        if (Intrinsics.areEqual(verifiedReward, VerifiedReward.UnsupportedReward.INSTANCE)) {
            return VerifiedReward.UnsupportedReward.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logFailureToLogcat(String message, boolean isError) {
        if (isError) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", message, null);
            return;
        }
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), message);
        }
    }
}
