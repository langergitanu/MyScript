package androidx.constraintlayout.compose.carousel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 */
/* JADX INFO: compiled from: CarouselSwipeable.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1", m1609f = "CarouselSwipeable.kt", m1610i = {0}, m1611l = {842}, m1612m = "onPostFling-RZ2iAVY", m1613n = {"available"}, m1615s = {"J$0"})
final class C1566xa706cf0e extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1566xa706cf0e(CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1 carouselSwipeableKt$PreUpPostDownNestedScrollConnection$1, Continuation<? super C1566xa706cf0e> continuation) {
        super(continuation);
        this.this$0 = carouselSwipeableKt$PreUpPostDownNestedScrollConnection$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo2379onPostFlingRZ2iAVY(0L, 0L, this);
    }
}
