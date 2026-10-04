package com.myscript.nebo.purchase;

import android.content.ComponentCallbacks2;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.analytics.firebase.LoginOrigin;
import com.myscript.nebo.migration.IInstallReferralRepository;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: compiled from: PaywallViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001a\b\u0007\u0018\u0000 82\u00020\u0001:\u00045678B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fJ\u000e\u0010 \u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015J\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020'0&J\u0010\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010#J\u001c\u0010*\u001a\u00020\u00182\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fH\u0086@¢\u0006\u0002\u0010,J \u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00069"}, m1599d2 = {"Lcom/myscript/nebo/purchase/PaywallViewModel;", "Landroidx/lifecycle/ViewModel;", "subscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "installReferralRepository", "Lcom/myscript/nebo/migration/IInstallReferralRepository;", "<init>", "(Lcom/myscript/nebo/purchase/ISubscriptionRepository;Lcom/myscript/nebo/sso/api/ISSOManager;Lcom/myscript/nebo/sso/model/UserData;Lcom/myscript/nebo/migration/IInstallReferralRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/myscript/nebo/purchase/PaywallViewModel$PaywallState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "oemOfferingIds", "", "", "loginResultDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "loginListener", "com/myscript/nebo/purchase/PaywallViewModel$loginListener$1", "Lcom/myscript/nebo/purchase/PaywallViewModel$loginListener$1;", "checkSubscription", "", "firebaseNotification", "Lkotlin/Function0;", "hasSubscribed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOffering", "Lcom/revenuecat/purchases/Offering;", "placementId", "getCustomVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "onPaywallDisplayed", "offering", "prePurchaseChecks", "startLoginFlow", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startNativeLoginWithGoogle", "googleIdToken", "origin", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePotentialSSOLogin", "uri", "Landroid/net/Uri;", "onLoginCanceled", "State", "PaywallState", "Factory", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PaywallViewModel extends ViewModel {
    private static final String OFFERING_ID_OPT_IN_END_OF_TRIAL = "msnotes_fullaccess_eot";
    private static final String OFFERING_ID_OPT_IN_TRIAL = "msnotes_fullacccess_manual_trial";
    private static final String PAYWALL_CUSTOM_VARIABLE_SHOW_PACKAGES_KEY = "show_packages";
    private static final String SHOW_PACKAGES_YEARLY_RENEWAL = "yearly_renewal";
    private final MutableStateFlow<PaywallState> _uiState;
    private final IInstallReferralRepository installReferralRepository;
    private final PaywallViewModel$loginListener$1 loginListener;
    private CompletableDeferred<Boolean> loginResultDeferred;
    private final List<String> oemOfferingIds;
    private final ISSOManager ssoManager;
    private final ISubscriptionRepository subscriptionRepository;
    private final StateFlow<PaywallState> uiState;
    private final UserData userData;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.PaywallViewModel$prePurchaseChecks$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.PaywallViewModel", m1609f = "PaywallViewModel.kt", m1610i = {0, 0, 0}, m1611l = {135}, m1612m = "prePurchaseChecks", m1613n = {"startLoginFlow", "deferred", "authenticated"}, m1614nl = {TsExtractor.TS_STREAM_TYPE_DTS_HD}, m1615s = {"L$0", "L$1", "Z$0"}, m1616v = 2)
    static final class C67301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C67301(Continuation<? super C67301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModel.this.prePurchaseChecks(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [com.myscript.nebo.purchase.PaywallViewModel$loginListener$1] */
    public PaywallViewModel(ISubscriptionRepository subscriptionRepository, ISSOManager ssoManager, UserData userData, IInstallReferralRepository installReferralRepository) {
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(ssoManager, "ssoManager");
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(installReferralRepository, "installReferralRepository");
        this.subscriptionRepository = subscriptionRepository;
        this.ssoManager = ssoManager;
        this.userData = userData;
        this.installReferralRepository = installReferralRepository;
        MutableStateFlow<PaywallState> MutableStateFlow = StateFlowKt.MutableStateFlow(new PaywallState(null, null, false, 7, null));
        this._uiState = MutableStateFlow;
        this.uiState = MutableStateFlow;
        this.oemOfferingIds = SubscriptionRepository.INSTANCE.getOEM_OFFERING_IDS();
        this.loginListener = new ISSOManager.OnLoginListener() { // from class: com.myscript.nebo.purchase.PaywallViewModel$loginListener$1
            @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
            public void onLogout() {
            }

            @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
            public void onLogin() {
                CompletableDeferred completableDeferred = this.this$0.loginResultDeferred;
                if (completableDeferred != null) {
                    completableDeferred.complete(Boolean.valueOf(this.this$0.userData.hasUser()));
                }
                this.this$0.ssoManager.removeLoginListener(this);
            }
        };
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C67271(null), 3, null);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/purchase/PaywallViewModel$State;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Ready", "Subscribed", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State Loading = new State("Loading", 0);
        public static final State Ready = new State("Ready", 1);
        public static final State Subscribed = new State("Subscribed", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{Loading, Ready, Subscribed};
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        private State(String str, int i) {
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stateArr$values);
        }
    }

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/purchase/PaywallViewModel$PaywallState;", "", "state", "Lcom/myscript/nebo/purchase/PaywallViewModel$State;", "planType", "Lcom/myscript/nebo/purchase/ISubscriptionRepository$PlanType;", "closable", "", "<init>", "(Lcom/myscript/nebo/purchase/PaywallViewModel$State;Lcom/myscript/nebo/purchase/ISubscriptionRepository$PlanType;Z)V", "getState", "()Lcom/myscript/nebo/purchase/PaywallViewModel$State;", "getPlanType", "()Lcom/myscript/nebo/purchase/ISubscriptionRepository$PlanType;", "getClosable", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class PaywallState {
        public static final int $stable = 0;
        private final boolean closable;
        private final ISubscriptionRepository.PlanType planType;
        private final State state;

        public PaywallState() {
            this(null, null, false, 7, null);
        }

        public static /* synthetic */ PaywallState copy$default(PaywallState paywallState, State state, ISubscriptionRepository.PlanType planType, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                state = paywallState.state;
            }
            if ((i & 2) != 0) {
                planType = paywallState.planType;
            }
            if ((i & 4) != 0) {
                z = paywallState.closable;
            }
            return paywallState.copy(state, planType, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final State getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ISubscriptionRepository.PlanType getPlanType() {
            return this.planType;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getClosable() {
            return this.closable;
        }

        public final PaywallState copy(State state, ISubscriptionRepository.PlanType planType, boolean closable) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new PaywallState(state, planType, closable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaywallState)) {
                return false;
            }
            PaywallState paywallState = (PaywallState) other;
            return this.state == paywallState.state && this.planType == paywallState.planType && this.closable == paywallState.closable;
        }

        public int hashCode() {
            int iHashCode = this.state.hashCode() * 31;
            ISubscriptionRepository.PlanType planType = this.planType;
            return ((iHashCode + (planType == null ? 0 : planType.hashCode())) * 31) + Boolean.hashCode(this.closable);
        }

        public String toString() {
            return "PaywallState(state=" + this.state + ", planType=" + this.planType + ", closable=" + this.closable + ")";
        }

        public PaywallState(State state, ISubscriptionRepository.PlanType planType, boolean z) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.planType = planType;
            this.closable = z;
        }

        public /* synthetic */ PaywallState(State state, ISubscriptionRepository.PlanType planType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? State.Loading : state, (i & 2) != 0 ? null : planType, (i & 4) != 0 ? false : z);
        }

        public final boolean getClosable() {
            return this.closable;
        }

        public final ISubscriptionRepository.PlanType getPlanType() {
            return this.planType;
        }

        public final State getState() {
            return this.state;
        }
    }

    public final StateFlow<PaywallState> getUiState() {
        return this.uiState;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.PaywallViewModel$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.PaywallViewModel$1", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {58}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C67271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67271(Continuation<? super C67271> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModel.this.new C67271(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.purchase.PaywallViewModel$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PaywallViewModel.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ PaywallViewModel this$0;

            AnonymousClass1(PaywallViewModel paywallViewModel) {
                this.this$0 = paywallViewModel;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                PaywallViewModel$1$1$emit$1 paywallViewModel$1$1$emit$1;
                MutableStateFlow mutableStateFlow;
                MutableStateFlow mutableStateFlow2;
                PaywallState paywallState;
                String identifier;
                Offering current;
                if (continuation instanceof PaywallViewModel$1$1$emit$1) {
                    paywallViewModel$1$1$emit$1 = (PaywallViewModel$1$1$emit$1) continuation;
                    if ((paywallViewModel$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        paywallViewModel$1$1$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        paywallViewModel$1$1$emit$1 = new PaywallViewModel$1$1$emit$1(this, continuation);
                    }
                }
                Object obj = paywallViewModel$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = paywallViewModel$1$1$emit$1.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow = this.this$0._uiState;
                    if (!z) {
                        paywallState = new PaywallState(State.Loading, null, false, 6, null);
                        mutableStateFlow.setValue(paywallState);
                        return Unit.INSTANCE;
                    }
                    PaywallViewModel paywallViewModel = this.this$0;
                    paywallViewModel$1$1$emit$1.L$0 = mutableStateFlow;
                    paywallViewModel$1$1$emit$1.Z$0 = z;
                    paywallViewModel$1$1$emit$1.label = 1;
                    Object objHasSubscribed = paywallViewModel.hasSubscribed(paywallViewModel$1$1$emit$1);
                    if (objHasSubscribed == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objHasSubscribed;
                    mutableStateFlow2 = mutableStateFlow;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z2 = paywallViewModel$1$1$emit$1.Z$0;
                    mutableStateFlow2 = (MutableStateFlow) paywallViewModel$1$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    paywallState = new PaywallState(State.Subscribed, this.this$0.subscriptionRepository.getPlanType(), true);
                } else {
                    Offerings offerings = this.this$0.subscriptionRepository.get_offerings();
                    List list = this.this$0.oemOfferingIds;
                    if (offerings == null || (current = offerings.getCurrent()) == null || (identifier = current.getIdentifier()) == null) {
                        identifier = "";
                    }
                    paywallState = new PaywallState(State.Ready, this.this$0.subscriptionRepository.getPlanType(), !list.contains(identifier));
                }
                mutableStateFlow = mutableStateFlow2;
                mutableStateFlow.setValue(paywallState);
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
                if (PaywallViewModel.this.subscriptionRepository.isConfigured().collect(new AnonymousClass1(PaywallViewModel.this), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.PaywallViewModel$checkSubscription$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.PaywallViewModel$checkSubscription$1", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {74, BaseNCodec.MIME_CHUNK_SIZE}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {BaseNCodec.MIME_CHUNK_SIZE, 77}, m1615s = {}, m1616v = 2)
    static final class C67281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $firebaseNotification;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67281(Function0<Unit> function0, Continuation<? super C67281> continuation) {
            super(2, continuation);
            this.$firebaseNotification = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModel.this.new C67281(this.$firebaseNotification, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        
            if (r7 == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PaywallViewModel.this.subscriptionRepository.fetchSubscriptionStatus(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    PaywallViewModel.this._uiState.setValue(new PaywallState(State.Subscribed, PaywallViewModel.this.subscriptionRepository.getPlanType(), false, 4, null));
                    this.$firebaseNotification.invoke();
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 2;
            obj = PaywallViewModel.this.hasSubscribed(this);
        }
    }

    public final void checkSubscription(Function0<Unit> firebaseNotification) {
        Intrinsics.checkNotNullParameter(firebaseNotification, "firebaseNotification");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C67281(firebaseNotification, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object hasSubscribed(Continuation<? super Boolean> continuation) {
        return FlowKt.first(this.subscriptionRepository.getHasSubscribed(), continuation);
    }

    public static /* synthetic */ Offering getOffering$default(PaywallViewModel paywallViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return paywallViewModel.getOffering(str);
    }

    public final Offering getOffering(String placementId) {
        Offerings offerings = this.subscriptionRepository.get_offerings();
        if (offerings == null) {
            return null;
        }
        return offerings.getCurrent();
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        String strReferralSource = this.installReferralRepository.referralSource();
        if (strReferralSource != null) {
        }
        if (this.subscriptionRepository.getRenewalOfferState().getValue().getActive()) {
            mapCreateMapBuilder.put(PAYWALL_CUSTOM_VARIABLE_SHOW_PACKAGES_KEY, new CustomVariableValue.String(SHOW_PACKAGES_YEARLY_RENEWAL));
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public final void onPaywallDisplayed(Offering offering) {
        if (Intrinsics.areEqual(offering != null ? offering.getIdentifier() : null, OFFERING_ID_OPT_IN_END_OF_TRIAL)) {
            this.subscriptionRepository.setPaywallAfterOptInTrialShown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prePurchaseChecks(Function0<Unit> function0, Continuation<? super Boolean> continuation) {
        C67301 c67301;
        if (continuation instanceof C67301) {
            c67301 = (C67301) continuation;
            if ((c67301.label & Integer.MIN_VALUE) != 0) {
                c67301.label -= Integer.MIN_VALUE;
            } else {
                c67301 = new C67301(continuation);
            }
        }
        Object objAwait = c67301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c67301.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            boolean zHasUser = this.userData.hasUser();
            if (!zHasUser) {
                CompletableDeferred<Boolean> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                this.loginResultDeferred = completableDeferredCompletableDeferred$default;
                this.ssoManager.addLoginListener(this.loginListener);
                function0.invoke();
                c67301.L$0 = SpillingKt.nullOutSpilledVariable(function0);
                c67301.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferredCompletableDeferred$default);
                c67301.Z$0 = zHasUser;
                c67301.label = 1;
                objAwait = completableDeferredCompletableDeferred$default.await(c67301);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Boxing.boxBoolean(true);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z = c67301.Z$0;
            ResultKt.throwOnFailure(objAwait);
        }
        return Boxing.boxBoolean(((Boolean) objAwait).booleanValue());
    }

    public final Object startNativeLoginWithGoogle(String str, String str2, Continuation<? super Boolean> continuation) {
        return this.ssoManager.startNativeLoginWithGoogle(str, str2, continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.PaywallViewModel$handlePotentialSSOLogin$1 */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.PaywallViewModel$handlePotentialSSOLogin$1", m1609f = "PaywallViewModel.kt", m1610i = {0}, m1611l = {148}, m1612m = "invokeSuspend", m1613n = {"code"}, m1614nl = {149}, m1615s = {"L$0"}, m1616v = 2)
    static final class C67291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $uri;
        Object L$0;
        int label;
        final /* synthetic */ PaywallViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67291(Uri uri, PaywallViewModel paywallViewModel, Continuation<? super C67291> continuation) {
            super(2, continuation);
            this.$uri = uri;
            this.this$0 = paywallViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67291(this.$uri, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String queryParameter = this.$uri.getQueryParameter("code");
                if (queryParameter == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(queryParameter);
                this.label = 1;
                if (this.this$0.ssoManager.login(queryParameter, LoginOrigin.PremiumModal.getValue(), this) == coroutine_suspended) {
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

    public final void handlePotentialSSOLogin(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C67291(uri, this, null), 3, null);
    }

    public final void onLoginCanceled() {
        this.ssoManager.removeLoginListener(this.loginListener);
        CompletableDeferred<Boolean> completableDeferred = this.loginResultDeferred;
        if (completableDeferred != null) {
            completableDeferred.complete(false);
        }
    }

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/purchase/PaywallViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Factory implements ViewModelProvider.Factory {
        public static final int $stable = 0;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(Class<T> cls) {
            return (T) super.create(cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras) {
            return (T) super.create(kClass, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (modelClass.isAssignableFrom(PaywallViewModel.class)) {
                ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(extras);
                ISubscriptionRepository.Provider provider = componentCallbacks2RequireApplication instanceof ISubscriptionRepository.Provider ? (ISubscriptionRepository.Provider) componentCallbacks2RequireApplication : null;
                ISubscriptionRepository iSubscriptionRepositoryProvideSubscriptionRepository = provider != null ? provider.provideSubscriptionRepository() : null;
                ISSOManager.Provider provider2 = componentCallbacks2RequireApplication instanceof ISSOManager.Provider ? (ISSOManager.Provider) componentCallbacks2RequireApplication : null;
                ISSOManager iSSOManagerProvideSSOManager = provider2 != null ? provider2.provideSSOManager() : null;
                if (iSSOManagerProvideSSOManager == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                UserData.Provider provider3 = componentCallbacks2RequireApplication instanceof UserData.Provider ? (UserData.Provider) componentCallbacks2RequireApplication : null;
                UserData userDataProvideUserData = provider3 != null ? provider3.provideUserData() : null;
                if (userDataProvideUserData == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                IInstallReferralRepository.Provider provider4 = componentCallbacks2RequireApplication instanceof IInstallReferralRepository.Provider ? (IInstallReferralRepository.Provider) componentCallbacks2RequireApplication : null;
                IInstallReferralRepository iInstallReferralRepositoryProvideInstallReferralRepository = provider4 != null ? provider4.provideInstallReferralRepository() : null;
                if (iInstallReferralRepositoryProvideInstallReferralRepository == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                if (iSubscriptionRepositoryProvideSubscriptionRepository != null) {
                    return new PaywallViewModel(iSubscriptionRepositoryProvideSubscriptionRepository, iSSOManagerProvideSSOManager, userDataProvideUserData, iInstallReferralRepositoryProvideInstallReferralRepository);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Unknown ViewModel " + modelClass);
        }
    }
}
