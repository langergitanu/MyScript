package com.myscript.nebo.sso.p032ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LoginActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0014J\b\u0010\u0013\u001a\u00020\u000eH\u0014J\u001a\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/login/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "loginViewModel", "Lcom/myscript/nebo/sso/ui/login/LoginViewModel;", "getLoginViewModel", "()Lcom/myscript/nebo/sso/ui/login/LoginViewModel;", "loginViewModel$delegate", "Lkotlin/Lazy;", "loginActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onDestroy", "launchLoginTab", ImagesContract.URL, "", "browserPackageName", "Companion", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoginActivity extends AppCompatActivity {
    private static final String COMPATIBLE_BROWSER_PACKAGE_NAME = "COMPATIBLE_BROWSER_PACKAGE_NAME";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ActivityResultLauncher<Intent> loginActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.sso.ui.login.LoginActivity$$ExternalSyntheticLambda4
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
        }
    });

    /* JADX INFO: renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;

    @JvmStatic
    public static final Intent newIntent(Context context, String str) {
        return INSTANCE.newIntent(context, str);
    }

    public LoginActivity() {
        final LoginActivity loginActivity = this;
        final Function0 function0 = null;
        this.loginViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.sso.ui.login.LoginActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return loginActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.sso.ui.login.LoginActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoginActivity.loginViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.sso.ui.login.LoginActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? loginActivity.getDefaultViewModelCreationExtras() : creationExtras;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final String stringExtra = intent != null ? intent.getStringExtra(COMPATIBLE_BROWSER_PACKAGE_NAME) : null;
        if (stringExtra == null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C68542(null), 3, null);
        } else {
            getLoginViewModel().getOpenLoginTab().observe(this, new LoginActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.sso.ui.login.LoginActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LoginActivity.onCreate$lambda$0(this.f$0, stringExtra, (String) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(LoginActivity loginActivity, String str, String str2) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(loginActivity), null, null, new LoginActivity$onCreate$1$1(loginActivity, str, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.login.LoginActivity$onCreate$2 */
    /* JADX INFO: compiled from: LoginActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.LoginActivity$onCreate$2", m1609f = "LoginActivity.kt", m1610i = {}, m1611l = {43}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {44}, m1615s = {}, m1616v = 2)
    static final class C68542 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C68542(Continuation<? super C68542> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginActivity.this.new C68542(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68542) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginViewModel loginViewModel = LoginActivity.this.getLoginViewModel();
                Intent intent = LoginActivity.this.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                this.label = 1;
                if (loginViewModel.handleRedirectIntent(intent, null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LoginActivity.this.finish();
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C68551(intent, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.login.LoginActivity$onNewIntent$1 */
    /* JADX INFO: compiled from: LoginActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.LoginActivity$onNewIntent$1", m1609f = "LoginActivity.kt", m1610i = {}, m1611l = {53}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE}, m1615s = {}, m1616v = 2)
    static final class C68551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $intent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68551(Intent intent, Continuation<? super C68551> continuation) {
            super(2, continuation);
            this.$intent = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginActivity.this.new C68551(this.$intent, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LoginActivity.this.getLoginViewModel().handleRedirectIntent(this.$intent, null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LoginActivity.this.finish();
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.loginActivityLauncher = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchLoginTab(String url, String browserPackageName) {
        if (url != null) {
            LoginActivityHelperKt.launchTab(this, new Function0() { // from class: com.myscript.nebo.sso.ui.login.LoginActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.loginActivityLauncher;
                }
            }, url, browserPackageName, new Function0() { // from class: com.myscript.nebo.sso.ui.login.LoginActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LoginActivity.launchLoginTab$lambda$1(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit launchLoginTab$lambda$1(LoginActivity loginActivity) {
        loginActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: LoginActivity.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/login/LoginActivity$Companion;", "", "<init>", "()V", LoginActivity.COMPATIBLE_BROWSER_PACKAGE_NAME, "", "newIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "compatibleBrowserPackage", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Intent newIntent(Context context, String compatibleBrowserPackage) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(compatibleBrowserPackage, "compatibleBrowserPackage");
            Intent intent = new Intent(context, (Class<?>) LoginActivity.class);
            intent.putExtra(LoginActivity.COMPATIBLE_BROWSER_PACKAGE_NAME, compatibleBrowserPackage);
            return intent;
        }
    }
}
