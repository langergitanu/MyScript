package com.myscript.nebo.screennavigation;

import com.myscript.nebo.screennavigation.LaunchViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: LaunchViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchScreenUIState;", "step", "Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchStep;", "hasInternetAccess", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$uiState$1", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class LaunchViewModel$uiState$1 extends SuspendLambda implements Function3<LaunchViewModel.LaunchStep, Boolean, Continuation<? super LaunchViewModel.LaunchScreenUIState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    LaunchViewModel$uiState$1(Continuation<? super LaunchViewModel$uiState$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(LaunchViewModel.LaunchStep launchStep, boolean z, Continuation<? super LaunchViewModel.LaunchScreenUIState> continuation) {
        LaunchViewModel$uiState$1 launchViewModel$uiState$1 = new LaunchViewModel$uiState$1(continuation);
        launchViewModel$uiState$1.L$0 = launchStep;
        launchViewModel$uiState$1.Z$0 = z;
        return launchViewModel$uiState$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(LaunchViewModel.LaunchStep launchStep, Boolean bool, Continuation<? super LaunchViewModel.LaunchScreenUIState> continuation) {
        return invoke(launchStep, bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LaunchViewModel.LaunchStep launchStep = (LaunchViewModel.LaunchStep) this.L$0;
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new LaunchViewModel.LaunchScreenUIState(launchStep, z);
    }
}
