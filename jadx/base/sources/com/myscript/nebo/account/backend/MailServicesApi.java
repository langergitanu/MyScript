package com.myscript.nebo.account.backend;

import com.myscript.nebo.account.backend.entity.RevenueCatCustomerRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: compiled from: MailApi.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/MailServicesApi;", "", "linkToRevenueCat", "Lretrofit2/Response;", "", "request", "Lcom/myscript/nebo/account/backend/entity/RevenueCatCustomerRequest;", "(Lcom/myscript/nebo/account/backend/entity/RevenueCatCustomerRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "optInTrialStarted", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface MailServicesApi {
    @POST("/revenuecat")
    Object linkToRevenueCat(@Body RevenueCatCustomerRequest revenueCatCustomerRequest, Continuation<? super Response<Unit>> continuation);

    @POST("/app/onboarding/notes_trialstarted")
    Object optInTrialStarted(@Body RevenueCatCustomerRequest revenueCatCustomerRequest, Continuation<? super Response<Unit>> continuation);
}
