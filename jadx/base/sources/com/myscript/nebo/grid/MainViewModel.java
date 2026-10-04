package com.myscript.nebo.grid;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.PreferenceManager;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.myscript.android.utils.BooleanSharedPreferencesProperty;
import com.myscript.android.utils.LongSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.UserSessionManager;
import com.myscript.nebo.account.Feature;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.analytics.UserProperties;
import com.myscript.nebo.analytics.firebase.PaywallOrigin;
import com.myscript.nebo.analytics.firebase.PreRatingOrigin;
import com.myscript.nebo.backup.BackupRestoreViewModel;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.discoverability.DiscoverabilityManager;
import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.discoverability.GridDiscoverableFeature;
import com.myscript.nebo.grid.MainViewModel;
import com.myscript.nebo.grid.Screen;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.migration.IInstallReferralRepository;
import com.myscript.nebo.migration.ILenovoMigrationController;
import com.myscript.nebo.migration.MigrationState;
import com.myscript.nebo.purchase.FreePeriodState;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.purchase.RenewalOfferState;
import com.myscript.nebo.purchase.SubscriptionPreConfigurationWorker;
import com.myscript.nebo.purchase.SubscriptionRepository;
import com.myscript.nebo.rating.PreRatingFilter;
import com.myscript.nebo.rating.PreRatingFilterAction;
import com.myscript.nebo.utils.NewFeatureVisibilityHelper;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000ß\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001&\b\u0007\u0018\u0000 \u0099\u00012\u00020\u0001:\u0002\u0099\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0006\u0010^\u001a\u00020_J\u0006\u0010`\u001a\u00020_J\u0006\u0010a\u001a\u00020_J\u0006\u0010v\u001a\u00020_J\u0006\u0010w\u001a\u00020_J\u0006\u0010x\u001a\u00020_J\u001a\u0010y\u001a\u00020_2\u0006\u0010z\u001a\u00020\u001d2\b\b\u0002\u0010{\u001a\u00020\u001dH\u0007J\b\u0010|\u001a\u00020_H\u0002J\u0018\u0010}\u001a\u00020_2\u0006\u0010~\u001a\u00020\u001d2\b\b\u0002\u0010\u007f\u001a\u00020\u001dJ\u0007\u0010\u0080\u0001\u001a\u00020_J\u0007\u0010\u0081\u0001\u001a\u00020\u001dJ\u0007\u0010\u0082\u0001\u001a\u00020_J\u0011\u0010\u0083\u0001\u001a\u00020_2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001J\u0010\u0010\u0086\u0001\u001a\u00020_H\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0007\u0010\u0088\u0001\u001a\u00020_J\u0007\u0010\u0089\u0001\u001a\u00020_J\u0007\u0010\u008a\u0001\u001a\u00020_J\u0011\u0010\u008b\u0001\u001a\u00020_2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\u0007\u0010\u008e\u0001\u001a\u00020_J\u0010\u0010\u008f\u0001\u001a\u00020_H\u0082@¢\u0006\u0003\u0010\u0087\u0001J\u0007\u0010\u0090\u0001\u001a\u00020_J\u0007\u0010\u0091\u0001\u001a\u00020_J\u0007\u0010\u0092\u0001\u001a\u00020_J\u0007\u0010\u0093\u0001\u001a\u00020_J\u0007\u0010\u0094\u0001\u001a\u00020_J\u0007\u0010\u0095\u0001\u001a\u00020_J\u0007\u0010\u0096\u0001\u001a\u00020_J\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u001e\u0010)\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u000e\u0010,\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020/018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00106\u001a\b\u0012\u0004\u0012\u000205018F¢\u0006\u0006\u001a\u0004\b7\u00103R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u001d0.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u001d018F¢\u0006\u0006\u001a\u0004\b9\u00103R+\u0010;\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\b<\u0010*\"\u0004\b=\u0010>R+\u0010A\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010@\u001a\u0004\bB\u0010*\"\u0004\bC\u0010>R+\u0010F\u001a\u00020E2\u0006\u0010:\u001a\u00020E8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O0Q¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001d0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001d0Q¢\u0006\b\n\u0000\u001a\u0004\bV\u0010SR\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001d0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001d0Q¢\u0006\b\n\u0000\u001a\u0004\bY\u0010SR\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001d0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001d0Q¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010SR\u000e\u0010]\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0Q¢\u0006\b\n\u0000\u001a\u0004\be\u0010SR\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020\u001d0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001d0Q¢\u0006\b\n\u0000\u001a\u0004\bh\u0010SR\u0016\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020\u001d0lX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j01¢\u0006\b\n\u0000\u001a\u0004\bn\u00103R\u001c\u0010o\u001a\u0010\u0012\f\u0012\n q*\u0004\u0018\u00010p0p0.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010r\u001a\b\u0012\u0004\u0012\u00020p018F¢\u0006\u0006\u001a\u0004\bs\u00103R\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020\u001d0Q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bu\u0010S¨\u0006\u009a\u0001"}, m1599d2 = {"Lcom/myscript/nebo/grid/MainViewModel;", "Landroidx/lifecycle/ViewModel;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "sessionManager", "Lcom/myscript/nebo/UserSessionManager;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "profileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "subscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "discoverabilityManager", "Lcom/myscript/nebo/discoverability/DiscoverabilityManager;", "sharedPreferences", "Landroid/content/SharedPreferences;", "technicalLogger", "Lcom/myscript/nebo/log/TechnicalLogger;", "preRatingFilter", "Lcom/myscript/nebo/rating/PreRatingFilter;", "referralRepository", "Lcom/myscript/nebo/migration/IInstallReferralRepository;", "migrationController", "Lcom/myscript/nebo/migration/ILenovoMigrationController;", "isLenovoAppInstalled", "", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/UserSessionManager;Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;Lcom/myscript/nebo/account/UserProfileManager;Lcom/myscript/nebo/purchase/ISubscriptionRepository;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lcom/myscript/nebo/discoverability/DiscoverabilityManager;Landroid/content/SharedPreferences;Lcom/myscript/nebo/log/TechnicalLogger;Lcom/myscript/nebo/rating/PreRatingFilter;Lcom/myscript/nebo/migration/IInstallReferralRepository;Lcom/myscript/nebo/migration/ILenovoMigrationController;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getMigrationController", "()Lcom/myscript/nebo/migration/ILenovoMigrationController;", "backupRestoreListener", "com/myscript/nebo/grid/MainViewModel$backupRestoreListener$1", "Lcom/myscript/nebo/grid/MainViewModel$backupRestoreListener$1;", "value", "isSidePanelOpen", "()Z", "isSideBySide", "isMainNavigationVisible", "_screen", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/grid/Screen;", "screen", "Landroidx/lifecycle/LiveData;", "getScreen", "()Landroidx/lifecycle/LiveData;", "_sidePanelState", "Lcom/myscript/nebo/grid/SidePanelState;", "sidePanelState", "getSidePanelState", "_isDetailFragmentAvailable", "isDetailFragmentAvailable", "<set-?>", "hasPaywallAfterOnboardingBeenShown", "getHasPaywallAfterOnboardingBeenShown", "setHasPaywallAfterOnboardingBeenShown", "(Z)V", "hasPaywallAfterOnboardingBeenShown$delegate", "Lcom/myscript/android/utils/BooleanSharedPreferencesProperty;", "hasOemOfferDialogBeenShown", "getHasOemOfferDialogBeenShown", "setHasOemOfferDialogBeenShown", "hasOemOfferDialogBeenShown$delegate", "", "renewalOfferDialogShownForWindow", "getRenewalOfferDialogShownForWindow", "()J", "setRenewalOfferDialogShownForWindow", "(J)V", "renewalOfferDialogShownForWindow$delegate", "Lcom/myscript/android/utils/LongSharedPreferencesProperty;", "_oemOfferDialogState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/myscript/nebo/grid/OEMOfferDialogState;", "oemOfferDialogState", "Lkotlinx/coroutines/flow/StateFlow;", "getOemOfferDialogState", "()Lkotlinx/coroutines/flow/StateFlow;", "_renewalOfferDialogVisible", "renewalOfferDialogVisible", "getRenewalOfferDialogVisible", "_dataCollectVisible", "dataCollectVisible", "getDataCollectVisible", "_billingUnavailableDialogVisible", "billingUnavailableDialogVisible", "getBillingUnavailableDialogVisible", "hasBillingUnavailableDialogBeenShown", "dismissBillingUnavailableDialog", "", "showDataCollectDialog", "dismissDataCollectDialog", "_paywallOrigin", "", "paywallOrigin", "getPaywallOrigin", "_showLenovoMigration", "showLenovoMigration", "getShowLenovoMigration", "_discoveryTooltip", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "isModalSuppressingTooltip", "Lkotlinx/coroutines/flow/Flow;", "discoveryTooltip", "getDiscoveryTooltip", "_showPreRating", "Lcom/myscript/nebo/grid/PreRatingFilterState;", "kotlin.jvm.PlatformType", "showPreRating", "getShowPreRating", "hasInternetAccess", "getHasInternetAccess", "navigateToNotebooks", "navigateToTrash", "toggleSidePanel", "requestSidePanelVisibility", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "forceUpdate", "updateSidePanel", "deviceConfigurationChanged", "sideBySide", "initialState", "closeNavigationDrawer", "shouldShowBackupReminder", "dismissCurrentTooltip", "discover", "feature", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "updatePremiumStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPurchased", "onRenewalOfferCtaClicked", "dismissRenewalOfferDialog", "showPaywall", "origin", "Lcom/myscript/nebo/analytics/firebase/PaywallOrigin;", "dismissPaywall", "launchLenovoMigrationIfNeeded", "onLenovoMigrationDismissed", "requestPreRatingFilterAfterClosingANote", "preRatingLoveIt", "preRatingFilterNeedsWork", "dismissPreRating", "saveCorruptPage", "onOEMOfferDismissed", "getBackupRestoreListener", "Lcom/myscript/nebo/backup/BackupRestoreViewModel$BackupRestoreListener;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MainViewModel extends ViewModel {
    public static final ViewModelProvider.Factory Factory;
    private static final String PREF_OEM_OFFER_DIALOG_BEEN_SHOWN_KEY = "PREF_OEM_OFFER_DIALOG_BEEN_SHOWN_KEY";
    private static final String PREF_PAYWALL_AFTER_ONBOARDING_SHOWN_KEY = "PREF_PAYWALL_AFTER_ONBOARDING_SHOWN_KEY";
    private static final String PREF_RENEWAL_OFFER_DIALOG_SHOWN_WINDOW_KEY = "PREF_RENEWAL_OFFER_DIALOG_SHOWN_WINDOW_KEY";
    private final MutableStateFlow<Boolean> _billingUnavailableDialogVisible;
    private final MutableStateFlow<Boolean> _dataCollectVisible;
    private final MutableStateFlow<TooltipUIState> _discoveryTooltip;
    private MutableLiveData<Boolean> _isDetailFragmentAvailable;
    private final MutableStateFlow<OEMOfferDialogState> _oemOfferDialogState;
    private final MutableStateFlow<String> _paywallOrigin;
    private final MutableStateFlow<Boolean> _renewalOfferDialogVisible;
    private MutableLiveData<Screen> _screen;
    private final MutableStateFlow<Boolean> _showLenovoMigration;
    private MutableLiveData<PreRatingFilterState> _showPreRating;
    private MutableLiveData<SidePanelState> _sidePanelState;
    private final Application application;
    private final IAutoSyncTimerManager autoSyncTimerManager;
    private final MainViewModel$backupRestoreListener$1 backupRestoreListener;
    private final StateFlow<Boolean> billingUnavailableDialogVisible;
    private final StateFlow<Boolean> dataCollectVisible;
    private final DiscoverabilityManager discoverabilityManager;
    private final LiveData<TooltipUIState> discoveryTooltip;
    private boolean hasBillingUnavailableDialogBeenShown;

    /* JADX INFO: renamed from: hasOemOfferDialogBeenShown$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty hasOemOfferDialogBeenShown;

    /* JADX INFO: renamed from: hasPaywallAfterOnboardingBeenShown$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty hasPaywallAfterOnboardingBeenShown;
    private final CoroutineDispatcher ioDispatcher;
    private final boolean isLenovoAppInstalled;
    private boolean isMainNavigationVisible;
    private final Flow<Boolean> isModalSuppressingTooltip;
    private boolean isSideBySide;
    private boolean isSidePanelOpen;
    private final LibraryRepository libraryRepository;
    private final CoroutineDispatcher mainDispatcher;
    private final ILenovoMigrationController migrationController;
    private final NeboNetworkStateRepository networkStateRepository;
    private final StateFlow<OEMOfferDialogState> oemOfferDialogState;
    private final StateFlow<String> paywallOrigin;
    private final PreRatingFilter preRatingFilter;
    private final UserProfileManager profileManager;
    private final IInstallReferralRepository referralRepository;

    /* JADX INFO: renamed from: renewalOfferDialogShownForWindow$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty renewalOfferDialogShownForWindow;
    private final StateFlow<Boolean> renewalOfferDialogVisible;
    private final UserSessionManager sessionManager;
    private final SharedPreferences sharedPreferences;
    private final StateFlow<Boolean> showLenovoMigration;
    private final ISubscriptionRepository subscriptionRepository;
    private final TechnicalLogger technicalLogger;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(MainViewModel.class, "hasPaywallAfterOnboardingBeenShown", "getHasPaywallAfterOnboardingBeenShown()Z", 0), new MutablePropertyReference1Impl(MainViewModel.class, "hasOemOfferDialogBeenShown", "getHasOemOfferDialogBeenShown()Z", 0), new MutablePropertyReference1Impl(MainViewModel.class, "renewalOfferDialogShownForWindow", "getRenewalOfferDialogShownForWindow()J", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$updatePremiumStatus$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {459, 460}, m1612m = "updatePremiumStatus", m1613n = {}, m1614nl = {460, 461}, m1615s = {}, m1616v = 2)
    static final class C65861 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C65861(Continuation<? super C65861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainViewModel.this.updatePremiumStatus(this);
        }
    }

    public final void requestSidePanelVisibility(boolean z) {
        requestSidePanelVisibility$default(this, z, false, 2, null);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.myscript.nebo.grid.MainViewModel$backupRestoreListener$1] */
    public MainViewModel(Application application, UserSessionManager sessionManager, LibraryRepository libraryRepository, IAutoSyncTimerManager autoSyncTimerManager, UserProfileManager profileManager, ISubscriptionRepository subscriptionRepository, NeboNetworkStateRepository networkStateRepository, DiscoverabilityManager discoverabilityManager, SharedPreferences sharedPreferences, TechnicalLogger technicalLogger, PreRatingFilter preRatingFilter, IInstallReferralRepository referralRepository, ILenovoMigrationController migrationController, boolean z, CoroutineDispatcher mainDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(autoSyncTimerManager, "autoSyncTimerManager");
        Intrinsics.checkNotNullParameter(profileManager, "profileManager");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(preRatingFilter, "preRatingFilter");
        Intrinsics.checkNotNullParameter(referralRepository, "referralRepository");
        Intrinsics.checkNotNullParameter(migrationController, "migrationController");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.application = application;
        this.sessionManager = sessionManager;
        this.libraryRepository = libraryRepository;
        this.autoSyncTimerManager = autoSyncTimerManager;
        this.profileManager = profileManager;
        this.subscriptionRepository = subscriptionRepository;
        this.networkStateRepository = networkStateRepository;
        this.discoverabilityManager = discoverabilityManager;
        this.sharedPreferences = sharedPreferences;
        this.technicalLogger = technicalLogger;
        this.preRatingFilter = preRatingFilter;
        this.referralRepository = referralRepository;
        this.migrationController = migrationController;
        this.isLenovoAppInstalled = z;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        this.backupRestoreListener = new BackupRestoreViewModel.BackupRestoreListener() { // from class: com.myscript.nebo.grid.MainViewModel$backupRestoreListener$1
            @Override // com.myscript.nebo.backup.BackupRestoreViewModel.BackupRestoreListener
            public void onPauseAutoSync() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new MainViewModel$backupRestoreListener$1$onPauseAutoSync$1(this.this$0, null), 3, null);
            }

            @Override // com.myscript.nebo.backup.BackupRestoreViewModel.BackupRestoreListener
            public void onResumeAutoSync() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new MainViewModel$backupRestoreListener$1$onResumeAutoSync$1(this.this$0, null), 3, null);
            }
        };
        this.isMainNavigationVisible = true;
        this._screen = new MutableLiveData<>(Screen.Notebooks.INSTANCE);
        this._sidePanelState = new MutableLiveData<>(new SidePanelState(false, false, false, false, 15, null));
        this._isDetailFragmentAvailable = new MutableLiveData<>(true);
        this.hasPaywallAfterOnboardingBeenShown = SharedPreferencesExtKt.booleanPref(sharedPreferences, PREF_PAYWALL_AFTER_ONBOARDING_SHOWN_KEY, false);
        this.hasOemOfferDialogBeenShown = SharedPreferencesExtKt.booleanPref(sharedPreferences, PREF_OEM_OFFER_DIALOG_BEEN_SHOWN_KEY, false);
        this.renewalOfferDialogShownForWindow = SharedPreferencesExtKt.longPref(sharedPreferences, PREF_RENEWAL_OFFER_DIALOG_SHOWN_WINDOW_KEY, 0L);
        MutableStateFlow<OEMOfferDialogState> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._oemOfferDialogState = MutableStateFlow;
        this.oemOfferDialogState = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._renewalOfferDialogVisible = MutableStateFlow2;
        this.renewalOfferDialogVisible = MutableStateFlow2;
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._dataCollectVisible = MutableStateFlow3;
        this.dataCollectVisible = MutableStateFlow3;
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._billingUnavailableDialogVisible = MutableStateFlow4;
        this.billingUnavailableDialogVisible = MutableStateFlow4;
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._paywallOrigin = MutableStateFlow5;
        this.paywallOrigin = MutableStateFlow5;
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._showLenovoMigration = MutableStateFlow6;
        this.showLenovoMigration = MutableStateFlow6;
        MutableStateFlow<TooltipUIState> MutableStateFlow7 = StateFlowKt.MutableStateFlow(null);
        this._discoveryTooltip = MutableStateFlow7;
        Flow<Boolean> flowCombine = FlowKt.combine(MutableStateFlow, MutableStateFlow5, MutableStateFlow6, MutableStateFlow2, MutableStateFlow4, new MainViewModel$isModalSuppressingTooltip$1(null));
        this.isModalSuppressingTooltip = flowCombine;
        this.discoveryTooltip = FlowLiveDataConversions.asLiveData$default(FlowKt.combine(MutableStateFlow7, flowCombine, new MainViewModel$discoveryTooltip$1(null)), (CoroutineContext) null, 0L, 3, (Object) null);
        this._showPreRating = new MutableLiveData<>(new PreRatingFilterState(false, null, 3, null));
        MainViewModel mainViewModel = this;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(mainViewModel), mainDispatcher, null, new C65561(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(mainViewModel), mainDispatcher, null, new C65572(null), 2, null);
        if (!subscriptionRepository.hasPaywallAfterFreePeriodBeenShown()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(mainViewModel), mainDispatcher, null, new C65583(null), 2, null);
        }
        if (!getHasPaywallAfterOnboardingBeenShown()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(mainViewModel), mainDispatcher, null, new C65594(null), 2, null);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(mainViewModel), mainDispatcher, null, new C65605(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(mainViewModel), mainDispatcher, null, new C65616(null), 2, null);
        if (!getHasOemOfferDialogBeenShown()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(mainViewModel), mainDispatcher, null, new C65627(null), 2, null);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(mainViewModel), mainDispatcher, null, new C65638(null), 2, null);
        if (this.hasBillingUnavailableDialogBeenShown) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(mainViewModel), mainDispatcher, null, new C65649(null), 2, null);
    }

    public final ILenovoMigrationController getMigrationController() {
        return this.migrationController;
    }

    public /* synthetic */ MainViewModel(Application application, UserSessionManager userSessionManager, LibraryRepository libraryRepository, IAutoSyncTimerManager iAutoSyncTimerManager, UserProfileManager userProfileManager, ISubscriptionRepository iSubscriptionRepository, NeboNetworkStateRepository neboNetworkStateRepository, DiscoverabilityManager discoverabilityManager, SharedPreferences sharedPreferences, TechnicalLogger technicalLogger, PreRatingFilter preRatingFilter, IInstallReferralRepository iInstallReferralRepository, ILenovoMigrationController iLenovoMigrationController, boolean z, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, userSessionManager, libraryRepository, iAutoSyncTimerManager, userProfileManager, iSubscriptionRepository, neboNetworkStateRepository, discoverabilityManager, sharedPreferences, (i & 512) != 0 ? null : technicalLogger, preRatingFilter, iInstallReferralRepository, iLenovoMigrationController, z, (i & 16384) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 32768) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    /* JADX INFO: renamed from: isSidePanelOpen, reason: from getter */
    public final boolean getIsSidePanelOpen() {
        return this.isSidePanelOpen;
    }

    /* JADX INFO: renamed from: isSideBySide, reason: from getter */
    public final boolean getIsSideBySide() {
        return this.isSideBySide;
    }

    public final LiveData<Screen> getScreen() {
        return this._screen;
    }

    public final LiveData<SidePanelState> getSidePanelState() {
        return this._sidePanelState;
    }

    public final LiveData<Boolean> isDetailFragmentAvailable() {
        return this._isDetailFragmentAvailable;
    }

    private final boolean getHasPaywallAfterOnboardingBeenShown() {
        return this.hasPaywallAfterOnboardingBeenShown.getValue((Object) this, $$delegatedProperties[0]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHasPaywallAfterOnboardingBeenShown(boolean z) {
        this.hasPaywallAfterOnboardingBeenShown.setValue(this, $$delegatedProperties[0], z);
    }

    private final boolean getHasOemOfferDialogBeenShown() {
        return this.hasOemOfferDialogBeenShown.getValue((Object) this, $$delegatedProperties[1]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHasOemOfferDialogBeenShown(boolean z) {
        this.hasOemOfferDialogBeenShown.setValue(this, $$delegatedProperties[1], z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getRenewalOfferDialogShownForWindow() {
        return this.renewalOfferDialogShownForWindow.getValue((Object) this, $$delegatedProperties[2]).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRenewalOfferDialogShownForWindow(long j) {
        this.renewalOfferDialogShownForWindow.setValue(this, $$delegatedProperties[2], j);
    }

    public final StateFlow<OEMOfferDialogState> getOemOfferDialogState() {
        return this.oemOfferDialogState;
    }

    public final StateFlow<Boolean> getRenewalOfferDialogVisible() {
        return this.renewalOfferDialogVisible;
    }

    public final StateFlow<Boolean> getDataCollectVisible() {
        return this.dataCollectVisible;
    }

    public final StateFlow<Boolean> getBillingUnavailableDialogVisible() {
        return this.billingUnavailableDialogVisible;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$dismissBillingUnavailableDialog$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$dismissBillingUnavailableDialog$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65661(Continuation<? super C65661> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65661(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._billingUnavailableDialogVisible.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void dismissBillingUnavailableDialog() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65661(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$showDataCollectDialog$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$showDataCollectDialog$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65831(Continuation<? super C65831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._dataCollectVisible.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void showDataCollectDialog() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65831(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$dismissDataCollectDialog$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$dismissDataCollectDialog$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65681(Continuation<? super C65681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65681(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._dataCollectVisible.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void dismissDataCollectDialog() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65681(null), 2, null);
    }

    public final StateFlow<String> getPaywallOrigin() {
        return this.paywallOrigin;
    }

    public final StateFlow<Boolean> getShowLenovoMigration() {
        return this.showLenovoMigration;
    }

    public final LiveData<TooltipUIState> getDiscoveryTooltip() {
        return this.discoveryTooltip;
    }

    public final LiveData<PreRatingFilterState> getShowPreRating() {
        return this._showPreRating;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StateFlow<Boolean> getHasInternetAccess() {
        final Flow flowAsFlow = FlowLiveDataConversions.asFlow(this.networkStateRepository.getNeboNetworkState());
        return FlowKt.stateIn(new Flow<Boolean>() { // from class: com.myscript.nebo.grid.MainViewModel$special$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object objCollect = flowAsFlow.collect(new C65852(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$special$$inlined$map$1$2 */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final class C65852<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$special$$inlined$map$1$2", m1609f = "MainViewModel.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {50}, m1612m = "emit", m1613n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, m1614nl = {49}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
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
                        return C65852.this.emit(null, this);
                    }
                }

                public C65852(FlowCollector flowCollector) {
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
        }, ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), Boolean.valueOf(this.networkStateRepository.getNeboNetworkState().getValue() instanceof NeboNetworkState.Connected));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {229}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C65561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65561(Continuation<? super C65561> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65561(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow hasInternetAccess = MainViewModel.this.getHasInternetAccess();
                final MainViewModel mainViewModel = MainViewModel.this;
                this.label = 1;
                if (hasInternetAccess.collect(new FlowCollector() { // from class: com.myscript.nebo.grid.MainViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        TechnicalLogger technicalLogger = mainViewModel.technicalLogger;
                        if (technicalLogger != null) {
                            technicalLogger.setKeyValue("hasInternetAccess", String.valueOf(z));
                        }
                        WorkManager.INSTANCE.getInstance(mainViewModel.application).enqueue(new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) SubscriptionPreConfigurationWorker.class).build());
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

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$2 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$2", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_4_3}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {246}, m1615s = {}, m1616v = 2)
    static final class C65572 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65572(Continuation<? super C65572> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65572(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65572) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowCombine = FlowKt.combine(MainViewModel.this.subscriptionRepository.getHasSubscribed(), MainViewModel.this.subscriptionRepository.getFreePeriodState(), new AnonymousClass1(null));
                final MainViewModel mainViewModel = MainViewModel.this;
                this.label = 1;
                if (flowCombine.collect(new FlowCollector() { // from class: com.myscript.nebo.grid.MainViewModel.2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        TechnicalLogger technicalLogger = mainViewModel.technicalLogger;
                        if (technicalLogger != null) {
                            technicalLogger.setUserProperty(UserProperties.USER_TYPE_KEY, str);
                        }
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

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, m1599d2 = {"<anonymous>", "", "hasSubscribed", "", "<unused var>", "Lcom/myscript/nebo/purchase/FreePeriodState;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$2$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, FreePeriodState, Continuation<? super String>, Object> {
            /* synthetic */ boolean Z$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, FreePeriodState freePeriodState, Continuation<? super String> continuation) {
                return invoke(bool.booleanValue(), freePeriodState, continuation);
            }

            public final Object invoke(boolean z, FreePeriodState freePeriodState, Continuation<? super String> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.Z$0 = z;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean z = this.Z$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return z ? "paying" : "trial";
            }
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$3 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$3", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {253}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA2_5_1}, m1615s = {}, m1616v = 2)
    static final class C65583 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65583(Continuation<? super C65583> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65583(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65583) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FlowKt.first(MainViewModel.this.subscriptionRepository.isConfigured(), new MainViewModel$3$isConfigured$1(null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue() && !MainViewModel.this.profileManager.hasPaidEntitlement() && !MainViewModel.this.profileManager.isFreePeriod() && !MainViewModel.this.subscriptionRepository.getRenewalOfferState().getValue().getActive() && (MainViewModel.this.networkStateRepository.getNeboNetworkState().getValue() instanceof NeboNetworkState.Connected)) {
                MainViewModel.this._paywallOrigin.setValue(PaywallOrigin.TrialEnd.getValue());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$4 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$4", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {270}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA2_7_1}, m1615s = {}, m1616v = 2)
    static final class C65594 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65594(Continuation<? super C65594> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65594(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65594) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Offering current;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            String identifier = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FlowKt.first(MainViewModel.this.subscriptionRepository.isConfigured(), new MainViewModel$4$isConfigured$1(null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            List<String> oem_offering_ids = SubscriptionRepository.INSTANCE.getOEM_OFFERING_IDS();
            Offerings offerings = MainViewModel.this.subscriptionRepository.get_offerings();
            if (offerings != null && (current = offerings.getCurrent()) != null) {
                identifier = current.getIdentifier();
            }
            boolean zContains = CollectionsKt.contains(oem_offering_ids, identifier);
            if (zBooleanValue && !MainViewModel.this.profileManager.hasPaidEntitlement() && MainViewModel.this.profileManager.isFreePeriod() && !zContains) {
                MainViewModel.this.setHasPaywallAfterOnboardingBeenShown(true);
                MainViewModel.this._paywallOrigin.setValue(PaywallOrigin.Onboarding.getValue());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$5 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$5", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {280, 282}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {282, 287}, m1615s = {}, m1616v = 2)
    static final class C65605 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65605(Continuation<? super C65605> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65605(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65605) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
        
            if (r5.collect(new com.myscript.nebo.grid.MainViewModel.C65605.AnonymousClass1<>(), r4) == r0) goto L21;
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
                DiscoverabilityManager discoverabilityManager = MainViewModel.this.discoverabilityManager;
                if (discoverabilityManager != null) {
                    this.label = 1;
                    if (discoverabilityManager.init(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    throw new KotlinNothingValueException();
                }
                ResultKt.throwOnFailure(obj);
            }
            DiscoverabilityManager discoverabilityManager2 = MainViewModel.this.discoverabilityManager;
            if (discoverabilityManager2 == null || (r5 = discoverabilityManager2.getNextDiscovery()) == null) {
                return Unit.INSTANCE;
            }
            final MainViewModel mainViewModel = MainViewModel.this;
            this.label = 2;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$6 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$6", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {290}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C65616 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65616(Continuation<? super C65616> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65616(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65616) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<RenewalOfferState> renewalOfferState = MainViewModel.this.subscriptionRepository.getRenewalOfferState();
                final MainViewModel mainViewModel = MainViewModel.this;
                this.label = 1;
                if (renewalOfferState.collect(new FlowCollector() { // from class: com.myscript.nebo.grid.MainViewModel.6.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((RenewalOfferState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(RenewalOfferState renewalOfferState2, Continuation<? super Unit> continuation) {
                        if (renewalOfferState2.getActive() && mainViewModel.getRenewalOfferDialogShownForWindow() != renewalOfferState2.getEndsAtMs()) {
                            mainViewModel.setRenewalOfferDialogShownForWindow(renewalOfferState2.getEndsAtMs());
                            mainViewModel._renewalOfferDialogVisible.setValue(Boxing.boxBoolean(true));
                        }
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

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$7 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$7", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {301}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {302}, m1615s = {}, m1616v = 2)
    static final class C65627 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65627(Continuation<? super C65627> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65627(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65627) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00ec  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            OEMOfferDialogState oEMOfferDialogState;
            Offering current;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            String identifier = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FlowKt.first(MainViewModel.this.subscriptionRepository.isConfigured(), new MainViewModel$7$isConfigured$1(null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                return Unit.INSTANCE;
            }
            Offerings offerings = MainViewModel.this.subscriptionRepository.get_offerings();
            MutableStateFlow mutableStateFlow = MainViewModel.this._oemOfferDialogState;
            if (offerings != null && (current = offerings.getCurrent()) != null) {
                identifier = current.getIdentifier();
            }
            if (identifier != null) {
                switch (identifier.hashCode()) {
                    case -2130270245:
                        if (!identifier.equals(SubscriptionRepository.OFFERING_ID_LENOVO)) {
                            MainViewModel.this.setHasOemOfferDialogBeenShown(true);
                            oEMOfferDialogState = new OEMOfferDialogState(false, 0, 0, 0, 14, null);
                        } else {
                            oEMOfferDialogState = new OEMOfferDialogState(true, C6079R.drawable.oem_offer_lenovo_illustration, C6079R.string.lenovo_offer_dialog_title, C6079R.string.lenovo_offer_dialog_message);
                        }
                        break;
                    case -585700809:
                        if (identifier.equals(SubscriptionRepository.OFFERING_ID_MOTOROLA)) {
                            oEMOfferDialogState = new OEMOfferDialogState(true, C6079R.drawable.oem_offer_motorola_illustration, C6079R.string.motorola_offer_dialog_title, C6079R.string.motorola_offer_dialog_message);
                            break;
                        }
                        break;
                    case 29629412:
                        if (identifier.equals(SubscriptionRepository.OFFERING_ID_NEC)) {
                            oEMOfferDialogState = new OEMOfferDialogState(true, C6079R.drawable.oem_offer_nec_illustration, C6079R.string.nec_offer_dialog_title, C6079R.string.nec_offer_dialog_message);
                            break;
                        }
                        break;
                    case 29635125:
                        if (identifier.equals(SubscriptionRepository.OFFERING_ID_TCL)) {
                            oEMOfferDialogState = new OEMOfferDialogState(true, C6079R.drawable.oem_offer_tcl_illustration, C6079R.string.tcl_offer_dialog_title, C6079R.string.tcl_offer_dialog_message);
                            break;
                        }
                        break;
                    case 188368466:
                        if (identifier.equals(SubscriptionRepository.OFFERING_ID_SAMSUNG)) {
                            oEMOfferDialogState = new OEMOfferDialogState(true, C6079R.drawable.oem_offer_samsung_illustration, C6079R.string.samsung_offer_dialog_title, C6079R.string.samsung_offer_dialog_message);
                            break;
                        }
                        break;
                    case 2046492872:
                        if (identifier.equals(SubscriptionRepository.OFFERING_ID_HANVON)) {
                            oEMOfferDialogState = new OEMOfferDialogState(true, C6079R.drawable.oem_offer_hanvon_illustration, C6079R.string.hanvon_offer_dialog_title, C6079R.string.hanvon_offer_dialog_message);
                            break;
                        }
                        break;
                }
            }
            mutableStateFlow.setValue(oEMOfferDialogState);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$8 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$8", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_5_3}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA3_5_4}, m1615s = {}, m1616v = 2)
    static final class C65638 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65638(Continuation<? super C65638> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65638(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65638) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "", "it"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$8$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
                return invoke(bool.booleanValue(), continuation);
            }

            public final Object invoke(boolean z, Continuation<? super Boolean> continuation) {
                return ((AnonymousClass1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean z = this.Z$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(z);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.first(MainViewModel.this.subscriptionRepository.isConfigured(), new AnonymousClass1(null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (MainViewModel.this.referralRepository.isLenovoReferral() && MainViewModel.this.isLenovoAppInstalled && MainViewModel.this.getMigrationController().getMigrationState() == MigrationState.Pending) {
                MainViewModel.this._showLenovoMigration.setValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$9 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$9", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {364}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {365}, m1615s = {}, m1616v = 2)
    static final class C65649 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65649(Continuation<? super C65649> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65649(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65649) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$9$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "", "it"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$9$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
                return invoke(bool.booleanValue(), continuation);
            }

            public final Object invoke(boolean z, Continuation<? super Boolean> continuation) {
                return ((AnonymousClass1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean z = this.Z$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(z);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.first(MainViewModel.this.subscriptionRepository.isBillingUnavailable(), new AnonymousClass1(null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MainViewModel.this.hasBillingUnavailableDialogBeenShown = true;
            MainViewModel.this._billingUnavailableDialogVisible.setValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$navigateToNotebooks$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$navigateToNotebooks$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65731(Continuation<? super C65731> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65731(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._screen.setValue(Screen.Notebooks.INSTANCE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void navigateToNotebooks() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65731(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$navigateToTrash$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$navigateToTrash$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65741(Continuation<? super C65741> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65741(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._screen.setValue(Screen.Trash.INSTANCE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void navigateToTrash() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65741(null), 3, null);
    }

    public final void toggleSidePanel() {
        requestSidePanelVisibility$default(this, !this.isSidePanelOpen, false, 2, null);
    }

    public static /* synthetic */ void requestSidePanelVisibility$default(MainViewModel mainViewModel, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        mainViewModel.requestSidePanelVisibility(z, z2);
    }

    public final void requestSidePanelVisibility(boolean open, boolean forceUpdate) {
        if (this.isSidePanelOpen != open || forceUpdate) {
            this.isSidePanelOpen = open;
            updateSidePanel();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$updateSidePanel$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$updateSidePanel$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65871(Continuation<? super C65871> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65871(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z = MainViewModel.this.getIsSidePanelOpen() && !MainViewModel.this.getIsSideBySide();
            MainViewModel.this._sidePanelState.setValue(new SidePanelState(MainViewModel.this.getIsSidePanelOpen(), z, MainViewModel.this.isMainNavigationVisible, MainViewModel.this.getIsSideBySide()));
            MainViewModel.this._isDetailFragmentAvailable.setValue(Boxing.boxBoolean(!z));
            return Unit.INSTANCE;
        }
    }

    private final void updateSidePanel() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65871(null), 3, null);
    }

    public static /* synthetic */ void deviceConfigurationChanged$default(MainViewModel mainViewModel, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        mainViewModel.deviceConfigurationChanged(z, z2);
    }

    public final void deviceConfigurationChanged(boolean sideBySide, boolean initialState) {
        boolean z = this.isSideBySide;
        this.isSideBySide = sideBySide;
        if (initialState && sideBySide) {
            requestSidePanelVisibility(true, true);
            return;
        }
        if (sideBySide && this.isSidePanelOpen && !z) {
            requestSidePanelVisibility(true, true);
        } else {
            if (sideBySide) {
                return;
            }
            requestSidePanelVisibility(false, true);
        }
    }

    public final void closeNavigationDrawer() {
        if (this.isSideBySide || !this.isSidePanelOpen) {
            return;
        }
        requestSidePanelVisibility$default(this, false, false, 2, null);
    }

    public final boolean shouldShowBackupReminder() {
        return this.profileManager.hasFeatureAccess(Feature.CloudSync) && !NewFeatureVisibilityHelper.hasFeatureBeenDiscovered(this.application, NewFeatureVisibilityHelper.Key.BACKUP_REMINDER) && this.sessionManager.getSessionCount() > 5 && LibraryRepository.getPageCount$default(this.libraryRepository, false, 1, null) > 1 && !this.libraryRepository.getHasCloudProvider();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$dismissCurrentTooltip$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$dismissCurrentTooltip$1", m1609f = "MainViewModel.kt", m1610i = {0, 0, 0, 0}, m1611l = {446}, m1612m = "invokeSuspend", m1613n = {"tooltip", "state", "$i$a$-let-MainViewModel$dismissCurrentTooltip$1$1", "$i$a$-let-MainViewModel$dismissCurrentTooltip$1$1$1"}, m1614nl = {447}, m1615s = {"L$0", "L$1", "I$0", "I$1"}, m1616v = 2)
    static final class C65671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        C65671(Continuation<? super C65671> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65671(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DiscoverabilityManager discoverabilityManager;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TooltipUIState tooltipUIState = (TooltipUIState) MainViewModel.this._discoveryTooltip.getValue();
                if (tooltipUIState != null) {
                    MainViewModel mainViewModel = MainViewModel.this;
                    IDiscoverableFeature iDiscoverableFeatureFromTooltipState = GridDiscoverableFeature.INSTANCE.fromTooltipState(tooltipUIState);
                    if (iDiscoverableFeatureFromTooltipState != null && (discoverabilityManager = mainViewModel.discoverabilityManager) != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(tooltipUIState);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(iDiscoverableFeatureFromTooltipState);
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        if (discoverabilityManager.discover(iDiscoverableFeatureFromTooltipState, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
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

    public final void dismissCurrentTooltip() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65671(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$discover$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$discover$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {454}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {455}, m1615s = {}, m1616v = 2)
    static final class C65651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IDiscoverableFeature $feature;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65651(IDiscoverableFeature iDiscoverableFeature, Continuation<? super C65651> continuation) {
            super(2, continuation);
            this.$feature = iDiscoverableFeature;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65651(this.$feature, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DiscoverabilityManager discoverabilityManager = MainViewModel.this.discoverabilityManager;
                if (discoverabilityManager != null) {
                    this.label = 1;
                    if (discoverabilityManager.discover(this.$feature, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public final void discover(IDiscoverableFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C65651(feature, null), 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r6.fetchNeboAccount(r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updatePremiumStatus(Continuation<? super Unit> continuation) {
        C65861 c65861;
        if (continuation instanceof C65861) {
            c65861 = (C65861) continuation;
            if ((c65861.label & Integer.MIN_VALUE) != 0) {
                c65861.label -= Integer.MIN_VALUE;
            } else {
                c65861 = new C65861(continuation);
            }
        }
        Object obj = c65861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c65861.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ISubscriptionRepository iSubscriptionRepository = this.subscriptionRepository;
            c65861.label = 1;
            if (iSubscriptionRepository.fetchSubscriptionStatus(c65861) != coroutine_suspended) {
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
        UserProfileManager userProfileManager = this.profileManager;
        c65861.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$onPurchased$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$onPurchased$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {465}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {466}, m1615s = {}, m1616v = 2)
    static final class C65771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65771(Continuation<? super C65771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainViewModel.this.updatePremiumStatus(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MainViewModel.this._showPreRating.setValue(new PreRatingFilterState(MainViewModel.this.preRatingFilter.requestPreRatingFilterAfterPurchase(), PreRatingOrigin.PaywallPurchase.getOrigin()));
            return Unit.INSTANCE;
        }
    }

    public final void onPurchased() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65771(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$onRenewalOfferCtaClicked$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$onRenewalOfferCtaClicked$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65781(Continuation<? super C65781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._renewalOfferDialogVisible.setValue(Boxing.boxBoolean(false));
                MainViewModel.this._paywallOrigin.setValue(PaywallOrigin.RenewalOffer.getValue());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void onRenewalOfferCtaClicked() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65781(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$dismissRenewalOfferDialog$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$dismissRenewalOfferDialog$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65711(Continuation<? super C65711> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65711(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._renewalOfferDialogVisible.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void dismissRenewalOfferDialog() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65711(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$showPaywall$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$showPaywall$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallOrigin $origin;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65841(PaywallOrigin paywallOrigin, Continuation<? super C65841> continuation) {
            super(2, continuation);
            this.$origin = paywallOrigin;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65841(this.$origin, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._paywallOrigin.setValue(this.$origin.getValue());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void showPaywall(PaywallOrigin origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65841(origin, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$dismissPaywall$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$dismissPaywall$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {492}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {493}, m1615s = {}, m1616v = 2)
    static final class C65691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65691(Continuation<? super C65691> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65691(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._paywallOrigin.setValue(null);
                this.label = 1;
                if (MainViewModel.this.launchLenovoMigrationIfNeeded(this) == coroutine_suspended) {
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

    public final void dismissPaywall() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65691(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object launchLenovoMigrationIfNeeded(Continuation<? super Unit> continuation) {
        if (this.referralRepository.isLenovoReferral() && this.isLenovoAppInstalled && this.migrationController.getMigrationState() != MigrationState.Completed) {
            this.migrationController.markMigrationPending();
            Object objWithContext = BuildersKt.withContext(this.mainDispatcher, new C65722(null), continuation);
            return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$launchLenovoMigrationIfNeeded$2 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$launchLenovoMigrationIfNeeded$2", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65722(Continuation<? super C65722> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65722(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._showLenovoMigration.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$onLenovoMigrationDismissed$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$onLenovoMigrationDismissed$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {TypedValues.PositionType.TYPE_POSITION_TYPE}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {InputDeviceCompat.SOURCE_DPAD}, m1615s = {}, m1616v = 2)
    static final class C65751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65751(Continuation<? super C65751> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65751(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._showLenovoMigration.setValue(Boxing.boxBoolean(false));
                this.label = 1;
                if (BuildersKt.withContext(MainViewModel.this.ioDispatcher, new AnonymousClass1(MainViewModel.this, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$onLenovoMigrationDismissed$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$onLenovoMigrationDismissed$1$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MainViewModel mainViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
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
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getMigrationController().markMigrationCompleted();
                return Unit.INSTANCE;
            }
        }
    }

    public final void onLenovoMigrationDismissed() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65751(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$requestPreRatingFilterAfterClosingANote$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$requestPreRatingFilterAfterClosingANote$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65811(Continuation<? super C65811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65811(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._showPreRating.setValue(new PreRatingFilterState(MainViewModel.this.preRatingFilter.requestPreRatingFilterAfterClosingANote(), PreRatingOrigin.SessionThreshold.getOrigin()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void requestPreRatingFilterAfterClosingANote() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65811(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$preRatingLoveIt$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$preRatingLoveIt$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65801(Continuation<? super C65801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65801(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._showPreRating.setValue(new PreRatingFilterState(false, null, 2, null));
                MainViewModel.this.preRatingFilter.savePreFilterAction(PreRatingFilterAction.LOVE_IT);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void preRatingLoveIt() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65801(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$preRatingFilterNeedsWork$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$preRatingFilterNeedsWork$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65791(Continuation<? super C65791> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65791(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._showPreRating.setValue(new PreRatingFilterState(false, null, 2, null));
                MainViewModel.this.preRatingFilter.savePreFilterAction(PreRatingFilterAction.NEEDS_REWORK);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void preRatingFilterNeedsWork() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65791(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$dismissPreRating$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$dismissPreRating$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65701(Continuation<? super C65701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65701(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this._showPreRating.setValue(new PreRatingFilterState(false, null, 2, null));
                MainViewModel.this.preRatingFilter.savePreFilterAction(PreRatingFilterAction.LATER);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void dismissPreRating() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C65701(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$saveCorruptPage$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$saveCorruptPage$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65821(Continuation<? super C65821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainViewModel.this.preRatingFilter.saveCorruptedPage();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void saveCorruptPage() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C65821(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$onOEMOfferDismissed$1 */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$onOEMOfferDismissed$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {552, 553}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {553, 556}, m1615s = {}, m1616v = 2)
    static final class C65761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C65761(Continuation<? super C65761> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C65761(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r11.this$0.ioDispatcher, new com.myscript.nebo.grid.MainViewModel.C65761.AnonymousClass1(r11.this$0, null), r11) == r0) goto L15;
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
                MainViewModel.this._oemOfferDialogState.setValue(new OEMOfferDialogState(false, 0, 0, 0, 14, null));
                this.label = 1;
                if (MainViewModel.this.subscriptionRepository.startOEMOffer(this) != coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewModel$onOEMOfferDismissed$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.grid.MainViewModel$onOEMOfferDismissed$1$1", m1609f = "MainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MainViewModel mainViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
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
                    this.this$0.setHasOemOfferDialogBeenShown(true);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void onOEMOfferDismissed() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65761(null), 2, null);
    }

    public final BackupRestoreViewModel.BackupRestoreListener getBackupRestoreListener() {
        return this.backupRestoreListener;
    }

    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/grid/MainViewModel$Companion;", "", "<init>", "()V", MainViewModel.PREF_PAYWALL_AFTER_ONBOARDING_SHOWN_KEY, "", MainViewModel.PREF_OEM_OFFER_DIALOG_BEEN_SHOWN_KEY, MainViewModel.PREF_RENEWAL_OFFER_DIALOG_SHOWN_WINDOW_KEY, "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final MainViewModel Companion$Factory$lambda$0$0(CreationExtras initializer) {
            Object objM14499constructorimpl;
            Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
            Application applicationRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
            Intrinsics.checkNotNull(applicationRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.discoverability.DiscoverabilityManager.Provider");
            DiscoverabilityManager discoverabilityManagerProvideGridDiscoverabilityManager = ((DiscoverabilityManager.Provider) applicationRequireApplication).provideGridDiscoverabilityManager();
            IInstallReferralRepository.Provider provider = applicationRequireApplication instanceof IInstallReferralRepository.Provider ? (IInstallReferralRepository.Provider) applicationRequireApplication : null;
            IInstallReferralRepository iInstallReferralRepositoryProvideInstallReferralRepository = provider != null ? provider.provideInstallReferralRepository() : null;
            ILenovoMigrationController.Provider provider2 = applicationRequireApplication instanceof ILenovoMigrationController.Provider ? (ILenovoMigrationController.Provider) applicationRequireApplication : null;
            ILenovoMigrationController iLenovoMigrationControllerProvideLenovoMigrationController = provider2 != null ? provider2.provideLenovoMigrationController() : null;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(applicationRequireApplication.getPackageManager().getPackageInfo("com.myscript.nebo.lenovo", 0));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            boolean zM14506isSuccessimpl = Result.m14506isSuccessimpl(objM14499constructorimpl);
            UserSessionManager userSessionManagerProvideUserSessionManager = ((UserSessionManager.Provider) applicationRequireApplication).provideUserSessionManager();
            LibraryRepository libraryRepositoryProvideLibraryRepository = ((LibraryRepository.Provider) applicationRequireApplication).provideLibraryRepository();
            IAutoSyncTimerManager iAutoSyncTimerManagerProvideAutoSyncTimerManager = ((IAutoSyncTimerManager.Provider) applicationRequireApplication).provideAutoSyncTimerManager();
            UserProfileManager userProfileManagerProvideUserProfileManager = ((UserProfileManager.Provider) applicationRequireApplication).provideUserProfileManager();
            ISubscriptionRepository iSubscriptionRepositoryProvideSubscriptionRepository = ((ISubscriptionRepository.Provider) applicationRequireApplication).provideSubscriptionRepository();
            NeboNetworkStateRepository neboNetworkStateRepositoryProvideNeboNetworkStateRepository = ((NeboNetworkStateRepositoryProvider) applicationRequireApplication).provideNeboNetworkStateRepository();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationRequireApplication);
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
            TechnicalLogger technicalLoggerProvideTechnicalLogger = ((TechnicalLoggerProvider) applicationRequireApplication).provideTechnicalLogger();
            PreRatingFilter preRatingFilterProvidePreRatingFilter = ((PreRatingFilter.Provider) applicationRequireApplication).providePreRatingFilter();
            if (iInstallReferralRepositoryProvideInstallReferralRepository == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            if (iLenovoMigrationControllerProvideLenovoMigrationController != null) {
                return new MainViewModel(applicationRequireApplication, userSessionManagerProvideUserSessionManager, libraryRepositoryProvideLibraryRepository, iAutoSyncTimerManagerProvideAutoSyncTimerManager, userProfileManagerProvideUserProfileManager, iSubscriptionRepositoryProvideSubscriptionRepository, neboNetworkStateRepositoryProvideNeboNetworkStateRepository, discoverabilityManagerProvideGridDiscoverabilityManager, defaultSharedPreferences, technicalLoggerProvideTechnicalLogger, preRatingFilterProvidePreRatingFilter, iInstallReferralRepositoryProvideInstallReferralRepository, iLenovoMigrationControllerProvideLenovoMigrationController, zM14506isSuccessimpl, null, null, 49152, null);
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function1() { // from class: com.myscript.nebo.grid.MainViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainViewModel.Companion.Companion$Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
