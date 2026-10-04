package com.revenuecat.purchases;

import android.content.Context;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.common.CancellableContinuationExtensionsKt;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0002\u0010\b\u001a2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a8\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00060\u0012*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0017\u001a\u00020\u0018*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001b\u001a \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001b\u001a\u0012\u0010\u001d\u001a\u00020\u001e*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010 \u001a\u00020\r*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015¨\u0006!"}, m1599d2 = {"awaitCanMakePayments", "", "Lcom/revenuecat/purchases/Purchases$Companion;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "features", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "(Lcom/revenuecat/purchases/Purchases$Companion;Landroid/content/Context;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProducts", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/revenuecat/purchases/Purchases;", "productIds", "", "type", "Lcom/revenuecat/purchases/ProductType;", "(Lcom/revenuecat/purchases/Purchases;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProductsResult", "Lkotlin/Result;", "awaitOfferings", "Lcom/revenuecat/purchases/Offerings;", "(Lcom/revenuecat/purchases/Purchases;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOfferingsResult", "awaitPurchase", "Lcom/revenuecat/purchases/PurchaseResult;", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/PurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPurchaseResult", "awaitRestore", "Lcom/revenuecat/purchases/CustomerInfo;", "awaitRestoreResult", "awaitStorefrontCountryCode", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CoroutinesExtensionsCommonKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1 */
    /* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", m1609f = "CoroutinesExtensionsCommon.kt", m1610i = {0, 0, 0}, m1611l = {289}, m1612m = "awaitGetProductsResult", m1613n = {"$this$awaitGetProductsResult", "productIds", "type"}, m1615s = {"L$0", "L$1", "L$2"})
    static final class C69701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C69701(Continuation<? super C69701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitGetProductsResult = CoroutinesExtensionsCommonKt.awaitGetProductsResult(null, null, null, this);
            return objAwaitGetProductsResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitGetProductsResult : Result.m14498boximpl(objAwaitGetProductsResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1 */
    /* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", m1609f = "CoroutinesExtensionsCommon.kt", m1610i = {0}, m1611l = {289}, m1612m = "awaitOfferingsResult", m1613n = {"$this$awaitOfferingsResult"}, m1615s = {"L$0"})
    static final class C69711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C69711(Continuation<? super C69711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitOfferingsResult = CoroutinesExtensionsCommonKt.awaitOfferingsResult(null, this);
            return objAwaitOfferingsResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitOfferingsResult : Result.m14498boximpl(objAwaitOfferingsResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1 */
    /* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", m1609f = "CoroutinesExtensionsCommon.kt", m1610i = {0, 0}, m1611l = {289}, m1612m = "awaitPurchaseResult", m1613n = {"$this$awaitPurchaseResult", "purchaseParams"}, m1615s = {"L$0", "L$1"})
    static final class C69721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C69721(Continuation<? super C69721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws PurchasesException {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitPurchaseResult = CoroutinesExtensionsCommonKt.awaitPurchaseResult(null, null, this);
            return objAwaitPurchaseResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPurchaseResult : Result.m14498boximpl(objAwaitPurchaseResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1 */
    /* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", m1609f = "CoroutinesExtensionsCommon.kt", m1610i = {0}, m1611l = {289}, m1612m = "awaitRestoreResult", m1613n = {"$this$awaitRestoreResult"}, m1615s = {"L$0"})
    static final class C69731 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C69731(Continuation<? super C69731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitRestoreResult = CoroutinesExtensionsCommonKt.awaitRestoreResult(null, this);
            return objAwaitRestoreResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitRestoreResult : Result.m14498boximpl(objAwaitRestoreResult);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitOfferingsResult(Purchases purchases, Continuation continuation) {
        C69711 c69711;
        if (continuation instanceof C69711) {
            c69711 = (C69711) continuation;
            if ((c69711.label & Integer.MIN_VALUE) != 0) {
                c69711.label -= Integer.MIN_VALUE;
            } else {
                c69711 = new C69711(continuation);
            }
        }
        Object result = c69711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c69711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            c69711.L$0 = purchases;
            c69711.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c69711), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ListenerConversionsCommonKt.getOfferingsWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$1
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
                    CancellableContinuation<Result<Offerings>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    CancellableContinuationExtensionsKt.safeResume(cancellableContinuation, Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(new PurchasesException(it)))));
                }
            }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$2
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
                    CancellableContinuation<Result<Offerings>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    CancellableContinuationExtensionsKt.safeResume(cancellableContinuation, Result.m14498boximpl(Result.m14499constructorimpl(it)));
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c69711);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitPurchaseResult(Purchases purchases, PurchaseParams purchaseParams, Continuation continuation) throws PurchasesException {
        C69721 c69721;
        if (continuation instanceof C69721) {
            c69721 = (C69721) continuation;
            if ((c69721.label & Integer.MIN_VALUE) != 0) {
                c69721.label -= Integer.MIN_VALUE;
            } else {
                c69721 = new C69721(continuation);
            }
        }
        Object result = c69721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c69721.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            c69721.L$0 = purchases;
            c69721.L$1 = purchaseParams;
            c69721.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c69721), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            purchases.purchase(purchaseParams, ListenerConversionsCommonKt.purchaseCompletedCallback(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                    invoke2(storeTransaction, customerInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    CancellableContinuation<Result<PurchaseResult>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    CancellableContinuationExtensionsKt.safeResume(cancellableContinuation, Result.m14498boximpl(Result.m14499constructorimpl(new PurchaseResult(storeTransaction, customerInfo))));
                }
            }, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                    invoke(purchasesError, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PurchasesError purchasesError, boolean z) {
                    Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                    CancellableContinuation<Result<PurchaseResult>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    CancellableContinuationExtensionsKt.safeResume(cancellableContinuation, Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(new PurchasesTransactionException(purchasesError, z)))));
                }
            }));
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c69721);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    public static /* synthetic */ Object awaitGetProducts$default(Purchases purchases, List list, ProductType productType, Continuation continuation, int i, Object obj) throws PurchasesTransactionException {
        if ((i & 2) != 0) {
            productType = null;
        }
        return awaitGetProducts(purchases, list, productType, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitGetProductsResult(Purchases purchases, List list, ProductType productType, Continuation continuation) {
        C69701 c69701;
        if (continuation instanceof C69701) {
            c69701 = (C69701) continuation;
            if ((c69701.label & Integer.MIN_VALUE) != 0) {
                c69701.label -= Integer.MIN_VALUE;
            } else {
                c69701 = new C69701(continuation);
            }
        }
        Object result = c69701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c69701.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            c69701.L$0 = purchases;
            c69701.L$1 = list;
            c69701.L$2 = productType;
            c69701.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c69701), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ListenerConversionsCommonKt.getProductsWith(purchases, list, productType, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$1
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
                    CancellableContinuation<Result<? extends List<? extends StoreProduct>>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    CancellableContinuationExtensionsKt.safeResume(cancellableContinuation, Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(new PurchasesException(it)))));
                }
            }, new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$2
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
                public final void invoke2(List<? extends StoreProduct> storeProducts) {
                    Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                    CancellableContinuation<Result<? extends List<? extends StoreProduct>>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    CancellableContinuationExtensionsKt.safeResume(cancellableContinuation, Result.m14498boximpl(Result.m14499constructorimpl(storeProducts)));
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c69701);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    public static /* synthetic */ Object awaitGetProductsResult$default(Purchases purchases, List list, ProductType productType, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            productType = null;
        }
        return awaitGetProductsResult(purchases, list, productType, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitRestoreResult(Purchases purchases, Continuation continuation) {
        C69731 c69731;
        if (continuation instanceof C69731) {
            c69731 = (C69731) continuation;
            if ((c69731.label & Integer.MIN_VALUE) != 0) {
                c69731.label -= Integer.MIN_VALUE;
            } else {
                c69731 = new C69731(continuation);
            }
        }
        Object result = c69731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c69731.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            c69731.L$0 = purchases;
            c69731.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c69731), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ListenerConversionsCommonKt.restorePurchasesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$1
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
                    CancellableContinuation<Result<CustomerInfo>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    CancellableContinuationExtensionsKt.safeResume(cancellableContinuation, Result.m14498boximpl(Result.m14499constructorimpl(ResultKt.createFailure(new PurchasesException(it)))));
                }
            }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$2
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
                public final void invoke2(CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    CancellableContinuation<Result<CustomerInfo>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    CancellableContinuationExtensionsKt.safeResume(cancellableContinuation, Result.m14498boximpl(Result.m14499constructorimpl(customerInfo)));
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c69731);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }

    public static /* synthetic */ Object awaitCanMakePayments$default(Purchases.Companion companion, Context context, List list, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return awaitCanMakePayments(companion, context, list, continuation);
    }

    public static final /* synthetic */ Object awaitOfferings(Purchases purchases, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsCommonKt.getOfferingsWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferings$2$1
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
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferings$2$2
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

    public static final /* synthetic */ Object awaitPurchase(Purchases purchases, PurchaseParams purchaseParams, Continuation continuation) throws PurchasesException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        purchases.purchase(purchaseParams, ListenerConversionsCommonKt.purchaseCompletedCallback(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchase$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                invoke2(storeTransaction, customerInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, new PurchaseResult(storeTransaction, customerInfo));
            }
        }, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchase$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                invoke(purchasesError, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError purchasesError, boolean z) {
                Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl2, new PurchasesTransactionException(purchasesError, z));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final /* synthetic */ Object awaitGetProducts(Purchases purchases, List list, ProductType productType, Continuation continuation) throws PurchasesTransactionException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsCommonKt.getProductsWith(purchases, list, productType, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProducts$2$1
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
        }, new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProducts$2$2
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
            public final void invoke2(List<? extends StoreProduct> it) {
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

    public static final /* synthetic */ Object awaitRestore(Purchases purchases, Continuation continuation) throws PurchasesTransactionException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsCommonKt.restorePurchasesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestore$2$1
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
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestore$2$2
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

    public static final Object awaitStorefrontCountryCode(Purchases purchases, Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ListenerConversionsCommonKt.getStorefrontCountryCodeWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitStorefrontCountryCode$2$1
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
        }, new Function1<String, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitStorefrontCountryCode$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
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

    public static final /* synthetic */ Object awaitCanMakePayments(Purchases.Companion companion, Context context, List list, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        companion.canMakePayments(context, list, new Callback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitCanMakePayments$2$1
            @Override // com.revenuecat.purchases.interfaces.Callback
            public final void onReceived(Boolean bool) {
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl2, bool);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
