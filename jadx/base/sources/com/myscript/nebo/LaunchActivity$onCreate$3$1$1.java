package com.myscript.nebo;

import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.PopUpToBuilder;
import com.myscript.nebo.screennavigation.LaunchViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LaunchActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.LaunchActivity$onCreate$3$1$1", m1609f = "LaunchActivity.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class LaunchActivity$onCreate$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ String $route;
    final /* synthetic */ State<LaunchViewModel.LaunchScreenUIState> $uiState$delegate;
    int label;
    final /* synthetic */ LaunchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LaunchActivity$onCreate$3$1$1(NavHostController navHostController, String str, LaunchActivity launchActivity, State<LaunchViewModel.LaunchScreenUIState> state, Continuation<? super LaunchActivity$onCreate$3$1$1> continuation) {
        super(2, continuation);
        this.$navController = navHostController;
        this.$route = str;
        this.this$0 = launchActivity;
        this.$uiState$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LaunchActivity$onCreate$3$1$1(this.$navController, this.$route, this.this$0, this.$uiState$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LaunchActivity$onCreate$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final NavHostController navHostController = this.$navController;
        navHostController.navigate(this.$route, new Function1() { // from class: com.myscript.nebo.LaunchActivity$onCreate$3$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return LaunchActivity$onCreate$3$1$1.invokeSuspend$lambda$0(navHostController, (NavOptionsBuilder) obj2);
            }
        });
        if (LaunchActivity.onCreate$lambda$2$0(this.$uiState$delegate).getStep() == LaunchViewModel.LaunchStep.App) {
            this.this$0.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(NavHostController navHostController, NavOptionsBuilder navOptionsBuilder) {
        navOptionsBuilder.popUpTo(navHostController.getGraph().getId(), new Function1() { // from class: com.myscript.nebo.LaunchActivity$onCreate$3$1$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LaunchActivity$onCreate$3$1$1.invokeSuspend$lambda$0$0((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(PopUpToBuilder popUpToBuilder) {
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }
}
