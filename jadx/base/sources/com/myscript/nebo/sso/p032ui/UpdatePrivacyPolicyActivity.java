package com.myscript.nebo.sso.p032ui;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.gms.common.internal.ImagesContract;
import com.myscript.nebo.sso.api.ISSOManager;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UpdatePrivacyPolicyActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\n\u001a\u00020\u000bH\u0094@¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/UpdatePrivacyPolicyActivity;", "Lcom/myscript/nebo/sso/ui/WebViewActivity;", "<init>", "()V", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getOrFetchUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interceptUrl", "", ImagesContract.URL, "Companion", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UpdatePrivacyPolicyActivity extends WebViewActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int RESULT_SIGNOUT = 10;
    private ISSOManager ssoManager;

    @JvmStatic
    public static final Intent newIntent(Context context) {
        return INSTANCE.newIntent(context);
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.sso.api.ISSOManager.Provider");
        this.ssoManager = ((ISSOManager.Provider) application).provideSSOManager();
        super.onCreate(savedInstanceState);
        setChromeVisible(false);
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity
    protected Object getOrFetchUrl(Continuation<? super String> continuation) {
        ISSOManager iSSOManager = this.ssoManager;
        if (iSSOManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
            iSSOManager = null;
        }
        return iSSOManager.getPrivacyPolicyUpdateUrl();
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity
    protected boolean interceptUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ISSOManager iSSOManager = this.ssoManager;
        if (iSSOManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
            iSSOManager = null;
        }
        if (Intrinsics.areEqual(url, iSSOManager.getPrivacyPolicyAcceptedUrl())) {
            stop();
            setResult(-1);
            finish();
            return true;
        }
        ISSOManager iSSOManager2 = this.ssoManager;
        if (iSSOManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
            iSSOManager2 = null;
        }
        if (!Intrinsics.areEqual(url, iSSOManager2.getPrivacyPolicyRejectedUrl())) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C68471(null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.UpdatePrivacyPolicyActivity$interceptUrl$1 */
    /* JADX INFO: compiled from: UpdatePrivacyPolicyActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.UpdatePrivacyPolicyActivity$interceptUrl$1", m1609f = "UpdatePrivacyPolicyActivity.kt", m1610i = {}, m1611l = {37}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {38}, m1615s = {}, m1616v = 2)
    static final class C68471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C68471(Continuation<? super C68471> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UpdatePrivacyPolicyActivity.this.new C68471(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UpdatePrivacyPolicyActivity.this.stop();
                ISSOManager iSSOManager = UpdatePrivacyPolicyActivity.this.ssoManager;
                if (iSSOManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
                    iSSOManager = null;
                }
                this.label = 1;
                if (iSSOManager.logout(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            UpdatePrivacyPolicyActivity.this.setResult(10);
            UpdatePrivacyPolicyActivity.this.finish();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: UpdatePrivacyPolicyActivity.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/UpdatePrivacyPolicyActivity$Companion;", "", "<init>", "()V", "RESULT_SIGNOUT", "", "newIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Intent newIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) UpdatePrivacyPolicyActivity.class);
        }
    }
}
