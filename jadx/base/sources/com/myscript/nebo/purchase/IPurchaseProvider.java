package com.myscript.nebo.purchase;

import com.revenuecat.purchases.Offerings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IPurchaseProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH&J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0010H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH¦@¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bH¦@¢\u0006\u0004\b\u0016\u0010\u0013J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bH¦@¢\u0006\u0004\b\u0019\u0010\u0013¨\u0006\u001aÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/purchase/IPurchaseProvider;", "", "enableDebugMode", "", "isConfigured", "", "configure", "appUserId", "", "apiKey", "login", "Lkotlin/Result;", "login-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAttributes", "attributes", "", "syncPurchases", "syncPurchases-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncAttributesAndOfferingsIfNeeded", "Lcom/revenuecat/purchases/Offerings;", "syncAttributesAndOfferingsIfNeeded-IoAF18A", "getCustomerInfoWith", "Lcom/myscript/nebo/purchase/CustomerInfoResult;", "getCustomerInfoWith-IoAF18A", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IPurchaseProvider {
    void configure(String appUserId, String apiKey);

    void enableDebugMode();

    /* JADX INFO: renamed from: getCustomerInfoWith-IoAF18A, reason: not valid java name */
    Object mo13346getCustomerInfoWithIoAF18A(Continuation<? super Result<CustomerInfoResult>> continuation);

    boolean isConfigured();

    /* JADX INFO: renamed from: login-gIAlu-s, reason: not valid java name */
    Object mo13347logingIAlus(String str, Continuation<? super Result<Unit>> continuation);

    void setAttributes(Map<String, String> attributes);

    /* JADX INFO: renamed from: syncAttributesAndOfferingsIfNeeded-IoAF18A, reason: not valid java name */
    Object mo13348syncAttributesAndOfferingsIfNeededIoAF18A(Continuation<? super Result<Offerings>> continuation);

    /* JADX INFO: renamed from: syncPurchases-IoAF18A, reason: not valid java name */
    Object mo13349syncPurchasesIoAF18A(Continuation<? super Result<Unit>> continuation);
}
