package com.myscript.nebo.grid;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "", "oemState", "Lcom/myscript/nebo/grid/OEMOfferDialogState;", "paywallOrigin", "", "showMigration", "renewalOfferVisible", "billingUnavailableVisible"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$isModalSuppressingTooltip$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class MainViewModel$isModalSuppressingTooltip$1 extends SuspendLambda implements Function6<OEMOfferDialogState, String, Boolean, Boolean, Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    /* synthetic */ boolean Z$2;
    int label;

    MainViewModel$isModalSuppressingTooltip$1(Continuation<? super MainViewModel$isModalSuppressingTooltip$1> continuation) {
        super(6, continuation);
    }

    public final Object invoke(OEMOfferDialogState oEMOfferDialogState, String str, boolean z, boolean z2, boolean z3, Continuation<? super Boolean> continuation) {
        MainViewModel$isModalSuppressingTooltip$1 mainViewModel$isModalSuppressingTooltip$1 = new MainViewModel$isModalSuppressingTooltip$1(continuation);
        mainViewModel$isModalSuppressingTooltip$1.L$0 = oEMOfferDialogState;
        mainViewModel$isModalSuppressingTooltip$1.L$1 = str;
        mainViewModel$isModalSuppressingTooltip$1.Z$0 = z;
        mainViewModel$isModalSuppressingTooltip$1.Z$1 = z2;
        mainViewModel$isModalSuppressingTooltip$1.Z$2 = z3;
        return mainViewModel$isModalSuppressingTooltip$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object invoke(OEMOfferDialogState oEMOfferDialogState, String str, Boolean bool, Boolean bool2, Boolean bool3, Continuation<? super Boolean> continuation) {
        return invoke(oEMOfferDialogState, str, bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OEMOfferDialogState oEMOfferDialogState = (OEMOfferDialogState) this.L$0;
        String str = (String) this.L$1;
        boolean z = this.Z$0;
        boolean z2 = this.Z$1;
        boolean z3 = this.Z$2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        boolean z4 = true;
        if ((oEMOfferDialogState == null || !oEMOfferDialogState.getShow()) && str == null && !z && !z2 && !z3) {
            z4 = false;
        }
        return Boxing.boxBoolean(z4);
    }
}
