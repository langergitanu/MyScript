package com.myscript.nebo.sso.p032ui.login;

import android.widget.Toast;
import com.myscript.nebo.common.C6183R;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LoginActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.LoginActivity$onCreate$1$1", m1609f = "LoginActivity.kt", m1610i = {0, 0, 0}, m1611l = {31}, m1612m = "invokeSuspend", m1613n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-LoginActivity$onCreate$1$1$1"}, m1614nl = {32}, m1615s = {"L$0", "L$3", "I$0"}, m1616v = 2)
final class LoginActivity$onCreate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $compatibleBrowserPackage;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ LoginActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoginActivity$onCreate$1$1(LoginActivity loginActivity, String str, Continuation<? super LoginActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = loginActivity;
        this.$compatibleBrowserPackage = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LoginActivity$onCreate$1$1 loginActivity$onCreate$1$1 = new LoginActivity$onCreate$1$1(this.this$0, this.$compatibleBrowserPackage, continuation);
        loginActivity$onCreate$1$1.L$0 = obj;
        return loginActivity$onCreate$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoginActivity$onCreate$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM14499constructorimpl;
        LoginActivity loginActivity;
        String str;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginActivity loginActivity2 = this.this$0;
                String str2 = this.$compatibleBrowserPackage;
                Result.Companion companion = Result.INSTANCE;
                LoginViewModel loginViewModel = loginActivity2.getLoginViewModel();
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = loginActivity2;
                this.L$2 = str2;
                this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.I$0 = 0;
                this.label = 1;
                Object objGenerateLoginUrl = loginViewModel.generateLoginUrl(this);
                if (objGenerateLoginUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                loginActivity = loginActivity2;
                obj = objGenerateLoginUrl;
                str = str2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$2;
                loginActivity = (LoginActivity) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            loginActivity.launchLoginTab((String) obj, str);
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        LoginActivity loginActivity3 = this.this$0;
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            if (thM14502exceptionOrNullimpl instanceof UnknownHostException) {
                Toast.makeText(loginActivity3, loginActivity3.getString(C6183R.string.cannot_connect_message_sso), 1).show();
            }
            loginActivity3.finish();
        }
        return Unit.INSTANCE;
    }
}
