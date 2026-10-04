package androidx.constraintlayout.compose.carousel;

import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CarouselSwipeable.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState", m1609f = "CarouselSwipeable.kt", m1610i = {1, 1, 1, 2, 2, 2}, m1611l = {146, PDFACompliance.e_PDFA1_7_1, PDFACompliance.e_PDFA1_7_4}, m1612m = "processNewAnchors$constraintlayout_compose_release", m1613n = {"this", "newAnchors", "targetOffset", "this", "newAnchors", "targetOffset"}, m1615s = {"L$0", "L$1", "F$0", "L$0", "L$1", "F$0"})
final class CarouselSwipeableState$processNewAnchors$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CarouselSwipeableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CarouselSwipeableState$processNewAnchors$1(CarouselSwipeableState<T> carouselSwipeableState, Continuation<? super CarouselSwipeableState$processNewAnchors$1> continuation) {
        super(continuation);
        this.this$0 = carouselSwipeableState;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processNewAnchors$constraintlayout_compose_release(null, null, this);
    }
}
