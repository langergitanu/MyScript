package com.myscript.nebo.editing;

import com.myscript.nebo.analytics.firebase.LoginOrigin;
import com.myscript.nebo.sso.api.ISSOManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "token", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.EditingActivity$onCreate$26$1$3$1", m1609f = "EditingActivity.kt", m1610i = {0}, m1611l = {1293}, m1612m = "invokeSuspend", m1613n = {"token"}, m1614nl = {1294}, m1615s = {"L$0"}, m1616v = 2)
final class EditingActivity$onCreate$26$1$3$1 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ISSOManager $ssoManager;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EditingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditingActivity$onCreate$26$1$3$1(ISSOManager iSSOManager, EditingActivity editingActivity, Continuation<? super EditingActivity$onCreate$26$1$3$1> continuation) {
        super(2, continuation);
        this.$ssoManager = iSSOManager;
        this.this$0 = editingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EditingActivity$onCreate$26$1$3$1 editingActivity$onCreate$26$1$3$1 = new EditingActivity$onCreate$26$1$3$1(this.$ssoManager, this.this$0, continuation);
        editingActivity$onCreate$26$1$3$1.L$0 = obj;
        return editingActivity$onCreate$26$1$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Boolean> continuation) {
        return ((EditingActivity$onCreate$26$1$3$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.label = 1;
            obj = this.$ssoManager.startNativeLoginWithGoogle(str, LoginOrigin.AiButton.getValue(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (zBooleanValue) {
            this.this$0.getAiContainerViewModel().onSignInSuccess();
        }
        return Boxing.boxBoolean(zBooleanValue);
    }
}
