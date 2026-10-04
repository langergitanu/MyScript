package com.revenuecat.purchases.p036ui.revenuecatui.components.carousel;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.CarouselPageChangeInteraction;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CarouselComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$4$1", m1609f = "CarouselComponentView.kt", m1610i = {}, m1611l = {TsExtractor.TS_STREAM_TYPE_DTS}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
public final class CarouselComponentViewKt$CarouselComponentView$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaywallComponentInteractionTracker $componentInteractionTracker;
    final /* synthetic */ int $pageCount;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ ProgrammaticPageTrackingFlag $skipProgrammaticPageTracking;
    final /* synthetic */ CarouselComponentStyle $style;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CarouselComponentViewKt$CarouselComponentView$4$1(PagerState pagerState, ProgrammaticPageTrackingFlag programmaticPageTrackingFlag, int i, PaywallComponentInteractionTracker paywallComponentInteractionTracker, CarouselComponentStyle carouselComponentStyle, Continuation<? super CarouselComponentViewKt$CarouselComponentView$4$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$skipProgrammaticPageTracking = programmaticPageTrackingFlag;
        this.$pageCount = i;
        this.$componentInteractionTracker = paywallComponentInteractionTracker;
        this.$style = carouselComponentStyle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CarouselComponentViewKt$CarouselComponentView$4$1(this.$pagerState, this.$skipProgrammaticPageTracking, this.$pageCount, this.$componentInteractionTracker, this.$style, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CarouselComponentViewKt$CarouselComponentView$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = this.$pagerState.getCurrentPage();
            final PagerState pagerState = this.$pagerState;
            Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$4$1.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(pagerState.getCurrentPage());
                }
            });
            final ProgrammaticPageTrackingFlag programmaticPageTrackingFlag = this.$skipProgrammaticPageTracking;
            final int i2 = this.$pageCount;
            final PaywallComponentInteractionTracker paywallComponentInteractionTracker = this.$componentInteractionTracker;
            final CarouselComponentStyle carouselComponentStyle = this.$style;
            this.label = 1;
            if (flowSnapshotFlow.collect(new FlowCollector() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$4$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Number) obj2).intValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(int i3, Continuation<? super Unit> continuation) {
                    if (i3 != intRef.element) {
                        if (!programmaticPageTrackingFlag.consumeShouldSkipPageChange()) {
                            int i4 = i3 % i2;
                            int i5 = intRef.element % i2;
                            paywallComponentInteractionTracker.track(PaywallComponentInteractionFactoriesKt.paywallCarouselPageChange(new CarouselPageChangeInteraction(carouselComponentStyle.getComponentName(), i4, i5, carouselComponentStyle.getInitialPageIndex(), emit$pageName(carouselComponentStyle, i5), emit$pageName(carouselComponentStyle, i4))));
                        }
                        intRef.element = i3;
                    }
                    return Unit.INSTANCE;
                }

                private static final String emit$pageName(CarouselComponentStyle carouselComponentStyle2, int i3) {
                    String str = (String) CollectionsKt.getOrNull(carouselComponentStyle2.getPageContextNames(), i3);
                    if (str == null || StringsKt.isBlank(str)) {
                        return null;
                    }
                    return str;
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
}
