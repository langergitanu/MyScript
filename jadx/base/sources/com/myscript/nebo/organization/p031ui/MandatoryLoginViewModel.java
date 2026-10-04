package com.myscript.nebo.organization.p031ui;

import android.content.ComponentCallbacks2;
import androidx.compose.p004ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.account.backend.Backend;
import com.myscript.nebo.common.IClock;
import com.myscript.nebo.organization.MandatoryLoginRepository;
import com.myscript.nebo.organization.MandatoryLoginRepositoryImpl;
import com.myscript.nebo.organization.p031ui.State;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import com.yalantis.ucrop.UCrop;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/organization/ui/MandatoryLoginViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/myscript/nebo/organization/MandatoryLoginRepository;", "clock", "Lcom/myscript/nebo/common/IClock;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "workDispatcher", "<init>", "(Lcom/myscript/nebo/organization/MandatoryLoginRepository;Lcom/myscript/nebo/common/IClock;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/organization/ui/State;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "getAuthorizeUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "", "authorizationCode", "loadOrganizationState", "Companion", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MandatoryLoginViewModel extends ViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ViewModelProvider.Factory Factory;
    private static final long ONE_MONTH_MS = 2592000000L;
    private final MutableLiveData<State> _state;
    private final IClock clock;
    private final CoroutineDispatcher mainDispatcher;
    private final MandatoryLoginRepository repository;
    private final CoroutineDispatcher workDispatcher;

    /* JADX INFO: renamed from: com.myscript.nebo.organization.ui.MandatoryLoginViewModel$loadOrganizationState$1 */
    /* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.organization.ui.MandatoryLoginViewModel", m1609f = "MandatoryLoginViewModel.kt", m1610i = {}, m1611l = {68}, m1612m = "loadOrganizationState", m1613n = {}, m1614nl = {72}, m1615s = {}, m1616v = 2)
    static final class C66751 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C66751(Continuation<? super C66751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MandatoryLoginViewModel.this.loadOrganizationState(this);
        }
    }

    public MandatoryLoginViewModel(MandatoryLoginRepository repository, IClock clock, CoroutineDispatcher mainDispatcher, CoroutineDispatcher workDispatcher) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        this.repository = repository;
        this.clock = clock;
        this.mainDispatcher = mainDispatcher;
        this.workDispatcher = workDispatcher;
        this._state = new MutableLiveData<>(new State.Login(false, 1, null));
        if (repository.hasUser()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), mainDispatcher, null, new C66741(null), 2, null);
        }
    }

    public /* synthetic */ MandatoryLoginViewModel(MandatoryLoginRepository mandatoryLoginRepository, IClock iClock, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mandatoryLoginRepository, iClock, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 8) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    public final LiveData<State> getState() {
        return this._state;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.organization.ui.MandatoryLoginViewModel$1 */
    /* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.organization.ui.MandatoryLoginViewModel$1", m1609f = "MandatoryLoginViewModel.kt", m1610i = {}, m1611l = {43}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {44}, m1615s = {}, m1616v = 2)
    static final class C66741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C66741(Continuation<? super C66741> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MandatoryLoginViewModel.this.new C66741(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MandatoryLoginViewModel.this._state.setValue(State.Loading.INSTANCE);
                MutableLiveData mutableLiveData2 = MandatoryLoginViewModel.this._state;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objLoadOrganizationState = MandatoryLoginViewModel.this.loadOrganizationState(this);
                if (objLoadOrganizationState == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                obj = objLoadOrganizationState;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            mutableLiveData.setValue(obj);
            return Unit.INSTANCE;
        }
    }

    public final Object getAuthorizeUrl(Continuation<? super String> continuation) {
        return this.repository.getAuthorizeUrl(continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.organization.ui.MandatoryLoginViewModel$login$1 */
    /* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.organization.ui.MandatoryLoginViewModel$login$1", m1609f = "MandatoryLoginViewModel.kt", m1610i = {1}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 60}, m1612m = "invokeSuspend", m1613n = {FirebaseAnalytics.Param.SUCCESS}, m1614nl = {59, RectListKt.BitOffsetForGesturable}, m1615s = {"Z$0"}, m1616v = 2)
    static final class C66771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $authorizationCode;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66771(String str, Continuation<? super C66771> continuation) {
            super(2, continuation);
            this.$authorizationCode = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MandatoryLoginViewModel.this.new C66771(this.$authorizationCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object obj2;
            MutableLiveData mutableLiveData2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MandatoryLoginViewModel.this._state.setValue(State.Loading.INSTANCE);
                this.label = 1;
                obj = BuildersKt.withContext(MandatoryLoginViewModel.this.workDispatcher, new MandatoryLoginViewModel$login$1$success$1(MandatoryLoginViewModel.this, this.$authorizationCode, null), this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData2 = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = (State) obj;
                mutableLiveData = mutableLiveData2;
                mutableLiveData.setValue(obj2);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            mutableLiveData = MandatoryLoginViewModel.this._state;
            if (zBooleanValue) {
                this.L$0 = mutableLiveData;
                this.Z$0 = zBooleanValue;
                this.label = 2;
                obj = MandatoryLoginViewModel.this.loadOrganizationState(this);
                if (obj != coroutine_suspended) {
                    mutableLiveData2 = mutableLiveData;
                    obj2 = (State) obj;
                    mutableLiveData = mutableLiveData2;
                    mutableLiveData.setValue(obj2);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            obj2 = (State) new State.Login(false, 1, null);
            mutableLiveData.setValue(obj2);
            return Unit.INSTANCE;
        }
    }

    public final void login(String authorizationCode) {
        Intrinsics.checkNotNullParameter(authorizationCode, "authorizationCode");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C66771(authorizationCode, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.organization.ui.MandatoryLoginViewModel$loadOrganizationState$2 */
    /* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/organization/MandatoryLoginRepository$OrganizationState;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.organization.ui.MandatoryLoginViewModel$loadOrganizationState$2", m1609f = "MandatoryLoginViewModel.kt", m1610i = {}, m1611l = {UCrop.REQUEST_CROP}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C66762 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MandatoryLoginRepository.OrganizationState>, Object> {
        int label;

        C66762(Continuation<? super C66762> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MandatoryLoginViewModel.this.new C66762(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MandatoryLoginRepository.OrganizationState> continuation) {
            return ((C66762) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Object objLoadOrganizationState = MandatoryLoginViewModel.this.repository.loadOrganizationState(this);
            return objLoadOrganizationState == coroutine_suspended ? coroutine_suspended : objLoadOrganizationState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadOrganizationState(Continuation<? super State> continuation) {
        C66751 c66751;
        if (continuation instanceof C66751) {
            c66751 = (C66751) continuation;
            if ((c66751.label & Integer.MIN_VALUE) != 0) {
                c66751.label -= Integer.MIN_VALUE;
            } else {
                c66751 = new C66751(continuation);
            }
        }
        Object objWithContext = c66751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c66751.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher coroutineDispatcher = this.workDispatcher;
            C66762 c66762 = new C66762(null);
            c66751.label = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, c66762, c66751);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        MandatoryLoginRepository.OrganizationState organizationState = (MandatoryLoginRepository.OrganizationState) objWithContext;
        boolean canOpenApp = organizationState.getCanOpenApp();
        long lastFetch = organizationState.getLastFetch();
        if (this.clock.getTime() - lastFetch > ONE_MONTH_MS) {
            this.repository.logout();
            return new State.Login(true);
        }
        if (canOpenApp) {
            this.repository.saveOrganizationState(canOpenApp, lastFetch);
            return State.LoggedIn.INSTANCE;
        }
        this.repository.logout();
        return new State.Login(true);
    }

    /* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/organization/ui/MandatoryLoginViewModel$Companion;", "", "<init>", "()V", "ONE_MONTH_MS", "", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return MandatoryLoginViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MandatoryLoginViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.common.IClock");
        IClock iClock = (IClock) componentCallbacks2RequireApplication;
        return new MandatoryLoginViewModel(new MandatoryLoginRepositoryImpl(((UserData.Provider) componentCallbacks2RequireApplication).provideUserData(), ((ISSOManager.Provider) componentCallbacks2RequireApplication).provideSSOManager(), ((Backend.Provider) componentCallbacks2RequireApplication).provideBackend(), iClock), iClock, null, null, 12, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(MandatoryLoginViewModel.class), new Function1() { // from class: com.myscript.nebo.organization.ui.MandatoryLoginViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MandatoryLoginViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
