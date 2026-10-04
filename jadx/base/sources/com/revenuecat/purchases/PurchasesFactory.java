package com.revenuecat.purchases;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Process;
import androidx.core.os.UserManagerCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import aws.sdk.kotlin.services.p010s3.express.S3ExpressDefaultChecksumAlgorithmKt;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.PurchasesFactory;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DefaultLocaleProvider;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.HTTPClient;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.SharedPreferencesManager;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.audiences.AudiencesConfigProvider;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.caching.LocalTransactionMetadataStore;
import com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsFileHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.common.events.EventsRequest;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import com.revenuecat.purchases.common.localrules.LocalRulesEvaluator;
import com.revenuecat.purchases.common.localrules.RulesDimensionProvider;
import com.revenuecat.purchases.common.localrules.RulesEngineLoggerBridge;
import com.revenuecat.purchases.common.localrules.StoreDimensionProvider;
import com.revenuecat.purchases.common.localrules.SubscriberAttributesDimensionProvider;
import com.revenuecat.purchases.common.networking.APISourceFailover;
import com.revenuecat.purchases.common.networking.DeviceConnectivityChecker;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import com.revenuecat.purchases.common.networking.SourceHealthChecker;
import com.revenuecat.purchases.common.offerings.OfferingsCache;
import com.revenuecat.purchases.common.offerings.OfferingsFactory;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.offlineentitlements.PurchasedProductsFetcher;
import com.revenuecat.purchases.common.remoteconfig.ConfigTopic;
import com.revenuecat.purchases.common.remoteconfig.DefaultRemoteConfigSourceProvider;
import com.revenuecat.purchases.common.remoteconfig.PersistedRemoteConfigurationState;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobStore;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigDiskCache;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigTopic;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigTopicStore;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.uiconfig.UiConfigProvider;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.common.workflows.WorkflowAssetPrewarmer;
import com.revenuecat.purchases.common.workflows.WorkflowManager;
import com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.paywalls.FontLoader;
import com.revenuecat.purchases.paywalls.OfferingFontPreDownloader;
import com.revenuecat.purchases.paywalls.PaywallAssetWarming;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.storage.DefaultFileRepository;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.DefaultUrlConnectionFactory;
import com.revenuecat.purchases.utils.EventsFileHelper;
import com.revenuecat.purchases.utils.IsDebugBuildProvider;
import com.revenuecat.purchases.utils.OfferingImagePreDownloader;
import com.revenuecat.purchases.utils.OfferingWebViewPrewarmer;
import com.revenuecat.purchases.utils.PrewarmTargetOfferingsKt;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: PurchasesFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 42\u00020\u0001:\u000245B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002JF\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002JV\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\fH\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020 H\u0007J\f\u0010/\u001a\u000200*\u000201H\u0002J\u0014\u00102\u001a\u00020(*\u0002012\u0006\u00103\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, m1599d2 = {"Lcom/revenuecat/purchases/PurchasesFactory;", "", "isDebugBuild", "Lcom/revenuecat/purchases/utils/IsDebugBuildProvider;", "apiKeyValidator", "Lcom/revenuecat/purchases/APIKeyValidator;", "(Lcom/revenuecat/purchases/utils/IsDebugBuildProvider;Lcom/revenuecat/purchases/APIKeyValidator;)V", "blobUrlConnectionFactory", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "strategy", "Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "createDefaultExecutor", "Ljava/util/concurrent/ExecutorService;", "createEventsExecutor", "createEventsManager", "Lcom/revenuecat/purchases/common/events/EventsManager;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "eventsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, "Lcom/revenuecat/purchases/common/Backend;", "legacyEventsFileHelper", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "fileHelper", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "baseURL", "Ljava/net/URL;", "createPurchases", "Lcom/revenuecat/purchases/Purchases;", "configuration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "proxyURL", "overrideBillingAbstract", "Lcom/revenuecat/purchases/common/BillingAbstract;", "forceServerErrorStrategy", "forceSigningError", "", "runningIntegrationTests", "baseUrlString", "", "createRemoteConfigExecutor", "validateConfiguration", "Lcom/revenuecat/purchases/APIKeyValidator$ValidationResult;", "getApplication", "Landroid/app/Application;", "Landroid/content/Context;", "hasPermission", "permission", "Companion", "LowPriorityThreadFactory", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PurchasesFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final APIKeyValidator apiKeyValidator;
    private final IsDebugBuildProvider isDebugBuild;

    public PurchasesFactory(IsDebugBuildProvider isDebugBuild, APIKeyValidator apiKeyValidator) {
        Intrinsics.checkNotNullParameter(isDebugBuild, "isDebugBuild");
        Intrinsics.checkNotNullParameter(apiKeyValidator, "apiKeyValidator");
        this.isDebugBuild = isDebugBuild;
        this.apiKeyValidator = apiKeyValidator;
    }

    public /* synthetic */ PurchasesFactory(IsDebugBuildProvider isDebugBuildProvider, APIKeyValidator aPIKeyValidator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(isDebugBuildProvider, (i & 2) != 0 ? new APIKeyValidator() : aPIKeyValidator);
    }

    public static /* synthetic */ Purchases createPurchases$default(PurchasesFactory purchasesFactory, PurchasesConfiguration purchasesConfiguration, PlatformInfo platformInfo, URL url, BillingAbstract billingAbstract, ForceServerErrorStrategy forceServerErrorStrategy, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            billingAbstract = null;
        }
        if ((i & 16) != 0) {
            forceServerErrorStrategy = null;
        }
        if ((i & 32) != 0) {
            z = false;
        }
        if ((i & 64) != 0) {
            z2 = false;
        }
        if ((i & 128) != 0) {
            str = AppConfig.baseUrlString;
        }
        return purchasesFactory.createPurchases(purchasesConfiguration, platformInfo, url, billingAbstract, forceServerErrorStrategy, z, z2, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.revenuecat.purchases.common.verification.SignatureVerifier, java.lang.Object, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v9 */
    public final Purchases createPurchases(final PurchasesConfiguration configuration, PlatformInfo platformInfo, URL proxyURL, BillingAbstract overrideBillingAbstract, ForceServerErrorStrategy forceServerErrorStrategy, boolean forceSigningError, boolean runningIntegrationTests, String baseUrlString) {
        Store store;
        Application context;
        Context context2;
        Store store2;
        AppConfig appConfig;
        ?? r10;
        DiagnosticsTracker diagnosticsTracker;
        DiagnosticsFileHelper diagnosticsFileHelper;
        DiagnosticsHelper diagnosticsHelper;
        SignatureVerificationMode.Disabled disabledFromEntitlementVerificationMode$default;
        Store store3;
        DiagnosticsTracker diagnosticsTracker2;
        PaywallAssetWarming paywallAssetWarming;
        Application application;
        Backend backend;
        BackendHelper backendHelper;
        DeviceCache deviceCache;
        BillingAbstract billingAbstractCreateBilling;
        LocalRulesEvaluator localRulesEvaluator;
        Backend backend2;
        IdentityManager identityManager;
        DiagnosticsTracker diagnosticsTracker3;
        DiagnosticsSynchronizer diagnosticsSynchronizer;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        Intrinsics.checkNotNullParameter(baseUrlString, "baseUrlString");
        APIKeyValidator.ValidationResult validationResultValidateConfiguration = validateConfiguration(configuration);
        if (validationResultValidateConfiguration == APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            store = Store.TEST_STORE;
        } else {
            store = configuration.getStore();
        }
        Store store4 = store;
        Application application2 = getApplication(configuration.getContext());
        AppConfig appConfig2 = new AppConfig(configuration.getContext(), configuration.getPurchasesAreCompletedBy(), configuration.getShowInAppMessagesAutomatically(), platformInfo, proxyURL, store4, this.isDebugBuild.invoke(), validationResultValidateConfiguration, configuration.getDangerousSettings(), runningIntegrationTests, forceSigningError, baseUrlString);
        if (!UtilsKt.isDeviceProtectedStorageCompat(configuration.getContext())) {
            context = application2;
        } else {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "‼️ Using device-protected storage. Make sure to *always* configure Purchases with a Context object created using `createDeviceProtectedStorageContext()` to avoid undefined behavior.\nSee https://developer.android.com/reference/android/content/Context#createDeviceProtectedStorageContext() for more info.");
            }
            context = configuration.getContext();
        }
        Context context3 = context;
        try {
            SharedPreferences sharedPreferences = new SharedPreferencesManager(context3, null, null, 6, null).getSharedPreferences();
            ETagManager eTagManager = new ETagManager(context3, null, null, null, 14, null);
            Dispatcher dispatcher = new Dispatcher(createDefaultExecutor(), 0 == true ? 1 : 0, runningIntegrationTests, 2, null);
            ExecutorService service = configuration.getService();
            if (service == null) {
                service = createDefaultExecutor();
            }
            int i = 2;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Handler handler = null;
            Dispatcher dispatcher2 = new Dispatcher(service, handler, runningIntegrationTests, i, defaultConstructorMarker);
            Dispatcher dispatcher3 = new Dispatcher(createEventsExecutor(), handler, runningIntegrationTests, i, defaultConstructorMarker);
            Dispatcher dispatcher4 = new Dispatcher(createRemoteConfigExecutor(), handler, runningIntegrationTests, 2, defaultConstructorMarker);
            Companion companion = INSTANCE;
            if (companion.shouldInitializeDiagnostics$purchases_defaultsRelease(configuration.getDiagnosticsEnabled(), appConfig2.getUiPreviewMode()) && AndroidVersionUtilsKt.isAndroidNOrNewer()) {
                DiagnosticsFileHelper diagnosticsFileHelper2 = new DiagnosticsFileHelper(new FileHelper(context3));
                store2 = store4;
                r10 = 0;
                DiagnosticsHelper diagnosticsHelper2 = new DiagnosticsHelper(context3, diagnosticsFileHelper2, null, 4, null);
                context2 = context3;
                appConfig = appConfig2;
                diagnosticsTracker = new DiagnosticsTracker(appConfig2, diagnosticsFileHelper2, diagnosticsHelper2, dispatcher3, null, 16, null);
                diagnosticsFileHelper = diagnosticsFileHelper2;
                diagnosticsHelper = diagnosticsHelper2;
            } else {
                context2 = context3;
                store2 = store4;
                appConfig = appConfig2;
                r10 = 0;
                if (companion.shouldInitializeDiagnostics$purchases_defaultsRelease(configuration.getDiagnosticsEnabled(), appConfig.getUiPreviewMode())) {
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), "Diagnostics are only supported on Android N or newer.");
                    }
                }
                diagnosticsTracker = null;
                diagnosticsFileHelper = null;
                diagnosticsHelper = null;
            }
            try {
                disabledFromEntitlementVerificationMode$default = SignatureVerificationMode.Companion.fromEntitlementVerificationMode$default(SignatureVerificationMode.INSTANCE, configuration.getVerificationMode(), r10, 2, r10);
            } catch (IllegalStateException e) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Error creating signature verifier: " + e.getMessage() + ". Disabling signature verification.", r10);
                disabledFromEntitlementVerificationMode$default = SignatureVerificationMode.Disabled.INSTANCE;
            }
            SigningManager signingManager = new SigningManager(disabledFromEntitlementVerificationMode$default, appConfig, configuration.getApiKey());
            DeviceCache deviceCache2 = new DeviceCache(sharedPreferences, configuration.getApiKey(), null, 4, null);
            DefaultLocaleProvider defaultLocaleProvider = new DefaultLocaleProvider();
            final boolean z = !appConfig.getCustomEntitlementComputation();
            final RemoteConfigDiskCache remoteConfigDiskCache = new RemoteConfigDiskCache(context2);
            RemoteConfigTopicStore remoteConfigTopicStore = new RemoteConfigTopicStore() { // from class: com.revenuecat.purchases.PurchasesFactory$$ExternalSyntheticLambda0
                @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigTopicStore
                public final ConfigTopic topic(RemoteConfigTopic remoteConfigTopic) {
                    return PurchasesFactory.createPurchases$lambda$9$lambda$3(z, remoteConfigDiskCache, remoteConfigTopic);
                }
            };
            DefaultRemoteConfigSourceProvider defaultRemoteConfigSourceProvider = new DefaultRemoteConfigSourceProvider(remoteConfigTopicStore, null, null, 6, 0 == true ? 1 : 0);
            Context context4 = context2;
            Application application3 = application2;
            APISourceFailover aPISourceFailover = new APISourceFailover(appConfig, defaultRemoteConfigSourceProvider, new SourceHealthChecker(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0), new DeviceConnectivityChecker(application3));
            HTTPTimeoutManager hTTPTimeoutManager = new HTTPTimeoutManager(appConfig, null, 2, 0 == true ? 1 : 0);
            DefaultLocaleProvider defaultLocaleProvider2 = defaultLocaleProvider;
            AppConfig appConfig3 = appConfig;
            HTTPClient hTTPClient = new HTTPClient(appConfig3, eTagManager, diagnosticsTracker, signingManager, deviceCache2, aPISourceFailover, 0 == true ? 1 : 0, null, defaultLocaleProvider2, forceServerErrorStrategy, null, hTTPTimeoutManager, 1216, null);
            BackendHelper backendHelper2 = new BackendHelper(configuration.getApiKey(), dispatcher2, appConfig, hTTPClient);
            Backend backend3 = new Backend(appConfig3, dispatcher2, dispatcher3, hTTPClient, backendHelper2, dispatcher4);
            int i2 = 2;
            DefaultFileRepository defaultFileRepository = new DefaultFileRepository(application3, null, i2, 0 == true ? 1 : 0);
            PaywallAssetWarming paywallAssetWarming2 = new PaywallAssetWarming(application3, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
            PurchasesStateCache purchasesStateCache = new PurchasesStateCache(new PurchasesState(null, null, null, false, false, 31, null));
            if (overrideBillingAbstract == null) {
                paywallAssetWarming = paywallAssetWarming2;
                store3 = store2;
                DiagnosticsTracker diagnosticsTracker4 = diagnosticsTracker;
                application = application2;
                backendHelper = backendHelper2;
                deviceCache = deviceCache2;
                backend = backend3;
                diagnosticsTracker2 = diagnosticsTracker4;
                billingAbstractCreateBilling = BillingFactory.INSTANCE.createBilling(store3, application, backendHelper2, deviceCache2, PurchasesAreCompletedByKt.getFinishTransactions(configuration.getPurchasesAreCompletedBy()), diagnosticsTracker4, purchasesStateCache, appConfig.getApplyObfuscatedAccountIdToSubscriptionChanges(), configuration.getPendingTransactionsForPrepaidPlansEnabled(), configuration.getGalaxyBillingMode(), backend3);
            } else {
                store3 = store2;
                diagnosticsTracker2 = diagnosticsTracker;
                paywallAssetWarming = paywallAssetWarming2;
                application = application2;
                backend = backend3;
                backendHelper = backendHelper2;
                deviceCache = deviceCache2;
                billingAbstractCreateBilling = overrideBillingAbstract;
            }
            SubscriberAttributesPoster subscriberAttributesPoster = new SubscriberAttributesPoster(backendHelper);
            DeviceIdentifiersFetcher deviceIdentifiersFetcherCreateAttributionFetcher = AttributionFetcherFactory.INSTANCE.createAttributionFetcher(configuration.getStore(), dispatcher2);
            final SubscriberAttributesCache subscriberAttributesCache = new SubscriberAttributesCache(deviceCache);
            SubscriberAttributesManager subscriberAttributesManager = new SubscriberAttributesManager(subscriberAttributesCache, subscriberAttributesPoster, deviceIdentifiersFetcherCreateAttributionFetcher, configuration.getAutomaticDeviceIdentifierCollectionEnabled());
            BillingAbstract billingAbstract = billingAbstractCreateBilling;
            final DeviceCache deviceCache3 = deviceCache;
            DiagnosticsTracker diagnosticsTracker5 = diagnosticsTracker2;
            final AppConfig appConfig4 = appConfig;
            Backend backend4 = backend;
            PaywallAssetWarming paywallAssetWarming3 = paywallAssetWarming;
            OfflineEntitlementsManager offlineEntitlementsManager = new OfflineEntitlementsManager(backend4, new OfflineCustomerInfoCalculator(new PurchasedProductsFetcher(deviceCache3, billingAbstract, null, 4, null), appConfig4, diagnosticsTracker5, null, 8, null), deviceCache3, appConfig4, diagnosticsTracker5);
            final OfferingsCache offeringsCache = new OfferingsCache(deviceCache3, null, null, defaultLocaleProvider2, 6, 0 == true ? 1 : 0);
            RemoteConfigBlobStore remoteConfigBlobStore = new RemoteConfigBlobStore(context4);
            RemoteConfigManager remoteConfigManager = new RemoteConfigManager(backend4, remoteConfigDiskCache, remoteConfigBlobStore, null, null, 0 == true ? 1 : 0, remoteConfigTopicStore, defaultRemoteConfigSourceProvider, new RemoteConfigBlobFetcher(remoteConfigBlobStore, defaultRemoteConfigSourceProvider, hTTPTimeoutManager, blobUrlConnectionFactory(forceServerErrorStrategy), 0 == true ? 1 : 0, 16, null), new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$1$remoteConfigManager$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return deviceCache3.getCachedAppUserID$purchases_defaultsRelease();
                }
            }, null, z, 1080, null);
            FontLoader fontLoader = new FontLoader(context4, null, null, null, 14, null);
            OfferingFontPreDownloader offeringFontPreDownloader = new OfferingFontPreDownloader(context4, fontLoader);
            UiConfigProvider uiConfigProvider = new UiConfigProvider(remoteConfigManager, null, 2, 0 == true ? 1 : 0);
            WorkflowAssetPrewarmer workflowAssetPrewarmer = new WorkflowAssetPrewarmer(uiConfigProvider, paywallAssetWarming3, offeringFontPreDownloader);
            WorkflowsConfigProvider workflowsConfigProvider = new WorkflowsConfigProvider(remoteConfigManager, new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$1$workflowsConfigProvider$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Offering current;
                    Offerings cachedOfferings = offeringsCache.getCachedOfferings();
                    if (cachedOfferings == null || (current = cachedOfferings.getCurrent()) == null) {
                        return null;
                    }
                    return current.getIdentifier();
                }
            }, new Function0<Set<? extends String>>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$1$workflowsConfigProvider$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Set<? extends String> invoke() {
                    Offerings cachedOfferings = offeringsCache.getCachedOfferings();
                    Set<String> setPrewarmTargetOfferingIds = cachedOfferings != null ? PrewarmTargetOfferingsKt.prewarmTargetOfferingIds(cachedOfferings) : null;
                    return setPrewarmTargetOfferingIds == null ? SetsKt.emptySet() : setPrewarmTargetOfferingIds;
                }
            }, new PurchasesFactory$createPurchases$1$workflowsConfigProvider$3(workflowAssetPrewarmer), null, 16, null);
            CheckpointsConfigProvider checkpointsConfigProvider = new CheckpointsConfigProvider(remoteConfigManager);
            AudiencesConfigProvider audiencesConfigProvider = new AudiencesConfigProvider(remoteConfigManager);
            remoteConfigManager.registerListener(uiConfigProvider);
            remoteConfigManager.registerListener(workflowsConfigProvider);
            int configGeneration = remoteConfigManager.getConfigGeneration();
            uiConfigProvider.warmAsync(configGeneration);
            workflowsConfigProvider.warmAsync(configGeneration);
            final IdentityManager identityManager2 = new IdentityManager(appConfig4, deviceCache3, subscriberAttributesCache, subscriberAttributesManager, offeringsCache, remoteConfigManager, backend4, offlineEntitlementsManager, dispatcher, paywallAssetWarming3, appConfig4.getUiPreviewMode());
            RulesEngine.INSTANCE.setLogger(RulesEngineLoggerBridge.INSTANCE);
            LocalRulesEvaluator localRulesEvaluator2 = new LocalRulesEvaluator(CollectionsKt.listOf((Object[]) new RulesDimensionProvider[]{new DeviceDimensionProvider(appConfig4, defaultLocaleProvider2), new StoreDimensionProvider(new PurchasesFactory$createPurchases$1$localRulesEvaluator$1(null)), new SubscriberAttributesDimensionProvider(new Function0<Map<String, ? extends SubscriberAttribute>>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$1$localRulesEvaluator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends SubscriberAttribute> invoke() {
                    return subscriberAttributesCache.getAllStoredSubscriberAttributes(identityManager2.getCurrentAppUserID());
                }
            })}), null, 2, 0 == true ? 1 : 0);
            CustomerInfoUpdateHandler customerInfoUpdateHandler = new CustomerInfoUpdateHandler(deviceCache3, identityManager2, offlineEntitlementsManager, appConfig4, diagnosticsTracker5, null, 32, null);
            PaywallPresentedCache paywallPresentedCache = new PaywallPresentedCache();
            PostReceiptHelper postReceiptHelper = new PostReceiptHelper(appConfig4, backend4, billingAbstract, customerInfoUpdateHandler, deviceCache3, subscriberAttributesManager, offlineEntitlementsManager, paywallPresentedCache, new LocalTransactionMetadataStore(context4, configuration.getApiKey(), null, 0 == true ? 1 : 0, 12, null));
            PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper = new PostTransactionWithProductDetailsHelper(billingAbstract, postReceiptHelper);
            PostPendingTransactionsHelper postPendingTransactionsHelper = new PostPendingTransactionsHelper(appConfig4, deviceCache3, billingAbstract, dispatcher2, identityManager2, postTransactionWithProductDetailsHelper, postReceiptHelper);
            CustomerInfoHelper customerInfoHelper = new CustomerInfoHelper(deviceCache3, backend4, offlineEntitlementsManager, customerInfoUpdateHandler, postPendingTransactionsHelper, diagnosticsTracker5, appConfig4.getUiPreviewMode(), null, null, RendererCapabilities.DECODER_SUPPORT_MASK, null);
            OfferingParser offeringParserCreateOfferingParser = OfferingParserFactory.INSTANCE.createOfferingParser(store3);
            if (diagnosticsFileHelper == null || diagnosticsHelper == null || diagnosticsTracker5 == null || !AndroidVersionUtilsKt.isAndroidNOrNewer()) {
                localRulesEvaluator = localRulesEvaluator2;
                backend2 = backend4;
                identityManager = identityManager2;
                diagnosticsTracker3 = diagnosticsTracker5;
                diagnosticsSynchronizer = null;
            } else {
                diagnosticsSynchronizer = new DiagnosticsSynchronizer(diagnosticsHelper, diagnosticsFileHelper, diagnosticsTracker5, backend4, dispatcher3);
                backend2 = backend4;
                identityManager = identityManager2;
                localRulesEvaluator = localRulesEvaluator2;
                diagnosticsTracker3 = diagnosticsTracker5;
                diagnosticsTracker3.setListener(diagnosticsSynchronizer);
            }
            DiagnosticsTracker diagnosticsTracker6 = diagnosticsTracker3;
            SyncPurchasesHelper syncPurchasesHelper = new SyncPurchasesHelper(billingAbstract, identityManager, customerInfoHelper, postReceiptHelper, diagnosticsTracker6, null, 32, null);
            Application application4 = application;
            IdentityManager identityManager3 = identityManager;
            WorkflowManager workflowManager = new WorkflowManager(workflowsConfigProvider, uiConfigProvider, workflowAssetPrewarmer, null, z, 8, null);
            Backend backend5 = backend2;
            OfferingsManager offeringsManager = new OfferingsManager(offeringsCache, backend5, new OfferingsFactory(billingAbstract, offeringParserCreateOfferingParser, dispatcher, appConfig4), new OfferingImagePreDownloader(paywallAssetWarming3), diagnosticsTracker6, offeringFontPreDownloader, new OfferingWebViewPrewarmer(paywallAssetWarming3), dispatcher, appConfig4.getUiPreviewMode(), null, null, workflowManager, 1536, null);
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$9$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Debug logging enabled";
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel3 = LogLevel.DEBUG;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.mo1541d("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel4 = LogLevel.WARN;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.mo1545w("[Purchases] - " + logLevel4.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.mo1541d("[Purchases] - " + logLevel6.name(), function0.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel7 = LogLevel.INFO;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.mo1543i("[Purchases] - " + logLevel7.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel8 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.mo1541d("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel9 = LogLevel.DEBUG;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.mo1541d("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler10.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler11.mo1545w("[Purchases] - " + logLevel11.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler12.mo1545w("[Purchases] - " + logLevel12.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
            final LogIntent logIntent2 = LogIntent.DEBUG;
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$9$$inlined$log$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                    String str = String.format(ConfigureStrings.SDK_VERSION, Arrays.copyOf(new Object[]{Purchases.INSTANCE.getFrameworkVersion()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return sbAppend.append(str).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler13.mo1541d("[Purchases] - " + logLevel13.name(), function02.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel14 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler14.mo1545w("[Purchases] - " + logLevel14.name(), function02.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler15.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler16.mo1541d("[Purchases] - " + logLevel16.name(), function02.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel17 = LogLevel.INFO;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler17.mo1543i("[Purchases] - " + logLevel17.name(), function02.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel18 = LogLevel.DEBUG;
                    LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler18.mo1541d("[Purchases] - " + logLevel18.name(), function02.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel19 = LogLevel.DEBUG;
                    LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler19.mo1541d("[Purchases] - " + logLevel19.name(), function02.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler20.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel21 = LogLevel.WARN;
                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                        currentLogHandler21.mo1545w("[Purchases] - " + logLevel21.name(), function02.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel22 = LogLevel.WARN;
                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                        currentLogHandler22.mo1545w("[Purchases] - " + logLevel22.name(), function02.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
            }
            final LogIntent logIntent3 = LogIntent.DEBUG;
            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$9$$inlined$log$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                    String str = String.format(ConfigureStrings.PACKAGE_NAME, Arrays.copyOf(new Object[]{appConfig4.getPackageName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return sbAppend.append(str).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                case 1:
                    LogLevel logLevel23 = LogLevel.DEBUG;
                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                        currentLogHandler23.mo1541d("[Purchases] - " + logLevel23.name(), function03.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel24 = LogLevel.WARN;
                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                        currentLogHandler24.mo1545w("[Purchases] - " + logLevel24.name(), function03.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel25 = LogLevel.INFO;
                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                        currentLogHandler25.mo1543i("[Purchases] - " + logLevel25.name(), function03.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel26 = LogLevel.DEBUG;
                    LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                        currentLogHandler26.mo1541d("[Purchases] - " + logLevel26.name(), function03.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel27 = LogLevel.INFO;
                    LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                        currentLogHandler27.mo1543i("[Purchases] - " + logLevel27.name(), function03.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel28 = LogLevel.DEBUG;
                    LogHandler currentLogHandler28 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                        currentLogHandler28.mo1541d("[Purchases] - " + logLevel28.name(), function03.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel29 = LogLevel.DEBUG;
                    LogHandler currentLogHandler29 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                        currentLogHandler29.mo1541d("[Purchases] - " + logLevel29.name(), function03.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel30 = LogLevel.WARN;
                    LogHandler currentLogHandler30 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                        currentLogHandler30.mo1545w("[Purchases] - " + logLevel30.name(), function03.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel31 = LogLevel.WARN;
                    LogHandler currentLogHandler31 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel31) <= 0) {
                        currentLogHandler31.mo1545w("[Purchases] - " + logLevel31.name(), function03.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel32 = LogLevel.WARN;
                    LogHandler currentLogHandler32 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel32) <= 0) {
                        currentLogHandler32.mo1545w("[Purchases] - " + logLevel32.name(), function03.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                    break;
            }
            final LogIntent logIntent4 = LogIntent.USER;
            Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$9$$inlined$log$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent4.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                    String str = String.format(ConfigureStrings.INITIAL_APP_USER_ID, Arrays.copyOf(new Object[]{configuration.getAppUserID()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return sbAppend.append(str).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent4.ordinal()]) {
                case 1:
                    LogLevel logLevel33 = LogLevel.DEBUG;
                    LogHandler currentLogHandler33 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel33) <= 0) {
                        currentLogHandler33.mo1541d("[Purchases] - " + logLevel33.name(), function04.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel34 = LogLevel.WARN;
                    LogHandler currentLogHandler34 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel34) <= 0) {
                        currentLogHandler34.mo1545w("[Purchases] - " + logLevel34.name(), function04.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel35 = LogLevel.INFO;
                    LogHandler currentLogHandler35 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel35) <= 0) {
                        currentLogHandler35.mo1543i("[Purchases] - " + logLevel35.name(), function04.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel36 = LogLevel.DEBUG;
                    LogHandler currentLogHandler36 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel36) <= 0) {
                        currentLogHandler36.mo1541d("[Purchases] - " + logLevel36.name(), function04.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel37 = LogLevel.INFO;
                    LogHandler currentLogHandler37 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel37) <= 0) {
                        currentLogHandler37.mo1543i("[Purchases] - " + logLevel37.name(), function04.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel38 = LogLevel.DEBUG;
                    LogHandler currentLogHandler38 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel38) <= 0) {
                        currentLogHandler38.mo1541d("[Purchases] - " + logLevel38.name(), function04.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel39 = LogLevel.DEBUG;
                    LogHandler currentLogHandler39 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel39) <= 0) {
                        currentLogHandler39.mo1541d("[Purchases] - " + logLevel39.name(), function04.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel40 = LogLevel.WARN;
                    LogHandler currentLogHandler40 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel40) <= 0) {
                        currentLogHandler40.mo1545w("[Purchases] - " + logLevel40.name(), function04.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel41 = LogLevel.WARN;
                    LogHandler currentLogHandler41 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel41) <= 0) {
                        currentLogHandler41.mo1545w("[Purchases] - " + logLevel41.name(), function04.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel42 = LogLevel.WARN;
                    LogHandler currentLogHandler42 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel42) <= 0) {
                        currentLogHandler42.mo1545w("[Purchases] - " + logLevel42.name(), function04.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                    break;
            }
            final LogIntent logIntent5 = LogIntent.DEBUG;
            Function0<String> function05 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$9$$inlined$log$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent5.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                    String str = String.format(ConfigureStrings.VERIFICATION_MODE_SELECTED, Arrays.copyOf(new Object[]{configuration.getVerificationMode().name()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return sbAppend.append(str).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent5.ordinal()]) {
                case 1:
                    LogLevel logLevel43 = LogLevel.DEBUG;
                    LogHandler currentLogHandler43 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel43) <= 0) {
                        currentLogHandler43.mo1541d("[Purchases] - " + logLevel43.name(), function05.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function05.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel44 = LogLevel.WARN;
                    LogHandler currentLogHandler44 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel44) <= 0) {
                        currentLogHandler44.mo1545w("[Purchases] - " + logLevel44.name(), function05.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel45 = LogLevel.INFO;
                    LogHandler currentLogHandler45 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel45) <= 0) {
                        currentLogHandler45.mo1543i("[Purchases] - " + logLevel45.name(), function05.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel46 = LogLevel.DEBUG;
                    LogHandler currentLogHandler46 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel46) <= 0) {
                        currentLogHandler46.mo1541d("[Purchases] - " + logLevel46.name(), function05.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function05.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel47 = LogLevel.INFO;
                    LogHandler currentLogHandler47 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel47) <= 0) {
                        currentLogHandler47.mo1543i("[Purchases] - " + logLevel47.name(), function05.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel48 = LogLevel.DEBUG;
                    LogHandler currentLogHandler48 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel48) <= 0) {
                        currentLogHandler48.mo1541d("[Purchases] - " + logLevel48.name(), function05.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel49 = LogLevel.DEBUG;
                    LogHandler currentLogHandler49 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel49) <= 0) {
                        currentLogHandler49.mo1541d("[Purchases] - " + logLevel49.name(), function05.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel50 = LogLevel.WARN;
                    LogHandler currentLogHandler50 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel50) <= 0) {
                        currentLogHandler50.mo1545w("[Purchases] - " + logLevel50.name(), function05.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel51 = LogLevel.WARN;
                    LogHandler currentLogHandler51 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel51) <= 0) {
                        currentLogHandler51.mo1545w("[Purchases] - " + logLevel51.name(), function05.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function05.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel52 = LogLevel.WARN;
                    LogHandler currentLogHandler52 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel52) <= 0) {
                        currentLogHandler52.mo1545w("[Purchases] - " + logLevel52.name(), function05.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function05.invoke(), null);
                    break;
            }
            return new Purchases(new PurchasesOrchestrator(application4, configuration.getAppUserID(), backend5, billingAbstract, deviceCache3, identityManager3, subscriberAttributesManager, appConfig4, customerInfoHelper, customerInfoUpdateHandler, diagnosticsSynchronizer, diagnosticsTracker6, null, offlineEntitlementsManager, postReceiptHelper, postTransactionWithProductDetailsHelper, postPendingTransactionsHelper, syncPurchasesHelper, offeringsManager, createEventsManager(identityManager3, dispatcher3, backend5, EventsManager.INSTANCE.paywalls(new FileHelper(application3)), EventsManager.INSTANCE.backendEvents(new FileHelper(application3)), AppConfig.INSTANCE.getPaywallEventsURL()), createEventsManager(identityManager3, dispatcher3, backend5, null, EventsManager.INSTANCE.adEvents(new FileHelper(application3)), AppConfig.INSTANCE.getAdEventsURL()), paywallPresentedCache, purchasesStateCache, null, dispatcher, configuration, fontLoader, defaultLocaleProvider, null, new VirtualCurrencyManager(identityManager3, deviceCache3, backend5, appConfig4), new PurchaseParamsValidator(), workflowManager, null, null, null, defaultFileRepository, remoteConfigManager, uiConfigProvider, workflowsConfigProvider, checkpointsConfigProvider, audiencesConfigProvider, null, null, localRulesEvaluator, null, 276828160, 5639, null));
        } catch (IllegalStateException e2) {
            if (!UserManagerCompat.isUserUnlocked(configuration.getContext())) {
                throw new IllegalStateException("Trying to configure Purchases while the device is locked. If you need to support this scenario, ensure you *always* configure Purchases with a Context created with `createDeviceProtectedStorageContext()` to avoid undefined behavior.\nSee https://developer.android.com/reference/android/content/Context#createDeviceProtectedStorageContext() for more info.", e2);
            }
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConfigTopic createPurchases$lambda$9$lambda$3(boolean z, RemoteConfigDiskCache remoteConfigDiskCache, RemoteConfigTopic topic) {
        PersistedRemoteConfigurationState persistedRemoteConfigurationState;
        Map<String, ConfigTopic> topics;
        Intrinsics.checkNotNullParameter(topic, "topic");
        if (!z || (persistedRemoteConfigurationState = remoteConfigDiskCache.read()) == null || (topics = persistedRemoteConfigurationState.getTopics()) == null) {
            return null;
        }
        return topics.get(topic.getWireName());
    }

    private final EventsManager createEventsManager(IdentityManager identityManager, Dispatcher eventsDispatcher, final Backend backend, EventsFileHelper<PaywallStoredEvent> legacyEventsFileHelper, EventsFileHelper<BackendStoredEvent> fileHelper, final URL baseURL) {
        return new EventsManager(null, legacyEventsFileHelper, fileHelper, identityManager, eventsDispatcher, new Function4<EventsRequest, Delay, Function0<? extends Unit>, Function2<? super PurchasesError, ? super Boolean, ? extends Unit>, Unit>() { // from class: com.revenuecat.purchases.PurchasesFactory.createEventsManager.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(EventsRequest eventsRequest, Delay delay, Function0<? extends Unit> function0, Function2<? super PurchasesError, ? super Boolean, ? extends Unit> function2) {
                invoke2(eventsRequest, delay, (Function0<Unit>) function0, (Function2<? super PurchasesError, ? super Boolean, Unit>) function2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EventsRequest request, Delay delay, Function0<Unit> onSuccess, Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(delay, "delay");
                Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
                Intrinsics.checkNotNullParameter(onError, "onError");
                backend.postEvents(request, baseURL, delay, onSuccess, onError);
            }
        }, null, 65, null);
    }

    public final APIKeyValidator.ValidationResult validateConfiguration(PurchasesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (!hasPermission(configuration.getContext(), "android.permission.INTERNET")) {
            throw new IllegalArgumentException("Purchases requires INTERNET permission.".toString());
        }
        if (StringsKt.isBlank(configuration.getApiKey())) {
            throw new IllegalArgumentException("API key must be set. Get this from the RevenueCat web app".toString());
        }
        APIKeyValidator.ValidationResult validationResultValidateAndLog = this.apiKeyValidator.validateAndLog(configuration.getApiKey(), configuration.getStore());
        boolean z = true;
        boolean z2 = !this.isDebugBuild.invoke() && validationResultValidateAndLog == APIKeyValidator.ValidationResult.SIMULATED_STORE;
        if (!configuration.getDangerousSettings().getUiPreviewMode() && !configuration.getDangerousSettings().getAllowTestStoreInReleaseBuild()) {
            z = false;
        }
        if (z2 && !z) {
            String strRedactApiKey = this.apiKeyValidator.redactApiKey(configuration.getApiKey());
            LogUtilsKt.errorLog(new PurchasesError(PurchasesErrorCode.ConfigurationError, "Test Store API key used in release build: " + strRedactApiKey + ". Please configure the Play Store/Amazon app on the RevenueCat dashboard and use its corresponding API key before releasing. Visit https://rev.cat/sdk-test-store to learn more."));
            SimulatedStoreErrorDialogActivity.INSTANCE.show(configuration.getContext(), strRedactApiKey);
            return validationResultValidateAndLog;
        }
        if (configuration.getContext().getApplicationContext() instanceof Application) {
            return validationResultValidateAndLog;
        }
        throw new IllegalArgumentException("Needs an application context.".toString());
    }

    private final UrlConnectionFactory blobUrlConnectionFactory(ForceServerErrorStrategy strategy) {
        DefaultUrlConnectionFactory defaultUrlConnectionFactory = new DefaultUrlConnectionFactory();
        return strategy != null ? new ForcedFailureUrlConnectionFactory(defaultUrlConnectionFactory, strategy) : defaultUrlConnectionFactory;
    }

    private final Application getApplication(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        return (Application) applicationContext;
    }

    private final boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    private final ExecutorService createDefaultExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private final ExecutorService createEventsExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new LowPriorityThreadFactory("revenuecat-events-thread"));
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduled…venuecat-events-thread\"))");
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private final ExecutorService createRemoteConfigExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PurchasesFactory.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/PurchasesFactory$LowPriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "threadName", "", "(Ljava/lang/String;)V", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    static final class LowPriorityThreadFactory implements ThreadFactory {
        private final String threadName;

        public LowPriorityThreadFactory(String threadName) {
            Intrinsics.checkNotNullParameter(threadName, "threadName");
            this.threadName = threadName;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r) {
            return new Thread(new Runnable() { // from class: com.revenuecat.purchases.PurchasesFactory$LowPriorityThreadFactory$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PurchasesFactory.LowPriorityThreadFactory.newThread$lambda$1(r);
                }
            }, this.threadName);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void newThread$lambda$1(Runnable runnable) {
            if (runnable != null) {
                Process.setThreadPriority(5);
                runnable.run();
            }
        }
    }

    /* JADX INFO: compiled from: PurchasesFactory.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/PurchasesFactory$Companion;", "", "()V", "shouldInitializeDiagnostics", "", "diagnosticsEnabled", "uiPreviewMode", "shouldInitializeDiagnostics$purchases_defaultsRelease", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldInitializeDiagnostics$purchases_defaultsRelease(boolean diagnosticsEnabled, boolean uiPreviewMode) {
            return diagnosticsEnabled && !uiPreviewMode;
        }

        private Companion() {
        }
    }
}
