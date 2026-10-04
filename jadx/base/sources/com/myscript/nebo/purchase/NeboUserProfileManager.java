package com.myscript.nebo.purchase;

import android.content.SharedPreferences;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.myscript.android.utils.BooleanSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.nebo.IAsyncDataComponent;
import com.myscript.nebo.account.Feature;
import com.myscript.nebo.account.FeatureAccessListener;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.account.backend.Backend;
import com.myscript.nebo.account.backend.entity.CustomAttributeKey;
import com.myscript.nebo.account.backend.entity.InApp;
import com.myscript.nebo.account.backend.entity.InAppKt;
import com.myscript.nebo.account.backend.entity.InAppPurchaseResponse;
import com.myscript.nebo.account.backend.entity.NeboAccount;
import com.myscript.nebo.account.backend.entity.Store;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.freemium.InAppProduct;
import com.myscript.nebo.freemium.PurchaseController;
import com.myscript.nebo.freemium.storage.LegacyPaidStorage;
import com.myscript.nebo.freemium.storage.PurchaseStorage;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: NeboUserProfileManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001$\b\u0007\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NBi\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u00109\u001a\u00020:H\u0096@¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020+H\u0016J\b\u0010@\u001a\u00020+H\u0016J\b\u0010A\u001a\u00020+H\u0016J\b\u0010B\u001a\u00020+H\u0016J\b\u0010C\u001a\u00020+H\u0016J\u0010\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020\"H\u0016J\u0010\u0010F\u001a\u00020:2\u0006\u0010E\u001a\u00020\"H\u0016J\b\u0010G\u001a\u00020:H\u0002J\b\u0010H\u001a\u00020:H\u0016J\u0006\u0010I\u001a\u00020:J\u0006\u0010J\u001a\u00020:J\b\u0010K\u001a\u00020:H\u0002J\u000e\u0010L\u001a\u00020:H\u0096@¢\u0006\u0002\u0010;J\b\u0010M\u001a\u00020+H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010-\u001a\u00020+2\u0006\u0010,\u001a\u00020+8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020+05X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020+07X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00108¨\u0006O"}, m1599d2 = {"Lcom/myscript/nebo/purchase/NeboUserProfileManager;", "Lcom/myscript/nebo/account/UserProfileManager;", "Lcom/myscript/nebo/IAsyncDataComponent;", "legacyPaidStorage", "Lcom/myscript/nebo/freemium/storage/LegacyPaidStorage;", "purchaseStorage", "Lcom/myscript/nebo/freemium/storage/PurchaseStorage;", "purchaseController", "Lcom/myscript/nebo/freemium/PurchaseController;", "neboBackend", "Lcom/myscript/nebo/account/backend/Backend;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "subscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "sharedPreferences", "Landroid/content/SharedPreferences;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/myscript/nebo/freemium/storage/LegacyPaidStorage;Lcom/myscript/nebo/freemium/storage/PurchaseStorage;Lcom/myscript/nebo/freemium/PurchaseController;Lcom/myscript/nebo/account/backend/Backend;Ljava/lang/String;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lcom/myscript/nebo/purchase/ISubscriptionRepository;Lcom/myscript/nebo/log/TechnicalLogger;Landroid/content/SharedPreferences;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "initialDataMutex", "Lkotlinx/coroutines/sync/Mutex;", "featureAccessListeners", "", "Lcom/myscript/nebo/account/FeatureAccessListener;", "purchaseListener", "com/myscript/nebo/purchase/NeboUserProfileManager$purchaseListener$1", "Lcom/myscript/nebo/purchase/NeboUserProfileManager$purchaseListener$1;", "neboAccount", "Lcom/myscript/nebo/account/backend/entity/NeboAccount;", "paidPackageNames", "", "initialDataLoadingDone", "", "<set-?>", "debugSimulatePaidEntitlement", "getDebugSimulatePaidEntitlement", "()Z", "setDebugSimulatePaidEntitlement", "(Z)V", "debugSimulatePaidEntitlement$delegate", "Lkotlin/properties/ReadWriteProperty;", "_isPaidSubscriber", "Lkotlinx/coroutines/flow/MutableStateFlow;", "isPaidSubscriber", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "loadInitialDataIfNeeded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasFeatureAccess", "feature", "Lcom/myscript/nebo/account/Feature;", "hasLifetimeInAppPurchase", "hasAccessToAllFeatures", "hasPaidEntitlement", "isFreePeriod", "hasRecurringPurchase", "addFeatureAccessListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeFeatureAccessListener", "notifyUserStatusChanged", "release", "debugSetSimulatePaidEntitlement", "debugClearSimulatePaidEntitlement", "refreshDebugEntitlementState", "fetchNeboAccount", "isWhitelistedVersion", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboUserProfileManager implements UserProfileManager, IAsyncDataComponent {
    public static final String BACKEND_PAID_STATUS_FREE = "free";
    public static final String BACKEND_PAID_STATUS_KEY = "paying_status";
    public static final String BACKEND_PAID_STATUS_PAID = "paying";
    public static final String BACKEND_PAID_STATUS_TRIAL = "trial";
    public static final String CUSTOM_ATTRIBUTE_OEM_KEY = "manufacturer";
    public static final String CUSTOM_ATTRIBUTE_OEM_MODEL_KEY = "model";
    public static final String CUSTOM_ATTRIBUTE_REFERRER_KEY = "referrer";
    private static final String PREF_DEBUG_SIMULATE_PAID_KEY = "pref_internal_qa_simulate_paid_key";
    private final MutableStateFlow<Boolean> _isPaidSubscriber;

    /* JADX INFO: renamed from: debugSimulatePaidEntitlement$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty debugSimulatePaidEntitlement;
    private final Set<FeatureAccessListener> featureAccessListeners;
    private boolean initialDataLoadingDone;
    private final Mutex initialDataMutex;
    private final CoroutineDispatcher ioDispatcher;
    private final Flow<Boolean> isPaidSubscriber;
    private final LegacyPaidStorage legacyPaidStorage;
    private final TechnicalLogger logger;
    private final CoroutineDispatcher mainDispatcher;
    private NeboAccount neboAccount;
    private final Backend neboBackend;
    private final NeboNetworkStateRepository networkStateRepository;
    private final String packageName;
    private final List<String> paidPackageNames;
    private CompletableJob parentJob;
    private final PurchaseController purchaseController;
    private final NeboUserProfileManager$purchaseListener$1 purchaseListener;
    private final PurchaseStorage purchaseStorage;
    private final CoroutineScope scope;
    private final SharedPreferences sharedPreferences;
    private final ISubscriptionRepository subscriptionRepository;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(NeboUserProfileManager.class, "debugSimulatePaidEntitlement", "getDebugSimulatePaidEntitlement()Z", 0)};
    public static final int $stable = 8;

    /* JADX INFO: compiled from: NeboUserProfileManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Feature.values().length];
            try {
                iArr[Feature.UnlimitedPages.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Feature.CloudSync.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.NeboUserProfileManager$fetchNeboAccount$1 */
    /* JADX INFO: compiled from: NeboUserProfileManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager", m1609f = "NeboUserProfileManager.kt", m1610i = {}, m1611l = {249, 286}, m1612m = "fetchNeboAccount", m1613n = {}, m1614nl = {286, 289}, m1615s = {}, m1616v = 2)
    static final class C67201 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C67201(Continuation<? super C67201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboUserProfileManager.this.fetchNeboAccount(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.NeboUserProfileManager$loadInitialDataIfNeeded$1 */
    /* JADX INFO: compiled from: NeboUserProfileManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager", m1609f = "NeboUserProfileManager.kt", m1610i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2}, m1611l = {314, 120, 135}, m1612m = "loadInitialDataIfNeeded", m1613n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$this$forEach$iv", "element$iv", "product", "token", "$i$f$withLock", "$i$a$-withLock$default-NeboUserProfileManager$loadInitialDataIfNeeded$2", "$i$f$forEach", "$i$a$-forEach-NeboUserProfileManager$loadInitialDataIfNeeded$2$1", "$i$a$-let-NeboUserProfileManager$loadInitialDataIfNeeded$2$1$1", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-NeboUserProfileManager$loadInitialDataIfNeeded$2"}, m1614nl = {315, PDFACompliance.e_PDFA1_2_3, TsExtractor.TS_STREAM_TYPE_DTS_HD}, m1615s = {"L$0", "I$0", "L$0", "L$1", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "I$0", "I$1"}, m1616v = 2)
    static final class C67231 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C67231(Continuation<? super C67231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboUserProfileManager.this.loadInitialDataIfNeeded(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NeboUserProfileManager(LegacyPaidStorage legacyPaidStorage, PurchaseStorage purchaseStorage, PurchaseController purchaseController, Backend neboBackend, String packageName, NeboNetworkStateRepository networkStateRepository, ISubscriptionRepository subscriptionRepository, TechnicalLogger logger) {
        this(legacyPaidStorage, purchaseStorage, purchaseController, neboBackend, packageName, networkStateRepository, subscriptionRepository, logger, null, null, null, 1792, null);
        Intrinsics.checkNotNullParameter(legacyPaidStorage, "legacyPaidStorage");
        Intrinsics.checkNotNullParameter(purchaseStorage, "purchaseStorage");
        Intrinsics.checkNotNullParameter(purchaseController, "purchaseController");
        Intrinsics.checkNotNullParameter(neboBackend, "neboBackend");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(logger, "logger");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NeboUserProfileManager(LegacyPaidStorage legacyPaidStorage, PurchaseStorage purchaseStorage, PurchaseController purchaseController, Backend neboBackend, String packageName, NeboNetworkStateRepository networkStateRepository, ISubscriptionRepository subscriptionRepository, TechnicalLogger logger, SharedPreferences sharedPreferences) {
        this(legacyPaidStorage, purchaseStorage, purchaseController, neboBackend, packageName, networkStateRepository, subscriptionRepository, logger, sharedPreferences, null, null, 1536, null);
        Intrinsics.checkNotNullParameter(legacyPaidStorage, "legacyPaidStorage");
        Intrinsics.checkNotNullParameter(purchaseStorage, "purchaseStorage");
        Intrinsics.checkNotNullParameter(purchaseController, "purchaseController");
        Intrinsics.checkNotNullParameter(neboBackend, "neboBackend");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(logger, "logger");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NeboUserProfileManager(LegacyPaidStorage legacyPaidStorage, PurchaseStorage purchaseStorage, PurchaseController purchaseController, Backend neboBackend, String packageName, NeboNetworkStateRepository networkStateRepository, ISubscriptionRepository subscriptionRepository, TechnicalLogger logger, SharedPreferences sharedPreferences, CoroutineDispatcher mainDispatcher) {
        this(legacyPaidStorage, purchaseStorage, purchaseController, neboBackend, packageName, networkStateRepository, subscriptionRepository, logger, sharedPreferences, mainDispatcher, null, 1024, null);
        Intrinsics.checkNotNullParameter(legacyPaidStorage, "legacyPaidStorage");
        Intrinsics.checkNotNullParameter(purchaseStorage, "purchaseStorage");
        Intrinsics.checkNotNullParameter(purchaseController, "purchaseController");
        Intrinsics.checkNotNullParameter(neboBackend, "neboBackend");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [com.myscript.nebo.purchase.NeboUserProfileManager$purchaseListener$1] */
    public NeboUserProfileManager(LegacyPaidStorage legacyPaidStorage, PurchaseStorage purchaseStorage, PurchaseController purchaseController, Backend neboBackend, String packageName, NeboNetworkStateRepository networkStateRepository, ISubscriptionRepository subscriptionRepository, TechnicalLogger logger, SharedPreferences sharedPreferences, CoroutineDispatcher mainDispatcher, CoroutineDispatcher ioDispatcher) {
        ReadWriteProperty<Object, Boolean> readWriteProperty;
        BooleanSharedPreferencesProperty booleanSharedPreferencesPropertyBooleanPref;
        Intrinsics.checkNotNullParameter(legacyPaidStorage, "legacyPaidStorage");
        Intrinsics.checkNotNullParameter(purchaseStorage, "purchaseStorage");
        Intrinsics.checkNotNullParameter(purchaseController, "purchaseController");
        Intrinsics.checkNotNullParameter(neboBackend, "neboBackend");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.legacyPaidStorage = legacyPaidStorage;
        this.purchaseStorage = purchaseStorage;
        this.purchaseController = purchaseController;
        this.neboBackend = neboBackend;
        this.packageName = packageName;
        this.networkStateRepository = networkStateRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.logger = logger;
        this.sharedPreferences = sharedPreferences;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.parentJob = completableJobJob$default;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(completableJobJob$default.plus(mainDispatcher));
        this.scope = CoroutineScope;
        this.initialDataMutex = MutexKt.Mutex$default(false, 1, null);
        this.featureAccessListeners = new LinkedHashSet();
        ?? r7 = new PurchaseController.PurchaseListener() { // from class: com.myscript.nebo.purchase.NeboUserProfileManager$purchaseListener$1
            @Override // com.myscript.nebo.freemium.PurchaseController.PurchaseListener
            public void onProductPurchased(InAppProduct product, String packageName2, String purchaseToken) {
                Intrinsics.checkNotNullParameter(product, "product");
                Intrinsics.checkNotNullParameter(packageName2, "packageName");
                Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
                if (product == InAppProduct.UnlimitedPages) {
                    BuildersKt__Builders_commonKt.launch$default(this.this$0.scope, null, null, new NeboUserProfileManager$purchaseListener$1$onProductPurchased$1(this.this$0, purchaseToken, packageName2, product, null), 3, null);
                }
            }
        };
        this.purchaseListener = r7;
        this.paidPackageNames = CollectionsKt.listOf((Object[]) new String[]{"com.myscript.nebo.enterprise", "com.myscript.nebo.instrumented", "com.myscript.nebo.retail", "com.myscript.nebo.samsungretail"});
        if (sharedPreferences == null || (booleanSharedPreferencesPropertyBooleanPref = SharedPreferencesExtKt.booleanPref(sharedPreferences, PREF_DEBUG_SIMULATE_PAID_KEY, false)) == null) {
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            readWriteProperty = new ReadWriteProperty<Object, Boolean>() { // from class: com.myscript.nebo.purchase.NeboUserProfileManager$debugSimulatePaidEntitlement$2$1
                @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
                public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
                    return getValue(obj, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.ReadWriteProperty
                public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Boolean bool) {
                    setValue(obj, (KProperty<?>) kProperty, bool.booleanValue());
                }

                @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
                public Boolean getValue(Object thisRef, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    return Boolean.valueOf(booleanRef.element);
                }

                public void setValue(Object thisRef, KProperty<?> property, boolean value) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    booleanRef.element = value;
                }
            };
        } else {
            readWriteProperty = booleanSharedPreferencesPropertyBooleanPref;
        }
        this.debugSimulatePaidEntitlement = readWriteProperty;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.valueOf(hasPaidEntitlement()));
        this._isPaidSubscriber = MutableStateFlow;
        this.isPaidSubscriber = MutableStateFlow;
        purchaseController.addPurchaseListener((PurchaseController.PurchaseListener) r7);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C67191(null), 3, null);
    }

    public /* synthetic */ NeboUserProfileManager(LegacyPaidStorage legacyPaidStorage, PurchaseStorage purchaseStorage, PurchaseController purchaseController, Backend backend, String str, NeboNetworkStateRepository neboNetworkStateRepository, ISubscriptionRepository iSubscriptionRepository, TechnicalLogger technicalLogger, SharedPreferences sharedPreferences, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(legacyPaidStorage, purchaseStorage, purchaseController, backend, str, neboNetworkStateRepository, iSubscriptionRepository, technicalLogger, (i & 256) != 0 ? null : sharedPreferences, (i & 512) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 1024) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    private final boolean getDebugSimulatePaidEntitlement() {
        return ((Boolean) this.debugSimulatePaidEntitlement.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    private final void setDebugSimulatePaidEntitlement(boolean z) {
        this.debugSimulatePaidEntitlement.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public Flow<Boolean> isPaidSubscriber() {
        return this.isPaidSubscriber;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.NeboUserProfileManager$1 */
    /* JADX INFO: compiled from: NeboUserProfileManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager$1", m1609f = "NeboUserProfileManager.kt", m1610i = {}, m1611l = {104}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {107}, m1615s = {}, m1616v = 2)
    static final class C67191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67191(Continuation<? super C67191> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboUserProfileManager.this.new C67191(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.purchase.NeboUserProfileManager$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: NeboUserProfileManager.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/myscript/nebo/purchase/FreePeriodState;", "hasSubscribed", "trialState"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager$1$1", m1609f = "NeboUserProfileManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, FreePeriodState, Continuation<? super Pair<? extends Boolean, ? extends FreePeriodState>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ boolean Z$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, FreePeriodState freePeriodState, Continuation<? super Pair<? extends Boolean, ? extends FreePeriodState>> continuation) {
                return invoke(bool.booleanValue(), freePeriodState, (Continuation<? super Pair<Boolean, FreePeriodState>>) continuation);
            }

            public final Object invoke(boolean z, FreePeriodState freePeriodState, Continuation<? super Pair<Boolean, FreePeriodState>> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.Z$0 = z;
                anonymousClass1.L$0 = freePeriodState;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean z = this.Z$0;
                FreePeriodState freePeriodState = (FreePeriodState) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return TuplesKt.m1606to(Boxing.boxBoolean(z), freePeriodState);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowCombine = FlowKt.combine(NeboUserProfileManager.this.subscriptionRepository.getHasSubscribed(), NeboUserProfileManager.this.subscriptionRepository.getFreePeriodState(), new AnonymousClass1(null));
                final NeboUserProfileManager neboUserProfileManager = NeboUserProfileManager.this;
                this.label = 1;
                if (flowCombine.collect(new FlowCollector() { // from class: com.myscript.nebo.purchase.NeboUserProfileManager.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Pair<Boolean, FreePeriodState>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Pair<Boolean, FreePeriodState> pair, Continuation<? super Unit> continuation) {
                        neboUserProfileManager._isPaidSubscriber.setValue(Boxing.boxBoolean(neboUserProfileManager.hasPaidEntitlement()));
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

    /* JADX WARN: Path cross not found for [B:65:0x0169, B:68:0x017c], limit reached: 103 */
    /* JADX WARN: Path cross not found for [B:68:0x017c, B:51:0x0127], limit reached: 103 */
    /* JADX WARN: Path cross not found for [B:68:0x017c, B:53:0x012d], limit reached: 103 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6 A[Catch: all -> 0x01c7, TryCatch #4 {all -> 0x01c7, blocks: (B:39:0x00c0, B:41:0x00c6, B:43:0x00d5, B:45:0x00dd, B:77:0x019f), top: B:99:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0139 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:49:0x0123, B:51:0x0127, B:53:0x012d, B:54:0x0133, B:56:0x0139, B:58:0x0158, B:63:0x0165, B:65:0x0169, B:67:0x016f, B:70:0x017f, B:72:0x0187), top: B:95:0x0123 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019f A[Catch: all -> 0x01c7, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x01c7, blocks: (B:39:0x00c0, B:41:0x00c6, B:43:0x00d5, B:45:0x00dd, B:77:0x019f), top: B:99:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00d3 -> B:76:0x0198). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00db -> B:76:0x0198). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0116 -> B:95:0x0123). Please report as a decompilation issue!!! */
    @Override // com.myscript.nebo.IAsyncDataComponent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadInitialDataIfNeeded(Continuation<? super Unit> continuation) throws Throwable {
        C67231 c67231;
        Mutex mutex;
        int i;
        Mutex mutex2;
        Iterable iterable;
        int i2;
        Continuation continuation2;
        Iterator it;
        int i3;
        int i4;
        boolean z;
        String str;
        String str2;
        List<InApp> inApps;
        Object next;
        Map<String, String> customAttributes;
        if (continuation instanceof C67231) {
            c67231 = (C67231) continuation;
            if ((c67231.label & Integer.MIN_VALUE) != 0) {
                c67231.label -= Integer.MIN_VALUE;
            } else {
                c67231 = new C67231(continuation);
            }
        }
        Object obj = c67231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c67231.label;
        Continuation continuation3 = null;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex3 = this.initialDataMutex;
                c67231.L$0 = mutex3;
                c67231.I$0 = 0;
                c67231.label = 1;
                if (mutex3.lock(null, c67231) != coroutine_suspended) {
                    mutex = mutex3;
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i5 == 1) {
                i = c67231.I$0;
                mutex = (Mutex) c67231.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i5 == 2) {
                int i6 = c67231.I$4;
                int i7 = c67231.I$3;
                int i8 = c67231.I$2;
                int i9 = c67231.I$1;
                i3 = c67231.I$0;
                InAppProduct inAppProduct = (InAppProduct) c67231.L$4;
                Object obj2 = c67231.L$3;
                it = (Iterator) c67231.L$2;
                iterable = (Iterable) c67231.L$1;
                Mutex mutex4 = (Mutex) c67231.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Continuation continuation4 = null;
                    int i10 = i8;
                    C67231 c672312 = c67231;
                    mutex2 = mutex4;
                    try {
                        try {
                            InAppPurchaseResponse inAppPurchaseResponse = (InAppPurchaseResponse) obj;
                            if (inAppPurchaseResponse != null && (inApps = inAppPurchaseResponse.getInApps()) != null) {
                                Iterator<T> it2 = inApps.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        next = it2.next();
                                        InApp inApp = (InApp) next;
                                        if (Intrinsics.areEqual(inApp.getCustomAttributes().get(CustomAttributeKey.ProductId.getKey()), inAppProduct.getId()) && inApp.getStore() == Store.googleInApp) {
                                            break;
                                        }
                                    } else {
                                        next = null;
                                        break;
                                    }
                                }
                                InApp inApp2 = (InApp) next;
                                if (inApp2 == null && (customAttributes = inApp2.getCustomAttributes()) != null) {
                                    str2 = customAttributes.get(CustomAttributeKey.PurchaseState.getKey());
                                }
                                if (str2 != null && !Intrinsics.areEqual(str2, InAppKt.purchaseStatePurchasedValue)) {
                                    this.purchaseStorage.remove(inAppProduct);
                                    notifyUserStatusChanged();
                                }
                                continuation2 = continuation4;
                                i2 = i9;
                                mutex = mutex2;
                                c67231 = c672312;
                                i4 = i10;
                                continuation3 = null;
                                if (!it.hasNext()) {
                                    Object next2 = it.next();
                                    InAppProduct inAppProduct2 = (InAppProduct) next2;
                                    if (this.purchaseStorage.has(inAppProduct2) && (str = this.purchaseStorage.get(inAppProduct2)) != null) {
                                        CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
                                        NeboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1 neboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1 = new NeboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1(this, str, inAppProduct2, continuation3);
                                        c67231.L$0 = mutex;
                                        c67231.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                                        c67231.L$2 = it;
                                        c67231.L$3 = SpillingKt.nullOutSpilledVariable(next2);
                                        c67231.L$4 = inAppProduct2;
                                        c67231.L$5 = SpillingKt.nullOutSpilledVariable(str);
                                        c67231.I$0 = i3;
                                        c67231.I$1 = i2;
                                        c67231.I$2 = i4;
                                        c67231.I$3 = 0;
                                        c67231.I$4 = 0;
                                        c67231.label = 2;
                                        Object objWithContext = BuildersKt.withContext(coroutineDispatcher, neboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1, c67231);
                                        if (objWithContext != coroutine_suspended) {
                                            Mutex mutex5 = mutex;
                                            i9 = i2;
                                            obj = objWithContext;
                                            i10 = i4;
                                            c672312 = c67231;
                                            mutex2 = mutex5;
                                            Continuation continuation5 = continuation2;
                                            inAppProduct = inAppProduct2;
                                            continuation4 = continuation5;
                                            InAppPurchaseResponse inAppPurchaseResponse2 = (InAppPurchaseResponse) obj;
                                            if (inAppPurchaseResponse2 != null) {
                                                Iterator<T> it22 = inApps.iterator();
                                                while (true) {
                                                    if (!it22.hasNext()) {
                                                    }
                                                }
                                                InApp inApp22 = (InApp) next;
                                                if (inApp22 == null) {
                                                }
                                            }
                                        }
                                    }
                                    continuation3 = null;
                                    if (!it.hasNext()) {
                                        c67231.L$0 = mutex;
                                        c67231.L$1 = null;
                                        c67231.L$2 = null;
                                        c67231.L$3 = null;
                                        c67231.L$4 = null;
                                        c67231.L$5 = null;
                                        c67231.I$0 = i3;
                                        c67231.I$1 = i2;
                                        c67231.label = 3;
                                        if (fetchNeboAccount(c67231) != coroutine_suspended) {
                                            mutex2 = mutex;
                                            continuation3 = continuation2;
                                            z = true;
                                            this.initialDataLoadingDone = z;
                                            Unit unit = Unit.INSTANCE;
                                            mutex2.unlock(continuation3);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                }
                                return coroutine_suspended;
                            }
                            str2 = null;
                            if (str2 != null) {
                                this.purchaseStorage.remove(inAppProduct);
                                notifyUserStatusChanged();
                            }
                            continuation2 = continuation4;
                            i2 = i9;
                            mutex = mutex2;
                            c67231 = c672312;
                            i4 = i10;
                            if (!it.hasNext()) {
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            th = th;
                            continuation3 = continuation4;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2 = mutex;
                        continuation3 = continuation2;
                    }
                    continuation3 = null;
                } catch (Throwable th3) {
                    th = th3;
                    mutex2 = mutex4;
                }
            } else {
                if (i5 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i11 = c67231.I$1;
                int i12 = c67231.I$0;
                mutex2 = (Mutex) c67231.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    z = true;
                    this.initialDataLoadingDone = z;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(continuation3);
                    return Unit.INSTANCE;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            if (this.initialDataLoadingDone) {
                try {
                    Unit unit3 = Unit.INSTANCE;
                    mutex.unlock(null);
                    return unit3;
                } catch (Throwable th5) {
                    th = th5;
                }
            } else {
                List listListOf = CollectionsKt.listOf((Object[]) new InAppProduct[]{InAppProduct.UnlimitedPages, InAppProduct.FakeInApp});
                Iterator it3 = listListOf.iterator();
                iterable = listListOf;
                i2 = 0;
                continuation2 = null;
                it = it3;
                i3 = i;
                i4 = 0;
                if (!it.hasNext()) {
                }
                return coroutine_suspended;
            }
        } catch (Throwable th6) {
            th = th6;
        }
        mutex2 = mutex;
        mutex2.unlock(continuation3);
        throw th;
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public boolean hasFeatureAccess(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        int i = WhenMappings.$EnumSwitchMapping$0[feature.ordinal()];
        if (i == 1) {
            return hasAccessToAllFeatures();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return hasAccessToAllFeatures();
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public boolean hasLifetimeInAppPurchase() {
        return this.legacyPaidStorage.isPaidLegacyUser() || this.purchaseStorage.has(InAppProduct.UnlimitedPages) || this.purchaseStorage.has(InAppProduct.Lifetime);
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public boolean hasAccessToAllFeatures() {
        return hasPaidEntitlement() || (this.subscriptionRepository.getFreePeriodState().getValue().getStatus() == FreePeriodStatus.Active);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    @Override // com.myscript.nebo.account.UserProfileManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasPaidEntitlement() {
        boolean z;
        List<NeboAccount.Feature> features;
        if (getDebugSimulatePaidEntitlement()) {
            return true;
        }
        NeboAccount neboAccount = this.neboAccount;
        if (neboAccount == null || (features = neboAccount.getFeatures()) == null) {
            z = false;
        } else {
            List<NeboAccount.Feature> list = features;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (NeboAccount.Feature feature : list) {
                    if (feature.getName() == NeboAccount.Feature.Name.OpenApp || feature.getName() == NeboAccount.Feature.Name.UnlimitedNotebook) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
        }
        return z || isWhitelistedVersion() || this.subscriptionRepository.getHasSubscribed().getValue().booleanValue() || this.legacyPaidStorage.isPaidLegacyUser() || this.purchaseStorage.has(InAppProduct.UnlimitedPages) || this.purchaseStorage.has(InAppProduct.Lifetime);
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public boolean isFreePeriod() {
        return !hasPaidEntitlement() && this.subscriptionRepository.getFreePeriodState().getValue().getStatus() == FreePeriodStatus.Active;
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public boolean hasRecurringPurchase() {
        return hasPaidEntitlement() && this.subscriptionRepository.getHasSubscribed().getValue().booleanValue() && !(this.subscriptionRepository.getPlanType() == ISubscriptionRepository.PlanType.LIFETIME || hasLifetimeInAppPurchase());
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public void addFeatureAccessListener(FeatureAccessListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.featureAccessListeners.add(listener);
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public void removeFeatureAccessListener(FeatureAccessListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.featureAccessListeners.remove(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyUserStatusChanged() {
        EnumEntries<Feature> entries = Feature.getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (Feature feature : entries) {
            linkedHashMap.put(feature, Boolean.valueOf(hasFeatureAccess(feature)));
        }
        Iterator<T> it = this.featureAccessListeners.iterator();
        while (it.hasNext()) {
            ((FeatureAccessListener) it.next()).featuresAccessChanged(linkedHashMap);
        }
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public void release() {
        this.purchaseController.removePurchaseListener(this.purchaseListener);
    }

    public final void debugSetSimulatePaidEntitlement() {
        setDebugSimulatePaidEntitlement(true);
        refreshDebugEntitlementState();
    }

    public final void debugClearSimulatePaidEntitlement() {
        setDebugSimulatePaidEntitlement(false);
        refreshDebugEntitlementState();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.NeboUserProfileManager$refreshDebugEntitlementState$1 */
    /* JADX INFO: compiled from: NeboUserProfileManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager$refreshDebugEntitlementState$1", m1609f = "NeboUserProfileManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67251(Continuation<? super C67251> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboUserProfileManager.this.new C67251(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NeboUserProfileManager.this._isPaidSubscriber.setValue(Boxing.boxBoolean(NeboUserProfileManager.this.hasPaidEntitlement()));
                NeboUserProfileManager.this.notifyUserStatusChanged();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void refreshDebugEntitlementState() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C67251(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.NeboUserProfileManager$fetchNeboAccount$2 */
    /* JADX INFO: compiled from: NeboUserProfileManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager$fetchNeboAccount$2", m1609f = "NeboUserProfileManager.kt", m1610i = {0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3}, m1611l = {PDFACompliance.e_PDFA2_5_2, 260, 269, PDFACompliance.e_PDFA2_8_1}, m1612m = "invokeSuspend", m1613n = {"hasInternetAccess", "account", "hasInternetAccess", "$i$a$-let-NeboUserProfileManager$fetchNeboAccount$2$1", "isLegacyOnDevice", "isLegacyInBackend", "hasInternetAccess", "hasPaidEntitlement", "paidStatus", "hasInternetAccess", "hasPaidEntitlement"}, m1614nl = {255, 262, 273, 284}, m1615s = {"I$0", "L$1", "I$0", "I$1", "Z$0", "I$2", "I$0", "Z$0", "L$0", "I$0", "Z$0"}, m1616v = 2)
    static final class C67212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        C67212(Continuation<? super C67212> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboUserProfileManager.this.new C67212(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67212) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
        
            if (r13 == r0) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0165, code lost:
        
            if (com.myscript.nebo.account.backend.Backend.m12807setValueyxL6bBk$default(r12.this$0.neboBackend, com.myscript.nebo.purchase.NeboUserProfileManager.BACKEND_PAID_STATUS_KEY, r6, false, false, r12, 12, null) == r0) goto L63;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00f9 A[PHI: r6
          0x00f9: PHI (r6v3 ??) = (r6v1 ??), (r6v4 ??), (r6v4 ??), (r6v4 ??) binds: [B:21:0x0088, B:44:0x00ee, B:45:0x00f0, B:46:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0101  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
        /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r6v1, types: [int] */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v3, types: [int] */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v5 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            NeboUserProfileManager neboUserProfileManager;
            ?? r1;
            ?? r6;
            NeboAccount neboAccount;
            NeboUserProfileManager neboUserProfileManager2;
            boolean zIsPaidLegacyUser;
            int i;
            boolean z;
            int i2;
            ?? r12;
            boolean zHasPaidEntitlement;
            ?? r3;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ?? r13 = NeboUserProfileManager.this.networkStateRepository.getNeboNetworkState().getValue() instanceof NeboNetworkState.Connected;
                r1 = r13;
                if (r13 == 0) {
                    r6 = r1;
                    neboAccount = NeboUserProfileManager.this.neboAccount;
                    if (neboAccount == null) {
                        neboUserProfileManager2 = NeboUserProfileManager.this;
                        zIsPaidLegacyUser = neboUserProfileManager2.legacyPaidStorage.isPaidLegacyUser();
                        List<InApp> inAppPurchases = neboAccount.getInAppPurchases();
                        if (inAppPurchases != null) {
                            List<InApp> list = inAppPurchases;
                            if (!(list instanceof Collection) || !list.isEmpty()) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    if (((InApp) it.next()).getStore() == Store.GoogleInAppLegacy) {
                                        i = 1;
                                        break;
                                    }
                                }
                            }
                        }
                        i = 0;
                        if (zIsPaidLegacyUser && i == 0 && r6 != 0) {
                            Backend backend = neboUserProfileManager2.neboBackend;
                            this.L$0 = neboUserProfileManager2;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(neboAccount);
                            this.I$0 = r6;
                            this.I$1 = 0;
                            this.Z$0 = zIsPaidLegacyUser;
                            this.I$2 = i;
                            this.label = 2;
                            if (backend.flagLegacyPurchase(this) != coroutine_suspended) {
                                z = zIsPaidLegacyUser;
                                i2 = i;
                                r6 = r6;
                                i = i2;
                                zIsPaidLegacyUser = z;
                            }
                        }
                        if (!zIsPaidLegacyUser) {
                            neboUserProfileManager2.legacyPaidStorage.storeLegacyState(true);
                        }
                        if (NeboUserProfileManager.this.neboAccount != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    if (NeboUserProfileManager.this.neboAccount != null) {
                    }
                    return Unit.INSTANCE;
                }
                neboUserProfileManager = NeboUserProfileManager.this;
                this.L$0 = neboUserProfileManager;
                this.I$0 = r13;
                this.label = 1;
                obj = neboUserProfileManager.neboBackend.getNeboAccount(this);
                r12 = r13;
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        ((Result) obj).getValue();
                        return Unit.INSTANCE;
                    }
                    zHasPaidEntitlement = this.Z$0;
                    int i4 = this.I$0;
                    ResultKt.throwOnFailure(obj);
                    r3 = i4;
                    if (r3 != 0) {
                        if (!zHasPaidEntitlement && NeboUserProfileManager.this.isFreePeriod()) {
                            str = "trial";
                        } else if (zHasPaidEntitlement) {
                            str = "paying";
                        } else {
                            str = NeboUserProfileManager.BACKEND_PAID_STATUS_FREE;
                        }
                        String str2 = str;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                        this.I$0 = r3;
                        this.Z$0 = zHasPaidEntitlement;
                        this.label = 4;
                    }
                    return Unit.INSTANCE;
                }
                i2 = this.I$2;
                z = this.Z$0;
                int i5 = this.I$0;
                neboUserProfileManager2 = (NeboUserProfileManager) this.L$0;
                ResultKt.throwOnFailure(obj);
                r6 = i5;
                i = i2;
                zIsPaidLegacyUser = z;
                if (!zIsPaidLegacyUser && i != 0) {
                    neboUserProfileManager2.legacyPaidStorage.storeLegacyState(true);
                }
                if (NeboUserProfileManager.this.neboAccount != null) {
                    zHasPaidEntitlement = NeboUserProfileManager.this.hasPaidEntitlement();
                    this.L$0 = null;
                    this.L$1 = null;
                    this.I$0 = r6;
                    this.Z$0 = zHasPaidEntitlement;
                    this.label = 3;
                    if (BuildersKt.withContext(NeboUserProfileManager.this.mainDispatcher, new AnonymousClass2(NeboUserProfileManager.this, zHasPaidEntitlement, null), this) != coroutine_suspended) {
                        r3 = r6;
                        if (r3 != 0) {
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            int i6 = this.I$0;
            neboUserProfileManager = (NeboUserProfileManager) this.L$0;
            ResultKt.throwOnFailure(obj);
            r12 = i6;
            neboUserProfileManager.neboAccount = (NeboAccount) obj;
            r1 = r12;
            r6 = r1;
            neboAccount = NeboUserProfileManager.this.neboAccount;
            if (neboAccount == null) {
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.purchase.NeboUserProfileManager$fetchNeboAccount$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: NeboUserProfileManager.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager$fetchNeboAccount$2$2", m1609f = "NeboUserProfileManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $hasPaidEntitlement;
            int label;
            final /* synthetic */ NeboUserProfileManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(NeboUserProfileManager neboUserProfileManager, boolean z, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = neboUserProfileManager;
                this.$hasPaidEntitlement = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$hasPaidEntitlement, continuation);
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
                    this.this$0._isPaidSubscriber.setValue(Boxing.boxBoolean(this.$hasPaidEntitlement));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.UserProfileManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchNeboAccount(Continuation<? super Unit> continuation) {
        C67201 c67201;
        if (continuation instanceof C67201) {
            c67201 = (C67201) continuation;
            if ((c67201.label & Integer.MIN_VALUE) != 0) {
                c67201.label -= Integer.MIN_VALUE;
            } else {
                c67201 = new C67201(continuation);
            }
        }
        Object obj = c67201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c67201.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
            C67212 c67212 = new C67212(null);
            c67201.label = 1;
            if (BuildersKt.withContext(coroutineDispatcher, c67212, c67201) != coroutine_suspended) {
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
        CoroutineDispatcher coroutineDispatcher2 = this.mainDispatcher;
        C67223 c67223 = new C67223(null);
        c67201.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.NeboUserProfileManager$fetchNeboAccount$3 */
    /* JADX INFO: compiled from: NeboUserProfileManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager$fetchNeboAccount$3", m1609f = "NeboUserProfileManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67223 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67223(Continuation<? super C67223> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboUserProfileManager.this.new C67223(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67223) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NeboUserProfileManager.this.notifyUserStatusChanged();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.myscript.nebo.account.UserProfileManager
    public boolean isWhitelistedVersion() {
        return this.paidPackageNames.contains(this.packageName);
    }
}
