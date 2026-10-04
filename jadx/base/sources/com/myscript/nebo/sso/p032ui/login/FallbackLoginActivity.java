package com.myscript.nebo.sso.p032ui.login;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.gms.common.internal.ImagesContract;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.api.SSOManager;
import com.myscript.nebo.sso.p032ui.WebViewActivity;
import com.myscript.nebo.sso.util.AccessTokenExtractorKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FallbackLoginActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u000e\u0010\u0012\u001a\u00020\rH\u0094@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/login/FallbackLoginActivity;", "Lcom/myscript/nebo/sso/ui/WebViewActivity;", "<init>", "()V", "loginViewModel", "Lcom/myscript/nebo/sso/ui/login/LoginViewModel;", "getLoginViewModel", "()Lcom/myscript/nebo/sso/ui/login/LoginViewModel;", "loginViewModel$delegate", "Lkotlin/Lazy;", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "origin", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getOrFetchUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interceptUrl", "", ImagesContract.URL, "Companion", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FallbackLoginActivity extends WebViewActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ORIGIN = "origin";

    /* JADX INFO: renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;
    private String origin;
    private ISSOManager ssoManager;

    @JvmStatic
    public static final Intent newIntent(Context context, String str) {
        return INSTANCE.newIntent(context, str);
    }

    public FallbackLoginActivity() {
        final FallbackLoginActivity fallbackLoginActivity = this;
        final Function0 function0 = null;
        this.loginViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.sso.ui.login.FallbackLoginActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fallbackLoginActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.sso.ui.login.FallbackLoginActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FallbackLoginActivity.loginViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.sso.ui.login.FallbackLoginActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? fallbackLoginActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getLoginViewModel() {
        return (LoginViewModel) this.loginViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory loginViewModel_delegate$lambda$0() {
        return LoginViewModel.INSTANCE.getFactory();
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.sso.api.ISSOManager.Provider");
        this.ssoManager = ((ISSOManager.Provider) application).provideSSOManager();
        Intent intent = getIntent();
        this.origin = intent != null ? intent.getStringExtra("origin") : null;
        super.onCreate(savedInstanceState);
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity
    protected Object getOrFetchUrl(Continuation<? super String> continuation) {
        return getLoginViewModel().generateLoginUrl(continuation);
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity
    protected boolean interceptUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (Intrinsics.areEqual(Uri.parse(SSOManager.REDIRECT_URI).getHost(), Uri.parse(url).getHost())) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C68491(url, null), 3, null);
            return true;
        }
        ISSOManager iSSOManager = this.ssoManager;
        if (!Intrinsics.areEqual(url, iSSOManager != null ? iSSOManager.getPrivacyPolicyRejectedUrl() : null)) {
            return false;
        }
        setResult(0);
        finish();
        return true;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.login.FallbackLoginActivity$interceptUrl$1 */
    /* JADX INFO: compiled from: FallbackLoginActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.FallbackLoginActivity$interceptUrl$1", m1609f = "FallbackLoginActivity.kt", m1610i = {}, m1611l = {40}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {45}, m1615s = {}, m1616v = 2)
    static final class C68491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68491(String str, Continuation<? super C68491> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FallbackLoginActivity.this.new C68491(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.login.FallbackLoginActivity$interceptUrl$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: FallbackLoginActivity.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.FallbackLoginActivity$interceptUrl$1$1", m1609f = "FallbackLoginActivity.kt", m1610i = {0}, m1611l = {42}, m1612m = "invokeSuspend", m1613n = {"code"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $url;
            Object L$0;
            int label;
            final /* synthetic */ FallbackLoginActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, FallbackLoginActivity fallbackLoginActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$url = str;
                this.this$0 = fallbackLoginActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$url, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String strExtractAuthCode = AccessTokenExtractorKt.extractAuthCode(this.$url);
                    if (strExtractAuthCode == null) {
                        return null;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(strExtractAuthCode);
                    this.label = 1;
                    if (this.this$0.getLoginViewModel().login(strExtractAuthCode, this.this$0.origin, this) == coroutine_suspended) {
                        return coroutine_suspended;
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$url, FallbackLoginActivity.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            FallbackLoginActivity.this.stop();
            FallbackLoginActivity.this.setResult(-1);
            FallbackLoginActivity.this.finish();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: FallbackLoginActivity.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/login/FallbackLoginActivity$Companion;", "", "<init>", "()V", "EXTRA_ORIGIN", "", "newIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "origin", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Intent newIntent(Context context, String origin) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) FallbackLoginActivity.class);
            if (origin != null) {
                intent.putExtra("origin", origin);
            }
            return intent;
        }
    }
}
