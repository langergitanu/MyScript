package androidx.constraintlayout.compose.carousel;

import androidx.constraintlayout.compose.carousel.CarouselSwipeableState;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CarouselSwipeable.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2", m1609f = "CarouselSwipeable.kt", m1610i = {0}, m1611l = {AIContainerViewModel.SUMMARIZE_MIN_LIMIT}, m1612m = "emit", m1613n = {"this"}, m1615s = {"L$0"})
final class CarouselSwipeableState$snapTo$2$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CarouselSwipeableState.C15792<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CarouselSwipeableState$snapTo$2$emit$1(CarouselSwipeableState.C15792<? super T> c15792, Continuation<? super CarouselSwipeableState$snapTo$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = c15792;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Map) null, (Continuation<? super Unit>) this);
    }
}
