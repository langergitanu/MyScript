package com.myscript.nebo.screennavigation;

import android.os.Bundle;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.dms.core.ContentInitializer;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.migration.IInstallReferralRepository;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.purchase.SubscriptionConfigurationWorker;
import com.myscript.nebo.screennavigation.LaunchViewModel;
import com.myscript.nebo.whatsnew.ApplicationState;
import com.myscript.snt.core.PageKey;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: LaunchViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001:\u0002BCB\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u00100\u001a\u000201H\u0002J\u000e\u00105\u001a\u000201H\u0082@¢\u0006\u0002\u00106J\u0006\u00107\u001a\u000201J\u000e\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\tJ\u0006\u0010:\u001a\u000201J\u0006\u0010;\u001a\u000201J\u0016\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000201H\u0017J\u000e\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020.0*¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u0014\u00102\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006D"}, m1599d2 = {"Lcom/myscript/nebo/screennavigation/LaunchViewModel;", "Landroidx/lifecycle/ViewModel;", "launchState", "Lcom/myscript/nebo/screennavigation/ILaunchStateProvider;", "subscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "contentInitializer", "Lcom/myscript/nebo/dms/core/ContentInitializer;", "initialCollectionName", "", "initialFolderName", "initialFolderColor", "", "initialNotebookName", "initialNotebookColor", "enableAnalytics", "", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "applicationVersion", "workManager", "Landroidx/work/WorkManager;", "referralRepository", "Lcom/myscript/nebo/migration/IInstallReferralRepository;", "isNeboForLenovoInstalled", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/myscript/nebo/screennavigation/ILaunchStateProvider;Lcom/myscript/nebo/purchase/ISubscriptionRepository;Lcom/myscript/nebo/dms/core/ContentInitializer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZLcom/myscript/nebo/common/network/NeboNetworkStateRepository;Ljava/lang/String;Landroidx/work/WorkManager;Lcom/myscript/nebo/migration/IInstallReferralRepository;ZLcom/myscript/nebo/log/TechnicalLogger;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "isFreshInstall", "currentStep", "Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchStep;", "step", "Lkotlinx/coroutines/flow/MutableStateFlow;", "hasSeenSlides", "hasSeenWelcome", "seenSlidesCount", "isInitializingContent", "hasInternetAccess", "Lkotlinx/coroutines/flow/StateFlow;", "getHasInternetAccess", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchScreenUIState;", "getUiState", "enqueueSubscriptionConfigurationWork", "", "shouldShowLenovoWelcome", "getShouldShowLenovoWelcome", "()Z", "updateStep", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startFreeTrial", "languageSelected", "selectedLanguageKey", "plsMigrationEnded", "lenovoWelcomeContinue", "createInitialContent", "languageKey", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "onboardingCtaClicked", "pageIndex", "LaunchScreenUIState", "LaunchStep", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LaunchViewModel extends ViewModel {
    public static final int $stable = 8;
    private final String applicationVersion;
    private final ContentInitializer contentInitializer;
    private LaunchStep currentStep;
    private final boolean enableAnalytics;
    private boolean hasSeenSlides;
    private boolean hasSeenWelcome;
    private final String initialCollectionName;
    private final int initialFolderColor;
    private final String initialFolderName;
    private final int initialNotebookColor;
    private final String initialNotebookName;
    private final CoroutineDispatcher ioDispatcher;
    private boolean isFreshInstall;
    private boolean isInitializingContent;
    private final boolean isNeboForLenovoInstalled;
    private final ILaunchStateProvider launchState;
    private final TechnicalLogger logger;
    private final CoroutineDispatcher mainDispatcher;
    private final NeboNetworkStateRepository networkStateRepository;
    private final IInstallReferralRepository referralRepository;
    private int seenSlidesCount;
    private final MutableStateFlow<LaunchStep> step;
    private final ISubscriptionRepository subscriptionRepository;
    private final StateFlow<LaunchScreenUIState> uiState;
    private final WorkManager workManager;

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$createInitialContent$1 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel", m1609f = "LaunchViewModel.kt", m1610i = {0, 1}, m1611l = {PsExtractor.VIDEO_STREAM_MASK, PDFACompliance.e_PDFA2_5_2}, m1612m = "createInitialContent", m1613n = {"languageKey", "languageKey"}, m1614nl = {PDFACompliance.e_PDFA2_5_2, 253}, m1615s = {"L$0", "L$0"}, m1616v = 2)
    static final class C67561 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C67561(Continuation<? super C67561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LaunchViewModel.this.createInitialContent(null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$updateStep$1 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel", m1609f = "LaunchViewModel.kt", m1610i = {0, 1, 1, 2, 2}, m1611l = {164, 178, 195}, m1612m = "updateStep", m1613n = {"isLoggedIn", "nextStep", "isLoggedIn", "nextStep", "isLoggedIn"}, m1614nl = {167, 195, 198}, m1615s = {"Z$0", "L$0", "Z$0", "L$0", "Z$0"}, m1616v = 2)
    static final class C67641 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C67641(Continuation<? super C67641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LaunchViewModel.this.updateStep(this);
        }
    }

    public LaunchViewModel(ILaunchStateProvider launchState, ISubscriptionRepository subscriptionRepository, ContentInitializer contentInitializer, String initialCollectionName, String initialFolderName, int i, String initialNotebookName, int i2, boolean z, NeboNetworkStateRepository networkStateRepository, String str, WorkManager workManager, IInstallReferralRepository referralRepository, boolean z2, TechnicalLogger technicalLogger, CoroutineDispatcher mainDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(launchState, "launchState");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(contentInitializer, "contentInitializer");
        Intrinsics.checkNotNullParameter(initialCollectionName, "initialCollectionName");
        Intrinsics.checkNotNullParameter(initialFolderName, "initialFolderName");
        Intrinsics.checkNotNullParameter(initialNotebookName, "initialNotebookName");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(workManager, "workManager");
        Intrinsics.checkNotNullParameter(referralRepository, "referralRepository");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.launchState = launchState;
        this.subscriptionRepository = subscriptionRepository;
        this.contentInitializer = contentInitializer;
        this.initialCollectionName = initialCollectionName;
        this.initialFolderName = initialFolderName;
        this.initialFolderColor = i;
        this.initialNotebookName = initialNotebookName;
        this.initialNotebookColor = i2;
        this.enableAnalytics = z;
        this.networkStateRepository = networkStateRepository;
        this.applicationVersion = str;
        this.workManager = workManager;
        this.referralRepository = referralRepository;
        this.isNeboForLenovoInstalled = z2;
        this.logger = technicalLogger;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        this.currentStep = LaunchStep.SplashScreen;
        MutableStateFlow<LaunchStep> MutableStateFlow = StateFlowKt.MutableStateFlow(LaunchStep.SplashScreen);
        this.step = MutableStateFlow;
        LaunchViewModel launchViewModel = this;
        this.uiState = FlowKt.stateIn(FlowKt.combine(MutableStateFlow, getHasInternetAccess(), new LaunchViewModel$uiState$1(null)), ViewModelKt.getViewModelScope(launchViewModel), SharingStarted.INSTANCE.getEagerly(), new LaunchScreenUIState(this.currentStep, true));
        ApplicationState applicationState = launchState.getApplicationState();
        boolean z3 = applicationState.getStoredVersion() == null;
        this.isFreshInstall = z3;
        if (z3) {
            applicationState.setWhatsNewNumber(108);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(launchViewModel), null, null, new C67531(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(launchViewModel), null, null, new C67542(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(launchViewModel), null, null, new C67553(null), 3, null);
    }

    public /* synthetic */ LaunchViewModel(ILaunchStateProvider iLaunchStateProvider, ISubscriptionRepository iSubscriptionRepository, ContentInitializer contentInitializer, String str, String str2, int i, String str3, int i2, boolean z, NeboNetworkStateRepository neboNetworkStateRepository, String str4, WorkManager workManager, IInstallReferralRepository iInstallReferralRepository, boolean z2, TechnicalLogger technicalLogger, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(iLaunchStateProvider, iSubscriptionRepository, contentInitializer, str, str2, i, str3, i2, (i3 & 256) != 0 ? true : z, neboNetworkStateRepository, str4, workManager, iInstallReferralRepository, z2, (i3 & 16384) != 0 ? null : technicalLogger, (32768 & i3) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i3 & 65536) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchScreenUIState;", "", "step", "Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchStep;", "hasInternetAccess", "", "<init>", "(Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchStep;Z)V", "getStep", "()Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchStep;", "getHasInternetAccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class LaunchScreenUIState {
        public static final int $stable = 0;
        private final boolean hasInternetAccess;
        private final LaunchStep step;

        public static /* synthetic */ LaunchScreenUIState copy$default(LaunchScreenUIState launchScreenUIState, LaunchStep launchStep, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                launchStep = launchScreenUIState.step;
            }
            if ((i & 2) != 0) {
                z = launchScreenUIState.hasInternetAccess;
            }
            return launchScreenUIState.copy(launchStep, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LaunchStep getStep() {
            return this.step;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasInternetAccess() {
            return this.hasInternetAccess;
        }

        public final LaunchScreenUIState copy(LaunchStep step, boolean hasInternetAccess) {
            Intrinsics.checkNotNullParameter(step, "step");
            return new LaunchScreenUIState(step, hasInternetAccess);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LaunchScreenUIState)) {
                return false;
            }
            LaunchScreenUIState launchScreenUIState = (LaunchScreenUIState) other;
            return this.step == launchScreenUIState.step && this.hasInternetAccess == launchScreenUIState.hasInternetAccess;
        }

        public int hashCode() {
            return (this.step.hashCode() * 31) + Boolean.hashCode(this.hasInternetAccess);
        }

        public String toString() {
            return "LaunchScreenUIState(step=" + this.step + ", hasInternetAccess=" + this.hasInternetAccess + ")";
        }

        public LaunchScreenUIState(LaunchStep step, boolean z) {
            Intrinsics.checkNotNullParameter(step, "step");
            this.step = step;
            this.hasInternetAccess = z;
        }

        public final boolean getHasInternetAccess() {
            return this.hasInternetAccess;
        }

        public final LaunchStep getStep() {
            return this.step;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchStep;", "", "<init>", "(Ljava/lang/String;I)V", "SplashScreen", "PlsMigration", "LenovoWelcome", "OnboardingSlides", "MandatoryLoginEnterprise", "Language", "InitContent", "App", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class LaunchStep {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LaunchStep[] $VALUES;
        public static final LaunchStep SplashScreen = new LaunchStep("SplashScreen", 0);
        public static final LaunchStep PlsMigration = new LaunchStep("PlsMigration", 1);
        public static final LaunchStep LenovoWelcome = new LaunchStep("LenovoWelcome", 2);
        public static final LaunchStep OnboardingSlides = new LaunchStep("OnboardingSlides", 3);
        public static final LaunchStep MandatoryLoginEnterprise = new LaunchStep("MandatoryLoginEnterprise", 4);
        public static final LaunchStep Language = new LaunchStep("Language", 5);
        public static final LaunchStep InitContent = new LaunchStep("InitContent", 6);
        public static final LaunchStep App = new LaunchStep("App", 7);

        private static final /* synthetic */ LaunchStep[] $values() {
            return new LaunchStep[]{SplashScreen, PlsMigration, LenovoWelcome, OnboardingSlides, MandatoryLoginEnterprise, Language, InitContent, App};
        }

        public static EnumEntries<LaunchStep> getEntries() {
            return $ENTRIES;
        }

        public static LaunchStep valueOf(String str) {
            return (LaunchStep) Enum.valueOf(LaunchStep.class, str);
        }

        public static LaunchStep[] values() {
            return (LaunchStep[]) $VALUES.clone();
        }

        private LaunchStep(String str, int i) {
        }

        static {
            LaunchStep[] launchStepArr$values = $values();
            $VALUES = launchStepArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(launchStepArr$values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StateFlow<Boolean> getHasInternetAccess() {
        final Flow flowAsFlow = FlowLiveDataConversions.asFlow(this.networkStateRepository.getNeboNetworkState());
        return FlowKt.stateIn(new Flow<Boolean>() { // from class: com.myscript.nebo.screennavigation.LaunchViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$special$$inlined$map$1$2 */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final class C67622<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$special$$inlined$map$1$2", m1609f = "LaunchViewModel.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {50}, m1612m = "emit", m1613n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, m1614nl = {49}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C67622.this.emit(null, this);
                    }
                }

                public C67622(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Boolean boolBoxBoolean = Boxing.boxBoolean(((NeboNetworkState) obj) instanceof NeboNetworkState.Connected);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(boolBoxBoolean, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object objCollect = flowAsFlow.collect(new C67622(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), false);
    }

    public final StateFlow<LaunchScreenUIState> getUiState() {
        return this.uiState;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$1 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$1", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_2_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {WebSocketProtocol.PAYLOAD_SHORT}, m1615s = {}, m1616v = 2)
    static final class C67531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67531(Continuation<? super C67531> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67531(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: LaunchViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$1$1", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ LaunchViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LaunchViewModel launchViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = launchViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean zBooleanValue = ((Boolean) this.this$0.getHasInternetAccess().getValue()).booleanValue();
                    TechnicalLogger technicalLogger = this.this$0.logger;
                    if (technicalLogger != null) {
                        technicalLogger.setKeyValue("hasInternetAccess", String.valueOf(zBooleanValue));
                    }
                    this.this$0.enqueueSubscriptionConfigurationWork();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(LaunchViewModel.this, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$2 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$2", m1609f = "LaunchViewModel.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA1_3_1}, m1612m = "invokeSuspend", m1613n = {"previousValue"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
    static final class C67542 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C67542(Continuation<? super C67542> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67542(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67542) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                StateFlow hasInternetAccess = LaunchViewModel.this.getHasInternetAccess();
                final LaunchViewModel launchViewModel = LaunchViewModel.this;
                this.L$0 = SpillingKt.nullOutSpilledVariable(objectRef);
                this.label = 1;
                if (hasInternetAccess.collect(new FlowCollector() { // from class: com.myscript.nebo.screennavigation.LaunchViewModel.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        if (objectRef.element != null && !Intrinsics.areEqual(objectRef.element, Boxing.boxBoolean(z))) {
                            TechnicalLogger technicalLogger = launchViewModel.logger;
                            if (technicalLogger != null) {
                                technicalLogger.setKeyValue("hasInternetAccess", String.valueOf(z));
                            }
                            launchViewModel.enqueueSubscriptionConfigurationWork();
                        }
                        objectRef.element = (T) Boxing.boxBoolean(z);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$3 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$3", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_4_2}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {143}, m1615s = {}, m1616v = 2)
    static final class C67553 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67553(Continuation<? super C67553> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67553(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67553) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LaunchViewModel.this.updateStep(this) == coroutine_suspended) {
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

    private final boolean getShouldShowLenovoWelcome() {
        return this.launchState.isOnBoardingNeeded() && this.referralRepository.isLenovoReferral() && this.isNeboForLenovoInstalled && !this.hasSeenWelcome;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011c, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r12, r5, r0) != r1) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateStep(Continuation<? super Unit> continuation) {
        C67641 c67641;
        boolean zIsLoggedIn;
        LaunchStep launchStep;
        LaunchStep launchStep2;
        if (continuation instanceof C67641) {
            c67641 = (C67641) continuation;
            if ((c67641.label & Integer.MIN_VALUE) != 0) {
                c67641.label -= Integer.MIN_VALUE;
            } else {
                c67641 = new C67641(continuation);
            }
        }
        Object obj = c67641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c67641.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            zIsLoggedIn = this.launchState.isLoggedIn();
            if (this.launchState.isOnBoardingNeeded() && this.isNeboForLenovoInstalled && !this.hasSeenWelcome) {
                CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
                C67652 c67652 = new C67652(null);
                c67641.Z$0 = zIsLoggedIn;
                c67641.label = 1;
                if (BuildersKt.withContext(coroutineDispatcher, c67652, c67641) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else if (i == 1) {
            zIsLoggedIn = c67641.Z$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z = c67641.Z$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            zIsLoggedIn = c67641.Z$0;
            launchStep2 = (LaunchStep) c67641.L$0;
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher2 = this.mainDispatcher;
            C67674 c67674 = new C67674(launchStep2, null);
            c67641.L$0 = SpillingKt.nullOutSpilledVariable(launchStep2);
            c67641.Z$0 = zIsLoggedIn;
            c67641.label = 3;
        }
        if (this.launchState.getRequiresPLSMigration()) {
            launchStep = LaunchStep.PlsMigration;
        } else if (this.launchState.isEnterpriseMandatoryLoginNeeded() && !zIsLoggedIn) {
            launchStep = LaunchStep.MandatoryLoginEnterprise;
        } else if (getShouldShowLenovoWelcome()) {
            launchStep = LaunchStep.LenovoWelcome;
        } else if (!this.launchState.isOnBoardingNeeded() || this.hasSeenSlides) {
            launchStep = (this.launchState.isOnBoardingNeeded() && this.hasSeenSlides) ? LaunchStep.Language : LaunchStep.App;
        } else {
            launchStep = LaunchStep.OnboardingSlides;
        }
        TechnicalLogger technicalLogger = this.logger;
        if (technicalLogger != null) {
            technicalLogger.logTrace("updateStep: currentStep=" + this.currentStep + ", nextStep=" + this.step.getValue());
        }
        CoroutineDispatcher coroutineDispatcher3 = this.ioDispatcher;
        C67663 c67663 = new C67663(launchStep, null);
        c67641.L$0 = launchStep;
        c67641.Z$0 = zIsLoggedIn;
        c67641.label = 2;
        if (BuildersKt.withContext(coroutineDispatcher3, c67663, c67641) != coroutine_suspended) {
            launchStep2 = launchStep;
            CoroutineDispatcher coroutineDispatcher22 = this.mainDispatcher;
            C67674 c676742 = new C67674(launchStep2, null);
            c67641.L$0 = SpillingKt.nullOutSpilledVariable(launchStep2);
            c67641.Z$0 = zIsLoggedIn;
            c67641.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$updateStep$2 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$updateStep$2", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {164}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C67652 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67652(Continuation<? super C67652> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67652(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67652) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LaunchViewModel.this.referralRepository.resolveReferral(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$updateStep$3 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$updateStep$3", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67663 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LaunchStep $nextStep;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67663(LaunchStep launchStep, Continuation<? super C67663> continuation) {
            super(2, continuation);
            this.$nextStep = launchStep;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67663(this.$nextStep, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67663) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (LaunchViewModel.this.isFreshInstall && this.$nextStep == LaunchStep.App) {
                    LaunchViewModel.this.launchState.getApplicationState().setStoredVersion(LaunchViewModel.this.applicationVersion);
                }
                if (LaunchViewModel.this.enableAnalytics && this.$nextStep != LaunchViewModel.this.step.getValue() && LaunchViewModel.this.step.getValue() != LaunchStep.SplashScreen && this.$nextStep == LaunchStep.App) {
                    NeboFirebaseEvent neboFirebaseEvent = NeboFirebaseEvent.TutorialEnd;
                    final LaunchViewModel launchViewModel = LaunchViewModel.this;
                    neboFirebaseEvent.log(new Function1() { // from class: com.myscript.nebo.screennavigation.LaunchViewModel$updateStep$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return LaunchViewModel.C67663.invokeSuspend$lambda$0(launchViewModel, (Bundle) obj2);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(LaunchViewModel launchViewModel, Bundle bundle) {
            bundle.putString("count", String.valueOf(launchViewModel.seenSlidesCount));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$updateStep$4 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$updateStep$4", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67674 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LaunchStep $nextStep;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67674(LaunchStep launchStep, Continuation<? super C67674> continuation) {
            super(2, continuation);
            this.$nextStep = launchStep;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67674(this.$nextStep, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67674) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LaunchViewModel.this.step.setValue(this.$nextStep);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$startFreeTrial$1 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$startFreeTrial$1", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {202, 203}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {203, 204}, m1615s = {}, m1616v = 2)
    static final class C67631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67631(Continuation<? super C67631> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67631(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        
            if (r4.this$0.updateStep(r4) == r0) goto L15;
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
                if (LaunchViewModel.this.subscriptionRepository.startFreeTrial(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 2;
        }
    }

    public final void startFreeTrial() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C67631(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$languageSelected$1 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$languageSelected$1", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {210, 211, 213}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {211, 212, 214}, m1615s = {}, m1616v = 2)
    static final class C67581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $selectedLanguageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67581(String str, Continuation<? super C67581> continuation) {
            super(2, continuation);
            this.$selectedLanguageKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67581(this.$selectedLanguageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
        
            if (r5.this$0.updateStep(r5) != r0) goto L21;
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
                LaunchViewModel.this.isInitializingContent = true;
                this.label = 1;
                if (LaunchViewModel.this.updateStep(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                LaunchViewModel.this.isInitializingContent = false;
                this.label = 3;
            }
            this.label = 2;
            if (LaunchViewModel.this.createInitialContent(this.$selectedLanguageKey, this) != coroutine_suspended) {
                LaunchViewModel.this.isInitializingContent = false;
                this.label = 3;
            }
            return coroutine_suspended;
        }
    }

    public final void languageSelected(String selectedLanguageKey) {
        Intrinsics.checkNotNullParameter(selectedLanguageKey, "selectedLanguageKey");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C67581(selectedLanguageKey, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$plsMigrationEnded$1 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$plsMigrationEnded$1", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {219, 222}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {222, 223}, m1615s = {}, m1616v = 2)
    static final class C67611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67611(Continuation<? super C67611> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67611(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$plsMigrationEnded$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: LaunchViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$plsMigrationEnded$1$1", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ LaunchViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LaunchViewModel launchViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = launchViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.launchState.getApplicationState().setPLSMigrationDone(true);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        
            if (r6.this$0.updateStep(r6) == r0) goto L15;
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
                if (BuildersKt.withContext(LaunchViewModel.this.ioDispatcher, new AnonymousClass1(LaunchViewModel.this, null), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 2;
        }
    }

    public final void plsMigrationEnded() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C67611(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$lenovoWelcomeContinue$1 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$lenovoWelcomeContinue$1", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67591(Continuation<? super C67591> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67591(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LaunchViewModel.this.hasSeenWelcome = true;
                LaunchViewModel.this.hasSeenSlides = true;
                LaunchViewModel.this.startFreeTrial();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void lenovoWelcomeContinue() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C67591(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$createInitialContent$2 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$createInitialContent$2", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_4_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {248}, m1615s = {}, m1616v = 2)
    static final class C67572 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $languageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67572(String str, Continuation<? super C67572> continuation) {
            super(2, continuation);
            this.$languageKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67572(this.$languageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67572) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = InitialContentKt.createInitialNotebook(LaunchViewModel.this.contentInitializer, LaunchViewModel.this.initialCollectionName, LaunchViewModel.this.initialFolderName, LaunchViewModel.this.initialFolderColor, LaunchViewModel.this.initialNotebookName, LaunchViewModel.this.initialNotebookColor, this.$languageKey, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((PageKey) obj) != null) {
                LaunchViewModel.this.launchState.setOnBoardingNotNeeded();
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (updateStep(r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createInitialContent(String str, Continuation<? super Unit> continuation) {
        C67561 c67561;
        if (continuation instanceof C67561) {
            c67561 = (C67561) continuation;
            if ((c67561.label & Integer.MIN_VALUE) != 0) {
                c67561.label -= Integer.MIN_VALUE;
            } else {
                c67561 = new C67561(continuation);
            }
        }
        Object obj = c67561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c67561.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
            C67572 c67572 = new C67572(str, null);
            c67561.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c67561.label = 1;
            if (BuildersKt.withContext(coroutineDispatcher, c67572, c67561) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        str = (String) c67561.L$0;
        ResultKt.throwOnFailure(obj);
        c67561.L$0 = SpillingKt.nullOutSpilledVariable(str);
        c67561.label = 2;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.screennavigation.LaunchViewModel$onboardingCtaClicked$1 */
    /* JADX INFO: compiled from: LaunchViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.screennavigation.LaunchViewModel$onboardingCtaClicked$1", m1609f = "LaunchViewModel.kt", m1610i = {}, m1611l = {265}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {266}, m1615s = {}, m1616v = 2)
    static final class C67601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67601(int i, Continuation<? super C67601> continuation) {
            super(2, continuation);
            this.$pageIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LaunchViewModel.this.new C67601(this.$pageIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LaunchViewModel.this.hasSeenSlides = true;
                LaunchViewModel.this.seenSlidesCount = this.$pageIndex + 1;
                LaunchViewModel.this.startFreeTrial();
                this.label = 1;
                if (LaunchViewModel.this.updateStep(this) == coroutine_suspended) {
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

    public final void onboardingCtaClicked(int pageIndex) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C67601(pageIndex, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueSubscriptionConfigurationWork() {
        this.workManager.enqueue(new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) SubscriptionConfigurationWorker.class).build());
    }
}
