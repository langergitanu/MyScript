package com.android.billingclient.api;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: com.android.billingclient:billing-ktx@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t\u001a\u001a\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\r\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0013\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0013\u001a\u0012\u0010\u0016\u001a\u00020\u0001*\u00020\u0002H\u0087@¢\u0006\u0002\u0010\u0013\u001a\u0012\u0010\u0017\u001a\u00020\u0018*\u00020\u0002H\u0087@¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001d\u001a\u001a\u0010\u001e\u001a\u00020\u001f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!¨\u0006\""}, m1599d2 = {"acknowledgePurchase", "Lcom/android/billingclient/api/BillingResult;", "Lcom/android/billingclient/api/BillingClient;", "params", "Lcom/android/billingclient/api/AcknowledgePurchaseParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePurchase", "Lcom/android/billingclient/api/ConsumeResult;", "Lcom/android/billingclient/api/ConsumeParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/ConsumeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchasesAsync", "Lcom/android/billingclient/api/PurchasesResult;", "Lcom/android/billingclient/api/QueryPurchasesParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchasesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryProductDetails", "Lcom/android/billingclient/api/ProductDetailsResult;", "Lcom/android/billingclient/api/QueryProductDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryProductDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAlternativeBillingOnlyAvailable", "(Lcom/android/billingclient/api/BillingClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAlternativeBillingOnlyReportingDetails", "Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "isExternalOfferAvailable", "createExternalOfferReportingDetails", "Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "isBillingProgramAvailable", "Lcom/android/billingclient/api/IsBillingProgramAvailableResult;", "billingProgram", "", "(Lcom/android/billingclient/api/BillingClient;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBillingProgramReportingDetails", "Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsResult;", "Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, m1600k = 2, m1601mv = {2, 2, 0}, m1603xi = 48)
public final class BillingClientKotlinKt {
    public static final Object acknowledgePurchase(BillingClient billingClient, AcknowledgePurchaseParams acknowledgePurchaseParams, Continuation<? super BillingResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda5
            @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
            public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                BillingClientKotlinKt.acknowledgePurchase$lambda$0(completableDeferredCompletableDeferred$default, billingResult);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void acknowledgePurchase$lambda$0(CompletableDeferred completableDeferred, BillingResult billingResult) {
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(billingResult);
    }

    public static final Object consumePurchase(BillingClient billingClient, ConsumeParams consumeParams, Continuation<? super ConsumeResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.consumeAsync(consumeParams, new ConsumeResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda2
            @Override // com.android.billingclient.api.ConsumeResponseListener
            public final void onConsumeResponse(BillingResult billingResult, String str) {
                BillingClientKotlinKt.consumePurchase$lambda$1(completableDeferredCompletableDeferred$default, billingResult, str);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void consumePurchase$lambda$1(CompletableDeferred completableDeferred, BillingResult billingResult, String str) {
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new ConsumeResult(billingResult, str));
    }

    public static final Object createAlternativeBillingOnlyReportingDetails(BillingClient billingClient, Continuation<? super CreateAlternativeBillingOnlyReportingDetailsResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.createAlternativeBillingOnlyReportingDetailsAsync(new AlternativeBillingOnlyReportingDetailsListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda8
            @Override // com.android.billingclient.api.AlternativeBillingOnlyReportingDetailsListener
            public final void onAlternativeBillingOnlyTokenResponse(BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
                BillingClientKotlinKt.createAlternativeBillingOnlyReportingDetails$lambda$5(completableDeferredCompletableDeferred$default, billingResult, alternativeBillingOnlyReportingDetails);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void createAlternativeBillingOnlyReportingDetails$lambda$5(CompletableDeferred completableDeferred, BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new CreateAlternativeBillingOnlyReportingDetailsResult(billingResult, alternativeBillingOnlyReportingDetails));
    }

    public static final Object createBillingProgramReportingDetails(BillingClient billingClient, BillingProgramReportingDetailsParams billingProgramReportingDetailsParams, Continuation<? super CreateBillingProgramReportingDetailsResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.createBillingProgramReportingDetailsAsync(billingProgramReportingDetailsParams, new BillingProgramReportingDetailsListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda1
            @Override // com.android.billingclient.api.BillingProgramReportingDetailsListener
            public final void onCreateBillingProgramReportingDetailsResponse(BillingResult billingResult, BillingProgramReportingDetails billingProgramReportingDetails) {
                BillingClientKotlinKt.createBillingProgramReportingDetails$lambda$9(completableDeferredCompletableDeferred$default, billingResult, billingProgramReportingDetails);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void createBillingProgramReportingDetails$lambda$9(CompletableDeferred completableDeferred, BillingResult billingResult, BillingProgramReportingDetails billingProgramReportingDetails) {
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new CreateBillingProgramReportingDetailsResult(billingResult, billingProgramReportingDetails));
    }

    @Deprecated(message = "Use [BillingClient.createBillingProgramReportingDetails(BillingProgramReportingDetailsParams)] instead")
    public static final Object createExternalOfferReportingDetails(BillingClient billingClient, Continuation<? super CreateExternalOfferReportingDetailsResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.createExternalOfferReportingDetailsAsync(new ExternalOfferReportingDetailsListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda6
            @Override // com.android.billingclient.api.ExternalOfferReportingDetailsListener
            public final void onExternalOfferReportingDetailsResponse(BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
                BillingClientKotlinKt.createExternalOfferReportingDetails$lambda$7(completableDeferredCompletableDeferred$default, billingResult, externalOfferReportingDetails);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void createExternalOfferReportingDetails$lambda$7(CompletableDeferred completableDeferred, BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new CreateExternalOfferReportingDetailsResult(billingResult, externalOfferReportingDetails));
    }

    public static final Object isAlternativeBillingOnlyAvailable(BillingClient billingClient, Continuation<? super BillingResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.isAlternativeBillingOnlyAvailableAsync(new AlternativeBillingOnlyAvailabilityListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda7
            @Override // com.android.billingclient.api.AlternativeBillingOnlyAvailabilityListener
            public final void onAlternativeBillingOnlyAvailabilityResponse(BillingResult billingResult) {
                BillingClientKotlinKt.isAlternativeBillingOnlyAvailable$lambda$4(completableDeferredCompletableDeferred$default, billingResult);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void isAlternativeBillingOnlyAvailable$lambda$4(CompletableDeferred completableDeferred, BillingResult billingResult) {
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(billingResult);
    }

    public static final Object isBillingProgramAvailable(BillingClient billingClient, int i, Continuation<? super IsBillingProgramAvailableResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.isBillingProgramAvailableAsync(i, new BillingProgramAvailabilityListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.BillingProgramAvailabilityListener
            public final void onBillingProgramAvailabilityResponse(BillingResult billingResult, BillingProgramAvailabilityDetails billingProgramAvailabilityDetails) {
                BillingClientKotlinKt.isBillingProgramAvailable$lambda$8(completableDeferredCompletableDeferred$default, billingResult, billingProgramAvailabilityDetails);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void isBillingProgramAvailable$lambda$8(CompletableDeferred completableDeferred, BillingResult billingResult, BillingProgramAvailabilityDetails billingProgramAvailabilityDetails) {
        Intrinsics.checkNotNull(billingResult);
        Intrinsics.checkNotNull(billingProgramAvailabilityDetails);
        completableDeferred.complete(new IsBillingProgramAvailableResult(billingResult, billingProgramAvailabilityDetails));
    }

    @Deprecated(message = "Use [BillingClient.isBillingProgramAvailable(int)] instead")
    public static final Object isExternalOfferAvailable(BillingClient billingClient, Continuation<? super BillingResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.isExternalOfferAvailableAsync(new ExternalOfferAvailabilityListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda3
            @Override // com.android.billingclient.api.ExternalOfferAvailabilityListener
            public final void onExternalOfferAvailabilityResponse(BillingResult billingResult) {
                BillingClientKotlinKt.isExternalOfferAvailable$lambda$6(completableDeferredCompletableDeferred$default, billingResult);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void isExternalOfferAvailable$lambda$6(CompletableDeferred completableDeferred, BillingResult billingResult) {
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(billingResult);
    }

    public static final Object queryProductDetails(BillingClient billingClient, QueryProductDetailsParams queryProductDetailsParams, Continuation<? super ProductDetailsResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryProductDetailsAsync(queryProductDetailsParams, new ProductDetailsResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda4
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void onProductDetailsResponse(BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
                BillingClientKotlinKt.queryProductDetails$lambda$3(completableDeferredCompletableDeferred$default, billingResult, queryProductDetailsResult);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void queryProductDetails$lambda$3(CompletableDeferred completableDeferred, BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new ProductDetailsResult(billingResult, queryProductDetailsResult.getProductDetailsList()));
    }

    public static final Object queryPurchasesAsync(BillingClient billingClient, QueryPurchasesParams queryPurchasesParams, Continuation<? super PurchasesResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchasesAsync(queryPurchasesParams, new PurchasesResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda9
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.queryPurchasesAsync$lambda$2(completableDeferredCompletableDeferred$default, billingResult, list);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static final void queryPurchasesAsync$lambda$2(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNull(billingResult);
        Intrinsics.checkNotNull(list);
        completableDeferred.complete(new PurchasesResult(billingResult, list));
    }
}
