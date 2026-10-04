package com.myscript.nebo.settings;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import com.dropbox.core.p013v2.DbxClientV2;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.android.utils.ProgressDialogFragment;
import com.myscript.android.utils.preference.InAppPreference;
import com.myscript.android.utils.preference.SummaryPreference;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.NeboBaseActivity;
import com.myscript.nebo.account.Feature;
import com.myscript.nebo.account.FeatureAccessListener;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.analytics.firebase.LoginOrigin;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.cloudsync.settings.ProviderModel;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.dms.cloud.common.api.AccountInfo;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.dropbox.DropboxClient;
import com.myscript.nebo.dms.gdrive.C6278R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.freemium.PurchaseController;
import com.myscript.nebo.p034ui.compose.NativeSignInDialogKt;
import com.myscript.nebo.sso.C6821R;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.sso.p032ui.login.GoogleSignInHelper;
import com.myscript.nebo.sso.p032ui.login.LoginActivityHelperKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;

/* JADX INFO: compiled from: SyncSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002*\u0004\u001b1SV\b\u0007\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0002stB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u0002042\u0006\u0010:\u001a\u000206H\u0016J$\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010M\u001a\u00020\u00122\u0006\u0010N\u001a\u00020OH\u0016J\u001a\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u00020<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010X\u001a\u000204H\u0016J\u0010\u0010]\u001a\u0002042\u0006\u0010^\u001a\u00020\u0012H\u0002J\u0010\u0010_\u001a\u0002042\u0006\u0010`\u001a\u000208H\u0002J\b\u0010a\u001a\u00020bH\u0002J\b\u0010c\u001a\u000204H\u0002J\u0012\u0010d\u001a\u0002042\b\b\u0002\u0010e\u001a\u00020fH\u0002J\b\u0010g\u001a\u000204H\u0002J\b\u0010h\u001a\u000204H\u0002J(\u0010i\u001a\u0002042\n\b\u0002\u0010`\u001a\u0004\u0018\u0001082\b\b\u0002\u0010j\u001a\u00020k2\b\b\u0002\u0010l\u001a\u00020kH\u0002J\u0012\u0010m\u001a\u0002042\b\u0010n\u001a\u0004\u0018\u00010fH\u0002J\u0010\u0010o\u001a\u0002042\u0006\u0010p\u001a\u00020\u0012H\u0002J\u0010\u0010q\u001a\u0002042\u0006\u0010`\u001a\u000208H\u0002J\b\u0010r\u001a\u000204H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0014\u0010A\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010DR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0010\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0004\n\u0002\u0010TR\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u001c\u0010Y\u001a\u0010\u0012\f\u0012\n \\*\u0004\u0018\u00010[0[0ZX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u²\u0006\n\u0010v\u001a\u00020wX\u008a\u0084\u0002"}, m1599d2 = {"Lcom/myscript/nebo/settings/SyncSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "cloudManager", "Lcom/myscript/nebo/cloudsync/CloudManager;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "purchaseController", "Lcom/myscript/nebo/freemium/PurchaseController;", "userProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "<set-?>", "", "showNativeSignInDialog", "getShowNativeSignInDialog", "()Z", "setShowNativeSignInDialog", "(Z)V", "showNativeSignInDialog$delegate", "Landroidx/compose/runtime/MutableState;", "loginListener", "com/myscript/nebo/settings/SyncSettingsFragment$loginListener$1", "Lcom/myscript/nebo/settings/SyncSettingsFragment$loginListener$1;", "featureAccessListener", "Lcom/myscript/nebo/account/FeatureAccessListener;", "isGDriveVisible", "signInCategoryPref", "Landroidx/preference/Preference;", "pendingActivationCategoryPref", "pendingActivationSummaryPref", "cloudChooseCategoryPref", "syncCategoryPref", "freeUsageLimitationSummaryPref", "cloudProviderPref", "Lcom/myscript/nebo/settings/CloudProviderPreference;", "disconnectPref", "cloudSyncGDrivePref", "freemiumInAppPref", "Lcom/myscript/android/utils/preference/InAppPreference;", "freemiumInAppSummaryPref", "Lcom/myscript/android/utils/preference/SummaryPreference;", "purchaseFlowRequested", "purchaseRequestedCallback", "com/myscript/nebo/settings/SyncSettingsFragment$purchaseRequestedCallback$1", "Lcom/myscript/nebo/settings/SyncSettingsFragment$purchaseRequestedCallback$1;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onSaveInstanceState", "outState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "onMenuItemClicked", "menuItem", "Landroid/view/MenuItem;", "onViewCreated", "view", "cloudSyncInitializedListener", "com/myscript/nebo/settings/SyncSettingsFragment$cloudSyncInitializedListener$1", "Lcom/myscript/nebo/settings/SyncSettingsFragment$cloudSyncInitializedListener$1;", "cloudDisconnectedListener", "com/myscript/nebo/settings/SyncSettingsFragment$cloudDisconnectedListener$1", "Lcom/myscript/nebo/settings/SyncSettingsFragment$cloudDisconnectedListener$1;", "onDestroyView", "loginActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onAutoSyncToggled", "enabled", "onDisconnectFromCloudRequested", "label", "getUserState", "Lcom/myscript/nebo/settings/SyncSettingsFragment$UserProfileState;", "updateCloudSettingsUI", "updateCloudProviders", "cloudProviderType", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "asyncUpdateGDriveUserInfo", "asyncUpdateDropboxUserInfo", "updateCloudProviderInfo", "providerUsage", "", "providerMaxSpace", "startCloudLogin", "provider", "updateFreemiumInApp", "hasUnlimitedPagesAccess", "showDisconnectProgress", "dismissDisconnectProgress", "Companion", "UserProfileState", "app_standardRelease", "networkState", "Lcom/myscript/nebo/common/network/NeboNetworkState;"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SyncSettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    private static final String SHOW_NATIVE_SIGN_IN_DIALOG_KEY = "SHOW_NATIVE_SIGN_IN_DIALOG_KEY";
    public static final String TAG = "SyncSettingsFragmentTag";
    private Preference cloudChooseCategoryPref;
    private CloudManager cloudManager;
    private CloudProviderPreference cloudProviderPref;
    private Preference cloudSyncGDrivePref;
    private Preference disconnectPref;
    private Preference freeUsageLimitationSummaryPref;
    private InAppPreference freemiumInAppPref;
    private SummaryPreference freemiumInAppSummaryPref;
    private LibraryRepository libraryRepository;
    private final ActivityResultLauncher<Intent> loginActivityLauncher;
    private Navigator navigator;
    private Preference pendingActivationCategoryPref;
    private Preference pendingActivationSummaryPref;
    private PurchaseController purchaseController;
    private boolean purchaseFlowRequested;
    private Preference signInCategoryPref;
    private ISSOManager ssoManager;
    private Preference syncCategoryPref;
    private UserData userData;
    private UserProfileManager userProfileManager;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: showNativeSignInDialog$delegate, reason: from kotlin metadata */
    private final MutableState showNativeSignInDialog = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private final SyncSettingsFragment$loginListener$1 loginListener = new ISSOManager.OnLoginListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$loginListener$1
        @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
        public void onLogin() {
            this.this$0.updateCloudSettingsUI();
        }

        @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
        public void onLogout() {
            this.this$0.updateCloudSettingsUI();
        }
    };
    private final FeatureAccessListener featureAccessListener = new FeatureAccessListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda0
        @Override // com.myscript.nebo.account.FeatureAccessListener
        public final void featuresAccessChanged(Map map) {
            SyncSettingsFragment.featureAccessListener$lambda$0(this.f$0, map);
        }
    };
    private final SyncSettingsFragment$purchaseRequestedCallback$1 purchaseRequestedCallback = new SyncSettingsFragment$purchaseRequestedCallback$1(this);
    private final SyncSettingsFragment$cloudSyncInitializedListener$1 cloudSyncInitializedListener = new CloudManager.CloudSyncInitializedListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$cloudSyncInitializedListener$1
        @Override // com.myscript.nebo.cloudsync.CloudManager.CloudSyncInitializedListener
        public void onCloudSyncInitialized() {
            this.this$0.updateCloudSettingsUI();
        }
    };
    private final SyncSettingsFragment$cloudDisconnectedListener$1 cloudDisconnectedListener = new CloudManager.CloudDisconnectedListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$cloudDisconnectedListener$1
        @Override // com.myscript.nebo.cloudsync.CloudManager.CloudDisconnectedListener
        public void onCloudDisconnecting(CloudManager.CloudProviderType provider) {
            LifecycleOwner viewLifecycleOwner;
            Intrinsics.checkNotNullParameter(provider, "provider");
            if (this.this$0.getView() == null || (viewLifecycleOwner = this.this$0.getViewLifecycleOwner()) == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain(), null, new C6793xa30ae2e6(this.this$0, provider, null), 2, null);
        }

        @Override // com.myscript.nebo.cloudsync.CloudManager.CloudDisconnectedListener
        public void onCloudDisconnected(CloudManager.CloudProviderType provider) {
            LifecycleOwner viewLifecycleOwner;
            Intrinsics.checkNotNullParameter(provider, "provider");
            if (this.this$0.getView() == null || (viewLifecycleOwner = this.this$0.getViewLifecycleOwner()) == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain(), null, new C6792x89617395(this.this$0, null), 2, null);
        }
    };

    /* JADX INFO: compiled from: SyncSettingsFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CloudManager.CloudProviderType.values().length];
            try {
                iArr[CloudManager.CloudProviderType.GDrive.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CloudManager.CloudProviderType.Dropbox.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CloudManager.CloudProviderType.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[UserProfileState.values().length];
            try {
                iArr2[UserProfileState.CLOUD_NOT_ALLOWED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[UserProfileState.NO_SSO.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[UserProfileState.MAIL_NOT_VERIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[UserProfileState.CONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[UserProfileState.CLOUD_CONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
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

    /* JADX WARN: Type inference failed for: r0v3, types: [com.myscript.nebo.settings.SyncSettingsFragment$loginListener$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.myscript.nebo.settings.SyncSettingsFragment$cloudSyncInitializedListener$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.myscript.nebo.settings.SyncSettingsFragment$cloudDisconnectedListener$1] */
    public SyncSettingsFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SyncSettingsFragment.loginActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.loginActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SyncSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/settings/SyncSettingsFragment$UserProfileState;", "", "<init>", "(Ljava/lang/String;I)V", "NO_SSO", "CLOUD_NOT_ALLOWED", "MAIL_NOT_VERIFIED", "CONNECTED", "CLOUD_CONNECTED", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class UserProfileState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UserProfileState[] $VALUES;
        public static final UserProfileState NO_SSO = new UserProfileState("NO_SSO", 0);
        public static final UserProfileState CLOUD_NOT_ALLOWED = new UserProfileState("CLOUD_NOT_ALLOWED", 1);
        public static final UserProfileState MAIL_NOT_VERIFIED = new UserProfileState("MAIL_NOT_VERIFIED", 2);
        public static final UserProfileState CONNECTED = new UserProfileState("CONNECTED", 3);
        public static final UserProfileState CLOUD_CONNECTED = new UserProfileState("CLOUD_CONNECTED", 4);

        private static final /* synthetic */ UserProfileState[] $values() {
            return new UserProfileState[]{NO_SSO, CLOUD_NOT_ALLOWED, MAIL_NOT_VERIFIED, CONNECTED, CLOUD_CONNECTED};
        }

        public static EnumEntries<UserProfileState> getEntries() {
            return $ENTRIES;
        }

        public static UserProfileState valueOf(String str) {
            return (UserProfileState) Enum.valueOf(UserProfileState.class, str);
        }

        public static UserProfileState[] values() {
            return (UserProfileState[]) $VALUES.clone();
        }

        private UserProfileState(String str, int i) {
        }

        static {
            UserProfileState[] userProfileStateArr$values = $values();
            $VALUES = userProfileStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(userProfileStateArr$values);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShowNativeSignInDialog() {
        return ((Boolean) this.showNativeSignInDialog.getValue()).booleanValue();
    }

    private final void setShowNativeSignInDialog(boolean z) {
        this.showNativeSignInDialog.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void featureAccessListener$lambda$0(SyncSettingsFragment syncSettingsFragment, Map access) {
        Intrinsics.checkNotNullParameter(access, "access");
        syncSettingsFragment.updateCloudSettingsUI();
        Object obj = access.get(Feature.UnlimitedPages);
        if (obj == null) {
            obj = false;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (syncSettingsFragment.purchaseFlowRequested && zBooleanValue) {
            NeboFirebaseEvent.PaymentComplete.log(new Function1() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SyncSettingsFragment.featureAccessListener$lambda$0$1((Bundle) obj2);
                }
            });
        }
        syncSettingsFragment.updateFreemiumInApp(zBooleanValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit featureAccessListener$lambda$0$1(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("origin", "panel_settings_cta");
        return Unit.INSTANCE;
    }

    private final boolean isGDriveVisible() {
        if (getResources().getBoolean(C6079R.bool.custom_play_services_check)) {
            return CommonUtils.isGooglePlayServiceAvailable(getActivity());
        }
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(C6079R.xml.sync_settings);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        this.libraryRepository = ((LibraryRepository.Provider) application).provideLibraryRepository();
        ComponentCallbacks2 application2 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.myscript.nebo.cloudsync.CloudManager.Provider");
        this.cloudManager = ((CloudManager.Provider) application2).provideCloudManager();
        ComponentCallbacks2 application3 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.myscript.nebo.sso.model.UserData.Provider");
        this.userData = ((UserData.Provider) application3).provideUserData();
        ComponentCallbacks2 application4 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application4, "null cannot be cast to non-null type com.myscript.nebo.sso.api.ISSOManager.Provider");
        this.ssoManager = ((ISSOManager.Provider) application4).provideSSOManager();
        ComponentCallbacks2 application5 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application5, "null cannot be cast to non-null type com.myscript.nebo.freemium.PurchaseController.Provider");
        this.purchaseController = ((PurchaseController.Provider) application5).providePurchaseController();
        ComponentCallbacks2 application6 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application6, "null cannot be cast to non-null type com.myscript.nebo.account.UserProfileManager.Provider");
        this.userProfileManager = ((UserProfileManager.Provider) application6).provideUserProfileManager();
        setShowNativeSignInDialog(savedInstanceState != null ? savedInstanceState.getBoolean(SHOW_NATIVE_SIGN_IN_DIALOG_KEY, false) : false);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean(SHOW_NATIVE_SIGN_IN_DIALOG_KEY, getShowNativeSignInDialog());
        super.onSaveInstanceState(outState);
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
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1476253038, true, new Function2() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SyncSettingsFragment.onCreateView$lambda$0$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        frameLayout.addView(composeView2);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(final SyncSettingsFragment syncSettingsFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C170@7959L40,171@8030L1002,171@8020L1012:SyncSettingsFragment.kt#z1jqn1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1476253038, i, -1, "com.myscript.nebo.settings.SyncSettingsFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (SyncSettingsFragment.kt:168)");
            }
            Application application = syncSettingsFragment.requireActivity().getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.NeboApplication");
            final NeboApplication neboApplication = (NeboApplication) application;
            final State stateObserveAsState = LiveDataAdapterKt.observeAsState(neboApplication.provideNeboNetworkStateRepository().getNeboNetworkState(), NeboNetworkState.Offline.INSTANCE, composer, 0);
            ThemeKt.m13017NeboTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(1096351974, true, new Function2() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SyncSettingsFragment.onCreateView$lambda$0$0$0$1(this.f$0, neboApplication, stateObserveAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$1(final SyncSettingsFragment syncSettingsFragment, NeboApplication neboApplication, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C174@8173L34,181@8719L264,178@8512L158,172@8056L954:SyncSettingsFragment.kt#z1jqn1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1096351974, i, -1, "com.myscript.nebo.settings.SyncSettingsFragment.onCreateView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SyncSettingsFragment.kt:172)");
            }
            boolean showNativeSignInDialog = syncSettingsFragment.getShowNativeSignInDialog();
            GoogleSignInHelper googleSignInHelper = neboApplication.getGoogleSignInHelper();
            String string = syncSettingsFragment.getString(C6278R.string.google_server_client_id);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            boolean z = onCreateView$lambda$0$0$0$0(state) instanceof NeboNetworkState.Connected;
            ComposerKt.sourceInformationMarkerStart(composer, 1327264104, "CC(remember):SyncSettingsFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(syncSettingsFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SyncSettingsFragment.onCreateView$lambda$0$0$0$1$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1327281806, "CC(remember):SyncSettingsFragment.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(syncSettingsFragment);
            SyncSettingsFragment$onCreateView$1$1$1$1$2$1 syncSettingsFragment$onCreateView$1$1$1$1$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || syncSettingsFragment$onCreateView$1$1$1$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                syncSettingsFragment$onCreateView$1$1$1$1$2$1RememberedValue = new SyncSettingsFragment$onCreateView$1$1$1$1$2$1(syncSettingsFragment, null);
                composer.updateRememberedValue(syncSettingsFragment$onCreateView$1$1$1$1$2$1RememberedValue);
            }
            Function2 function2 = (Function2) syncSettingsFragment$onCreateView$1$1$1$1$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1327275076, "CC(remember):SyncSettingsFragment.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(syncSettingsFragment);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SyncSettingsFragment.onCreateView$lambda$0$0$0$1$2$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NativeSignInDialogKt.NativeSignInDialog(showNativeSignInDialog, function0, googleSignInHelper, string, function2, z, null, (Function0) objRememberedValue2, composer, 0, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$1$0$0(SyncSettingsFragment syncSettingsFragment) {
        syncSettingsFragment.setShowNativeSignInDialog(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$1$2$0(SyncSettingsFragment syncSettingsFragment) {
        ActivityResultLauncher<Intent> activityResultLauncher = syncSettingsFragment.loginActivityLauncher;
        Context contextRequireContext = syncSettingsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        activityResultLauncher.launch(LoginActivityHelperKt.getLoginActivityIntent(contextRequireContext, LoginOrigin.Sync.getValue()));
        return Unit.INSTANCE;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_sync_title;
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
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.signInCategoryPref = findPreference(getString(C6079R.string.pref_sync_sign_in_category_key));
        this.pendingActivationCategoryPref = findPreference(getString(C6079R.string.pref_sync_pending_activation_category_key));
        this.pendingActivationSummaryPref = findPreference(getString(C6079R.string.pref_sync_pending_activation_summary_key));
        this.cloudChooseCategoryPref = findPreference(getString(C6079R.string.pref_sync_cloud_choose_category_key));
        this.syncCategoryPref = findPreference(getString(C6079R.string.pref_sync_category_key));
        this.freeUsageLimitationSummaryPref = findPreference(getString(C6079R.string.pref_sync_free_usage_limitation_key));
        this.cloudProviderPref = (CloudProviderPreference) findPreference(getString(C6079R.string.pref_sync_cloud_provider_key));
        this.disconnectPref = findPreference(getString(C6079R.string.pref_sync_cloud_disconnect_key));
        this.cloudSyncGDrivePref = findPreference(getString(C6079R.string.pref_cloudsync_gdrive_key));
        Preference preferenceFindPreference = findPreference(getString(C6079R.string.pref_sync_sign_in_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda13
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SyncSettingsFragment.onViewCreated$lambda$0(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference2 = findPreference(getString(C6079R.string.pref_cloudsync_dropbox_key));
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SyncSettingsFragment.onViewCreated$lambda$1(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference3 = findPreference(getString(C6079R.string.pref_cloudsync_gdrive_key));
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda2
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SyncSettingsFragment.onViewCreated$lambda$2(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference4 = findPreference(getString(C6079R.string.pref_autosync_enabled_key));
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda3
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return SyncSettingsFragment.onViewCreated$lambda$3(view, this, preference, obj);
                }
            });
        }
        Preference preference = this.disconnectPref;
        if (preference != null) {
            preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda4
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference2) {
                    return SyncSettingsFragment.onViewCreated$lambda$4(this.f$0, preference2);
                }
            });
        }
        this.freemiumInAppPref = (InAppPreference) findPreference(getString(C6079R.string.pref_account_in_apps_freemium_key));
        this.freemiumInAppSummaryPref = (SummaryPreference) findPreference(getString(C6079R.string.pref_account_in_apps_freemium_summary_key));
        UserProfileManager userProfileManager = this.userProfileManager;
        CloudManager cloudManager = null;
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
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(getString(C6079R.string.pref_sync_in_apps_category_key));
        if (preferenceCategory != null) {
            preferenceCategory.setVisible(z);
        }
        UserProfileManager userProfileManager2 = this.userProfileManager;
        if (userProfileManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager2 = null;
        }
        updateFreemiumInApp(userProfileManager2.hasFeatureAccess(Feature.UnlimitedPages));
        updateCloudSettingsUI();
        UserProfileManager userProfileManager3 = this.userProfileManager;
        if (userProfileManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager3 = null;
        }
        userProfileManager3.addFeatureAccessListener(this.featureAccessListener);
        ISSOManager iSSOManager = this.ssoManager;
        if (iSSOManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
            iSSOManager = null;
        }
        iSSOManager.addLoginListener(this.loginListener);
        CloudManager cloudManager2 = this.cloudManager;
        if (cloudManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
            cloudManager2 = null;
        }
        cloudManager2.addCloudSyncInitializedListener(this.cloudSyncInitializedListener);
        CloudManager cloudManager3 = this.cloudManager;
        if (cloudManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
        } else {
            cloudManager = cloudManager3;
        }
        cloudManager.addCloudDisconnectedListener(this.cloudDisconnectedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0(SyncSettingsFragment syncSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        syncSettingsFragment.setShowNativeSignInDialog(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1(SyncSettingsFragment syncSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        syncSettingsFragment.startCloudLogin(SyncSettingsFragmentKt.ProviderDropbox.getType());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2(SyncSettingsFragment syncSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        syncSettingsFragment.startCloudLogin(SyncSettingsFragmentKt.ProviderGDrive.getType());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3(View view, final SyncSettingsFragment syncSettingsFragment, Preference preference, final Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        view.post(new Runnable() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                SyncSettingsFragment.onViewCreated$lambda$3$0(this.f$0, obj);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$0(SyncSettingsFragment syncSettingsFragment, Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        syncSettingsFragment.onAutoSyncToggled(((Boolean) obj).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$4(final SyncSettingsFragment syncSettingsFragment, Preference it) {
        ProviderModel providerModel;
        Intrinsics.checkNotNullParameter(it, "it");
        CloudManager cloudManager = syncSettingsFragment.cloudManager;
        if (cloudManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
            cloudManager = null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[cloudManager.getConnectedProvider().ordinal()];
        if (i == 1) {
            providerModel = SyncSettingsFragmentKt.ProviderGDrive;
        } else if (i == 2) {
            providerModel = SyncSettingsFragmentKt.ProviderDropbox;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            providerModel = null;
        }
        if (providerModel == null) {
            return false;
        }
        final String string = syncSettingsFragment.getResources().getString(C6079R.string.disconnect_cloud, syncSettingsFragment.getResources().getString(providerModel.getName()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        new MaterialAlertDialogBuilder(syncSettingsFragment.requireContext()).setMessage(C6079R.string.sso_login_disconnect_dialog_message).setPositiveButton((CharSequence) string, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.settings.SyncSettingsFragment$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.onDisconnectFromCloudRequested(string);
            }
        }).setNegativeButton(C6079R.string.sso_login_disconnect_dialog_negative_button, (DialogInterface.OnClickListener) null).show();
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        CloudManager cloudManager = this.cloudManager;
        ISSOManager iSSOManager = null;
        if (cloudManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
            cloudManager = null;
        }
        cloudManager.removeCloudSyncInitializedListener(this.cloudSyncInitializedListener);
        CloudManager cloudManager2 = this.cloudManager;
        if (cloudManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
            cloudManager2 = null;
        }
        cloudManager2.removeCloudDisconnectedListener(this.cloudDisconnectedListener);
        UserProfileManager userProfileManager = this.userProfileManager;
        if (userProfileManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager = null;
        }
        userProfileManager.removeFeatureAccessListener(this.featureAccessListener);
        ISSOManager iSSOManager2 = this.ssoManager;
        if (iSSOManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
        } else {
            iSSOManager = iSSOManager2;
        }
        iSSOManager.removeLoginListener(this.loginListener);
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loginActivityLauncher$lambda$0(SyncSettingsFragment syncSettingsFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "<unused var>");
        syncSettingsFragment.updateCloudSettingsUI();
    }

    private final void onAutoSyncToggled(boolean enabled) {
        LibraryRepository libraryRepository = this.libraryRepository;
        if (libraryRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
            libraryRepository = null;
        }
        libraryRepository.setAutoSyncEnabled(enabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDisconnectFromCloudRequested(String label) {
        showDisconnectProgress(label);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C67941(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$onDisconnectFromCloudRequested$1 */
    /* JADX INFO: compiled from: SyncSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$onDisconnectFromCloudRequested$1", m1609f = "SyncSettingsFragment.kt", m1610i = {0, 1, 2, 3}, m1611l = {PDFACompliance.e_PDFA3_6_1, PDFACompliance.e_PDFA3_7_1, PDFACompliance.e_PDFA3_7_1, PDFACompliance.e_PDFA3_7_1}, m1612m = "invokeSuspend", m1613n = {"baseActivity", "baseActivity", "baseActivity", "baseActivity"}, m1614nl = {PDFACompliance.e_PDFA3_7_1, 377, 377, 378}, m1615s = {"L$0", "L$0", "L$0", "L$0"}, m1616v = 2)
    static final class C67941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C67941(Continuation<? super C67941> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SyncSettingsFragment.this.new C67941(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a0, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r11, r2, r3) == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00d0, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.NonCancellable.INSTANCE.plus(kotlinx.coroutines.Dispatchers.getMain()), new com.myscript.nebo.settings.SyncSettingsFragment.C67941.AnonymousClass2(r10.this$0, null), r10) != r0) goto L38;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v9, types: [kotlin.jvm.functions.Function2] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v6, types: [kotlin.coroutines.Continuation] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            NeboBaseActivity neboBaseActivity;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object objNullOutSpilledVariable = this.label;
            AnonymousClass2 anonymousClass2 = 4;
            C67941 c67941 = 3;
            try {
                try {
                } catch (CancellationException e) {
                    throw e;
                } catch (Exception e2) {
                    Log.e(SyncSettingsFragment.TAG, "Disconnect failed", e2);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(objNullOutSpilledVariable);
                    this.label = c67941;
                }
            } catch (Throwable th) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(objNullOutSpilledVariable);
                this.L$1 = th;
                this.label = anonymousClass2;
                if (BuildersKt.withContext(NonCancellable.INSTANCE.plus(Dispatchers.getMain()), new AnonymousClass2(SyncSettingsFragment.this, null), this) != coroutine_suspended) {
                    throw th;
                }
            }
            if (objNullOutSpilledVariable == 0) {
                ResultKt.throwOnFailure(obj);
                FragmentActivity activity = SyncSettingsFragment.this.getActivity();
                neboBaseActivity = activity instanceof NeboBaseActivity ? (NeboBaseActivity) activity : null;
                if (neboBaseActivity == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(neboBaseActivity);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(neboBaseActivity, SyncSettingsFragment.this, null), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (objNullOutSpilledVariable != 1) {
                if (objNullOutSpilledVariable == 2 || objNullOutSpilledVariable == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (objNullOutSpilledVariable != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Throwable th2 = (Throwable) this.L$1;
                ResultKt.throwOnFailure(obj);
                throw th2;
            }
            neboBaseActivity = (NeboBaseActivity) this.L$0;
            ResultKt.throwOnFailure(obj);
            CoroutineContext coroutineContextPlus = NonCancellable.INSTANCE.plus(Dispatchers.getMain());
            anonymousClass2 = new AnonymousClass2(SyncSettingsFragment.this, null);
            c67941 = this;
            objNullOutSpilledVariable = SpillingKt.nullOutSpilledVariable(neboBaseActivity);
            this.L$0 = objNullOutSpilledVariable;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$onDisconnectFromCloudRequested$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: SyncSettingsFragment.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$onDisconnectFromCloudRequested$1$1", m1609f = "SyncSettingsFragment.kt", m1610i = {}, m1611l = {363}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {364}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ NeboBaseActivity $baseActivity;
            int label;
            final /* synthetic */ SyncSettingsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NeboBaseActivity neboBaseActivity, SyncSettingsFragment syncSettingsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$baseActivity = neboBaseActivity;
                this.this$0 = syncSettingsFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$baseActivity, this.this$0, continuation);
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
                    this.$baseActivity.driveSignOut();
                    CloudManager cloudManager = this.this$0.cloudManager;
                    if (cloudManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
                        cloudManager = null;
                    }
                    this.label = 1;
                    if (cloudManager.disconnect(this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$onDisconnectFromCloudRequested$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: SyncSettingsFragment.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$onDisconnectFromCloudRequested$1$2", m1609f = "SyncSettingsFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SyncSettingsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(SyncSettingsFragment syncSettingsFragment, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = syncSettingsFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.dismissDisconnectProgress();
                    if (this.this$0.isAdded() && this.this$0.getView() != null) {
                        this.this$0.updateCloudSettingsUI();
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final UserProfileState getUserState() {
        UserProfileManager userProfileManager = this.userProfileManager;
        CloudManager cloudManager = null;
        if (userProfileManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager = null;
        }
        boolean zHasFeatureAccess = userProfileManager.hasFeatureAccess(Feature.CloudSync);
        UserData userData = this.userData;
        if (userData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            userData = null;
        }
        boolean zHasUser = userData.hasUser();
        UserData userData2 = this.userData;
        if (userData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            userData2 = null;
        }
        boolean zIsAccountActivated = userData2.isAccountActivated();
        CloudManager cloudManager2 = this.cloudManager;
        if (cloudManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
        } else {
            cloudManager = cloudManager2;
        }
        boolean zIsCloudConnected = cloudManager.isCloudConnected();
        if (!zHasFeatureAccess) {
            return UserProfileState.CLOUD_NOT_ALLOWED;
        }
        if (zHasUser && !zIsAccountActivated) {
            return UserProfileState.MAIL_NOT_VERIFIED;
        }
        if (zHasUser && zHasFeatureAccess && zIsCloudConnected) {
            return UserProfileState.CLOUD_CONNECTED;
        }
        if (zHasUser) {
            return UserProfileState.CONNECTED;
        }
        return UserProfileState.NO_SSO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCloudSettingsUI() {
        int i = WhenMappings.$EnumSwitchMapping$1[getUserState().ordinal()];
        if (i == 1) {
            Preference preference = this.freeUsageLimitationSummaryPref;
            if (preference != null) {
                preference.setVisible(true);
            }
            Preference preference2 = this.signInCategoryPref;
            if (preference2 != null) {
                preference2.setVisible(false);
            }
            Preference preference3 = this.pendingActivationCategoryPref;
            if (preference3 != null) {
                preference3.setVisible(false);
            }
            Preference preference4 = this.cloudChooseCategoryPref;
            if (preference4 != null) {
                preference4.setVisible(false);
            }
            Preference preference5 = this.syncCategoryPref;
            if (preference5 != null) {
                preference5.setVisible(false);
                return;
            }
            return;
        }
        if (i == 2) {
            Preference preference6 = this.freeUsageLimitationSummaryPref;
            if (preference6 != null) {
                preference6.setVisible(false);
            }
            Preference preference7 = this.signInCategoryPref;
            if (preference7 != null) {
                preference7.setVisible(true);
            }
            Preference preference8 = this.pendingActivationCategoryPref;
            if (preference8 != null) {
                preference8.setVisible(false);
            }
            Preference preference9 = this.cloudChooseCategoryPref;
            if (preference9 != null) {
                preference9.setVisible(false);
            }
            Preference preference10 = this.syncCategoryPref;
            if (preference10 != null) {
                preference10.setVisible(false);
                return;
            }
            return;
        }
        UserData userData = null;
        if (i == 3) {
            Preference preference11 = this.freeUsageLimitationSummaryPref;
            if (preference11 != null) {
                preference11.setVisible(false);
            }
            Preference preference12 = this.signInCategoryPref;
            if (preference12 != null) {
                preference12.setVisible(false);
            }
            Preference preference13 = this.cloudChooseCategoryPref;
            if (preference13 != null) {
                preference13.setVisible(false);
            }
            Preference preference14 = this.pendingActivationCategoryPref;
            if (preference14 != null) {
                preference14.setVisible(true);
            }
            UserData userData2 = this.userData;
            if (userData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
            } else {
                userData = userData2;
            }
            String mail = userData.getMail();
            Preference preference15 = this.pendingActivationSummaryPref;
            if (preference15 != null) {
                preference15.setSummary(getString(C6821R.string.banner_activate_account, mail));
            }
            Preference preference16 = this.syncCategoryPref;
            if (preference16 != null) {
                preference16.setVisible(false);
                return;
            }
            return;
        }
        if (i != 4) {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            Preference preference17 = this.freeUsageLimitationSummaryPref;
            if (preference17 != null) {
                preference17.setVisible(false);
            }
            Preference preference18 = this.cloudChooseCategoryPref;
            if (preference18 != null) {
                preference18.setVisible(false);
            }
            Preference preference19 = this.syncCategoryPref;
            if (preference19 != null) {
                preference19.setVisible(true);
            }
            CloudProviderPreference cloudProviderPreference = this.cloudProviderPref;
            if (cloudProviderPreference != null) {
                cloudProviderPreference.setEnabled(true);
            }
            updateCloudProviders$default(this, null, 1, null);
            return;
        }
        Preference preference20 = this.freeUsageLimitationSummaryPref;
        if (preference20 != null) {
            preference20.setVisible(false);
        }
        Preference preference21 = this.signInCategoryPref;
        if (preference21 != null) {
            preference21.setVisible(false);
        }
        Preference preference22 = this.pendingActivationCategoryPref;
        if (preference22 != null) {
            preference22.setVisible(false);
        }
        Preference preference23 = this.cloudChooseCategoryPref;
        if (preference23 != null) {
            preference23.setVisible(true);
        }
        Preference preference24 = this.cloudSyncGDrivePref;
        if (preference24 != null) {
            preference24.setVisible(isGDriveVisible());
        }
        Preference preference25 = this.syncCategoryPref;
        if (preference25 != null) {
            preference25.setVisible(false);
        }
    }

    static /* synthetic */ void updateCloudProviders$default(SyncSettingsFragment syncSettingsFragment, CloudManager.CloudProviderType cloudProviderType, int i, Object obj) {
        if ((i & 1) != 0) {
            CloudManager cloudManager = syncSettingsFragment.cloudManager;
            if (cloudManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cloudManager");
                cloudManager = null;
            }
            cloudProviderType = cloudManager.getConnectedProvider();
        }
        syncSettingsFragment.updateCloudProviders(cloudProviderType);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$updateCloudProviders$1 */
    /* JADX INFO: compiled from: SyncSettingsFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C67981 extends FunctionReferenceImpl implements Function0<Unit> {
        C67981(Object obj) {
            super(0, obj, SyncSettingsFragment.class, "asyncUpdateGDriveUserInfo", "asyncUpdateGDriveUserInfo()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SyncSettingsFragment) this.receiver).asyncUpdateGDriveUserInfo();
        }
    }

    private final void updateCloudProviders(CloudManager.CloudProviderType cloudProviderType) {
        Pair pairM1606to;
        int i = WhenMappings.$EnumSwitchMapping$0[cloudProviderType.ordinal()];
        if (i == 1) {
            pairM1606to = TuplesKt.m1606to(SyncSettingsFragmentKt.ProviderGDrive, new C67981(this));
        } else if (i == 2) {
            pairM1606to = TuplesKt.m1606to(SyncSettingsFragmentKt.ProviderDropbox, new C67992(this));
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            pairM1606to = TuplesKt.m1606to(null, null);
        }
        ProviderModel providerModel = (ProviderModel) pairM1606to.component1();
        KFunction kFunction = (KFunction) pairM1606to.component2();
        if (providerModel != null) {
            String string = getResources().getString(providerModel.getName());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Preference preference = this.disconnectPref;
            if (preference != null) {
                preference.setTitle(getResources().getString(C6079R.string.disconnect_cloud, string));
            }
            CloudProviderPreference cloudProviderPreference = this.cloudProviderPref;
            if (cloudProviderPreference != null) {
                cloudProviderPreference.setIcon(providerModel.getIconResId());
            }
            CloudProviderPreference cloudProviderPreference2 = this.cloudProviderPref;
            if (cloudProviderPreference2 != null) {
                cloudProviderPreference2.showProgressBar(kFunction != null);
            }
            CloudProviderPreference cloudProviderPreference3 = this.cloudProviderPref;
            if (cloudProviderPreference3 != null) {
                cloudProviderPreference3.setTitle(string);
            }
            CloudProviderPreference cloudProviderPreference4 = this.cloudProviderPref;
            if (cloudProviderPreference4 != null) {
                cloudProviderPreference4.setSummary(kFunction != null ? " " : null);
            }
        }
        if (kFunction != null) {
            ((Function0) kFunction).invoke();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$updateCloudProviders$2 */
    /* JADX INFO: compiled from: SyncSettingsFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C67992 extends FunctionReferenceImpl implements Function0<Unit> {
        C67992(Object obj) {
            super(0, obj, SyncSettingsFragment.class, "asyncUpdateDropboxUserInfo", "asyncUpdateDropboxUserInfo()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SyncSettingsFragment) this.receiver).asyncUpdateDropboxUserInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void asyncUpdateGDriveUserInfo() {
        LiveData<NeboNetworkState> neboNetworkState;
        FragmentActivity activity = getActivity();
        ComponentCallbacks2 application = activity != null ? activity.getApplication() : null;
        NeboNetworkStateRepositoryProvider neboNetworkStateRepositoryProvider = application instanceof NeboNetworkStateRepositoryProvider ? (NeboNetworkStateRepositoryProvider) application : null;
        NeboNetworkStateRepository neboNetworkStateRepositoryProvideNeboNetworkStateRepository = neboNetworkStateRepositoryProvider != null ? neboNetworkStateRepositoryProvider.provideNeboNetworkStateRepository() : null;
        NeboNetworkState value = (neboNetworkStateRepositoryProvideNeboNetworkStateRepository == null || (neboNetworkState = neboNetworkStateRepositoryProvideNeboNetworkStateRepository.getNeboNetworkState()) == null) ? null : neboNetworkState.getValue();
        if (!(value != null ? value.isDataTransferAllowed() : false)) {
            String string = getString(SyncSettingsFragmentKt.ProviderGDrive.getName());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            updateCloudProviderInfo$default(this, string, 0L, 0L, 6, null);
        } else {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain(), null, new C67911(null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$asyncUpdateGDriveUserInfo$1 */
    /* JADX INFO: compiled from: SyncSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$asyncUpdateGDriveUserInfo$1", m1609f = "SyncSettingsFragment.kt", m1610i = {}, m1611l = {476}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {490}, m1615s = {}, m1616v = 2)
    static final class C67911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67911(Continuation<? super C67911> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SyncSettingsFragment.this.new C67911(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new SyncSettingsFragment$asyncUpdateGDriveUserInfo$1$info$1(null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                AccountInfo accountInfo = (AccountInfo) obj;
                if (SyncSettingsFragment.this.isAdded()) {
                    if (accountInfo != null) {
                        SyncSettingsFragment.this.updateCloudProviderInfo(accountInfo.getEmail(), accountInfo.getSpaceUsed(), accountInfo.getSpaceAllocation());
                    } else {
                        SyncSettingsFragment syncSettingsFragment = SyncSettingsFragment.this;
                        SyncSettingsFragment.updateCloudProviderInfo$default(syncSettingsFragment, syncSettingsFragment.getString(SyncSettingsFragmentKt.ProviderGDrive.getName()), 0L, 0L, 6, null);
                    }
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Exception unused) {
                if (SyncSettingsFragment.this.isAdded()) {
                    String string = SyncSettingsFragment.this.getString(SyncSettingsFragmentKt.ProviderGDrive.getName());
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    SyncSettingsFragment.updateCloudProviderInfo$default(SyncSettingsFragment.this, string, 0L, 0L, 6, null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$asyncUpdateDropboxUserInfo$1 */
    /* JADX INFO: compiled from: SyncSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$asyncUpdateDropboxUserInfo$1", m1609f = "SyncSettingsFragment.kt", m1610i = {0}, m1611l = {512}, m1612m = "invokeSuspend", m1613n = {"dbxClient"}, m1614nl = {515}, m1615s = {"L$0"}, m1616v = 2)
    static final class C67901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C67901(Continuation<? super C67901> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SyncSettingsFragment.this.new C67901(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DbxClientV2 dropboxClient = DropboxClient.getInstance();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(dropboxClient);
                    this.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new SyncSettingsFragment$asyncUpdateDropboxUserInfo$1$info$1(dropboxClient, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                AccountInfo accountInfo = (AccountInfo) obj;
                if (SyncSettingsFragment.this.isAdded()) {
                    SyncSettingsFragment.this.updateCloudProviderInfo(accountInfo.getEmail(), accountInfo.getSpaceUsed(), accountInfo.getSpaceAllocation());
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Exception unused) {
                if (SyncSettingsFragment.this.isAdded()) {
                    SyncSettingsFragment syncSettingsFragment = SyncSettingsFragment.this;
                    SyncSettingsFragment.updateCloudProviderInfo$default(syncSettingsFragment, syncSettingsFragment.getString(SyncSettingsFragmentKt.ProviderDropbox.getName()), 0L, 0L, 6, null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void asyncUpdateDropboxUserInfo() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain(), null, new C67901(null), 2, null);
    }

    static /* synthetic */ void updateCloudProviderInfo$default(SyncSettingsFragment syncSettingsFragment, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            j = -1;
        }
        syncSettingsFragment.updateCloudProviderInfo(str, j, (i & 4) != 0 ? -1L : j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCloudProviderInfo(String label, long providerUsage, long providerMaxSpace) {
        String str;
        CloudProviderPreference cloudProviderPreference = this.cloudProviderPref;
        if (cloudProviderPreference != null) {
            cloudProviderPreference.setTitle(label);
        }
        CloudProviderPreference cloudProviderPreference2 = this.cloudProviderPref;
        if (cloudProviderPreference2 != null) {
            cloudProviderPreference2.showProgressBar(false);
        }
        CloudProviderPreference cloudProviderPreference3 = this.cloudProviderPref;
        if (cloudProviderPreference3 != null) {
            if (providerUsage < 0 || providerMaxSpace < 0) {
                str = null;
            } else {
                str = CommonUtils.getHumanReadableByteCount(providerUsage, true) + " / " + (providerMaxSpace == 0 ? "∞" : CommonUtils.getHumanReadableByteCount(providerMaxSpace, true));
            }
            cloudProviderPreference3.setSummary(str);
        }
    }

    private final void startCloudLogin(CloudManager.CloudProviderType provider) {
        int i = provider == null ? -1 : WhenMappings.$EnumSwitchMapping$0[provider.ordinal()];
        if (i == 1) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67971(null), 3, null);
            return;
        }
        if (i != 2) {
            return;
        }
        FragmentActivity activity = getActivity();
        NeboBaseActivity neboBaseActivity = activity instanceof NeboBaseActivity ? (NeboBaseActivity) activity : null;
        if (neboBaseActivity != null) {
            neboBaseActivity.dropboxSignIn();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.SyncSettingsFragment$startCloudLogin$1 */
    /* JADX INFO: compiled from: SyncSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$startCloudLogin$1", m1609f = "SyncSettingsFragment.kt", m1610i = {}, m1611l = {542}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {543}, m1615s = {}, m1616v = 2)
    static final class C67971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67971(Continuation<? super C67971> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SyncSettingsFragment.this.new C67971(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws GetCredentialException {
            Object objM12802driveManualSignInIoAF18A;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FragmentActivity activity = SyncSettingsFragment.this.getActivity();
                NeboBaseActivity neboBaseActivity = activity instanceof NeboBaseActivity ? (NeboBaseActivity) activity : null;
                if (neboBaseActivity != null) {
                    this.label = 1;
                    objM12802driveManualSignInIoAF18A = neboBaseActivity.m12802driveManualSignInIoAF18A(this);
                    if (objM12802driveManualSignInIoAF18A == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM12802driveManualSignInIoAF18A = ((Result) obj).getValue();
            Result.m14498boximpl(objM12802driveManualSignInIoAF18A);
            return Unit.INSTANCE;
        }
    }

    private final void updateFreemiumInApp(boolean hasUnlimitedPagesAccess) {
        int i;
        int i2;
        UserProfileManager userProfileManager = this.userProfileManager;
        if (userProfileManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager = null;
        }
        if (userProfileManager.isFreePeriod()) {
            i = C6079R.string.pref_account_in_apps_trial_title;
        } else if (hasUnlimitedPagesAccess) {
            i = C6079R.string.pref_account_in_apps_premium_title;
        } else {
            i = C6079R.string.pref_account_in_apps_freemium_title;
        }
        InAppPreference inAppPreference = this.freemiumInAppPref;
        if (inAppPreference != null) {
            String string = getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            inAppPreference.updateState(hasUnlimitedPagesAccess, string, hasUnlimitedPagesAccess ? null : this.purchaseRequestedCallback);
        }
        SummaryPreference summaryPreference = this.freemiumInAppSummaryPref;
        if (summaryPreference != null) {
            if (hasUnlimitedPagesAccess) {
                i2 = C6079R.string.pref_account_freemium_summary_paid;
            } else {
                i2 = C6079R.string.pref_account_freemium_summary_free;
            }
            summaryPreference.setTitle(getString(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDisconnectProgress(String label) {
        dismissDisconnectProgress();
        if (!isAdded() || isRemoving() || getChildFragmentManager().isStateSaved()) {
            return;
        }
        ProgressDialogFragment progressDialogFragmentNewInstance = ProgressDialogFragment.INSTANCE.newInstance(label);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        progressDialogFragmentNewInstance.showAllowingStateLoss(childFragmentManager, "ProgressDialogFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissDisconnectProgress() {
        if (!isAdded() || isRemoving()) {
            return;
        }
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("ProgressDialogFragment");
        DialogFragment dialogFragment = fragmentFindFragmentByTag instanceof DialogFragment ? (DialogFragment) fragmentFindFragmentByTag : null;
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    private static final NeboNetworkState onCreateView$lambda$0$0$0$0(State<? extends NeboNetworkState> state) {
        return state.getValue();
    }
}
