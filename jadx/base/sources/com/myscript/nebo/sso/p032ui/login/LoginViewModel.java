package com.myscript.nebo.sso.p032ui.login;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.myscript.android.utils.SingleLiveEvent;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.sso.api.ISSOManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: LoginViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "<init>", "(Lcom/myscript/nebo/sso/api/ISSOManager;)V", "openLoginTab", "Lcom/myscript/android/utils/SingleLiveEvent;", "", "getOpenLoginTab", "()Lcom/myscript/android/utils/SingleLiveEvent;", "generateLoginUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRedirectIntent", "", "intent", "Landroid/content/Intent;", "origin", "(Landroid/content/Intent;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "code", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoginViewModel extends ViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ViewModelProvider.Factory Factory;
    private final SingleLiveEvent<String> openLoginTab;
    private final ISSOManager ssoManager;

    public LoginViewModel(ISSOManager ssoManager) {
        Intrinsics.checkNotNullParameter(ssoManager, "ssoManager");
        this.ssoManager = ssoManager;
        SingleLiveEvent<String> singleLiveEvent = new SingleLiveEvent<>();
        this.openLoginTab = singleLiveEvent;
        singleLiveEvent.setValue("");
    }

    public final SingleLiveEvent<String> getOpenLoginTab() {
        return this.openLoginTab;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.login.LoginViewModel$generateLoginUrl$2 */
    /* JADX INFO: compiled from: LoginViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.LoginViewModel$generateLoginUrl$2", m1609f = "LoginViewModel.kt", m1610i = {}, m1611l = {25}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C68562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        int label;

        C68562(Continuation<? super C68562> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new C68562(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C68562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objBuildAuthorizeUrl = LoginViewModel.this.ssoManager.buildAuthorizeUrl(this);
            return objBuildAuthorizeUrl == coroutine_suspended ? coroutine_suspended : objBuildAuthorizeUrl;
        }
    }

    public final Object generateLoginUrl(Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C68562(null), continuation);
    }

    public final Object handleRedirectIntent(Intent intent, String str, Continuation<? super Unit> continuation) {
        String queryParameter;
        Uri data = intent.getData();
        if (data == null || (queryParameter = data.getQueryParameter("code")) == null) {
            return Unit.INSTANCE;
        }
        Object objLogin = login(queryParameter, str, continuation);
        return objLogin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLogin : Unit.INSTANCE;
    }

    public final Object login(String str, String str2, Continuation<? super Unit> continuation) {
        Object objLogin = this.ssoManager.login(str, str2, continuation);
        return objLogin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLogin : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: LoginViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/login/LoginViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return LoginViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        ISSOManager.Provider provider = componentCallbacks2RequireApplication instanceof ISSOManager.Provider ? (ISSOManager.Provider) componentCallbacks2RequireApplication : null;
        ISSOManager iSSOManagerProvideSSOManager = provider != null ? provider.provideSSOManager() : null;
        if (iSSOManagerProvideSSOManager == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return new LoginViewModel(iSSOManagerProvideSSOManager);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function1() { // from class: com.myscript.nebo.sso.ui.login.LoginViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LoginViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
