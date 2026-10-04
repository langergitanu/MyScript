package com.revenuecat.purchases;

import android.content.Context;
import com.revenuecat.purchases.ads.events.AdCaptureMethod;
import com.revenuecat.purchases.ads.rewardverification.Outcome;
import com.revenuecat.purchases.ads.rewardverification.Poller;
import com.revenuecat.purchases.ads.rewardverification.RewardedAdTrackingMetadata;
import com.revenuecat.purchases.common.CancellableContinuationExtensionsKt;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.data.LogInResult;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetRewardVerificationResultCallback;
import com.revenuecat.purchases.interfaces.ManageSubscriptionsCallback;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: coroutinesExtensions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0006\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0087@¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a\u001a\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0012\u001a\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0012\u001a\u0012\u0010\u0018\u001a\u00020\u000b*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t\u001a&\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0086@¢\u0006\u0002\u0010\u001d\u001a,\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0087@¢\u0006\u0002\u0010 \u001a&\u0010!\u001a\u00020\"*\u00020\u00022\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040$H\u0086@¢\u0006\u0002\u0010%\u001a\u001a\u0010&\u001a\u00020'*\u00020\u00022\u0006\u0010(\u001a\u00020)H\u0086@¢\u0006\u0002\u0010*\u001a\u0012\u0010+\u001a\u00020,*\u00020\u0002H\u0087@¢\u0006\u0002\u0010\t\u001a\u0012\u0010-\u001a\u00020\"*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t\u001a\u0012\u0010.\u001a\u00020\u000b*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t\u001a\u0012\u0010/\u001a\u000200*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t¨\u00061"}, m1599d2 = {"awaitCreateSupportTicket", "Lcom/revenuecat/purchases/CreateSupportTicketResult;", "Lcom/revenuecat/purchases/Purchases;", "email", "", "description", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerCenterConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "(Lcom/revenuecat/purchases/Purchases;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/CacheFetchPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetRewardVerificationResult", "Lcom/revenuecat/purchases/RewardVerificationPollStatus;", "clientTransactionId", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "awaitLogIn", "Lcom/revenuecat/purchases/data/LogInResult;", "appUserID", "awaitLogOut", "awaitPollRewardVerification", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult;", "trackingMetadata", "Lcom/revenuecat/purchases/ads/rewardverification/RewardedAdTrackingMetadata;", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lcom/revenuecat/purchases/ads/rewardverification/RewardedAdTrackingMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lcom/revenuecat/purchases/ads/rewardverification/RewardedAdTrackingMetadata;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSetAppstackAttributionParams", "Lcom/revenuecat/purchases/Offerings;", "data", "", "(Lcom/revenuecat/purchases/Purchases;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitShowManageSubscriptions", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "(Lcom/revenuecat/purchases/Purchases;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitStorefrontLocale", "Ljava/util/Locale;", "awaitSyncAttributesAndOfferingsIfNeeded", "awaitSyncPurchases", "getAmazonLWAConsentStatus", "Lcom/revenuecat/purchases/AmazonLWAConsentStatus;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CoroutinesExtensionsKt {
    public static /* synthetic */ Object awaitCustomerInfo$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Continuation continuation, int i, Object obj) throws PurchasesException {
        if ((i & 1) != 0) {
            cacheFetchPolicy = CacheFetchPolicy.INSTANCE.m13621default();
        }
        return awaitCustomerInfo(purchases, cacheFetchPolicy, continuation);
    }

    public static /* synthetic */ Object awaitPollRewardVerification$default(Purchases purchases, String str, RewardedAdTrackingMetadata rewardedAdTrackingMetadata, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            rewardedAdTrackingMetadata = null;
        }
        return awaitPollRewardVerification(purchases, str, rewardedAdTrackingMetadata, continuation);
    }

    public static final /* synthetic */ Object awaitPollRewardVerification(Purchases purchases, String str, RewardedAdTrackingMetadata rewardedAdTrackingMetadata, Continuation continuation) {
        return awaitPollRewardVerification(purchases, str, rewardedAdTrackingMetadata, AdCaptureMethod.MANUAL, continuation);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitPollRewardVerification$3 */
    /* JADX INFO: compiled from: coroutinesExtensions.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome;", "it", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.CoroutinesExtensionsKt$awaitPollRewardVerification$3", m1609f = "coroutinesExtensions.kt", m1610i = {}, m1611l = {HttpStatusCodesKt.HTTP_EARLY_HINTS}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C69743 extends SuspendLambda implements Function2<String, Continuation<? super Outcome>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C69743(Continuation<? super C69743> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C69743 c69743 = new C69743(continuation);
            c69743.L$0 = obj;
            return c69743;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Outcome> continuation) {
            return ((C69743) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
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
            String str = (String) this.L$0;
            this.label = 1;
            Object objPoll$default = Poller.poll$default(Poller.INSTANCE, str, null, null, null, 0, null, this, 62, null);
            return objPoll$default == coroutine_suspended ? coroutine_suspended : objPoll$default;
        }
    }

    public static final /* synthetic */ Object awaitPollRewardVerification(Purchases purchases, String str, RewardedAdTrackingMetadata rewardedAdTrackingMetadata, AdCaptureMethod adCaptureMethod, Continuation continuation) {
        return purchases.pollRewardVerification$purchases_defaultsRelease(str, rewardedAdTrackingMetadata, adCaptureMethod, new C69743(null), continuation);
    }

    public static final /* synthetic */ Object awaitCustomerInfo(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsKt.getCustomerInfoWith(purchases, cacheFetchPolicy, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerInfo$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerInfo$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, it);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitShowManageSubscriptions(Purchases purchases, Context context, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        purchases.showManageSubscriptions(context, new ManageSubscriptionsCallback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitShowManageSubscriptions$2$1
            @Override // com.revenuecat.purchases.interfaces.ManageSubscriptionsCallback
            public void onSuccess() {
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, Unit.INSTANCE);
            }

            @Override // com.revenuecat.purchases.interfaces.ManageSubscriptionsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(error));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public static final /* synthetic */ Object awaitLogIn(Purchases purchases, String str, Continuation continuation) throws PurchasesTransactionException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsKt.logInWith(purchases, str, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogIn$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        }, new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogIn$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo, Boolean bool) {
                invoke(customerInfo, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(CustomerInfo customerInfo, boolean z) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, new LogInResult(customerInfo, z));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitLogOut(Purchases purchases, Continuation continuation) throws PurchasesTransactionException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsKt.logOutWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogOut$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogOut$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, it);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitSyncPurchases(Purchases purchases, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsKt.syncPurchasesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncPurchases$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncPurchases$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, it);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitSyncAttributesAndOfferingsIfNeeded(Purchases purchases, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsKt.syncAttributesAndOfferingsIfNeededWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, it);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitSetAppstackAttributionParams(Purchases purchases, Map map, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        purchases.setAppstackAttributionParams(map, ListenerConversionsKt.syncAttributesAndOfferingsListener(new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSetAppstackAttributionParams$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, it);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSetAppstackAttributionParams$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object getAmazonLWAConsentStatus(Purchases purchases, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsKt.getAmazonLWAConsentStatusWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        }, new Function1<AmazonLWAConsentStatus, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, it);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitCustomerCenterConfigData(Purchases purchases, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        purchases.getCustomerCenterConfigData$purchases_defaultsRelease(new GetCustomerCenterConfigCallback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerCenterConfigData$2$1
            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onSuccess(CustomerCenterConfigData customerCenterConfig) {
                Intrinsics.checkNotNullParameter(customerCenterConfig, "customerCenterConfig");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, customerCenterConfig);
            }

            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(error));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitGetRewardVerificationResult(Purchases purchases, String str, Continuation continuation) throws RewardVerificationException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        purchases.getRewardVerificationResult$purchases_defaultsRelease(str, new GetRewardVerificationResultCallback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitGetRewardVerificationResult$2$1
            @Override // com.revenuecat.purchases.interfaces.GetRewardVerificationResultCallback
            public void onReceived(RewardVerificationPollStatus result) {
                Intrinsics.checkNotNullParameter(result, "result");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, result);
            }

            @Override // com.revenuecat.purchases.interfaces.GetRewardVerificationResultCallback
            public void onError(RewardVerificationError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new RewardVerificationException(error.getError(), error.isServerError()));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitGetVirtualCurrencies(Purchases purchases, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsKt.getVirtualCurrenciesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        }, new Function1<VirtualCurrencies, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VirtualCurrencies virtualCurrencies) {
                invoke2(virtualCurrencies);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VirtualCurrencies it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, it);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final Object awaitStorefrontLocale(Purchases purchases, Continuation<? super Locale> continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsKt.getStorefrontLocaleWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitStorefrontLocale$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        }, new Function1<Locale, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitStorefrontLocale$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Locale locale) {
                invoke2(locale);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Locale it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, it);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitCreateSupportTicket(Purchases purchases, String str, String str2, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        purchases.createSupportTicket(str, str2, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCreateSupportTicket$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, new CreateSupportTicketResult(z));
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCreateSupportTicket$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesException(it));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
