package com.myscript.nebo.settings;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import aws.sdk.kotlin.services.p010s3.express.S3ExpressDefaultChecksumAlgorithmKt;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.android.utils.preference.InAppPreference;
import com.myscript.android.utils.preference.SummaryPreference;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.LaunchActivity;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.account.Feature;
import com.myscript.nebo.account.FeatureAccessListener;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.account.backend.Backend;
import com.myscript.nebo.analytics.firebase.LoginOrigin;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.dms.gdrive.C6278R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.freemium.PurchaseController;
import com.myscript.nebo.p034ui.compose.NativeSignInDialogKt;
import com.myscript.nebo.settings.SyncSettingsFragment;
import com.myscript.nebo.sso.C6821R;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.sso.p032ui.login.GoogleSignInHelper;
import com.myscript.nebo.sso.p032ui.login.LoginActivityHelperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.customercenter.CustomerCenterKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AccountSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002*\u0002%*\b\u0007\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020@H\u0016J$\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020B2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020/H\u0016J\b\u0010K\u001a\u00020-H\u0016J\b\u0010P\u001a\u00020\u001aH\u0002J\b\u0010Q\u001a\u00020-H\u0002J\u0018\u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020\u001aH\u0002J\b\u0010U\u001a\u00020VH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0014\u00102\u001a\u0002038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u0002038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u001c\u00108\u001a\u0004\u0018\u000109X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010L\u001a\u0010\u0012\f\u0012\n O*\u0004\u0018\u00010N0N0MX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X²\u0006\n\u0010Y\u001a\u00020ZX\u008a\u0084\u0002"}, m1599d2 = {"Lcom/myscript/nebo/settings/AccountSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "purchaseController", "Lcom/myscript/nebo/freemium/PurchaseController;", S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, "Lcom/myscript/nebo/account/backend/Backend;", "userProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "signInCategoryPref", "Landroidx/preference/Preference;", "pendingActivationCategoryPref", "pendingActivationSummaryPref", "profileCategoryPref", "profilePref", "freemiumInAppPref", "Lcom/myscript/android/utils/preference/InAppPreference;", "freemiumInAppSummaryPref", "Lcom/myscript/android/utils/preference/SummaryPreference;", "purchaseFlowRequested", "", "appUserIdSummaryPref", "<set-?>", "showNativeSignInDialog", "getShowNativeSignInDialog", "()Z", "setShowNativeSignInDialog", "(Z)V", "showNativeSignInDialog$delegate", "Landroidx/compose/runtime/MutableState;", "purchaseRequestedCallback", "com/myscript/nebo/settings/AccountSettingsFragment$purchaseRequestedCallback$1", "Lcom/myscript/nebo/settings/AccountSettingsFragment$purchaseRequestedCallback$1;", "featureAccessListener", "Lcom/myscript/nebo/account/FeatureAccessListener;", "loginListener", "com/myscript/nebo/settings/AccountSettingsFragment$loginListener$1", "Lcom/myscript/nebo/settings/AccountSettingsFragment$loginListener$1;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "onMenuItemClicked", "menuItem", "Landroid/view/MenuItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onSaveInstanceState", "outState", "onDestroyView", "loginActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "signOut", "updateUI", "updateFreemiumInApp", "hasPaidEntitlement", "isFreePeriod", "getUserState", "Lcom/myscript/nebo/settings/SyncSettingsFragment$UserProfileState;", "Companion", "app_standardRelease", "networkState", "Lcom/myscript/nebo/common/network/NeboNetworkState;"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AccountSettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    private static final String PURCHASE_FLOW_REQUESTED_KEY = "PURCHASE_FLOW_REQUESTED_KEY";
    private SummaryPreference appUserIdSummaryPref;
    private Backend backend;
    private InAppPreference freemiumInAppPref;
    private SummaryPreference freemiumInAppSummaryPref;
    private final ActivityResultLauncher<Intent> loginActivityLauncher;
    private Navigator navigator;
    private Preference pendingActivationCategoryPref;
    private Preference pendingActivationSummaryPref;
    private Preference profileCategoryPref;
    private Preference profilePref;
    private PurchaseController purchaseController;
    private boolean purchaseFlowRequested;
    private Preference signInCategoryPref;
    private ISSOManager ssoManager;
    private UserData userData;
    private UserProfileManager userProfileManager;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: showNativeSignInDialog$delegate, reason: from kotlin metadata */
    private final MutableState showNativeSignInDialog = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private final AccountSettingsFragment$purchaseRequestedCallback$1 purchaseRequestedCallback = new AccountSettingsFragment$purchaseRequestedCallback$1(this);
    private final FeatureAccessListener featureAccessListener = new FeatureAccessListener() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda15
        @Override // com.myscript.nebo.account.FeatureAccessListener
        public final void featuresAccessChanged(Map map) {
            AccountSettingsFragment.featureAccessListener$lambda$0(this.f$0, map);
        }
    };
    private final AccountSettingsFragment$loginListener$1 loginListener = new ISSOManager.OnLoginListener() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$loginListener$1
        @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
        public void onLogin() {
            this.this$0.updateUI();
        }

        @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
        public void onLogout() {
            this.this$0.updateUI();
        }
    };

    /* JADX INFO: compiled from: AccountSettingsFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SyncSettingsFragment.UserProfileState.values().length];
            try {
                iArr[SyncSettingsFragment.UserProfileState.NO_SSO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SyncSettingsFragment.UserProfileState.MAIL_NOT_VERIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SyncSettingsFragment.UserProfileState.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SyncSettingsFragment.UserProfileState.CLOUD_CONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return 0;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.myscript.nebo.settings.AccountSettingsFragment$loginListener$1] */
    public AccountSettingsFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda16
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AccountSettingsFragment.loginActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.loginActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShowNativeSignInDialog() {
        return ((Boolean) this.showNativeSignInDialog.getValue()).booleanValue();
    }

    private final void setShowNativeSignInDialog(boolean z) {
        this.showNativeSignInDialog.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void featureAccessListener$lambda$0(AccountSettingsFragment accountSettingsFragment, Map access) {
        Intrinsics.checkNotNullParameter(access, "access");
        Object obj = access.get(Feature.UnlimitedPages);
        if (obj == null) {
            obj = false;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (accountSettingsFragment.purchaseFlowRequested && zBooleanValue) {
            NeboFirebaseEvent.PaymentComplete.log(new Function1() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return AccountSettingsFragment.featureAccessListener$lambda$0$1((Bundle) obj2);
                }
            });
        }
        UserProfileManager userProfileManager = accountSettingsFragment.userProfileManager;
        UserProfileManager userProfileManager2 = null;
        if (userProfileManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager = null;
        }
        boolean zHasPaidEntitlement = userProfileManager.hasPaidEntitlement();
        UserProfileManager userProfileManager3 = accountSettingsFragment.userProfileManager;
        if (userProfileManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
        } else {
            userProfileManager2 = userProfileManager3;
        }
        accountSettingsFragment.updateFreemiumInApp(zHasPaidEntitlement, userProfileManager2.isFreePeriod());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit featureAccessListener$lambda$0$1(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("origin", "panel_settings_cta");
        return Unit.INSTANCE;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(C6079R.xml.account_settings);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.sso.model.UserData.Provider");
        this.userData = ((UserData.Provider) application).provideUserData();
        this.ssoManager = ((ISSOManager.Provider) application).provideSSOManager();
        this.purchaseController = ((PurchaseController.Provider) application).providePurchaseController();
        this.userProfileManager = ((UserProfileManager.Provider) application).provideUserProfileManager();
        this.backend = ((Backend.Provider) application).provideBackend();
        this.purchaseFlowRequested = savedInstanceState != null ? savedInstanceState.getBoolean(PURCHASE_FLOW_REQUESTED_KEY, false) : false;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_account_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(viewOnCreateView, "onCreateView(...)");
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.addView(viewOnCreateView);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        ComposeView composeView2 = composeView;
        ViewTreeViewModelStoreOwner.set(composeView2, this);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1736304608, true, new Function2() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AccountSettingsFragment.onCreateView$lambda$0$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        frameLayout.addView(composeView2);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(final AccountSettingsFragment accountSettingsFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C171@7880L40,172@7951L1061,172@7941L1071:AccountSettingsFragment.kt#z1jqn1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1736304608, i, -1, "com.myscript.nebo.settings.AccountSettingsFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (AccountSettingsFragment.kt:169)");
            }
            Application application = accountSettingsFragment.requireActivity().getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.NeboApplication");
            final NeboApplication neboApplication = (NeboApplication) application;
            final State stateObserveAsState = LiveDataAdapterKt.observeAsState(neboApplication.provideNeboNetworkStateRepository().getNeboNetworkState(), NeboNetworkState.Offline.INSTANCE, composer, 0);
            ThemeKt.m13017NeboTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(-698210984, true, new Function2() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccountSettingsFragment.onCreateView$lambda$0$0$0$1(this.f$0, neboApplication, stateObserveAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$1(final AccountSettingsFragment accountSettingsFragment, NeboApplication neboApplication, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C175@8094L34,183@8701L262,179@8434L2,180@8483L169,173@7977L1013:AccountSettingsFragment.kt#z1jqn1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-698210984, i, -1, "com.myscript.nebo.settings.AccountSettingsFragment.onCreateView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AccountSettingsFragment.kt:173)");
            }
            boolean showNativeSignInDialog = accountSettingsFragment.getShowNativeSignInDialog();
            GoogleSignInHelper googleSignInHelper = neboApplication.getGoogleSignInHelper();
            String string = accountSettingsFragment.getString(C6278R.string.google_server_client_id);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            boolean z = onCreateView$lambda$0$0$0$0(state) instanceof NeboNetworkState.Connected;
            ComposerKt.sourceInformationMarkerStart(composer, -965852838, "CC(remember):AccountSettingsFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(accountSettingsFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountSettingsFragment.onCreateView$lambda$0$0$0$1$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -965833186, "CC(remember):AccountSettingsFragment.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(accountSettingsFragment);
            AccountSettingsFragment$onCreateView$wrapper$1$1$1$1$2$1 accountSettingsFragment$onCreateView$wrapper$1$1$1$1$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || accountSettingsFragment$onCreateView$wrapper$1$1$1$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                accountSettingsFragment$onCreateView$wrapper$1$1$1$1$2$1RememberedValue = new AccountSettingsFragment$onCreateView$wrapper$1$1$1$1$2$1(accountSettingsFragment, null);
                composer.updateRememberedValue(accountSettingsFragment$onCreateView$wrapper$1$1$1$1$2$1RememberedValue);
            }
            Function2 function2 = (Function2) accountSettingsFragment$onCreateView$wrapper$1$1$1$1$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -965841990, "CC(remember):AccountSettingsFragment.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function02 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -965840255, "CC(remember):AccountSettingsFragment.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(accountSettingsFragment);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountSettingsFragment.onCreateView$lambda$0$0$0$1$3$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NativeSignInDialogKt.NativeSignInDialog(showNativeSignInDialog, function0, googleSignInHelper, string, function2, z, function02, (Function0) objRememberedValue3, composer, 1572864, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$1$0$0(AccountSettingsFragment accountSettingsFragment) {
        accountSettingsFragment.setShowNativeSignInDialog(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$1$3$0(AccountSettingsFragment accountSettingsFragment) {
        ActivityResultLauncher<Intent> activityResultLauncher = accountSettingsFragment.loginActivityLauncher;
        Context contextRequireContext = accountSettingsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        activityResultLauncher.launch(LoginActivityHelperKt.getLoginActivityIntent(contextRequireContext, LoginOrigin.SettingsAccount.getValue()));
        return Unit.INSTANCE;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.signInCategoryPref = findPreference(getString(C6079R.string.pref_account_sign_in_category_key));
        this.pendingActivationCategoryPref = findPreference(getString(C6079R.string.pref_account_pending_activation_category_key));
        this.pendingActivationSummaryPref = findPreference(getString(C6079R.string.pref_account_pending_activation_summary_key));
        this.profileCategoryPref = findPreference(getString(C6079R.string.pref_account_profile_category_key));
        this.profilePref = findPreference(getString(C6079R.string.pref_account_profile_key));
        Preference preferenceFindPreference = findPreference(getString(C6079R.string.pref_account_sign_in_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AccountSettingsFragment.onViewCreated$lambda$0(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference2 = findPreference(getString(C6079R.string.pref_account_resend_key));
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda8
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AccountSettingsFragment.onViewCreated$lambda$1(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference3 = findPreference(getString(C6079R.string.pref_account_pending_sign_out_key));
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda9
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AccountSettingsFragment.onViewCreated$lambda$2(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference4 = findPreference(getString(C6079R.string.pref_account_sign_out_key));
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda10
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AccountSettingsFragment.onViewCreated$lambda$3(this.f$0, preference);
                }
            });
        }
        this.freemiumInAppPref = (InAppPreference) findPreference(getString(C6079R.string.pref_account_in_apps_freemium_key));
        this.freemiumInAppSummaryPref = (SummaryPreference) findPreference(getString(C6079R.string.pref_account_in_apps_freemium_summary_key));
        UserProfileManager userProfileManager = this.userProfileManager;
        if (userProfileManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager = null;
        }
        boolean z = !userProfileManager.isWhitelistedVersion();
        InAppPreference inAppPreference = this.freemiumInAppPref;
        if (inAppPreference != null) {
            inAppPreference.setVisible(z);
        }
        SummaryPreference summaryPreference = this.freemiumInAppSummaryPref;
        if (summaryPreference != null) {
            summaryPreference.setVisible(z);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(getString(C6079R.string.pref_account_entitlements_category_key));
        if (preferenceCategory != null) {
            preferenceCategory.setVisible(z);
        }
        UserProfileManager userProfileManager2 = this.userProfileManager;
        if (userProfileManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager2 = null;
        }
        userProfileManager2.addFeatureAccessListener(this.featureAccessListener);
        UserProfileManager userProfileManager3 = this.userProfileManager;
        if (userProfileManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager3 = null;
        }
        boolean zHasPaidEntitlement = userProfileManager3.hasPaidEntitlement();
        UserProfileManager userProfileManager4 = this.userProfileManager;
        if (userProfileManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager4 = null;
        }
        updateFreemiumInApp(zHasPaidEntitlement, userProfileManager4.isFreePeriod());
        Preference preferenceFindPreference5 = findPreference(getString(C6079R.string.pref_account_entitlements_customer_center_key));
        if (preferenceFindPreference5 != null) {
            UserProfileManager userProfileManager5 = this.userProfileManager;
            if (userProfileManager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
                userProfileManager5 = null;
            }
            preferenceFindPreference5.setVisible(userProfileManager5.hasRecurringPurchase());
        }
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda11
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AccountSettingsFragment.onViewCreated$lambda$4(this.f$0, preference);
                }
            });
        }
        SummaryPreference summaryPreference2 = (SummaryPreference) findPreference(getString(C6079R.string.pref_account_app_user_id_summary_key));
        if (summaryPreference2 != null) {
            summaryPreference2.setCopyingEnabled(true);
        } else {
            summaryPreference2 = null;
        }
        this.appUserIdSummaryPref = summaryPreference2;
        ISSOManager iSSOManager = this.ssoManager;
        if (iSSOManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
            iSSOManager = null;
        }
        iSSOManager.addLoginListener(this.loginListener);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67687(null), 3, null);
        updateUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0(AccountSettingsFragment accountSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        accountSettingsFragment.setShowNativeSignInDialog(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1(AccountSettingsFragment accountSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ISSOManager iSSOManager = accountSettingsFragment.ssoManager;
        if (iSSOManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
            iSSOManager = null;
        }
        ISSOManager.reSendEmail$default(iSSOManager, null, 1, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2(final AccountSettingsFragment accountSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context contextRequireContext = accountSettingsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        AccountSettingsFragmentKt.showSignOutConfirmationDialog(contextRequireContext, new Function0() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AccountSettingsFragment.onViewCreated$lambda$2$0(this.f$0);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2$0(AccountSettingsFragment accountSettingsFragment) {
        accountSettingsFragment.signOut();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3(final AccountSettingsFragment accountSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context contextRequireContext = accountSettingsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        AccountSettingsFragmentKt.showSignOutConfirmationDialog(contextRequireContext, new Function0() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AccountSettingsFragment.onViewCreated$lambda$3$0(this.f$0);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3$0(AccountSettingsFragment accountSettingsFragment) {
        accountSettingsFragment.signOut();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v9, types: [T, androidx.appcompat.app.AlertDialog] */
    public static final boolean onViewCreated$lambda$4(AccountSettingsFragment accountSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(accountSettingsFragment.requireActivity());
        FragmentActivity fragmentActivityRequireActivity = accountSettingsFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ComposeView composeView = new ComposeView(fragmentActivityRequireActivity, null, 0, 6, null);
        ComposeView composeView2 = composeView;
        ViewTreeViewModelStoreOwner.set(composeView2, accountSettingsFragment);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(243737949, true, new Function2() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AccountSettingsFragment.onViewCreated$lambda$4$0$0(objectRef, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        Unit unit = Unit.INSTANCE;
        objectRef.element = materialAlertDialogBuilder.setView((View) composeView2).create();
        ((AlertDialog) objectRef.element).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4$0$0(final Ref.ObjectRef objectRef, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C255@12281L109:AccountSettingsFragment.kt#z1jqn1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(243737949, i, -1, "com.myscript.nebo.settings.AccountSettingsFragment.onViewCreated.<anonymous>.<anonymous>.<anonymous> (AccountSettingsFragment.kt:255)");
            }
            CustomerCenterKt.CustomerCenter(null, null, new Function0() { // from class: com.myscript.nebo.settings.AccountSettingsFragment$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AccountSettingsFragment.onViewCreated$lambda$4$0$0$0(objectRef);
                }
            }, composer, 0, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onViewCreated$lambda$4$0$0$0(Ref.ObjectRef objectRef) {
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.AccountSettingsFragment$onViewCreated$7 */
    /* JADX INFO: compiled from: AccountSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.AccountSettingsFragment$onViewCreated$7", m1609f = "AccountSettingsFragment.kt", m1610i = {}, m1611l = {275}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {278}, m1615s = {}, m1616v = 2)
    static final class C67687 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67687(Continuation<? super C67687> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountSettingsFragment.this.new C67687(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67687) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UserProfileManager userProfileManager = AccountSettingsFragment.this.userProfileManager;
                if (userProfileManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
                    userProfileManager = null;
                }
                Flow<Boolean> flowIsPaidSubscriber = userProfileManager.isPaidSubscriber();
                final AccountSettingsFragment accountSettingsFragment = AccountSettingsFragment.this;
                this.label = 1;
                if (flowIsPaidSubscriber.collect(new FlowCollector() { // from class: com.myscript.nebo.settings.AccountSettingsFragment.onViewCreated.7.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        AccountSettingsFragment accountSettingsFragment2 = accountSettingsFragment;
                        UserProfileManager userProfileManager2 = accountSettingsFragment2.userProfileManager;
                        if (userProfileManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
                            userProfileManager2 = null;
                        }
                        accountSettingsFragment2.updateFreemiumInApp(z, userProfileManager2.isFreePeriod());
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
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean(PURCHASE_FLOW_REQUESTED_KEY, this.purchaseFlowRequested);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ISSOManager iSSOManager = this.ssoManager;
        UserProfileManager userProfileManager = null;
        if (iSSOManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
            iSSOManager = null;
        }
        iSSOManager.removeLoginListener(this.loginListener);
        UserProfileManager userProfileManager2 = this.userProfileManager;
        if (userProfileManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
        } else {
            userProfileManager = userProfileManager2;
        }
        userProfileManager.removeFeatureAccessListener(this.featureAccessListener);
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loginActivityLauncher$lambda$0(AccountSettingsFragment accountSettingsFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        accountSettingsFragment.updateUI();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.AccountSettingsFragment$signOut$1 */
    /* JADX INFO: compiled from: AccountSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.AccountSettingsFragment$signOut$1", m1609f = "AccountSettingsFragment.kt", m1610i = {1}, m1611l = {300, 302}, m1612m = "invokeSuspend", m1613n = {LaunchActivity.LaunchRoute.App}, m1614nl = {301, 303}, m1615s = {"L$0"}, m1616v = 2)
    static final class C67711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C67711(Continuation<? super C67711> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountSettingsFragment.this.new C67711(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
        
            if (r5.getGoogleSignInHelper().clearCredentialState(r4) == r0) goto L18;
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
                ISSOManager iSSOManager = AccountSettingsFragment.this.ssoManager;
                if (iSSOManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
                    iSSOManager = null;
                }
                this.label = 1;
                if (iSSOManager.logout(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                AccountSettingsFragment.this.updateUI();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            Application application = AccountSettingsFragment.this.requireActivity().getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.NeboApplication");
            NeboApplication neboApplication = (NeboApplication) application;
            this.L$0 = SpillingKt.nullOutSpilledVariable(neboApplication);
            this.label = 2;
        }
    }

    private final boolean signOut() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67711(null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI() {
        int i = WhenMappings.$EnumSwitchMapping$0[getUserState().ordinal()];
        if (i == 1) {
            Preference preference = this.signInCategoryPref;
            if (preference != null) {
                preference.setVisible(true);
            }
            Preference preference2 = this.pendingActivationCategoryPref;
            if (preference2 != null) {
                preference2.setVisible(false);
            }
            Preference preference3 = this.profileCategoryPref;
            if (preference3 != null) {
                preference3.setVisible(false);
            }
            Preference preference4 = this.profilePref;
            if (preference4 != null) {
                preference4.setTitle(getString(C6079R.string.guest));
            }
            Preference preference5 = this.profilePref;
            if (preference5 != null) {
                preference5.setSummary("");
            }
            SummaryPreference summaryPreference = this.appUserIdSummaryPref;
            if (summaryPreference != null) {
                summaryPreference.setVisible(false);
                return;
            }
            return;
        }
        UserData userData = null;
        if (i == 2) {
            Preference preference6 = this.signInCategoryPref;
            if (preference6 != null) {
                preference6.setVisible(false);
            }
            Preference preference7 = this.profileCategoryPref;
            if (preference7 != null) {
                preference7.setVisible(false);
            }
            Preference preference8 = this.pendingActivationCategoryPref;
            if (preference8 != null) {
                preference8.setVisible(true);
            }
            UserData userData2 = this.userData;
            if (userData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
            } else {
                userData = userData2;
            }
            String mail = userData.getMail();
            Preference preference9 = this.pendingActivationSummaryPref;
            if (preference9 != null) {
                preference9.setSummary(getString(C6821R.string.banner_activate_account, mail));
            }
            SummaryPreference summaryPreference2 = this.appUserIdSummaryPref;
            if (summaryPreference2 != null) {
                summaryPreference2.setVisible(false);
                return;
            }
            return;
        }
        if (i == 3 || i == 4) {
            UserData userData3 = this.userData;
            if (userData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData3 = null;
            }
            String firstName = userData3.getFirstName();
            UserData userData4 = this.userData;
            if (userData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData4 = null;
            }
            String lastName = userData4.getLastName();
            UserData userData5 = this.userData;
            if (userData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData5 = null;
            }
            String mail2 = userData5.getMail();
            String str = (firstName.length() == 0 && lastName.length() == 0) ? mail2 : firstName + " " + lastName;
            Preference preference10 = this.profilePref;
            if (preference10 != null) {
                preference10.setTitle(str);
            }
            Preference preference11 = this.profilePref;
            if (preference11 != null) {
                preference11.setSummary(mail2);
            }
            Preference preference12 = this.signInCategoryPref;
            if (preference12 != null) {
                preference12.setVisible(false);
            }
            Preference preference13 = this.pendingActivationCategoryPref;
            if (preference13 != null) {
                preference13.setVisible(false);
            }
            Preference preference14 = this.profileCategoryPref;
            if (preference14 != null) {
                preference14.setVisible(true);
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67721(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.AccountSettingsFragment$updateUI$1 */
    /* JADX INFO: compiled from: AccountSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.AccountSettingsFragment$updateUI$1", m1609f = "AccountSettingsFragment.kt", m1610i = {}, m1611l = {344}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {345}, m1615s = {}, m1616v = 2)
    static final class C67721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67721(Continuation<? super C67721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountSettingsFragment.this.new C67721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Backend backend = AccountSettingsFragment.this.backend;
                if (backend == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY);
                    backend = null;
                }
                this.label = 1;
                obj = backend.getAppUserId(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            String str = (String) obj;
            SummaryPreference summaryPreference = AccountSettingsFragment.this.appUserIdSummaryPref;
            if (summaryPreference != null) {
                summaryPreference.setSummary(str);
            }
            SummaryPreference summaryPreference2 = AccountSettingsFragment.this.appUserIdSummaryPref;
            if (summaryPreference2 != null) {
                String str2 = str;
                summaryPreference2.setVisible(!(str2 == null || StringsKt.isBlank(str2)));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFreemiumInApp(boolean hasPaidEntitlement, boolean isFreePeriod) {
        AccountFreemiumDisplayState accountFreemiumDisplayStateComputeAccountFreemiumDisplayState = AccountSettingsFragmentKt.computeAccountFreemiumDisplayState(hasPaidEntitlement, isFreePeriod);
        InAppPreference inAppPreference = this.freemiumInAppPref;
        if (inAppPreference != null) {
            boolean zIsPurchased = accountFreemiumDisplayStateComputeAccountFreemiumDisplayState.isPurchased();
            String string = getString(accountFreemiumDisplayStateComputeAccountFreemiumDisplayState.getTitleRes());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            AccountSettingsFragment$purchaseRequestedCallback$1 accountSettingsFragment$purchaseRequestedCallback$1 = this.purchaseRequestedCallback;
            if (accountFreemiumDisplayStateComputeAccountFreemiumDisplayState.isPurchased()) {
                accountSettingsFragment$purchaseRequestedCallback$1 = null;
            }
            inAppPreference.updateState(zIsPurchased, string, accountSettingsFragment$purchaseRequestedCallback$1);
        }
        SummaryPreference summaryPreference = this.freemiumInAppSummaryPref;
        if (summaryPreference != null) {
            summaryPreference.setTitle(getString(accountFreemiumDisplayStateComputeAccountFreemiumDisplayState.getSummaryRes()));
        }
    }

    private final SyncSettingsFragment.UserProfileState getUserState() {
        UserData userData = this.userData;
        UserData userData2 = null;
        if (userData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            userData = null;
        }
        boolean zHasUser = userData.hasUser();
        UserData userData3 = this.userData;
        if (userData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
        } else {
            userData2 = userData3;
        }
        boolean zIsAccountActivated = userData2.isAccountActivated();
        if (zHasUser && !zIsAccountActivated) {
            return SyncSettingsFragment.UserProfileState.MAIL_NOT_VERIFIED;
        }
        if (zHasUser) {
            return SyncSettingsFragment.UserProfileState.CONNECTED;
        }
        return SyncSettingsFragment.UserProfileState.NO_SSO;
    }

    private static final NeboNetworkState onCreateView$lambda$0$0$0$0(State<? extends NeboNetworkState> state) {
        return state.getValue();
    }
}
