package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p004ui.unit.Velocity;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"androidx/compose/material3/ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", FirebaseAnalytics.Param.SOURCE, "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitUntilCollapsedScrollBehavior this$0;

    ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior) {
        this.this$0 = exitUntilCollapsedScrollBehavior;
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo2958onPreScrollOzD1aCk(long available, int source) {
        if (this.this$0.getCanScroll().invoke().booleanValue()) {
            int i = (int) (4294967295L & available);
            if (Float.intBitsToFloat(i) <= 0.0f) {
                float heightOffset = this.this$0.getState().getHeightOffset();
                this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Float.intBitsToFloat(i));
                if (heightOffset != this.this$0.getState().getHeightOffset()) {
                    return Offset.m7897copydBAh8RU$default(available, 0.0f, 0.0f, 2, null);
                }
                return Offset.INSTANCE.m7919getZeroF1C5BW0();
            }
        }
        return Offset.INSTANCE.m7919getZeroF1C5BW0();
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo2380onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m7919getZeroF1C5BW0();
        }
        TopAppBarState state = this.this$0.getState();
        int i = (int) (consumed & 4294967295L);
        state.setContentOffset(state.getContentOffset() + Float.intBitsToFloat(i));
        int i2 = (int) (available & 4294967295L);
        if (Float.intBitsToFloat(i2) < 0.0f || Float.intBitsToFloat(i) < 0.0f) {
            float heightOffset = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Float.intBitsToFloat(i));
            return Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(this.this$0.getState().getHeightOffset() - heightOffset)) & 4294967295L));
        }
        if (Float.intBitsToFloat(i2) > 0.0f) {
            float heightOffset2 = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Float.intBitsToFloat(i2));
            return Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(this.this$0.getState().getHeightOffset() - heightOffset2)) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
        }
        return Offset.INSTANCE.m7919getZeroF1C5BW0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0088, code lost:
    
        if (r13 == r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo2379onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        C1000x78ae0263 c1000x78ae0263;
        ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 exitUntilCollapsedScrollBehavior$nestedScrollConnection$1;
        long j3;
        long packedValue;
        if (continuation instanceof C1000x78ae0263) {
            c1000x78ae0263 = (C1000x78ae0263) continuation;
            if ((c1000x78ae0263.label & Integer.MIN_VALUE) != 0) {
                c1000x78ae0263.label -= Integer.MIN_VALUE;
            } else {
                c1000x78ae0263 = new C1000x78ae0263(this, continuation);
            }
        }
        C1000x78ae0263 c1000x78ae02632 = c1000x78ae0263;
        Object objMo2379onPostFlingRZ2iAVY = c1000x78ae02632.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c1000x78ae02632.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo2379onPostFlingRZ2iAVY);
            if (Velocity.m11256getYimpl(j2) > 0.0f) {
                this.this$0.getState().setContentOffset(0.0f);
            }
            c1000x78ae02632.J$0 = j2;
            c1000x78ae02632.label = 1;
            exitUntilCollapsedScrollBehavior$nestedScrollConnection$1 = this;
            objMo2379onPostFlingRZ2iAVY = super.mo2379onPostFlingRZ2iAVY(j, j2, c1000x78ae02632);
            if (objMo2379onPostFlingRZ2iAVY != coroutine_suspended) {
                j3 = j2;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            packedValue = c1000x78ae02632.J$0;
            ResultKt.throwOnFailure(objMo2379onPostFlingRZ2iAVY);
            return Velocity.m11246boximpl(Velocity.m11259plusAH228Gc(packedValue, ((Velocity) objMo2379onPostFlingRZ2iAVY).getPackedValue()));
        }
        j3 = c1000x78ae02632.J$0;
        ResultKt.throwOnFailure(objMo2379onPostFlingRZ2iAVY);
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1 = this;
        packedValue = ((Velocity) objMo2379onPostFlingRZ2iAVY).getPackedValue();
        TopAppBarState state = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getState();
        float fM11256getYimpl = Velocity.m11256getYimpl(j3);
        DecayAnimationSpec<Float> flingAnimationSpec = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> snapAnimationSpec = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
        c1000x78ae02632.J$0 = packedValue;
        c1000x78ae02632.label = 2;
        objMo2379onPostFlingRZ2iAVY = AppBarKt.settleAppBar(state, fM11256getYimpl, flingAnimationSpec, snapAnimationSpec, c1000x78ae02632);
    }
}
