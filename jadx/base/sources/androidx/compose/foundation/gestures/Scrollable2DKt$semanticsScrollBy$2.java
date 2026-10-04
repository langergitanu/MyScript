package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Scrollable2D.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$2", m1609f = "Scrollable2D.kt", m1610i = {}, m1611l = {515}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
final class Scrollable2DKt$semanticsScrollBy$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $offset;
    final /* synthetic */ Ref.LongRef $previousValue;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Scrollable2DKt$semanticsScrollBy$2(long j, Ref.LongRef longRef, Continuation<? super Scrollable2DKt$semanticsScrollBy$2> continuation) {
        super(2, continuation);
        this.$offset = j;
        this.$previousValue = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Scrollable2DKt$semanticsScrollBy$2 scrollable2DKt$semanticsScrollBy$2 = new Scrollable2DKt$semanticsScrollBy$2(this.$offset, this.$previousValue, continuation);
        scrollable2DKt$semanticsScrollBy$2.L$0 = obj;
        return scrollable2DKt$semanticsScrollBy$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
        return ((Scrollable2DKt$semanticsScrollBy$2) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
            TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.INSTANCE);
            Offset offsetM7892boximpl = Offset.m7892boximpl(Offset.INSTANCE.m7919getZeroF1C5BW0());
            Offset offsetM7892boximpl2 = Offset.m7892boximpl(this.$offset);
            final Ref.LongRef longRef = this.$previousValue;
            this.label = 1;
            if (SuspendAnimationKt.animate$default(vectorConverter, offsetM7892boximpl, offsetM7892boximpl2, null, null, new Function2() { // from class: androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return Scrollable2DKt$semanticsScrollBy$2.invokeSuspend$lambda$0(longRef, nestedScrollScope, (Offset) obj2, (Offset) obj3);
                }
            }, this, 24, null) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Ref.LongRef longRef, NestedScrollScope nestedScrollScope, Offset offset, Offset offset2) {
        longRef.element = Offset.m7908plusMKHz9U(longRef.element, nestedScrollScope.mo2335scrollByOzD1aCk(Offset.m7907minusMKHz9U(offset.m7913unboximpl(), longRef.element), NestedScrollSource.INSTANCE.m9361getUserInputWNlRxjI()));
        return Unit.INSTANCE;
    }
}
