package com.revenuecat.purchases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.VerifiedReward;
import com.revenuecat.purchases.ads.events.AdCaptureMethod;
import com.revenuecat.purchases.ads.events.AdTracker;
import com.revenuecat.purchases.ads.events.types.AdRewardEarnedUnverifiedData;
import com.revenuecat.purchases.ads.events.types.AdRewardFailedToVerifyData;
import com.revenuecat.purchases.ads.events.types.AdRewardGrantedData;
import com.revenuecat.purchases.ads.events.types.AdRewardVerifiedData;
import com.revenuecat.purchases.ads.rewardverification.Outcome;
import com.revenuecat.purchases.ads.rewardverification.OutcomeKt;
import com.revenuecat.purchases.ads.rewardverification.RewardVerificationPollLauncher;
import com.revenuecat.purchases.ads.rewardverification.RewardVerificationResult;
import com.revenuecat.purchases.ads.rewardverification.RewardVerificationToken;
import com.revenuecat.purchases.ads.rewardverification.RewardedAdTrackingMetadata;
import com.revenuecat.purchases.ads.rewardverification.VerifiedReward;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.deeplinks.DeepLinkParser;
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
import com.revenuecat.purchases.interfaces.PollRewardVerificationCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.paywalls.events.CustomPaywallEvent;
import com.revenuecat.purchases.paywalls.events.CustomPaywallImpressionParams;
import com.revenuecat.purchases.storage.FileRepository;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.utils.DefaultIsDebugBuildProvider;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: Purchases.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Þ\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ²\u00022\u00020\u0001:\u0002²\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010k\u001a\u00020lH\u0087@¢\u0006\u0002\u0010mJ\u0016\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020\u0013H\u0087@¢\u0006\u0002\u0010qJ\u0006\u0010r\u001a\u00020sJ\u0006\u0010t\u001a\u00020sJ@\u0010u\u001a\u00020s2\u0006\u0010v\u001a\u00020\u00132\u0006\u0010w\u001a\u00020\u00132\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020s0y2\u0012\u0010z\u001a\u000e\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020s0yH\u0007J\u000e\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u0013J\u0010\u0010\u007f\u001a\u00020s2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J\u0016\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0007J\u0019\u0010\u0086\u0001\u001a\u00020s2\b\u0010\u0080\u0001\u001a\u00030\u0087\u0001H\u0000¢\u0006\u0003\b\u0088\u0001J\u001b\u0010\u0089\u0001\u001a\u00020s2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u0080\u0001\u001a\u00030\u008c\u0001J\u0011\u0010\u0089\u0001\u001a\u00020s2\b\u0010\u0080\u0001\u001a\u00030\u008c\u0001J#\u0010\u008d\u0001\u001a\u00020s2\u000e\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u008f\u00012\b\u0010\u0080\u0001\u001a\u00030\u0090\u0001H\u0007J\u0011\u0010\u0091\u0001\u001a\u00020s2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001J/\u0010\u0094\u0001\u001a\u00020s2\u000e\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u008f\u00012\f\b\u0002\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\b\u0010\u0080\u0001\u001a\u00030\u0090\u0001J!\u0010\u0094\u0001\u001a\u00020s2\u000e\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u008f\u00012\b\u0010\u0080\u0001\u001a\u00030\u0090\u0001J\"\u0010\u0097\u0001\u001a\u00020s2\u0007\u0010\u0098\u0001\u001a\u00020\u00132\b\u0010\u0080\u0001\u001a\u00030\u0099\u0001H\u0000¢\u0006\u0003\b\u009a\u0001J\u0010\u0010W\u001a\u00020s2\b\u0010\u0080\u0001\u001a\u00030\u009b\u0001J\u0012\u0010[\u001a\u00020s2\b\u0010\u0080\u0001\u001a\u00030\u009c\u0001H\u0007J#\u0010\u009d\u0001\u001a\u00020s2\u000e\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u008f\u00012\b\u0010\u0080\u0001\u001a\u00030\u0090\u0001H\u0007J\u0011\u0010\u009e\u0001\u001a\u00020s2\b\u0010\u0080\u0001\u001a\u00030\u009f\u0001J\u0007\u0010 \u0001\u001a\u00020sJ\u0007\u0010¡\u0001\u001a\u00020sJ \u0010¢\u0001\u001a\u00020s2\u0007\u0010£\u0001\u001a\u00020\u00132\f\b\u0002\u0010\u0080\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0007J\u0017\u0010¥\u0001\u001a\u00020s2\f\b\u0002\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0007J\t\u0010¦\u0001\u001a\u00020sH\u0002J\t\u0010§\u0001\u001a\u00020sH\u0017J\t\u0010¨\u0001\u001a\u00020sH\u0017J\u0012\u0010©\u0001\u001a\u00020\n2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0013J[\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u00132\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u00012\b\u0010¯\u0001\u001a\u00030°\u00012&\u0010±\u0001\u001a!\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\f\u0012\n\u0012\u0005\u0012\u00030´\u00010³\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001b0²\u0001H\u0080@¢\u0006\u0006\bµ\u0001\u0010¶\u0001J*\u0010«\u0001\u001a\u00020s2\u0007\u0010\u0098\u0001\u001a\u00020\u00132\b\u0010\u0080\u0001\u001a\u00030·\u00012\f\b\u0002\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001H\u0007J\u001b\u0010¸\u0001\u001a\u00020s2\b\u0010¹\u0001\u001a\u00030º\u00012\b\u0010\u0080\u0001\u001a\u00030»\u0001J&\u0010¼\u0001\u001a\u00020s2\u0007\u0010½\u0001\u001a\u00020%2\b\u0010¾\u0001\u001a\u00030¿\u00012\b\u0010\u0092\u0001\u001a\u00030»\u0001H\u0007J&\u0010À\u0001\u001a\u00020s2\u0007\u0010½\u0001\u001a\u00020%2\b\u0010Á\u0001\u001a\u00030Â\u00012\b\u0010\u0080\u0001\u001a\u00030»\u0001H\u0007J\u001b\u0010Ã\u0001\u001a\u00020s2\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010\u0092\u0001\u001a\u00030Æ\u0001J\u0018\u0010Ç\u0001\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010qJ\u0007\u0010È\u0001\u001a\u00020sJ3\u0010É\u0001\u001a\u00030Ê\u00012\u0007\u0010Ë\u0001\u001a\u00020\u00132\u0017\b\u0002\u0010Ì\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0005\u0012\u00030Î\u00010Í\u0001H\u0087@¢\u0006\u0003\u0010Ï\u0001J\u0019\u0010Ð\u0001\u001a\u00030Ñ\u00012\u0007\u0010Ò\u0001\u001a\u00020\u0013H\u0087@¢\u0006\u0002\u0010qJ\u0011\u0010Ó\u0001\u001a\u00020s2\b\u0010\u0080\u0001\u001a\u00030\u008c\u0001J\u0012\u0010Ô\u0001\u001a\u00020s2\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010Ö\u0001\u001a\u00020s2\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010Ø\u0001\u001a\u00020s2\t\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010Ú\u0001\u001a\u00020s2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010Ü\u0001\u001a\u00020s2\t\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0013J\u001b\u0010Þ\u0001\u001a\u00020s2\u0012\u0010ß\u0001\u001a\r\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010Í\u0001J\u0012\u0010à\u0001\u001a\u00020s2\t\u0010á\u0001\u001a\u0004\u0018\u00010\u0013J'\u0010â\u0001\u001a\u00020s2\u0014\u0010ß\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130Í\u00012\b\u0010\u0080\u0001\u001a\u00030ã\u0001J\u001f\u0010ä\u0001\u001a\u00020s2\u0016\u0010å\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130Í\u0001J\u0012\u0010æ\u0001\u001a\u00020s2\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010è\u0001\u001a\u00020s2\t\u0010é\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010ê\u0001\u001a\u00020s2\t\u0010ë\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010ì\u0001\u001a\u00020s2\t\u0010í\u0001\u001a\u0004\u0018\u00010\u0013J\u0011\u0010î\u0001\u001a\u00020s2\b\u0010v\u001a\u0004\u0018\u00010\u0013J\u0012\u0010ï\u0001\u001a\u00020s2\t\u0010ð\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010ñ\u0001\u001a\u00020s2\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010ó\u0001\u001a\u00020s2\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010õ\u0001\u001a\u00020s2\t\u0010ö\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010÷\u0001\u001a\u00020s2\t\u0010ø\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010ù\u0001\u001a\u00020s2\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010û\u0001\u001a\u00020s2\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010ý\u0001\u001a\u00020s2\t\u0010þ\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010ÿ\u0001\u001a\u00020s2\t\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0081\u0002\u001a\u00020s2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0083\u0002\u001a\u00020s2\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0085\u0002\u001a\u00020s2\t\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0087\u0002\u001a\u00020s2\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0089\u0002\u001a\u00020s2\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u008b\u0002\u001a\u00020s2\t\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u008d\u0002\u001a\u00020s2\t\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u008f\u0002\u001a\u00020s2\t\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u0013J%\u0010\u0091\u0002\u001a\u00020s2\u0007\u0010½\u0001\u001a\u00020%2\u0011\b\u0002\u0010\u0092\u0002\u001a\n\u0012\u0005\u0012\u00030\u0093\u00020\u008f\u0001H\u0007J!\u0010\u0094\u0002\u001a\u00020s2\b\u0010\u0095\u0002\u001a\u00030\u0096\u00022\f\b\u0002\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0097\u0002H\u0007JA\u0010\u0098\u0002\u001a\u00020s2\u0007\u0010\u0099\u0002\u001a\u00020\u00132\u0007\u0010\u009a\u0002\u001a\u00020\u00132\u0007\u0010\u009b\u0002\u001a\u00020\u00132\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u00132\n\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009e\u0002H\u0007¢\u0006\u0003\u0010\u009f\u0002JI\u0010\u0098\u0002\u001a\u00020s2\u0007\u0010\u0099\u0002\u001a\u00020\u00132\u0007\u0010\u009a\u0002\u001a\u00020\u00132\u0007\u0010\u009b\u0002\u001a\u00020\u00132\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u00132\n\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009e\u00022\b\u0010 \u0002\u001a\u00030¡\u0002¢\u0006\u0003\u0010¢\u0002J\u0011\u0010£\u0002\u001a\u00020s2\b\u0010\u0080\u0001\u001a\u00030ã\u0001JA\u0010¤\u0002\u001a\u00020s2\u0007\u0010\u0099\u0002\u001a\u00020\u00132\u0007\u0010\u009a\u0002\u001a\u00020\u00132\u0007\u0010\u009b\u0002\u001a\u00020\u00132\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u00132\n\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009e\u0002H\u0007¢\u0006\u0003\u0010\u009f\u0002J\u0017\u0010¥\u0002\u001a\u00020s2\f\b\u0002\u0010\u0092\u0001\u001a\u0005\u0018\u00010¦\u0002H\u0007J\u0013\u0010§\u0002\u001a\u00020s2\b\u0010¨\u0002\u001a\u00030©\u0002H\u0007J\u0015\u0010ª\u0002\u001a\u00020s2\n\b\u0002\u0010«\u0002\u001a\u00030¬\u0002H\u0007J'\u0010\u00ad\u0002\u001a\u00020s2\b\u0010\u00ad\u0001\u001a\u00030®\u00012\b\u0010®\u0002\u001a\u00030´\u00012\b\u0010¯\u0001\u001a\u00030°\u0001H\u0002J\u000f\u0010¯\u0002\u001a\u00030°\u0002*\u00030±\u0002H\u0002R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R5\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\b\u001d\u0010\r\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#*\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\u0004\u0018\u00010%8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\r\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R/\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\u001a\u001a\u0004\u0018\u00010-8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b0\u00101\"\u0004\b2\u00103*\u0004\b/\u0010\u001fR5\u00105\u001a\u0004\u0018\u0001042\b\u0010\u001a\u001a\u0004\u0018\u0001048F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\b6\u0010\r\u001a\u0004\b8\u00109\"\u0004\b:\u0010;*\u0004\b7\u0010\u001fR\u001a\u0010<\u001a\u00020=8FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\r\u001a\u0004\b?\u0010@R*\u0010A\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bB\u0010\r\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010\u0011R\u0011\u0010E\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bE\u0010\u000fR\u0013\u0010F\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\bG\u0010\u0015R$\u0010I\u001a\u00020H2\u0006\u0010\t\u001a\u00020H8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010R\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0013\u0010V\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\bW\u0010\u0015R\u001c\u0010X\u001a\u0004\u0018\u00010Y8FX\u0087\u0004¢\u0006\f\u0012\u0004\bZ\u0010\r\u001a\u0004\b[\u0010\\R5\u0010^\u001a\u0004\u0018\u00010]2\b\u0010\u001a\u001a\u0004\u0018\u00010]8F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\b_\u0010\r\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d*\u0004\b`\u0010\u001fR(\u0010f\u001a\u0004\u0018\u00010e2\b\u0010\t\u001a\u0004\u0018\u00010e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j¨\u0006³\u0002"}, m1599d2 = {"Lcom/revenuecat/purchases/Purchases;", "Lcom/revenuecat/purchases/LifecycleDelegate;", "purchasesOrchestrator", "Lcom/revenuecat/purchases/PurchasesOrchestrator;", "(Lcom/revenuecat/purchases/PurchasesOrchestrator;)V", "adTracker", "Lcom/revenuecat/purchases/ads/events/AdTracker;", "getAdTracker", "()Lcom/revenuecat/purchases/ads/events/AdTracker;", "value", "", "allowSharingPlayStoreAccount", "getAllowSharingPlayStoreAccount$annotations", "()V", "getAllowSharingPlayStoreAccount", "()Z", "setAllowSharingPlayStoreAccount", "(Z)V", "appUserID", "", "getAppUserID", "()Ljava/lang/String;", "cachedVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "getCachedVirtualCurrencies", "()Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "<set-?>", "", "checkpointManagerSlot", "getCheckpointManagerSlot$annotations", "getCheckpointManagerSlot$delegate", "(Lcom/revenuecat/purchases/Purchases;)Ljava/lang/Object;", "getCheckpointManagerSlot", "()Ljava/lang/Object;", "setCheckpointManagerSlot", "(Ljava/lang/Object;)V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity$annotations", "getCurrentActivity", "()Landroid/app/Activity;", "currentConfiguration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "getCurrentConfiguration", "()Lcom/revenuecat/purchases/PurchasesConfiguration;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "customerCenterListener", "getCustomerCenterListener$delegate", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "setCustomerCenterListener", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "Lcom/revenuecat/purchases/DebugEventListener;", "debugEventListener", "getDebugEventListener$annotations", "getDebugEventListener$delegate", "getDebugEventListener", "()Lcom/revenuecat/purchases/DebugEventListener;", "setDebugEventListener", "(Lcom/revenuecat/purchases/DebugEventListener;)V", "fileRepository", "Lcom/revenuecat/purchases/storage/FileRepository;", "getFileRepository$annotations", "getFileRepository", "()Lcom/revenuecat/purchases/storage/FileRepository;", "finishTransactions", "getFinishTransactions$annotations", "getFinishTransactions", "setFinishTransactions", "isAnonymous", "preferredUILocaleOverride", "getPreferredUILocaleOverride", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "purchasesAreCompletedBy", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "setPurchasesAreCompletedBy", "(Lcom/revenuecat/purchases/PurchasesAreCompletedBy;)V", "getPurchasesOrchestrator$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PurchasesOrchestrator;", "rewardVerificationPollLauncher", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationPollLauncher;", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "storefrontCountryCode", "getStorefrontCountryCode", "storefrontLocale", "Ljava/util/Locale;", "getStorefrontLocale$annotations", "getStorefrontLocale", "()Ljava/util/Locale;", "Lcom/revenuecat/purchases/TrackedEventListener;", "trackedEventListener", "getTrackedEventListener$annotations", "getTrackedEventListener$delegate", "getTrackedEventListener", "()Lcom/revenuecat/purchases/TrackedEventListener;", "setTrackedEventListener", "(Lcom/revenuecat/purchases/TrackedEventListener;)V", "Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "updatedCustomerInfoListener", "getUpdatedCustomerInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "setUpdatedCustomerInfoListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;)V", "awaitGetUiConfig", "Lcom/revenuecat/purchases/UiConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetWorkflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "workflowId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "collectDeviceIdentifiers", "createSupportTicket", "email", "description", "onSuccess", "Lkotlin/Function1;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "generateRewardVerificationToken", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationToken;", "impressionId", "getAmazonLWAConsentStatus", "callback", "Lcom/revenuecat/purchases/interfaces/GetAmazonLWAConsentStatusCallback;", "getCachedFontFamilyOrStartDownload", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "fontInfo", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "getCustomerCenterConfigData", "Lcom/revenuecat/purchases/interfaces/GetCustomerCenterConfigCallback;", "getCustomerCenterConfigData$purchases_defaultsRelease", "getCustomerInfo", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "getNonSubscriptionSkus", "productIds", "", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "getOfferings", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "getProducts", "type", "Lcom/revenuecat/purchases/ProductType;", "getRewardVerificationResult", "clientTransactionId", "Lcom/revenuecat/purchases/interfaces/GetRewardVerificationResultCallback;", "getRewardVerificationResult$purchases_defaultsRelease", "Lcom/revenuecat/purchases/interfaces/GetStorefrontCallback;", "Lcom/revenuecat/purchases/interfaces/GetStorefrontLocaleCallback;", "getSubscriptionSkus", "getVirtualCurrencies", "Lcom/revenuecat/purchases/interfaces/GetVirtualCurrenciesCallback;", "invalidateCustomerInfoCache", "invalidateVirtualCurrenciesCache", "logIn", "newAppUserID", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logOut", "notifyLifecycleClosed", "onAppBackgrounded", "onAppForegrounded", "overridePreferredUILocale", "localeString", "pollRewardVerification", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult;", "trackingMetadata", "Lcom/revenuecat/purchases/ads/rewardverification/RewardedAdTrackingMetadata;", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "poll", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome;", "pollRewardVerification$purchases_defaultsRelease", "(Ljava/lang/String;Lcom/revenuecat/purchases/ads/rewardverification/RewardedAdTrackingMetadata;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/revenuecat/purchases/interfaces/PollRewardVerificationCallback;", FirebaseAnalytics.Event.PURCHASE, "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "purchasePackage", "activity", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "purchaseProduct", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "redeemWebPurchase", "webPurchaseRedemption", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener;", "refreshCustomerInfoAfterEntitlementGrant", "removeUpdatedCustomerInfoListener", "resolveCheckpoint", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution;", "checkpointIdentifier", "customVariables", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "offeringId", "restorePurchases", "setAd", "ad", "setAdGroup", "adGroup", "setAdjustID", "adjustID", "setAirbridgeDeviceID", "airbridgeDeviceID", "setAirshipChannelID", "airshipChannelID", "setAppsFlyerConversionData", "data", "setAppsflyerID", "appsflyerID", "setAppstackAttributionParams", "Lcom/revenuecat/purchases/interfaces/SyncAttributesAndOfferingsCallback;", "setAttributes", "attributes", "setCampaign", FirebaseAnalytics.Param.CAMPAIGN, "setCleverTapID", "cleverTapID", "setCreative", "creative", "setDisplayName", "displayName", "setEmail", "setFBAnonymousID", "fbAnonymousID", "setFirebaseAppInstanceID", "firebaseAppInstanceID", "setKeyword", "keyword", "setKochavaDeviceID", "kochavaDeviceID", "setMediaSource", "mediaSource", "setMixpanelDistinctID", "mixpanelDistinctID", "setMparticleID", "mparticleID", "setOnesignalID", "onesignalID", "setOnesignalUserID", "onesignalUserID", "setPhoneNumber", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "setPostHogUserId", "postHogUserId", "setPushToken", "fcmToken", "setSingularDeviceID", "singularDeviceID", "setSolarEngineAccountId", "solarEngineAccountId", "setSolarEngineDistinctId", "solarEngineDistinctId", "setSolarEngineVisitorId", "solarEngineVisitorId", "setTenjinAnalyticsInstallationID", "tenjinAnalyticsInstallationID", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "showManageSubscriptions", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "Lcom/revenuecat/purchases/interfaces/ManageSubscriptionsCallback;", "syncAmazonPurchase", "productID", "receiptID", "amazonUserID", "isoCurrencyCode", "price", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "purchaseTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;J)V", "syncAttributesAndOfferingsIfNeeded", "syncObserverModeAmazonPurchase", "syncPurchases", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "track", NotificationCompat.CATEGORY_EVENT, "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "trackCustomPaywallImpression", "params", "Lcom/revenuecat/purchases/paywalls/events/CustomPaywallImpressionParams;", "trackRewardOutcome", "outcome", "toCoreVerifiedReward", "Lcom/revenuecat/purchases/VerifiedReward;", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class Purchases implements LifecycleDelegate {
    private static final int MAX_ENTITLEMENT_REFRESH_ATTEMPTS = 3;
    private static /* synthetic */ Purchases backingFieldSharedInstance;
    private final PurchasesOrchestrator purchasesOrchestrator;
    private final RewardVerificationPollLauncher rewardVerificationPollLauncher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static PurchasesServiceDispatcher serviceDispatcher = PurchasesServices.INSTANCE.m13646default();
    private static final String frameworkVersion = "10.20.0";

    /* JADX INFO: compiled from: Purchases.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.Purchases$pollRewardVerification$3 */
    /* JADX INFO: compiled from: Purchases.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.Purchases", m1609f = "Purchases.kt", m1610i = {0, 0, 0, 0, 1}, m1611l = {909, 929}, m1612m = "pollRewardVerification$purchases_defaultsRelease", m1613n = {"this", "clientTransactionId", "trackingMetadata", "captureMethod", "result"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C70303 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C70303(Continuation<? super C70303> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Purchases.this.pollRewardVerification$purchases_defaultsRelease(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.Purchases$refreshCustomerInfoAfterEntitlementGrant$1 */
    /* JADX INFO: compiled from: Purchases.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.Purchases", m1609f = "Purchases.kt", m1610i = {0, 0, 0, 1, 1, 1}, m1611l = {1009, 1016}, m1612m = "refreshCustomerInfoAfterEntitlementGrant", m1613n = {"this", "clientTransactionId", "attempt", "this", "clientTransactionId", "attempt"}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
    static final class C70311 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C70311(Continuation<? super C70311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Purchases.this.refreshCustomerInfoAfterEntitlementGrant(null, this);
        }
    }

    @JvmStatic
    public static final void canMakePayments(Context context, Callback<Boolean> callback) {
        INSTANCE.canMakePayments(context, callback);
    }

    @JvmStatic
    public static final void canMakePayments(Context context, List<? extends BillingFeature> list, Callback<Boolean> callback) {
        INSTANCE.canMakePayments(context, list, callback);
    }

    @JvmStatic
    public static final Purchases configure(PurchasesConfiguration purchasesConfiguration) {
        return INSTANCE.configure(purchasesConfiguration);
    }

    @Deprecated(message = "Replaced with configuration in the RevenueCat dashboard", replaceWith = @ReplaceWith(expression = "configure through the RevenueCat dashboard", imports = {}))
    public static /* synthetic */ void getAllowSharingPlayStoreAccount$annotations() {
    }

    public static /* synthetic */ void getCheckpointManagerSlot$annotations() {
    }

    public static /* synthetic */ void getCurrentActivity$annotations() {
    }

    public static /* synthetic */ void getDebugEventListener$annotations() {
    }

    public static final boolean getDebugLogsEnabled() {
        return INSTANCE.getDebugLogsEnabled();
    }

    public static /* synthetic */ void getFileRepository$annotations() {
    }

    @Deprecated(message = "\"Finishing transactions\" is not a platform-agnostic term.", replaceWith = @ReplaceWith(expression = "purchasesAreCompletedBy", imports = {}))
    public static /* synthetic */ void getFinishTransactions$annotations() {
    }

    public static final String getFrameworkVersion() {
        return INSTANCE.getFrameworkVersion();
    }

    public static final LogLevel getLogLevel() {
        return INSTANCE.getLogLevel();
    }

    public static final PlatformInfo getPlatformInfo() {
        return INSTANCE.getPlatformInfo();
    }

    public static final URL getProxyURL() {
        return INSTANCE.getProxyURL();
    }

    public static final Purchases getSharedInstance() {
        return INSTANCE.getSharedInstance();
    }

    public static /* synthetic */ void getStorefrontLocale$annotations() {
    }

    public static /* synthetic */ void getTrackedEventListener$annotations() {
    }

    public static final boolean isConfigured() {
        return INSTANCE.isConfigured();
    }

    @JvmStatic
    public static final WebPurchaseRedemption parseAsWebPurchaseRedemption(Intent intent) {
        return INSTANCE.parseAsWebPurchaseRedemption(intent);
    }

    @JvmStatic
    public static final WebPurchaseRedemption parseAsWebPurchaseRedemption(String str) {
        return INSTANCE.parseAsWebPurchaseRedemption(str);
    }

    public static final void setDebugLogsEnabled(boolean z) {
        INSTANCE.setDebugLogsEnabled(z);
    }

    public static final void setLogLevel(LogLevel logLevel) {
        INSTANCE.setLogLevel(logLevel);
    }

    public static final void setPlatformInfo(PlatformInfo platformInfo) {
        INSTANCE.setPlatformInfo(platformInfo);
    }

    public static final void setProxyURL(URL url) {
        INSTANCE.setProxyURL(url);
    }

    public final void logIn(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        logIn$default(this, newAppUserID, null, 2, null);
    }

    public final void logOut() {
        logOut$default(this, null, 1, null);
    }

    public final void pollRewardVerification(String clientTransactionId, PollRewardVerificationCallback callback) {
        Intrinsics.checkNotNullParameter(clientTransactionId, "clientTransactionId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        pollRewardVerification$default(this, clientTransactionId, callback, null, 4, null);
    }

    public final void showInAppMessagesIfNeeded(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showInAppMessagesIfNeeded$default(this, activity, null, 2, null);
    }

    public final void showManageSubscriptions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        showManageSubscriptions$default(this, context, null, 2, null);
    }

    public final void syncPurchases() {
        syncPurchases$default(this, null, 1, null);
    }

    public final void trackCustomPaywallImpression() {
        trackCustomPaywallImpression$default(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Purchases(PurchasesOrchestrator purchasesOrchestrator) {
        Intrinsics.checkNotNullParameter(purchasesOrchestrator, "purchasesOrchestrator");
        this.purchasesOrchestrator = purchasesOrchestrator;
        this.rewardVerificationPollLauncher = new RewardVerificationPollLauncher(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: getPurchasesOrchestrator$purchases_defaultsRelease, reason: from getter */
    public final /* synthetic */ PurchasesOrchestrator getPurchasesOrchestrator() {
        return this.purchasesOrchestrator;
    }

    public final PurchasesConfiguration getCurrentConfiguration() {
        return this.purchasesOrchestrator.getCurrentConfiguration();
    }

    public final synchronized boolean getFinishTransactions() {
        return this.purchasesOrchestrator.getFinishTransactions();
    }

    public final synchronized void setFinishTransactions(boolean z) {
        this.purchasesOrchestrator.setFinishTransactions(z);
    }

    public final synchronized PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        PurchasesAreCompletedBy purchasesAreCompletedBy;
        if (this.purchasesOrchestrator.getFinishTransactions()) {
            purchasesAreCompletedBy = PurchasesAreCompletedBy.REVENUECAT;
        } else {
            purchasesAreCompletedBy = PurchasesAreCompletedBy.MY_APP;
        }
        return purchasesAreCompletedBy;
    }

    public final synchronized void setPurchasesAreCompletedBy(PurchasesAreCompletedBy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        PurchasesOrchestrator purchasesOrchestrator = this.purchasesOrchestrator;
        int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            z = false;
        }
        purchasesOrchestrator.setFinishTransactions(z);
    }

    public final synchronized String getAppUserID() {
        return this.purchasesOrchestrator.getAppUserID();
    }

    public final synchronized String getStorefrontCountryCode() {
        return this.purchasesOrchestrator.getStorefrontCountryCode();
    }

    public final Locale getStorefrontLocale() {
        return this.purchasesOrchestrator.getStorefrontLocale();
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.purchasesOrchestrator.getUpdatedCustomerInfoListener();
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.purchasesOrchestrator.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final CustomerCenterListener getCustomerCenterListener() {
        return this.purchasesOrchestrator.getCustomerCenterListener();
    }

    public final void setCustomerCenterListener(CustomerCenterListener customerCenterListener) {
        this.purchasesOrchestrator.setCustomerCenterListener(customerCenterListener);
    }

    public final /* synthetic */ TrackedEventListener getTrackedEventListener() {
        return this.purchasesOrchestrator.getTrackedEventListener();
    }

    public final /* synthetic */ void setTrackedEventListener(TrackedEventListener trackedEventListener) {
        this.purchasesOrchestrator.setTrackedEventListener(trackedEventListener);
    }

    public final /* synthetic */ DebugEventListener getDebugEventListener() {
        return this.purchasesOrchestrator.getDebugEventListener();
    }

    public final /* synthetic */ void setDebugEventListener(DebugEventListener debugEventListener) {
        this.purchasesOrchestrator.setDebugEventListener(debugEventListener);
    }

    public final /* synthetic */ Object getCheckpointManagerSlot() {
        return this.purchasesOrchestrator.getCheckpointManagerSlot();
    }

    public final /* synthetic */ void setCheckpointManagerSlot(Object obj) {
        this.purchasesOrchestrator.setCheckpointManagerSlot(obj);
    }

    public final /* synthetic */ Activity getCurrentActivity() {
        return this.purchasesOrchestrator.getCurrentActivity();
    }

    public static /* synthetic */ Object resolveCheckpoint$default(Purchases purchases, String str, Map map, Continuation continuation, int i, Object obj) throws PurchasesException {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return purchases.resolveCheckpoint(str, map, continuation);
    }

    public final /* synthetic */ Object resolveCheckpoint(String str, Map map, Continuation continuation) throws PurchasesException {
        return this.purchasesOrchestrator.resolveCheckpoint(str, map, continuation);
    }

    public final boolean isAnonymous() {
        return this.purchasesOrchestrator.isAnonymous();
    }

    public final Store getStore() {
        return this.purchasesOrchestrator.getStore();
    }

    public final /* synthetic */ FileRepository getFileRepository() {
        return this.purchasesOrchestrator.getFileRepository();
    }

    public final /* synthetic */ AdTracker getAdTracker() {
        return this.purchasesOrchestrator.getAdTracker();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    @Deprecated(message = "Will be removed in next major. Logic has been moved to PurchasesOrchestrator")
    public void onAppBackgrounded() {
        this.purchasesOrchestrator.onAppBackgrounded();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    @Deprecated(message = "Will be removed in next major. Logic has been moved to PurchasesOrchestrator")
    public void onAppForegrounded() {
        this.purchasesOrchestrator.onAppForegrounded();
    }

    public final void getStorefrontCountryCode(GetStorefrontCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getStorefrontCountryCode(callback);
    }

    public final void getStorefrontLocale(GetStorefrontLocaleCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getStorefrontLocale(callback);
    }

    public static /* synthetic */ void syncPurchases$default(Purchases purchases, SyncPurchasesCallback syncPurchasesCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchases.syncPurchases(syncPurchasesCallback);
    }

    public final void syncPurchases(SyncPurchasesCallback listener) {
        this.purchasesOrchestrator.syncPurchases(listener);
    }

    @Deprecated(message = "syncObserverModeAmazonPurchase is being deprecated in favor of syncAmazonPurchase.", replaceWith = @ReplaceWith(expression = "syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price)", imports = {}))
    public final void syncObserverModeAmazonPurchase(String productID, String receiptID, String amazonUserID, String isoCurrencyCode, Double price) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price);
    }

    @Deprecated(message = "Use syncAmazonPurchase with purchaseTime parameter instead.", replaceWith = @ReplaceWith(expression = "syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price, purchaseTime)", imports = {}))
    public final void syncAmazonPurchase(String productID, String receiptID, String amazonUserID, String isoCurrencyCode, Double price) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        this.purchasesOrchestrator.syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price, null);
    }

    public final void syncAmazonPurchase(String productID, String receiptID, String amazonUserID, String isoCurrencyCode, Double price, long purchaseTime) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        this.purchasesOrchestrator.syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price, Long.valueOf(purchaseTime));
    }

    public final void syncAttributesAndOfferingsIfNeeded(SyncAttributesAndOfferingsCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.syncAttributesAndOfferingsIfNeeded(callback);
    }

    public final void getOfferings(ReceiveOfferingsCallback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        PurchasesOrchestrator.getOfferings$default(this.purchasesOrchestrator, listener, false, 2, null);
    }

    public final /* synthetic */ Object awaitGetWorkflow(String str, Continuation continuation) throws PurchasesException {
        return this.purchasesOrchestrator.getWorkflow(str, continuation);
    }

    public final /* synthetic */ Object awaitGetUiConfig(Continuation continuation) throws PurchasesException {
        return this.purchasesOrchestrator.getUiConfig(continuation);
    }

    public final /* synthetic */ Object resolveWorkflow(String str, Continuation continuation) {
        return this.purchasesOrchestrator.resolveWorkflow(str, continuation);
    }

    public final void getProducts(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getProducts(productIds, null, callback);
    }

    public static /* synthetic */ void getProducts$default(Purchases purchases, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            productType = null;
        }
        purchases.getProducts(list, productType, getStoreProductsCallback);
    }

    public final void getProducts(List<String> productIds, ProductType type, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProducts(productIds, type, callback);
    }

    public final void purchase(PurchaseParams purchaseParams, PurchaseCallback callback) throws PurchasesException {
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.purchase(purchaseParams, callback);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchaseProduct(Activity activity, StoreProduct storeProduct, PurchaseCallback callback) throws PurchasesException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(callback, "callback");
        purchase(new PurchaseParams.Builder(activity, storeProduct).build(), callback);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchasePackage(Activity activity, Package packageToPurchase, PurchaseCallback listener) throws PurchasesException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        Intrinsics.checkNotNullParameter(listener, "listener");
        purchase(new PurchaseParams.Builder(activity, packageToPurchase).build(), listener);
    }

    public final void restorePurchases(ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.restorePurchases(callback);
    }

    public static /* synthetic */ void logIn$default(Purchases purchases, String str, LogInCallback logInCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            logInCallback = null;
        }
        purchases.logIn(str, logInCallback);
    }

    public final void logIn(String newAppUserID, LogInCallback callback) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        this.purchasesOrchestrator.logIn(newAppUserID, callback);
    }

    public static /* synthetic */ void logOut$default(Purchases purchases, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchases.logOut(receiveCustomerInfoCallback);
    }

    public final void logOut(ReceiveCustomerInfoCallback callback) {
        this.purchasesOrchestrator.logOut(callback);
    }

    public final void close() {
        notifyLifecycleClosed();
        this.purchasesOrchestrator.close();
        this.rewardVerificationPollLauncher.close();
        backingFieldSharedInstance = null;
    }

    private final void notifyLifecycleClosed() {
        serviceDispatcher.close(this);
    }

    public final void getCustomerInfo(ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(CacheFetchPolicy.INSTANCE.m13621default(), true, callback);
    }

    public final void getCustomerInfo(CacheFetchPolicy fetchPolicy, ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(fetchPolicy, true, callback);
    }

    public final void getVirtualCurrencies(GetVirtualCurrenciesCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getVirtualCurrencies(callback);
    }

    public final void invalidateVirtualCurrenciesCache() {
        this.purchasesOrchestrator.invalidateVirtualCurrenciesCache();
    }

    public final VirtualCurrencies getCachedVirtualCurrencies() {
        return this.purchasesOrchestrator.getCachedVirtualCurrencies();
    }

    public final void removeUpdatedCustomerInfoListener() {
        this.purchasesOrchestrator.removeUpdatedCustomerInfoListener();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showInAppMessagesIfNeeded$default(Purchases purchases, Activity activity, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.listOf(InAppMessageType.BILLING_ISSUES);
        }
        purchases.showInAppMessagesIfNeeded(activity, list);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        this.purchasesOrchestrator.showInAppMessagesIfNeeded(activity, inAppMessageTypes);
    }

    public static /* synthetic */ void showManageSubscriptions$default(Purchases purchases, Context context, ManageSubscriptionsCallback manageSubscriptionsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            manageSubscriptionsCallback = null;
        }
        purchases.showManageSubscriptions(context, manageSubscriptionsCallback);
    }

    public final void showManageSubscriptions(Context context, ManageSubscriptionsCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.purchasesOrchestrator.showManageSubscriptions(context, callback);
    }

    public final void invalidateCustomerInfoCache() {
        this.purchasesOrchestrator.invalidateCustomerInfoCache();
    }

    public final /* synthetic */ void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.purchasesOrchestrator.track(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackCustomPaywallImpression$default(Purchases purchases, CustomPaywallImpressionParams customPaywallImpressionParams, int i, Object obj) {
        int i2 = 1;
        if ((i & 1) != 0) {
            customPaywallImpressionParams = new CustomPaywallImpressionParams((String) null, i2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }
        purchases.trackCustomPaywallImpression(customPaywallImpressionParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[PHI: r1
      0x0047: PHI (r1v5 java.lang.String) = 
      (r1v3 java.lang.String)
      (r1v3 java.lang.String)
      (r1v3 java.lang.String)
      (r1v8 java.lang.String)
      (r1v8 java.lang.String)
      (r1v8 java.lang.String)
     binds: [B:25:0x005b, B:27:0x0061, B:29:0x0069, B:11:0x0032, B:13:0x0038, B:15:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void trackCustomPaywallImpression(CustomPaywallImpressionParams params) {
        String identifier;
        List<Package> availablePackages;
        Package r0;
        PresentedOfferingContext presentedOfferingContext;
        String str;
        PresentedOfferingContext presentedOfferingContext2;
        List<Package> availablePackages2;
        Package r02;
        PresentedOfferingContext.TargetingContext targetingContext;
        PresentedOfferingContext.TargetingContext targetingContext2;
        Intrinsics.checkNotNullParameter(params, "params");
        Offerings cachedOfferings = this.purchasesOrchestrator.getCachedOfferings();
        if (params.getPresentedOfferingContext() != null) {
            String offeringId = params.getOfferingId();
            presentedOfferingContext2 = params.getPresentedOfferingContext();
            str = offeringId;
        } else if (params.getOfferingId() != null) {
            Offering offering = cachedOfferings != null ? cachedOfferings.get(params.getOfferingId()) : null;
            identifier = params.getOfferingId();
            presentedOfferingContext = (offering == null || (availablePackages2 = offering.getAvailablePackages()) == null || (r02 = (Package) CollectionsKt.firstOrNull((List) availablePackages2)) == null) ? null : r02.getPresentedOfferingContext();
            str = identifier;
            presentedOfferingContext2 = presentedOfferingContext;
        } else {
            Offering current = cachedOfferings != null ? cachedOfferings.getCurrent() : null;
            identifier = current != null ? current.getIdentifier() : null;
            if (current != null && (availablePackages = current.getAvailablePackages()) != null && (r0 = (Package) CollectionsKt.firstOrNull((List) availablePackages)) != null) {
                presentedOfferingContext = r0.getPresentedOfferingContext();
            }
            str = identifier;
            presentedOfferingContext2 = presentedOfferingContext;
        }
        this.purchasesOrchestrator.track(new CustomPaywallEvent.Impression(null, new CustomPaywallEvent.Impression.Data(params.getPaywallId(), str, presentedOfferingContext2 != null ? presentedOfferingContext2.getPlacementIdentifier() : null, (presentedOfferingContext2 == null || (targetingContext2 = presentedOfferingContext2.getTargetingContext()) == null) ? null : Integer.valueOf(targetingContext2.getRevision()), (presentedOfferingContext2 == null || (targetingContext = presentedOfferingContext2.getTargetingContext()) == null) ? null : targetingContext.getRuleId()), 1, null));
    }

    public final void getCustomerCenterConfigData$purchases_defaultsRelease(GetCustomerCenterConfigCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerCenterConfig(callback);
    }

    public final void createSupportTicket(String email, String description, Function1<? super Boolean, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchasesOrchestrator.createSupportTicket(email, description, onSuccess, onError);
    }

    public final RewardVerificationToken generateRewardVerificationToken(String impressionId) {
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        String string2 = new JSONObject().put("api_key", this.purchasesOrchestrator.getCurrentConfiguration().getApiKey()).put("client_transaction_id", string).put("impression_id", impressionId).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "JSONObject()\n           …)\n            .toString()");
        return new RewardVerificationToken(string2, string, this.purchasesOrchestrator.getAppUserID());
    }

    public static /* synthetic */ void pollRewardVerification$default(Purchases purchases, String str, PollRewardVerificationCallback pollRewardVerificationCallback, RewardedAdTrackingMetadata rewardedAdTrackingMetadata, int i, Object obj) {
        if ((i & 4) != 0) {
            rewardedAdTrackingMetadata = null;
        }
        purchases.pollRewardVerification(str, pollRewardVerificationCallback, rewardedAdTrackingMetadata);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.Purchases$pollRewardVerification$1 */
    /* JADX INFO: compiled from: Purchases.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.Purchases$pollRewardVerification$1", m1609f = "Purchases.kt", m1610i = {}, m1611l = {881}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C70281 extends SuspendLambda implements Function1<Continuation<? super RewardVerificationResult>, Object> {
        final /* synthetic */ String $clientTransactionId;
        final /* synthetic */ RewardedAdTrackingMetadata $trackingMetadata;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C70281(String str, RewardedAdTrackingMetadata rewardedAdTrackingMetadata, Continuation<? super C70281> continuation) {
            super(1, continuation);
            this.$clientTransactionId = str;
            this.$trackingMetadata = rewardedAdTrackingMetadata;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return Purchases.this.new C70281(this.$clientTransactionId, this.$trackingMetadata, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super RewardVerificationResult> continuation) {
            return ((C70281) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            Object objAwaitPollRewardVerification = CoroutinesExtensionsKt.awaitPollRewardVerification(Purchases.this, this.$clientTransactionId, this.$trackingMetadata, this);
            return objAwaitPollRewardVerification == coroutine_suspended ? coroutine_suspended : objAwaitPollRewardVerification;
        }
    }

    public final void pollRewardVerification(String clientTransactionId, final PollRewardVerificationCallback callback, RewardedAdTrackingMetadata trackingMetadata) {
        Intrinsics.checkNotNullParameter(clientTransactionId, "clientTransactionId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.rewardVerificationPollLauncher.launch(new C70281(clientTransactionId, trackingMetadata, null), new Function1<RewardVerificationResult, Unit>() { // from class: com.revenuecat.purchases.Purchases.pollRewardVerification.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RewardVerificationResult rewardVerificationResult) {
                invoke2(rewardVerificationResult);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RewardVerificationResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onCompleted(it);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pollRewardVerification$purchases_defaultsRelease(String str, RewardedAdTrackingMetadata rewardedAdTrackingMetadata, AdCaptureMethod adCaptureMethod, Function2<? super String, ? super Continuation<? super Outcome>, ? extends Object> function2, Continuation<? super RewardVerificationResult> continuation) {
        C70303 c70303;
        Purchases purchases;
        RewardVerificationResult result;
        com.revenuecat.purchases.ads.rewardverification.VerifiedReward verifiedReward;
        List listPlus;
        RewardVerificationResult rewardVerificationResult;
        String str2 = str;
        RewardedAdTrackingMetadata rewardedAdTrackingMetadata2 = rewardedAdTrackingMetadata;
        AdCaptureMethod adCaptureMethod2 = adCaptureMethod;
        if (continuation instanceof C70303) {
            c70303 = (C70303) continuation;
            if ((c70303.label & Integer.MIN_VALUE) != 0) {
                c70303.label -= Integer.MIN_VALUE;
            } else {
                c70303 = new C70303(continuation);
            }
        }
        Object objInvoke = c70303.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c70303.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            if (rewardedAdTrackingMetadata2 != null) {
                getAdTracker().trackAdRewardEarnedUnverified(new AdRewardEarnedUnverifiedData(rewardedAdTrackingMetadata2.getNetworkName(), rewardedAdTrackingMetadata2.getMediatorName(), rewardedAdTrackingMetadata2.getAdFormat(), rewardedAdTrackingMetadata2.getPlacement(), rewardedAdTrackingMetadata2.getAdUnitId(), rewardedAdTrackingMetadata2.getImpressionId(), true, null), adCaptureMethod2);
            }
            try {
                c70303.L$0 = this;
                c70303.L$1 = str2;
                c70303.L$2 = rewardedAdTrackingMetadata2;
                c70303.L$3 = adCaptureMethod2;
                c70303.label = 1;
                objInvoke = function2.invoke(str2, c70303);
                if (objInvoke != coroutine_suspended) {
                    purchases = this;
                    Outcome outcome = (Outcome) objInvoke;
                    if (rewardedAdTrackingMetadata2 != null) {
                    }
                    result = OutcomeKt.toResult(outcome);
                    verifiedReward = result.getVerifiedReward();
                    if (verifiedReward != null) {
                    }
                    return result;
                }
                return coroutine_suspended;
            } catch (CancellationException e) {
                e = e;
                purchases = this;
                if (rewardedAdTrackingMetadata2 != null) {
                }
                throw e;
            }
        }
        if (i == 1) {
            AdCaptureMethod adCaptureMethod3 = (AdCaptureMethod) c70303.L$3;
            RewardedAdTrackingMetadata rewardedAdTrackingMetadata3 = (RewardedAdTrackingMetadata) c70303.L$2;
            str2 = (String) c70303.L$1;
            purchases = (Purchases) c70303.L$0;
            try {
                ResultKt.throwOnFailure(objInvoke);
                adCaptureMethod2 = adCaptureMethod3;
                rewardedAdTrackingMetadata2 = rewardedAdTrackingMetadata3;
            } catch (CancellationException e2) {
                e = e2;
                adCaptureMethod2 = adCaptureMethod3;
                rewardedAdTrackingMetadata2 = rewardedAdTrackingMetadata3;
                if (rewardedAdTrackingMetadata2 != null) {
                    purchases.trackRewardOutcome(rewardedAdTrackingMetadata2, Outcome.Failed.Cancelled.INSTANCE, adCaptureMethod2);
                }
                throw e;
            }
            try {
                Outcome outcome2 = (Outcome) objInvoke;
                if (rewardedAdTrackingMetadata2 != null) {
                    purchases.trackRewardOutcome(rewardedAdTrackingMetadata2, outcome2, adCaptureMethod2);
                }
                result = OutcomeKt.toResult(outcome2);
                verifiedReward = result.getVerifiedReward();
                if (verifiedReward != null || (listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(verifiedReward), (Iterable) result.getMoreRewards())) == null) {
                    return result;
                }
                List list = listPlus;
                boolean z2 = list instanceof Collection;
                if (!z2 || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((com.revenuecat.purchases.ads.rewardverification.VerifiedReward) it.next()) instanceof VerifiedReward.VirtualCurrency) {
                            purchases.purchasesOrchestrator.invalidateVirtualCurrenciesCache();
                            break;
                        }
                    }
                }
                if (!z2 || !list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (((com.revenuecat.purchases.ads.rewardverification.VerifiedReward) it2.next()) instanceof VerifiedReward.Entitlement) {
                            c70303.L$0 = result;
                            c70303.L$1 = null;
                            c70303.L$2 = null;
                            c70303.L$3 = null;
                            c70303.label = 2;
                            objInvoke = purchases.refreshCustomerInfoAfterEntitlementGrant(str2, c70303);
                            if (objInvoke != coroutine_suspended) {
                                rewardVerificationResult = result;
                                if (((Boolean) objInvoke).booleanValue()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                    }
                }
                rewardVerificationResult = result;
            } catch (CancellationException e3) {
                e = e3;
                if (rewardedAdTrackingMetadata2 != null) {
                }
                throw e;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            rewardVerificationResult = (RewardVerificationResult) c70303.L$0;
            ResultKt.throwOnFailure(objInvoke);
            if (((Boolean) objInvoke).booleanValue()) {
                z = false;
            } else {
                result = rewardVerificationResult;
                rewardVerificationResult = result;
            }
        }
        return z ? rewardVerificationResult : RewardVerificationResult.failed;
    }

    private final void trackRewardOutcome(RewardedAdTrackingMetadata trackingMetadata, Outcome outcome, AdCaptureMethod captureMethod) {
        if (outcome instanceof Outcome.Verified) {
            getAdTracker().trackAdRewardVerified(new AdRewardVerifiedData(trackingMetadata.getNetworkName(), trackingMetadata.getMediatorName(), trackingMetadata.getAdFormat(), trackingMetadata.getPlacement(), trackingMetadata.getAdUnitId(), trackingMetadata.getImpressionId(), null), captureMethod);
            Outcome.Verified verified = (Outcome.Verified) outcome;
            List listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(verified.getReward()), (Iterable) verified.getMoreRewards());
            ArrayList arrayList = new ArrayList();
            for (Object obj : listPlus) {
                if (!(((com.revenuecat.purchases.ads.rewardverification.VerifiedReward) obj) instanceof VerifiedReward.NoReward)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                getAdTracker().trackAdRewardGranted(new AdRewardGrantedData(trackingMetadata.getNetworkName(), trackingMetadata.getMediatorName(), trackingMetadata.getAdFormat(), trackingMetadata.getPlacement(), trackingMetadata.getAdUnitId(), trackingMetadata.getImpressionId(), toCoreVerifiedReward((com.revenuecat.purchases.ads.rewardverification.VerifiedReward) it.next()), null), captureMethod);
            }
            return;
        }
        if (outcome instanceof Outcome.Failed) {
            getAdTracker().trackAdRewardFailedToVerify(new AdRewardFailedToVerifyData(trackingMetadata.getNetworkName(), trackingMetadata.getMediatorName(), trackingMetadata.getAdFormat(), trackingMetadata.getPlacement(), trackingMetadata.getAdUnitId(), trackingMetadata.getImpressionId(), ((Outcome.Failed) outcome).getTrackingFailureReason(), null), captureMethod);
        }
    }

    private final VerifiedReward toCoreVerifiedReward(com.revenuecat.purchases.ads.rewardverification.VerifiedReward verifiedReward) {
        if (verifiedReward instanceof VerifiedReward.VirtualCurrency) {
            VerifiedReward.VirtualCurrency virtualCurrency = (VerifiedReward.VirtualCurrency) verifiedReward;
            return new VerifiedReward.VirtualCurrency(virtualCurrency.getCode(), virtualCurrency.getAmount());
        }
        if (!(verifiedReward instanceof VerifiedReward.Entitlement)) {
            return Intrinsics.areEqual(verifiedReward, VerifiedReward.NoReward.INSTANCE) ? VerifiedReward.NoReward.INSTANCE : VerifiedReward.UnsupportedReward.INSTANCE;
        }
        VerifiedReward.Entitlement entitlement = (VerifiedReward.Entitlement) verifiedReward;
        return new VerifiedReward.Entitlement(entitlement.getIdentifier(), entitlement.getExpiresAt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cc, code lost:
    
        if (com.revenuecat.purchases.ads.rewardverification.RewardVerificationRetryKt.rewardVerificationRetryDelay(r0) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00be -> B:40:0x00cf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00cc -> B:40:0x00cf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshCustomerInfoAfterEntitlementGrant(String str, Continuation<? super Boolean> continuation) {
        C70311 c70311;
        Purchases purchases;
        String str2;
        int i;
        PurchasesException e;
        String str3;
        LogLevel logLevel;
        if (continuation instanceof C70311) {
            c70311 = (C70311) continuation;
            if ((c70311.label & Integer.MIN_VALUE) != 0) {
                c70311.label -= Integer.MIN_VALUE;
            } else {
                c70311 = new C70311(continuation);
            }
        }
        Object obj = c70311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c70311.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler.mo1541d("[Purchases] - " + logLevel2.name(), "Reward verification granted an entitlement; refreshing CustomerInfo (transactionId=" + str + ").");
            }
            purchases = this;
            str2 = str;
            i = 0;
            if (i < 3) {
            }
            logLevel = LogLevel.WARN;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            }
            return Boxing.boxBoolean(false);
        }
        if (i2 == 1) {
            i = c70311.I$0;
            str3 = (String) c70311.L$1;
            purchases = (Purchases) c70311.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (PurchasesException e2) {
                e = e2;
                if (e.getCode() != PurchasesErrorCode.NetworkError) {
                }
            }
            return Boxing.boxBoolean(true);
        }
        if (i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = c70311.I$0;
        str3 = (String) c70311.L$1;
        purchases = (Purchases) c70311.L$0;
        ResultKt.throwOnFailure(obj);
        str2 = str3;
        if (i < 3) {
            try {
            } catch (PurchasesException e3) {
                str3 = str2;
                e = e3;
                if (e.getCode() != PurchasesErrorCode.NetworkError) {
                    i++;
                    if (i < 3) {
                        c70311.L$0 = purchases;
                        c70311.L$1 = str3;
                        c70311.I$0 = i;
                        c70311.label = 2;
                    }
                    str2 = str3;
                    if (i < 3) {
                    }
                    logLevel = LogLevel.WARN;
                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    }
                    return Boxing.boxBoolean(false);
                }
                str2 = str3;
                logLevel = LogLevel.WARN;
                LogHandler currentLogHandler222 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                }
                return Boxing.boxBoolean(false);
            }
            CacheFetchPolicy cacheFetchPolicy = CacheFetchPolicy.FETCH_CURRENT;
            c70311.L$0 = purchases;
            c70311.L$1 = str2;
            c70311.I$0 = i;
            c70311.label = 1;
            if (CoroutinesExtensionsKt.awaitCustomerInfo(purchases, cacheFetchPolicy, c70311) != coroutine_suspended) {
                str3 = str2;
                return Boxing.boxBoolean(true);
            }
            return coroutine_suspended;
        }
        logLevel = LogLevel.WARN;
        LogHandler currentLogHandler2222 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler2222.mo1545w("[Purchases] - " + logLevel.name(), "Reward verification could not refresh CustomerInfo after an entitlement grant (transactionId=" + str2 + "). The grant persists server-side and will sync on a later fetch.");
        }
        return Boxing.boxBoolean(false);
    }

    public final void getRewardVerificationResult$purchases_defaultsRelease(String clientTransactionId, GetRewardVerificationResultCallback callback) {
        Intrinsics.checkNotNullParameter(clientTransactionId, "clientTransactionId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getRewardVerificationResult(clientTransactionId, callback);
    }

    public final void setAttributes(Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.purchasesOrchestrator.setAttributes(attributes);
    }

    public final void setEmail(String email) {
        this.purchasesOrchestrator.setEmail(email);
    }

    public final void setPhoneNumber(String phoneNumber) {
        this.purchasesOrchestrator.setPhoneNumber(phoneNumber);
    }

    public final void setDisplayName(String displayName) {
        this.purchasesOrchestrator.setDisplayName(displayName);
    }

    public final void setPushToken(String fcmToken) {
        this.purchasesOrchestrator.setPushToken(fcmToken);
    }

    public final void setMixpanelDistinctID(String mixpanelDistinctID) {
        this.purchasesOrchestrator.setMixpanelDistinctID(mixpanelDistinctID);
    }

    public final void setOnesignalID(String onesignalID) {
        this.purchasesOrchestrator.setOnesignalID(onesignalID);
    }

    public final void setOnesignalUserID(String onesignalUserID) {
        this.purchasesOrchestrator.setOnesignalUserID(onesignalUserID);
    }

    public final void setAirshipChannelID(String airshipChannelID) {
        this.purchasesOrchestrator.setAirshipChannelID(airshipChannelID);
    }

    public final void setFirebaseAppInstanceID(String firebaseAppInstanceID) {
        this.purchasesOrchestrator.setFirebaseAppInstanceID(firebaseAppInstanceID);
    }

    public final void setTenjinAnalyticsInstallationID(String tenjinAnalyticsInstallationID) {
        this.purchasesOrchestrator.setTenjinAnalyticsInstallationID(tenjinAnalyticsInstallationID);
    }

    public final void setPostHogUserId(String postHogUserId) {
        this.purchasesOrchestrator.setPostHogUserId(postHogUserId);
    }

    public final void collectDeviceIdentifiers() {
        this.purchasesOrchestrator.collectDeviceIdentifiers();
    }

    public final void setAdjustID(String adjustID) {
        this.purchasesOrchestrator.setAdjustID(adjustID);
    }

    public final void setAppsflyerID(String appsflyerID) {
        this.purchasesOrchestrator.setAppsflyerID(appsflyerID);
    }

    public final void setFBAnonymousID(String fbAnonymousID) {
        this.purchasesOrchestrator.setFBAnonymousID(fbAnonymousID);
    }

    public final void setMparticleID(String mparticleID) {
        this.purchasesOrchestrator.setMparticleID(mparticleID);
    }

    public final void setCleverTapID(String cleverTapID) {
        this.purchasesOrchestrator.setCleverTapID(cleverTapID);
    }

    public final void setKochavaDeviceID(String kochavaDeviceID) {
        this.purchasesOrchestrator.setKochavaDeviceID(kochavaDeviceID);
    }

    public final void setAirbridgeDeviceID(String airbridgeDeviceID) {
        this.purchasesOrchestrator.setAirbridgeDeviceID(airbridgeDeviceID);
    }

    public final void setSolarEngineDistinctId(String solarEngineDistinctId) {
        this.purchasesOrchestrator.setSolarEngineDistinctId(solarEngineDistinctId);
    }

    public final void setSolarEngineAccountId(String solarEngineAccountId) {
        this.purchasesOrchestrator.setSolarEngineAccountId(solarEngineAccountId);
    }

    public final void setSolarEngineVisitorId(String solarEngineVisitorId) {
        this.purchasesOrchestrator.setSolarEngineVisitorId(solarEngineVisitorId);
    }

    public final void setSingularDeviceID(String singularDeviceID) {
        this.purchasesOrchestrator.setSingularDeviceID(singularDeviceID);
    }

    public final void setAppsFlyerConversionData(Map<?, ?> data) {
        this.purchasesOrchestrator.setAppsFlyerConversionData(data);
    }

    public final void setAppstackAttributionParams(Map<String, String> data, SyncAttributesAndOfferingsCallback callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.setAppstackAttributionParams(data, callback);
    }

    public final void setMediaSource(String mediaSource) {
        this.purchasesOrchestrator.setMediaSource(mediaSource);
    }

    public final void setCampaign(String campaign) {
        this.purchasesOrchestrator.setCampaign(campaign);
    }

    public final void setAdGroup(String adGroup) {
        this.purchasesOrchestrator.setAdGroup(adGroup);
    }

    public final void setAd(String ad) {
        this.purchasesOrchestrator.setAd(ad);
    }

    public final void setKeyword(String keyword) {
        this.purchasesOrchestrator.setKeyword(keyword);
    }

    public final void setCreative(String creative) {
        this.purchasesOrchestrator.setCreative(creative);
    }

    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        return this.purchasesOrchestrator.getCachedFontFamilyOrStartDownload(fontInfo);
    }

    public final synchronized boolean getAllowSharingPlayStoreAccount() {
        return this.purchasesOrchestrator.getAllowSharingPlayStoreAccount();
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z) {
        this.purchasesOrchestrator.setAllowSharingPlayStoreAccount(z);
    }

    public final synchronized String getPreferredUILocaleOverride() {
        return this.purchasesOrchestrator.get_preferredUILocaleOverride();
    }

    public final boolean overridePreferredUILocale(String localeString) {
        return this.purchasesOrchestrator.overridePreferredUILocale(localeString);
    }

    @Deprecated(message = "Replaced with getProducts() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProducts()", imports = {}))
    public final void getSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(productIds), SetsKt.setOf(ProductType.SUBS), callback);
    }

    @Deprecated(message = "Replaced with getProducts() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProducts()", imports = {}))
    public final void getNonSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(productIds), SetsKt.setOf(ProductType.INAPP), callback);
    }

    public final void getAmazonLWAConsentStatus(GetAmazonLWAConsentStatusCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getAmazonLWAConsentStatus(callback);
    }

    public final void redeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, RedeemWebPurchaseListener listener) {
        Intrinsics.checkNotNullParameter(webPurchaseRedemption, "webPurchaseRedemption");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.purchasesOrchestrator.redeemWebPurchase(webPurchaseRedemption, listener);
    }

    /* JADX INFO: compiled from: Purchases.kt */
    @Metadata(m1598d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020G0F2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0IH\u0007J\u0010\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020LH\u0007J\u0012\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020PH\u0007J\u0012\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00148\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u0018\u0010\u0010R*\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u001a8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\u0002\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010)\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020(8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\u0002\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R.\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u000b\u001a\u0004\u0018\u00010/8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\u0002\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0002078\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010\u0002\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R*\u0010=\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00068F@AX\u0087\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\u0002\u001a\u0004\b?\u0010\b\"\u0004\b@\u0010\n¨\u0006R"}, m1599d2 = {"Lcom/revenuecat/purchases/Purchases$Companion;", "", "()V", "MAX_ENTITLEMENT_REFRESH_ATTEMPTS", "", "backingFieldSharedInstance", "Lcom/revenuecat/purchases/Purchases;", "getBackingFieldSharedInstance$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/Purchases;", "setBackingFieldSharedInstance$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/Purchases;)V", "value", "", "debugLogsEnabled", "getDebugLogsEnabled$annotations", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "frameworkVersion", "", "getFrameworkVersion$annotations", "getFrameworkVersion", "()Ljava/lang/String;", "isConfigured", "isConfigured$annotations", "Lcom/revenuecat/purchases/LogHandler;", "logHandler", "getLogHandler$annotations", "getLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "Lcom/revenuecat/purchases/LogLevel;", "logLevel", "getLogLevel$annotations", "getLogLevel", "()Lcom/revenuecat/purchases/LogLevel;", "setLogLevel", "(Lcom/revenuecat/purchases/LogLevel;)V", "Lcom/revenuecat/purchases/common/PlatformInfo;", "platformInfo", "getPlatformInfo$annotations", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "setPlatformInfo", "(Lcom/revenuecat/purchases/common/PlatformInfo;)V", "Ljava/net/URL;", "proxyURL", "getProxyURL$annotations", "getProxyURL", "()Ljava/net/URL;", "setProxyURL", "(Ljava/net/URL;)V", "serviceDispatcher", "Lcom/revenuecat/purchases/PurchasesServiceDispatcher;", "getServiceDispatcher$purchases_defaultsRelease$annotations", "getServiceDispatcher$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PurchasesServiceDispatcher;", "setServiceDispatcher$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/PurchasesServiceDispatcher;)V", "sharedInstance", "getSharedInstance$annotations", "getSharedInstance", "setSharedInstance$purchases_defaultsRelease", "canMakePayments", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "features", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "callback", "Lcom/revenuecat/purchases/interfaces/Callback;", "configure", "configuration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "parseAsWebPurchaseRedemption", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", "intent", "Landroid/content/Intent;", TypedValues.Custom.S_STRING, "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use logLevel instead")
        @JvmStatic
        public static /* synthetic */ void getDebugLogsEnabled$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getFrameworkVersion$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getLogHandler$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getLogLevel$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getPlatformInfo$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getProxyURL$annotations() {
        }

        public static /* synthetic */ void getServiceDispatcher$purchases_defaultsRelease$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getSharedInstance$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isConfigured$annotations() {
        }

        @JvmStatic
        public final void canMakePayments(Context context, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            canMakePayments$default(this, context, null, callback, 2, null);
        }

        private Companion() {
        }

        public final PurchasesServiceDispatcher getServiceDispatcher$purchases_defaultsRelease() {
            return Purchases.serviceDispatcher;
        }

        public final void setServiceDispatcher$purchases_defaultsRelease(PurchasesServiceDispatcher purchasesServiceDispatcher) {
            Intrinsics.checkNotNullParameter(purchasesServiceDispatcher, "<set-?>");
            Purchases.serviceDispatcher = purchasesServiceDispatcher;
        }

        @JvmStatic
        public final WebPurchaseRedemption parseAsWebPurchaseRedemption(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Uri data = intent.getData();
            if (data == null) {
                return null;
            }
            return DeepLinkParser.INSTANCE.parseWebPurchaseRedemption(data);
        }

        @JvmStatic
        public final WebPurchaseRedemption parseAsWebPurchaseRedemption(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            try {
                Uri uri = Uri.parse(string);
                DeepLinkParser deepLinkParser = DeepLinkParser.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                return deepLinkParser.parseWebPurchaseRedemption(uri);
            } catch (Throwable th) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Error parsing URL: " + string, th);
                return null;
            }
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.INSTANCE.getPlatformInfo();
        }

        public final void setPlatformInfo(PlatformInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.INSTANCE.setPlatformInfo(value);
        }

        public final boolean getDebugLogsEnabled() {
            return PurchasesOrchestrator.INSTANCE.getDebugLogsEnabled();
        }

        public final void setDebugLogsEnabled(boolean z) {
            PurchasesOrchestrator.INSTANCE.setDebugLogsEnabled(z);
        }

        public final LogLevel getLogLevel() {
            return PurchasesOrchestrator.INSTANCE.getLogLevel();
        }

        public final void setLogLevel(LogLevel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.INSTANCE.setLogLevel(value);
        }

        public final synchronized LogHandler getLogHandler() {
            return PurchasesOrchestrator.INSTANCE.getLogHandler();
        }

        public final synchronized void setLogHandler(LogHandler value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.INSTANCE.setLogHandler(value);
        }

        public final Purchases getBackingFieldSharedInstance$purchases_defaultsRelease() {
            return Purchases.backingFieldSharedInstance;
        }

        public final void setBackingFieldSharedInstance$purchases_defaultsRelease(Purchases purchases) {
            Purchases.backingFieldSharedInstance = purchases;
        }

        public final Purchases getSharedInstance() {
            Purchases backingFieldSharedInstance$purchases_defaultsRelease = getBackingFieldSharedInstance$purchases_defaultsRelease();
            if (backingFieldSharedInstance$purchases_defaultsRelease != null) {
                return backingFieldSharedInstance$purchases_defaultsRelease;
            }
            throw new UninitializedPropertyAccessException(ConfigureStrings.NO_SINGLETON_INSTANCE);
        }

        public final void setSharedInstance$purchases_defaultsRelease(Purchases value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Purchases backingFieldSharedInstance$purchases_defaultsRelease = getBackingFieldSharedInstance$purchases_defaultsRelease();
            if (backingFieldSharedInstance$purchases_defaultsRelease != null) {
                backingFieldSharedInstance$purchases_defaultsRelease.close();
            }
            setBackingFieldSharedInstance$purchases_defaultsRelease(value);
        }

        public final String getFrameworkVersion() {
            return Purchases.frameworkVersion;
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.INSTANCE.getProxyURL();
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.INSTANCE.setProxyURL(url);
        }

        public final boolean isConfigured() {
            return getBackingFieldSharedInstance$purchases_defaultsRelease() != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final Purchases configure(PurchasesConfiguration configuration) {
            PurchasesOrchestrator purchasesOrchestrator;
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            APIKeyValidator aPIKeyValidator = null;
            Object[] objArr = 0;
            if (isConfigured()) {
                Purchases backingFieldSharedInstance$purchases_defaultsRelease = getBackingFieldSharedInstance$purchases_defaultsRelease();
                if (Intrinsics.areEqual((backingFieldSharedInstance$purchases_defaultsRelease == null || (purchasesOrchestrator = backingFieldSharedInstance$purchases_defaultsRelease.getPurchasesOrchestrator()) == null) ? null : purchasesOrchestrator.getCurrentConfiguration(), configuration)) {
                    LogLevel logLevel = LogLevel.INFO;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.mo1543i("[Purchases] - " + logLevel.name(), ConfigureStrings.INSTANCE_ALREADY_EXISTS_WITH_SAME_CONFIG);
                    }
                    return getSharedInstance();
                }
                LogLevel logLevel2 = LogLevel.INFO;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1543i("[Purchases] - " + logLevel2.name(), ConfigureStrings.INSTANCE_ALREADY_EXISTS);
                }
            }
            Purchases purchasesCreatePurchases$default = PurchasesFactory.createPurchases$default(new PurchasesFactory(new DefaultIsDebugBuildProvider(configuration.getContext()), aPIKeyValidator, 2, objArr == true ? 1 : 0), configuration, getPlatformInfo(), getProxyURL(), null, null, false, false, null, 248, null);
            Purchases.INSTANCE.setSharedInstance$purchases_defaultsRelease(purchasesCreatePurchases$default);
            Purchases.INSTANCE.getServiceDispatcher$purchases_defaultsRelease().initialize(purchasesCreatePurchases$default);
            return purchasesCreatePurchases$default;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            companion.canMakePayments(context, list, callback);
        }

        @JvmStatic
        public final void canMakePayments(Context context, List<? extends BillingFeature> features, Callback<Boolean> callback) {
            LogHandler currentLogHandler;
            String str;
            String strInvoke;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (getSharedInstance().getPurchasesOrchestrator().getAppConfig().getStore() == Store.PLAY_STORE) {
                PurchasesOrchestrator.INSTANCE.canMakePayments(context, features, callback);
                return;
            }
            final LogIntent logIntent = LogIntent.RC_ERROR;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.Purchases$Companion$canMakePayments$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " canMakePayments requires the Google Play Store. Skipping any checks and returning true.";
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
            callback.onReceived(true);
        }
    }

    public static final synchronized LogHandler getLogHandler() {
        return INSTANCE.getLogHandler();
    }

    public static final synchronized void setLogHandler(LogHandler logHandler) {
        INSTANCE.setLogHandler(logHandler);
    }
}
