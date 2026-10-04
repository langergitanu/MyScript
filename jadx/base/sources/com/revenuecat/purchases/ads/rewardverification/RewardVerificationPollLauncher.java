package com.revenuecat.purchases.ads.rewardverification;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: RewardVerificationPollLauncher.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J=\u0010\u0007\u001a\u00020\u00062\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationPollLauncher;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "close", "", "launch", "poll", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult;", "onCompleted", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RewardVerificationPollLauncher {
    private final CoroutineScope scope;

    /* JADX WARN: Multi-variable type inference failed */
    public RewardVerificationPollLauncher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public RewardVerificationPollLauncher(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
    }

    public /* synthetic */ RewardVerificationPollLauncher(CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ads.rewardverification.RewardVerificationPollLauncher$launch$1 */
    /* JADX INFO: compiled from: RewardVerificationPollLauncher.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ads.rewardverification.RewardVerificationPollLauncher$launch$1", m1609f = "RewardVerificationPollLauncher.kt", m1610i = {}, m1611l = {23, 24}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C71151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<RewardVerificationResult, Unit> $onCompleted;
        final /* synthetic */ Function1<Continuation<? super RewardVerificationResult>, Object> $poll;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C71151(Function1<? super Continuation<? super RewardVerificationResult>, ? extends Object> function1, Function1<? super RewardVerificationResult, Unit> function12, Continuation<? super C71151> continuation) {
            super(2, continuation);
            this.$poll = function1;
            this.$onCompleted = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C71151(this.$poll, this.$onCompleted, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C71151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r1, new com.revenuecat.purchases.ads.rewardverification.RewardVerificationPollLauncher.C71151.AnonymousClass1(r4, (com.revenuecat.purchases.ads.rewardverification.RewardVerificationResult) r7, null), r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super RewardVerificationResult>, Object> function1 = this.$poll;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj != coroutine_suspended) {
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
            MainCoroutineDispatcher main = Dispatchers.getMain();
            Function1<RewardVerificationResult, Unit> function12 = this.$onCompleted;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.ads.rewardverification.RewardVerificationPollLauncher$launch$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: RewardVerificationPollLauncher.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.revenuecat.purchases.ads.rewardverification.RewardVerificationPollLauncher$launch$1$1", m1609f = "RewardVerificationPollLauncher.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<RewardVerificationResult, Unit> $onCompleted;
            final /* synthetic */ RewardVerificationResult $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super RewardVerificationResult, Unit> function1, RewardVerificationResult rewardVerificationResult, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$onCompleted = function1;
                this.$result = rewardVerificationResult;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$onCompleted, this.$result, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$onCompleted.invoke(this.$result);
                return Unit.INSTANCE;
            }
        }
    }

    public final void launch(Function1<? super Continuation<? super RewardVerificationResult>, ? extends Object> poll, Function1<? super RewardVerificationResult, Unit> onCompleted) {
        Intrinsics.checkNotNullParameter(poll, "poll");
        Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C71151(poll, onCompleted, null), 3, null);
    }

    public final void close() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }
}
