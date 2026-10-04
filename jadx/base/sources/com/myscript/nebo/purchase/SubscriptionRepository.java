package com.myscript.nebo.purchase;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.sdk.kotlin.services.p010s3.express.S3ExpressDefaultChecksumAlgorithmKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.IntSharedPreferencesProperty;
import com.myscript.android.utils.LongSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.account.backend.Backend;
import com.myscript.nebo.account.backend.CachePolicy;
import com.myscript.nebo.account.backend.IMailServices;
import com.myscript.nebo.account.backend.entity.KeyValue;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.migration.IInstallReferralRepository;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: SubscriptionRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Õ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001j\b\u0007\u0018\u0000 \u0091\u00012\u00020\u0001:\u0004\u0090\u0001\u0091\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010l\u001a\u00020\u00132\n\u0010m\u001a\u0006\u0012\u0002\b\u00030n2\u0006\u0010o\u001a\u00020#2\b\b\u0002\u0010p\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010qJ\u000e\u0010r\u001a\u00020sH\u0096@¢\u0006\u0002\u0010tJ\u000e\u0010u\u001a\u00020sH\u0096@¢\u0006\u0002\u0010tJ\u0018\u0010v\u001a\u00020s2\b\u0010w\u001a\u0004\u0018\u00010#H\u0082@¢\u0006\u0002\u0010xJ\u000e\u0010y\u001a\u00020sH\u0096@¢\u0006\u0002\u0010tJ\u000e\u0010z\u001a\u00020sH\u0096@¢\u0006\u0002\u0010tJ\u000e\u0010{\u001a\u00020sH\u0096@¢\u0006\u0002\u0010tJ\u000e\u0010|\u001a\u00020sH\u0096@¢\u0006\u0002\u0010tJ\u0011\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020s2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\t\u0010\u0082\u0001\u001a\u00020sH\u0002J\u0010\u0010\u0083\u0001\u001a\u00020s2\u0007\u0010\u0084\u0001\u001a\u00020:J\u000f\u0010\u0085\u0001\u001a\u00020sH\u0086@¢\u0006\u0002\u0010tJ\t\u0010\u0086\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u0087\u0001\u001a\u00020sH\u0016J\u0007\u0010\u0088\u0001\u001a\u00020sJ,\u0010\u0089\u0001\u001a\u00020s2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020:2\u0007\u0010\u008d\u0001\u001a\u00020:H\u0086@¢\u0006\u0003\u0010\u008e\u0001J\u000f\u0010\u008f\u0001\u001a\u00020sH\u0086@¢\u0006\u0002\u0010tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020(0*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R+\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020.8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b0\u00101\"\u0004\b2\u00103R+\u00106\u001a\u00020.2\u0006\u0010-\u001a\u00020.8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b9\u00105\u001a\u0004\b7\u00101\"\u0004\b8\u00103R+\u0010;\u001a\u00020:2\u0006\u0010-\u001a\u00020:8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R+\u0010B\u001a\u00020.2\u0006\u0010-\u001a\u00020.8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u00105\u001a\u0004\bC\u00101\"\u0004\bD\u00103R+\u0010F\u001a\u00020.2\u0006\u0010-\u001a\u00020.8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bI\u00105\u001a\u0004\bG\u00101\"\u0004\bH\u00103R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020K0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020K0*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010,R\u000e\u0010N\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00130'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00130*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010,R\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00130'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00130*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010,R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00130'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00130*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010,R\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00130'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00130*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010,R\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0016\u0010_\u001a\u0004\u0018\u00010`8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0010\u0010c\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010d\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010eR\u0012\u0010f\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010eR\u0012\u0010g\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0004\n\u0002\u0010hR\u0010\u0010i\u001a\u00020jX\u0082\u0004¢\u0006\u0004\n\u0002\u0010k¨\u0006\u0092\u0001"}, m1599d2 = {"Lcom/myscript/nebo/purchase/SubscriptionRepository;", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", WebViewMessageType.CONTEXT, "Landroid/app/Application;", S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, "Lcom/myscript/nebo/account/backend/Backend;", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "mailServices", "Lcom/myscript/nebo/account/backend/IMailServices;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "isFreemiumEnabled", "", "purchaseProvider", "Lcom/myscript/nebo/purchase/IPurchaseProvider;", "installReferralRepository", "Lcom/myscript/nebo/migration/IInstallReferralRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/account/backend/Backend;Lcom/myscript/nebo/sso/api/ISSOManager;Lcom/myscript/nebo/account/backend/IMailServices;Lcom/myscript/nebo/sso/model/UserData;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Landroid/content/SharedPreferences;Lcom/myscript/nebo/log/TechnicalLogger;ZLcom/myscript/nebo/purchase/IPurchaseProvider;Lcom/myscript/nebo/migration/IInstallReferralRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dataSyncMutex", "Lkotlinx/coroutines/sync/Mutex;", "lastConfiguredAppUserId", "", "alreadyConfiguredWithoutInternet", "alreadyConfiguredWithInternet", "_freePeriodState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/myscript/nebo/purchase/FreePeriodState;", "freePeriodState", "Lkotlinx/coroutines/flow/StateFlow;", "getFreePeriodState", "()Lkotlinx/coroutines/flow/StateFlow;", "<set-?>", "", "freeTrialStart", "getFreeTrialStart", "()J", "setFreeTrialStart", "(J)V", "freeTrialStart$delegate", "Lcom/myscript/android/utils/LongSharedPreferencesProperty;", "oemOfferStart", "getOemOfferStart", "setOemOfferStart", "oemOfferStart$delegate", "", "oemOfferDuration", "getOemOfferDuration", "()I", "setOemOfferDuration", "(I)V", "oemOfferDuration$delegate", "Lcom/myscript/android/utils/IntSharedPreferencesProperty;", "renewalOfferWindowStart", "getRenewalOfferWindowStart", "setRenewalOfferWindowStart", "renewalOfferWindowStart$delegate", "renewalOfferHandledExpiration", "getRenewalOfferHandledExpiration", "setRenewalOfferHandledExpiration", "renewalOfferHandledExpiration$delegate", "_renewalOfferState", "Lcom/myscript/nebo/purchase/RenewalOfferState;", "renewalOfferState", "getRenewalOfferState", "renewalOfferEndsAtMs", "debugRenewalOfferOverride", "_isPreConfigured", "isPreConfigured", "_isConfigured", "isConfigured", "_hasSubscribed", "hasSubscribed", "getHasSubscribed", "_isBillingUnavailable", "isBillingUnavailable", "planType", "Lcom/myscript/nebo/purchase/ISubscriptionRepository$PlanType;", "getPlanType", "()Lcom/myscript/nebo/purchase/ISubscriptionRepository$PlanType;", "setPlanType", "(Lcom/myscript/nebo/purchase/ISubscriptionRepository$PlanType;)V", "offerings", "Lcom/revenuecat/purchases/Offerings;", "getOfferings", "()Lcom/revenuecat/purchases/Offerings;", "_offerings", "savedFreeTrialStart", "Ljava/lang/Long;", "savedOEMOfferStart", "savedOEMOfferDuration", "Ljava/lang/Integer;", "loginListener", "com/myscript/nebo/purchase/SubscriptionRepository$loginListener$1", "Lcom/myscript/nebo/purchase/SubscriptionRepository$loginListener$1;", "recordFailure", "result", "Lkotlin/Result;", "fallbackMessage", "clearsBillingUnavailableOnSuccess", "(Ljava/lang/Object;Ljava/lang/String;Z)Z", "updateConfiguration", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preConfigure", "configure", "appUserId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startFreeTrial", "startOEMOffer", "checkFreePeriodStatus", "fetchSubscriptionStatus", "rememberRenewalMemory", "Lcom/myscript/nebo/purchase/SubscriptionRepository$RenewalMemory;", "customerInfo", "Lcom/myscript/nebo/purchase/CustomerInfoResult;", "updateRenewalOffer", "publishRenewalOfferState", "debugOverrideRenewalOffer", "remainingHours", "debugClearRenewalOfferOverride", "hasPaywallAfterFreePeriodBeenShown", "setPaywallAfterOptInTrialShown", "onCleared", "debugOverrideFreePeriod", "type", "Lcom/myscript/nebo/purchase/FreePeriodType;", "remainingDays", "durationDays", "(Lcom/myscript/nebo/purchase/FreePeriodType;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "debugClearFreePeriodOverride", "RenewalMemory", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SubscriptionRepository implements ISubscriptionRepository {
    private static final String APP_ID_1_KEY = "app_id_1";
    private static final String APP_ID_2_KEY = "app_id_2";
    private static final String APP_NOTES_VALUE = "ms_notes";
    private static final String BACKEND_FREE_TRIAL_START_KEY = "free_trial_start";
    private static final long DAY_IN_MS = 86400000;
    public static final String FREEMIUM_PLACEMENT_ID = "freemium";
    private static final int FREE_TRIAL_DEFAULT_DURATION_DAYS = 7;
    private static final long OEM_OFFER_DURATION_WAIT_TIMEOUT_MS = 10000;
    private static final String PAYWALL_AFTER_FREE_PERIOD_SHOWN_KEY = "PAYWALL_AFTER_TRIAL_SHOWN_KEY";
    public static final String PREF_FREE_TRIAL_START_KEY = "PREF_FREE_TRIAL_START_KEY";
    private static final String PREF_MAILSERVICES_LINK_RC_DONE_KEY = "PREF_MAILSERVICES_LINK_RC_DONE_KEY";
    public static final String PREF_OEM_OFFER_DURATION_KEY = "PREF_OEM_OFFER_DURATION_KEY";
    public static final String PREF_OEM_OFFER_START_KEY = "PREF_OEM_OFFER_START_KEY";
    private static final String PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_KEY = "PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_KEY";
    private static final String PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_USER_KEY = "PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_USER_KEY";
    private static final String PREF_RENEWAL_OFFER_HANDLED_EXPIRATION_KEY = "PREF_RENEWAL_OFFER_HANDLED_EXPIRATION_KEY";
    private static final String PREF_RENEWAL_OFFER_OBSERVED_CHAIN_KEY = "PREF_RENEWAL_OFFER_OBSERVED_CHAIN_KEY";
    private static final String PREF_RENEWAL_OFFER_OBSERVED_PAYMENTS_KEY = "PREF_RENEWAL_OFFER_OBSERVED_PAYMENTS_KEY";
    private static final String PREF_RENEWAL_OFFER_WINDOW_START_KEY = "PREF_RENEWAL_OFFER_WINDOW_START_KEY";
    private static final String RC_OEM_OFFER_DURATION_KEY = "oem_offer_duration_days";
    private final MutableStateFlow<FreePeriodState> _freePeriodState;
    private final MutableStateFlow<Boolean> _hasSubscribed;
    private final MutableStateFlow<Boolean> _isBillingUnavailable;
    private final MutableStateFlow<Boolean> _isConfigured;
    private final MutableStateFlow<Boolean> _isPreConfigured;
    private Offerings _offerings;
    private final MutableStateFlow<RenewalOfferState> _renewalOfferState;
    private boolean alreadyConfiguredWithInternet;
    private boolean alreadyConfiguredWithoutInternet;
    private final Backend backend;
    private final Application context;
    private final Mutex dataSyncMutex;
    private boolean debugRenewalOfferOverride;
    private final StateFlow<FreePeriodState> freePeriodState;

    /* JADX INFO: renamed from: freeTrialStart$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty freeTrialStart;
    private final StateFlow<Boolean> hasSubscribed;
    private final IInstallReferralRepository installReferralRepository;
    private final CoroutineDispatcher ioDispatcher;
    private final StateFlow<Boolean> isBillingUnavailable;
    private final StateFlow<Boolean> isConfigured;
    private final boolean isFreemiumEnabled;
    private final StateFlow<Boolean> isPreConfigured;
    private String lastConfiguredAppUserId;
    private final TechnicalLogger logger;
    private final SubscriptionRepository$loginListener$1 loginListener;
    private final IMailServices mailServices;
    private final NeboNetworkStateRepository networkStateRepository;

    /* JADX INFO: renamed from: oemOfferDuration$delegate, reason: from kotlin metadata */
    private final IntSharedPreferencesProperty oemOfferDuration;

    /* JADX INFO: renamed from: oemOfferStart$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty oemOfferStart;
    private final CompletableJob parentJob;
    private ISubscriptionRepository.PlanType planType;
    private final IPurchaseProvider purchaseProvider;
    private long renewalOfferEndsAtMs;

    /* JADX INFO: renamed from: renewalOfferHandledExpiration$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty renewalOfferHandledExpiration;
    private final StateFlow<RenewalOfferState> renewalOfferState;

    /* JADX INFO: renamed from: renewalOfferWindowStart$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty renewalOfferWindowStart;
    private Long savedFreeTrialStart;
    private Integer savedOEMOfferDuration;
    private Long savedOEMOfferStart;
    private final CoroutineScope scope;
    private final SharedPreferences sharedPreferences;
    private final ISSOManager ssoManager;
    private final UserData userData;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(SubscriptionRepository.class, "freeTrialStart", "getFreeTrialStart()J", 0), new MutablePropertyReference1Impl(SubscriptionRepository.class, "oemOfferStart", "getOemOfferStart()J", 0), new MutablePropertyReference1Impl(SubscriptionRepository.class, "oemOfferDuration", "getOemOfferDuration()I", 0), new MutablePropertyReference1Impl(SubscriptionRepository.class, "renewalOfferWindowStart", "getRenewalOfferWindowStart()J", 0), new MutablePropertyReference1Impl(SubscriptionRepository.class, "renewalOfferHandledExpiration", "getRenewalOfferHandledExpiration()J", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final String OFFERING_ID_NEC = "msnotes_fullaccess_nec";
    public static final String OFFERING_ID_HANVON = "msnotes_fullaccess_hanvon";
    public static final String OFFERING_ID_LENOVO = "msnotes_fullaccess_lenovo";
    public static final String OFFERING_ID_MOTOROLA = "msnotes_fullaccess_motorola";
    public static final String OFFERING_ID_TCL = "msnotes_fullaccess_tcl";
    public static final String OFFERING_ID_SAMSUNG = "msnotes_fullaccess_samsung";
    private static final List<String> OEM_OFFERING_IDS = CollectionsKt.listOf((Object[]) new String[]{OFFERING_ID_NEC, OFFERING_ID_HANVON, OFFERING_ID_LENOVO, OFFERING_ID_MOTOROLA, OFFERING_ID_TCL, OFFERING_ID_SAMSUNG});

    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FreePeriodType.values().length];
            try {
                iArr[FreePeriodType.Trial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FreePeriodType.OEMOffer.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FreePeriodType.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$checkFreePeriodStatus$1 */
    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository", m1609f = "SubscriptionRepository.kt", m1610i = {0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {498, 542}, m1612m = "checkFreePeriodStatus", m1613n = {"freeTrialStartFromPrefs", "oemOfferStartFromPrefs", "freeTrialStarted", "freeTrialStartFromPrefs", "freePeriodType", "oemOfferStartFromPrefs", "freeTrialStarted", "now"}, m1614nl = {500, 545}, m1615s = {"L$0", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0", "J$1"}, m1616v = 2)
    static final class C67341 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C67341(Continuation<? super C67341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionRepository.this.checkFreePeriodStatus(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$fetchSubscriptionStatus$1 */
    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO}, m1612m = "fetchSubscriptionStatus", m1613n = {}, m1614nl = {TypedValues.MotionType.TYPE_PATHMOTION_ARC}, m1615s = {}, m1616v = 2)
    static final class C67381 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C67381(Continuation<? super C67381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionRepository.this.fetchSubscriptionStatus(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$preConfigure$1 */
    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository", m1609f = "SubscriptionRepository.kt", m1610i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, m1611l = {859, 274, 282, 286, 289, PDFACompliance.e_PDFA2_9_1}, m1612m = "preConfigure", m1613n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-SubscriptionRepository$preConfigure$2", "$this$withLock_u24default$iv", "appUserId", "$i$f$withLock", "$i$a$-withLock$default-SubscriptionRepository$preConfigure$2", "$this$withLock_u24default$iv", "appUserId", "$i$f$withLock", "$i$a$-withLock$default-SubscriptionRepository$preConfigure$2", "$this$withLock_u24default$iv", "appUserId", "syncPurchasesResult", "$i$f$withLock", "$i$a$-withLock$default-SubscriptionRepository$preConfigure$2", "$this$withLock_u24default$iv", "appUserId", "syncPurchasesResult", "$i$f$withLock", "$i$a$-withLock$default-SubscriptionRepository$preConfigure$2"}, m1614nl = {860, 276, 283, 287, PDFACompliance.e_PDFA2_9_1, 302}, m1615s = {"L$0", "I$0", "L$0", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, m1616v = 2)
    static final class C67401 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C67401(Continuation<? super C67401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionRepository.this.preConfigure(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$updateConfiguration$1 */
    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository", m1609f = "SubscriptionRepository.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {859, 250}, m1612m = "updateConfiguration", m1613n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-SubscriptionRepository$updateConfiguration$2"}, m1614nl = {860, 254}, m1615s = {"L$0", "I$0", "L$0", "I$0", "I$1"}, m1616v = 2)
    static final class C67421 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C67421(Continuation<? super C67421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionRepository.this.updateConfiguration(this);
        }
    }

    /* JADX WARN: Type inference failed for: r1v32, types: [com.myscript.nebo.purchase.SubscriptionRepository$loginListener$1] */
    public SubscriptionRepository(Application context, Backend backend, ISSOManager ssoManager, IMailServices mailServices, UserData userData, NeboNetworkStateRepository networkStateRepository, SharedPreferences sharedPreferences, TechnicalLogger logger, boolean z, IPurchaseProvider purchaseProvider, IInstallReferralRepository installReferralRepository, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(ssoManager, "ssoManager");
        Intrinsics.checkNotNullParameter(mailServices, "mailServices");
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(purchaseProvider, "purchaseProvider");
        Intrinsics.checkNotNullParameter(installReferralRepository, "installReferralRepository");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.context = context;
        this.backend = backend;
        this.ssoManager = ssoManager;
        this.mailServices = mailServices;
        this.userData = userData;
        this.networkStateRepository = networkStateRepository;
        this.sharedPreferences = sharedPreferences;
        this.logger = logger;
        this.isFreemiumEnabled = z;
        this.purchaseProvider = purchaseProvider;
        this.installReferralRepository = installReferralRepository;
        this.ioDispatcher = ioDispatcher;
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.parentJob = completableJobJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(completableJobJob$default.plus(ioDispatcher));
        this.dataSyncMutex = MutexKt.Mutex$default(false, 1, null);
        MutableStateFlow<FreePeriodState> MutableStateFlow = StateFlowKt.MutableStateFlow(new FreePeriodState(null, null, 0L, 0L, 15, null));
        this._freePeriodState = MutableStateFlow;
        this.freePeriodState = MutableStateFlow;
        this.freeTrialStart = SharedPreferencesExtKt.longPref(sharedPreferences, PREF_FREE_TRIAL_START_KEY, 0L);
        this.oemOfferStart = SharedPreferencesExtKt.longPref(sharedPreferences, PREF_OEM_OFFER_START_KEY, 0L);
        this.oemOfferDuration = SharedPreferencesExtKt.intPref(sharedPreferences, PREF_OEM_OFFER_DURATION_KEY, -1);
        this.renewalOfferWindowStart = SharedPreferencesExtKt.longPref(sharedPreferences, PREF_RENEWAL_OFFER_WINDOW_START_KEY, 0L);
        this.renewalOfferHandledExpiration = SharedPreferencesExtKt.longPref(sharedPreferences, PREF_RENEWAL_OFFER_HANDLED_EXPIRATION_KEY, 0L);
        MutableStateFlow<RenewalOfferState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new RenewalOfferState(false, 0L, 3, null));
        this._renewalOfferState = MutableStateFlow2;
        this.renewalOfferState = MutableStateFlow2;
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(Boolean.valueOf(!z));
        this._isPreConfigured = MutableStateFlow3;
        this.isPreConfigured = MutableStateFlow3;
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(Boolean.valueOf(!z));
        this._isConfigured = MutableStateFlow4;
        this.isConfigured = MutableStateFlow4;
        MutableStateFlow<Boolean> MutableStateFlow5 = StateFlowKt.MutableStateFlow(Boolean.valueOf(!z));
        this._hasSubscribed = MutableStateFlow5;
        this.hasSubscribed = MutableStateFlow5;
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._isBillingUnavailable = MutableStateFlow6;
        this.isBillingUnavailable = MutableStateFlow6;
        ?? r1 = new ISSOManager.OnLoginListener() { // from class: com.myscript.nebo.purchase.SubscriptionRepository$loginListener$1
            @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
            public void onLogin() {
                BuildersKt__Builders_commonKt.launch$default(this.this$0.scope, null, null, new SubscriptionRepository$loginListener$1$onLogin$1(this.this$0, null), 3, null);
            }

            @Override // com.myscript.nebo.sso.api.ISSOManager.OnLoginListener
            public void onLogout() {
                BuildersKt__Builders_commonKt.launch$default(this.this$0.scope, null, null, new SubscriptionRepository$loginListener$1$onLogout$1(this.this$0, null), 3, null);
            }
        };
        this.loginListener = r1;
        ssoManager.addLoginListener((ISSOManager.OnLoginListener) r1);
    }

    public /* synthetic */ SubscriptionRepository(Application application, Backend backend, ISSOManager iSSOManager, IMailServices iMailServices, UserData userData, NeboNetworkStateRepository neboNetworkStateRepository, SharedPreferences sharedPreferences, TechnicalLogger technicalLogger, boolean z, IPurchaseProvider iPurchaseProvider, IInstallReferralRepository iInstallReferralRepository, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, backend, iSSOManager, iMailServices, userData, neboNetworkStateRepository, sharedPreferences, technicalLogger, z, iPurchaseProvider, iInstallReferralRepository, (i & 2048) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public StateFlow<FreePeriodState> getFreePeriodState() {
        return this.freePeriodState;
    }

    private final long getFreeTrialStart() {
        return this.freeTrialStart.getValue((Object) this, $$delegatedProperties[0]).longValue();
    }

    private final void setFreeTrialStart(long j) {
        this.freeTrialStart.setValue(this, $$delegatedProperties[0], j);
    }

    private final long getOemOfferStart() {
        return this.oemOfferStart.getValue((Object) this, $$delegatedProperties[1]).longValue();
    }

    private final void setOemOfferStart(long j) {
        this.oemOfferStart.setValue(this, $$delegatedProperties[1], j);
    }

    private final int getOemOfferDuration() {
        return this.oemOfferDuration.getValue((Object) this, $$delegatedProperties[2]).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOemOfferDuration(int i) {
        this.oemOfferDuration.setValue(this, $$delegatedProperties[2], i);
    }

    private final long getRenewalOfferWindowStart() {
        return this.renewalOfferWindowStart.getValue((Object) this, $$delegatedProperties[3]).longValue();
    }

    private final void setRenewalOfferWindowStart(long j) {
        this.renewalOfferWindowStart.setValue(this, $$delegatedProperties[3], j);
    }

    private final long getRenewalOfferHandledExpiration() {
        return this.renewalOfferHandledExpiration.getValue((Object) this, $$delegatedProperties[4]).longValue();
    }

    private final void setRenewalOfferHandledExpiration(long j) {
        this.renewalOfferHandledExpiration.setValue(this, $$delegatedProperties[4], j);
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public StateFlow<RenewalOfferState> getRenewalOfferState() {
        return this.renewalOfferState;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public StateFlow<Boolean> isPreConfigured() {
        return this.isPreConfigured;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public StateFlow<Boolean> isConfigured() {
        return this.isConfigured;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public StateFlow<Boolean> getHasSubscribed() {
        return this.hasSubscribed;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public StateFlow<Boolean> isBillingUnavailable() {
        return this.isBillingUnavailable;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public ISubscriptionRepository.PlanType getPlanType() {
        return this.planType;
    }

    public void setPlanType(ISubscriptionRepository.PlanType planType) {
        this.planType = planType;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    /* JADX INFO: renamed from: getOfferings, reason: from getter */
    public Offerings get_offerings() {
        return this._offerings;
    }

    static /* synthetic */ boolean recordFailure$default(SubscriptionRepository subscriptionRepository, Object obj, String str, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        return subscriptionRepository.recordFailure(obj, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordFailure(Object result, String fallbackMessage, boolean clearsBillingUnavailableOnSuccess) {
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(result);
        if (thM14502exceptionOrNullimpl == null) {
            if (clearsBillingUnavailableOnSuccess) {
                this._isBillingUnavailable.setValue(false);
            }
            return true;
        }
        PurchaseException purchaseException = thM14502exceptionOrNullimpl instanceof PurchaseException ? (PurchaseException) thM14502exceptionOrNullimpl : null;
        if ((purchaseException != null ? purchaseException.getKind() : null) == PurchaseErrorKind.BillingUnavailable) {
            this._isBillingUnavailable.setValue(true);
            this._hasSubscribed.setValue(false);
            setPlanType(null);
        }
        TechnicalLogger technicalLogger = this.logger;
        RuntimeException runtimeException = thM14502exceptionOrNullimpl instanceof Exception ? (Exception) thM14502exceptionOrNullimpl : null;
        if (runtimeException == null) {
            runtimeException = new RuntimeException(fallbackMessage, thM14502exceptionOrNullimpl);
        }
        technicalLogger.logError(runtimeException);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateConfiguration(Continuation<? super Unit> continuation) throws Throwable {
        C67421 c67421;
        Mutex mutex;
        int i;
        Mutex mutex2;
        Throwable th;
        if (continuation instanceof C67421) {
            c67421 = (C67421) continuation;
            if ((c67421.label & Integer.MIN_VALUE) != 0) {
                c67421.label -= Integer.MIN_VALUE;
            } else {
                c67421 = new C67421(continuation);
            }
        }
        Object obj = c67421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c67421.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.dataSyncMutex;
                c67421.L$0 = mutex;
                c67421.I$0 = 0;
                c67421.label = 1;
                if (mutex.lock(null, c67421) != coroutine_suspended) {
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c67421.I$1;
                int i4 = c67421.I$0;
                mutex2 = (Mutex) c67421.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            i = c67421.I$0;
            Mutex mutex3 = (Mutex) c67421.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
            SubscriptionRepository$updateConfiguration$2$1 subscriptionRepository$updateConfiguration$2$1 = new SubscriptionRepository$updateConfiguration$2$1(this, null);
            c67421.L$0 = mutex;
            c67421.I$0 = i;
            c67421.I$1 = 0;
            c67421.label = 2;
            if (BuildersKt.withContext(coroutineDispatcher, subscriptionRepository$updateConfiguration$2$1, c67421) != coroutine_suspended) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ef, code lost:
    
        if (kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r3, r0) != r8) goto L81;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00b7: MOVE (r2 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:35:0x00b7 */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9 A[Catch: all -> 0x0203, TRY_LEAVE, TryCatch #1 {all -> 0x0203, blocks: (B:57:0x0122, B:59:0x0129, B:61:0x0131, B:63:0x0146, B:41:0x00d9, B:43:0x00e9, B:46:0x00ef, B:48:0x00f3, B:51:0x0102, B:53:0x010a), top: B:90:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ef A[Catch: all -> 0x0203, TRY_ENTER, TryCatch #1 {all -> 0x0203, blocks: (B:57:0x0122, B:59:0x0129, B:61:0x0131, B:63:0x0146, B:41:0x00d9, B:43:0x00e9, B:46:0x00ef, B:48:0x00f3, B:51:0x0102, B:53:0x010a), top: B:90:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0131 A[Catch: all -> 0x0203, TryCatch #1 {all -> 0x0203, blocks: (B:57:0x0122, B:59:0x0129, B:61:0x0131, B:63:0x0146, B:41:0x00d9, B:43:0x00e9, B:46:0x00ef, B:48:0x00f3, B:51:0x0102, B:53:0x010a), top: B:90:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.myscript.nebo.purchase.SubscriptionRepository] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v4 */
    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object preConfigure(Continuation<? super Unit> continuation) throws Throwable {
        C67401 c67401;
        Object obj;
        Mutex mutex;
        int i;
        int i2;
        int i3;
        String str;
        Object orCreateAppUserId;
        Mutex mutex2;
        Object value;
        Mutex mutex3;
        Object objMo13349syncPurchasesIoAF18A;
        int i4;
        int i5;
        String str2;
        Object obj2;
        Mutex mutex4;
        int i6;
        String str3;
        ?? r2 = "RC login failed(";
        if (continuation instanceof C67401) {
            c67401 = (C67401) continuation;
            if ((c67401.label & Integer.MIN_VALUE) != 0) {
                c67401.label -= Integer.MIN_VALUE;
            } else {
                c67401 = new C67401(continuation);
            }
        }
        C67401 c674012 = c67401;
        Object obj3 = c674012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (c674012.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj3);
                        mutex = this.dataSyncMutex;
                        c674012.L$0 = mutex;
                        c674012.I$0 = 0;
                        c674012.label = 1;
                        if (mutex.lock(null, c674012) != coroutine_suspended) {
                            i = 0;
                            try {
                                if (!isPreConfigured().getValue().booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    mutex.unlock(null);
                                    return unit;
                                }
                                if (!this.isFreemiumEnabled) {
                                    this._isPreConfigured.setValue(Boxing.boxBoolean(true));
                                    Unit unit2 = Unit.INSTANCE;
                                    mutex.unlock(null);
                                    return unit2;
                                }
                                if (this.userData.hasUser()) {
                                    Backend backend = this.backend;
                                    c674012.L$0 = mutex;
                                    c674012.I$0 = i;
                                    c674012.I$1 = 0;
                                    c674012.label = 2;
                                    orCreateAppUserId = backend.getOrCreateAppUserId(c674012);
                                    if (orCreateAppUserId != coroutine_suspended) {
                                        i2 = i;
                                        i3 = 0;
                                        str = (String) orCreateAppUserId;
                                        if (!this.purchaseProvider.isConfigured()) {
                                            IPurchaseProvider iPurchaseProvider = this.purchaseProvider;
                                            String string = this.context.getString(C6079R.string.revenuecat_public_sdk_key);
                                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                            iPurchaseProvider.configure(str, string);
                                        } else if (str != null) {
                                            IPurchaseProvider iPurchaseProvider2 = this.purchaseProvider;
                                            c674012.L$0 = mutex;
                                            c674012.L$1 = str;
                                            c674012.I$0 = i2;
                                            c674012.I$1 = i3;
                                            c674012.label = 3;
                                            Object objMo13347logingIAlus = iPurchaseProvider2.mo13347logingIAlus(str, c674012);
                                            if (objMo13347logingIAlus != coroutine_suspended) {
                                                mutex2 = mutex;
                                                value = objMo13347logingIAlus;
                                                int i7 = i3;
                                                int i8 = i2;
                                                String str4 = str;
                                                recordFailure$default(this, value, "RC login failed(" + str4 + ")", false, 4, null);
                                                mutex3 = mutex2;
                                                i3 = i7;
                                                i2 = i8;
                                                str = str4;
                                                IPurchaseProvider iPurchaseProvider3 = this.purchaseProvider;
                                                c674012.L$0 = mutex3;
                                                c674012.L$1 = str;
                                                c674012.I$0 = i2;
                                                c674012.I$1 = i3;
                                                c674012.label = 4;
                                                objMo13349syncPurchasesIoAF18A = iPurchaseProvider3.mo13349syncPurchasesIoAF18A(c674012);
                                                if (objMo13349syncPurchasesIoAF18A != coroutine_suspended) {
                                                    mutex2 = mutex3;
                                                    i4 = i3;
                                                    i5 = i2;
                                                    str2 = str;
                                                    Object obj4 = objMo13349syncPurchasesIoAF18A;
                                                    recordFailure$default(this, obj4, "Initial sync purchases failed(" + str2 + ")", false, 4, null);
                                                    c674012.L$0 = mutex2;
                                                    c674012.L$1 = str2;
                                                    c674012.L$2 = SpillingKt.nullOutSpilledVariable(obj4);
                                                    c674012.I$0 = i5;
                                                    c674012.I$1 = i4;
                                                    c674012.label = 5;
                                                    if (fetchSubscriptionStatus(c674012) != coroutine_suspended) {
                                                        obj2 = obj4;
                                                        mutex4 = mutex2;
                                                        i6 = i5;
                                                        str3 = str2;
                                                        SubscriptionRepository$preConfigure$2$1 subscriptionRepository$preConfigure$2$1 = new SubscriptionRepository$preConfigure$2$1(this, str3, null);
                                                        c674012.L$0 = mutex4;
                                                        c674012.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                                        c674012.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                                                        c674012.I$0 = i6;
                                                        c674012.I$1 = i4;
                                                        c674012.label = 6;
                                                        r2 = mutex4;
                                                    }
                                                }
                                            }
                                        }
                                        mutex3 = mutex;
                                        IPurchaseProvider iPurchaseProvider32 = this.purchaseProvider;
                                        c674012.L$0 = mutex3;
                                        c674012.L$1 = str;
                                        c674012.I$0 = i2;
                                        c674012.I$1 = i3;
                                        c674012.label = 4;
                                        objMo13349syncPurchasesIoAF18A = iPurchaseProvider32.mo13349syncPurchasesIoAF18A(c674012);
                                        if (objMo13349syncPurchasesIoAF18A != coroutine_suspended) {
                                        }
                                        break;
                                    }
                                } else {
                                    i2 = i;
                                    i3 = 0;
                                    str = null;
                                    if (!this.purchaseProvider.isConfigured()) {
                                    }
                                    mutex3 = mutex;
                                    IPurchaseProvider iPurchaseProvider322 = this.purchaseProvider;
                                    c674012.L$0 = mutex3;
                                    c674012.L$1 = str;
                                    c674012.I$0 = i2;
                                    c674012.I$1 = i3;
                                    c674012.label = 4;
                                    objMo13349syncPurchasesIoAF18A = iPurchaseProvider322.mo13349syncPurchasesIoAF18A(c674012);
                                    if (objMo13349syncPurchasesIoAF18A != coroutine_suspended) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                r2 = mutex;
                                r2.unlock(null);
                                throw th;
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        i = c674012.I$0;
                        Mutex mutex5 = (Mutex) c674012.L$0;
                        ResultKt.throwOnFailure(obj3);
                        mutex = mutex5;
                        if (!isPreConfigured().getValue().booleanValue()) {
                        }
                        break;
                    case 2:
                        i3 = c674012.I$1;
                        i2 = c674012.I$0;
                        Mutex mutex6 = (Mutex) c674012.L$0;
                        ResultKt.throwOnFailure(obj3);
                        orCreateAppUserId = obj3;
                        mutex = mutex6;
                        str = (String) orCreateAppUserId;
                        if (!this.purchaseProvider.isConfigured()) {
                        }
                        mutex3 = mutex;
                        IPurchaseProvider iPurchaseProvider3222 = this.purchaseProvider;
                        c674012.L$0 = mutex3;
                        c674012.L$1 = str;
                        c674012.I$0 = i2;
                        c674012.I$1 = i3;
                        c674012.label = 4;
                        objMo13349syncPurchasesIoAF18A = iPurchaseProvider3222.mo13349syncPurchasesIoAF18A(c674012);
                        if (objMo13349syncPurchasesIoAF18A != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 3:
                        i3 = c674012.I$1;
                        i2 = c674012.I$0;
                        str = (String) c674012.L$1;
                        mutex2 = (Mutex) c674012.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            value = ((Result) obj3).getValue();
                            int i72 = i3;
                            int i82 = i2;
                            String str42 = str;
                            recordFailure$default(this, value, "RC login failed(" + str42 + ")", false, 4, null);
                            mutex3 = mutex2;
                            i3 = i72;
                            i2 = i82;
                            str = str42;
                            IPurchaseProvider iPurchaseProvider32222 = this.purchaseProvider;
                            c674012.L$0 = mutex3;
                            c674012.L$1 = str;
                            c674012.I$0 = i2;
                            c674012.I$1 = i3;
                            c674012.label = 4;
                            objMo13349syncPurchasesIoAF18A = iPurchaseProvider32222.mo13349syncPurchasesIoAF18A(c674012);
                            if (objMo13349syncPurchasesIoAF18A != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        } catch (Throwable th2) {
                            th = th2;
                            r2 = mutex2;
                            r2.unlock(null);
                            throw th;
                        }
                    case 4:
                        int i9 = c674012.I$1;
                        int i10 = c674012.I$0;
                        String str5 = (String) c674012.L$1;
                        Mutex mutex7 = (Mutex) c674012.L$0;
                        ResultKt.throwOnFailure(obj3);
                        objMo13349syncPurchasesIoAF18A = ((Result) obj3).getValue();
                        i4 = i9;
                        i5 = i10;
                        str2 = str5;
                        mutex2 = mutex7;
                        Object obj42 = objMo13349syncPurchasesIoAF18A;
                        recordFailure$default(this, obj42, "Initial sync purchases failed(" + str2 + ")", false, 4, null);
                        c674012.L$0 = mutex2;
                        c674012.L$1 = str2;
                        c674012.L$2 = SpillingKt.nullOutSpilledVariable(obj42);
                        c674012.I$0 = i5;
                        c674012.I$1 = i4;
                        c674012.label = 5;
                        if (fetchSubscriptionStatus(c674012) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 5:
                        int i11 = c674012.I$1;
                        i6 = c674012.I$0;
                        obj2 = c674012.L$2;
                        str3 = (String) c674012.L$1;
                        Mutex mutex8 = (Mutex) c674012.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            i4 = i11;
                            mutex4 = mutex8;
                            SubscriptionRepository$preConfigure$2$1 subscriptionRepository$preConfigure$2$12 = new SubscriptionRepository$preConfigure$2$1(this, str3, null);
                            c674012.L$0 = mutex4;
                            c674012.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                            c674012.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                            c674012.I$0 = i6;
                            c674012.I$1 = i4;
                            c674012.label = 6;
                            r2 = mutex4;
                        } catch (Throwable th3) {
                            th = th3;
                            r2 = mutex8;
                            r2.unlock(null);
                            throw th;
                        }
                        break;
                    case 6:
                        int i12 = c674012.I$1;
                        int i13 = c674012.I$0;
                        Object obj5 = c674012.L$2;
                        Mutex mutex9 = (Mutex) c674012.L$0;
                        ResultKt.throwOnFailure(obj3);
                        r2 = mutex9;
                        this._isPreConfigured.setValue(Boxing.boxBoolean(true));
                        Unit unit3 = Unit.INSTANCE;
                        r2.unlock(null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th4) {
                th = th4;
                r2 = obj;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$configure$2 */
    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$configure$2", m1609f = "SubscriptionRepository.kt", m1610i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6}, m1611l = {PDFACompliance.e_PDFA3_3_2, PDFACompliance.e_PDFA3_5_5, PDFACompliance.e_PDFA3_5_7, 362, PDFACompliance.e_PDFA3_7_1, 428, 439}, m1612m = "invokeSuspend", m1613n = {"$this$coroutineScope", "customAttributes", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "hasInternetAccess", FirebaseAnalytics.Param.SUCCESS, "$this$coroutineScope", "customAttributes", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "referralResolution", "hasInternetAccess", FirebaseAnalytics.Param.SUCCESS, "shouldConfigure", "$this$coroutineScope", "customAttributes", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "referralResolution", "hasInternetAccess", FirebaseAnalytics.Param.SUCCESS, "shouldConfigure", "$this$coroutineScope", "customAttributes", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "referralResolution", "appId1", "hasInternetAccess", FirebaseAnalytics.Param.SUCCESS, "shouldConfigure", "$this$coroutineScope", "customAttributes", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "referralResolution", "appId1", "appId2", "hasInternetAccess", FirebaseAnalytics.Param.SUCCESS, "shouldConfigure", "$this$coroutineScope", "customAttributes", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "referralResolution", "$this$invokeSuspend_u24lambda_u240", "hasInternetAccess", FirebaseAnalytics.Param.SUCCESS, "shouldConfigure", "$i$a$-runCatching-SubscriptionRepository$configure$2$7", "$this$coroutineScope", "customAttributes", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "referralResolution", "hasInternetAccess", FirebaseAnalytics.Param.SUCCESS, "shouldConfigure"}, m1614nl = {333, PDFACompliance.e_PDFA3_5_7, 359, 362, PDFACompliance.e_PDFA3_7_1, 428, 440}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, m1616v = 2)
    static final class C67372 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appUserId;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67372(String str, Continuation<? super C67372> continuation) {
            super(2, continuation);
            this.$appUserId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C67372 c67372 = SubscriptionRepository.this.new C67372(this.$appUserId, continuation);
            c67372.L$0 = obj;
            return c67372;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67372) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0533  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0542  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0581  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x05a3  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x05d0  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x061c  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x063f  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x0641  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x0685  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x069a  */
        /* JADX WARN: Removed duplicated region for block: B:172:0x06b1  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0274  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x027a  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0293 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x02aa  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x02bc  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0355 A[PHI: r0 r3 r4 r5 r6 r7 r11 r17 r18 r19 r20
          0x0355: PHI (r0v24 int) = (r0v22 int), (r0v28 int) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r3v30 int) = (r3v28 int), (r3v32 int) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r4v21 ??) = (r4v73 ??), (r4v74 ??) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r5v21 kotlinx.coroutines.Deferred) = (r5v17 kotlinx.coroutines.Deferred), (r5v25 kotlinx.coroutines.Deferred) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r6v19 java.lang.String) = (r6v15 java.lang.String), (r6v23 java.lang.String) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r7v17 java.lang.String) = (r7v13 java.lang.String), (r7v20 java.lang.String) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r11v10 java.util.Map) = (r11v7 java.util.Map), (r11v14 java.util.Map) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r17v6 int) = (r17v4 int), (r17v7 int) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r18v7 java.lang.Object) = (r18v32 java.lang.Object), (r18v9 java.lang.Object) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r19v8 java.lang.Object) = (r19v24 java.lang.Object), (r19v9 java.lang.Object) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]
          0x0355: PHI (r20v7 java.lang.String) = (r20v5 java.lang.String), (r20v8 java.lang.String) binds: [B:55:0x0351, B:14:0x0107] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x039d  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x03a2  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x03a7  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x040d  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0412  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0426  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0446  */
        /* JADX WARN: Type inference failed for: r0v108 */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v84, types: [com.myscript.nebo.purchase.IPurchaseProvider] */
        /* JADX WARN: Type inference failed for: r14v12 */
        /* JADX WARN: Type inference failed for: r14v13 */
        /* JADX WARN: Type inference failed for: r14v14 */
        /* JADX WARN: Type inference failed for: r14v22 */
        /* JADX WARN: Type inference failed for: r14v23 */
        /* JADX WARN: Type inference failed for: r14v24 */
        /* JADX WARN: Type inference failed for: r14v6 */
        /* JADX WARN: Type inference failed for: r14v7 */
        /* JADX WARN: Type inference failed for: r14v8 */
        /* JADX WARN: Type inference failed for: r15v20 */
        /* JADX WARN: Type inference failed for: r15v21, types: [boolean] */
        /* JADX WARN: Type inference failed for: r15v22 */
        /* JADX WARN: Type inference failed for: r19v13 */
        /* JADX WARN: Type inference failed for: r19v18 */
        /* JADX WARN: Type inference failed for: r19v21 */
        /* JADX WARN: Type inference failed for: r19v22 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r3v52 */
        /* JADX WARN: Type inference failed for: r3v53, types: [T] */
        /* JADX WARN: Type inference failed for: r3v70 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v19, types: [int] */
        /* JADX WARN: Type inference failed for: r4v21, types: [int] */
        /* JADX WARN: Type inference failed for: r4v27 */
        /* JADX WARN: Type inference failed for: r4v28, types: [T] */
        /* JADX WARN: Type inference failed for: r4v72 */
        /* JADX WARN: Type inference failed for: r4v73 */
        /* JADX WARN: Type inference failed for: r4v74 */
        /* JADX WARN: Type inference failed for: r4v75 */
        /* JADX WARN: Type inference failed for: r5v27, types: [T] */
        /* JADX WARN: Type inference failed for: r5v28, types: [T] */
        /* JADX WARN: Type inference failed for: r5v46, types: [T] */
        /* JADX WARN: Type inference failed for: r5v51 */
        /* JADX WARN: Type inference failed for: r5v82 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v36, types: [int] */
        /* JADX WARN: Type inference failed for: r7v38 */
        /* JADX WARN: Type inference failed for: r7v43 */
        /* JADX WARN: Type inference failed for: r7v44, types: [int] */
        /* JADX WARN: Type inference failed for: r7v45 */
        /* JADX WARN: Type inference failed for: r7v46, types: [int] */
        /* JADX WARN: Type inference failed for: r7v47 */
        /* JADX WARN: Type inference failed for: r7v48 */
        /* JADX WARN: Type inference failed for: r7v49 */
        /* JADX WARN: Type inference failed for: r7v50 */
        /* JADX WARN: Type inference failed for: r9v15 */
        /* JADX WARN: Type inference failed for: r9v19 */
        /* JADX WARN: Type inference failed for: r9v20 */
        /* JADX WARN: Type inference failed for: r9v21 */
        /* JADX WARN: Type inference failed for: r9v23, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v27 */
        /* JADX WARN: Type inference failed for: r9v29 */
        /* JADX WARN: Type inference failed for: r9v30 */
        /* JADX WARN: Type inference failed for: r9v31 */
        /* JADX WARN: Type inference failed for: r9v38 */
        /* JADX WARN: Type inference failed for: r9v39 */
        /* JADX WARN: Type inference failed for: r9v40 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i;
            Continuation continuation;
            String str;
            Object objMo13347logingIAlus;
            int i2;
            String str2;
            Map map;
            String str3;
            int i3;
            Map map2;
            String str4;
            int i4;
            Object obj2;
            ?? r0;
            int i5;
            Object obj3;
            Object obj4;
            SubscriptionRepository subscriptionRepository;
            String str5;
            String str6;
            ?? r4;
            Deferred deferred;
            int i6;
            int i7;
            Object obj5;
            Object obj6;
            Map map3;
            Object obj7;
            Object obj8;
            ?? r42;
            String str7;
            ?? r9;
            Deferred deferred2;
            String str8;
            Map map4;
            int i8;
            int i9;
            String str9;
            ?? r7;
            int i10;
            ?? r14;
            Deferred deferred3;
            String str10;
            Ref.ObjectRef objectRef;
            Object value;
            Map map5;
            int i11;
            String str11;
            Ref.ObjectRef objectRef2;
            Object obj9;
            Object obj10;
            Ref.ObjectRef objectRef3;
            ?? r5;
            CharSequence charSequence;
            Map map6;
            int i12;
            Object obj11;
            String str12;
            ?? r92;
            Ref.ObjectRef objectRef4;
            Ref.ObjectRef objectRef5;
            Ref.ObjectRef objectRef6;
            Ref.ObjectRef objectRef7;
            Object obj12;
            Ref.ObjectRef objectRef8;
            Ref.ObjectRef objectRef9;
            Object obj13;
            Ref.ObjectRef objectRef10;
            int i13;
            Deferred deferred4;
            Object obj14;
            ?? r142;
            ?? r93;
            ?? r19;
            ?? r143;
            ?? r52;
            KeyValue keyValue;
            ?? r3;
            int i14;
            ?? r94;
            Object objM14499constructorimpl;
            ?? r72;
            Throwable thM14502exceptionOrNullimpl;
            String strInstallSource;
            Integer num;
            Object objMo13348syncAttributesAndOfferingsIfNeededIoAF18A;
            Object value2;
            int i15;
            ?? r2;
            Offering current;
            boolean z;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    i = 0;
                    ResultKt.throwOnFailure(obj);
                    if (!SubscriptionRepository.this.isFreemiumEnabled) {
                        SubscriptionRepository.this._isConfigured.setValue(Boxing.boxBoolean(true));
                        return Unit.INSTANCE;
                    }
                    boolean z2 = SubscriptionRepository.this.networkStateRepository.getNeboNetworkState().getValue() instanceof NeboNetworkState.Connected;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    String MANUFACTURER = Build.MANUFACTURER;
                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                    String upperCase = MANUFACTURER.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    String str13 = Build.MODEL;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(SubscriptionRepository.this, null);
                    Object obj15 = SubscriptionRepository.APP_NOTES_VALUE;
                    continuation = null;
                    str = SubscriptionRepository.APP_ID_2_KEY;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, anonymousClass1, 3, null);
                    if (!SubscriptionRepository.this.purchaseProvider.isConfigured()) {
                        IPurchaseProvider iPurchaseProvider = SubscriptionRepository.this.purchaseProvider;
                        String str14 = this.$appUserId;
                        String string = SubscriptionRepository.this.context.getString(C6079R.string.revenuecat_public_sdk_key);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        iPurchaseProvider.configure(str14, string);
                    } else if (this.$appUserId != null) {
                        this.L$0 = coroutineScope;
                        this.L$1 = linkedHashMap;
                        this.L$2 = upperCase;
                        this.L$3 = str13;
                        this.I$0 = z2 ? 1 : 0;
                        this.I$1 = 1;
                        this.label = 1;
                        objMo13347logingIAlus = SubscriptionRepository.this.purchaseProvider.mo13347logingIAlus(this.$appUserId, this);
                        if (objMo13347logingIAlus != coroutine_suspended) {
                            i2 = z2 ? 1 : 0;
                            str2 = str13;
                            map = linkedHashMap;
                            str3 = upperCase;
                            i3 = 1;
                            obj5 = obj15;
                            if (SubscriptionRepository.recordFailure$default(SubscriptionRepository.this, objMo13347logingIAlus, "RC login failed(" + this.$appUserId + ")", false, 4, null)) {
                                r0 = i2;
                                str4 = str2;
                                map2 = map;
                                i4 = i;
                                obj2 = obj5;
                            } else {
                                i4 = i3;
                                r0 = i2;
                                str4 = str2;
                                map2 = map;
                                obj2 = obj5;
                            }
                            i5 = (Intrinsics.areEqual(this.$appUserId, SubscriptionRepository.this.lastConfiguredAppUserId) && ((r0 == 0 && SubscriptionRepository.this.alreadyConfiguredWithoutInternet) || SubscriptionRepository.this.alreadyConfiguredWithInternet)) ? i : 1;
                            if (i5 == 0) {
                                String str15 = str3;
                                int i16 = i5;
                                obj3 = "";
                                Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new SubscriptionRepository$configure$2$referralResolution$1(SubscriptionRepository.this, continuation), 2, null);
                                SubscriptionRepository subscriptionRepository2 = SubscriptionRepository.this;
                                this.L$0 = coroutineScope;
                                this.L$1 = map2;
                                this.L$2 = str15;
                                this.L$3 = str4;
                                this.L$4 = deferredAsync$default;
                                this.L$5 = subscriptionRepository2;
                                this.I$0 = r0;
                                this.I$1 = i4;
                                this.I$2 = i16;
                                this.label = 2;
                                Object objMo13349syncPurchasesIoAF18A = subscriptionRepository2.purchaseProvider.mo13349syncPurchasesIoAF18A(this);
                                if (objMo13349syncPurchasesIoAF18A != coroutine_suspended) {
                                    obj4 = objMo13349syncPurchasesIoAF18A;
                                    subscriptionRepository = subscriptionRepository2;
                                    str5 = str4;
                                    str6 = str15;
                                    r4 = r0;
                                    deferred = deferredAsync$default;
                                    i6 = i4;
                                    i7 = i16;
                                    obj6 = obj2;
                                    map3 = map2;
                                    SubscriptionRepository.recordFailure$default(subscriptionRepository, obj4, "sync purchases failed(" + this.$appUserId + ")", false, 4, null);
                                    this.L$0 = coroutineScope;
                                    this.L$1 = map3;
                                    this.L$2 = str6;
                                    this.L$3 = str5;
                                    this.L$4 = deferred;
                                    this.L$5 = null;
                                    this.I$0 = r4;
                                    this.I$1 = i6;
                                    this.I$2 = i7;
                                    this.label = 3;
                                    r42 = r4;
                                    obj8 = obj6;
                                    obj7 = obj3;
                                    if (SubscriptionRepository.this.fetchSubscriptionStatus(this) != coroutine_suspended) {
                                        if (this.$appUserId != null || r42 == 0) {
                                            str7 = ")";
                                            r9 = obj7;
                                            deferred2 = deferred;
                                            str8 = str5;
                                            map4 = map3;
                                            i8 = i7;
                                            i9 = i6;
                                            str9 = str6;
                                            r7 = r42;
                                            IPurchaseProvider iPurchaseProvider2 = SubscriptionRepository.this.purchaseProvider;
                                            Pair[] pairArr = new Pair[2];
                                            pairArr[i] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, r9);
                                            pairArr[1] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, r9);
                                            iPurchaseProvider2.setAttributes(MapsKt.mapOf(pairArr));
                                            if (!StringsKt.isBlank(str9)) {
                                                map4.put(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, str9);
                                            }
                                            Intrinsics.checkNotNull(str8);
                                            if (!StringsKt.isBlank(str8)) {
                                                map4.put(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, str8);
                                            }
                                            try {
                                                Result.Companion companion = Result.INSTANCE;
                                                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                this.L$1 = map4;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(deferred2);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                this.L$6 = null;
                                                this.L$7 = null;
                                                this.I$0 = r7;
                                                this.I$1 = i9;
                                                this.I$2 = i8;
                                                i13 = i;
                                                try {
                                                    this.I$3 = i13;
                                                    this.label = 6;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    deferred4 = deferred2;
                                                    Result.Companion companion2 = Result.INSTANCE;
                                                    objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                                                    r72 = r7;
                                                    SubscriptionRepository subscriptionRepository3 = SubscriptionRepository.this;
                                                    thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                                                    if (thM14502exceptionOrNullimpl != null) {
                                                    }
                                                    strInstallSource = SubscriptionRepository.this.installReferralRepository.installSource();
                                                    if (strInstallSource != null) {
                                                    }
                                                    SubscriptionRepository.this.purchaseProvider.setAttributes(map4);
                                                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(map4);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(deferred4);
                                                    num = null;
                                                    this.L$5 = null;
                                                    this.L$6 = null;
                                                    this.L$7 = null;
                                                    this.I$0 = r72;
                                                    this.I$1 = i9;
                                                    this.I$2 = i8;
                                                    this.label = 7;
                                                    objMo13348syncAttributesAndOfferingsIfNeededIoAF18A = SubscriptionRepository.this.purchaseProvider.mo13348syncAttributesAndOfferingsIfNeededIoAF18A(this);
                                                    if (objMo13348syncAttributesAndOfferingsIfNeededIoAF18A != coroutine_suspended) {
                                                    }
                                                    return coroutine_suspended;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                i13 = i;
                                            }
                                            if (deferred2.await(this) != coroutine_suspended) {
                                                deferred4 = deferred2;
                                                r7 = r7;
                                                try {
                                                    objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
                                                    r72 = r7;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    Result.Companion companion22 = Result.INSTANCE;
                                                    objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                                                    r72 = r7;
                                                }
                                                SubscriptionRepository subscriptionRepository32 = SubscriptionRepository.this;
                                                thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                                                if (thM14502exceptionOrNullimpl != null) {
                                                    if (!(thM14502exceptionOrNullimpl instanceof CancellationException)) {
                                                        TechnicalLogger technicalLogger = subscriptionRepository32.logger;
                                                        RuntimeException runtimeException = thM14502exceptionOrNullimpl instanceof Exception ? (Exception) thM14502exceptionOrNullimpl : null;
                                                        if (runtimeException == null) {
                                                            runtimeException = new RuntimeException("install referral resolution failed", thM14502exceptionOrNullimpl);
                                                        }
                                                        technicalLogger.logError(runtimeException);
                                                    } else {
                                                        throw thM14502exceptionOrNullimpl;
                                                    }
                                                }
                                                strInstallSource = SubscriptionRepository.this.installReferralRepository.installSource();
                                                if (strInstallSource != null) {
                                                    map4.put(NeboUserProfileManager.CUSTOM_ATTRIBUTE_REFERRER_KEY, strInstallSource);
                                                }
                                                SubscriptionRepository.this.purchaseProvider.setAttributes(map4);
                                                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                this.L$1 = SpillingKt.nullOutSpilledVariable(map4);
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(deferred4);
                                                num = null;
                                                this.L$5 = null;
                                                this.L$6 = null;
                                                this.L$7 = null;
                                                this.I$0 = r72;
                                                this.I$1 = i9;
                                                this.I$2 = i8;
                                                this.label = 7;
                                                objMo13348syncAttributesAndOfferingsIfNeededIoAF18A = SubscriptionRepository.this.purchaseProvider.mo13348syncAttributesAndOfferingsIfNeededIoAF18A(this);
                                                if (objMo13348syncAttributesAndOfferingsIfNeededIoAF18A != coroutine_suspended) {
                                                    value2 = objMo13348syncAttributesAndOfferingsIfNeededIoAF18A;
                                                    i15 = i9;
                                                    r2 = r72;
                                                    if (SubscriptionRepository.this.recordFailure(value2, "failed attributes and offerings re-sync in configure(" + this.$appUserId + str7, true)) {
                                                        i15 = i13;
                                                    } else {
                                                        if (Result.m14505isFailureimpl(value2)) {
                                                            value2 = num;
                                                        }
                                                        Offerings offerings = (Offerings) value2;
                                                        Object obj16 = (offerings == null || (current = offerings.getCurrent()) == null) ? num : current.getMetadata().get(SubscriptionRepository.RC_OEM_OFFER_DURATION_KEY);
                                                        if (obj16 instanceof Integer) {
                                                            num = (Integer) obj16;
                                                        }
                                                        SubscriptionRepository.this.setOemOfferDuration(num != null ? num.intValue() : i13);
                                                        SubscriptionRepository.this._offerings = offerings;
                                                        SubscriptionRepository.this.publishRenewalOfferState();
                                                    }
                                                    SubscriptionRepository.this.lastConfiguredAppUserId = this.$appUserId;
                                                    if (i15 != 0) {
                                                        z = true;
                                                    } else if (r2 == 0) {
                                                        z = true;
                                                        SubscriptionRepository.this.alreadyConfiguredWithoutInternet = true;
                                                    } else {
                                                        z = true;
                                                        SubscriptionRepository.this.alreadyConfiguredWithoutInternet = true;
                                                        SubscriptionRepository.this.alreadyConfiguredWithInternet = true;
                                                    }
                                                    SubscriptionRepository.this._isConfigured.setValue(Boxing.boxBoolean((SubscriptionRepository.this.purchaseProvider.isConfigured() || i15 == 0) ? i13 : z));
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                            break;
                                        } else {
                                            Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
                                            this.L$0 = coroutineScope;
                                            this.L$1 = map3;
                                            this.L$2 = str6;
                                            this.L$3 = str5;
                                            this.L$4 = deferred;
                                            this.L$5 = objectRef11;
                                            this.L$6 = objectRef11;
                                            this.I$0 = r42;
                                            this.I$1 = i6;
                                            this.I$2 = i7;
                                            int i17 = i7;
                                            this.label = 4;
                                            Object objMo12808getValue0E7RQCE = SubscriptionRepository.this.backend.mo12808getValue0E7RQCE(SubscriptionRepository.APP_ID_1_KEY, CachePolicy.FromCacheIfAvailable, this);
                                            if (objMo12808getValue0E7RQCE != coroutine_suspended) {
                                                i10 = i6;
                                                r14 = r42;
                                                deferred3 = deferred;
                                                str10 = str6;
                                                objectRef = objectRef11;
                                                value = objMo12808getValue0E7RQCE;
                                                map5 = map3;
                                                i11 = i17;
                                                str11 = str5;
                                                objectRef2 = objectRef;
                                                obj10 = obj8;
                                                obj9 = obj7;
                                                if (Result.m14505isFailureimpl(value)) {
                                                    value = null;
                                                }
                                                KeyValue keyValue2 = (KeyValue) value;
                                                objectRef.element = keyValue2 == null ? keyValue2.getValue() : 0;
                                                objectRef3 = new Ref.ObjectRef();
                                                r5 = obj9;
                                                objectRef3.element = r5;
                                                charSequence = (CharSequence) objectRef2.element;
                                                if (charSequence != null || StringsKt.isBlank(charSequence)) {
                                                    map6 = map5;
                                                    i12 = i11;
                                                    obj11 = SubscriptionRepository.APP_ID_1_KEY;
                                                    str12 = str;
                                                    r92 = r5;
                                                    ?? r53 = obj10;
                                                    str7 = ")";
                                                    objectRef2.element = r53;
                                                    objectRef4 = objectRef2;
                                                    deferred2 = deferred3;
                                                    objectRef5 = objectRef3;
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass2(SubscriptionRepository.this, objectRef2, null), 2, null);
                                                } else {
                                                    ?? r192 = r5;
                                                    Object obj17 = obj10;
                                                    if (Intrinsics.areEqual(objectRef2.element, obj17)) {
                                                        i12 = i11;
                                                        r92 = r192;
                                                        map6 = map5;
                                                        obj11 = SubscriptionRepository.APP_ID_1_KEY;
                                                        str7 = ")";
                                                        str12 = str;
                                                        deferred2 = deferred3;
                                                        objectRef5 = objectRef3;
                                                        objectRef4 = objectRef2;
                                                    } else {
                                                        Backend backend = SubscriptionRepository.this.backend;
                                                        str7 = ")";
                                                        CachePolicy cachePolicy = CachePolicy.FromCacheIfAvailable;
                                                        obj12 = SubscriptionRepository.APP_ID_1_KEY;
                                                        this.L$0 = coroutineScope;
                                                        this.L$1 = map5;
                                                        this.L$2 = str10;
                                                        this.L$3 = str11;
                                                        this.L$4 = deferred3;
                                                        this.L$5 = objectRef2;
                                                        this.L$6 = objectRef3;
                                                        this.L$7 = objectRef3;
                                                        this.I$0 = r14 == true ? 1 : 0;
                                                        this.I$1 = i10;
                                                        this.I$2 = i11;
                                                        map6 = map5;
                                                        this.label = 5;
                                                        str12 = str;
                                                        Object objMo12808getValue0E7RQCE2 = backend.mo12808getValue0E7RQCE(str12, cachePolicy, this);
                                                        if (objMo12808getValue0E7RQCE2 != coroutine_suspended) {
                                                            deferred2 = deferred3;
                                                            objectRef8 = objectRef3;
                                                            objectRef9 = objectRef2;
                                                            obj13 = objMo12808getValue0E7RQCE2;
                                                            objectRef10 = objectRef8;
                                                            r52 = obj17;
                                                            r143 = r14;
                                                            r19 = r192;
                                                            if (Result.m14505isFailureimpl(obj13)) {
                                                                obj13 = null;
                                                            }
                                                            keyValue = (KeyValue) obj13;
                                                            if (keyValue != null) {
                                                                String value3 = keyValue.getValue();
                                                                r3 = value3;
                                                                if (value3 == null) {
                                                                }
                                                                objectRef10.element = r3;
                                                                if (StringsKt.isBlank((CharSequence) objectRef8.element)) {
                                                                    objectRef8.element = r52;
                                                                    i14 = i11;
                                                                    r94 = r19;
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass3(SubscriptionRepository.this, objectRef8, null), 2, null);
                                                                } else {
                                                                    i14 = i11;
                                                                    r94 = r19;
                                                                }
                                                                i12 = i14;
                                                                objectRef7 = objectRef8;
                                                                objectRef6 = objectRef9;
                                                                r93 = r94;
                                                                r142 = r143;
                                                                obj14 = obj12;
                                                                Map map7 = map6;
                                                                map7.put(obj14, objectRef6.element);
                                                                map7.put(str12, objectRef7.element);
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass4(SubscriptionRepository.this, str10, null), 2, null);
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass5(SubscriptionRepository.this, null), 2, null);
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass6(SubscriptionRepository.this, this.$appUserId, null), 2, null);
                                                                str8 = str11;
                                                                i9 = i10;
                                                                r7 = r142;
                                                                str9 = str10;
                                                                i8 = i12;
                                                                map4 = map7;
                                                                r9 = r93;
                                                                IPurchaseProvider iPurchaseProvider22 = SubscriptionRepository.this.purchaseProvider;
                                                                Pair[] pairArr2 = new Pair[2];
                                                                pairArr2[i] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, r9);
                                                                pairArr2[1] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, r9);
                                                                iPurchaseProvider22.setAttributes(MapsKt.mapOf(pairArr2));
                                                                if (!StringsKt.isBlank(str9)) {
                                                                }
                                                                Intrinsics.checkNotNull(str8);
                                                                if (!StringsKt.isBlank(str8)) {
                                                                }
                                                                Result.Companion companion3 = Result.INSTANCE;
                                                                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                                this.L$1 = map4;
                                                                this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                                                                this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                                                                this.L$4 = SpillingKt.nullOutSpilledVariable(deferred2);
                                                                this.L$5 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                                this.L$6 = null;
                                                                this.L$7 = null;
                                                                this.I$0 = r7;
                                                                this.I$1 = i9;
                                                                this.I$2 = i8;
                                                                i13 = i;
                                                                this.I$3 = i13;
                                                                this.label = 6;
                                                                if (deferred2.await(this) != coroutine_suspended) {
                                                                }
                                                            }
                                                            r3 = r19;
                                                            objectRef10.element = r3;
                                                            if (StringsKt.isBlank((CharSequence) objectRef8.element)) {
                                                            }
                                                            i12 = i14;
                                                            objectRef7 = objectRef8;
                                                            objectRef6 = objectRef9;
                                                            r93 = r94;
                                                            r142 = r143;
                                                            obj14 = obj12;
                                                            Map map72 = map6;
                                                            map72.put(obj14, objectRef6.element);
                                                            map72.put(str12, objectRef7.element);
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass4(SubscriptionRepository.this, str10, null), 2, null);
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass5(SubscriptionRepository.this, null), 2, null);
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass6(SubscriptionRepository.this, this.$appUserId, null), 2, null);
                                                            str8 = str11;
                                                            i9 = i10;
                                                            r7 = r142;
                                                            str9 = str10;
                                                            i8 = i12;
                                                            map4 = map72;
                                                            r9 = r93;
                                                            IPurchaseProvider iPurchaseProvider222 = SubscriptionRepository.this.purchaseProvider;
                                                            Pair[] pairArr22 = new Pair[2];
                                                            pairArr22[i] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, r9);
                                                            pairArr22[1] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, r9);
                                                            iPurchaseProvider222.setAttributes(MapsKt.mapOf(pairArr22));
                                                            if (!StringsKt.isBlank(str9)) {
                                                            }
                                                            Intrinsics.checkNotNull(str8);
                                                            if (!StringsKt.isBlank(str8)) {
                                                            }
                                                            Result.Companion companion32 = Result.INSTANCE;
                                                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                            this.L$1 = map4;
                                                            this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                                                            this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                                                            this.L$4 = SpillingKt.nullOutSpilledVariable(deferred2);
                                                            this.L$5 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                            this.L$6 = null;
                                                            this.L$7 = null;
                                                            this.I$0 = r7;
                                                            this.I$1 = i9;
                                                            this.I$2 = i8;
                                                            i13 = i;
                                                            this.I$3 = i13;
                                                            this.label = 6;
                                                            if (deferred2.await(this) != coroutine_suspended) {
                                                            }
                                                        }
                                                    }
                                                }
                                                objectRef6 = objectRef4;
                                                objectRef7 = objectRef5;
                                                r93 = r92;
                                                r142 = r14;
                                                obj14 = obj11;
                                                Map map722 = map6;
                                                map722.put(obj14, objectRef6.element);
                                                map722.put(str12, objectRef7.element);
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass4(SubscriptionRepository.this, str10, null), 2, null);
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass5(SubscriptionRepository.this, null), 2, null);
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass6(SubscriptionRepository.this, this.$appUserId, null), 2, null);
                                                str8 = str11;
                                                i9 = i10;
                                                r7 = r142;
                                                str9 = str10;
                                                i8 = i12;
                                                map4 = map722;
                                                r9 = r93;
                                                IPurchaseProvider iPurchaseProvider2222 = SubscriptionRepository.this.purchaseProvider;
                                                Pair[] pairArr222 = new Pair[2];
                                                pairArr222[i] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, r9);
                                                pairArr222[1] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, r9);
                                                iPurchaseProvider2222.setAttributes(MapsKt.mapOf(pairArr222));
                                                if (!StringsKt.isBlank(str9)) {
                                                }
                                                Intrinsics.checkNotNull(str8);
                                                if (!StringsKt.isBlank(str8)) {
                                                }
                                                Result.Companion companion322 = Result.INSTANCE;
                                                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                this.L$1 = map4;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(deferred2);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                this.L$6 = null;
                                                this.L$7 = null;
                                                this.I$0 = r7;
                                                this.I$1 = i9;
                                                this.I$2 = i8;
                                                i13 = i;
                                                this.I$3 = i13;
                                                this.label = 6;
                                                if (deferred2.await(this) != coroutine_suspended) {
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                SubscriptionRepository.this._isConfigured.setValue(Boxing.boxBoolean(true));
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    }
                    str3 = upperCase;
                    map2 = linkedHashMap;
                    str4 = str13;
                    i4 = 1;
                    r0 = z2;
                    obj2 = obj15;
                    if (Intrinsics.areEqual(this.$appUserId, SubscriptionRepository.this.lastConfiguredAppUserId)) {
                        if (i5 == 0) {
                        }
                    }
                    if (i5 == 0) {
                    }
                    break;
                case 1:
                    i = 0;
                    i3 = this.I$1;
                    i2 = this.I$0;
                    str2 = (String) this.L$3;
                    str3 = (String) this.L$2;
                    map = (Map) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    objMo13347logingIAlus = ((Result) obj).getValue();
                    str = SubscriptionRepository.APP_ID_2_KEY;
                    obj5 = SubscriptionRepository.APP_NOTES_VALUE;
                    continuation = null;
                    if (SubscriptionRepository.recordFailure$default(SubscriptionRepository.this, objMo13347logingIAlus, "RC login failed(" + this.$appUserId + ")", false, 4, null)) {
                    }
                    if (Intrinsics.areEqual(this.$appUserId, SubscriptionRepository.this.lastConfiguredAppUserId)) {
                    }
                    if (i5 == 0) {
                    }
                    break;
                case 2:
                    i = 0;
                    i7 = this.I$2;
                    i6 = this.I$1;
                    int i18 = this.I$0;
                    SubscriptionRepository subscriptionRepository4 = (SubscriptionRepository) this.L$5;
                    Deferred deferred5 = (Deferred) this.L$4;
                    String str16 = (String) this.L$3;
                    String str17 = (String) this.L$2;
                    map2 = (Map) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    Object value4 = ((Result) obj).getValue();
                    subscriptionRepository = subscriptionRepository4;
                    deferred = deferred5;
                    str5 = str16;
                    str = SubscriptionRepository.APP_ID_2_KEY;
                    str6 = str17;
                    obj6 = SubscriptionRepository.APP_NOTES_VALUE;
                    obj4 = value4;
                    obj3 = "";
                    r4 = i18;
                    map3 = map2;
                    SubscriptionRepository.recordFailure$default(subscriptionRepository, obj4, "sync purchases failed(" + this.$appUserId + ")", false, 4, null);
                    this.L$0 = coroutineScope;
                    this.L$1 = map3;
                    this.L$2 = str6;
                    this.L$3 = str5;
                    this.L$4 = deferred;
                    this.L$5 = null;
                    this.I$0 = r4;
                    this.I$1 = i6;
                    this.I$2 = i7;
                    this.label = 3;
                    r42 = r4;
                    obj8 = obj6;
                    obj7 = obj3;
                    if (SubscriptionRepository.this.fetchSubscriptionStatus(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 3:
                    i = 0;
                    i7 = this.I$2;
                    i6 = this.I$1;
                    int i19 = this.I$0;
                    deferred = (Deferred) this.L$4;
                    str5 = (String) this.L$3;
                    str6 = (String) this.L$2;
                    map3 = (Map) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    str = SubscriptionRepository.APP_ID_2_KEY;
                    obj8 = SubscriptionRepository.APP_NOTES_VALUE;
                    obj7 = "";
                    r42 = i19;
                    if (this.$appUserId != null) {
                    }
                    str7 = ")";
                    r9 = obj7;
                    deferred2 = deferred;
                    str8 = str5;
                    map4 = map3;
                    i8 = i7;
                    i9 = i6;
                    str9 = str6;
                    r7 = r42;
                    IPurchaseProvider iPurchaseProvider22222 = SubscriptionRepository.this.purchaseProvider;
                    Pair[] pairArr2222 = new Pair[2];
                    pairArr2222[i] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, r9);
                    pairArr2222[1] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, r9);
                    iPurchaseProvider22222.setAttributes(MapsKt.mapOf(pairArr2222));
                    if (!StringsKt.isBlank(str9)) {
                    }
                    Intrinsics.checkNotNull(str8);
                    if (!StringsKt.isBlank(str8)) {
                    }
                    Result.Companion companion3222 = Result.INSTANCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = map4;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(deferred2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$6 = null;
                    this.L$7 = null;
                    this.I$0 = r7;
                    this.I$1 = i9;
                    this.I$2 = i8;
                    i13 = i;
                    this.I$3 = i13;
                    this.label = 6;
                    if (deferred2.await(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 4:
                    i = 0;
                    int i20 = this.I$2;
                    int i21 = this.I$1;
                    int i22 = this.I$0;
                    objectRef = (Ref.ObjectRef) this.L$6;
                    objectRef2 = (Ref.ObjectRef) this.L$5;
                    Deferred deferred6 = (Deferred) this.L$4;
                    str11 = (String) this.L$3;
                    str10 = (String) this.L$2;
                    map5 = (Map) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    r14 = i22;
                    value = ((Result) obj).getValue();
                    str = SubscriptionRepository.APP_ID_2_KEY;
                    i11 = i20;
                    obj9 = "";
                    obj10 = SubscriptionRepository.APP_NOTES_VALUE;
                    i10 = i21;
                    deferred3 = deferred6;
                    if (Result.m14505isFailureimpl(value)) {
                    }
                    KeyValue keyValue22 = (KeyValue) value;
                    objectRef.element = keyValue22 == null ? keyValue22.getValue() : 0;
                    objectRef3 = new Ref.ObjectRef();
                    r5 = obj9;
                    objectRef3.element = r5;
                    charSequence = (CharSequence) objectRef2.element;
                    if (charSequence != null) {
                        break;
                    }
                    map6 = map5;
                    i12 = i11;
                    obj11 = SubscriptionRepository.APP_ID_1_KEY;
                    str12 = str;
                    r92 = r5;
                    ?? r532 = obj10;
                    str7 = ")";
                    objectRef2.element = r532;
                    objectRef4 = objectRef2;
                    deferred2 = deferred3;
                    objectRef5 = objectRef3;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass2(SubscriptionRepository.this, objectRef2, null), 2, null);
                    objectRef6 = objectRef4;
                    objectRef7 = objectRef5;
                    r93 = r92;
                    r142 = r14;
                    obj14 = obj11;
                    Map map7222 = map6;
                    map7222.put(obj14, objectRef6.element);
                    map7222.put(str12, objectRef7.element);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass4(SubscriptionRepository.this, str10, null), 2, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass5(SubscriptionRepository.this, null), 2, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass6(SubscriptionRepository.this, this.$appUserId, null), 2, null);
                    str8 = str11;
                    i9 = i10;
                    r7 = r142;
                    str9 = str10;
                    i8 = i12;
                    map4 = map7222;
                    r9 = r93;
                    IPurchaseProvider iPurchaseProvider222222 = SubscriptionRepository.this.purchaseProvider;
                    Pair[] pairArr22222 = new Pair[2];
                    pairArr22222[i] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, r9);
                    pairArr22222[1] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, r9);
                    iPurchaseProvider222222.setAttributes(MapsKt.mapOf(pairArr22222));
                    if (!StringsKt.isBlank(str9)) {
                    }
                    Intrinsics.checkNotNull(str8);
                    if (!StringsKt.isBlank(str8)) {
                    }
                    Result.Companion companion32222 = Result.INSTANCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = map4;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(deferred2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$6 = null;
                    this.L$7 = null;
                    this.I$0 = r7;
                    this.I$1 = i9;
                    this.I$2 = i8;
                    i13 = i;
                    this.I$3 = i13;
                    this.label = 6;
                    if (deferred2.await(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 5:
                    int i23 = this.I$2;
                    int i24 = this.I$1;
                    int i25 = this.I$0;
                    objectRef10 = (Ref.ObjectRef) this.L$7;
                    Ref.ObjectRef objectRef12 = (Ref.ObjectRef) this.L$6;
                    i = 0;
                    Ref.ObjectRef objectRef13 = (Ref.ObjectRef) this.L$5;
                    Deferred deferred7 = (Deferred) this.L$4;
                    String str18 = (String) this.L$3;
                    String str19 = (String) this.L$2;
                    Map map8 = (Map) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    Object value5 = ((Result) obj).getValue();
                    i10 = i24;
                    r52 = SubscriptionRepository.APP_NOTES_VALUE;
                    objectRef9 = objectRef13;
                    str10 = str19;
                    obj12 = SubscriptionRepository.APP_ID_1_KEY;
                    str7 = ")";
                    objectRef8 = objectRef12;
                    deferred2 = deferred7;
                    str11 = str18;
                    obj13 = value5;
                    map6 = map8;
                    str12 = SubscriptionRepository.APP_ID_2_KEY;
                    i11 = i23;
                    r19 = "";
                    r143 = i25;
                    if (Result.m14505isFailureimpl(obj13)) {
                    }
                    keyValue = (KeyValue) obj13;
                    if (keyValue != null) {
                    }
                    r3 = r19;
                    objectRef10.element = r3;
                    if (StringsKt.isBlank((CharSequence) objectRef8.element)) {
                    }
                    i12 = i14;
                    objectRef7 = objectRef8;
                    objectRef6 = objectRef9;
                    r93 = r94;
                    r142 = r143;
                    obj14 = obj12;
                    Map map72222 = map6;
                    map72222.put(obj14, objectRef6.element);
                    map72222.put(str12, objectRef7.element);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass4(SubscriptionRepository.this, str10, null), 2, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass5(SubscriptionRepository.this, null), 2, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, SubscriptionRepository.this.ioDispatcher, null, new AnonymousClass6(SubscriptionRepository.this, this.$appUserId, null), 2, null);
                    str8 = str11;
                    i9 = i10;
                    r7 = r142;
                    str9 = str10;
                    i8 = i12;
                    map4 = map72222;
                    r9 = r93;
                    IPurchaseProvider iPurchaseProvider2222222 = SubscriptionRepository.this.purchaseProvider;
                    Pair[] pairArr222222 = new Pair[2];
                    pairArr222222[i] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, r9);
                    pairArr222222[1] = TuplesKt.m1606to(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, r9);
                    iPurchaseProvider2222222.setAttributes(MapsKt.mapOf(pairArr222222));
                    if (!StringsKt.isBlank(str9)) {
                    }
                    Intrinsics.checkNotNull(str8);
                    if (!StringsKt.isBlank(str8)) {
                    }
                    Result.Companion companion322222 = Result.INSTANCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = map4;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(deferred2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$6 = null;
                    this.L$7 = null;
                    this.I$0 = r7;
                    this.I$1 = i9;
                    this.I$2 = i8;
                    i13 = i;
                    this.I$3 = i13;
                    this.label = 6;
                    if (deferred2.await(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 6:
                    i8 = this.I$2;
                    i9 = this.I$1;
                    r7 = this.I$0;
                    deferred4 = (Deferred) this.L$4;
                    str8 = (String) this.L$3;
                    str9 = (String) this.L$2;
                    map4 = (Map) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        str7 = ")";
                        i13 = 0;
                        r7 = r7;
                        objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
                        r72 = r7;
                        break;
                    } catch (Throwable th4) {
                        th = th4;
                        str7 = ")";
                        i13 = 0;
                        Result.Companion companion222 = Result.INSTANCE;
                        objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                        r72 = r7;
                        SubscriptionRepository subscriptionRepository322 = SubscriptionRepository.this;
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                        }
                        strInstallSource = SubscriptionRepository.this.installReferralRepository.installSource();
                        if (strInstallSource != null) {
                        }
                        SubscriptionRepository.this.purchaseProvider.setAttributes(map4);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(map4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(deferred4);
                        num = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = null;
                        this.I$0 = r72;
                        this.I$1 = i9;
                        this.I$2 = i8;
                        this.label = 7;
                        objMo13348syncAttributesAndOfferingsIfNeededIoAF18A = SubscriptionRepository.this.purchaseProvider.mo13348syncAttributesAndOfferingsIfNeededIoAF18A(this);
                        if (objMo13348syncAttributesAndOfferingsIfNeededIoAF18A != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    SubscriptionRepository subscriptionRepository3222 = SubscriptionRepository.this;
                    thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                    if (thM14502exceptionOrNullimpl != null) {
                    }
                    strInstallSource = SubscriptionRepository.this.installReferralRepository.installSource();
                    if (strInstallSource != null) {
                    }
                    SubscriptionRepository.this.purchaseProvider.setAttributes(map4);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(map4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(deferred4);
                    num = null;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.L$7 = null;
                    this.I$0 = r72;
                    this.I$1 = i9;
                    this.I$2 = i8;
                    this.label = 7;
                    objMo13348syncAttributesAndOfferingsIfNeededIoAF18A = SubscriptionRepository.this.purchaseProvider.mo13348syncAttributesAndOfferingsIfNeededIoAF18A(this);
                    if (objMo13348syncAttributesAndOfferingsIfNeededIoAF18A != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 7:
                    i15 = this.I$1;
                    int i26 = this.I$0;
                    ResultKt.throwOnFailure(obj);
                    value2 = ((Result) obj).getValue();
                    str7 = ")";
                    i13 = 0;
                    num = null;
                    r2 = i26;
                    if (SubscriptionRepository.this.recordFailure(value2, "failed attributes and offerings re-sync in configure(" + this.$appUserId + str7, true)) {
                    }
                    SubscriptionRepository.this.lastConfiguredAppUserId = this.$appUserId;
                    if (i15 != 0) {
                    }
                    SubscriptionRepository.this._isConfigured.setValue(Boxing.boxBoolean((SubscriptionRepository.this.purchaseProvider.isConfigured() || i15 == 0) ? i13 : z));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$configure$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SubscriptionRepository.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$configure$2$1", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_2_3}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA3_2_4}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SubscriptionRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SubscriptionRepository subscriptionRepository, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = subscriptionRepository;
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
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.checkFreePeriodStatus(this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$configure$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: SubscriptionRepository.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$configure$2$2", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {368}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {369}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<String> $appId1;
            int label;
            final /* synthetic */ SubscriptionRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(SubscriptionRepository subscriptionRepository, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = subscriptionRepository;
                this.$appId1 = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$appId1, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (Backend.m12807setValueyxL6bBk$default(this.this$0.backend, SubscriptionRepository.APP_ID_1_KEY, this.$appId1.element, true, false, this, 8, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$configure$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: SubscriptionRepository.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$configure$2$3", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {375}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {376}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<String> $appId2;
            int label;
            final /* synthetic */ SubscriptionRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(SubscriptionRepository subscriptionRepository, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = subscriptionRepository;
                this.$appId2 = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$appId2, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (Backend.m12807setValueyxL6bBk$default(this.this$0.backend, SubscriptionRepository.APP_ID_2_KEY, this.$appId2.element, true, false, this, 8, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$configure$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: SubscriptionRepository.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$configure$2$4", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {385}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {386}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $manufacturer;
            int label;
            final /* synthetic */ SubscriptionRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(SubscriptionRepository subscriptionRepository, String str, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.this$0 = subscriptionRepository;
                this.$manufacturer = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.this$0, this.$manufacturer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (Backend.m12807setValueyxL6bBk$default(this.this$0.backend, NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, this.$manufacturer, false, false, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$configure$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: SubscriptionRepository.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$configure$2$5", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {388}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {389}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SubscriptionRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(SubscriptionRepository subscriptionRepository, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.this$0 = subscriptionRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Backend backend = this.this$0.backend;
                    String MODEL = Build.MODEL;
                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                    this.label = 1;
                    if (Backend.m12807setValueyxL6bBk$default(backend, NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, MODEL, false, false, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$configure$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: SubscriptionRepository.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$configure$2$6", m1609f = "SubscriptionRepository.kt", m1610i = {0}, m1611l = {395}, m1612m = "invokeSuspend", m1613n = {"mailServicesAlreadyLinked"}, m1614nl = {396}, m1615s = {"Z$0"}, m1616v = 2)
        static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $appUserId;
            boolean Z$0;
            int label;
            final /* synthetic */ SubscriptionRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(SubscriptionRepository subscriptionRepository, String str, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.this$0 = subscriptionRepository;
                this.$appUserId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.this$0, this.$appUserId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                } catch (Exception e) {
                    this.this$0.logger.logError(e);
                }
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean z = this.this$0.sharedPreferences.getBoolean(SubscriptionRepository.PREF_MAILSERVICES_LINK_RC_DONE_KEY, false);
                    if (!z) {
                        this.Z$0 = z;
                        this.label = 1;
                        obj = this.this$0.mailServices.linkToRevenueCat(this.$appUserId, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    SharedPreferences.Editor editorEdit = this.this$0.sharedPreferences.edit();
                    editorEdit.putBoolean(SubscriptionRepository.PREF_MAILSERVICES_LINK_RC_DONE_KEY, true);
                    editorEdit.apply();
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object configure(String str, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C67372(str, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public Object startFreeTrial(Continuation<? super Unit> continuation) {
        if (getFreeTrialStart() <= 0) {
            setFreeTrialStart(System.currentTimeMillis());
        }
        Object objCheckFreePeriodStatus = checkFreePeriodStatus(continuation);
        return objCheckFreePeriodStatus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCheckFreePeriodStatus : Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public Object startOEMOffer(Continuation<? super Unit> continuation) {
        if (getOemOfferStart() <= 0) {
            setOemOfferStart(System.currentTimeMillis());
        }
        Object objCheckFreePeriodStatus = checkFreePeriodStatus(continuation);
        return objCheckFreePeriodStatus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCheckFreePeriodStatus : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008c, code lost:
    
        if (r0 == r3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b7  */
    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object checkFreePeriodStatus(Continuation<? super Unit> continuation) {
        C67341 c67341;
        Ref.LongRef longRef;
        long oemOfferStart;
        int i;
        long jCurrentTimeMillis;
        FreePeriodType freePeriodType;
        FreePeriodType freePeriodType2;
        FreePeriodType freePeriodType3;
        long j;
        Ref.LongRef longRef2;
        String value;
        int oemOfferDuration;
        boolean z;
        FreePeriodStatus freePeriodStatus;
        long jM15951getZEROUwyO8pc;
        if (continuation instanceof C67341) {
            c67341 = (C67341) continuation;
            if ((c67341.label & Integer.MIN_VALUE) != 0) {
                c67341.label -= Integer.MIN_VALUE;
            } else {
                c67341 = new C67341(continuation);
            }
        }
        Object objWithContext = c67341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c67341.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            longRef = new Ref.LongRef();
            longRef.element = getFreeTrialStart();
            oemOfferStart = getOemOfferStart();
            i = longRef.element > 0 ? 1 : 0;
            if (i == 0) {
                CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
                C67352 c67352 = new C67352(null);
                c67341.L$0 = longRef;
                c67341.J$0 = oemOfferStart;
                c67341.I$0 = i;
                c67341.label = 1;
                objWithContext = BuildersKt.withContext(coroutineDispatcher, c67352, c67341);
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                if (longRef.element > jCurrentTimeMillis) {
                    setFreeTrialStart(jCurrentTimeMillis);
                    longRef.element = jCurrentTimeMillis;
                }
                if (oemOfferStart > jCurrentTimeMillis) {
                    setOemOfferStart(jCurrentTimeMillis);
                    oemOfferStart = jCurrentTimeMillis;
                }
                if (oemOfferStart <= 0) {
                    freePeriodType = FreePeriodType.OEMOffer;
                } else {
                    freePeriodType = longRef.element > 0 ? FreePeriodType.Trial : FreePeriodType.None;
                }
                if (freePeriodType != FreePeriodType.None) {
                    this._freePeriodState.setValue(new FreePeriodState(FreePeriodStatus.NotStarted, FreePeriodType.None, 0L, 0L, 12, null));
                    return Unit.INSTANCE;
                }
                if (freePeriodType == FreePeriodType.OEMOffer && getOemOfferDuration() < 0) {
                    SubscriptionRepository$checkFreePeriodStatus$configured$1 subscriptionRepository$checkFreePeriodStatus$configured$1 = new SubscriptionRepository$checkFreePeriodStatus$configured$1(this, null);
                    c67341.L$0 = longRef;
                    c67341.L$1 = freePeriodType;
                    c67341.J$0 = oemOfferStart;
                    c67341.I$0 = i;
                    c67341.J$1 = jCurrentTimeMillis;
                    c67341.label = 2;
                    Object objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(10000L, subscriptionRepository$checkFreePeriodStatus$configured$1, c67341);
                    if (objWithTimeoutOrNull != coroutine_suspended) {
                        freePeriodType3 = freePeriodType;
                        objWithContext = objWithTimeoutOrNull;
                        j = oemOfferStart;
                        longRef2 = longRef;
                        if (((Boolean) objWithContext) != null) {
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    freePeriodType2 = freePeriodType;
                    if (freePeriodType2 != FreePeriodType.OEMOffer) {
                    }
                    if (freePeriodType2 != FreePeriodType.OEMOffer) {
                    }
                    long duration = DurationKt.toDuration(oemOfferDuration, DurationUnit.DAYS);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    long jM15867getInWholeMillisecondsimpl = oemOfferStart + Duration.m15867getInWholeMillisecondsimpl(duration);
                    long j2 = jM15867getInWholeMillisecondsimpl - jCurrentTimeMillis2;
                    if (jCurrentTimeMillis2 < jM15867getInWholeMillisecondsimpl) {
                    }
                    if (!z) {
                    }
                    FreePeriodStatus freePeriodStatus2 = freePeriodStatus;
                    if (!z) {
                    }
                    this._freePeriodState.setValue(new FreePeriodState(freePeriodStatus2, freePeriodType2, jM15951getZEROUwyO8pc, duration, null));
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = c67341.J$1;
            int i3 = c67341.I$0;
            j = c67341.J$0;
            freePeriodType3 = (FreePeriodType) c67341.L$1;
            longRef2 = (Ref.LongRef) c67341.L$0;
            ResultKt.throwOnFailure(objWithContext);
            if (((Boolean) objWithContext) != null || getOemOfferDuration() < 0) {
                return Unit.INSTANCE;
            }
            longRef = longRef2;
            oemOfferStart = j;
            freePeriodType2 = freePeriodType3;
            if (freePeriodType2 != FreePeriodType.OEMOffer) {
                oemOfferStart = longRef.element;
            }
            if (freePeriodType2 != FreePeriodType.OEMOffer) {
                Duration.Companion companion = Duration.INSTANCE;
                oemOfferDuration = getOemOfferDuration();
            } else {
                Duration.Companion companion2 = Duration.INSTANCE;
                oemOfferDuration = 7;
            }
            long duration2 = DurationKt.toDuration(oemOfferDuration, DurationUnit.DAYS);
            long jCurrentTimeMillis22 = System.currentTimeMillis();
            long jM15867getInWholeMillisecondsimpl2 = oemOfferStart + Duration.m15867getInWholeMillisecondsimpl(duration2);
            long j22 = jM15867getInWholeMillisecondsimpl2 - jCurrentTimeMillis22;
            z = jCurrentTimeMillis22 < jM15867getInWholeMillisecondsimpl2;
            if (!z) {
                freePeriodStatus = FreePeriodStatus.Active;
            } else {
                freePeriodStatus = FreePeriodStatus.Expired;
            }
            FreePeriodStatus freePeriodStatus22 = freePeriodStatus;
            if (!z) {
                Duration.Companion companion3 = Duration.INSTANCE;
                double dM15867getInWholeMillisecondsimpl = (float) (j22 / Duration.m15867getInWholeMillisecondsimpl(DurationKt.toDuration(1, DurationUnit.DAYS)));
                if (dM15867getInWholeMillisecondsimpl <= 0.5d) {
                    jM15951getZEROUwyO8pc = Duration.INSTANCE.m15951getZEROUwyO8pc();
                } else {
                    Duration.Companion companion4 = Duration.INSTANCE;
                    jM15951getZEROUwyO8pc = DurationKt.toDuration((int) Math.ceil(dM15867getInWholeMillisecondsimpl - 0.5d), DurationUnit.DAYS);
                }
            } else {
                jM15951getZEROUwyO8pc = Duration.INSTANCE.m15951getZEROUwyO8pc();
            }
            this._freePeriodState.setValue(new FreePeriodState(freePeriodStatus22, freePeriodType2, jM15951getZEROUwyO8pc, duration2, null));
            return Unit.INSTANCE;
        }
        i = c67341.I$0;
        oemOfferStart = c67341.J$0;
        longRef = (Ref.LongRef) c67341.L$0;
        ResultKt.throwOnFailure(objWithContext);
        Object value2 = ((Result) objWithContext).getValue();
        if (Result.m14506isSuccessimpl(value2) && (value = ((KeyValue) value2).getValue()) != null && !StringsKt.isBlank(value)) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                SubscriptionRepository subscriptionRepository = this;
                setFreeTrialStart(Long.parseLong(value));
                longRef.element = Long.parseLong(value);
                Result.m14499constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion6 = Result.INSTANCE;
                Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
        }
        jCurrentTimeMillis = System.currentTimeMillis();
        if (longRef.element > jCurrentTimeMillis) {
        }
        if (oemOfferStart > jCurrentTimeMillis) {
        }
        if (oemOfferStart <= 0) {
        }
        if (freePeriodType != FreePeriodType.None) {
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$checkFreePeriodStatus$2 */
    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/myscript/nebo/account/backend/entity/KeyValue;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$checkFreePeriodStatus$2", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {499}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C67352 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends KeyValue>>, Object> {
        int label;

        C67352(Continuation<? super C67352> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionRepository.this.new C67352(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends KeyValue>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<KeyValue>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<KeyValue>> continuation) {
            return ((C67352) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objMo12808getValue0E7RQCE;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objMo12808getValue0E7RQCE = SubscriptionRepository.this.backend.mo12808getValue0E7RQCE(SubscriptionRepository.BACKEND_FREE_TRIAL_START_KEY, CachePolicy.FromCacheIfAvailable, this);
                if (objMo12808getValue0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objMo12808getValue0E7RQCE = ((Result) obj).getValue();
            }
            return Result.m14498boximpl(objMo12808getValue0E7RQCE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchSubscriptionStatus(Continuation<? super Unit> continuation) {
        C67381 c67381;
        Object objMo13346getCustomerInfoWithIoAF18A;
        SubscriptionRepository subscriptionRepository;
        String str;
        String str2;
        String str3;
        String productIdentifier;
        ISubscriptionRepository.PlanType planType;
        Set<String> activeSubscriptions;
        Object next;
        Offering current;
        Package monthly;
        StoreProduct product;
        Set<String> activeSubscriptions2;
        Object next2;
        Offering current2;
        Package annual;
        StoreProduct product2;
        Pair pair;
        Set<String> activeSubscriptions3;
        Object next3;
        Offering current3;
        Package lifetime;
        StoreProduct product3;
        if (continuation instanceof C67381) {
            c67381 = (C67381) continuation;
            if ((c67381.label & Integer.MIN_VALUE) != 0) {
                c67381.label -= Integer.MIN_VALUE;
            } else {
                c67381 = new C67381(continuation);
            }
        }
        Object obj = c67381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c67381.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.isFreemiumEnabled) {
                this._hasSubscribed.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            if (!this.purchaseProvider.isConfigured()) {
                this._hasSubscribed.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            if (this._isBillingUnavailable.getValue().booleanValue()) {
                this._hasSubscribed.setValue(Boxing.boxBoolean(false));
                setPlanType(null);
                return Unit.INSTANCE;
            }
            IPurchaseProvider iPurchaseProvider = this.purchaseProvider;
            c67381.label = 1;
            objMo13346getCustomerInfoWithIoAF18A = iPurchaseProvider.mo13346getCustomerInfoWithIoAF18A(c67381);
            if (objMo13346getCustomerInfoWithIoAF18A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objMo13346getCustomerInfoWithIoAF18A = ((Result) obj).getValue();
        }
        Object obj2 = objMo13346getCustomerInfoWithIoAF18A;
        if (Result.m14505isFailureimpl(obj2)) {
            subscriptionRepository = this;
            recordFailure$default(subscriptionRepository, obj2, "Couldn't fetch customer info", false, 4, null);
            pair = new Pair(Boxing.boxBoolean(false), null);
        } else {
            subscriptionRepository = this;
            CustomerInfoResult customerInfoResult = (CustomerInfoResult) (Result.m14505isFailureimpl(obj2) ? null : obj2);
            if (customerInfoResult == null || (activeSubscriptions3 = customerInfoResult.getActiveSubscriptions()) == null) {
                str = null;
            } else {
                Iterator<T> it = activeSubscriptions3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it.next();
                    String str4 = (String) next3;
                    Offerings offerings = subscriptionRepository._offerings;
                    if (Intrinsics.areEqual(str4, (offerings == null || (current3 = offerings.getCurrent()) == null || (lifetime = current3.getLifetime()) == null || (product3 = lifetime.getProduct()) == null) ? null : product3.getId())) {
                        break;
                    }
                }
                str = (String) next3;
            }
            if (str != null) {
                planType = ISubscriptionRepository.PlanType.LIFETIME;
            } else {
                if (customerInfoResult == null || (activeSubscriptions2 = customerInfoResult.getActiveSubscriptions()) == null) {
                    str2 = null;
                } else {
                    Iterator<T> it2 = activeSubscriptions2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        String str5 = (String) next2;
                        Offerings offerings2 = subscriptionRepository._offerings;
                        if (Intrinsics.areEqual(str5, (offerings2 == null || (current2 = offerings2.getCurrent()) == null || (annual = current2.getAnnual()) == null || (product2 = annual.getProduct()) == null) ? null : product2.getId())) {
                            break;
                        }
                    }
                    str2 = (String) next2;
                }
                if (str2 != null) {
                    planType = ISubscriptionRepository.PlanType.YEARLY;
                } else {
                    if (customerInfoResult == null || (activeSubscriptions = customerInfoResult.getActiveSubscriptions()) == null) {
                        str3 = null;
                    } else {
                        Iterator<T> it3 = activeSubscriptions.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it3.next();
                            String str6 = (String) next;
                            Offerings offerings3 = subscriptionRepository._offerings;
                            if (Intrinsics.areEqual(str6, (offerings3 == null || (current = offerings3.getCurrent()) == null || (monthly = current.getMonthly()) == null || (product = monthly.getProduct()) == null) ? null : product.getId())) {
                                break;
                            }
                        }
                        str3 = (String) next;
                    }
                    planType = str3 != null ? ISubscriptionRepository.PlanType.MONTHLY : (customerInfoResult == null || (productIdentifier = customerInfoResult.getProductIdentifier()) == null || !StringsKt.contains((CharSequence) productIdentifier, (CharSequence) "lifetime", true)) ? null : ISubscriptionRepository.PlanType.LIFETIME;
                }
            }
            pair = new Pair(Boxing.boxBoolean(customerInfoResult != null ? customerInfoResult.getHasSubscribed() : false), planType);
        }
        boolean zBooleanValue = ((Boolean) pair.component1()).booleanValue();
        ISubscriptionRepository.PlanType planType2 = (ISubscriptionRepository.PlanType) pair.component2();
        subscriptionRepository._hasSubscribed.setValue(Boxing.boxBoolean(zBooleanValue));
        setPlanType(planType2);
        CustomerInfoResult customerInfoResult2 = (CustomerInfoResult) (Result.m14505isFailureimpl(obj2) ? null : obj2);
        if (customerInfoResult2 != null) {
            updateRenewalOffer(customerInfoResult2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J$\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/purchase/SubscriptionRepository$RenewalMemory;", "", "earliestPurchaseMs", "", "observedPayments", "", "<init>", "(Ljava/lang/Long;I)V", "getEarliestPurchaseMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getObservedPayments", "()I", "component1", "component2", "copy", "(Ljava/lang/Long;I)Lcom/myscript/nebo/purchase/SubscriptionRepository$RenewalMemory;", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final /* data */ class RenewalMemory {
        private final Long earliestPurchaseMs;
        private final int observedPayments;

        public static /* synthetic */ RenewalMemory copy$default(RenewalMemory renewalMemory, Long l, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                l = renewalMemory.earliestPurchaseMs;
            }
            if ((i2 & 2) != 0) {
                i = renewalMemory.observedPayments;
            }
            return renewalMemory.copy(l, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getEarliestPurchaseMs() {
            return this.earliestPurchaseMs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getObservedPayments() {
            return this.observedPayments;
        }

        public final RenewalMemory copy(Long earliestPurchaseMs, int observedPayments) {
            return new RenewalMemory(earliestPurchaseMs, observedPayments);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RenewalMemory)) {
                return false;
            }
            RenewalMemory renewalMemory = (RenewalMemory) other;
            return Intrinsics.areEqual(this.earliestPurchaseMs, renewalMemory.earliestPurchaseMs) && this.observedPayments == renewalMemory.observedPayments;
        }

        public int hashCode() {
            Long l = this.earliestPurchaseMs;
            return ((l == null ? 0 : l.hashCode()) * 31) + Integer.hashCode(this.observedPayments);
        }

        public String toString() {
            return "RenewalMemory(earliestPurchaseMs=" + this.earliestPurchaseMs + ", observedPayments=" + this.observedPayments + ")";
        }

        public RenewalMemory(Long l, int i) {
            this.earliestPurchaseMs = l;
            this.observedPayments = i;
        }

        public final Long getEarliestPurchaseMs() {
            return this.earliestPurchaseMs;
        }

        public final int getObservedPayments() {
            return this.observedPayments;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final RenewalMemory rememberRenewalMemory(CustomerInfoResult customerInfo) {
        Long lValueOf;
        Set<String> setEmptySet;
        String str = this.lastConfiguredAppUserId;
        if (str == null) {
            str = "";
        }
        boolean zAreEqual = Intrinsics.areEqual(this.sharedPreferences.getString(PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_USER_KEY, null), str);
        if (zAreEqual) {
            lValueOf = Long.valueOf(this.sharedPreferences.getLong(PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_KEY, 0L));
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
        }
        Long l = (Long) CollectionsKt.minOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new Long[]{lValueOf, RenewalOfferEvaluator.INSTANCE.earliestKnownPurchaseMs(customerInfo)}));
        Long originalPurchaseDateMs = customerInfo.getOriginalPurchaseDateMs();
        long jLongValue = originalPurchaseDateMs != null ? originalPurchaseDateMs.longValue() : 0L;
        if (!zAreEqual || this.sharedPreferences.getLong(PREF_RENEWAL_OFFER_OBSERVED_CHAIN_KEY, 0L) != jLongValue || (setEmptySet = this.sharedPreferences.getStringSet(PREF_RENEWAL_OFFER_OBSERVED_PAYMENTS_KEY, null)) == null) {
            setEmptySet = SetsKt.emptySet();
        }
        Set<String> mutableSet = CollectionsKt.toMutableSet(setEmptySet);
        Long latestPurchaseDateMs = customerInfo.getLatestPurchaseDateMs();
        if (jLongValue != 0 && latestPurchaseDateMs != null && mutableSet.size() < 4) {
            mutableSet.add(String.valueOf(latestPurchaseDateMs.longValue()));
        }
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_USER_KEY, str);
        editorEdit.putLong(PREF_RENEWAL_OFFER_OBSERVED_CHAIN_KEY, jLongValue);
        editorEdit.putStringSet(PREF_RENEWAL_OFFER_OBSERVED_PAYMENTS_KEY, mutableSet);
        if (l != null) {
            editorEdit.putLong(PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_KEY, l.longValue());
        } else {
            editorEdit.remove(PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_KEY);
        }
        editorEdit.apply();
        return new RenewalMemory(l, mutableSet.size());
    }

    private final void updateRenewalOffer(CustomerInfoResult customerInfo) {
        if (this.isFreemiumEnabled) {
            RenewalMemory renewalMemoryRememberRenewalMemory = rememberRenewalMemory(customerInfo);
            if (this.debugRenewalOfferOverride) {
                return;
            }
            RenewalOfferEvaluation renewalOfferEvaluationEvaluate = RenewalOfferEvaluator.INSTANCE.evaluate(customerInfo, new RenewalOfferPersistedState(getRenewalOfferWindowStart(), getRenewalOfferHandledExpiration()), System.currentTimeMillis(), renewalMemoryRememberRenewalMemory.getEarliestPurchaseMs(), renewalMemoryRememberRenewalMemory.getObservedPayments());
            setRenewalOfferWindowStart(renewalOfferEvaluationEvaluate.getPersisted().getWindowStartMs());
            setRenewalOfferHandledExpiration(renewalOfferEvaluationEvaluate.getPersisted().getHandledExpirationMs());
            this.renewalOfferEndsAtMs = renewalOfferEvaluationEvaluate.getWindowEndsAtMs();
            publishRenewalOfferState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publishRenewalOfferState() {
        this._renewalOfferState.setValue(new RenewalOfferState(this.renewalOfferEndsAtMs > System.currentTimeMillis(), this.renewalOfferEndsAtMs));
    }

    public final void debugOverrideRenewalOffer(int remainingHours) {
        long jM15867getInWholeMillisecondsimpl;
        this.debugRenewalOfferOverride = true;
        if (remainingHours > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Duration.Companion companion = Duration.INSTANCE;
            jM15867getInWholeMillisecondsimpl = jCurrentTimeMillis + Duration.m15867getInWholeMillisecondsimpl(DurationKt.toDuration(remainingHours, DurationUnit.HOURS));
        } else {
            jM15867getInWholeMillisecondsimpl = 0;
        }
        this.renewalOfferEndsAtMs = jM15867getInWholeMillisecondsimpl;
        publishRenewalOfferState();
    }

    public final Object debugClearRenewalOfferOverride(Continuation<? super Unit> continuation) {
        this.debugRenewalOfferOverride = false;
        this.renewalOfferEndsAtMs = 0L;
        publishRenewalOfferState();
        Object objFetchSubscriptionStatus = fetchSubscriptionStatus(continuation);
        return objFetchSubscriptionStatus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFetchSubscriptionStatus : Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public boolean hasPaywallAfterFreePeriodBeenShown() {
        return this.sharedPreferences.getBoolean(PAYWALL_AFTER_FREE_PERIOD_SHOWN_KEY, false);
    }

    @Override // com.myscript.nebo.purchase.ISubscriptionRepository
    public void setPaywallAfterOptInTrialShown() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(PAYWALL_AFTER_FREE_PERIOD_SHOWN_KEY, true);
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionRepository$onCleared$1 */
    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$onCleared$1", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {748}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C67391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67391(Continuation<? super C67391> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionRepository.this.new C67391(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SubscriptionRepository.this.debugClearFreePeriodOverride(this) == coroutine_suspended) {
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

    public final void onCleared() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C67391(null), 3, null);
        this.ssoManager.removeLoginListener(this.loginListener);
    }

    public final Object debugOverrideFreePeriod(FreePeriodType freePeriodType, int i, int i2, Continuation<? super Unit> continuation) {
        if (this.savedFreeTrialStart == null) {
            this.savedFreeTrialStart = Boxing.boxLong(getFreeTrialStart());
        }
        if (this.savedOEMOfferStart == null) {
            this.savedOEMOfferStart = Boxing.boxLong(getOemOfferStart());
        }
        if (this.savedOEMOfferDuration == null) {
            this.savedOEMOfferDuration = Boxing.boxInt(getOemOfferDuration());
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i2, 1);
        long jCurrentTimeMillis = System.currentTimeMillis() - (((long) (iCoerceAtLeast - i)) * 86400000);
        int i3 = WhenMappings.$EnumSwitchMapping$0[freePeriodType.ordinal()];
        if (i3 == 1) {
            setFreeTrialStart(jCurrentTimeMillis);
            setOemOfferStart(0L);
        } else if (i3 == 2) {
            setOemOfferStart(jCurrentTimeMillis);
            setOemOfferDuration(iCoerceAtLeast);
            setFreeTrialStart(0L);
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            setFreeTrialStart(0L);
            setOemOfferStart(0L);
        }
        Object objCheckFreePeriodStatus = checkFreePeriodStatus(continuation);
        return objCheckFreePeriodStatus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCheckFreePeriodStatus : Unit.INSTANCE;
    }

    public final Object debugClearFreePeriodOverride(Continuation<? super Unit> continuation) {
        Long l = this.savedFreeTrialStart;
        if (l != null) {
            setFreeTrialStart(l.longValue());
        }
        Long l2 = this.savedOEMOfferStart;
        if (l2 != null) {
            setOemOfferStart(l2.longValue());
        }
        Integer num = this.savedOEMOfferDuration;
        if (num != null) {
            setOemOfferDuration(num.intValue());
        }
        this.savedFreeTrialStart = null;
        this.savedOEMOfferStart = null;
        this.savedOEMOfferDuration = null;
        Object objCheckFreePeriodStatus = checkFreePeriodStatus(continuation);
        return objCheckFreePeriodStatus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCheckFreePeriodStatus : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0003R\u0016\u0010\u001c\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0003R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, m1599d2 = {"Lcom/myscript/nebo/purchase/SubscriptionRepository$Companion;", "", "<init>", "()V", "OFFERING_ID_NEC", "", "OFFERING_ID_HANVON", "OFFERING_ID_LENOVO", "OFFERING_ID_MOTOROLA", "OFFERING_ID_TCL", "OFFERING_ID_SAMSUNG", "OEM_OFFERING_IDS", "", "getOEM_OFFERING_IDS", "()Ljava/util/List;", "FREEMIUM_PLACEMENT_ID", "APP_ID_1_KEY", "APP_ID_2_KEY", "APP_NOTES_VALUE", "DAY_IN_MS", "", "FREE_TRIAL_DEFAULT_DURATION_DAYS", "", "OEM_OFFER_DURATION_WAIT_TIMEOUT_MS", "BACKEND_FREE_TRIAL_START_KEY", SubscriptionRepository.PREF_FREE_TRIAL_START_KEY, SubscriptionRepository.PREF_OEM_OFFER_START_KEY, "getPREF_OEM_OFFER_START_KEY$annotations", SubscriptionRepository.PREF_OEM_OFFER_DURATION_KEY, "getPREF_OEM_OFFER_DURATION_KEY$annotations", "RC_OEM_OFFER_DURATION_KEY", "PAYWALL_AFTER_FREE_PERIOD_SHOWN_KEY", SubscriptionRepository.PREF_MAILSERVICES_LINK_RC_DONE_KEY, SubscriptionRepository.PREF_RENEWAL_OFFER_WINDOW_START_KEY, SubscriptionRepository.PREF_RENEWAL_OFFER_HANDLED_EXPIRATION_KEY, SubscriptionRepository.PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_KEY, SubscriptionRepository.PREF_RENEWAL_OFFER_EARLIEST_PURCHASE_USER_KEY, SubscriptionRepository.PREF_RENEWAL_OFFER_OBSERVED_CHAIN_KEY, SubscriptionRepository.PREF_RENEWAL_OFFER_OBSERVED_PAYMENTS_KEY, "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPREF_OEM_OFFER_DURATION_KEY$annotations() {
        }

        public static /* synthetic */ void getPREF_OEM_OFFER_START_KEY$annotations() {
        }

        private Companion() {
        }

        public final List<String> getOEM_OFFERING_IDS() {
            return SubscriptionRepository.OEM_OFFERING_IDS;
        }
    }
}
