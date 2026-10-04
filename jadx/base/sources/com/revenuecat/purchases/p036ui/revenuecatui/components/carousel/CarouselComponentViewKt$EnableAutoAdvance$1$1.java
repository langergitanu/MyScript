package com.revenuecat.purchases.p036ui.revenuecatui.components.carousel;

import androidx.compose.foundation.pager.PagerState;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CarouselComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$EnableAutoAdvance$1$1", m1609f = "CarouselComponentView.kt", m1610i = {}, m1611l = {369, 379}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class CarouselComponentViewKt$EnableAutoAdvance$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CarouselComponent.AutoAdvancePages $autoAdvance;
    final /* synthetic */ int $pageCount;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ boolean $shouldLoop;
    final /* synthetic */ ProgrammaticPageTrackingFlag $skipProgrammaticPageTracking;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CarouselComponentViewKt$EnableAutoAdvance$1$1(CarouselComponent.AutoAdvancePages autoAdvancePages, PagerState pagerState, boolean z, int i, ProgrammaticPageTrackingFlag programmaticPageTrackingFlag, Continuation<? super CarouselComponentViewKt$EnableAutoAdvance$1$1> continuation) {
        super(2, continuation);
        this.$autoAdvance = autoAdvancePages;
        this.$pagerState = pagerState;
        this.$shouldLoop = z;
        this.$pageCount = i;
        this.$skipProgrammaticPageTracking = programmaticPageTrackingFlag;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CarouselComponentViewKt$EnableAutoAdvance$1$1(this.$autoAdvance, this.$pagerState, this.$shouldLoop, this.$pageCount, this.$skipProgrammaticPageTracking, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CarouselComponentViewKt$EnableAutoAdvance$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Path cross not found for [B:12:0x0021, B:17:0x003c], limit reached: 25 */
    /* JADX WARN: Path cross not found for [B:12:0x0021, B:19:0x004c], limit reached: 25 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003a -> B:12:0x0021). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004a -> B:12:0x0021). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0073 -> B:12:0x0021). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:23:0x0076
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L76
            goto L21
        L12:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1a:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L34
        L1e:
            kotlin.ResultKt.throwOnFailure(r12)
        L21:
            com.revenuecat.purchases.paywalls.components.CarouselComponent$AutoAdvancePages r12 = r11.$autoAdvance
            int r12 = r12.getMsTimePerPage()
            long r4 = (long) r12
            r12 = r11
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r11.label = r3
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r4, r12)
            if (r12 != r0) goto L34
            goto L75
        L34:
            androidx.compose.foundation.pager.PagerState r12 = r11.$pagerState
            boolean r12 = r12.isScrollInProgress()
            if (r12 != 0) goto L21
            boolean r12 = r11.$shouldLoop
            int r1 = r11.$pageCount
            androidx.compose.foundation.pager.PagerState r4 = r11.$pagerState
            int r4 = r4.getCurrentPage()
            java.lang.Integer r12 = com.revenuecat.purchases.p036ui.revenuecatui.components.carousel.CarouselComponentViewKt.nextAutoAdvanceTargetPage(r12, r1, r4)
            if (r12 == 0) goto L21
            com.revenuecat.purchases.ui.revenuecatui.components.carousel.ProgrammaticPageTrackingFlag r1 = r11.$skipProgrammaticPageTracking
            r1.markProgrammaticScrollStarted()
            androidx.compose.foundation.pager.PagerState r4 = r11.$pagerState     // Catch: java.util.concurrent.CancellationException -> L76
            int r5 = r12.intValue()     // Catch: java.util.concurrent.CancellationException -> L76
            com.revenuecat.purchases.paywalls.components.CarouselComponent$AutoAdvancePages r12 = r11.$autoAdvance     // Catch: java.util.concurrent.CancellationException -> L76
            int r12 = r12.getMsTransitionTime()     // Catch: java.util.concurrent.CancellationException -> L76
            r1 = 0
            r6 = 6
            r7 = 0
            androidx.compose.animation.core.TweenSpec r12 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r12, r1, r7, r6, r7)     // Catch: java.util.concurrent.CancellationException -> L76
            r7 = r12
            androidx.compose.animation.core.AnimationSpec r7 = (androidx.compose.animation.core.AnimationSpec) r7     // Catch: java.util.concurrent.CancellationException -> L76
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: java.util.concurrent.CancellationException -> L76
            r11.label = r2     // Catch: java.util.concurrent.CancellationException -> L76
            r6 = 0
            r9 = 2
            r10 = 0
            java.lang.Object r12 = androidx.compose.foundation.pager.PagerState.animateScrollToPage$default(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L76
            if (r12 != r0) goto L21
        L75:
            return r0
        L76:
            com.revenuecat.purchases.ui.revenuecatui.components.carousel.ProgrammaticPageTrackingFlag r12 = r11.$skipProgrammaticPageTracking
            r12.clear()
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.p036ui.revenuecatui.components.carousel.CarouselComponentViewKt$EnableAutoAdvance$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
