package com.myscript.nebo.p034ui.compose;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.pager.PagerState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: OnboardingPager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.ui.compose.OnboardingPagerKt$AutoScrollEffect$1$1$startAutoScroll$1", m1609f = "OnboardingPager.kt", m1610i = {1}, m1611l = {565, 567}, m1612m = "invokeSuspend", m1613n = {"nextPage"}, m1614nl = {566, -1}, m1615s = {"I$0"}, m1616v = 2)
final class OnboardingPagerKt$AutoScrollEffect$1$1$startAutoScroll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $autoScrollDelay;
    final /* synthetic */ int $autoScrollDuration;
    final /* synthetic */ PagerState $pagerState;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingPagerKt$AutoScrollEffect$1$1$startAutoScroll$1(long j, PagerState pagerState, int i, Continuation<? super OnboardingPagerKt$AutoScrollEffect$1$1$startAutoScroll$1> continuation) {
        super(2, continuation);
        this.$autoScrollDelay = j;
        this.$pagerState = pagerState;
        this.$autoScrollDuration = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingPagerKt$AutoScrollEffect$1$1$startAutoScroll$1(this.$autoScrollDelay, this.$pagerState, this.$autoScrollDuration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingPagerKt$AutoScrollEffect$1$1$startAutoScroll$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0057 -> B:11:0x001e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                int currentPage = (this.$pagerState.getCurrentPage() + 1) % this.$pagerState.getPageCount();
                this.I$0 = currentPage;
                this.label = 2;
                if (PagerState.animateScrollToPage$default(this.$pagerState, currentPage, 0.0f, AnimationSpecKt.tween$default(this.$autoScrollDuration, 0, null, 6, null), this, 2, null) != coroutine_suspended) {
                    this.label = 1;
                    if (DelayKt.delay(this.$autoScrollDelay, this) != coroutine_suspended) {
                        int currentPage2 = (this.$pagerState.getCurrentPage() + 1) % this.$pagerState.getPageCount();
                        this.I$0 = currentPage2;
                        this.label = 2;
                        if (PagerState.animateScrollToPage$default(this.$pagerState, currentPage2, 0.0f, AnimationSpecKt.tween$default(this.$autoScrollDuration, 0, null, 6, null), this, 2, null) != coroutine_suspended) {
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        if (DelayKt.delay(this.$autoScrollDelay, this) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
