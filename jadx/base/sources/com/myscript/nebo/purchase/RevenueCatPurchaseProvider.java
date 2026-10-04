package com.myscript.nebo.purchase;

import android.app.Application;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: RevenueCatPurchaseProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0014H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000fH\u0096@¢\u0006\u0004\b\u001a\u0010\u0017J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000fH\u0096@¢\u0006\u0004\b\u001d\u0010\u0017J\u0014\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\u0002\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m1599d2 = {"Lcom/myscript/nebo/purchase/RevenueCatPurchaseProvider;", "Lcom/myscript/nebo/purchase/IPurchaseProvider;", WebViewMessageType.CONTEXT, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "enableDebugMode", "", "isConfigured", "", "configure", "appUserId", "", "apiKey", "login", "Lkotlin/Result;", "login-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAttributes", "attributes", "", "syncPurchases", "syncPurchases-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncAttributesAndOfferingsIfNeeded", "Lcom/revenuecat/purchases/Offerings;", "syncAttributesAndOfferingsIfNeeded-IoAF18A", "getCustomerInfoWith", "Lcom/myscript/nebo/purchase/CustomerInfoResult;", "getCustomerInfoWith-IoAF18A", "toPurchaseException", "Lcom/myscript/nebo/purchase/PurchaseException;", "Lcom/revenuecat/purchases/PurchasesError;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RevenueCatPurchaseProvider implements IPurchaseProvider {
    private static final String RC_ENTITLEMENT_ID = "MyScript Notes – Full Access";
    private final Application context;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: RevenueCatPurchaseProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesErrorCode.values().length];
            try {
                iArr[PurchasesErrorCode.PurchaseNotAllowedError.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesErrorCode.StoreProblemError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchasesErrorCode.NetworkError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RevenueCatPurchaseProvider(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.myscript.nebo.purchase.IPurchaseProvider
    public void enableDebugMode() {
        Purchases.INSTANCE.setLogLevel(LogLevel.DEBUG);
    }

    @Override // com.myscript.nebo.purchase.IPurchaseProvider
    public boolean isConfigured() {
        return Purchases.INSTANCE.isConfigured();
    }

    @Override // com.myscript.nebo.purchase.IPurchaseProvider
    public void configure(String appUserId, String apiKey) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Purchases.INSTANCE.configure(new PurchasesConfiguration.Builder(this.context, apiKey).appUserID(appUserId).build());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.purchase.IPurchaseProvider
    /* JADX INFO: renamed from: login-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo13347logingIAlus(final String str, Continuation<? super Result<Unit>> continuation) {
        RevenueCatPurchaseProvider$login$1 revenueCatPurchaseProvider$login$1;
        if (continuation instanceof RevenueCatPurchaseProvider$login$1) {
            revenueCatPurchaseProvider$login$1 = (RevenueCatPurchaseProvider$login$1) continuation;
            if ((revenueCatPurchaseProvider$login$1.label & Integer.MIN_VALUE) != 0) {
                revenueCatPurchaseProvider$login$1.label -= Integer.MIN_VALUE;
            } else {
                revenueCatPurchaseProvider$login$1 = new RevenueCatPurchaseProvider$login$1(this, continuation);
            }
        }
        Object result = revenueCatPurchaseProvider$login$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = revenueCatPurchaseProvider$login$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            revenueCatPurchaseProvider$login$1.L$0 = str;
            revenueCatPurchaseProvider$login$1.I$0 = 0;
            revenueCatPurchaseProvider$login$1.label = 1;
            RevenueCatPurchaseProvider$login$1 revenueCatPurchaseProvider$login$12 = revenueCatPurchaseProvider$login$1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(revenueCatPurchaseProvider$login$12), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            Purchases.INSTANCE.getSharedInstance().logIn(str, new LogInCallback() { // from class: com.myscript.nebo.purchase.RevenueCatPurchaseProvider$login$2$1
                @Override // com.revenuecat.purchases.interfaces.LogInCallback
                public void onError(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    CancellableContinuation<Result<Unit>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(this.toPurchaseException(error, "RC login failed(" + str + ")"))));
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                }

                @Override // com.revenuecat.purchases.interfaces.LogInCallback
                public void onReceived(CustomerInfo customerInfo, boolean created) {
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    CancellableContinuation<Result<Unit>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(Unit.INSTANCE));
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(revenueCatPurchaseProvider$login$12);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = revenueCatPurchaseProvider$login$1.I$0;
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    @Override // com.myscript.nebo.purchase.IPurchaseProvider
    public void setAttributes(Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Purchases.INSTANCE.getSharedInstance().setAttributes(attributes);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.purchase.IPurchaseProvider
    /* JADX INFO: renamed from: syncPurchases-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo13349syncPurchasesIoAF18A(Continuation<? super Result<Unit>> continuation) {
        RevenueCatPurchaseProvider$syncPurchases$1 revenueCatPurchaseProvider$syncPurchases$1;
        if (continuation instanceof RevenueCatPurchaseProvider$syncPurchases$1) {
            revenueCatPurchaseProvider$syncPurchases$1 = (RevenueCatPurchaseProvider$syncPurchases$1) continuation;
            if ((revenueCatPurchaseProvider$syncPurchases$1.label & Integer.MIN_VALUE) != 0) {
                revenueCatPurchaseProvider$syncPurchases$1.label -= Integer.MIN_VALUE;
            } else {
                revenueCatPurchaseProvider$syncPurchases$1 = new RevenueCatPurchaseProvider$syncPurchases$1(this, continuation);
            }
        }
        Object result = revenueCatPurchaseProvider$syncPurchases$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = revenueCatPurchaseProvider$syncPurchases$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            revenueCatPurchaseProvider$syncPurchases$1.I$0 = 0;
            revenueCatPurchaseProvider$syncPurchases$1.label = 1;
            RevenueCatPurchaseProvider$syncPurchases$1 revenueCatPurchaseProvider$syncPurchases$12 = revenueCatPurchaseProvider$syncPurchases$1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(revenueCatPurchaseProvider$syncPurchases$12), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            Purchases.INSTANCE.getSharedInstance().syncPurchases(new SyncPurchasesCallback() { // from class: com.myscript.nebo.purchase.RevenueCatPurchaseProvider$syncPurchases$2$1
                @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
                public void onError(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    CancellableContinuation<Result<Unit>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(this.toPurchaseException(error, "Initial sync purchases failed"))));
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                }

                @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
                public void onSuccess(CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    CancellableContinuation<Result<Unit>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(Unit.INSTANCE));
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(revenueCatPurchaseProvider$syncPurchases$12);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = revenueCatPurchaseProvider$syncPurchases$1.I$0;
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.purchase.IPurchaseProvider
    /* JADX INFO: renamed from: syncAttributesAndOfferingsIfNeeded-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo13348syncAttributesAndOfferingsIfNeededIoAF18A(Continuation<? super Result<Offerings>> continuation) {
        RevenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1 revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1;
        if (continuation instanceof RevenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1) {
            revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1 = (RevenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1) continuation;
            if ((revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1.label & Integer.MIN_VALUE) != 0) {
                revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1.label -= Integer.MIN_VALUE;
            } else {
                revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1 = new RevenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1(this, continuation);
            }
        }
        Object result = revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1.I$0 = 0;
            revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1.label = 1;
            RevenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1 revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$12 = revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$12), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            Purchases.INSTANCE.getSharedInstance().syncAttributesAndOfferingsIfNeeded(new SyncAttributesAndOfferingsCallback() { // from class: com.myscript.nebo.purchase.RevenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$2$1
                @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
                public void onError(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    CancellableContinuation<Result<Offerings>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(this.toPurchaseException(error, "failed attributes and offerings sync after configuration"))));
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                }

                @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
                public void onSuccess(Offerings offerings) {
                    Intrinsics.checkNotNullParameter(offerings, "offerings");
                    CancellableContinuation<Result<Offerings>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(offerings));
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$12);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = revenueCatPurchaseProvider$syncAttributesAndOfferingsIfNeeded$1.I$0;
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.purchase.IPurchaseProvider
    /* JADX INFO: renamed from: getCustomerInfoWith-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo13346getCustomerInfoWithIoAF18A(Continuation<? super Result<CustomerInfoResult>> continuation) {
        RevenueCatPurchaseProvider$getCustomerInfoWith$1 revenueCatPurchaseProvider$getCustomerInfoWith$1;
        if (continuation instanceof RevenueCatPurchaseProvider$getCustomerInfoWith$1) {
            revenueCatPurchaseProvider$getCustomerInfoWith$1 = (RevenueCatPurchaseProvider$getCustomerInfoWith$1) continuation;
            if ((revenueCatPurchaseProvider$getCustomerInfoWith$1.label & Integer.MIN_VALUE) != 0) {
                revenueCatPurchaseProvider$getCustomerInfoWith$1.label -= Integer.MIN_VALUE;
            } else {
                revenueCatPurchaseProvider$getCustomerInfoWith$1 = new RevenueCatPurchaseProvider$getCustomerInfoWith$1(this, continuation);
            }
        }
        Object result = revenueCatPurchaseProvider$getCustomerInfoWith$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = revenueCatPurchaseProvider$getCustomerInfoWith$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            revenueCatPurchaseProvider$getCustomerInfoWith$1.I$0 = 0;
            revenueCatPurchaseProvider$getCustomerInfoWith$1.label = 1;
            RevenueCatPurchaseProvider$getCustomerInfoWith$1 revenueCatPurchaseProvider$getCustomerInfoWith$12 = revenueCatPurchaseProvider$getCustomerInfoWith$1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(revenueCatPurchaseProvider$getCustomerInfoWith$12), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ListenerConversionsKt.getCustomerInfoWith(Purchases.INSTANCE.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.myscript.nebo.purchase.RevenueCatPurchaseProvider$getCustomerInfoWith$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    CancellableContinuation<Result<CustomerInfoResult>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(this.toPurchaseException(error, "Couldn't fetch customer info"))));
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                }
            }, new Function1<CustomerInfo, Unit>() { // from class: com.myscript.nebo.purchase.RevenueCatPurchaseProvider$getCustomerInfoWith$2$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                    invoke2(customerInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerInfo customerInfo) {
                    Date latestPurchaseDate;
                    Date originalPurchaseDate;
                    Date expirationDate;
                    Date unsubscribeDetectedAt;
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    EntitlementInfo entitlementInfo = customerInfo.getEntitlements().get("MyScript Notes – Full Access");
                    boolean isActive = entitlementInfo != null ? entitlementInfo.getIsActive() : false;
                    PeriodType periodType = entitlementInfo != null ? entitlementInfo.getPeriodType() : null;
                    boolean z = periodType == PeriodType.TRIAL;
                    Set<String> activeSubscriptions = customerInfo.getActiveSubscriptions();
                    Boolean boolValueOf = entitlementInfo != null ? Boolean.valueOf(entitlementInfo.getWillRenew()) : null;
                    Long lValueOf = (entitlementInfo == null || (unsubscribeDetectedAt = entitlementInfo.getUnsubscribeDetectedAt()) == null) ? null : Long.valueOf(unsubscribeDetectedAt.getTime());
                    Long lValueOf2 = (entitlementInfo == null || (expirationDate = entitlementInfo.getExpirationDate()) == null) ? null : Long.valueOf(expirationDate.getTime());
                    Long lValueOf3 = (entitlementInfo == null || (originalPurchaseDate = entitlementInfo.getOriginalPurchaseDate()) == null) ? null : Long.valueOf(originalPurchaseDate.getTime());
                    Long lValueOf4 = (entitlementInfo == null || (latestPurchaseDate = entitlementInfo.getLatestPurchaseDate()) == null) ? null : Long.valueOf(latestPurchaseDate.getTime());
                    String productIdentifier = entitlementInfo != null ? entitlementInfo.getProductIdentifier() : null;
                    String productPlanIdentifier = entitlementInfo != null ? entitlementInfo.getProductPlanIdentifier() : null;
                    Map<String, Date> allPurchaseDatesByProduct = customerInfo.getAllPurchaseDatesByProduct();
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, Date> entry : allPurchaseDatesByProduct.entrySet()) {
                        String key = entry.getKey();
                        Date value = entry.getValue();
                        Pair pairM1606to = value != null ? TuplesKt.m1606to(key, Long.valueOf(value.getTime())) : null;
                        if (pairM1606to != null) {
                            arrayList.add(pairM1606to);
                        }
                    }
                    CustomerInfoResult customerInfoResult = new CustomerInfoResult(isActive, z, periodType, activeSubscriptions, boolValueOf, lValueOf, lValueOf2, lValueOf3, lValueOf4, productIdentifier, productPlanIdentifier, MapsKt.toMap(arrayList));
                    CancellableContinuation<Result<CustomerInfoResult>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM14498boximpl = Result.m14498boximpl(Result.m14499constructorimpl(customerInfoResult));
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(resultM14498boximpl));
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(revenueCatPurchaseProvider$getCustomerInfoWith$12);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = revenueCatPurchaseProvider$getCustomerInfoWith$1.I$0;
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PurchaseException toPurchaseException(PurchasesError purchasesError, String str) {
        PurchaseErrorKind purchaseErrorKind;
        int i = WhenMappings.$EnumSwitchMapping$0[purchasesError.getCode().ordinal()];
        if (i == 1 || i == 2) {
            purchaseErrorKind = PurchaseErrorKind.BillingUnavailable;
        } else if (i == 3) {
            purchaseErrorKind = PurchaseErrorKind.Network;
        } else {
            purchaseErrorKind = PurchaseErrorKind.Other;
        }
        return new PurchaseException(purchaseErrorKind, str + ": " + purchasesError.getCode());
    }
}
