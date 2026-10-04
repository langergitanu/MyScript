package com.myscript.nebo.discoverability.p024ui.compose;

import android.graphics.Point;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DiscoverabilityTooltip.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$FloatingTooltip$1$4$1", m1609f = "DiscoverabilityTooltip.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class DiscoverabilityTooltipKt$FloatingTooltip$1$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<SpeechBubbleShape> $bubbleShape$delegate;
    final /* synthetic */ float $caretSize;
    final /* synthetic */ Point $targetPoint;
    final /* synthetic */ MutableState<Rect> $tooltipBounds$delegate;
    final /* synthetic */ MutableState<Offset> $tooltipPosition$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiscoverabilityTooltipKt$FloatingTooltip$1$4$1(MutableState<Rect> mutableState, MutableState<Offset> mutableState2, Point point, float f, MutableState<SpeechBubbleShape> mutableState3, Continuation<? super DiscoverabilityTooltipKt$FloatingTooltip$1$4$1> continuation) {
        super(2, continuation);
        this.$tooltipBounds$delegate = mutableState;
        this.$tooltipPosition$delegate = mutableState2;
        this.$targetPoint = point;
        this.$caretSize = f;
        this.$bubbleShape$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiscoverabilityTooltipKt$FloatingTooltip$1$4$1(this.$tooltipBounds$delegate, this.$tooltipPosition$delegate, this.$targetPoint, this.$caretSize, this.$bubbleShape$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiscoverabilityTooltipKt$FloatingTooltip$1$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Rect rectFloatingTooltip$lambda$0$6 = DiscoverabilityTooltipKt.FloatingTooltip$lambda$0$6(this.$tooltipBounds$delegate);
            if (rectFloatingTooltip$lambda$0$6 != null) {
                MutableState<Offset> mutableState = this.$tooltipPosition$delegate;
                Point point = this.$targetPoint;
                float f = this.$caretSize;
                MutableState<SpeechBubbleShape> mutableState2 = this.$bubbleShape$delegate;
                Offset offsetFloatingTooltip$lambda$0$9 = DiscoverabilityTooltipKt.FloatingTooltip$lambda$0$9(mutableState);
                if (offsetFloatingTooltip$lambda$0$9 != null) {
                    long jM7913unboximpl = offsetFloatingTooltip$lambda$0$9.m7913unboximpl();
                    mutableState2.setValue(new SpeechBubbleShape(0.0f, f, new Point((int) Float.intBitsToFloat((int) (rectFloatingTooltip$lambda$0$6.m7933getCenterF1C5BW0() >> 32)), (int) Float.intBitsToFloat((int) (4294967295L & rectFloatingTooltip$lambda$0$6.m7933getCenterF1C5BW0()))), point != null ? new Point((int) (point.x - Float.intBitsToFloat((int) (jM7913unboximpl >> 32))), (int) (point.y - Float.intBitsToFloat((int) (jM7913unboximpl & 4294967295L)))) : null, 1, null));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
