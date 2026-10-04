package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: LazyLayoutPager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, m1599d2 = {"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "<init>", "(Landroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class PagerWrapperFlingBehavior implements FlingBehavior {
    private final TargetedFlingBehavior originalFlingBehavior;
    private final PagerState pagerState;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1 */
    /* JADX INFO: compiled from: LazyLayoutPager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.pager.PagerWrapperFlingBehavior", m1609f = "LazyLayoutPager.kt", m1610i = {}, m1611l = {488}, m1612m = "performFling", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C06261 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06261(Continuation<? super C06261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerWrapperFlingBehavior.this.performFling(null, 0.0f, this);
        }
    }

    public PagerWrapperFlingBehavior(TargetedFlingBehavior targetedFlingBehavior, PagerState pagerState) {
        this.originalFlingBehavior = targetedFlingBehavior;
        this.pagerState = pagerState;
    }

    public final TargetedFlingBehavior getOriginalFlingBehavior() {
        return this.originalFlingBehavior;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(final ScrollScope scrollScope, float f, Continuation<? super Float> continuation) {
        C06261 c06261;
        if (continuation instanceof C06261) {
            c06261 = (C06261) continuation;
            if ((c06261.label & Integer.MIN_VALUE) != 0) {
                c06261.label -= Integer.MIN_VALUE;
            } else {
                c06261 = new C06261(continuation);
            }
        }
        Object objPerformFling = c06261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06261.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objPerformFling);
            TargetedFlingBehavior targetedFlingBehavior = this.originalFlingBehavior;
            Function1<? super Float, Unit> function1 = new Function1() { // from class: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PagerWrapperFlingBehavior.performFling$lambda$0$0(this.f$0, scrollScope, ((Float) obj).floatValue());
                }
            };
            c06261.label = 1;
            objPerformFling = targetedFlingBehavior.performFling(scrollScope, f, function1, c06261);
            if (objPerformFling == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objPerformFling);
        }
        float fFloatValue = ((Number) objPerformFling).floatValue();
        if (this.pagerState.getCurrentPageOffsetFraction() != 0.0f && Math.abs(this.pagerState.getCurrentPageOffsetFraction()) < 0.001d) {
            PagerState pagerState = this.pagerState;
            PagerState.requestScrollToPage$default(pagerState, pagerState.getCurrentPage(), 0.0f, 2, null);
        } else {
            Boxing.boxFloat(this.pagerState.getCurrentPageOffsetFraction());
        }
        return Boxing.boxFloat(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit performFling$lambda$0$0(PagerWrapperFlingBehavior pagerWrapperFlingBehavior, ScrollScope scrollScope, float f) {
        pagerWrapperFlingBehavior.pagerState.updateTargetPage(scrollScope, MathKt.roundToInt(pagerWrapperFlingBehavior.pagerState.getPageSizeWithSpacing$foundation() != 0 ? f / pagerWrapperFlingBehavior.pagerState.getPageSizeWithSpacing$foundation() : 0.0f) + pagerWrapperFlingBehavior.pagerState.getCurrentPage());
        return Unit.INSTANCE;
    }
}
