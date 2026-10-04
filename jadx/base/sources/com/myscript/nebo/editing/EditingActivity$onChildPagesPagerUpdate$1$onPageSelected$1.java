package com.myscript.nebo.editing;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1", m1609f = "EditingActivity.kt", m1610i = {0, 0}, m1611l = {582}, m1612m = "invokeSuspend", m1613n = {"it", "$i$a$-let-EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1$1"}, m1614nl = {585}, m1615s = {"L$0", "I$0"}, m1616v = 2)
final class EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $positionToReset;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ EditingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1(EditingActivity editingActivity, int i, Continuation<? super EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = editingActivity;
        this.$positionToReset = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1(this.this$0, this.$positionToReset, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EditingController editingController;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PageFragment fragmentAtPosition = this.this$0.getFragmentAtPosition(this.$positionToReset);
            if (fragmentAtPosition != null && (editingController = fragmentAtPosition.getEditingController()) != null) {
                MainCoroutineDispatcher main = Dispatchers.getMain();
                EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1$1$1 editingActivity$onChildPagesPagerUpdate$1$onPageSelected$1$1$1 = new EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1$1$1(editingController, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(editingController);
                this.I$0 = 0;
                this.label = 1;
                if (BuildersKt.withContext(main, editingActivity$onChildPagesPagerUpdate$1$onPageSelected$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
