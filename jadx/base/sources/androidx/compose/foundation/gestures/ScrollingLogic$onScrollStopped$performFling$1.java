package androidx.compose.foundation.gestures;

import androidx.compose.p004ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.gestures.ScrollingLogic$onScrollStopped$performFling$1", m1609f = "Scrollable.kt", m1610i = {0, 1, 1, 2, 2}, m1611l = {864, 867, 870}, m1612m = "invokeSuspend", m1613n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, m1615s = {"J$0", "J$0", "J$1", "J$0", "J$1"}, m1616v = 1)
final class ScrollingLogic$onScrollStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$onScrollStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onScrollStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onScrollStopped$performFling$1.J$0 = ((Velocity) obj).getPackedValue();
        return scrollingLogic$onScrollStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m2402invokesFctU(velocity.getPackedValue(), continuation);
    }

    /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m2402invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onScrollStopped$performFling$1) create(Velocity.m11246boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM9344dispatchPreFlingQWom1Mo;
        long j;
        long jM11258minusAH228Gc;
        Object objMo2366doFlingAnimationQWom1Mo;
        long packedValue;
        Object objM9342dispatchPostFlingRZ2iAVY;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j3 = this.J$0;
            this.J$0 = j3;
            this.label = 1;
            objM9344dispatchPreFlingQWom1Mo = this.this$0.nestedScrollDispatcher.m9344dispatchPreFlingQWom1Mo(j3, this);
            if (objM9344dispatchPreFlingQWom1Mo != coroutine_suspended) {
                j = j3;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j4 = this.J$1;
                j2 = this.J$0;
                ResultKt.throwOnFailure(obj);
                packedValue = j4;
                objM9342dispatchPostFlingRZ2iAVY = obj;
                return Velocity.m11246boximpl(Velocity.m11258minusAH228Gc(j2, Velocity.m11258minusAH228Gc(packedValue, ((Velocity) objM9342dispatchPostFlingRZ2iAVY).getPackedValue())));
            }
            long j5 = this.J$1;
            long j6 = this.J$0;
            ResultKt.throwOnFailure(obj);
            jM11258minusAH228Gc = j5;
            j = j6;
            objMo2366doFlingAnimationQWom1Mo = obj;
            packedValue = ((Velocity) objMo2366doFlingAnimationQWom1Mo).getPackedValue();
            this.J$0 = j;
            this.J$1 = packedValue;
            this.label = 3;
            objM9342dispatchPostFlingRZ2iAVY = this.this$0.nestedScrollDispatcher.m9342dispatchPostFlingRZ2iAVY(Velocity.m11258minusAH228Gc(jM11258minusAH228Gc, packedValue), packedValue, this);
            if (objM9342dispatchPostFlingRZ2iAVY != coroutine_suspended) {
                j2 = j;
                return Velocity.m11246boximpl(Velocity.m11258minusAH228Gc(j2, Velocity.m11258minusAH228Gc(packedValue, ((Velocity) objM9342dispatchPostFlingRZ2iAVY).getPackedValue())));
            }
            return coroutine_suspended;
        }
        j = this.J$0;
        ResultKt.throwOnFailure(obj);
        objM9344dispatchPreFlingQWom1Mo = obj;
        jM11258minusAH228Gc = Velocity.m11258minusAH228Gc(j, ((Velocity) objM9344dispatchPreFlingQWom1Mo).getPackedValue());
        this.J$0 = j;
        this.J$1 = jM11258minusAH228Gc;
        this.label = 2;
        objMo2366doFlingAnimationQWom1Mo = this.this$0.mo2366doFlingAnimationQWom1Mo(jM11258minusAH228Gc, this);
        if (objMo2366doFlingAnimationQWom1Mo != coroutine_suspended) {
            packedValue = ((Velocity) objMo2366doFlingAnimationQWom1Mo).getPackedValue();
            this.J$0 = j;
            this.J$1 = packedValue;
            this.label = 3;
            objM9342dispatchPostFlingRZ2iAVY = this.this$0.nestedScrollDispatcher.m9342dispatchPostFlingRZ2iAVY(Velocity.m11258minusAH228Gc(jM11258minusAH228Gc, packedValue), packedValue, this);
            if (objM9342dispatchPostFlingRZ2iAVY != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }
}
