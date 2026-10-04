package com.myscript.nebo.screennavigation;

import android.app.Application;
import android.content.ComponentCallbacks2;
import androidx.media3.common.MimeTypes;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.onboarding.OnboardingUtilsKt;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.whatsnew.ApplicationState;
import com.myscript.nebo.whatsnew.IApplicationStateProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: LaunchState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0013\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/screennavigation/LaunchState;", "Lcom/myscript/nebo/screennavigation/ILaunchStateProvider;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "versionName", "", "getVersionName", "()Ljava/lang/String;", "requiresPLSMigration", "", "getRequiresPLSMigration", "()Z", "isOnBoardingNeeded", "setOnBoardingNotNeeded", "", "isEnterpriseMandatoryLoginNeeded", "isLoggedIn", "hasSubscribed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applicationState", "Lcom/myscript/nebo/whatsnew/ApplicationState;", "getApplicationState", "()Lcom/myscript/nebo/whatsnew/ApplicationState;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LaunchState implements ILaunchStateProvider {
    public static final int $stable = 8;
    private final Application application;

    public LaunchState(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
    }

    @Override // com.myscript.nebo.screennavigation.ILaunchStateProvider
    public String getVersionName() {
        return CommonUtils.getVersionName(this.application);
    }

    @Override // com.myscript.nebo.screennavigation.ILaunchStateProvider
    public boolean getRequiresPLSMigration() {
        return getApplicationState().requiresPLSMigration();
    }

    @Override // com.myscript.nebo.screennavigation.ILaunchStateProvider
    public boolean isOnBoardingNeeded() {
        return OnboardingUtilsKt.isOnBoardingNeededAtStartup(this.application);
    }

    @Override // com.myscript.nebo.screennavigation.ILaunchStateProvider
    public void setOnBoardingNotNeeded() {
        OnboardingUtilsKt.setOnBoardingNeededAtStartup(this.application, false);
    }

    @Override // com.myscript.nebo.screennavigation.ILaunchStateProvider
    public boolean isEnterpriseMandatoryLoginNeeded() {
        return this.application.getResources().getBoolean(C6079R.bool.mandatory_login);
    }

    @Override // com.myscript.nebo.screennavigation.ILaunchStateProvider
    public boolean isLoggedIn() {
        UserData userDataProvideUserData;
        ComponentCallbacks2 componentCallbacks2 = this.application;
        UserData.Provider provider = componentCallbacks2 instanceof UserData.Provider ? (UserData.Provider) componentCallbacks2 : null;
        if (provider == null || (userDataProvideUserData = provider.provideUserData()) == null) {
            return false;
        }
        return userDataProvideUserData.hasUser();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchState$hasSubscribed$2 */
    /* JADX INFO: compiled from: LaunchState.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchState$hasSubscribed$2", m1609f = "LaunchState.kt", m1610i = {}, m1611l = {42}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C67522 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C67522(Continuation<? super C67522> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchState.this.new C67522(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C67522) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            ISubscriptionRepository iSubscriptionRepositoryProvideSubscriptionRepository;
            StateFlow<Boolean> hasSubscribed;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ComponentCallbacks2 componentCallbacks2 = LaunchState.this.application;
                ISubscriptionRepository.Provider provider = componentCallbacks2 instanceof ISubscriptionRepository.Provider ? (ISubscriptionRepository.Provider) componentCallbacks2 : null;
                if (provider == null || (iSubscriptionRepositoryProvideSubscriptionRepository = provider.provideSubscriptionRepository()) == null || (hasSubscribed = iSubscriptionRepositoryProvideSubscriptionRepository.getHasSubscribed()) == null) {
                    zBooleanValue = false;
                    return Boxing.boxBoolean(zBooleanValue);
                }
                this.label = 1;
                obj = FlowKt.first(hasSubscribed, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            zBooleanValue = ((Boolean) obj).booleanValue();
            return Boxing.boxBoolean(zBooleanValue);
        }
    }

    @Override // com.myscript.nebo.screennavigation.ILaunchStateProvider
    public Object hasSubscribed(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C67522(null), continuation);
    }

    @Override // com.myscript.nebo.screennavigation.ILaunchStateProvider
    public ApplicationState getApplicationState() {
        ComponentCallbacks2 componentCallbacks2 = this.application;
        Intrinsics.checkNotNull(componentCallbacks2, "null cannot be cast to non-null type com.myscript.nebo.whatsnew.IApplicationStateProvider");
        return ((IApplicationStateProvider) componentCallbacks2).provideApplicationState();
    }
}
