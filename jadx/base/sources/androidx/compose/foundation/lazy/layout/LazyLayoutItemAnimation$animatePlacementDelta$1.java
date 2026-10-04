package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.p004ui.unit.IntOffset;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1", m1609f = "LazyLayoutItemAnimation.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA1_4_1, 148}, m1612m = "invokeSuspend", m1613n = {"finalSpec"}, m1615s = {"L$0"}, m1616v = 1)
final class LazyLayoutItemAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutItemAnimation$animatePlacementDelta$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j, Continuation<? super LazyLayoutItemAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutItemAnimation$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ad, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r13.this$0.placementDeltaAnimation, androidx.compose.p004ui.unit.IntOffset.m11136boximpl(r3), r1, null, new androidx.compose.foundation.lazy.layout.C0580x27eda3f(r14, r3), r13, 4, null) != r0) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SpringSpec springSpec;
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec;
        SpringSpec springSpec2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.placementDeltaAnimation.isRunning()) {
                FiniteAnimationSpec<IntOffset> finiteAnimationSpec2 = this.$spec;
                if (!(finiteAnimationSpec2 instanceof SpringSpec)) {
                    springSpec2 = LazyLayoutItemAnimationKt.InterruptionSpec;
                } else {
                    springSpec2 = (SpringSpec) finiteAnimationSpec2;
                }
                springSpec = springSpec2;
            } else {
                springSpec = this.$spec;
            }
            finiteAnimationSpec = springSpec;
            if (!this.this$0.placementDeltaAnimation.isRunning()) {
                this.L$0 = finiteAnimationSpec;
                this.label = 1;
                if (this.this$0.placementDeltaAnimation.snapTo(IntOffset.m11136boximpl(this.$totalDelta), this) == coroutine_suspended) {
                }
            } else {
                final long jM11148minusqkQi6aY = IntOffset.m11148minusqkQi6aY(((IntOffset) this.this$0.placementDeltaAnimation.getValue()).m11154unboximpl(), this.$totalDelta);
                final LazyLayoutItemAnimation lazyLayoutItemAnimation = this.this$0;
                this.L$0 = null;
                this.label = 2;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.setPlacementAnimationInProgress(false);
            this.this$0.isRunningMovingAwayAnimation = false;
            return Unit.INSTANCE;
        }
        finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
        ResultKt.throwOnFailure(obj);
        this.this$0.onLayerPropertyChanged.invoke();
        final long jM11148minusqkQi6aY2 = IntOffset.m11148minusqkQi6aY(((IntOffset) this.this$0.placementDeltaAnimation.getValue()).m11154unboximpl(), this.$totalDelta);
        final LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.this$0;
        this.L$0 = null;
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(LazyLayoutItemAnimation lazyLayoutItemAnimation, long j, Animatable animatable) {
        lazyLayoutItemAnimation.m3062setPlacementDeltagyyYBs(IntOffset.m11148minusqkQi6aY(((IntOffset) animatable.getValue()).m11154unboximpl(), j));
        lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
        return Unit.INSTANCE;
    }
}
