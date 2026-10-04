package com.revenuecat.purchases;

import android.app.Activity;
import android.app.Application;
import android.app.backup.BackupManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import aws.sdk.kotlin.services.p010s3.express.S3ExpressDefaultChecksumAlgorithmKt;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.ads.events.AdTracker;
import com.revenuecat.purchases.blockstore.BlockstoreHelper;
import com.revenuecat.purchases.checkpoints.CheckpointEvent;
import com.revenuecat.purchases.checkpoints.CheckpointResolution;
import com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolver;
import com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BackendErrorCode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DefaultLocaleProvider;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.audiences.AudiencesConfigProvider;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.localrules.LocalRulesEvaluator;
import com.revenuecat.purchases.common.localrules.RulesDimensionValue;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigFetchContext;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.common.uiconfig.UiConfigProvider;
import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowManager;
import com.revenuecat.purchases.common.workflows.WorkflowResolution;
import com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetRewardVerificationResultCallback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ManageSubscriptionsCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.PurchaseErrorCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.paywalls.FontLoader;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.storage.DefaultFileRepository;
import com.revenuecat.purchases.storage.FileRepository;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.IdentityStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.strings.SyncAttributesAndOfferingsStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CurrentActivityTracker;
import com.revenuecat.purchases.utils.CustomActivityLifecycleHandler;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import com.revenuecat.purchases.utils.RateLimiter;
import com.revenuecat.purchases.utils.Result;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: PurchasesOrchestrator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000ð\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 ±\u00032\u00020\u00012\u00020\u0002:\u0002±\u0003B\u0091\u0003\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020$\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020*\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\u0006\u00102\u001a\u000203\u0012\u0006\u00104\u001a\u000205\u0012\u0006\u00106\u001a\u000207\u0012\u0006\u00108\u001a\u000209\u0012\b\b\u0002\u0010:\u001a\u00020;\u0012\u0006\u0010<\u001a\u00020=\u0012\u0006\u0010>\u001a\u00020?\u0012\u0006\u0010@\u001a\u00020A\u0012\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C\u0012\b\b\u0002\u0010E\u001a\u00020F\u0012\b\b\u0002\u0010G\u001a\u00020H\u0012\b\b\u0002\u0010I\u001a\u00020J\u0012\u0006\u0010K\u001a\u00020L\u0012\u0006\u0010M\u001a\u00020N\u0012\u0006\u0010O\u001a\u00020P\u0012\u0006\u0010Q\u001a\u00020R\u0012\u0006\u0010S\u001a\u00020T\u0012\b\b\u0002\u0010U\u001a\u00020V\u0012\b\b\u0002\u0010W\u001a\u00020X\u0012\b\b\u0002\u0010Y\u001a\u00020Z\u0012\b\b\u0002\u0010[\u001a\u00020\\¢\u0006\u0002\u0010]J+\u0010È\u0001\u001a\u00020b2 \u0010É\u0001\u001a\u001b\u0012\u0006\u0012\u0004\u0018\u00010t\u0012\u0007\u0012\u0005\u0018\u00010Ë\u0001\u0012\u0005\u0012\u00030Ì\u00010Ê\u0001H\u0002J\b\u0010Í\u0001\u001a\u00030Ì\u0001J\b\u0010Î\u0001\u001a\u00030Ì\u0001J(\u0010Ï\u0001\u001a\u00030Ð\u00012\b\u0010Ñ\u0001\u001a\u00030Ð\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0002JI\u0010Ö\u0001\u001a\u00030Ì\u00012\u0007\u0010×\u0001\u001a\u00020\u00062\u0007\u0010Ø\u0001\u001a\u00020\u00062\u0015\u0010Ù\u0001\u001a\u0010\u0012\u0004\u0012\u00020b\u0012\u0005\u0012\u00030Ì\u00010Ú\u00012\u0016\u0010Û\u0001\u001a\u0011\u0012\u0005\u0012\u00030Ë\u0001\u0012\u0005\u0012\u00030Ì\u00010Ú\u0001J\u001a\u0010Ü\u0001\u001a\u00030Ì\u00012\u000e\u0010Ý\u0001\u001a\t\u0012\u0005\u0012\u00030Ì\u00010CH\u0002J\u001a\u0010Þ\u0001\u001a\u00030Ì\u00012\u000e\u0010ß\u0001\u001a\t\u0012\u0005\u0012\u00030Ì\u00010CH\u0002J\u0014\u0010à\u0001\u001a\u00030Ì\u00012\b\u0010á\u0001\u001a\u00030â\u0001H\u0002J\u0012\u0010ã\u0001\u001a\u00030Ì\u00012\b\u0010É\u0001\u001a\u00030ä\u0001J\u0011\u0010å\u0001\u001a\n\u0012\u0005\u0012\u00030Ð\u00010æ\u0001H\u0002J\f\u0010ç\u0001\u001a\u0005\u0018\u00010è\u0001H\u0002J\u0016\u0010é\u0001\u001a\u0005\u0018\u00010ê\u00012\b\u0010ë\u0001\u001a\u00030ì\u0001H\u0007J\u0012\u0010í\u0001\u001a\u00030Ì\u00012\b\u0010É\u0001\u001a\u00030î\u0001J%\u0010ï\u0001\u001a\u00030Ì\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\u0007\u0010ò\u0001\u001a\u00020b2\b\u0010É\u0001\u001a\u00030ó\u0001J\u0014\u0010ï\u0001\u001a\u00030Ì\u00012\b\u0010É\u0001\u001a\u00030ó\u0001H\u0002J\u001d\u0010ô\u0001\u001a\u00030Ì\u00012\b\u0010õ\u0001\u001a\u00030ö\u00012\t\b\u0002\u0010÷\u0001\u001a\u00020bJX\u0010ø\u0001\u001aE\u0012\u001f\u0012\u001d\u0012\u0005\u0012\u00030ú\u0001\u0012\u0005\u0012\u00030û\u0001\u0012\u0005\u0012\u00030Ì\u00010Ê\u0001j\u0003`ü\u0001\u0012\u001f\u0012\u001d\u0012\u0005\u0012\u00030ú\u0001\u0012\u0005\u0012\u00030Ë\u0001\u0012\u0005\u0012\u00030Ì\u00010Ê\u0001j\u0003`ý\u00010ù\u00012\n\u0010þ\u0001\u001a\u0005\u0018\u00010è\u0001H\u0002J0\u0010ÿ\u0001\u001a\u00030Ì\u00012\u000e\u0010\u0080\u0002\u001a\t\u0012\u0004\u0012\u00020\u00060æ\u00012\f\b\u0002\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u00022\b\u0010É\u0001\u001a\u00030\u0083\u0002J3\u0010\u0084\u0002\u001a\u00030Ì\u00012\u000e\u0010\u0080\u0002\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u00022\u000f\u0010\u0086\u0002\u001a\n\u0012\u0005\u0012\u00030\u0082\u00020\u0085\u00022\b\u0010É\u0001\u001a\u00030\u0083\u0002JT\u0010\u0084\u0002\u001a\u00030Ì\u00012\u000e\u0010\u0080\u0002\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u00022\u000f\u0010\u0086\u0002\u001a\n\u0012\u0005\u0012\u00030\u0082\u00020\u0085\u00022\u000f\u0010\u0087\u0002\u001a\n\u0012\u0005\u0012\u00030\u0088\u00020æ\u00012\f\b\u0002\u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u00012\b\u0010É\u0001\u001a\u00030\u0083\u0002H\u0002J\u0015\u0010\u0089\u0002\u001a\u0005\u0018\u00010Ð\u00012\u0007\u0010\u008a\u0002\u001a\u00020\u0006H\u0002JL\u0010\u008b\u0002\u001aE\u0012\u001f\u0012\u001d\u0012\u0005\u0012\u00030ú\u0001\u0012\u0005\u0012\u00030û\u0001\u0012\u0005\u0012\u00030Ì\u00010Ê\u0001j\u0003`ü\u0001\u0012\u001f\u0012\u001d\u0012\u0005\u0012\u00030ú\u0001\u0012\u0005\u0012\u00030Ë\u0001\u0012\u0005\u0012\u00030Ì\u00010Ê\u0001j\u0003`ý\u00010ù\u0001H\u0002J\n\u0010\u008c\u0002\u001a\u00030\u008d\u0002H\u0002J\u001b\u0010\u008e\u0002\u001a\u00030Ì\u00012\u0007\u0010\u008f\u0002\u001a\u00020\u00062\b\u0010É\u0001\u001a\u00030\u0090\u0002J\u0012\u0010·\u0001\u001a\u00030Ì\u00012\b\u0010É\u0001\u001a\u00030\u0091\u0002J\u0014\u0010º\u0001\u001a\u00030Ì\u00012\b\u0010É\u0001\u001a\u00030\u0092\u0002H\u0007J\u0011\u0010\u0093\u0002\u001a\u00030\u0094\u0002H\u0086@¢\u0006\u0003\u0010\u0095\u0002J\u0012\u0010\u0096\u0002\u001a\u00030Ì\u00012\b\u0010É\u0001\u001a\u00030\u0097\u0002J\u001a\u0010\u0098\u0002\u001a\u00030\u0099\u00022\u0007\u0010\u009a\u0002\u001a\u00020\u0006H\u0086@¢\u0006\u0003\u0010\u009b\u0002J\b\u0010\u009c\u0002\u001a\u00030Ì\u0001J\b\u0010\u009d\u0002\u001a\u00030Ì\u0001J\u001f\u0010\u009e\u0002\u001a\u00030Ì\u00012\u0007\u0010\u009f\u0002\u001a\u00020\u00062\f\b\u0002\u0010É\u0001\u001a\u0005\u0018\u00010 \u0002J\u0016\u0010¡\u0002\u001a\u00030Ì\u00012\f\b\u0002\u0010É\u0001\u001a\u0005\u0018\u00010ó\u0001J\u0014\u0010¢\u0002\u001a\u00030Ì\u00012\b\u0010£\u0002\u001a\u00030\u0083\u0001H\u0016J\u0014\u0010¤\u0002\u001a\u00030Ì\u00012\b\u0010£\u0002\u001a\u00030\u0083\u0001H\u0016J\u0014\u0010¥\u0002\u001a\u00030Ì\u00012\b\u0010£\u0002\u001a\u00030\u0083\u0001H\u0016J\n\u0010¦\u0002\u001a\u00030Ì\u0001H\u0016J\n\u0010§\u0002\u001a\u00030Ì\u0001H\u0016J\u0012\u0010¨\u0002\u001a\u00020b2\t\u0010©\u0002\u001a\u0004\u0018\u00010\u0006J\u001c\u0010ª\u0002\u001a\u00030Ì\u00012\b\u0010«\u0002\u001a\u00030¬\u00022\b\u0010É\u0001\u001a\u00030Ð\u0001J\u001c\u0010\u00ad\u0002\u001a\u00030Ì\u00012\b\u0010®\u0002\u001a\u00030¯\u00022\b\u0010õ\u0001\u001a\u00030°\u0002J\b\u0010±\u0002\u001a\u00030Ì\u0001Jb\u0010²\u0002\u001a\u00030Ì\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0007\u0010³\u0002\u001a\u00020\u00062\n\u0010´\u0002\u001a\u0005\u0018\u00010µ\u00022\b\u0010£\u0002\u001a\u00030\u0083\u00012\u0006\u0010l\u001a\u00020\u00062\n\u0010¶\u0002\u001a\u0005\u0018\u00010·\u00022\t\u0010¸\u0002\u001a\u0004\u0018\u00010b2\b\u0010õ\u0001\u001a\u00030¹\u0002H\u0002¢\u0006\u0003\u0010º\u0002J1\u0010»\u0002\u001a\u00030¼\u00022\u0007\u0010½\u0002\u001a\u00020\u00062\u0015\u0010¾\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030À\u00020¿\u0002H\u0086@¢\u0006\u0003\u0010Á\u0002J\u001a\u0010Â\u0002\u001a\u00030Ã\u00022\u0007\u0010Ä\u0002\u001a\u00020\u0006H\u0086@¢\u0006\u0003\u0010\u009b\u0002J\u0012\u0010Å\u0002\u001a\u00030Ì\u00012\b\u0010É\u0001\u001a\u00030ó\u0001J\u0013\u0010Æ\u0002\u001a\u00030Ì\u00012\t\u0010Ç\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010È\u0002\u001a\u00030Ì\u00012\t\u0010É\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010Ê\u0002\u001a\u00030Ì\u00012\t\u0010Ë\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010Ì\u0002\u001a\u00030Ì\u00012\t\u0010Í\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010Î\u0002\u001a\u00030Ì\u00012\t\u0010Ï\u0002\u001a\u0004\u0018\u00010\u0006J\u001c\u0010Ð\u0002\u001a\u00030Ì\u00012\u0012\u0010Ñ\u0002\u001a\r\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010¿\u0002J\u0013\u0010Ò\u0002\u001a\u00030Ì\u00012\t\u0010Ó\u0002\u001a\u0004\u0018\u00010\u0006J(\u0010Ô\u0002\u001a\u00030Ì\u00012\u0014\u0010Ñ\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060¿\u00022\b\u0010É\u0001\u001a\u00030Õ\u0002J \u0010Ö\u0002\u001a\u00030Ì\u00012\u0016\u0010×\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060¿\u0002J\u0013\u0010Ø\u0002\u001a\u00030Ì\u00012\t\u0010Ù\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010Ú\u0002\u001a\u00030Ì\u00012\t\u0010Û\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010Ü\u0002\u001a\u00030Ì\u00012\t\u0010Ý\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010Þ\u0002\u001a\u00030Ì\u00012\t\u0010ß\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010à\u0002\u001a\u00030Ì\u00012\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0006J\u0013\u0010á\u0002\u001a\u00030Ì\u00012\t\u0010â\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010ã\u0002\u001a\u00030Ì\u00012\t\u0010ä\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010å\u0002\u001a\u00030Ì\u00012\t\u0010æ\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010ç\u0002\u001a\u00030Ì\u00012\t\u0010è\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010é\u0002\u001a\u00030Ì\u00012\t\u0010ê\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010ë\u0002\u001a\u00030Ì\u00012\t\u0010ì\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010í\u0002\u001a\u00030Ì\u00012\t\u0010î\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010ï\u0002\u001a\u00030Ì\u00012\t\u0010ð\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010ñ\u0002\u001a\u00030Ì\u00012\t\u0010ò\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010ó\u0002\u001a\u00030Ì\u00012\t\u0010ô\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010õ\u0002\u001a\u00030Ì\u00012\t\u0010ö\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010÷\u0002\u001a\u00030Ì\u00012\t\u0010ø\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010ù\u0002\u001a\u00030Ì\u00012\t\u0010ú\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010û\u0002\u001a\u00030Ì\u00012\t\u0010ü\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010ý\u0002\u001a\u00030Ì\u00012\t\u0010þ\u0002\u001a\u0004\u0018\u00010\u0006J\u0013\u0010ÿ\u0002\u001a\u00030Ì\u00012\t\u0010\u0080\u0003\u001a\u0004\u0018\u00010\u0006J\u0013\u0010\u0081\u0003\u001a\u00030Ì\u00012\t\u0010\u0082\u0003\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0083\u0003\u001a\u00020b2\u0007\u0010\u0084\u0003\u001a\u00020bH\u0002J#\u0010\u0085\u0003\u001a\u00030Ì\u00012\b\u0010£\u0002\u001a\u00030\u0083\u00012\u000f\u0010\u0086\u0003\u001a\n\u0012\u0005\u0012\u00030\u0087\u00030æ\u0001J\u001e\u0010\u0088\u0003\u001a\u00030Ì\u00012\b\u0010\u0089\u0003\u001a\u00030\u008a\u00032\n\u0010É\u0001\u001a\u0005\u0018\u00010\u008b\u0003JX\u0010\u008c\u0003\u001a\u00030Ì\u00012\b\u0010£\u0002\u001a\u00030\u0083\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u00012\n\u0010¶\u0002\u001a\u0005\u0018\u00010·\u00022\u0007\u0010³\u0002\u001a\u00020\u00062\b\u0010´\u0002\u001a\u00030µ\u00022\t\u0010¸\u0002\u001a\u0004\u0018\u00010b2\b\u0010\u008d\u0003\u001a\u00030Ð\u0001H\u0002¢\u0006\u0003\u0010\u008e\u0003JE\u0010\u008f\u0003\u001a\u00030Ì\u00012\b\u0010£\u0002\u001a\u00030\u0083\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u00012\n\u0010¶\u0002\u001a\u0005\u0018\u00010·\u00022\t\u0010¸\u0002\u001a\u0004\u0018\u00010b2\b\u0010õ\u0001\u001a\u00030Ð\u0001H\u0002¢\u0006\u0003\u0010\u0090\u0003J\u0011\u0010\u0091\u0003\u001a\u00030Ì\u00012\u0007\u0010\u009f\u0002\u001a\u00020\u0006JL\u0010\u0092\u0003\u001a\u00030Ì\u00012\u0007\u0010\u0093\u0003\u001a\u00020\u00062\u0007\u0010\u0094\u0003\u001a\u00020\u00062\u0007\u0010\u0095\u0003\u001a\u00020\u00062\t\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u00062\n\u0010\u0097\u0003\u001a\u0005\u0018\u00010\u0098\u00032\n\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u009a\u0003¢\u0006\u0003\u0010\u009b\u0003J\u0012\u0010\u009c\u0003\u001a\u00030Ì\u00012\b\u0010É\u0001\u001a\u00030Õ\u0002J\u0016\u0010\u009d\u0003\u001a\u00030Ì\u00012\f\b\u0002\u0010õ\u0001\u001a\u0005\u0018\u00010\u009e\u0003J\u0014\u0010\u009f\u0003\u001a\u00030Ì\u00012\b\u0010á\u0001\u001a\u00030â\u0001H\u0002J\u0012\u0010 \u0003\u001a\u00030Ì\u00012\b\u0010¡\u0003\u001a\u00030¢\u0003J@\u0010£\u0003\u001a\u00030Ì\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\u000e\u0010¤\u0003\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u00022\u000e\u0010¥\u0003\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u00022\n\u0010¦\u0003\u001a\u0005\u0018\u00010Ë\u0001H\u0002J\u001a\u0010§\u0003\u001a\u00030Ì\u00012\u000e\u0010¤\u0003\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u0002H\u0002J6\u0010¨\u0003\u001a\u00030Ì\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u00012\n\u0010¦\u0003\u001a\u0005\u0018\u00010Ë\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\n\u0010©\u0003\u001a\u0005\u0018\u00010ª\u0003H\u0002J\u001d\u0010«\u0003\u001a\u00030Ì\u00012\u0007\u0010\u008a\u0002\u001a\u00020\u00062\b\u0010¬\u0003\u001a\u00030\u0082\u0002H\u0002J*\u0010\u00ad\u0003\u001a\u00030Ì\u00012\u0006\u0010l\u001a\u00020\u00062\b\u0010®\u0003\u001a\u00030¯\u00032\f\b\u0002\u0010°\u0003\u001a\u0005\u0018\u00010ó\u0001H\u0002J\u0019\u0010Ü\u0001\u001a\u00030Ì\u0001*\u00030¹\u00022\b\u0010¦\u0003\u001a\u00030Ë\u0001H\u0002R\u0010\u0010^\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010U\u001a\u00020V¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R$\u0010c\u001a\u00020b2\u0006\u0010a\u001a\u00020b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0011\u0010l\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bm\u0010nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010S\u001a\u00020T8\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010q\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\br\u0010nR\u0013\u0010s\u001a\u0004\u0018\u00010t8F¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0013\u0010w\u001a\u0004\u0018\u00010x8F¢\u0006\u0006\u001a\u0004\by\u0010zR,\u0010}\u001a\u0004\u0018\u00010|2\b\u0010{\u001a\u0004\u0018\u00010|8F@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00018F¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u000e\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0086\u0001\u001a\u0002058F¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R1\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00012\t\u0010{\u001a\u0005\u0018\u00010\u0089\u00018F@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R8\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00012\t\u0010{\u001a\u0005\u0018\u00010\u008f\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001*\u0006\b\u0091\u0001\u0010\u0092\u0001R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010I\u001a\u00020J¢\u0006\n\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R'\u0010\u0099\u0001\u001a\u00020b2\u0006\u0010a\u001a\u00020b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0001\u0010e\"\u0005\b\u009b\u0001\u0010gR\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u009c\u0001\u001a\u00020b8F¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010eR\u0010\u0010\u009d\u0001\u001a\u00030\u009e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u009f\u0001\u001a\u00030 \u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u001d\u001a\u00020\u001e8\u0007¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010§\u0001\u001a\u00030\u009e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010¨\u0001\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0007\u001a\u0005\b©\u0001\u0010nR\u0019\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C¢\u0006\n\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u00ad\u0001\u001a\u00030¬\u00012\u0007\u0010a\u001a\u00030¬\u00018@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u0015\u0010²\u0001\u001a\u00030³\u00018F¢\u0006\b\u001a\u0006\b´\u0001\u0010µ\u0001R$\u0010¶\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010{\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b·\u0001\u0010nR\u0017\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u00018F¢\u0006\b\u001a\u0006\bº\u0001\u0010»\u0001R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00012\t\u0010{\u001a\u0005\u0018\u00010¼\u00018F@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00012\t\u0010a\u001a\u0005\u0018\u00010Â\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006²\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/PurchasesOrchestrator;", "Lcom/revenuecat/purchases/LifecycleDelegate;", "Lcom/revenuecat/purchases/utils/CustomActivityLifecycleHandler;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "backingFieldAppUserID", "", S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, "Lcom/revenuecat/purchases/common/Backend;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "customerInfoHelper", "Lcom/revenuecat/purchases/CustomerInfoHelper;", "customerInfoUpdateHandler", "Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "diagnosticsSynchronizer", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "postReceiptHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "postTransactionWithProductDetailsHelper", "Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;", "postPendingTransactionsHelper", "Lcom/revenuecat/purchases/PostPendingTransactionsHelper;", "syncPurchasesHelper", "Lcom/revenuecat/purchases/SyncPurchasesHelper;", "offeringsManager", "Lcom/revenuecat/purchases/common/offerings/OfferingsManager;", "eventsManager", "Lcom/revenuecat/purchases/common/events/EventsManager;", "adEventsManager", "paywallPresentedCache", "Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;", "purchasesStateCache", "Lcom/revenuecat/purchases/PurchasesStateCache;", "mainHandler", "Landroid/os/Handler;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "initialConfiguration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "fontLoader", "Lcom/revenuecat/purchases/paywalls/FontLoader;", "localeProvider", "Lcom/revenuecat/purchases/common/DefaultLocaleProvider;", "webPurchaseRedemptionHelper", "Lcom/revenuecat/purchases/deeplinks/WebPurchaseRedemptionHelper;", "virtualCurrencyManager", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencyManager;", "purchaseParamsValidator", "Lcom/revenuecat/purchases/utils/PurchaseParamsValidator;", "workflowManager", "Lcom/revenuecat/purchases/common/workflows/WorkflowManager;", "processLifecycleOwnerProvider", "Lkotlin/Function0;", "Landroidx/lifecycle/LifecycleOwner;", "blockstoreHelper", "Lcom/revenuecat/purchases/blockstore/BlockstoreHelper;", "backupManager", "Landroid/app/backup/BackupManager;", "fileRepository", "Lcom/revenuecat/purchases/storage/FileRepository;", "remoteConfigManager", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;", "uiConfigProvider", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider;", "workflowsConfigProvider", "Lcom/revenuecat/purchases/common/workflows/WorkflowsConfigProvider;", "checkpointsConfigProvider", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointsConfigProvider;", "audiencesConfigProvider", "Lcom/revenuecat/purchases/common/audiences/AudiencesConfigProvider;", "adTracker", "Lcom/revenuecat/purchases/ads/events/AdTracker;", "currentActivityTracker", "Lcom/revenuecat/purchases/utils/CurrentActivityTracker;", "localRulesEvaluator", "Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluator;", "checkpointWorkflowResolver", "Lcom/revenuecat/purchases/checkpoints/CheckpointWorkflowResolver;", "(Landroid/app/Application;Ljava/lang/String;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/CustomerInfoHelper;Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/PostReceiptHelper;Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;Lcom/revenuecat/purchases/PostPendingTransactionsHelper;Lcom/revenuecat/purchases/SyncPurchasesHelper;Lcom/revenuecat/purchases/common/offerings/OfferingsManager;Lcom/revenuecat/purchases/common/events/EventsManager;Lcom/revenuecat/purchases/common/events/EventsManager;Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;Lcom/revenuecat/purchases/PurchasesStateCache;Landroid/os/Handler;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/PurchasesConfiguration;Lcom/revenuecat/purchases/paywalls/FontLoader;Lcom/revenuecat/purchases/common/DefaultLocaleProvider;Lcom/revenuecat/purchases/deeplinks/WebPurchaseRedemptionHelper;Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencyManager;Lcom/revenuecat/purchases/utils/PurchaseParamsValidator;Lcom/revenuecat/purchases/common/workflows/WorkflowManager;Lkotlin/jvm/functions/Function0;Lcom/revenuecat/purchases/blockstore/BlockstoreHelper;Landroid/app/backup/BackupManager;Lcom/revenuecat/purchases/storage/FileRepository;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider;Lcom/revenuecat/purchases/common/workflows/WorkflowsConfigProvider;Lcom/revenuecat/purchases/common/checkpoints/CheckpointsConfigProvider;Lcom/revenuecat/purchases/common/audiences/AudiencesConfigProvider;Lcom/revenuecat/purchases/ads/events/AdTracker;Lcom/revenuecat/purchases/utils/CurrentActivityTracker;Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluator;Lcom/revenuecat/purchases/checkpoints/CheckpointWorkflowResolver;)V", "_preferredUILocaleOverride", "getAdTracker", "()Lcom/revenuecat/purchases/ads/events/AdTracker;", "value", "", "allowSharingPlayStoreAccount", "getAllowSharingPlayStoreAccount", "()Z", "setAllowSharingPlayStoreAccount", "(Z)V", "getAppConfig", "()Lcom/revenuecat/purchases/common/AppConfig;", "setAppConfig", "(Lcom/revenuecat/purchases/common/AppConfig;)V", "appUserID", "getAppUserID", "()Ljava/lang/String;", "getAudiencesConfigProvider$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/common/audiences/AudiencesConfigProvider;", "cachedCurrentOfferingIdentifier", "getCachedCurrentOfferingIdentifier", "cachedOfferings", "Lcom/revenuecat/purchases/Offerings;", "getCachedOfferings", "()Lcom/revenuecat/purchases/Offerings;", "cachedVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "getCachedVirtualCurrencies", "()Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "<set-?>", "", "checkpointManagerSlot", "getCheckpointManagerSlot", "()Ljava/lang/Object;", "setCheckpointManagerSlot", "(Ljava/lang/Object;)V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "currentConfiguration", "getCurrentConfiguration", "()Lcom/revenuecat/purchases/PurchasesConfiguration;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "customerCenterListener", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "setCustomerCenterListener", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "Lcom/revenuecat/purchases/DebugEventListener;", "debugEventListener", "getDebugEventListener$delegate", "(Lcom/revenuecat/purchases/PurchasesOrchestrator;)Ljava/lang/Object;", "getDebugEventListener", "()Lcom/revenuecat/purchases/DebugEventListener;", "setDebugEventListener", "(Lcom/revenuecat/purchases/DebugEventListener;)V", "getFileRepository", "()Lcom/revenuecat/purchases/storage/FileRepository;", "finishTransactions", "getFinishTransactions", "setFinishTransactions", "isAnonymous", "lastSyncAttributesAndOfferingsRateLimiter", "Lcom/revenuecat/purchases/utils/RateLimiter;", "lifecycleHandler", "Lcom/revenuecat/purchases/AppLifecycleHandler;", "getLifecycleHandler", "()Lcom/revenuecat/purchases/AppLifecycleHandler;", "lifecycleHandler$delegate", "Lkotlin/Lazy;", "getOfflineEntitlementsManager", "()Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "preferredLocaleOverrideRateLimiter", "preferredUILocaleOverride", "getPreferredUILocaleOverride", "getProcessLifecycleOwnerProvider", "()Lkotlin/jvm/functions/Function0;", "Lcom/revenuecat/purchases/PurchasesState;", "state", "getState$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PurchasesState;", "setState$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/PurchasesState;)V", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "storefrontCountryCode", "getStorefrontCountryCode", "storefrontLocale", "Ljava/util/Locale;", "getStorefrontLocale", "()Ljava/util/Locale;", "Lcom/revenuecat/purchases/TrackedEventListener;", "trackedEventListener", "getTrackedEventListener", "()Lcom/revenuecat/purchases/TrackedEventListener;", "setTrackedEventListener", "(Lcom/revenuecat/purchases/TrackedEventListener;)V", "Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "updatedCustomerInfoListener", "getUpdatedCustomerInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "setUpdatedCustomerInfoListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;)V", "clearInMemoryCacheAndFetchOfferingsWithRateLimit", "callback", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/PurchasesError;", "", "close", "collectDeviceIdentifiers", "createCallbackWithDiagnosticsIfNeeded", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "originalCallback", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "startTime", "Ljava/util/Date;", "createSupportTicket", "email", "description", "onSuccess", "Lkotlin/Function1;", "onError", "dispatch", "action", "enqueue", "command", "flushEvents", "delay", "Lcom/revenuecat/purchases/common/Delay;", "getAmazonLWAConsentStatus", "Lcom/revenuecat/purchases/interfaces/GetAmazonLWAConsentStatusCallback;", "getAndClearAllPurchaseCallbacks", "", "getAndClearProductChangeCallback", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "getCachedFontFamilyOrStartDownload", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "fontInfo", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "getCustomerCenterConfig", "Lcom/revenuecat/purchases/interfaces/GetCustomerCenterConfigCallback;", "getCustomerInfo", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "trackDiagnostics", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "getOfferings", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "fetchCurrent", "getProductChangeCompletedCallbacks", "Landroid/util/Pair;", "Lcom/revenuecat/purchases/models/StoreTransaction;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "productChangeListener", "getProducts", "productIds", "type", "Lcom/revenuecat/purchases/ProductType;", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "getProductsOfTypes", "", "types", "collectedStoreProducts", "Lcom/revenuecat/purchases/models/StoreProduct;", "getPurchaseCallback", "productId", "getPurchaseCompletedCallbacks", "getPurchasesUpdatedListener", "Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "getRewardVerificationResult", "clientTransactionId", "Lcom/revenuecat/purchases/interfaces/GetRewardVerificationResultCallback;", "Lcom/revenuecat/purchases/interfaces/GetStorefrontCallback;", "Lcom/revenuecat/purchases/interfaces/GetStorefrontLocaleCallback;", "getUiConfig", "Lcom/revenuecat/purchases/UiConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVirtualCurrencies", "Lcom/revenuecat/purchases/interfaces/GetVirtualCurrenciesCallback;", "getWorkflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "workflowId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateCustomerInfoCache", "invalidateVirtualCurrenciesCache", "logIn", "newAppUserID", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logOut", "onActivityPaused", "activity", "onActivityStarted", "onActivityStopped", "onAppBackgrounded", "onAppForegrounded", "overridePreferredUILocale", "localeString", FirebaseAnalytics.Event.PURCHASE, "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "redeemWebPurchase", "webPurchaseRedemption", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener;", "removeUpdatedCustomerInfoListener", "replaceOldPurchaseWithNewProduct", "oldProductId", "replacementMode", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "isPersonalizedPrice", "Lcom/revenuecat/purchases/interfaces/PurchaseErrorCallback;", "(Lcom/revenuecat/purchases/models/PurchasingData;Ljava/lang/String;Lcom/revenuecat/purchases/models/StoreReplacementMode;Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/PurchaseErrorCallback;)V", "resolveCheckpoint", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution;", "checkpointIdentifier", "customVariables", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "offeringId", "restorePurchases", "setAd", "ad", "setAdGroup", "adGroup", "setAdjustID", "adjustID", "setAirbridgeDeviceID", "airbridgeDeviceID", "setAirshipChannelID", "airshipChannelID", "setAppsFlyerConversionData", "data", "setAppsflyerID", "appsflyerID", "setAppstackAttributionParams", "Lcom/revenuecat/purchases/interfaces/SyncAttributesAndOfferingsCallback;", "setAttributes", "attributes", "setCampaign", FirebaseAnalytics.Param.CAMPAIGN, "setCleverTapID", "cleverTapID", "setCreative", "creative", "setDisplayName", "displayName", "setEmail", "setFBAnonymousID", "fbAnonymousID", "setFirebaseAppInstanceID", "firebaseAppInstanceID", "setKeyword", "keyword", "setKochavaDeviceID", "kochavaDeviceID", "setMediaSource", "mediaSource", "setMixpanelDistinctID", "mixpanelDistinctID", "setMparticleID", "mparticleID", "setOnesignalID", "onesignalID", "setOnesignalUserID", "onesignalUserID", "setPhoneNumber", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "setPostHogUserId", "postHogUserId", "setPushToken", "fcmToken", "setSingularDeviceID", "singularDeviceID", "setSolarEngineAccountId", "solarEngineAccountId", "setSolarEngineDistinctId", "solarEngineDistinctId", "setSolarEngineVisitorId", "solarEngineVisitorId", "setTenjinAnalyticsInstallationID", "tenjinAnalyticsInstallationID", "shouldRefreshCustomerInfo", "firstTimeInForeground", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "showManageSubscriptions", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "Lcom/revenuecat/purchases/interfaces/ManageSubscriptionsCallback;", "startProductChange", "purchaseCallback", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/StoreReplacementMode;Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "startPurchase", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "switchUser", "syncAmazonPurchase", "productID", "receiptID", "amazonUserID", "isoCurrencyCode", "price", "", "purchaseTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;)V", "syncAttributesAndOfferingsIfNeeded", "syncPurchases", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "synchronizeSubscriberAttributesIfNeeded", "track", NotificationCompat.CATEGORY_EVENT, "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "trackGetProductsResult", "requestedProductIds", "notFoundProductIds", "error", "trackGetProductsStarted", "trackPurchaseResultIfNeeded", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "trackPurchaseStarted", "productType", "updateAllCaches", "fetchContext", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigFetchContext;", "completion", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PurchasesOrchestrator implements LifecycleDelegate, CustomActivityLifecycleHandler {
    public static final String frameworkVersion = "10.20.0";
    private static URL proxyURL;
    private volatile String _preferredUILocaleOverride;
    private final EventsManager adEventsManager;
    private final AdTracker adTracker;
    private AppConfig appConfig;
    private final Application application;
    private final AudiencesConfigProvider audiencesConfigProvider;
    private final Backend backend;
    private final BackupManager backupManager;
    private final BillingAbstract billing;
    private final BlockstoreHelper blockstoreHelper;
    private Object checkpointManagerSlot;
    private final CheckpointWorkflowResolver checkpointWorkflowResolver;
    private final CheckpointsConfigProvider checkpointsConfigProvider;
    private final CurrentActivityTracker currentActivityTracker;
    private CustomerCenterListener customerCenterListener;
    private final CustomerInfoHelper customerInfoHelper;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final DiagnosticsSynchronizer diagnosticsSynchronizer;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Dispatcher dispatcher;
    private final EventsManager eventsManager;
    private final FileRepository fileRepository;
    private final FontLoader fontLoader;
    private final IdentityManager identityManager;
    private final PurchasesConfiguration initialConfiguration;
    private final RateLimiter lastSyncAttributesAndOfferingsRateLimiter;

    /* JADX INFO: renamed from: lifecycleHandler$delegate, reason: from kotlin metadata */
    private final Lazy lifecycleHandler;
    private final LocalRulesEvaluator localRulesEvaluator;
    private final DefaultLocaleProvider localeProvider;
    private final Handler mainHandler;
    private final OfferingsManager offeringsManager;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PaywallPresentedCache paywallPresentedCache;
    private final PostPendingTransactionsHelper postPendingTransactionsHelper;
    private final PostReceiptHelper postReceiptHelper;
    private final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;
    private final RateLimiter preferredLocaleOverrideRateLimiter;
    private final Function0<LifecycleOwner> processLifecycleOwnerProvider;
    private final PurchaseParamsValidator purchaseParamsValidator;
    private final PurchasesStateCache purchasesStateCache;
    private final RemoteConfigManager remoteConfigManager;
    private String storefrontCountryCode;
    private final SubscriberAttributesManager subscriberAttributesManager;
    private final SyncPurchasesHelper syncPurchasesHelper;
    private TrackedEventListener trackedEventListener;
    private final UiConfigProvider uiConfigProvider;
    private final VirtualCurrencyManager virtualCurrencyManager;
    private final WebPurchaseRedemptionHelper webPurchaseRedemptionHelper;
    private final WorkflowManager workflowManager;
    private final WorkflowsConfigProvider workflowsConfigProvider;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static PlatformInfo platformInfo = new PlatformInfo("native", null);

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$getUiConfig$1 */
    /* JADX INFO: compiled from: PurchasesOrchestrator.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.PurchasesOrchestrator", m1609f = "PurchasesOrchestrator.kt", m1610i = {}, m1611l = {711}, m1612m = "getUiConfig", m1613n = {}, m1615s = {})
    static final class C70681 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C70681(Continuation<? super C70681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PurchasesOrchestrator.this.getUiConfig(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PurchasesOrchestrator(Application application, String str, Backend backend, BillingAbstract billing, DeviceCache deviceCache, IdentityManager identityManager, SubscriberAttributesManager subscriberAttributesManager, AppConfig appConfig, CustomerInfoHelper customerInfoHelper, CustomerInfoUpdateHandler customerInfoUpdateHandler, DiagnosticsSynchronizer diagnosticsSynchronizer, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, OfflineEntitlementsManager offlineEntitlementsManager, PostReceiptHelper postReceiptHelper, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, PostPendingTransactionsHelper postPendingTransactionsHelper, SyncPurchasesHelper syncPurchasesHelper, OfferingsManager offeringsManager, EventsManager eventsManager, EventsManager adEventsManager, PaywallPresentedCache paywallPresentedCache, PurchasesStateCache purchasesStateCache, Handler handler, Dispatcher dispatcher, PurchasesConfiguration initialConfiguration, FontLoader fontLoader, DefaultLocaleProvider localeProvider, WebPurchaseRedemptionHelper webPurchaseRedemptionHelper, VirtualCurrencyManager virtualCurrencyManager, PurchaseParamsValidator purchaseParamsValidator, WorkflowManager workflowManager, Function0<? extends LifecycleOwner> processLifecycleOwnerProvider, BlockstoreHelper blockstoreHelper, BackupManager backupManager, FileRepository fileRepository, RemoteConfigManager remoteConfigManager, UiConfigProvider uiConfigProvider, WorkflowsConfigProvider workflowsConfigProvider, CheckpointsConfigProvider checkpointsConfigProvider, AudiencesConfigProvider audiencesConfigProvider, AdTracker adTracker, CurrentActivityTracker currentActivityTracker, LocalRulesEvaluator localRulesEvaluator, CheckpointWorkflowResolver checkpointWorkflowResolver) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(customerInfoHelper, "customerInfoHelper");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        Intrinsics.checkNotNullParameter(postTransactionWithProductDetailsHelper, "postTransactionWithProductDetailsHelper");
        Intrinsics.checkNotNullParameter(postPendingTransactionsHelper, "postPendingTransactionsHelper");
        Intrinsics.checkNotNullParameter(syncPurchasesHelper, "syncPurchasesHelper");
        Intrinsics.checkNotNullParameter(offeringsManager, "offeringsManager");
        Intrinsics.checkNotNullParameter(eventsManager, "eventsManager");
        Intrinsics.checkNotNullParameter(adEventsManager, "adEventsManager");
        Intrinsics.checkNotNullParameter(paywallPresentedCache, "paywallPresentedCache");
        Intrinsics.checkNotNullParameter(purchasesStateCache, "purchasesStateCache");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(initialConfiguration, "initialConfiguration");
        Intrinsics.checkNotNullParameter(fontLoader, "fontLoader");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(webPurchaseRedemptionHelper, "webPurchaseRedemptionHelper");
        Intrinsics.checkNotNullParameter(virtualCurrencyManager, "virtualCurrencyManager");
        Intrinsics.checkNotNullParameter(purchaseParamsValidator, "purchaseParamsValidator");
        Intrinsics.checkNotNullParameter(workflowManager, "workflowManager");
        Intrinsics.checkNotNullParameter(processLifecycleOwnerProvider, "processLifecycleOwnerProvider");
        Intrinsics.checkNotNullParameter(blockstoreHelper, "blockstoreHelper");
        Intrinsics.checkNotNullParameter(backupManager, "backupManager");
        Intrinsics.checkNotNullParameter(fileRepository, "fileRepository");
        Intrinsics.checkNotNullParameter(remoteConfigManager, "remoteConfigManager");
        Intrinsics.checkNotNullParameter(uiConfigProvider, "uiConfigProvider");
        Intrinsics.checkNotNullParameter(workflowsConfigProvider, "workflowsConfigProvider");
        Intrinsics.checkNotNullParameter(checkpointsConfigProvider, "checkpointsConfigProvider");
        Intrinsics.checkNotNullParameter(audiencesConfigProvider, "audiencesConfigProvider");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(currentActivityTracker, "currentActivityTracker");
        Intrinsics.checkNotNullParameter(localRulesEvaluator, "localRulesEvaluator");
        Intrinsics.checkNotNullParameter(checkpointWorkflowResolver, "checkpointWorkflowResolver");
        this.application = application;
        this.backend = backend;
        this.billing = billing;
        this.deviceCache = deviceCache;
        this.identityManager = identityManager;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.appConfig = appConfig;
        this.customerInfoHelper = customerInfoHelper;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.diagnosticsSynchronizer = diagnosticsSynchronizer;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.postReceiptHelper = postReceiptHelper;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper;
        this.postPendingTransactionsHelper = postPendingTransactionsHelper;
        this.syncPurchasesHelper = syncPurchasesHelper;
        this.offeringsManager = offeringsManager;
        this.eventsManager = eventsManager;
        this.adEventsManager = adEventsManager;
        this.paywallPresentedCache = paywallPresentedCache;
        this.purchasesStateCache = purchasesStateCache;
        this.mainHandler = handler;
        this.dispatcher = dispatcher;
        this.initialConfiguration = initialConfiguration;
        this.fontLoader = fontLoader;
        this.localeProvider = localeProvider;
        this.webPurchaseRedemptionHelper = webPurchaseRedemptionHelper;
        this.virtualCurrencyManager = virtualCurrencyManager;
        this.purchaseParamsValidator = purchaseParamsValidator;
        this.workflowManager = workflowManager;
        this.processLifecycleOwnerProvider = processLifecycleOwnerProvider;
        this.blockstoreHelper = blockstoreHelper;
        this.backupManager = backupManager;
        this.fileRepository = fileRepository;
        this.remoteConfigManager = remoteConfigManager;
        this.uiConfigProvider = uiConfigProvider;
        this.workflowsConfigProvider = workflowsConfigProvider;
        this.checkpointsConfigProvider = checkpointsConfigProvider;
        this.audiencesConfigProvider = audiencesConfigProvider;
        this.adTracker = adTracker;
        this.currentActivityTracker = currentActivityTracker;
        this.localRulesEvaluator = localRulesEvaluator;
        this.checkpointWorkflowResolver = checkpointWorkflowResolver;
        this.lifecycleHandler = LazyKt.lazy(new Function0<AppLifecycleHandler>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$lifecycleHandler$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AppLifecycleHandler invoke() {
                return new AppLifecycleHandler(this.this$0);
            }
        });
        Duration.Companion companion = Duration.INSTANCE;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.lastSyncAttributesAndOfferingsRateLimiter = new RateLimiter(5, DurationKt.toDuration(60, DurationUnit.SECONDS), defaultConstructorMarker);
        Duration.Companion companion2 = Duration.INSTANCE;
        this.preferredLocaleOverrideRateLimiter = new RateLimiter(2, DurationKt.toDuration(60, DurationUnit.SECONDS), defaultConstructorMarker);
        this._preferredUILocaleOverride = initialConfiguration.getPreferredUILocaleOverride();
        localeProvider.setPreferredLocaleOverride(this._preferredUILocaleOverride);
        identityManager.configure(str);
        billing.setStateListener(new BillingAbstract.StateListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.3
            @Override // com.revenuecat.purchases.common.BillingAbstract.StateListener
            public void onConnected() {
                PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(PurchasesOrchestrator.this.postPendingTransactionsHelper, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), null, 2, null);
                BillingAbstract billingAbstract = PurchasesOrchestrator.this.billing;
                final PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                billingAbstract.getStorefront(new Function1<String, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$3$onConnected$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                        invoke2(str2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String countryCode) {
                        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
                        purchasesOrchestrator.storefrontCountryCode = countryCode;
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            String str2 = "[Purchases] - " + logLevel.name();
                            String str3 = String.format(BillingStrings.BILLING_COUNTRY_CODE, Arrays.copyOf(new Object[]{countryCode}, 1));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            currentLogHandler.mo1541d(str2, str3);
                        }
                    }
                }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$3$onConnected$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                        invoke2(purchasesError);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        LogUtilsKt.errorLog(error);
                    }
                });
            }
        });
        billing.setPurchasesUpdatedListener(getPurchasesUpdatedListener());
        BillingAbstract.startConnection$default(billing, 0L, 1, null);
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PurchasesOrchestrator.this.getProcessLifecycleOwnerProvider().invoke().getLifecycle().addObserver(PurchasesOrchestrator.this.getLifecycleHandler());
                PurchasesOrchestrator.this.application.registerActivityLifecycleCallbacks(PurchasesOrchestrator.this);
            }
        });
        if (this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            return;
        }
        final LogIntent logIntent = LogIntent.WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$special$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Automatic syncing of purchases has been disabled. \nRevenueCat won’t observe the new purchases from the store, and it will not sync any purchase \nautomatically. Call syncPurchases whenever a new transaction is completed so the \nreceipt is sent to RevenueCat’s backend. Consumables disappear from the receipt \nafter the transaction is finished, so make sure purchases are synced before \nfinishing any consumable transaction, otherwise RevenueCat won’t register the \npurchase.";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), function0.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.mo1541d("[Purchases] - " + logLevel4.name(), function0.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler6.mo1541d("[Purchases] - " + logLevel6.name(), function0.invoke());
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler7.mo1541d("[Purchases] - " + logLevel7.name(), function0.invoke());
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler8.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler9.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler10.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
    }

    public final AppConfig getAppConfig() {
        return this.appConfig;
    }

    public final void setAppConfig(AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "<set-?>");
        this.appConfig = appConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ PurchasesOrchestrator(Application application, String str, Backend backend, BillingAbstract billingAbstract, DeviceCache deviceCache, IdentityManager identityManager, SubscriberAttributesManager subscriberAttributesManager, AppConfig appConfig, CustomerInfoHelper customerInfoHelper, CustomerInfoUpdateHandler customerInfoUpdateHandler, DiagnosticsSynchronizer diagnosticsSynchronizer, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, OfflineEntitlementsManager offlineEntitlementsManager, PostReceiptHelper postReceiptHelper, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, PostPendingTransactionsHelper postPendingTransactionsHelper, SyncPurchasesHelper syncPurchasesHelper, OfferingsManager offeringsManager, EventsManager eventsManager, EventsManager eventsManager2, PaywallPresentedCache paywallPresentedCache, PurchasesStateCache purchasesStateCache, Handler handler, Dispatcher dispatcher, PurchasesConfiguration purchasesConfiguration, FontLoader fontLoader, DefaultLocaleProvider defaultLocaleProvider, WebPurchaseRedemptionHelper webPurchaseRedemptionHelper, VirtualCurrencyManager virtualCurrencyManager, PurchaseParamsValidator purchaseParamsValidator, WorkflowManager workflowManager, Function0 function0, BlockstoreHelper blockstoreHelper, BackupManager backupManager, FileRepository fileRepository, RemoteConfigManager remoteConfigManager, UiConfigProvider uiConfigProvider, WorkflowsConfigProvider workflowsConfigProvider, CheckpointsConfigProvider checkpointsConfigProvider, AudiencesConfigProvider audiencesConfigProvider, AdTracker adTracker, CurrentActivityTracker currentActivityTracker, LocalRulesEvaluator localRulesEvaluator, CheckpointWorkflowResolver checkpointWorkflowResolver, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        FileRepository defaultFileRepository;
        EventsManager eventsManager3;
        AdTracker adTracker2;
        LocalRulesEvaluator localRulesEvaluator2;
        DateProvider defaultDateProvider = (i & 4096) != 0 ? new DefaultDateProvider() : dateProvider;
        Handler handler2 = (8388608 & i) != 0 ? new Handler(Looper.getMainLooper()) : handler;
        WebPurchaseRedemptionHelper webPurchaseRedemptionHelper2 = (i & 268435456) != 0 ? new WebPurchaseRedemptionHelper(backend, identityManager, offlineEntitlementsManager, customerInfoUpdateHandler, null, 16, null) : webPurchaseRedemptionHelper;
        Function0 function02 = (i2 & 1) != 0 ? new Function0<LifecycleOwner>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LifecycleOwner invoke() {
                LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "get()");
                return lifecycleOwner;
            }
        } : function0;
        BlockstoreHelper blockstoreHelper2 = (i2 & 2) != 0 ? new BlockstoreHelper(application, identityManager, null, null, null, 28, null) : blockstoreHelper;
        BackupManager backupManager2 = (i2 & 4) != 0 ? new BackupManager(application) : backupManager;
        int i3 = 2;
        String str2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if ((i2 & 8) != 0) {
            defaultFileRepository = new DefaultFileRepository(application, str2, i3, objArr3 == true ? 1 : 0);
        } else {
            defaultFileRepository = fileRepository;
        }
        if ((i2 & 512) != 0) {
            eventsManager3 = eventsManager2;
            adTracker2 = new AdTracker(eventsManager3);
        } else {
            eventsManager3 = eventsManager2;
            adTracker2 = adTracker;
        }
        CurrentActivityTracker currentActivityTracker2 = (i2 & 1024) != 0 ? new CurrentActivityTracker() : currentActivityTracker;
        if ((i2 & 2048) != 0) {
            localRulesEvaluator2 = new LocalRulesEvaluator(CollectionsKt.emptyList(), objArr2 == true ? 1 : 0, i3, objArr == true ? 1 : 0);
        } else {
            localRulesEvaluator2 = localRulesEvaluator;
        }
        this(application, str, backend, billingAbstract, deviceCache, identityManager, subscriberAttributesManager, appConfig, customerInfoHelper, customerInfoUpdateHandler, diagnosticsSynchronizer, diagnosticsTracker, defaultDateProvider, offlineEntitlementsManager, postReceiptHelper, postTransactionWithProductDetailsHelper, postPendingTransactionsHelper, syncPurchasesHelper, offeringsManager, eventsManager, eventsManager3, paywallPresentedCache, purchasesStateCache, handler2, dispatcher, purchasesConfiguration, fontLoader, defaultLocaleProvider, webPurchaseRedemptionHelper2, virtualCurrencyManager, purchaseParamsValidator, workflowManager, function02, blockstoreHelper2, backupManager2, defaultFileRepository, remoteConfigManager, uiConfigProvider, workflowsConfigProvider, checkpointsConfigProvider, audiencesConfigProvider, adTracker2, currentActivityTracker2, localRulesEvaluator2, (i2 & 4096) != 0 ? new CheckpointWorkflowResolverImpl(workflowManager, uiConfigProvider, checkpointsConfigProvider, audiencesConfigProvider, localRulesEvaluator2, new C70352(null)) : checkpointWorkflowResolver);
    }

    public final OfflineEntitlementsManager getOfflineEntitlementsManager() {
        return this.offlineEntitlementsManager;
    }

    public final Function0<LifecycleOwner> getProcessLifecycleOwnerProvider() {
        return this.processLifecycleOwnerProvider;
    }

    public final FileRepository getFileRepository() {
        return this.fileRepository;
    }

    /* JADX INFO: renamed from: getAudiencesConfigProvider$purchases_defaultsRelease, reason: from getter */
    public final AudiencesConfigProvider getAudiencesConfigProvider() {
        return this.audiencesConfigProvider;
    }

    public final AdTracker getAdTracker() {
        return this.adTracker;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$2 */
    /* JADX INFO: compiled from: PurchasesOrchestrator.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/Offerings;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.PurchasesOrchestrator$2", m1609f = "PurchasesOrchestrator.kt", m1610i = {}, m1611l = {198}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C70352 extends SuspendLambda implements Function1<Continuation<? super Offerings>, Object> {
        int label;

        C70352(Continuation<? super C70352> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C70352(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Offerings> continuation) {
            return ((C70352) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws PurchasesException {
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
            Object objAwaitOfferings = CoroutinesExtensionsCommonKt.awaitOfferings(Purchases.INSTANCE.getSharedInstance(), this);
            return objAwaitOfferings == coroutine_suspended ? coroutine_suspended : objAwaitOfferings;
        }
    }

    public final PurchasesState getState$purchases_defaultsRelease() {
        return this.purchasesStateCache.getPurchasesState();
    }

    public final void setState$purchases_defaultsRelease(PurchasesState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.purchasesStateCache.setPurchasesState(value);
    }

    public final String getCachedCurrentOfferingIdentifier() {
        return this.offeringsManager.getCachedCurrentOfferingIdentifier();
    }

    public final Offerings getCachedOfferings() {
        return this.offeringsManager.getCachedOfferings();
    }

    public final PurchasesConfiguration getCurrentConfiguration() {
        if (this.initialConfiguration.getAppUserID() == null) {
            return this.initialConfiguration;
        }
        return PurchasesConfiguration.copy$purchases_defaultsRelease$default(this.initialConfiguration, getAppUserID(), null, 2, null);
    }

    public final synchronized boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    public final synchronized void setFinishTransactions(boolean z) {
        this.appConfig.setFinishTransactions(z);
    }

    public final synchronized String getAppUserID() {
        return this.identityManager.getCurrentAppUserID();
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.customerInfoUpdateHandler.getUpdatedCustomerInfoListener();
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.customerInfoUpdateHandler.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final synchronized CustomerCenterListener getCustomerCenterListener() {
        return this.customerCenterListener;
    }

    public final synchronized void setCustomerCenterListener(CustomerCenterListener customerCenterListener) {
        this.customerCenterListener = customerCenterListener;
    }

    public final synchronized TrackedEventListener getTrackedEventListener() {
        return this.trackedEventListener;
    }

    public final synchronized void setTrackedEventListener(TrackedEventListener trackedEventListener) {
        this.trackedEventListener = trackedEventListener;
    }

    public final synchronized DebugEventListener getDebugEventListener() {
        return this.eventsManager.getDebugEventListener();
    }

    public final synchronized void setDebugEventListener(DebugEventListener debugEventListener) {
        this.eventsManager.setDebugEventListener(debugEventListener);
    }

    public final synchronized Object getCheckpointManagerSlot() {
        return this.checkpointManagerSlot;
    }

    public final synchronized void setCheckpointManagerSlot(Object obj) {
        this.checkpointManagerSlot = obj;
    }

    public final Activity getCurrentActivity() {
        return this.currentActivityTracker.getCurrentActivity();
    }

    public final boolean isAnonymous() {
        return this.identityManager.currentUserIsAnonymous();
    }

    public final Store getStore() {
        return this.appConfig.getStore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppLifecycleHandler getLifecycleHandler() {
        return (AppLifecycleHandler) this.lifecycleHandler.getValue();
    }

    public final boolean getAllowSharingPlayStoreAccount() {
        Boolean allowSharingPlayStoreAccount;
        synchronized (this) {
            allowSharingPlayStoreAccount = getState$purchases_defaultsRelease().getAllowSharingPlayStoreAccount();
        }
        return allowSharingPlayStoreAccount != null ? allowSharingPlayStoreAccount.booleanValue() : this.identityManager.currentUserIsAnonymous();
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z) {
        setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), Boolean.valueOf(z), null, null, false, false, 30, null));
    }

    public final String getStorefrontCountryCode() {
        return this.storefrontCountryCode;
    }

    public final Locale getStorefrontLocale() {
        String str = this.storefrontCountryCode;
        if (str != null) {
            return new Locale.Builder().setRegion(str).build();
        }
        return null;
    }

    /* JADX INFO: renamed from: getPreferredUILocaleOverride, reason: from getter */
    public final String get_preferredUILocaleOverride() {
        return this._preferredUILocaleOverride;
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppBackgrounded() {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        synchronized (this) {
            setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, null, true, false, 23, null));
            Unit unit = Unit.INSTANCE;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$onAppBackgrounded$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " App backgrounded";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        DebugEventListener debugEventListener = getDebugEventListener();
        if (debugEventListener != null) {
            debugEventListener.onDebugEventReceived(new DebugEvent(DebugEventName.APP_BACKGROUNDED, null, 2, null));
        }
        this.appConfig.setAppBackgrounded(true);
        if (this.appConfig.getUiPreviewMode()) {
            return;
        }
        synchronizeSubscriberAttributesIfNeeded(Delay.NONE);
        flushEvents(Delay.NONE);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppForegrounded() {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        synchronized (this) {
            booleanRef.element = getState$purchases_defaultsRelease().getFirstTimeInForeground();
            setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, null, false, false, 7, null));
            Unit unit = Unit.INSTANCE;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$onAppForegrounded$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " App foregrounded";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.appConfig.setAppBackgrounded(false);
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.onAppForegrounded.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DiagnosticsSynchronizer diagnosticsSynchronizer;
                LogHandler currentLogHandler8;
                String str2;
                String strInvoke2;
                if (PurchasesOrchestrator.this.getAppConfig().getUiPreviewMode()) {
                    return;
                }
                PurchasesOrchestrator.this.remoteConfigManager.refreshRemoteConfigIfStale(false, PurchasesOrchestrator.this.identityManager.getCurrentAppUserID(), booleanRef.element ? RemoteConfigFetchContext.AppStart : RemoteConfigFetchContext.Foreground);
                if (PurchasesOrchestrator.this.shouldRefreshCustomerInfo(booleanRef.element)) {
                    final LogIntent logIntent2 = LogIntent.DEBUG;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + " CustomerInfo cache is stale, updating from network in foreground.";
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel11 = LogLevel.DEBUG;
                            currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                str2 = "[Purchases] - " + logLevel11.name();
                                strInvoke2 = function02.invoke();
                                currentLogHandler8.mo1541d(str2, strInvoke2);
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 3:
                            LogLevel logLevel12 = LogLevel.WARN;
                            LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                            }
                            break;
                        case 4:
                            LogLevel logLevel13 = LogLevel.INFO;
                            LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                            }
                            break;
                        case 5:
                            LogLevel logLevel14 = LogLevel.DEBUG;
                            currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                str2 = "[Purchases] - " + logLevel14.name();
                                strInvoke2 = function02.invoke();
                                currentLogHandler8.mo1541d(str2, strInvoke2);
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel15 = LogLevel.INFO;
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                currentLogHandler11.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                str2 = "[Purchases] - " + logLevel16.name();
                                strInvoke2 = function02.invoke();
                                currentLogHandler8.mo1541d(str2, strInvoke2);
                            }
                            break;
                        case 9:
                            LogLevel logLevel17 = LogLevel.DEBUG;
                            currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                str2 = "[Purchases] - " + logLevel17.name();
                                strInvoke2 = function02.invoke();
                                currentLogHandler8.mo1541d(str2, strInvoke2);
                            }
                            break;
                        case 10:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler12.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel19 = LogLevel.WARN;
                            LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                currentLogHandler13.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel20 = LogLevel.WARN;
                            LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                currentLogHandler14.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                    }
                    CustomerInfoHelper customerInfoHelper = PurchasesOrchestrator.this.customerInfoHelper;
                    String currentAppUserID = PurchasesOrchestrator.this.identityManager.getCurrentAppUserID();
                    CacheFetchPolicy cacheFetchPolicy = CacheFetchPolicy.FETCH_CURRENT;
                    boolean allowSharingPlayStoreAccount = PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount();
                    final PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    CustomerInfoHelper.retrieveCustomerInfo$default(customerInfoHelper, currentAppUserID, cacheFetchPolicy, false, allowSharingPlayStoreAccount, false, new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.onAppForegrounded.3.2
                        @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                        public void onError(PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                        }

                        @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                        public void onReceived(CustomerInfo customerInfo) {
                            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                            purchasesOrchestrator.blockstoreHelper.storeUserIdIfNeeded(customerInfo);
                        }
                    }, 16, null);
                }
                PurchasesOrchestrator.this.offeringsManager.onAppForeground(PurchasesOrchestrator.this.identityManager.getCurrentAppUserID());
                PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(PurchasesOrchestrator.this.postPendingTransactionsHelper, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), null, 2, null);
                PurchasesOrchestrator.this.synchronizeSubscriberAttributesIfNeeded(Delay.DEFAULT);
                OfflineEntitlementsManager.updateProductEntitlementMappingCacheIfStale$default(PurchasesOrchestrator.this.getOfflineEntitlementsManager(), null, 1, null);
                PurchasesOrchestrator.this.flushEvents(Delay.DEFAULT);
                if (booleanRef.element && AndroidVersionUtilsKt.isAndroidNOrNewer() && (diagnosticsSynchronizer = PurchasesOrchestrator.this.diagnosticsSynchronizer) != null) {
                    diagnosticsSynchronizer.syncDiagnosticsFileIfNeeded();
                }
            }
        });
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.currentActivityTracker.onActivityStarted(activity);
        if (this.appConfig.getShowInAppMessagesAutomatically()) {
            showInAppMessagesIfNeeded(activity, ArraysKt.toList(InAppMessageType.values()));
        }
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.currentActivityTracker.onActivityStopped(activity);
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        flushEvents(Delay.NONE);
    }

    public final void redeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, RedeemWebPurchaseListener listener) {
        Intrinsics.checkNotNullParameter(webPurchaseRedemption, "webPurchaseRedemption");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.webPurchaseRedemptionHelper.handleRedeemWebPurchase(webPurchaseRedemption, listener);
    }

    public final Object resolveCheckpoint(String str, Map<String, ? extends RulesDimensionValue> map, Continuation<? super CheckpointResolution> continuation) {
        track(new CheckpointEvent(str, null, this.dateProvider.getNow(), 2, null));
        return this.checkpointWorkflowResolver.resolve(str, map, continuation);
    }

    public final void getStorefrontCountryCode(final GetStorefrontCallback callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = this.storefrontCountryCode;
        if (str != null) {
            callback.onReceived(str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.billing.getStorefront(new Function1<String, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getStorefrontCountryCode$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String countryCode) {
                    Intrinsics.checkNotNullParameter(countryCode, "countryCode");
                    this.$this_run.storefrontCountryCode = countryCode;
                    callback.onReceived(countryCode);
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getStorefrontCountryCode$2$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    LogUtilsKt.errorLog(error);
                    callback.onError(error);
                }
            });
        }
    }

    public final void getStorefrontLocale(final GetStorefrontLocaleCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getStorefrontCountryCode(new GetStorefrontCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getStorefrontLocale.1
            @Override // com.revenuecat.purchases.interfaces.GetStorefrontCallback
            public void onReceived(String storefrontCountryCode) {
                Intrinsics.checkNotNullParameter(storefrontCountryCode, "storefrontCountryCode");
                GetStorefrontLocaleCallback getStorefrontLocaleCallback = callback;
                Locale localeBuild = new Locale.Builder().setRegion(storefrontCountryCode).build();
                Intrinsics.checkNotNullExpressionValue(localeBuild, "Builder().setRegion(storefrontCountryCode).build()");
                getStorefrontLocaleCallback.onReceived(localeBuild);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStorefrontCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                callback.onError(error);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1] */
    public final void syncAttributesAndOfferingsIfNeeded(final SyncAttributesAndOfferingsCallback callback) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ?? r0 = new ReceiveOfferingsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1
            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onReceived(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                callback.onSuccess(offerings);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                callback.onError(error);
            }
        };
        if (this.lastSyncAttributesAndOfferingsRateLimiter.shouldProceed()) {
            final AtomicReference atomicReference = new AtomicReference();
            final C7101xe2f88452 c7101xe2f88452 = new Function2<PurchasesError, List<? extends SubscriberAttributeError>, Boolean>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$shouldBlockOfferingsFetch$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Boolean invoke(PurchasesError purchasesError, List<? extends SubscriberAttributeError> list) {
                    return invoke2(purchasesError, (List<SubscriberAttributeError>) list);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Boolean invoke2(PurchasesError error, List<SubscriberAttributeError> attributeErrors) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(error, "error");
                    Intrinsics.checkNotNullParameter(attributeErrors, "attributeErrors");
                    if (error.getCode() != PurchasesErrorCode.InvalidSubscriberAttributesError || attributeErrors.isEmpty()) {
                        z = true;
                        break;
                    }
                    List<SubscriberAttributeError> list = attributeErrors;
                    z = false;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        for (SubscriberAttributeError subscriberAttributeError : list) {
                            Integer backendErrorCode = subscriberAttributeError.getBackendErrorCode();
                            int value = BackendErrorCode.BackendInvalidSubscriberAttributes.getValue();
                            if (backendErrorCode == null || backendErrorCode.intValue() != value || !StringsKt.startsWith$default(subscriberAttributeError.getKeyName(), "$", false, 2, (Object) null)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    return Boolean.valueOf(z);
                }
            };
            this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(getAppUserID(), Delay.INSTANCE.jitterOnlyIfInBackground(getState$purchases_defaultsRelease().getAppInBackground()), new Function2<PurchasesError, List<? extends SubscriberAttributeError>, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAttributesAndOfferingsIfNeeded.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, List<? extends SubscriberAttributeError> list) {
                    invoke2(purchasesError, (List<SubscriberAttributeError>) list);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError purchasesError, List<SubscriberAttributeError> attributeErrors) {
                    Intrinsics.checkNotNullParameter(attributeErrors, "attributeErrors");
                    if (purchasesError == null || !c7101xe2f88452.invoke(purchasesError, attributeErrors).booleanValue()) {
                        return;
                    }
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m11m(atomicReference, null, purchasesError);
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAttributesAndOfferingsIfNeeded.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Unit unit;
                    PurchasesError purchasesError = atomicReference.get();
                    if (purchasesError != null) {
                        callback.onError(purchasesError);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        PurchasesOrchestrator purchasesOrchestrator = this;
                        C7100x42dece3e c7100x42dece3e = r0;
                        purchasesOrchestrator.remoteConfigManager.refreshRemoteConfig(purchasesOrchestrator.getState$purchases_defaultsRelease().getAppInBackground(), purchasesOrchestrator.getAppUserID(), RemoteConfigFetchContext.Read);
                        purchasesOrchestrator.getOfferings(c7100x42dece3e, true);
                    }
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(SyncAttributesAndOfferingsStrings.RATE_LIMIT_REACHED, Arrays.copyOf(new Object[]{Integer.valueOf(this.lastSyncAttributesAndOfferingsRateLimiter.getMaxCallsInPeriod()), Long.valueOf(Duration.m15870getInWholeSecondsimpl(this.lastSyncAttributesAndOfferingsRateLimiter.getPeriodSeconds()))}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        getOfferings$default(this, (ReceiveOfferingsCallback) r0, false, 2, null);
    }

    public static /* synthetic */ void syncPurchases$default(PurchasesOrchestrator purchasesOrchestrator, SyncPurchasesCallback syncPurchasesCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchasesOrchestrator.syncPurchases(syncPurchasesCallback);
    }

    public final void syncPurchases(final SyncPurchasesCallback listener) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        if (this.appConfig.getApiKeyValidationResult() != APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            this.syncPurchasesHelper.syncPurchases(getAllowSharingPlayStoreAccount(), getState$purchases_defaultsRelease().getAppInBackground(), new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncPurchases.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                    invoke2(customerInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    SyncPurchasesCallback syncPurchasesCallback = listener;
                    if (syncPurchasesCallback != null) {
                        syncPurchasesCallback.onSuccess(it);
                    }
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncPurchases.4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    SyncPurchasesCallback syncPurchasesCallback = listener;
                    if (syncPurchasesCallback != null) {
                        syncPurchasesCallback.onError(it);
                    }
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncPurchases$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Syncing purchases not available in test store. Returning current CustomerInfo.";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        getCustomerInfo(new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncPurchases.2
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                SyncPurchasesCallback syncPurchasesCallback = listener;
                if (syncPurchasesCallback != null) {
                    syncPurchasesCallback.onSuccess(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                SyncPurchasesCallback syncPurchasesCallback = listener;
                if (syncPurchasesCallback != null) {
                    syncPurchasesCallback.onError(error);
                }
            }
        });
    }

    public final void syncAmazonPurchase(String productID, final String receiptID, final String amazonUserID, final String isoCurrencyCode, final Double price, final Long purchaseTime) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(PurchaseStrings.SYNCING_PURCHASE_STORE_USER_ID, Arrays.copyOf(new Object[]{receiptID, amazonUserID}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        Set<String> previouslySentHashedTokens$purchases_defaultsRelease = this.deviceCache.getPreviouslySentHashedTokens$purchases_defaultsRelease();
        if (!previouslySentHashedTokens$purchases_defaultsRelease.contains(UtilsKt.sha1(receiptID))) {
            previouslySentHashedTokens$purchases_defaultsRelease = null;
        }
        if (previouslySentHashedTokens$purchases_defaultsRelease == null) {
            final String currentAppUserID = this.identityManager.getCurrentAppUserID();
            this.billing.normalizePurchaseData(productID, receiptID, amazonUserID, new Function1<String, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAmazonPurchase.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String normalizedProductID) {
                    Intrinsics.checkNotNullParameter(normalizedProductID, "normalizedProductID");
                    List listListOf = CollectionsKt.listOf(normalizedProductID);
                    Double d = price;
                    Double d2 = (d == null || d.doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) ? null : d;
                    String str2 = isoCurrencyCode;
                    ReceiptInfo receiptInfo = new ReceiptInfo(listListOf, purchaseTime, null, d2, null, (str2 == null || StringsKt.isBlank(str2)) ? null : str2, null, null, null, null, false, amazonUserID, null, PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, null);
                    PostReceiptHelper postReceiptHelper = this.postReceiptHelper;
                    String str3 = receiptID;
                    boolean allowSharingPlayStoreAccount = this.getAllowSharingPlayStoreAccount();
                    String str4 = currentAppUserID;
                    PostReceiptInitiationSource postReceiptInitiationSource = PostReceiptInitiationSource.RESTORE;
                    final String str5 = receiptID;
                    final String str6 = amazonUserID;
                    Function1<CustomerInfo, Unit> function1 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAmazonPurchase.4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                            invoke2(customerInfo);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            final LogIntent logIntent2 = LogIntent.PURCHASE;
                            final String str7 = str5;
                            final String str8 = str6;
                            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                                    String str9 = String.format(PurchaseStrings.PURCHASE_SYNCED_USER_ID, Arrays.copyOf(new Object[]{str7, str8}, 2));
                                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                    return sbAppend.append(str9).toString();
                                }
                            };
                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                case 1:
                                    LogLevel logLevel11 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                        currentLogHandler8.mo1541d("[Purchases] - " + logLevel11.name(), function02.invoke());
                                    }
                                    break;
                                case 2:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                                    break;
                                case 3:
                                    LogLevel logLevel12 = LogLevel.WARN;
                                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                        currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                                    }
                                    break;
                                case 4:
                                    LogLevel logLevel13 = LogLevel.INFO;
                                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                        currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                                    }
                                    break;
                                case 5:
                                    LogLevel logLevel14 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                        currentLogHandler11.mo1541d("[Purchases] - " + logLevel14.name(), function02.invoke());
                                    }
                                    break;
                                case 6:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                                    break;
                                case 7:
                                    LogLevel logLevel15 = LogLevel.INFO;
                                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                        currentLogHandler12.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                                    }
                                    break;
                                case 8:
                                    LogLevel logLevel16 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                        currentLogHandler13.mo1541d("[Purchases] - " + logLevel16.name(), function02.invoke());
                                    }
                                    break;
                                case 9:
                                    LogLevel logLevel17 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                        currentLogHandler14.mo1541d("[Purchases] - " + logLevel17.name(), function02.invoke());
                                    }
                                    break;
                                case 10:
                                    LogLevel logLevel18 = LogLevel.WARN;
                                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                        currentLogHandler15.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                                    }
                                    break;
                                case 11:
                                    LogLevel logLevel19 = LogLevel.WARN;
                                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                        currentLogHandler16.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                                    }
                                    break;
                                case 12:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                                    break;
                                case 13:
                                    LogLevel logLevel20 = LogLevel.WARN;
                                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                        currentLogHandler17.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                                    }
                                    break;
                                case 14:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                                    break;
                            }
                        }
                    };
                    final String str7 = receiptID;
                    final String str8 = amazonUserID;
                    postReceiptHelper.postTokenWithoutConsuming(str3, receiptInfo, allowSharingPlayStoreAccount, str4, postReceiptInitiationSource, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAmazonPurchase.4.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                            invoke2(purchasesError);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            final LogIntent logIntent2 = LogIntent.RC_ERROR;
                            final String str9 = str7;
                            final String str10 = str8;
                            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                                    String str11 = String.format(PurchaseStrings.SYNCING_PURCHASE_ERROR_DETAILS_USER_ID, Arrays.copyOf(new Object[]{str9, str10, error}, 3));
                                    Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                                    return sbAppend.append(str11).toString();
                                }
                            };
                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                case 1:
                                    LogLevel logLevel11 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                        currentLogHandler8.mo1541d("[Purchases] - " + logLevel11.name(), function02.invoke());
                                    }
                                    break;
                                case 2:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                                    break;
                                case 3:
                                    LogLevel logLevel12 = LogLevel.WARN;
                                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                        currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                                    }
                                    break;
                                case 4:
                                    LogLevel logLevel13 = LogLevel.INFO;
                                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                        currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                                    }
                                    break;
                                case 5:
                                    LogLevel logLevel14 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                        currentLogHandler11.mo1541d("[Purchases] - " + logLevel14.name(), function02.invoke());
                                    }
                                    break;
                                case 6:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                                    break;
                                case 7:
                                    LogLevel logLevel15 = LogLevel.INFO;
                                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                        currentLogHandler12.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                                    }
                                    break;
                                case 8:
                                    LogLevel logLevel16 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                        currentLogHandler13.mo1541d("[Purchases] - " + logLevel16.name(), function02.invoke());
                                    }
                                    break;
                                case 9:
                                    LogLevel logLevel17 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                        currentLogHandler14.mo1541d("[Purchases] - " + logLevel17.name(), function02.invoke());
                                    }
                                    break;
                                case 10:
                                    LogLevel logLevel18 = LogLevel.WARN;
                                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                        currentLogHandler15.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                                    }
                                    break;
                                case 11:
                                    LogLevel logLevel19 = LogLevel.WARN;
                                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                        currentLogHandler16.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                                    }
                                    break;
                                case 12:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                                    break;
                                case 13:
                                    LogLevel logLevel20 = LogLevel.WARN;
                                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                        currentLogHandler17.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                                    }
                                    break;
                                case 14:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                                    break;
                            }
                        }
                    }, (128 & 128) != 0 ? null : null);
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAmazonPurchase.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    final LogIntent logIntent2 = LogIntent.RC_ERROR;
                    final String str2 = receiptID;
                    final String str3 = amazonUserID;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                            String str4 = String.format(PurchaseStrings.SYNCING_PURCHASE_ERROR_DETAILS_USER_ID, Arrays.copyOf(new Object[]{str2, str3, error}, 3));
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                            return sbAppend.append(str4).toString();
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel11 = LogLevel.DEBUG;
                            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                currentLogHandler8.mo1541d("[Purchases] - " + logLevel11.name(), function02.invoke());
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 3:
                            LogLevel logLevel12 = LogLevel.WARN;
                            LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                            }
                            break;
                        case 4:
                            LogLevel logLevel13 = LogLevel.INFO;
                            LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                            }
                            break;
                        case 5:
                            LogLevel logLevel14 = LogLevel.DEBUG;
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                currentLogHandler11.mo1541d("[Purchases] - " + logLevel14.name(), function02.invoke());
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel15 = LogLevel.INFO;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                currentLogHandler12.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                currentLogHandler13.mo1541d("[Purchases] - " + logLevel16.name(), function02.invoke());
                            }
                            break;
                        case 9:
                            LogLevel logLevel17 = LogLevel.DEBUG;
                            LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                currentLogHandler14.mo1541d("[Purchases] - " + logLevel17.name(), function02.invoke());
                            }
                            break;
                        case 10:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler15.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel19 = LogLevel.WARN;
                            LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                currentLogHandler16.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel20 = LogLevel.WARN;
                            LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                currentLogHandler17.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                    }
                }
            });
            return;
        }
        final LogIntent logIntent2 = LogIntent.DEBUG;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$lambda$14$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(PurchaseStrings.SYNCING_PURCHASE_SKIPPING, Arrays.copyOf(new Object[]{receiptID, amazonUserID}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
            case 1:
                LogLevel logLevel11 = LogLevel.DEBUG;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    currentLogHandler8.mo1541d("[Purchases] - " + logLevel11.name(), function02.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 3:
                LogLevel logLevel12 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                }
                break;
            case 4:
                LogLevel logLevel13 = LogLevel.INFO;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                }
                break;
            case 5:
                LogLevel logLevel14 = LogLevel.DEBUG;
                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    currentLogHandler11.mo1541d("[Purchases] - " + logLevel14.name(), function02.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 7:
                LogLevel logLevel15 = LogLevel.INFO;
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler12.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                }
                break;
            case 8:
                LogLevel logLevel16 = LogLevel.DEBUG;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    currentLogHandler13.mo1541d("[Purchases] - " + logLevel16.name(), function02.invoke());
                }
                break;
            case 9:
                LogLevel logLevel17 = LogLevel.DEBUG;
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    currentLogHandler14.mo1541d("[Purchases] - " + logLevel17.name(), function02.invoke());
                }
                break;
            case 10:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler15.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                }
                break;
            case 11:
                LogLevel logLevel19 = LogLevel.WARN;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                    currentLogHandler16.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 13:
                LogLevel logLevel20 = LogLevel.WARN;
                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                    currentLogHandler17.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
        }
    }

    public final void getAmazonLWAConsentStatus(final GetAmazonLWAConsentStatusCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.billing.getAmazonLWAConsentStatus(new Function1<AmazonLWAConsentStatus, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getAmazonLWAConsentStatus.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AmazonLWAConsentStatus amazonLWAConsentStatus) {
                invoke2(amazonLWAConsentStatus);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AmazonLWAConsentStatus it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onSuccess(it);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getAmazonLWAConsentStatus.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onError(it);
            }
        });
    }

    public final boolean overridePreferredUILocale(String localeString) {
        if (!Intrinsics.areEqual(this._preferredUILocaleOverride, localeString)) {
            synchronized (this) {
                this._preferredUILocaleOverride = localeString;
                this.localeProvider.setPreferredLocaleOverride(localeString);
                Unit unit = Unit.INSTANCE;
            }
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Locale changed, attempting to fetch fresh offerings");
            }
            return clearInMemoryCacheAndFetchOfferingsWithRateLimit(new Function2<Offerings, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.overridePreferredUILocale.4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Offerings offerings, PurchasesError purchasesError) {
                    invoke2(offerings, purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Offerings offerings, PurchasesError purchasesError) {
                    if (offerings != null) {
                        LogLevel logLevel2 = LogLevel.DEBUG;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.mo1541d("[Purchases] - " + logLevel2.name(), "Fresh offerings fetch completed successfully");
                            return;
                        }
                        return;
                    }
                    LogLevel logLevel3 = LogLevel.DEBUG;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.mo1541d("[Purchases] - " + logLevel3.name(), "Fresh offerings fetch failed: " + (purchasesError != null ? purchasesError.getMessage() : null));
                    }
                }
            });
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) > 0) {
            return false;
        }
        currentLogHandler2.mo1541d("[Purchases] - " + logLevel2.name(), "Locale unchanged, no fresh fetch needed");
        return false;
    }

    public static /* synthetic */ void getOfferings$default(PurchasesOrchestrator purchasesOrchestrator, ReceiveOfferingsCallback receiveOfferingsCallback, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        purchasesOrchestrator.getOfferings(receiveOfferingsCallback, z);
    }

    public final void getOfferings(final ReceiveOfferingsCallback listener, boolean fetchCurrent) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.offeringsManager.getOfferings(this.identityManager.getCurrentAppUserID(), getState$purchases_defaultsRelease().getAppInBackground(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getOfferings.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                listener.onError(it);
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getOfferings.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offerings offerings) {
                invoke2(offerings);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Offerings it) {
                Intrinsics.checkNotNullParameter(it, "it");
                listener.onReceived(it);
            }
        }, fetchCurrent);
    }

    public final Object getWorkflow(String str, Continuation<? super PublishedWorkflow> continuation) throws PurchasesException {
        if (this.appConfig.getUiPreviewMode()) {
            throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ConfigurationError, "Workflows cannot be fetched in UI preview mode."));
        }
        if (this.remoteConfigManager.isDisabled()) {
            throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ConfigurationError, "Workflows are not enabled."));
        }
        return this.workflowManager.getWorkflow(str, continuation);
    }

    public final Object resolveWorkflow(String str, Continuation<? super WorkflowResolution> continuation) {
        return this.workflowManager.resolveWorkflow(str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getUiConfig(Continuation<? super UiConfig> continuation) throws PurchasesException {
        C70681 c70681;
        String str;
        if (continuation instanceof C70681) {
            c70681 = (C70681) continuation;
            if ((c70681.label & Integer.MIN_VALUE) != 0) {
                c70681.label -= Integer.MIN_VALUE;
            } else {
                c70681 = new C70681(continuation);
            }
        }
        Object uiConfig = c70681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c70681.label;
        if (i == 0) {
            ResultKt.throwOnFailure(uiConfig);
            if (this.appConfig.getUiPreviewMode() || this.remoteConfigManager.isDisabled()) {
                if (this.appConfig.getUiPreviewMode()) {
                    str = "UI config cannot be fetched in UI preview mode.";
                } else {
                    str = "UI config is not enabled.";
                }
                throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ConfigurationError, str));
            }
            UiConfigProvider uiConfigProvider = this.uiConfigProvider;
            c70681.label = 1;
            uiConfig = uiConfigProvider.getUiConfig(c70681);
            if (uiConfig == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(uiConfig);
        }
        UiConfig uiConfig2 = (UiConfig) uiConfig;
        if (uiConfig2 != null) {
            return uiConfig2;
        }
        throw new PurchasesException(new PurchasesError(PurchasesErrorCode.UnknownError, "UI config is unavailable."));
    }

    public static /* synthetic */ void getProducts$default(PurchasesOrchestrator purchasesOrchestrator, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            productType = null;
        }
        purchasesOrchestrator.getProducts(list, productType, getStoreProductsCallback);
    }

    public final void getProducts(List<String> productIds, ProductType type, final GetStoreProductsCallback callback) {
        Set<? extends ProductType> of;
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (type == null || (of = SetsKt.setOf(type)) == null) {
            of = SetsKt.setOf((Object[]) new ProductType[]{ProductType.SUBS, ProductType.INAPP});
        }
        List<String> list = productIds;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt.contains$default((CharSequence) obj, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                String strSubstringBefore$default = StringsKt.substringBefore$default(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (String) null, 2, (Object) null);
                String strSubstringAfter$default = StringsKt.substringAfter$default(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (String) null, 2, (Object) null);
                if (!set.contains(strSubstringBefore$default)) {
                    Object obj2 = linkedHashMap.get(strSubstringBefore$default);
                    if (obj2 == null) {
                        obj2 = (Set) new LinkedHashSet();
                        linkedHashMap.put(strSubstringBefore$default, obj2);
                    }
                    ((Set) obj2).add(strSubstringAfter$default);
                }
                str = strSubstringBefore$default;
            }
            arrayList2.add(str);
        }
        getProductsOfTypes(CollectionsKt.toSet(arrayList2), of, new GetStoreProductsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getProducts.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onReceived(List<? extends StoreProduct> storeProducts) {
                boolean zContains;
                Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                if (!linkedHashMap.isEmpty()) {
                    Map<String, Set<String>> map = linkedHashMap;
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj3 : storeProducts) {
                        StoreProduct storeProduct = (StoreProduct) obj3;
                        Set<String> set2 = map.get(storeProduct.getPurchasingData().getProductId());
                        if (set2 != null) {
                            Set<String> set3 = set2;
                            GoogleStoreProduct googleStoreProduct = storeProduct instanceof GoogleStoreProduct ? (GoogleStoreProduct) storeProduct : null;
                            zContains = CollectionsKt.contains(set3, googleStoreProduct != null ? googleStoreProduct.getBasePlanId() : null);
                        } else {
                            zContains = true;
                        }
                        if (zContains) {
                            arrayList3.add(obj3);
                        }
                    }
                    storeProducts = arrayList3;
                }
                callback.onReceived(storeProducts);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                callback.onError(error);
            }
        });
    }

    public final void purchase(PurchaseParams purchaseParams, final PurchaseCallback callback) throws PurchasesException {
        PurchaseCallback purchaseCallback;
        Unit unit;
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Result<Unit, PurchasesError> resultValidate = this.purchaseParamsValidator.validate(purchaseParams);
        if (resultValidate instanceof Result.Error) {
            dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.purchase.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    callback.onError((PurchasesError) ((Result.Error) resultValidate).getValue(), false);
                }
            });
            return;
        }
        String oldProductId = purchaseParams.getOldProductId();
        if (oldProductId != null) {
            purchaseCallback = callback;
            startProductChange(purchaseParams.getActivity(), purchaseParams.getPurchasingData(), purchaseParams.getPresentedOfferingContext(), oldProductId, purchaseParams.getReplacementMode(), purchaseParams.getIsPersonalizedPrice(), purchaseCallback);
            unit = Unit.INSTANCE;
        } else {
            purchaseCallback = callback;
            unit = null;
        }
        if (unit == null) {
            startPurchase(purchaseParams.getActivity(), purchaseParams.getPurchasingData(), purchaseParams.getPresentedOfferingContext(), purchaseParams.getIsPersonalizedPrice(), purchaseCallback);
        }
    }

    public final void restorePurchases(final ReceiveCustomerInfoCallback callback) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(callback, "callback");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Restoring purchases";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        if (!getAllowSharingPlayStoreAccount()) {
            final LogIntent logIntent2 = LogIntent.WARNING;
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$$inlined$log$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + " allowSharingPlayStoreAccount is set to false and restorePurchases has been called. This will 'alias' any app user id's sharing the same receipt. Are you sure you want to do this? More info here: https://errors.rev.cat/allowsSharingPlayStoreAccount";
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel11 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.mo1541d("[Purchases] - " + logLevel11.name(), function02.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel13 = LogLevel.INFO;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel14 = LogLevel.DEBUG;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.mo1541d("[Purchases] - " + logLevel14.name(), function02.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.mo1541d("[Purchases] - " + logLevel16.name(), function02.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel17 = LogLevel.DEBUG;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.mo1541d("[Purchases] - " + logLevel17.name(), function02.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel19 = LogLevel.WARN;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler16.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler17.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
            }
        }
        if (this.appConfig.getApiKeyValidationResult() != APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            final Date now = this.dateProvider.getNow();
            DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
            if (diagnosticsTracker != null) {
                diagnosticsTracker.trackRestorePurchasesStarted();
                Unit unit = Unit.INSTANCE;
            }
            final String currentAppUserID = this.identityManager.getCurrentAppUserID();
            if (this.diagnosticsTrackerIfEnabled != null) {
                callback = new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$callbackWithTracking$1
                    @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                    public void onReceived(CustomerInfo customerInfo) {
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        this.this$0.diagnosticsTrackerIfEnabled.m13728trackRestorePurchasesResultSxA4cEA(null, null, DurationExtensionsKt.between(Duration.INSTANCE, now, this.this$0.dateProvider.getNow()));
                        callback.onReceived(customerInfo);
                    }

                    @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                    public void onError(PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        this.this$0.diagnosticsTrackerIfEnabled.m13728trackRestorePurchasesResultSxA4cEA(Integer.valueOf(error.getCode().getCode()), error.getMessage(), DurationExtensionsKt.between(Duration.INSTANCE, now, this.this$0.dateProvider.getNow()));
                        callback.onError(error);
                    }
                };
            }
            this.blockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.restorePurchases.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BillingAbstract billingAbstract = PurchasesOrchestrator.this.billing;
                    String str2 = currentAppUserID;
                    final PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = callback;
                    final String str3 = currentAppUserID;
                    Function1<List<? extends StoreTransaction>, Unit> function1 = new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.restorePurchases.4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreTransaction> list) {
                            invoke2((List<StoreTransaction>) list);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(List<StoreTransaction> allPurchases) {
                            LogHandler currentLogHandler18;
                            String str4;
                            String strInvoke2;
                            Intrinsics.checkNotNullParameter(allPurchases, "allPurchases");
                            if (!allPurchases.isEmpty()) {
                                final List<StoreTransaction> listSortedWith = CollectionsKt.sortedWith(allPurchases, new Comparator() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$sortedBy$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t, T t2) {
                                        return ComparisonsKt.compareValues(Long.valueOf(((StoreTransaction) t).getPurchaseTime()), Long.valueOf(((StoreTransaction) t2).getPurchaseTime()));
                                    }
                                });
                                final PurchasesOrchestrator purchasesOrchestrator2 = purchasesOrchestrator;
                                String str5 = str3;
                                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = receiveCustomerInfoCallback;
                                for (final StoreTransaction storeTransaction : listSortedWith) {
                                    purchasesOrchestrator2.postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, null, null, true, str5, PostReceiptInitiationSource.RESTORE, false, new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction2, CustomerInfo customerInfo) {
                                            invoke2(storeTransaction2, customerInfo);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(StoreTransaction storeTransaction2, final CustomerInfo info) {
                                            LogHandler currentLogHandler19;
                                            String str6;
                                            String strInvoke3;
                                            Intrinsics.checkNotNullParameter(storeTransaction2, "<anonymous parameter 0>");
                                            Intrinsics.checkNotNullParameter(info, "info");
                                            final LogIntent logIntent3 = LogIntent.DEBUG;
                                            final StoreTransaction storeTransaction3 = storeTransaction;
                                            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$1$invoke$$inlined$log$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final String invoke() {
                                                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                                                    String str7 = String.format(RestoreStrings.PURCHASE_RESTORED, Arrays.copyOf(new Object[]{storeTransaction3}, 1));
                                                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                                    return sbAppend.append(str7).toString();
                                                }
                                            };
                                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                                                case 1:
                                                    LogLevel logLevel21 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                                                        str6 = "[Purchases] - " + logLevel21.name();
                                                        strInvoke3 = function03.invoke();
                                                        currentLogHandler19.mo1541d(str6, strInvoke3);
                                                    }
                                                    break;
                                                case 2:
                                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                                    break;
                                                case 3:
                                                    LogLevel logLevel22 = LogLevel.WARN;
                                                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                                                        currentLogHandler20.mo1545w("[Purchases] - " + logLevel22.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 4:
                                                    LogLevel logLevel23 = LogLevel.INFO;
                                                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                                                        currentLogHandler21.mo1543i("[Purchases] - " + logLevel23.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 5:
                                                    LogLevel logLevel24 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                                                        str6 = "[Purchases] - " + logLevel24.name();
                                                        strInvoke3 = function03.invoke();
                                                        currentLogHandler19.mo1541d(str6, strInvoke3);
                                                    }
                                                    break;
                                                case 6:
                                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                                    break;
                                                case 7:
                                                    LogLevel logLevel25 = LogLevel.INFO;
                                                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                                                        currentLogHandler22.mo1543i("[Purchases] - " + logLevel25.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 8:
                                                    LogLevel logLevel26 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                                                        str6 = "[Purchases] - " + logLevel26.name();
                                                        strInvoke3 = function03.invoke();
                                                        currentLogHandler19.mo1541d(str6, strInvoke3);
                                                    }
                                                    break;
                                                case 9:
                                                    LogLevel logLevel27 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                                                        str6 = "[Purchases] - " + logLevel27.name();
                                                        strInvoke3 = function03.invoke();
                                                        currentLogHandler19.mo1541d(str6, strInvoke3);
                                                    }
                                                    break;
                                                case 10:
                                                    LogLevel logLevel28 = LogLevel.WARN;
                                                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                                                        currentLogHandler23.mo1545w("[Purchases] - " + logLevel28.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 11:
                                                    LogLevel logLevel29 = LogLevel.WARN;
                                                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                                                        currentLogHandler24.mo1545w("[Purchases] - " + logLevel29.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 12:
                                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                                    break;
                                                case 13:
                                                    LogLevel logLevel30 = LogLevel.WARN;
                                                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                                                        currentLogHandler25.mo1545w("[Purchases] - " + logLevel30.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 14:
                                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                                    break;
                                            }
                                            if (Intrinsics.areEqual(CollectionsKt.last((List) listSortedWith), storeTransaction)) {
                                                PurchasesOrchestrator purchasesOrchestrator3 = purchasesOrchestrator2;
                                                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = receiveCustomerInfoCallback2;
                                                purchasesOrchestrator3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                        invoke2();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2() {
                                                        receiveCustomerInfoCallback3.onReceived(info);
                                                    }
                                                });
                                            }
                                        }
                                    }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction2, PurchasesError purchasesError) {
                                            invoke2(storeTransaction2, purchasesError);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(StoreTransaction storeTransaction2, final PurchasesError error) {
                                            LogHandler currentLogHandler19;
                                            String str6;
                                            String strInvoke3;
                                            Intrinsics.checkNotNullParameter(storeTransaction2, "<anonymous parameter 0>");
                                            Intrinsics.checkNotNullParameter(error, "error");
                                            final LogIntent logIntent3 = LogIntent.RC_ERROR;
                                            final StoreTransaction storeTransaction3 = storeTransaction;
                                            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$2$invoke$$inlined$log$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final String invoke() {
                                                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                                                    String str7 = String.format(RestoreStrings.RESTORING_PURCHASE_ERROR, Arrays.copyOf(new Object[]{storeTransaction3, error}, 2));
                                                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                                    return sbAppend.append(str7).toString();
                                                }
                                            };
                                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                                                case 1:
                                                    LogLevel logLevel21 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                                                        str6 = "[Purchases] - " + logLevel21.name();
                                                        strInvoke3 = function03.invoke();
                                                        currentLogHandler19.mo1541d(str6, strInvoke3);
                                                    }
                                                    break;
                                                case 2:
                                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                                    break;
                                                case 3:
                                                    LogLevel logLevel22 = LogLevel.WARN;
                                                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                                                        currentLogHandler20.mo1545w("[Purchases] - " + logLevel22.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 4:
                                                    LogLevel logLevel23 = LogLevel.INFO;
                                                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                                                        currentLogHandler21.mo1543i("[Purchases] - " + logLevel23.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 5:
                                                    LogLevel logLevel24 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                                                        str6 = "[Purchases] - " + logLevel24.name();
                                                        strInvoke3 = function03.invoke();
                                                        currentLogHandler19.mo1541d(str6, strInvoke3);
                                                    }
                                                    break;
                                                case 6:
                                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                                    break;
                                                case 7:
                                                    LogLevel logLevel25 = LogLevel.INFO;
                                                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                                                        currentLogHandler22.mo1543i("[Purchases] - " + logLevel25.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 8:
                                                    LogLevel logLevel26 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                                                        str6 = "[Purchases] - " + logLevel26.name();
                                                        strInvoke3 = function03.invoke();
                                                        currentLogHandler19.mo1541d(str6, strInvoke3);
                                                    }
                                                    break;
                                                case 9:
                                                    LogLevel logLevel27 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                                                        str6 = "[Purchases] - " + logLevel27.name();
                                                        strInvoke3 = function03.invoke();
                                                        currentLogHandler19.mo1541d(str6, strInvoke3);
                                                    }
                                                    break;
                                                case 10:
                                                    LogLevel logLevel28 = LogLevel.WARN;
                                                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                                                        currentLogHandler23.mo1545w("[Purchases] - " + logLevel28.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 11:
                                                    LogLevel logLevel29 = LogLevel.WARN;
                                                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                                                        currentLogHandler24.mo1545w("[Purchases] - " + logLevel29.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 12:
                                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                                    break;
                                                case 13:
                                                    LogLevel logLevel30 = LogLevel.WARN;
                                                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                                                        currentLogHandler25.mo1545w("[Purchases] - " + logLevel30.name(), function03.invoke());
                                                    }
                                                    break;
                                                case 14:
                                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                                    break;
                                            }
                                            if (Intrinsics.areEqual(CollectionsKt.last((List) listSortedWith), storeTransaction)) {
                                                PurchasesOrchestrator purchasesOrchestrator3 = purchasesOrchestrator2;
                                                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = receiveCustomerInfoCallback2;
                                                purchasesOrchestrator3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                        invoke2();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2() {
                                                        receiveCustomerInfoCallback3.onError(error);
                                                    }
                                                });
                                            }
                                        }
                                    });
                                }
                                return;
                            }
                            final LogIntent logIntent3 = LogIntent.DEBUG;
                            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null) + " No purchases found to restore. This will happen if the user does not have any active subscriptions or unconsumed one-time products.Please make sure you're using the correct Store account (Google/Amazon) and that you have configured your one-time products correctly as either consumables (that can be purchased multiple times) or non-consumables (that can only be purchased one by each user) in the RevenueCat dashboard. This will return the current CustomerInfo.";
                                }
                            };
                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                                case 1:
                                    LogLevel logLevel21 = LogLevel.DEBUG;
                                    currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                                        str4 = "[Purchases] - " + logLevel21.name();
                                        strInvoke2 = function03.invoke();
                                        currentLogHandler18.mo1541d(str4, strInvoke2);
                                    }
                                    break;
                                case 2:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                    break;
                                case 3:
                                    LogLevel logLevel22 = LogLevel.WARN;
                                    LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                                        currentLogHandler19.mo1545w("[Purchases] - " + logLevel22.name(), function03.invoke());
                                    }
                                    break;
                                case 4:
                                    LogLevel logLevel23 = LogLevel.INFO;
                                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                                        currentLogHandler20.mo1543i("[Purchases] - " + logLevel23.name(), function03.invoke());
                                    }
                                    break;
                                case 5:
                                    LogLevel logLevel24 = LogLevel.DEBUG;
                                    currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                                        str4 = "[Purchases] - " + logLevel24.name();
                                        strInvoke2 = function03.invoke();
                                        currentLogHandler18.mo1541d(str4, strInvoke2);
                                    }
                                    break;
                                case 6:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                    break;
                                case 7:
                                    LogLevel logLevel25 = LogLevel.INFO;
                                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                                        currentLogHandler21.mo1543i("[Purchases] - " + logLevel25.name(), function03.invoke());
                                    }
                                    break;
                                case 8:
                                    LogLevel logLevel26 = LogLevel.DEBUG;
                                    currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                                        str4 = "[Purchases] - " + logLevel26.name();
                                        strInvoke2 = function03.invoke();
                                        currentLogHandler18.mo1541d(str4, strInvoke2);
                                    }
                                    break;
                                case 9:
                                    LogLevel logLevel27 = LogLevel.DEBUG;
                                    currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                                        str4 = "[Purchases] - " + logLevel27.name();
                                        strInvoke2 = function03.invoke();
                                        currentLogHandler18.mo1541d(str4, strInvoke2);
                                    }
                                    break;
                                case 10:
                                    LogLevel logLevel28 = LogLevel.WARN;
                                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                                        currentLogHandler22.mo1545w("[Purchases] - " + logLevel28.name(), function03.invoke());
                                    }
                                    break;
                                case 11:
                                    LogLevel logLevel29 = LogLevel.WARN;
                                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                                        currentLogHandler23.mo1545w("[Purchases] - " + logLevel29.name(), function03.invoke());
                                    }
                                    break;
                                case 12:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                    break;
                                case 13:
                                    LogLevel logLevel30 = LogLevel.WARN;
                                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                                        currentLogHandler24.mo1545w("[Purchases] - " + logLevel30.name(), function03.invoke());
                                    }
                                    break;
                                case 14:
                                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                                    break;
                            }
                            purchasesOrchestrator.getCustomerInfo(receiveCustomerInfoCallback);
                        }
                    };
                    final PurchasesOrchestrator purchasesOrchestrator2 = PurchasesOrchestrator.this;
                    final ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = callback;
                    billingAbstract.queryAllPurchases(str2, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.restorePurchases.4.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                            invoke2(purchasesError);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            PurchasesOrchestrator purchasesOrchestrator3 = purchasesOrchestrator2;
                            final ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = receiveCustomerInfoCallback2;
                            purchasesOrchestrator3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.restorePurchases.4.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    receiveCustomerInfoCallback3.onError(error);
                                }
                            });
                        }
                    });
                }
            });
            return;
        }
        final LogIntent logIntent3 = LogIntent.DEBUG;
        Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$$inlined$log$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Restoring purchases not available in test store. Returning current CustomerInfo.";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
            case 1:
                LogLevel logLevel21 = LogLevel.DEBUG;
                LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                    currentLogHandler18.mo1541d("[Purchases] - " + logLevel21.name(), function03.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                break;
            case 3:
                LogLevel logLevel22 = LogLevel.WARN;
                LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                    currentLogHandler19.mo1545w("[Purchases] - " + logLevel22.name(), function03.invoke());
                }
                break;
            case 4:
                LogLevel logLevel23 = LogLevel.INFO;
                LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                    currentLogHandler20.mo1543i("[Purchases] - " + logLevel23.name(), function03.invoke());
                }
                break;
            case 5:
                LogLevel logLevel24 = LogLevel.DEBUG;
                LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                    currentLogHandler21.mo1541d("[Purchases] - " + logLevel24.name(), function03.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                break;
            case 7:
                LogLevel logLevel25 = LogLevel.INFO;
                LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                    currentLogHandler22.mo1543i("[Purchases] - " + logLevel25.name(), function03.invoke());
                }
                break;
            case 8:
                LogLevel logLevel26 = LogLevel.DEBUG;
                LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                    currentLogHandler23.mo1541d("[Purchases] - " + logLevel26.name(), function03.invoke());
                }
                break;
            case 9:
                LogLevel logLevel27 = LogLevel.DEBUG;
                LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                    currentLogHandler24.mo1541d("[Purchases] - " + logLevel27.name(), function03.invoke());
                }
                break;
            case 10:
                LogLevel logLevel28 = LogLevel.WARN;
                LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                    currentLogHandler25.mo1545w("[Purchases] - " + logLevel28.name(), function03.invoke());
                }
                break;
            case 11:
                LogLevel logLevel29 = LogLevel.WARN;
                LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                    currentLogHandler26.mo1545w("[Purchases] - " + logLevel29.name(), function03.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                break;
            case 13:
                LogLevel logLevel30 = LogLevel.WARN;
                LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                    currentLogHandler27.mo1545w("[Purchases] - " + logLevel30.name(), function03.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function03.invoke(), null);
                break;
        }
        getCustomerInfo(callback);
    }

    public static /* synthetic */ void logIn$default(PurchasesOrchestrator purchasesOrchestrator, String str, LogInCallback logInCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            logInCallback = null;
        }
        purchasesOrchestrator.logIn(str, logInCallback);
    }

    public final void logIn(final String newAppUserID, final LogInCallback callback) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        Unit unit = null;
        if (Intrinsics.areEqual(currentAppUserID, newAppUserID)) {
            currentAppUserID = null;
        }
        if (currentAppUserID != null) {
            this.blockstoreHelper.clearUserIdBackupIfNeeded(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IdentityManager identityManager = this.this$0.identityManager;
                    String str = newAppUserID;
                    final PurchasesOrchestrator purchasesOrchestrator = this.this$0;
                    final String str2 = newAppUserID;
                    final LogInCallback logInCallback = callback;
                    Function2<CustomerInfo, Boolean, Unit> function2 = new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo, Boolean bool) {
                            invoke(customerInfo, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final CustomerInfo customerInfo, final boolean z) {
                            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                            PurchasesOrchestrator purchasesOrchestrator2 = purchasesOrchestrator;
                            final LogInCallback logInCallback2 = logInCallback;
                            final PurchasesOrchestrator purchasesOrchestrator3 = purchasesOrchestrator;
                            purchasesOrchestrator2.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.2.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    LogInCallback logInCallback3 = logInCallback2;
                                    if (logInCallback3 != null) {
                                        logInCallback3.onReceived(customerInfo, z);
                                    }
                                    purchasesOrchestrator3.customerInfoUpdateHandler.notifyListeners(customerInfo);
                                }
                            });
                            purchasesOrchestrator.remoteConfigManager.refreshRemoteConfig(purchasesOrchestrator.getState$purchases_defaultsRelease().getAppInBackground(), str2, RemoteConfigFetchContext.IdentityChange);
                            OfferingsManager.fetchAndCacheOfferings$default(purchasesOrchestrator.offeringsManager, str2, purchasesOrchestrator.getState$purchases_defaultsRelease().getAppInBackground(), null, null, 12, null);
                            purchasesOrchestrator.backupManager.dataChanged();
                        }
                    };
                    final PurchasesOrchestrator purchasesOrchestrator2 = this.this$0;
                    final LogInCallback logInCallback2 = callback;
                    identityManager.logIn(str, function2, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                            invoke2(purchasesError);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            PurchasesOrchestrator purchasesOrchestrator3 = purchasesOrchestrator2;
                            final LogInCallback logInCallback3 = logInCallback2;
                            purchasesOrchestrator3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.2.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    LogInCallback logInCallback4 = logInCallback3;
                                    if (logInCallback4 != null) {
                                        logInCallback4.onError(error);
                                    }
                                }
                            });
                        }
                    });
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, this.identityManager.getCurrentAppUserID(), CacheFetchPolicy.INSTANCE.m13621default(), getState$purchases_defaultsRelease().getAppInBackground(), getAllowSharingPlayStoreAccount(), false, ListenerConversionsCommonKt.receiveCustomerInfoCallback(new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                    invoke2(customerInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final LogInCallback logInCallback = callback;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            LogInCallback logInCallback2 = logInCallback;
                            if (logInCallback2 != null) {
                                logInCallback2.onReceived(customerInfo, false);
                            }
                        }
                    });
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final LogInCallback logInCallback = callback;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            LogInCallback logInCallback2 = logInCallback;
                            if (logInCallback2 != null) {
                                logInCallback2.onError(error);
                            }
                        }
                    });
                }
            }), 16, null);
        }
    }

    public static /* synthetic */ void logOut$default(PurchasesOrchestrator purchasesOrchestrator, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.logOut(receiveCustomerInfoCallback);
    }

    public final void logOut(final ReceiveCustomerInfoCallback callback) {
        this.identityManager.logOut(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logOut.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError) {
                if (purchasesError != null) {
                    ReceiveCustomerInfoCallback receiveCustomerInfoCallback = callback;
                    if (receiveCustomerInfoCallback != null) {
                        receiveCustomerInfoCallback.onError(purchasesError);
                        return;
                    }
                    return;
                }
                PurchasesOrchestrator purchasesOrchestrator = this;
                synchronized (purchasesOrchestrator) {
                    PurchasesState state$purchases_defaultsRelease = purchasesOrchestrator.getState$purchases_defaultsRelease();
                    Map mapEmptyMap = Collections.emptyMap();
                    Intrinsics.checkNotNullExpressionValue(mapEmptyMap, "emptyMap()");
                    purchasesOrchestrator.setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, mapEmptyMap, null, false, false, 29, null));
                    Unit unit = Unit.INSTANCE;
                }
                PurchasesOrchestrator purchasesOrchestrator2 = this;
                purchasesOrchestrator2.updateAllCaches(purchasesOrchestrator2.identityManager.getCurrentAppUserID(), RemoteConfigFetchContext.IdentityChange, callback);
                this.backupManager.dataChanged();
            }
        });
    }

    public final void close() {
        synchronized (this) {
            PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
            Map mapEmptyMap = Collections.emptyMap();
            Intrinsics.checkNotNullExpressionValue(mapEmptyMap, "emptyMap()");
            setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, mapEmptyMap, null, false, false, 29, null));
            Unit unit = Unit.INSTANCE;
        }
        this.backend.close();
        this.remoteConfigManager.close();
        this.workflowManager.close();
        this.uiConfigProvider.close();
        this.workflowsConfigProvider.close();
        this.billing.close();
        setUpdatedCustomerInfoListener(null);
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.close.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PurchasesOrchestrator.this.getProcessLifecycleOwnerProvider().invoke().getLifecycle().removeObserver(PurchasesOrchestrator.this.getLifecycleHandler());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCustomerInfo(ReceiveCustomerInfoCallback callback) {
        getCustomerInfo(CacheFetchPolicy.INSTANCE.m13621default(), false, callback);
    }

    public final void getCustomerInfo(CacheFetchPolicy fetchPolicy, boolean trackDiagnostics, ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.customerInfoHelper.retrieveCustomerInfo(this.identityManager.getCurrentAppUserID(), fetchPolicy, getState$purchases_defaultsRelease().getAppInBackground(), getAllowSharingPlayStoreAccount(), trackDiagnostics, callback);
    }

    public final void removeUpdatedCustomerInfoListener() {
        setUpdatedCustomerInfoListener(null);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        this.billing.showInAppMessagesIfNeeded(activity, inAppMessageTypes, new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.showInAppMessagesIfNeeded.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PurchasesOrchestrator.syncPurchases$default(PurchasesOrchestrator.this, null, 1, null);
            }
        });
    }

    public final void showManageSubscriptions(final Context context, final ManageSubscriptionsCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        getCustomerInfo(CacheFetchPolicy.CACHED_OR_FETCHED, false, new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.showManageSubscriptions.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Uri managementURL = customerInfo.getManagementURL();
                if (managementURL == null) {
                    String managementUrl$purchases_defaultsRelease = PurchasesOrchestrator.this.getAppConfig().getStore().getManagementUrl$purchases_defaultsRelease();
                    managementURL = managementUrl$purchases_defaultsRelease != null ? Uri.parse(managementUrl$purchases_defaultsRelease) : null;
                }
                if (managementURL == null) {
                    PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnsupportedError, "No management URL found for current subscription");
                    LogUtilsKt.errorLog(purchasesError);
                    ManageSubscriptionsCallback manageSubscriptionsCallback = callback;
                    if (manageSubscriptionsCallback != null) {
                        manageSubscriptionsCallback.onError(purchasesError);
                        return;
                    }
                    return;
                }
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", managementURL).addFlags(268435456));
                    ManageSubscriptionsCallback manageSubscriptionsCallback2 = callback;
                    if (manageSubscriptionsCallback2 != null) {
                        manageSubscriptionsCallback2.onSuccess();
                    }
                } catch (ActivityNotFoundException e) {
                    PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.UnknownError, "Cannot open subscription management URL: " + e.getMessage());
                    LogUtilsKt.errorLog(purchasesError2);
                    ManageSubscriptionsCallback manageSubscriptionsCallback3 = callback;
                    if (manageSubscriptionsCallback3 != null) {
                        manageSubscriptionsCallback3.onError(purchasesError2);
                    }
                }
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                ManageSubscriptionsCallback manageSubscriptionsCallback = callback;
                if (manageSubscriptionsCallback != null) {
                    manageSubscriptionsCallback.onError(error);
                }
            }
        });
    }

    public final void invalidateCustomerInfoCache() {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Invalidating CustomerInfo cache.";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.deviceCache.clearCustomerInfoCache$purchases_defaultsRelease(getAppUserID());
    }

    public final void getProductsOfTypes(Set<String> productIds, Set<? extends ProductType> types, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList();
        for (Object obj : types) {
            if (((ProductType) obj) != ProductType.UNKNOWN) {
                arrayList.add(obj);
            }
        }
        getProductsOfTypes$default(this, productIds, CollectionsKt.toSet(arrayList), CollectionsKt.emptyList(), null, callback, 8, null);
    }

    public final void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PaywallEvent) {
            this.paywallPresentedCache.receiveEvent((PaywallEvent) event);
        }
        this.eventsManager.track(event);
        TrackedEventListener trackedEventListener = this.trackedEventListener;
        if (trackedEventListener != null) {
            trackedEventListener.onEventTracked(event);
        }
    }

    public final void getCustomerCenterConfig(final GetCustomerCenterConfigCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.backend.getCustomerCenterConfig(this.identityManager.getCurrentAppUserID(), new Function1<CustomerCenterConfigData, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getCustomerCenterConfig.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterConfigData customerCenterConfigData) {
                invoke2(customerCenterConfigData);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerCenterConfigData config) {
                Intrinsics.checkNotNullParameter(config, "config");
                callback.onSuccess(config);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getCustomerCenterConfig.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                callback.onError(error);
            }
        });
    }

    public final void createSupportTicket(String email, String description, Function1<? super Boolean, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.backend.postCreateSupportTicket(this.identityManager.getCurrentAppUserID(), email, description, onSuccess, onError);
    }

    public final void getRewardVerificationResult(String clientTransactionId, final GetRewardVerificationResultCallback callback) {
        Intrinsics.checkNotNullParameter(clientTransactionId, "clientTransactionId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.backend.getRewardVerificationResult(this.identityManager.getCurrentAppUserID(), clientTransactionId, new Function1<RewardVerificationPollStatus, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getRewardVerificationResult.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RewardVerificationPollStatus rewardVerificationPollStatus) {
                invoke2(rewardVerificationPollStatus);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RewardVerificationPollStatus it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onReceived(it);
            }
        }, new Function1<RewardVerificationError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getRewardVerificationResult.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RewardVerificationError rewardVerificationError) {
                invoke2(rewardVerificationError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RewardVerificationError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onError(it);
            }
        });
    }

    public final void setAttributes(Map<String, String> attributes) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAttributes$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAttributes"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributes(attributes, getAppUserID());
    }

    public final void setEmail(String email) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setEmail$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setEmail"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.Email.INSTANCE, email, getAppUserID());
    }

    public final void setPhoneNumber(String phoneNumber) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setPhoneNumber$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPhoneNumber"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.PhoneNumber.INSTANCE, phoneNumber, getAppUserID());
    }

    public final void setDisplayName(String displayName) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setDisplayName$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setDisplayName"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.DisplayName.INSTANCE, displayName, getAppUserID());
    }

    public final void setPushToken(String fcmToken) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setPushToken$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPushToken"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.FCMTokens.INSTANCE, fcmToken, getAppUserID());
    }

    public final void setMixpanelDistinctID(String mixpanelDistinctID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMixpanelDistinctID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.MixpanelDistinctId.INSTANCE, mixpanelDistinctID, getAppUserID());
    }

    public final void setOnesignalID(String onesignalID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setOnesignalID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setOnesignalID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignal.INSTANCE, onesignalID, getAppUserID());
    }

    public final void setOnesignalUserID(String onesignalUserID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setOnesignalUserID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setOnesignalUserID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignalUserId.INSTANCE, onesignalUserID, getAppUserID());
    }

    public final void setAirshipChannelID(String airshipChannelID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAirshipChannelID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAirshipChannelID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.Airship.INSTANCE, airshipChannelID, getAppUserID());
    }

    public final void setFirebaseAppInstanceID(String firebaseAppInstanceID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setFirebaseAppInstanceID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.FirebaseAppInstanceId.INSTANCE, firebaseAppInstanceID, getAppUserID());
    }

    public final void setTenjinAnalyticsInstallationID(String tenjinAnalyticsInstallationID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setTenjinAnalyticsInstallationID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.TenjinAnalyticsInstallationId.INSTANCE, tenjinAnalyticsInstallationID, getAppUserID());
    }

    public final void setPostHogUserId(String postHogUserId) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setPostHogUserId$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPostHogUserId"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.PostHogUserId.INSTANCE, postHogUserId, getAppUserID());
    }

    public final void collectDeviceIdentifiers() {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"collectDeviceIdentifiers"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.collectDeviceIdentifiers(getAppUserID(), this.application);
    }

    public final void setAdjustID(String adjustID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAdjustID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAdjustID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Adjust.INSTANCE, adjustID, getAppUserID(), this.application);
    }

    public final void setAppsflyerID(String appsflyerID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAppsflyerID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAppsflyerID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.AppsFlyer.INSTANCE, appsflyerID, getAppUserID(), this.application);
    }

    public final void setFBAnonymousID(String fbAnonymousID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setFBAnonymousID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setFBAnonymousID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Facebook.INSTANCE, fbAnonymousID, getAppUserID(), this.application);
    }

    public final void setMparticleID(String mparticleID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setMparticleID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMparticleID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Mparticle.INSTANCE, mparticleID, getAppUserID(), this.application);
    }

    public final void setCleverTapID(String cleverTapID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setCleverTapID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCleverTapID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.CleverTap.INSTANCE, cleverTapID, getAppUserID(), this.application);
    }

    public final void setKochavaDeviceID(String kochavaDeviceID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setKochavaDeviceID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setKochavaDeviceID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Kochava.INSTANCE, kochavaDeviceID, getAppUserID(), this.application);
    }

    public final void setAirbridgeDeviceID(String airbridgeDeviceID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAirbridgeDeviceID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAirbridgeDeviceID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Airbridge.INSTANCE, airbridgeDeviceID, getAppUserID(), this.application);
    }

    public final void setSolarEngineDistinctId(String solarEngineDistinctId) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setSolarEngineDistinctId$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setSolarEngineDistinctId"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.SolarEngineDistinctId.INSTANCE, solarEngineDistinctId, getAppUserID(), this.application);
    }

    public final void setSolarEngineAccountId(String solarEngineAccountId) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setSolarEngineAccountId$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setSolarEngineAccountId"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.SolarEngineAccountId.INSTANCE, solarEngineAccountId, getAppUserID(), this.application);
    }

    public final void setSolarEngineVisitorId(String solarEngineVisitorId) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setSolarEngineVisitorId$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setSolarEngineVisitorId"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.SolarEngineVisitorId.INSTANCE, solarEngineVisitorId, getAppUserID(), this.application);
    }

    public final void setSingularDeviceID(String singularDeviceID) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setSingularDeviceID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setSingularDeviceID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Singular.INSTANCE, singularDeviceID, getAppUserID(), this.application);
    }

    public final void setAppsFlyerConversionData(Map<?, ?> data) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAppsFlyerConversionData$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAppsFlyerConversionData"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAppsFlyerConversionData(getAppUserID(), data);
    }

    public final void setAppstackAttributionParams(Map<String, String> data, SyncAttributesAndOfferingsCallback callback) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAppstackAttributionParams$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAppstackAttributionParams"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAppstackAttributionParams(getAppUserID(), data, this.application);
        syncAttributesAndOfferingsIfNeeded(callback);
    }

    private final boolean clearInMemoryCacheAndFetchOfferingsWithRateLimit(final Function2<? super Offerings, ? super PurchasesError, Unit> callback) {
        if (this.preferredLocaleOverrideRateLimiter.shouldProceed()) {
            this.offeringsManager.clearInMemoryOfferingsCache();
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Fetching fresh offerings");
            }
            getOfferings$default(this, new ReceiveOfferingsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.clearInMemoryCacheAndFetchOfferingsWithRateLimit.2
                @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
                public void onReceived(Offerings offerings) {
                    Intrinsics.checkNotNullParameter(offerings, "offerings");
                    callback.invoke(offerings, null);
                }

                @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
                public void onError(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    callback.invoke(null, error);
                }
            }, false, 2, null);
            return true;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.mo1541d("[Purchases] - " + logLevel2.name(), "Fresh offerings fetch rate limit reached: " + this.preferredLocaleOverrideRateLimiter.getMaxCallsInPeriod() + " per " + Duration.m15870getInWholeSecondsimpl(this.preferredLocaleOverrideRateLimiter.getPeriodSeconds()) + " seconds. Fetch not triggered.");
        }
        return false;
    }

    public final void setMediaSource(String mediaSource) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setMediaSource$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMediaSource"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE, mediaSource, getAppUserID());
    }

    public final void setCampaign(String campaign) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setCampaign$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCampaign"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE, campaign, getAppUserID());
    }

    public final void setAdGroup(String adGroup) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAdGroup$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAdGroup"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE, adGroup, getAppUserID());
    }

    public final void setAd(String ad) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAd$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAd"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.C7243Ad.INSTANCE, ad, getAppUserID());
    }

    public final void setKeyword(String keyword) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setKeyword$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"seKeyword"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE, keyword, getAppUserID());
    }

    public final void setCreative(String creative) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setCreative$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCreative"}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Creative.INSTANCE, creative, getAppUserID());
    }

    public final void getVirtualCurrencies(GetVirtualCurrenciesCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.virtualCurrencyManager.virtualCurrencies(callback);
    }

    public final void invalidateVirtualCurrenciesCache() {
        this.virtualCurrencyManager.invalidateVirtualCurrenciesCache();
    }

    public final VirtualCurrencies getCachedVirtualCurrencies() {
        return this.virtualCurrencyManager.cachedVirtualCurrencies();
    }

    public final void switchUser(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        if (!Intrinsics.areEqual(this.identityManager.getCurrentAppUserID(), newAppUserID)) {
            this.identityManager.switchUser(newAppUserID);
            OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, newAppUserID, getState$purchases_defaultsRelease().getAppInBackground(), null, null, 12, null);
            this.remoteConfigManager.refreshRemoteConfig(getState$purchases_defaultsRelease().getAppInBackground(), newAppUserID, RemoteConfigFetchContext.IdentityChange);
            return;
        }
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            String str2 = String.format(IdentityStrings.SWITCHING_USER_SAME_APP_USER_ID, Arrays.copyOf(new Object[]{newAppUserID}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            currentLogHandler.mo1545w(str, str2);
        }
    }

    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        return this.fontLoader.getCachedFontFamilyOrStartDownload(fontInfo);
    }

    private final void enqueue(final Function0<Unit> command) {
        this.dispatcher.enqueue(new Runnable() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                command.invoke();
            }
        }, Delay.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRefreshCustomerInfo(boolean firstTimeInForeground) {
        return !this.appConfig.getCustomEntitlementComputation() && (firstTimeInForeground || this.deviceCache.isCustomerInfoCacheStale$purchases_defaultsRelease(getAppUserID(), false));
    }

    static /* synthetic */ void getProductsOfTypes$default(PurchasesOrchestrator purchasesOrchestrator, Set set, Set set2, List list, Date date, GetStoreProductsCallback getStoreProductsCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            date = null;
        }
        purchasesOrchestrator.getProductsOfTypes(set, set2, list, date, getStoreProductsCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void getProductsOfTypes(Set<String> productIds, Set<? extends ProductType> types, List<? extends StoreProduct> collectedStoreProducts, Date startTime, GetStoreProductsCallback callback) {
        final PurchasesOrchestrator purchasesOrchestrator;
        final Set<String> set;
        final List<? extends StoreProduct> list;
        GetStoreProductsCallback getStoreProductsCallback;
        Unit unit;
        if (startTime == null) {
            trackGetProductsStarted(productIds);
            startTime = this.dateProvider.getNow();
        }
        final Date date = startTime;
        final Set mutableSet = CollectionsKt.toMutableSet(types);
        ProductType productType = (ProductType) CollectionsKt.firstOrNull(mutableSet);
        if (productType != null) {
            mutableSet.remove(productType);
        } else {
            productType = null;
        }
        if (productType != null) {
            purchasesOrchestrator = this;
            set = productIds;
            list = collectedStoreProducts;
            final GetStoreProductsCallback getStoreProductsCallback2 = callback;
            this.billing.queryProductDetailsAsync(productType, set, new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list2) {
                    invoke2(list2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final List<? extends StoreProduct> storeProducts) {
                    Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                    PurchasesOrchestrator purchasesOrchestrator2 = this.this$0;
                    final PurchasesOrchestrator purchasesOrchestrator3 = this.this$0;
                    final Set<String> set2 = set;
                    final Set<ProductType> set3 = mutableSet;
                    final List<StoreProduct> list2 = list;
                    final Date date2 = date;
                    final GetStoreProductsCallback getStoreProductsCallback3 = getStoreProductsCallback2;
                    purchasesOrchestrator2.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            purchasesOrchestrator3.getProductsOfTypes(set2, set3, CollectionsKt.plus((Collection) list2, (Iterable) storeProducts), date2, getStoreProductsCallback3);
                        }
                    });
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    PurchasesOrchestrator purchasesOrchestrator2 = this.this$0;
                    final PurchasesOrchestrator purchasesOrchestrator3 = this.this$0;
                    final Date date2 = date;
                    final Set<String> set2 = set;
                    final GetStoreProductsCallback getStoreProductsCallback3 = getStoreProductsCallback2;
                    purchasesOrchestrator2.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            PurchasesOrchestrator purchasesOrchestrator4 = purchasesOrchestrator3;
                            Date date3 = date2;
                            Set<String> set3 = set2;
                            purchasesOrchestrator4.trackGetProductsResult(date3, set3, set3, it);
                            getStoreProductsCallback3.onError(it);
                        }
                    });
                }
            });
            unit = Unit.INSTANCE;
            getStoreProductsCallback = getStoreProductsCallback2;
        } else {
            purchasesOrchestrator = this;
            set = productIds;
            list = collectedStoreProducts;
            getStoreProductsCallback = callback;
            unit = null;
        }
        if (unit == null) {
            List<? extends StoreProduct> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((StoreProduct) it.next()).getId());
            }
            trackGetProductsResult(date, set, SetsKt.minus((Set) set, (Iterable) CollectionsKt.toSet(arrayList)), null);
            getStoreProductsCallback.onReceived(list);
        }
    }

    static /* synthetic */ void updateAllCaches$default(PurchasesOrchestrator purchasesOrchestrator, String str, RemoteConfigFetchContext remoteConfigFetchContext, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.updateAllCaches(str, remoteConfigFetchContext, receiveCustomerInfoCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAllCaches(String appUserID, RemoteConfigFetchContext fetchContext, ReceiveCustomerInfoCallback completion) {
        boolean appInBackground = getState$purchases_defaultsRelease().getAppInBackground();
        this.remoteConfigManager.refreshRemoteConfig(appInBackground, appUserID, fetchContext);
        CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, appUserID, CacheFetchPolicy.FETCH_CURRENT, appInBackground, getAllowSharingPlayStoreAccount(), false, completion, 16, null);
        OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, appUserID, appInBackground, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(final Function0<Unit> action) {
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            Handler handler = this.mainHandler;
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    action.invoke();
                }
            });
            return;
        }
        action.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PurchaseCallback getPurchaseCallback(String productId) {
        PurchaseCallback purchaseCallback = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().get(productId);
        PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
        Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, PurchaseCallback> entry : purchaseCallbacksByProductId.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), productId)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, linkedHashMap, null, false, false, 29, null));
        return purchaseCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProductChangeCallback getAndClearProductChangeCallback() {
        ProductChangeCallback deprecatedProductChangeCallback = getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback();
        setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, null, false, false, 27, null));
        return deprecatedProductChangeCallback;
    }

    private final BillingAbstract.PurchasesUpdatedListener getPurchasesUpdatedListener() {
        return new BillingAbstract.PurchasesUpdatedListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getPurchasesUpdatedListener.1
            @Override // com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener
            public void onPurchasesUpdated(List<StoreTransaction> purchases) {
                boolean z;
                Pair productChangeCompletedCallbacks;
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                synchronized (purchasesOrchestrator) {
                    List<StoreTransaction> list = purchases;
                    boolean z2 = true;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        loop0: while (it.hasNext()) {
                            List<String> productIds = ((StoreTransaction) it.next()).getProductIds();
                            if (!(productIds instanceof Collection) || !productIds.isEmpty()) {
                                Iterator<T> it2 = productIds.iterator();
                                while (it2.hasNext()) {
                                    if (purchasesOrchestrator.getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().containsKey((String) it2.next())) {
                                        break;
                                    }
                                }
                            }
                            z2 = false;
                        }
                    }
                    z = z2;
                    productChangeCompletedCallbacks = purchasesOrchestrator.getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback() != null ? purchasesOrchestrator.getProductChangeCompletedCallbacks(purchasesOrchestrator.getAndClearProductChangeCallback()) : purchasesOrchestrator.getPurchaseCompletedCallbacks();
                    Unit unit = Unit.INSTANCE;
                }
                PurchasesOrchestrator.this.postTransactionWithProductDetailsHelper.postTransactions(purchases, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), PurchasesOrchestrator.this.getAppUserID(), PostReceiptInitiationSource.PURCHASE, z, (Function2) productChangeCompletedCallbacks.first, (Function2) productChangeCompletedCallbacks.second);
                PurchasesOrchestrator.this.flushEvents(Delay.NONE);
            }

            @Override // com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener
            public void onPurchasesFailedToUpdate(PurchasesError purchasesError) {
                Unit unit;
                Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                synchronized (purchasesOrchestrator) {
                    ProductChangeCallback andClearProductChangeCallback = purchasesOrchestrator.getAndClearProductChangeCallback();
                    if (andClearProductChangeCallback != null) {
                        purchasesOrchestrator.dispatch(andClearProductChangeCallback, purchasesError);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        Iterator it = purchasesOrchestrator.getAndClearAllPurchaseCallbacks().iterator();
                        while (it.hasNext()) {
                            purchasesOrchestrator.dispatch((PurchaseCallback) it.next(), purchasesError);
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PurchaseCallback> getAndClearAllPurchaseCallbacks() {
        List<PurchaseCallback> list;
        synchronized (this) {
            Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId();
            PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
            Map mapEmptyMap = Collections.emptyMap();
            Intrinsics.checkNotNullExpressionValue(mapEmptyMap, "emptyMap()");
            setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, mapEmptyMap, null, false, false, 29, null));
            list = CollectionsKt.toList(purchaseCallbacksByProductId.values());
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Function2<StoreTransaction, CustomerInfo, Unit>, Function2<StoreTransaction, PurchasesError, Unit>> getPurchaseCompletedCallbacks() {
        return new Pair<>(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                invoke2(storeTransaction, customerInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final StoreTransaction storeTransaction, final CustomerInfo info) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(info, "info");
                this.this$0.backupManager.dataChanged();
                BlockstoreHelper blockstoreHelper = this.this$0.blockstoreHelper;
                final PurchasesOrchestrator purchasesOrchestrator = this.this$0;
                blockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        purchasesOrchestrator.blockstoreHelper.storeUserIdIfNeeded(info);
                        final PurchaseCallback purchaseCallback = purchasesOrchestrator.getPurchaseCallback(storeTransaction.getProductIds().get(0));
                        if (purchaseCallback != null) {
                            PurchasesOrchestrator purchasesOrchestrator2 = purchasesOrchestrator;
                            final StoreTransaction storeTransaction2 = storeTransaction;
                            final CustomerInfo customerInfo = info;
                            purchasesOrchestrator2.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    purchaseCallback.onCompleted(storeTransaction2, customerInfo);
                                }
                            });
                        }
                    }
                });
            }
        }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onError$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
                invoke2(storeTransaction, purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreTransaction purchase, PurchasesError error) {
                Intrinsics.checkNotNullParameter(purchase, "purchase");
                Intrinsics.checkNotNullParameter(error, "error");
                PurchaseCallback purchaseCallback = this.this$0.getPurchaseCallback(purchase.getProductIds().get(0));
                if (purchaseCallback != null) {
                    this.this$0.dispatch(purchaseCallback, error);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Function2<StoreTransaction, CustomerInfo, Unit>, Function2<StoreTransaction, PurchasesError, Unit>> getProductChangeCompletedCallbacks(final ProductChangeCallback productChangeListener) {
        return new Pair<>(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductChangeCompletedCallbacks$onSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                invoke2(storeTransaction, customerInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final StoreTransaction storeTransaction, final CustomerInfo info) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(info, "info");
                final ProductChangeCallback productChangeCallback = productChangeListener;
                if (productChangeCallback != null) {
                    this.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductChangeCompletedCallbacks$onSuccess$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            productChangeCallback.onCompleted(storeTransaction, info);
                        }
                    });
                }
            }
        }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductChangeCompletedCallbacks$onError$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
                invoke2(storeTransaction, purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreTransaction storeTransaction, PurchasesError error) {
                Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(error, "error");
                ProductChangeCallback productChangeCallback = productChangeListener;
                if (productChangeCallback != null) {
                    this.dispatch(productChangeCallback, error);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(final PurchaseErrorCallback purchaseErrorCallback, final PurchasesError purchasesError) {
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.dispatch.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PurchaseErrorCallback purchaseErrorCallback2 = purchaseErrorCallback;
                PurchasesError purchasesError2 = purchasesError;
                purchaseErrorCallback2.onError(purchasesError2, purchasesError2.getCode() == PurchasesErrorCode.PurchaseCancelledError);
            }
        });
    }

    private final void startPurchase(Activity activity, final PurchasingData purchasingData, final PresentedOfferingContext presentedOfferingContext, Boolean isPersonalizedPrice, PurchaseCallback listener) {
        String str;
        LogHandler currentLogHandler;
        String str2;
        String strInvoke;
        String currentAppUserID;
        Unit unit;
        LogHandler currentLogHandler2;
        String str3;
        String strInvoke2;
        List addOnProducts;
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$startPurchase$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String offeringIdentifier;
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                StringBuilder sbAppend2 = new StringBuilder(" ").append(purchasingData).append(TokenParser.f2383SP);
                PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
                String str4 = String.format(PurchaseStrings.PURCHASE_STARTED, Arrays.copyOf(new Object[]{sbAppend2.append((presentedOfferingContext2 == null || (offeringIdentifier = presentedOfferingContext2.getOfferingIdentifier()) == null) ? null : PurchaseStrings.OFFERING + offeringIdentifier).toString()}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                return sbAppend.append(str4).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                str = "[Purchases] - ";
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str2, strInvoke);
                }
                break;
            case 2:
                str = "[Purchases] - ";
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                str = "[Purchases] - ";
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                str = "[Purchases] - ";
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                str = "[Purchases] - ";
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str2, strInvoke);
                }
                break;
            case 6:
                str = "[Purchases] - ";
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                str = "[Purchases] - ";
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                str = "[Purchases] - ";
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str2, strInvoke);
                }
                break;
            case 9:
                str = "[Purchases] - ";
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str2, strInvoke);
                }
                break;
            case 10:
                str = "[Purchases] - ";
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                str = "[Purchases] - ";
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                str = "[Purchases] - ";
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                str = "[Purchases] - ";
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler8.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                str = "[Purchases] - ";
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            default:
                str = "[Purchases] - ";
                break;
        }
        if ((purchasingData instanceof GooglePurchasingData.Subscription) && (addOnProducts = ((GooglePurchasingData.Subscription) purchasingData).getAddOnProducts()) != null && (!addOnProducts.isEmpty()) && getStore() != Store.PLAY_STORE) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, PurchaseStrings.PURCHASING_ADD_ONS_ONLY_SUPPORTED_ON_PLAY_STORE);
            LogUtilsKt.errorLog(purchasesError);
            dispatch(listener, purchasesError);
            return;
        }
        trackPurchaseStarted(purchasingData.getProductId(), purchasingData.getProductType());
        PurchaseCallback purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded = createCallbackWithDiagnosticsIfNeeded(listener, purchasingData, this.dateProvider.getNow());
        synchronized (this) {
            if (!this.appConfig.getFinishTransactions()) {
                final LogIntent logIntent2 = LogIntent.WARNING;
                Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$startPurchase$lambda$85$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + " finishTransactions is set to false and a purchase has been started. Are you sure you want to do this? More info here: https://errors.rev.cat/finishTransactions";
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                    case 1:
                        LogLevel logLevel11 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            str3 = str + logLevel11.name();
                            strInvoke2 = function02.invoke();
                            currentLogHandler2.mo1541d(str3, strInvoke2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel12 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                            currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel13 = LogLevel.INFO;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                            currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel14 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                            str3 = "[Purchases] - " + logLevel14.name();
                            strInvoke2 = function02.invoke();
                            currentLogHandler2.mo1541d(str3, strInvoke2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel15 = LogLevel.INFO;
                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                            currentLogHandler11.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel16 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                            str3 = "[Purchases] - " + logLevel16.name();
                            strInvoke2 = function02.invoke();
                            currentLogHandler2.mo1541d(str3, strInvoke2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel17 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                            str3 = "[Purchases] - " + logLevel17.name();
                            strInvoke2 = function02.invoke();
                            currentLogHandler2.mo1541d(str3, strInvoke2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel18 = LogLevel.WARN;
                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                            currentLogHandler12.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel19 = LogLevel.WARN;
                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                            currentLogHandler13.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel20 = LogLevel.WARN;
                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                            currentLogHandler14.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                }
            }
            if (getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                currentAppUserID = null;
            } else {
                setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, MapsKt.plus(getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId(), MapsKt.mapOf(TuplesKt.m1606to(purchasingData.getProductId(), purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded))), null, false, false, 29, null));
                currentAppUserID = this.identityManager.getCurrentAppUserID();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        if (currentAppUserID != null) {
            this.billing.makePurchaseAsync(activity, currentAppUserID, purchasingData, null, presentedOfferingContext, isPersonalizedPrice);
            Unit unit3 = Unit.INSTANCE;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, null, 2, null);
            LogUtilsKt.errorLog(purchasesError2);
            Unit unit4 = Unit.INSTANCE;
            dispatch(purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded, purchasesError2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v79 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String, kotlin.jvm.internal.DefaultConstructorMarker] */
    private final void startProductChange(Activity activity, final PurchasingData purchasingData, final PresentedOfferingContext presentedOfferingContext, final String oldProductId, final StoreReplacementMode replacementMode, Boolean isPersonalizedPrice, PurchaseCallback purchaseCallback) {
        StoreReplacementMode storeReplacementMode;
        PurchaseCallback purchaseCallback2;
        String currentAppUserID;
        Object obj;
        Object obj2;
        ?? r0;
        Object obj3;
        String productId;
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        LogHandler currentLogHandler2;
        String str2;
        String strInvoke2;
        List addOnProducts;
        trackPurchaseStarted(purchasingData.getProductId(), purchasingData.getProductType());
        PurchaseCallback purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded = createCallbackWithDiagnosticsIfNeeded(purchaseCallback, purchasingData, this.dateProvider.getNow());
        if (purchasingData.getProductType() != ProductType.SUBS) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            dispatch(purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded, purchasesError);
            return;
        }
        if ((purchasingData instanceof GooglePurchasingData.Subscription) && (addOnProducts = ((GooglePurchasingData.Subscription) purchasingData).getAddOnProducts()) != null && (!addOnProducts.isEmpty()) && getStore() != Store.PLAY_STORE) {
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, PurchaseStrings.PURCHASING_ADD_ONS_ONLY_SUPPORTED_ON_PLAY_STORE);
            LogUtilsKt.errorLog(purchasesError2);
            dispatch(purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded, purchasesError2);
            return;
        }
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$startProductChange$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String offeringIdentifier;
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                StringBuilder sbAppend2 = new StringBuilder(" ").append(purchasingData).append(TokenParser.f2383SP);
                PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
                String str3 = String.format(PurchaseStrings.PRODUCT_CHANGE_STARTED, Arrays.copyOf(new Object[]{sbAppend2.append((presentedOfferingContext2 == null || (offeringIdentifier = presentedOfferingContext2.getOfferingIdentifier()) == null) ? null : PurchaseStrings.OFFERING + offeringIdentifier).append(" oldProductId: ").append(oldProductId).append(" replacementMode ").append(replacementMode).toString()}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                return sbAppend.append(str3).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    strInvoke2 = function0.invoke();
                    currentLogHandler2.mo1541d(str2, strInvoke2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    strInvoke2 = function0.invoke();
                    currentLogHandler2.mo1541d(str2, strInvoke2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    strInvoke2 = function0.invoke();
                    currentLogHandler2.mo1541d(str2, strInvoke2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    strInvoke2 = function0.invoke();
                    currentLogHandler2.mo1541d(str2, strInvoke2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler8.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        synchronized (this) {
            if (!this.appConfig.getFinishTransactions()) {
                final LogIntent logIntent2 = LogIntent.WARNING;
                Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$startProductChange$lambda$96$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + " finishTransactions is set to false and a purchase has been started. Are you sure you want to do this? More info here: https://errors.rev.cat/finishTransactions";
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                    case 1:
                        LogLevel logLevel11 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            str = "[Purchases] - " + logLevel11.name();
                            strInvoke = function02.invoke();
                            currentLogHandler.mo1541d(str, strInvoke);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel12 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                            currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel13 = LogLevel.INFO;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                            currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel14 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                            str = "[Purchases] - " + logLevel14.name();
                            strInvoke = function02.invoke();
                            currentLogHandler.mo1541d(str, strInvoke);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel15 = LogLevel.INFO;
                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                            currentLogHandler11.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel16 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                            str = "[Purchases] - " + logLevel16.name();
                            strInvoke = function02.invoke();
                            currentLogHandler.mo1541d(str, strInvoke);
                        }
                        break;
                    case 9:
                        LogLevel logLevel17 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                            str = "[Purchases] - " + logLevel17.name();
                            strInvoke = function02.invoke();
                            currentLogHandler.mo1541d(str, strInvoke);
                        }
                        break;
                    case 10:
                        LogLevel logLevel18 = LogLevel.WARN;
                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                            currentLogHandler12.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel19 = LogLevel.WARN;
                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                            currentLogHandler13.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel20 = LogLevel.WARN;
                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                            currentLogHandler14.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                }
            }
            if (getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                storeReplacementMode = replacementMode;
                purchaseCallback2 = purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded;
                currentAppUserID = null;
                obj = null;
            } else {
                storeReplacementMode = replacementMode;
                if (Intrinsics.areEqual(storeReplacementMode, StoreReplacementMode.DEFERRED) && getStore() == Store.PLAY_STORE) {
                    if (StringsKt.contains$default((CharSequence) oldProductId, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                        LogLevel logLevel21 = LogLevel.WARN;
                        LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                            String str3 = "[Purchases] - " + logLevel21.name();
                            String str4 = String.format(PurchaseStrings.DEFERRED_PRODUCT_CHANGE_WITH_BASE_PLAN_ID, Arrays.copyOf(new Object[]{oldProductId}, 1));
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                            currentLogHandler15.mo1545w(str3, str4);
                        }
                    }
                    obj3 = null;
                    productId = StringsKt.substringBefore$default(oldProductId, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (String) null, 2, (Object) null);
                } else {
                    obj3 = null;
                    productId = purchasingData.getProductId();
                }
                purchaseCallback2 = purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded;
                setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, MapsKt.plus(getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId(), MapsKt.mapOf(TuplesKt.m1606to(productId, purchaseCallback2))), null, false, false, 29, null));
                obj = obj3;
                currentAppUserID = this.identityManager.getCurrentAppUserID();
            }
            Unit unit = Unit.INSTANCE;
        }
        if (currentAppUserID != null) {
            r0 = obj;
            replaceOldPurchaseWithNewProduct(purchasingData, oldProductId, storeReplacementMode, activity, currentAppUserID, presentedOfferingContext, isPersonalizedPrice, purchaseCallback2);
            Unit unit2 = Unit.INSTANCE;
            obj2 = Unit.INSTANCE;
        } else {
            Object obj4 = obj;
            obj2 = obj4;
            r0 = obj4;
        }
        if (obj2 == null) {
            PurchasesError purchasesError3 = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, r0, 2, r0);
            LogUtilsKt.errorLog(purchasesError3);
            Iterator<T> it = getAndClearAllPurchaseCallbacks().iterator();
            while (it.hasNext()) {
                dispatch((PurchaseCallback) it.next(), purchasesError3);
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.String] */
    private final void replaceOldPurchaseWithNewProduct(final PurchasingData purchasingData, String oldProductId, final StoreReplacementMode replacementMode, final Activity activity, final String appUserID, final PresentedOfferingContext presentedOfferingContext, final Boolean isPersonalizedPrice, final PurchaseErrorCallback listener) {
        if (purchasingData.getProductType() != ProductType.SUBS) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            ProductChangeCallback andClearProductChangeCallback = getAndClearProductChangeCallback();
            if (andClearProductChangeCallback != null) {
                dispatch(andClearProductChangeCallback, purchasesError);
            }
            Iterator<T> it = getAndClearAllPurchaseCallbacks().iterator();
            while (it.hasNext()) {
                dispatch((PurchaseCallback) it.next(), purchasesError);
            }
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = oldProductId;
        if (StringsKt.contains$default((CharSequence) oldProductId, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
            objectRef.element = StringsKt.substringBefore$default(oldProductId, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (String) null, 2, (Object) null);
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Using incorrect oldProductId: " + oldProductId + ". The productId should not contain the basePlanId. Using productId: " + ((String) objectRef.element) + '.');
            }
        }
        this.billing.findPurchaseInPurchaseHistory(appUserID, ProductType.SUBS, (String) objectRef.element, new Function1<StoreTransaction, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.replaceOldPurchaseWithNewProduct.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction) {
                invoke2(storeTransaction);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreTransaction purchaseRecord) {
                LogHandler currentLogHandler2;
                String str;
                String strInvoke;
                Intrinsics.checkNotNullParameter(purchaseRecord, "purchaseRecord");
                final LogIntent logIntent = LogIntent.PURCHASE;
                final Ref.ObjectRef<String> objectRef2 = objectRef;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                        String str2 = String.format(PurchaseStrings.FOUND_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{objectRef2.element}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        return sbAppend.append(str2).toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel2 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            str = "[Purchases] - " + logLevel2.name();
                            strInvoke = function0.invoke();
                            currentLogHandler2.mo1541d(str, strInvoke);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel3 = LogLevel.WARN;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.mo1545w("[Purchases] - " + logLevel3.name(), function0.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel4 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.mo1543i("[Purchases] - " + logLevel4.name(), function0.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel5 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            str = "[Purchases] - " + logLevel5.name();
                            strInvoke = function0.invoke();
                            currentLogHandler2.mo1541d(str, strInvoke);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel6 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler5.mo1543i("[Purchases] - " + logLevel6.name(), function0.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            strInvoke = function0.invoke();
                            currentLogHandler2.mo1541d(str, strInvoke);
                        }
                        break;
                    case 9:
                        LogLevel logLevel8 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            str = "[Purchases] - " + logLevel8.name();
                            strInvoke = function0.invoke();
                            currentLogHandler2.mo1541d(str, strInvoke);
                        }
                        break;
                    case 10:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel11 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            currentLogHandler8.mo1545w("[Purchases] - " + logLevel11.name(), function0.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                }
                PurchasesOrchestrator.this.billing.makePurchaseAsync(activity, appUserID, purchasingData, new ReplaceProductInfo(purchaseRecord, replacementMode), presentedOfferingContext, isPersonalizedPrice);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.replaceOldPurchaseWithNewProduct.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError2) {
                invoke2(purchasesError2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final PurchasesError error) {
                LogHandler currentLogHandler2;
                String str;
                String strInvoke;
                Intrinsics.checkNotNullParameter(error, "error");
                final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + TokenParser.f2383SP + error.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel2 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            str = "[Purchases] - " + logLevel2.name();
                            strInvoke = function0.invoke();
                            currentLogHandler2.mo1541d(str, strInvoke);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel3 = LogLevel.WARN;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.mo1545w("[Purchases] - " + logLevel3.name(), function0.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel4 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.mo1543i("[Purchases] - " + logLevel4.name(), function0.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel5 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            str = "[Purchases] - " + logLevel5.name();
                            strInvoke = function0.invoke();
                            currentLogHandler2.mo1541d(str, strInvoke);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel6 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler5.mo1543i("[Purchases] - " + logLevel6.name(), function0.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            strInvoke = function0.invoke();
                            currentLogHandler2.mo1541d(str, strInvoke);
                        }
                        break;
                    case 9:
                        LogLevel logLevel8 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            str = "[Purchases] - " + logLevel8.name();
                            strInvoke = function0.invoke();
                            currentLogHandler2.mo1541d(str, strInvoke);
                        }
                        break;
                    case 10:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel11 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            currentLogHandler8.mo1545w("[Purchases] - " + logLevel11.name(), function0.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                }
                PurchasesOrchestrator.this.getAndClearProductChangeCallback();
                PurchasesOrchestrator.this.getAndClearAllPurchaseCallbacks();
                PurchasesOrchestrator.this.dispatch(listener, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void synchronizeSubscriberAttributesIfNeeded(Delay delay) {
        if (this.appConfig.getUiPreviewMode()) {
            return;
        }
        SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers$default(this.subscriberAttributesManager, getAppUserID(), delay, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushEvents(Delay delay) {
        if (this.appConfig.getUiPreviewMode()) {
            return;
        }
        this.eventsManager.flushEvents(delay);
        this.adEventsManager.flushEvents(delay);
    }

    private final PurchaseCallback createCallbackWithDiagnosticsIfNeeded(final PurchaseCallback originalCallback, final PurchasingData purchasingData, final Date startTime) {
        return this.diagnosticsTrackerIfEnabled == null ? originalCallback : new PurchaseCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.createCallbackWithDiagnosticsIfNeeded.1
            @Override // com.revenuecat.purchases.interfaces.PurchaseCallback
            public void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PurchasesOrchestrator.this.trackPurchaseResultIfNeeded(purchasingData, null, startTime, customerInfo.getEntitlements().getVerification());
                originalCallback.onCompleted(storeTransaction, customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.PurchaseErrorCallback
            public void onError(PurchasesError error, boolean userCancelled) {
                Intrinsics.checkNotNullParameter(error, "error");
                PurchasesOrchestrator.this.trackPurchaseResultIfNeeded(purchasingData, error, startTime, null);
                originalCallback.onError(error, userCancelled);
            }
        };
    }

    private final void trackGetProductsStarted(Set<String> requestedProductIds) {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackGetProductsStarted(requestedProductIds);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackGetProductsResult(Date startTime, Set<String> requestedProductIds, Set<String> notFoundProductIds, PurchasesError error) {
        PurchasesErrorCode code;
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        long jBetween = DurationExtensionsKt.between(Duration.INSTANCE, startTime, this.dateProvider.getNow());
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        Integer numValueOf = null;
        String message = error != null ? error.getMessage() : null;
        if (error != null && (code = error.getCode()) != null) {
            numValueOf = Integer.valueOf(code.getCode());
        }
        diagnosticsTracker.m13722trackGetProductsResult9VgGkz4(requestedProductIds, notFoundProductIds, message, numValueOf, jBetween);
    }

    private final void trackPurchaseStarted(String productId, ProductType productType) {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackPurchaseStarted(productId, productType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackPurchaseResultIfNeeded(PurchasingData purchasingData, PurchasesError error, Date startTime, VerificationResult verificationResult) {
        PurchasesErrorCode code;
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        this.diagnosticsTrackerIfEnabled.m13727trackPurchaseResultmyKFqkg(purchasingData.getProductId(), purchasingData.getProductType(), (error == null || (code = error.getCode()) == null) ? null : Integer.valueOf(code.getCode()), error != null ? error.getMessage() : null, DurationExtensionsKt.between(Duration.INSTANCE, startTime, this.dateProvider.getNow()), verificationResult);
    }

    /* JADX INFO: compiled from: PurchasesOrchestrator.kt */
    @Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040,R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006-"}, m1599d2 = {"Lcom/revenuecat/purchases/PurchasesOrchestrator$Companion;", "", "()V", "value", "", "debugLogsEnabled", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "frameworkVersion", "", "Lcom/revenuecat/purchases/LogHandler;", "logHandler", "getLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "Lcom/revenuecat/purchases/LogLevel;", "logLevel", "getLogLevel", "()Lcom/revenuecat/purchases/LogLevel;", "setLogLevel", "(Lcom/revenuecat/purchases/LogLevel;)V", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "setPlatformInfo", "(Lcom/revenuecat/purchases/common/PlatformInfo;)V", "proxyURL", "Ljava/net/URL;", "getProxyURL", "()Ljava/net/URL;", "setProxyURL", "(Ljava/net/URL;)V", "canMakePayments", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "features", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "callback", "Lcom/revenuecat/purchases/interfaces/Callback;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.platformInfo;
        }

        public final void setPlatformInfo(PlatformInfo platformInfo) {
            Intrinsics.checkNotNullParameter(platformInfo, "<set-?>");
            PurchasesOrchestrator.platformInfo = platformInfo;
        }

        public final boolean getDebugLogsEnabled() {
            return LogUtilsKt.getDebugLogsEnabled(getLogLevel());
        }

        public final void setDebugLogsEnabled(boolean z) {
            setLogLevel(LogUtilsKt.debugLogsEnabled(LogLevel.INSTANCE, z));
        }

        public final LogLevel getLogLevel() {
            return Config.INSTANCE.getLogLevel();
        }

        public final void setLogLevel(LogLevel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Config.INSTANCE.setLogLevel(value);
        }

        public final synchronized LogHandler getLogHandler() {
            return LogWrapperKt.getCurrentLogHandler();
        }

        public final synchronized void setLogHandler(LogHandler value) {
            Intrinsics.checkNotNullParameter(value, "value");
            LogWrapperKt.setCurrentLogHandler(value);
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.proxyURL;
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.proxyURL = url;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            companion.canMakePayments(context, list, callback);
        }

        public final void canMakePayments(Context context, List<? extends BillingFeature> features, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callback, "callback");
            BillingClient billingClientBuild = BillingClient.newBuilder(context).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).setListener(new PurchasesUpdatedListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$Companion$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.PurchasesUpdatedListener
                public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                    Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
                }
            }).build();
            billingClientBuild.startConnection(new PurchasesOrchestrator$Companion$canMakePayments$2$1(new Handler(context.getMainLooper()), new AtomicBoolean(false), callback, billingClientBuild, features));
        }
    }
}
