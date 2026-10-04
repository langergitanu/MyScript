package com.myscript.nebo.grid;

import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "tooltip", "suppressed", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$discoveryTooltip$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class MainViewModel$discoveryTooltip$1 extends SuspendLambda implements Function3<TooltipUIState, Boolean, Continuation<? super TooltipUIState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    MainViewModel$discoveryTooltip$1(Continuation<? super MainViewModel$discoveryTooltip$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TooltipUIState tooltipUIState, boolean z, Continuation<? super TooltipUIState> continuation) {
        MainViewModel$discoveryTooltip$1 mainViewModel$discoveryTooltip$1 = new MainViewModel$discoveryTooltip$1(continuation);
        mainViewModel$discoveryTooltip$1.L$0 = tooltipUIState;
        mainViewModel$discoveryTooltip$1.Z$0 = z;
        return mainViewModel$discoveryTooltip$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(TooltipUIState tooltipUIState, Boolean bool, Continuation<? super TooltipUIState> continuation) {
        return invoke(tooltipUIState, bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TooltipUIState tooltipUIState = (TooltipUIState) this.L$0;
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (z) {
            return null;
        }
        return tooltipUIState;
    }
}
