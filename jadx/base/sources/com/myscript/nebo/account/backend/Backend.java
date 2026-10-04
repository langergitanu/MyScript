package com.myscript.nebo.account.backend;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.myscript.nebo.account.backend.entity.InAppPurchaseResponse;
import com.myscript.nebo.account.backend.entity.KeyValue;
import com.myscript.nebo.account.backend.entity.NeboAccount;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: NeboBackend.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001$J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006H¦@¢\u0006\u0002\u0010\u0004J:\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012H¦@¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H¦@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001e\u001a\u00020\u001fH¦@¢\u0006\u0002\u0010\u0004J\u001c\u0010 \u001a\u00020\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\"H¦@¢\u0006\u0002\u0010#¨\u0006%À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/Backend;", "", "getNeboAccount", "Lcom/myscript/nebo/account/backend/entity/NeboAccount;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPurchase", "Lcom/myscript/nebo/account/backend/entity/InAppPurchaseResponse;", "token", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "productId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flagLegacyPurchase", "setValue", "Lkotlin/Result;", SubscriberAttributeKt.JSON_NAME_KEY, "value", "writeOnce", "", "forceCacheFallback", "setValue-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValue", "Lcom/myscript/nebo/account/backend/entity/KeyValue;", "cachePolicy", "Lcom/myscript/nebo/account/backend/CachePolicy;", "getValue-0E7RQCE", "(Ljava/lang/String;Lcom/myscript/nebo/account/backend/CachePolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateAppUserId", "getAppUserId", "resetAppUserId", "", "resetCachedValues", UserMetadata.KEYDATA_FILENAME, "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Provider", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Backend {

    /* JADX INFO: compiled from: NeboBackend.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/Backend$Provider;", "", "provideBackend", "Lcom/myscript/nebo/account/backend/Backend;", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        Backend provideBackend();
    }

    Object flagLegacyPurchase(Continuation<? super InAppPurchaseResponse> continuation);

    Object getAppUserId(Continuation<? super String> continuation);

    Object getNeboAccount(Continuation<? super NeboAccount> continuation);

    Object getOrCreateAppUserId(Continuation<? super String> continuation);

    /* JADX INFO: renamed from: getValue-0E7RQCE, reason: not valid java name */
    Object mo12808getValue0E7RQCE(String str, CachePolicy cachePolicy, Continuation<? super Result<KeyValue>> continuation);

    Object resetAppUserId(Continuation<? super Unit> continuation);

    Object resetCachedValues(List<String> list, Continuation<? super Unit> continuation);

    Object sendPurchase(String str, String str2, String str3, Continuation<? super InAppPurchaseResponse> continuation);

    /* JADX INFO: renamed from: setValue-yxL6bBk, reason: not valid java name */
    Object mo12809setValueyxL6bBk(String str, String str2, boolean z, boolean z2, Continuation<? super Result<String>> continuation);

    /* JADX INFO: compiled from: NeboBackend.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX INFO: renamed from: setValue-yxL6bBk$default, reason: not valid java name */
    static /* synthetic */ Object m12807setValueyxL6bBk$default(Backend backend, String str, String str2, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setValue-yxL6bBk");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return backend.mo12809setValueyxL6bBk(str, str2, z, z2, continuation);
    }

    /* JADX INFO: renamed from: getValue-0E7RQCE$default, reason: not valid java name */
    static /* synthetic */ Object m12806getValue0E7RQCE$default(Backend backend, String str, CachePolicy cachePolicy, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getValue-0E7RQCE");
        }
        if ((i & 2) != 0) {
            cachePolicy = CachePolicy.FromCacheIfOffline;
        }
        return backend.mo12808getValue0E7RQCE(str, cachePolicy, continuation);
    }
}
