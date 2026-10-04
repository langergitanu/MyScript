package com.myscript.nebo.account.backend;

import com.myscript.nebo.account.backend.entity.InAppPurchasePayload;
import com.myscript.nebo.account.backend.entity.InAppPurchaseResponse;
import com.myscript.nebo.account.backend.entity.KeyValue;
import com.myscript.nebo.account.backend.entity.KeyValueParameters;
import com.myscript.nebo.account.backend.entity.NeboAccount;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* JADX INFO: compiled from: NeboBackendApi.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0004J6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0014\b\u0001\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\rH§@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/NeboBackendApi;", "", "getUser", "Lcom/myscript/nebo/account/backend/entity/NeboAccount;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPurchase", "Lcom/myscript/nebo/account/backend/entity/InAppPurchaseResponse;", "payload", "Lcom/myscript/nebo/account/backend/entity/InAppPurchasePayload;", "(Lcom/myscript/nebo/account/backend/entity/InAppPurchasePayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flagLegacyPurchase", "setValue", "Lretrofit2/Response;", "", "", "parameters", "Lcom/myscript/nebo/account/backend/entity/KeyValueParameters;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValue", "Lcom/myscript/nebo/account/backend/entity/KeyValue;", SubscriberAttributeKt.JSON_NAME_KEY, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface NeboBackendApi {
    @POST("api/v3.0/inapppurchase/google/legacy")
    Object flagLegacyPurchase(Continuation<? super InAppPurchaseResponse> continuation);

    @GET("api/v1.0/nebo/user")
    Object getUser(Continuation<? super NeboAccount> continuation);

    @GET("api/v3.0/nebo/kv/{key}")
    Object getValue(@Path(SubscriberAttributeKt.JSON_NAME_KEY) String str, Continuation<? super KeyValue> continuation);

    @POST("api/v3.0/inapppurchase/google/purchase")
    Object sendPurchase(@Body InAppPurchasePayload inAppPurchasePayload, Continuation<? super InAppPurchaseResponse> continuation);

    @POST("api/v3.0/nebo/kv/")
    Object setValue(@Body Map<String, KeyValueParameters> map, Continuation<? super Response<Map<String, String>>> continuation);
}
