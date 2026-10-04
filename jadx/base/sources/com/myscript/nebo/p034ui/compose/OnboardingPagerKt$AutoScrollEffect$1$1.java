package com.myscript.nebo.p034ui.compose;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: OnboardingPager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.ui.compose.OnboardingPagerKt$AutoScrollEffect$1$1", m1609f = "OnboardingPager.kt", m1610i = {0, 0}, m1611l = {577}, m1612m = "invokeSuspend", m1613n = {"$this$LaunchedEffect", "autoScrollJob"}, m1614nl = {583}, m1615s = {"L$0", "L$1"}, m1616v = 2)
final class OnboardingPagerKt$AutoScrollEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $autoScrollDelay;
    final /* synthetic */ int $autoScrollDuration;
    final /* synthetic */ PagerState $pagerState;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingPagerKt$AutoScrollEffect$1$1(long j, PagerState pagerState, int i, Continuation<? super OnboardingPagerKt$AutoScrollEffect$1$1> continuation) {
        super(2, continuation);
        this.$autoScrollDelay = j;
        this.$pagerState = pagerState;
        this.$autoScrollDuration = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OnboardingPagerKt$AutoScrollEffect$1$1 onboardingPagerKt$AutoScrollEffect$1$1 = new OnboardingPagerKt$AutoScrollEffect$1$1(this.$autoScrollDelay, this.$pagerState, this.$autoScrollDuration, continuation);
        onboardingPagerKt$AutoScrollEffect$1$1.L$0 = obj;
        return onboardingPagerKt$AutoScrollEffect$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingPagerKt$AutoScrollEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            invokeSuspend$startAutoScroll(objectRef, coroutineScope, this.$autoScrollDelay, this.$pagerState, this.$autoScrollDuration);
            final PagerState pagerState = this.$pagerState;
            Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$AutoScrollEffect$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(pagerState.isScrollInProgress());
                }
            });
            final long j = this.$autoScrollDelay;
            final PagerState pagerState2 = this.$pagerState;
            final int i2 = this.$autoScrollDuration;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(objectRef);
            this.label = 1;
            if (flowSnapshotFlow.collect(new FlowCollector() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$AutoScrollEffect$1$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    if (!z) {
                        OnboardingPagerKt$AutoScrollEffect$1$1.invokeSuspend$startAutoScroll(objectRef, coroutineScope, j, pagerState2, i2);
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, kotlinx.coroutines.Job] */
    public static final void invokeSuspend$startAutoScroll(Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, long j, PagerState pagerState, int i) {
        Job job = objectRef.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        objectRef.element = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OnboardingPagerKt$AutoScrollEffect$1$1$startAutoScroll$1(j, pagerState, i, null), 3, null);
    }
}
