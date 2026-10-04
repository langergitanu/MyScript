package com.myscript.nebo.discoverability.p024ui.compose;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.runtime.MutableIntState;
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
@DebugMetadata(m1608c = "com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$FloatingTooltip$1$1$1", m1609f = "DiscoverabilityTooltip.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class DiscoverabilityTooltipKt$FloatingTooltip$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Rect> $tooltipBounds$delegate;
    final /* synthetic */ MutableState<Offset> $tooltipPosition$delegate;
    final /* synthetic */ MutableIntState $updateCount$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiscoverabilityTooltipKt$FloatingTooltip$1$1$1(MutableState<Rect> mutableState, MutableState<Offset> mutableState2, MutableIntState mutableIntState, Continuation<? super DiscoverabilityTooltipKt$FloatingTooltip$1$1$1> continuation) {
        super(2, continuation);
        this.$tooltipBounds$delegate = mutableState;
        this.$tooltipPosition$delegate = mutableState2;
        this.$updateCount$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiscoverabilityTooltipKt$FloatingTooltip$1$1$1(this.$tooltipBounds$delegate, this.$tooltipPosition$delegate, this.$updateCount$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiscoverabilityTooltipKt$FloatingTooltip$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$tooltipBounds$delegate.setValue(null);
        this.$tooltipPosition$delegate.setValue(null);
        this.$updateCount$delegate.setIntValue(0);
        return Unit.INSTANCE;
    }
}
